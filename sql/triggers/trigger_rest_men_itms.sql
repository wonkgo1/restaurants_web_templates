DELIMITER $$

DROP TRIGGER IF EXISTS bi_rest_men_itms$$
CREATE TRIGGER bi_rest_men_itms
    BEFORE INSERT
    ON rest_men_itms FOR EACH ROW
BEGIN
    SET new.create_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rest_men_itms$$
CREATE TRIGGER bu_rest_men_itms
    BEFORE UPDATE
    ON rest_men_itms FOR EACH ROW
BEGIN
    SET new.mod_ts = current_time;
END$$

DELIMITER ;