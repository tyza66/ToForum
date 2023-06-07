/*
 Navicat Premium Data Transfer

 Source Server         : mongo
 Source Server Type    : MongoDB
 Source Server Version : 40422
 Source Host           : localhost:27017
 Source Schema         : totan

 Target Server Type    : MongoDB
 Target Server Version : 40422
 File Encoding         : 65001

 Date: 07/06/2023 19:20:16
*/


// ----------------------------
// Collection structure for post1
// ----------------------------
db.getCollection("post1").drop();
db.createCollection("post1");

// ----------------------------
// Documents of post1
// ----------------------------
db.getCollection("post1").insert([ {
    _id: "",
    title: "",
    description: "",
    status: "",
    owner: "",
    last: "",
    first: "",
    tags: "",
    in: "",
    collectionName: "post1",
    _class: "com.tyza66.toforum.pojo.PostStract"
} ]);
