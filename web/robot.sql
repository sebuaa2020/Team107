/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : frb

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 23/02/2020 22:58:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for thesys_loginlog
-- ----------------------------
DROP TABLE IF EXISTS `thesys_loginlog`;
CREATE TABLE `thesys_loginlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logintime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 169 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thesys_loginlog
-- ----------------------------
INSERT INTO `thesys_loginlog` VALUES (2, '超级管理员-system', '127.0.0.1', '2018-12-21 16:54:52');
INSERT INTO `thesys_loginlog` VALUES (3, '超级管理员-system', '127.0.0.1', '2018-12-21 16:55:15');
INSERT INTO `thesys_loginlog` VALUES (4, '超级管理员-system', '127.0.0.1', '2018-12-21 17:29:22');
INSERT INTO `thesys_loginlog` VALUES (5, '超级管理员-system', '127.0.0.1', '2018-12-22 09:05:22');
INSERT INTO `thesys_loginlog` VALUES (6, '超级管理员-system', '127.0.0.1', '2018-12-22 09:20:43');
INSERT INTO `thesys_loginlog` VALUES (7, '超级管理员-system', '127.0.0.1', '2018-12-22 09:25:40');
INSERT INTO `thesys_loginlog` VALUES (8, '超级管理员-system', '127.0.0.1', '2018-12-22 09:27:11');
INSERT INTO `thesys_loginlog` VALUES (9, '超级管理员-system', '127.0.0.1', '2018-12-22 09:29:58');
INSERT INTO `thesys_loginlog` VALUES (10, '超级管理员-system', '127.0.0.1', '2018-12-22 09:36:49');
INSERT INTO `thesys_loginlog` VALUES (11, '超级管理员-system', '127.0.0.1', '2018-12-22 09:46:56');
INSERT INTO `thesys_loginlog` VALUES (12, '超级管理员-system', '127.0.0.1', '2018-12-22 09:48:29');
INSERT INTO `thesys_loginlog` VALUES (13, '超级管理员-system', '127.0.0.1', '2018-12-22 09:49:13');
INSERT INTO `thesys_loginlog` VALUES (14, '超级管理员-system', '127.0.0.1', '2018-12-22 09:49:57');
INSERT INTO `thesys_loginlog` VALUES (15, '超级管理员-system', '127.0.0.1', '2018-12-22 09:57:46');
INSERT INTO `thesys_loginlog` VALUES (16, '超级管理员-system', '127.0.0.1', '2018-12-22 10:21:53');
INSERT INTO `thesys_loginlog` VALUES (17, '超级管理员-system', '127.0.0.1', '2018-12-22 10:38:25');
INSERT INTO `thesys_loginlog` VALUES (18, '超级管理员-system', '127.0.0.1', '2018-12-22 10:49:21');
INSERT INTO `thesys_loginlog` VALUES (19, '超级管理员-system', '127.0.0.1', '2018-12-22 14:01:42');
INSERT INTO `thesys_loginlog` VALUES (20, '超级管理员-system', '127.0.0.1', '2018-12-22 14:19:48');
INSERT INTO `thesys_loginlog` VALUES (21, '超级管理员-system', '127.0.0.1', '2018-12-22 14:45:29');
INSERT INTO `thesys_loginlog` VALUES (22, '超级管理员-system', '127.0.0.1', '2018-12-22 15:58:05');
INSERT INTO `thesys_loginlog` VALUES (23, '超级管理员-system', '127.0.0.1', '2018-12-22 16:40:53');
INSERT INTO `thesys_loginlog` VALUES (24, '超级管理员-system', '127.0.0.1', '2018-12-22 17:12:01');
INSERT INTO `thesys_loginlog` VALUES (25, '超级管理员-system', '127.0.0.1', '2018-12-24 09:19:15');
INSERT INTO `thesys_loginlog` VALUES (26, '超级管理员-system', '127.0.0.1', '2018-12-24 09:37:28');
INSERT INTO `thesys_loginlog` VALUES (27, '超级管理员-system', '127.0.0.1', '2018-12-24 09:46:51');
INSERT INTO `thesys_loginlog` VALUES (28, '超级管理员-system', '127.0.0.1', '2018-12-24 09:50:40');
INSERT INTO `thesys_loginlog` VALUES (29, '超级管理员-system', '127.0.0.1', '2018-12-24 09:52:52');
INSERT INTO `thesys_loginlog` VALUES (30, '超级管理员-system', '127.0.0.1', '2018-12-24 10:00:26');
INSERT INTO `thesys_loginlog` VALUES (31, '超级管理员-system', '127.0.0.1', '2018-12-24 10:10:58');
INSERT INTO `thesys_loginlog` VALUES (32, '超级管理员-system', '127.0.0.1', '2018-12-24 10:21:28');
INSERT INTO `thesys_loginlog` VALUES (33, '超级管理员-system', '127.0.0.1', '2018-12-24 11:22:27');
INSERT INTO `thesys_loginlog` VALUES (34, '超级管理员-system', '127.0.0.1', '2018-12-24 11:35:28');
INSERT INTO `thesys_loginlog` VALUES (35, '超级管理员-system', '127.0.0.1', '2018-12-24 14:05:28');
INSERT INTO `thesys_loginlog` VALUES (36, '超级管理员-system', '127.0.0.1', '2018-12-24 15:16:29');
INSERT INTO `thesys_loginlog` VALUES (37, '李四-ls', '127.0.0.1', '2018-12-24 15:16:50');
INSERT INTO `thesys_loginlog` VALUES (38, '王五-ww', '127.0.0.1', '2018-12-24 15:17:36');
INSERT INTO `thesys_loginlog` VALUES (39, '赵六-zl', '127.0.0.1', '2018-12-24 15:17:47');
INSERT INTO `thesys_loginlog` VALUES (40, '孙七-sq', '127.0.0.1', '2018-12-24 15:17:58');
INSERT INTO `thesys_loginlog` VALUES (41, '刘八-lb', '127.0.0.1', '2018-12-24 15:18:09');
INSERT INTO `thesys_loginlog` VALUES (42, '超级管理员-system', '127.0.0.1', '2018-12-24 15:34:59');
INSERT INTO `thesys_loginlog` VALUES (43, '超级管理员-system', '127.0.0.1', '2018-12-24 15:35:09');
INSERT INTO `thesys_loginlog` VALUES (44, '刘八-lb', '127.0.0.1', '2018-12-24 15:36:09');
INSERT INTO `thesys_loginlog` VALUES (45, '刘八-lb', '127.0.0.1', '2018-12-24 15:42:58');
INSERT INTO `thesys_loginlog` VALUES (46, '刘八-lb', '127.0.0.1', '2018-12-24 15:43:04');
INSERT INTO `thesys_loginlog` VALUES (47, '超级管理员-system', '127.0.0.1', '2018-12-24 15:46:01');
INSERT INTO `thesys_loginlog` VALUES (48, '超级管理员-system', '127.0.0.1', '2018-12-24 17:03:54');
INSERT INTO `thesys_loginlog` VALUES (49, '超级管理员-system', '127.0.0.1', '2018-12-24 17:26:32');
INSERT INTO `thesys_loginlog` VALUES (50, '超级管理员-system', '127.0.0.1', '2018-12-25 09:07:42');
INSERT INTO `thesys_loginlog` VALUES (51, '超级管理员-system', '127.0.0.1', '2018-12-25 09:16:27');
INSERT INTO `thesys_loginlog` VALUES (52, '超级管理员-system', '127.0.0.1', '2018-12-25 09:59:03');
INSERT INTO `thesys_loginlog` VALUES (53, '超级管理员-system', '127.0.0.1', '2018-12-25 10:05:13');
INSERT INTO `thesys_loginlog` VALUES (54, '超级管理员-system', '127.0.0.1', '2018-12-25 10:05:47');
INSERT INTO `thesys_loginlog` VALUES (55, '超级管理员-system', '127.0.0.1', '2018-12-25 10:11:17');
INSERT INTO `thesys_loginlog` VALUES (56, '超级管理员-system', '127.0.0.1', '2018-12-25 10:14:06');
INSERT INTO `thesys_loginlog` VALUES (57, '超级管理员-system', '127.0.0.1', '2018-12-25 10:36:16');
INSERT INTO `thesys_loginlog` VALUES (58, '超级管理员-system', '127.0.0.1', '2018-12-25 14:17:21');
INSERT INTO `thesys_loginlog` VALUES (59, '超级管理员-system', '127.0.0.1', '2018-12-25 14:20:00');
INSERT INTO `thesys_loginlog` VALUES (60, '超级管理员-system', '127.0.0.1', '2018-12-25 14:34:22');
INSERT INTO `thesys_loginlog` VALUES (61, '超级管理员-system', '127.0.0.1', '2018-12-25 14:34:27');
INSERT INTO `thesys_loginlog` VALUES (62, '超级管理员-system', '127.0.0.1', '2018-12-25 14:38:37');
INSERT INTO `thesys_loginlog` VALUES (63, '超级管理员-system', '127.0.0.1', '2018-12-25 14:50:37');
INSERT INTO `thesys_loginlog` VALUES (64, '超级管理员-system', '127.0.0.1', '2018-12-25 16:01:35');
INSERT INTO `thesys_loginlog` VALUES (65, '超级管理员-system', '127.0.0.1', '2018-12-25 16:25:28');
INSERT INTO `thesys_loginlog` VALUES (66, '超级管理员-system', '127.0.0.1', '2018-12-25 16:27:37');
INSERT INTO `thesys_loginlog` VALUES (67, '超级管理员-system', '127.0.0.1', '2018-12-25 16:28:28');
INSERT INTO `thesys_loginlog` VALUES (68, '超级管理员-system', '127.0.0.1', '2018-12-25 16:44:02');
INSERT INTO `thesys_loginlog` VALUES (69, '超级管理员-system', '127.0.0.1', '2018-12-25 16:47:55');
INSERT INTO `thesys_loginlog` VALUES (70, '超级管理员-system', '127.0.0.1', '2018-12-28 15:59:34');
INSERT INTO `thesys_loginlog` VALUES (71, '超级管理员-system', '127.0.0.1', '2018-12-28 17:27:16');
INSERT INTO `thesys_loginlog` VALUES (72, '超级管理员-system', '127.0.0.1', '2018-12-28 17:29:40');
INSERT INTO `thesys_loginlog` VALUES (73, '超级管理员-system', '127.0.0.1', '2018-12-28 17:51:10');
INSERT INTO `thesys_loginlog` VALUES (74, '超级管理员-system', '127.0.0.1', '2019-04-15 17:05:02');
INSERT INTO `thesys_loginlog` VALUES (75, '超级管理员-system', '127.0.0.1', '2019-04-15 17:05:12');
INSERT INTO `thesys_loginlog` VALUES (76, '超级管理员-system', '127.0.0.1', '2019-04-15 17:10:22');
INSERT INTO `thesys_loginlog` VALUES (77, '刘八-lb', '127.0.0.1', '2019-04-15 17:11:45');
INSERT INTO `thesys_loginlog` VALUES (78, '刘八-lb', '127.0.0.1', '2019-04-15 17:28:50');
INSERT INTO `thesys_loginlog` VALUES (79, '超级管理员-system', '127.0.0.1', '2019-04-15 17:29:13');
INSERT INTO `thesys_loginlog` VALUES (80, '刘八-lb', '127.0.0.1', '2019-04-15 17:30:59');
INSERT INTO `thesys_loginlog` VALUES (81, '刘八-lb', '127.0.0.1', '2019-04-15 17:32:42');
INSERT INTO `thesys_loginlog` VALUES (82, '刘八-lb', '127.0.0.1', '2019-04-15 17:33:48');
INSERT INTO `thesys_loginlog` VALUES (83, '刘八-lb', '127.0.0.1', '2019-04-15 17:34:17');
INSERT INTO `thesys_loginlog` VALUES (84, '超级管理员-system', '127.0.0.1', '2019-04-15 17:36:40');
INSERT INTO `thesys_loginlog` VALUES (85, '超级管理员-system', '127.0.0.1', '2019-04-15 17:47:21');
INSERT INTO `thesys_loginlog` VALUES (86, '超级管理员-system', '127.0.0.1', '2019-04-15 17:54:10');
INSERT INTO `thesys_loginlog` VALUES (87, '超级管理员-system', '127.0.0.1', '2019-04-15 17:55:52');
INSERT INTO `thesys_loginlog` VALUES (88, '超级管理员-system', '127.0.0.1', '2019-04-16 09:26:01');
INSERT INTO `thesys_loginlog` VALUES (89, '超级管理员-system', '127.0.0.1', '2019-04-16 09:26:25');
INSERT INTO `thesys_loginlog` VALUES (90, '超级管理员-system', '127.0.0.1', '2019-04-16 09:46:54');
INSERT INTO `thesys_loginlog` VALUES (91, '超级管理员-system', '127.0.0.1', '2019-04-16 10:07:48');
INSERT INTO `thesys_loginlog` VALUES (92, '超级管理员-system', '127.0.0.1', '2019-04-16 10:10:30');
INSERT INTO `thesys_loginlog` VALUES (93, '超级管理员-system', '127.0.0.1', '2019-04-16 10:14:29');
INSERT INTO `thesys_loginlog` VALUES (94, '超级管理员-system', '127.0.0.1', '2019-04-16 10:15:04');
INSERT INTO `thesys_loginlog` VALUES (95, '超级管理员-system', '127.0.0.1', '2019-04-16 10:15:58');
INSERT INTO `thesys_loginlog` VALUES (96, '超级管理员-system', '127.0.0.1', '2019-04-16 10:28:14');
INSERT INTO `thesys_loginlog` VALUES (97, '超级管理员-system', '127.0.0.1', '2019-04-16 10:32:42');
INSERT INTO `thesys_loginlog` VALUES (98, '超级管理员-system', '127.0.0.1', '2019-04-16 10:33:03');
INSERT INTO `thesys_loginlog` VALUES (99, '超级管理员-system', '127.0.0.1', '2019-04-16 11:02:01');
INSERT INTO `thesys_loginlog` VALUES (100, '超级管理员-system', '127.0.0.1', '2019-04-16 11:03:09');
INSERT INTO `thesys_loginlog` VALUES (101, '超级管理员-system', '127.0.0.1', '2019-04-16 11:13:42');
INSERT INTO `thesys_loginlog` VALUES (102, '超级管理员-system', '127.0.0.1', '2019-04-16 11:24:55');
INSERT INTO `thesys_loginlog` VALUES (104, '超级管理员-system', '127.0.0.1', '2019-08-14 01:11:34');
INSERT INTO `thesys_loginlog` VALUES (105, '超级管理员-system', '127.0.0.1', '2019-08-14 01:24:03');
INSERT INTO `thesys_loginlog` VALUES (106, '李四-ls', '127.0.0.1', '2019-08-14 01:25:47');
INSERT INTO `thesys_loginlog` VALUES (107, '李四-ls', '127.0.0.1', '2019-08-14 01:26:41');
INSERT INTO `thesys_loginlog` VALUES (108, '孙七-sq', '127.0.0.1', '2019-08-14 01:28:22');
INSERT INTO `thesys_loginlog` VALUES (109, '刘八-lb', '127.0.0.1', '2019-08-14 01:28:32');
INSERT INTO `thesys_loginlog` VALUES (110, '超级管理员-system', '127.0.0.1', '2019-08-14 01:46:18');
INSERT INTO `thesys_loginlog` VALUES (111, '超级管理员-system', '127.0.0.1', '2019-08-14 02:18:44');
INSERT INTO `thesys_loginlog` VALUES (112, '超级管理员-system', '127.0.0.1', '2019-08-14 02:32:06');
INSERT INTO `thesys_loginlog` VALUES (113, '李四-ls', '127.0.0.1', '2019-08-14 03:00:19');
INSERT INTO `thesys_loginlog` VALUES (114, '李四-ls', '127.0.0.1', '2019-08-14 03:00:56');
INSERT INTO `thesys_loginlog` VALUES (115, '李四-ls', '127.0.0.1', '2019-08-14 03:01:31');
INSERT INTO `thesys_loginlog` VALUES (116, '李四-ls', '127.0.0.1', '2019-08-14 03:01:39');
INSERT INTO `thesys_loginlog` VALUES (117, '李四-ls', '127.0.0.1', '2019-08-14 03:02:25');
INSERT INTO `thesys_loginlog` VALUES (118, '李四-ls', '127.0.0.1', '2019-08-14 03:04:57');
INSERT INTO `thesys_loginlog` VALUES (119, '李四-ls', '127.0.0.1', '2019-08-14 03:07:19');
INSERT INTO `thesys_loginlog` VALUES (121, '超级管理员-system', '127.0.0.1', '2019-08-14 03:13:06');
INSERT INTO `thesys_loginlog` VALUES (123, '超级管理员-system', '127.0.0.1', '2019-08-14 06:03:47');
INSERT INTO `thesys_loginlog` VALUES (124, '超级管理员-system', '127.0.0.1', '2019-08-14 07:20:12');
INSERT INTO `thesys_loginlog` VALUES (125, '超级管理员-system', '127.0.0.1', '2019-08-14 07:23:05');
INSERT INTO `thesys_loginlog` VALUES (126, '超级管理员-system', '127.0.0.1', '2019-08-14 07:25:30');
INSERT INTO `thesys_loginlog` VALUES (127, '超级管理员-system', '127.0.0.1', '2019-08-14 07:26:34');
INSERT INTO `thesys_loginlog` VALUES (128, '超级管理员-system', '127.0.0.1', '2019-08-14 07:27:22');
INSERT INTO `thesys_loginlog` VALUES (129, '超级管理员-system', '127.0.0.1', '2019-08-14 07:27:51');
INSERT INTO `thesys_loginlog` VALUES (130, '超级管理员-system', '127.0.0.1', '2019-08-14 08:22:05');
INSERT INTO `thesys_loginlog` VALUES (131, '超级管理员-system', '127.0.0.1', '2019-08-14 08:43:53');
INSERT INTO `thesys_loginlog` VALUES (132, '超级管理员-system', '127.0.0.1', '2019-08-14 08:45:55');
INSERT INTO `thesys_loginlog` VALUES (133, '超级管理员-system', '127.0.0.1', '2019-08-14 08:47:13');
INSERT INTO `thesys_loginlog` VALUES (134, '超级管理员-system', '127.0.0.1', '2019-08-14 09:35:20');
INSERT INTO `thesys_loginlog` VALUES (135, '超级管理员-system', '127.0.0.1', '2019-08-14 09:41:02');
INSERT INTO `thesys_loginlog` VALUES (136, '超级管理员-system', '127.0.0.1', '2019-08-14 09:44:04');
INSERT INTO `thesys_loginlog` VALUES (137, '超级管理员-system', '127.0.0.1', '2019-08-14 09:50:27');
INSERT INTO `thesys_loginlog` VALUES (138, '超级管理员-system', '127.0.0.1', '2019-08-14 09:56:57');
INSERT INTO `thesys_loginlog` VALUES (139, '超级管理员-system', '127.0.0.1', '2019-08-14 09:59:02');
INSERT INTO `thesys_loginlog` VALUES (140, '超级管理员-system', '127.0.0.1', '2019-08-16 01:05:37');
INSERT INTO `thesys_loginlog` VALUES (141, '超级管理员-system', '127.0.0.1', '2019-08-16 02:01:44');
INSERT INTO `thesys_loginlog` VALUES (142, '超级管理员-system', '127.0.0.1', '2019-08-16 02:05:57');
INSERT INTO `thesys_loginlog` VALUES (143, '超级管理员-system', '127.0.0.1', '2019-08-16 02:07:04');
INSERT INTO `thesys_loginlog` VALUES (144, '超级管理员-system', '127.0.0.1', '2019-08-16 02:20:02');
INSERT INTO `thesys_loginlog` VALUES (145, '超级管理员-system', '127.0.0.1', '2019-08-16 02:20:20');
INSERT INTO `thesys_loginlog` VALUES (146, '超级管理员-system', '127.0.0.1', '2019-08-16 02:21:42');
INSERT INTO `thesys_loginlog` VALUES (147, '超级管理员-system', '127.0.0.1', '2019-08-16 03:37:37');
INSERT INTO `thesys_loginlog` VALUES (148, '超级管理员-system', '127.0.0.1', '2019-08-16 03:52:40');
INSERT INTO `thesys_loginlog` VALUES (149, '超级管理员-system', '127.0.0.1', '2019-08-16 03:59:37');
INSERT INTO `thesys_loginlog` VALUES (150, '超级管理员-system', '127.0.0.1', '2019-08-16 06:11:45');
INSERT INTO `thesys_loginlog` VALUES (151, '超级管理员-system', '127.0.0.1', '2019-08-16 06:23:27');
INSERT INTO `thesys_loginlog` VALUES (152, '超级管理员-system', '127.0.0.1', '2019-08-16 06:50:31');
INSERT INTO `thesys_loginlog` VALUES (153, '超级管理员-system', '127.0.0.1', '2019-08-16 06:54:49');
INSERT INTO `thesys_loginlog` VALUES (154, '超级管理员-system', '127.0.0.1', '2019-08-16 07:00:48');
INSERT INTO `thesys_loginlog` VALUES (155, '超级管理员-system', '127.0.0.1', '2019-08-16 07:01:18');
INSERT INTO `thesys_loginlog` VALUES (156, '超级管理员-system', '127.0.0.1', '2019-08-16 07:03:35');
INSERT INTO `thesys_loginlog` VALUES (157, '超级管理员-system', '127.0.0.1', '2019-08-16 07:09:55');
INSERT INTO `thesys_loginlog` VALUES (158, '超级管理员-system', '127.0.0.1', '2019-08-16 07:46:09');
INSERT INTO `thesys_loginlog` VALUES (159, '超级管理员-system', '127.0.0.1', '2019-08-16 08:17:59');
INSERT INTO `thesys_loginlog` VALUES (160, '超级管理员-system', '127.0.0.1', '2019-08-16 08:22:29');
INSERT INTO `thesys_loginlog` VALUES (161, '超级管理员-system', '127.0.0.1', '2019-08-16 08:23:32');
INSERT INTO `thesys_loginlog` VALUES (162, '超级管理员-system', '127.0.0.1', '2019-08-16 08:26:48');

-- ----------------------------
-- Table structure for thesys_notice
-- ----------------------------
DROP TABLE IF EXISTS `thesys_notice`;
CREATE TABLE `thesys_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `createtime` datetime(0) NULL DEFAULT NULL,
  `opername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thesys_notice
-- ----------------------------
INSERT INTO `thesys_notice` VALUES (1, '关于系统V1.3更新公告', '2', '2018-08-07 00:00:00', '管理员');
INSERT INTO `thesys_notice` VALUES (10, '关于系统V1.2更新公告', '12312312<img src=\"/resources/layui/images/face/42.gif\" alt=\"[抓狂]\">', '2018-08-07 00:00:00', '超级管理员');
INSERT INTO `thesys_notice` VALUES (11, '关于系统V1.1更新公告', '21321321321<img src=\"/resources/layui/images/face/18.gif\" alt=\"[右哼哼]\">', '2018-08-07 00:00:00', '超级管理员');
INSERT INTO `thesys_notice` VALUES (12, '123123', '12312321', '2020-02-23 14:44:11', '超级管理员');

-- ----------------------------
-- Table structure for thesys_permission
-- ----------------------------
DROP TABLE IF EXISTS `thesys_permission`;
CREATE TABLE `thesys_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限类型[menu/permission]',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `percode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编码[只有type= permission才有  user:view]',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `href` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open` int(11) NULL DEFAULT NULL,
  `ordernum` int(11) NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL COMMENT '状态【0不可用1可用】',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thesys_permission
-- ----------------------------
INSERT INTO `thesys_permission` VALUES (1, 0, 'menu', '机器学习后台管理系统', NULL, '&#xe68e;', '', '', 1, 1, 1);
INSERT INTO `thesys_permission` VALUES (2, 1, 'menu', '用户管理', NULL, '&#xe857;', '', '', 1, 2, 1);
INSERT INTO `thesys_permission` VALUES (3, 1, 'menu', '项目管理', NULL, '&#xe645;', '', NULL, 0, 3, 1);
INSERT INTO `thesys_permission` VALUES (4, 1, 'menu', '资源管理', NULL, '&#xe611;', '', '', 0, 4, 1);
INSERT INTO `thesys_permission` VALUES (5, 1, 'menu', '其他管理', NULL, '&#xe614;', '', '', 0, 5, 1);
INSERT INTO `thesys_permission` VALUES (6, 2, 'menu', '账号管理', NULL, '&#xe628;', '', '', 0, 6, 1);
INSERT INTO `thesys_permission` VALUES (7, 2, 'menu', '角色管理', NULL, '&#xe651;', '/bus/toCustomerManager', '', 0, 7, 1);
INSERT INTO `thesys_permission` VALUES (8, 2, 'menu', '权限管理', NULL, '&#xe658;', '/bus/toProviderManager', '', 0, 8, 1);
INSERT INTO `thesys_permission` VALUES (9, 3, 'menu', '项目一览', NULL, '&#xe657;', '/bus/toProjectManager', '', 0, 9, 1);
INSERT INTO `thesys_permission` VALUES (10, 3, 'menu', '模型管理', NULL, '&#xe756;', '/bus/toInportManager', '', 0, 10, 1);
INSERT INTO `thesys_permission` VALUES (11, 3, 'menu', '训练查询', NULL, '&#xe65a;', '/bus/toOutportManager', '', 0, 11, 1);
INSERT INTO `thesys_permission` VALUES (12, 3, 'menu', '识别查询', NULL, '&#xe65b;', '', '', 0, 12, 1);
INSERT INTO `thesys_permission` VALUES (13, 4, 'menu', '主机管理', NULL, '&#xe770;', '', '', 0, 13, 1);
INSERT INTO `thesys_permission` VALUES (14, 4, 'menu', '其他资源1', NULL, '&#xe770;', '/sys/toDeptManager', '', 0, 14, 1);
INSERT INTO `thesys_permission` VALUES (15, 4, 'menu', '其他资源2', NULL, '&#xe857;', '/sys/toMenuManager', '', 0, 15, 1);
INSERT INTO `thesys_permission` VALUES (16, 5, 'menu', '登陆日志', '', '&#xe857;', '/sys/toLoginfoManager', '', 0, 16, 1);
INSERT INTO `thesys_permission` VALUES (17, 5, 'menu', '系统公告', '', '&#xe650;', '/sys/toNoticeManager', '', 0, 17, 1);
INSERT INTO `thesys_permission` VALUES (18, 5, 'menu', '项目日志', '', '&#xe612;', '/sys/toUserManager', '', 0, 18, 1);
INSERT INTO `thesys_permission` VALUES (21, 6, 'permission', '登陆日志', NULL, '&#xe675;', '/sys/toLoginfoManager', '', 0, 21, 1);
INSERT INTO `thesys_permission` VALUES (22, 6, 'permission', '系统公告', NULL, '&#xe756;', '/sys/toNoticeManager', NULL, 0, 22, 1);
INSERT INTO `thesys_permission` VALUES (23, 6, 'permission', '图标管理', NULL, '&#xe670;', '../resources/page/icon.html', NULL, 0, 23, 1);
INSERT INTO `thesys_permission` VALUES (30, 14, 'permission', '添加部门', 'dept:create', '', NULL, NULL, 0, 24, 1);
INSERT INTO `thesys_permission` VALUES (31, 14, 'permission', '修改部门', 'dept:update', '', NULL, NULL, 0, 26, 1);
INSERT INTO `thesys_permission` VALUES (32, 14, 'permission', '删除部门', 'dept:delete', '', NULL, NULL, 0, 27, 1);
INSERT INTO `thesys_permission` VALUES (34, 15, 'permission', '添加菜单', 'menu:create', '', '', '', 0, 29, 1);
INSERT INTO `thesys_permission` VALUES (35, 15, 'permission', '修改菜单', 'menu:update', '', NULL, NULL, 0, 30, 1);
INSERT INTO `thesys_permission` VALUES (36, 15, 'permission', '删除菜单', 'menu:delete', '', NULL, NULL, 0, 31, 1);
INSERT INTO `thesys_permission` VALUES (38, 16, 'permission', '添加权限', 'permission:create', '', NULL, NULL, 0, 33, 1);
INSERT INTO `thesys_permission` VALUES (39, 16, 'permission', '修改权限', 'permission:update', '', NULL, NULL, 0, 34, 1);
INSERT INTO `thesys_permission` VALUES (40, 16, 'permission', '删除权限', 'permission:delete', '', NULL, NULL, 0, 35, 1);
INSERT INTO `thesys_permission` VALUES (42, 17, 'permission', '添加角色', 'role:create', '', NULL, NULL, 0, 37, 1);
INSERT INTO `thesys_permission` VALUES (43, 17, 'permission', '修改角色', 'role:update', '', NULL, NULL, 0, 38, 1);
INSERT INTO `thesys_permission` VALUES (44, 17, 'permission', '角色删除', 'role:delete', '', NULL, NULL, 0, 39, 1);
INSERT INTO `thesys_permission` VALUES (46, 17, 'permission', '分配权限', 'role:selectPermission', '', NULL, NULL, 0, 41, 1);
INSERT INTO `thesys_permission` VALUES (47, 18, 'permission', '添加用户', 'user:create', '', NULL, NULL, 0, 42, 1);
INSERT INTO `thesys_permission` VALUES (48, 18, 'permission', '修改用户', 'user:update', '', NULL, NULL, 0, 43, 1);
INSERT INTO `thesys_permission` VALUES (49, 18, 'permission', '删除用户', 'user:delete', '', NULL, NULL, 0, 44, 1);
INSERT INTO `thesys_permission` VALUES (51, 18, 'permission', '用户分配角色', 'user:selectRole', '', NULL, NULL, 0, 46, 1);
INSERT INTO `thesys_permission` VALUES (52, 18, 'permission', '重置密码', 'user:resetPwd', NULL, NULL, NULL, 0, 47, 1);
INSERT INTO `thesys_permission` VALUES (53, 14, 'permission', '部门查询', 'dept:view', NULL, NULL, NULL, 0, 48, 1);
INSERT INTO `thesys_permission` VALUES (54, 15, 'permission', '菜单查询', 'menu:view', NULL, NULL, NULL, 0, 49, 1);
INSERT INTO `thesys_permission` VALUES (55, 16, 'permission', '权限查询', 'permission:view', NULL, NULL, NULL, 0, 50, 1);
INSERT INTO `thesys_permission` VALUES (56, 17, 'permission', '角色查询', 'role:view', NULL, NULL, NULL, 0, 51, 1);
INSERT INTO `thesys_permission` VALUES (57, 18, 'permission', '用户查询', 'user:view', NULL, NULL, NULL, 0, 52, 1);
INSERT INTO `thesys_permission` VALUES (68, 7, 'permission', '客户查询', 'customer:view', NULL, NULL, NULL, NULL, 60, 1);
INSERT INTO `thesys_permission` VALUES (69, 7, 'permission', '客户添加', 'customer:create', NULL, NULL, NULL, NULL, 61, 1);
INSERT INTO `thesys_permission` VALUES (70, 7, 'permission', '客户修改', 'customer:update', NULL, NULL, NULL, NULL, 62, 1);
INSERT INTO `thesys_permission` VALUES (71, 7, 'permission', '客户删除', 'customer:delete', NULL, NULL, NULL, NULL, 63, 1);
INSERT INTO `thesys_permission` VALUES (73, 21, 'permission', '日志查询', 'info:view', NULL, NULL, NULL, NULL, 65, 1);
INSERT INTO `thesys_permission` VALUES (74, 21, 'permission', '日志删除', 'info:delete', NULL, NULL, NULL, NULL, 66, 1);
INSERT INTO `thesys_permission` VALUES (75, 21, 'permission', '日志批量删除', 'info:batchdelete', NULL, NULL, NULL, NULL, 67, 1);
INSERT INTO `thesys_permission` VALUES (76, 22, 'permission', '公告查询', 'notice:view', NULL, NULL, NULL, NULL, 68, 1);
INSERT INTO `thesys_permission` VALUES (77, 22, 'permission', '公告添加', 'notice:create', NULL, NULL, NULL, NULL, 69, 1);
INSERT INTO `thesys_permission` VALUES (78, 22, 'permission', '公告修改', 'notice:update', NULL, NULL, NULL, NULL, 70, 1);
INSERT INTO `thesys_permission` VALUES (79, 22, 'permission', '公告删除', 'notice:delete', NULL, NULL, NULL, NULL, 71, 1);
INSERT INTO `thesys_permission` VALUES (81, 8, 'permission', '供应商查询', 'provider:view', NULL, NULL, NULL, NULL, 73, 1);
INSERT INTO `thesys_permission` VALUES (82, 8, 'permission', '供应商添加', 'provider:create', NULL, NULL, NULL, NULL, 74, 1);
INSERT INTO `thesys_permission` VALUES (83, 8, 'permission', '供应商修改', 'provider:update', NULL, NULL, NULL, NULL, 75, 1);
INSERT INTO `thesys_permission` VALUES (84, 8, 'permission', '供应商删除', 'provider:delete', NULL, NULL, NULL, NULL, 76, 1);
INSERT INTO `thesys_permission` VALUES (86, 22, 'permission', '公告查看', 'notice:viewnotice', NULL, NULL, NULL, NULL, 78, 1);
INSERT INTO `thesys_permission` VALUES (91, 9, 'permission', '商品查询', 'goods:view', NULL, NULL, NULL, 0, 79, 1);
INSERT INTO `thesys_permission` VALUES (92, 9, 'permission', '商品添加', 'goods:create', NULL, NULL, NULL, 0, 80, 1);

-- ----------------------------
-- Table structure for thesys_project
-- ----------------------------
DROP TABLE IF EXISTS `thesys_project`;
CREATE TABLE `thesys_project`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` int(11) NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `open` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT NULL COMMENT '状态【0不可用1可用】',
  `ordernum` int(11) NULL DEFAULT NULL COMMENT '排序码【为了调事显示顺序】',
  `createtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thesys_project
-- ----------------------------
INSERT INTO `thesys_project` VALUES (1, 0, '项目总览', 1, '大BOSS', '深圳', 1, 1, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (2, 1, '回归任务', 1, '程序员屌丝', '武汉', 1, 2, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (3, 1, '分类任务', 1, '无', '武汉', 1, 3, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (4, 1, '异常检测', 0, '无', '武汉', 1, 4, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (5, 1, '聚类问题', 0, '销售一部', '武汉', 1, 5, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (6, 1, '数据降维', 0, '销售二部', '武汉', 1, 6, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (7, 2, '回归问题1', 0, '运营一部', '武汉', 1, 7, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (8, 3, '分类问题1', 0, '销售三部', '11', 1, 8, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (9, 4, '异常检测1', 0, '销售四部', '222', 1, 9, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (10, 5, '聚类问题1', 0, '销售五部', '33', 1, 10, '2019-04-10 14:06:32');
INSERT INTO `thesys_project` VALUES (11, 6, '数据降维1', 0, '生产食品', '武汉', 1, 11, '2019-04-13 09:49:38');
INSERT INTO `thesys_project` VALUES (19, NULL, 'wf123', 1, '123', NULL, NULL, 123, '2020-02-23 14:41:12');
INSERT INTO `thesys_project` VALUES (20, NULL, '312312', 1, '3123', NULL, NULL, 3213, '2020-02-23 14:51:35');

-- ----------------------------
-- Table structure for thesys_user
-- ----------------------------
DROP TABLE IF EXISTS `thesys_user`;
CREATE TABLE `thesys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loginname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` int(11) NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `deptid` int(11) NULL DEFAULT NULL,
  `hiredate` date NULL DEFAULT NULL,
  `mgr` int(11) NULL DEFAULT NULL,
  `available` int(11) NULL DEFAULT 1,
  `ordernum` int(11) NULL DEFAULT NULL,
  `type` int(255) NULL DEFAULT NULL COMMENT '用户类型[0超级管理员1，管理员，2普通用户]',
  `imgpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK_3rrcpvho2w1mx1sfiuuyir1h`(`deptid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of thesys_user
