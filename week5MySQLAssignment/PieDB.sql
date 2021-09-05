CREATE DATABASE IF NOT EXISTS pies;

use pies;

DROP TABLE IF EXISTS pies;

CREATE TABLE pies (
	id int(10) NOT NULL auto_increment,
	pie_type varchar(50) NOT NULL,
	PRIMARY KEY(id)
); 
