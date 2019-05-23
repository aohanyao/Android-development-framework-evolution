package com.road.of.android.module.user.presenter;

import android.util.Log;

import com.road.of.android.bean.LoginDto;
import com.road.of.android.biz.service.ServiceBuild;
import com.road.of.android.module.user.contract.LoginContract;
import com.td.framework.biz.ApiSubscriber;

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
        mDisposable = ServiceBuild.getUserService()
                .login(userName, password)
                .compose(this.<LoginDto>getScheduler())
                .subscribeWith(new ApiSubscriber<LoginDto>(view) {
                    @Override
                    public void onNext(LoginDto loginDto) {
                        //结果回调
                        Log.e(TAG, "onNext: " + loginDto);
                        view.onComplete();
                        if (loginDto.getCode() == 200) {
                            view.loginSuccess(loginDto);
                        } else {
                            view.loginFailure(loginDto.getMessage());
                        }

                    }

                });
    }
}