-- ----------------------------
INSERT INTO `thesys_user` VALUES (1, '超级管理员', 'wf123', '系统深处的男人', 1, '超级管理员', 'e10adc3949ba59abbe56e057f20f883e', 1, '2018-06-25', NULL, 1, 1, 0, '../resources/images/defaultusertitle.jpg', '04A93C74C8294AA09A8B974FD1F4ECBB');
INSERT INTO `thesys_user` VALUES (2, '李四', 'ls', '武汉', 0, 'KING', 'b07b848d69e0553b80e601d31571797e', 1, '2018-06-25', NULL, 1, 2, 1, '../resources/images/defaultusertitle.jpg', 'FC1EE06AE4354D3FBF7FDD15C8FCDA71');
INSERT INTO `thesys_user` VALUES (3, '王五', 'ww', '武汉', 1, '管理员', '3c3f971eae61e097f59d52360323f1c8', 3, '2018-06-25', 2, 1, 3, 1, '../resources/images/defaultusertitle.jpg', '3D5F956E053C4E85B7D2681386E235D2');
INSERT INTO `thesys_user` VALUES (4, '赵六', 'zl', '武汉', 1, '程序员', '2e969742a7ea0c7376e9551d578e05dd', 4, '2018-06-25', 3, 1, 4, 1, '../resources/images/defaultusertitle.jpg', '6480EE1391E34B0886ACADA501E31145');
INSERT INTO `thesys_user` VALUES (5, '孙七', 'sq', '武汉', 1, '程序员', '47b4c1ad6e4b54dd9387a09cb5a03de1', 2, '2018-06-25', 4, 1, 5, 1, '../resources/images/defaultusertitle.jpg', 'FE3476C3E3674E5690C737C269FCBF8E');
INSERT INTO `thesys_user` VALUES (6, '刘八', 'lb', '深圳', 1, '程序员', 'bcee2b05b4b591106829aec69a094806', 4, '2018-08-06', 3, 1, 6, 1, '../resources/images/defaultusertitle.jpg', 'E6CCF54A09894D998225878BBD139B20');

SET FOREIGN_KEY_CHECKS = 1;
