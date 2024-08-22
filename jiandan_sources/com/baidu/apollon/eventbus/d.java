package com.baidu.apollon.eventbus;

import com.baidu.apollon.eventbus.EventBus;

public final class d {
    public EventBus.Event a;
    public g b;

    public d(EventBus.Event event, g gVar) {
        this.a = event;
        this.b = gVar;
    }

    public static d a(g gVar, EventBus.Event event) {
        return new d(event, gVar);
    }
}
