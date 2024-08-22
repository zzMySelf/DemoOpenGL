package com.baidu.searchbox.sport.page.web;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/sport/page/web/OlympicCalendarWebComp$dismissPanel$1$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicCalendarWebComp.kt */
public final class OlympicCalendarWebComp$dismissPanel$1$1 extends AnimatorListenerAdapter {
    final /* synthetic */ OlympicCalendarWebComp this$0;

    OlympicCalendarWebComp$dismissPanel$1$1(OlympicCalendarWebComp $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationEnd(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        super.onAnimationEnd(animation);
        PopupWindow access$getPopupWindow$p = this.this$0.popupWindow;
        if (access$getPopupWindow$p != null) {
            access$getPopupWindow$p.dismiss();
        }
    }
}
