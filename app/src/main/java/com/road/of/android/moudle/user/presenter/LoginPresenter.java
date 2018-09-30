package com.road.of.android.moudle.user.presenter;

import android.util.Log;

import com.road.of.android.bean.LoginDto;
import com.road.of.android.biz.service.ServiceBuild;
import com.road.of.android.moudle.user.contract.LoginContract;
import com.td.framework.biz.ApiSubscriber;
import com.td.framework.biz.BaseApi;

/**
 * 登陆Presenter
 */
public class LoginPresenter extends LoginContract.Presenter {

    private String TAG = "LoginPresenter";

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login(String userName, String password) {
        // 取消上次请求
        unDisposable();
        // 开始请求
        mDisposable = ServiceBuild.getUserService()
                .login(userName, password)
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
