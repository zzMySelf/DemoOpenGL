package fe.fe.o.rg.de;

import fe.fe.o.th.o;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: fe.fe.o.rg.de.if  reason: invalid class name */
public class Cif {

    /* renamed from: ad  reason: collision with root package name */
    public int f2625ad = 3;

    /* renamed from: de  reason: collision with root package name */
    public pf[] f2626de = null;

    /* renamed from: fe  reason: collision with root package name */
    public Map f2627fe = null;
    public ExecutorService qw = null;

    /* renamed from: rg  reason: collision with root package name */
    public Object f2628rg = new Object();

    public Cif(int i2) {
        this.f2625ad = i2;
        this.qw = Executors.newFixedThreadPool(i2, new o("WriteThread"));
        this.f2626de = new pf[this.f2625ad];
        for (int i3 = 0; i3 < this.f2625ad; i3++) {
            this.f2626de[i3] = new pf();
            this.qw.execute(this.f2626de[i3]);
        }
        this.f2627fe = new HashMap();
    }

    public void ad(ad adVar) {
        pf pfVar;
        pf pfVar2 = (pf) this.f2627fe.get(adVar.f2614fe);
        if (pfVar2 != null) {
            pfVar2.th(adVar);
            return;
        }
        synchronized (this.f2628rg) {
            pfVar = (pf) this.f2627fe.get(adVar.f2614fe);
            if (pfVar == null) {
                for (pf pfVar3 : this.f2626de) {
                    if (pfVar == null || pfVar.rg() > pfVar3.rg()) {
                        pfVar = pfVar3;
                    }
                }
                this.f2627fe.put(adVar.f2614fe, pfVar);
            }
        }
        pfVar.th(adVar);
    }

    public void qw(String str) {
        pf pfVar;
        synchronized (this.f2628rg) {
            pfVar = (pf) this.f2627fe.remove(str);
        }
        if (pfVar != null) {
            try {
                pfVar.fe(str);
            } catch (Exception unused) {
            }
        }
    }
}
