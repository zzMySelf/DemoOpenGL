package fe.mmm.qw.xxx.p033switch;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.ActivityChooserModel;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.Tag;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.upgrade.base.IUpgradeCallBack;
import com.tera.scan.upgrade.model.UpdateInfo;
import fe.mmm.qw.g.qw.qw;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Tag("NetdiskUpgradeCallBack")
/* renamed from: fe.mmm.qw.xxx.switch.ad  reason: invalid package */
public final class ad implements IUpgradeCallBack {
    @NotNull
    public final WeakReference<Activity> qw;

    public ad(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.qw = new WeakReference<>(activity);
    }

    public static final void th(ad adVar, UpdateInfo updateInfo) {
        Intrinsics.checkNotNullParameter(adVar, "this$0");
        Intrinsics.checkNotNullParameter(updateInfo, "$clientUpdateInfo");
        Activity activity = (Activity) adVar.qw.get();
        if (activity != null) {
            qw.qw.qw().p(activity, updateInfo);
        }
    }

    public void ad(@Nullable JSONObject jSONObject) {
        LoggerKt.d$default("onFetched " + jSONObject, (Object) null, 1, (Object) null);
    }

    public void de(@Nullable JSONObject jSONObject) {
        LoggerKt.d$default("onError " + jSONObject, (Object) null, 1, (Object) null);
        fe.mmm.qw.g.de.qw.th(false);
    }

    public void fe(@Nullable UpdateInfo updateInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("onCompleted ");
        sb.append(updateInfo != null ? updateInfo.mVername : null);
        LoggerKt.d$default(sb.toString(), (Object) null, 1, (Object) null);
        if (!fe.mmm.qw.g.de.qw.de() && updateInfo != null) {
            int i2 = -1;
            try {
                String str = updateInfo.mVercode;
                Intrinsics.checkNotNullExpressionValue(str, "clientUpdateInfo.mVercode");
                i2 = Integer.parseInt(str);
                ExpectKt.success(Unit.INSTANCE);
            } catch (Throwable th2) {
                LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
                ExpectKt.failure(th2);
            }
            if (fe.mmm.qw.g.de.qw.fe(BaseApplication.getInstance(), updateInfo.mVername, i2)) {
                fe.mmm.qw.g.de.qw.th(true);
                LoggerKt.d$default("是否强制升级 " + Intrinsics.areEqual((Object) "1", (Object) updateInfo.mIsForceUpdate), (Object) null, 1, (Object) null);
                if (Intrinsics.areEqual((Object) "1", (Object) updateInfo.mIsForceUpdate)) {
                    fe.mmm.qw.g.de.qw.rg();
                }
                rg(updateInfo);
            }
        }
    }

    public void qw(@Nullable JSONObject jSONObject) {
        LoggerKt.d$default("onException " + jSONObject, (Object) null, 1, (Object) null);
        fe.mmm.qw.g.de.qw.th(false);
    }

    public final void rg(UpdateInfo updateInfo) {
        new Handler(Looper.getMainLooper()).post(new qw(this, updateInfo));
    }
}
