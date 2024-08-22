package fe.i.qw.ad;

import com.dxmpay.apollon.eventbus.EventBus;

public final class fe {

    /* renamed from: ad  reason: collision with root package name */
    public yj f4471ad;
    public EventBus.Event qw;

    public fe(EventBus.Event event, yj yjVar) {
        this.qw = event;
        this.f4471ad = yjVar;
    }

    public static fe qw(yj yjVar, EventBus.Event event) {
        return new fe(event, yjVar);
    }
}
