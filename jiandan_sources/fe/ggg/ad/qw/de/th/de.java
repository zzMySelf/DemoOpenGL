package fe.ggg.ad.qw.de.th;

import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;

/* compiled from: lambda */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ WeakReference f7586ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ LiveData f7587th;

    public /* synthetic */ de(WeakReference weakReference, LiveData liveData) {
        this.f7586ad = weakReference;
        this.f7587th = liveData;
    }

    public final void run() {
        rg.fe(this.f7586ad, this.f7587th);
    }
}
