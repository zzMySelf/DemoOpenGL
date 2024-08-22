package de.qw.qw;

import android.os.IBinder;
import androidx.browser.customtabs.CustomTabsService;
import androidx.browser.customtabs.CustomTabsSessionToken;

/* compiled from: lambda */
public final /* synthetic */ class qw implements IBinder.DeathRecipient {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ CustomTabsSessionToken f1167ad;
    public final /* synthetic */ CustomTabsService.AnonymousClass1 qw;

    public /* synthetic */ qw(CustomTabsService.AnonymousClass1 r1, CustomTabsSessionToken customTabsSessionToken) {
        this.qw = r1;
        this.f1167ad = customTabsSessionToken;
    }

    public final void binderDied() {
        this.qw.qw(this.f1167ad);
    }
}
