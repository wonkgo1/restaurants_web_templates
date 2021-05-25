DROP TABLE IF EXISTS img;

CREATE TABLE img (
    img_id              VARCHAR(36) NOT NULL DEFAULT (uuid()),
    creat_by_acct_id    VARCHAR(36),
    mod_by_acct_id      VARCHAR(36),
    url                 VARCHAR(2083) NOT NULL,
    creat_ts            DATETIME DEFAULT NOW(),
    mod_ts              DATETIME DEFAULT NOW(),
    CONSTRAINT pk__img PRIMARY KEY(img_id),
    CONSTRAINT fk__img__creat_by_acct_id__acct__id FOREIGN KEY(creat_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk__img__mod_by_acct_id__acct__id FOREIGN KEY(mod_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL
);