package com.road.of.android.global;

import android.app.Application;

import com.td.framework.biz.BaseApi;
import com.td.framework.biz.NetConfig;

import okhttp3.Interceptor;

/**
 * 开发 APP
 */
public class DevApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BaseApi.registerConfig(new NetConfig() {
            @Override
            public String configBaseUrl() {
                return "http://qiniu.fullscreendeveloper.cn/";
            }

            @Override
            public Interceptor[] configInterceptors() {
                return new Interceptor[0];
            }

            @Override
            public long configConnectTimeoutMills() {
                return 45 * 1000;
            }

            @Override
            public long configReadTimeoutMills() {
                return 45 * 1000;
            }

            @Override
            public boolean configLogEnable() {
                return true;
            }
        });
    }
}
