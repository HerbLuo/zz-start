TRUNCATE TABLE sys_select_option;
INSERT INTO sys_select_option (`key`, `table`, label, value, where_clause, status, create_by, create_time)
VALUES ('状态', 'sys_dict_data', 'label', 'value', 'type = \'status\'', 'success', 'initializer', now());
INSERT INTO sys_select_option (`key`, `table`, label, value, where_clause, status, create_by, create_time)
VALUES ('状态标签', 'sys_dict_data', 'label', 'label', 'type = \'status\'', 'success', 'initializer', now());
