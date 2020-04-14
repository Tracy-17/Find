package com.shiqi.find.bean;

import com.shiqi.find.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:ShiQi
 * Date:2020/4/13-17:21
 * 首页解析后对应的数据
 */
public class IndexDataBean {

    public static final List<LeftBean> TRUE_MENU=new ArrayList<>();
    static{
        TRUE_MENU.add(1,new LeftBean("资料",R.drawable.leftmenu_info_selector));
        TRUE_MENU.add(2,new LeftBean("消息",R.drawable.leftmenu_msg_selector));
        TRUE_MENU.add(3,new LeftBean("收藏",R.drawable.leftmenu_col_selector));
        TRUE_MENU.add(4,new LeftBean("关注",R.drawable.leftmenu_fol_selector));
        TRUE_MENU.add(5,new LeftBean("注销",R.drawable.leftmenu_unsub_selector));
    }
    public static final List<LeftBean> FALSE_MENU=new ArrayList<>();
    static{
        FALSE_MENU.add(1,new LeftBean("注册", R.drawable.leftmenu_login_selector));
    }


    public static class LeftBean{
        private String title;
        private int icon;

        public String getTitle() {
            return title;
        }

        public int getIcon() {
            return icon;
        }

        public LeftBean(String title, int icon) {
            this.title = title;
            this.icon = icon;
        }
    }
}