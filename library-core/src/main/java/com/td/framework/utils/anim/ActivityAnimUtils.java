package com.td.framework.utils.anim;

import android.app.Activity;

import com.road.android.core.R;


/**
 * Activity的跳转动画
 *
 * @author aohanyao create in 2018年10月04日02:36:34
 */
public class ActivityAnimUtils {
    /**
     * 跳转到
     *
     * @param activity
     */
    public static void to(Activity activity) {
        activity.overridePendingTransition(R.anim.setup_next_in,
                R.anim.setup_next_out);

    }

    /**
     * 退出动画
     */
    public static void out(Activity activity) {
        activity.overridePendingTransition(R.anim.setup_pre_in, R.anim.setup_pre_out);
    }
}
