TRUNCATE TABLE sys_query_user_plan;

INSERT INTO sys_query_user_plan (id, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, public, status, create_by, create_time)
VALUES (1, null, 2, 'zi_dian_guan_li', '公共方案1', true, 'success', 'initializer', now());
INSERT INTO sys_query_user_plan (id, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, public, status, create_by, create_time)
VALUES (2, null, 2, 'zi_dian_guan_li', '公共方案2', true, 'success', 'initializer', now());

INSERT INTO sys_query_user_plan (id, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, status, create_by, create_time)
VALUES (10000, 1, 2, 'zi_dian_guan_li', '我的方案', 'success', 'initializer', now());
INSERT INTO sys_query_user_plan (id, sys_user_id, sys_query_id, sys_query_tag_cn_redundant, name, status, create_by, create_time)
VALUES (10001, 1, 2, 'zi_dian_guan_li', '我的方案2', 'success', 'initializer', now());
