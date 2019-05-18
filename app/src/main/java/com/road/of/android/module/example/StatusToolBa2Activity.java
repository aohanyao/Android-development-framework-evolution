package com.road.of.android.module.example;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.ViewGroup;

import com.jaeger.library.StatusBarUtil;
import com.road.of.android.R;
import com.td.framework.base.activity.CandyBaseActivity;

/**
 * Created on 2019-5-18 15:32:18
 *
 * @author: aohanyao
 * @version:1.0
 */
public class StatusToolBa2Activity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_tool_ba2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        initBaseToolBar();
    }

    /**
     * 初始化标题栏
     */
    private void initBaseToolBar() {
        // 设置为透明色 mToolBar 已经在base中获取过了
        mToolBar.setBackgroundColor(0x00000000);
        mToolBar.setTitle("");
        // 设置全透明
        mToolBar.getBackground().setAlpha(0);
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
}
