
package com.td.framework.ui.swipebacklayout.app;

import android.os.Bundle;
import android.view.View;

import com.td.framework.ui.swipebacklayout.SwipeBackLayout;
import com.td.framework.ui.swipebacklayout.SwipeBackUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


/**
 * 可滑动
 * link:https://github.com/ikew0ng/SwipeBackLayout
 */
public class SwipeBackActivity extends RxAppCompatActivity implements SwipeBackActivityBase {
    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    @Override
    public <T extends View> T findViewById(int id) {
        T v = super.findViewById(id);
        if (v == null && mHelper != null)
            return (T) mHelper.findViewById(id);
        return v;
    }

    //    @Override
//    public View findViewById(int id) {
//        View v = super.findViewById(id);
//        if (v == null && mHelper != null)
//            return mHelper.findViewById(id);
//        return v;
//    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        SwipeBackUtils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
