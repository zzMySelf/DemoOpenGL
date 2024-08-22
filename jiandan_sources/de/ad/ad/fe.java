package de.ad.ad;

import androidx.core.widget.ContentLoadingProgressBar;

/* compiled from: lambda */
public final /* synthetic */ class fe implements Runnable {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f1162ad;

    public /* synthetic */ fe(ContentLoadingProgressBar contentLoadingProgressBar) {
        this.f1162ad = contentLoadingProgressBar;
    }

    public final void run() {
        this.f1162ad.hideOnUiThread();
    }
}
