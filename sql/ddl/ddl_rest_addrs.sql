DROP TABLE IF EXISTS rest_addrs;

CREATE TABLE rest_addrs (
    rest_id             VARCHAR(36) NOT NULL,
    rest_addr_id        VARCHAR(36) NOT NULL DEFAULT (uuid()),
    creat_by_acct_id    VARCHAR(36),
    mod_by_acct_id      VARCHAR(36),
    strt_addr1          VARCHAR(128) NOT NULL,
    strt_addr2          VARCHAR(128),
    city                VARCHAR(128),
    state               VARCHAR(128),
    country             VARCHAR(128),
    creat_ts            DATETIME DEFAULT NOW(),
    mod_ts              DATETIME DEFAULT NOW(),
    CONSTRAINT pk__rest_addrs PRIMARY KEY(rest_addr_id),
    CONSTRAINT fk__rest_addrs__rest_id__rest__rest_id FOREIGN KEY(rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk__rest_addrs__creat_by_acct_id__acct__id FOREIGN KEY(creat_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk__rest_addrs__mod_by_acct_id__acct__id FOREIGN KEY(mod_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL
);