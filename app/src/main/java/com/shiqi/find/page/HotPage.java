package com.shiqi.find.page;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.shiqi.find.base.BasePager;
import com.shiqi.find.util.LogUtil;

/**
 * Author:ShiQi
 * Date:2020/4/13-12:03
 * 热门
 */
public class HotPage extends BasePager {
    public HotPage(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("热门页面被初始化");
        //设置标题
        tv_title.setText("三天 一周 一月");
        //联网请求，得到数据，创建视图
        TextView textView=new TextView(context);
        textView.setTextColor((Color.BLUE));
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        //添加到basePage的Fragment中
        fl_content.addView(textView);
        //绑定数据
        textView.setText("热门内容");
    }
}
