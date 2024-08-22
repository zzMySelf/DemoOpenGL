package com.baidu.apollon.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.text.format.Formatter;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserModel;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.util.devices.IDevices;
import com.baidu.apollon.ApollonConstants;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.apollon.restnet.http.b;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sofire.xclient.privacycontrol.lib.WifiInfoHelper;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.TimeModel;
import com.google.common.base.Ascii;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public final class PhoneUtils {
    public static final Pattern a = Pattern.compile("((\\d|[A-F]){32}).*");
    public static final Pattern b = Pattern.compile("((\\d|[a-f]){32}).*");
    public static final Pattern c = Pattern.compile("((\\d|[A-F]){32}).*(\\|.*)");
    public static final Pattern d = Pattern.compile("((\\d|[a-f]){32}).*(\\|.*)");
    public static final String e = "PhoneUtils";
    public static final String f = "_pay.preferences";
    public static final String g = "cuid_1";
    public static final String h = "cuid_2";

    /* renamed from: i  reason: collision with root package name */
    public static final String f717i = "wime";
    public static final String j = "identity_code";
    public static final String k = "phone_number";
    public static final String l = "card_no";
    public static final String m = "valid_date";
    public static final String n = "cvv2";

    /* renamed from: o  reason: collision with root package name */
    public static final String f718o = "imei";
    public static CPUInfo p = null;
    public static ArrayList<String> q = new ArrayList<>();
    public static final String r = "nettype";
    public static final String s = "wloc";
    public static String t = null;
    public static String u = null;
    public static String v = null;
    public static int w = 0;
    public static long x = -1;
    public static String y = "";
    public static final long z = 15000;

    public static class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_ARM_PREFIX = "armv";
        public static final String a = "processor";
        public static final String b = "features";
        public String features = "";
        public String processor = "";

        public String getCpuPath() {
            if (this.processor.startsWith("armv7")) {
                return com.dxmpay.apollon.utils.PhoneUtils.CPU_API_ARM_V7A;
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

    public class a implements FileFilter {
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    static {
        q.add("card_no");
        q.add("valid_date");
        q.add("cvv2");
        q.add("identity_code");
        q.add("phone_number");
    }

    public static String a(byte b2) {
        String str = ChipTextInputComboView.TextFormatter.DEFAULT_TEXT + Integer.toHexString(b2) + ":";
        return str.substring(str.length() - 3);
    }

    public static void checkPermission(Context context, String str) {
        if (!hasPermission(context, str)) {
            sdkError("You need the " + str + " permission. Open AndroidManifest.xml and just before the final </manifest> tag add:  <uses-permission android:name=\"" + str + "\" />");
        }
    }

    public static String encrypt(String str, String str2) {
        LogUtil.d(str + "加密=" + str2);
        if (!q.contains(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String encryptProxy = SafePay.getInstance().encryptProxy(str2);
        LogUtil.d(str + "加密=" + encryptProxy);
        return encryptProxy;
    }

    public static int getAppVersionCode(Context context) {
        if (context == null) {
            return 0;
        }
        int i2 = w;
        if (i2 != 0) {
            return i2;
        }
        try {
            int i3 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            w = i3;
            return i3;
        } catch (Throwable unused) {
            LogUtil.w(e, "get app version code exception");
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
            LogUtil.w(e, "get app version name exception");
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
        return a(context);
    }

    public static String getCUID2(Context context) {
        String str;
        String cuid = DeviceId.getCUID(context);
        String str2 = null;
        if (cuid == null) {
            return null;
        }
        Matcher matcher = c.matcher(cuid);
        if (matcher.matches()) {
            str2 = matcher.group(1) + matcher.group(3);
        }
        if (str2 != null) {
            return str2;
        }
        Matcher matcher2 = d.matcher(cuid);
        if (matcher2.matches()) {
            str = matcher2.group(1) + matcher2.group(3);
        } else {
            str = "";
        }
        return str;
    }

    public static String getCellLocation(Context context) {
        String format;
        CellLocation cellLocation;
        if (Build.VERSION.SDK_INT >= 29 || !PermissionManager.checkCallingPermission(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        format = String.format("%s_%s_%s", new Object[]{0, 0, 0});
        try {
            if ((!hasPermission(context, "android.permission.ACCESS_FINE_LOCATION") && !hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) || (cellLocation = ((TelephonyManager) context.getSystemService("phone")).getCellLocation()) == null) {
                return format;
            }
            if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                return String.format("%s_%s_%s", new Object[]{String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(gsmCellLocation.getCid())}), String.format(TimeModel.NUMBER_FORMAT, new Object[]{Integer.valueOf(gsmCellLocation.getLac())}), 0});
            }
            String[] split = cellLocation.toString().replace("[", "").replace("]", "").split(",");
            if (split.length <= 5) {
                return format;
            }
            return String.format("%s_%s_%s", new Object[]{split[0], split[3], split[4]});
        } catch (Exception e2) {
            "exception is " + e2;
        }
        return format;
    }

    public static String getGPSLocation(Context context) {
        if (!TextUtils.isEmpty(v)) {
            return v;
        }
        try {
            if (hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = ((LocationManager) context.getSystemService(b.c.j)).getLastKnownLocation("gps");
                LogUtil.d(e, "from system location: " + lastKnownLocation);
                if (lastKnownLocation != null) {
                    String format = String.format("%s:%s", new Object[]{Double.valueOf(lastKnownLocation.getLongitude()), Double.valueOf(lastKnownLocation.getLatitude())});
                    v = format;
                    return format;
                }
            } else {
                LogUtil.d(e, "location not hash permission");
            }
        } catch (Exception e2) {
            LogUtil.d(e, "location exception is " + e2);
        }
        return v;
    }

    public static String getIpInfo() {
        if (x <= 0) {
            y = getIpInfoNow();
            long currentTimeMillis = System.currentTimeMillis();
            x = currentTimeMillis;
            LogUtil.d("getIpInfo", "直接读取:: " + y + "  lastMills:: " + x + "  curMills:: " + currentTimeMillis);
            return y;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 - x >= 15000) {
            y = getIpInfoNow();
            x = currentTimeMillis2;
            LogUtil.d("getIpInfo", "直接读取:: " + y + "  lastMills:: " + x + "  curMills:: " + currentTimeMillis2);
            return y;
        } else if (TextUtils.isEmpty(y)) {
            y = getIpInfoNow();
            x = currentTimeMillis2;
            LogUtil.d("getIpInfo", "直接读取:: " + y + "  lastMills:: " + x + "  curMills:: " + currentTimeMillis2);
            return y;
        } else {
            LogUtil.d("getIpInfo", "来自缓存:: " + y + "  lastMills:: " + x + "  curMills:: " + currentTimeMillis2);
            return y;
        }
    }

    public static String getIpInfoNow() {
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
                            byte b2 = ((address[3] & 255) << Ascii.CAN) | ((address[2] & 255) << Ascii.DLE) | ((address[1] & 255) << 8) | (address[0] & 255);
                            str = (b2 & 255) + IStringUtil.CURRENT_PATH + ((b2 >> 8) & 255) + IStringUtil.CURRENT_PATH + ((b2 >> Ascii.DLE) & 255) + IStringUtil.CURRENT_PATH + ((b2 >> Ascii.CAN) & 255);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            if (ApollonConstants.DEBUG) {
                "getIpInfo fail!" + e2.toString();
            }
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @Nullable
    public static Location getLastKnownLocation(Context context, @Nullable Comparator<Location> comparator) {
        LocationManager locationManager;
        if (!hasPermission(context, "android.permission.ACCESS_FINE_LOCATION") || (locationManager = (LocationManager) context.getApplicationContext().getSystemService(b.c.j)) == null) {
            return null;
        }
        List<String> allProviders = locationManager.getAllProviders();
        Location[] locationArr = new Location[allProviders.size()];
        for (int i2 = 0; i2 < allProviders.size(); i2++) {
            locationArr[i2] = locationManager.getLastKnownLocation(allProviders.get(i2));
        }
        if (comparator == null) {
            comparator = new Comparator<Location>() {
                /* renamed from: a */
                public int compare(Location location, Location location2) {
                    if (location == null) {
                        return location2 == null ? 0 : -1;
                    }
                    if (location2 == null) {
                        return 1;
                    }
                    if (location.getTime() == location2.getTime()) {
                        return Float.compare(location.getAccuracy(), location2.getAccuracy());
                    }
                    return Long.valueOf(location.getTime()).compareTo(Long.valueOf(location2.getTime()));
                }
            };
        }
        Arrays.sort(locationArr, comparator);
        return locationArr[allProviders.size() - 1];
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

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0056 A[SYNTHETIC, Splitter:B:27:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062 A[SYNTHETIC, Splitter:B:36:0x0062] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getLocalMacAddress() {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 20
            r2 = 0
            char[] r3 = new char[r1]     // Catch:{ Exception -> 0x005f, all -> 0x0053 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x005f, all -> 0x0053 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x005f, all -> 0x0053 }
            java.lang.String r6 = "/sys/class/net/eth0/address"
            r5.<init>(r6)     // Catch:{ Exception -> 0x005f, all -> 0x0053 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x005f, all -> 0x0053 }
        L_0x0016:
            int r5 = r4.read(r3)     // Catch:{ Exception -> 0x0060, all -> 0x0050 }
            r6 = -1
            if (r5 == r6) goto L_0x0037
            r6 = 13
            if (r5 != r1) goto L_0x0028
            r7 = 19
            char r7 = r3[r7]     // Catch:{ Exception -> 0x0060, all -> 0x0050 }
            if (r7 == r6) goto L_0x0028
            goto L_0x0016
        L_0x0028:
            r7 = 0
        L_0x0029:
            if (r7 >= r5) goto L_0x0016
            char r8 = r3[r7]     // Catch:{ Exception -> 0x0060, all -> 0x0050 }
            if (r8 == r6) goto L_0x0034
            char r8 = r3[r7]     // Catch:{ Exception -> 0x0060, all -> 0x0050 }
            r0.append(r8)     // Catch:{ Exception -> 0x0060, all -> 0x0050 }
        L_0x0034:
            int r7 = r7 + 1
            goto L_0x0029
        L_0x0037:
            r4.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003f:
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = ":"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.replaceAll(r1, r2)
            return r0
        L_0x0050:
            r0 = move-exception
            r2 = r4
            goto L_0x0054
        L_0x0053:
            r0 = move-exception
        L_0x0054:
            if (r2 == 0) goto L_0x005e
            r2.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005e:
            throw r0
        L_0x005f:
            r4 = r2
        L_0x0060:
            if (r4 == 0) goto L_0x006a
            r4.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0066:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.apollon.utils.PhoneUtils.getLocalMacAddress():java.lang.String");
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
                LogUtil.w(e, "APP Key值为空||The value of APP Key is empty.");
            }
            return obj2;
        } catch (PackageManager.NameNotFoundException e2) {
            "exception is " + e2;
            return "";
        }
    }

    public static int getNumCores() {
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
            LogUtil.d(e, "CPU Count: " + listFiles.length);
            return listFiles.length;
        } catch (Exception e2) {
            LogUtil.d(e, "CPU Count: Failed.");
            e2.printStackTrace();
            return 1;
        }
    }

    @SuppressLint({"NewApi"})
    public static String getPhisicalMac(Context context) {
        return "";
    }

    public static CPUInfo getSystemCPUInfo() {
        CPUInfo cPUInfo = p;
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
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        p = cPUInfo2;
        return cPUInfo2;
    }

    public static long getTotalInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static String getTotalMemory(Context context) {
        long j2 = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (String str : split) {
                str + "\t";
            }
            j2 = Long.valueOf(split[1]).longValue() * 1024;
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return Formatter.formatFileSize(context, j2);
    }

    public static String getWCPParams(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wime", "");
            jSONObject.put("cuid_1", encrypt("phone_number", getCUID(context)));
            jSONObject.put("cuid_2", encrypt("phone_number", getCUID2(context)));
            jSONObject.put("nettype", NetworkUtils.getNetworkType(context));
            jSONObject.put("wloc", encrypt("phone_number", getGPSLocation(context)));
            return new String(Base64Utils.encode(jSONObject.toString().getBytes()));
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getWifiLocation(Context context) {
        String str = "";
        try {
            if (hasPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled()) {
                    int i2 = Integer.MAX_VALUE;
                    int i3 = -1;
                    for (int i4 = 0; i4 < wifiManager.getScanResults().size(); i4++) {
                        ScanResult scanResult = wifiManager.getScanResults().get(i4);
                        int abs = Math.abs(scanResult.level);
                        LogUtil.d(e, String.format("%s %s_%s", new Object[]{scanResult.SSID, scanResult.BSSID, Integer.valueOf(abs)}));
                        if (i2 > abs) {
                            i3 = i4;
                            i2 = abs;
                        }
                    }
                    if (i3 >= 0) {
                        ScanResult scanResult2 = wifiManager.getScanResults().get(i3);
                        str = String.format("%s_%s", new Object[]{scanResult2.BSSID.replace(":", str).toLowerCase(Locale.ENGLISH), Integer.valueOf(Math.abs(scanResult2.level))});
                    }
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    String.format("[active]%s %s_%s", new Object[]{connectionInfo.getSSID(), WifiInfoHelper.getMac(connectionInfo), Integer.valueOf(Math.abs(connectionInfo.getRssi()))});
                }
            }
        } catch (Exception e2) {
            "getWifiLocation " + e2;
        }
        return str;
    }

    public static String getWifiMacAddress(Context context) {
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            LogUtil.d(e, String.format("ssid=%s mac=%s", new Object[]{connectionInfo.getSSID(), WifiInfoHelper.getMac(connectionInfo)}));
            return WifiInfoHelper.getMac(connectionInfo);
        } catch (Exception e2) {
            if (!ApollonConstants.DEBUG) {
                return "";
            }
            e2.toString();
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
        try {
            if (context.getPackageManager().queryIntentActivities(intent, 1).size() > 0) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void sdkError(String str) {
        LogUtil.w(e, str);
        LogUtil.w(e, "SDK install error:" + str);
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

    public static String a(Context context) {
        String deviceID = DeviceId.getDeviceID(context);
        String str = null;
        if (deviceID == null) {
            return null;
        }
        Matcher matcher = a.matcher(deviceID);
        if (matcher.matches()) {
            str = matcher.group(1);
        }
        if (str != null) {
            return str;
        }
        Matcher matcher2 = b.matcher(deviceID);
        return matcher2.matches() ? matcher2.group(1) : "";
    }
}
