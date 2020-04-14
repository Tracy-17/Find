package com.shiqi.find.entity;

/**
 * Author:ShiQi
 * Date:2020/4/14-15:21
 * 收藏
 * 收藏人、收藏内容
 */
public class Collection {
    private int userId;
    private int contentId;


    public Collection(int userId, int contentId) {
        this.userId = userId;
        this.contentId = contentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }
}
