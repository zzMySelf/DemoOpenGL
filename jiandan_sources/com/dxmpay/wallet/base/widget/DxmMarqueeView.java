package com.dxmpay.wallet.base.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class DxmMarqueeView extends AppCompatTextView {
    public DxmMarqueeView(Context context) {
        super(context);
        a();
    }

    private void a() {
        setMarqueeRepeatLimit(-1);
        setSingleLine();
    }

    public boolean isFocused() {
        return true;
    }

    public DxmMarqueeView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public DxmMarqueeView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
