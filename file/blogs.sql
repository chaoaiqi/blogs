/*
Navicat MySQL Data Transfer

Source Server         : self
Source Server Version : 50724
Source Host           : 132.232.75.229:3306
Source Database       : blogs

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-11-05 11:19:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_category
-- ----------------------------
DROP TABLE IF EXISTS `blog_category`;
CREATE TABLE `blog_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET latin1 NOT NULL COMMENT '分类名称',
  `index` int(50) unsigned zerofill NOT NULL COMMENT '分类排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tag` varchar(50) NOT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_twitter
-- ----------------------------
DROP TABLE IF EXISTS `blog_twitter`;
CREATE TABLE `blog_twitter` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `content` varchar(255) NOT NULL,
  `createtime` datetime(6) NOT NULL,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `likenum` int(10) unsigned zerofill NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `telephone` varchar(11) NOT NULL,
  `account` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `createtime` datetime NOT NULL,
  `superuser` tinyint(1) unsigned zerofill NOT NULL,
  PRIMARY KEY (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `blog_userinfo`;
CREATE TABLE `blog_userinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `telephone` varchar(11) NOT NULL,
  `lasttime` datetime NOT NULL COMMENT '上一次登录时间',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `lastsite` varchar(50) NOT NULL COMMENT '最后登录地点',
  PRIMARY KEY (`id`),
  KEY `telephone` (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for blog_visit
-- ----------------------------
DROP TABLE IF EXISTS `blog_visit`;
CREATE TABLE `blog_visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lasttime` datetime NOT NULL,
  `ip` varchar(20) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
