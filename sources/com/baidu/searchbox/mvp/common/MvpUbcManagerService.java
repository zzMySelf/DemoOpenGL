package com.baidu.searchbox.mvp.common;

import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u0016JL\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/mvp/common/MvpUbcManagerService;", "Lcom/baidu/searchbox/mvp/common/IMvpUbcManagerService;", "()V", "cardType", "", "currentCardId", "traceId", "appendCardId", "", "ext", "Lorg/json/JSONObject;", "appendTraceId", "getCardId", "getCardType", "getTraceId", "ubcEvent7502", "from", "page", "type", "source", "value", "onlyAppendTraceId", "", "updateCardId", "id", "updateCardType", "updateTraceId", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MvpUbcManagerService.kt */
public final class MvpUbcManagerService implements IMvpUbcManagerService {
    private String cardType;
    private String currentCardId;
    private String traceId;

    public void updateTraceId(String id) {
        this.traceId = id;
    }

    public void updateCardId(String id) {
        this.currentCardId = id;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public String getCardId() {
        return this.currentCardId;
    }

    public void updateCardType(String type) {
        this.cardType = type;
    }

    public String getCardType() {
        return this.cardType;
    }

    private final void appendTraceId(JSONObject ext) {
        if (ext != null) {
            ext.putOpt("trace_id", this.traceId);
        }
    }

    private final void appendCardId(JSONObject ext) {
        if (ext != null) {
            ext.putOpt("card_id", this.currentCardId);
        }
    }

    public void ubcEvent7502(String from, String page, String type, String source, String value, JSONObject ext, boolean onlyAppendTraceId) {
        if (onlyAppendTraceId) {
            appendTraceId(ext);
        } else {
            appendTraceId(ext);
            appendCardId(ext);
        }
        UgcUBCUtils.ubcEventStatistics(MvpUbcUtil.UBC_UGC_AI_PUBLISHER_ID, from, page, type, source, value, ext);
    }
}
