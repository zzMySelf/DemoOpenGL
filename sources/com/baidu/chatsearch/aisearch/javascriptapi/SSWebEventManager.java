package com.baidu.chatsearch.aisearch.javascriptapi;

import com.baidu.chatsearch.logger.AppLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/chatsearch/aisearch/javascriptapi/SSWebEventManager;", "", "()V", "TAG", "", "eventSet", "", "Lcom/baidu/chatsearch/aisearch/javascriptapi/SSWebEventType;", "clearEventWatcher", "", "generaterDispatchEventDataChannel", "webEvent", "Lcom/baidu/chatsearch/aisearch/javascriptapi/SSWebEvent;", "generaterDispatchEventJSCode", "isEventHasWatcher", "", "eventType", "removeEventhasWatcher", "setEventHasWatcher", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SSWebEventManager.kt */
public final class SSWebEventManager {
    private final String TAG = "SSWebEventManager";
    private final Set<SSWebEventType> eventSet = new LinkedHashSet();

    public final void setEventHasWatcher(SSWebEventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventSet.add(eventType);
    }

    public final void removeEventhasWatcher(SSWebEventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventSet.remove(eventType);
    }

    public final void clearEventWatcher() {
        this.eventSet.clear();
    }

    public final boolean isEventHasWatcher(SSWebEventType eventType) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return this.eventSet.contains(eventType);
    }

    public final String generaterDispatchEventJSCode(SSWebEvent webEvent) {
        Intrinsics.checkNotNullParameter(webEvent, "webEvent");
        String code = webEvent.toJsCode() + " window.dispatchEvent(e);";
        AppLogger.d(this.TAG, " generaterDispatchEventJSCode " + code);
        return code;
    }

    public final String generaterDispatchEventDataChannel(SSWebEvent webEvent) {
        Intrinsics.checkNotNullParameter(webEvent, "webEvent");
        String code = String.valueOf(webEvent.toDataChannel());
        AppLogger.d(this.TAG, " generaterDispatchEventDataChannel " + code);
        return code;
    }
}
