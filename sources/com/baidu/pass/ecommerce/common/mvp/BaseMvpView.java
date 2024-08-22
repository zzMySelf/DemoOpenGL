package com.baidu.pass.ecommerce.common.mvp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class BaseMvpView extends FrameLayout implements IBaseView {
    public BaseMvpView(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void doFailure(int i2, String str) {
        doFailure(Integer.MIN_VALUE, i2, str);
    }

    public final void doResult(Object obj) {
        doResult(Integer.MIN_VALUE, obj);
    }

    public void showLoading(int i2) {
    }

    public BaseMvpView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void doFailure(int i2, int i3, String str) {
        doFailure(i2, i3, str, (String) null);
    }

    public final void doResult(int i2, Object obj) {
        doResult(i2, obj, (String) null);
    }

    public BaseMvpView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
