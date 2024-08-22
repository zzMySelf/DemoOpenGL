package com.baidu.searchbox.download.center.ui.fusion.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.config.AppConfig;

public class CompleteRecyclerView extends RecyclerView {
    private static final String TAG = "CompleteRecyclerView";
    private boolean isFastSmooth;

    public CompleteRecyclerView(Context context) {
        super(context);
    }

    public CompleteRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CompleteRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthSpec, int heightSpec) {
        try {
            super.onMeasure(widthSpec, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                Log.d(TAG, "CompleteRecyclerView onMeasure exception" + e2.getMessage());
            }
        }
    }

    public void smoothScrollBy(int dx, int dy, Interpolator interpolator, int duration) {
        if (this.isFastSmooth) {
            duration = 0;
        }
        super.smoothScrollBy(dx, dy, interpolator, duration);
    }

    public void setFastSmooth(boolean fastSmooth) {
        this.isFastSmooth = fastSmooth;
    }
}
