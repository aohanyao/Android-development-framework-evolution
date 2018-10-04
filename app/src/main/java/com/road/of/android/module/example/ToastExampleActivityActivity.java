package com.road.of.android.module.example;

import android.os.Bundle;
import android.view.View;

import com.road.of.android.R;
import com.td.framework.base.activity.CandyBaseActivity;
import com.td.framework.utils.T;

public class ToastExampleActivityActivity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_example_activity);
        showToast(getIntent().getStringExtra("key1"));
    }


    public void showSystemStringResToast(View view) {
        T.showSystemToast(getApplicationContext(), R.string.show_system_string_res_toast);
    }

    public void showSystemStringTextToast(View view) {
        T.showSystemToast(getApplicationContext(), "showSystemStringTextToast");
    }

    public void showCustomizeStringResToast(View view) {
        T.showToast(getApplicationContext(), R.string.show_customize_string_res_toast);
    }

    public void showCustomizeStringTextToast(View view) {
        T.showToast(getApplicationContext(), "showCustomizeStringTextToast");
    }
}

