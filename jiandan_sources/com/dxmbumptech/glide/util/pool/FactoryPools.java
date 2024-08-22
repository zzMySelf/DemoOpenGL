package com.dxmbumptech.glide.util.pool;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

public final class FactoryPools {
    public static final Resetter<Object> qw = new qw();

    public interface Factory<T> {
        T qw();
    }

    public interface Poolable {
        @NonNull
        fe.uk.qw.vvv.pf.ad fe();
    }

    public interface Resetter<T> {
        void qw(@NonNull T t);
    }

    public class ad implements Factory<List<T>> {
        @NonNull
        /* renamed from: ad */
        public List<T> qw() {
            return new ArrayList();
        }
    }

    public class de implements Resetter<List<T>> {
        /* renamed from: ad */
        public void qw(@NonNull List<T> list) {
            list.clear();
        }
    }

    public static final class fe<T> implements Pools.Pool<T> {

        /* renamed from: ad  reason: collision with root package name */
        public final Resetter<T> f3948ad;

        /* renamed from: de  reason: collision with root package name */
        public final Pools.Pool<T> f3949de;
        public final Factory<T> qw;

        public fe(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
            this.f3949de = pool;
            this.qw = factory;
            this.f3948ad = resetter;
        }

        public T acquire() {
            T acquire = this.f3949de.acquire();
            if (acquire == null) {
                acquire = this.qw.qw();
                if (Log.isLoggable("FactoryPools", 2)) {
                    "Created new " + acquire.getClass();
                }
            }
            if (acquire instanceof Poolable) {
                ((Poolable) acquire).fe().ad(false);
            }
            return acquire;
        }

        public boolean release(@NonNull T t) {
            if (t instanceof Poolable) {
                ((Poolable) t).fe().ad(true);
            }
            this.f3948ad.qw(t);
            return this.f3949de.release(t);
        }
    }

    public class qw implements Resetter<Object> {
        public void qw(@NonNull Object obj) {
        }
    }

    @NonNull
    public static <T> Pools.Pool<T> ad(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory, @NonNull Resetter<T> resetter) {
        return new fe(pool, factory, resetter);
    }

    @NonNull
    public static <T> Resetter<T> de() {
        return qw;
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> fe(int i2, @NonNull Factory<T> factory) {
        return qw(new Pools.SynchronizedPool(i2), factory);
    }

    @NonNull
    public static <T extends Poolable> Pools.Pool<T> qw(@NonNull Pools.Pool<T> pool, @NonNull Factory<T> factory) {
        return ad(pool, factory, de());
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> rg() {
        return th(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> th(int i2) {
        return ad(new Pools.SynchronizedPool(i2), new ad(), new de());
    }
}
