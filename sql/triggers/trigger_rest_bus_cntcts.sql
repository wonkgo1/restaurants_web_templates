DELIMITER $$

DROP TRIGGER IF EXISTS bi_rest_bus_cntcts$$
CREATE TRIGGER bi_rest_bus_cntcts
    BEFORE INSERT
    ON rest_bus_cntcts FOR EACH ROW
BEGIN
    SET new.creat_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rest_bus_cntcts$$
CREATE TRIGGER bu_rest_bus_cntcts
    BEFORE UPDATE
    ON rest_bus_cntcts FOR EACH ROW
BEGIN
    DECLARE diff_st JSON DEFAULT JSON_OBJECT();
    SET new.mod_ts = current_time;

    IF old.first_name <> new.first_name THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'first_name', old.first_name, new.first_name);
    END IF;

    IF old.last_name <> new.last_name THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'last_name', old.last_name, new.last_name);
    END IF;

    IF old.title <> new.title THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'title', old.title, new.title);
    END IF;

    IF old.phone <> new.phone THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'phone', old.phone, new.phone);
    END IF;

    IF old.email <> new.email THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'email', old.email, new.email);
    END IF;

    INSERT INTO logs(system_id, acct_id, rest_id, tbl_nm, tbl_pk_id, log_msg)
         VALUES (current_user, new.mod_by_acct_id, new.rest_id, 'rest_bus_cntcts', new.rest_bus_cntct_id, diff_st);
END$$

DELIMITER ;