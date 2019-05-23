package com.road.of.android.module.example;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.road.of.android.R;
import com.road.of.android.bean.LoginDto;
import com.td.framework.base.activity.CandyBaseActivity;
import com.td.framework.utils.L;

import java.util.ArrayList;
import java.util.List;

public class LogExampleActivity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_example);
        L.init(true);
    }


    public void jsonLog(View view) {
        LoginDto.UserInfo userInfo = new LoginDto.UserInfo();
        userInfo.setAge("25");
        userInfo.setEmail("aohanyao@gmail.com");
        userInfo.setNickName("aohanyao");
        userInfo.setUserName("aohanyao");
        // 序列化成json
        L.json(new Gson().toJson(userInfo));
    }


    public void listLog(View view) {
        List<String> list = new ArrayList<>();
        list.add("jsonLog");
        list.add("mapLog");
        list.add("ordinaryLog");
        L.list(list);
    }

    public void ordinaryLog(View view) {
        L.e("ordinaryLog");
    }
}
