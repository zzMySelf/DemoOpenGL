package com.baidu.wallet.paysdk.ui.widget.compliance.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.d;
import com.tera.scan.app.R$styleable;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseWheelLayout extends LinearLayout implements d {
    public final List<WheelView> a = new ArrayList();

    public BaseWheelLayout(Context context) {
        super(context);
        a(context, (AttributeSet) null, R.attr.DxmWheelStyle, R.style.DxmWheelDefault);
    }

    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        setOrientation(1);
        LinearLayout.inflate(context, provideLayoutRes(), this);
        onInit(context);
        this.a.clear();
        this.a.addAll(provideWheelViews());
        b(context, attributeSet, i2, i3);
        for (WheelView onWheelChangedListener : this.a) {
            onWheelChangedListener.setOnWheelChangedListener(this);
        }
    }

    private void b(Context context, AttributeSet attributeSet, int i2, int i3) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().scaledDensity;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DxmBaseWheelLayout, i2, i3);
        float f3 = f2 * 15.0f;
        setTextSize(obtainStyledAttributes.getDimension(1, f3));
        setSelectedTextSize(obtainStyledAttributes.getDimension(2, f3));
        setIndicatorSize(obtainStyledAttributes.getDimension(0, f * 1.0f));
        obtainStyledAttributes.recycle();
        onAttributeSet(context, attributeSet);
    }

    public void onAttributeSet(@NonNull Context context, @Nullable AttributeSet attributeSet) {
    }

    public void onInit(@NonNull Context context) {
    }

    public void onWheelLoopFinished(WheelView wheelView) {
    }

    public void onWheelScrollStateChanged(WheelView wheelView, int i2) {
    }

    public void onWheelScrolled(WheelView wheelView, int i2) {
    }

    @LayoutRes
    public abstract int provideLayoutRes();

    public abstract List<WheelView> provideWheelViews();

    public void setDefaultItemPosition(int i2) {
        for (WheelView defaultPosition : this.a) {
            defaultPosition.setDefaultPosition(i2);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (WheelView enabled : this.a) {
            enabled.setEnabled(z);
        }
    }

    public void setIndicatorSize(@Px float f) {
        for (WheelView indicatorSize : this.a) {
            indicatorSize.setIndicatorSize(f);
        }
    }

    public void setSelectedTextSize(@Px float f) {
        for (WheelView selectedTextSize : this.a) {
            selectedTextSize.setSelectedTextSize(f);
        }
    }

    public void setStyle(@StyleRes int i2) {
        b(getContext(), (AttributeSet) null, R.attr.DxmWheelStyle, i2);
        requestLayout();
        invalidate();
    }

    public void setTextSize(@Px float f) {
        for (WheelView textSize : this.a) {
            textSize.setTextSize(f);
        }
    }

    public void setVisibleItemCount(int i2) {
        for (WheelView visibleItemCount : this.a) {
            visibleItemCount.setVisibleItemCount(i2);
        }
    }

    public BaseWheelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, R.attr.DxmWheelStyle, R.style.DxmWheelDefault);
    }

    public BaseWheelLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2, R.style.DxmWheelDefault);
    }

    public BaseWheelLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2, i3);
    }
}
