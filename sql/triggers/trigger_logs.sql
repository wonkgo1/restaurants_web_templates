DELIMITER $$

DROP TRIGGER IF EXISTS bi_logs$$
CREATE TRIGGER bi_logs
    BEFORE INSERT
    ON logs FOR EACH ROW
BEGIN
    SET new.system_id = current_user;
    SET new.creat_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_logs$$
CREATE TRIGGER bu_logs
    BEFORE UPDATE
    ON logs FOR EACH ROW
BEGIN
    SET new.system_id = current_user;
    SET new.mod_ts = current_time;
END$$

DELIMITER ;