DROP TABLE IF EXISTS rest_bus_cntcts;

CREATE TABLE rest_bus_cntcts (
    rest_id             VARCHAR(36) NOT NULL,
    rest_bus_cntct_id   VARCHAR(36) NOT NULL DEFAULT (uuid()),
    creat_by_acct_id    VARCHAR(36),
    mod_by_acct_id      VARCHAR(36),
    first_name          VARCHAR(50) NOT NULL,
    last_name           VARCHAR(50) NOT NULL,
    title               VARCHAR(64),
    phone               VARCHAR(14),
    email               VARCHAR(256),
    creat_ts            DATETIME DEFAULT NOW(),
    mod_ts              DATETIME DEFAULT NOW(),
    CONSTRAINT pk__rest_bus_cntcts PRIMARY KEY(rest_bus_cntct_id),
    CONSTRAINT fk__rest_bus_cntcts__rest_id__rest__rest_id FOREIGN KEY(rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk__rest_bus_cntcts__creat_by_acct_id__acct__id FOREIGN KEY(creat_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk__rest_bus_cntcts__mod_by_acct_id__acct__id FOREIGN KEY(mod_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL
);
