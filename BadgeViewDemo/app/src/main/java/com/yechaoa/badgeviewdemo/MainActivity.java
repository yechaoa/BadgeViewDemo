package com.yechaoa.badgeviewdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int count;
    private TextView textView1;
    private TextView textView2;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDate();
    }

    private void initView() {
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    private void initDate() {

        //初始化BadgeView，1.上下文，2.显示对象
        final BadgeView badgeTextView1 = new BadgeView(this, textView1);
        BadgeView badgeTextView2 = new BadgeView(this, textView2);
        BadgeView badgeImageView = new BadgeView(this, imageView);

        badgeTextView1.setBadgeBackgroundColor(Color.RED);//设置背景颜色
        badgeTextView1.setBadgeMargin(5);//设置margin
        badgeTextView1.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);//设置显示的位置
        count = 1;
        if (count > 0) {
            if (count < 99) {
                badgeTextView1.setText(count + "");//设置显示的内容
            } else {
                badgeTextView1.setText("99+");
            }
            badgeTextView1.setTextSize(10);//设置字体大小
            badgeTextView1.setTextColor(Color.WHITE);//设置字体颜色
            badgeTextView1.show();//显示
        } else {
            badgeTextView1.hide();//隐藏
        }

        //设置点击
        badgeTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1
                // 设置进入的移动动画，设置了插值器，可以实现颤动的效果
                TranslateAnimation anim1 = new TranslateAnimation(0, 0, 0, 0);
                anim1.setInterpolator(new BounceInterpolator());
                // 设置动画的持续时间
                anim1.setDuration(500);
                // 设置退出的移动动画
                TranslateAnimation anim2 = new TranslateAnimation(0, 0, 0, 0);
                anim2.setDuration(500);
                badgeTextView1.toggle(anim1, anim2);
                // 2
                //badgeTextView1.toggle(true);
                // 3
                //badgeTextView1.hide();
            }
        });

        badgeTextView2.setBadgeBackgroundColor(Color.RED);
        badgeTextView2.setBadgeMargin(0);
        badgeTextView2.setBadgePosition(BadgeView.POSITION_TOP_LEFT);
        count = 10;
        if (count > 0) {
            if (count < 99) {
                badgeTextView2.setText(count + "");
            } else {
                badgeTextView2.setText("99+");
            }
            badgeTextView2.setTextSize(10);
            badgeTextView2.setTextColor(Color.WHITE);
            badgeTextView2.show();
        } else {
            badgeTextView2.hide();
        }

        badgeImageView.setBadgeBackgroundColor(Color.RED);
        badgeImageView.setBadgeMargin(0);
        badgeImageView.setBadgePosition(BadgeView.POSITION_TOP_RIGHT);
        count = 100;
        if (count > 0) {
            if (count < 99) {
                badgeImageView.setText(count + "");
            } else {
                badgeImageView.setText("99+");
            }
            badgeImageView.setTextSize(10);
            badgeImageView.setTextColor(Color.WHITE);
            badgeImageView.show();
        } else {
            badgeImageView.hide();
        }

    }

}
