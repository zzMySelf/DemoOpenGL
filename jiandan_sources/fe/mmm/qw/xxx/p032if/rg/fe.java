package fe.mmm.qw.xxx.p032if.rg;

import android.view.View;
import com.baidu.aiscan.R;
import com.tera.scan.libanalytics.ScanAnalyticsBaseEvent;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import fe.mmm.qw.ggg.qw;
import fe.mmm.qw.th.qw.th.o;
import fe.mmm.qw.xxx.pf.de;
import fe.mmm.qw.xxx.when.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.rg.fe  reason: invalid package */
public final class fe implements ISettingItem {
    @NotNull
    public final List<String> qw = new ArrayList();

    public static final void ad(fe feVar, SettingItemView settingItemView, View view) {
        Intrinsics.checkNotNullParameter(feVar, "this$0");
        Intrinsics.checkNotNullParameter(settingItemView, "$item");
        feVar.qw(settingItemView);
        ScanAnalyticsBaseEvent.qw.qw(qw.qw, "sidebar_settings_page_clean_cache_click", (List) null, 2, (Object) null);
        de.ad("PCntrClr_clk", "PCntr", (String) null, (Map) null, 12, (Object) null);
    }

    public final void de(SettingItemView settingItemView) {
        Object obj;
        this.qw.addAll(CollectionsKt__CollectionsJVMKt.listOf(settingItemView.getContext().getCacheDir().getPath()));
        File externalCacheDir = settingItemView.getContext().getExternalCacheDir();
        if (externalCacheDir != null) {
            List<String> list = this.qw;
            list.addAll(CollectionsKt__CollectionsJVMKt.listOf(externalCacheDir.getPath() + "/scan"));
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1155constructorimpl(ad.qw.rg(this.qw));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str == null) {
            str = "";
        }
        settingItemView.setTips(str);
    }

    @NotNull
    public String name() {
        return fe.mmm.qw.p030switch.th.de.ad.ad.qw(R.string.clear_cache);
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

    public final void qw(SettingItemView settingItemView) {
        ad.qw.qw(this.qw);
        o.rg(R.string.cleaned);
        settingItemView.setTips("");
    }

    @Nullable
    public String rg() {
        return ISettingItem.qw.fe(this);
    }

    public void th(@NotNull SettingItemView settingItemView) {
        Intrinsics.checkNotNullParameter(settingItemView, "item");
        de(settingItemView);
        settingItemView.setOnClickListener(new qw(this, settingItemView));
    }
}
