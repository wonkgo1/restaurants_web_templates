DELIMITER $$

DROP PROCEDURE IF EXISTS append_difference_to_json$$
CREATE PROCEDURE append_difference_to_json(INOUT diff_st JSON, 
                                           IN col VARCHAR(4096), 
                                           IN col_bu TEXT, 
                                           IN col_au TEXT)
BEGIN
    DECLARE new_json JSON DEFAULT JSON_OBJECT(col, JSON_OBJECT('old_value', col_bu, 'new_value', col_au));
    SET diff_st = JSON_MERGE_PATCH(diff_st, new_json);
END$$

DELIMITER ;