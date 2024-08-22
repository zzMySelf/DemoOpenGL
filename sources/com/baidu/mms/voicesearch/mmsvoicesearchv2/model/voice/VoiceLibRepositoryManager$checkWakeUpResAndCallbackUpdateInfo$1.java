package com.baidu.mms.voicesearch.mmsvoicesearchv2.model.voice;

import com.baidu.mms.voicesearch.mmsvoicesearchv2.model.voice.VoiceLibRepositoryManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/mms/voicesearch/mmsvoicesearchv2/model/voice/VoiceLibRepositoryManager$checkWakeUpResAndCallbackUpdateInfo$1", "Lcom/baidu/mms/voicesearch/mmsvoicesearchv2/model/voice/VoiceLibRepositoryManager$IlibRepoDownloadCallback;", "onDownLoadFailed", "", "string", "", "onDownLoadSuccess", "onProgress", "progress", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MMSVoiceLibRepositoryManager.kt */
public final class VoiceLibRepositoryManager$checkWakeUpResAndCallbackUpdateInfo$1 implements VoiceLibRepositoryManager.IlibRepoDownloadCallback {
    final /* synthetic */ VoiceLibRepositoryManager this$0;

    VoiceLibRepositoryManager$checkWakeUpResAndCallbackUpdateInfo$1(VoiceLibRepositoryManager $receiver) {
        this.this$0 = $receiver;
    }

    public void onDownLoadSuccess() {
        MMSVoiceWakeUpManager.getSharedInstance().startWakeup();
    }

    public void onDownLoadFailed(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.this$0.checkLocal();
    }

    public void onProgress(long progress) {
    }
}
