package com.td.framework.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;

import com.road.android.core.R;
import com.td.framework.utils.T;
import com.td.framework.utils.anim.ActivityAnimUtils;
import com.td.framework.utils.data.IntentUtils;

/**
 * 最基本的Activity
 * -------------------------------
 * v0.1 2018年10月04日11:44:26
 * ①showToast
 * ②startActivity
 * ③跳转动画
 * ④initToolbar
 * -------------------------------
 */
public class CandyBaseActivity extends AppCompatActivity {

    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
    }

    /**
     * 是否初始化了toolbar
     */
    private boolean isInitToolbar = false;


    @Override
    protected void onStart() {
        super.onStart();
        if (!isInitToolbar) {
            initToolbar();
        }
    }

    /**
     * 初始化toolbar
     */
    private void initToolbar() {
        Toolbar mToolbar = findViewById(R.id.base_toolbar);
        if (null != mToolbar) {
            // 清除标题
            mToolbar.setTitle("");
            setSupportActionBar(mToolbar);
            mToolbar.setBackgroundColor(getToolbarBackground());
            //设置返回按钮
            mToolbar.setNavigationIcon(getNavigationIcon());
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onNavigationOnClickListener();
                }
            });
            isInitToolbar = true;
            //返回文字按钮
            View navText = findViewById(R.id.toolbar_nav_text);
            if (null != navText) {
                navText.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onNavigationOnClickListener();
                    }
                });
            }
        }
    }

    /**
     * 获取toolbar的背景
     *
     * @return
     */
    private int getToolbarBackground() {
        return getResources().getColor(R.color.colorPrimary);
    }

    /**
     * 返回按钮点击
     */
    protected void onNavigationOnClickListener() {
        finish();
        slideLeftOut();
    }

    /**
     * 返回按钮
     *
     * @return
     */
    protected int getNavigationIcon() {
        return R.drawable.ic_chevron_left_write_24dp;
    }

    /**
     * 显示文本信息
     *
     * @param text 文本信息
     */
    public void showToast(String text) {
        T.showToast(mActivity, text);
    }

    /**
     * 显示文本信息
     *
     * @param resId 文本资源id信息
     */
    public void showToast(int resId) {
        T.showToast(mActivity, resId);
    }


    /**
     * 右边划出
     */
    protected void slideLeftOut() {
        ActivityAnimUtils.out(mActivity);
    }

    /**
     * 进入
     */
    protected void slideRightIn() {
        ActivityAnimUtils.to(mActivity);
    }

    @Override
    public void finish() {
        super.finish();
        slideLeftOut();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        slideLeftOut();
    }

    /**
     * 打开 Activity
     *
     * @param activity
     */
    protected void launchActivity(Class<? extends Activity> activity) {
        startActivity(new Intent(mActivity, activity));
        // 加上动画
        slideRightIn();
    }

    /**
     * 打开 Activity
     *
     * @param activity
     */
    protected void launchActivityForResult(Class<? extends Activity> activity, int requestCode) {
        startActivityForResult(new Intent(mActivity, activity), requestCode);
        // 加上动画
        slideRightIn();
    }

    /**
     * 打开新的 Activity
     *
     * @param activity 目标Activity
     * @param pairs    键值对
     */
    protected void launchActivity(Class<? extends Activity> activity, Pair<String, Object>... pairs) {
        Intent intent = new Intent(mActivity, activity);
        // 填充数据
        IntentUtils.fillIntent(intent, pairs);
        startActivity(intent);
        // 加上动画
        slideRightIn();
    }

    /**
     * 打开新的 Activity
     *
     * @param activity 目标Activity
     * @param pairs    键值对
     */
    protected void launchActivityForResult(Class<? extends Activity> activity, int requestCode, Pair<String, Object>... pairs) {
        Intent intent = new Intent(mActivity, activity);
        // 填充数据
        IntentUtils.fillIntent(intent, pairs);
        startActivityForResult(intent, requestCode);
        // 加上动画
        slideRightIn();
    }


}
