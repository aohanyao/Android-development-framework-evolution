package com.road.of.android.module.example.mvp.contract;

import com.road.of.android.bean.Repo;
import com.td.framework.mvp.presenter.BasePresenter;
import com.td.framework.mvp.view.BaseView;

import java.util.List;

public interface HandlerResponseErrorContract {

    interface View extends BaseView {
        /**
         * 获取仓库成功
         *
         * @param repos
         */
        void getReportSuccess(List<Repo> repos);
    }

    abstract class Presenter extends BasePresenter {
        /**
         * 持有View层
         */
        protected View view;

        public Presenter(View view) {
            super(view);
            this.view = view;
        }

        /**
         * 获取仓库
         */
        public abstract void getReports();

    }
}
