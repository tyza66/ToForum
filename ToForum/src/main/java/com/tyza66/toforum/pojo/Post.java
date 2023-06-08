package com.tyza66.toforum.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Author: tyza66
 * Date: 2023/6/6 15:24
 * Github: https://github.com/tyza66
 **/

@Data
public class Post {
    String id;
    String title;
    String description;
    String mongo;
    String status;
    String owner;
    Timestamp last;
    Timestamp first;
    String tags;
}
