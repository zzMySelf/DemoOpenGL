package fe.mmm.qw.m.xxx;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.aiscan.R;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import fe.mmm.qw.d.fe.yj;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Tag("WebTopBarColorControl")
public final class ad {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f8066ad;
    @NotNull
    public final String qw;

    public ad(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.qw = str;
    }

    public static /* synthetic */ void rg(ad adVar, Activity activity, fe.mmm.qw.f.fe.ad.ad adVar2, Integer num, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            num = null;
        }
        adVar.fe(activity, adVar2, num);
    }

    public final void ad(Activity activity, fe.mmm.qw.f.fe.ad.ad adVar, int i2) {
        adVar.m968if(i2);
        TextView yj2 = adVar.yj();
        if (yj2 != null) {
            yj2.setTextColor(yj.qw(R.color.white));
        }
        adVar.i(activity.getResources().getDrawable(R.drawable.back_left));
    }

    @JvmOverloads
    public final void de(@NotNull Activity activity, @NotNull fe.mmm.qw.f.fe.ad.ad adVar) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(adVar, "titleBar");
        rg(this, activity, adVar, (Integer) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void fe(@NotNull Activity activity, @NotNull fe.mmm.qw.f.fe.ad.ad adVar, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(adVar, "titleBar");
        LoggerKt.d$default("activity:" + activity + ", color:" + num, (Object) null, 1, (Object) null);
        if (num == null) {
            num = uk();
            LoggerKt.d$default("targetColor:" + num, (Object) null, 1, (Object) null);
        }
        if (num != null) {
            num.intValue();
            ad(activity, adVar, num.intValue());
            qw.yj(activity, num.intValue());
            this.f8066ad = true;
            LoggerKt.d$default("isChangedTopColor:" + this.f8066ad, (Object) null, 1, (Object) null);
        }
    }

    public final boolean i() {
        return th();
    }

    public final boolean o() {
        return yj();
    }

    public final boolean pf() {
        Integer num = (Integer) LoggerKt.d(uk(), "getCustomTopBarColor:");
        if (num == null) {
            return false;
        }
        num.intValue();
        return true;
    }

    public final void qw(@NotNull Activity activity, int i2, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        try {
            Result.Companion companion = Result.Companion;
            if (num != null) {
                if (num.intValue() == 0) {
                    qw.o(activity);
                    qw.yj(activity, i2);
                    Result.m1155constructorimpl(Unit.INSTANCE);
                }
            }
            if (num != null) {
                if (num.intValue() == 1) {
                    qw.i(activity);
                }
            }
            qw.yj(activity, i2);
            Result.m1155constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
    }

    public final boolean th() {
        Boolean bool;
        try {
            Result.Companion companion = Result.Companion;
            Uri parse = Uri.parse(this.qw);
            boolean z = false;
            if (parse != null) {
                z = parse.getBooleanQueryParameter("na_immerse_theme", false);
            }
            bool = Result.m1155constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.m1161isFailureimpl(bool)) {
            bool = bool2;
        }
        return ((Boolean) bool).booleanValue();
    }

    public final Integer uk() {
        Integer num = null;
        try {
            Result.Companion companion = Result.Companion;
            Uri parse = Uri.parse(this.qw);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter("na_theme");
                if (queryParameter != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "Uri.parse(url)?.getQuery…_NA_THEME) ?: return null");
                    LoggerKt.d$default("paramValue:" + queryParameter, (Object) null, 1, (Object) null);
                    return (Integer) LoggerKt.d(Integer.valueOf(Color.parseColor('#' + queryParameter)), "color:");
                }
            }
            return null;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Object r1 = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            if (!Result.m1161isFailureimpl(r1)) {
                num = r1;
            }
            return num;
        }
    }

    public final boolean yj() {
        Boolean bool;
        try {
            Result.Companion companion = Result.Companion;
            Uri parse = Uri.parse(this.qw);
            boolean z = false;
            if (parse != null) {
                z = parse.getBooleanQueryParameter("na_normal_theme", false);
            }
            bool = Result.m1155constructorimpl(Boolean.valueOf(z));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        Boolean bool2 = Boolean.FALSE;
        if (Result.m1161isFailureimpl(bool)) {
            bool = bool2;
        }
        return ((Boolean) bool).booleanValue();
    }
}
