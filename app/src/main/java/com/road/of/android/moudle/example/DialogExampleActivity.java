package com.road.of.android.moudle.example;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.road.of.android.R;
import com.td.framework.module.dialog.DialogHelper;
import com.td.framework.module.dialog.inf.OnDialogCancelListener;
import com.td.framework.module.dialog.inf.OnDialogConfirmListener;

public class DialogExampleActivity extends AppCompatActivity implements OnDialogCancelListener {

    private DialogHelper mDialogHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);
        initToolBar();

        if (mDialogHelper == null) {
            mDialogHelper = new DialogHelper(DialogExampleActivity.this, this);
        }
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


    public void showLoadingDialog(View view) {
        mDialogHelper.showLoadingDialog("LoadingDialog");
    }

    public void showMessageDialog(View view) {
        mDialogHelper.showMessageDialog("MessageDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("MessageDialog callBack");
            }
        });
    }

    public void showSuccessDialog(View view) {
        mDialogHelper.showSuccessDialog("SuccessDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("SuccessDialog callBack");
            }
        });
    }

    public void showWarningDialog(View view) {
        mDialogHelper.showWarningDialog("WarningDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("WarningDialog callBack");
            }
        });
    }

    public void showErrorDialog(View view) {
        mDialogHelper.showErrorDialog("ErrorDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("ErrorDialog callBack");
            }
        });
    }

    public void showConfirmDialog(View view) {
        mDialogHelper.showConfirmDialog("ConfirmDialog", "确定", "取消", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("confirm");
            }
        }, new OnDialogCancelListener() {
            @Override
            public void onDialogCancelListener(AlertDialog dialog) {
                showToast("cancel");
            }
        });
    }


    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onDialogCancelListener(AlertDialog dialog) {
        Toast.makeText(this, "弹窗关闭", Toast.LENGTH_SHORT).show();
    }
}
