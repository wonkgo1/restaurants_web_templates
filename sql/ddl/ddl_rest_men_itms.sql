DROP TABLE IF EXISTS rest_men_itms;

CREATE TABLE rest_men_itms (
    rest_id             VARCHAR(36) NOT NULL,
    rest_men_itm_id     VARCHAR(36) NOT NULL DEFAULT (uuid()),
    creat_by_acct_id    VARCHAR(36),
    mod_by_acct_id      VARCHAR(36),
    men_nm              VARCHAR(128) NOT NULL,
    img_id              VARCHAR(36),
    creat_ts            DATETIME DEFAULT NOW(),
    mod_ts              DATETIME DEFAULT NOW(),
    CONSTRAINT pk__rest_men_itms PRIMARY KEY(rest_men_itm_id),
    CONSTRAINT fk__rest_men_itms__rest_id__rest__rest_id FOREIGN KEY(rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk__rest_men_itms__img_id__img__img_id FOREIGN KEY(rest_id) REFERENCES img(img_id) ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk__rest_men_itms__creat_by_acct_id__acct__id FOREIGN KEY(creat_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL,
    CONSTRAINT fk__rest_men_itms__mod_by_acct_id__acct__id FOREIGN KEY(mod_by_acct_id) REFERENCES acct(acct_id) ON UPDATE CASCADE ON DELETE SET NULL
);