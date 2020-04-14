package com.shiqi.find.page;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.shiqi.find.R;
import com.shiqi.find.activity.MainActivity;
import com.shiqi.find.base.BasePager;
import com.shiqi.find.base.MenuDetailBasePage;
import com.shiqi.find.bean.IndexDataBean;
import com.shiqi.find.fragment.LeftMenuFragment;
import com.shiqi.find.menu.CollectionPage;
import com.shiqi.find.menu.FollowPage;
import com.shiqi.find.menu.MessagePage;
import com.shiqi.find.menu.MyPage;
import com.shiqi.find.util.Contants;
import com.shiqi.find.util.LogUtil;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:ShiQi
 * Date:2020/4/11-4:26
 * 主页
 */
public class IndexPage extends BasePager {
    public IndexPage(Context context) {
        super(context);
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("主页被初始化");
        ib_menu.setVisibility(View.VISIBLE);
        //设置标题
        tv_title.setText("搜索框 图标");
        //联网请求，得到数据，创建视图
        TextView textView = new TextView(context);
        textView.setTextColor((Color.BLUE));
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        //添加到basePage的Fragment中
        fl_content.addView(textView);
        //绑定数据
        textView.setText("主页面内容");

        //联网请求数据（暂定）
//        getDataFromNet();
        processData(true);
    }

    //使用xUtils3联网请求数据
    private void getDataFromNet() {
        RequestParams params = new RequestParams(Contants.OTHER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LogUtil.e("使用xUtils3联网请求成功，" + result);
//                processData(result);
                //适配器
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("使用xUtils3联网请求失败，" + ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("使用xUtils3-onCancelled," + cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("使用xUtils3-onFinished");
            }
        });
    }

    //显示数据
    private void processData(Boolean isLogin) {

        String title = IndexDataBean.TRUE_MENU.get(0).getTitle();
        LogUtil.e("解析menu数据" + title);
        if (isLogin) {
            leftBeans = IndexDataBean.TRUE_MENU;
        } else {
            leftBeans = IndexDataBean.FALSE_MENU;
        }
        MainActivity mainActivity = (MainActivity) context;
        LeftMenuFragment leftMenuFragment = mainActivity.getLeftMenuFragment();

        //详情页面
        detailBasePages = new ArrayList<>();
        if (isLogin) {
            detailBasePages.add(new MyPage(context));
            detailBasePages.add(new MessagePage(context));
            detailBasePages.add(new CollectionPage(context));
            detailBasePages.add(new FollowPage(context));
        }
        //向左侧菜单传递数据（放到集合上面会出现空指针异常）
        leftMenuFragment.setData(leftBeans);

    }

    //根据位置切换详情页面
    public void switchPage(int position) {
        //移除之前的内容
        fl_content.removeAllViews();
        //添加新的内容
        MenuDetailBasePage detailBasePage = detailBasePages.get(position);
        View rootView = detailBasePage.rootView;
        detailBasePage.initData();//初始化数据
        fl_content.addView(rootView);
    }
}
