package com.road.of.android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.road.of.android.moudle.example.DialogExampleActivity;
import com.road.of.android.moudle.example.LogExampleActivity;
import com.road.of.android.moudle.example.ToastExampleActivityActivity;
import com.road.of.android.moudle.user.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private MainActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mActivity = this;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void logExample(View view) {
        startActivity(new Intent(mActivity, LogExampleActivity.class));
    }

    public void toastExample(View view) {
        startActivity(new Intent(mActivity, ToastExampleActivityActivity.class));
    }

    public void dialogExample(View view) {
        // 弹窗
        startActivity(new Intent(mActivity, DialogExampleActivity.class));
    }

    public void loginPage(View view) {
        //跳转到登录页面
        startActivity(new Intent(mActivity, LoginActivity.class));
    }
}
