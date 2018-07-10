package com.road.of.android.moudle.user;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.road.of.android.R;
import com.road.of.android.bean.LoginDto;
import com.road.of.android.biz.service.UserService;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private String TAG = "LoginActivity";

    private UserService mUserService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initRetrofit();
        initEvent();
    }

    private void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://olrt5mymy.bkt.clouddn.com/")//请求url
                //增加转换器，这一步能直接Json字符串转换为实体对象
                .addConverterFactory(GsonConverterFactory.create())
                //加入 RxJava转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        mUserService = retrofit.create(UserService.class);
    }

    private void initEvent() {
        //获取帐号输入框
        final EditText etAccount = findViewById(R.id.et_account);
        //获取密码输入框
        final EditText etPassword = findViewById(R.id.et_pass);

        //获取登录按钮 设置点击事件
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CheckResult")
            @Override
            public void onClick(View v) {
                //获取帐号
                String account = etAccount.getText().toString();
                //获取密码
                String password = etPassword.getText().toString();
                //登录
                mUserService.login(account, password)
                        .subscribeOn(Schedulers.io())//运行在io线程
                        .observeOn(AndroidSchedulers.mainThread())//回调在主线程
                        .subscribeWith(new Subscriber<LoginDto>() {
                            @Override
                            public void onSubscribe(Subscription s) {
                                Log.e(TAG, "onSubscribe: ");
                            }

                            @Override
                            public void onNext(LoginDto loginDto) {
                                //结果回调
                                Log.e(TAG, "onNext: " + loginDto);
                            }

                            @Override
                            public void onError(Throwable t) {
                                t.printStackTrace();
                                Log.e(TAG, "onError: ");
                            }

                            @Override
                            public void onComplete() {
                                Log.e(TAG, "onComplete: ");
                            }
                        });

            }
        });
    }
}
