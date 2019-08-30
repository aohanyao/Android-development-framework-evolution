package com.road.of.android;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.road.of.android.module.example.CreateCandyBaseActivity;
import com.road.of.android.module.example.DialogExampleActivity;
import com.road.of.android.module.example.HandlerResponseErrorActivity;
import com.road.of.android.module.example.LogExampleActivity;
import com.road.of.android.module.example.StatusToolBarActivity;
import com.road.of.android.module.example.ToastExampleActivityActivity;
import com.road.of.android.module.user.LoginActivity;
import com.td.framework.base.activity.CandyBaseActivity;

public class MainActivity extends CandyBaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        getSwipeBackLayout().setEnableGesture(false);
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

    public void statusToolBar(View view) {
        // 标题栏
        launchActivity(StatusToolBarActivity.class);
    }

    public void handlerResponseError(View view) {
        // 统一错误处理
        launchActivity(HandlerResponseErrorActivity.class);
    }
}
