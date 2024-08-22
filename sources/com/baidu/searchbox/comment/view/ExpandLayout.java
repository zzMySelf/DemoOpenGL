package com.baidu.searchbox.comment.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0011J\b\u0010\u0016\u001a\u00020\u0014H\u0014J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\u0016\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/comment/view/ExpandLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "animPercent", "setAnimPercent", "(F)V", "animator", "Landroid/animation/ObjectAnimator;", "isOpen", "", "totalHeight", "forceToggle", "", "isExpand", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "startAnim", "duration", "", "toggle", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ExpandLayout.kt */
public final class ExpandLayout extends RelativeLayout {
    public Map<Integer, View> _$_findViewCache;
    private float animPercent;
    private ObjectAnimator animator;
    private boolean isOpen;
    private int totalHeight;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandLayout(Context context, AttributeSet attributeSet) {
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
    public ExpandLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        setAnimPercent(0.0f);
        this.isOpen = false;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpandLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setAnimPercent(float value) {
        this.animPercent = value;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.totalHeight = 0;
        if (getChildCount() > 0) {
            int childCount = getChildCount();
            for (int index = 0; index < childCount; index++) {
                if (getChildAt(index) != null) {
                    int topMargin = 0;
                    int bottomMargin = 0;
                    if (getChildAt(index).getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.LayoutParams layoutParams = getChildAt(index).getLayoutParams();
                        if (layoutParams != null) {
                            topMargin = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                            ViewGroup.LayoutParams layoutParams2 = getChildAt(index).getLayoutParams();
                            if (layoutParams2 != null) {
                                bottomMargin = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        }
                    }
                    this.totalHeight += getChildAt(index).getMeasuredHeight() + topMargin + bottomMargin;
                }
            }
            int paddingTop = this.totalHeight + getPaddingTop() + getPaddingBottom();
            this.totalHeight = paddingTop;
            if (this.isOpen) {
                setMeasuredDimension(widthMeasureSpec, (int) (((float) paddingTop) * this.animPercent));
            } else {
                setMeasuredDimension(widthMeasureSpec, paddingTop - ((int) (((float) paddingTop) * this.animPercent)));
            }
        }
    }

    public final void toggle(boolean isExpand, long duration) {
        if (this.isOpen != isExpand) {
            this.isOpen = isExpand;
            ObjectAnimator objectAnimator = this.animator;
            boolean z = true;
            if (objectAnimator == null || !objectAnimator.isRunning()) {
                z = false;
            }
            if (z) {
                setAnimPercent(1.0f);
                requestLayout();
                return;
            }
            startAnim(duration);
        }
    }

    public final void forceToggle(boolean isExpand) {
        if (this.isOpen != isExpand) {
            this.isOpen = isExpand;
            setAnimPercent(1.0f);
            requestLayout();
        }
    }

    private final void startAnim(long duration) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "animPercent", new float[]{0.0f, 1.0f});
        this.animator = ofFloat;
        if (ofFloat != null) {
            ofFloat.setDuration(duration);
        }
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.animator;
        boolean z = true;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            z = false;
        }
        if (z) {
            ObjectAnimator objectAnimator2 = this.animator;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            setAnimPercent(1.0f);
            requestLayout();
        }
        this.animator = null;
    }
}
