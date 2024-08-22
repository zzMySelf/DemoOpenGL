package com.baidu.searchbox.canvas;

import android.content.Context;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import com.baidu.searchbox.adjustment.Adjust;
import com.baidu.searchbox.adjustment.AdjustHelper;
import com.baidu.searchbox.adjustment.AdjustTrigger;
import com.baidu.searchbox.adjustment.Adjustment;
import com.baidu.searchbox.qrcode.utils.ResUtils;
import com.baidu.searchbox.resources.ColorValue;
import com.baidu.searchbox.resources.DimenValue;
import com.baidu.searchbox.resources.ResourceGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J\u0014\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J&\u0010\u001c\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020)H\u0016J\u0014\u0010*\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010+\u001a\u00020\u0019J\u0014\u0010,\u001a\u00020\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0013J\u000e\u0010/\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/searchbox/canvas/GenPaint;", "Landroid/text/TextPaint;", "Lcom/baidu/searchbox/adjustment/AdjustTrigger;", "()V", "flags", "", "(I)V", "p", "Landroid/graphics/Paint;", "(Landroid/graphics/Paint;)V", "context", "Landroid/content/Context;", "helper", "Lcom/baidu/searchbox/adjustment/AdjustHelper;", "adjust", "", "type", "backgroundColor", "color", "Lcom/baidu/searchbox/resources/ResourceGroup;", "Lcom/baidu/searchbox/resources/ColorValue;", "ellipsizeEnd", "", "text", "availWidth", "", "getFontMetrics", "Landroid/graphics/Paint$FontMetrics;", "preset", "selfTags", "", "", "adjustment", "Lcom/baidu/searchbox/adjustment/Adjustment;", "setFakeBoldText", "fakeBoldText", "", "setStrokeWidth", "width", "setStyle", "style", "Landroid/graphics/Paint$Style;", "textColor", "textHeight", "textSize", "dimen", "Lcom/baidu/searchbox/resources/DimenValue;", "textWidth", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: canvas.kt */
public class GenPaint extends TextPaint implements AdjustTrigger {
    private Context context;
    private final AdjustHelper helper = new AdjustHelper();

    public GenPaint() {
        setAntiAlias(true);
    }

    public GenPaint(int flags) {
        super(flags);
        setAntiAlias(true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GenPaint(Paint p) {
        super(p);
        Intrinsics.checkNotNullParameter(p, "p");
        setAntiAlias(true);
    }

    public static /* synthetic */ GenPaint preset$default(GenPaint genPaint, Context context2, List list, Adjustment adjustment, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                list = CollectionsKt.emptyList();
            }
            return genPaint.preset(context2, list, adjustment);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preset");
    }

    public final GenPaint preset(Context context2, List<String> selfTags, Adjustment adjustment) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(selfTags, "selfTags");
        Intrinsics.checkNotNullParameter(adjustment, "adjustment");
        this.context = context2;
        return (GenPaint) this.helper.preset(context2, this, adjustment, selfTags, true);
    }

    public final void textSize(ResourceGroup<DimenValue> dimen) {
        Intrinsics.checkNotNullParameter(dimen, ResUtils.DIMEN);
        this.helper.dimen(4, dimen, Adjust.dimenAdjustFunc(new GenPaint$textSize$1(this)));
    }

    public final void textColor(ResourceGroup<ColorValue> color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.helper.color(5, color, Adjust.colorAdjustFunc(new GenPaint$textColor$1(this)));
    }

    public final void backgroundColor(ResourceGroup<ColorValue> color) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.helper.color(5, color, Adjust.colorAdjustFunc(new GenPaint$backgroundColor$1(this)));
    }

    public void adjust() {
        this.helper.adjust();
    }

    public void adjust(int type) {
        this.helper.adjust(type);
    }

    public void setStrokeWidth(float width) {
        super.setStrokeWidth(width);
    }

    public void setStyle(Paint.Style style) {
        Intrinsics.checkNotNullParameter(style, "style");
        super.setStyle(style);
    }

    public void setFakeBoldText(boolean fakeBoldText) {
        super.setFakeBoldText(fakeBoldText);
    }

    public Paint.FontMetrics getFontMetrics() {
        Paint.FontMetrics fontMetrics = super.getFontMetrics();
        Intrinsics.checkNotNullExpressionValue(fontMetrics, "super.getFontMetrics()");
        return fontMetrics;
    }

    public final float textHeight() {
        Paint.FontMetrics it = getFontMetrics();
        return it.bottom - it.top;
    }

    public final float textWidth(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return measureText(text, 0, text.length());
    }

    public final CharSequence ellipsizeEnd(CharSequence text, float availWidth) {
        Intrinsics.checkNotNullParameter(text, "text");
        CharSequence ellipsize = TextUtils.ellipsize(text, this, availWidth, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNullExpressionValue(ellipsize, "ellipsize(text, this, av…TextUtils.TruncateAt.END)");
        return ellipsize;
    }
}
