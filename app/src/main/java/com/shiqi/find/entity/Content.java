package com.shiqi.find.entity;

/**
 * Author:ShiQi
 * Date:2020/4/14-15:26
 * 内容
 * 标题、正文、标签
 * 创建人
 * 观看、点赞、评论、收藏数
 * 创建、修改时间
 */
public class Content {

    private String title;
    private String description;
    private String tag;

    private int creator;

    private int viewCount;
    private int likeCount;
    private int commentCount;
    private int colCount;

    private long gmtCreate;
    private long gmtModify;

    public Content() {
    }

    public Content(String title, String description, String tag, int creator, int viewCount, int likeCount, int commentCount, int colCount, long gmtCreate, long gmtModify) {
        this.title = title;
        this.description = description;
        this.tag = tag;
        this.creator = creator;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.colCount = colCount;
        this.gmtCreate = gmtCreate;
        this.gmtModify = gmtModify;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getColCount() {
        return colCount;
    }

    public void setColCount(int colCount) {
        this.colCount = colCount;
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
