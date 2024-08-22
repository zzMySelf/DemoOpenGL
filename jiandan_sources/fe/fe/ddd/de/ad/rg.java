package fe.fe.ddd.de.ad;

import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.de.de.qw;
import fe.fe.vvv.qw.qw.ad;

public class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static rg f1389ad;
    public ListHolder<IANRRegister> qw;

    public rg() {
        fe();
    }

    public static rg de() {
        if (f1389ad == null) {
            synchronized (rg.class) {
                if (f1389ad == null) {
                    f1389ad = new rg();
                }
            }
        }
        return f1389ad;
    }

    public ListHolder<IANRRegister> ad() {
        return this.qw;
    }

    public void fe() {
        ad de2 = ad.de();
        this.qw = de2;
        de2.ad(new qw());
    }

    public boolean qw() {
        ListHolder<IANRRegister> listHolder = this.qw;
        if (listHolder == null || listHolder.qw() == null) {
            return false;
        }
        for (IANRRegister next : this.qw.qw()) {
            if (next != null && next.ad()) {
                boolean rg2 = AppConfig.rg();
                return true;
            }
        }
        return false;
    }
}
