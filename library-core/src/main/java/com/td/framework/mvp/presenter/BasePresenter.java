package com.td.framework.mvp.presenter;

import com.td.framework.mvp.view.BaseView;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.RxActivity;
import com.trello.rxlifecycle2.components.RxFragment;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 基类Presenter，做统一的处理
 */
public abstract class BasePresenter {

    private BaseView mView;

    public BasePresenter(BaseView mView) {
        this.mView = mView;
    }

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
     * 统一线程处理和绑定生命周期
     *
     * @turn
     * @par<T>
     */
    protected <E> FlowableTransformer<E, E> getScheduler() {    //compose简化线程
        return new FlowableTransformer<E, E>() {
            @Override
            public Flowable<E> apply(Flowable<E> observable) {
                // 最终用于订阅的
                LifecycleTransformer<E> bindUntilEvent = null;
                // ---------------------------------判断是相应的类型，进行绑定------------
                if (mView instanceof RxAppCompatActivity) {
                    bindUntilEvent = ((RxAppCompatActivity) mView).bindUntilEvent(ActivityEvent.DESTROY);
                }
                if (mView instanceof RxFragmentActivity) {
                    bindUntilEvent = ((RxFragmentActivity) mView).bindUntilEvent(ActivityEvent.DESTROY);
                }
                if (mView instanceof RxActivity) {
                    bindUntilEvent = ((RxActivity) mView).bindUntilEvent(ActivityEvent.DESTROY);
                }
                if (mView instanceof RxFragment) {
                    bindUntilEvent = ((RxFragment) mView).bindUntilEvent(FragmentEvent.DESTROY);
                }
                if (mView instanceof com.trello.rxlifecycle2.components.support.RxFragment) {
                    bindUntilEvent = ((com.trello.rxlifecycle2.components.support.RxFragment) mView).bindUntilEvent(FragmentEvent.DESTROY);
                }
                // ---------------------------------判断是相应的类型，进行绑定------------

                Flowable<E> flowable = observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());

                if (bindUntilEvent != null) {
                    //绑定
                    flowable = observable.subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .compose(bindUntilEvent);
                }
                return flowable;
            }
        };
    }
}
