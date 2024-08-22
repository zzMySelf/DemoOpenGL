package com.tera.scan.ui.view.helper;

import android.os.Build;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tera/scan/ui/view/helper/UIBaseHelper$addOnGlobalLayoutListener$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "component-ui-widget_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIBaseHelper$addOnGlobalLayoutListener$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ UIBaseHelper<T> this$0;

    public UIBaseHelper$addOnGlobalLayoutListener$1(UIBaseHelper<T> uIBaseHelper) {
        this.this$0 = uIBaseHelper;
    }

    public void onGlobalLayout() {
        this.this$0.o().getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (Build.VERSION.SDK_INT < 21) {
            float height = ((float) this.this$0.o().getHeight()) / 2.0f;
            int length = this.this$0.f7376uk.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (this.this$0.f7376uk[i2] > height) {
                    this.this$0.f7376uk[i2] = height;
                }
            }
        }
        if (this.this$0.g <= 0.0f) {
            this.this$0.l(((float) Math.min(this.this$0.o().getWidth(), this.this$0.o().getHeight())) / 2.0f);
        }
    }
}
