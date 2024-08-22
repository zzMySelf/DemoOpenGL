package fe.mmm.qw.xxx.p032if.qw;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.baidu.aiscan.R;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import fe.mmm.qw.p030switch.th.de.ad.ad;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.qw.i  reason: invalid package */
public final class i implements ISettingItem {
    @NotNull
    public String name() {
        return ad.qw(R.string.current_version);
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
        PackageInfo packageInfo;
        String str;
        Intrinsics.checkNotNullParameter(settingItemView, "item");
        Context context = settingItemView.getContext();
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null && (packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0)) != null && (str = packageInfo.versionName) != null) {
            settingItemView.setRightText(str);
        }
    }
}
