package com.baidu.android.util.devices;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.IDevices;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.dxmpay.apollon.utils.PhoneUtils;
import fe.fe.ddd.i.qw.qw;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class DeviceUtils implements IDevices {

    public static final class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PREFIX_FEATURES = "features";
        public static final String PREFIX_PROCESSOR = "processor";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_X86 = "x86";
        public static IDevices.ARCH sArch = IDevices.ARCH.Unknown;
        public static CPUInfo systemCPUInfo;
        public String features = "";
        public String processor = "";

        /* JADX WARNING: Removed duplicated region for block: B:38:0x006a A[SYNTHETIC, Splitter:B:38:0x006a] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0076 A[SYNTHETIC, Splitter:B:45:0x0076] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x007e A[SYNTHETIC, Splitter:B:49:0x007e] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:42:0x0071=Splitter:B:42:0x0071, B:35:0x0065=Splitter:B:35:0x0065} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static synchronized com.baidu.android.util.devices.IDevices.ARCH getCpuArch() {
            /*
                java.lang.Class<com.baidu.android.util.devices.DeviceUtils$CPUInfo> r0 = com.baidu.android.util.devices.DeviceUtils.CPUInfo.class
                monitor-enter(r0)
                r1 = 20
                byte[] r1 = new byte[r1]     // Catch:{ all -> 0x008b }
                java.io.File r2 = new java.io.File     // Catch:{ all -> 0x008b }
                java.io.File r3 = android.os.Environment.getRootDirectory()     // Catch:{ all -> 0x008b }
                java.lang.String r4 = "lib/libc.so"
                r2.<init>(r3, r4)     // Catch:{ all -> 0x008b }
                boolean r3 = r2.canRead()     // Catch:{ all -> 0x008b }
                if (r3 == 0) goto L_0x0087
                r3 = 0
                java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x0064 }
                java.lang.String r5 = "r"
                r4.<init>(r2, r5)     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x0064 }
                r4.readFully(r1)     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                r2 = 19
                byte r2 = r1[r2]     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                r3 = 8
                int r2 = r2 << r3
                r5 = 18
                byte r1 = r1[r5]     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                r1 = r1 | r2
                r2 = 3
                if (r1 == r2) goto L_0x004c
                if (r1 == r3) goto L_0x0047
                r2 = 40
                if (r1 == r2) goto L_0x0042
                r2 = 183(0xb7, float:2.56E-43)
                if (r1 == r2) goto L_0x003d
                goto L_0x0050
            L_0x003d:
                com.baidu.android.util.devices.IDevices$ARCH r1 = com.baidu.android.util.devices.IDevices.ARCH.ARM64     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                sArch = r1     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                goto L_0x0050
            L_0x0042:
                com.baidu.android.util.devices.IDevices$ARCH r1 = com.baidu.android.util.devices.IDevices.ARCH.ARM     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                sArch = r1     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                goto L_0x0050
            L_0x0047:
                com.baidu.android.util.devices.IDevices$ARCH r1 = com.baidu.android.util.devices.IDevices.ARCH.MIPS     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                sArch = r1     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                goto L_0x0050
            L_0x004c:
                com.baidu.android.util.devices.IDevices$ARCH r1 = com.baidu.android.util.devices.IDevices.ARCH.X86     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
                sArch = r1     // Catch:{ FileNotFoundException -> 0x005f, IOException -> 0x005c, all -> 0x0059 }
            L_0x0050:
                r4.close()     // Catch:{ IOException -> 0x0054 }
                goto L_0x0087
            L_0x0054:
                r1 = move-exception
            L_0x0055:
                r1.printStackTrace()     // Catch:{ all -> 0x008b }
                goto L_0x0087
            L_0x0059:
                r1 = move-exception
                r3 = r4
                goto L_0x007c
            L_0x005c:
                r1 = move-exception
                r3 = r4
                goto L_0x0065
            L_0x005f:
                r1 = move-exception
                r3 = r4
                goto L_0x0071
            L_0x0062:
                r1 = move-exception
                goto L_0x007c
            L_0x0064:
                r1 = move-exception
            L_0x0065:
                r1.printStackTrace()     // Catch:{ all -> 0x0062 }
                if (r3 == 0) goto L_0x0087
                r3.close()     // Catch:{ IOException -> 0x006e }
                goto L_0x0087
            L_0x006e:
                r1 = move-exception
                goto L_0x0055
            L_0x0070:
                r1 = move-exception
            L_0x0071:
                r1.printStackTrace()     // Catch:{ all -> 0x0062 }
                if (r3 == 0) goto L_0x0087
                r3.close()     // Catch:{ IOException -> 0x007a }
                goto L_0x0087
            L_0x007a:
                r1 = move-exception
                goto L_0x0055
            L_0x007c:
                if (r3 == 0) goto L_0x0086
                r3.close()     // Catch:{ IOException -> 0x0082 }
                goto L_0x0086
            L_0x0082:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ all -> 0x008b }
            L_0x0086:
                throw r1     // Catch:{ all -> 0x008b }
            L_0x0087:
                com.baidu.android.util.devices.IDevices$ARCH r1 = sArch     // Catch:{ all -> 0x008b }
                monitor-exit(r0)
                return r1
            L_0x008b:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.devices.DeviceUtils.CPUInfo.getCpuArch():com.baidu.android.util.devices.IDevices$ARCH");
        }

        public static String getCpuArchInfo() {
            String lowerCase = System.getProperty("os.arch").toLowerCase(Locale.getDefault());
            if (lowerCase == null || lowerCase.length() == 0) {
                return null;
            }
            return lowerCase;
        }

        public static String getPreferredABI() {
            if (OSInfo.hasLollipop()) {
                String[] strArr = Build.SUPPORTED_64_BIT_ABIS;
                if (strArr != null && strArr.length > 0) {
                    return strArr[0];
                }
                String[] strArr2 = Build.SUPPORTED_32_BIT_ABIS;
                if (strArr2 != null && strArr2.length > 0) {
                    return strArr2[0];
                }
            }
            return Build.CPU_ABI;
        }

        public static String[] getSupportedABIs() {
            if (Build.VERSION.SDK_INT >= 21) {
                return Build.SUPPORTED_ABIS;
            }
            ArrayList arrayList = new ArrayList(Arrays.asList(new String[]{Build.CPU_ABI, Build.CPU_ABI2}));
            arrayList.removeAll(Arrays.asList(new String[]{null, ""}));
            return (String[]) arrayList.toArray(new String[0]);
        }

        public static CPUInfo getSystemCPUInfo() {
            CPUInfo cPUInfo = systemCPUInfo;
            if (cPUInfo != null) {
                return cPUInfo;
            }
            CPUInfo cPUInfo2 = new CPUInfo();
            try {
                FileReader fileReader = new FileReader("/proc/cpuinfo");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    String lowerCase = readLine.trim().toLowerCase(Locale.getDefault());
                    if (lowerCase.startsWith("processor")) {
                        if (lowerCase.indexOf(":", 9) != -1) {
                            if (cPUInfo2.processor.length() > 0) {
                                cPUInfo2.processor += "__";
                            }
                            cPUInfo2.processor += lowerCase.split(":")[1].trim();
                        }
                    }
                    if (lowerCase.startsWith("features") && lowerCase.indexOf(":", 8) != -1) {
                        if (cPUInfo2.features.length() > 0) {
                            cPUInfo2.features += "__";
                        }
                        cPUInfo2.features += lowerCase.split(":")[1].trim();
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
                cPUInfo2.processor = "x86";
            }
            systemCPUInfo = cPUInfo2;
            return cPUInfo2;
        }

        public static boolean isARMSimulatedByX86() {
            return !supportX86() && IDevices.ARCH.X86.equals(getCpuArch());
        }

        public static boolean isRealARMArch() {
            return (supportABI(PhoneUtils.CPU_API_ARM_V7A) || supportABI("armeabi")) && IDevices.ARCH.ARM.equals(getCpuArch());
        }

        public static boolean isRealX86Arch() {
            return supportABI("x86") || IDevices.ARCH.X86.equals(getCpuArch());
        }

        public static boolean supportABI(String str) {
            for (String equalsIgnoreCase : getSupportedABIs()) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean supportMips() {
            return supportABI(IDevices.ABI_MIPS);
        }

        public static boolean supportX86() {
            return supportABI("x86");
        }
    }

    public static class OSInfo {
        public static String getOS() {
            return "Android";
        }

        public static String getOsVersion() {
            String str = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str)) {
                return "0.0";
            }
            return str.replace("_", "-");
        }

        public static int getSDKLevel() {
            return Build.VERSION.SDK_INT;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasFroyo() {
            return Build.VERSION.SDK_INT >= 8;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasGingerbread() {
            return Build.VERSION.SDK_INT >= 9;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasHoneycomb() {
            return Build.VERSION.SDK_INT >= 11;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasHoneycombMR1() {
            return Build.VERSION.SDK_INT >= 12;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasICS() {
            return Build.VERSION.SDK_INT >= 14;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean hasICSMR1() {
            return Build.VERSION.SDK_INT >= 15;
        }

        public static boolean hasJellyBean() {
            return Build.VERSION.SDK_INT >= 16;
        }

        public static boolean hasJellyBeanMR1() {
            return Build.VERSION.SDK_INT >= 17;
        }

        public static boolean hasJellyBeanMR2() {
            return Build.VERSION.SDK_INT >= 18;
        }

        public static boolean hasKitKat() {
            return Build.VERSION.SDK_INT >= 19;
        }

        public static boolean hasLollipop() {
            return Build.VERSION.SDK_INT >= 21;
        }

        public static boolean hasLollipopMR1() {
            return Build.VERSION.SDK_INT >= 22;
        }

        public static boolean hasMarshMallow() {
            return Build.VERSION.SDK_INT >= 23;
        }

        public static boolean hasNougat() {
            return Build.VERSION.SDK_INT >= 24;
        }

        public static boolean hasNougatMR1() {
            return Build.VERSION.SDK_INT >= 25;
        }

        public static boolean hasOreo() {
            return Build.VERSION.SDK_INT >= 26;
        }

        public static boolean hasOreoMR1() {
            return Build.VERSION.SDK_INT >= 27;
        }

        public static boolean hasPie() {
            return Build.VERSION.SDK_INT >= 28;
        }

        public static boolean hasQ() {
            return Build.VERSION.SDK_INT >= 29;
        }

        public static boolean hasTiramisu() {
            return Build.VERSION.SDK_INT >= 33;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean isGingerbread() {
            return Build.VERSION.SDK_INT == 9;
        }

        @SuppressLint({"ObsoleteSdkInt"})
        public static boolean isGingerbreadmr1() {
            return Build.VERSION.SDK_INT == 10;
        }

        public static boolean isKitKat() {
            return Build.VERSION.SDK_INT == 19;
        }

        public static final boolean isLollipop() {
            return Build.VERSION.SDK_INT == 21;
        }
    }

    public static class ScreenInfo {
        public static final int STANDARD_STATUSBAR_HEIGHT = 50;
        public static int originDensityDip;
        public static DisplayMetrics sDisplayMetrics;

        public static int dp2px(@Nullable Context context, float f) {
            if (context == null) {
                return 0;
            }
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static float dp2pxf(@Nullable Context context, float f) {
            return f * getDensity(context);
        }

        public static float getDensity(@Nullable Context context) {
            initDisplayMetrics(context);
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }

        public static int getDensityDpi(@Nullable Context context) {
            initDisplayMetrics(context);
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public static int getDisplayHeight(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(context);
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public static DisplayMetrics getDisplayMetrics(Context context) {
            if (context == null) {
                return null;
            }
            return context.getResources().getDisplayMetrics();
        }

        public static int getDisplayWidth(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(context);
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public static int getNavigationBarHeight() {
            boolean hasPermanentMenuKey = ViewConfiguration.get(qw.qw()).hasPermanentMenuKey();
            boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
            if (hasPermanentMenuKey || deviceHasKey) {
                return 0;
            }
            Resources resources = qw.qw().getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE));
        }

        public static int getRealScreenHeight(@Nullable Context context) {
            if (context == null) {
                return 0;
            }
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return -1;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (!OSInfo.hasJellyBeanMR1()) {
                return getDisplayHeight(context);
            }
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        }

        public static int[] getRealScreenSize(@Nullable Context context) {
            int[] iArr = new int[2];
            int displayWidth = getDisplayWidth(context);
            int realScreenHeight = getRealScreenHeight(context);
            if (displayWidth > 0 && realScreenHeight > 0) {
                iArr[0] = displayWidth;
                iArr[1] = realScreenHeight;
            }
            return iArr;
        }

        @SuppressLint({"PrivateApi"})
        public static int getScreenOriginDensityDip() {
            int i2 = originDensityDip;
            if (i2 > 0) {
                return i2;
            }
            try {
                Object invoke = Class.forName("android.view.WindowManagerGlobal").getMethod("getWindowManagerService", new Class[0]).invoke(new Object(), new Object[0]);
                originDensityDip = ((Integer) Class.forName("android.view.IWindowManager").getMethod("getInitialDisplayDensity", new Class[]{Integer.TYPE}).invoke(invoke, new Object[]{0})).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return originDensityDip;
        }

        public static int getStatusBarHeight() {
            int identifier = qw.qw().getResources().getIdentifier("status_bar_height", ResUtils.f719i, SapiDeviceInfo.OS_TYPE);
            int i2 = 0;
            if (identifier > 0) {
                try {
                    i2 = qw.qw().getResources().getDimensionPixelSize(identifier);
                } catch (Exception unused) {
                }
            }
            return i2 == 0 ? (int) (getDensity((Context) null) * 25.0f) : i2;
        }

        public static void initDisplayMetrics(Context context) {
            if (sDisplayMetrics == null && context != null) {
                sDisplayMetrics = context.getResources().getDisplayMetrics();
            }
        }

        public static boolean isDensityTooLarge(Activity activity) {
            int screenOriginDensityDip;
            if (Build.VERSION.SDK_INT < 24 || activity == null || (screenOriginDensityDip = getScreenOriginDensityDip()) <= 0 || activity.isInMultiWindowMode()) {
                return false;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.density > ((float) screenOriginDensityDip) / 160.0f) {
                return true;
            }
            return false;
        }

        public static boolean isScreenLand() {
            return qw.qw().getResources().getConfiguration().orientation == 2;
        }

        public static boolean isScreenPortrait() {
            return qw.qw().getResources().getConfiguration().orientation == 1;
        }

        public static int px2dp(@Nullable Context context, float f) {
            if (context == null) {
                return 0;
            }
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static float px2dpFloat(@Nullable Context context, float f) {
            return f / getDensity(context);
        }
    }

    @SuppressLint({"PrivateApi"})
    public static String getHarmonyVersion() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"hw_sc.build.os.version"});
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static boolean isHarmonyOS(Context context) {
        try {
            int identifier = Resources.getSystem().getIdentifier("config_os_brand", ResUtils.b, SapiDeviceInfo.OS_TYPE);
            if (identifier != 0) {
                return context.getString(identifier).equals("harmony");
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isSupportPreviewWhenClipCopy() {
        return false;
    }
}
