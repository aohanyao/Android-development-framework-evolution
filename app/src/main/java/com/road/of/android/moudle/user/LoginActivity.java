package com.road.of.android.moudle.user;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.road.of.android.R;
import com.road.of.android.bean.LoginDto;
import com.road.of.android.moudle.example.DialogExampleActivity;
import com.road.of.android.moudle.user.contract.LoginContract;
import com.road.of.android.moudle.user.presenter.LoginPresenter;
import com.td.framework.module.dialog.DialogHelper;
import com.td.framework.module.dialog.inf.OnDialogCancelListener;

public class LoginActivity extends AppCompatActivity implements LoginContract.View, OnDialogCancelListener {

    private String TAG = "LoginActivity";

    private LoginPresenter mLoginPresenter;
    private DialogHelper mDialogHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarUtil.setTranslucentForImageView(this, null);
        mLoginPresenter = new LoginPresenter(this);
        initEvent();


        if (mDialogHelper == null) {
            mDialogHelper = new DialogHelper(LoginActivity.this, this);
        }

        findViewById(R.id.tv_dialog_example).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到 例子页面 🌰
                startActivity(new Intent(LoginActivity.this, DialogExampleActivity.class));
            }
        });
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
//                Toast.makeText(LoginActivity.this, "正在登陆", Toast.LENGTH_SHORT).show();
                mDialogHelper.showLoadingDialog("正在登陆");
                mLoginPresenter.login(account, password);

            }
        });
    }

    @Override
    public void loginSuccess(LoginDto loginDto) {
//        Toast.makeText(this, "登陆成功：" + loginDto.toString(), Toast.LENGTH_SHORT).show();
        mDialogHelper.showSuccessDialog("登陆成功：" + loginDto.toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.unDisposable();
    }

    @Override
    public void loginFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogCancelListener(AlertDialog dialog) {
        mLoginPresenter.unDisposable();
        Toast.makeText(this, "取消登陆", Toast.LENGTH_SHORT).show();
    }
}
