package fe.fe.p004if.qw.de;

import androidx.lifecycle.CoroutineLiveDataKt;

/* renamed from: fe.fe.if.qw.de.qw  reason: invalid package */
public class qw {

    /* renamed from: ad  reason: collision with root package name */
    public long f1952ad = CoroutineLiveDataKt.DEFAULT_TIMEOUT;

    /* renamed from: de  reason: collision with root package name */
    public int f1953de = -1;

    /* renamed from: fe  reason: collision with root package name */
    public String f1954fe = "";

    /* renamed from: i  reason: collision with root package name */
    public long f1955i = -1;

    /* renamed from: if  reason: not valid java name */
    public boolean f45if = false;

    /* renamed from: o  reason: collision with root package name */
    public int f1956o = -1;

    /* renamed from: pf  reason: collision with root package name */
    public boolean f1957pf = false;
    public boolean ppp = false;
    public byte[] qw = new byte[0];

    /* renamed from: rg  reason: collision with root package name */
    public boolean f1958rg = false;

    /* renamed from: switch  reason: not valid java name */
    public boolean f46switch = false;

    /* renamed from: th  reason: collision with root package name */
    public byte[] f1959th = new byte[0];

    /* renamed from: uk  reason: collision with root package name */
    public long f1960uk = -1;
    public long when = -1;

    /* renamed from: yj  reason: collision with root package name */
    public long f1961yj = 60000;

    public String toString() {
        if (this.f46switch) {
            return "Request correlationId :" + this.when + ", serviceId :" + this.f1960uk + ", methodId :" + this.f1955i + ", connectState :" + this.f1956o + ", isNotify :" + this.f1958rg + ", bodySize :" + this.qw.length + ", request :" + new String(this.qw);
        }
        return "Response correlationId " + this.when + ", serviceId :" + this.f1960uk + ", methodId :" + this.f1955i + ", errorCode :" + this.f1953de + ", errorMsg :" + this.f1954fe + ", intervalMs :" + this.f1961yj + ", isNotify :" + this.f1958rg + ", bodySize :" + this.f1959th.length + ", response :" + new String(this.f1959th);
    }
}
