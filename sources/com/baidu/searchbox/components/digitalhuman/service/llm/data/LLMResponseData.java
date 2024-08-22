package com.baidu.searchbox.components.digitalhuman.service.llm.data;

import com.baidu.searchbox.components.digitalhuman.service.tts.TtsPlayTask;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/components/digitalhuman/service/llm/data/LLMResponseData;", "", "playTask", "Lcom/baidu/searchbox/components/digitalhuman/service/tts/TtsPlayTask;", "qid", "", "(Lcom/baidu/searchbox/components/digitalhuman/service/tts/TtsPlayTask;Ljava/lang/String;)V", "getPlayTask", "()Lcom/baidu/searchbox/components/digitalhuman/service/tts/TtsPlayTask;", "getQid", "()Ljava/lang/String;", "toString", "digital-human-service-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LLMResponseData.kt */
public class LLMResponseData {
    private final TtsPlayTask playTask;
    private final String qid;

    public LLMResponseData(TtsPlayTask playTask2, String qid2) {
        Intrinsics.checkNotNullParameter(playTask2, "playTask");
        Intrinsics.checkNotNullParameter(qid2, "qid");
        this.playTask = playTask2;
        this.qid = qid2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LLMResponseData(TtsPlayTask ttsPlayTask, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(ttsPlayTask, (i2 & 2) != 0 ? "" : str);
    }

    public TtsPlayTask getPlayTask() {
        return this.playTask;
    }

    public String getQid() {
        return this.qid;
    }

    public String toString() {
        return "LLMResponseData(playTask=" + getPlayTask() + ')';
    }
}
