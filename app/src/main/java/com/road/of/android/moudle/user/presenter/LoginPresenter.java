package com.road.of.android.moudle.user.presenter;

import android.util.Log;

import com.road.of.android.bean.LoginDto;
import com.road.of.android.biz.service.ServiceBuild;
import com.road.of.android.moudle.user.contract.LoginContract;
import com.td.framework.biz.ApiSubscriber;
import com.td.framework.biz.BaseApi;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;

/**
 * 登陆Presenter
 */
public class LoginPresenter extends LoginContract.Presenter {

    private String TAG = "LoginPresenter";

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login(final String userName, final String password) {
        // 取消上次请求
        unDisposable();
        // 开始请求
        mDisposable = Flowable.timer(2, TimeUnit.SECONDS)
                .flatMap(//这里是为了加一个延时效果
                        new Function<Long, Flowable<LoginDto>>() {
                            @Override
                            public Flowable<LoginDto> apply(Long aLong) throws Exception {
                                return ServiceBuild.getUserService()
                                        .login(userName, password);
                            }
                        })
                .compose(BaseApi.<LoginDto>getScheduler())
                .subscribeWith(new ApiSubscriber<LoginDto>() {
                    @Override
                    public void onNext(LoginDto loginDto) {
                        //结果回调
                        Log.e(TAG, "onNext: " + loginDto);
                        if (loginDto.getCode() == 200) {
                            view.loginSuccess(loginDto);
                        } else {
                            view.loginFailure(loginDto.getMessage());
                        }

                    }

                });
    }
}
