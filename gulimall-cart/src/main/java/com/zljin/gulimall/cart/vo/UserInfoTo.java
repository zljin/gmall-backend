package com.zljin.gulimall.cart.vo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class UserInfoTo {

    private Long userId;
    private String userKey; //一定封装

    private boolean tempUser = false;
}
