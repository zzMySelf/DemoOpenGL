package fe.mmm.qw.xxx.p032if.qw;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.framework.kernel.BaseApplication;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import com.tera.scan.upgrade.base.IUpgradeCallBack;
import com.tera.scan.upgrade.model.UpdateInfo;
import fe.mmm.qw.a.uk.rg;
import fe.mmm.qw.th.qw.th.o;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* renamed from: fe.mmm.qw.xxx.if.qw.switch  reason: invalid class name and invalid package */
public final class Cswitch implements ISettingItem, IUpgradeCallBack {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final qw f8612ad = new qw();
    @Nullable
    public WeakReference<Activity> qw;

    /* renamed from: fe.mmm.qw.xxx.if.qw.switch$ad */
    public static final class ad extends rg {
        public final /* synthetic */ SettingItemView ddd;
        public final /* synthetic */ Cswitch xxx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(Cswitch switchR, SettingItemView settingItemView) {
            super("settingsUpdateVersion");
            this.xxx = switchR;
            this.ddd = settingItemView;
        }

        public void when() throws Exception {
            fe.mmm.qw.g.qw.qw.qw.qw().tt(this.xxx, this.ddd.getContext());
        }
    }

    /* renamed from: fe.mmm.qw.xxx.if.qw.switch$qw */
    public static final class qw extends Handler {
        public qw() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(@NotNull Message message) {
            Intrinsics.checkNotNullParameter(message, "msg");
        }
    }

    public static final void i(Cswitch switchR, SettingItemView settingItemView, View view) {
        Intrinsics.checkNotNullParameter(switchR, "this$0");
        Intrinsics.checkNotNullParameter(settingItemView, "$item");
        new ad(switchR, settingItemView).mmm();
    }

    public static final void o(UpdateInfo updateInfo, Cswitch switchR) {
        int i2;
        Activity activity;
        Intrinsics.checkNotNullParameter(updateInfo, "$clientUpdateInfo");
        Intrinsics.checkNotNullParameter(switchR, "this$0");
        try {
            String str = updateInfo.mVercode;
            Intrinsics.checkNotNullExpressionValue(str, "clientUpdateInfo.mVercode");
            i2 = Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            i2 = -1;
        }
        String str2 = updateInfo.mVername;
        if (str2 == null) {
            str2 = "";
        }
        if (fe.mmm.qw.g.de.qw.fe(BaseApplication.getInstance(), str2, i2)) {
            WeakReference<Activity> weakReference = switchR.qw;
            if (weakReference != null && (activity = (Activity) weakReference.get()) != null) {
                fe.mmm.qw.g.qw.qw.qw.qw().p(activity, updateInfo);
                return;
            }
            return;
        }
        o.rg(R.string.already_lastet_version);
    }

    public static final void uk(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "$jsonObject");
        try {
            String string = jSONObject.getString("msgId");
            if (string != null) {
                int hashCode = string.hashCode();
                if (hashCode != 50) {
                    if (hashCode != 51) {
                        if (hashCode == 53) {
                            if (string.equals(BannerBaseItemInfo.TYPE_LOGIN)) {
                                o.rg(R.string.no_enough_free_space);
                                ExpectKt.success(Unit.INSTANCE);
                            }
                        }
                    } else if (string.equals("3")) {
                        o.rg(R.string.internal_server_error);
                        ExpectKt.success(Unit.INSTANCE);
                    }
                } else if (string.equals("2")) {
                    o.rg(R.string.network_exception_message);
                    ExpectKt.success(Unit.INSTANCE);
                }
            }
            o.rg(R.string.already_lastet_version);
            ExpectKt.success(Unit.INSTANCE);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            ExpectKt.failure(th2);
        }
    }

    public void ad(@Nullable JSONObject jSONObject) {
    }

    public void de(@Nullable JSONObject jSONObject) {
        fe.mmm.qw.i.qw.rg("AboutUpgradeVersionItem", "onError " + jSONObject);
        if (jSONObject != null) {
            yj(jSONObject);
        }
    }

    public void fe(@Nullable UpdateInfo updateInfo) {
        if (updateInfo != null) {
            this.f8612ad.post(new fe(updateInfo, this));
        }
    }

    @NotNull
    public String name() {
        return fe.mmm.qw.p030switch.th.de.ad.ad.qw(R.string.about_upgrade_version);
    }

    public void onDestroy() {
        ISettingItem.qw.qw(this);
    }

    public void onPause() {
        ISettingItem.qw.ad(this);
    }

    public void onResume() {
        ISettingItem.qw.de(this);
    }

    public void qw(@Nullable JSONObject jSONObject) {
        fe.mmm.qw.i.qw.rg("AboutUpgradeVersionItem", "onError " + jSONObject);
        if (jSONObject != null) {
            yj(jSONObject);
        }
    }

    @Nullable
    public String rg() {
        return ISettingItem.qw.fe(this);
    }

    public void th(@NotNull SettingItemView settingItemView) {
        Intrinsics.checkNotNullParameter(settingItemView, "item");
        Context context = settingItemView.getContext();
        this.qw = new WeakReference<>(context instanceof Activity ? (Activity) context : null);
        settingItemView.setOnClickListener(new qw(this, settingItemView));
    }

    public final void yj(JSONObject jSONObject) {
        this.f8612ad.post(new rg(jSONObject));
    }
}
