package com.baidu.map.poipage.utils;

import android.app.Activity;
import android.content.Context;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.talos.core.container.InitProps;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0004\u001a\u00020\u0005H\u0007J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0006\u0010\r\u001a\u00020\u000bJ\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0012\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/map/poipage/utils/DisplayUtil;", "", "()V", "displayType", "deviceType", "", "hideFloatInDisplayOutside", "", "context", "Landroid/content/Context;", "isFlipDevice", "", "isFoldableDevice", "isOuterDevice", "isOuterScreen", "activity", "Landroid/app/Activity;", "showFloatInDisplayOutside", "willNotStartInDisplayOutside", "willStartInDisplayOutside", "poi_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DisplayUtil.kt */
public final class DisplayUtil {
    public static final DisplayUtil INSTANCE = new DisplayUtil();
    private static Object displayType;

    private DisplayUtil() {
    }

    public final boolean isOuterDevice() {
        return isFlipDevice() && isOuterScreen(BdBoxActivityManager.getTopActivity());
    }

    @JvmStatic
    public static final String deviceType() {
        return "vivo";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.getApplicationContext();
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void willStartInDisplayOutside(android.content.Context r2) {
        /*
            if (r2 == 0) goto L_0x000f
            android.content.Context r0 = r2.getApplicationContext()
            if (r0 == 0) goto L_0x000f
            java.lang.String r1 = "audio"
            java.lang.Object r0 = r0.getSystemService(r1)
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            if (r0 == 0) goto L_0x001b
            java.lang.String r1 = "vivo_continue_display=true"
            r0.setParameters(r1)
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.map.poipage.utils.DisplayUtil.willStartInDisplayOutside(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.getApplicationContext();
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void willNotStartInDisplayOutside(android.content.Context r2) {
        /*
            if (r2 == 0) goto L_0x000f
            android.content.Context r0 = r2.getApplicationContext()
            if (r0 == 0) goto L_0x000f
            java.lang.String r1 = "audio"
            java.lang.Object r0 = r0.getSystemService(r1)
            goto L_0x0010
        L_0x000f:
            r0 = 0
        L_0x0010:
            android.media.AudioManager r0 = (android.media.AudioManager) r0
            if (r0 == 0) goto L_0x001b
            java.lang.String r1 = "vivo_continue_display=false"
            r0.setParameters(r1)
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.map.poipage.utils.DisplayUtil.willNotStartInDisplayOutside(android.content.Context):void");
    }

    @JvmStatic
    public static final void showFloatInDisplayOutside(Context context) {
    }

    @JvmStatic
    public static final void hideFloatInDisplayOutside(Context context) {
    }

    @JvmStatic
    public static final boolean isFoldableDevice() {
        Object obj = displayType;
        if (obj != null) {
            return Intrinsics.areEqual((Object) InitProps.KEY_FOLDABLE, obj);
        }
        try {
            Class c2 = Class.forName("android.util.FtDeviceInfo");
            Method m = c2.getMethod("getDeviceType", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(m, "c.getMethod(\"getDeviceType\")");
            Object invoke = m.invoke(c2, new Object[0]);
            displayType = invoke;
            return Intrinsics.areEqual((Object) InitProps.KEY_FOLDABLE, invoke);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @JvmStatic
    public static final boolean isFlipDevice() {
        Object obj = displayType;
        if (obj != null) {
            return Intrinsics.areEqual((Object) "flip", obj);
        }
        try {
            Class c2 = Class.forName("android.util.FtDeviceInfo");
            Method m = c2.getMethod("getDeviceType", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(m, "c.getMethod(\"getDeviceType\")");
            Object invoke = m.invoke(c2, new Object[0]);
            displayType = invoke;
            return Intrinsics.areEqual((Object) "flip", invoke);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @JvmStatic
    public static final boolean isOuterScreen(Activity activity) {
        if (activity == null) {
            return false;
        }
        Activity activity2 = activity;
        if (activity.getWindow().getWindowManager().getDefaultDisplay().getDisplayId() == 1) {
            return true;
        }
        return false;
    }
}
