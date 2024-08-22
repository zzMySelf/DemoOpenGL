package fe.fe.nn.de;

import android.util.Pair;
import com.baidu.sso.SSOManager;
import fe.fe.nn.rg.o;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class qw {

    /* renamed from: th  reason: collision with root package name */
    public static volatile qw f2236th;

    /* renamed from: ad  reason: collision with root package name */
    public final AtomicBoolean f2237ad = new AtomicBoolean(false);

    /* renamed from: de  reason: collision with root package name */
    public final AtomicBoolean f2238de = new AtomicBoolean(false);

    /* renamed from: fe  reason: collision with root package name */
    public final AtomicBoolean f2239fe = new AtomicBoolean(false);
    public final AtomicBoolean qw = new AtomicBoolean(false);

    /* renamed from: rg  reason: collision with root package name */
    public final HashMap<Integer, SSOManager.ISSOLoginListener> f2240rg = new HashMap<>();

    public static qw de() {
        if (f2236th == null) {
            synchronized (qw.class) {
                if (f2236th == null) {
                    f2236th = new qw();
                }
            }
        }
        return f2236th;
    }

    public synchronized Pair<Boolean, SSOManager.ISSOLoginListener> ad(int i2) {
        if (!this.f2240rg.containsKey(Integer.valueOf(i2))) {
            return new Pair<>(Boolean.FALSE, (Object) null);
        }
        o.qw().ad(i2);
        this.f2240rg.remove(Integer.valueOf(i2));
        return new Pair<>(Boolean.TRUE, this.f2240rg.get(Integer.valueOf(i2)));
    }

    public void fe(boolean z) {
        this.qw.set(z);
    }

    public boolean i(boolean z, boolean z2) {
        return this.f2237ad.compareAndSet(z, z2);
    }

    /* renamed from: if  reason: not valid java name */
    public synchronized boolean m146if(int i2) {
        return this.f2240rg.containsKey(Integer.valueOf(i2));
    }

    public void o(boolean z) {
        this.f2238de.set(z);
    }

    public boolean pf() {
        return this.f2238de.get();
    }

    public boolean ppp(boolean z, boolean z2) {
        return this.f2239fe.compareAndSet(z, z2);
    }

    public synchronized int qw(SSOManager.ISSOLoginListener iSSOLoginListener) {
        int currentTimeMillis;
        currentTimeMillis = (int) System.currentTimeMillis();
        this.f2240rg.put(Integer.valueOf(currentTimeMillis), iSSOLoginListener);
        return currentTimeMillis;
    }

    public boolean rg(boolean z, boolean z2) {
        return this.qw.compareAndSet(z, z2);
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m147switch(boolean z, boolean z2) {
        return this.f2238de.compareAndSet(z, z2);
    }

    public void th(boolean z) {
        this.f2237ad.set(z);
    }

    public synchronized boolean uk(int i2) {
        return this.f2240rg.containsKey(Integer.valueOf(i2));
    }

    public void when(boolean z) {
        this.f2239fe.set(z);
    }

    public boolean yj() {
        return this.f2237ad.get();
    }
}
