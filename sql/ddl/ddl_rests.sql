DROP TABLE IF EXISTS rests;

CREATE TABLE rests (
    rest_id             VARCHAR(36) NOT NULL DEFAULT (uuid()),
    creat_by_acct_id    VARCHAR(36),
    mod_by_acct_id      VARCHAR(36),
    rest_nm             VARCHAR(128) NOT NULL,
    parnt_rest_id       VARCHAR(256),
    url                 VARCHAR(2083),
    creat_ts            DATETIME DEFAULT NOW(),
    mod_ts              DATETIME DEFAULT NOW(),
    CONSTRAINT pk__rest PRIMARY KEY(rest_id),
    CONSTRAINT fk__rest__parnt_rest_id__rest__rest_id FOREIGN KEY(parnt_rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk__rest__creat_by_acct_id__acct__id FOREIGN KEY(creat_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk__rest__mod_by_acct_id__acct__id FOREIGN KEY(mod_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL
);