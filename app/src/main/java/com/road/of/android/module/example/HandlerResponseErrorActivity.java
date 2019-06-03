package com.road.of.android.module.example;

import android.os.Bundle;
import android.widget.TextView;

import com.road.of.android.R;
import com.road.of.android.bean.Repo;
import com.road.of.android.biz.service.GitHubService;
import com.td.framework.base.activity.CandyBaseActivity;
import com.td.framework.biz.ApiSubscriber;
import com.td.framework.module.exception.NetErrorException;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.HandlerGsonConverterFactory;

/**
 * 统一处理错误
 */
public class HandlerResponseErrorActivity extends CandyBaseActivity {
    protected TextView mResultTv;
    protected TextView mDescTv;
    protected Retrofit retrofit;
    protected GitHubService service;

    protected String TAG = getClass().getSimpleName();



    private Disposable disposable;
    Scheduler observeOn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        observeOn = Schedulers.computation();
        initRetrofitAndService();

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
                "④ 在error和complete中对结处理，到底是弹窗还是toast等");
    }


    protected void sendRequest() {
        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
        }

        mResultTv.setText("创建请求................\n");
        disposable = service.listRxJava2FlowableRepos("aohanyao", "owner")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new ApiSubscriber<List<Repo>>() {
                    @Override
                    public void onNext(List<Repo> repos) {
                        mResultTv.append("请求成功，repoCount:" + repos.size() + ":\n");
                        for (Repo repo : repos) {
                            mResultTv.append("repoName:" + repo.getName() + "    star:" + repo.getStargazers_count() + "\n");
                        }
                    }

                    @Override
                    protected void onFail(NetErrorException error) {
                        mResultTv.append("请求失败" + error.getMessage() + "................\n");
                    }

                    @Override
                    public void onComplete() {
                        mResultTv.append("请求成功................\n");
                    }
                });


    }

    private void initRetrofitAndService() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(HandlerGsonConverterFactory.create()) // 这里使用的是用自己自定义的转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(GitHubService.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            disposable.dispose();
        } catch (Exception e) {
        }
    }


}
