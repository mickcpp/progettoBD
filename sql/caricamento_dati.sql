-- Popolare la tabella 'circuito'
INSERT INTO circuito (Nome, Paese, Lunghezza, `Numero curve`)
VALUES
    ('Monza', 'Italia', 5793, 11),
    ('Silverstone', 'Regno Unito', 5891, 18),
    ('Monte Carlo', 'Monaco', 3340, 19);

-- Popolare la tabella 'scuderia'
INSERT INTO scuderia (Nome, Sede)
VALUES
    ('Ferrari', 'Maranello'),
    ('Mercedes', 'Brackley'),
    ('Red Bull Racing', 'Milton Keynes');

-- Popolare la tabella 'vettura'
INSERT INTO vettura (`Numero da gara`, Scuderia, Modello, `Numero di piloti`, `Numero di punti`)
VALUES
    (1, 'Ferrari', 'SF21', 0, 0),
    (2, 'Mercedes', 'W12', 0, 0),
    (3, 'Red Bull Racing', 'RB16B', 0, 0);


-- Popolare la tabella 'pilota'
INSERT INTO pilota (Vettura, Nome, Cognome, `Data nascita`, Nazionalità, `Data prima licenza`, `Numero licenze`)
VALUES
    (1, 'Charles', 'Leclerc', '1997-10-16', 'Monegasco', '2014-01-01', NULL),
    (2, 'Lewis', 'Hamilton', '1985-01-07', 'Britannico', NULL, 3),
    (3, 'Max', 'Verstappen', '1997-09-30', 'Olandese', '2015-01-01', NULL);


-- Popolare la tabella 'gentleman driver'
INSERT INTO `gentleman driver` (Vettura, Scuderia, Nome, Cognome, `Data nascita`, Nazionalità, `Data prima licenza`, Quota)
VALUES
    (1, 'Ferrari', 'John', 'Doe', '1980-05-20', 'Statunitense', '2005-01-01', 50000),
    (2, 'Mercedes', 'Jane', 'Smith', '1975-11-12', 'Canadese', '2008-01-01', 75000),
    (3, 'Red Bull Racing', 'Mario', 'Rossi', '1988-03-25', 'Italiano', '2010-01-01', 60000);

-- Popolare la tabella 'costruttore'
INSERT INTO costruttore (Nome, `Ragione sociale`, Sede, `Numero componenti`)
VALUES
    ('Ferrari', 'Ferrari S.p.A.', 'Maranello', 0),
    ('Mercedes', 'Mercedes-Benz', 'Stoccarda', 0),
    ('Red Bull Racing', 'Red Bull Technology', 'Milton Keynes', 0);

-- Popolare la tabella 'telaio'
INSERT INTO telaio (Vettura, Costruttore, Costo, `Data installazione`, Composizione, Peso)
VALUES
    (1, 'Ferrari', 50000.00, '2023-01-15', 'Carbonio', 700),
    (2, 'Mercedes', 55000.00, '2023-02-01', 'Alluminio', 720),
    (3, 'Red Bull Racing', 48000.00, '2023-01-20', 'Titanio', 710);

-- Popolare la tabella 'motore'
INSERT INTO motore (Vettura, Costruttore, Costo, `Data installazione`, Cilindrata, `Numero cilindri`, Tipo)
VALUES
    (1, 'Ferrari', 80000.00, '2023-01-15', 1600, 6, 'turbo'),
    (2, 'Mercedes', 85000.00, '2023-02-01', 1600, 8, 'turbo'),
    (3, 'Red Bull Racing', 75000.00, '2023-01-20', 1600, 6, 'aspirato');

-- Popolare la tabella 'cambio'
INSERT INTO cambio (Vettura, Costruttore, Costo, `Data installazione`, `Numero marce`)
VALUES
    (1, 'Ferrari', 30000.00, '2023-01-15', 8),
    (2, 'Mercedes', 32000.00, '2023-02-01', 7),
    (3, 'Red Bull Racing', 28000.00, '2023-01-20', 8);

-- Popolare la tabella 'gara'
INSERT INTO gara (Circuito, Nome, Data, Durata, Tipo)
VALUES
    ('Monza', 'Gran Premio d\'Italia', '2023-05-01', '14:00:00', 'asciutta'),
    ('Silverstone', 'British Grand Prix', '2023-06-15', '13:30:00', 'bagnata'),
    ('Monte Carlo', 'Monaco Grand Prix', '2023-07-01', '15:00:00', 'asciutta');

-- Popolare la tabella 'iscrizione'
INSERT INTO iscrizione (Gara, Vettura, Punti, `Motivo ritiro`)
VALUES
    (1, 1, 0, NULL),
    (2, 2, 0, NULL),
    (3, 3, 0, NULL);

