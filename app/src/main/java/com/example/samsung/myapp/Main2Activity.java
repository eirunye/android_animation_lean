package com.example.samsung.myapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.content_main2);

        init();

    }

    private void init() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setTitle("主标题");
        toolbar.setSubtitle("子标题");
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.action_search) {
                    Toast.makeText(Main2Activity.this, "搜索", Toast.LENGTH_LONG).show();
                } else if (itemId == R.id.action_notification) {
                    Toast.makeText(Main2Activity.this, "导航", Toast.LENGTH_LONG).show();
                } else if (itemId == R.id.action_item1) {
                    Toast.makeText(Main2Activity.this, "标题1", Toast.LENGTH_LONG).show();
                } else if (itemId == R.id.action_item2) {
                    Toast.makeText(Main2Activity.this, "标题2", Toast.LENGTH_LONG).show();
                }
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_search) {
            Toast.makeText(Main2Activity.this, "搜索", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.action_notification) {
            Toast.makeText(Main2Activity.this, "导航", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.action_item1) {
            Toast.makeText(Main2Activity.this, "标题1", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.action_item2) {
            Toast.makeText(Main2Activity.this, "标题2", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}





