package com.baidu.searchbox.weather.widget;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeExtKt;
import com.baidu.searchbox.nacomp.extension.fontsize.FontSizeInfo;
import com.baidu.searchbox.nacomp.extension.fontsize.IFontSize;
import com.baidu.searchbox.nacomp.extension.nightmode.INightMode;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import com.baidu.searchbox.weather.R;
import com.baidu.searchbox.weather.util.FontUtilKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00122\b\b\u0001\u0010\u000b\u001a\u00020\tH\u0007J\u0019\u0010\u001c\u001a\u00020\u00122\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010 \u001a\u00020\u00122\b\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0012\u0010#\u001a\u00020\u00122\b\b\u0001\u0010$\u001a\u00020\tH\u0007J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\u0012H\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/weather/widget/AirQualityView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/searchbox/nacomp/extension/nightmode/INightMode;", "Lcom/baidu/searchbox/nacomp/extension/fontsize/IFontSize;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "arrowRes", "bgColorInt", "Ljava/lang/Integer;", "radius", "", "textColorInt", "aptViewCornerSizeChange", "", "view", "Landroid/view/View;", "onFontSizeChange", "info", "Lcom/baidu/searchbox/nacomp/extension/fontsize/FontSizeInfo;", "onNightModeChange", "isNightMode", "", "setArrowRes", "setBgColor", "color", "(Ljava/lang/Integer;)V", "setCornerRadius", "setText", "text", "", "setTextColorRes", "colorInt", "updateArrow", "updateBg", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AirQualityView.kt */
public final class AirQualityView extends FrameLayout implements INightMode, IFontSize {
    public Map<Integer, View> _$_findViewCache;
    private int arrowRes;
    private Integer bgColorInt;
    private float radius;
    private int textColorInt;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AirQualityView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AirQualityView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirQualityView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.air_quality_layout, this);
        ((TextView) _$_findCachedViewById(R.id.tvAirQuality)).setTypeface(FontUtilKt.getNumberFontType());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AirQualityView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void setText(String text) {
        ((TextView) _$_findCachedViewById(R.id.tvAirQuality)).setText(text);
    }

    public final void setTextColorRes(int colorInt) {
        this.textColorInt = colorInt;
        ((TextView) _$_findCachedViewById(R.id.tvAirQuality)).setTextColor(colorInt);
    }

    public final void setArrowRes(int arrowRes2) {
        this.arrowRes = arrowRes2;
        updateArrow(arrowRes2);
    }

    public final void setCornerRadius(float radius2) {
        this.radius = radius2;
    }

    public final void setBgColor(Integer color) {
        this.bgColorInt = color;
        updateBg();
    }

    private final void updateBg() {
        Integer color = this.bgColorInt;
        if (color == null) {
            setBackground((Drawable) null);
            return;
        }
        GradientDrawable pressBg = new GradientDrawable();
        GradientDrawable $this$updateBg_u24lambda_u2d0 = pressBg;
        $this$updateBg_u24lambda_u2d0.setColor(color.intValue());
        $this$updateBg_u24lambda_u2d0.setCornerRadius(FontSizeHelper.getScaledSize(3, ViewExKt.getDpF(this.radius)));
        $this$updateBg_u24lambda_u2d0.setColorFilter(new PorterDuffColorFilter(218103808, PorterDuff.Mode.SRC_ATOP));
        GradientDrawable normalBg = new GradientDrawable();
        GradientDrawable $this$updateBg_u24lambda_u2d1 = normalBg;
        $this$updateBg_u24lambda_u2d1.setCornerRadius(FontSizeHelper.getScaledSize(3, ViewExKt.getDpF(this.radius)));
        $this$updateBg_u24lambda_u2d1.setColor(color.intValue());
        StateListDrawable stateListDrawable = new StateListDrawable();
        StateListDrawable $this$updateBg_u24lambda_u2d2 = stateListDrawable;
        $this$updateBg_u24lambda_u2d2.addState(new int[]{16842919}, pressBg);
        $this$updateBg_u24lambda_u2d2.addState(new int[0], normalBg);
        ((TextView) _$_findCachedViewById(R.id.tvAirQuality)).setBackground(stateListDrawable);
    }

    private final void updateArrow(int arrowRes2) {
        if (arrowRes2 != 0) {
            ((ImageView) _$_findCachedViewById(R.id.imgArrow)).setImageResource(arrowRes2);
        }
    }

    public void onFontSizeChange(FontSizeInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        View _$_findCachedViewById = _$_findCachedViewById(R.id.viewNightMask);
        Intrinsics.checkNotNullExpressionValue(_$_findCachedViewById, "this.viewNightMask");
        aptViewCornerSizeChange(_$_findCachedViewById);
        FontSizeExtKt.updateTextSize((TextView) _$_findCachedViewById(R.id.tvAirQuality), 3);
        FontSizeExtKt.updateHeight((TextView) _$_findCachedViewById(R.id.tvAirQuality), 3);
        FontSizeExtKt.updateSize((ImageView) _$_findCachedViewById(R.id.imgArrow), 3);
        updateBg();
    }

    private final void aptViewCornerSizeChange(View view2) {
        Drawable bg = view2.getBackground();
        if (bg instanceof GradientDrawable) {
            ((GradientDrawable) bg).setCornerRadius(FontSizeHelper.getScaledSize(3, ViewExKt.getDpF(this.radius)));
        }
    }

    public void onNightModeChange(boolean isNightMode) {
        _$_findCachedViewById(R.id.viewNightMask).setVisibility(isNightMode ? 0 : 8);
    }
}
