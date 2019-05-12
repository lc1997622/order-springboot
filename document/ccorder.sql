/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/5/12 13:27:09                           */
/*==============================================================*/


drop table if exists comment;

drop table if exists file;

drop table if exists food;

drop table if exists map_file;

drop table if exists map_order_comment;

drop table if exists map_order_food;

drop table if exists map_user_food;

drop table if exists map_user_order;

drop table if exists map_user_role;

drop table if exists order_table;

drop table if exists sys_dict;

drop table if exists sys_dict_type;

drop table if exists sys_role;

drop table if exists sys_user;

/*==============================================================*/
/* Table: comment                                               */
/*==============================================================*/
create table comment
(
   id                   varchar(255) not null,
   order_id             varchar(255),
   user_id              varchar(255) comment '商家对应的user_id',
   content              varchar(511),
   create_user_id       varchar(255),
   create_time          datetime,
   modify_user_id       varchar(255),
   modify_time          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

alter table comment comment '每个订单可以有一次评价的机会';

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   id                   varchar(255) not null,
   file_name            varchar(255),
   file_type            varchar(255),
   file_path            varchar(255) comment '对应字典项的id',
   file_remark          varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

/*==============================================================*/
/* Table: food                                                  */
/*==============================================================*/
create table food
(
   id                   varchar(255) not null,
   food_name            varchar(255),
   food_price           double,
   food_type            varchar(255) comment '对应字典项的id',
   food_material        varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

/*==============================================================*/
/* Table: map_file                                              */
/*==============================================================*/
create table map_file
(
   id                   varchar(255) not null,
   food_type            varchar(255) comment '对应字典项的id',
   对象id                 varchar(255),
   object_type          varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效'
);

alter table map_file comment '主要是存用户或者是食物的图片';

/*==============================================================*/
/* Table: map_order_comment                                     */
/*==============================================================*/
create table map_order_comment
(
   id                   varchar(255) not null,
   order_id             varchar(255),
   comment_id           varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效'
);

/*==============================================================*/
/* Table: map_order_food                                        */
/*==============================================================*/
create table map_order_food
(
   id                   varchar(255) not null,
   order_id             varchar(255),
   food_id              varchar(255),
   score                float,
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

alter table map_order_food comment '包含score，用户打分属性';

/*==============================================================*/
/* Table: map_user_food                                         */
/*==============================================================*/
create table map_user_food
(
   id                   varchar(255) not null,
   user_id              varchar(255),
   food_id              varchar(255),
   discount             float default 1,
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效'
);

/*==============================================================*/
/* Table: map_user_order                                        */
/*==============================================================*/
create table map_user_order
(
   id                   varchar(255) not null,
   user_id              varchar(255),
   order_id             varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

/*==============================================================*/
/* Table: map_user_role                                         */
/*==============================================================*/
create table map_user_role
(
   id                   varchar(255) not null,
   user_id              varchar(255),
   role_id              varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

/*==============================================================*/
/* Table: order_table                                           */
/*==============================================================*/
create table order_table
(
   id                   varchar(255) not null,
   order_num            varchar(255),
   pay_method           varchar(255) comment '字典项id',
   address              varchar(511),
   actual_payment       float,
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

alter table order_table comment '订单信息';

/*==============================================================*/
/* Table: sys_dict                                              */
/*==============================================================*/
create table sys_dict
(
   id                   varchar(255) not null,
   name_cn              varchar(255),
   name_en              varchar(255),
   sort                 int,
   type_id              varchar(255) comment '对应字典类别表id',
   parent_id            varchar(255),
   remark               varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_dict_type                                         */
/*==============================================================*/
create table sys_dict_type
(
   id                   varchar(255) not null,
   name_cn              varchar(255),
   name_en              varchar(255),
   sort                 int,
   parent_id            varchar(255),
   remark               varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

/*==============================================================*/
/* Table: sys_role                                              */
/*==============================================================*/
create table sys_role
(
   id                   varchar(255) not null,
   code                 varchar(255),
   sort                 varchar(255),
   name                 varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

alter table sys_role comment '角色表';

/*==============================================================*/
/* Table: sys_user                                              */
/*==============================================================*/
create table sys_user
(
   id                   varchar(255) not null,
   username             varchar(255),
   password             varchar(255),
   real_name            varchar(255),
   nick_name            varchar(255),
   sex                  int default 0 comment '0是初始值(未设置)，1是男，2是女',
   telephone            varchar(255),
   email                varchar(255),
   birthday             datetime,
   create_user_id       varchar(255),
   create_time          datetime,
   modify_user_id       varchar(255),
   modify_time          datetime,
   status               int default 0 comment '0是默认值，-1失效',
   primary key (id)
);

alter table sys_user comment '系统用户';

