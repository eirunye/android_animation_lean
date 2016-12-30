package com.example.samsung.myapp.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.samsung.myapp.R;

/**
 * Created by on 2016/12/29 17:24
 * Author：yrg
 * Describe:
 */


public class MyAnimatorSet extends AppCompatActivity implements View.OnClickListener {


    private Button menu, item1, item2, item3, item4, item5;
    private boolean mOpen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatorset);
        init();
    }

    private void init() {
        menu = (Button) findViewById(R.id.menu);
        item1 = (Button) findViewById(R.id.item1);
        item2 = (Button) findViewById(R.id.item2);
        item3 = (Button) findViewById(R.id.item3);
        item4 = (Button) findViewById(R.id.item4);
        item5 = (Button) findViewById(R.id.item5);
        menu.setOnClickListener(this);
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.menu) {
            if (!mOpen) {
                mOpen = true;
                openAnimatorSer(item1, 0, 5, 300);
                openAnimatorSer(item2, 1, 5, 300);
                openAnimatorSer(item3, 2, 5, 300);
                openAnimatorSer(item4, 3, 5, 300);
                openAnimatorSer(item5, 4, 5, 300);
            } else {
                mOpen = false;
                closeAnimatorSer(item1, 0, 5, 300);
                closeAnimatorSer(item2, 1, 5, 300);
                closeAnimatorSer(item3, 2, 5, 300);
                closeAnimatorSer(item4, 3, 5, 300);
                closeAnimatorSer(item5, 4, 5, 300);
            }
        } else {
            Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        }


    }

    private void closeAnimatorSer(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //包含平移、缩放和透明度动画
        set.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));

        set.setDuration(1 * 500).start();

    }

    private void openAnimatorSer(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX)
                , ObjectAnimator.ofFloat(view, "translationY", 0, translationY)
                , ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1));
        animatorSet.setDuration(1500);
        //animatorSet.setInterpolator(new AccelerateInterpolator());
        animatorSet.start();

    }
}
