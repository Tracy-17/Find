package com.shiqi.find.base;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.shiqi.find.R;
import com.shiqi.find.activity.MainActivity;

/**
 * Author:ShiQi
 * Date:2020/4/11-3:45
 * 顶栏、主要页面内容
 * 公共类，线性布局包裹相对布局和帧布局，动态切换子类布局
 */
public class BasePager {
    //上下文MainActivity
    public final Context context;
    //视图，代表各个不同的页面
    public View rootView;
    //显示标题
    public TextView tv_title;
    //侧边栏图标
    public ImageButton ib_menu;
    //发布图标
    public ImageButton ib_push;
    //加载各个子页面
    public FrameLayout fl_content;

    public BasePager(Context context){
        this.context=context;
        rootView=initView();
    }
    //初始化公共部分视图，并且初始化加载子视图的FragmentLayout
    private View initView() {
        //基类页面：
        View view=View.inflate(context, R.layout.base_page,null);
        //初始化：
        tv_title=view.findViewById(R.id.tv_title);
        ib_menu=view.findViewById(R.id.ib_menu);
        ib_push=view.findViewById(R.id.ib_push);
        fl_content=view.findViewById(R.id.fl_content);

        //点击事件：
        ib_menu.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= (MainActivity) context;
                mainActivity.getSlidingMenu().toggle();
            }
        });
        return view;
    }
    //初始化数据；当子类需要初始化数据或者绑定数据；联网请求数据并绑定时，重写此方法
    public void initData(){

    }
}
