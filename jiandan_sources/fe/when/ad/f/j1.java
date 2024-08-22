package fe.when.ad.f;

import com.itextpdf.text.ExceptionConverter;
import fe.when.ad.c.qw;
import java.io.IOException;
import java.util.ArrayList;

public class j1 {

    /* renamed from: ad  reason: collision with root package name */
    public ArrayList<l0> f9499ad = new ArrayList<>();

    /* renamed from: de  reason: collision with root package name */
    public int f9500de = 10;

    /* renamed from: fe  reason: collision with root package name */
    public c2 f9501fe;
    public ArrayList<l0> qw = new ArrayList<>();

    /* renamed from: rg  reason: collision with root package name */
    public l0 f9502rg;

    public j1(c2 c2Var) {
        this.f9501fe = c2Var;
    }

    public l0 ad() throws IOException {
        int i2;
        int i3;
        if (!this.qw.isEmpty()) {
            ArrayList<l0> arrayList = this.f9499ad;
            ArrayList<l0> arrayList2 = this.qw;
            ArrayList<l0> arrayList3 = new ArrayList<>();
            int i4 = 1;
            while (true) {
                int i5 = this.f9500de;
                i4 *= i5;
                int size = arrayList2.size();
                int i6 = this.f9500de;
                int i7 = size % i6;
                if (i7 != 0) {
                    i6 = i7;
                }
                for (int i8 = 0; i8 < arrayList.size(); i8++) {
                    if (i8 == arrayList.size() - 1) {
                        i3 = this.qw.size() % i4;
                        if (i3 == 0) {
                            i3 = i4;
                        }
                        i2 = i6;
                    } else {
                        i3 = i4;
                        i2 = i5;
                    }
                    x xVar = new x(s0.K3);
                    xVar.h(s0.a0, new v0(i3));
                    k kVar = new k();
                    int i9 = i8 * i5;
                    kVar.b().addAll(arrayList2.subList(i9, i2 + i9));
                    xVar.h(s0.u2, kVar);
                    if (arrayList.size() > 1) {
                        if (i8 % this.f9500de == 0) {
                            arrayList3.add(this.f9501fe.M());
                        }
                        xVar.h(s0.O3, arrayList3.get(i8 / this.f9500de));
                    }
                    this.f9501fe.tt(xVar, arrayList.get(i8));
                }
                if (arrayList.size() == 1) {
                    l0 l0Var = arrayList.get(0);
                    this.f9502rg = l0Var;
                    return l0Var;
                }
                arrayList2 = arrayList;
                arrayList = arrayList3;
                arrayList3 = new ArrayList<>();
            }
        } else {
            throw new IOException(qw.ad("the.document.has.no.pages", new Object[0]));
        }
    }

    public void qw(x xVar) {
        try {
            if (this.qw.size() % this.f9500de == 0) {
                this.f9499ad.add(this.f9501fe.M());
            }
            xVar.h(s0.O3, this.f9499ad.get(this.f9499ad.size() - 1));
            l0 t = this.f9501fe.t();
            this.f9501fe.tt(xVar, t);
            this.qw.add(t);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }
}
