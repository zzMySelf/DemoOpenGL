package fe.mmm.qw.xxx.p032if.qw;

import android.view.View;
import com.baidu.aiscan.R;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import fe.mmm.qw.p030switch.th.de.ad.ad;
import fe.mmm.qw.xxx.pf.de;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.qw.when  reason: invalid package */
public final class when implements ISettingItem {
    public static final void qw(SettingItemView settingItemView, View view) {
        Intrinsics.checkNotNullParameter(settingItemView, "$item");
        de.ad("PCntrUA_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
        fe.mmm.qw.l.de.ad(settingItemView.getContext(), "https://pan.baidu.com/disk/base/protocol#/scan_service");
    }

    @NotNull
    public String name() {
        return ad.qw(R.string.term_of_use);
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
        settingItemView.setOnClickListener(new yj(settingItemView));
    }
}
