package fe.mmm.qw.xxx;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.i.qw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe implements Application.ActivityLifecycleCallbacks {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final List<ad> f8577ad = new ArrayList();
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public de f8578th;

    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        qw.ad("NetdiskActivityLifecycle", "onActivityCreated : " + activity.getClass().getName());
        if (this.f8578th == null) {
            this.f8578th = new de();
        }
        String name = activity.getClass().getName();
        List<ad> list = this.f8577ad;
        int hashCode = activity.hashCode();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        list.add(new ad(hashCode, name, 0));
    }

    public void onActivityDestroyed(@NotNull Activity activity) {
        Object obj;
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        qw.ad("NetdiskActivityLifecycle", "onActivityDestroyed : " + activity.getClass().getName());
        List<ad> list = this.f8577ad;
        Iterator<ad> it = list.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                i2 = -1;
                break;
            } else {
                if (!(it.next().qw() == activity.hashCode())) {
                    i2++;
                }
            }
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(list.remove(i2));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r8 = Result.m1158exceptionOrNullimpl(obj);
        if (r8 != null) {
            LoggerKt.d$default("remove activity when onActivityDestroyed failed: " + r8.getMessage(), (Object) null, 1, (Object) null);
        }
    }

    public void onActivityPaused(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        qw.ad("NetdiskActivityLifecycle", "onActivityPaused : " + activity.getClass().getName());
        qw(activity.hashCode(), 3);
    }

    public void onActivityResumed(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        qw.ad("NetdiskActivityLifecycle", "onActivityResumed : " + activity.getClass().getName());
        qw(activity.hashCode(), 2);
    }

    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(bundle, "outState");
        qw.ad("NetdiskActivityLifecycle", "onActivitySaveInstanceState : " + activity.getClass().getName());
    }

    public void onActivityStarted(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        qw.ad("NetdiskActivityLifecycle", "onActivityStarted : " + activity.getClass().getName());
        qw(activity.hashCode(), 1);
        de deVar = this.f8578th;
        if (deVar != null) {
            deVar.rg(activity);
        }
    }

    public void onActivityStopped(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        qw.ad("NetdiskActivityLifecycle", "onActivityStopped : " + activity.getClass().getName());
        qw(activity.hashCode(), 4);
        de deVar = this.f8578th;
        if (deVar != null) {
            deVar.th(activity);
        }
    }

    public final void qw(int i2, int i3) {
        for (ad next : this.f8577ad) {
            if (next.qw() == i2) {
                next.ad(i3);
                return;
            }
        }
    }
}
