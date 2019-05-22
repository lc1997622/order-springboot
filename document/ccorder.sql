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

 Date: 22/05/2019 19:50:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `address_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址名',
  `house number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '门牌号',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是初始值，-1失效, 1是默认地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('address0001', '我是第一个地址', '门牌号0001', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:04', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:08', 0);
INSERT INTO `address` VALUES ('address0002', '我是第二个地址', '门牌号0002', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:06', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:11', 0);

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `content` varchar(511) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容(每个订单有一次评论机会)',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '每个订单可以有一次评价的机会' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2bf1ecd0-4d1b-415f-825b-a9620efd599a', 'order0002', '我是第2个条评论内容', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '1999-01-26 08:00:00', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '1999-01-27 08:00:00', 0);
INSERT INTO `comment` VALUES ('comment0001', 'order0001', '这家店很好呀很好呀', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 19:14:36', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 19:14:38', 0);

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
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('food0001', '酸菜鱼', 68, ' 0001(字典项)', '清江鱼 酸菜', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '1999-01-26 08:00:00', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '1999-01-26 08:00:00', 0);
INSERT INTO `food` VALUES ('food0002', '大盘鸡', 56, '0002(字典项)', '土豆 鸡块 西红柿', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 16:39:12', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 16:39:14', 0);

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
-- Table structure for map_order_address
-- ----------------------------
DROP TABLE IF EXISTS `map_order_address`;
CREATE TABLE `map_order_address`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `address_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址id',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单地址关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_order_address
-- ----------------------------
INSERT INTO `map_order_address` VALUES ('maporderaddress0001', 'order0001', 'address0001', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:11:12', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:11:14', 0);
INSERT INTO `map_order_address` VALUES ('maporderaddress0002', 'order0002', 'address0002', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:11:12', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:11:14', 0);

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
-- Records of map_order_food
-- ----------------------------
INSERT INTO `map_order_food` VALUES ('maporderfood0001', 'order0001', 'food0001', 1, NULL, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 16:40:12', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 16:40:17', 0);
INSERT INTO `map_order_food` VALUES ('maporderfood0002', 'order0001', 'food0002', 2, NULL, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 16:40:14', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 16:40:19', 0);

-- ----------------------------
-- Table structure for map_user_address
-- ----------------------------
DROP TABLE IF EXISTS `map_user_address`;
CREATE TABLE `map_user_address`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `address_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址id',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_user_address
-- ----------------------------
INSERT INTO `map_user_address` VALUES ('mapuseraddress0001', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', 'address0001', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:50', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:52', 0);
INSERT INTO `map_user_address` VALUES ('mapuseraddress0002', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', 'address0002', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:50', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:09:52', 0);

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
-- Records of map_user_food
-- ----------------------------
INSERT INTO `map_user_food` VALUES ('220e4621-5a9f-451c-8add-2b4412a4edb8', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '37189440-0490-44fa-87f7-3532e85d00e3', 1, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-21 21:02:33', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-21 21:02:33', 0);

-- ----------------------------
-- Table structure for map_user_order
-- ----------------------------
DROP TABLE IF EXISTS `map_user_order`;
CREATE TABLE `map_user_order`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键ID',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id(可以是用户也可以是商家)',
  `order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单id',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效，1代表是用户，2代表是商家。',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_user_order
-- ----------------------------
INSERT INTO `map_user_order` VALUES ('mapuserorder0001', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', 'order0001', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:21', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:25', 0);
INSERT INTO `map_user_order` VALUES ('mapuserorder0002', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', 'order0002', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:21', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:25', 0);
INSERT INTO `map_user_order` VALUES ('mapuserorder0003', 'store0001', 'order0001', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:21', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:25', 0);
INSERT INTO `map_user_order` VALUES ('mapuserorder0004', 'store0001', 'order0002', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:21', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 06:59:25', 0);

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
  `delivery_time` datetime(0) NULL DEFAULT NULL COMMENT '送达时间',
  `address` varchar(511) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收货地址',
  `actual_payment` float NULL DEFAULT NULL COMMENT '实际支付',
  `score` float NULL DEFAULT NULL COMMENT '订单评分(针对商家)',
  `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人id',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终修改人id',
  `modify_date` datetime(0) NULL DEFAULT NULL COMMENT '最终修改时间',
  `status` int(11) NULL DEFAULT 0 COMMENT '0是默认值，-1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_table
-- ----------------------------
INSERT INTO `order_table` VALUES ('order0001', '订单号1', '支付宝', '2019-05-22 15:12:14', NULL, 100, 5, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:12:23', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:12:29', 5);
INSERT INTO `order_table` VALUES ('order0002', '订单号2', '微信', '2019-05-22 15:12:08', NULL, 200, 4.5, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:12:27', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 15:12:31', 5);

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
INSERT INTO `sys_user` VALUES ('store0001', 'store', 'store', '店家', '小二', 0, '18811xxxxxx', NULL, NULL, 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 18:59:38', 'o258k0Zofn-pJJvLs6DzKRHwvkbA', '2019-05-22 18:59:40', 1);

SET FOREIGN_KEY_CHECKS = 1;
