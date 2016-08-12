# Create an index if not exists in MySQL DB
delimiter $$

DROP PROCEDURE IF EXISTS `tzdr`.`create_index` $$

CREATE PROCEDURE `tzdr`.`create_index`(db_name VARCHAR(60), tb_name VARCHAR(60), index_name VARCHAR(60), columns_name VARCHAR(60))
  BEGIN
    DECLARE IndexIsThere INTEGER;

    SELECT COUNT(1) INTO IndexIsThere
    FROM INFORMATION_SCHEMA.STATISTICS
    WHERE table_schema COLLATE utf8_bin = db_name
          AND table_name COLLATE utf8_bin = tb_name
          AND index_name COLLATE utf8_bin = index_name;

    IF IndexIsThere = 0 THEN
      SET @sqlstmt = CONCAT('CREATE INDEX ',index_name,' ON ',
                            db_name,'.',tb_name,' (',columns_name,')');
      PREPARE st FROM @sqlstmt;
      EXECUTE st;
      DEALLOCATE PREPARE st;
      SELECT CONCAT('Created index ', tb_name,'.', index_name, ' on columns ', columns_name)
        AS 'CreateIndex status';
    ELSE
      SELECT CONCAT('Index ',index_name,' Already Exists on Table ', db_name,'.',tb_name)
        AS 'CreateIndex status';
    END IF;
  END $$

delimiter ;

CALL create_index('tzdr', 'user_info', 'user_info_name_idx', 'name');
CALL create_index('tzdr', 'user_info', 'user_info_email_idx', 'email');
CALL create_index('tzdr', 'user_info', 'user_info_mobile_idx', 'mobile');

CALL create_index('tzdr', 'institution_info', 'institution_info_name', 'institution_name');
CALL create_index('tzdr', 'institution_info', 'institution_info_level', 'institution_level');
CALL create_index('tzdr', 'institution_info', 'institution_info_success_indicator', 'invest_success_indicator');
CALL create_index('tzdr', 'institution_info', 'institution_authenticated', 'authenticated');

CALL create_index('tzdr', 'investor_info', 'investor_info_name', 'investor_name');
CALL create_index('tzdr', 'investor_info', 'investor_info_level', 'investor_level');
CALL create_index('tzdr', 'investor_info', 'investor_invest_success_indicator', 'invest_success_indicator');
CALL create_index('tzdr', 'investor_info', 'investor_authenticated', 'authenticated');
