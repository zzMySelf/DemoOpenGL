package com.baidu.searchbox.net.update.v2;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@StableApi
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/net/update/v2/UpdateEvent;", "", "event", "", "(I)V", "getEvent", "()I", "mEvent", "getMEvent", "setMEvent", "Companion", "lib-update-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateEvent.kt */
public final class UpdateEvent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int UPDATE_EVENT_DISPATCH_FINISH = 1;
    public static final int UPDATE_EVENT_ERROR = 2;
    private final int event;
    private int mEvent;

    public UpdateEvent(int event2) {
        this.event = event2;
        this.mEvent = event2;
    }

    public final int getEvent() {
        return this.event;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/net/update/v2/UpdateEvent$Companion;", "", "()V", "UPDATE_EVENT_DISPATCH_FINISH", "", "UPDATE_EVENT_ERROR", "lib-update-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UpdateEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getMEvent() {
        return this.mEvent;
    }

    public final void setMEvent(int i2) {
        this.mEvent = i2;
    }
}
