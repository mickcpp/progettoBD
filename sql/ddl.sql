CREATE SCHEMA campionato;
USE campionato;

CREATE TABLE `circuito` (
    `Nome` VARCHAR(20) PRIMARY KEY,
    `Paese` VARCHAR(20) NOT NULL,
    `Lunghezza` INT UNSIGNED NOT NULL,
    `Numero curve` INT UNSIGNED NOT NULL
);

CREATE TABLE `gara` (
    `ID` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Circuito` VARCHAR(20) NOT NULL,
    `Nome` VARCHAR(20) NOT NULL,
    `Data` DATE NOT NULL,
    `Durata` TIME NOT NULL,
    `Tipo` VARCHAR(20) NOT NULL,
    CHECK (Tipo IN ('asciutta' , 'bagnata')),
    FOREIGN KEY (Circuito)
        REFERENCES circuito (Nome)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE `scuderia` (
    `Nome` VARCHAR(20) PRIMARY KEY,
    `Sede` VARCHAR(20) NOT NULL
);

CREATE TABLE `vettura` (
    `Numero da gara` INT UNSIGNED PRIMARY KEY,
    `Scuderia` VARCHAR(20) NOT NULL,
    `Modello` VARCHAR(20) NOT NULL,
    `Numero di piloti` INT UNSIGNED DEFAULT 0 NOT NULL,
    `Numero di punti` INT UNSIGNED DEFAULT 0 NOT NULL,
    FOREIGN KEY (Scuderia)
        REFERENCES scuderia (Nome)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE `pilota` (
    `ID` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Vettura` INT UNSIGNED NOT NULL,
    `Nome` VARCHAR(20) NOT NULL,
    `Cognome` VARCHAR(20) NOT NULL,
    `Data nascita` DATE NOT NULL,
    `Nazionalità` VARCHAR(20) NOT NULL,
    `Data prima licenza` DATE,
    `Numero licenze` INT UNSIGNED,
    CHECK ((`Data prima licenza` IS NOT NULL
        AND `Numero licenze` IS NULL)
        OR (`Data prima licenza` IS NULL
        AND `Numero licenze` IS NOT NULL)),
    FOREIGN KEY (Vettura)
        REFERENCES vettura (`Numero da gara`)
        ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE `gentleman driver` (
    `ID` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Vettura` INT UNSIGNED NOT NULL,
    `Scuderia` VARCHAR(20) NOT NULL,
    `Nome` VARCHAR(20) NOT NULL,
    `Cognome` VARCHAR(20) NOT NULL,
    `Data nascita` DATE NOT NULL,
    `Nazionalità` VARCHAR(20) NOT NULL,
    `Data prima licenza` DATE NOT NULL,
    `Quota` INT UNSIGNED NOT NULL,
    FOREIGN KEY (Vettura)
        REFERENCES vettura (`Numero da gara`)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY (Scuderia)
        REFERENCES scuderia (Nome)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `costruttore` (
	`Nome` VARCHAR(20) PRIMARY KEY,
    `Ragione sociale` VARCHAR(20) NOT NULL,
    `Sede` VARCHAR(20) NOT NULL,
    `Numero componenti` INT UNSIGNED DEFAULT 0 NOT NULL
);

CREATE TABLE `telaio` (
    `Codice` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Vettura` INT UNSIGNED NOT NULL,
    `Costruttore` VARCHAR(20) NOT NULL,
    `Costo` DECIMAL(8 , 2 ) NOT NULL,
    `Data installazione` DATE NOT NULL,
    `Composizione` VARCHAR(20) NOT NULL,
    `Peso` DECIMAL(6 , 3 ) NOT NULL,
    FOREIGN KEY (Vettura)
        REFERENCES vettura (`Numero da gara`)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (Costruttore)
        REFERENCES costruttore (`Nome`)
        ON UPDATE CASCADE ON DELETE CASCADE,
	UNIQUE(Vettura)
);

CREATE TABLE `motore` (
    `Codice` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Vettura` INT UNSIGNED NOT NULL,
    `Costruttore` VARCHAR(20) NOT NULL,
    `Costo` DECIMAL(8 , 2 ) NOT NULL,
    `Data installazione` DATE NOT NULL,
    `Cilindrata` INT UNSIGNED NOT NULL,
    `Numero cilindri` INT UNSIGNED NOT NULL,
    `Tipo` VARCHAR(20) NOT NULL,
    CHECK (Tipo IN ('turbo' , 'aspirato')),
    FOREIGN KEY (Vettura)
        REFERENCES vettura (`Numero da gara`)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (Costruttore)
        REFERENCES costruttore (`Nome`)
        ON UPDATE CASCADE ON DELETE CASCADE,
	UNIQUE(Vettura)
);

CREATE TABLE `cambio` (
    `Codice` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Vettura` INT UNSIGNED NOT NULL,
    `Costruttore` VARCHAR(20) NOT NULL,
    `Costo` DECIMAL(8 , 2 ) NOT NULL,
    `Data installazione` DATE NOT NULL,
    `Numero marce` INT UNSIGNED NOT NULL,
    CHECK (`Numero marce` BETWEEN 7 AND 8),
    FOREIGN KEY (Vettura)
        REFERENCES vettura (`Numero da gara`)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (Costruttore)
        REFERENCES costruttore (`Nome`)
        ON UPDATE CASCADE ON DELETE CASCADE,
	UNIQUE(Vettura)
);

CREATE TABLE `iscrizione` (
    `Gara` INT UNSIGNED NOT NULL,
    `Vettura` INT UNSIGNED NOT NULL,
    `Punti` INT DEFAULT 0 NOT NULL,
    `Piazzamento` INT UNSIGNED DEFAULT NULL,
    `Motivo ritiro` VARCHAR(20),
    CHECK (`Motivo ritiro` IN ('incidente' , 'squalifica', 'guasto meccanico')),
    FOREIGN KEY (Gara)
        REFERENCES gara (ID)
        ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (Vettura)
        REFERENCES vettura (`Numero da gara`)
        ON UPDATE CASCADE ON DELETE CASCADE,
	UNIQUE(Gara, Piazzamento),
    UNIQUE(Gara, Vettura)
);

DELIMITER //
CREATE TRIGGER before_insert_GentlemanDriver
BEFORE INSERT ON `gentleman driver`
FOR EACH ROW
BEGIN
    DECLARE scuderia_vettura INT;

    -- Ottieni l'ID della vettura associata alla scuderia finanziata dal GentlemanDriver
    SELECT vettura.`Numero da gara` INTO scuderia_vettura
    FROM vettura
    JOIN scuderia ON vettura.Scuderia = scuderia.Nome
    WHERE scuderia.Nome = NEW.Scuderia
	LIMIT 1;
    -- Verifica se l'ID della vettura coincide
    IF NEW.Vettura != scuderia_vettura THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'La vettura scelta dal GentlemanDriver non appartiene alla scuderia finanziata';
    END IF;
END;
//
DELIMITER ;

-- Creazione del trigger per l'aggiornamento del numero di piloti (inserimento pilota)
DELIMITER //
CREATE TRIGGER aggiorna_numero_piloti_insert1
AFTER INSERT ON pilota
FOR EACH ROW
BEGIN
    UPDATE vettura
    SET `Numero di piloti` = `Numero di piloti`+ 1
    WHERE `Numero da gara` = NEW.Vettura;
END;
//
DELIMITER ;

-- Creazione del trigger per l'aggiornamento del numero di piloti (inserimento gentleman driver)
DELIMITER //
CREATE TRIGGER aggiorna_numero_piloti_insert2
AFTER INSERT ON `gentleman driver`
FOR EACH ROW
BEGIN
    UPDATE vettura
    SET `Numero di piloti` = `Numero di piloti`+ 1
    WHERE `Numero da gara` = NEW.Vettura;
END;
//
DELIMITER ;

-- Creazione del trigger per l'INSERT nella tabella 'telaio'
DELIMITER //
CREATE TRIGGER aggiorna_numero_componenti_telaio_insert
AFTER INSERT ON telaio
FOR EACH ROW
BEGIN
    UPDATE costruttore
    SET `Numero componenti` = `Numero componenti` + 1
    WHERE Nome = NEW.Costruttore;
END;
//
DELIMITER ;

-- Creazione del trigger per il DELETE nella tabella 'telaio'
DELIMITER //
CREATE TRIGGER aggiorna_numero_componenti_telaio_delete
AFTER DELETE ON telaio
FOR EACH ROW
BEGIN
    UPDATE costruttore
    SET `Numero componenti` = `Numero componenti` - 1
    WHERE Nome = OLD.Costruttore;
END;
//
DELIMITER ;

-- Creazione del trigger per l'INSERT nella tabella 'motore'
DELIMITER //
CREATE TRIGGER aggiorna_numero_componenti_motore_insert
AFTER INSERT ON motore
FOR EACH ROW
BEGIN
    UPDATE costruttore
    SET `Numero componenti` = `Numero componenti` + 1
    WHERE Nome = NEW.Costruttore;
END;
//
DELIMITER ;

-- Creazione del trigger per il DELETE nella tabella 'motore'
DELIMITER //
CREATE TRIGGER aggiorna_numero_componenti_motore_delete
AFTER DELETE ON motore
FOR EACH ROW
BEGIN
    UPDATE costruttore
    SET `Numero componenti` = `Numero componenti` - 1
    WHERE Nome = OLD.Costruttore;
END;
//
DELIMITER ;

-- Creazione del trigger per l'INSERT nella tabella 'cambio'
DELIMITER //
CREATE TRIGGER aggiorna_numero_componenti_cambio_insert
AFTER INSERT ON cambio
FOR EACH ROW
BEGIN
    UPDATE costruttore
    SET `Numero componenti` = `Numero componenti` + 1
    WHERE Nome = NEW.Costruttore;
END;
//
DELIMITER ;

-- Creazione del trigger per il DELETE nella tabella 'cambio'
DELIMITER //
CREATE TRIGGER aggiorna_numero_componenti_cambio_delete
AFTER DELETE ON cambio
FOR EACH ROW
BEGIN
    UPDATE costruttore
    SET `Numero componenti` = `Numero componenti` - 1
    WHERE Nome = OLD.Costruttore;
END;
//
DELIMITER ;

-- Creazione del trigger per l'aggiornamento dei punti di una vettura
DELIMITER //
CREATE TRIGGER aggiorna_punti_vettura_dopo_modifica
AFTER UPDATE ON iscrizione
FOR EACH ROW
BEGIN
    UPDATE vettura
    SET `Numero di punti` = 
        (`Numero di punti` + (NEW.Punti - OLD.Punti))
    WHERE `Numero da gara` = NEW.Vettura;
END;
//
DELIMITER ;

-- Creazione del trigger per il calcolo dei punti dopo l'update del piazzamento
DELIMITER //
CREATE TRIGGER calcola_punti_prima_inserimento
BEFORE UPDATE ON iscrizione
FOR EACH ROW
BEGIN
    DECLARE calcolo_punti INT;
    
    -- Calcola i punti in base al piazzamento
    SET calcolo_punti = CASE
        WHEN NEW.Piazzamento BETWEEN 1 AND 15 THEN 15 - NEW.Piazzamento + 1
        ELSE 0
    END;
    
    -- Aggiorna il campo Punti prima dell'inserimento
    SET NEW.Punti = calcolo_punti;
END;
//
DELIMITER ;
