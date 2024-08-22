package th.qw.qw.ad.fe;

import android.content.Context;
import android.os.Handler;
import io.flutter.embedding.engine.loader.FlutterLoader;

/* compiled from: lambda */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ FlutterLoader f11079ad;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Runnable f11080i;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Context f11081th;

    /* renamed from: uk  reason: collision with root package name */
    public final /* synthetic */ Handler f11082uk;

    /* renamed from: yj  reason: collision with root package name */
    public final /* synthetic */ String[] f11083yj;

    public /* synthetic */ de(FlutterLoader flutterLoader, Context context, String[] strArr, Handler handler, Runnable runnable) {
        this.f11079ad = flutterLoader;
        this.f11081th = context;
        this.f11083yj = strArr;
        this.f11082uk = handler;
        this.f11080i = runnable;
    }

    public final void run() {
        this.f11079ad.qw(this.f11081th, this.f11083yj, this.f11082uk, this.f11080i);
    }
}
