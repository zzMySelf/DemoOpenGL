package com.baidu.swan.apps.publisher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.swan.apps.publisher.handler.SPSwitchRootLayoutHandler;

public class SPSwitchRootLinearLayout extends LinearLayout {
    private SPSwitchRootLayoutHandler conflictHandler;

    public SPSwitchRootLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SPSwitchRootLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SPSwitchRootLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.conflictHandler = new SPSwitchRootLayoutHandler(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.conflictHandler.handleBeforeMeasure(View.MeasureSpec.getSize(widthMeasureSpec), View.MeasureSpec.getSize(heightMeasureSpec));
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
