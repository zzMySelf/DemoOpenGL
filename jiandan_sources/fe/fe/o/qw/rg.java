package fe.fe.o.qw;

import android.content.Context;
import com.baidu.down.a.h;
import com.baidu.down.loopj.android.http.exp.RetryStrategyException;
import fe.fe.o.rg.ad.qw;
import fe.fe.o.rg.de.i;
import fe.fe.o.rg.de.th;
import fe.fe.o.th.Cswitch;
import fe.fe.o.th.ggg;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.HttpResponseException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public qw f2585ad = null;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2586de = false;

    /* renamed from: fe  reason: collision with root package name */
    public List f2587fe;

    /* renamed from: i  reason: collision with root package name */
    public int f2588i = 0;

    /* renamed from: o  reason: collision with root package name */
    public Exception f2589o;
    public Context qw;

    /* renamed from: rg  reason: collision with root package name */
    public th f2590rg;

    /* renamed from: th  reason: collision with root package name */
    public List f2591th;

    /* renamed from: uk  reason: collision with root package name */
    public ConcurrentHashMap f2592uk = new ConcurrentHashMap();

    /* renamed from: yj  reason: collision with root package name */
    public boolean f2593yj;

    public rg(Context context, qw qwVar) {
        this.qw = context;
        this.f2585ad = qwVar;
        this.f2593yj = Cswitch.ad(qwVar.ggg);
    }

    public String ddd() {
        th thVar = this.f2590rg;
        return thVar != null ? thVar.when : "";
    }

    public List fe() {
        return this.f2591th;
    }

    public ConcurrentHashMap ggg() {
        return this.f2592uk;
    }

    public boolean i(int i2) {
        return !ggg.th(this.f2591th) && i2 < this.f2591th.size();
    }

    public String mmm() {
        Exception exc = this.f2589o;
        return exc != null ? exc.getClass().getName() : "";
    }

    public int nn() {
        return this.f2588i;
    }

    public boolean pf(boolean z, Exception exc, int i2) {
        return i.ad((Context) null).qw().ddd().f2643de && ((z && this.f2593yj && ((exc instanceof UnknownHostException) || (exc instanceof ConnectException) || (exc instanceof SocketException) || (exc instanceof HttpHostConnectException) || (exc instanceof HttpResponseException) || (exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException) || (exc instanceof ProtocolException) || (exc instanceof RetryStrategyException))) || i(i2));
    }

    /* renamed from: switch  reason: not valid java name */
    public void m170switch(int i2) {
        this.f2588i = i2;
    }

    public void th(int i2, String str) {
        if (this.f2592uk.containsKey(Integer.valueOf(i2))) {
            ConcurrentHashMap concurrentHashMap = this.f2592uk;
            Integer valueOf = Integer.valueOf(i2);
            concurrentHashMap.put(valueOf, ((String) this.f2592uk.get(Integer.valueOf(i2))) + str);
            return;
        }
        this.f2592uk.put(Integer.valueOf(i2), str);
    }

    public void uk(Exception exc, h hVar) {
        if (when()) {
            hVar.a(true);
            return;
        }
        if (!this.f2586de) {
            this.f2586de = true;
            ArrayList arrayList = new ArrayList();
            this.f2587fe = arrayList;
            arrayList.add(hVar);
            ad adVar = new ad();
            qw qwVar = this.f2585ad;
            adVar.fe(qwVar.f82switch, qwVar.ggg, new th(this, exc));
        } else {
            this.f2587fe.add(hVar);
        }
        try {
            this.f2585ad.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public long vvv() {
        th thVar = this.f2590rg;
        if (thVar != null) {
            return thVar.f85if;
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.f2590rg;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean when() {
        /*
            r3 = this;
            boolean r0 = r3.f2593yj
            r1 = 0
            if (r0 == 0) goto L_0x0018
            fe.fe.o.rg.de.th r0 = r3.f2590rg
            if (r0 == 0) goto L_0x0018
            android.content.Context r2 = r3.qw
            boolean r0 = r0.rg(r2)
            if (r0 == 0) goto L_0x0018
            boolean r0 = r3.i(r1)
            if (r0 == 0) goto L_0x0018
            r1 = 1
        L_0x0018:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.qw.rg.when():boolean");
    }

    public int xxx() {
        th thVar = this.f2590rg;
        if (thVar != null) {
            return thVar.f2651pf;
        }
        return -1;
    }

    public void yj(Exception exc) {
        this.f2589o = exc;
    }
}
