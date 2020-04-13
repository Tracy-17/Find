package com.shiqi.find.data;

import android.graphics.drawable.Drawable;

/**
 * Author:ShiQi
 * Date:2020/4/13-17:21
 * 首页解析后对应的数据
 */
public class LeftBean {
    //自动解析的json数据：
    String title;
    int icon;

    public LeftBean(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}