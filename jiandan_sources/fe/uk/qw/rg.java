package fe.uk.qw;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class rg {
    public final Map<Class<?>, Object> qw;

    public static final class qw {
        public final Map<Class<?>, Object> qw = new HashMap();

        public rg ad() {
            return new rg(this);
        }
    }

    public rg(qw qwVar) {
        this.qw = Collections.unmodifiableMap(new HashMap(qwVar.qw));
    }

    public boolean qw(Class<? extends Object> cls) {
        return this.qw.containsKey(cls);
    }
}
