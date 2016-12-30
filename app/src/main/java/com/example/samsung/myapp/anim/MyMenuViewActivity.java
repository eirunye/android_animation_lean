package com.example.samsung.myapp.anim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.samsung.myapp.R;

/**
 * Created by on 2016/12/30 11:13
 * Author：yrg
 * Describe:
 */


public class MyMenuViewActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    MyMenuView myMenuView;
    boolean isOpen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_view);
        init();
    }

    private void init() {

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        myMenuView = (MyMenuView) findViewById(R.id.myMenuView);
        myMenuView.OnClickItem(new MyMenuView.OnClickMenuMyListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(MyMenuViewActivity.this,"kkkkkk--->"+position,Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button) {
            if (!isOpen) {
                myMenuView.showView(isOpen);
                isOpen = true;
            } else {
                myMenuView.showView(isOpen);
                isOpen = false;
            }

        }
    }
}
