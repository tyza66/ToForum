package com.tyza66.toforum.pojo;

import lombok.Data;

import java.sql.Date;

/**
 * Author: tyza66
 * Date: 2023/6/6 15:24
 * Github: https://github.com/tyza66
 **/

@Data
public class Post {
    Integer id;
    String title;
    String description;
    String mongo;
    String status;
    String owner;
    Date last;
    Date first;
    String tags;
}
