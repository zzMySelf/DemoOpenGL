package fe.mmm.qw.xxx.p032if.qw;

import android.view.View;
import com.baidu.aiscan.R;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sofire.xclient.privacycontrol.PrvDataManager;
import com.baidu.sofire.xclient.privacycontrol.ui.IDoubleListCallBack;
import com.mars.kotlin.extension.LoggerKt;
import com.tera.scan.main.ui.settingitems.ISettingItem;
import com.tera.scan.main.view.SettingItemView;
import fe.mmm.qw.p030switch.th.de.ad.ad;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fe.mmm.qw.xxx.if.qw.uk  reason: invalid package */
public final class uk implements ISettingItem {

    /* renamed from: fe.mmm.qw.xxx.if.qw.uk$qw */
    public static final class qw implements IDoubleListCallBack {
        public void onLoginFail(@Nullable WebAuthResult webAuthResult) {
            LoggerKt.d$default("打开【已收集个人信息清单】>> onLoginFail 回调", (Object) null, 1, (Object) null);
        }

        public void onLoginSuccess(@Nullable WebAuthResult webAuthResult) {
            LoggerKt.d$default("打开【已收集个人信息清单】>> onLoginSuccess 回调", (Object) null, 1, (Object) null);
        }

        public void onPassNotInit() {
            LoggerKt.d$default("打开【已收集个人信息清单】>> onPassNotInit 回调", (Object) null, 1, (Object) null);
        }
    }

    public static final void qw(SettingItemView settingItemView, View view) {
        Intrinsics.checkNotNullParameter(settingItemView, "$item");
        LoggerKt.d$default("Sofire 双清单：打开【已收集个人信息清单】", (Object) null, 1, (Object) null);
        PrvDataManager.gotoDoubleListUserPage(settingItemView.getContext(), (IDoubleListCallBack) new qw());
    }

    @NotNull
    public String name() {
        return ad.qw(R.string.about_collect_personal_info);
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
        settingItemView.setOnClickListener(new ad(settingItemView));
    }
}
