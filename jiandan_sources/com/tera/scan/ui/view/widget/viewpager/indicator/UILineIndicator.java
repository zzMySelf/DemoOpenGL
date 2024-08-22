package com.tera.scan.ui.view.widget.viewpager.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import com.tera.scan.ui.view.widget.viewpager.UIViewPager;
import com.tera.scan.ui.view.widget.viewpager.UIWrapPagerAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0002\u0013\u001c\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007H\u0002J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0018\u00101\u001a\u00020.2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014R$\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000eR\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R$\u0010\"\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\t\u001a\u0004\u0018\u00010%@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00064"}, d2 = {"Lcom/tera/scan/ui/view/widget/viewpager/indicator/UILineIndicator;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "bgColor", "getBgColor", "()I", "setBgColor", "(I)V", "curPos", "curPosOffset", "", "dataSetObserver", "com/tera/scan/ui/view/widget/viewpager/indicator/UILineIndicator$dataSetObserver$1", "Lcom/tera/scan/ui/view/widget/viewpager/indicator/UILineIndicator$dataSetObserver$1;", "defaultItemWidth", "itemWidth", "getItemWidth", "setItemWidth", "onAdapterChangeListener", "Landroidx/viewpager/widget/ViewPager$OnAdapterChangeListener;", "onPageChangeListener", "com/tera/scan/ui/view/widget/viewpager/indicator/UILineIndicator$onPageChangeListener$1", "Lcom/tera/scan/ui/view/widget/viewpager/indicator/UILineIndicator$onPageChangeListener$1;", "paint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", "selectColor", "getSelectColor", "setSelectColor", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "getCurPos", "position", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class UILineIndicator extends View {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    public int bgColor;
    public int curPos;
    public float curPosOffset;
    @NotNull
    public final qw dataSetObserver;
    public final int defaultItemWidth;
    public int itemWidth;
    @NotNull
    public final ViewPager.OnAdapterChangeListener onAdapterChangeListener;
    @NotNull
    public final UILineIndicator$onPageChangeListener$1 onPageChangeListener;
    @NotNull
    public final Paint paint;
    @NotNull
    public final RectF rectF;
    public int selectColor;
    @Nullable
    public ViewPager viewPager;

    public static final class qw extends DataSetObserver {
        public final /* synthetic */ UILineIndicator qw;

        public qw(UILineIndicator uILineIndicator) {
            this.qw = uILineIndicator;
        }

        public void onChanged() {
            super.onChanged();
            this.qw.requestLayout();
        }

        public void onInvalidated() {
            super.onInvalidated();
            this.qw.requestLayout();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UILineIndicator(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UILineIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UILineIndicator(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        int qw2 = fe.mmm.qw.f.ad.qw.qw(9.0f, context);
        this.defaultItemWidth = qw2;
        this.itemWidth = qw2;
        this.selectColor = fe.mmm.qw.f.ad.fe.qw.qw.qw(context, R.color.ui_color_gc36);
        this.bgColor = fe.mmm.qw.f.ad.fe.qw.qw.qw(context, R.color.ui_color_gc2);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.FILL);
        this.paint = paint2;
        this.rectF = new RectF();
        this.onPageChangeListener = new UILineIndicator$onPageChangeListener$1(this);
        this.onAdapterChangeListener = new fe.mmm.qw.f.de.de.fe.fe.qw(this);
        this.dataSetObserver = new qw(this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UILineIndicator, i2, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…dicator, defStyleAttr, 0)");
            setItemWidth(obtainStyledAttributes.getDimensionPixelOffset(1, this.itemWidth));
            setSelectColor(obtainStyledAttributes.getColor(2, this.selectColor));
            setBgColor(obtainStyledAttributes.getColor(0, this.bgColor));
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: private */
    public final int getCurPos(int i2) {
        PagerAdapter wrapAdapter;
        ViewPager viewPager2 = this.viewPager;
        PagerAdapter pagerAdapter = null;
        UIViewPager uIViewPager = viewPager2 instanceof UIViewPager ? (UIViewPager) viewPager2 : null;
        if (uIViewPager == null || (wrapAdapter = uIViewPager.getWrapAdapter()) == null) {
            ViewPager viewPager3 = this.viewPager;
            if (viewPager3 != null) {
                pagerAdapter = viewPager3.getAdapter();
            }
        } else {
            pagerAdapter = wrapAdapter;
        }
        return pagerAdapter instanceof UIWrapPagerAdapter ? ((UIWrapPagerAdapter) pagerAdapter).getRealPosition(i2) : i2;
    }

    /* renamed from: onAdapterChangeListener$lambda-1  reason: not valid java name */
    public static final void m927onAdapterChangeListener$lambda1(UILineIndicator uILineIndicator, ViewPager viewPager2, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
        Intrinsics.checkNotNullParameter(uILineIndicator, "this$0");
        Intrinsics.checkNotNullParameter(viewPager2, "<anonymous parameter 0>");
        if (pagerAdapter != null) {
            pagerAdapter.unregisterDataSetObserver(uILineIndicator.dataSetObserver);
        }
        if (pagerAdapter2 != null) {
            pagerAdapter2.registerDataSetObserver(uILineIndicator.dataSetObserver);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getItemWidth() {
        return this.itemWidth;
    }

    public final int getSelectColor() {
        return this.selectColor;
    }

    @Nullable
    public final ViewPager getViewPager() {
        return this.viewPager;
    }

    public void onDraw(@Nullable Canvas canvas) {
        PagerAdapter adapter;
        super.onDraw(canvas);
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null && (adapter = viewPager2.getAdapter()) != null && adapter.getCount() > 0) {
            float measuredHeight = ((float) getMeasuredHeight()) / 2.0f;
            this.paint.setColor(this.bgColor);
            this.rectF.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
            if (canvas != null) {
                canvas.drawRoundRect(this.rectF, measuredHeight, measuredHeight, this.paint);
            }
            this.paint.setColor(this.selectColor);
            int i2 = this.itemWidth;
            float f = ((float) i2) * (((float) this.curPos) + this.curPosOffset);
            float f2 = ((float) i2) + f;
            if (f2 > ((float) getMeasuredWidth())) {
                this.rectF.set(0.0f, 0.0f, f2 - ((float) getMeasuredWidth()), (float) getMeasuredHeight());
                if (canvas != null) {
                    canvas.drawRoundRect(this.rectF, measuredHeight, measuredHeight, this.paint);
                }
            }
            this.rectF.set(f, 0.0f, RangesKt___RangesKt.coerceAtMost((float) getMeasuredWidth(), f2), (float) getMeasuredHeight());
            if (canvas != null) {
                canvas.drawRoundRect(this.rectF, measuredHeight, measuredHeight, this.paint);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getAdapter();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r3, int r4) {
        /*
            r2 = this;
            androidx.viewpager.widget.ViewPager r0 = r2.viewPager
            if (r0 == 0) goto L_0x000f
            androidx.viewpager.widget.PagerAdapter r0 = r0.getAdapter()
            if (r0 == 0) goto L_0x000f
            int r0 = r0.getCount()
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            int r1 = r2.itemWidth
            int r1 = r1 * r0
            int r3 = android.view.View.MeasureSpec.getMode(r3)
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r3)
            super.onMeasure(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.widget.viewpager.indicator.UILineIndicator.onMeasure(int, int):void");
    }

    public final void setBgColor(int i2) {
        this.bgColor = i2;
        postInvalidate();
    }

    public final void setItemWidth(int i2) {
        this.itemWidth = i2;
        postInvalidate();
    }

    public final void setSelectColor(int i2) {
        this.selectColor = i2;
        postInvalidate();
    }

    public final void setViewPager(@Nullable ViewPager viewPager2) {
        ViewPager viewPager3 = this.viewPager;
        if (viewPager3 != null) {
            viewPager3.removeOnPageChangeListener(this.onPageChangeListener);
        }
        ViewPager viewPager4 = this.viewPager;
        if (viewPager4 != null) {
            viewPager4.removeOnAdapterChangeListener(this.onAdapterChangeListener);
        }
        this.viewPager = viewPager2;
        if (viewPager2 != null) {
            viewPager2.addOnAdapterChangeListener(this.onAdapterChangeListener);
        }
        ViewPager viewPager5 = this.viewPager;
        if (viewPager5 != null) {
            viewPager5.addOnPageChangeListener(this.onPageChangeListener);
        }
        postInvalidate();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UILineIndicator(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
