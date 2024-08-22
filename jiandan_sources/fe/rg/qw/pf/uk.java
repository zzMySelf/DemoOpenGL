package fe.rg.qw.pf;

import androidx.annotation.NonNull;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.target.Target;
import fe.rg.qw.ggg.i;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class uk implements LifecycleListener {

    /* renamed from: ad  reason: collision with root package name */
    public final Set<Target<?>> f5017ad = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    public List<Target<?>> i() {
        return i.i(this.f5017ad);
    }

    public void o(@NonNull Target<?> target) {
        this.f5017ad.add(target);
    }

    public void onDestroy() {
        for (T onDestroy : i.i(this.f5017ad)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (T onStart : i.i(this.f5017ad)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : i.i(this.f5017ad)) {
            onStop.onStop();
        }
    }

    public void pf(@NonNull Target<?> target) {
        this.f5017ad.remove(target);
    }

    public void uk() {
        this.f5017ad.clear();
    }
}
