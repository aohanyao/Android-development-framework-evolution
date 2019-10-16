package com.road.of.android.module.upload;

import android.os.Bundle;
import android.view.View;

import com.road.of.android.R;
import com.td.framework.base.activity.CandyBaseActivity;

/**
 * Created on 2019-10-16 17:00:40
 *
 * @author: aohanyao
 * @version:1.0
 *
 * 还没来得及时间写
 */
@Deprecated
public class UploadImageMainActivity extends CandyBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_image);
    }

    public void base64(View view) {
        launchActivity(UploaImageByBase64Activity.class);
    }

    public void multipart(View view) {
        launchActivity(UploadImageByMultipartActivity.class);
    }

    public void requestBody(View view) {
        launchActivity(UploadImageByRequestBodyActivity.class);
    }
}
