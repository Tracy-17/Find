package com.shiqi.find.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.shiqi.find.base.BasePager;

import java.util.ArrayList;

/**
 * Author:ShiQi
 * Date:2020/4/13-16:08
 * 适配器
 */
public class ContentFragmentAdapter extends PagerAdapter {

    private final ArrayList<BasePager> basePagers;

    public ContentFragmentAdapter(ArrayList<BasePager> basePagers) {
        this.basePagers=basePagers;
    }

    //页面总数
    @Override
    public int getCount() {
        return basePagers.size();
    }

    //
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        //各个页面的实例
        BasePager basePager = basePagers.get(position);
        View rootView = basePager.rootView;
        //调用各个页面的initData()初始化数据
        //修改为切换到某一页面时初始化数据
//            basePager.initData();
        //添加到容器
        container.addView(rootView);
        return rootView;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
