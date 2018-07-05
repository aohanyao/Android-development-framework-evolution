package com.road.of.android.moudle.user;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.road.of.android.R;
import com.road.of.android.bean.LoginDto;
import com.road.of.android.biz.service.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
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
            @Override
            public void onClick(View v) {
                //获取帐号
                String account = etAccount.getText().toString();
                //获取密码
                String password = etPassword.getText().toString();

                //调用登录
                mUserService.login(account, password)
                        //执行请求
                        .enqueue(new Callback<LoginDto>() {
                            @Override
                            public void onResponse(Call<LoginDto> call, Response<LoginDto> response) {
                                //打印登录信息
                                Log.e(TAG, "onResponse: " + response.body());
                                //结果
                                //LoginDto{code=200, message='登录成功',
                                // data=UserInfo{userName='aohanyao',
                                // nickName='禁言', header='', age=20,
                                // sex=1, phone='13813801380',
                                // email='aohanyao@gmail.com'}}
                            }

                            @Override
                            public void onFailure(Call<LoginDto> call, Throwable t) {

                            }
                        });

            }
        });
    }
}
