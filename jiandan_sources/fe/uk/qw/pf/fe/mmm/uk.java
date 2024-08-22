package fe.uk.qw.pf.fe.mmm;

import android.util.Log;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import fe.uk.qw.vvv.i;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class uk implements ArrayPool {

    /* renamed from: ad  reason: collision with root package name */
    public final ad f5797ad = new ad();

    /* renamed from: de  reason: collision with root package name */
    public final Map<Class<?>, NavigableMap<Integer, Integer>> f5798de = new HashMap();

    /* renamed from: fe  reason: collision with root package name */
    public final Map<Class<?>, qw<?>> f5799fe = new HashMap();
    public final th<qw, Object> qw = new th<>();

    /* renamed from: rg  reason: collision with root package name */
    public final int f5800rg;

    /* renamed from: th  reason: collision with root package name */
    public int f5801th;

    public static final class ad extends de<qw> {
        /* renamed from: fe */
        public qw qw() {
            return new qw(this);
        }

        public qw rg(int i2, Class<?> cls) {
            qw qwVar = (qw) ad();
            qwVar.ad(i2, cls);
            return qwVar;
        }
    }

    public static final class qw implements pf {

        /* renamed from: ad  reason: collision with root package name */
        public int f5802ad;

        /* renamed from: de  reason: collision with root package name */
        public Class<?> f5803de;
        public final ad qw;

        public qw(ad adVar) {
            this.qw = adVar;
        }

        public void ad(int i2, Class<?> cls) {
            this.f5802ad = i2;
            this.f5803de = cls;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof qw)) {
                return false;
            }
            qw qwVar = (qw) obj;
            if (this.f5802ad == qwVar.f5802ad && this.f5803de == qwVar.f5803de) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.f5802ad * 31;
            Class<?> cls = this.f5803de;
            return i2 + (cls != null ? cls.hashCode() : 0);
        }

        public void qw() {
            this.qw.de(this);
        }

        public String toString() {
            return "Key{size=" + this.f5802ad + "array=" + this.f5803de + ExtendedMessageFormat.END_FE;
        }
    }

    public uk(int i2) {
        this.f5800rg = i2;
    }

    public synchronized void ad() {
        yj(0);
    }

    public synchronized <T> T de(int i2, Class<T> cls) {
        qw qwVar;
        Integer ceilingKey = m377if(cls).ceilingKey(Integer.valueOf(i2));
        if (ppp(i2, ceilingKey)) {
            qwVar = this.f5797ad.rg(ceilingKey.intValue(), cls);
        } else {
            qwVar = this.f5797ad.rg(i2, cls);
        }
        return pf(qwVar, cls);
    }

    public synchronized <T> T fe(int i2, Class<T> cls) {
        return pf(this.f5797ad.rg(i2, cls), cls);
    }

    public final <T> qw<T> i(Class<T> cls) {
        qw<T> qwVar = this.f5799fe.get(cls);
        if (qwVar == null) {
            if (cls.equals(int[].class)) {
                qwVar = new yj();
            } else if (cls.equals(byte[].class)) {
                qwVar = new rg();
            } else {
                throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
            }
            this.f5799fe.put(cls, qwVar);
        }
        return qwVar;
    }

    /* renamed from: if  reason: not valid java name */
    public final NavigableMap<Integer, Integer> m377if(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.f5798de.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5798de.put(cls, treeMap);
        return treeMap;
    }

    @Nullable
    public final <T> T o(qw qwVar) {
        return this.qw.qw(qwVar);
    }

    public final <T> T pf(qw qwVar, Class<T> cls) {
        qw<T> i2 = i(cls);
        T o2 = o(qwVar);
        if (o2 != null) {
            this.f5801th -= i2.ad(o2) * i2.qw();
            rg(i2.ad(o2), cls);
        }
        if (o2 != null) {
            return o2;
        }
        if (Log.isLoggable(i2.getTag(), 2)) {
            i2.getTag();
            "Allocated " + qwVar.f5802ad + " bytes";
        }
        return i2.newArray(qwVar.f5802ad);
    }

    public final boolean ppp(int i2, Integer num) {
        return num != null && (m378switch() || num.intValue() <= i2 * 8);
    }

    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        qw<?> i2 = i(cls);
        int ad2 = i2.ad(t);
        int qw2 = i2.qw() * ad2;
        if (when(qw2)) {
            qw rg2 = this.f5797ad.rg(ad2, cls);
            this.qw.fe(rg2, t);
            NavigableMap<Integer, Integer> navigableMap = m377if(cls);
            Integer num = (Integer) navigableMap.get(Integer.valueOf(rg2.f5802ad));
            Integer valueOf = Integer.valueOf(rg2.f5802ad);
            int i3 = 1;
            if (num != null) {
                i3 = 1 + num.intValue();
            }
            navigableMap.put(valueOf, Integer.valueOf(i3));
            this.f5801th += qw2;
            th();
        }
    }

    public synchronized void qw(int i2) {
        if (i2 >= 40) {
            try {
                ad();
            } catch (Throwable th2) {
                throw th2;
            }
        } else if (i2 >= 20 || i2 == 15) {
            yj(this.f5800rg / 2);
        }
    }

    public final void rg(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = m377if(cls);
        Integer num = (Integer) navigableMap.get(Integer.valueOf(i2));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
        } else if (num.intValue() == 1) {
            navigableMap.remove(Integer.valueOf(i2));
        } else {
            navigableMap.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m378switch() {
        int i2 = this.f5801th;
        return i2 == 0 || this.f5800rg / i2 >= 2;
    }

    public final void th() {
        yj(this.f5800rg);
    }

    public final <T> qw<T> uk(T t) {
        return i(t.getClass());
    }

    public final boolean when(int i2) {
        return i2 <= this.f5800rg / 2;
    }

    public final void yj(int i2) {
        while (this.f5801th > i2) {
            Object th2 = this.qw.th();
            i.fe(th2);
            qw uk2 = uk(th2);
            this.f5801th -= uk2.ad(th2) * uk2.qw();
            rg(uk2.ad(th2), th2.getClass());
            if (Log.isLoggable(uk2.getTag(), 2)) {
                uk2.getTag();
                "evicted: " + uk2.ad(th2);
            }
        }
    }
}
