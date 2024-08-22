package com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting;

import android.widget.CheckBox;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.setting.SettingItemViewForPanel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/uikit/setting/SettingItemViewForPanel$wakeUpHasStart$1", "Ljava/lang/Runnable;", "run", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SettingItemViewForPanel.kt */
public final class SettingItemViewForPanel$wakeUpHasStart$1 implements Runnable {
    final /* synthetic */ SettingItemViewForPanel this$0;

    SettingItemViewForPanel$wakeUpHasStart$1(SettingItemViewForPanel $receiver) {
        this.this$0 = $receiver;
    }

    public void run() {
        CheckBox access$getCheckButton$p = this.this$0.checkButton;
        if (access$getCheckButton$p != null) {
            access$getCheckButton$p.setChecked(true);
        }
        SettingItemViewForPanel.WakeUpButtonSwitchCallBack access$getSwitchCallBackWakeup$p = this.this$0.switchCallBackWakeup;
        if (access$getSwitchCallBackWakeup$p != null) {
            access$getSwitchCallBackWakeup$p.onDownloadSuccess();
        }
    }
}
