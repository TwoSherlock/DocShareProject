/*
Navicat MySQL Data Transfer

Source Server         : mySqlConn
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : docshare

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2018-11-25 19:58:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `ROLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '身份编号',
  `ROLE_NM` varchar(12) NOT NULL COMMENT '身份名',
  `ST` char(255) DEFAULT NULL COMMENT '用户状态，1：可用，2：禁用',
  `CRTR` varchar(10) DEFAULT NULL COMMENT '创建人',
  `CRTM` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDTR` varchar(10) DEFAULT NULL COMMENT '修改人',
  `UPDTM` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------

-- ----------------------------
-- Table structure for `usr_info`
-- ----------------------------
DROP TABLE IF EXISTS `usr_info`;
CREATE TABLE `usr_info` (
  `USR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `USR_NM` varchar(12) NOT NULL COMMENT '用户名',
  `USR_PWD` varchar(50) NOT NULL COMMENT '用户密码，需要加密',
  `ST` char(255) DEFAULT NULL COMMENT '用户状态，1：可用，2：禁用',
  `CRTR` varchar(10) DEFAULT NULL COMMENT '创建人',
  `CRTM` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `UPDTR` varchar(10) DEFAULT NULL COMMENT '修改人',
  `UPDTM` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`USR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usr_info
-- ----------------------------

-- ----------------------------
-- Table structure for `usr_role_mpng`
-- ----------------------------
DROP TABLE IF EXISTS `usr_role_mpng`;
CREATE TABLE `usr_role_mpng` (
  `MPNG_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USR_ID` int(11) NOT NULL,
  `ROLE_ID` int(11) NOT NULL,
  PRIMARY KEY (`MPNG_ID`),
  KEY `用户id` (`USR_ID`),
  KEY `身份id` (`ROLE_ID`),
  CONSTRAINT `用户id` FOREIGN KEY (`USR_ID`) REFERENCES `usr_info` (`USR_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `身份id` FOREIGN KEY (`ROLE_ID`) REFERENCES `role_info` (`ROLE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of usr_role_mpng
-- ----------------------------
