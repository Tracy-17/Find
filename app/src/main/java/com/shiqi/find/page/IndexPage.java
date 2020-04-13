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
import com.shiqi.find.data.IndexDataBean;
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
        TextView textView=new TextView(context);
        textView.setTextColor((Color.BLUE));
        textView.setTextSize(25);
        textView.setGravity(Gravity.CENTER);
        //添加到basePage的Fragment中
        fl_content.addView(textView);
        //绑定数据
        textView.setText("主页面内容");

        //联网请求数据（暂定）
        getDataFromNet();
    }
    //使用xUtils3联网请求数据
    private void getDataFromNet() {
        RequestParams params=new RequestParams(Contants.OTHER_URL);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                LogUtil.e("使用xUtils3联网请求成功，"+result);
                processData(result);
                //适配器
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                LogUtil.e("使用xUtils3联网请求失败，"+ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {
                LogUtil.e("使用xUtils3-onCancelled,"+cex.getMessage());
            }

            @Override
            public void onFinished() {
                LogUtil.e("使用xUtils3-onFinished");
            }
        });
    }
    //显示数据
    private void processData(Boolean isLogin) {

        MainActivity mainActivity=(MainActivity)context;
        IndexDataBean leftBean=new IndexDataBean(1,"我的", R.drawable.leftmenu_info_selector);
        Boolean data=true;//虚假资料

        LeftMenuFragment leftMenuFragment=mainActivity.getLeftMenuFragment();
        detailBasePages =new ArrayList<>();
        //详情页面
        if(isLogin){
            detailBasePages.add(new MyPage(context));
            detailBasePages.add(new MessagePage(context));
            detailBasePages.add(new CollectionPage(context));
            detailBasePages.add(new FollowPage(context));
        }
        leftMenuFragment.setData(data);


    }
}
