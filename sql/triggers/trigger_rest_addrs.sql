DELIMITER $$

DROP TRIGGER IF EXISTS bi_rest_addrs$$
CREATE TRIGGER bi_rest_addrs
    BEFORE INSERT
    ON rest_addrs FOR EACH ROW
BEGIN
    SET new.create_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rest_addrs$$
CREATE TRIGGER bu_rest_addrs
    BEFORE UPDATE
    ON rest_addrs FOR EACH ROW
BEGIN
    SET new.mod_ts = current_time;
END$$

DELIMITER ;