/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : totan

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 08/06/2023 17:27:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mongo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `owner` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `last` datetime NULL DEFAULT NULL,
  `first` datetime NULL DEFAULT NULL,
  `tags` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('048852e784244d409cba0687cf89955c', 'giao', '#                              在这里编辑你的帖子正文', 'post048852e784244d409cba0687cf89955c', NULL, 'tyza66', '2023-06-08 09:09:00', '2023-06-08 09:09:00', 'giaogiao');
INSERT INTO `post` VALUES ('c428f773f9e84877a749c3fcf5287c34', '家人们家人们', '#                              在这里编辑你的帖子正文', 'postc428f773f9e84877a749c3fcf5287c34', NULL, 'tyza66', '2023-06-08 08:49:15', '2023-06-08 08:49:15', '家人们');
INSERT INTO `post` VALUES ('fc7de87740d546e780449c0557c89d7f', '666', '#                              在这里编辑你的帖子正文', 'postfc7de87740d546e780449c0557c89d7f', NULL, 'tyza66', '2023-06-08 08:49:44', '2023-06-08 08:49:44', '666');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL,
  `power` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (-1723842559, 'xxx', 'b60d121b438a380c343d5ec3c2037564b82ffef3', 0, '2');
INSERT INTO `user` VALUES (-910073854, 'tyza661', 'a03a7be3c4c7bbab242638969f735c2fef61b4a5', 0, '2');
INSERT INTO `user` VALUES (9, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 0, '0');
INSERT INTO `user` VALUES (10, 'tyza66', '7132f04074c4b8955383155cda268c45850b56cc', 0, '0');

SET FOREIGN_KEY_CHECKS = 1;
