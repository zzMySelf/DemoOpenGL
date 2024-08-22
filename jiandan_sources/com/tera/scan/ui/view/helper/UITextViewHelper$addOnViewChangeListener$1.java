package com.tera.scan.ui.view.helper;

import android.view.ViewTreeObserver;
import android.widget.TextView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tera/scan/ui/view/helper/UITextViewHelper$addOnViewChangeListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UITextViewHelper$addOnViewChangeListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ UITextViewHelper<T> this$0;

    public UITextViewHelper$addOnViewChangeListener$1(UITextViewHelper<T> uITextViewHelper) {
        this.this$0 = uITextViewHelper;
    }

    public void onGlobalLayout() {
        ((TextView) this.this$0.o()).getViewTreeObserver().removeOnGlobalLayoutListener(this);
        UITextViewHelper<T> uITextViewHelper = this.this$0;
        uITextViewHelper.C(((TextView) uITextViewHelper.o()).getPaddingLeft());
        UITextViewHelper<T> uITextViewHelper2 = this.this$0;
        uITextViewHelper2.D(((TextView) uITextViewHelper2.o()).getPaddingRight());
        UITextViewHelper<T> uITextViewHelper3 = this.this$0;
        uITextViewHelper3.E(((TextView) uITextViewHelper3.o()).getPaddingTop());
        UITextViewHelper<T> uITextViewHelper4 = this.this$0;
        uITextViewHelper4.B(((TextView) uITextViewHelper4.o()).getPaddingBottom());
        this.this$0.y();
    }
}
