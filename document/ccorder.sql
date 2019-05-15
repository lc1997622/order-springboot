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
   user_id              varchar(255) comment '�̼Ҷ�Ӧ��user_id',
   content              varchar(511),
   create_user_id       varchar(255),
   create_time          datetime,
   modify_user_id       varchar(255),
   modify_time          datetime,
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
   primary key (id)
);

alter table comment comment 'ÿ������������һ�����۵Ļ���';

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   id                   varchar(255) not null,
   file_name            varchar(255),
   file_type            varchar(255),
   file_path            varchar(255) comment '��Ӧ�ֵ����id',
   file_remark          varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
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
   food_type            varchar(255) comment '��Ӧ�ֵ����id',
   food_material        varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
   primary key (id)
);

/*==============================================================*/
/* Table: map_file                                              */
/*==============================================================*/
create table map_file
(
   id                   varchar(255) not null,
   food_type            varchar(255) comment '��Ӧ�ֵ����id',
   ����id                 varchar(255),
   object_type          varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ'
);

alter table map_file comment '��Ҫ�Ǵ��û�������ʳ���ͼƬ';

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
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ'
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
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
   primary key (id)
);

alter table map_order_food comment '����score���û��������';

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
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ'
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
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
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
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
   primary key (id)
);

/*==============================================================*/
/* Table: order_table                                           */
/*==============================================================*/
create table order_table
(
   id                   varchar(255) not null,
   order_num            varchar(255),
   pay_method           varchar(255) comment '�ֵ���id',
   address              varchar(511),
   actual_payment       float,
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
   primary key (id)
);

alter table order_table comment '������Ϣ';

/*==============================================================*/
/* Table: sys_dict                                              */
/*==============================================================*/
create table sys_dict
(
   id                   varchar(255) not null,
   name_cn              varchar(255),
   name_en              varchar(255),
   sort                 int,
   type_id              varchar(255) comment '��Ӧ�ֵ�����id',
   parent_id            varchar(255),
   remark               varchar(255),
   create_user_id       varchar(255),
   create_date          datetime,
   modify_user_id       varchar(255),
   modify_date          datetime,
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
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
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
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
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
   primary key (id)
);

alter table sys_role comment '��ɫ��';

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
   sex                  int default 0 comment '0�ǳ�ʼֵ(δ����)��1���У�2��Ů',
   telephone            varchar(255),
   email                varchar(255),
   birthday             datetime,
   create_user_id       varchar(255),
   create_time          datetime,
   modify_user_id       varchar(255),
   modify_time          datetime,
   status               int default 0 comment '0��Ĭ��ֵ��-1ʧЧ',
   primary key (id)
);

alter table sys_user comment 'ϵͳ�û�';

