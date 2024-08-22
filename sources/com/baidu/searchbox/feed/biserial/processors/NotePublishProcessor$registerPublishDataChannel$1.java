package com.baidu.searchbox.feed.biserial.processors;

import android.text.TextUtils;
import com.baidu.searchbox.datachannel.NAReceiverCallback;
import com.baidu.searchbox.ugc.model.UgcConstant;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/baidu/searchbox/feed/biserial/processors/NotePublishProcessor$registerPublishDataChannel$1", "Lcom/baidu/searchbox/datachannel/NAReceiverCallback;", "onReceive", "", "action", "", "data", "lib-feed-biserial_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NotePublishProcessor.kt */
public final class NotePublishProcessor$registerPublishDataChannel$1 extends NAReceiverCallback {
    final /* synthetic */ NotePublishProcessor this$0;

    NotePublishProcessor$registerPublishDataChannel$1(NotePublishProcessor $receiver) {
        this.this$0 = $receiver;
    }

    public void onReceive(String action, String data) {
        Object obj;
        if (TextUtils.equals("com.baidu.channel.feed.ugcpublishstatus", action)) {
            CharSequence charSequence = data;
            if (!(charSequence == null || charSequence.length() == 0)) {
                try {
                    Result.Companion companion = Result.Companion;
                    obj = Result.m8971constructorimpl(new JSONObject(data).getJSONObject(UgcConstant.UGC_ASYNC_TASK_PUBLISH_RESULT).toString());
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
                if (Result.m8977isFailureimpl(obj)) {
                    obj = null;
                }
                this.this$0.processPublishResult((String) obj);
            }
        }
    }
}
