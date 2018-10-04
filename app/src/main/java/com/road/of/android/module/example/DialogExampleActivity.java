package com.road.of.android.module.example;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.road.of.android.R;
import com.td.framework.base.activity.CandyLoadingBaseActivity;
import com.td.framework.module.dialog.inf.OnDialogCancelListener;
import com.td.framework.module.dialog.inf.OnDialogConfirmListener;

/**
 * ----------------------------
 * v0.1 2018年10月04日11:43:26
 * 将DialogHelper替换成了CandyLoadingBaseActivity
 * ----------------------------
 */
public class DialogExampleActivity extends CandyLoadingBaseActivity {
//    protected DialogHelper mDialogHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_example);
//        if (mDialogHelper == null) {
//            mDialogHelper = new DialogHelper(mActivity, this);
//        }
    }


    public void showLoadingDialog(View view) {
        /**mDialogHelper.*/showLoadingDialog("LoadingDialog");
    }

    public void showMessageDialog(View view) {
        /*mDialogHelper.*/
        showMessageDialog("MessageDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("MessageDialog callBack");
            }
        });
    }

    public void showSuccessDialog(View view) {
        /*mDialogHelper.*/
        showSuccessDialog("SuccessDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("SuccessDialog callBack");
            }
        });
    }

    public void showWarningDialog(View view) {
        /*mDialogHelper.*/
        showWarningDialog("WarningDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("WarningDialog callBack");
            }
        });
    }

    public void showErrorDialog(View view) {
        /*mDialogHelper.*/
        showErrorDialog("ErrorDialog", new OnDialogConfirmListener() {
            @Override
            public void onDialogConfirmListener(AlertDialog dialog) {
                showToast("ErrorDialog callBack");
            }
        });
    }

    public void showConfirmDialog(View view) {
        /*mDialogHelper.*/
        showConfirmDialog("ConfirmDialog", "确定", "取消", new OnDialogConfirmListener() {
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


//    private void showToast(String msg) {
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDialogCancelListener(AlertDialog dialog) {
        Toast.makeText(this, "弹窗关闭", Toast.LENGTH_SHORT).show();
    }
}
