package com.shiqi.find.activity;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.shiqi.find.R;
import com.shiqi.find.util.CatchUtils;
import com.shiqi.find.util.DensityUtil;

import java.util.ArrayList;

public class GuideActivity extends Activity {
    private static final String TAG =GuideActivity.class.getSimpleName();
    private ViewPager viewPager;
    private Button btn_start;
    private LinearLayout point_group;
    private ImageView point_red;
    private ArrayList<ImageView> imageViews;
    private int leftMax;
    private int widthdpi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager = findViewById(R.id.viewPage);
        btn_start=findViewById(R.id.btn_start);
        point_group=findViewById(R.id.point_group);
        point_red=findViewById(R.id.point_red);
        //准备数据
        int [] ids=new int[]{
            R.drawable.guide1,
            R.drawable.guide2,
            R.drawable.guide3
        };
        //适配转换
        widthdpi= DensityUtil.dip2px(this,10);
        Log.e(TAG,widthdpi+"-");

        imageViews=new ArrayList<>();
        for(int i=0;i<ids.length;i++){
            ImageView imageView=new ImageView(this);
            //设置背景
            imageView.setBackgroundResource(ids[i]);
            //添加到集合
            imageViews.add(imageView);
            //创建点，添加到线性布局
            ImageView point =new ImageView(this);
            point.setBackgroundResource(R.drawable.point_normal);
            //宽-高-10，单位：像素，需要做适配
            //适配：单位dp转成对应像素
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(widthdpi,widthdpi);
            if(i!=0){
                //除第一个点外其他点距左边10像素
                params.leftMargin=widthdpi;
            }
            point.setLayoutParams(params);
            point_group.addView(point);

        }
        //设置ViewPager的适配器
        viewPager.setAdapter(new MyPagerAdapter());
        //根据View的生命周期，当视图执行到onLayout或者onDraw时，可以得到视图的高、宽、边距
        point_red.getViewTreeObserver().addOnGlobalLayoutListener(new MyOnGlobalLayoutListener());
        //屏幕滑动的百分比
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());
        //开始按钮的点击事件
        btn_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //1、保存记录（曾打开过应用）
                CatchUtils.putBoolean(GuideActivity.this, WelcomeActivity.START_MAIN,true);
                //2、跳转到主页面
                Intent intent=new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                //3、关闭引导页面
                finish();
            }
        });
    }
    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        //页面滚动回调方法：当前滑动页面位置、页面滑动百分比、滑动像素
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //两点间移动的距离=间距*屏幕滑动百分比
//            int leftMargin=(int)(positionOffset*leftMax);
//            Log.e(TAG,"position="+position+",positionOffset="+positionOffset+",positionOffsetPixels"+positionOffsetPixels);
            //两点间滑动距离对应的坐标=原来的起始位置+两点间移动距离
            int leftMargin=(int)(position*leftMax+(positionOffset*leftMax));
            RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) point_red.getLayoutParams();
            params.leftMargin=leftMargin;
            point_red.setLayoutParams(params);
        }
        //当页面被选中时回调方法：被选中页面的位置
        @Override
        public void onPageSelected(int position) {
            if(position==imageViews.size()-1){
                //最后一个页面
                btn_start.setVisibility(View.VISIBLE);
            }else{
                //其他页面不显示按钮
                btn_start.setVisibility(View.GONE);
            }
        }
        //当页面滑动状态发生变化时
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
    class MyOnGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener{
        @Override
        public void onGlobalLayout() {
            //不需要执行多次
            point_red.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            //间距：第二个点距左边的距离-第一个点距左边的距离
            leftMax=point_group.getChildAt(1).getLeft()-
                    point_group.getChildAt(0).getLeft();
            Log.e(TAG,"leftMax="+leftMax);
        }
    }
    class MyPagerAdapter extends PagerAdapter{
        //返回数据的总个数
        @Override
        public int getCount(){
            return 0;
        }
        //类似getView，视图+创建页面的位置返回关系值
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=imageViews.get(position);
            //添加至容器
            container.addView(imageView);
//            return position;
            return imageView;
//            return super.instantiateItem(container, position);
        }
        //判断 当前创建的视图+instantiateItem的结果
        @Override
        public boolean isViewFromObject(View view,Object object){
            //返回位置的比较方法：
//            return view==imageViews.get(Integer.parseInt((String)object));
            return view==object;
        }
        //销毁页面
        @Override
        public void destroyItem(ViewGroup container, int position,Object object) {
//            super.destroyItem(container, position, object);
            container.removeView((View)object);
        }

    }
}
