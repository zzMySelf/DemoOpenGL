package com.baidu.mms.voicesearch.voice.view.guide;

import android.os.Bundle;
import com.baidu.mms.voicesearch.api.VoiceSearchManager;
import com.baidu.voicesearch.component.utils.NormalTask;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/baidu/mms/voicesearch/voice/view/guide/WebViewInterface$openHotVoice$1", "Lcom/baidu/voicesearch/component/utils/NormalTask;", "doTask", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewInterface.kt */
public final class WebViewInterface$openHotVoice$1 extends NormalTask {
    final /* synthetic */ JSONObject $command;
    final /* synthetic */ WebViewInterface this$0;

    WebViewInterface$openHotVoice$1(WebViewInterface $receiver, JSONObject $command2) {
        this.this$0 = $receiver;
        this.$command = $command2;
    }

    public boolean doTask() {
        String string;
        VoiceSearchManager.getInstance().getVoiceSearchCallback().executeDirectSearch(this.this$0.mContext, this.$command, (Bundle) null);
        JSONObject jSONObject = this.$command;
        boolean z = true;
        if (jSONObject != null && jSONObject.has("keepAlive")) {
            JSONObject jSONObject2 = this.$command;
            boolean keepAlive = (jSONObject2 == null || (string = jSONObject2.getString("keepAlive")) == null || !string.equals("1")) ? false : true;
            JSONObject jSONObject3 = this.$command;
            if (jSONObject3 != null) {
                jSONObject3.remove("keepAlive");
            }
        }
        JSONObject jSONObject4 = this.$command;
        if (jSONObject4 != null && jSONObject4.has("url")) {
            JSONObject jSONObject5 = this.$command;
            String url = jSONObject5 != null ? jSONObject5.getString("url") : null;
            if (url == null || !StringsKt.startsWith$default(url, "http", false, 2, (Object) null)) {
                z = false;
            }
            if (z) {
            }
        }
        return super.doTask();
    }
}
