package com.example.samsung.myapp;

import android.animation.Animator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by on 2016/12/28 13:58
 * Author：yrg
 * Describe:ObjectAnimator
 *
 * 父类是ValueAnimator
 */


public class ObjectActivity extends AppCompatActivity {
    private Button start,cancel;
    private TextView tv;
    private MyAnimatorView myAnimatorView;
    private MyText mytext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        init();

    }

    private void initObject() {

        /**
         * 1.第一个参数用于指定动画要操作的layout
         * 2.第二个参数指定动画要操作这个layout的属性 alpha (透明度)、rotation（旋转）、translate(平移)
         *
         * 3.第三个参数是可变参数
         */
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"alpha",1,0,1);
        animator.setDuration(2000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    private void rotationObject(){
        /**
         * rotationX x轴方向上的改变 rotationX旋转的角度
         * rotationY y轴方向上的改变
         * rotation
         */
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"rotation",0,180,0);
        animator.setDuration(2000);
        animator.setInterpolator(new OvershootInterpolator());
        animator.start();

    }

    private void translateObject(){
        /**
         * translationX  表示向x轴方向上移动多少像素
         * translationY
         * translation
         */
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"translationY",0,30,-30,0);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.RESTART);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    private void scaleObject(){
        /*
        scaleX 向X轴方向扩展
        scaleY 向Y轴方向上扩展
        可变参数
         */
        ObjectAnimator animator = ObjectAnimator.ofFloat(tv,"scaleX",0,10,1);
        animator.setDuration(2000);
        animator.start();
    }

    private void pointObject(){

        ObjectAnimator animator = ObjectAnimator.ofInt(myAnimatorView,"pointRadius",0,300,100);
        animator.setDuration(2000);
        animator.start();

    }

    /**
     * PropertValuesHolder
     */

    public void ProperValue(){
        /**
         * propertyName :ObjectAnimator 动画的属性名
         * evaluator :Evaluator的实例，是计算当前动画进度的值，可系统自带 IntEvaluator，FloatEvaluator
         * values:可变长参数表示操作动画属性值
         */
        PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("Rotation",60f,-60f,40f,-40f,20f,-20f,10f,-10f,0);
        PropertyValuesHolder colorPropertHolder = PropertyValuesHolder.ofInt("BackgroundColor",0xffff00cc,0xffcc0033,0xffffff00,0xffff00cc);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(tv,propertyValuesHolder,colorPropertHolder);
        animator.setDuration(2000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();

    }

    private void init() {
        start = (Button) findViewById(R.id.start);
        cancel = (Button) findViewById(R.id.cancel);
        tv = (TextView) findViewById(R.id.tv);
        mytext = (MyText) findViewById(R.id.mytext);
        //myAnimatorView = (MyAnimatorView) findViewById(R.id.myView);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initObject();
                //rotationObject();
                //translateObject();
                //scaleObject();
                //pointObject();
                //ProperValue();
                //doObjectChar();
                keyframe();
            }
        });
    }

    public class CharEvaluator  implements TypeEvaluator<Character>{

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            int startInt  = (int)startValue;
            int endInt = (int)endValue;
            int curInt = (int)(startInt + fraction *(endInt - startInt));
            char result = (char)curInt;
            return result;
        }
    }

    private void doObjectChar(){
        /**
         *
         */
        PropertyValuesHolder charHolder = PropertyValuesHolder.ofObject("CharText",new CharEvaluator(),new Character('A'),new Character('Z'));
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mytext,charHolder);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();
    }

    private void keyframe(){
        Keyframe frame1 = Keyframe.ofFloat(0f,0);
        Keyframe frame2 = Keyframe.ofFloat(0.1f,-20f);
        Keyframe frame3 = Keyframe.ofFloat(1,0);

        PropertyValuesHolder frame = PropertyValuesHolder.ofKeyframe("rotation",frame1,frame2,frame3);
        Animator animator = ObjectAnimator.ofPropertyValuesHolder(tv,frame);
        animator.setDuration(3000);
        animator.start();
    }
}
