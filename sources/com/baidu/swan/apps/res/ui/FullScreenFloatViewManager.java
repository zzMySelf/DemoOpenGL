package com.baidu.swan.apps.res.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.baidu.swan.apps.R;

public class FullScreenFloatViewManager {
    public static final int TYPE_BUTTON = 2;
    public static final int TYPE_IMAGE_VIEW = 1;

    public static FullScreenFloatView addFloatView(Context context, ViewGroup contentView) {
        return addFloatView(context, contentView, 1);
    }

    public static FullScreenFloatView addFloatView(Context context, ViewGroup contentView, int floatType) {
        if (context == null || contentView == null) {
            return null;
        }
        FullScreenFloatView floatView = inflateFloatView(context, floatType);
        contentView.addView(floatView);
        return floatView;
    }

    private static FullScreenFloatView inflateFloatView(Context context, int floatType) {
        if (context == null) {
            return null;
        }
        int layoutRes = R.layout.aiapps_fullscreen_floatview;
        if (floatType == 1) {
            layoutRes = R.layout.aiapps_fullscreen_floatview;
        } else if (floatType == 2) {
            layoutRes = R.layout.aiapps_fullscreen_floatview_button;
        }
        return (FullScreenFloatView) LayoutInflater.from(context.getApplicationContext()).inflate(layoutRes, (ViewGroup) null);
    }
}
