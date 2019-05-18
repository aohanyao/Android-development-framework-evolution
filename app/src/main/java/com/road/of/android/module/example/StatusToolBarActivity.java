package com.road.of.android.module.example;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.jaeger.library.StatusBarUtil;
import com.road.of.android.R;
import com.td.framework.base.activity.CandyBaseActivity;

/**
 * Created on 2019-5-18 11:54:46
 *
 * @author: aohanyao
 * @version:1.0
 */
public class StatusToolBarActivity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_tool_bar);

        initBaseToolBar();
    }

    /**
     * 初始化标题栏
     */
    private void initBaseToolBar() {
        // 获取标题栏
        Toolbar mToolBar = findViewById(R.id.base_toolbar);
        // 设置为透明色
        mToolBar.setBackgroundColor(0x000000);
        Drawable mToolBarBackground = mToolBar.getBackground();
        mToolBarBackground.setAlpha(0);
        mToolBar.setBackground(mToolBarBackground);
        // appbar
        AppBarLayout mAppBarLayout = findViewById(R.id.base_appbar);
        // 状态栏高度 getStatusBarHeight只是一个获取高度的方法
        int statusBarHeight = getStatusBarHeight(mActivity);
        //大于 19  设置沉浸和padding
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (mAppBarLayout != null) {
                ViewGroup.MarginLayoutParams appbarLayoutParam = (ViewGroup.MarginLayoutParams) mAppBarLayout.getLayoutParams();
                // 更改高度 toolbar_height 的高度是可配置的
                appbarLayoutParam.height = (int) (getResources().getDimension(R.dimen.toolbar_height) + statusBarHeight);
                // 设置padding
                mAppBarLayout.setPadding(mAppBarLayout.getPaddingLeft(),
                        statusBarHeight,
                        mAppBarLayout.getPaddingRight(),
                        mAppBarLayout.getPaddingBottom());

                //重新设置回去
                mAppBarLayout.setLayoutParams(appbarLayoutParam);
            }
        }
        // 设置沉浸和状态栏的颜色为透明
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }

    /**
     * 获取状态栏高度
     *
     * @param context context
     * @return 状态栏高度
     */
    private int getStatusBarHeight(Context context) {
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    public void statusToolBar(View view) {
        // 打开下一个页面
        launchActivity(StatusToolBa2Activity.class);
    }
}
