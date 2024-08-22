package fe.fe.ddd.p001switch.p002if;

import fe.fe.ddd.p001switch.p002if.ad;
import fe.fe.ddd.p001switch.qw;
import okhttp3.RequestBody;

/* renamed from: fe.fe.ddd.switch.if.ad  reason: invalid package */
public abstract class ad<T extends ad> extends rg<T> {
    public RequestBody tt;

    public ad(qw qwVar) {
        super(qwVar);
    }

    public T i(RequestBody requestBody) {
        this.tt = requestBody;
        return this;
    }
}
