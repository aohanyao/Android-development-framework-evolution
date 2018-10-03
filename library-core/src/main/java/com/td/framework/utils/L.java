package com.td.framework.utils;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Logcat工具类
 */
public class L {
    private L() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 是否需要打印bug，可以在application的onCreate函数里面初始化
     */
    private static boolean mIsDebug = true;


    /**
     * 初始化
     */
    public static void init(Boolean isDebug) {
        Logger.addLogAdapter(new AndroidLogAdapter());
        mIsDebug = isDebug;
    }


    public static void i(String msg) {
        if (mIsDebug)
            Logger.i(msg);
    }

    public static void d(String msg) {
        if (mIsDebug)
            Logger.d(msg);
    }

    public static void e(String msg) {
        if (mIsDebug)
            Logger.e(msg);
    }

    public static void v(String msg) {
        if (mIsDebug)
            Logger.v(msg);
    }

    public static void json(String json) {
        if (mIsDebug)
            Logger.json(json);
    }

    public static void xml(String xml) {
        if (mIsDebug)
            Logger.xml(xml);
    }

    public static void list(Object list) {
        if (mIsDebug)
            Logger.d(list);
    }
}