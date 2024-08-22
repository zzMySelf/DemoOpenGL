package com.baidu.wallet.base.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;

public class UnableClickView extends LinearLayout implements NoProguard {
    public static final String TAG = UnableClickView.class.getSimpleName();
    public boolean mInterceptEvent;

    public UnableClickView(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.mInterceptEvent) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void setBgColor(String str) {
        try {
            setBackgroundColor(Color.parseColor(str));
        } catch (Exception e) {
            String str2 = TAG;
            LogUtil.d(str2, "exception:: " + e.toString());
        }
    }

    public void setViewClickable(boolean z) {
        this.mInterceptEvent = z;
    }

    public UnableClickView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
