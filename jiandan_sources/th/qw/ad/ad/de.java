package th.qw.ad.ad;

import android.view.View;
import io.flutter.plugin.platform.PlatformViewsController;

/* compiled from: lambda */
public final /* synthetic */ class de implements View.OnFocusChangeListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f11050ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ int f11051th;

    public /* synthetic */ de(PlatformViewsController platformViewsController, int i2) {
        this.f11050ad = platformViewsController;
        this.f11051th = i2;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f11050ad.qw(this.f11051th, view, z);
    }
}
