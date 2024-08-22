package com.baidu.chatsearch.aicall.comps.digitalman.dependents;

import android.animation.ObjectAnimator;
import android.view.View;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\rH\u0007J\u001a\u0010\u0012\u001a\u00020\r2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0007J\b\u0010\u0014\u001a\u00020\rH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/digitalman/dependents/AICallBubbleAnimHelper;", "", "destView", "Landroid/view/View;", "(Landroid/view/View;)V", "dismissAnimator", "Landroid/animation/ObjectAnimator;", "getDismissAnimator", "()Landroid/animation/ObjectAnimator;", "dismissAnimator$delegate", "Lkotlin/Lazy;", "dismissCallback", "Lkotlin/Function0;", "", "showAnimator", "getShowAnimator", "showAnimator$delegate", "cancelAll", "startDismissAnim", "callback", "startShowAim", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AICallBubbleAnimHelper.kt */
public final class AICallBubbleAnimHelper {
    /* access modifiers changed from: private */
    public final View destView;
    private final Lazy dismissAnimator$delegate = LazyKt.lazy(new AICallBubbleAnimHelper$dismissAnimator$2(this));
    /* access modifiers changed from: private */
    public Function0<Unit> dismissCallback;
    private final Lazy showAnimator$delegate = LazyKt.lazy(new AICallBubbleAnimHelper$showAnimator$2(this));

    public AICallBubbleAnimHelper(View destView2) {
        Intrinsics.checkNotNullParameter(destView2, "destView");
        this.destView = destView2;
        destView2.setPivotX(ViewExKt.getDpF(80.0f));
        destView2.setPivotY(ViewExKt.getDpF(80.0f));
    }

    private final ObjectAnimator getShowAnimator() {
        return (ObjectAnimator) this.showAnimator$delegate.getValue();
    }

    private final ObjectAnimator getDismissAnimator() {
        return (ObjectAnimator) this.dismissAnimator$delegate.getValue();
    }

    public final void startShowAim() {
        if (!getShowAnimator().isRunning()) {
            getDismissAnimator().cancel();
            getShowAnimator().start();
        }
    }

    public static /* synthetic */ void startDismissAnim$default(AICallBubbleAnimHelper aICallBubbleAnimHelper, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function0 = null;
        }
        aICallBubbleAnimHelper.startDismissAnim(function0);
    }

    public final void startDismissAnim(Function0<Unit> callback) {
        if (!getDismissAnimator().isRunning()) {
            this.dismissCallback = callback;
            getShowAnimator().cancel();
            getDismissAnimator().start();
        }
    }

    public final void cancelAll() {
        this.dismissCallback = null;
        getShowAnimator().cancel();
        getDismissAnimator().cancel();
    }
}
