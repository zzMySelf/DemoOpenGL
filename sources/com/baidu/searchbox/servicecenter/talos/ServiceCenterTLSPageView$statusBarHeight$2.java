package com.baidu.searchbox.servicecenter.talos;

import com.baidu.android.util.devices.DeviceUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ServiceCenterTLSPageView.kt */
final class ServiceCenterTLSPageView$statusBarHeight$2 extends Lambda implements Function0<Integer> {
    public static final ServiceCenterTLSPageView$statusBarHeight$2 INSTANCE = new ServiceCenterTLSPageView$statusBarHeight$2();

    ServiceCenterTLSPageView$statusBarHeight$2() {
        super(0);
    }

    public final Integer invoke() {
        return Integer.valueOf(DeviceUtil.ScreenInfo.getStatusBarHeight());
    }
}
