package com.baidu.searchbox.feed.template.tplinterface;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/feed/template/tplinterface/ITalosLiteContainerEventEmitter;", "", "dispatchContainerEvent", "", "eventName", "", "params", "Lorg/json/JSONObject;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ITalosLiteContainerEventEmitter.kt */
public interface ITalosLiteContainerEventEmitter {
    void dispatchContainerEvent(String str, JSONObject jSONObject);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ITalosLiteContainerEventEmitter.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void dispatchContainerEvent$default(ITalosLiteContainerEventEmitter iTalosLiteContainerEventEmitter, String str, JSONObject jSONObject, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    jSONObject = null;
                }
                iTalosLiteContainerEventEmitter.dispatchContainerEvent(str, jSONObject);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchContainerEvent");
        }
    }
}
