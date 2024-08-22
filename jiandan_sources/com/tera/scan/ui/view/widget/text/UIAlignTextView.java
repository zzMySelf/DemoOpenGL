package com.tera.scan.ui.view.widget.text;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import com.tera.scan.ui.view.helper.UIHelper;
import com.tera.scan.ui.view.helper.UITextViewHelper;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\u00030\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0002J0\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0011H\u0002J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003H\u0016J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0*J\u001c\u0010+\u001a\u00020\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0006\u0010,\u001a\u00020\u0011J\u0006\u0010-\u001a\u00020\u001bJ\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020#H\u0014J0\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\u00112\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0014J\u0018\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0014J\u0010\u00108\u001a\u00020\u00112\u0006\u00109\u001a\u00020:H\u0017J\b\u0010;\u001a\u00020\u001fH\u0016J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020\u000bH\u0016J\u0012\u0010>\u001a\u00020\u001f2\b\b\u0001\u0010?\u001a\u00020\u000bH\u0016J\u000e\u0010@\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u000bJ(\u0010A\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0016J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u0011H\u0016J\u001c\u0010D\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Lcom/tera/scan/ui/view/widget/text/UIAlignTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/tera/scan/ui/view/helper/UIHelper;", "Lcom/tera/scan/ui/view/helper/UITextViewHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ellipseLetter", "", "expandButtonWidth", "firstCalc", "", "lineWidth", "lines", "", "originalHeight", "originalLineCount", "originalPaddingBottom", "setPaddingFromMe", "tailLines", "textHeight", "", "textLineSpaceExtra", "uiBaseHelper", "calc", "", "text", "drawLine", "canvas", "Landroid/graphics/Canvas;", "line", "lineNumber", "y", "isLastLine", "getHelper", "getWillDisplayLines", "", "initAttr", "isLastLineFullWindow", "lastBaselineToBottom", "onDraw", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "refreshDrawableState", "setBackgroundColor", "color", "setBackgroundResource", "resid", "setExpandButtonWidth", "setPadding", "setSelected", "selected", "setText", "", "type", "Landroid/widget/TextView$BufferType;", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class UIAlignTextView extends AppCompatTextView implements UIHelper<UITextViewHelper<UIAlignTextView>> {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    public String ellipseLetter;
    public int expandButtonWidth;
    public boolean firstCalc;
    public int lineWidth;
    @NotNull
    public final List<String> lines;
    public int originalHeight;
    public int originalLineCount;
    public int originalPaddingBottom;
    public boolean setPaddingFromMe;
    @NotNull
    public final List<Integer> tailLines;
    public float textHeight;
    public float textLineSpaceExtra;
    @NotNull
    public final UITextViewHelper<UIAlignTextView> uiBaseHelper;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UIAlignTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.uiBaseHelper = new UITextViewHelper<>(context2, this);
        this.lines = new ArrayList();
        this.tailLines = new ArrayList();
        this.ellipseLetter = "...";
        initAttr$default(this, (AttributeSet) null, 0, 2, (Object) null);
    }

    private final void calc(String str) {
        if (str.length() == 0) {
            this.lines.add(StringUtils.LF);
            return;
        }
        int i2 = this.originalLineCount;
        for (int i3 = 0; i3 < i2; i3++) {
            int lineEnd = getLayout().getLineEnd(i3);
            int lineStart = getLayout().getLineStart(i3);
            List<String> list = this.lines;
            String substring = str.substring(lineStart, RangesKt___RangesKt.coerceAtMost(lineEnd, str.length()));
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            list.add(substring);
            if (lineEnd >= str.length()) {
                break;
            }
        }
        this.tailLines.add(Integer.valueOf(this.lines.size() - 1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008e, code lost:
        if (getTextAlignment() == 3) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void drawLine(android.graphics.Canvas r17, java.lang.String r18, int r19, float r20, boolean r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r8 = r18
            r9 = r19
            android.text.TextPaint r2 = r16.getPaint()
            java.lang.String r3 = r0.ellipseLetter
            float r10 = r2.measureText(r3)
            java.lang.String r2 = "\n"
            r11 = 0
            r3 = 2
            r4 = 0
            boolean r12 = kotlin.text.StringsKt__StringsJVMKt.endsWith$default(r8, r2, r11, r3, r4)
            java.lang.String r3 = "\n"
            java.lang.String r4 = ""
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r18
            kotlin.text.StringsKt__StringsJVMKt.replace$default((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (boolean) r5, (int) r6, (java.lang.Object) r7)
            int r2 = r16.getPaddingLeft()
            float r2 = (float) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r18.length()
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0038:
            java.lang.String r13 = "this as java.lang.String…ing(startIndex, endIndex)"
            if (r6 >= r4) goto L_0x0057
            android.text.TextPaint r14 = r16.getPaint()
            int r15 = r6 + 1
            java.lang.String r6 = r8.substring(r6, r15)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r13)
            float r6 = r14.measureText(r6)
            java.lang.Float r13 = java.lang.Float.valueOf(r6)
            r3.add(r13)
            float r7 = r7 + r6
            r6 = r15
            goto L_0x0038
        L_0x0057:
            int r4 = r0.lineWidth
            float r4 = (float) r4
            java.util.Iterator r6 = r3.iterator()
            r14 = 0
        L_0x005f:
            boolean r15 = r6.hasNext()
            if (r15 == 0) goto L_0x0071
            java.lang.Object r15 = r6.next()
            java.lang.Number r15 = (java.lang.Number) r15
            float r15 = r15.floatValue()
            float r14 = r14 + r15
            goto L_0x005f
        L_0x0071:
            float r4 = r4 - r14
            int r6 = r18.length()
            int r6 = r6 + -1
            float r6 = (float) r6
            float r6 = r4 / r6
            if (r21 == 0) goto L_0x0091
            int r14 = r16.getTextAlignment()
            r15 = 4
            if (r14 != r15) goto L_0x0089
            r14 = 1073741824(0x40000000, float:2.0)
            float r4 = r4 / r14
        L_0x0087:
            float r2 = r2 + r4
            goto L_0x0091
        L_0x0089:
            int r14 = r16.getTextAlignment()
            r15 = 3
            if (r14 != r15) goto L_0x0091
            goto L_0x0087
        L_0x0091:
            if (r12 != 0) goto L_0x009f
            if (r21 == 0) goto L_0x00a0
            java.util.List<java.lang.String> r4 = r0.lines
            int r4 = r4.size()
            int r4 = r4 + -1
            if (r9 != r4) goto L_0x00a0
        L_0x009f:
            r6 = 0
        L_0x00a0:
            if (r21 == 0) goto L_0x00f2
            java.util.List<java.lang.String> r4 = r0.lines
            int r4 = r4.size()
            int r4 = r4 + -1
            if (r9 == r4) goto L_0x00f2
            float r4 = r7 + r2
            int r12 = r0.expandButtonWidth
            float r12 = (float) r12
            float r4 = r4 + r12
            int r12 = r0.lineWidth
            float r12 = (float) r12
            int r4 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x00f2
            int r4 = r3.size()
            int r4 = r4 + -1
            int r12 = r0.expandButtonWidth
            float r12 = (float) r12
            float r10 = r10 + r12
            float r10 = r10 + r2
            int r12 = r4 + -1
            float r12 = (float) r12
            float r12 = r12 * r6
            float r10 = r10 + r12
        L_0x00ca:
            if (r4 < 0) goto L_0x00ee
            java.lang.Object r12 = r3.get(r4)
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            float r12 = r7 - r12
            float r12 = r12 + r10
            int r14 = r0.lineWidth
            float r14 = (float) r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x00ee
            java.lang.Object r12 = r3.get(r4)
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            float r7 = r7 - r12
            int r4 = r4 + -1
            goto L_0x00ca
        L_0x00ee:
            java.util.List r3 = r3.subList(r11, r4)
        L_0x00f2:
            int r4 = r3.size()
        L_0x00f6:
            if (r11 >= r4) goto L_0x0129
            int r7 = r11 + 1
            java.lang.String r10 = r8.substring(r11, r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r13)
            float r12 = r5 + r2
            int r14 = r16.getPaddingTop()
            float r14 = (float) r14
            float r14 = r20 + r14
            float r15 = r0.textLineSpaceExtra
            r21 = r4
            float r4 = (float) r9
            float r15 = r15 * r4
            float r14 = r14 + r15
            android.text.TextPaint r4 = r16.getPaint()
            r1.drawText(r10, r12, r14, r4)
            java.lang.Object r4 = r3.get(r11)
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            float r4 = r4 + r6
            float r5 = r5 + r4
            r4 = r21
            r11 = r7
            goto L_0x00f6
        L_0x0129:
            int r3 = r3.size()
            int r4 = r18.length()
            if (r3 >= r4) goto L_0x014a
            java.lang.String r3 = r0.ellipseLetter
            float r5 = r5 + r2
            int r2 = r16.getPaddingTop()
            float r2 = (float) r2
            float r2 = r20 + r2
            float r4 = r0.textLineSpaceExtra
            float r6 = (float) r9
            float r4 = r4 * r6
            float r2 = r2 + r4
            android.text.TextPaint r4 = r16.getPaint()
            r1.drawText(r3, r5, r2, r4)
        L_0x014a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.widget.text.UIAlignTextView.drawLine(android.graphics.Canvas, java.lang.String, int, float, boolean):void");
    }

    private final void initAttr(AttributeSet attributeSet, int i2) {
        this.firstCalc = true;
        this.originalHeight = 0;
        this.originalLineCount = 0;
        this.originalPaddingBottom = 0;
        this.setPaddingFromMe = false;
        this.originalPaddingBottom = getPaddingBottom();
        UITextViewHelper<UIAlignTextView> uITextViewHelper = this.uiBaseHelper;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        uITextViewHelper.pf(context, attributeSet, i2);
    }

    public static /* synthetic */ void initAttr$default(UIAlignTextView uIAlignTextView, AttributeSet attributeSet, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            uIAlignTextView.initAttr(attributeSet, i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initAttr");
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

    @NotNull
    public final List<String> getWillDisplayLines() {
        return this.lines;
    }

    public final boolean isLastLineFullWindow() {
        if (this.lines.isEmpty() || this.expandButtonWidth <= 0) {
            return false;
        }
        String str = (String) CollectionsKt___CollectionsKt.last(this.lines);
        float f = 0.0f;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            TextPaint paint = getPaint();
            int i3 = i2 + 1;
            String substring = str.substring(i2, i3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            f += paint.measureText(substring);
            i2 = i3;
        }
        if (f + ((float) this.expandButtonWidth) > ((float) this.lineWidth)) {
            return true;
        }
        return false;
    }

    public final float lastBaselineToBottom() {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        float textSize = getTextSize() - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
        if ((getGravity() & 112) == 16) {
            textSize += (this.textHeight - textSize) / 2.0f;
        }
        float coerceAtLeast = (float) (RangesKt___RangesKt.coerceAtLeast(0, RangesKt___RangesKt.coerceAtMost(this.lines.size(), getMaxLines())) - 1);
        return ((float) getMeasuredHeight()) - ((((this.textHeight * coerceAtLeast) + textSize) + ((float) getPaddingTop())) + (this.textLineSpaceExtra * coerceAtLeast));
    }

    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.lineWidth = getMeasuredWidth();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float textSize = getTextSize() - (((fontMetrics.bottom - fontMetrics.descent) + fontMetrics.ascent) - fontMetrics.top);
        if ((getGravity() & 112) == 16) {
            textSize += (this.textHeight - textSize) / 2.0f;
        }
        this.lineWidth = (this.lineWidth - getPaddingLeft()) - getPaddingRight();
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(0, RangesKt___RangesKt.coerceAtMost(this.lines.size(), getMaxLines()));
        int i2 = 0;
        while (i2 < coerceAtLeast) {
            drawLine(canvas, this.lines.get(i2), i2, (((float) i2) * this.textHeight) + textSize, coerceAtLeast > 0 && i2 == coerceAtLeast + -1);
            i2++;
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.firstCalc) {
            this.lineWidth = getMeasuredWidth();
            String obj = getText().toString();
            this.originalLineCount = getLayout().getLineCount();
            this.originalHeight = getLayout().getHeight();
            this.lines.clear();
            this.tailLines.clear();
            calc(obj);
            float f = ((float) this.originalHeight) / ((float) this.originalLineCount);
            this.textHeight = f;
            float lineSpacingMultiplier = f * (getLineSpacingMultiplier() - 1.0f);
            this.textLineSpaceExtra = lineSpacingMultiplier;
            this.setPaddingFromMe = true;
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.originalPaddingBottom + ((int) ((lineSpacingMultiplier + this.textHeight) * ((float) (this.lines.size() - this.originalLineCount)))));
            this.firstCalc = false;
        }
    }

    public void onMeasure(int i2, int i3) {
        int[] eee = this.uiBaseHelper.eee(i2, i3);
        super.onMeasure(eee[0], eee[1]);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        UITextViewHelper<UIAlignTextView> uITextViewHelper = this.uiBaseHelper;
        if (uITextViewHelper != null) {
            uITextViewHelper.w(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        UITextViewHelper<UIAlignTextView> uITextViewHelper = this.uiBaseHelper;
        if (uITextViewHelper != null) {
            uITextViewHelper.rrr();
        }
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        UITextViewHelper<UIAlignTextView> uITextViewHelper = this.uiBaseHelper;
        if (uITextViewHelper != null) {
            uITextViewHelper.aaa(i2);
        }
    }

    public void setBackgroundResource(@IdRes int i2) {
        super.setBackgroundResource(i2);
        UITextViewHelper<UIAlignTextView> uITextViewHelper = this.uiBaseHelper;
        if (uITextViewHelper != null) {
            uITextViewHelper.qqq(i2);
        }
    }

    public final void setExpandButtonWidth(int i2) {
        this.expandButtonWidth = i2;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        if (!this.setPaddingFromMe) {
            this.originalPaddingBottom = i5;
        }
        this.setPaddingFromMe = false;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setSelected(boolean z) {
        UITextViewHelper<UIAlignTextView> uITextViewHelper = this.uiBaseHelper;
        if (uITextViewHelper != null) {
            uITextViewHelper.F(z);
        }
        super.setSelected(z);
    }

    public void setText(@Nullable CharSequence charSequence, @Nullable TextView.BufferType bufferType) {
        this.firstCalc = true;
        super.setText(charSequence, bufferType);
    }

    @NotNull
    public UITextViewHelper<UIAlignTextView> getHelper() {
        return this.uiBaseHelper;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UIAlignTextView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.uiBaseHelper = new UITextViewHelper<>(context2, this);
        this.lines = new ArrayList();
        this.tailLines = new ArrayList();
        this.ellipseLetter = "...";
        initAttr$default(this, attributeSet, 0, 2, (Object) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UIAlignTextView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.uiBaseHelper = new UITextViewHelper<>(context2, this);
        this.lines = new ArrayList();
        this.tailLines = new ArrayList();
        this.ellipseLetter = "...";
        initAttr(attributeSet, i2);
    }
}
