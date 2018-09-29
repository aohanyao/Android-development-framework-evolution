package com.td.framework.biz;

import okhttp3.Interceptor;

/**
 * 网络配置器
 * <p>在Application中使用</p>
 */
public interface NetConfig {
    /**
     * 通用请求地址
     *
     * @return
     */
    String configBaseUrl();

    /**
     * 拦截器
     *
     * @return
     */
    Interceptor[] configInterceptors();


    /**
     * 连接超时时间
     *
     * @return
     */
    long configConnectTimeoutMills();

    /**
     * 读取超时时间
     *
     * @return
     */
    long configReadTimeoutMills();


    /**
     * 是否调试模式
     *
     * @return
     */
    boolean configLogEnable();
}
