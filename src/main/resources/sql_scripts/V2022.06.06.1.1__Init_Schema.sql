create schema if not exists zz_start default char set utf8mb4 collate utf8mb4_general_ci;

use zz_start;

create table if not exists sys_user (
    id          bigint auto_increment comment '用户ID' primary key,
    user_name   varchar(30)  not null comment '用户账号',
    nick_name   varchar(30)  not null comment '用户昵称',
    email       varchar(50)  null comment '用户邮箱',
    phone       varchar(11)  null comment '手机号码',
    sex         char         null comment '用户性别（0男 1女 2未知）',
    avatar      varchar(100) null comment '头像地址',
    password    varchar(100) null comment '密码',
    login_ip    varchar(50)  null comment '最后登录IP',
    login_date  datetime     null comment '最后登录时间',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '用户信息表';

create table if not exists sys_select_option (
    id              bigint auto_increment comment 'ID' primary key,
    `key`           varchar(55)  null comment 'key',
    `table`         varchar(255) null comment '表',
    label           varchar(55)  null comment '标签',
    value           varchar(55)  null comment '列名 值',
    where_clause    varchar(255) null comment 'where子句',
    default_clause  varchar(255) null comment '获取默认值的子句',
    order_by_clause varchar(255) null comment 'order by 子句',
    payload         varchar(255) null comment '获取payload的子句',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '下拉列表';

create table if not exists sys_attachment (
    id          bigint auto_increment comment 'ID' primary key,
    business    varchar(55)  not null comment '业务',
    business_id bigint       not null comment '业务ID',
    hash        varchar(64)  not null comment '文件HASH',
    name        varchar(256) null comment '文件名',
    size        bigint       null comment '文件大小(Byte)',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '附件';

create table if not exists sys_dict_type (
    id          bigint auto_increment comment 'ID' primary key,
    name       varchar(64)   comment '名称',
    type       varchar(128)  comment '类型',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '字典类型';

create table if not exists sys_dict_data (
    id          bigint auto_increment comment 'ID' primary key,

    type        varchar(128) comment '类型',
    label       varchar(128) comment '名称',
    value       varchar(128) comment '值',
    sort        int          default 0 comment '排序',
    is_default  tinyint(1)   comment '是否为默认',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '字典值';

create table if not exists sys_query (
    id          bigint auto_increment comment 'ID' primary key,
    tag         varchar(128) comment '方案名(可用于查询，唯一)',
    tag_cn      varchar(128) comment '方案名(备注, 可为中文)',

    `sql`       text         comment 'sql',
    hash        binary(32)   comment 'hash',

    status      varchar(64)  not null default 'success' comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '查询方案配置';

create table if not exists sys_query_element (
    id                                  bigint auto_increment comment 'ID' primary key,
    sys_query_id                        bigint        comment '主键ID',
    sys_query_tag_cn_redundant          varchar(128)  comment '方案名(冗余字段)',
    alias                               varchar(128)  comment '属性名(作为字段名)',
    alias_cn                            varchar(128)  comment '属性名(显示用)',
    `sql`                               text          comment '属性sql',
    type                                varchar(64)   comment '类型(text, select, number, time, date, date-time, month, year)',
    limit_conditions                    varchar(255)  comment '允许的搜索条件',
    limit_type                          varchar(255)  comment '限定类型(可选)(values, dictionary, select_option, url)',
    sort                                int default 0 comment '排序',
    hidden                              tinyint(1)    comment '隐藏',
    order_by                            tinyint(1)    comment '排序字段',
    order_by_desc                       tinyint(1)    comment '倒序排序字段',
    limit_values                        varchar(255)  comment '限定值',

    status      varchar(64)  not null default 'success' comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '查询方案配置列';

create table if not exists sys_query_user_plan (
    id bigint auto_increment comment 'ID' primary key,

    sys_user_id                bigint       comment '用户ID',
    sys_query_id               bigint       comment '查询方案',
    sys_query_tag_cn_redundant varchar(128) comment '方案配置名(冗余字段)',

    name                       varchar(64) comment '用户定义的查询方案名称',
    sort                       int         comment '排序',
    `default`                  tinyint(1)  comment '是否为默认方案',
    public                   tinyint(1)  comment '只读（针对公用方案, 只能拷贝不能修改）',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '用户保存的查询方案';

create table if not exists sys_query_user_plan_item (
    id bigint auto_increment comment 'ID' primary key,

    sys_query_id                            bigint       comment '',
    sys_query_user_plan_id                  bigint       comment '表头ID',
    sys_query_element_id                    bigint       comment '对应的查询方案列ID',
    sys_user_id_redundant                   bigint       comment '用户ID(冗余)',
    sys_query_tag_cn_redundant              varchar(255) comment '查询方案配置名(冗余)',
    sys_query_element_alias_cn_redundant    varchar(255) comment '查询方案字段名(冗余)',

    search_condition varchar(255) comment '条件',
    search_value     varchar(255) comment '值',
    sort             int          comment '排序',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '用户保存的查询方案明细';

create table if not exists sys_query_element_user (
    id bigint auto_increment comment 'ID' primary key,

    sys_user_id                            bigint      comment '用户ID',
    sys_query_element_id                   bigint      comment '对应的查询方案列ID',
    hidden                                 tinyint(1)  comment '是否隐藏',
    sort                                   int         comment '排序信息',
    sortable                               tinyint(1)  comment '是否允许排序(对于操作列，是不能排序的)',
    width                                  varchar(64) comment '宽度',

    status      varchar(64)  not null comment '状态[init, wait, success, invalid, cancel, invalid_wait, cancel_wait, reject]',
    create_by   varchar(64)  null comment '创建者',
    create_time datetime     null comment '创建时间',
    update_by   varchar(64)  null comment '更新者',
    update_time datetime     null comment '更新时间',
    deleted     tinyint(1)   not null default false comment '删除标志',
    remark      varchar(500) null comment '备注'
) comment '用户定义字段信息(排序,隐藏)';
