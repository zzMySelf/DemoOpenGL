package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import java.lang.reflect.Method;

public class SubscriberExceptionContext {
    public final Object event;
    public final EventBus eventBus;
    public final Object subscriber;
    public final Method subscriberMethod;

    public SubscriberExceptionContext(EventBus eventBus2, Object obj, Object obj2, Method method) {
        this.eventBus = (EventBus) Preconditions.checkNotNull(eventBus2);
        this.event = Preconditions.checkNotNull(obj);
        this.subscriber = Preconditions.checkNotNull(obj2);
        this.subscriberMethod = (Method) Preconditions.checkNotNull(method);
    }

    public Object getEvent() {
        return this.event;
    }

    public EventBus getEventBus() {
        return this.eventBus;
    }

    public Object getSubscriber() {
        return this.subscriber;
    }

    public Method getSubscriberMethod() {
        return this.subscriberMethod;
    }
}
