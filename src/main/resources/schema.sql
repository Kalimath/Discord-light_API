CREATE TABLE GEBRUIKER
(
    USERNAME varchar(300) not null ,
    VOORNAAM varchar(300) not null ,
    ACHTERNAAM varchar(300) not null
);

CREATE TABLE KANAAL
(
    ID integer auto_increment,
    NAME varchar(300) not null,
    TOPIC varchar(300) not null,
);

CREATE TABLE BERICHT
(
    ID integer auto_increment,
    USERNAME varchar(300) not null ,
    VOORNAAM varchar(300) not null ,
    ACHTERNAAM varchar(300) not null
);