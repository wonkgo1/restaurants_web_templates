DROP TABLE IF EXISTS rests;

CREATE TABLE rests
  (
     rest_id          VARCHAR(36) NOT NULL DEFAULT (Uuid()),
     creat_by_acct_id VARCHAR(36),
     mod_by_acct_id   VARCHAR(36),
     rest_nm          VARCHAR(128) NOT NULL,
     parnt_rest_id    VARCHAR(256),
     url              VARCHAR(2083),
     creat_ts         DATETIME DEFAULT Now(),
     mod_ts           DATETIME DEFAULT Now(),
     CONSTRAINT pk__rest PRIMARY KEY(rest_id)
  );

DROP TABLE IF EXISTS rest_addrs;

CREATE TABLE rest_addrs
  (
     rest_id          VARCHAR(36) NOT NULL,
     rest_addr_id     VARCHAR(36) NOT NULL DEFAULT (Uuid()),
     creat_by_acct_id VARCHAR(36),
     mod_by_acct_id   VARCHAR(36),
     strt_addr1       VARCHAR(128) NOT NULL,
     strt_addr2       VARCHAR(128),
     city             VARCHAR(128),
     state            VARCHAR(128),
     country          VARCHAR(128),
     creat_ts         DATETIME DEFAULT Now(),
     mod_ts           DATETIME DEFAULT Now(),
     CONSTRAINT pk__rest_addrs PRIMARY KEY(rest_addr_id)
  );

DROP TABLE IF EXISTS rest_bus_cntcts;

CREATE TABLE rest_bus_cntcts
  (
     rest_id           VARCHAR(36) NOT NULL,
     rest_bus_cntct_id VARCHAR(36) NOT NULL DEFAULT (Uuid()),
     creat_by_acct_id  VARCHAR(36),
     mod_by_acct_id    VARCHAR(36),
     first_name        VARCHAR(50) NOT NULL,
     last_name         VARCHAR(50) NOT NULL,
     title             VARCHAR(64),
     phone             VARCHAR(14),
     email             VARCHAR(256),
     creat_ts          DATETIME DEFAULT Now(),
     mod_ts            DATETIME DEFAULT Now(),
     CONSTRAINT pk__rest_bus_cntcts PRIMARY KEY(rest_bus_cntct_id)
  );

DROP TABLE IF EXISTS rest_men_itms;

CREATE TABLE rest_men_itms
  (
     rest_id          VARCHAR(36) NOT NULL,
     rest_men_itm_id  VARCHAR(36) NOT NULL DEFAULT (Uuid()),
     creat_by_acct_id VARCHAR(36),
     mod_by_acct_id   VARCHAR(36),
     men_nm           VARCHAR(128) NOT NULL,
     img_id           VARCHAR(36),
     creat_ts         DATETIME DEFAULT Now(),
     mod_ts           DATETIME DEFAULT Now(),
     CONSTRAINT pk__rest_men_itms PRIMARY KEY(rest_men_itm_id)
  );

DROP TABLE IF EXISTS img;

CREATE TABLE img
  (
     img_id           VARCHAR(36) NOT NULL DEFAULT (Uuid()),
     creat_by_acct_id VARCHAR(36),
     mod_by_acct_id   VARCHAR(36),
     url              VARCHAR(2083) NOT NULL,
     creat_ts         DATETIME DEFAULT Now(),
     mod_ts           DATETIME DEFAULT Now(),
     CONSTRAINT pk__img PRIMARY KEY(img_id)
  );

DROP TABLE IF EXISTS acct;

CREATE TABLE acct
  (
     acct_id          VARCHAR(36) NOT NULL DEFAULT (Uuid()),
     creat_by_acct_id VARCHAR(36),
     mod_by_acct_id   VARCHAR(36),
     rest_id          VARCHAR(36),
     creat_ts         DATETIME DEFAULT Now(),
     mod_ts           DATETIME DEFAULT Now(),
     CONSTRAINT pk__acct PRIMARY KEY(acct_id)
  );

INSERT INTO rests
            (rest_id,
             creat_by_acct_id,
             mod_by_acct_id,
             rest_nm,
             parnt_rest_id,
             url)
VALUES      ('da215b52-be98-11eb-ba46-0242ac110002',
             NULL,
             NULL,
             'parent restaurant',
             NULL,
             'http://localhost:8080/parent_restaurant');

INSERT INTO rests
            (rest_id,
             creat_by_acct_id,
             mod_by_acct_id,
             rest_nm,
             parnt_rest_id,
             url)
VALUES      ('da8eb719-be98-11eb-ba46-0242ac110002',
             NULL,
             NULL,
             'child restaurant',
             'da215b52-be98-11eb-ba46-0242ac110002',
             'http://localhost:8080/child_restaurant'); 