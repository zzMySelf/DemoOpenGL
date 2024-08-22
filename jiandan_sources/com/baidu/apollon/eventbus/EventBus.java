package com.baidu.apollon.eventbus;

public final class EventBus {
    public static final String DEFAULT_METHOD_NAME = "onModuleEvent";
    public static EventBus mEventBusInstance;
    public static b mEventController;

    public class Event {
        public String mEventKey;
        public Object mEventObj;

        public Event(String str, Object obj) {
            this.mEventKey = str;
            this.mEventObj = obj;
        }
    }

    public enum ThreadMode {
        PostThread,
        MainThread,
        Async
    }

    public EventBus() {
        mEventController = new b();
    }

    public static EventBus getInstance() {
        if (mEventBusInstance == null) {
            synchronized (EventBus.class) {
                if (mEventBusInstance == null) {
                    mEventBusInstance = new EventBus();
                }
            }
        }
        return mEventBusInstance;
    }

    public void cancelEventDelivery(Event event) {
        mEventController.c(event);
    }

    public void post(Event event) {
        mEventController.a(event);
    }

    public void postStickyEvent(Event event) {
        mEventController.b(event);
    }

    public void register(Object obj, String str, int i2, ThreadMode threadMode) {
        mEventController.a(obj, str, i2, false, threadMode);
    }

    public void registerSticky(Object obj, String str, int i2, ThreadMode threadMode) {
        mEventController.a(obj, str, i2, true, threadMode);
    }

    public void removeAllStickyEvents() {
        mEventController.a();
    }

    public void removeStickyEvent(String str) {
        mEventController.a(str);
    }

    public synchronized void unregister(Object obj) {
        mEventController.a(obj);
    }

    public void register(Object obj, String[] strArr, int i2, ThreadMode threadMode) {
        mEventController.a(obj, strArr, i2, false, threadMode);
    }

    public synchronized void unregister(Object obj, String str) {
        mEventController.a(obj, str);
    }

    public synchronized void unregister(Object obj, String[] strArr) {
        if (strArr != null) {
            for (String a : strArr) {
                mEventController.a(obj, a);
            }
        }
    }
}
