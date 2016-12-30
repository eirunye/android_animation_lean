package com.example.samsung.myapp;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by on 2016/12/28 9:25
 * Author：yrg
 * Describe:属性动画
 */


public class AnimatorActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;

    private ValueAnimator valueAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        init();
        //initAnimator();
    }

    private void init() {
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initAnimator();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AnimatorActivity.this, "点击了textView", Toast.LENGTH_LONG).show();
            }
        });

    }


    private void initAnimator() {

        ValueAnimator animator = ValueAnimator.ofInt(0, 400);
        //ValueAnimator.ofFloat(0f,400f,30f,30f);//可变参数
        animator.setDuration(1000);//延迟时长
        // animator.setRepeatCount(ValueAnimator.INFINITE);//设置循环次数，INFINITE无限循环
        //animator.setRepeatMode(ValueAnimator.RESTART);//设置循环模式，ValueAnimator.RESTART表示正序重新开始，ValueAnimator.REVERSE表示倒序重新开始

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedFraction = (int) valueAnimator.getAnimatedValue();//获取当前运动点的值
                // float animatedValue = (float) valueAnimator.getAnimatedValue();
                Log.d("TAG", animatedFraction + "");
                textView.layout(animatedFraction, animatedFraction, animatedFraction + textView.getWidth(), textView.getHeight());
            }
        });
        animator.start();//启动
        //animator.cancel();//取消
    }

    public ValueAnimator doAnimatorListener(){

        ValueAnimator animator = ValueAnimator.ofInt(0,400);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();

                textView.layout(textView.getLeft(),animatedValue,textView.getRight(),textView.getHeight());
            }
        });

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                Log.d("TAG_","animator start");
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                Log.d("TAG_","animator end");
            }

            @Override
            public void onAnimationCancel(Animator animator) {
                Log.d("TAG_","animator Cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animator) {
                Log.d("TAG_","animator Repeat");
            }
        });
//        移除动画（动画一直执行）
//        animator.removeListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animator) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animator) {
//              //不执行
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animator) {
//                  //不执行
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animator) {
//
//            }
//        });

        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(1000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

        return animator;
    }

    /**
     * 无论移除或者取消都无法停止动画
     */
    private void cloneValueAnimator(){

        valueAnimator = doAnimatorListener();
        ValueAnimator mValueAnimator = valueAnimator.clone();
        mValueAnimator.setDuration(1000);
        mValueAnimator.start();

    }



}
