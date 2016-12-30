package com.example.samsung.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by on 2016/12/28 10:28
 * Author：yrg
 * Describe:动画进阶《一》
 *
 *  AccelerateDecelerateInterpolator            在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
 *  AccelerateInterpolator                      在动画开始的地方速率改变比较慢，然后开始加速
 *  AnticipateInterpolator                      开始的时候向后然后向前甩
 *  AnticipateOvershootInterpolator             开始的时候向后然后向前甩一定值后返回最后的值
 *  BounceInterpolator                          动画结束的时候弹起
 *  CycleInterpolator                           动画循环播放特定的次数，速率改变沿着正弦曲线
 *  DecelerateInterpolator                      在动画开始的地方快然后慢
 *  LinearInterpolator                          以常量速率改变
 *  OvershootInterpolator                       向前甩一定值后再回到原来位置
 */


public class Animator1Activity extends AppCompatActivity {

    private Button button3;
    private TextView textView3;
    Animation animation;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value1);
        button3 = (Button) findViewById(R.id.button3);
        textView3 = (TextView) findViewById(R.id.textView3);
        animation = AnimationUtils.loadAnimation(this,R.anim.animtoion_onetran);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView3.startAnimation(animation);
            }
        });

    }
}
