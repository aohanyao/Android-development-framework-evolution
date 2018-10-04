package com.td.framework.utils.data;

import android.content.Intent;
import android.os.Parcelable;
import android.util.Pair;

import java.io.Serializable;

/**
 * Intent工具类
 */
public class IntentUtils {
    /**
     * 填充intent数据，暂时只写了常用的一些数据格式，不常用的没写
     *
     * @param intent
     * @param pairs
     */
    public static void fillIntent(Intent intent, Pair<String, Object>[] pairs) {

        if (pairs != null) {
            for (Pair<String, Object> pair : pairs) {
                Object value = pair.second;
                //判断不同的类型，进行强转和存放
                if (value instanceof Boolean) {
                    intent.putExtra(pair.first, (Boolean) value);
                }
                if (value instanceof Byte) {
                    intent.putExtra(pair.first, (Byte) value);
                }
                if (value instanceof Short) {
                    intent.putExtra(pair.first, (Short) value);
                }
                if (value instanceof Long) {
                    intent.putExtra(pair.first, (Long) value);
                }

                if (value instanceof Float) {
                    intent.putExtra(pair.first, (Float) value);
                }

                if (value instanceof Double) {
                    intent.putExtra(pair.first, (Double) value);
                }
                if (value instanceof Integer) {
                    intent.putExtra(pair.first, (Integer) value);
                }
                if (value instanceof String) {
                    intent.putExtra(pair.first, (String) value);
                }
                if (value instanceof Parcelable) {
                    intent.putExtra(pair.first, (Parcelable) value);
                }
                if (value instanceof Serializable) {
                    intent.putExtra(pair.first, (Serializable) value);
                }

            }
        }
    }
}
