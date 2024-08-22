package fe.fe.o.rg.de;

import java.util.LinkedList;
import java.util.Queue;

public class de {

    /* renamed from: rg  reason: collision with root package name */
    public static int f2616rg = 100;

    /* renamed from: ad  reason: collision with root package name */
    public Queue f2617ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f2618de;

    /* renamed from: fe  reason: collision with root package name */
    public int f2619fe;
    public Queue qw;

    public de() {
        this.qw = null;
        this.f2617ad = null;
        this.f2618de = false;
        this.f2619fe = 0;
        this.qw = new LinkedList();
        this.f2617ad = new LinkedList();
        this.f2618de = false;
    }

    public void ad(int i2) {
        if (!this.f2618de) {
            for (int i3 = 0; i3 < i2; i3++) {
                this.qw.offer(new ad());
            }
            this.f2619fe = f2616rg;
            this.f2618de = true;
        }
    }

    public void de(ad adVar) {
        synchronized (this.f2617ad) {
            if (!adVar.f2615rg) {
                adVar.f2615rg = true;
                if (this.f2617ad != null) {
                    this.f2617ad.offer(adVar);
                }
            }
        }
    }

    public void fe() {
        this.qw.clear();
        this.f2617ad.clear();
        this.f2618de = false;
        this.f2619fe = 0;
    }

    public synchronized ad qw() {
        if (this.qw.size() == 0 && this.f2617ad.size() != 0) {
            synchronized (this.f2617ad) {
                this.qw.addAll(this.f2617ad);
                this.f2617ad.clear();
            }
        }
        ad adVar = (ad) this.qw.poll();
        if (adVar == null) {
            if (this.f2619fe >= f2616rg * 2) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return qw();
            }
            adVar = new ad();
            this.f2619fe++;
        }
        adVar.f2615rg = false;
        return adVar;
    }
}
