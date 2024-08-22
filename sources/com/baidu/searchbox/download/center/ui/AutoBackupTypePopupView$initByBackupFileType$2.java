package com.baidu.searchbox.download.center.ui;

import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AutoBackupTypePopupView.kt */
final class AutoBackupTypePopupView$initByBackupFileType$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AutoBackupTypePopupView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AutoBackupTypePopupView$initByBackupFileType$2(AutoBackupTypePopupView autoBackupTypePopupView) {
        super(0);
        this.this$0 = autoBackupTypePopupView;
    }

    public final void invoke() {
        NetDiskOptionWrapper netDiskOptionWrapper = NetDiskOptionWrapper.INSTANCE;
        final AutoBackupTypePopupView autoBackupTypePopupView = this.this$0;
        netDiskOptionWrapper.setSwitchStateOptionVideo(true, true, new Function1<Boolean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke(((Boolean) p1).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean it) {
                AutoBackupTypePopupView autoBackupTypePopupView = autoBackupTypePopupView;
                String string = autoBackupTypePopupView.mContext.getString(R.string.auto_backup_video_title_open);
                Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str…_backup_video_title_open)");
                autoBackupTypePopupView.onEnableAutoBackupSuccess(string);
            }
        });
    }
}
