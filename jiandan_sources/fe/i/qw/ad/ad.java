package fe.i.qw.ad;

import android.os.Looper;
import android.text.TextUtils;
import com.dxmpay.apollon.ApollonConstants;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.eventbus.EventBusException;
import com.dxmpay.apollon.utils.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ad {

    /* renamed from: i  reason: collision with root package name */
    public static final String f4456i = ad.class.getSimpleName();

    /* renamed from: uk  reason: collision with root package name */
    public static final boolean f4457uk = ApollonConstants.DEBUG;

    /* renamed from: ad  reason: collision with root package name */
    public final de f4458ad = new de(this, Looper.getMainLooper(), 10);

    /* renamed from: de  reason: collision with root package name */
    public final qw f4459de = new qw(this);

    /* renamed from: fe  reason: collision with root package name */
    public final Map<String, CopyOnWriteArrayList<yj>> f4460fe = new HashMap();
    public final Map<String, EventBus.Event> qw = new ConcurrentHashMap();

    /* renamed from: rg  reason: collision with root package name */
    public final Map<Object, List<String>> f4461rg = new HashMap();

    /* renamed from: th  reason: collision with root package name */
    public final th f4462th = new th();

    /* renamed from: yj  reason: collision with root package name */
    public final ThreadLocal<de> f4463yj = new qw(this);

    /* renamed from: fe.i.qw.ad.ad$ad  reason: collision with other inner class name */
    public static /* synthetic */ class C0193ad {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.dxmpay.apollon.eventbus.EventBus$ThreadMode[] r0 = com.dxmpay.apollon.eventbus.EventBus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.dxmpay.apollon.eventbus.EventBus$ThreadMode r1 = com.dxmpay.apollon.eventbus.EventBus.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.dxmpay.apollon.eventbus.EventBus$ThreadMode r1 = com.dxmpay.apollon.eventbus.EventBus.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.dxmpay.apollon.eventbus.EventBus$ThreadMode r1 = com.dxmpay.apollon.eventbus.EventBus.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: fe.i.qw.ad.ad.C0193ad.<clinit>():void");
        }
    }

    public static final class de {

        /* renamed from: ad  reason: collision with root package name */
        public boolean f4464ad;

        /* renamed from: de  reason: collision with root package name */
        public yj f4465de;

        /* renamed from: fe  reason: collision with root package name */
        public EventBus.Event f4466fe;
        public boolean qw;

        /* renamed from: rg  reason: collision with root package name */
        public boolean f4467rg;
    }

    public class qw extends ThreadLocal<de> {
        public qw(ad adVar) {
        }

        /* renamed from: qw */
        public de initialValue() {
            return new de();
        }
    }

    public void ad(EventBus.Event event) {
        de deVar = this.f4463yj.get();
        if (!deVar.qw) {
            deVar.f4464ad = Looper.getMainLooper() == Looper.myLooper();
            deVar.qw = true;
            if (deVar.f4467rg) {
                deVar.qw = false;
                if (f4457uk) {
                    LogUtil.d(f4456i, "Event has already been cancelled");
                    return;
                }
                return;
            }
            try {
                de(event, deVar);
            } finally {
                deVar.qw = false;
                deVar.f4464ad = false;
            }
        }
    }

    public final void de(EventBus.Event event, de deVar) throws Error {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f4460fe.get(event.mEventKey);
        }
        boolean z = false;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                yj yjVar = (yj) it.next();
                deVar.f4466fe = event;
                deVar.f4465de = yjVar;
                try {
                    th(yjVar, event, deVar.f4464ad);
                    if (deVar.f4467rg) {
                        break;
                    }
                } finally {
                    deVar.f4466fe = null;
                    deVar.f4465de = null;
                    deVar.f4467rg = z;
                }
            }
            z = true;
        }
        if (!z && f4457uk) {
            "No subscribers registered for event " + event.mEventKey;
        }
    }

    public void fe(fe feVar) {
        EventBus.Event event = feVar.qw;
        yj yjVar = feVar.f4471ad;
        if (yjVar.f4477rg) {
            rg(yjVar, event);
        }
    }

    public void ggg(EventBus.Event event) {
        de deVar = this.f4463yj.get();
        if (!deVar.qw) {
            throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        } else if (event == null) {
            throw new EventBusException("Event may not be null");
        } else if (deVar.f4466fe == event) {
            deVar.f4467rg = true;
        } else {
            throw new EventBusException("Only the currently handled event may be aborted");
        }
    }

    public synchronized void i(Object obj, String str, int i2, boolean z, EventBus.ThreadMode threadMode) {
        o(obj, this.f4462th.qw(obj.getClass()), z, i2, str, threadMode);
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized void m281if(Object obj, String[] strArr, int i2, boolean z, EventBus.ThreadMode threadMode) {
        pf(obj, this.f4462th.qw(obj.getClass()), z, i2, strArr, threadMode);
    }

    public final void o(Object obj, Method method, boolean z, int i2, String str, EventBus.ThreadMode threadMode) {
        EventBus.Event event;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f4460fe.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.f4460fe.put(str, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((yj) it.next()).qw.equals(obj)) {
                    String str2 = f4456i;
                    LogUtil.d(str2, "Subscriber " + obj.getClass() + " already registered to event " + str);
                    return;
                }
            }
        }
        yj yjVar = new yj(obj, method, str, i2, threadMode);
        int size = copyOnWriteArrayList.size();
        boolean z2 = false;
        if (size > 0) {
            int i3 = 0;
            while (true) {
                if (i3 > size) {
                    break;
                } else if (i3 == size || yjVar.f4475de > ((yj) copyOnWriteArrayList.get(i3)).f4475de) {
                    copyOnWriteArrayList.add(i3, yjVar);
                } else {
                    i3++;
                }
            }
            copyOnWriteArrayList.add(i3, yjVar);
        } else {
            copyOnWriteArrayList.add(yjVar);
        }
        List list = this.f4461rg.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.f4461rg.put(obj, list);
        }
        list.add(str);
        if (z) {
            synchronized (this.qw) {
                event = this.qw.get(str);
            }
            if (event != null) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z2 = true;
                }
                th(yjVar, event, z2);
            }
        }
    }

    public final void pf(Object obj, Method method, boolean z, int i2, String[] strArr, EventBus.ThreadMode threadMode) {
        for (String o2 : strArr) {
            o(obj, method, z, i2, o2, threadMode);
        }
    }

    public final void ppp(Object obj, String str) {
        List list = this.f4460fe.get(str);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                yj yjVar = (yj) list.get(i2);
                if (yjVar.qw == obj) {
                    yjVar.f4477rg = false;
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public void qw() {
        synchronized (this.qw) {
            this.qw.clear();
        }
    }

    public final void rg(yj yjVar, EventBus.Event event) throws Error {
        try {
            yjVar.f4474ad.invoke(yjVar.qw, new Object[]{event});
        } catch (InvocationTargetException e) {
            e.getCause();
            "Could not dispatch event: " + event.getClass() + " to subscribing class " + yjVar.qw.getClass();
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m282switch(String str) {
        synchronized (this.qw) {
            this.qw.remove(str);
        }
    }

    public final void th(yj yjVar, EventBus.Event event, boolean z) {
        int i2 = C0193ad.qw[yjVar.f4476fe.ordinal()];
        if (i2 == 1) {
            rg(yjVar, event);
        } else if (i2 != 2) {
            if (i2 == 3) {
                this.f4459de.qw(yjVar, event);
                return;
            }
            throw new IllegalStateException("Unknown thread mode: " + yjVar.f4476fe);
        } else if (z) {
            rg(yjVar, event);
        } else {
            this.f4458ad.qw(yjVar, event);
        }
    }

    public synchronized void uk(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            ppp(obj, str);
            List list = this.f4461rg.get(obj);
            if (list != null) {
                list.remove(str);
            }
            if (list != null && list.size() == 0) {
                this.f4461rg.remove(obj);
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    public void when(EventBus.Event event) {
        synchronized (this.qw) {
            this.qw.put(event.mEventKey, event);
        }
        ad(event);
    }

    public synchronized void yj(Object obj) {
        if (obj != null) {
            List<String> list = this.f4461rg.get(obj);
            if (list != null) {
                for (String ppp : list) {
                    ppp(obj, ppp);
                }
                this.f4461rg.remove(obj);
            } else {
                String str = f4456i;
                LogUtil.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }
}
