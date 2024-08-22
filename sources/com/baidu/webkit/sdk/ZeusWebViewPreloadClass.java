package com.baidu.webkit.sdk;

import com.baidu.webkit.internal.cloudsetting.CloudSettingSDK;
import com.baidu.webkit.internal.daemon.ZeusThreadPoolUtil;
import java.io.File;
import java.util.concurrent.CopyOnWriteArrayList;

public class ZeusWebViewPreloadClass {
    private static final String LOG_TAG = "ZeusWebViewPreloadClass";
    private static final String SAVING_CLASSES_FILE_NAME = "zeus_class_saving_file";
    private static final String ZEUS_FILE_DIR = "zeus";
    private static volatile ZeusWebViewPreloadClass sInstance;
    private volatile boolean mIsFirstCheckUpdateFile = true;
    private volatile boolean mIsNeedUpdateSavingClassFile = true;
    /* access modifiers changed from: private */
    public Object mSavingClassesFileLock = new Object();
    private volatile boolean mStartFlushClassesData;
    private boolean mSwitchEnabled;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<String> mZeusClassLoadList;

    private ZeusWebViewPreloadClass() {
    }

    public static ZeusWebViewPreloadClass getInstance() {
        if (sInstance == null) {
            synchronized (ZeusWebViewPreloadClass.class) {
                if (sInstance == null) {
                    sInstance = new ZeusWebViewPreloadClass();
                }
            }
        }
        return sInstance;
    }

    private boolean isPreloadClassEnabled() {
        if (this.mIsFirstCheckUpdateFile) {
            syncSwitchValuesAtFirstCheck();
        }
        return this.mSwitchEnabled;
    }

    private boolean isCloudSettingsEnabled() {
        return CloudSettingSDK.isPreloadWebviewClassEnabled();
    }

    private boolean isAbTestEnabled() {
        return true;
    }

    /* access modifiers changed from: private */
    public String getSavingClassesFilePath() {
        if (WebViewFactory.getContext() == null) {
            return null;
        }
        String str = WebViewFactory.getContext().getFilesDir().getAbsolutePath() + File.separator + "zeus";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + File.separator + SAVING_CLASSES_FILE_NAME;
    }

    private boolean isSavingClassesFileExist() {
        String savingClassesFilePath = getSavingClassesFilePath();
        if (savingClassesFilePath == null) {
            Log.i(LOG_TAG, "isSavingClassesFileExist path=null");
            return false;
        }
        try {
            if (new File(savingClassesFilePath).exists()) {
                Log.i(LOG_TAG, "isSavingClassesFileExist path exist: ".concat(String.valueOf(savingClassesFilePath)));
                return true;
            }
            Log.i(LOG_TAG, "isSavingClassesFileExist path not exist: ".concat(String.valueOf(savingClassesFilePath)));
            return false;
        } catch (Exception e2) {
            Log.i(LOG_TAG, "isSavingClassesFileExist path: " + savingClassesFilePath + ", hit error=" + e2.getMessage());
            return false;
        }
    }

    public void deleteSavingClassesFile() {
        if (isPreloadClassEnabled()) {
            synchronized (this.mSavingClassesFileLock) {
                String savingClassesFilePath = getSavingClassesFilePath();
                if (savingClassesFilePath == null) {
                    Log.i(LOG_TAG, "deleteSavingClassesFile path=null");
                    return;
                }
                try {
                    File file = new File(savingClassesFilePath);
                    if (file.exists()) {
                        Log.i(LOG_TAG, "deleteSavingClassesFile path exist: ".concat(String.valueOf(savingClassesFilePath)));
                        file.delete();
                    }
                } catch (Exception e2) {
                    WebKitFactory.getLoadErrorCode().addDownloadInfo(1018);
                    Log.i(LOG_TAG, "deleteSavingClassesFile path: " + savingClassesFilePath + ", hit error=" + e2.getMessage());
                }
            }
        }
    }

    public boolean isNeedUpdateSavingClassFile() {
        if (this.mIsFirstCheckUpdateFile) {
            syncSwitchValuesAtFirstCheck();
        }
        return this.mIsNeedUpdateSavingClassFile;
    }

