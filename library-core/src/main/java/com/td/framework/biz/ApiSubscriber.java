package com.td.framework.biz;

import com.td.framework.mvp.BaseView;

import io.reactivex.subscribers.ResourceSubscriber;

/**
 * 统一订阅管理
 *
 * @param <T> 泛型
 */
public abstract class ApiSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView view;

    public ApiSubscriber(BaseView view) {
        this.view = view;
    }

    public ApiSubscriber() {
    }

    @Override
    public void onError(Throwable t) {
        if (null != view) {
            view.onFailure(t.getMessage());
        }
    }

    @Override
    public void onComplete() {
        if (null != view) {
            view.onComplete();
        }
    }
}
