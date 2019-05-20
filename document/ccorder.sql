/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : ccorder

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 20/05/2019 10:52:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应的商家id',
  `content` varchar(511) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容(每个订单有一次评论机会)',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '每个订单可以有一次评价的机会' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件格式',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件存放路径',
  `file_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件备注',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `food_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '食物名称',
  `food_price` double NULL DEFAULT NULL COMMENT '食物价格',
  `food_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '食物类别(对应字典项的id)',
  `food_material` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '食物原料',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_file
-- ----------------------------
DROP TABLE IF EXISTS `map_file`;
CREATE TABLE `map_file`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `file_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'file表主键',
  `object_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对象的主键ID',
  `food_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件类型(对应字典项的id)',
  `object_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对象类型(对应字典项id)',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '主要是存用户或者是食物的图片' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_order_comment
-- ----------------------------
DROP TABLE IF EXISTS `map_order_comment`;
CREATE TABLE `map_order_comment`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `comment_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论id',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_order_food
-- ----------------------------
DROP TABLE IF EXISTS `map_order_food`;
CREATE TABLE `map_order_food`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `food_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '食品id',
  `amount` int(11) NULL DEFAULT NULL COMMENT '该订单中本食品数量',
  `score` float NULL DEFAULT NULL COMMENT '该订单中本食品的评分',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '包含score，用户打分属性' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_food
-- ----------------------------
DROP TABLE IF EXISTS `map_user_food`;
CREATE TABLE `map_user_food`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id(店家)',
  `food_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '食品id',
  `discount` float NULL DEFAULT 1 COMMENT '食品折扣，范围(0,1)',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_order
-- ----------------------------
DROP TABLE IF EXISTS `map_user_order`;
CREATE TABLE `map_user_order`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for map_user_role
-- ----------------------------
DROP TABLE IF EXISTS `map_user_role`;
CREATE TABLE `map_user_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_table
-- ----------------------------
DROP TABLE IF EXISTS `order_table`;
CREATE TABLE `order_table`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
  `pay_method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式(字典项id)',
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '订单配送时间',
  `address` varchar(511) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `actual_payment` float NULL DEFAULT NULL COMMENT '实际支付',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `name_cn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名',
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文名',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序序号',
  `type_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字典类别id(对应sys_dict_type的id)',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父字典项id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('0001', '名点主食', 'zhushi', 0, 'dsihcihsifcaeba', NULL, NULL, 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:42:47', 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:05', 0);
INSERT INTO `sys_dict` VALUES ('0002', '烧卤卤味', 'luwei', 1, 'dsihcihsifcaeba', NULL, NULL, 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:42:54', 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:08', 0);
INSERT INTO `sys_dict` VALUES ('0003', '秦淮小厨', 'xiaochu', 2, 'dsihcihsifcaeba', NULL, NULL, 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:42:57', 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:10', 0);
INSERT INTO `sys_dict` VALUES ('0004', '秦淮糕点', 'gaodian', 3, 'dsihcihsifcaeba', NULL, NULL, 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:42:59', 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:12', 0);
INSERT INTO `sys_dict` VALUES ('0005', '冰爽畅饮', 'yinliao', 4, 'dsihcihsifcaeba', NULL, NULL, 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:01', 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:14', 0);
INSERT INTO `sys_dict` VALUES ('0006', '开胃凉菜', 'liangcai', 5, 'dsihcihsifcaeba', NULL, NULL, 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:03', 'pJJvLs6DzKRHwvkbA', '2019-05-17 10:43:16', 0);
INSERT INTO `sys_dict` VALUES ('d51d508c-fbe4-4899-92a5-8827d3d20f6e', '蜜汁菜品', NULL, 9, NULL, NULL, NULL, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-17 11:52:46', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-17 11:52:46', 0);

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `name_cn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名',
  `name_en` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '英文名',
  `sort` int(11) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '类别排序',
  `parent_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父类别id',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES ('dsihcihsifcaeba', '食品类别', 'foodType', 00000000001, NULL, NULL, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-17 10:38:25', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-17 10:38:27', 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色code',
  `sort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` int(11) NULL DEFAULT 0 COMMENT '0是初始值(未设置)，1是男，2是女',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('o258k0Zofn-pJJvLs6DzKRHwvkbA', 'zm', 'zm', '周淼', '三水', 1, '18811650227', '529117982@qq.com', '1999-01-26 00:00:00', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-17 10:03:57', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-17 10:03:59', 0);

SET FOREIGN_KEY_CHECKS = 1;
