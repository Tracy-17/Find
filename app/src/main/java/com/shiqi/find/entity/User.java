package com.shiqi.find.entity;

import java.util.Map;

/**
 * Author:ShiQi
 * Date:2020/4/14-14:34
 * 用户
 * 注册资料：用户名、密码
 * 个人资料：昵称、头像、简介
 * 内容：*浏览记录（最近10条，用varchar存储）
 * *关注列表、粉丝列表
 * 缓存数据、注册时间、数据修改时间等
 */
public class User {

    private String uid;
    private String password;

    private String name;
    private String icon;
    private String bio;

    //浏览的内容id和浏览时间
//    private Map<Integer,Long> viewedArticle;
//    private Map<Integer,Long> viewedQuestion;

    private String token;
    private long gmtCreate;
    private long gmtModify;

    //创建
    public User(String uid, String password, String token, Long gmtCreate) {
        this.uid = uid;
        this.password = password;
        this.token = token;
        this.gmtCreate = gmtCreate;
    }
    public User(String uid, String password, String name, String icon, String bio,String token, Long gmtCreate, Long gmtModify) {
        this.uid = uid;
        this.password = password;
        this.name = name;
        this.icon = icon;
        this.bio = bio;

        this.token = token;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public long getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(long gmtModify) {
        this.gmtModify = gmtModify;
    }
}
