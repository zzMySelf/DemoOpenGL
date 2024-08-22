package com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto;

import com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "autoBackupSwitchState", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoAutoBackupSwitchView.kt */
final class VideoAutoBackupSwitchView$openVideoAutoBackup$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ VideoAutoBackupSwitchView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoAutoBackupSwitchView$openVideoAutoBackup$1(VideoAutoBackupSwitchView videoAutoBackupSwitchView) {
        super(1);
        this.this$0 = videoAutoBackupSwitchView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean autoBackupSwitchState) {
        if (!autoBackupSwitchState) {
            IAutoBackupSwitchListener autoBackupSwitchOperatorListener = this.this$0.getAutoBackupSwitchOperatorListener();
            if (autoBackupSwitchOperatorListener != null) {
                autoBackupSwitchOperatorListener.onOpenSwitchFailed();
                return;
            }
            return;
        }
        this.this$0.setMAutoBackupSwitch(autoBackupSwitchState);
        NetDiskOptionWrapper.INSTANCE.startAutoBackup();
        IAutoBackupSwitchListener autoBackupSwitchOperatorListener2 = this.this$0.getAutoBackupSwitchOperatorListener();
        if (autoBackupSwitchOperatorListener2 != null) {
            autoBackupSwitchOperatorListener2.onOpenSwitchSuccess();
        }
    }
}
