/*
 * Copyright (C) 2012 www.amsoft.cn
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.td.framework.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.road.android.core.R;


/**
 * 描述：Toast工具类.
 */

public class T {


    /**
     * 描述：Toast提示文本.
     *
     * @param text 文本
     */
    public static void showToast(Context context, String text) {
        // 获取布局解析器
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (!TextUtils.isEmpty(text) && null != inflate) {
            // 解析布局
            View layout = inflate.inflate(R.layout.layout_toast, null);
            TextView tvMsg = (TextView) layout.findViewById((R.id.tv_msg));
            tvMsg.setText(text);
            Toast toast = new Toast(context.getApplicationContext());
            // 底部距离150
            toast.setGravity(Gravity.BOTTOM, 0, 150);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }

    }


    /**
     * 描述：Toast提示文本.
     *
     * @param resId 文本的资源ID
     */
    public static void showToast(Context context, int resId) {
        Context mContext = context.getApplicationContext();
        showToast(mContext, mContext.getResources().getString(resId));
    }

    /**
     * 描述：Toast提示文本.
     * <p>
     * 只作为演示使用，正式情况下不要使用
     *
     * @param textStr 文本
     */
    @Deprecated
    public static void showSystemToast(Context context, String textStr) {
        Toast.makeText(context.getApplicationContext(), textStr, Toast.LENGTH_SHORT).show();
    }


    /**
     * 描述：Toast提示文本.
     * <p>
     * 只作为演示使用，正式情况下不要使用
     *
     * @param resId 文本的资源ID
     */
    @Deprecated
    public static void showSystemToast(Context context, int resId) {
        Context mContext = context.getApplicationContext();
        showSystemToast(mContext, mContext.getResources().getString(resId));
    }
}
