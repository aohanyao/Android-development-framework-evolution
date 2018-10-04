package com.td.framework.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;

import com.td.framework.module.dialog.DialogHelper;
import com.td.framework.module.dialog.inf.OnDialogCancelListener;
import com.td.framework.module.dialog.inf.OnDialogConfirmListener;

/**
 * 有弹窗的BaseFragment
 * ----------------------------
 * v0.1 2018年10月04日15:04:23
 * 创建完成
 * ----------------------------
 */
public class CandyLoadingBaseFragment extends CandyBaseFragment implements OnDialogCancelListener {
    protected DialogHelper mDialogHelper;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mDialogHelper == null) {
            mDialogHelper = new DialogHelper(mActivity, this);
        }
    }

    /**
     * 显示 loading 弹窗,默认不能点击空白处进行取消
     *
     * @param loadingTip 信息提示
     */
    public void showLoadingDialog(String loadingTip) {
        showLoadingDialog(loadingTip, true);
    }

    /**
     * 显示 loading 弹窗
     *
     * @param loadingTip 信息提示
     * @param cancelable 能不能点击空白的地方
     */
    public void showLoadingDialog(String loadingTip, Boolean cancelable) {
        mDialogHelper.showLoadingDialog(loadingTip, cancelable);
    }

    /**
     * 信息提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showMessageDialog(String message) {
        mDialogHelper.showMessageDialog(message);
    }

    /**
     * 信息提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showMessageDialog(String message, OnDialogConfirmListener confirmListener) {
        mDialogHelper.showMessageDialog(message, confirmListener);
    }

    /**
     * 成功提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showSuccessDialog(String message) {
        mDialogHelper.showSuccessDialog(message);
    }

    /**
     * 成功提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showSuccessDialog(String message, OnDialogConfirmListener confirmListener) {
        mDialogHelper.showSuccessDialog(message, confirmListener);
    }

    /**
     * 警告提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showWarningDialog(String message) {
        mDialogHelper.showWarningDialog(message);
    }

    /**
     * 警告提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showWarningDialog(String message, OnDialogConfirmListener confirmListener) {
        mDialogHelper.showWarningDialog(message, confirmListener);
    }

    /**
     * 错误提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showErrorDialog(String message) {
        mDialogHelper.showErrorDialog(message);
    }

    /**
     * 错误提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showErrorDialog(String message, OnDialogConfirmListener confirmListener) {
        mDialogHelper.showErrorDialog(message, confirmListener);
    }

    /**
     * 显示确认弹窗
     *
     * @param message         提示信息
     * @param confirmText     确认按钮文字
     * @param cancelText      取消按钮文字
     * @param confirmListener 确认按钮点击回调
     * @param cancelListener  取消按钮点击回调
     */
    public void showConfirmDialog(String message,
                                  String confirmText,
                                  String cancelText,
                                  final OnDialogConfirmListener confirmListener,
                                  final OnDialogCancelListener cancelListener) {

        mDialogHelper.showConfirmDialog(message, confirmText, cancelText, confirmListener, cancelListener);

    }

    /**
     * 显示确认弹窗
     *
     * @param message         提示信息
     * @param confirmText     确认按钮文字
     * @param cancelText      取消按钮文字
     * @param confirmListener 确认按钮点击回调
     */
    public void showConfirmDialog(String message,
                                  String confirmText,
                                  String cancelText,
                                  OnDialogConfirmListener confirmListener) {

        showConfirmDialog(message, confirmText, cancelText, confirmListener, null);
    }

    /**
     * 显示确认弹窗
     *
     * @param message         提示信息
     * @param confirmListener 确认按钮点击回调
     */
    public void showConfirmDialog(String message,
                                  OnDialogConfirmListener confirmListener) {
        showConfirmDialog(message, "确定", "取消", confirmListener, null);
    }


    @Override
    public void onDialogCancelListener(AlertDialog dialog) {
        //空实现，让子类做自己想做的事情
    }

    /**
     * 关闭弹窗
     */
    public void dismissDialog() {
        mDialogHelper.dismissDialog();
    }
}
