package com.tyza66.toforum.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * Author: tyza66
 * Date: 2023/6/6 19:27
 * Github: https://github.com/tyza66
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostStract {
    String id;
    String title;
    String description;
    String status;
    String owner;
    Timestamp last;
    Timestamp first;
    String tags;
    String in;
    String collectionName;
}
