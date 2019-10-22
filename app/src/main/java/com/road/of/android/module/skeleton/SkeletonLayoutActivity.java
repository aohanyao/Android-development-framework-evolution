package com.road.of.android.module.skeleton;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

import com.road.of.android.R;
import com.td.framework.base.activity.CandyBaseActivity;

/**
 * Created on 2019-10-16 19:12:13
 *
 * @author: aohanyao
 * @version:1.0
 */
public class SkeletonLayoutActivity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initSkeletonLayout(R.layout.activity_skeleton_layout));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_skeleton, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mShowLoading:
                showSkeletonLoading();
                break;
            case R.id.mShowEmpty:
                showSkeletonEmpty();
                break;
            case R.id.mShowContent:
                showSkeletonContent();
                break;
            case R.id.mShowRetry:
                showSkeletonRetry();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSkeletonRetry() {
        showToast("开始重试");
        showSkeletonLoading();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //加载成功
                showToast("加载成功");
                showSkeletonContent();
            }
        }, 1500);
    }
}
