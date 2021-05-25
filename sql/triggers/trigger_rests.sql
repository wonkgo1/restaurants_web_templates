DELIMITER $$

DROP TRIGGER IF EXISTS bi_rests$$
CREATE TRIGGER bi_rests
    BEFORE INSERT
    ON rests FOR EACH ROW
BEGIN
    SET new.create_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rests$$
CREATE TRIGGER bu_rests
    BEFORE UPDATE
    ON rests FOR EACH ROW
BEGIN
    SET new.mod_ts = current_time;
END$$

DELIMITER ;