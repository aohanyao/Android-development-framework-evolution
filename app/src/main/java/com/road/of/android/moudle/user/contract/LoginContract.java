package com.road.of.android.moudle.user.contract;

import com.road.of.android.bean.LoginDto;
import com.td.framework.mvp.BasePresenter;

/**
 * 登陆合约类
 */
public interface LoginContract {
    interface View {
        /**
         * 登陆成功
         *
         * @param loginDto 成功回调的信息
         */
        void loginSuccess(LoginDto loginDto);

        /**
         * 登陆失败
         *
         * @param message 失败消息
         */
        void loginFailure(String message);
    }

    abstract class Presenter extends BasePresenter{
        /**
         * 持有View层
         */
        protected View view;

        public Presenter(View view) {
            this.view = view;
        }

        /**
         * 登陆
         *
         * @param userName 用户名
         * @param password 密码
         */
        public abstract void login(String userName, String password);

    }
}
