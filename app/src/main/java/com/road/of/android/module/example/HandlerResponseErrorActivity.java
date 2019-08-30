package com.road.of.android.module.example;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.road.of.android.R;
import com.road.of.android.bean.Repo;
import com.road.of.android.module.example.mvp.contract.HandlerResponseErrorContract;
import com.road.of.android.module.example.mvp.presenter.HandlerResponseErrorPresenter;
import com.td.framework.module.exception.NetErrorException;
import com.td.framework.mvp.base.activity.MVPBaseActivity;

import java.util.List;

/**
 * 统一处理错误
 */
public class HandlerResponseErrorActivity extends MVPBaseActivity<HandlerResponseErrorPresenter> implements HandlerResponseErrorContract.View {
    protected TextView mResultTv;
    protected TextView mDescTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_get_request);
        mResultTv = findViewById(R.id.mResultTv);
        mDescTv = findViewById(R.id.mDescTv);

        mDescTv.setText("本例子说明：\n" +
                "1.统一对返回结果中的状态码做统一的处理，开发者只关心拿到的data。\n" +
                "2.对Exaction进行统一的抓取和处理。\n" +
                "实现思路：\n" +
                "① 创建自定义Exception类，所有错误统一处理\n" +
                "② 自定义BodyConverter，在这里对正常返回结果做第一次判断，抛出Exception\n" +
                "③ 自定义Subscriber，在onError中处理错误\n" +
                "④ 回调error到view层，让view对结果处理，到底是弹窗还是toast等");

        initEvent();
    }

    private void initEvent() {
        findViewById(R.id.mSendRequestBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mResultTv.setText("创建请求................\n");
                // 发起请求
                getP().getReports();
            }
        });
    }


    @Override
    public void onFailure(NetErrorException exception) {
        mResultTv.append("请求失败：" + exception.getMessage()+"\n");
        super.onFailure(exception);
    }

    @Override
    protected HandlerResponseErrorPresenter createPresenter() {
        return new HandlerResponseErrorPresenter(this);
    }

    @Override
    public void onComplete() {
        mResultTv.append("请求结束");
    }


    @Override
    public void getReportSuccess(List<Repo> repos) {
        mResultTv.append("请求成功，repoCount:" + repos.size() + ":\n");
        for (Repo repo : repos) {
            mResultTv.append("repoName:" + repo.getName() + "    star:" + repo.getStargazers_count() + "\n");
        }
    }
}
