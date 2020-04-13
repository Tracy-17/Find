package com.shiqi.find.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Author:ShiQi
 * Date:2020/4/10-3:13
 * 基本Fragment
 * *只要有一个抽象方法，就变成抽象类
 */
public abstract class BaseFragment extends Fragment {

    public Activity activity;//最终要绑定至MainActivity

    //fragment创建时
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity =getActivity();
    }
    //视图创建时
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }
    //让子类实现自己的视图效果
    public abstract View initView();

    //activity创建后
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    //作用：若页面无数据，可联网请求并绑定至initView初始化的视图；有数据直接绑定（写成抽象是强迫实现）
    public void initData(){}
}
