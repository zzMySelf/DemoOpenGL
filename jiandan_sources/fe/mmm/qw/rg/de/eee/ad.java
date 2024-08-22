package fe.mmm.qw.rg.de.eee;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.widget.ActivityChooserModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ad {
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public static final qw f8271fe = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final View f8272ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f8273de;
    @Nullable
    public Function1<? super Boolean, Unit> qw;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void qw(@Nullable Activity activity, @NotNull EditText editText) {
            Intrinsics.checkNotNullParameter(editText, "content");
            Object systemService = activity != null ? activity.getSystemService("input_method") : null;
            if (systemService != null) {
                ((InputMethodManager) systemService).showSoftInput(editText, 1);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public ad(@NotNull Activity activity, @Nullable Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.qw = function1;
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
        this.f8272ad = decorView;
        this.f8273de = ad(activity) > de(activity);
        this.f8272ad.getViewTreeObserver().addOnGlobalLayoutListener(new qw(this, activity));
    }

    public static final void qw(ad adVar, Activity activity) {
        boolean z;
        Intrinsics.checkNotNullParameter(adVar, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (adVar.ad(activity) > adVar.de(activity)) {
            Function1<? super Boolean, Unit> function1 = adVar.qw;
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            z = true;
        } else {
            Function1<? super Boolean, Unit> function12 = adVar.qw;
            if (function12 != null) {
                function12.invoke(Boolean.FALSE);
            }
            z = false;
        }
        adVar.f8273de = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.getResources();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int ad(android.content.Context r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x000d
            android.content.res.Resources r1 = r1.getResources()
            if (r1 == 0) goto L_0x000d
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            if (r1 == 0) goto L_0x0013
            int r1 = r1.heightPixels
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.mmm.qw.rg.de.eee.ad.ad(android.content.Context):int");
    }

    public final int de(Activity activity) {
        if (activity == null) {
            return 0;
        }
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.height();
    }

    public final boolean fe() {
        return this.f8273de;
    }
}
