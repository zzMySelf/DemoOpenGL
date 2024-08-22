package com.baidu.wallet.paysdk.ui.widget.compliance.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.ui.widget.compliance.a.a;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.c;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.f;
import com.tera.scan.app.R$styleable;
import java.util.Arrays;
import java.util.List;

public class LinkageWheelLayout extends BaseWheelLayout {
    public WheelView a;
    public WheelView b;
    public WheelView c;
    public int d;
    public int e;
    public int f;
    public List<a> g;
    public List<a> h;

    /* renamed from: i  reason: collision with root package name */
    public List<a> f3637i;
    public c j;

    public LinkageWheelLayout(Context context) {
        super(context);
    }

    public final WheelView getFirstWheelView() {
        return this.a;
    }

    public final WheelView getSecondWheelView() {
        return this.b;
    }

    public final WheelView getThirdWheelView() {
        return this.c;
    }

    @CallSuper
    public void onAttributeSet(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DxmLinkageWheelLayout);
        setFirstVisible(obtainStyledAttributes.getBoolean(1, true));
        setThirdVisible(obtainStyledAttributes.getBoolean(4, true));
        obtainStyledAttributes.getString(0);
        obtainStyledAttributes.getString(2);
        obtainStyledAttributes.getString(3);
        obtainStyledAttributes.recycle();
    }

    @CallSuper
    public void onInit(@NonNull Context context) {
        this.a = (WheelView) findViewById(R.id.wheel_picker_linkage_first_wheel);
        this.b = (WheelView) findViewById(R.id.wheel_picker_linkage_second_wheel);
        this.c = (WheelView) findViewById(R.id.wheel_picker_linkage_third_wheel);
    }

    @CallSuper
    public void onWheelScrollStateChanged(WheelView wheelView, int i2) {
        int id = wheelView.getId();
        boolean z = true;
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            this.b.setEnabled(i2 == 0);
            WheelView wheelView2 = this.c;
            if (i2 != 0) {
                z = false;
            }
            wheelView2.setEnabled(z);
        } else if (id == R.id.wheel_picker_linkage_second_wheel) {
            this.a.setEnabled(i2 == 0);
            WheelView wheelView3 = this.c;
            if (i2 != 0) {
                z = false;
            }
            wheelView3.setEnabled(z);
        } else if (id == R.id.wheel_picker_linkage_third_wheel) {
            this.a.setEnabled(i2 == 0);
            WheelView wheelView4 = this.b;
            if (i2 != 0) {
                z = false;
            }
            wheelView4.setEnabled(z);
        }
    }

    @CallSuper
    public void onWheelSelected(WheelView wheelView, final int i2) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_linkage_first_wheel) {
            this.d = i2;
            this.e = 0;
            this.f = 0;
            if (this.j != null) {
                this.c.post(new Runnable() {
                    public void run() {
                        LinkageWheelLayout.this.j.a(i2);
                    }
                });
            }
        } else if (id == R.id.wheel_picker_linkage_second_wheel) {
            this.e = i2;
            this.f = 0;
            if (this.j != null) {
                this.c.post(new Runnable() {
                    public void run() {
                        LinkageWheelLayout.this.j.b(i2);
                    }
                });
            }
        } else if (id == R.id.wheel_picker_linkage_third_wheel) {
            this.f = i2;
            if (this.j != null) {
                this.c.post(new Runnable() {
                    public void run() {
                        LinkageWheelLayout.this.j.c(i2);
                    }
                });
            }
        }
    }

    public int provideLayoutRes() {
        return R.layout.dxm_wallet_wheel_picker_linkage;
    }

    @CallSuper
    public List<WheelView> provideWheelViews() {
        return Arrays.asList(new WheelView[]{this.a, this.b, this.c});
    }

    public void setFirstData(@NonNull List<a> list) {
        if (list == null || list.isEmpty() || list.size() <= 0) {
            setFirstVisible(false);
            return;
        }
        setFirstVisible(true);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = list;
        this.a.setData(list);
        this.a.setDefaultPosition(this.d);
    }

    public void setFirstVisible(boolean z) {
        if (z) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }

    public void setFormatter(f fVar, f fVar2, f fVar3) {
        this.a.setFormatter(fVar);
        this.b.setFormatter(fVar2);
        this.c.setFormatter(fVar3);
    }

    public void setOnLinkageSelectedListener(c cVar) {
        this.j = cVar;
    }

    public void setSecondData(@NonNull List<a> list) {
        if (list == null || list.isEmpty() || list.size() <= 0) {
            setSecondVisible(false);
            return;
        }
        setSecondVisible(true);
        this.e = 0;
        this.f = 0;
        this.h = list;
        this.b.setData(list);
        this.b.setDefaultPosition(this.e);
    }

    public void setSecondVisible(boolean z) {
        if (z) {
            this.b.setVisibility(0);
        } else {
            this.b.setVisibility(8);
        }
    }

    public void setSelectValue(int i2, int i3, int i4) {
        List<a> list = this.g;
        if (list != null && list.size() > i2) {
            this.d = i2;
            this.a.setDefaultPosition(i2);
        }
        List<a> list2 = this.h;
        if (list2 != null && list2.size() > i3) {
            this.e = i3;
            this.b.setDefaultPosition(i3);
        }
        List<a> list3 = this.f3637i;
        if (list3 != null && list3.size() > i4) {
            this.f = i4;
            this.c.setDefaultPosition(i4);
        }
    }

    public void setThirdData(@NonNull List<a> list) {
        if (list == null || list.isEmpty() || list.size() <= 0) {
            setThirdVisible(false);
            return;
        }
        setThirdVisible(true);
        this.f = 0;
        this.f3637i = list;
        this.c.setData(list);
        this.c.setDefaultPosition(this.f);
    }

    public void setThirdVisible(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public LinkageWheelLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }
}
