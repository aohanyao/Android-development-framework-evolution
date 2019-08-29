package com.road.of.android.module.example.mvp.presenter;

import com.road.of.android.bean.Repo;
import com.road.of.android.biz.ApiGithub;
import com.road.of.android.module.example.mvp.contract.HandlerResponseErrorContract;
import com.td.framework.biz.ApiSubscriber;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 处理错误的Presenter
 */
public class HandlerResponseErrorPresenter extends HandlerResponseErrorContract.Presenter {


    public HandlerResponseErrorPresenter(HandlerResponseErrorContract.View view) {
        super(view);
    }

    @Override
    public void getReports() {
        mDisposable = ApiGithub.getInstance()
                .gitHubService()
                .listRxJava2FlowableRepos("aohanyao", "owner")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ApiSubscriber<List<Repo>>(view) {
                    @Override
                    public void onNext(List<Repo> repos) {
                        view.getReportSuccess(repos);
                    }
                });
    }
}
