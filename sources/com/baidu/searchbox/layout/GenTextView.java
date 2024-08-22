package com.baidu.searchbox.layout;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.baidu.searchbox.adjustment.Adjust;
import com.baidu.searchbox.adjustment.AdjustHelper;
import com.baidu.searchbox.adjustment.AdjustTrigger;
import com.baidu.searchbox.adjustment.Adjustment;
import com.baidu.searchbox.resources.ColorValue;
import com.baidu.searchbox.resources.DimenValue;
import com.baidu.searchbox.resources.ResourceGroup;
import com.baidu.searchbox.ui.span.BdSpanTouchFixTextView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0014\u0010\u0017\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\b\u0010\u001b\u001a\u00020\nH\u0016J \u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\b\b\u0002\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020$J\u000e\u0010'\u001a\u00020\u00152\u0006\u0010&\u001a\u00020$J\u0018\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,J\u0014\u0010-\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u0014\u0010.\u001a\u00020\u00152\f\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0019J\u000e\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u00064"}, d2 = {"Lcom/baidu/searchbox/layout/GenTextView;", "Lcom/baidu/searchbox/ui/span/BdSpanTouchFixTextView;", "Lcom/baidu/searchbox/adjustment/AdjustTrigger;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "helper", "Lcom/baidu/searchbox/adjustment/AdjustHelper;", "lineHeightWithoutLineSpace", "", "getLineHeightWithoutLineSpace", "()Z", "setLineHeightWithoutLineSpace", "(Z)V", "adjust", "", "type", "backgroundColor", "colorValues", "Lcom/baidu/searchbox/resources/ResourceGroup;", "Lcom/baidu/searchbox/resources/ColorValue;", "getLineHeight", "preset", "selfTags", "", "", "adjustment", "Lcom/baidu/searchbox/adjustment/Adjustment;", "setBoldWithStroke", "strokeWidth", "", "setTextSizeDp", "size", "setTextSizePx", "setTextWith", "text", "", "bufferType", "Landroid/widget/TextView$BufferType;", "textColor", "textSize", "dimeValues", "Lcom/baidu/searchbox/resources/DimenValue;", "textStyle", "style", "Companion", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: layout.kt */
public class GenTextView extends BdSpanTouchFixTextView implements AdjustTrigger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final Function1<Context, GenTextView> factory = GenTextView$Companion$factory$1.INSTANCE;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final AdjustHelper helper;
    private boolean lineHeightWithoutLineSpace;

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
    public GenTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new AdjustHelper();
        preset$default(this, (List) null, (Adjustment) null, 3, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new AdjustHelper();
        preset$default(this, (List) null, (Adjustment) null, 3, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenTextView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.helper = new AdjustHelper();
        preset$default(this, (List) null, (Adjustment) null, 3, (Object) null);
    }

    public final boolean getLineHeightWithoutLineSpace() {
        return this.lineHeightWithoutLineSpace;
    }

    public final void setLineHeightWithoutLineSpace(boolean z) {
        this.lineHeightWithoutLineSpace = z;
    }

    public static /* synthetic */ GenTextView preset$default(GenTextView genTextView, List list, Adjustment adjustment, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                list = CollectionsKt.emptyList();
            }
            if ((i2 & 2) != 0) {
                adjustment = Adjust.getEmptyAdjustment();
            }
            return genTextView.preset(list, adjustment);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preset");
    }

    public final GenTextView preset(List<String> selfTags, Adjustment adjustment) {
        Intrinsics.checkNotNullParameter(selfTags, "selfTags");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        AdjustHelper adjustHelper = this.helper;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return (GenTextView) adjustHelper.preset(context, this, adjustment, selfTags, true);
    }

    public final void textStyle(int style) {
        setTypeface(getTypeface(), style);
    }

    public final void textSize(ResourceGroup<DimenValue> dimeValues) {
        Intrinsics.checkNotNullParameter(dimeValues, "dimeValues");
        this.helper.dimen(4, dimeValues, Adjust.dimenAdjustFunc(new GenTextView$textSize$1(this)));
    }

    public final void textColor(ResourceGroup<ColorValue> colorValues) {
        Intrinsics.checkNotNullParameter(colorValues, "colorValues");
        this.helper.color(5, colorValues, Adjust.colorAdjustFunc(new GenTextView$textColor$1(this)));
    }

    public final void backgroundColor(ResourceGroup<ColorValue> colorValues) {
        Intrinsics.checkNotNullParameter(colorValues, "colorValues");
        this.helper.color(3, colorValues, Adjust.colorAdjustFunc(new GenTextView$backgroundColor$1(this)));
    }

    public void adjust() {
        this.helper.adjust();
    }

    public void adjust(int type) {
        this.helper.adjust(type);
    }

    public final void setTextSizeDp(float size) {
        setTextSize(1, size);
    }

    public final void setTextSizePx(float size) {
        setTextSize(0, size);
    }

    public static /* synthetic */ void setTextWith$default(GenTextView genTextView, CharSequence charSequence, TextView.BufferType bufferType, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                bufferType = TextView.BufferType.NORMAL;
            }
            genTextView.setTextWith(charSequence, bufferType);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTextWith");
    }

    public final void setTextWith(CharSequence text, TextView.BufferType bufferType) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(bufferType, "bufferType");
        setTextWithUnifiedPadding(text, bufferType);
    }

    public final void setBoldWithStroke(float strokeWidth) {
        getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        getPaint().setStrokeWidth(strokeWidth);
    }

    public int getLineHeight() {
        if (this.lineHeightWithoutLineSpace) {
            return MathKt.roundToInt((getTextSize() * getLineSpacingMultiplier()) + getLineSpacingExtra());
        }
        return super.getLineHeight();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/layout/GenTextView$Companion;", "", "()V", "factory", "Lkotlin/Function1;", "Landroid/content/Context;", "Lcom/baidu/searchbox/layout/GenTextView;", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: layout.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
