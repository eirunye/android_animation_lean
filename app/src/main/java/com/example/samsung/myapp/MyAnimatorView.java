package com.example.samsung.myapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by on 2016/12/28 13:42
 * Author：yrg
 * Describe:
 */


public class MyAnimatorView extends View {

    private Point mpaint = new Point(100);

    public MyAnimatorView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (mpaint!=null){
            Paint paint = new Paint();
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(300,300,mpaint.getRadius(),paint);
        }
        super.onDraw(canvas);

    }

    public int getPointRadius(){
        return 50;
    }

    public void setPointRadius(int radius){
        mpaint.setRadius(radius);
        invalidate();

    }


}
