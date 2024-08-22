package th.qw.ad.ad;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

/* compiled from: lambda */
public final /* synthetic */ class qw implements View.OnFocusChangeListener {

    /* renamed from: ad  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f11052ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f11053th;

    public /* synthetic */ qw(PlatformViewsController.AnonymousClass1 r1, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f11052ad = r1;
        this.f11053th = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z) {
        this.f11052ad.qw(this.f11053th, view, z);
    }
}
