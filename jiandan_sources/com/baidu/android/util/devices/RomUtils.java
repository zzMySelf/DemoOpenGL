package com.baidu.android.util.devices;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public class RomUtils {
    public static final String KEY_VERSION_EMUI = "ro.build.version.emui";
    public static final String KEY_VERSION_GIONEE = "ro.gn.sv.version";
    public static final String KEY_VERSION_MIUI = "ro.miui.ui.version.name";
    public static final String KEY_VERSION_NUBIA = "ro.build.rom.id";
    public static final String KEY_VERSION_OPPO = "ro.build.version.opporom";
    public static final String KEY_VERSION_SMARTISAN = "ro.smartisan.version";
    public static final String KEY_VERSION_VIVO = "ro.vivo.os.version";
    public static final String MANUFACTURER_GIONEE = "gionee";
    public static final String MANUFACTURER_HUAWEI = "huawei";
    public static final String MANUFACTURER_MEIZU = "meizu";
    public static final String MANUFACTURER_NUBIA = "nubia";
    public static final String MANUFACTURER_OPPO = "oppo";
    public static final String MANUFACTURER_SMARTISAN = "smartisan";
    public static final String MANUFACTURER_VIVO = "vivo";
    public static final String MANUFACTURER_XIAOMI = "xiaomi";
    public static final String PROP_RO_BUILD_DISPLAY_ID = "ro.build.display.id";
    public static final String PROP_RO_BUILD_FINGERPRINT = "ro.build.fingerprint";
    public static final String PROP_RO_BUILD_VERSION_INCREMENTAL = "ro.build.version.incremental";
    public static final String ROM_EMUI = "EMUI";
    public static final String ROM_FLYME = "FLYME";
    public static final String ROM_GIONEE = "GIONEE";
    public static final String ROM_MIUI = "MIUI";
    public static final String ROM_NUBIA = "NUBIA";
    public static final String ROM_OPPO = "OPPO";
    public static final String ROM_QIKU = "QIKU";
    public static final String ROM_SMARTISAN = "SMARTISAN";
    public static final String ROM_UNKNOWN = "ROM_UNKNOWN";
    public static final String ROM_VIVO = "VIVO";
    public static final String ROM_XIAOMI = "XIAOMI";
    public static final String TAG = "Rom";
    public static final String UNKNOWN = "UNKNOWN";
    public static String sRomName;
    public static String sRomVersion;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String check() {
        /*
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.toLowerCase(r1)
            int r1 = r0.hashCode()
            switch(r1) {
                case -1443430368: goto L_0x0058;
                case -1245779295: goto L_0x004e;
                case -1206476313: goto L_0x0044;
                case -759499589: goto L_0x003a;
                case 3418016: goto L_0x0030;
                case 3620012: goto L_0x0026;
                case 103777484: goto L_0x001c;
                case 105170387: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0062
        L_0x0012:
            java.lang.String r1 = "nubia"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 6
            goto L_0x0063
        L_0x001c:
            java.lang.String r1 = "meizu"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 7
            goto L_0x0063
        L_0x0026:
            java.lang.String r1 = "vivo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 3
            goto L_0x0063
        L_0x0030:
            java.lang.String r1 = "oppo"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 2
            goto L_0x0063
        L_0x003a:
            java.lang.String r1 = "xiaomi"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 1
            goto L_0x0063
        L_0x0044:
            java.lang.String r1 = "huawei"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 0
            goto L_0x0063
        L_0x004e:
            java.lang.String r1 = "gionee"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 5
            goto L_0x0063
        L_0x0058:
            java.lang.String r1 = "smartisan"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0062
            r0 = 4
            goto L_0x0063
        L_0x0062:
            r0 = -1
        L_0x0063:
            switch(r0) {
                case 0: goto L_0x0115;
                case 1: goto L_0x00fd;
                case 2: goto L_0x00e5;
                case 3: goto L_0x00cd;
                case 4: goto L_0x00b5;
                case 5: goto L_0x009d;
                case 6: goto L_0x0085;
                case 7: goto L_0x006b;
                default: goto L_0x0066;
            }
        L_0x0066:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x006b:
            java.lang.String r0 = android.os.Build.DISPLAY
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.toUpperCase(r1)
            java.lang.String r1 = "FLYME"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0080
            sRomName = r1
            return r1
        L_0x0080:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x0085:
            java.lang.String r0 = "ro.build.rom.id"
            java.lang.String r0 = getProp(r0)
            sRomVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0098
            java.lang.String r0 = "NUBIA"
            sRomName = r0
            return r0
        L_0x0098:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x009d:
            java.lang.String r0 = "ro.gn.sv.version"
            java.lang.String r0 = getProp(r0)
            sRomVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00b0
            java.lang.String r0 = "GIONEE"
            sRomName = r0
            return r0
        L_0x00b0:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x00b5:
            java.lang.String r0 = "ro.smartisan.version"
            java.lang.String r0 = getProp(r0)
            sRomVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00c8
            java.lang.String r0 = "SMARTISAN"
            sRomName = r0
            return r0
        L_0x00c8:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x00cd:
            java.lang.String r0 = "ro.vivo.os.version"
            java.lang.String r0 = getProp(r0)
            sRomVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00e0
            java.lang.String r0 = "VIVO"
            sRomName = r0
            return r0
        L_0x00e0:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x00e5:
            java.lang.String r0 = "ro.build.version.opporom"
            java.lang.String r0 = getProp(r0)
            sRomVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00f8
            java.lang.String r0 = "OPPO"
            sRomName = r0
            return r0
        L_0x00f8:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x00fd:
            java.lang.String r0 = "ro.miui.ui.version.name"
            java.lang.String r0 = getProp(r0)
            sRomVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0110
            java.lang.String r0 = "MIUI"
            sRomName = r0
            return r0
        L_0x0110:
            java.lang.String r0 = getOtherRomName()
            return r0
        L_0x0115:
            java.lang.String r0 = "ro.build.version.emui"
            java.lang.String r0 = getProp(r0)
            sRomVersion = r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0128
            java.lang.String r0 = "EMUI"
            sRomName = r0
            return r0
        L_0x0128:
            java.lang.String r0 = getOtherRomName()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.devices.RomUtils.check():java.lang.String");
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceName() {
        return Build.PRODUCT;
    }

    public static String getIncrementalVersion() {
        return getProp(PROP_RO_BUILD_VERSION_INCREMENTAL);
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getName() {
        String str = sRomName;
        return str == null ? check() : str;
    }

    public static String getOtherRomName() {
        String str = Build.DISPLAY;
        sRomVersion = str;
        if (str.toUpperCase(Locale.getDefault()).contains(ROM_FLYME)) {
            sRomName = ROM_FLYME;
        } else {
            sRomVersion = "unknown";
            sRomName = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
        }
        return sRomName;
    }

    public static String getProp(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (Exception e) {
            e.printStackTrace();
            return getPropByRuntimeExec(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        "Unable to read prop " + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        if (r2 != null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        r4 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005a A[SYNTHETIC, Splitter:B:24:0x005a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getPropByRuntimeExec(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            r2.<init>()     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            r2.append(r4)     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            r3.<init>(r1)     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x003a, all -> 0x0038 }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x003b }
            r2.close()     // Catch:{ IOException -> 0x003b }
            r2.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0037:
            return r1
        L_0x0038:
            r4 = move-exception
            goto L_0x0058
        L_0x003a:
            r2 = r0
        L_0x003b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0056 }
            r1.<init>()     // Catch:{ all -> 0x0056 }
            java.lang.String r3 = "Unable to read prop "
            r1.append(r3)     // Catch:{ all -> 0x0056 }
            r1.append(r4)     // Catch:{ all -> 0x0056 }
            r1.toString()     // Catch:{ all -> 0x0056 }
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0055
        L_0x0051:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0055:
            return r0
        L_0x0056:
            r4 = move-exception
            r0 = r2
        L_0x0058:
            if (r0 == 0) goto L_0x0062
            r0.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.util.devices.RomUtils.getPropByRuntimeExec(java.lang.String):java.lang.String");
    }

    public static String getVersion() {
        if (sRomVersion == null) {
            check();
        }
        return sRomVersion;
    }

    public static boolean is360() {
        return check(ROM_QIKU) || check("360");
    }

    public static boolean isEmui() {
        return check(ROM_EMUI);
    }

    public static boolean isFlyme() {
        return check(ROM_FLYME);
    }

    public static boolean isFlymeQuickly() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toUpperCase(Locale.getDefault()).contains(ROM_FLYME);
    }

    public static boolean isMagicBoxDevice() {
        return Build.MANUFACTURER.equalsIgnoreCase("MagicBox") && Build.PRODUCT.equalsIgnoreCase("MagicBox");
    }

    public static boolean isMiBox2Device() {
        return Build.MANUFACTURER.equalsIgnoreCase("Xiaomi") && Build.PRODUCT.equalsIgnoreCase("dredd");
    }

    public static boolean isMiui() {
        return check(ROM_MIUI);
    }

    public static boolean isMiuiOrXiaoMi() {
        return check(ROM_MIUI) || check(ROM_XIAOMI);
    }

    public static boolean isNubia() {
        return check(ROM_NUBIA);
    }

    public static boolean isOppo() {
        return check(ROM_OPPO);
    }

    public static boolean isSmartisan() {
        return check(ROM_SMARTISAN);
    }

    public static boolean isVivo() {
        return check(ROM_VIVO);
    }

    public static boolean check(String str) {
        String str2 = sRomName;
        if (str2 != null) {
            return str2.equals(str);
        }
        String prop = getProp("ro.miui.ui.version.name");
        sRomVersion = prop;
        if (!TextUtils.isEmpty(prop)) {
            sRomName = ROM_MIUI;
        } else {
            String prop2 = getProp("ro.build.version.emui");
            sRomVersion = prop2;
            if (!TextUtils.isEmpty(prop2)) {
                sRomName = ROM_EMUI;
            } else {
                String prop3 = getProp(KEY_VERSION_OPPO);
                sRomVersion = prop3;
                if (!TextUtils.isEmpty(prop3)) {
                    sRomName = ROM_OPPO;
                } else {
                    String prop4 = getProp(KEY_VERSION_VIVO);
                    sRomVersion = prop4;
                    if (!TextUtils.isEmpty(prop4)) {
                        sRomName = ROM_VIVO;
                    } else {
                        String prop5 = getProp(KEY_VERSION_SMARTISAN);
                        sRomVersion = prop5;
                        if (!TextUtils.isEmpty(prop5)) {
                            sRomName = ROM_SMARTISAN;
                        } else {
                            String prop6 = getProp(KEY_VERSION_GIONEE);
                            sRomVersion = prop6;
                            if (!TextUtils.isEmpty(prop6)) {
                                sRomName = ROM_GIONEE;
                            } else {
                                String prop7 = getProp(KEY_VERSION_NUBIA);
                                sRomVersion = prop7;
                                if (!TextUtils.isEmpty(prop7)) {
                                    sRomName = ROM_NUBIA;
                                } else {
                                    String str3 = Build.DISPLAY;
                                    sRomVersion = str3;
                                    if (str3.toUpperCase(Locale.getDefault()).contains(ROM_FLYME)) {
                                        sRomName = ROM_FLYME;
                                    } else {
                                        sRomVersion = "unknown";
                                        sRomName = Build.MANUFACTURER.toUpperCase(Locale.getDefault());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return sRomName.equals(str);
    }
}
