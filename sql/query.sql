use campionato;

-- Registrazione di una scuderia
INSERT INTO scuderia (Nome, Sede) VALUES ('Fiat', 'Torino');

-- Inserimento dei dati di un'autovettura, compresi i componenti di cui è composta
-- Inserimento vettura
INSERT INTO vettura (`Numero da gara`, Scuderia, Modello) VALUES ('4', 'Ferrari', 'monoposto');
-- Inserimento componenti
INSERT INTO cambio (Vettura, Costruttore, Costo, `Data installazione`, `Numero marce`)
VALUES ('2', 'Ferrari', '8000', '2023-04-06', '8');
INSERT INTO motore (Vettura, Costruttore, Costo, `Data installazione`, `Cilindrata`, `Numero cilindri`, `Tipo`)
VALUES ('4', 'Mercedes', '27000', '2023-04-07', '2000', '8', 'aspirato');
INSERT INTO telaio (Vettura, Costruttore, Costo, `Data installazione`, `Composizione`, `Peso`)
VALUES ('1', 'Mercedes', '15000', '2023-04-11', 'Carbonio', '650');

-- Aggiunta di un nuovo pilota ad una vettura
INSERT INTO pilota (Vettura, Nome, Cognome, `Data nascita`, `Nazionalità`, `Data prima licenza`, `Numero licenze`)
VALUES ('3', 'Sebastian', 'Vettel', '1989-03-17', 'Spagna', NULL, '8');

-- Registrazione di un finanziamento per una scuderia
INSERT INTO `gentleman driver` (Vettura, Scuderia, Nome, Cognome, `Data nascita`, `Nazionalità`, `Data prima licenza`, Quota)
VALUES ('15', 'Fiat', 'Anna', 'Rossi', '1994-10-03', 'Italia', '2010-04-05', 6000);

-- Iscrizione di una vettura ad una gara
INSERT INTO iscrizione (Gara, Vettura)
VALUES ('1', '4');

-- Registrazione del risultato conseguito da ciascuna vettura iscritta ad una gara
UPDATE iscrizione
SET Piazzamento = '3', `Motivo ritiro` = NULL
WHERE Gara = 2 AND Vettura = 3;

-- Verifica della possibilità di montare un componente su una vettura
SELECT
    COUNT(cambio.`Codice`) AS 'Numero di Cambi',
    COUNT(motore.`Codice`) AS 'Numero di Motori',
    COUNT(telaio.`Codice`) AS 'Numero di Telai'
FROM
    vettura
LEFT JOIN cambio ON vettura.`Numero da gara` = cambio.Vettura
LEFT JOIN motore ON vettura.`Numero da gara` = motore.Vettura
LEFT JOIN telaio ON vettura.`Numero da gara` = telaio.Vettura
WHERE
    vettura.`Numero da gara` = '1';

-- Per ciascuna scuderia, stampare la somma totale dei finanziamenti ricevuti
SELECT scuderia.Nome AS Scuderia, COALESCE(SUM(`gentleman driver`.quota), 0) AS `Quota totale`
FROM scuderia
LEFT JOIN
`gentleman driver`
ON scuderia.Nome = `gentleman driver`.Scuderia
GROUP BY Scuderia.Nome
ORDER BY `Quota totale` DESC;

-- Stampa annuale delle scuderie che hanno partecipato al campionato, compreso il numero di finanziamenti
SELECT scuderia.Nome AS Scuderia, Scuderia.Sede AS Sede, COUNT(`gentleman driver`.quota) AS `Numero Finanziamenti`
FROM scuderia
LEFT JOIN
`gentleman driver`
ON Scuderia.Nome = `gentleman driver`.Scuderia
GROUP BY Scuderia.Nome;

-- Visualizzare i piloti che hanno vinto nel circuito di casa
SELECT pilota.ID AS ID_Pilota, pilota.Vettura, pilota.Nome, pilota.Cognome, pilota.Nazionalità, Gara.Nome AS Gara
FROM pilota JOIN vettura
ON pilota.Vettura = vettura.`Numero da gara`
JOIN iscrizione
ON vettura.`Numero da gara` = iscrizione.Vettura
JOIN gara 
ON iscrizione.Gara = gara.ID
JOIN circuito
ON gara.Circuito = circuito.Nome
WHERE pilota.nazionalità = circuito.Paese AND iscrizione.Piazzamento = '1'

UNION

