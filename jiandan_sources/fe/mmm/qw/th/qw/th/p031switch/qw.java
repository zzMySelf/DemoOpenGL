package fe.mmm.qw.th.qw.th.p031switch;

import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;

/* renamed from: fe.mmm.qw.th.qw.th.switch.qw  reason: invalid package */
/* compiled from: lambda */
public final /* synthetic */ class qw implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ WeakReference f8363ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ LiveData f8364th;

    public /* synthetic */ qw(WeakReference weakReference, LiveData liveData) {
        this.f8363ad = weakReference;
        this.f8364th = liveData;
    }

    public final void run() {
        ad.ad(this.f8363ad, this.f8364th);
    }
}
