package com.baidu.mms.voicesearch.voice.view;

import android.view.View;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.model.utils.ToolsUtils;
import com.baidu.mms.voicesearch.voice.utils.VoiceUBCHelperKt;
import com.baidu.mms.voicesearch.voice.view.PermissionPopWindow;
import com.baidu.voicesearch.component.utils.VoiceParamManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/mms/voicesearch/voice/view/PermissionPopWindow$initView$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PermissionPopWindow.kt */
public final class PermissionPopWindow$initView$2 implements View.OnClickListener {
    final /* synthetic */ PermissionPopWindow this$0;

    PermissionPopWindow$initView$2(PermissionPopWindow $receiver) {
        this.this$0 = $receiver;
    }

    public void onClick(View v) {
        this.this$0.dismiss();
        PermissionPopWindow.PermissionPopWindowCallBack access$getPopWindowCallBack$p = this.this$0.popWindowCallBack;
        if (access$getPopWindowCallBack$p != null) {
            access$getPopWindowCallBack$p.onConfirm();
        }
        VoiceUBCHelperKt.ubcCustomPermission("click", "confirm_clk", VoiceParamManager.getInstance().getImeCommonParams());
        ToolsUtils.jumpToSetting();
    }
}
