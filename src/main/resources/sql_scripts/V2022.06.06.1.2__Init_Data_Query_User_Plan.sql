TRUNCATE TABLE sys_query_user_plan;

INSERT INTO sys_query_user_plan (id, page_tag, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, public, status, create_by, create_time)
VALUES (1, 'page:zi_dian_guan_li', null, 2, '字典管理', '公共方案1', true, 'success', 'initializer', now());
INSERT INTO sys_query_user_plan (id, page_tag, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, public, status, create_by, create_time)
VALUES (2, 'page:zi_dian_guan_li', null, 2, '字典管理', '公共方案2', true, 'success', 'initializer', now());

INSERT INTO sys_query_user_plan (id, page_tag, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, status, create_by, create_time)
VALUES (10000, 'page:zi_dian_guan_li', 1, 2, '字典管理', '我的方案', 'success', 'initializer', now());
INSERT INTO sys_query_user_plan (id, page_tag, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, status, create_by, create_time)
VALUES (10001, 'page:zi_dian_guan_li', 1, 2, '字典管理', '我的方案2', 'success', 'initializer', now());

TRUNCATE TABLE sys_query_user_plan_item;

INSERT INTO sys_query_user_plan_item (sys_query_id, sys_query_user_plan_id, sys_query_element_id, sys_user_id_redundant, sys_query_tag_cn_redundant, search_condition, search_value, status, create_by, create_time)
VALUES (2, 1, 10, null, '字典管理', '=', null, 'success', 'initializer', now())
