package com.baidu.searchbox.plugins.kernels.webview;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.baidu.android.common.ui.style.R;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.pass.main.facesdk.BuildConfig;
import com.baidu.searchbox.SearchBox;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.webkit.engine.IZeusEngineInstallListener;
import com.baidu.webkit.sdk.WebKitFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class ZeusInstallHelper {
    public static final boolean DEBUG = (SearchBox.GLOBAL_DEBUG & true);
    public static final String FILE_SCHEMA = "file://";
    public static final String TAG = ZeusInstallHelper.class.getSimpleName();
    public static final String ZEUS_SDCARD_PATH = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/zeus");
    public static final String ZEUS_ZIP_FILENAME = "zeus.zip";
    /* access modifiers changed from: private */
    public Context mContext;
    private CPU_TYPE mCpuType = CPU_TYPE.UNKNOWN_TYPE;

    private enum CPU_TYPE {
        UNKNOWN_TYPE,
        ARMV5,
        ARMV6,
        ARMV7_NEON,
        ARMV7_VFP
    }

    public interface NewZeusInstallListener extends IZeusEngineInstallListener, VerificationCallback {
    }

    private interface VerificationCallback {
        void onReceivefileMd5Error();
    }

    public interface ZeusInstallListener extends WebKitFactory.WebkitInstallListener, VerificationCallback {
    }

    public ZeusInstallHelper(Context ctx) {
        this.mContext = ctx;
    }

    public String prepareInstallFromSD() {
        String suffixString;
        String sdkVersion = getSDKVersion();
        if (getCPUInfo() == CPU_TYPE.ARMV7_NEON) {
            suffixString = "NEON.zes";
        } else {
            suffixString = "AR.zes";
        }
        String str = ZEUS_SDCARD_PATH;
        File file = new File(str);
        if (!file.exists()) {
            if (this.mContext instanceof Activity) {
                UniversalToast.makeText(SearchBox.getAppContext(), (CharSequence) "未发现" + str).setDuration(3).showToast();
            }
            return "";
        }
        if (file.isDirectory()) {
            int i2 = 0;
            if (file.list().length > 1) {
                String[] list = file.list();
                int length = list.length;
                while (i2 < length) {
                    String fileName = list[i2];
                    if (fileName.contains(sdkVersion) && fileName.endsWith(suffixString)) {
                        return fileName;
                    }
                    i2++;
                }
            } else {
                String[] list2 = file.list();
                int length2 = list2.length;
                while (i2 < length2) {
                    String fileName2 = list2[i2];
                    if (fileName2.endsWith(suffixString)) {
                        return fileName2;
                    }
                    i2++;
                }
            }
        }
        Context context = this.mContext;
        if (context instanceof Activity) {
            UniversalToast.makeText(SearchBox.getAppContext(), (CharSequence) context.getString(R.string.zeus_install_error_msg).replace("%s1", ZEUS_SDCARD_PATH).replace("%s2", "*" + suffixString)).setDuration(3).showToast();
        }
        return "";
    }

    public void installZeusAsync(String path, ZeusInstallListener listener) {
        if (WebkitKernelPlugin.getInstance(this.mContext).isAvailable()) {
            WebKitFactory.setEngine(1);
        } else {
            installZeusAsyncInternal(path, listener);
        }
    }

    private void installZeusAsyncInternal(final String path, final ZeusInstallListener listener) {
        ExecutorUtilsExt.getElasticExecutor("installZeusAsyncInternal", 1).execute(new Runnable() {
            public void run() {
                if (ZeusInstallHelper.verify(ZeusInstallHelper.this.mContext, path)) {
                    WebKitFactory.installAsync(path, listener);
                } else {
                    listener.onReceivefileMd5Error();
                }
            }
        });
    }

    private String getSDKVersion() {
        int sdkVersion = Build.VERSION.SDK_INT;
        if (sdkVersion == 7) {
            return "2.1";
        }
        if (sdkVersion == 8) {
            return "2.2";
        }
        if (sdkVersion >= 9 && sdkVersion <= 10) {
            return "2.3";
        }
        if (sdkVersion >= 11 && sdkVersion <= 13) {
            return "3.0";
        }
        if (sdkVersion >= 14 && sdkVersion <= 15) {
            return "4.0";
        }
        if (sdkVersion == 16) {
            return BuildConfig.VERSION_NAME;
        }
        if (sdkVersion == 17) {
            return "4.2";
        }
        if (sdkVersion == 18) {
            return "4.3";
        }
        return DownloadStatisticConstants.UBC_VALUE_UNKNOW;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0063, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008d, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c7, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean verify(android.content.Context r15, java.lang.String r16) {
        /*
            java.lang.Class<com.baidu.searchbox.plugins.kernels.webview.ZeusInstallHelper> r1 = com.baidu.searchbox.plugins.kernels.webview.ZeusInstallHelper.class
            monitor-enter(r1)
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00c8 }
            boolean r0 = android.text.TextUtils.isEmpty(r16)     // Catch:{ all -> 0x00c8 }
            r4 = 0
            if (r0 == 0) goto L_0x001c
            boolean r0 = DEBUG     // Catch:{ all -> 0x00c8 }
            if (r0 == 0) goto L_0x001a
            java.lang.String r0 = TAG     // Catch:{ all -> 0x00c8 }
            java.lang.String r5 = "verify: error by empty filePath"
            com.baidu.android.common.logging.Log.i(r0, r5)     // Catch:{ all -> 0x00c8 }
        L_0x001a:
            monitor-exit(r1)
            return r4
        L_0x001c:
            android.net.Uri r0 = android.net.Uri.parse(r16)     // Catch:{ all -> 0x00c8 }
            if (r0 != 0) goto L_0x0030
            boolean r5 = DEBUG     // Catch:{ all -> 0x00c8 }
            if (r5 == 0) goto L_0x002e
            java.lang.String r5 = TAG     // Catch:{ all -> 0x00c8 }
            java.lang.String r6 = "verify: error by null fileUri"
            com.baidu.android.common.logging.Log.i(r5, r6)     // Catch:{ all -> 0x00c8 }
        L_0x002e:
            monitor-exit(r1)
            return r4
        L_0x0030:
            java.lang.String r5 = r0.getPath()     // Catch:{ all -> 0x00c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x0048
            boolean r6 = DEBUG     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x0046
            java.lang.String r6 = TAG     // Catch:{ all -> 0x00c8 }
            java.lang.String r7 = "verify: error by empty path"
            com.baidu.android.common.logging.Log.i(r6, r7)     // Catch:{ all -> 0x00c8 }
        L_0x0046:
            monitor-exit(r1)
            return r4
        L_0x0048:
            com.baidu.searchbox.plugins.kernels.webview.WebkitKernelPlugin r6 = com.baidu.searchbox.plugins.kernels.webview.WebkitKernelPlugin.getInstance(r15)     // Catch:{ all -> 0x00c8 }
            java.lang.String r6 = r6.getMd5()     // Catch:{ all -> 0x00c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00c8 }
            if (r7 == 0) goto L_0x0064
            boolean r7 = DEBUG     // Catch:{ all -> 0x00c8 }
            if (r7 == 0) goto L_0x0062
            java.lang.String r7 = TAG     // Catch:{ all -> 0x00c8 }
            java.lang.String r8 = "verify: error by empty savedMd5"
            com.baidu.android.common.logging.Log.i(r7, r8)     // Catch:{ all -> 0x00c8 }
        L_0x0062:
            monitor-exit(r1)
            return r4
        L_0x0064:
            java.io.File r7 = new java.io.File     // Catch:{ all -> 0x00c8 }
            r7.<init>(r5)     // Catch:{ all -> 0x00c8 }
            boolean r8 = r7.isFile()     // Catch:{ all -> 0x00c8 }
            if (r8 != 0) goto L_0x008e
            boolean r8 = DEBUG     // Catch:{ all -> 0x00c8 }
            if (r8 == 0) goto L_0x008c
            java.lang.String r8 = TAG     // Catch:{ all -> 0x00c8 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c8 }
            r9.<init>()     // Catch:{ all -> 0x00c8 }
            java.lang.String r10 = "verify: error by is not file = \n    "
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch:{ all -> 0x00c8 }
            java.lang.StringBuilder r9 = r9.append(r7)     // Catch:{ all -> 0x00c8 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00c8 }
            com.baidu.android.common.logging.Log.i(r8, r9)     // Catch:{ all -> 0x00c8 }
        L_0x008c:
            monitor-exit(r1)
            return r4
        L_0x008e:
            java.lang.String r8 = org.apache.commons.codec.digest4util.MD5Utils.toMd5((java.io.File) r7, (boolean) r4)     // Catch:{ all -> 0x00c8 }
            boolean r9 = android.text.TextUtils.equals(r6, r8)     // Catch:{ all -> 0x00c8 }
            boolean r10 = DEBUG     // Catch:{ all -> 0x00c8 }
            if (r10 == 0) goto L_0x00c6
            long r10 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00c8 }
            long r2 = r10 - r2
            java.lang.String r10 = TAG     // Catch:{ all -> 0x00c8 }
            java.util.Locale r11 = java.util.Locale.getDefault()     // Catch:{ all -> 0x00c8 }
            java.lang.String r12 = "verify: %b cost(%d) md5(%s)\n    file(%s)"
            r13 = 4
            java.lang.Object[] r13 = new java.lang.Object[r13]     // Catch:{ all -> 0x00c8 }
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r9)     // Catch:{ all -> 0x00c8 }
            r13[r4] = r14     // Catch:{ all -> 0x00c8 }
            r4 = 1
            java.lang.Long r14 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x00c8 }
            r13[r4] = r14     // Catch:{ all -> 0x00c8 }
            r4 = 2
            r13[r4] = r8     // Catch:{ all -> 0x00c8 }
            r4 = 3
            r13[r4] = r7     // Catch:{ all -> 0x00c8 }
            java.lang.String r4 = java.lang.String.format(r11, r12, r13)     // Catch:{ all -> 0x00c8 }
            com.baidu.android.common.logging.Log.i(r10, r4)     // Catch:{ all -> 0x00c8 }
        L_0x00c6:
            monitor-exit(r1)
            return r9
        L_0x00c8:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.plugins.kernels.webview.ZeusInstallHelper.verify(android.content.Context, java.lang.String):boolean");
    }

    private static class CpuInfoConst {
        public static final String ARMV5 = "armv5";
        public static final String ARMV6 = "armv6";
        public static final String ARMV7 = "armv7";
        public static final String FEATURES = "features";
        public static final String NEON = "neon";
        public static final String PROCESSOR = "processor";

        private CpuInfoConst() {
        }
    }

    private CPU_TYPE getCPUInfo() {
        if (this.mCpuType != CPU_TYPE.UNKNOWN_TYPE) {
            return this.mCpuType;
        }
        CPU_TYPE type = CPU_TYPE.UNKNOWN_TYPE;
        try {
            FileReader fr = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fr);
            String line = bufferedReader.readLine();
            while (true) {
                if (line == null) {
                    break;
                }
                String lowerCaseLine = line.toLowerCase(Locale.getDefault());
                if (lowerCaseLine.contains(CpuInfoConst.PROCESSOR)) {
                    if (lowerCaseLine.contains("armv5")) {
                        type = CPU_TYPE.ARMV5;
                        break;
                    } else if (lowerCaseLine.contains("armv6")) {
                        type = CPU_TYPE.ARMV6;
                        break;
                    } else if (lowerCaseLine.contains("armv7")) {
                        type = CPU_TYPE.ARMV7_VFP;
                    }
                }
                if (type != CPU_TYPE.ARMV7_VFP || !lowerCaseLine.contains(CpuInfoConst.FEATURES)) {
                    line = bufferedReader.readLine();
                } else if (lowerCaseLine.contains("neon")) {
                    type = CPU_TYPE.ARMV7_NEON;
                }
            }
            bufferedReader.close();
            fr.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        this.mCpuType = type;
        return type;
    }
}
