package com.baidu.searchbox.search.tab.implement.tplmodel;

import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006J\u0015\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020\u0006¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001J\u001f\u0010/\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u00101J5\u0010/\u001a\u0004\u0018\u00010)2&\u00102\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000603j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006`4¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0006H\u0016R(\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0007R(\u0010\r\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\u0007R(\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0004R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000fR(\u0010\u0019\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\u0007R(\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\u0007R(\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\u0007R(\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b#\u0010\u000b\"\u0004\b$\u0010\u0007R(\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010\u0007¨\u00067"}, d2 = {"Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoExtLog;", "", "extLogObj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "extLogString", "", "(Ljava/lang/String;)V", "value", "applid", "getApplid", "()Ljava/lang/String;", "setApplid", "autoPlayExt", "getAutoPlayExt", "()Lorg/json/JSONObject;", "setAutoPlayExt", "getExtLogObj", "getExtLogString", "setExtLogString", "extra", "getExtra", "setExtra", "extraObj", "getExtraObj", "lid", "getLid", "setLid", "order", "getOrder", "setOrder", "pn", "getPn", "setPn", "q", "getQ", "setQ", "srcid", "getSrcid", "setSrcid", "removeExt", "", "key", "removeExtraObj", "extraKey", "(Ljava/lang/String;)Lkotlin/Unit;", "setExt", "setExtraObj", "extraValue", "(Ljava/lang/String;Ljava/lang/String;)Lkotlin/Unit;", "map", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;)Lkotlin/Unit;", "toString", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoExtLog.kt */
public final class VideoExtLog {
    private String extLogString;

    public VideoExtLog(String extLogString2) {
        this.extLogString = extLogString2;
    }

    public final String getExtLogString() {
        return this.extLogString;
    }

    public final void setExtLogString(String str) {
        this.extLogString = str;
    }

    public VideoExtLog(JSONObject extLogObj) {
        this(String.valueOf(extLogObj));
    }

    public final JSONObject getExtLogObj() {
        String it = this.extLogString;
        if (it != null) {
            return new JSONObject(it);
        }
        return null;
    }

    public final String getQ() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optString("q");
        }
        return null;
    }

    public final void setQ(String value) {
        setExt("q", value);
    }

    public final String getApplid() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optString("applid");
        }
        return null;
    }

    public final void setApplid(String value) {
        setExt("applid", value);
    }

    public final String getLid() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optString("lid");
        }
        return null;
    }

    public final void setLid(String value) {
        setExt("lid", value);
    }

    public final String getPn() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optString("pn");
        }
        return null;
    }

    public final void setPn(String value) {
        setExt("pn", value);
    }

    public final String getSrcid() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optString("srcid");
        }
        return null;
    }

    public final void setSrcid(String value) {
        setExt("srcid", value);
    }

    public final JSONObject getExtra() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optJSONObject("extra");
        }
        return null;
    }

    public final void setExtra(JSONObject value) {
        setExt("extra", value);
    }

    public final JSONObject getAutoPlayExt() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optJSONObject("auto_play_ext");
        }
        return null;
    }

    public final void setAutoPlayExt(JSONObject value) {
        setExt("auto_play_ext", value);
    }

    private final JSONObject getExtraObj() {
        JSONObject it = getExtLogObj();
        if (it == null) {
            return null;
        }
        try {
            return new JSONObject(it.optString("extra"));
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
            return new JSONObject();
        }
    }

    public final String getOrder() {
        JSONObject extLogObj = getExtLogObj();
        if (extLogObj != null) {
            return extLogObj.optString("order");
        }
        return null;
    }

    public final void setOrder(String value) {
        setExt("order", value);
    }

    public final void setExt(String key, Object value) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject it = getExtLogObj();
        if (it != null) {
            JSONObject newJson = new JSONObject(it.toString());
            newJson.put(key, value);
            this.extLogString = newJson.toString();
        }
    }

    public final void removeExt(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        JSONObject $this$removeExt_u24lambda_u2d3 = getExtLogObj();
        if ($this$removeExt_u24lambda_u2d3 != null) {
            $this$removeExt_u24lambda_u2d3.remove(key);
            this.extLogString = $this$removeExt_u24lambda_u2d3.toString();
        }
    }

    public final Unit setExtraObj(String extraKey, String extraValue) {
        Intrinsics.checkNotNullParameter(extraKey, "extraKey");
        JSONObject it = getExtraObj();
        if (it == null) {
            return null;
        }
        it.put(extraKey, extraValue);
        setExtra(it);
        return Unit.INSTANCE;
    }

    public final Unit setExtraObj(HashMap<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        JSONObject it = getExtraObj();
        if (it == null) {
            return null;
        }
        for (Map.Entry entry : map.entrySet()) {
            it.put((String) entry.getKey(), (String) entry.getValue());
        }
        setExtra(it);
        return Unit.INSTANCE;
    }

    public final Unit removeExtraObj(String extraKey) {
        Intrinsics.checkNotNullParameter(extraKey, "extraKey");
        JSONObject it = getExtraObj();
        if (it == null) {
            return null;
        }
        it.remove(extraKey);
        setExt("extra", it.toString());
        return Unit.INSTANCE;
    }

    public String toString() {
        return String.valueOf(this.extLogString);
    }
}
