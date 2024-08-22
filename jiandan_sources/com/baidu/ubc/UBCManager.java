package com.baidu.ubc;

import fe.fe.mmm.Cif;
import fe.fe.mmm.ggg;
import fe.fe.mmm.nn;
import fe.fe.vvv.ad.ad.de;
import java.util.Map;
import org.json.JSONObject;

public interface UBCManager {
    public static final String CONTENT_KEY_DURATION = "duration";
    public static final String CONTENT_KEY_EXT = "ext";
    public static final String CONTENT_KEY_FROM = "from";
    public static final String CONTENT_KEY_PAGE = "page";
    public static final String CONTENT_KEY_SOURCE = "source";
    public static final String CONTENT_KEY_TYPE = "type";
    public static final String CONTENT_KEY_VALUE = "value";
    public static final de SERVICE_REFERENCE = new de("ubc", "UBC");

    Flow beginFlow(String str);

    Flow beginFlow(String str, int i2);

    Flow beginFlow(String str, String str2);

    Flow beginFlow(String str, String str2, int i2);

    Flow beginFlow(String str, Map<String, String> map);

    Flow beginFlow(String str, Map<String, String> map, int i2);

    Flow beginFlow(String str, JSONObject jSONObject);

    Flow beginFlow(String str, JSONObject jSONObject, int i2);

    void flowAddEvent(Flow flow, String str);

    void flowAddEvent(Flow flow, String str, String str2);

    void flowAddEventWithDate(Flow flow, String str, String str2, long j);

    void flowCancel(Flow flow);

    void flowEnd(Flow flow);

    void flowEndSlot(Flow flow, String str);

    void flowSetValue(Flow flow, String str);

    void flowSetValue(Flow flow, Map<String, String> map);

    void flowSetValueWithDuration(Flow flow, String str);

    void flowStartSlot(Flow flow, String str, JSONObject jSONObject);

    void flush();

    String getUploadType(String str);

    boolean isUBCDebug();

    boolean isUBCSample();

    boolean isUseOfflineUrl();

    void onEvent(String str);

    void onEvent(String str, int i2);

    void onEvent(String str, String str2);

    void onEvent(String str, String str2, int i2);

    void onEvent(String str, Map<String, String> map);

    void onEvent(String str, Map<String, String> map, int i2);

    void onEvent(String str, JSONObject jSONObject);

    void onEvent(String str, JSONObject jSONObject, int i2);

    void registerBizParamData(Cif ifVar);

    void registerConfig(nn nnVar);

    void registerConfig(nn nnVar, boolean z, IUBCStatisticCallback iUBCStatisticCallback);

    void setDefaultConfig(ggg ggg);

    void setUBCDebug(boolean z);

    void setUBCSample(boolean z);

    void setUseOfflineUrl(boolean z);

    void upload();

    void uploadFailedData();

    void uploadLocalDatas();
}
