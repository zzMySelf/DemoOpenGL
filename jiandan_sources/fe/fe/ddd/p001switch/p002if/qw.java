package fe.fe.ddd.p001switch.p002if;

import fe.fe.ddd.p001switch.p002if.ad;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* renamed from: fe.fe.ddd.switch.if.qw  reason: invalid package */
public abstract class qw<T extends ad> extends fe<T> {
    public RequestBody g;

    public qw(T t) {
        super(t);
    }

    public RequestBody de() {
        RequestBody requestBody = this.g;
        if (requestBody != null) {
            return requestBody;
        }
        return RequestBody.create((MediaType) null, new byte[0]);
    }

    /* renamed from: vvv */
    public void when(T t) {
        this.g = t.tt;
    }
}
