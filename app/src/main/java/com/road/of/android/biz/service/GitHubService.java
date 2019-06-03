package com.road.of.android.biz.service;


import com.road.of.android.bean.Repo;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitHubService {

    @GET("users/{user}/repos")
    Flowable<List<Repo>> listRxJava2FlowableRepos(@Path("user") String user,
                                                  @Query("type") String type);

}