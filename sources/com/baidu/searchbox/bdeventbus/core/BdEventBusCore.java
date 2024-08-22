package com.baidu.searchbox.bdeventbus.core;

import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.bdeventbus.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010!\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001H\u0000¢\u0006\u0002\b&J\u0010\u0010'\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0001H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020 H\u0002J7\u0010(\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00012\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u0010-\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010/H\u0000¢\u0006\u0002\b0J\u000e\u00101\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0001R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00190\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\b\u001a\u0004\b\u001c\u0010\u001dR \u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u00190\u0018X\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore;", "", "()V", "DEFAULT_EXECUTOR_SERVICE", "Ljava/util/concurrent/ExecutorService;", "getDEFAULT_EXECUTOR_SERVICE", "()Ljava/util/concurrent/ExecutorService;", "DEFAULT_EXECUTOR_SERVICE$delegate", "Lkotlin/Lazy;", "LAZY_SUBSCRIBE_MSG", "", "TAG", "", "asyncPoster", "Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "getAsyncPoster", "()Lcom/baidu/searchbox/bdeventbus/core/AsyncPoster;", "asyncPoster$delegate", "backgroundPoster", "Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "getBackgroundPoster", "()Lcom/baidu/searchbox/bdeventbus/core/BackgroundPoster;", "backgroundPoster$delegate", "eventBySubscriber", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mainHandlerPoster", "Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "getMainHandlerPoster", "()Lcom/baidu/searchbox/bdeventbus/core/MainHandlerPoster;", "mainHandlerPoster$delegate", "subscriptionsInfoByEventType", "Lcom/baidu/searchbox/bdeventbus/core/SubscriptionInfo;", "getExecutorService", "getExecutorService$lib_bd_event_bus_release", "post", "", "event", "post$lib_bd_event_bus_release", "postSingleEvent", "subscribe", "subscriptionInfo", "subscriber", "eventType", "Ljava/lang/Class;", "threadMode", "action", "Lcom/baidu/searchbox/bdeventbus/Action;", "subscribe$lib_bd_event_bus_release", "unregister", "PostingThreadState", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdEventBusCore.kt */
public final class BdEventBusCore {
    private final Lazy DEFAULT_EXECUTOR_SERVICE$delegate = LazyKt.lazy(BdEventBusCore$DEFAULT_EXECUTOR_SERVICE$2.INSTANCE);
    private final int LAZY_SUBSCRIBE_MSG = 1;
    private final String TAG = "BdEventBusCore";
    private final Lazy asyncPoster$delegate = LazyKt.lazy(new BdEventBusCore$asyncPoster$2(this));
    private final Lazy backgroundPoster$delegate = LazyKt.lazy(new BdEventBusCore$backgroundPoster$2(this));
    private ConcurrentHashMap<Object, CopyOnWriteArrayList<Object>> eventBySubscriber = new ConcurrentHashMap<>();
    private final Lazy mainHandlerPoster$delegate = LazyKt.lazy(BdEventBusCore$mainHandlerPoster$2.INSTANCE);
    private ConcurrentHashMap<Object, CopyOnWriteArrayList<SubscriptionInfo>> subscriptionsInfoByEventType = new ConcurrentHashMap<>();

    private final ExecutorService getDEFAULT_EXECUTOR_SERVICE() {
        Object value = this.DEFAULT_EXECUTOR_SERVICE$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-DEFAULT_EXECUTOR_SERVICE>(...)");
        return (ExecutorService) value;
    }

    private final MainHandlerPoster getMainHandlerPoster() {
        return (MainHandlerPoster) this.mainHandlerPoster$delegate.getValue();
    }

    private final BackgroundPoster getBackgroundPoster() {
        return (BackgroundPoster) this.backgroundPoster$delegate.getValue();
    }

    private final AsyncPoster getAsyncPoster() {
        return (AsyncPoster) this.asyncPoster$delegate.getValue();
    }

    public final ExecutorService getExecutorService$lib_bd_event_bus_release() {
        return getDEFAULT_EXECUTOR_SERVICE();
    }

