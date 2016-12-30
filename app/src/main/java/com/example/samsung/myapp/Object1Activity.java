package com.example.samsung.myapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by on 2016/12/28 16:30
 * Author：yrg
 * Describe:
 */


public class Object1Activity extends AppCompatActivity {
    Button button2;
    TextView tv1,tv2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objectset);
        init();
    }

    private void init() {
        button2 = (Button) findViewById(R.id.button2);
        tv1 = (TextView) findViewById(R.id.textView4);
        tv2 = (TextView) findViewById(R.id.textView2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animatorSet();
            }
        });

    }

    private void animatorSet(){
        ObjectAnimator tvBg = ObjectAnimator.ofInt(tv1,"BackgroundColor",0xffff00cc,0xffffff00,0xffff00cc);
        ObjectAnimator tvTranslator = ObjectAnimator.ofFloat(tv2,"translationY",0,300,0);
        ObjectAnimator tvTranslatorY = ObjectAnimator.ofFloat(tv1,"translationY",0,400,0);
        AnimatorSet animatorSet = new AnimatorSet();
        //playSequentially根据先后顺序进行
        animatorSet.playSequentially(tvBg,tvTranslator,tvTranslatorY);
        // 串行方式  表示在颜色改变之后两个同时进行
       // animatorSet.play(tvTranslator).with(tvTranslatorY).after(tvBg);
        animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.setDuration(2000);
        animatorSet.start();

    }
}
