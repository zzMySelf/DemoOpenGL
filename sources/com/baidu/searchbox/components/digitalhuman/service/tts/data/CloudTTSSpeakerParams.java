package com.baidu.searchbox.components.digitalhuman.service.tts.data;

import com.baidu.searchbox.feed.tts.interfaces.IFeedTTSContext;
import com.baidu.swan.apps.impl.ai.tts.model.RequestParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u0003R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/components/digitalhuman/service/tts/data/CloudTTSSpeakerParams;", "", "pdt", "", "per", "audioCtrl", "ttsParamsJson", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAudioCtrl", "()Ljava/lang/String;", "getPdt", "getPer", "getTtsParamsJson", "getTTSParams", "digital-human-service-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TTSSpeakerParams.kt */
public final class CloudTTSSpeakerParams {
    private final String audioCtrl;
    private final String pdt;
    private final String per;
    private final String ttsParamsJson;

    public CloudTTSSpeakerParams() {
        this((String) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public CloudTTSSpeakerParams(String pdt2, String per2, String audioCtrl2, String ttsParamsJson2) {
        this.pdt = pdt2;
        this.per = per2;
        this.audioCtrl = audioCtrl2;
        this.ttsParamsJson = ttsParamsJson2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CloudTTSSpeakerParams(String str, String str2, String str3, String str4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4);
    }

    public final String getPdt() {
        return this.pdt;
    }

    public final String getPer() {
        return this.per;
    }

    public final String getAudioCtrl() {
        return this.audioCtrl;
    }

    public final String getTtsParamsJson() {
        return this.ttsParamsJson;
    }

    public final String getTTSParams() {
        CharSequence charSequence = this.ttsParamsJson;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            return this.ttsParamsJson;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject $this$getTTSParams_u24lambda_u2d0 = jSONObject;
        $this$getTTSParams_u24lambda_u2d0.put("pdt", this.pdt);
        $this$getTTSParams_u24lambda_u2d0.put(RequestParams.K_TO_MAP_PER, this.per);
        $this$getTTSParams_u24lambda_u2d0.put(IFeedTTSContext.KEY_AUDIO_CTRL, this.audioCtrl);
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "{\n            JSONObject…   }.toString()\n        }");
        return jSONObject2;
    }
}
