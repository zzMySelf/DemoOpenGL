package com.google.common.eventbus;

public interface SubscriberExceptionHandler {
    void handleException(Throwable th2, SubscriberExceptionContext subscriberExceptionContext);
}
