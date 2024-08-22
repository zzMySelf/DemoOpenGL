package fe.fe.o.rg.de;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.down.common.DownConstants;
import com.baidu.down.common.TaskObserverInterface;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.loopj.android.http.n;
import fe.fe.o.ad.de;
import fe.fe.o.ad.th;
import fe.fe.o.de.ad;
import fe.fe.o.de.fe;
import fe.fe.o.de.rg;
import fe.fe.o.th.Cswitch;
import fe.fe.o.th.pf;
import io.flutter.plugins.connectivity.ConnectivityBroadcastReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public fe.fe.o.fe.qw.de.qw f2632ad;
    public rg ddd;

    /* renamed from: de  reason: collision with root package name */
    public Context f2633de;

    /* renamed from: fe  reason: collision with root package name */
    public ConcurrentHashMap f2634fe;
    public pf ggg;

    /* renamed from: i  reason: collision with root package name */
    public fe f2635i;

    /* renamed from: if  reason: not valid java name */
    public Handler f83if;

    /* renamed from: o  reason: collision with root package name */
    public de f2636o;

    /* renamed from: pf  reason: collision with root package name */
    public Cif f2637pf;
    public th ppp;
    public int qw = 3;

    /* renamed from: rg  reason: collision with root package name */
    public PriorityQueue f2638rg;

    /* renamed from: switch  reason: not valid java name */
    public HandlerThread f84switch;

    /* renamed from: th  reason: collision with root package name */
    public List f2639th;

    /* renamed from: uk  reason: collision with root package name */
    public BroadcastReceiver f2640uk;
    public Map vvv;
    public PowerManager.WakeLock when;
    public CopyOnWriteArrayList xxx;

    /* renamed from: yj  reason: collision with root package name */
    public List f2641yj;

    public qw(Context context, fe feVar) {
        pf pfVar;
        long[] jArr = null;
        this.f84switch = null;
        this.when = null;
        this.ppp = null;
        this.ddd = new rg();
        this.f2633de = context;
        this.ggg = new pf();
        if (feVar != null) {
            de.f2616rg = feVar.yj();
            int ad2 = feVar.ad();
            fe.fe.o.rg.ad.qw.D = ad2;
            fe.fe.o.rg.ad.qw.E = (long) (ad2 * 32);
            this.qw = feVar.uk();
            long[] i2 = feVar.i();
            fe.fe.o.th.qw.qw.ad().qw = feVar.m159if();
            this.ddd.qw = feVar.o();
            this.ddd.f2642ad = feVar.qw();
            this.ddd.f2643de = feVar.th();
            this.ddd.f2644fe = feVar.fe();
            this.ddd.f2645rg = de.qw(this.f2633de, (String) null);
            int i3 = 1;
            if (feVar.rg() == 1) {
                pfVar = this.ggg;
            } else {
                pfVar = this.ggg;
                i3 = 0;
            }
            pfVar.f2678ad = i3;
            Cswitch.qw(feVar.pf(), feVar.de());
            jArr = i2;
        }
        jArr = jArr == null ? DownConstants.qw : jArr;
        this.f2634fe = new ConcurrentHashMap();
        this.f2638rg = new PriorityQueue();
        this.f2639th = new ArrayList();
        this.f2641yj = new CopyOnWriteArrayList();
        this.vvv = new HashMap();
        d(this.f2633de);
        this.f2636o = new de();
        this.f2637pf = new Cif(3);
        this.f2632ad = new fe.fe.o.fe.qw.de.qw(this.f2633de, jArr, this.ggg.f2678ad);
        ad();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityBroadcastReceiver.CONNECTIVITY_ACTION);
        BroadcastReceiver broadcastReceiver = this.f2640uk;
        if (broadcastReceiver == null) {
            broadcastReceiver = new when(this);
            this.f2640uk = broadcastReceiver;
        }
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    public void a(Object obj) {
        for (TaskObserverInterface qw2 : this.f2641yj) {
            qw2.qw(obj);
        }
    }

    public pf aaa() {
        return this.ggg;
    }

    public final void ad() {
        HandlerThread handlerThread = new HandlerThread("DownloadLooperThread", 10);
        this.f84switch = handlerThread;
        handlerThread.start();
        this.f83if = new Cswitch(this, this.f84switch.getLooper());
    }

    public void b(int i2, Object obj) {
        Message obtainMessage = this.f83if.obtainMessage();
        obtainMessage.what = i2;
        obtainMessage.obj = obj;
        this.f83if.sendMessage(obtainMessage);
    }

    public synchronized void c(th thVar) {
        this.ppp = thVar;
    }

    public void d(Context context) {
        String[] split;
        String de2 = fe.fe.o.th.fe.de(context, "pref_config_info_type", "");
        CopyOnWriteArrayList copyOnWriteArrayList = this.xxx;
        if (copyOnWriteArrayList == null) {
            this.xxx = new CopyOnWriteArrayList();
        } else {
            copyOnWriteArrayList.clear();
        }
        if (!TextUtils.isEmpty(de2) && (split = de2.intern().replace(" ", "").toLowerCase().split(",")) != null && split.length > 0) {
            for (int i2 = 0; i2 < split.length; i2++) {
                if (!TextUtils.isEmpty(split[i2])) {
                    this.xxx.add(split[i2]);
                }
            }
        }
    }

    public rg ddd() {
        return this.ddd;
    }

    public final void de(fe.fe.o.rg.ad.qw qwVar) {
        qwVar.h = 0;
        rg rgVar = new rg();
        rgVar.qw = 1002;
        rgVar.f2493de = qwVar.ppp;
        rgVar.f2492ad = qwVar.ggg + qwVar.ppp;
        rgVar.f2499th = qwVar.nn;
        rgVar.f2498rg = qwVar.qqq;
        rgVar.f2494fe = qwVar.eee.i();
        rgVar.f72if = qwVar.eee.toString();
        rgVar.f2495i = 0;
        a(rgVar);
    }

    public long e(ad adVar) {
        SystemClock.elapsedRealtime();
        long j = adVar.f2484uk;
        String str = adVar.f2476ad;
        if (j > -1) {
            str = str + adVar.f2484uk;
        }
        if (this.f2634fe.containsKey(str)) {
            rg(str, adVar);
        } else {
            fe.fe.o.rg.ad.qw deVar = this.f2632ad.m163if() != n.TYPE_2G ? this.ggg.qw != 1 ? new fe.fe.o.rg.ad.de(this.f2633de, adVar) : (adVar.ppp != 1 || !th(adVar.xxx)) ? new fe.fe.o.rg.ad.de(this.f2633de, adVar) : new fe.fe.o.rg.ad.rg(this.f2633de, adVar) : new fe.fe.o.rg.ad.de(this.f2633de, adVar);
            deVar.f2602o = adVar.aaa;
            if (adVar.qw && adVar.f2484uk < 0) {
                if (this.f2635i == null) {
                    this.f2635i = new fe(this.f2633de);
                }
                deVar.ppp = this.f2635i.qw(deVar.ggg, deVar.vvv, deVar.ddd, 1);
                str = str + deVar.ppp;
            }
            long j2 = deVar.ppp;
            deVar.fe(adVar.qqq);
            synchronized (this.f2634fe) {
                if (this.f2634fe.containsKey(str)) {
                    rg(str, adVar);
                } else {
                    this.f2634fe.put(str, deVar);
                    f(deVar);
                }
            }
            j = j2;
        }
        this.f2636o.ad(de.f2616rg);
        return j;
    }

    public Cif eee() {
        return this.f2637pf;
    }

    public void f(fe.fe.o.rg.ad.qw qwVar) {
        int i2 = qwVar.when;
        if (i2 != 1002 && i2 != 1009 && i2 != 1001) {
            qwVar.when = PointerIconCompat.TYPE_VERTICAL_TEXT;
            Message obtainMessage = this.f83if.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = qwVar;
            this.f83if.sendMessageAtFrontOfQueue(obtainMessage);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m175if() {
        fe.fe.o.rg.ad.qw qwVar;
        int i2;
        Iterator it = this.f2639th.iterator();
        while (it.hasNext()) {
            fe.fe.o.rg.ad.qw qwVar2 = (fe.fe.o.rg.ad.qw) it.next();
            int i3 = qwVar2.when;
            if (i3 == 1004 || i3 == 1005 || i3 == 1003 || i3 == 1008 || i3 == 1006) {
                it.remove();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            int i4 = qwVar2.when;
            if ((i4 == 1001 || i4 == 1002) && qwVar2.h != 0 && elapsedRealtime - qwVar2.g > ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                de(qwVar2);
            }
        }
        while (this.f2638rg.size() > 0) {
            if (this.f2639th.size() < this.qw) {
                qwVar = (fe.fe.o.rg.ad.qw) this.f2634fe.get(((fe.fe.o.rg.ad.qw) this.f2638rg.poll()).ad());
                if (qwVar != null) {
                    int i5 = qwVar.when;
                    if (i5 != 1004) {
                        if (i5 != 1005) {
                            if (i5 != 1003) {
                                if (i5 != 1008) {
                                    if (i5 != 1006) {
                                        if (this.f2639th.contains(qwVar)) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                fe.fe.o.rg.ad.qw qwVar3 = (fe.fe.o.rg.ad.qw) this.f2638rg.peek();
                fe.fe.o.rg.ad.qw qwVar4 = null;
                Iterator it2 = this.f2639th.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    fe.fe.o.rg.ad.qw qwVar5 = (fe.fe.o.rg.ad.qw) it2.next();
                    if (qwVar3.th() > qwVar5.th()) {
                        qwVar4 = qwVar5;
                        break;
                    }
                }
                if (qwVar4 == null) {
                    break;
                }
                this.f2638rg.remove(qwVar3);
                qwVar = (fe.fe.o.rg.ad.qw) this.f2634fe.get(qwVar3.ad());
                if (!(qwVar == null || (i2 = qwVar.when) == 1004 || i2 == 1005 || i2 == 1003 || i2 == 1008 || i2 == 1006 || this.f2639th.contains(qwVar))) {
                    qwVar4.o();
                    this.f2639th.remove(qwVar4);
                    this.f2638rg.add(qwVar4);
                }
            }
            this.f2639th.add(qwVar);
            qwVar.uk();
        }
        if (this.f2638rg.size() > 0 || this.f2639th.size() > 0) {
            this.f83if.sendEmptyMessageDelayed(0, CoroutineLiveDataKt.DEFAULT_TIMEOUT);
            if (this.when == null) {
                PowerManager.WakeLock newWakeLock = ((PowerManager) this.f2633de.getSystemService("power")).newWakeLock(1, "Async-Downloader");
                this.when = newWakeLock;
                newWakeLock.acquire();
            }
            PowerManager.WakeLock wakeLock = this.when;
            if (wakeLock != null && !wakeLock.isHeld()) {
                this.when.acquire();
                return;
            }
            return;
        }
        PowerManager.WakeLock wakeLock2 = this.when;
        if (wakeLock2 != null && wakeLock2.isHeld()) {
            this.when.release();
        }
    }

    public synchronized th mmm() {
        return this.ppp;
    }

    public fe.fe.o.fe.qw.de.qw nn() {
        return this.f2632ad;
    }

    public final void o() {
        fe.fe.o.de.uk.ad qw2;
        fe.fe.o.de.uk.ad qw3;
        List list = this.f2639th;
        if (list != null && list.size() > 0) {
            for (fe.fe.o.rg.ad.qw qwVar : this.f2639th) {
                Map map = qwVar.f2602o;
                if (map != null && map.containsKey("network") && (qw3 = ((IIntercepter) qwVar.f2602o.get("network")).qw(qwVar.f82switch, qwVar.ad(), qwVar.ppp, (Object) null)) != null && qw3.f2502ad == 1) {
                    qwVar.i();
                }
            }
        }
        if (this.f2638rg.size() > 0) {
            int size = this.f2638rg.size();
            fe.fe.o.rg.ad.qw[] qwVarArr = new fe.fe.o.rg.ad.qw[size];
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    fe.fe.o.rg.ad.qw qwVar2 = qwVarArr[i2];
                    Map map2 = qwVar2.f2602o;
                    if (map2 != null && map2.containsKey("network") && (qw2 = ((IIntercepter) qwVar2.f2602o.get("network")).qw(qwVar2.f82switch, qwVar2.ad(), qwVar2.ppp, (Object) null)) != null && qw2.f2502ad == 1) {
                        qwVar2.i();
                    }
                }
            }
        }
    }

    public fe.fe.o.rg.ad.qw qqq(String str) {
        if (str == null) {
            return null;
        }
        return (fe.fe.o.rg.ad.qw) this.f2634fe.get(str);
    }

    public final void rg(String str, ad adVar) {
        fe.fe.o.rg.ad.qw qwVar = (fe.fe.o.rg.ad.qw) this.f2634fe.get(str);
        qwVar.fe(adVar.qqq);
        f(qwVar);
        qwVar.f2602o = adVar.aaa;
        if (!qwVar.ddd.equals(adVar.f2477de)) {
            qwVar.ddd = adVar.f2477de;
            qwVar.nn = null;
        }
    }

    public final boolean th(String str) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.xxx;
        return copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty() && !TextUtils.isEmpty(str) && this.xxx.contains(str);
    }

    public void tt(String str, long j) {
        if (j > 0) {
            str = str + j;
        }
        fe.fe.o.rg.ad.qw qwVar = (fe.fe.o.rg.ad.qw) this.f2634fe.get(str);
        if (qwVar != null) {
            int i2 = qwVar.when;
            if (i2 == 1004 || i2 == 1008) {
                synchronized (this.f2634fe) {
                    this.f2634fe.remove(str);
                }
                this.f83if.removeMessages(1);
                this.f83if.sendEmptyMessageDelayed(1, 30000);
            }
            this.f83if.removeMessages(0);
            this.f83if.sendEmptyMessage(0);
            int i3 = qwVar.when;
            if (i3 == 1004 || i3 == 1005 || i3 == 1006 || i3 == 1008) {
                th thVar = qwVar.f81if;
                if (thVar.qw) {
                    thVar.f2463fe = qwVar.when;
                    o.de(this.f2633de, thVar, this.ddd.f2645rg, false);
                } else if (de.fe(this.f2633de, this.ddd)) {
                    o.de(this.f2633de, (th) null, this.ddd.f2645rg, true);
                }
            }
            if (qwVar instanceof fe.fe.o.rg.ad.rg) {
                ((fe.fe.o.rg.ad.rg) qwVar).j(qwVar.when);
            }
        }
    }

    public void uk(Long l, fe.fe.o.de.de deVar) {
        this.vvv.put(l, deVar);
    }

    public de vvv() {
        return this.f2636o;
    }

    public fe xxx() {
        return this.f2635i;
    }

    public void yj(TaskObserverInterface taskObserverInterface) {
        synchronized (this.f2641yj) {
            if (!this.f2641yj.contains(taskObserverInterface)) {
                this.f2641yj.add(taskObserverInterface);
            }
        }
    }
}
