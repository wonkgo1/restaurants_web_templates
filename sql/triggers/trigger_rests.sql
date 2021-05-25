DELIMITER $$

DROP TRIGGER IF EXISTS bi_rests$$
CREATE TRIGGER bi_rests
    BEFORE INSERT
    ON rests FOR EACH ROW
BEGIN
    SET new.creat_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rests$$
CREATE TRIGGER bu_rests
    BEFORE UPDATE
    ON rests FOR EACH ROW
BEGIN
    DECLARE diff_st JSON DEFAULT JSON_OBJECT();
    SET new.mod_ts = current_time;

    IF old.rest_nm <> new.rest_nm THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'rest_nm', old.rest_nm, new.rest_nm);
    END IF;

    IF old.url <> new.url THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'url', old.url, new.url);
    END IF;

    INSERT INTO logs(system_id, acct_id, rest_id, tbl_nm, log_msg)
         VALUES (current_user, new.mod_by_acct_id, new.rest_id, 'rest_men_itms', diff_st);
END$$

DELIMITER ;