package com.road.of.android.biz.service;

import com.road.of.android.bean.LoginDto;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jc on 2018-07-05.
 * Version:1.0
 * Description: 用户服务
 * ChangeLog:
 */
public interface UserService {

    @GET("app_login.json")
    Flowable<LoginDto> login(@Query("account") String account,
                             @Query("password") String password);
}
