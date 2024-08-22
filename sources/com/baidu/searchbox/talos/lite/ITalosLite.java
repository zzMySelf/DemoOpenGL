package com.baidu.searchbox.talos.lite;

import android.app.Activity;
import android.content.Context;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J*\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/talos/lite/ITalosLite;", "Lcom/baidu/searchbox/NoProGuard;", "canIUse", "", "capabilityName", "", "createTalosLiteContainer", "Lcom/baidu/searchbox/talos/lite/ITalosLiteContainer;", "businessName", "activity", "Landroid/app/Activity;", "talosLiteParams", "Lcom/baidu/searchbox/talos/lite/TalosLiteRenderParams;", "width", "", "destroyTalosLiteView", "", "rootViewTag", "", "getCommonParams", "Lorg/json/JSONObject;", "context", "Landroid/content/Context;", "Companion", "lib-talos-lite-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ITalosLite.kt */
public interface ITalosLite extends NoProGuard {
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean canIUse(String str);

    ITalosLiteContainer createTalosLiteContainer(String str, Activity activity, TalosLiteRenderParams talosLiteRenderParams, int i2);

    void destroyTalosLiteView(String str, long j2);

    JSONObject getCommonParams(Context context);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ITalosLite.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ ITalosLiteContainer createTalosLiteContainer$default(ITalosLite iTalosLite, String str, Activity activity, TalosLiteRenderParams talosLiteRenderParams, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    i2 = DeviceUtils.ScreenInfo.getDisplayWidth(activity);
                }
                return iTalosLite.createTalosLiteContainer(str, activity, talosLiteRenderParams, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTalosLiteContainer");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/talos/lite/ITalosLite$Companion;", "Lcom/baidu/searchbox/NoProGuard;", "()V", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "lib-talos-lite-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ITalosLite.kt */
    public static final class Companion implements NoProGuard {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ServiceReference SERVICE_REFERENCE = new ServiceReference("talos", ITalosLiteKt.TALOS_LITE_SERVICE_NAME);

        private Companion() {
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }
}
