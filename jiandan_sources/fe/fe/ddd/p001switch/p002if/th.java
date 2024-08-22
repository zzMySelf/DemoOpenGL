package fe.fe.ddd.p001switch.p002if;

import fe.fe.ddd.p001switch.p002if.th;
import fe.fe.ddd.p001switch.qw;
import java.util.LinkedHashMap;

/* renamed from: fe.fe.ddd.switch.if.th  reason: invalid package */
public abstract class th<T extends th> extends rg<T> {
    public LinkedHashMap<String, String> tt = new LinkedHashMap<>();

    public th(qw qwVar) {
        super(qwVar);
    }

    public T i(String str, String str2) {
        this.tt.put(str, str2);
        return this;
    }
}
