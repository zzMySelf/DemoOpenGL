package com.tera.scan.ui.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.IdRes;
import com.tera.scan.ui.view.helper.UIBaseHelper;
import com.tera.scan.ui.view.helper.UIHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00030\u0002B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\b\u0001\u0010\u0018\u001a\u00020\tH\u0016R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/tera/scan/ui/view/widget/UIView;", "Landroid/view/View;", "Lcom/tera/scan/ui/view/helper/UIHelper;", "Lcom/tera/scan/ui/view/helper/UIBaseHelper;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "uiBaseHelper", "dispatchDraw", "", "canvas", "Landroid/graphics/Canvas;", "getHelper", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "refreshDrawableState", "setBackgroundColor", "color", "setBackgroundResource", "resid", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class UIView extends View implements UIHelper<UIBaseHelper<UIView>> {
    @NotNull
    public Map<Integer, View> _$_findViewCache;
    @NotNull
    public final UIBaseHelper<UIView> uiBaseHelper;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public UIView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        UIBaseHelper<UIView> uIBaseHelper = new UIBaseHelper<>(context, this);
        this.uiBaseHelper = uIBaseHelper;
        uIBaseHelper.pf(context, attributeSet, i2);
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

    public void dispatchDraw(@Nullable Canvas canvas) {
        this.uiBaseHelper.rg(canvas);
        super.dispatchDraw(canvas);
    }

    @NotNull
    public UIBaseHelper<UIView> getHelper() {
        return this.uiBaseHelper;
    }

    public void onMeasure(int i2, int i3) {
        int[] eee = this.uiBaseHelper.eee(i2, i3);
        super.onMeasure(eee[0], eee[1]);
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        UIBaseHelper<UIView> uIBaseHelper = this.uiBaseHelper;
        if (uIBaseHelper != null) {
            uIBaseHelper.rrr();
        }
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        UIBaseHelper<UIView> uIBaseHelper = this.uiBaseHelper;
        if (uIBaseHelper != null) {
            uIBaseHelper.aaa(i2);
        }
    }

    public void setBackgroundResource(@IdRes int i2) {
        super.setBackgroundResource(i2);
        UIBaseHelper<UIView> uIBaseHelper = this.uiBaseHelper;
        if (uIBaseHelper != null) {
            uIBaseHelper.qqq(i2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UIView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
