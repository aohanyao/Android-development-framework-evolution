package com.td.framework.mvp;

import io.reactivex.disposables.Disposable;

/**
 * 基类Presenter，做统一的处理
 */
public abstract class BasePresenter {
    /**
     * 持有订阅
     */
    protected Disposable mDisposable;

    /**
     * 取消订阅
     */
    public void unDisposable() {
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }
}
