DROP TABLE IF EXISTS img;

CREATE TABLE img (
    img_id VARCHAR(36) NOT NULL DEFAULT (uuid()),
    url VARCHAR(2083) NOT NULL,
    create_ts       datetime DEFAULT NOW(),
    mod_ts          datetime DEFAULT NOW(),
    CONSTRAINT pk__img PRIMARY KEY(img_id)
);