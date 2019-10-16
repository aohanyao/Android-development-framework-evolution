package com.td.framework.biz;

import com.google.gson.JsonParseException;
import com.td.framework.module.exception.NetErrorException;
import com.td.framework.mvp.view.BaseView;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

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
    public void onError(Throwable e) {
        NetErrorException error = null;
        if (e != null) {
            // 对不是自定义抛出的错误进行解析
            if (!(e instanceof NetErrorException)) {
                if (e instanceof UnknownHostException) {
                    error = new NetErrorException(e, NetErrorException.NoConnectError);
                } else if (e instanceof JSONException || e instanceof JsonParseException) {
                    error = new NetErrorException(e, NetErrorException.PARSE_ERROR);
                } else if (e instanceof SocketTimeoutException) {
                    error = new NetErrorException(e, NetErrorException.SocketTimeoutError);
                } else if (e instanceof ConnectException) {
                    error = new NetErrorException(e, NetErrorException.ConnectExceptionError);
                } else {
                    error = new NetErrorException(e, NetErrorException.OTHER);
                }
            } else {
                error = new NetErrorException(e.getMessage(), NetErrorException.OTHER);
            }
        }

        // 回调抽象方法
        onFail(error);

    }

    /**
     * 回调错误
     */
    protected void onFail(NetErrorException error) {
        //
        if (view != null) {
            view.onComplete();
            view.onFailure(error);
        }
    }

    @Override
    public void onComplete() {
        if (view != null) {
            view.onComplete();
        }
    }
}