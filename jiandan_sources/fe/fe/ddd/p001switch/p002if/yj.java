package fe.fe.ddd.p001switch.p002if;

import okhttp3.Request;
import okhttp3.RequestBody;

/* renamed from: fe.fe.ddd.switch.if.yj  reason: invalid package */
public class yj extends qw<qw> {

    /* renamed from: fe.fe.ddd.switch.if.yj$qw */
    public static class qw extends ad<qw> {
        public qw(fe.fe.ddd.p001switch.qw qwVar) {
            super(qwVar);
        }

        /* renamed from: o */
        public yj ad() {
            return new yj(this);
        }
    }

    public yj(qw qwVar) {
        super(qwVar);
    }

    public Request ad(RequestBody requestBody) {
        return this.f33if.post(requestBody).build();
    }
}
