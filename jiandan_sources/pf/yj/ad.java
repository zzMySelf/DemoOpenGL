package pf.yj;

import java.util.concurrent.ThreadFactory;
import okhttp3.internal.Util;

/* compiled from: lambda */
public final /* synthetic */ class ad implements ThreadFactory {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ String f11370ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ boolean f11371th;

    public /* synthetic */ ad(String str, boolean z) {
        this.f11370ad = str;
        this.f11371th = z;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.qw(this.f11370ad, this.f11371th, runnable);
    }
}
