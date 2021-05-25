DROP TABLE IF EXISTS rest_men_itms;

CREATE TABLE rest_men_itms (
    rest_id VARCHAR(36) NOT NULL,
    rest_men_itm_id VARCHAR(36) NOT NULL DEFAULT (uuid()),
    men_nm VARCHAR(128) NOT NULL,
    img_id VARCHAR(36),
    create_ts       datetime DEFAULT NOW(),
    mod_ts          datetime DEFAULT NOW(),
    CONSTRAINT pk__rest_men_itms PRIMARY KEY(rest_men_itm_id),
    CONSTRAINT fk__rest_men_itms__rest_id__rest__rest_id FOREIGN KEY(rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk__rest_men_itms__img_id__img__img_id FOREIGN KEY(rest_id) REFERENCES img(img_id) ON UPDATE CASCADE ON DELETE RESTRICT
);