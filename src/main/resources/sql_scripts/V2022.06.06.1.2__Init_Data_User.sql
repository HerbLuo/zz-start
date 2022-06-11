truncate table sys_user;
INSERT INTO sys_user (`user_name`, `nick_name`, `password`, `status`, `create_by`, `create_time`)
VALUES ('admin', 'Admin', '123456', 'success', 'initializer', now());
INSERT INTO sys_user (`user_name`, `nick_name`, `password`, `status`, `create_by`, `create_time`)
VALUES ('test', 'Test', '123456', 'success', 'initializer', now());

