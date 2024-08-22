package fe.rg.qw.pf;

import androidx.annotation.NonNull;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import fe.rg.qw.ggg.i;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class qw implements Lifecycle {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f5015ad;

    /* renamed from: de  reason: collision with root package name */
    public boolean f5016de;
    public final Set<LifecycleListener> qw = Collections.newSetFromMap(new WeakHashMap());

    public void ad(@NonNull LifecycleListener lifecycleListener) {
        this.qw.add(lifecycleListener);
        if (this.f5016de) {
            lifecycleListener.onDestroy();
        } else if (this.f5015ad) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    public void de() {
        this.f5016de = true;
        for (T onDestroy : i.i(this.qw)) {
            onDestroy.onDestroy();
        }
    }

    public void fe() {
        this.f5015ad = true;
        for (T onStart : i.i(this.qw)) {
            onStart.onStart();
        }
    }

    public void qw(@NonNull LifecycleListener lifecycleListener) {
        this.qw.remove(lifecycleListener);
    }

    public void rg() {
        this.f5015ad = false;
        for (T onStop : i.i(this.qw)) {
            onStop.onStop();
        }
    }
}
