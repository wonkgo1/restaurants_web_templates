DELIMITER $$

DROP TRIGGER IF EXISTS bi_rest_bus_cntcts$$
CREATE TRIGGER bi_rest_bus_cntcts
    BEFORE INSERT
    ON rest_bus_cntcts FOR EACH ROW
BEGIN
    SET new.create_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rest_bus_cntcts$$
CREATE TRIGGER bu_rest_bus_cntcts
    BEFORE UPDATE
    ON rest_bus_cntcts FOR EACH ROW
BEGIN
    SET new.mod_ts = current_time;
END$$

DELIMITER ;