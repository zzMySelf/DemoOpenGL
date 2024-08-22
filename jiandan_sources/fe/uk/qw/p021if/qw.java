package fe.uk.qw.p021if;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.manager.Lifecycle;
import com.dxmbumptech.glide.manager.LifecycleListener;
import fe.uk.qw.vvv.o;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: fe.uk.qw.if.qw  reason: invalid package */
public class qw implements Lifecycle {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f5649ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f5650de;
    public final Set<LifecycleListener> qw = Collections.newSetFromMap(new WeakHashMap());

    public void ad(@NonNull LifecycleListener lifecycleListener) {
        this.qw.add(lifecycleListener);
        if (this.f5650de) {
            lifecycleListener.onDestroy();
        } else if (this.f5649ad) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void de() {
        this.f5650de = true;
        for (T onDestroy : o.i(this.qw)) {
            onDestroy.onDestroy();
        }
    }

    public void fe() {
        this.f5649ad = true;
        for (T onStart : o.i(this.qw)) {
            onStart.onStart();
        }
    }

    public void qw(@NonNull LifecycleListener lifecycleListener) {
        this.qw.remove(lifecycleListener);
    }

    public void rg() {
        this.f5649ad = false;
        for (T onStop : o.i(this.qw)) {
            onStop.onStop();
        }
    }
}
