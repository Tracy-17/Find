package com.shiqi.find.page;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.shiqi.find.base.BasePager;
import com.shiqi.find.util.LogUtil;

/**
 * Author:ShiQi
 * Date:2020/4/13-12:08
 * 文章
 */
public class ArticlePage extends BasePager {
    public ArticlePage(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("文章页面被初始化");
        //设置标题
        tv_title.setText("按热度（浏览+评论+赞）/时间切换\t搜索框 图标  \t发布图标");
        //联网请求，得到数据，创建视图
        TextView textView=new TextView(context);
        textView.setTextColor((Color.BLUE));
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        //添加到basePage的Fragment中
        fl_content.addView(textView);
        //绑定数据
        textView.setText("文章内容");
    }
}
