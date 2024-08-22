package de.qw.ad;

import android.net.Uri;
import androidx.browser.trusted.TrustedWebActivityServiceConnectionPool;

/* compiled from: lambda */
public final /* synthetic */ class de implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool f1165ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ Uri f1166th;

    public /* synthetic */ de(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.f1165ad = trustedWebActivityServiceConnectionPool;
        this.f1166th = uri;
    }

    public final void run() {
        this.f1165ad.qw(this.f1166th);
    }
}
