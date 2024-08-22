package fe.rg.qw.ggg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class rg<T, Y> {

    /* renamed from: ad  reason: collision with root package name */
    public long f4679ad;

    /* renamed from: de  reason: collision with root package name */
    public long f4680de;
    public final Map<T, Y> qw = new LinkedHashMap(100, 0.75f, true);

    public rg(long j) {
        this.f4679ad = j;
    }

    public void ad() {
        m300switch(0);
    }

    public int i(@Nullable Y y) {
        return 1;
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public synchronized Y m299if(@NonNull T t) {
        Y remove;
        remove = this.qw.remove(t);
        if (remove != null) {
            this.f4680de -= (long) i(remove);
        }
        return remove;
    }

    public void o(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y pf(@NonNull T t, @Nullable Y y) {
        long i2 = (long) i(y);
        if (i2 >= this.f4679ad) {
            o(t, y);
            return null;
        }
        if (y != null) {
            this.f4680de += i2;
        }
        Y put = this.qw.put(t, y);
        if (put != null) {
            this.f4680de -= (long) i(put);
            if (!put.equals(y)) {
                o(t, put);
            }
        }
        th();
        return put;
    }

    /* renamed from: switch  reason: not valid java name */
    public synchronized void m300switch(long j) {
        while (this.f4680de > j) {
            Iterator<Map.Entry<T, Y>> it = this.qw.entrySet().iterator();
            Map.Entry next = it.next();
            Object value = next.getValue();
            this.f4680de -= (long) i(value);
            Object key = next.getKey();
            it.remove();
            o(key, value);
        }
    }

    public final void th() {
        m300switch(this.f4679ad);
    }

    public synchronized long uk() {
        return this.f4679ad;
    }

    @Nullable
    public synchronized Y yj(@NonNull T t) {
        return this.qw.get(t);
    }
}
