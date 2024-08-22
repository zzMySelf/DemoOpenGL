package fe.fe.o.rg.de;

import fe.fe.o.th.ggg;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class yj implements Comparable {

    /* renamed from: ad  reason: collision with root package name */
    public String f2661ad;

    /* renamed from: i  reason: collision with root package name */
    public int f2662i = 0;

    /* renamed from: if  reason: not valid java name */
    public List f87if = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    public int f2663o;

    /* renamed from: pf  reason: collision with root package name */
    public int f2664pf;

    /* renamed from: switch  reason: not valid java name */
    public int f88switch = 0;

    /* renamed from: th  reason: collision with root package name */
    public String f2665th;

    /* renamed from: uk  reason: collision with root package name */
    public long f2666uk;

    /* renamed from: yj  reason: collision with root package name */
    public long f2667yj;

    public yj ad(String str, String str2) {
        String str3;
        yj yjVar = new yj();
        try {
            String replace = str.replace(new URL(str).getHost(), this.f2661ad);
            yjVar.f2665th = replace;
            if (ggg.pf(replace)) {
                str3 = yjVar.f2665th + "&xcode=" + str2;
            } else {
                str3 = yjVar.f2665th + "?xcode=" + str2;
            }
            yjVar.f2665th = str3;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        yjVar.f2667yj = this.f2667yj;
        yjVar.f2666uk = this.f2666uk;
        yjVar.f2662i = this.f2662i;
        yjVar.f2663o = this.f2663o;
        yjVar.f2664pf = this.f2664pf;
        yjVar.f87if = new ArrayList();
        yjVar.f88switch = 0;
        return yjVar;
    }

    /* renamed from: fe */
    public int compareTo(yj yjVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        long j = this.f2667yj;
        if (j == 0 || (i2 = this.f2664pf) == 0) {
            return 1;
        }
        long j2 = yjVar.f2667yj;
        if (j2 == 0 || (i3 = yjVar.f2664pf) == 0 || ((float) (this.f2666uk / (j * ((long) i2)))) > ((float) (yjVar.f2666uk / (j2 * ((long) i3))))) {
            return -1;
        }
        if (i4 != 0 || (i5 = this.f2663o) > (i6 = yjVar.f2663o)) {
            return 1;
        }
        return i5 < i6 ? -1 : 0;
    }

    public yj qw() {
        yj yjVar = new yj();
        yjVar.f2661ad = this.f2661ad;
        yjVar.f2667yj = this.f2667yj;
        yjVar.f2666uk = this.f2666uk;
        yjVar.f2662i = this.f2662i;
        yjVar.f2663o = this.f2663o;
        yjVar.f2664pf = this.f2664pf;
        return yjVar;
    }

    public long rg() {
        int i2;
        long j = this.f2667yj;
        if (j == 0 || (i2 = this.f2664pf) == 0) {
            return 0;
        }
        return (this.f2666uk * 1000) / (j * ((long) i2));
    }
}
