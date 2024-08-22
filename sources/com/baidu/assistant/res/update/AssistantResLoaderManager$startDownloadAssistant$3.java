package com.baidu.assistant.res.update;

import com.baidu.assistant.res.update.interfaces.AssistantDownloadExtCallback;
import com.baidu.assistant.res.update.interfaces.DownloadResult;
import com.baidu.assistant.res.update.interfaces.FailReason;
import com.baidu.assistant.res.update.utils.AssistantDownloadUbcUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantResLoaderManager.kt */
final class AssistantResLoaderManager$startDownloadAssistant$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $assistantResId;
    final /* synthetic */ AssistantDownloadExtCallback $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssistantResLoaderManager$startDownloadAssistant$3(AssistantDownloadExtCallback assistantDownloadExtCallback, String str) {
        super(0);
        this.$callback = assistantDownloadExtCallback;
        this.$assistantResId = str;
    }

    public final void invoke() {
        AssistantDownloadExtCallback assistantDownloadExtCallback = this.$callback;
        if (assistantDownloadExtCallback != null) {
            assistantDownloadExtCallback.onDownloadFail(FailReason.Fail);
        }
        AssistantDownloadUbcUtil.INSTANCE.ubcDownloadError();
        AssistantDownloadExtCallback assistantDownloadExtCallback2 = this.$callback;
        if (assistantDownloadExtCallback2 != null) {
            assistantDownloadExtCallback2.ubcDownloadResult(DownloadResult.FAIL, this.$assistantResId, "basic", "");
        }
    }
}
