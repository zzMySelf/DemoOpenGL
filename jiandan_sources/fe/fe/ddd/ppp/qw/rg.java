package fe.fe.ddd.ppp.qw;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.pyramid.annotation.component.Holder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.looper.ioc.ILooperNeedContext;
import com.baidu.searchbox.looper.ioc.ILooperUIContext;
import com.baidu.searchbox.track.Track;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.ppp.ad.ad;
import fe.fe.ddd.ppp.ad.de;

public class rg {

    /* renamed from: fe  reason: collision with root package name */
    public static final ILooperUIContext f1564fe = new qw();

    /* renamed from: rg  reason: collision with root package name */
    public static rg f1565rg;

    /* renamed from: ad  reason: collision with root package name */
    public ListHolder<ad> f1566ad;

    /* renamed from: de  reason: collision with root package name */
    public Holder<ILooperNeedContext> f1567de;
    public Holder<ILooperUIContext> qw;

    public static class qw implements ILooperUIContext {
        public boolean qw() {
            return false;
        }
    }

    public rg() {
        yj();
        th();
    }

    public static rg de() {
        if (f1565rg == null) {
            synchronized (rg.class) {
                if (f1565rg == null) {
                    f1565rg = new rg();
                }
            }
        }
        return f1565rg;
    }

    public boolean ad() {
        ListHolder<ad> listHolder = this.f1566ad;
        if (listHolder == null || listHolder.qw() == null) {
            return false;
        }
        for (ad next : this.f1566ad.qw()) {
            if (next != null && next.qw()) {
                boolean rg2 = AppConfig.rg();
                return true;
            }
        }
        return false;
    }

    public ILooperNeedContext fe() {
        return this.f1567de.get();
    }

    public void qw(Context context, fe.p013if.de.qw.uk.qw qwVar) {
        ListHolder<ad> listHolder = this.f1566ad;
        if (listHolder != null && listHolder.qw() != null) {
            qw qwVar2 = new qw(qwVar.xxx, qwVar.vvv, qwVar.when, qwVar.ppp, qwVar.qqq);
            uk rg2 = Track.fe().rg();
            if (rg2 != null) {
                if (!TextUtils.isEmpty(rg2.fe())) {
                    qwVar2.o(rg2.fe());
                } else if (!TextUtils.isEmpty(rg2.qw())) {
                    qwVar2.o(rg2.qw());
                }
            }
            qwVar2.pf(Track.fe().de());
            for (ad ad2 : this.f1566ad.qw()) {
                ad2.ad(context, qwVar2);
            }
        }
    }

    public ILooperUIContext rg() {
        Holder<ILooperUIContext> holder = this.qw;
        if (holder == null) {
            return f1564fe;
        }
        return holder.get();
    }

    public void th() {
        fe.fe.vvv.qw.qw.ad de2 = fe.fe.vvv.qw.qw.ad.de();
        this.f1566ad = de2;
        de2.ad(new de());
    }

    public void yj() {
        fe.fe.vvv.qw.qw.qw ad2 = fe.fe.vvv.qw.qw.qw.ad();
        this.f1567de = ad2;
        ad2.qw(new fe.fe.ddd.ppp.ad.qw());
    }
}
