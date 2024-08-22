package com.dxmpay.apollon.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.IDevices;
import com.baidu.sapi2.SapiAccount;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.permission.PermissionManager;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class PhoneUtils {
    public static final String CPU_API_ARM_V7A = "armeabi-v7a";
    public static final String CPU_API_ARM_V8A = "arm64-v8a";

    /* renamed from: ad  reason: collision with root package name */
    public static ArrayList<String> f4086ad = new ArrayList<>();

    /* renamed from: de  reason: collision with root package name */
    public static final Pattern f4087de = Pattern.compile("((\\d|[A-F]){32}).*");

    /* renamed from: fe  reason: collision with root package name */
    public static final Pattern f4088fe = Pattern.compile("((\\d|[a-f]){32}).*");
    public static CPUInfo qw;

    /* renamed from: rg  reason: collision with root package name */
    public static final Pattern f4089rg = Pattern.compile("((\\d|[A-F]){32}).*(\\|.*)");

    /* renamed from: th  reason: collision with root package name */
    public static final Pattern f4090th = Pattern.compile("((\\d|[a-f]){32}).*(\\|.*)");

    public static class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_ARM_PREFIX = "armv";
        public String features = "";
        public String processor = "";

        public String getCpuPath() {
            if (this.processor.startsWith("armv7")) {
                return PhoneUtils.CPU_API_ARM_V7A;
            }
            if (this.processor.startsWith("armv")) {
                return "armeabi";
            }
            if (this.processor.equals("intel")) {
                return "x86";
            }
            return this.processor.equals(IDevices.ABI_MIPS) ? IDevices.ABI_MIPS : "";
        }
    }

    public class qw implements FileFilter {
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    static {
        f4086ad.add("card_no");
        f4086ad.add("valid_date");
        f4086ad.add("cvv2");
        f4086ad.add("identity_code");
        f4086ad.add("phone_number");
    }

    public static boolean ad() {
        Method declaredMethod;
        Object invoke;
        Method declaredMethod2;
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getRuntime", new Class[0])) == null || (invoke = declaredMethod.invoke((Object) null, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("is64Bit", new Class[0])) == null) {
                return false;
            }
            Object invoke2 = declaredMethod2.invoke(invoke, new Object[0]);
            if (invoke2 instanceof Boolean) {
                return ((Boolean) invoke2).booleanValue();
            }
            return false;
        } catch (Throwable th2) {
            LogUtil.e(com.baidu.apollon.utils.PhoneUtils.e, th2.getMessage(), th2);
        }
    }

    public static void checkPermission(Context context, String str) {
        if (!hasPermission(context, str)) {
            sdkError("You need the " + str + " permission. Open AndroidManifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />");
        }
    }

    public static String encrypt(String str, String str2) {
        LogUtil.d(str + "加密=" + str2);
        if (!f4086ad.contains(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String encryptProxy = SecurePay.getInstance().encryptProxy(str2);
        LogUtil.d(str + "加密=" + encryptProxy);
        return encryptProxy;
    }

    public static int getAppVersionCode(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            LogUtil.w(com.baidu.apollon.utils.PhoneUtils.e, "get app version code exception");
            return 1;
        }
    }

    public static String getAppVersionName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            LogUtil.w(com.baidu.apollon.utils.PhoneUtils.e, "get app version name exception");
            return "";
        }
    }

    public static ApplicationInfo getApplicationInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getApplicationName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY)).getMemoryInfo(memoryInfo);
        return Formatter.formatFileSize(context, memoryInfo.availMem) + "_" + memoryInfo.lowMemory + "_" + Formatter.formatFileSize(context, memoryInfo.threshold);
    }

    public static String getCUID(Context context) {
        return qw(context);
    }

    public static String getCUID2(Context context) {
        String str;
        String cuid = DeviceId.getCUID(context);
        String str2 = null;
        if (cuid == null) {
            return null;
        }
        Matcher matcher = f4089rg.matcher(cuid);
        if (matcher.matches()) {
            str2 = matcher.group(1) + matcher.group(3);
        }
        if (str2 != null) {
            return str2;
        }
        Matcher matcher2 = f4090th.matcher(cuid);
        if (matcher2.matches()) {
            str = matcher2.group(1) + matcher2.group(3);
        } else {
            str = "";
        }
        return str;
    }

    public static String getCpuAbi() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 23 ? Process.is64Bit() ? CPU_API_ARM_V8A : CPU_API_ARM_V7A : (i2 >= 21 && ad()) ? CPU_API_ARM_V8A : CPU_API_ARM_V7A;
    }

    public static String getGPSLocation(Context context) {
        return "";
    }

    public static String getIpInfo() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress()) {
                        byte[] address = nextElement.getAddress();
                        if (address.length == 4) {
                            byte b = ((address[3] & 255) << Ascii.CAN) | ((address[2] & 255) << Ascii.DLE) | ((address[1] & 255) << 8) | (address[0] & 255);
                            str = (b & 255) + IStringUtil.CURRENT_PATH + ((b >> 8) & 255) + IStringUtil.CURRENT_PATH + ((b >> Ascii.DLE) & 255) + IStringUtil.CURRENT_PATH + ((b >> Ascii.CAN) & 255);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogUtil.d(com.baidu.apollon.utils.PhoneUtils.e, "getIpInfo fail!" + e.toString());
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getLinkedWay(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String typeName = activeNetworkInfo.getTypeName();
            return (typeName.equals("WIFI") || activeNetworkInfo.getSubtypeName() == null) ? typeName : activeNetworkInfo.getSubtypeName();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c A[SYNTHETIC, Splitter:B:27:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c A[SYNTHETIC, Splitter:B:36:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLocalMacAddress() {
        /*
            java.lang.String r0 = "PhoneUtils"
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 20
            r3 = 0
            char[] r4 = new char[r2]     // Catch:{ Exception -> 0x0069, all -> 0x0059 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0069, all -> 0x0059 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0069, all -> 0x0059 }
            java.lang.String r7 = "/sys/class/net/eth0/address"
            r6.<init>(r7)     // Catch:{ Exception -> 0x0069, all -> 0x0059 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x0069, all -> 0x0059 }
        L_0x0018:
            int r6 = r5.read(r4)     // Catch:{ Exception -> 0x006a, all -> 0x0056 }
            r7 = -1
            if (r6 == r7) goto L_0x0039
            r7 = 13
            if (r6 != r2) goto L_0x002a
            r8 = 19
            char r8 = r4[r8]     // Catch:{ Exception -> 0x006a, all -> 0x0056 }
            if (r8 == r7) goto L_0x002a
            goto L_0x0018
        L_0x002a:
            r8 = 0
        L_0x002b:
            if (r8 >= r6) goto L_0x0018
            char r9 = r4[r8]     // Catch:{ Exception -> 0x006a, all -> 0x0056 }
            if (r9 == r7) goto L_0x0036
            char r9 = r4[r8]     // Catch:{ Exception -> 0x006a, all -> 0x0056 }
            r1.append(r9)     // Catch:{ Exception -> 0x006a, all -> 0x0056 }
        L_0x0036:
            int r8 = r8 + 1
            goto L_0x002b
        L_0x0039:
            r5.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0045
        L_0x003d:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r3, r2)
        L_0x0045:
            java.lang.String r0 = r1.toString()
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = ":"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replaceAll(r1, r2)
            return r0
        L_0x0056:
            r1 = move-exception
            r3 = r5
            goto L_0x005a
        L_0x0059:
            r1 = move-exception
        L_0x005a:
            if (r3 == 0) goto L_0x0068
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0068
        L_0x0060:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r3, r2)
        L_0x0068:
            throw r1
        L_0x0069:
            r5 = r3
        L_0x006a:
            if (r5 == 0) goto L_0x0078
            r5.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x0078
        L_0x0070:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            com.dxmpay.apollon.utils.LogUtil.e(r0, r2, r1)
        L_0x0078:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dxmpay.apollon.utils.PhoneUtils.getLocalMacAddress():java.lang.String");
    }

    public static String getMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null) {
                return "";
            }
            Object obj = null;
            Bundle bundle = applicationInfo.metaData;
            if (bundle != null) {
                obj = bundle.get(str);
            }
            if (obj == null) {
                LogUtil.d("StatSDK", "null,can't find information for key:" + str);
                return "";
            }
            String obj2 = obj.toString();
            if (obj2.trim().equals("")) {
                LogUtil.w(com.baidu.apollon.utils.PhoneUtils.e, "APP Key值为空||The value of APP Key is empty.");
            }
            return obj2;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.e(com.baidu.apollon.utils.PhoneUtils.e, "exception is " + e, e);
            return "";
        }
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new qw());
            LogUtil.d(com.baidu.apollon.utils.PhoneUtils.e, "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e) {
            LogUtil.d(com.baidu.apollon.utils.PhoneUtils.e, "CPU Count: Failed.");
            LogUtil.e(com.baidu.apollon.utils.PhoneUtils.e, e.getMessage(), e);
            return 1;
        }
    }

    public static CPUInfo getSystemCPUInfo() {
        CPUInfo cPUInfo = qw;
        if (cPUInfo != null) {
            return cPUInfo;
        }
        CPUInfo cPUInfo2 = new CPUInfo();
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                String lowerCase = readLine.trim().toLowerCase(Locale.ENGLISH);
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
            LogUtil.e(com.baidu.apollon.utils.PhoneUtils.e, e.getMessage(), e);
        } catch (IOException e2) {
            LogUtil.e(com.baidu.apollon.utils.PhoneUtils.e, e2.getMessage(), e2);
        }
        qw = cPUInfo2;
        return cPUInfo2;
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static String getTotalMemory(Context context) {
        long j = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String readLine = bufferedReader.readLine();
            String[] split = readLine.split("\\s+");
            for (String str : split) {
                LogUtil.i(readLine, str + "\t");
            }
            j = Long.valueOf(split[1]).longValue() * 1024;
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return Formatter.formatFileSize(context, j);
    }

    public static String getWCPParams(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wime", "");
            jSONObject.put("cuid_1", encrypt("phone_number", getCUID(context)));
            jSONObject.put("cuid_2", encrypt("phone_number", getCUID2(context)));
            LogUtil.d("NetworkType", "NetworkType:" + NetworkUtils.getNetworkType(context));
            jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
            jSONObject.put("wloc", encrypt("phone_number", getGPSLocation(context)));
            return new String(Base64Utils.encode(jSONObject.toString().getBytes()));
        } catch (JSONException e) {
            LogUtil.e(com.baidu.apollon.utils.PhoneUtils.e, e.getMessage(), e);
            return "";
        }
    }

    public static boolean hasPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        return PermissionManager.checkCallingPermission(context, str);
    }

    public static boolean isIntentAvailable(Context context, Intent intent) {
        if (context.getPackageManager().queryIntentActivities(intent, 1).size() > 0) {
            return true;
        }
        return false;
    }

    public static String qw(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        String str = null;
        if (deviceID == null) {
            return null;
        }
        Matcher matcher = f4087de.matcher(deviceID);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (str != null) {
            return str;
        }
        Matcher matcher2 = f4088fe.matcher(deviceID);
        return matcher2.matches() ? matcher2.group(1) : "";
    }

    public static void sdkError(String str) {
        LogUtil.w(com.baidu.apollon.utils.PhoneUtils.e, str);
        LogUtil.w(com.baidu.apollon.utils.PhoneUtils.e, "SDK install error:" + str);
    }

    @TargetApi(9)
    public static void showInstalledAppOrDetails(Context context, String str) {
        Intent intent = new Intent();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 9) {
            String str2 = i2 == 8 ? SapiAccount.ExtraProperty.EXTRA_PKG : "com.android.settings.ApplicationPkgName";
            intent.setAction("android.intent.action.VIEW");
            if (!TextUtils.isEmpty(str)) {
                intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                intent.putExtra(str2, str);
            } else {
                intent.setClassName("com.android.settings", "com.android.settings.ManageApplications");
            }
        } else if (!TextUtils.isEmpty(str)) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", str, (String) null));
        } else {
            intent.setAction("android.settings.MANAGE_APPLICATIONS_SETTINGS");
        }
        if (isIntentAvailable(context, intent)) {
            context.startActivity(intent);
        }
    }
}
