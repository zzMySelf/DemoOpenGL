package th.qw.de.qw;

import io.flutter.plugins.pathprovider.PathProviderPlugin;
import java.util.concurrent.Callable;

/* compiled from: lambda */
public final /* synthetic */ class de implements Callable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PathProviderPlugin f11055ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ String f11056th;

    public /* synthetic */ de(PathProviderPlugin pathProviderPlugin, String str) {
        this.f11055ad = pathProviderPlugin;
        this.f11056th = str;
    }

    public final Object call() {
        return this.f11055ad.th(this.f11056th);
    }
}
