package com.road.of.android;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.road.of.android.module.example.CreateCandyBaseActivity;
import com.road.of.android.module.example.DialogExampleActivity;
import com.road.of.android.module.example.LogExampleActivity;
import com.road.of.android.module.example.ToastExampleActivityActivity;
import com.road.of.android.module.user.LoginActivity;
import com.td.framework.base.activity.CandyBaseActivity;

public class MainActivity extends CandyBaseActivity {


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
//        startActivity(new Intent(mActivity, LogExampleActivity.class));
        launchActivity(LogExampleActivity.class);
    }

    public void toastExample(View view) {
//        startActivity(new Intent(mActivity, ToastExampleActivityActivity.class));
        launchActivity(ToastExampleActivityActivity.class,
                new Pair<String, Object>("key1", "value1"),
                new Pair<String, Object>("key1", "value1"));
    }

    public void dialogExample(View view) {
        // 弹窗
//        startActivity(new Intent(mActivity, DialogExampleActivity.class));
        launchActivity(DialogExampleActivity.class);
    }

    public void loginPage(View view) {
        //跳转到登录页面
//        startActivity(new Intent(mActivity, LoginActivity.class));
        launchActivityForResult(LoginActivity.class,
                200,
                new Pair<String, Object>("key1", "value1"),
                new Pair<String, Object>("key1", "value1"));
    }

    public void createCandyBaseActivity(View view) {
        launchActivity(CreateCandyBaseActivity.class);
    }
}
