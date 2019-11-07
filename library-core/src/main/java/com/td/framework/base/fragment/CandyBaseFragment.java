package com.td.framework.base.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.td.framework.ui.skeleton.SkeletonLayout;
import com.td.framework.utils.T;
import com.td.framework.utils.anim.ActivityAnimUtils;
import com.td.framework.utils.data.IntentUtils;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * 最基本的Fragment
 * -------------------------------
 * v0.1 2018年10月04日15:04:17
 * ①showToast
 * ②startActivity
 * ③跳转动画
 * -------------------------------
 *
 * -------------------------------
 * 2019年11月07日16:21:39
 * ①增加SkeletonLayout
 * -------------------------------
 */
public class CandyBaseFragment extends RxFragment implements SkeletonLayout.OnSkeletonListener{

    protected Activity mActivity;
    /**
     * 骨架图
     */
    protected SkeletonLayout mSkeletonLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
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

//----------------------骨架图相关的封装 start--------------------

    /**
     * 初始化骨架图，需要骨架的地方才会进行初始化，传入的是Activity的根布局
     *
     * @param layoutId 根布局
     * @return 解析好的根布局，增加了骨架图在原本的ViewGroup上面
     */
    protected View initSkeletonLayout(@LayoutRes int layoutId,ViewGroup container) {
        ViewGroup contentView = (ViewGroup) LayoutInflater.from(mActivity).inflate(layoutId, container, false);
        mSkeletonLayout = new SkeletonLayout(mActivity);
        contentView.addView(mSkeletonLayout);
        mSkeletonLayout.setOnSkeletonListener(this);
        return contentView;
    }

    public void showSkeletonLoading() {
        if (mSkeletonLayout != null) {
            mSkeletonLayout.showSkeletonLoading();
        }
    }

    public void showSkeletonRetry() {
        if (mSkeletonLayout != null) {
            mSkeletonLayout.showSkeletonRetry();
        }
    }
    public void showSkeletonContent() {
        if (mSkeletonLayout != null) {
            mSkeletonLayout.showSkeletonContent();
        }
    }

    public void showSkeletonEmpty() {
        if (mSkeletonLayout != null) {
            mSkeletonLayout.showSkeletonEmpty();
        }
    }
    @Override
    public void onSkeletonRetry() {
        //重试点击
    }
    //----------------------骨架图相关的封装 end----------------------

}
