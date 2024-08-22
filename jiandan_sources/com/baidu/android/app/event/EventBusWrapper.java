package com.baidu.android.app.event;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import p041if.i.qw;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public final class EventBusWrapper {
    public static final boolean DEBUG = false;
    public static final int LAZY_POST_MSG = 2;
    public static final Handler LAZY_SUBSCRIBE_HANDLER;
    public static final int LAZY_SUBSCRIBE_MSG = 1;
    public static final String TAG = "EventBusWrapper";
    public static final int THREAD_MODE_BACKGROUND = 1;
    public static final int THREAD_MODE_CURRENT = 2;
    public static final int THREAD_MODE_MAIN = 0;
    public static ConcurrentHashMap<Object, ConcurrentLinkedQueue<LazySubscriber>> sLazySubscribers = new ConcurrentHashMap<>();

    public static class LazySubscriber {
        public final Action1 action;
        public final int mode;
        public final Class type;

        public LazySubscriber(Class cls, Action1 action1, int i2) {
            this.type = cls;
            this.action = action1;
            this.mode = i2;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            return this.type.equals(((LazySubscriber) obj).type);
        }
    }

    static {
        HandlerThread handlerThread = new HandlerThread(RxBus.TAG);
        handlerThread.start();
        LAZY_SUBSCRIBE_HANDLER = new Handler(handlerThread.getLooper()) {
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    EventBusWrapper.registerLazySubscribers();
                } else if (i2 == 2) {
                    EventBusWrapper.post(message.obj);
                }
            }
        };
    }

    public static void lazyPost(Object obj) {
        Handler handler = LAZY_SUBSCRIBE_HANDLER;
        handler.sendMessage(handler.obtainMessage(2, obj));
    }

    public static <T> void lazyRegister(Object obj, Class<T> cls, Action1<T> action1) {
        lazyRegister(obj, cls, action1, 2);
    }

    public static <T> void lazyRegisterOnBackgroundThread(Object obj, Class<T> cls, Action1<T> action1) {
        lazyRegister(obj, cls, action1, 1);
    }

    public static <T> void lazyRegisterOnMainThread(Object obj, Class<T> cls, Action1<T> action1) {
        lazyRegister(obj, cls, action1, 0);
    }

    public static void post(Object obj) {
        if (sLazySubscribers.size() > 0) {
            LAZY_SUBSCRIBE_HANDLER.removeMessages(1);
            registerLazySubscribers();
        }
        RxBus.get().post(obj);
    }

    public static <T> Observable<T> register(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return Observable.uk();
        }
        return RxBus.get().register(obj, cls);
    }

    public static void registerLazySubscribers() {
        if (sLazySubscribers.size() > 0) {
            for (Map.Entry next : sLazySubscribers.entrySet()) {
                try {
                    ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) next.getValue();
                    while (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                        LazySubscriber lazySubscriber = (LazySubscriber) concurrentLinkedQueue.peek();
                        if (lazySubscriber != null) {
                            register(next.getKey(), lazySubscriber.type, lazySubscriber.action, lazySubscriber.mode);
                            concurrentLinkedQueue.remove(lazySubscriber);
                        }
                    }
                    sLazySubscribers.remove(next.getKey(), next.getValue());
                } catch (Exception unused) {
                }
            }
        }
    }

    public static <T> Observable<T> registerOnBackgroundThread(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return Observable.uk();
        }
        Observable<T> register = register(obj, cls);
        if (register != null) {
            return register.i(qw.qw());
        }
        return null;
    }

    public static <T> Observable<T> registerOnMainThread(Object obj, Class<T> cls) {
        if (RxBus.get().isRegistered(obj, cls)) {
            return Observable.uk();
        }
        Observable<T> register = register(obj, cls);
        if (register != null) {
            return register.i(AndroidSchedulers.mainThread());
        }
        return null;
    }

    public static synchronized void unregister(Object obj) {
        ConcurrentLinkedQueue remove;
        synchronized (EventBusWrapper.class) {
            if (obj != null) {
                if (sLazySubscribers.size() > 0 && (remove = sLazySubscribers.remove(obj)) != null) {
                    remove.clear();
                }
                RxBus.get().unregister(obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        r0 = new java.util.concurrent.ConcurrentLinkedQueue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> void lazyRegister(java.lang.Object r2, java.lang.Class<T> r3, rx.functions.Action1<T> r4, int r5) {
        /*
            if (r2 != 0) goto L_0x0003
            return
        L_0x0003:
            if (r3 != 0) goto L_0x0006
            return
        L_0x0006:
            if (r4 != 0) goto L_0x0009
            return
        L_0x0009:
            java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.util.concurrent.ConcurrentLinkedQueue<com.baidu.android.app.event.EventBusWrapper$LazySubscriber>> r0 = sLazySubscribers
            java.lang.Object r0 = r0.get(r2)
            java.util.concurrent.ConcurrentLinkedQueue r0 = (java.util.concurrent.ConcurrentLinkedQueue) r0
            if (r0 != 0) goto L_0x0023
            java.util.concurrent.ConcurrentLinkedQueue r0 = new java.util.concurrent.ConcurrentLinkedQueue
            r0.<init>()
            java.util.concurrent.ConcurrentHashMap<java.lang.Object, java.util.concurrent.ConcurrentLinkedQueue<com.baidu.android.app.event.EventBusWrapper$LazySubscriber>> r1 = sLazySubscribers
            java.lang.Object r2 = r1.putIfAbsent(r2, r0)
            java.util.concurrent.ConcurrentLinkedQueue r2 = (java.util.concurrent.ConcurrentLinkedQueue) r2
            if (r2 == 0) goto L_0x0023
            r0 = r2
        L_0x0023:
            com.baidu.android.app.event.EventBusWrapper$LazySubscriber r2 = new com.baidu.android.app.event.EventBusWrapper$LazySubscriber
            r2.<init>(r3, r4, r5)
            boolean r3 = r0.contains(r2)
            if (r3 != 0) goto L_0x0031
            r0.add(r2)
        L_0x0031:
            android.os.Handler r2 = LAZY_SUBSCRIBE_HANDLER
            r3 = 1
            r2.sendEmptyMessage(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.app.event.EventBusWrapper.lazyRegister(java.lang.Object, java.lang.Class, rx.functions.Action1, int):void");
    }

    public static <T> void register(Object obj, Class<T> cls, Action1<T> action1) {
        register(obj, cls, action1, 2);
    }

    public static <T> void register(Object obj, Class<T> cls, Action1<T> action1, int i2) {
        if (obj != null && cls != null && action1 != null && !RxBus.get().isRegistered(obj, cls)) {
            AnonymousClass2 r0 = new Action1<Throwable>() {
                public void call(Throwable th2) {
                }
            };
            Observable<T> register = RxBus.get().register(obj, cls);
            if (i2 == 0) {
                register.i(AndroidSchedulers.mainThread()).fe(action1).de(r0).xxx().ddd();
            } else if (i2 == 1) {
                register.i(qw.qw()).fe(action1).de(r0).xxx().ddd();
            } else if (i2 == 2) {
                register.fe(action1).de(r0).xxx().ddd();
            } else {
                register.fe(action1).de(r0).xxx().ddd();
            }
        }
    }

    public static <T> void registerOnBackgroundThread(Object obj, Class<T> cls, Action1<T> action1) {
        register(obj, cls, action1, 1);
    }

    public static <T> void registerOnMainThread(Object obj, Class<T> cls, Action1<T> action1) {
        register(obj, cls, action1, 0);
    }

    public static <T> void register(Object obj, Class<T> cls, p041if.qw qwVar, Action1 action1) {
        if (obj != null && cls != null && action1 != null && qwVar != null && !RxBus.get().isRegistered(obj, cls)) {
            RxBus.get().register(obj, cls).i(qwVar).fe(action1).de(new Action1<Throwable>() {
                public void call(Throwable th2) {
                }
            }).xxx().ddd();
        }
    }
}
