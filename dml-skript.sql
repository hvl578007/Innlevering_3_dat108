CREATE SCHEMA dat108_oblig3

SET search_path = dat108_oblig3

DROP TABLE IF EXISTS deltakar

CREATE TABLE deltakar(

    fornamn VARCHAR(20),
    etternamn VARCHAR(20),
    mobilnummer VARCHAR(8),
    passordhash INTEGER,
    passordsalt INTEGER,
    kjoenn VARCHAR,
    PRIMARY KEY (mobilnummer)

);