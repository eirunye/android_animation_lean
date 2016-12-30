package com.example.samsung.myapp.anim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.samsung.myapp.R;

/**
 * Created by on 2016/12/30 10:34
 * Author：yrg
 * Describe:
 */


public class MyMenuView extends FrameLayout implements View.OnClickListener {

    View view;
    Button item1, item2, item3, item4, item5;
    OnClickMenuMyListener onClickMenuMyListener;
    int position;

    public MyMenuView(Context context) {
        super(context);
        init();
    }


    public MyMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        view = LayoutInflater.from(getContext()).inflate(R.layout.item_animator, this, true);
        initView();
        // showView();

    }


    private void initView() {
        item1 = (Button) view.findViewById(R.id.item1);
        item2 = (Button) view.findViewById(R.id.item2);
        item3 = (Button) view.findViewById(R.id.item3);
        item4 = (Button) view.findViewById(R.id.item4);
        item5 = (Button) view.findViewById(R.id.item5);
        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);

    }

    public void showView(boolean isOpen) {

        if (!isOpen) {
            openAnimatorSer(item1, 0, 5, 300);
            openAnimatorSer(item2, 1, 5, 300);
            openAnimatorSer(item3, 2, 5, 300);
            openAnimatorSer(item4, 3, 5, 300);
            openAnimatorSer(item5, 4, 5, 300);
        } else {
            closeAnimatorSer(item1, 0, 5, 300);
            closeAnimatorSer(item2, 1, 5, 300);
            closeAnimatorSer(item3, 2, 5, 300);
            closeAnimatorSer(item4, 3, 5, 300);
            closeAnimatorSer(item5, 4, 5, 300);
        }


    }

    private void closeAnimatorSer(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double v = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(v));
        int translationY = -(int) (radius * Math.cos(v));
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));
        set.setDuration(2000);
        set.start();
    }

    private void openAnimatorSer(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }

        double v = Math.toRadians(90) / (total - 1) * index;
        int translationX = -(int) (radius * Math.sin(v));
        int translationY = -(int) (radius * Math.cos(v));
        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view, "alpha", 0f, 1f));
        set.setDuration(500);
        set.start();
    }

    public void OnClickItem(OnClickMenuMyListener onClickMenuMyListener) {
        this.onClickMenuMyListener= onClickMenuMyListener;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item1:
                position = 1;
                onClickMenuMyListener.onItemClick(position);
                break;
            case R.id.item2:
                position = 2;
                onClickMenuMyListener.onItemClick(position);
                break;
            case R.id.item3:
                position = 3;
                onClickMenuMyListener.onItemClick(position);
                break;
            case R.id.item4:
                position = 4;
                onClickMenuMyListener.onItemClick(position);
                break;
            case R.id.item5:
                position = 5;
                onClickMenuMyListener.onItemClick(position);
                break;
        }
    }

    public interface OnClickMenuMyListener {
        void onItemClick(int position);
    }


}
