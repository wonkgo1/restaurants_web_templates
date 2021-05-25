DELIMITER $$

DROP FUNCTION IF EXISTS append_difference_to_json_int$$
CREATE FUNCTION append_difference_to_json_int(diff_st JSON, 
                                          col VARCHAR(4096), 
                                          col_bu INT, 
                                          col_au INT)
    RETURNS JSON DETERMINISTIC
BEGIN
    DECLARE new_json JSON DEFAULT JSON_OBJECT(col, JSON_OBJECT('old_value', col_bu, 'new_value', col_au));
    SET diff_st = JSON_MERGE_PATCH(diff_st, new_json);
    RETURN diff_st;
END$$

DELIMITER ;