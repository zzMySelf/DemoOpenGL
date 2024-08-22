package fe.uk.qw.p021if;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.request.Request;
import fe.uk.qw.vvv.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: fe.uk.qw.if.pf  reason: invalid package */
public class pf {

    /* renamed from: ad  reason: collision with root package name */
    public final List<Request> f5647ad = new ArrayList();

    /* renamed from: de  reason: collision with root package name */
    public boolean f5648de;
    public final Set<Request> qw = Collections.newSetFromMap(new WeakHashMap());

    public void ad() {
        for (T qw2 : o.i(this.qw)) {
            qw(qw2);
        }
        this.f5647ad.clear();
    }

    public void de() {
        this.f5648de = true;
        for (T t : o.i(this.qw)) {
            if (t.isRunning() || t.isComplete()) {
                t.clear();
                this.f5647ad.add(t);
            }
        }
    }

    public void fe() {
        this.f5648de = true;
        for (T t : o.i(this.qw)) {
            if (t.isRunning()) {
                t.pause();
                this.f5647ad.add(t);
            }
        }
    }

    public boolean qw(@Nullable Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.qw.remove(request);
        if (!this.f5647ad.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public void rg() {
        for (T t : o.i(this.qw)) {
            if (!t.isComplete() && !t.de()) {
                t.clear();
                if (!this.f5648de) {
                    t.begin();
                } else {
                    this.f5647ad.add(t);
                }
            }
        }
    }

    public void th() {
        this.f5648de = false;
        for (T t : o.i(this.qw)) {
            if (!t.isComplete() && !t.isRunning()) {
                t.begin();
            }
        }
        this.f5647ad.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.qw.size() + ", isPaused=" + this.f5648de + "}";
    }

    public void yj(@NonNull Request request) {
        this.qw.add(request);
        if (!this.f5648de) {
            request.begin();
            return;
        }
        request.clear();
        boolean isLoggable = Log.isLoggable("RequestTracker", 2);
        this.f5647ad.add(request);
    }
}
