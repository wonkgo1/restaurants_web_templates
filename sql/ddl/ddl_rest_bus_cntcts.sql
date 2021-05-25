DROP TABLE IF EXISTS rest_bus_cntcts;

CREATE TABLE rest_bus_cntcts (
    rest_id VARCHAR(36) NOT NULL,
    rest_bus_cntct_id VARCHAR(36) NOT NULL DEFAULT (uuid()),
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(64),
    phone VARCHAR(14),
    email VARCHAR(256),
    create_ts       datetime DEFAULT NOW(),
    mod_ts          datetime DEFAULT NOW(),
    CONSTRAINT pk__rest_bus_cntcts PRIMARY KEY(rest_bus_cntct_id),
    CONSTRAINT fk__rest_bus_cntcts__rest_id__rest__rest_id FOREIGN KEY(rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE 
);
