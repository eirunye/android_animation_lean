package com.example.samsung.myapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by on 2016/12/28 15:58
 * Author：yrg
 * Describe:
 */


public class MyText extends TextView {

    public MyText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setCharText(Character character){
        setText(String.valueOf(character));

    }
}
