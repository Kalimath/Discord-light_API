CREATE SCHEMA DISCORD_LIGHT;

CREATE TABLE DISCORD_LIGHT.GEBRUIKER
(
    USERNAME varchar(300) not null primary key,
    VOORNAAM varchar(300) not null ,
    ACHTERNAAM varchar(300) not null
);


CREATE TABLE DISCORD_LIGHT.KANAAL
(
    ID bigint serial primary key,
    NAME varchar(300) not null,
    TOPIC varchar(300) not null
);



CREATE TABLE DISCORD_LIGHT.BERICHT
(
    ID bigint serial primary key,
    USERNAME varchar(300) not null ,
    VOORNAAM varchar(300) not null ,
    ACHTERNAAM varchar(300) not null
);