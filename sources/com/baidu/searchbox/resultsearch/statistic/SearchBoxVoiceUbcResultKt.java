package com.baidu.searchbox.resultsearch.statistic;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\b\u001a\u00020\t\u001a\u0006\u0010\n\u001a\u00020\t\u001a$\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"FROM_AI_SEARCH", "", "PAGE_HOME", "TAG", "TYPE_CLICK", "TYPE_SHOW", "UBCID", "VALUE_AI_VOICE_IC", "ubcResultVoiceIconClick", "", "ubcResultVoiceIconShow", "voiceUbc", "type", "value", "ext", "Lorg/json/JSONObject;", "lib-result-search_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SearchBoxVoiceUbcResult.kt */
public final class SearchBoxVoiceUbcResultKt {
    private static final String FROM_AI_SEARCH = "aisearch";
    private static final String PAGE_HOME = "resultpage";
    private static final String TAG = "ubcVoiceGuide";
    private static final String TYPE_CLICK = "click";
    private static final String TYPE_SHOW = "show";
    private static final String UBCID = "6467";
    private static final String VALUE_AI_VOICE_IC = "ai_voice";

    public static final void ubcResultVoiceIconShow() {
        voiceUbc$default("show", VALUE_AI_VOICE_IC, (JSONObject) null, 4, (Object) null);
    }

    public static final void ubcResultVoiceIconClick() {
        voiceUbc$default("click", VALUE_AI_VOICE_IC, (JSONObject) null, 4, (Object) null);
    }

    static /* synthetic */ void voiceUbc$default(String str, String str2, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            jSONObject = null;
        }
        voiceUbc(str, str2, jSONObject);
    }

    private static final void voiceUbc(String type, String value, JSONObject ext) {
        try {
            Result.Companion companion = Result.Companion;
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("from", "aisearch");
            jsonObject.put("page", "resultpage");
            jsonObject.put("type", type);
            jsonObject.put("value", value);
            if (ext != null) {
                JSONObject jSONObject = ext;
                jsonObject.put("ext", ext);
            }
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(UBCID, jsonObject);
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }
}
