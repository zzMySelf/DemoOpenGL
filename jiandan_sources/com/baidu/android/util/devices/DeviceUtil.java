package com.baidu.android.util.devices;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.android.util.devices.IDevices;
import com.dxmpay.apollon.utils.PhoneUtils;
import fe.fe.ddd.i.qw.qw;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Locale;

@Deprecated
public class DeviceUtil implements IDevices {

    public static class BrandInfo {
        public static String getDeviceBrand() {
            return RomUtils.getDeviceBrand();
        }

        public static String getDeviceModel() {
            return RomUtils.getDeviceModel();
        }

        public static String getDeviceName() {
            return RomUtils.getDeviceName();
        }

        public static String getManufacturer() {
            return RomUtils.getManufacturer();
        }

        public static boolean isMagicBoxDevice() {
            return RomUtils.isMagicBoxDevice();
        }

        public static boolean isMiBox2Device() {
            return RomUtils.isMiBox2Device();
        }

        @Deprecated
        public static boolean isProblemBoxDevice() {
            return isMiBox2Device() || isMagicBoxDevice();
        }
    }

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

        public static String getCpuArchInfo() {
            return DeviceUtils.CPUInfo.getCpuArchInfo();
        }

        public static synchronized IDevices.ARCH getMyCpuArch() {
            IDevices.ARCH cpuArch;
            synchronized (CPUInfo.class) {
                cpuArch = DeviceUtils.CPUInfo.getCpuArch();
            }
            return cpuArch;
        }

        public static String getPreferredABI() {
            return DeviceUtils.CPUInfo.getPreferredABI();
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

        @Deprecated
        public static String get_CPU_ABI() {
            return Build.CPU_ABI;
        }

        @Deprecated
        public static String get_CPU_ABI2() {
            try {
                Field declaredField = Build.class.getDeclaredField("CPU_ABI2");
                if (declaredField == null) {
                    return null;
                }
                Object obj = declaredField.get((Object) null);
                if (!(obj instanceof String)) {
                    return null;
                }
                return (String) obj;
            } catch (Exception unused) {
                return null;
            }
        }

        public static boolean isARMSimulatedByX86() {
            return !supportX86() && IDevices.ARCH.X86.equals(getMyCpuArch());
        }

        public static boolean isRealARMArch() {
            return (supportABI(PhoneUtils.CPU_API_ARM_V7A) || supportABI("armeabi")) && IDevices.ARCH.ARM.equals(getMyCpuArch());
        }

        public static boolean isRealX86Arch() {
            return supportABI("x86") || IDevices.ARCH.X86.equals(getMyCpuArch());
        }

        public static boolean supportABI(String str) {
            String _cpu_abi = get_CPU_ABI();
            if (!TextUtils.isEmpty(_cpu_abi) && _cpu_abi.equalsIgnoreCase(str)) {
                return true;
            }
            if (TextUtils.isEmpty(get_CPU_ABI2()) || !_cpu_abi.equalsIgnoreCase(str)) {
                return false;
            }
            return true;
        }

        public static boolean supportMips() {
            return supportABI(IDevices.ABI_MIPS);
        }

        public static boolean supportX86() {
            return supportABI("x86");
        }
    }

    public static class OSInfo {
        public static final int KITKAT = 19;
        public static final int LOLLIPOP = 21;
        public static final int LOLLIPOP_MR1 = 22;
        public static final int MARSHMALLOW = 23;
        public static final int Nougat = 24;
        public static final int NougatPlus = 25;

        public static String getOS() {
            return "Android";
        }

        public static String getOsVersion() {
            return DeviceUtils.OSInfo.getOsVersion();
        }

        public static int getSDKLevel() {
            return DeviceUtils.OSInfo.getSDKLevel();
        }

        public static boolean hasFroyo() {
            return DeviceUtils.OSInfo.hasFroyo();
        }

        public static boolean hasGingerbread() {
            return DeviceUtils.OSInfo.hasGingerbread();
        }

        public static boolean hasHoneycomb() {
            return DeviceUtils.OSInfo.hasHoneycomb();
        }

