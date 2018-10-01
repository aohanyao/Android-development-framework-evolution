package com.td.framework.module.dialog;

import com.td.framework.module.dialog.inf.OnDialogCancelListener;
import com.td.framework.module.dialog.inf.OnDialogConfirmListener;

/**
 * 弹窗帮助类
 */
public class DialogHelper {

    /**
     * 显示 loading 弹窗,默认不能点击空白处进行取消
     *
     * @param loadingTip 信息提示
     */
    public void showLoadingDialog(String loadingTip) {

    }

    /**
     * 显示 loading 弹窗
     *
     * @param loadingTip 信息提示
     * @param cancelable 能不能点击空白的地方
     */
    public void showLoadingDialog(String loadingTip, Boolean cancelable) {

    }

    /**
     * 信息提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showMessageDialog(String message) {

    }

    /**
     * 信息提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showMessageDialog(String message, OnDialogConfirmListener confirmListener) {

    }

    /**
     * 成功提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showSuccessDialog(String message) {

    }

    /**
     * 成功提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showSuccessDialog(String message, OnDialogConfirmListener confirmListener) {

    }

    /**
     * 警告提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showWarningDialog(String message) {

    }

    /**
     * 警告提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showWarningDialog(String message, OnDialogConfirmListener confirmListener) {

    }

    /**
     * 错误提示弹窗
     *
     * @param message 提示信息的内容
     */
    public void showErrorDialog(String message) {

    }

    /**
     * 错误提示弹窗
     *
     * @param message         提示信息的内容
     * @param confirmListener 确认按钮点击的回调
     */
    public void showErrorDialog(String message, OnDialogConfirmListener confirmListener) {

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
                                  OnDialogConfirmListener confirmListener,
                                  OnDialogCancelListener cancelListener) {

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

    }

    /**
     * 显示确认弹窗
     *
     * @param message         提示信息
     * @param confirmListener 确认按钮点击回调
     */
    public void showConfirmDialog(String message,
                                  OnDialogConfirmListener confirmListener) {

    }

    /**
     * 关闭弹窗
     */
    public void dismissDialog() {

    }
}
