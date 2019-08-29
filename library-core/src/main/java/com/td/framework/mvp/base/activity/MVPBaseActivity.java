package com.td.framework.mvp.base.activity;

import android.support.v7.app.AlertDialog;

import com.td.framework.base.activity.CandyLoadingBaseActivity;
import com.td.framework.module.exception.NetErrorException;
import com.td.framework.mvp.presenter.BasePresenter;
import com.td.framework.mvp.view.BaseView;

/**
 * Mvp BaseActivity
 *
 * @param <P>
 */
abstract public class MVPBaseActivity<P extends BasePresenter> extends CandyLoadingBaseActivity
        implements BaseView {

    private P mPresenter;

    /**
     * 底层获取P
     *
     * @return P
     */
    protected synchronized P getP() {
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }
        return mPresenter;
    }


    /**
     * 创建Presenter
     *
     * @return 返回Presenter的实例
     */
    protected abstract P createPresenter();

    @Override
    public void onComplete() {
        // 请求完成、关闭dialog
        dismissDialog();
    }

    @Override
    public void onDialogCancelListener(AlertDialog dialog) {
        super.onDialogCancelListener(dialog);
        // dialog取消，取消订阅
        getP().unDisposable();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 销毁 取消订阅
        getP().unDisposable();
    }

    @Override
    public void onFailure(NetErrorException exception) {
        showWarningDialog(exception.getMessage());
    }
}
