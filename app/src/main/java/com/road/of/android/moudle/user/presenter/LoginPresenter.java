package com.road.of.android.moudle.user.presenter;

import android.util.Log;

import com.road.of.android.bean.LoginDto;
import com.road.of.android.biz.service.UserService;
import com.road.of.android.moudle.user.contract.LoginContract;

import org.reactivestreams.Subscriber;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.ResourceSubscriber;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.CustGsonConverterFactory;

/**
 * 登陆Presenter
 */
public class LoginPresenter extends LoginContract.Presenter {

    private String TAG = "LoginPresenter";

    /**
     * 用户服务
     */
    private UserService mUserService;


    public LoginPresenter(LoginContract.View view) {
        super(view);
        // 日志拦截器，可以打印出所有的请求过程中的信息
        // 如：请求体、参数、响应体等
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(logInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://olrt5mymy.bkt.clouddn.com/")//请求url
                //增加转换器，这一步能直接Json字符串转换为实体对象
                .addConverterFactory(CustGsonConverterFactory.create())
                //加入 RxJava转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();

        mUserService = retrofit.create(UserService.class);
    }

    @Override
    public void login(String userName, String password) {
        // 开始请求
        Subscriber subscriber = mUserService.login(userName, password)
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
