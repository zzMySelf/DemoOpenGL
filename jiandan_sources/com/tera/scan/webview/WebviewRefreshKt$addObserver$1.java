package com.tera.scan.webview;

import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.ubc.UBCManager;
import com.mars.kotlin.extension.LoggerKt;
import fe.mmm.qw.m.ggg.ad.ad;
import fe.mmm.qw.m.ggg.ad.fe;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"com/tera/scan/webview/WebviewRefreshKt$addObserver$1", "Landroidx/lifecycle/LifecycleEventObserver;", "firstOnResume", "", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lib-webview_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebviewRefreshKt$addObserver$1 implements LifecycleEventObserver {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f7477ad;

    /* renamed from: th  reason: collision with root package name */
    public final /* synthetic */ WebView f7478th;

    public /* synthetic */ class qw {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, UBCManager.CONTENT_KEY_SOURCE);
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        if (qw.$EnumSwitchMapping$0[event.ordinal()] != 1) {
            return;
        }
        if (this.f7477ad) {
            this.f7477ad = false;
            LoggerKt.d("on resumen first", "injectWebRefresh");
            return;
        }
        LoggerKt.d("on resumen callback", "injectWebRefresh");
        fe.qw(this.f7478th, new ad("refreshActivity", 1, "", new JSONObject()));
    }
}
