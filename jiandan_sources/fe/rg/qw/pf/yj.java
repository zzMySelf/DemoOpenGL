package fe.rg.qw.pf;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import fe.rg.qw.ggg.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class yj {

    /* renamed from: ad  reason: collision with root package name */
    public final List<Request> f5018ad = new ArrayList();

    /* renamed from: de  reason: collision with root package name */
    public boolean f5019de;
    public final Set<Request> qw = Collections.newSetFromMap(new WeakHashMap());

    public boolean ad(@Nullable Request request) {
        return qw(request, true);
    }

    public void de() {
        for (T qw2 : i.i(this.qw)) {
            qw(qw2, false);
        }
        this.f5018ad.clear();
    }

    public void fe() {
        this.f5019de = true;
        for (T t : i.i(this.qw)) {
            if (t.isRunning()) {
                t.clear();
                this.f5018ad.add(t);
            }
        }
    }

    public final boolean qw(@Nullable Request request, boolean z) {
        boolean z2 = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.qw.remove(request);
        if (!this.f5018ad.remove(request) && !remove) {
            z2 = false;
        }
        if (z2) {
            request.clear();
            if (z) {
                request.recycle();
            }
        }
        return z2;
    }

    public void rg() {
        for (T t : i.i(this.qw)) {
            if (!t.isComplete() && !t.de()) {
                t.clear();
                if (!this.f5019de) {
                    t.begin();
                } else {
                    this.f5018ad.add(t);
                }
            }
        }
    }

    public void th() {
        this.f5019de = false;
        for (T t : i.i(this.qw)) {
            if (!t.isComplete() && !t.isRunning()) {
                t.begin();
            }
        }
        this.f5018ad.clear();
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.qw.size() + ", isPaused=" + this.f5019de + "}";
    }

    public void yj(@NonNull Request request) {
        this.qw.add(request);
        if (!this.f5019de) {
            request.begin();
            return;
        }
        request.clear();
        boolean isLoggable = Log.isLoggable("RequestTracker", 2);
        this.f5018ad.add(request);
    }
}
