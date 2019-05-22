package com.td.framework.mvp.presenter;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

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


    /**
     * 统一线程处理
     *
     * @turn
     * @par<T>
     */
    protected <E> FlowableTransformer<E, E> getScheduler() {    //compose简化线程
        return new FlowableTransformer<E, E>() {
            @Override
            public Flowable<E> apply(Flowable<E> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
