package com.shiqi.find.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.shiqi.find.R;
import com.shiqi.find.activity.MainActivity;
import com.shiqi.find.base.BaseFragment;
import com.shiqi.find.bean.IndexDataBean;
import com.shiqi.find.page.IndexPage;
import com.shiqi.find.util.DensityUtil;
import com.shiqi.find.util.LogUtil;


import java.util.List;

/**
 * Author:ShiQi
 * Date:2020/4/10-3:13
 * 左侧菜单
 */
public class LeftMenuFragment extends BaseFragment {
    private List<IndexDataBean.LeftBean> data;
    private LeftMenuFragmentAdapter adapter;
    private ListView listView;
    //上一次点击的位置（默认0）
    private int prePosition;

    @Override
    public View initView() {
        LogUtil.e("左侧菜单视图初始化");
        listView = new ListView(activity);
        listView.setPadding(0, DensityUtil.dip2px(activity, 40), 0, 0);
        //设置分割线高度为0（不出现）
        listView.setDividerHeight(0);
        //按下listView为透明
        listView.setCacheColorHint(Color.TRANSPARENT);
        //设置按下的listView的item不变色（默认变色？）
        listView.setSelector(android.R.color.transparent);

        //设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //记录点的位置
                prePosition=position;
                adapter.notifyDataSetChanged();
                //关闭左侧菜单
                MainActivity mainActivity= (MainActivity) activity;
                mainActivity.getSlidingMenu().toggle();
                //切换到对应的详情页面：资料，消息，收藏，关注，注销
                switchPager(prePosition);

            }
        });
        return listView;
    }

    //根据位置切换不同的详情页面
    private void switchPager(int position) {
        MainActivity mainActivity= (MainActivity) activity;
        ContentFragment ct=mainActivity.getContentFragment();
        IndexPage indexPage=ct.getIndexPage();
        indexPage.switchPage(position);
    }

    @Override
    public void initData() {
        super.initData();
        LogUtil.e("左侧菜单数据初始化");
    }

    //接收数据
    public void setData(List<IndexDataBean.LeftBean> data) {
        this.data=data;
        for(int i=0;i<data.size();i++){
            LogUtil.e("title="+data.get(i).getTitle());
        }
        //设置适配器
        adapter = new LeftMenuFragmentAdapter();
        listView.setAdapter(adapter);
        //设置默认页面
        switchPager(prePosition);
    }

    class LeftMenuFragmentAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = (TextView) View.inflate(activity, R.layout.item_leftmenu, null);
            textView.setText(data.get(position).getTitle());
            //图片变化：
            int icon = data.get(position).getIcon();
             Drawable drawable = getResources().getDrawable(icon);//得到drawable对象
//            drawable.setBounds(0, 0, 24,75);//设置drawable对象的宽度和高度
            //将drawable对象放在new_button的左侧（这里有个注意点，如果使用setCompundDrawables方法，一定要首先通过setBounds来配置一下图片资源
            textView.setCompoundDrawables(drawable,null, null, null);
            //变色
            textView.setEnabled(position==prePosition);
            return textView;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

    }
}