    private synchronized void syncSwitchValuesAtFirstCheck() {
        if (this.mIsFirstCheckUpdateFile) {
            boolean z = true;
            this.mSwitchEnabled = isCloudSettingsEnabled() && isAbTestEnabled() && WebViewFactory.isMainAppProcess();
            if (isSavingClassesFileExist()) {
                z = false;
            }
            this.mIsNeedUpdateSavingClassFile = z;
            Log.i(LOG_TAG, "syncSwitchValuesAtFirstCheck mSwitchEnabled=" + this.mSwitchEnabled + ", isSavingClassesFileExist()=" + isSavingClassesFileExist());
            this.mIsFirstCheckUpdateFile = false;
        }
    }

    public void appendLoadClass(String str) {
        if (!this.mStartFlushClassesData && isNeedUpdateSavingClassFile() && isPreloadClassEnabled()) {
            if (this.mZeusClassLoadList == null) {
                this.mZeusClassLoadList = new CopyOnWriteArrayList<>();
            }
            this.mZeusClassLoadList.add(str);
        }
    }

    public void flushLoadClassesToFile() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (!this.mStartFlushClassesData && isNeedUpdateSavingClassFile() && isPreloadClassEnabled() && (copyOnWriteArrayList = this.mZeusClassLoadList) != null && copyOnWriteArrayList.size() > 0) {
            this.mStartFlushClassesData = true;
            ZeusThreadPoolUtil.execute(new Runnable() {
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedWriter} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.File} */
                /* JADX WARNING: type inference failed for: r2v0 */
                /* JADX WARNING: type inference failed for: r2v5 */
                /* JADX WARNING: type inference failed for: r2v6 */
                /* JADX WARNING: type inference failed for: r2v9 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:0x0069, code lost:
                    r1 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x006a, code lost:
                    r6 = r3;
                    r3 = null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:34:0x006e, code lost:
                    r1 = th;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
                    r2.delete();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
                    r3.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:0x0080, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
                    r1.printStackTrace();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:51:0x008c, code lost:
                    r1 = th;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:52:0x008d, code lost:
                    r2 = r3;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
                    r2.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:56:0x0094, code lost:
                    r2 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
                    r2.printStackTrace();
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Multi-variable type inference failed */
                /* JADX WARNING: Removed duplicated region for block: B:34:0x006e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0014] */
                /* JADX WARNING: Removed duplicated region for block: B:38:0x0074 A[SYNTHETIC, Splitter:B:38:0x0074] */
                /* JADX WARNING: Removed duplicated region for block: B:42:0x007c A[SYNTHETIC, Splitter:B:42:0x007c] */
                /* JADX WARNING: Removed duplicated region for block: B:54:0x0090 A[SYNTHETIC, Splitter:B:54:0x0090] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r0 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this
                        java.lang.Object r0 = r0.mSavingClassesFileLock
                        monitor-enter(r0)
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r1 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this     // Catch:{ all -> 0x009e }
                        java.lang.String r1 = r1.getSavingClassesFilePath()     // Catch:{ all -> 0x009e }
                        if (r1 != 0) goto L_0x0011
                        monitor-exit(r0)     // Catch:{ all -> 0x009e }
                        return
                    L_0x0011:
                        r2 = 0
                        java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0070, all -> 0x006e }
                        r3.<init>(r1)     // Catch:{ IOException -> 0x0070, all -> 0x006e }
                        boolean r1 = r3.exists()     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        if (r1 == 0) goto L_0x0022
                        r3.delete()     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                    L_0x0022:
                        r3.createNewFile()     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        r5.<init>(r3)     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        r4.<init>(r5)     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        r1.<init>(r4)     // Catch:{ IOException -> 0x0069, all -> 0x006e }
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r2 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        java.util.concurrent.CopyOnWriteArrayList r2 = r2.mZeusClassLoadList     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        java.util.Iterator r2 = r2.iterator()     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                    L_0x003e:
                        boolean r4 = r2.hasNext()     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        if (r4 == 0) goto L_0x0051
                        java.lang.Object r4 = r2.next()     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        r1.write(r4)     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        r1.newLine()     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        goto L_0x003e
                    L_0x0051:
                        r1.flush()     // Catch:{ IOException -> 0x0064, all -> 0x005f }
                        r1.close()     // Catch:{ IOException -> 0x0058 }
                        goto L_0x005c
                    L_0x0058:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x009e }
                    L_0x005c:
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r1 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this     // Catch:{ all -> 0x009e }
                        goto L_0x0086
                    L_0x005f:
                        r2 = move-exception
                        r6 = r2
                        r2 = r1
                        r1 = r6
                        goto L_0x008e
                    L_0x0064:
                        r2 = move-exception
                        r6 = r3
                        r3 = r1
                        r1 = r2
                        goto L_0x006c
                    L_0x0069:
                        r1 = move-exception
                        r6 = r3
                        r3 = r2
                    L_0x006c:
                        r2 = r6
                        goto L_0x0072
                    L_0x006e:
                        r1 = move-exception
                        goto L_0x008e
                    L_0x0070:
                        r1 = move-exception
                        r3 = r2
                    L_0x0072:
                        if (r2 == 0) goto L_0x0077
                        r2.delete()     // Catch:{ all -> 0x008c }
                    L_0x0077:
                        r1.printStackTrace()     // Catch:{ all -> 0x008c }
                        if (r3 == 0) goto L_0x0084
                        r3.close()     // Catch:{ IOException -> 0x0080 }
                        goto L_0x0084
                    L_0x0080:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x009e }
                    L_0x0084:
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r1 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this     // Catch:{ all -> 0x009e }
                    L_0x0086:
                        r1.destroy()     // Catch:{ all -> 0x009e }
                        monitor-exit(r0)     // Catch:{ all -> 0x009e }
                        return
                    L_0x008c:
                        r1 = move-exception
                        r2 = r3
                    L_0x008e:
                        if (r2 == 0) goto L_0x0098
                        r2.close()     // Catch:{ IOException -> 0x0094 }
                        goto L_0x0098
                    L_0x0094:
                        r2 = move-exception
                        r2.printStackTrace()     // Catch:{ all -> 0x009e }
                    L_0x0098:
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r2 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this     // Catch:{ all -> 0x009e }
                        r2.destroy()     // Catch:{ all -> 0x009e }
                        throw r1     // Catch:{ all -> 0x009e }
                    L_0x009e:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x009e }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.sdk.ZeusWebViewPreloadClass.AnonymousClass1.run():void");
                }
            });
        }
    }

    public void preloadZeusWebViewClasses(final ClassLoader classLoader) {
        if (classLoader != null && (classLoader instanceof ZeusClassLoader) && !isNeedUpdateSavingClassFile() && isPreloadClassEnabled()) {
            ZeusThreadPoolUtil.execute(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:27:0x004a, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x004b, code lost:
                    r2 = r1;
                    r1 = null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:29:0x004f, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:30:0x0050, code lost:
                    r2 = r1;
                    r1 = null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:0x0055, code lost:
                    r2 = r1;
                    r1 = null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
                    r3.delete();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:42:0x006b, code lost:
                    r1 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
                    r3.delete();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:54:0x0082, code lost:
                    r1 = e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:58:0x0086, code lost:
                    r2 = th;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:59:0x0087, code lost:
                    if (r1 != null) goto L_0x0089;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
                    r1.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:62:0x008d, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
                    r1.printStackTrace();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:65:0x0091, code lost:
                    throw r2;
                 */
                /* JADX WARNING: Failed to process nested try/catch */
                /* JADX WARNING: Removed duplicated region for block: B:31:0x0054 A[ExcHandler: all (r1v15 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:8:0x0014] */
                /* JADX WARNING: Removed duplicated region for block: B:36:0x005f A[SYNTHETIC, Splitter:B:36:0x005f] */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x0067 A[SYNTHETIC, Splitter:B:40:0x0067] */
                /* JADX WARNING: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC, Splitter:B:48:0x0076] */
                /* JADX WARNING: Removed duplicated region for block: B:52:0x007e A[SYNTHETIC, Splitter:B:52:0x007e] */
                /* JADX WARNING: Removed duplicated region for block: B:60:0x0089 A[SYNTHETIC, Splitter:B:60:0x0089] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r7 = this;
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r0 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this
                        java.lang.Object r0 = r0.mSavingClassesFileLock
                        monitor-enter(r0)
                        com.baidu.webkit.sdk.ZeusWebViewPreloadClass r1 = com.baidu.webkit.sdk.ZeusWebViewPreloadClass.this     // Catch:{ all -> 0x0092 }
                        java.lang.String r1 = r1.getSavingClassesFilePath()     // Catch:{ all -> 0x0092 }
                        if (r1 != 0) goto L_0x0011
                        monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                        return
                    L_0x0011:
                        r2 = 0
                        java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x0070, ClassNotFoundException -> 0x0059, all -> 0x0054 }
                        r3.<init>(r1)     // Catch:{ IOException -> 0x0070, ClassNotFoundException -> 0x0059, all -> 0x0054 }
                        boolean r1 = r3.exists()     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0054 }
                        if (r1 == 0) goto L_0x0042
                        java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0054 }
                        java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0054 }
                        java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0054 }
                        r5.<init>(r3)     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0054 }
                        r4.<init>(r5)     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0054 }
                        r1.<init>(r4)     // Catch:{ IOException -> 0x004f, ClassNotFoundException -> 0x004a, all -> 0x0054 }
                    L_0x002e:
                        java.lang.String r2 = r1.readLine()     // Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
                        if (r2 == 0) goto L_0x003c
                        java.lang.ClassLoader r4 = r2     // Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
                        if (r4 == 0) goto L_0x002e
                        r4.loadClass(r2)     // Catch:{ IOException -> 0x0040, ClassNotFoundException -> 0x003e }
                        goto L_0x002e
                    L_0x003c:
                        r2 = r1
                        goto L_0x0042
                    L_0x003e:
                        r2 = move-exception
                        goto L_0x005d
                    L_0x0040:
                        r2 = move-exception
                        goto L_0x0074
                    L_0x0042:
                        if (r2 == 0) goto L_0x0084
                        r2.close()     // Catch:{ IOException -> 0x0048 }
                        goto L_0x0081
                    L_0x0048:
                        r1 = move-exception
                        goto L_0x006c
                    L_0x004a:
                        r1 = move-exception
                        r6 = r2
                        r2 = r1
                        r1 = r6
                        goto L_0x005d
                    L_0x004f:
                        r1 = move-exception
                        r6 = r2
                        r2 = r1
                        r1 = r6
                        goto L_0x0074
                    L_0x0054:
                        r1 = move-exception
                        r6 = r2
                        r2 = r1
                        r1 = r6
                        goto L_0x0087
                    L_0x0059:
                        r1 = move-exception
                        r3 = r2
                        r2 = r1
                        r1 = r3
                    L_0x005d:
                        if (r3 == 0) goto L_0x0062
                        r3.delete()     // Catch:{ all -> 0x0086 }
                    L_0x0062:
                        r2.printStackTrace()     // Catch:{ all -> 0x0086 }
                        if (r1 == 0) goto L_0x0084
                        r1.close()     // Catch:{ IOException -> 0x006b }
                        goto L_0x0081
                    L_0x006b:
                        r1 = move-exception
                    L_0x006c:
                        r1.printStackTrace()     // Catch:{ all -> 0x0092 }
                        goto L_0x0084
                    L_0x0070:
                        r1 = move-exception
                        r3 = r2
                        r2 = r1
                        r1 = r3
                    L_0x0074:
                        if (r3 == 0) goto L_0x0079
                        r3.delete()     // Catch:{ all -> 0x0086 }
                    L_0x0079:
                        r2.printStackTrace()     // Catch:{ all -> 0x0086 }
                        if (r1 == 0) goto L_0x0084
                        r1.close()     // Catch:{ IOException -> 0x0082 }
                    L_0x0081:
                        goto L_0x0084
                    L_0x0082:
                        r1 = move-exception
                        goto L_0x006c
                    L_0x0084:
                        monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                        return
                    L_0x0086:
                        r2 = move-exception
                    L_0x0087:
                        if (r1 == 0) goto L_0x0091
                        r1.close()     // Catch:{ IOException -> 0x008d }
                        goto L_0x0091
                    L_0x008d:
                        r1 = move-exception
                        r1.printStackTrace()     // Catch:{ all -> 0x0092 }
                    L_0x0091:
                        throw r2     // Catch:{ all -> 0x0092 }
                    L_0x0092:
                        r1 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.sdk.ZeusWebViewPreloadClass.AnonymousClass2.run():void");
                }
            });
        }
    }

    public void destroy() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = this.mZeusClassLoadList;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
            this.mZeusClassLoadList = null;
        }
    }
}
