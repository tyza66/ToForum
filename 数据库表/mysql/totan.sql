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

 Date: 07/06/2023 19:19:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int NOT NULL AUTO_INCREMENT,
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
INSERT INTO `post` VALUES (1, '家人们谁懂啊', '', 'post1', '2', 'tyza66', '2023-06-06 00:00:00', '2023-06-06 00:00:00', '#绝 #搞笑');
INSERT INTO `post` VALUES (2, '竟然有这种人', '', 'post2', '2', 'tyza66', '2023-06-06 00:00:00', '2023-06-06 00:00:00', '#绝 #社会现象');
INSERT INTO `post` VALUES (3, '这根本就是形式主义', '', 'post3', '2', 'tyza66', '2023-06-06 00:00:00', '2023-06-06 00:00:00', '#绝 #社会现象');
INSERT INTO `post` VALUES (4, '完了完了 堵死了 上班已经迟到', '', 'post4', '2', 'tyza66', '2023-06-06 00:00:00', '2023-06-06 00:00:00', '#绝 #交通');
INSERT INTO `post` VALUES (5, '这种现象绝了', NULL, 'post5', '2', 'tyza66', '2023-06-06 17:13:42', '2023-06-06 17:13:35', '#惊了');
INSERT INTO `post` VALUES (6, '怎么理解懂的都懂', NULL, 'post6', '2', 'tyza66', '2023-06-06 17:15:09', '2023-06-06 17:15:12', '#6');
INSERT INTO `post` VALUES (7, '怎么理解6', NULL, 'post7', '2', 'tyza66', '2023-06-06 17:15:09', '2023-06-06 17:15:12', '#6');
INSERT INTO `post` VALUES (8, '怎么理解96', NULL, 'post8', '2', 'tyza66', '2023-06-06 17:15:09', '2023-06-06 17:15:12', '#6');
INSERT INTO `post` VALUES (9, '怎么理解好玩', NULL, 'post9', '2', 'tyza66', '2023-06-06 17:15:09', '2023-06-06 17:15:12', '#6');
INSERT INTO `post` VALUES (10, '怎么理解666', NULL, 'post10', '2', 'tyza66', '2023-06-06 17:15:09', '2023-06-06 17:15:12', '#6');
INSERT INTO `post` VALUES (11, '怎么理解xx', NULL, 'post11', '2', 'tyza66', '2023-06-06 17:15:09', '2023-06-06 17:15:12', '#6');

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
INSERT INTO `user` VALUES (-910073854, 'tyza661', 'a03a7be3c4c7bbab242638969f735c2fef61b4a5', 0, '2');
INSERT INTO `user` VALUES (9, 'admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 0, '0');
INSERT INTO `user` VALUES (10, 'tyza66', '7132f04074c4b8955383155cda268c45850b56cc', 0, '0');

SET FOREIGN_KEY_CHECKS = 1;
