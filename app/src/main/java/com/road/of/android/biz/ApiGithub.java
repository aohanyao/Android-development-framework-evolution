package com.road.of.android.biz;

import com.road.of.android.biz.service.GitHubService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.HandlerGsonConverterFactory;

public class ApiGithub {

    private static ApiGithub mApiGithub = null;

    private GitHubService mGitHubService = null;

    private ApiGithub() {
    }

    public static ApiGithub getInstance() {
        synchronized (ApiGithub.class) {
            if (mApiGithub == null) {
                mApiGithub = new ApiGithub();
            }
        }
        return mApiGithub;
    }

    /**
     * 获取GitHub服务
     * @return
     */
    public GitHubService gitHubService() {
        synchronized (ApiGithub.class) {
            if (mGitHubService == null) {
                mGitHubService = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(HandlerGsonConverterFactory.create()) // 这里使用的是用自己自定义的转换器
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
                        .create(GitHubService.class);
            }
        }
        return mGitHubService;
    }
}
