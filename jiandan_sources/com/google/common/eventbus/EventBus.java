package com.google.common.eventbus;

import com.baidu.android.common.others.IStringUtil;
import com.google.common.annotations.Beta;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@Beta
public class EventBus {
    public static final Logger logger = Logger.getLogger(EventBus.class.getName());
    public final Dispatcher dispatcher;
    public final SubscriberExceptionHandler exceptionHandler;
    public final Executor executor;
    public final String identifier;
    public final SubscriberRegistry subscribers;

    public static final class LoggingHandler implements SubscriberExceptionHandler {
        public static final LoggingHandler INSTANCE = new LoggingHandler();

        public static Logger logger(SubscriberExceptionContext subscriberExceptionContext) {
            return Logger.getLogger(EventBus.class.getName() + IStringUtil.CURRENT_PATH + subscriberExceptionContext.getEventBus().identifier());
        }

        public static String message(SubscriberExceptionContext subscriberExceptionContext) {
            Method subscriberMethod = subscriberExceptionContext.getSubscriberMethod();
            return "Exception thrown by subscriber method " + subscriberMethod.getName() + '(' + subscriberMethod.getParameterTypes()[0].getName() + ')' + " on subscriber " + subscriberExceptionContext.getSubscriber() + " when dispatching event: " + subscriberExceptionContext.getEvent();
        }

        public void handleException(Throwable th2, SubscriberExceptionContext subscriberExceptionContext) {
            Logger logger = logger(subscriberExceptionContext);
            if (logger.isLoggable(Level.SEVERE)) {
                logger.log(Level.SEVERE, message(subscriberExceptionContext), th2);
            }
        }
    }

    public EventBus() {
        this("default");
    }

    public final Executor executor() {
        return this.executor;
    }

    public void handleSubscriberException(Throwable th2, SubscriberExceptionContext subscriberExceptionContext) {
        Preconditions.checkNotNull(th2);
        Preconditions.checkNotNull(subscriberExceptionContext);
        try {
            this.exceptionHandler.handleException(th2, subscriberExceptionContext);
        } catch (Throwable th3) {
            logger.log(Level.SEVERE, String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[]{th3, th2}), th3);
        }
    }

    public final String identifier() {
        return this.identifier;
    }

    public void post(Object obj) {
        Iterator<Subscriber> subscribers2 = this.subscribers.getSubscribers(obj);
        if (subscribers2.hasNext()) {
            this.dispatcher.dispatch(obj, subscribers2);
        } else if (!(obj instanceof DeadEvent)) {
            post(new DeadEvent(this, obj));
        }
    }

    public void register(Object obj) {
        this.subscribers.register(obj);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).addValue((Object) this.identifier).toString();
    }

    public void unregister(Object obj) {
        this.subscribers.unregister(obj);
    }

    public EventBus(String str) {
        this(str, MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), LoggingHandler.INSTANCE);
    }

    public EventBus(SubscriberExceptionHandler subscriberExceptionHandler) {
        this("default", MoreExecutors.directExecutor(), Dispatcher.perThreadDispatchQueue(), subscriberExceptionHandler);
    }

    public EventBus(String str, Executor executor2, Dispatcher dispatcher2, SubscriberExceptionHandler subscriberExceptionHandler) {
        this.subscribers = new SubscriberRegistry(this);
        this.identifier = (String) Preconditions.checkNotNull(str);
        this.executor = (Executor) Preconditions.checkNotNull(executor2);
        this.dispatcher = (Dispatcher) Preconditions.checkNotNull(dispatcher2);
        this.exceptionHandler = (SubscriberExceptionHandler) Preconditions.checkNotNull(subscriberExceptionHandler);
    }
}
