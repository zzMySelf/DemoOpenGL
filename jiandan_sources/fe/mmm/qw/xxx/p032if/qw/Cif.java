package fe.mmm.qw.xxx.p032if.qw;

import android.view.View;
import com.baidu.aiscan.R;
import com.baidu.sofire.xclient.privacycontrol.PrvDataManager;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import fe.mmm.qw.p030switch.th.de.ad.ad;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.qw.if  reason: invalid class name and invalid package */
public final class Cif implements ISettingItem {
    public static final void qw(SettingItemView settingItemView, View view) {
        Intrinsics.checkNotNullParameter(settingItemView, "$item");
        LoggerKt.d$default("Sofire 双清单：跳转到【与第三方共享个人信息清单】", (Object) null, 1, (Object) null);
        PrvDataManager.gotoDoubleListThirdPage(settingItemView.getContext());
    }

    @NotNull
    public String name() {
        return ad.qw(R.string.about_share_to_other_app_personal_info);
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

    @Nullable
    public String rg() {
        return ISettingItem.qw.fe(this);
    }

    public void th(@NotNull SettingItemView settingItemView) {
        Intrinsics.checkNotNullParameter(settingItemView, "item");
        settingItemView.setOnClickListener(new de(settingItemView));
    }
}
