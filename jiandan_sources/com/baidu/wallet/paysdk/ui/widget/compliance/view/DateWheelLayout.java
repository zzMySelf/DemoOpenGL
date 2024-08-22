package com.baidu.wallet.paysdk.ui.widget.compliance.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.a;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.b;
import com.baidu.wallet.paysdk.ui.widget.compliance.c.f;
import com.baidu.wallet.paysdk.ui.widget.compliance.entity.DateEntity;
import com.tera.scan.app.R$styleable;
import java.util.Arrays;
import java.util.List;

public class DateWheelLayout extends BaseWheelLayout {
    public NumberWheelView a;
    public NumberWheelView b;
    public NumberWheelView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public DateEntity g;
    public DateEntity h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f3636i;
    public Integer j;
    public Integer k;
    public b l;
    public boolean m = true;

    public DateWheelLayout(Context context) {
        super(context);
    }

    public final TextView getDayLabelView() {
        return this.f;
    }

    public final NumberWheelView getDayWheelView() {
        return this.c;
    }

    public final DateEntity getEndValue() {
        return this.h;
    }

    public final TextView getMonthLabelView() {
        return this.e;
    }

    public final NumberWheelView getMonthWheelView() {
        return this.b;
    }

    public final int getSelectedDay() {
        return ((Integer) this.c.getCurrentItem()).intValue();
    }

    public final int getSelectedMonth() {
        return ((Integer) this.b.getCurrentItem()).intValue();
    }

    public final int getSelectedYear() {
        return ((Integer) this.a.getCurrentItem()).intValue();
    }

    public final DateEntity getStartValue() {
        return this.g;
    }

    public final TextView getYearLabelView() {
        return this.d;
    }

    public final NumberWheelView getYearWheelView() {
        return this.a;
    }

