create schema if not exists zz_start default char set utf8mb4 collate utf8mb4_general_ci;

create table sys_user (
    id          bigint auto_increment comment '用户ID' primary key,
    user_name   varchar(30)  not null comment '用户账号',
    nick_name   varchar(30)  not null comment '用户昵称',
    email       varchar(50)  null comment '用户邮箱',
    phone       varchar(11)  null comment '手机号码',
    sex         char         null     default '0' comment '用户性别（0男 1女 2未知）',
    avatar      varchar(100) null comment '头像地址',
    password    varchar(100) null comment '密码',
    login_ip    varchar(50)  null comment '最后登录IP',
    login_date  datetime     null comment '最后登录时间',

    status      varchar(64)  null comment '帐号状态（0正常 1停用）',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '用户信息表';

create table sys_select_option (
    id bigint auto_increment primary key,
    `key` varchar(55) null comment 'key',
    `table` varchar(255) null comment '表',
    label varchar(55) null comment '标签',
    value varchar(55) null comment '列名 值',
    where_clause varchar(255) null comment 'where子句',
    order_by_clause varchar(255) null comment 'order by 子句',
    deleted tinyint(1) default 0 null
);
