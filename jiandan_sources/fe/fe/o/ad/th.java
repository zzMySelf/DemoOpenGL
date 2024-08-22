package fe.fe.o.ad;

import android.content.Context;
import fe.fe.o.th.i;
import java.util.ArrayList;
import java.util.List;

public class th {

    /* renamed from: ad  reason: collision with root package name */
    public String f2461ad;

    /* renamed from: de  reason: collision with root package name */
    public long f2462de;

    /* renamed from: fe  reason: collision with root package name */
    public int f2463fe;
    public boolean qw = false;

    /* renamed from: rg  reason: collision with root package name */
    public long f2464rg;

    /* renamed from: th  reason: collision with root package name */
    public List f2465th;

    public List ad() {
        return this.f2465th;
    }

    public void de(yj yjVar) {
        if (!this.f2465th.contains(yjVar)) {
            this.f2465th.add(yjVar);
        }
    }

    public void fe(boolean z) {
        this.qw = z;
        this.f2465th = new ArrayList();
        this.f2464rg = System.currentTimeMillis();
    }

    public String qw(Context context) {
        return i.qw(context).fe() + this.f2461ad + this.f2462de + System.currentTimeMillis();
    }
}
