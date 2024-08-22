package com.dxmpay.apollon.eventbus;

import fe.i.qw.ad.ad;

public final class EventBus {
    public static final String DEFAULT_METHOD_NAME = "onModuleEvent";
    public static EventBus mEventBusInstance;
    public static ad mEventController;

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
        mEventController = new ad();
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
        mEventController.ggg(event);
    }

    public void post(Event event) {
        mEventController.ad(event);
    }

    public void postStickyEvent(Event event) {
        mEventController.when(event);
    }

    public void register(Object obj, String str, int i2, ThreadMode threadMode) {
        mEventController.i(obj, str, i2, false, threadMode);
    }

    public void registerSticky(Object obj, String str, int i2, ThreadMode threadMode) {
        mEventController.i(obj, str, i2, true, threadMode);
    }

    public void removeAllStickyEvents() {
        mEventController.qw();
    }

    public void removeStickyEvent(String str) {
        mEventController.m282switch(str);
    }

    public synchronized void unregister(Object obj) {
        mEventController.yj(obj);
    }

    public void register(Object obj, String[] strArr, int i2, ThreadMode threadMode) {
        mEventController.m281if(obj, strArr, i2, false, threadMode);
    }

    public synchronized void unregister(Object obj, String str) {
        mEventController.uk(obj, str);
    }

    public synchronized void unregister(Object obj, String[] strArr) {
        if (strArr != null) {
            for (String uk2 : strArr) {
                mEventController.uk(obj, uk2);
            }
        }
    }
}
