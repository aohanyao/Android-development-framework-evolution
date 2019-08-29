package com.td.framework.mvp.view;

import com.td.framework.module.exception.NetErrorException;

/**
 * 基类View，对统一的接口进行定义
 */
public interface BaseView {
    /**
     * 回调失败信息
     *
     * @param exception 异常内容
     */
    void onFailure(NetErrorException exception);

    /**
     * 完成网络请求，可以在这个方法中关闭弹出等操作
     */
    void onComplete();
}
