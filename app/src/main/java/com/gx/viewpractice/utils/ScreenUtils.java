package com.gx.viewpractice.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by gaoxuan on 2017/8/26.
 */

public class ScreenUtils {

    public static int getScreenWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        return dm.heightPixels;
    }

    public static float getScreenDensity(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        dm = context.getResources().getDisplayMetrics();
        return dm.density;
    }

    public static int dp2Px(float size, Context context) {
        int length = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size,
                context.getResources().getDisplayMetrics());
        return length;
    }
}
