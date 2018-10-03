package com.road.of.android.moudle.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.road.of.android.R;
import com.td.framework.utils.T;

public class ToastExampleActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_example_activity);
        initToolBar();
    }

    /**
     * toolbar
     */
    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

