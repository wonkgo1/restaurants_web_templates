DROP TABLE IF EXISTS rests;

CREATE TABLE rests (
    rest_id         VARCHAR(36) NOT NULL DEFAULT (uuid()),
    rest_nm         VARCHAR(128) NOT NULL,
    parnt_rest_id   VARCHAR(256),
    url             VARCHAR(2083),
    create_ts       datetime DEFAULT NOW(),
    mod_ts          datetime DEFAULT NOW(),
    CONSTRAINT pk__rest PRIMARY KEY(rest_id),
    CONSTRAINT fk__rest__parnt_rest_id__rest__rest_id FOREIGN KEY(parnt_rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE 
);