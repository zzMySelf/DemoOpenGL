package com.baidu.assistant.res.update;

import com.baidu.assistant.res.update.interfaces.AssistantDownloadExtCallback;
import com.baidu.assistant.res.update.interfaces.DownloadResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssistantResLoaderManager.kt */
final class AssistantResLoaderManager$startDownloadAssistant$1$4$onDownloadSucceed$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $assistantResId;
    final /* synthetic */ AssistantDownloadExtCallback $callback;
    final /* synthetic */ Ref.ObjectRef<String> $downloadVersion;
    final /* synthetic */ String $filePath;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssistantResLoaderManager$startDownloadAssistant$1$4$onDownloadSucceed$2(AssistantDownloadExtCallback assistantDownloadExtCallback, String str, String str2, Ref.ObjectRef<String> objectRef) {
        super(0);
        this.$callback = assistantDownloadExtCallback;
        this.$filePath = str;
        this.$assistantResId = str2;
        this.$downloadVersion = objectRef;
    }

    public final void invoke() {
        AssistantDownloadExtCallback assistantDownloadExtCallback = this.$callback;
        if (assistantDownloadExtCallback != null) {
            assistantDownloadExtCallback.onDownloadSucceed(this.$filePath);
        }
        AssistantDownloadExtCallback assistantDownloadExtCallback2 = this.$callback;
        if (assistantDownloadExtCallback2 != null) {
            assistantDownloadExtCallback2.ubcDownloadResult(DownloadResult.SUCCESS, this.$assistantResId, "basic", (String) this.$downloadVersion.element);
        }
    }
}
