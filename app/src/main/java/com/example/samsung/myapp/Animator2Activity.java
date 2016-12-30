package com.example.samsung.myapp;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by on 2016/12/28 10:28
 * Author：yrg
 * Describe:动画进阶《二》
 * <p>
 * AccelerateDecelerateInterpolator            在动画开始与介绍的地方速率改变比较慢，在中间的时候加速
 * AccelerateInterpolator                      在动画开始的地方速率改变比较慢，然后开始加速
 * AnticipateInterpolator                      开始的时候向后然后向前甩
 * AnticipateOvershootInterpolator             开始的时候向后然后向前甩一定值后返回最后的值
 * BounceInterpolator                          动画结束的时候弹起
 * CycleInterpolator                           动画循环播放特定的次数，速率改变沿着正弦曲线
 * DecelerateInterpolator                      在动画开始的地方快然后慢
 * LinearInterpolator                          以常量速率改变
 * OvershootInterpolator                       向前甩一定值后再回到原来位置
 */


public class Animator2Activity extends AppCompatActivity {

    private Button start;
    private TextView text;
    private Button cancel;
    private MyAnimatorView myView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator2);
        start = (Button) findViewById(R.id.start);
        text = (TextView) findViewById(R.id.text);
        cancel = (Button) findViewById(R.id.cancel);
        myView = (MyAnimatorView) findViewById(R.id.myview);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueAnimatorStart();
            }
        });

    }

    private void valueAnimatorStart() {
        ValueAnimator animator = ValueAnimator.ofInt(0, 600);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                text.layout(text.getLeft(), animatedValue, text.getRight(), animatedValue + text.getHeight());
            }
        });
        animator.setDuration(1000);
        //animator.setInterpolator(new BounceInterpolator());//弹跳的形式
        animator.setInterpolator(new MyInterpolator());
        animator.setEvaluator(new MyEvaluator());//Evalutor（指定从哪个位置跑到哪个位置上）
        animator.start();
    }

    /**
     * 自定义一个插值器
     */
    public class MyInterpolator implements TimeInterpolator {

        @Override
        public float getInterpolation(float v) {
            return 1 - v;
        }
    }


    /**
     * 自定义Evaluator
     */
    public class MyEvaluator implements TypeEvaluator<Integer> {

        @Override
        public Integer evaluate(float v, Integer integer, Integer endValue) {
            int startInt = integer;
            return (int) (200 + startInt + v * (endValue - startInt));
        }
    }

    /**
     * ArgbEvaluator(颜色)
     */

    public void ArgbEvaluator() {

        ValueAnimator v = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);
        v.setDuration(3000);
        v.setEvaluator(new ArgbEvaluator());
        v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                text.setBackgroundColor(animatedValue);

            }
        });
    }

    public class ArgbEvaluator implements TypeEvaluator {

        @Override
        public Object evaluate(float fraction, Object startValue, Object endValue) {
            int startInt = (Integer) startValue;

            int startA = (startInt >> 24);
            int startR = (startInt >> 16) & 0xff;
            int startG = (startInt >> 8) & 0xff;
            int startB = startInt & 0xff;

            int endInt = (Integer) endValue;
            int endA = (endInt >> 24);
            int endR = (endInt >> 16) & 0xff;
            int endG = (endInt >> 8) & 0xff;
            int endB = endInt & 0xff;

            return (int) ((startA + (int) (fraction * (endA - startA))) << 24) |
                    (int) ((startR + (int) (fraction * (endR - startR))) << 16) |
                    (int) ((startG + (int) (fraction * (endG - startG))) << 8) |
                    (int) ((startB + (int) (fraction * (endB - startB))));
        }
    }

    /**
     * CharEvaluator
     */

    public class CharEvaluator implements TypeEvaluator<Character> {
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {

            int startInt = (int) startValue;
            int endInt = (int) endValue;
            int curInt = (int) (startInt + fraction * (endInt - startInt));
            char result = (char) curInt;
            return result;
        }
    }

    public void startCharValueAnimator(){
        ValueAnimator value = ValueAnimator.ofObject(new CharEvaluator(),new Character('A'),new Character('Z'));
        value.setDuration(2000);
        value.setInterpolator(new AccelerateInterpolator());//越来越快的加速
        value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                char animatedValue = (char) valueAnimator.getAnimatedValue();
                text.setText(String.valueOf(animatedValue));
            }
        });
        value.start();
    }

    public class PointEvaluator implements TypeEvaluator<Point>{

        @Override
        public Point evaluate(float fraction, Point startValue, Point endValue) {
            int start = startValue.getRadius();
            int end = endValue.getRadius();
            int curValue = (int)(start+fraction*(end-start));
            return new Point(curValue);
        }
    }

}
