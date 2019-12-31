/*
 Navicat Premium Data Transfer

 Source Server         : Three
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : 127.0.0.1:3306
 Source Schema         : db_addressbook

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 21/11/2019 11:06:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `id` decimal(5, 0) NOT NULL COMMENT '编号',
  `firstName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名',
  `lastName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '姓',
  `jobTitle` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作电话',
  `department` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门',
  `offph` decimal(10, 0) DEFAULT NULL COMMENT '办公室电话',
  `mobile` decimal(11, 0) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (1, 'asd', 'jack', '山东省', 'sss', 1337471, 13387471854, '923394245@qq.com');
INSERT INTO `contact` VALUES (2, 'sum', 'jack', 'ssd', 'sss', 1337471, 13387471854, '923394245@qq.com');
INSERT INTO `contact` VALUES (3, 'sum', 'jack', 'ssd', 'sss', 1337471, 13387471854, '923394245@qq.com');
INSERT INTO `contact` VALUES (12, '23123', '1231', '21312', '21312', 213, 21, '2');
INSERT INTO `contact` VALUES (44, '23123', 'dsf', '班主任', 'sss', 1337471, 13387471854, '923394245@qq.com');
INSERT INTO `contact` VALUES (66, '安抚', 'jack', '阿萨大', 'sss', 1337471, 13387471854, '923394245@qq.com');

SET FOREIGN_KEY_CHECKS = 1;
