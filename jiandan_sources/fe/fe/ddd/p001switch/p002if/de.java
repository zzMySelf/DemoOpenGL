package fe.fe.ddd.p001switch.p002if;

import fe.fe.ddd.p001switch.p002if.th;
import java.util.LinkedHashMap;

/* renamed from: fe.fe.ddd.switch.if.de  reason: invalid package */
public abstract class de<T extends th> extends fe<T> {
    public LinkedHashMap<String, String> g;

    public de(T t) {
        super(t);
    }

    /* renamed from: vvv */
    public void when(T t) {
        if (t.tt != null) {
            this.g = new LinkedHashMap<>(t.tt);
        }
    }
}
