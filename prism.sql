/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : prism

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-10-28 00:33:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` tinyint(1) DEFAULT '0',
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `birthdate` date DEFAULT NULL,
  `balance` decimal(10,0) DEFAULT NULL,
  `age` int(10) unsigned DEFAULT NULL,
  `isActive` tinyint(1) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('2', 'Sourav', '2017-09-14', '10000', '25', '1', null);
INSERT INTO `customer` VALUES ('3', 'Masum', '2017-09-21', '100000', '30', '1', null);
INSERT INTO `customer` VALUES ('6', 'Masum Vai', '2017-09-22', '234', '33', '1', null);
INSERT INTO `customer` VALUES ('7', 'Name', '2017-09-15', '324234', '23', '1', null);
INSERT INTO `customer` VALUES ('8', 'jkhk', '2017-09-27', '899', '78', '1', null);
INSERT INTO `customer` VALUES ('9', 'fsfs', '2017-09-21', '44', '33', '1', null);
INSERT INTO `customer` VALUES ('10', 'sads', '2017-09-28', '223', '23', '1', null);
INSERT INTO `customer` VALUES ('11', 'sfds', null, '3333', '1', '1', null);
INSERT INTO `customer` VALUES ('12', 'kkj', '2017-09-08', '90990', '999', '1', null);
INSERT INTO `customer` VALUES ('13', 'sfs', null, '444', '4', '1', null);
INSERT INTO `customer` VALUES ('14', 'ssfs', '2017-09-21', '3243', '44', '1', null);
INSERT INTO `customer` VALUES ('18', 'kjfn', '2017-09-08', '333', '33', '1', null);
INSERT INTO `customer` VALUES ('19', 'Abc', '2017-10-31', '233', '23', '1', null);
INSERT INTO `customer` VALUES ('20', 'Test', '2017-10-05', '1111', '10', '1', null);
INSERT INTO `customer` VALUES ('21', 'Test Again', '2017-10-13', '100', '12', '1', null);
INSERT INTO `customer` VALUES ('22', 'Test4', '2017-10-12', '100', '33', '1', null);
INSERT INTO `customer` VALUES ('23', 'Deksi', '2017-10-27', '10', '33', '0', null);
INSERT INTO `customer` VALUES ('24', 'ijnkj', '2017-12-22', '900900', '99', '1', null);
INSERT INTO `customer` VALUES ('25', 'jkjkj', '2017-12-15', '9999', '89', '1', null);
INSERT INTO `customer` VALUES ('26', 'helo', '2017-12-05', '343343', '33', '1', null);
INSERT INTO `customer` VALUES ('28', 'Dsa', '2017-12-29', '44', '44', '1', null);
INSERT INTO `customer` VALUES ('29', 'kol', '2017-12-22', '4', '44', '1', null);
INSERT INTO `customer` VALUES ('31', 'Mamun', '2017-12-13', '10000', '26', '1', 'Draft');
INSERT INTO `customer` VALUES ('32', 'asd111', '2017-12-14', '111', '1111', '1', 'Draft');
INSERT INTO `customer` VALUES ('33', 'Maaa', '2017-12-07', '1222', '22', '1', 'Draft');
INSERT INTO `customer` VALUES ('34', 'Ma', '2017-12-06', '11111', '22', '1', 'Draft');
INSERT INTO `customer` VALUES ('35', 'jhj', '2017-12-06', '89', '6', '1', 'Draft');
INSERT INTO `customer` VALUES ('36', 'hh', '2017-12-13', '888', '88', '1', 'Draft');
INSERT INTO `customer` VALUES ('37', 'ms', '2017-12-12', '111', '11', '1', 'Draft');
INSERT INTO `customer` VALUES ('38', 'dfg', '2017-12-13', '111', '1', '1', 'Draft');
INSERT INTO `customer` VALUES ('39', 'dfsfs', '2017-12-22', '1111', '1', '1', 'Draft');
INSERT INTO `customer` VALUES ('40', 'hnhj', '2017-12-06', '99', '9', '1', 'Draft');
INSERT INTO `customer` VALUES ('41', 'hh', '2017-12-28', '99', '9', '0', 'Draft');
INSERT INTO `customer` VALUES ('42', 'jj', '2017-12-29', '99', '9', '0', 'Draft');
INSERT INTO `customer` VALUES ('43', 'dd', '2017-12-06', '11', '11', '0', 'Check');
INSERT INTO `customer` VALUES ('44', 'hh', '2017-12-18', '88', '88', '0', 'Draft');
INSERT INTO `customer` VALUES ('45', 'kk', '2017-12-26', '99', '9', '0', 'Make');
INSERT INTO `customer` VALUES ('46', 'mm', '2017-12-23', '99', '99', '0', 'Make');
INSERT INTO `customer` VALUES ('47', 'jj', '2017-12-30', '99', '99', '0', 'Make');
INSERT INTO `customer` VALUES ('48', 'kk', '2017-12-29', null, null, '0', 'Make');
INSERT INTO `customer` VALUES ('49', 'jj', '2017-12-21', '888', '88', '0', 'Make');
INSERT INTO `customer` VALUES ('50', 'hh', '2017-12-15', '88', null, '0', 'Make');
INSERT INTO `customer` VALUES ('51', 'nn', '2017-12-30', '99', '99', '0', 'Make');
INSERT INTO `customer` VALUES ('52', 'jjj', '2017-12-22', null, null, '0', 'Check');
INSERT INTO `customer` VALUES ('53', 'dd', '2017-12-30', '111', '11', '1', 'Check');
INSERT INTO `customer` VALUES ('54', 'jj', '2017-12-30', '0', '9', '0', 'Check');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `itemname` varchar(255) DEFAULT NULL,
  `itemprice` varchar(255) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `customerid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`orderid`),
  KEY `customerFK` (`customerid`),
  CONSTRAINT `customerFK` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------

