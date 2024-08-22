package fe.mmm.qw.xxx.p032if.rg;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.aiscan.R;
import com.tera.scan.account.OnLoginCallBack;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import fe.mmm.qw.p030switch.th.de.ad.ad;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.rg.rg  reason: invalid package */
public final class rg implements ISettingItem {
    @Nullable
    public OnLoginCallBack qw;

    /* renamed from: fe.mmm.qw.xxx.if.rg.rg$qw */
    public static final class qw implements OnLoginCallBack {
        public final /* synthetic */ SettingItemView qw;

        public qw(SettingItemView settingItemView) {
            this.qw = settingItemView;
        }

        public void ad() {
        }

        public void qw() {
            Context context = this.qw.getContext();
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final void qw(View view) {
        de.ad("PCntrClAc_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
        fe.mmm.qw.qw.qw.qw.i();
    }

    @NotNull
    public String name() {
        return ad.qw(R.string.account_manager);
    }

    public void onDestroy() {
        ISettingItem.qw.qw(this);
        OnLoginCallBack onLoginCallBack = this.qw;
        if (onLoginCallBack != null) {
            fe.mmm.qw.qw.qw.qw.ggg(onLoginCallBack);
        }
        this.qw = null;
    }

    public void onPause() {
        ISettingItem.qw.ad(this);
    }

    public void onResume() {
        ISettingItem.qw.de(this);
    }

    @Nullable
    public String rg() {
        return ISettingItem.qw.fe(this);
    }

    public void th(@NotNull SettingItemView settingItemView) {
        Intrinsics.checkNotNullParameter(settingItemView, "item");
        settingItemView.setVisibility(fe.mmm.qw.qw.qw.qw.pf() ? 0 : 8);
        settingItemView.setOnClickListener(de.f8616ad);
        qw qwVar = new qw(settingItemView);
        this.qw = qwVar;
        if (qwVar != null) {
            fe.mmm.qw.qw.qw.qw.de(qwVar);
        }
    }
}
