package com.shiqi.find.util;

import android.content.Context;

/**
 * Author:ShiQi
 * Date:2020/4/10-0:02
 * 单位转换工具，用于适配各种屏幕
 */
public class DensityUtil {
    //依据手机的分辨率从dip的单位转为px（像素）
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    //根据手机分辨率从px转dp
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
