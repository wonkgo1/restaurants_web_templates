DROP TABLE IF EXISTS logs;

CREATE TABLE logs (
    log_id VARCHAR(36) NOT NULL DEFAULT (uuid()),
    system_id VARCHAR(32),
    rest_id VARCHAR(36),
    tbl_nm VARCHAR(64),
    log_msg TEXT,
    create_ts       datetime DEFAULT NOW(),
    mod_ts          datetime DEFAULT NOW(),
    CONSTRAINT pk__logs PRIMARY KEY(log_id),
    CONSTRAINT fk__logs__rest_id__rest__rest_id FOREIGN KEY(rest_id) REFERENCES rests(rest_id) ON UPDATE CASCADE ON DELETE CASCADE 
);