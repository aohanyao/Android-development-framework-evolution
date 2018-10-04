package com.road.of.android.module.user;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.road.of.android.R;
import com.road.of.android.bean.LoginDto;
import com.road.of.android.module.user.contract.LoginContract;
import com.road.of.android.module.user.presenter.LoginPresenter;
import com.td.framework.module.dialog.inf.OnDialogCancelListener;
import com.td.framework.mvp.base.activity.MVPBaseActivity;

public class LoginActivity extends MVPBaseActivity<LoginPresenter> implements LoginContract.View, OnDialogCancelListener {

    private String TAG = "LoginActivity";

    //    private LoginPresenter mLoginPresenter;
//    private DialogHelper mDialogHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        StatusBarUtil.setTranslucentForImageView(this, null);
//        mLoginPresenter = new LoginPresenter(this);
        initEvent();


//        if (mDialogHelper == null) {
//            mDialogHelper = new DialogHelper(LoginActivity.this, this);
//        }

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
                /*mDialogHelper.*/showLoadingDialog("正在登陆");
//                mLoginPresenter.login(account, password);
                getP().login(account, password);

            }
        });
    }

    @Override
    public void loginSuccess(LoginDto loginDto) {
//        Toast.makeText(this, "登陆成功：" + loginDto.toString(), Toast.LENGTH_SHORT).show();
        /*mDialogHelper.*/
        showSuccessDialog("登陆成功：" + loginDto.toString());
    }


    @Override
    public void loginFailure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogCancelListener(AlertDialog dialog) {
        Toast.makeText(this, "取消登陆", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }
}
