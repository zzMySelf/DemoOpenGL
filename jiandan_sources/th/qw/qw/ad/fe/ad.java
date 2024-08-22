package th.qw.qw.ad.fe;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f11074ad;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Runnable f11075i;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Context f11076th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ Handler f11077uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ String[] f11078yj;

    public /* synthetic */ ad(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f11074ad = flutterLoader;
        this.f11076th = context;
        this.f11078yj = strArr;
        this.f11077uk = handler;
        this.f11075i = runnable;
    }

    public final void run() {
        this.f11074ad.ad(this.f11076th, this.f11078yj, this.f11077uk, this.f11075i);
    }
}