    public final void subscribe$lib_bd_event_bus_release(Object subscriber, Class<?> eventType, int threadMode, Action<Object> action) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(action, "action");
        subscribe(new SubscriptionInfo(subscriber, eventType, threadMode, action));
    }

    private final void subscribe(SubscriptionInfo subscriptionInfo) {
        CopyOnWriteArrayList subscriptionInfoList = this.subscriptionsInfoByEventType.get(subscriptionInfo.getEventType());
        if (subscriptionInfoList == null) {
            CopyOnWriteArrayList subscriptionList = new CopyOnWriteArrayList();
            subscriptionList.add(subscriptionInfo);
            this.subscriptionsInfoByEventType.put(subscriptionInfo.getEventType(), subscriptionList);
        } else if (!subscriptionInfoList.contains(subscriptionInfo)) {
            subscriptionInfoList.add(subscriptionInfo);
        }
        CopyOnWriteArrayList eventList = this.eventBySubscriber.get(subscriptionInfo.getSubscriber());
        if (eventList == null) {
            CopyOnWriteArrayList eventList2 = new CopyOnWriteArrayList();
            eventList2.add(subscriptionInfo.getEventType());
            this.eventBySubscriber.put(subscriptionInfo.getSubscriber(), eventList2);
        } else if (!eventList.contains(subscriptionInfo.getEventType())) {
            eventList.add(subscriptionInfo.getEventType());
        }
    }

    public final void post$lib_bd_event_bus_release(Object event) {
        Intrinsics.checkNotNullParameter(event, "event");
        postSingleEvent(event);
    }

    private final void postSingleEvent(Object event) {
        CopyOnWriteArrayList subscriptionsList = this.subscriptionsInfoByEventType.get(event.getClass());
        if (subscriptionsList != null && !subscriptionsList.isEmpty()) {
            Iterator it = subscriptionsList.iterator();
            while (it.hasNext()) {
                SubscriptionInfo subscription = (SubscriptionInfo) it.next();
                switch (subscription.getThreadMode()) {
                    case 0:
                        subscription.getAction().call(event);
                        break;
                    case 1:
                        if (!UiThreadUtils.isOnUiThread()) {
                            MainHandlerPoster mainHandlerPoster = getMainHandlerPoster();
                            Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                            mainHandlerPoster.enqueue(event, subscription);
                            break;
                        } else {
                            subscription.getAction().call(event);
                            break;
                        }
                    case 2:
                        if (!UiThreadUtils.isOnUiThread()) {
                            subscription.getAction().call(event);
                            break;
                        } else {
                            BackgroundPoster backgroundPoster = getBackgroundPoster();
                            Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                            backgroundPoster.enqueue(event, subscription);
                            break;
                        }
                    case 3:
                        AsyncPoster asyncPoster = getAsyncPoster();
                        Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                        asyncPoster.enqueue(event, subscription);
                        break;
                    case 4:
                        MainHandlerPoster mainHandlerPoster2 = getMainHandlerPoster();
                        Intrinsics.checkNotNullExpressionValue(subscription, "subscription");
                        mainHandlerPoster2.enqueue(event, subscription);
                        break;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdeventbus/core/BdEventBusCore$PostingThreadState;", "", "()V", "eventQueue", "", "getEventQueue", "()Ljava/util/List;", "lib-bd-event-bus_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BdEventBusCore.kt */
    public static final class PostingThreadState {
        private final List<Object> eventQueue = new ArrayList();

        public final List<Object> getEventQueue() {
            return this.eventQueue;
        }
    }

    public final synchronized void unregister(Object subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        CopyOnWriteArrayList eventList = this.eventBySubscriber.get(subscriber);
        if (eventList != null) {
            Iterator it = eventList.iterator();
            while (it.hasNext()) {
                CopyOnWriteArrayList<SubscriptionInfo> subscriptionInfoList = this.subscriptionsInfoByEventType.get(it.next());
                if (subscriptionInfoList != null) {
                    for (SubscriptionInfo it2 : subscriptionInfoList) {
                        if (Intrinsics.areEqual(it2.getSubscriber(), subscriber)) {
                            subscriptionInfoList.remove(it2);
                        }
                    }
                }
            }
            this.eventBySubscriber.remove(subscriber);
        }
    }
}
