package com.shiqi.find;

import android.app.Application;
import org.xutils.x;

/**
 * Author:ShiQi
 * Date:2020/4/11-2:53
 * 程序入口
 */
public class FindApplication extends Application {
    // xUtils3在application的onCreate中初始化
    /*
    * 所有组件被创建之前执行
    * */
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志, 开启debug会影响性能.
    }
}
