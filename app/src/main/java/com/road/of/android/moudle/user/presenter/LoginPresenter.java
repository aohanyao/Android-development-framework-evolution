package com.road.of.android.moudle.user.presenter;

import android.util.Log;

import com.road.of.android.bean.LoginDto;
import com.road.of.android.biz.service.ServiceBuild;
import com.road.of.android.moudle.user.contract.LoginContract;

import org.reactivestreams.Subscriber;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;

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
        // 开始请求
        Subscriber subscriber = ServiceBuild.getUserService()
                .login(userName, password)
                .subscribeOn(Schedulers.io())//运行在io线程
                .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                .subscribeWith(new ResourceSubscriber<LoginDto>() {
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

                    @Override
                    public void onError(Throwable t) {
                        Log.e(TAG, "onError: ");
                        view.loginFailure("登陆失败：" + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                });
    }
}
