package com.baidu.searchbox.aisearch.comps.halfscreen;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017J\b\u0010\u0011\u001a\u00020\u0005H\u0017J\b\u0010\u0012\u001a\u00020\u0005H\u0017J\b\u0010\u0013\u001a\u00020\u0005H\u0017J\b\u0010\u0014\u001a\u00020\u0005H\u0017J\b\u0010\u0015\u001a\u00020\u0005H\u0017J\b\u0010\u0016\u001a\u00020\u0005H\u0017R=\u0010\u0002\u001a'\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/aisearch/comps/halfscreen/IHalfScreenPanel;", "", "dismissPanel", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Lkotlin/ParameterName;", "name", "dismissEnd", "getDismissPanel", "()Lkotlin/jvm/functions/Function1;", "setDismissPanel", "(Lkotlin/jvm/functions/Function1;)V", "canDrag", "", "ev", "Landroid/view/MotionEvent;", "onDismissEnd", "onDismissStart", "onShowEnd", "onShowStart", "onTransitionEnd", "onTransitionStart", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IHalfScreenPanel.kt */
public interface IHalfScreenPanel {
    boolean canDrag(MotionEvent motionEvent);

    Function1<Function0<Unit>, Unit> getDismissPanel();

    void onDismissEnd();

    void onDismissStart();

    void onShowEnd();

    void onShowStart();

    void onTransitionEnd();

    void onTransitionStart();

    void setDismissPanel(Function1<? super Function0<Unit>, Unit> function1);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IHalfScreenPanel.kt */
    public static final class DefaultImpls {
        public static void onTransitionStart(IHalfScreenPanel iHalfScreenPanel) {
        }

        public static void onTransitionEnd(IHalfScreenPanel iHalfScreenPanel) {
        }

        public static void onShowStart(IHalfScreenPanel iHalfScreenPanel) {
        }

        public static void onShowEnd(IHalfScreenPanel iHalfScreenPanel) {
        }

        public static void onDismissStart(IHalfScreenPanel iHalfScreenPanel) {
        }

        public static void onDismissEnd(IHalfScreenPanel iHalfScreenPanel) {
        }

        public static boolean canDrag(IHalfScreenPanel iHalfScreenPanel, MotionEvent ev) {
            Intrinsics.checkNotNullParameter(ev, "ev");
            return true;
        }
    }
}
