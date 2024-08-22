package th.qw.de.qw;

import com.google.common.util.concurrent.SettableFuture;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import java.util.concurrent.Callable;

/* compiled from: lambda */
public final /* synthetic */ class th implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ SettableFuture f11060ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Callable f11061th;

    public /* synthetic */ th(SettableFuture settableFuture, Callable callable) {
        this.f11060ad = settableFuture;
        this.f11061th = callable;
    }

    public final void run() {
        PathProviderPlugin.qw(this.f11060ad, this.f11061th);
    }
}
