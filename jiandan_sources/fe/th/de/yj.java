package fe.th.de;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.duxiaoman.okhttp3.TlsVersion;
import fe.th.de.rrr.fe;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class yj {

    /* renamed from: rg  reason: collision with root package name */
    public static final rg[] f5571rg = {rg.vvv, rg.xxx, rg.ddd, rg.nn, rg.mmm, rg.f5248pf, rg.f209switch, rg.f208if, rg.when, rg.ggg, rg.ppp};

    /* renamed from: th  reason: collision with root package name */
    public static final rg[] f5572th = {rg.vvv, rg.xxx, rg.ddd, rg.nn, rg.mmm, rg.f5248pf, rg.f209switch, rg.f208if, rg.when, rg.ggg, rg.ppp, rg.f5246i, rg.f5247o, rg.f5252yj, rg.f5251uk, rg.f5249rg, rg.f5250th, rg.f5245fe};

    /* renamed from: uk  reason: collision with root package name */
    public static final yj f5573uk = new qw(false).qw();

    /* renamed from: yj  reason: collision with root package name */
    public static final yj f5574yj;

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f5575ad;

    /* renamed from: de  reason: collision with root package name */
    public final String[] f5576de;

    /* renamed from: fe  reason: collision with root package name */
    public final String[] f5577fe;
    public final boolean qw;

    static {
        qw qwVar = new qw(true);
        qwVar.ad(f5571rg);
        qwVar.rg(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2);
        qwVar.fe(true);
        qwVar.qw();
        qw qwVar2 = new qw(true);
        qwVar2.ad(f5572th);
        qwVar2.rg(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0);
        qwVar2.fe(true);
        f5574yj = qwVar2.qw();
        qw qwVar3 = new qw(true);
        qwVar3.ad(f5572th);
        qwVar3.rg(TlsVersion.TLS_1_0);
        qwVar3.fe(true);
        qwVar3.qw();
    }

    public yj(qw qwVar) {
        this.qw = qwVar.qw;
        this.f5576de = qwVar.f5578ad;
        this.f5577fe = qwVar.f5579de;
        this.f5575ad = qwVar.f5580fe;
    }

    public List<rg> ad() {
        String[] strArr = this.f5576de;
        if (strArr != null) {
            return rg.ad(strArr);
        }
        return null;
    }

    public boolean de(SSLSocket sSLSocket) {
        if (!this.qw) {
            return false;
        }
        String[] strArr = this.f5577fe;
        if (strArr != null && !fe.b(fe.ppp, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f5576de;
        if (strArr2 == null || fe.b(rg.f5243ad, strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof yj)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        yj yjVar = (yj) obj;
        boolean z = this.qw;
        if (z != yjVar.qw) {
            return false;
        }
        return !z || (Arrays.equals(this.f5576de, yjVar.f5576de) && Arrays.equals(this.f5577fe, yjVar.f5577fe) && this.f5575ad == yjVar.f5575ad);
    }

    public boolean fe() {
        return this.qw;
    }

    public int hashCode() {
        if (this.qw) {
            return ((((PayBeanFactory.BEAN_ID_WIDTHDRAW + Arrays.hashCode(this.f5576de)) * 31) + Arrays.hashCode(this.f5577fe)) * 31) + (this.f5575ad ^ true ? 1 : 0);
        }
        return 17;
    }

    public void qw(SSLSocket sSLSocket, boolean z) {
        yj rg2 = rg(sSLSocket, z);
        String[] strArr = rg2.f5577fe;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = rg2.f5576de;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public final yj rg(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f5576de != null) {
            strArr = fe.tt(rg.f5243ad, sSLSocket.getEnabledCipherSuites(), this.f5576de);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f5577fe != null) {
            strArr2 = fe.tt(fe.ppp, sSLSocket.getEnabledProtocols(), this.f5577fe);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int qqq = fe.qqq(rg.f5243ad, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && qqq != -1) {
            strArr = fe.i(strArr, supportedCipherSuites[qqq]);
        }
        qw qwVar = new qw(this);
        qwVar.de(strArr);
        qwVar.th(strArr2);
        return qwVar.qw();
    }

    public boolean th() {
        return this.f5575ad;
    }

    public String toString() {
        if (!this.qw) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f5576de != null ? ad().toString() : str;
        if (this.f5577fe != null) {
            str = yj().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f5575ad + ")";
    }

    public List<TlsVersion> yj() {
        String[] strArr = this.f5577fe;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public String[] f5578ad;

        /* renamed from: de  reason: collision with root package name */
        public String[] f5579de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f5580fe;
        public boolean qw;

        public qw(boolean z) {
            this.qw = z;
        }

        public qw ad(rg... rgVarArr) {
            if (this.qw) {
                String[] strArr = new String[rgVarArr.length];
                for (int i2 = 0; i2 < rgVarArr.length; i2++) {
                    strArr[i2] = rgVarArr[i2].qw;
                }
                de(strArr);
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public qw de(String... strArr) {
            if (!this.qw) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5578ad = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public qw fe(boolean z) {
            if (this.qw) {
                this.f5580fe = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public yj qw() {
            return new yj(this);
        }

        public qw rg(TlsVersion... tlsVersionArr) {
            if (this.qw) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i2 = 0; i2 < tlsVersionArr.length; i2++) {
                    strArr[i2] = tlsVersionArr[i2].javaName;
                }
                th(strArr);
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public qw th(String... strArr) {
            if (!this.qw) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.f5579de = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public qw(yj yjVar) {
            this.qw = yjVar.qw;
            this.f5578ad = yjVar.f5576de;
            this.f5579de = yjVar.f5577fe;
            this.f5580fe = yjVar.f5575ad;
        }
    }
}