SELECT `gentleman driver`.ID, `gentleman driver`.Vettura, `gentleman driver`.Nome, `gentleman driver`.Cognome, `gentleman driver`.Nazionalità, Gara.Nome
FROM `gentleman driver` JOIN vettura
ON `gentleman driver`.Vettura = vettura.`Numero da gara`
JOIN iscrizione
ON vettura.`Numero da gara` = iscrizione.Vettura
JOIN gara 
ON iscrizione.Gara = gara.ID
JOIN circuito
ON gara.Circuito = circuito.Nome
WHERE `gentleman driver`.nazionalità = circuito.Paese AND iscrizione.Piazzamento = '1';

-- Per ciascuna scuderia, visualizzare la percentuale di gentleman driver di cui si compone l'equipaggio
SELECT scuderia.Nome AS Scuderia, COUNT(`gentleman driver`.ID) / SUM(DISTINCT vettura.`Numero di piloti`) * 100 AS percentualeGD
FROM scuderia JOIN vettura
ON scuderia.Nome = vettura.Scuderia
JOIN `gentleman driver`
ON `gentleman driver`.Vettura = vettura.`Numero da gara`
GROUP BY scuderia.Nome;

-- Stampa mensile dei costruttori compreso il numero di componenti che hanno fornito
SELECT costruttore.Nome AS Costruttore, costruttore.`Ragione sociale`, costruttore.`Numero componenti` AS `Componenti forniti`
FROM costruttore;

-- Stampa della classifica finale dei punti conseguiti da tutte le vetture
SELECT ROW_NUMBER() OVER (ORDER BY vettura.`Numero di punti` DESC) AS Posizione,
vettura.`Numero da gara` AS Vettura, vettura.`Numero di punti` AS Punti
FROM vettura
ORDER BY Posizione;

-- Stampa delle classifiche finali di punti per tipo di motore
SELECT
	ROW_NUMBER() OVER (PARTITION BY `Tipo motore` ORDER BY Punti DESC) AS Posizione,
    `Tipo motore`,
    Vettura,
    Punti
FROM
    (
        SELECT
            motore.`Tipo` AS `Tipo motore`,
            vettura.`Numero da gara` AS Vettura,
            vettura.`Numero di punti` AS Punti
        FROM
            vettura
        JOIN
            motore ON vettura.`Numero da gara` = motore.`Vettura`
    ) AS ClassificaMotore
ORDER BY
	`Tipo motore`,
    Posizione;
    
-- Stampa una classifica sulla base del rapporto punti/minuti di gara di ciascuna scuderia
SELECT
ROW_NUMBER() OVER (ORDER BY `Rapporto punti/minuti` DESC) AS Posizione,
Classifica.Scuderia,
`Rapporto punti/minuti`
FROM (
	SELECT
	vettura.Scuderia, SUM(DISTINCT vettura.`Numero di punti`) / SUM(TIME_TO_SEC(gara.Durata) / 60) AS `Rapporto punti/minuti`
	FROM vettura
	JOIN iscrizione
	ON iscrizione.Vettura = vettura.`Numero da gara`
	JOIN gara 
	ON iscrizione.Gara = gara.ID
	GROUP BY vettura.Scuderia
    ) AS Classifica
ORDER BY `Rapporto punti/minuti` DESC;


-- QUERY AGGIUNTIVE

-- Stampa delle vetture
SELECT * FROM vettura;

-- Stampa delle gare
SELECT * FROM gara;

-- Stampa delle iscrizioni delle vetture e le rispettive scuderie
SELECT Gara, Vettura, scuderia.Nome AS Scuderia, Punti, Piazzamento 
FROM iscrizione, scuderia, vettura
WHERE iscrizione.Vettura = vettura.`Numero da gara` AND vettura.Scuderia = scuderia.Nome
ORDER BY Gara;

-- Stampa classifica di una gara
SELECT 
ROW_NUMBER() OVER (ORDER BY iscrizione.Punti DESC) AS `Posizione`,
iscrizione.Vettura,
iscrizione.Punti
FROM iscrizione
WHERE iscrizione.Gara = '1'
ORDER BY `Posizione`;

-- Stampa dei costruttori
SELECT * FROM costruttore;

-- Stampa dei piloti
SELECT * FROM pilota;

-- Stampa dei gentleman driver
SELECT * FROM `gentleman driver`;

-- Elimina un componente di una vettura
DELETE FROM cambio WHERE cambio.Vettura = '12';
DELETE FROM motore WHERE cambio.Vettura = '12';
DELETE FROM telaio WHERE cambio.Vettura = '12';




