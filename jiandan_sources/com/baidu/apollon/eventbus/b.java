package com.baidu.apollon.eventbus;

import android.os.Looper;
import android.text.TextUtils;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class b {
    public static final boolean a = ApollonConstants.DEBUG;
    public static final String b = b.class.getSimpleName();
    public final Map<String, EventBus.Event> c = new ConcurrentHashMap();
    public final c d = new c(this, Looper.getMainLooper(), 10);
    public final a e = new a(this);
    public final Map<String, CopyOnWriteArrayList<g>> f = new HashMap();
    public final Map<Object, List<String>> g = new HashMap();
    public final f h = new f();

    /* renamed from: i  reason: collision with root package name */
    public final ThreadLocal<a> f697i = new ThreadLocal<a>() {
        /* renamed from: a */
        public a initialValue() {
            return new a();
        }
    };

    /* renamed from: com.baidu.apollon.eventbus.b$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidu.apollon.eventbus.EventBus$ThreadMode[] r0 = com.baidu.apollon.eventbus.EventBus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.apollon.eventbus.EventBus$ThreadMode r1 = com.baidu.apollon.eventbus.EventBus.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.apollon.eventbus.EventBus$ThreadMode r1 = com.baidu.apollon.eventbus.EventBus.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.apollon.eventbus.EventBus$ThreadMode r1 = com.baidu.apollon.eventbus.EventBus.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.eventbus.b.AnonymousClass2.<clinit>():void");
        }
    }

    public static final class a {
        public boolean a;
        public boolean b;
        public g c;
        public EventBus.Event d;
        public boolean e;
    }

    private void b(Object obj, String str) {
        List list = this.f.get(str);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                g gVar = (g) list.get(i2);
                if (gVar.a == obj) {
                    gVar.f = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public synchronized void a(Object obj, String[] strArr, int i2, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.h.a(obj.getClass()), z, i2, strArr, threadMode);
    }

    public void c(EventBus.Event event) {
        a aVar = this.f697i.get();
        if (!aVar.a) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        } else if (event == null) {
            throw new EventBusException("Event may not be null");
        } else if (aVar.d == event) {
            aVar.e = true;
        } else {
            throw new EventBusException("Only the currently handled event may be aborted");
        }
    }

    public synchronized void a(Object obj, String str, int i2, boolean z, EventBus.ThreadMode threadMode) {
        a(obj, this.h.a(obj.getClass()), z, i2, str, threadMode);
    }

    private void a(Object obj, Method method, boolean z, int i2, String[] strArr, EventBus.ThreadMode threadMode) {
        for (String a2 : strArr) {
            a(obj, method, z, i2, a2, threadMode);
        }
    }

    public void b(EventBus.Event event) {
        synchronized (this.c) {
            this.c.put(event.mEventKey, event);
        }
        a(event);
    }

    private void a(Object obj, Method method, boolean z, int i2, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f.put(str, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((g) it.next()).a.equals(obj)) {
                    if (a) {
                        "Subscriber " + obj.getClass() + " already registered to event " + str;
                        return;
                    }
                    return;
                }
            }
        }
        g gVar = new g(obj, method, str, i2, threadMode);
        int size = copyOnWriteArrayList.size();
        boolean z2 = false;
        if (size > 0) {
            int i3 = 0;
            while (true) {
                if (i3 > size) {
                    break;
                } else if (i3 == size || gVar.c > ((g) copyOnWriteArrayList.get(i3)).c) {
                    copyOnWriteArrayList.add(i3, gVar);
                } else {
                    i3++;
                }
            }
            copyOnWriteArrayList.add(i3, gVar);
        } else {
            copyOnWriteArrayList.add(gVar);
        }
        List list = this.g.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.g.put(obj, list);
        }
        list.add(str);
        if (z) {
            synchronized (this.c) {
                event = this.c.get(str);
            }
            if (event != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z2 = true;
                }
                a(gVar, event, z2);
            }
        }
    }

    public synchronized void a(Object obj) {
        if (obj != null) {
            List<String> list = this.g.get(obj);
            if (list != null) {
                for (String b2 : list) {
                    b(obj, b2);
                }
                this.g.remove(obj);
            } else {
                String str = b;
                LogUtil.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public synchronized void a(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            b(obj, str);
            List list = this.g.get(obj);
            if (list != null) {
                list.remove(str);
            }
            if (list != null && list.size() == 0) {
                this.g.remove(obj);
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public void a(EventBus.Event event) {
        a aVar = this.f697i.get();
        if (!aVar.a) {
            aVar.b = Looper.getMainLooper() == Looper.myLooper();
            aVar.a = true;
            if (aVar.e) {
                aVar.a = false;
                boolean z = a;
                return;
            }
            try {
                a(event, aVar);
            } finally {
                aVar.a = false;
                aVar.b = false;
            }
        }
    }

    public void a(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
    }

    public void a() {
        synchronized (this.c) {
            this.c.clear();
        }
    }

    private void a(EventBus.Event event, a aVar) throws Error {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f.get(event.mEventKey);
        }
        boolean z = false;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                g gVar = (g) it.next();
                aVar.d = event;
                aVar.c = gVar;
                try {
                    a(gVar, event, aVar.b);
                    if (aVar.e) {
                        break;
                    }
                } finally {
                    aVar.d = null;
                    aVar.c = null;
                    aVar.e = z;
                }
            }
            z = true;
        }
        if (!z && a) {
            "No subscribers registered for event " + event.mEventKey;
        }
    }

    private void a(g gVar, EventBus.Event event, boolean z) {
        int i2 = AnonymousClass2.a[gVar.e.ordinal()];
        if (i2 == 1) {
            a(gVar, event);
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.e.a(gVar, event);
                return;
            }
            throw new IllegalStateException("Unknown thread mode: " + gVar.e);
        } else if (z) {
            a(gVar, event);
        } else {
            this.d.a(gVar, event);
        }
    }

    public void a(d dVar) {
        EventBus.Event event = dVar.a;
        g gVar = dVar.b;
        if (gVar.f) {
            a(gVar, event);
        }
    }

    private void a(g gVar, EventBus.Event event) throws Error {
        try {
            gVar.b.invoke(gVar.a, new Object[]{event});
        } catch (InvocationTargetException e2) {
            e2.getCause();
            "Could not dispatch event: " + event.getClass() + " to subscribing class " + gVar.a.getClass();
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }
}