-- ----------------------------
-- Table structure for `partner`
-- ----------------------------
DROP TABLE IF EXISTS `partner`;
CREATE TABLE `partner` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `name` varchar(128) NOT NULL,
  `image` longblob,
  `city` varchar(128) DEFAULT NULL,
  `country` varchar(128) DEFAULT NULL,
  `street` varchar(128) DEFAULT NULL,
  `supplier` tinyint(4) DEFAULT NULL,
  `customer` tinyint(4) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `website` varchar(64) DEFAULT NULL,
  `fax` varchar(64) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `credit` double DEFAULT NULL,
  `debit` double DEFAULT NULL,
  `image_medium` longblob,
  `mobile` varchar(64) DEFAULT NULL,
  `is_company` tinyint(4) DEFAULT NULL,
  `purchase_deals` int(11) DEFAULT '0',
  `sale_deals` int(11) DEFAULT '0',
  `active` tinyint(4) NOT NULL DEFAULT '1',
  `accountReceivable_id` int(11) NOT NULL,
  `accountPayable_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `partner_accountReceivable_id_fkey` (`accountReceivable_id`),
  KEY `partner_accountPayable_id_fkey` (`accountPayable_id`),
  CONSTRAINT `partner_ibfk_1` FOREIGN KEY (`accountPayable_id`) REFERENCES `account` (`id`),
  CONSTRAINT `partner_ibfk_2` FOREIGN KEY (`accountReceivable_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of partner
-- ----------------------------
INSERT INTO `partner` VALUES ('1', '2016-10-15 00:00:00', 'Md. Mamun', null, 'asas', 'MA', 'asas', '0', '1', 'asas', '', 'asas', 'asas', '0', '0', null, 'asas', null, null, null, '1', '1', '6');
INSERT INTO `partner` VALUES ('2', '2016-10-15 00:00:00', 'dfvdf', null, 'sdfs', 'MA', 'sdd', '0', '1', 'dsd', 'dsd', 'dfs', 'fds', '0', '0', null, 'sdfsd', null, null, null, '1', '1', '6');
INSERT INTO `partner` VALUES ('3', '2016-10-27 00:00:00', 'hbhhj', null, 'ddd', 'MA', 'ddd', '1', '1', 'dd', 'dd', 'ddd', 'dd', '0', '0', null, 'ddddd', null, null, null, '1', '1', '6');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `name` varchar(64) NOT NULL,
  `user_type` varchar(64) DEFAULT NULL,
  `image` longblob,
  `active` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'user', 'user', 'User', 'User', null, '1');
