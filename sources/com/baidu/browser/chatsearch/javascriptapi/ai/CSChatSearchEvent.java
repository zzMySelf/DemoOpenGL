package com.baidu.browser.chatsearch.javascriptapi.ai;

import com.baidu.browser.chatsearch.javascriptapi.CSChatSearchEventKey;
import com.baidu.browser.chatsearch.javascriptapi.CSWebEvent;
import com.baidu.browser.chatsearch.javascriptapi.CSWebEventType;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\nH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/baidu/browser/chatsearch/javascriptapi/ai/CSChatSearchEvent;", "Lcom/baidu/browser/chatsearch/javascriptapi/CSWebEvent;", "()V", "key", "Lcom/baidu/browser/chatsearch/javascriptapi/CSChatSearchEventKey;", "getKey", "()Lcom/baidu/browser/chatsearch/javascriptapi/CSChatSearchEventKey;", "setKey", "(Lcom/baidu/browser/chatsearch/javascriptapi/CSChatSearchEventKey;)V", "params", "Lorg/json/JSONObject;", "getParams", "()Lorg/json/JSONObject;", "setParams", "(Lorg/json/JSONObject;)V", "getDataJson", "getNameStr", "", "toDataChannel", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CSChatSearchEvent.kt */
public final class CSChatSearchEvent extends CSWebEvent {
    private CSChatSearchEventKey key;
    private JSONObject params;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CSChatSearchEvent.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CSChatSearchEventKey.values().length];
            iArr[CSChatSearchEventKey.CSChatSearchEventKeyLoginStatus.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CSChatSearchEvent() {
        super(CSWebEventType.CSWebEventTypeChatSearch);
    }

    public final CSChatSearchEventKey getKey() {
        return this.key;
    }

    public final void setKey(CSChatSearchEventKey cSChatSearchEventKey) {
        this.key = cSChatSearchEventKey;
    }

    public final JSONObject getParams() {
        return this.params;
    }

    public final void setParams(JSONObject jSONObject) {
        this.params = jSONObject;
    }

    private final String getNameStr() {
        CSChatSearchEventKey cSChatSearchEventKey = this.key;
        if ((cSChatSearchEventKey == null ? -1 : WhenMappings.$EnumSwitchMapping$0[cSChatSearchEventKey.ordinal()]) == 1) {
            return "login-status";
        }
        return "";
    }

    private final JSONObject getDataJson() {
        JSONObject dataObj = new JSONObject();
        try {
            dataObj.put("name", getNameStr());
            JSONObject jSONObject = this.params;
            if (jSONObject != null) {
                dataObj.put("params", jSONObject);
            }
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        return dataObj;
    }

    public JSONObject toDataChannel() {
        JSONObject rootJson = super.toDataChannel();
        try {
            rootJson.put("data", getDataJson());
        } catch (JSONException e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        return rootJson;
    }
}
