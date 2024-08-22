package com.tera.scan.ui.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;

public class PatchedTextView extends TextView {
    public PatchedTextView(Context context) {
        super(context);
        init();
    }

    @TargetApi(16)
    private void init() {
        if (Build.VERSION.SDK_INT >= 16 && getMaxLines() == 1) {
            setSingleLine(true);
        }
    }

    public PatchedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PatchedTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
