package fe.mmm.qw.ggg.ad.yj;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import fe.mmm.qw.ggg.ad.ad;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class qw implements Application.ActivityLifecycleCallbacks {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f7840i;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public static final C0281qw f7841th = new C0281qw((DefaultConstructorMarker) null);

    /* renamed from: uk  reason: collision with root package name */
    public static boolean f7842uk;

    /* renamed from: yj  reason: collision with root package name */
    public static long f7843yj;

    /* renamed from: ad  reason: collision with root package name */
    public long f7844ad;

    /* renamed from: fe.mmm.qw.ggg.ad.yj.qw$qw  reason: collision with other inner class name */
    public static final class C0281qw {
        public C0281qw() {
        }

        public /* synthetic */ C0281qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean ad() {
            return qw.f7842uk;
        }

        public final boolean de() {
            return qw.f7840i;
        }

        public final void fe() {
            fe.mmm.qw.ggg.qw.qw.qw("cold_open_to_home_show", CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(System.currentTimeMillis() - qw())));
        }

        public final long qw() {
            return qw.f7843yj;
        }

        public final void rg() {
            if (!ad()) {
                yj(true);
                fe();
            } else if (!de()) {
                uk(true);
                th();
            }
        }

        public final void th() {
            fe.mmm.qw.ggg.qw.qw.qw("hot_open_to_home_show", CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(System.currentTimeMillis() - qw())));
        }

        public final void uk(boolean z) {
            qw.f7840i = z;
        }

        public final void yj(boolean z) {
            qw.f7842uk = z;
        }
    }

    public qw() {
        f7843yj = System.currentTimeMillis();
    }

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (!CollectionsKt___CollectionsKt.contains(ad.qw, activity) && (activity instanceof FragmentActivity)) {
            ad.qw.add(activity);
        }
        if (ad.f7836ad == 0 && f7842uk) {
            f7843yj = System.currentTimeMillis();
        }
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        TypeIntrinsics.asMutableCollection(ad.qw).remove(activity);
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (ad.f7836ad == 0) {
            de.qw("frontdesk");
            ad.qw((ResultReceiver) null);
        }
        ad.f7836ad = ad.f7836ad + 1;
        if (ad.f7837de) {
            ad.f7837de = false;
        } else if (ad.f7836ad == 1) {
            ad.yj().postValue(Boolean.TRUE);
        }
        if (ad.f7836ad == 1) {
            this.f7844ad = System.currentTimeMillis();
        }
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ad.f7836ad = ad.f7836ad - 1;
        if (ad.f7836ad == 0) {
            th();
            ad.yj().postValue(Boolean.FALSE);
        }
    }

    public final void th() {
        fe.mmm.qw.ggg.qw.qw.qw("use_duration", CollectionsKt__CollectionsJVMKt.listOf(String.valueOf((System.currentTimeMillis() - this.f7844ad) / ((long) 1000))));
    }
}
