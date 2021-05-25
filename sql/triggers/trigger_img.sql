DELIMITER $$

DROP TRIGGER IF EXISTS bi_img$$
CREATE TRIGGER bi_img
    BEFORE INSERT
    ON img FOR EACH ROW
BEGIN
    SET new.creat_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_img$$
CREATE TRIGGER bu_img
    BEFORE UPDATE
    ON img FOR EACH ROW
BEGIN
    DECLARE diff_st JSON DEFAULT JSON_OBJECT();
    SET new.mod_ts = current_time;

    IF old.url <> new.url THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'url', old.url, new.url);
    END IF;

    INSERT INTO logs(system_id, acct_id, tbl_nm, log_msg)
         VALUES (current_user, new.mod_by_acct_id, 'img', diff_st);
END$$

DELIMITER ;