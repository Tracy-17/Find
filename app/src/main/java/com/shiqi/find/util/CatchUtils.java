package com.shiqi.find.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author:ShiQi
 * Date:2020/4/8-21:28
 * 缓存软件参数和数据
 */
public class CatchUtils {
    //通过上下文和key得到缓存值
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp=context.getSharedPreferences("catch",Context.MODE_PRIVATE);
        return sp.getBoolean(key,false);
    }
    //保存软件参数
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp=context.getSharedPreferences("catch",Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }
}
