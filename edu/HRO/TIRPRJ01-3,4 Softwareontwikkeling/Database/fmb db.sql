CREATE SCHEMA fmb;
USE fmb;

CREATE TABLE Klant
(
	Id INT PRIMARY KEY,	-- klant nr
	Naam VARCHAR(25)
);

CREATE TABLE Rekening
(
	Id INT PRIMARY KEY, -- rekeningnummer
	Klantid INT, -- fk -> Klant.Id
	Klantnaam VARCHAR(25), -- fk -> Klant.Naam
	PinpasId INT, -- fk -> Pinpas.Id
	Saldo INT, -- huidige saldo
	
	FOREIGN KEY (Klantid) REFERENCES Klant(Id)
);

CREATE TABLE Pinpas
(
	Id INT PRIMARY KEY, -- Pasnummer
	Klantid INT, -- fk -> Klant.Id
	Klantnaam VARCHAR(25), -- fk -> Klant.Naam
	Rekeningid INT, -- fk -> Rekening.Id
	Pincode INT, -- 4 cijferig
	Pogingen INT, -- aantal foutieve pogingen
	Verloopdatum DATETIME, -- YYYY-MM-DD HH:MM:SS
	
	track1 VARCHAR(30),
	track2 VARCHAR(25),
	
	FOREIGN KEY (Klantid) REFERENCES Klant(Id),
	FOREIGN KEY (Rekeningid) REFERENCES Rekening(Id)
);

/*
CREATE TABLE Transactie
(
	Id INT PRIMARY KEY,
);
*/
