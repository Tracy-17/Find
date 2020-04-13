package com.shiqi.find.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

/**
 * Author:ShiQi
 * Date:2020/4/13-13:01
 * 自定义viewPager去掉滑动效果
 */
public class NoScrollViewPager extends ViewPager {
    //代码实例化时使用
    public NoScrollViewPager(Context context){
        super(context);
    }
    //布局文件中使用该类时，实例化该类用此构造方法。没有此方法会系统崩溃
    //（系统规定布局文件中使用某一控件必须用带有两个参数的构造方法
    public NoScrollViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    //修改触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return true;
    }
}
