package com.baidu.android.util.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public final class ComponentUtils {
    public static final boolean DEBUG = false;
    public static final String TAG = "ComponentUtils";

    /* renamed from: com.baidu.android.util.android.ComponentUtils$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.android.util.android.ComponentUtils$ComponentType[] r0 = com.baidu.android.util.android.ComponentUtils.ComponentType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType = r0
                com.baidu.android.util.android.ComponentUtils$ComponentType r1 = com.baidu.android.util.android.ComponentUtils.ComponentType.RECEIVER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.android.util.android.ComponentUtils$ComponentType r1 = com.baidu.android.util.android.ComponentUtils.ComponentType.ACTIVITY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.android.util.android.ComponentUtils$ComponentType r1 = com.baidu.android.util.android.ComponentUtils.ComponentType.SERVICE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.android.util.android.ComponentUtils$ComponentType r1 = com.baidu.android.util.android.ComponentUtils.ComponentType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.android.util.android.ComponentUtils$ComponentType r1 = com.baidu.android.util.android.ComponentUtils.ComponentType.ALL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.android.ComponentUtils.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ComponentType {
        ALL,
        ACTIVITY,
        SERVICE,
        RECEIVER,
        PROVIDER
    }

    public static ComponentInfo getActivityInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getActivityInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public static ComponentInfo getComponentInfo(Context context, ComponentType componentType, ComponentName componentName) {
        int i2 = AnonymousClass1.$SwitchMap$com$baidu$android$util$android$ComponentUtils$ComponentType[componentType.ordinal()];
        if (i2 == 1) {
            return getReceiverInfo(context, componentName);
        }
        if (i2 == 2) {
            return getActivityInfo(context, componentName);
        }
        if (i2 == 3) {
            return getServiceInfo(context, componentName);
        }
        if (i2 == 4) {
            return getProviderInfo(context, componentName);
        }
        ComponentInfo receiverInfo = getReceiverInfo(context, componentName);
        if (receiverInfo == null) {
            receiverInfo = getActivityInfo(context, componentName);
        }
        if (receiverInfo == null) {
            receiverInfo = getServiceInfo(context, componentName);
        }
        if (receiverInfo == null) {
            return getProviderInfo(context, componentName);
        }
        return receiverInfo;
    }

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public static ComponentInfo getProviderInfo(Context context, ComponentName componentName) {
        if (Build.VERSION.SDK_INT >= 11) {
            try {
                return context.getPackageManager().getProviderInfo(componentName, 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return null;
    }

    public static ComponentInfo getReceiverInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getReceiverInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static ComponentInfo getServiceInfo(Context context, ComponentName componentName) {
        try {
            return context.getPackageManager().getServiceInfo(componentName, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean isComponentEnabledSetting(Context context, ComponentName componentName) {
        return 1 == context.getPackageManager().getComponentEnabledSetting(componentName);
    }

    public static boolean isComponetEnable(Context context, ComponentType componentType, ComponentName componentName) {
        ComponentInfo componentInfo = getComponentInfo(context, componentType, componentName);
        if (componentInfo != null) {
            return componentInfo.enabled;
        }
        return false;
    }

    public static void setComponentEnabledSetting(Context context, ComponentType componentType, ComponentName componentName, boolean z) {
        boolean isComponetEnable = isComponetEnable(context, componentType, componentName);
        if (z) {
            if (!isComponetEnable) {
                context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
            }
        } else if (isComponetEnable) {
            context.getPackageManager().setComponentEnabledSetting(componentName, 2, 1);
        }
    }
}
