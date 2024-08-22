package fe.i.qw.ad;

import com.dxmpay.apollon.eventbus.EventBus;
import java.lang.reflect.Method;

public final class yj {

    /* renamed from: ad  reason: collision with root package name */
    public final Method f4474ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f4475de;

    /* renamed from: fe  reason: collision with root package name */
    public final EventBus.ThreadMode f4476fe;
    public final Object qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile boolean f4477rg = true;

    public yj(Object obj, Method method, String str, int i2, EventBus.ThreadMode threadMode) {
        this.qw = obj;
        this.f4474ad = method;
        this.f4475de = i2;
        this.f4476fe = threadMode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof yj)) {
            return false;
        }
        yj yjVar = (yj) obj;
        if (this.qw != yjVar.qw || !this.f4474ad.equals(yjVar.f4474ad)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.qw.hashCode() + this.f4474ad.hashCode();
    }
}
