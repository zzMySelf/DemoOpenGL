package com.tera.scan.main.view;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tera/scan/main/view/UserCenterCardScene$show$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserCenterCardScene$show$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View $view;
    public final /* synthetic */ UserCenterCardScene this$0;

    public UserCenterCardScene$show$2(UserCenterCardScene userCenterCardScene, View view) {
        this.this$0 = userCenterCardScene;
        this.$view = view;
    }

    public void onGlobalLayout() {
        if (this.this$0.f6998ad.getWidth() != 0 && this.this$0.f6998ad.getHeight() != 0) {
            this.this$0.uk(this.$view);
            this.this$0.f6998ad.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
