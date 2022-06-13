/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : mms_db

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2022-06-13 14:16:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill_info
-- ----------------------------
DROP TABLE IF EXISTS `bill_info`;
CREATE TABLE `bill_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `supplier_name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `drug_name` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `count` int(10) DEFAULT NULL COMMENT '药品数量',
  `total` float(20,2) DEFAULT NULL COMMENT '总金额',
  `buy_time` datetime DEFAULT NULL COMMENT '进货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='账单信息';

-- ----------------------------
-- Records of bill_info
-- ----------------------------
INSERT INTO `bill_info` VALUES ('1', '哈药六厂', '感冒灵', '1000', '22500.00', '2021-02-02 16:00:00');

-- ----------------------------
-- Table structure for drug_info
-- ----------------------------
DROP TABLE IF EXISTS `drug_info`;
CREATE TABLE `drug_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `supplier` varchar(255) DEFAULT NULL COMMENT '供应商',
  `product_time` date DEFAULT NULL COMMENT '生产时间',
  `warranty` varchar(255) DEFAULT NULL COMMENT '保质期（月）',
  `number` varchar(255) DEFAULT NULL COMMENT '药品编码',
  `price` float(20,2) DEFAULT NULL COMMENT '价格',
  `stock` int(10) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='药品信息';

-- ----------------------------
-- Records of drug_info
-- ----------------------------
INSERT INTO `drug_info` VALUES ('2', '感冒灵', '哈药六厂', '2020-01-27', '24', '1001', '22.50', '50');
INSERT INTO `drug_info` VALUES ('3', '白药片', '云南白药', '2021-02-02', '36', '2021052', '30.50', '100');
INSERT INTO `drug_info` VALUES ('4', 'dasd', '哈药六厂', '2022-06-07', '11', '1111', '11.00', '11');

-- ----------------------------
-- Table structure for ow_info
-- ----------------------------
DROP TABLE IF EXISTS `ow_info`;
CREATE TABLE `ow_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `type` varchar(255) DEFAULT NULL COMMENT '出库/入库',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='出入库';

-- ----------------------------
-- Records of ow_info
-- ----------------------------
INSERT INTO `ow_info` VALUES ('1', '白药片', '出库', '3', '华佗', '2021-02-20 14:21:53');
INSERT INTO `ow_info` VALUES ('2', '感冒灵', '入库', '20', '扁鹊', '2021-02-20 14:22:12');

-- ----------------------------
-- Table structure for problem_drug
-- ----------------------------
DROP TABLE IF EXISTS `problem_drug`;
CREATE TABLE `problem_drug` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `drug_count` int(10) DEFAULT NULL COMMENT '问题药品数量',
  `drug_price` float(20,2) DEFAULT NULL COMMENT '药品单价',
  `reason` varchar(1000) DEFAULT NULL COMMENT '问题原因',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='问题药品';

-- ----------------------------
-- Records of problem_drug
-- ----------------------------
INSERT INTO `problem_drug` VALUES ('1', '感冒灵', '2', '22.50', '受潮了。不能欺骗消费者。', '2021-02-24 14:19:36');

-- ----------------------------
-- Table structure for return_drug
-- ----------------------------
DROP TABLE IF EXISTS `return_drug`;
CREATE TABLE `return_drug` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `reason` varchar(1000) DEFAULT NULL COMMENT '退货原因',
  `total` float(20,2) DEFAULT NULL COMMENT '总金额',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='收到退货';

-- ----------------------------
-- Records of return_drug
-- ----------------------------
INSERT INTO `return_drug` VALUES ('1', '感冒灵', '1', '过期了。', '22.50', '2021-02-25 16:00:00');

-- ----------------------------
-- Table structure for return_supplier
-- ----------------------------
DROP TABLE IF EXISTS `return_supplier`;
CREATE TABLE `return_supplier` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `drug_count` int(10) DEFAULT NULL COMMENT '数量',
  `supplier_name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `buy_time` datetime DEFAULT NULL COMMENT '进货时间',
  `reason` varchar(1000) DEFAULT NULL COMMENT '退货原因',
  `return_time` datetime DEFAULT NULL COMMENT '退货时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='退货给供应商';

-- ----------------------------
-- Records of return_supplier
-- ----------------------------
INSERT INTO `return_supplier` VALUES ('1', '感冒灵', '5', '哈药六厂', '2021-02-24 16:00:00', '过期了呗！！！', '2021-02-26 16:00:00');

-- ----------------------------
-- Table structure for sale_info
-- ----------------------------
DROP TABLE IF EXISTS `sale_info`;
CREATE TABLE `sale_info` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `drug_name` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `drug_number` varchar(255) DEFAULT NULL COMMENT '药品编号',
  `count` int(10) DEFAULT NULL COMMENT '数量',
  `total` float(20,2) DEFAULT NULL COMMENT '金额',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='销售记录';

-- ----------------------------
-- Records of sale_info
-- ----------------------------
INSERT INTO `sale_info` VALUES ('1', '感冒灵', '1001', '2', '45.00', '张三', '2021-02-25 16:00:00');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) DEFAULT NULL COMMENT '供应商描述',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='供应商';

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '哈药六厂', '东北很知名的企业之一', '2018-01-17 11:52:53');
INSERT INTO `supplier` VALUES ('2', '云南白药', '云南白药是云南著名的中成药，由名贵药材制成，具有化瘀止血、活血止痛、解毒消肿之功效。', '2021-02-18 14:20:49');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `perm` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '123456', 'admin');
INSERT INTO `user` VALUES ('2', 'user', '123456', 'user');
