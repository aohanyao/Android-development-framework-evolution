package com.road.of.android.module.skeleton;

import android.os.Bundle;
import android.view.View;

import com.td.framework.base.activity.CandyBaseActivity;
import com.road.of.android.R;

/**
 * Created on 2019-10-16 19:12:13
 *
 * @author: aohanyao
 * @version:1.0
 */
public class SkeletonLayoutActivity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initSkeletonLayout(R.layout.activity_skeleton_layout));
        showSkeletonRetry();
    }


}
