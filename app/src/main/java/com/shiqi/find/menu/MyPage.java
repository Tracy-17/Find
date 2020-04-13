package com.shiqi.find.menu;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.shiqi.find.base.MenuDetailBasePage;
import com.shiqi.find.util.LogUtil;

/**
 * Author:ShiQi
 * Date:2020/4/14-0:26
 * 显示个人资料；发布的问题、文章；浏览记录
 */
public class InfoPage extends MenuDetailBasePage {
    private TextView textView;

    public InfoPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor((Color.BLUE));
        textView.setTextSize(25);
        return textView;
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("资料页被初始化了");
        textView.setText("资料");
    }
}
