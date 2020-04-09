package com.shiqi.find.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.shiqi.find.R;
import com.shiqi.find.util.CatchUtils;

public class WelcomeActivity extends AppCompatActivity {

    //实例化
    private RelativeLayout welcomePage;
    //ctrl+alt+c抽取数据：静态常量，保存是否打开过应用的key
    public static final String START_MAIN = "start_main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcomePage = findViewById(R.id.welcomePage);

        //渐变、缩放、旋转动画
        AlphaAnimation aa = new AlphaAnimation(0, 1);
//        aa.setDuration(500);//持续播放时间
        aa.setFillAfter(true);//播放后状态

        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
//        sa.setDuration(500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0, 360, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f);
//        ra.setDuration(500);
        ra.setFillAfter(true);

        AnimationSet set = new AnimationSet(false);
        //添加三个动画，无先后顺序，同时播放
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.addAnimation(ra);
        set.setDuration(1000);

        welcomePage.startAnimation(set);
        //监听
        set.setAnimationListener(new MyAnimationListener());
    }

    //接口
    class MyAnimationListener implements Animation.AnimationListener {

        //开始播放时回调此方法
        @Override
        public void onAnimationStart(Animation animation) {

        }
        //播放结束
        @Override
        public void onAnimationEnd(Animation animation) {
//            Toast.makeText(WelcomeActivity.this,"动画播放完毕",Toast.LENGTH_SHORT).show();
            //判断是否打开过应用
            boolean isStartMain= CatchUtils.getBoolean(WelcomeActivity.this, START_MAIN);
            Intent intent;
            if(isStartMain){
                //打开过：直接进入主页面
                intent=new Intent(WelcomeActivity.this,MainActivity.class);
            }else {
                //第一次打开应用：进入引导页面
                intent =new Intent(WelcomeActivity.this, GuideActivity.class);
            }
            startActivity(intent);
            //关闭welcome页面：
            finish();
        }
        //重复播放时
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