    public void onAttributeSet(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DxmDateWheelLayout);
        setDateMode(obtainStyledAttributes.getInt(0, 0));
        String string = obtainStyledAttributes.getString(3);
        String string2 = obtainStyledAttributes.getString(2);
        String string3 = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        setDateLabel(string, string2, string3);
    }

    public void onInit(@NonNull Context context) {
        this.a = (NumberWheelView) findViewById(R.id.wheel_picker_date_year_wheel);
        this.b = (NumberWheelView) findViewById(R.id.wheel_picker_date_month_wheel);
        this.c = (NumberWheelView) findViewById(R.id.wheel_picker_date_day_wheel);
        this.d = (TextView) findViewById(R.id.wheel_picker_date_year_label);
        this.e = (TextView) findViewById(R.id.wheel_picker_date_month_label);
        this.f = (TextView) findViewById(R.id.wheel_picker_date_day_label);
    }

    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (i2 == 0 && this.g == null && this.h == null) {
            setRange(DateEntity.today(), DateEntity.yearOnFuture(30), DateEntity.today());
        }
    }

    public void onWheelScrollStateChanged(WheelView wheelView, int i2) {
        int id = wheelView.getId();
        boolean z = true;
        if (id == R.id.wheel_picker_date_year_wheel) {
            this.b.setEnabled(i2 == 0);
            NumberWheelView numberWheelView = this.c;
            if (i2 != 0) {
                z = false;
            }
            numberWheelView.setEnabled(z);
        } else if (id == R.id.wheel_picker_date_month_wheel) {
            this.a.setEnabled(i2 == 0);
            NumberWheelView numberWheelView2 = this.c;
            if (i2 != 0) {
                z = false;
            }
            numberWheelView2.setEnabled(z);
        } else if (id == R.id.wheel_picker_date_day_wheel) {
            this.a.setEnabled(i2 == 0);
            NumberWheelView numberWheelView3 = this.b;
            if (i2 != 0) {
                z = false;
            }
            numberWheelView3.setEnabled(z);
        }
    }

    public void onWheelSelected(WheelView wheelView, int i2) {
        int id = wheelView.getId();
        if (id == R.id.wheel_picker_date_year_wheel) {
            this.f3636i = (Integer) this.a.getItem(i2);
            if (this.m) {
                this.j = null;
                this.k = null;
            }
            a(this.f3636i.intValue());
            a();
        } else if (id == R.id.wheel_picker_date_month_wheel) {
            this.j = (Integer) this.b.getItem(i2);
            if (this.m) {
                this.k = null;
            }
            a(this.f3636i.intValue(), this.j.intValue());
            a();
        } else if (id == R.id.wheel_picker_date_day_wheel) {
            this.k = (Integer) this.c.getItem(i2);
            a();
        }
    }

    public int provideLayoutRes() {
        return R.layout.dxm_wallet_wheel_picker_date;
    }

    public List<WheelView> provideWheelViews() {
        return Arrays.asList(new WheelView[]{this.a, this.b, this.c});
    }

    public void setDateFormatter(final a aVar) {
        if (aVar != null) {
            this.a.setFormatter(new f() {
                public String a(@NonNull Object obj) {
                    return aVar.a(((Integer) obj).intValue());
                }
            });
            this.b.setFormatter(new f() {
                public String a(@NonNull Object obj) {
                    return aVar.b(((Integer) obj).intValue());
                }
            });
            this.c.setFormatter(new f() {
                public String a(@NonNull Object obj) {
                    return aVar.c(((Integer) obj).intValue());
                }
            });
        }
    }

    public void setDateLabel(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.d.setText(charSequence);
        this.e.setText(charSequence2);
        this.f.setText(charSequence3);
    }

    public void setDateMode(int i2) {
        this.a.setVisibility(0);
        this.d.setVisibility(0);
        this.b.setVisibility(0);
        this.e.setVisibility(0);
        this.c.setVisibility(0);
        this.f.setVisibility(0);
        if (i2 == -1) {
            this.a.setVisibility(8);
            this.d.setVisibility(8);
            this.b.setVisibility(8);
            this.e.setVisibility(8);
            this.c.setVisibility(8);
            this.f.setVisibility(8);
        } else if (i2 == 2) {
            this.a.setVisibility(8);
            this.d.setVisibility(8);
        } else if (i2 == 1) {
            this.c.setVisibility(8);
            this.f.setVisibility(8);
        }
    }

    public void setDefaultValue(DateEntity dateEntity) {
        setRange(this.g, this.h, dateEntity);
    }

    public void setOnDateSelectedListener(b bVar) {
        this.l = bVar;
    }

    public void setRange(DateEntity dateEntity, DateEntity dateEntity2) {
        setRange(dateEntity, dateEntity2, (DateEntity) null);
    }

    public void setResetWhenLinkage(boolean z) {
        this.m = z;
    }

    private void a() {
        if (this.l != null) {
            this.c.post(new Runnable() {
                public void run() {
                    DateWheelLayout.this.l.a(DateWheelLayout.this.f3636i.intValue(), DateWheelLayout.this.j.intValue(), DateWheelLayout.this.k.intValue());
                }
            });
        }
    }

    private void b() {
        int min = Math.min(this.g.getYear(), this.h.getYear());
        int max = Math.max(this.g.getYear(), this.h.getYear());
        Integer num = this.f3636i;
        if (num == null) {
            this.f3636i = Integer.valueOf(min);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), min));
            this.f3636i = valueOf;
            this.f3636i = Integer.valueOf(Math.min(valueOf.intValue(), max));
        }
        this.a.setRange(min, max, 1);
        this.a.setDefaultValue(this.f3636i);
        a(this.f3636i.intValue());
    }

    public void setRange(DateEntity dateEntity, DateEntity dateEntity2, DateEntity dateEntity3) {
        if (dateEntity == null) {
            dateEntity = DateEntity.today();
        }
        if (dateEntity2 == null) {
            dateEntity2 = DateEntity.yearOnFuture(30);
        }
        if (dateEntity2.toTimeInMillis() >= dateEntity.toTimeInMillis()) {
            this.g = dateEntity;
            this.h = dateEntity2;
            if (dateEntity3 != null) {
                this.f3636i = Integer.valueOf(dateEntity3.getYear());
                this.j = Integer.valueOf(dateEntity3.getMonth());
                this.k = Integer.valueOf(dateEntity3.getDay());
            } else {
                this.f3636i = null;
                this.j = null;
                this.k = null;
            }
            b();
            return;
        }
        throw new IllegalArgumentException("Ensure the start date is less than the end date");
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void a(int i2) {
        int i3;
        int i4 = 12;
        if (this.g.getYear() == this.h.getYear()) {
            i3 = Math.min(this.g.getMonth(), this.h.getMonth());
            i4 = Math.max(this.g.getMonth(), this.h.getMonth());
        } else if (i2 == this.g.getYear()) {
            i3 = this.g.getMonth();
        } else {
            if (i2 == this.h.getYear()) {
                i4 = this.h.getMonth();
            }
            i3 = 1;
        }
        Integer num = this.j;
        if (num == null) {
            this.j = Integer.valueOf(i3);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), i3));
            this.j = valueOf;
            this.j = Integer.valueOf(Math.min(valueOf.intValue(), i4));
        }
        this.b.setRange(i3, i4, 1);
        this.b.setDefaultValue(this.j);
        a(i2, this.j.intValue());
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public DateWheelLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    private int b(int i2, int i3) {
        boolean z = true;
        if (i3 == 1) {
            return 31;
        }
        if (i3 != 2) {
            return (i3 == 3 || i3 == 5 || i3 == 10 || i3 == 12 || i3 == 7 || i3 == 8) ? 31 : 30;
        }
        if (i2 <= 0) {
            return 29;
        }
        if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
            z = false;
        }
        return z ? 29 : 28;
    }

    private void a(int i2, int i3) {
        int i4;
        int i5;
        if (i2 == this.g.getYear() && i3 == this.g.getMonth() && i2 == this.h.getYear() && i3 == this.h.getMonth()) {
            i5 = this.g.getDay();
            i4 = this.h.getDay();
        } else if (i2 == this.g.getYear() && i3 == this.g.getMonth()) {
            int day = this.g.getDay();
            i4 = b(i2, i3);
            i5 = day;
        } else {
            if (i2 == this.h.getYear() && i3 == this.h.getMonth()) {
                i4 = this.h.getDay();
            } else {
                i4 = b(i2, i3);
            }
            i5 = 1;
        }
        Integer num = this.k;
        if (num == null) {
            this.k = Integer.valueOf(i5);
        } else {
            Integer valueOf = Integer.valueOf(Math.max(num.intValue(), i5));
            this.k = valueOf;
            this.k = Integer.valueOf(Math.min(valueOf.intValue(), i4));
        }
        this.c.setRange(i5, i4, 1);
        this.c.setDefaultValue(this.k);
    }
}
