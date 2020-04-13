package com.shiqi.find.menu;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.shiqi.find.base.MenuDetailBasePage;
import com.shiqi.find.util.LogUtil;

/**
 * Author:ShiQi
 * Date:2020/4/14-0:26
 * 被评论/点赞/回答/关注消息
 */
public class MsgPage extends MenuDetailBasePage {
    private TextView textView;

    public MsgPage(Context context) {
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
        LogUtil.e("消息页被初始化了");
        textView.setText("消息");
    }
}
