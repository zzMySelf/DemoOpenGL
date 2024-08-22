package com.otaliastudios.cameraview.internal;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.otaliastudios.cameraview.CameraLogger;
import java.util.concurrent.LinkedBlockingQueue;

public class Pool<T> {

    /* renamed from: th  reason: collision with root package name */
    public static final CameraLogger f6762th = CameraLogger.qw(Pool.class.getSimpleName());

    /* renamed from: ad  reason: collision with root package name */
    public int f6763ad;

    /* renamed from: de  reason: collision with root package name */
    public LinkedBlockingQueue<T> f6764de;

    /* renamed from: fe  reason: collision with root package name */
    public Factory<T> f6765fe;
    public int qw;

    /* renamed from: rg  reason: collision with root package name */
    public final Object f6766rg = new Object();

    public interface Factory<T> {
        T qw();
    }

    public Pool(int i2, @NonNull Factory<T> factory) {
        this.qw = i2;
        this.f6764de = new LinkedBlockingQueue<>(i2);
        this.f6765fe = factory;
    }

    @CallSuper
    public void ad() {
        synchronized (this.f6766rg) {
            this.f6764de.clear();
        }
    }

    public final int de() {
        int qw2;
        synchronized (this.f6766rg) {
            qw2 = qw() + yj();
        }
        return qw2;
    }

    @Nullable
    public T fe() {
        synchronized (this.f6766rg) {
            T poll = this.f6764de.poll();
            if (poll != null) {
                this.f6763ad++;
                f6762th.uk("GET - Reusing recycled item.", this);
                return poll;
            } else if (rg()) {
                f6762th.uk("GET - Returning null. Too much items requested.", this);
                return null;
            } else {
                this.f6763ad++;
                f6762th.uk("GET - Creating a new item.", this);
                T qw2 = this.f6765fe.qw();
                return qw2;
            }
        }
    }

    public final int qw() {
        int i2;
        synchronized (this.f6766rg) {
            i2 = this.f6763ad;
        }
        return i2;
    }

    public boolean rg() {
        boolean z;
        synchronized (this.f6766rg) {
            z = de() >= this.qw;
        }
        return z;
    }

    public void th(@NonNull T t) {
        synchronized (this.f6766rg) {
            f6762th.uk("RECYCLE - Recycling item.", this);
            int i2 = this.f6763ad - 1;
            this.f6763ad = i2;
            if (i2 < 0) {
                throw new IllegalStateException("Trying to recycle an item which makes activeCount < 0. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. " + this);
            } else if (!this.f6764de.offer(t)) {
                throw new IllegalStateException("Trying to recycle an item while the queue is full. This means that this or some previous items being recycled were not coming from this pool, or some item was recycled more than once. " + this);
            }
        }
    }

    @NonNull
    public String toString() {
        return getClass().getSimpleName() + " - count:" + de() + ", active:" + qw() + ", recycled:" + yj();
    }

    public final int yj() {
        int size;
        synchronized (this.f6766rg) {
            size = this.f6764de.size();
        }
        return size;
    }
}
