package com.road.of.android.biz.service;

import com.td.framework.biz.BaseApi;

/**
 * 服务获取类
 */
public class ServiceBuild {
    /**
     * 用户服务
     */
    private static UserService mUserService;

    /**
     * 获取用户服务
     */
    public static synchronized UserService getUserService() {
        if (null == mUserService) {
            mUserService = BaseApi.createRetrofit().create(UserService.class);
        }

        return mUserService;
    }
}
