DELIMITER $$

DROP TRIGGER IF EXISTS bi_rest_men_itms$$
CREATE TRIGGER bi_rest_men_itms
    BEFORE INSERT
    ON rest_men_itms FOR EACH ROW
BEGIN
    SET new.creat_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rest_men_itms$$
CREATE TRIGGER bu_rest_men_itms
    BEFORE UPDATE
    ON rest_men_itms FOR EACH ROW
BEGIN
    DECLARE diff_st JSON DEFAULT JSON_OBJECT();
    SET new.mod_ts = current_time;

    IF old.men_nm <> new.men_nm THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'men_nm', old.men_nm, new.men_nm);
    END IF;

    IF old.img_id <> new.img_id THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'img_id', old.img_id, new.img_id);
    END IF;

    INSERT INTO logs(system_id, acct_id, rest_id, tbl_nm, log_msg)
         VALUES (current_user, new.mod_by_acct_id, new.rest_id, 'rest_men_itms', diff_st);
END$$

DELIMITER ;