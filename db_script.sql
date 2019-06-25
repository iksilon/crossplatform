CREATE SCHEMA `db_crossplatform`;

USE db_crossplatform;

CREATE TABLE `User` (
 idUser INT AUTO_INCREMENT,
 username VARCHAR(255) NOT NULL,
 PRIMARY KEY (idUser)
);

INSERT INTO User (username) VALUES('Mario');

CREATE TABLE `Platform` (
idPlatform INT AUTO_INCREMENT,
platformName VARCHAR(255) NOT NULL,
PRIMARY KEY (idPlatform)
);

INSERT INTO Platform (platformName) 
	VALUES('Steam'), 
			('GOG'), 
			('Humble Bundle');
            
CREATE TABLE `Game` (
idGame INT AUTO_INCREMENT,
gameName VARCHAR(255) NOT NULL,
idUser INT ,
idPlatform INT,
PRIMARY KEY (idGame),
CONSTRAINT FK_idUserGame FOREIGN KEY (idUser) REFERENCES User(idUser),
CONSTRAINT FK_idPlatformGame FOREIGN KEY (idPlatform) REFERENCES Platform(idPlatform)
);

INSERT INTO Game (gameName, idUser, idPlatform)
	VALUES('Planet Coaster', 1, 1),
			('The Witcher 3', 1, 2),
            ('Thimbleweed Park', 1, 2)