        public static boolean hasHoneycombMR1() {
            return DeviceUtils.OSInfo.hasHoneycombMR1();
        }

        public static boolean hasICS() {
            return DeviceUtils.OSInfo.hasICS();
        }

        public static boolean hasICSMR1() {
            return DeviceUtils.OSInfo.hasICSMR1();
        }

        public static boolean hasJellyBean() {
            return DeviceUtils.OSInfo.hasJellyBean();
        }

        public static boolean hasJellyBeanMR1() {
            return DeviceUtils.OSInfo.hasJellyBeanMR1();
        }

        public static boolean hasJellyBeanMR2() {
            return DeviceUtils.OSInfo.hasJellyBeanMR2();
        }

        public static boolean hasKitKat() {
            return DeviceUtils.OSInfo.hasKitKat();
        }

        public static boolean hasLollipop() {
            return DeviceUtils.OSInfo.hasLollipop();
        }

        public static boolean hasLollipopMR1() {
            return DeviceUtils.OSInfo.hasLollipopMR1();
        }

        public static boolean hasMarshMallow() {
            return DeviceUtils.OSInfo.hasMarshMallow();
        }

        public static boolean hasNougat() {
            return DeviceUtils.OSInfo.hasNougat();
        }

        public static boolean hasNougatMR1() {
            return DeviceUtils.OSInfo.hasNougatMR1();
        }

        public static boolean hasOreo() {
            return DeviceUtils.OSInfo.hasOreo();
        }

        public static boolean isGingerbread() {
            return DeviceUtils.OSInfo.isGingerbread();
        }

        public static boolean isGingerbreadmr1() {
            return DeviceUtils.OSInfo.isGingerbreadmr1();
        }

        public static boolean isKitKat() {
            return DeviceUtils.OSInfo.isKitKat();
        }

        public static final boolean isLollipop() {
            return DeviceUtils.OSInfo.isLollipop();
        }
    }

    public static class ScreenInfo {
        public static final int STANDARD_STATUSBAR_HEIGHT = 50;
        public static int originDensityDip;
        public static DisplayMetrics sDisplayMetrics;

        public static int dp2px(@Nullable Context context, float f) {
            return (int) ((f * qw.qw().getResources().getDisplayMetrics().density) + 0.5f);
        }

        public static float dp2pxf(@Nullable Context context, float f) {
            return f * getDensity(qw.qw());
        }

        public static float getDensity(@Nullable Context context) {
            initDisplayMetrics(qw.qw());
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.density;
            }
            return 0.0f;
        }

        public static int getDensityDpi(@Nullable Context context) {
            initDisplayMetrics(qw.qw());
            DisplayMetrics displayMetrics = sDisplayMetrics;
            if (displayMetrics != null) {
                return displayMetrics.densityDpi;
            }
            return 0;
        }

        public static int getDisplayHeight(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(qw.qw());
            if (displayMetrics != null) {
                return displayMetrics.heightPixels;
            }
            return 0;
        }

        public static DisplayMetrics getDisplayMetrics(Context context) {
            Context qw = qw.qw();
            if (qw == null) {
                return null;
            }
            return qw.getResources().getDisplayMetrics();
        }

        public static int getDisplayWidth(@Nullable Context context) {
            DisplayMetrics displayMetrics = getDisplayMetrics(qw.qw());
            if (displayMetrics != null) {
                return displayMetrics.widthPixels;
            }
            return 0;
        }

        public static int getNavigationBarHeight() {
            return DeviceUtils.ScreenInfo.getNavigationBarHeight();
        }

