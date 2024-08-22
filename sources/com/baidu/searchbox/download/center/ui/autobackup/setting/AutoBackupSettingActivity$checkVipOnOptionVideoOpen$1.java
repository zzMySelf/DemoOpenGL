package com.baidu.searchbox.download.center.ui.autobackup.setting;

import com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoBackupSettingActivity.kt */
final class AutoBackupSettingActivity$checkVipOnOptionVideoOpen$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AutoBackupSettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoBackupSettingActivity$checkVipOnOptionVideoOpen$1(AutoBackupSettingActivity autoBackupSettingActivity) {
        super(0);
        this.this$0 = autoBackupSettingActivity;
    }

    public final void invoke() {
        NetDiskOptionWrapper netDiskOptionWrapper = NetDiskOptionWrapper.INSTANCE;
        final AutoBackupSettingActivity autoBackupSettingActivity = this.this$0;
        netDiskOptionWrapper.refreshDiskAccountCache(new Function0<Unit>() {
            public final void invoke() {
                autoBackupSettingActivity.openOptionVideo();
            }
        });
    }
}
