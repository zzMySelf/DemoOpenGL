package fe.uk.qw.p021if;

import androidx.annotation.NonNull;
import com.dxmbumptech.glide.manager.LifecycleListener;
import com.dxmbumptech.glide.request.target.Target;
import fe.uk.qw.vvv.o;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: fe.uk.qw.if.if  reason: invalid class name and invalid package */
public final class Cif implements LifecycleListener {

    /* renamed from: ad  reason: collision with root package name */
    public final Set<Target<?>> f5646ad = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    public List<Target<?>> i() {
        return o.i(this.f5646ad);
    }

    public void o(@NonNull Target<?> target) {
        this.f5646ad.add(target);
    }

    public void onDestroy() {
        for (T onDestroy : o.i(this.f5646ad)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (T onStart : o.i(this.f5646ad)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : o.i(this.f5646ad)) {
            onStop.onStop();
        }
    }

    public void pf(@NonNull Target<?> target) {
        this.f5646ad.remove(target);
    }

    public void uk() {
        this.f5646ad.clear();
    }
}
