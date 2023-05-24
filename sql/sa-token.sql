/*
 Navicat Premium Data Transfer

 Source Server         : sa-token
 Source Server Type    : MySQL
 Source Server Version : 50740 (5.7.40-log)
 Source Host           : 123.57.133.26:3306
 Source Schema         : sa-token

 Target Server Type    : MySQL
 Target Server Version : 50740 (5.7.40-log)
 File Encoding         : 65001

 Date: 24/05/2023 13:13:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `code` varchar(50) NOT NULL COMMENT '权限',
  `path` varchar(50) NOT NULL COMMENT '路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
BEGIN;
INSERT INTO `tb_menu` (`id`, `name`, `code`, `path`) VALUES (1, '用户列表', 'user:list', '/user/list');
INSERT INTO `tb_menu` (`id`, `name`, `code`, `path`) VALUES (2, '增加用户', 'user:add', '/user/add');
INSERT INTO `tb_menu` (`id`, `name`, `code`, `path`) VALUES (3, '修改用户', 'user:edit', '/user/edit');
INSERT INTO `tb_menu` (`id`, `name`, `code`, `path`) VALUES (4, '删除用户', 'user:delete', '/user/delete');
COMMIT;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(50) NOT NULL COMMENT '角色',
  `role_name` varchar(50) NOT NULL COMMENT '角色名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_role` (`id`, `role_code`, `role_name`) VALUES (1, 'admin', '管理员');
INSERT INTO `tb_role` (`id`, `role_code`, `role_name`) VALUES (2, 'user', '普通用户');
COMMIT;

-- ----------------------------
-- Table structure for tb_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_menu`;
CREATE TABLE `tb_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `menu_id` bigint(20) NOT NULL COMMENT '权限id（0代表所有）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `tb_role_menu` (`id`, `role_id`, `menu_id`) VALUES (5, 2, 1);
INSERT INTO `tb_role_menu` (`id`, `role_id`, `menu_id`) VALUES (6, 1, 0);
COMMIT;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `gender` int(11) NOT NULL COMMENT '性别 1男 0女',
  `age` int(11) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
BEGIN;
INSERT INTO `tb_user` (`id`, `name`, `username`, `password`, `gender`, `age`) VALUES (1, '管理员', 'admin', '$2a$10$mbo7FiZ1T/ZgMtFvVwG38eLUifNpqi8kX/rhrcYxKr8txwApkfNCu', 1, 22);
INSERT INTO `tb_user` (`id`, `name`, `username`, `password`, `gender`, `age`) VALUES (2, '李四', 'lisi', '$2a$10$FDOOgRLW12Pgt1d5qU8V8u4vAp/A9bMuIpl0RlzBh305AZhWMYfhO', 0, 25);
COMMIT;

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
BEGIN;
INSERT INTO `tb_user_role` (`id`, `user_id`, `role_id`) VALUES (1, 2, 2);
INSERT INTO `tb_user_role` (`id`, `user_id`, `role_id`) VALUES (2, 1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
