package com.td.framework.ui.skeleton;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.road.android.core.R;

/**
 * 骨架状态图
 * <p>
 * 只在根布局中进行使用
 */
public class SkeletonLayout extends FrameLayout {
    /**
     * 加载中布局id
     */
    private @LayoutRes
    int mLoadingLayoutId = R.layout.skeleton_base_loading;
    private View mLoadingLayout = null;

    /**
     * 重试布局
     */
    private @LayoutRes
    int mRetryLayoutId = R.layout.skeleton_base_retry;
    private View mRetryLayout = null;

    /**
     * 空布局
     */
    private @LayoutRes
    int mEmptyLayoutId = R.layout.skeleton_base_empty;
    private View mEmptyLayout = null;


    private OnSkeletonListener onSkeletonListener;

    public SkeletonLayout(@NonNull Context context) {
        super(context);
        initSkeletonLayout();
    }

    /**
     * 初始化骨架布局
     */
    private void initSkeletonLayout() {
        FrameLayout.LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        setLayoutParams(layoutParams);

        initRetryView();
        initLoadingView();
        initEmptyView();
        // 不显示布局
        switchSkeleton(null);
    }


    private void initLoadingView() {
        if (mLoadingLayout != null) {
            removeView(mLoadingLayout);
        }
        mLoadingLayout = View.inflate(getContext(), mLoadingLayoutId, null);
        addView(mLoadingLayout);
    }

    private void initEmptyView() {
        if (mEmptyLayout != null) {
            removeView(mEmptyLayout);
        }
        mEmptyLayout = View.inflate(getContext(), mEmptyLayoutId, null);
        addView(mEmptyLayout);
    }

    private void initRetryView() {
        if (mRetryLayout != null) {
            removeView(mRetryLayout);
        }
        mRetryLayout = View.inflate(getContext(), mRetryLayoutId, null);
        addView(mRetryLayout);

        // 点击事件并回调
        View mSkeletonRetry = mRetryLayout.findViewById(R.id.mSkeletonRetry);
        if (mSkeletonRetry != null) {
            mSkeletonRetry.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onSkeletonListener != null) {
                        onSkeletonListener.onSkeletonRetry();
                    }
                }
            });
        }
    }

    public void showSkeletonLoading() {
        switchSkeleton(mLoadingLayout);
    }

    public void showSkeletonRetry() {
        switchSkeleton(mRetryLayout);
    }

    public void showSkeletonContent() {
        switchSkeleton(null);
    }

    public void showSkeletonEmpty() {
        switchSkeleton(mEmptyLayout);
    }

    /**
     * 切换布局状态，进行显示和隐藏
     *
     * @param skeletonView 需要显示的布局
     */
    private void switchSkeleton(View skeletonView) {
        if (mLoadingLayout != null) {
            mLoadingLayout.setVisibility(skeletonView == mLoadingLayout ? VISIBLE : GONE);
        }
        if (mEmptyLayout != null) {
            mEmptyLayout.setVisibility(skeletonView == mEmptyLayout ? VISIBLE : GONE);
        }
        if (mRetryLayout != null) {
            mRetryLayout.setVisibility(skeletonView == mRetryLayout ? VISIBLE : GONE);
        }
    }

    public void setLoadingLayoutId(@LayoutRes int mLoadingLayoutId) {
        this.mLoadingLayoutId = mLoadingLayoutId;
        initLoadingView();
    }

    public void setRetryLayoutId(@LayoutRes int mRetryLayoutId) {
        this.mRetryLayoutId = mRetryLayoutId;
        initRetryView();
    }

    public void setEmptyLayoutId(@LayoutRes int mEmptyLayoutId) {
        this.mEmptyLayoutId = mEmptyLayoutId;
        initEmptyView();
    }

    public void setOnSkeletonListener(OnSkeletonListener onSkeletonListener) {
        this.onSkeletonListener = onSkeletonListener;
    }

    /**
     * 回调接口
     */
    public interface OnSkeletonListener {
        /**显示loading状态*/
        void showSkeletonLoading();
        /**显示重试状态，请求失败的时候使用*/
        void showSkeletonRetry();
        /**隐藏所有状态，现在主内容*/
        void showSkeletonContent();
        /**显示空状态,没有数据的时候使用*/
        void showSkeletonEmpty();
        /**重试状态下被点击，用来确认下一步操作*/
        void onSkeletonRetry();
    }
}
