package fe.uk.qw.pf.de;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.load.data.DataRewinder;
import fe.uk.qw.vvv.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class fe {

    /* renamed from: ad  reason: collision with root package name */
    public static final DataRewinder.Factory<?> f5692ad = new qw();
    public final Map<Class<?>, DataRewinder.Factory<?>> qw = new HashMap();

    public static final class ad implements DataRewinder<Object> {
        public final Object qw;

        public ad(@NonNull Object obj) {
            this.qw = obj;
        }

        public void ad() {
        }

        @NonNull
        public Object qw() {
            return this.qw;
        }
    }

    public class qw implements DataRewinder.Factory<Object> {
        @NonNull
        public DataRewinder<Object> ad(@NonNull Object obj) {
            return new ad(obj);
        }

        @NonNull
        public Class<Object> qw() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    public synchronized void ad(@NonNull DataRewinder.Factory<?> factory) {
        this.qw.put(factory.qw(), factory);
    }

    @NonNull
    public synchronized <T> DataRewinder<T> qw(@NonNull T t) {
        DataRewinder.Factory<?> factory;
        i.fe(t);
        factory = this.qw.get(t.getClass());
        if (factory == null) {
            Iterator<DataRewinder.Factory<?>> it = this.qw.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataRewinder.Factory<?> next = it.next();
                if (next.qw().isAssignableFrom(t.getClass())) {
                    factory = next;
                    break;
                }
            }
        }
        if (factory == null) {
            factory = f5692ad;
        }
        return factory.ad(t);
    }
}
