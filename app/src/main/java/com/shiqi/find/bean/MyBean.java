package com.shiqi.find.bean;

import com.shiqi.find.entity.User;

import java.util.Map;

/**
 * Author:ShiQi
 * Date:2020/4/14-14:32
 * 我的（头像 昵称 简介，问题 文章，浏览记录）info（icon name bio）
 */
public class MyBean {
    Long nowTime=System.currentTimeMillis();
    private User testUser=new User("a","a","十七","icon","简介","token",nowTime,nowTime);

}
