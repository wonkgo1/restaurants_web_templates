DELIMITER $$

DROP TRIGGER IF EXISTS bi_img$$
CREATE TRIGGER bi_img
    BEFORE INSERT
    ON img FOR EACH ROW
BEGIN
    SET new.create_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_img$$
CREATE TRIGGER bu_img
    BEFORE UPDATE
    ON img FOR EACH ROW
BEGIN
    SET new.mod_ts = current_time;
END$$

DELIMITER ;