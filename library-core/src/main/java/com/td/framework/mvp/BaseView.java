package com.td.framework.mvp;

/**
 * 基类View，对统一的接口进行定义
 */
public interface BaseView {
    /**
     * 回调失败信息
     *
     * @param message 失败消息
     */
    void onFailure(String message);

    /**
     * 完成网络请求，可以在这个方法中关闭弹出等操作
     */
    void onComplete();
}
