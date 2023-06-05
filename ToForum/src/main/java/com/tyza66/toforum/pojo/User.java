package com.tyza66.toforum.pojo;

import lombok.Data;

/**
 * Author: tyza66
 * Date: 2023/6/5 16:21
 * Github: https://github.com/tyza66
 **/

@Data
public class User {
    Integer id;
    String username;
    String password;
    String status;
    String power;
}
