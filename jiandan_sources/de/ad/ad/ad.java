package de.ad.ad;

import androidx.core.widget.ContentLoadingProgressBar;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f1160ad;

    public /* synthetic */ ad(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f1160ad = contentLoadingProgressBar;
    }

    public final void run() {
        this.f1160ad.showOnUiThread();
    }
}
