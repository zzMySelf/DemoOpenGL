package com.baidu.wallet.lightapp.business;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappWebView;

public class LightappBrowserWebView extends LightappWebView {
    public final String a = LightappBrowserWebView.class.getSimpleName();
    public int b = -1;
    public int c = -1;
    public boolean isTop = true;

    public LightappBrowserWebView(Context context) {
        super(context);
    }

    private boolean a() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        int childCount = frameLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (frameLayout.getChildAt(i2) instanceof EditText) {
                return true;
            }
        }
        return false;
    }

    private boolean b() {
        return this.b > 0 && this.c > 0 && a();
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.b < 0 && measuredWidth > 0) {
            this.b = measuredWidth;
        }
        if (this.c < 0 && measuredHeight > 10) {
            this.c = measuredHeight;
        }
        String str = this.a;
        LogUtil.d(str, "onMeasure current:(" + measuredWidth + "," + measuredHeight + ")");
        if (b()) {
            String str2 = this.a;
            LogUtil.d(str2, "onMeasure force to:(" + this.b + "," + this.c + ")");
            setMeasuredDimension(this.b, this.c);
        }
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        if (i3 == 0) {
            this.isTop = true;
        } else if (i3 != 0) {
            this.isTop = false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && getScrollY() <= 0) {
            scrollTo(0, 1);
        }
        return super.onTouchEvent(motionEvent);
    }
}
