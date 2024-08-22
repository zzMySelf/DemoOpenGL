package com.tera.scan.ui.view.helper;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.f.ad.fe.ad;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\b\u0016\u0018\u0000 t*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001tB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u00020\u0010H\u0016J\b\u00104\u001a\u00020\u0010H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u00106\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u00107\u001a\u0004\u0018\u00010\u000eH\u0016J\n\u00108\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u00109\u001a\u00020\u0010H\u0016J\b\u0010:\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0010H\u0016J\b\u0010<\u001a\u00020\u0010H\u0016J\b\u0010=\u001a\u00020\u0010H\u0016J2\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u00022\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u0010H\u0016J2\u0010E\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u00022\u0006\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0010H\u0016J\n\u0010J\u001a\u0004\u0018\u00010,H\u0016J'\u0010K\u001a\u0002022\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020\u0010H\u0010¢\u0006\u0002\bOJ\u0010\u0010P\u001a\u0002022\u0006\u0010Q\u001a\u00020RH\u0016J\u0010\u0010S\u001a\u0002022\u0006\u0010T\u001a\u00020\tH\u0016J\b\u0010U\u001a\u000202H\u0002J\u0012\u0010U\u001a\u0002022\b\u0010V\u001a\u0004\u0018\u00010\u000eH\u0014J*\u0010U\u001a\u0002022\b\u0010W\u001a\u0004\u0018\u00010\u000e2\u0006\u0010X\u001a\u00020\u00102\u0006\u0010Y\u001a\u00020\u00102\u0006\u0010Z\u001a\u00020\u0010H\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\\\u001a\u00020\u0010H\u0016J\u0016\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010^\u001a\u00020\u0010H\u0016J\u0018\u0010_\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010V\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010V\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010V\u001a\u0004\u0018\u00010\u000eH\u0016J\u001e\u0010b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010c\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010H\u0016J\u0018\u0010d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010V\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010c\u001a\u00020\u0010H\u0016J\u0010\u0010f\u001a\u0002022\u0006\u0010g\u001a\u00020\tH\u0016J\b\u0010h\u001a\u000202H\u0014J6\u0010h\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010i\u001a\u00020\u00102\b\b\u0001\u0010j\u001a\u00020\u00102\b\b\u0001\u0010k\u001a\u00020\u00102\b\b\u0001\u0010g\u001a\u00020\u0010H\u0016J\u0018\u0010l\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010m\u001a\u00020\u0010H\u0016J\u0018\u0010n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010m\u001a\u00020\u0010H\u0016J\u0018\u0010o\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010m\u001a\u00020\u0010H\u0016J\u0018\u0010p\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0001\u0010m\u001a\u00020\u0010H\u0016J\b\u0010q\u001a\u000202H\u0002J\u0018\u0010q\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0010r\u001a\u0004\u0018\u00010,H\u0016J\b\u0010s\u001a\u000202H\u0002R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\"\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u000e\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010/0.X\u000e¢\u0006\u0004\n\u0002\u00100¨\u0006u"}, d2 = {"Lcom/tera/scan/ui/view/helper/UITextViewHelper;", "T", "Landroid/widget/TextView;", "Lcom/tera/scan/ui/view/helper/UIBaseHelper;", "context", "Landroid/content/Context;", "uiView", "(Landroid/content/Context;Landroid/widget/TextView;)V", "mDrawableWithText", "", "mHasPressedTextColor", "mHasSelectedTextColor", "mHasUnableTextColor", "mIcon", "Landroid/graphics/drawable/Drawable;", "mIconDirection", "", "mIconHeight", "mIconNormal", "mIconPressed", "mIconSelected", "mIconUnable", "mIconWidth", "mPaddingBottom", "getMPaddingBottom", "()I", "setMPaddingBottom", "(I)V", "mPaddingLeft", "getMPaddingLeft", "setMPaddingLeft", "mPaddingRight", "getMPaddingRight", "setMPaddingRight", "mPaddingTop", "getMPaddingTop", "setMPaddingTop", "mTextColorNormal", "mTextColorPressed", "mTextColorSelected", "mTextColorStateList", "Landroid/content/res/ColorStateList;", "mTextColorUnable", "mTypefacePath", "", "states", "", "", "[[I", "addOnViewChangeListener", "", "getIconDirection", "getIconHeight", "getIconNormal", "getIconPressed", "getIconSelected", "getIconUnable", "getIconWidth", "getTextColorNormal", "getTextColorPressed", "getTextColorSelected", "getTextColorUnable", "getTextHeight", "", "view", "drawableHeight", "paddingTop", "paddingBottom", "drawablePaddingVertical", "getTextWidth", "drawableWidth", "paddingLeft", "paddingRight", "drawablePaddingHorizontal", "getTypefacePath", "initAttr", "attr", "Landroid/util/AttributeSet;", "defStyleAttr", "initAttr$component_ui_widget_aiscanConfigRelease", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "setEnabled", "enabled", "setIcon", "icon", "drawable", "srcDrawableWidth", "srcDrawableHeight", "direction", "setIconDirection", "iconDirection", "setIconHeight", "iconHeight", "setIconNormal", "setIconPressed", "setIconSelected", "setIconSize", "iconWidth", "setIconUnable", "setIconWidth", "setSelected", "selected", "setTextColor", "normal", "pressed", "unable", "setTextColorNormal", "textColor", "setTextColorPressed", "setTextColorSelected", "setTextColorUnable", "setTypeface", "typefacePath", "setup", "Companion", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class UITextViewHelper<T extends TextView> extends UIBaseHelper<T> {
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public int h0;
    public int i0;
    public int j0;
    public int k0;
    public int l0;
    public int m0;
    public int n0;
    @Nullable
    public ColorStateList o0;
    @NotNull
    public int[][] p0 = new int[5][];
    @Nullable
    public Drawable q0;
    @Nullable
    public Drawable r0;
    @Nullable
    public Drawable s0;
    @Nullable
    public Drawable t0;
    @Nullable
    public Drawable u0;
    @Nullable
    public String v0;
    public boolean w0;
    public boolean x0;
    public boolean y0;
    public boolean z0;

    public static final class qw implements TextWatcher {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ UITextViewHelper<T> f7378ad;

        public qw(UITextViewHelper<T> uITextViewHelper) {
            this.f7378ad = uITextViewHelper;
        }

        public void afterTextChanged(@NotNull Editable editable) {
            Intrinsics.checkNotNullParameter(editable, "s");
            this.f7378ad.y();
        }

        public void beforeTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(charSequence, "s");
        }

        public void onTextChanged(@NotNull CharSequence charSequence, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(charSequence, "s");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UITextViewHelper(@NotNull Context context, @NotNull T t) {
        super(context, t);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(t, "uiView");
        t();
    }

    public static final void A(UITextViewHelper uITextViewHelper, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(uITextViewHelper, "this$0");
        int width = ((int) (((float) (((TextView) uITextViewHelper.o()).getWidth() - (uITextViewHelper.A0 + uITextViewHelper.B0))) - ((uITextViewHelper.v((TextView) uITextViewHelper.o(), i2, uITextViewHelper.A0, uITextViewHelper.B0, i3) + ((float) i2)) + ((float) i3)))) / 2;
        int i6 = 0;
        if (width < 0) {
            width = 0;
        }
        int height = ((int) (((float) (((TextView) uITextViewHelper.o()).getHeight() - (uITextViewHelper.C0 + uITextViewHelper.D0))) - ((uITextViewHelper.u((TextView) uITextViewHelper.o(), i4, uITextViewHelper.C0, uITextViewHelper.D0, i5) + ((float) i4)) + ((float) i5)))) / 2;
        if (height >= 0) {
            i6 = height;
        }
        ((TextView) uITextViewHelper.o()).setPadding(uITextViewHelper.A0 + width, uITextViewHelper.C0 + i6, width + uITextViewHelper.B0, i6 + uITextViewHelper.D0);
    }

    private final void p() {
        Drawable drawable;
        if (!((TextView) o()).isEnabled()) {
            drawable = this.t0;
        } else if (((TextView) o()).isSelected()) {
            drawable = this.u0;
        } else {
            drawable = this.r0;
        }
        this.q0 = drawable;
        if (!this.x0) {
            this.l0 = this.k0;
        }
        if (!this.y0) {
            this.m0 = this.k0;
        }
        if (!this.z0) {
            this.n0 = this.k0;
        }
        int[][] iArr = this.p0;
        iArr[0] = new int[]{-16842910};
        iArr[1] = new int[]{16842908};
        iArr[2] = new int[]{16842919};
        iArr[3] = new int[]{16842913};
        iArr[4] = new int[]{16842910};
        G();
        y();
        H();
    }

    public final void B(int i2) {
        this.D0 = i2;
    }

    public final void C(int i2) {
        this.A0 = i2;
    }

    public final void D(int i2) {
        this.B0 = i2;
    }

    public final void E(int i2) {
        this.C0 = i2;
    }

    public void F(boolean z) {
        if (((TextView) o()).isEnabled()) {
            if (z) {
                Drawable drawable = this.u0;
                if (drawable != null) {
                    this.q0 = drawable;
                    y();
                    return;
                }
                return;
            }
            this.q0 = this.r0;
            y();
        }
    }

    public void G() {
        int i2 = this.l0;
        this.o0 = new ColorStateList(this.p0, new int[]{this.m0, i2, i2, this.n0, this.k0});
        ((TextView) o()).setTextColor(this.o0);
    }

    public final void H() {
        if (!TextUtils.isEmpty(this.v0)) {
            AssetManager assets = uk().getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            ((TextView) o()).setTypeface(Typeface.createFromAsset(assets, this.v0));
        }
    }

    public void pf(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (attributeSet == null) {
            p();
            return;
        }
        super.pf(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.UITextView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…, R.styleable.UITextView)");
        if (Build.VERSION.SDK_INT >= 21) {
            this.r0 = ad.ad(obtainStyledAttributes, 33);
            this.s0 = ad.ad(obtainStyledAttributes, 34);
            this.t0 = ad.ad(obtainStyledAttributes, 36);
            this.u0 = ad.ad(obtainStyledAttributes, 35);
        } else {
            int resourceId = obtainStyledAttributes.getResourceId(33, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(34, -1);
            int resourceId3 = obtainStyledAttributes.getResourceId(36, -1);
            int resourceId4 = obtainStyledAttributes.getResourceId(35, -1);
            if (resourceId != -1) {
                this.r0 = fe.mmm.qw.f.ad.fe.qw.qw.ad(context, resourceId);
            }
            if (resourceId2 != -1) {
                this.s0 = fe.mmm.qw.f.ad.fe.qw.qw.ad(context, resourceId2);
            }
            if (resourceId3 != -1) {
                this.t0 = fe.mmm.qw.f.ad.fe.qw.qw.ad(context, resourceId3);
            }
            if (resourceId4 != -1) {
                this.u0 = fe.mmm.qw.f.ad.fe.qw.qw.ad(context, resourceId4);
            }
        }
        this.i0 = obtainStyledAttributes.getDimensionPixelSize(37, 0);
        this.h0 = obtainStyledAttributes.getDimensionPixelSize(31, 0);
        this.j0 = obtainStyledAttributes.getInt(30, 1);
        int qw2 = ad.qw(obtainStyledAttributes, 44, ((TextView) o()).getCurrentTextColor());
        this.k0 = qw2;
        this.l0 = ad.qw(obtainStyledAttributes, 45, qw2);
        this.m0 = ad.qw(obtainStyledAttributes, 47, this.k0);
        this.n0 = ad.qw(obtainStyledAttributes, 46, this.k0);
        this.v0 = obtainStyledAttributes.getString(48);
        this.w0 = obtainStyledAttributes.getBoolean(38, false);
        this.x0 = obtainStyledAttributes.hasValue(45);
        this.y0 = obtainStyledAttributes.hasValue(47);
        this.z0 = obtainStyledAttributes.hasValue(46);
        obtainStyledAttributes.recycle();
        p();
    }

    public final void t() {
        if (this.w0) {
            ((TextView) o()).getViewTreeObserver().addOnGlobalLayoutListener(new UITextViewHelper$addOnViewChangeListener$1(this));
            ((TextView) o()).addTextChangedListener(new qw(this));
        }
    }

    public float u(@Nullable TextView textView, int i2, int i3, int i4, int i5) {
        if (textView == null) {
            return 0.0f;
        }
        Paint.FontMetrics fontMetrics = textView.getPaint().getFontMetrics();
        float abs = Math.abs(fontMetrics.bottom - fontMetrics.top) * ((float) textView.getLineCount());
        float height = (float) ((((textView.getHeight() - i2) - i3) - i4) - i5);
        return abs > height ? height : abs;
    }

    public float v(@Nullable TextView textView, int i2, int i3, int i4, int i5) {
        float f;
        if (textView == null) {
            return 0.0f;
        }
        String obj = textView.getText().toString();
        if (StringsKt__StringsKt.contains$default((CharSequence) obj, (CharSequence) StringUtils.LF, false, 2, (Object) null)) {
            Object[] array = new Regex(StringUtils.LF).split(obj, 0).toArray(new String[0]);
            if (array != null) {
                ArrayList arrayList = new ArrayList(r1);
                for (String measureText : (String[]) array) {
                    arrayList.add(Float.valueOf(textView.getPaint().measureText(measureText)));
                }
                Object max = Collections.max(arrayList);
                Intrinsics.checkNotNullExpressionValue(max, "max(widthList)");
                f = ((Number) max).floatValue();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        } else {
            f = textView.getPaint().measureText(obj);
        }
        float width = (float) ((((textView.getWidth() - i2) - i3) - i4) - i5);
        return f > width ? width : f;
    }

    public void w(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, NotificationCompat.CATEGORY_EVENT);
        if (((TextView) o()).isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                Drawable drawable = this.s0;
                if (drawable != null) {
                    this.q0 = drawable;
                    y();
                }
            } else if (action != 1) {
                if (action != 2) {
                    if (action == 3 && this.r0 != null) {
                        this.q0 = ((TextView) o()).isSelected() ? this.u0 : this.r0;
                        y();
                    }
                } else if (mmm((int) motionEvent.getX(), (int) motionEvent.getY()) && this.r0 != null) {
                    this.q0 = ((TextView) o()).isSelected() ? this.u0 : this.r0;
                    y();
                }
            } else if (this.r0 != null) {
                this.q0 = ((TextView) o()).isSelected() ? this.u0 : this.r0;
                y();
            }
        }
    }

    public void x(boolean z) {
        if (z) {
            Drawable drawable = this.r0;
            if (drawable != null) {
                this.q0 = drawable;
                y();
                return;
            }
            return;
        }
        Drawable drawable2 = this.t0;
        if (drawable2 != null) {
            this.q0 = drawable2;
            y();
        }
    }

    public final void y() {
        Drawable drawable;
        if (this.h0 == 0 && this.i0 == 0 && (drawable = this.q0) != null) {
            int i2 = 0;
            this.i0 = drawable != null ? drawable.getIntrinsicWidth() : 0;
            Drawable drawable2 = this.q0;
            if (drawable2 != null) {
                i2 = drawable2.getIntrinsicHeight();
            }
            this.h0 = i2;
        }
        z(this.q0, this.i0, this.h0, this.j0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z(android.graphics.drawable.Drawable r10, int r11, int r12, int r13) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x0085
            r1 = 0
            if (r11 == 0) goto L_0x000b
            if (r12 == 0) goto L_0x000b
            r10.setBounds(r1, r1, r11, r12)
        L_0x000b:
            android.view.View r2 = r9.o()
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r2 = r2.getCompoundDrawablePadding()
            r3 = 1
            if (r13 == r3) goto L_0x0048
            r3 = 2
            if (r13 == r3) goto L_0x003a
            r3 = 3
            if (r13 == r3) goto L_0x0030
            r3 = 4
            if (r13 == r3) goto L_0x0026
            r5 = r11
            r7 = r12
            r6 = r2
            r8 = r6
            goto L_0x0055
        L_0x0026:
            android.view.View r11 = r9.o()
            android.widget.TextView r11 = (android.widget.TextView) r11
            r11.setCompoundDrawables(r0, r0, r0, r10)
            goto L_0x0043
        L_0x0030:
            android.view.View r12 = r9.o()
            android.widget.TextView r12 = (android.widget.TextView) r12
            r12.setCompoundDrawables(r0, r0, r10, r0)
            goto L_0x0051
        L_0x003a:
            android.view.View r11 = r9.o()
            android.widget.TextView r11 = (android.widget.TextView) r11
            r11.setCompoundDrawables(r0, r10, r0, r0)
        L_0x0043:
            r7 = r12
            r8 = r2
            r5 = 0
            r6 = 0
            goto L_0x0055
        L_0x0048:
            android.view.View r12 = r9.o()
            android.widget.TextView r12 = (android.widget.TextView) r12
            r12.setCompoundDrawables(r10, r0, r0, r0)
        L_0x0051:
            r5 = r11
            r6 = r2
            r7 = 0
            r8 = 0
        L_0x0055:
            boolean r10 = r9.w0
            if (r10 != 0) goto L_0x005a
            return
        L_0x005a:
            android.view.View r10 = r9.o()
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r10 = r10.getWidth()
            if (r10 == 0) goto L_0x0084
            android.view.View r10 = r9.o()
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r10 = r10.getHeight()
            if (r10 != 0) goto L_0x0073
            goto L_0x0084
        L_0x0073:
            android.view.View r10 = r9.o()
            android.widget.TextView r10 = (android.widget.TextView) r10
            fe.mmm.qw.f.de.ad.qw r11 = new fe.mmm.qw.f.de.ad.qw
            r3 = r11
            r4 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            r10.post(r11)
            goto L_0x008e
        L_0x0084:
            return
        L_0x0085:
            android.view.View r10 = r9.o()
            android.widget.TextView r10 = (android.widget.TextView) r10
            r10.setCompoundDrawables(r0, r0, r0, r0)
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.ui.view.helper.UITextViewHelper.z(android.graphics.drawable.Drawable, int, int, int):void");
    }
}
