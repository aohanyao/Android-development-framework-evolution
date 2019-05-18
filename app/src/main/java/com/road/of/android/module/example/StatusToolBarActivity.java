package com.road.of.android.module.example;

import android.os.Bundle;
import android.view.View;

import com.road.of.android.R;
import com.td.framework.base.activity.CandyBaseActivity;

/**
 * Created on 2019-5-18 11:54:46
 *
 * @author: aohanyao
 * @version:1.0
 */
public class StatusToolBarActivity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_tool_bar);
    }


    public void statusToolBar(View view) {
        // 打开下一个页面
        launchActivity(StatusToolBa2Activity.class);
    }
}
