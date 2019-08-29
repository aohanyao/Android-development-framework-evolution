package com.td.framework.mvp.base.fragment;

import android.support.v7.app.AlertDialog;

import com.td.framework.base.fragment.CandyLoadingBaseFragment;
import com.td.framework.module.exception.NetErrorException;
import com.td.framework.mvp.presenter.BasePresenter;
import com.td.framework.mvp.view.BaseView;

/**
 * Mvp Base Fragment
 *
 * @param <P>
 */
abstract public class MVPBaseFragment<P extends BasePresenter> extends CandyLoadingBaseFragment
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
    public void onDestroy() {
        super.onDestroy();
        // 销毁 取消订阅
        getP().unDisposable();
    }

    @Override
    public void onFailure(NetErrorException exception) {
        showWarningDialog(exception.getMessage());
    }
}
