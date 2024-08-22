package fe.th.de;

import com.baidu.sapi2.activity.BindVerifyActivity;
import com.duxiaoman.okhttp3.Protocol;
import fe.th.de.pf;
import java.io.Closeable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class mmm implements Closeable {

    /* renamed from: ad  reason: collision with root package name */
    public final ddd f5196ad;
    public final long ggg;

    /* renamed from: i  reason: collision with root package name */
    public final o f5197i;

    /* renamed from: if  reason: not valid java name */
    public final mmm f205if;

    /* renamed from: o  reason: collision with root package name */
    public final pf f5198o;

    /* renamed from: pf  reason: collision with root package name */
    public final aaa f5199pf;
    public final long ppp;

    /* renamed from: switch  reason: not valid java name */
    public final mmm f206switch;

    /* renamed from: th  reason: collision with root package name */
    public final Protocol f5200th;

    /* renamed from: uk  reason: collision with root package name */
    public final String f5201uk;
    public volatile de vvv;
    public final mmm when;

    /* renamed from: yj  reason: collision with root package name */
    public final int f5202yj;

    public mmm(qw qwVar) {
        this.f5196ad = qwVar.qw;
        this.f5200th = qwVar.f5203ad;
        this.f5202yj = qwVar.f5204de;
        this.f5201uk = qwVar.f5205fe;
        this.f5197i = qwVar.f5209rg;
        this.f5198o = qwVar.f5210th.rg();
        this.f5199pf = qwVar.f5212yj;
        this.f205if = qwVar.f5211uk;
        this.f206switch = qwVar.f5206i;
        this.when = qwVar.f5207o;
        this.ppp = qwVar.f5208pf;
        this.ggg = qwVar.f207if;
    }

    public void close() {
        aaa aaa = this.f5199pf;
        if (aaa != null) {
            aaa.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public long ddd() {
        return this.ggg;
    }

    public de de() {
        de deVar = this.vvv;
        if (deVar != null) {
            return deVar;
        }
        de pf2 = de.pf(this.f5198o);
        this.vvv = pf2;
        return pf2;
    }

    public mmm fe() {
        return this.f206switch;
    }

    public qw ggg() {
        return new qw(this);
    }

    public boolean isSuccessful() {
        int i2 = this.f5202yj;
        return i2 >= 200 && i2 < 300;
    }

    public long mmm() {
        return this.ppp;
    }

    public ddd nn() {
        return this.f5196ad;
    }

    public pf pf() {
        return this.f5198o;
    }

    public mmm ppp() {
        return this.f205if;
    }

    public aaa qw() {
        return this.f5199pf;
    }

    public int rg() {
        return this.f5202yj;
    }

    /* renamed from: switch  reason: not valid java name */
    public boolean m342switch() {
        int i2 = this.f5202yj;
        if (i2 == 307 || i2 == 308) {
            return true;
        }
        switch (i2) {
            case 300:
            case 301:
            case 302:
            case BindVerifyActivity.D:
                return true;
            default:
                return false;
        }
    }

    public o th() {
        return this.f5197i;
    }

    public String toString() {
        return "Response{protocol=" + this.f5200th + ", code=" + this.f5202yj + ", message=" + this.f5201uk + ", url=" + this.f5196ad.uk() + ExtendedMessageFormat.END_FE;
    }

    public String uk(String str, String str2) {
        String de2 = this.f5198o.de(str);
        return de2 != null ? de2 : str2;
    }

    public mmm vvv() {
        return this.when;
    }

    public String when() {
        return this.f5201uk;
    }

    public Protocol xxx() {
        return this.f5200th;
    }

    public String yj(String str) {
        return uk(str, (String) null);
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public Protocol f5203ad;

        /* renamed from: de  reason: collision with root package name */
        public int f5204de;

        /* renamed from: fe  reason: collision with root package name */
        public String f5205fe;

        /* renamed from: i  reason: collision with root package name */
        public mmm f5206i;

        /* renamed from: if  reason: not valid java name */
        public long f207if;

        /* renamed from: o  reason: collision with root package name */
        public mmm f5207o;

        /* renamed from: pf  reason: collision with root package name */
        public long f5208pf;
        public ddd qw;

        /* renamed from: rg  reason: collision with root package name */
        public o f5209rg;

        /* renamed from: th  reason: collision with root package name */
        public pf.qw f5210th;

        /* renamed from: uk  reason: collision with root package name */
        public mmm f5211uk;

        /* renamed from: yj  reason: collision with root package name */
        public aaa f5212yj;

        public qw() {
            this.f5204de = -1;
            this.f5210th = new pf.qw();
        }

        public qw ad(aaa aaa) {
            this.f5212yj = aaa;
            return this;
        }

        public mmm de() {
            if (this.qw == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f5203ad == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f5204de < 0) {
                throw new IllegalStateException("code < 0: " + this.f5204de);
            } else if (this.f5205fe != null) {
                return new mmm(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public qw fe(mmm mmm) {
            if (mmm != null) {
                th("cacheResponse", mmm);
            }
            this.f5206i = mmm;
            return this;
        }

        public qw ggg(ddd ddd) {
            this.qw = ddd;
            return this;
        }

        public qw i(String str, String str2) {
            this.f5210th.uk(str, str2);
            return this;
        }

        /* renamed from: if  reason: not valid java name */
        public qw m343if(mmm mmm) {
            if (mmm != null) {
                th("networkResponse", mmm);
            }
            this.f5211uk = mmm;
            return this;
        }

        public qw o(pf pfVar) {
            this.f5210th = pfVar.th();
            return this;
        }

        public qw pf(String str) {
            this.f5205fe = str;
            return this;
        }

        public qw ppp(long j) {
            this.f207if = j;
            return this;
        }

        public qw qw(String str, String str2) {
            this.f5210th.qw(str, str2);
            return this;
        }

        public final void rg(mmm mmm) {
            if (mmm.f5199pf != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: switch  reason: not valid java name */
        public qw m344switch(mmm mmm) {
            if (mmm != null) {
                rg(mmm);
            }
            this.f5207o = mmm;
            return this;
        }

        public final void th(String str, mmm mmm) {
            if (mmm.f5199pf != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (mmm.f205if != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (mmm.f206switch != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (mmm.when != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public qw uk(o oVar) {
            this.f5209rg = oVar;
            return this;
        }

        public qw vvv(long j) {
            this.f5208pf = j;
            return this;
        }

        public qw when(Protocol protocol) {
            this.f5203ad = protocol;
            return this;
        }

        public qw yj(int i2) {
            this.f5204de = i2;
            return this;
        }

        public qw(mmm mmm) {
            this.f5204de = -1;
            this.qw = mmm.f5196ad;
            this.f5203ad = mmm.f5200th;
            this.f5204de = mmm.f5202yj;
            this.f5205fe = mmm.f5201uk;
            this.f5209rg = mmm.f5197i;
            this.f5210th = mmm.f5198o.th();
            this.f5212yj = mmm.f5199pf;
            this.f5211uk = mmm.f205if;
            this.f5206i = mmm.f206switch;
            this.f5207o = mmm.when;
            this.f5208pf = mmm.ppp;
            this.f207if = mmm.ggg;
        }
    }
}
