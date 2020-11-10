CREATE SCHEMA DISCORD_LIGHT;

CREATE TABLE DISCORD_LIGHT.GEBRUIKER
(
    GEBRUIKER_ID bigint serial primary key,
    USERNAME varchar(300) not null,
    VOORNAAM varchar(300) not null ,
    ACHTERNAAM varchar(300) not null
);


CREATE TABLE DISCORD_LIGHT.KANAAL
(
    KANAAL_ID bigint serial primary key,
    NAME varchar(300) not null,
    TOPIC varchar(300) not null
);



CREATE TABLE DISCORD_LIGHT.BERICHT
(
    BERICHT_ID bigint serial primary key,
    AFZENDER_ID bigint not null ,
    BERICHT varchar(2000) not null ,
    VERZENDDATUM DATETIME AUTO_INCREMENT
);

CREATE TABLE DISCORD_LIGHT.GEBRUIKER_KANAAL
(
    GEBRUIKER_ID bigint,
    KANAAL_ID bigint
);