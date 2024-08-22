package com.baidu.searchbox.layout;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.resources.ResourceGroup;
import com.baidu.searchbox.resources.ResourcesKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u00105\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\u0013\u00108\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\u0013\u00109\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\t\u0010:\u001a\u000206H\bJ\t\u0010;\u001a\u000206H\bJ\t\u0010<\u001a\u000206H\bJ\t\u0010=\u001a\u000206H\bJ\u0013\u0010>\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\u0013\u0010?\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\t\u0010@\u001a\u000206H\bJ\u0013\u0010A\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\u0013\u0010B\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\t\u0010C\u001a\u000206H\bJ\t\u0010D\u001a\u000206H\bJ\t\u0010E\u001a\u000206H\bJ\u000e\u0010F\u001a\u0002062\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u0002062\u0006\u0010G\u001a\u00020HJ\u000e\u0010J\u001a\u0002062\u0006\u0010G\u001a\u00020HJ\u0006\u0010\u0014\u001a\u00020\u000eJ\u0011\u0010K\u001a\u0002062\u0006\u0010L\u001a\u00020\u0001H\bJ\u0013\u0010M\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\u0012\u0010N\u001a\u00020\u00152\b\u0010O\u001a\u0004\u0018\u00010\u0001H\u0002J\u0013\u0010P\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0015H\bJ\u0011\u0010Q\u001a\u0002062\u0006\u0010Q\u001a\u00020\u0001H\bJ\u0019\u0010Q\u001a\u0002062\u0006\u00102\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\bJ\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020UJ\u0006\u0010V\u001a\u00020WJ\u0011\u0010X\u001a\u0002062\u0006\u0010L\u001a\u00020\u0001H\bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010 \u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010\u0013R\u001a\u0010,\u001a\u00020-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013¨\u0006Y"}, d2 = {"Lcom/baidu/searchbox/layout/GenLayoutParams;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alignWithParent", "", "getAlignWithParent", "()Z", "setAlignWithParent", "(Z)V", "getAppContext", "()Landroid/content/Context;", "axis", "Lcom/baidu/searchbox/layout/GravityAxis;", "bottomMargin", "getBottomMargin", "()Ljava/lang/Object;", "setBottomMargin", "(Ljava/lang/Object;)V", "gravity", "", "getGravity", "()I", "setGravity", "(I)V", "height", "getHeight", "setHeight", "leftMargin", "getLeftMargin", "setLeftMargin", "rightMargin", "getRightMargin", "setRightMargin", "rules", "", "getRules", "()[I", "setRules", "([I)V", "topMargin", "getTopMargin", "setTopMargin", "weight", "", "getWeight", "()F", "setWeight", "(F)V", "width", "getWidth", "setWidth", "above", "", "id", "alignBottom", "alignLeft", "alignParentBottom", "alignParentLeft", "alignParentRight", "alignParentTop", "alignRight", "alignTop", "alignWithParentIfMissing", "baselineOf", "below", "centerHorizontally", "centerInParent", "centerVertically", "fromFrameParams", "lp", "Landroid/view/ViewGroup$LayoutParams;", "fromLinearParams", "fromRelativeParams", "horizontalMargin", "margin", "leftOf", "rawIntDimen", "dimen", "rightOf", "size", "toFrameParams", "Landroid/widget/FrameLayout$LayoutParams;", "toLinearParams", "Landroid/widget/LinearLayout$LayoutParams;", "toRelativeParams", "Landroid/widget/RelativeLayout$LayoutParams;", "verticalMargin", "monoid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: layout.kt */
public final class GenLayoutParams {
    private boolean alignWithParent;
    private final Context appContext;
    private GravityAxis axis;
    private Object bottomMargin = 0;
    private int gravity;
    private Object height = -2;
    private Object leftMargin = 0;
    private Object rightMargin = 0;
    private int[] rules = new int[22];
    private Object topMargin = 0;
    private float weight;
    private Object width = -2;

    public GenLayoutParams(Context appContext2) {
        Intrinsics.checkNotNullParameter(appContext2, "appContext");
        this.appContext = appContext2;
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final Object getWidth() {
        return this.width;
    }

    public final void setWidth(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.width = obj;
    }

    public final Object getHeight() {
        return this.height;
    }

    public final void setHeight(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.height = obj;
    }

    public final Object getLeftMargin() {
        return this.leftMargin;
    }

    public final void setLeftMargin(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.leftMargin = obj;
    }

    public final Object getTopMargin() {
        return this.topMargin;
    }

    public final void setTopMargin(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.topMargin = obj;
    }

    public final Object getRightMargin() {
        return this.rightMargin;
    }

    public final void setRightMargin(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.rightMargin = obj;
    }

    public final Object getBottomMargin() {
        return this.bottomMargin;
    }

    public final void setBottomMargin(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.bottomMargin = obj;
    }

    public final float getWeight() {
        return this.weight;
    }

    public final void setWeight(float f2) {
        this.weight = f2;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final void setGravity(int i2) {
        this.gravity = i2;
    }

    public final boolean getAlignWithParent() {
        return this.alignWithParent;
    }

    public final void setAlignWithParent(boolean z) {
        this.alignWithParent = z;
    }

    public final int[] getRules() {
        return this.rules;
    }

    public final void setRules(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.rules = iArr;
    }

    public final GravityAxis gravity() {
        GravityAxis gravityAxis = this.axis;
        if (gravityAxis != null) {
            return gravityAxis;
        }
        GravityAxisImpl it = new GravityAxisImpl(this);
        this.axis = it;
        return it;
    }

    public final void above(int id) {
        getRules()[2] = id;
    }

    public final void below(int id) {
        getRules()[3] = id;
    }

    public final void leftOf(int id) {
        getRules()[0] = id;
    }

    public final void rightOf(int id) {
        getRules()[1] = id;
    }

    public final void alignLeft(int id) {
        getRules()[5] = id;
    }

    public final void alignTop(int id) {
        getRules()[6] = id;
    }

    public final void alignRight(int id) {
        getRules()[7] = id;
    }

    public final void alignBottom(int id) {
        getRules()[8] = id;
    }

    public final void alignParentTop() {
        getRules()[10] = -1;
    }

    public final void alignParentRight() {
        getRules()[11] = -1;
    }

    public final void alignParentBottom() {
        getRules()[12] = -1;
    }

    public final void alignParentLeft() {
        getRules()[9] = -1;
    }

    public final void centerHorizontally() {
        getRules()[14] = -1;
    }

    public final void centerVertically() {
        getRules()[15] = -1;
    }

    public final void centerInParent() {
        getRules()[13] = -1;
    }

    public final void baselineOf(int id) {
        getRules()[4] = id;
    }

    public final void alignWithParentIfMissing() {
        setAlignWithParent(true);
    }

    public final void size(Object width2, Object height2) {
        Intrinsics.checkNotNullParameter(width2, "width");
        Intrinsics.checkNotNullParameter(height2, "height");
        setWidth(width2);
        setHeight(height2);
    }

    public final void size(Object size) {
        Intrinsics.checkNotNullParameter(size, "size");
        setWidth(size);
        setHeight(size);
    }

    public final void horizontalMargin(Object margin) {
        Intrinsics.checkNotNullParameter(margin, "margin");
        setLeftMargin(margin);
        setRightMargin(margin);
    }

    public final void verticalMargin(Object margin) {
        Intrinsics.checkNotNullParameter(margin, "margin");
        setTopMargin(margin);
        setBottomMargin(margin);
    }

    public final void fromFrameParams(ViewGroup.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(lp, "lp");
        this.width = Integer.valueOf(lp.width);
        this.height = Integer.valueOf(lp.height);
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            this.leftMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).leftMargin);
            this.topMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).topMargin);
            this.rightMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).rightMargin);
            this.bottomMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).bottomMargin);
            if (lp instanceof FrameLayout.LayoutParams) {
                this.gravity = ((FrameLayout.LayoutParams) lp).gravity;
            }
        }
    }

    public final FrameLayout.LayoutParams toFrameParams() {
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(rawIntDimen(this.width), rawIntDimen(this.height));
        lp.leftMargin = rawIntDimen(this.leftMargin);
        lp.topMargin = rawIntDimen(this.topMargin);
        lp.rightMargin = rawIntDimen(this.rightMargin);
        lp.bottomMargin = rawIntDimen(this.bottomMargin);
        lp.gravity = this.gravity;
        return lp;
    }

    public final void fromLinearParams(ViewGroup.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(lp, "lp");
        this.width = Integer.valueOf(lp.width);
        this.height = Integer.valueOf(lp.height);
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            this.leftMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).leftMargin);
            this.topMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).topMargin);
            this.rightMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).rightMargin);
            this.bottomMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).bottomMargin);
            if (lp instanceof LinearLayout.LayoutParams) {
                this.gravity = ((LinearLayout.LayoutParams) lp).gravity;
                this.weight = ((LinearLayout.LayoutParams) lp).weight;
            }
        }
    }

    public final LinearLayout.LayoutParams toLinearParams() {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(rawIntDimen(this.width), rawIntDimen(this.height));
        lp.leftMargin = rawIntDimen(this.leftMargin);
        lp.topMargin = rawIntDimen(this.topMargin);
        lp.rightMargin = rawIntDimen(this.rightMargin);
        lp.bottomMargin = rawIntDimen(this.bottomMargin);
        lp.gravity = this.gravity;
        lp.weight = this.weight;
        return lp;
    }

    public final void fromRelativeParams(ViewGroup.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(lp, "lp");
        this.width = Integer.valueOf(lp.width);
        this.height = Integer.valueOf(lp.height);
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            this.leftMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).leftMargin);
            this.topMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).topMargin);
            this.rightMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).rightMargin);
            this.bottomMargin = Integer.valueOf(((ViewGroup.MarginLayoutParams) lp).bottomMargin);
            if (lp instanceof RelativeLayout.LayoutParams) {
                this.alignWithParent = ((RelativeLayout.LayoutParams) lp).alignWithParent;
                int[] rules2 = ((RelativeLayout.LayoutParams) lp).getRules();
                Intrinsics.checkNotNullExpressionValue(rules2, "lp.rules");
                ArraysKt.copyInto$default(rules2, this.rules, 0, 0, 0, 14, (Object) null);
            }
        }
    }

    public final RelativeLayout.LayoutParams toRelativeParams() {
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(rawIntDimen(this.width), rawIntDimen(this.height));
        lp.leftMargin = rawIntDimen(this.leftMargin);
        lp.topMargin = rawIntDimen(this.topMargin);
        lp.rightMargin = rawIntDimen(this.rightMargin);
        lp.bottomMargin = rawIntDimen(this.bottomMargin);
        lp.alignWithParent = this.alignWithParent;
        int[] $this$forEachIndexed$iv = this.rules;
        int index$iv = 0;
        int length = $this$forEachIndexed$iv.length;
        int i2 = 0;
        while (i2 < length) {
            lp.addRule(index$iv, $this$forEachIndexed$iv[i2]);
            i2++;
            index$iv++;
        }
        return lp;
    }

    private final int rawIntDimen(Object dimen) {
        if (dimen instanceof ResourceGroup) {
            if (dimen != null) {
                return (int) ResourcesKt.asDimen$default((ResourceGroup) dimen, this.appContext, 0.0f, 4, (Object) null);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.resources.ResourceGroup<com.baidu.searchbox.resources.DimenValue>");
        } else if (dimen instanceof Number) {
            return ((Number) dimen).intValue();
        } else {
            return 0;
        }
    }
}
