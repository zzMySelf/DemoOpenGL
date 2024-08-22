package com.baidu.swan.apps.impl.ai.voice.recognize.voice2text;

import com.baidu.swan.apps.framework.DefaultActivityCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/swan/apps/impl/ai/voice/recognize/voice2text/VoicePanelRootView$activityCallback$1", "Lcom/baidu/swan/apps/framework/DefaultActivityCallback;", "onActivityDestroyed", "", "onActivityPaused", "onActivityResumed", "onActivityStopped", "lib-swan-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoicePanelRootView.kt */
public final class VoicePanelRootView$activityCallback$1 extends DefaultActivityCallback {
    final /* synthetic */ VoicePanelRootView this$0;

    VoicePanelRootView$activityCallback$1(VoicePanelRootView $receiver) {
        this.this$0 = $receiver;
    }

    public void onActivityPaused() {
        this.this$0.mCurrentStatus = VoicePanelStatus.BREAK;
    }

    public void onActivityStopped() {
        this.this$0.mCurrentStatus = VoicePanelStatus.BREAK;
    }

    public void onActivityResumed() {
        if (this.this$0.mCurrentStatus == VoicePanelStatus.BREAK) {
            this.this$0.changeToBreakStatus();
            VoicePanelRootView voicePanelRootView = this.this$0;
            if (!voicePanelRootView.hasAudioPermission(voicePanelRootView.getSwanActivity())) {
                this.this$0.changeToNoPermission();
            }
        }
    }

    public void onActivityDestroyed() {
        this.this$0.getListener().onFail(this.this$0.getErrorCode());
        this.this$0.runExitAnim();
    }
}
