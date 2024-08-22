package com.baidu.nps.runtime.resources.api24;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.nps.runtime.resources.MainThreadTask;
import com.baidu.nps.runtime.resources.MainThreadTaskHandler;
import com.baidu.nps.runtime.resources.webview.HostWebViewResourcesHelper;
import com.baidu.nps.utils.ArrayUtils;
import com.baidu.nps.utils.ContextHolder;
import com.baidu.nps.utils.NPSLog;
import com.baidu.searchbox.message.push.IAchPluginInvoker;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Api24ResourcesManager {
    private static final Runnable S_MAIN_THREAD_TASK_ONCE = new Runnable() {
        public void run() {
            if (NPSLog.isDebug()) {
                NPSLog.e(Api24ResourcesManager.TAG, "First Main Task: doWebViewPathTask: start");
            }
            HostWebViewResourcesHelper.get().doWebViewPathTask();
            if (NPSLog.isDebug()) {
                NPSLog.e(Api24ResourcesManager.TAG, "First Main Task: doWebViewPathTask: end");
            }
        }
    };
    private static final String TAG = "Api24ResourcesManager";

    private Api24ResourcesManager() {
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static final Api24ResourcesManager INSTANCE = new Api24ResourcesManager();

        private Holder() {
        }
    }

    public static Api24ResourcesManager get() {
        return Holder.INSTANCE;
    }

    public static void doStabilizeHost(String apkPath) {
        MainThreadTaskHandler.get().doMainThreadTask(new MainThreadTask(apkPath, S_MAIN_THREAD_TASK_ONCE));
    }

    @Deprecated
    public void appendLibAssetForMainAssetPath(String apkPath) {
        String str = apkPath;
        if (Build.VERSION.SDK_INT >= 24) {
            if (NPSLog.isDebug()) {
                NPSLog.d(TAG, "appendLibAssetForMainAssetPath: ");
                NPSLog.d(TAG, "apkPath: " + str);
            }
            try {
                long start = System.currentTimeMillis();
                ApplicationInfo appInfo = ContextHolder.getApplicationContext().getApplicationInfo();
                String[] sharedLibraryFiles = appInfo.sharedLibraryFiles;
                if (NPSLog.isDebug()) {
                    NPSLog.d(TAG, "old sharedLibraryFiles: " + sharedLibraryFiles);
                    NPSLog.d(TAG, "old sharedLibraryFiles: " + TextUtils.join(",", sharedLibraryFiles));
                }
                for (String newAssetPath : new String[]{str}) {
                    sharedLibraryFiles = (String[]) ArrayUtils.appendElement(String.class, sharedLibraryFiles, newAssetPath);
                }
                if (NPSLog.isDebug()) {
                    NPSLog.d(TAG, "new sharedLibraryFiles: " + sharedLibraryFiles);
                    NPSLog.d(TAG, "new sharedLibraryFiles: " + TextUtils.join(",", sharedLibraryFiles));
                }
                if (NPSLog.isDebug()) {
                    NPSLog.d(TAG, "sharedLibraryFiles != appInfo.sharedLibraryFiles = : " + (sharedLibraryFiles != appInfo.sharedLibraryFiles));
                }
                if (sharedLibraryFiles != appInfo.sharedLibraryFiles) {
                    appInfo.sharedLibraryFiles = sharedLibraryFiles;
                    Class<?> clazz = Class.forName("android.app.ResourcesManager");
                    Method getInstanceMethod = clazz.getDeclaredMethod(IAchPluginInvoker.INSTANCE_METHOD, new Class[0]);
                    getInstanceMethod.setAccessible(true);
                    Object resourcesManager = getInstanceMethod.invoke((Object) null, new Object[0]);
                    Method appendMethod = clazz.getDeclaredMethod("appendLibAssetForMainAssetPath", new Class[]{String.class, String.class});
                    appendMethod.setAccessible(true);
                    appendMethod.invoke(resourcesManager, new Object[]{appInfo.publicSourceDir, str});
                }
                if (NPSLog.isDebug()) {
                    NPSLog.d(TAG, "appendLibAssetForMainAssetPath cost: " + (System.currentTimeMillis() - start));
                }
            } catch (ClassNotFoundException e2) {
                NPSLog.e(TAG, "appendLibAssetForMainAssetPath: " + e2.getMessage());
                e2.printStackTrace();
            } catch (NoSuchMethodException e3) {
                NPSLog.e(TAG, "appendLibAssetForMainAssetPath: " + e3.getMessage());
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                NPSLog.e(TAG, "appendLibAssetForMainAssetPath: " + e4.getMessage());
                e4.printStackTrace();
            } catch (IllegalAccessException e5) {
                NPSLog.e(TAG, "appendLibAssetForMainAssetPath: " + e5.getMessage());
                e5.printStackTrace();
            }
        }
    }
}
