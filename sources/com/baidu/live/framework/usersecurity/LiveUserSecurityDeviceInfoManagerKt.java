package com.baidu.live.framework.usersecurity;

import com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\u0012\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u001a\u0012\u0010\n\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u001a\u0006\u0010\u000b\u001a\u00020\f\"#\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00018BX\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\r"}, d2 = {"service", "Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "kotlin.jvm.PlatformType", "getService", "()Lcom/baidu/searchbox/live/interfaces/service/LiveUserSecurityDeviceInfoService;", "service$delegate", "Lkotlin/Lazy;", "getManufacturer", "", "purpose", "getModel", "isDeviceInfoServiceAvailable", "", "lib-live-feed-page_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveUserSecurityDeviceInfoManager.kt */
public final class LiveUserSecurityDeviceInfoManagerKt {
    private static final Lazy service$delegate = LazyKt.lazy(LiveUserSecurityDeviceInfoManagerKt$service$2.INSTANCE);

    private static final LiveUserSecurityDeviceInfoService getService() {
        return (LiveUserSecurityDeviceInfoService) service$delegate.getValue();
    }

    public static final boolean isDeviceInfoServiceAvailable() {
        return getService() != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getModel(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getModel(java.lang.String r1) {
        /*
            com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService r0 = getService()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.getModel(r1)
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.framework.usersecurity.LiveUserSecurityDeviceInfoManagerKt.getModel(java.lang.String):java.lang.String");
    }

    public static /* synthetic */ String getModel$default(String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return getModel(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getManufacturer(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getManufacturer(java.lang.String r1) {
        /*
            com.baidu.searchbox.live.interfaces.service.LiveUserSecurityDeviceInfoService r0 = getService()
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.getManufacturer(r1)
            if (r0 != 0) goto L_0x000e
        L_0x000c:
            java.lang.String r0 = ""
        L_0x000e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.live.framework.usersecurity.LiveUserSecurityDeviceInfoManagerKt.getManufacturer(java.lang.String):java.lang.String");
    }

    public static /* synthetic */ String getManufacturer$default(String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return getManufacturer(str);
    }
}
