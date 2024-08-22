package fe.ggg.ad.qw.de.th;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ LiveData f7584ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Observer f7585th;

    public /* synthetic */ ad(LiveData liveData, Observer observer) {
        this.f7584ad = liveData;
        this.f7585th = observer;
    }

    public final void run() {
        rg.ad(this.f7584ad, this.f7585th);
    }
}
