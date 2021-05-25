DELIMITER $$

DROP TRIGGER IF EXISTS bi_rest_addrs$$
CREATE TRIGGER bi_rest_addrs
    BEFORE INSERT
    ON rest_addrs FOR EACH ROW
BEGIN
    SET new.creat_ts = current_time;
    SET new.mod_ts = current_time;
END$$

DROP TRIGGER IF EXISTS bu_rest_addrs$$
CREATE TRIGGER bu_rest_addrs
    BEFORE UPDATE
    ON rest_addrs FOR EACH ROW
BEGIN
    DECLARE diff_st JSON DEFAULT JSON_OBJECT();
    SET new.mod_ts = current_time;

    IF old.strt_addr1 <> new.strt_addr1 THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'strt_addr1', old.strt_addr1, new.strt_addr1);
    END IF;

    IF old.strt_addr2 <> new.strt_addr2 THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'strt_addr2', old.strt_addr2, new.strt_addr2);
    END IF;

    IF old.city <> new.city THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'city', old.city, new.city);
    END IF;

    IF old.state <> new.state THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'state', old.state, new.state);
    END IF;

    IF old.country <> new.country THEN
        SET diff_st = append_difference_to_json_text(diff_st, 'country', old.country, new.country);
    END IF;

    INSERT INTO logs(system_id, acct_id, rest_id, tbl_nm, log_msg)
         VALUES (current_user, new.mod_by_acct_id, new.rest_id, 'rest_addrs', diff_st);
END$$

DELIMITER ;