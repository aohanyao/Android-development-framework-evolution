package com.td.framework.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;

import com.td.framework.utils.T;
import com.td.framework.utils.anim.ActivityAnimUtils;

import java.io.Serializable;

/**
 * 最基本的Activity
 */
public class CandyBaseActivity extends AppCompatActivity {

    protected Activity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
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
        fillIntent(intent, pairs);
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
        fillIntent(intent, pairs);
        startActivityForResult(intent, requestCode);
        // 加上动画
        slideRightIn();
    }

    /**
     * 填充intent数据，暂时只写了常用的一些数据格式，不常用的没写
     *
     * @param intent
     * @param pairs
     */
    private void fillIntent(Intent intent, Pair<String, Object>[] pairs) {

        if (pairs != null) {
            for (Pair<String, Object> pair : pairs) {
                Object value = pair.second;
                //判断不同的类型，进行强转和存放
                if (value instanceof Boolean) {
                    intent.putExtra(pair.first, (Boolean) value);
                }
                if (value instanceof Byte) {
                    intent.putExtra(pair.first, (Byte) value);
                }
                if (value instanceof Short) {
                    intent.putExtra(pair.first, (Short) value);
                }
                if (value instanceof Long) {
                    intent.putExtra(pair.first, (Long) value);
                }

                if (value instanceof Float) {
                    intent.putExtra(pair.first, (Float) value);
                }

                if (value instanceof Double) {
                    intent.putExtra(pair.first, (Double) value);
                }
                if (value instanceof Integer) {
                    intent.putExtra(pair.first, (Integer) value);
                }
                if (value instanceof String) {
                    intent.putExtra(pair.first, (String) value);
                }
                if (value instanceof Parcelable) {
                    intent.putExtra(pair.first, (Parcelable) value);
                }
                if (value instanceof Parcelable[]) {
                    intent.putExtra(pair.first, (Parcelable) value);
                }
                if (value instanceof Serializable) {
                    intent.putExtra(pair.first, (Serializable) value);
                }

            }
        }
    }
}
