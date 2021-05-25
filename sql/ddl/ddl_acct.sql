DROP TABLE IF EXISTS acct;

CREATE TABLE acct (
    acct_id             VARCHAR(36) NOT NULL DEFAULT (uuid()),
    creat_ts            DATETIME DEFAULT NOW(),
    mod_ts              DATETIME DEFAULT NOW(),
    CONSTRAINT pk__acct PRIMARY KEY(acct_id)
);