        public static int getRealScreenHeight(@Nullable Context context) {
            WindowManager windowManager = (WindowManager) qw.qw().getSystemService("window");
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

        @Deprecated
        public static String getRealScreenSize(@Nullable Context context) {
            int displayWidth = getDisplayWidth(context);
            int realScreenHeight = getRealScreenHeight(context);
            if (displayWidth <= 0 || realScreenHeight <= 0) {
                return "";
            }
            return displayWidth + "_" + realScreenHeight;
        }

        public static int getScreenOriginDensityDip() {
            return DeviceUtils.ScreenInfo.getScreenOriginDensityDip();
        }

        public static int getStatusBarHeight() {
            return DeviceUtils.ScreenInfo.getStatusBarHeight();
        }

        public static void initDisplayMetrics(Context context) {
            Context qw = qw.qw();
            if (sDisplayMetrics == null) {
                if (qw != null) {
                    context = qw;
                }
                if (context != null) {
                    sDisplayMetrics = context.getResources().getDisplayMetrics();
                }
            }
        }

        public static boolean isDensityTooLarge(Activity activity) {
            return DeviceUtils.ScreenInfo.isDensityTooLarge(activity);
        }

        public static boolean isScreenLand() {
            return DeviceUtils.ScreenInfo.isScreenLand();
        }

        public static boolean isScreenPortrait() {
            return DeviceUtils.ScreenInfo.isScreenPortrait();
        }

        public static int px2dp(@Nullable Context context, float f) {
            return (int) ((f / qw.qw().getResources().getDisplayMetrics().density) + 0.5f);
        }

        @Deprecated
        public static float px2dpFloat(float f) {
            return f / getDensity(qw.qw());
        }
    }

    public static String getSamsungFeature(String str) {
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.SemFloatingFeature");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
            return (String) cls.getDeclaredMethod("getString", new Class[]{String.class}).invoke(invoke, new Object[]{str});
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean isHonorFoldableDevice() {
        if (!"HONOR".equalsIgnoreCase(Build.MANUFACTURER) || !qw.qw().getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture")) {
            return isHonorSpecifiedDevice();
        }
        return true;
    }

    public static boolean isHonorSpecifiedDevice() {
        return "HONOR".equalsIgnoreCase(Build.MANUFACTURER) && "HNMGI".equalsIgnoreCase(Build.DEVICE) && ("DIA-AN00".equalsIgnoreCase(Build.MODEL) || "MGI-AN00".equalsIgnoreCase(Build.MODEL));
    }

    public static boolean isHwFoldableDevice() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) && qw.qw().getPackageManager().hasSystemFeature("com.huawei.hardware.sensor.posture");
    }

    public static boolean isInMagicWindow(Context context) {
        if (context == null) {
            return false;
        }
        String configuration = context.getResources().getConfiguration().toString();
        if (TextUtils.isEmpty(configuration)) {
            return false;
        }
        return configuration.contains("hw-magic-windows");
    }

    public static boolean isMateX() {
        String[] strArr = {"RLI-AN00", "RLI-N29", "TAH-AN00", "TAH-N29", "TAH-AN00m", "RHA-AN00m", "TET-AN00"};
        if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
            for (int i2 = 0; i2 < 7; i2++) {
                if (strArr[i2].equalsIgnoreCase(Build.MODEL)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isOppoFoldableDevice() {
        return qw.qw().getPackageManager().hasSystemFeature("oplus.feature.largescreen") || qw.qw().getPackageManager().hasSystemFeature("oplus.feature.largescreen.land");
    }

    public static boolean isSamSungFoldDevice() {
        if (!TextUtils.isEmpty(Build.MODEL) && "SAMSUNG".equalsIgnoreCase(Build.MANUFACTURER)) {
            return TextUtils.equals(getSamsungFeature("SEC_FLOATING_FEATURE_FRAMEWORK_SUPPORT_FOLDABLE_TYPE_FOLD"), "TRUE");
        }
        return false;
    }

    public static boolean isSupportFoldable() {
        if (!isMateX() && !isHwFoldableDevice() && !isSamSungFoldDevice() && !isHonorFoldableDevice() && !isOppoFoldableDevice() && !isVIVOFoldableDevice()) {
            return false;
        }
        return true;
    }

    public static boolean isVIVOFoldableDevice() {
        if (!RomUtils.ROM_VIVO.equalsIgnoreCase(RomUtils.getManufacturer())) {
            return false;
        }
        try {
            return TextUtils.equals("foldable", (String) Class.forName("android.util.FtDeviceInfo").getMethod("getDeviceType", new Class[0]).invoke((Object) null, new Object[0]));
        } catch (Exception unused) {
            return false;
        }
    }
}
