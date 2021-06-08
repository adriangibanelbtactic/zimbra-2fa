CREATE DATABASE IF NOT EXISTS 2fa;
CREATE USER IF NOT EXISTS '2fa_integration'@'localhost' IDENTIFIED BY 'CHANGETHIS';
SET PASSWORD FOR '2fa_integration'@'localhost' = PASSWORD('CHANGETHIS');
CREATE TABLE IF NOT EXISTS 2fa.clients (
	id 			MEDIUMINT 	NOT NULL AUTO_INCREMENT,
	email 		CHAR(100) 	UNIQUE NOT NULL,
	secret_key 	CHAR(100) 	NOT NULL,
	validated 	BOOLEAN 	NOT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS 2fa.single_app_password (
	id 			MEDIUMINT 	NOT NULL AUTO_INCREMENT,
	email 		CHAR(100) 	NOT NULL,
	hash	 	CHAR(100),
	PRIMARY KEY (id)
);
GRANT SELECT, INSERT, DELETE ON 2fa.single_app_password TO '2fa_integration'@'localhost' WITH GRANT OPTION;
GRANT SELECT, INSERT, UPDATE ON 2fa.clients TO '2fa_integration'@'localhost' WITH GRANT OPTION;