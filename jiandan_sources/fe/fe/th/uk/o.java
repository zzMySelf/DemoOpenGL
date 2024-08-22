package fe.fe.th.uk;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.storage.StorageManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.content.FileProvider;
import com.baidu.sapi2.utils.SapiUtils;
import fe.fe.aaa.ad;
import fe.fe.aaa.qw;
import fe.fe.th.ad.de;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class o {
    public static String qw = "";

    public static String ad(Context context, String str) {
        try {
            return yj.qw(new File(yj(context, str).applicationInfo.publicSourceDir));
        } catch (Exception e) {
            qw.ad("Utility", SapiUtils.KEY_QR_LOGIN_ERROR + e.getMessage());
            return "";
        }
    }

    public static String de(Object obj) {
        Object qw2 = qw(obj, "getPath", (Class[]) null, (Object[]) null);
        return qw2 != null ? (String) qw2 : "";
    }

    public static void fe(Context context, File file) {
        Context context2 = context;
        de ad2 = de.ad(context);
        fe.fe.th.th.qw qw2 = fe.fe.th.th.qw.qw(context);
        qw.qw("Utility", "startSystemInstallUI安装文件存在:" + file.exists() + ":" + file.getPath());
        ad.ad(context).rg("lcsdk_xml", "sessionId", qw2.i());
        ad.ad(context).rg("lcsdk_xml", "sessionInfo", qw2.rg());
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(268435457);
                String str = qw;
                if (TextUtils.isEmpty(qw)) {
                    str = context.getPackageName() + ".fileprovider";
                }
                intent.setDataAndType(FileProvider.getUriForFile(context2, str, file), "application/vnd.android.package-archive");
            } else {
                File file2 = file;
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(268435456);
            }
            qw.qw("Utility", "启动系统安装界面");
            context2.startActivity(intent);
            ad2.th(qw2.i(), "0", qw2.rg(), "a9", "0", (System.currentTimeMillis() / 1000) + "", "", "startSystemInstallUI", "");
        } catch (Exception e) {
            e.printStackTrace();
            qw.ad("Utility", "启动系统安装界面失败");
            ad2.th(qw2.i(), "0", qw2.rg(), "a9", "1", (System.currentTimeMillis() / 1000) + "", "", "startSystemInstallUI", e.toString());
        }
    }

    public static long i(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("client_update_ignore_time", 0);
    }

    /* renamed from: if  reason: not valid java name */
    public static ActivityManager.RunningTaskInfo m222if(Context context) {
        ActivityManager.RecentTaskInfo recentTaskInfo;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        List<ActivityManager.RecentTaskInfo> recentTasks = activityManager.getRecentTasks(1, 1);
        List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(3);
        Iterator<ActivityManager.RecentTaskInfo> it = recentTasks.iterator();
        Iterator<ActivityManager.RunningTaskInfo> it2 = runningTasks.iterator();
        if (it.hasNext()) {
            recentTaskInfo = it.next();
            qw.qw("Utility", "getCurrentTask---------当前任务----localRecentTaskInfo.id = " + recentTaskInfo.id);
            qw.qw("Utility", "getCurrentTask---------当前任务----localRecentTaskInfo.PackageName = " + recentTaskInfo.baseIntent.getComponent().getPackageName());
        } else {
            recentTaskInfo = null;
        }
        if (recentTaskInfo == null) {
            return null;
        }
        ActivityManager.RunningTaskInfo next = it2.hasNext() ? it2.next() : null;
        if (next == null) {
            return null;
        }
        int i2 = recentTaskInfo.id;
        if (i2 == -1 || next.id != i2) {
            String packageName = recentTaskInfo.baseIntent.getComponent().getPackageName();
            if (next.baseActivity.getPackageName().equals(packageName)) {
                while (it2.hasNext()) {
                    next = it2.next();
                    if (!next.baseActivity.getPackageName().equals(packageName)) {
                    }
                }
                return null;
            }
        } else {
            qw.qw("Utility", "getCurrentTask---------new task");
        }
        return next;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r5 = qw((android.os.storage.StorageManager) r5.getSystemService("storage"), "getVolumeState", new java.lang.Class[]{java.lang.String.class}, new java.lang.Object[]{r6});
     */
    @android.annotation.TargetApi(9)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String o(android.content.Context r5, java.lang.String r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            java.lang.String r1 = ""
            r2 = 9
            if (r0 >= r2) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r0 = "storage"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.os.storage.StorageManager r5 = (android.os.storage.StorageManager) r5
            r0 = 1
            java.lang.Class[] r2 = new java.lang.Class[r0]
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            r4 = 0
            r2[r4] = r3
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r4] = r6
            java.lang.String r6 = "getVolumeState"
            java.lang.Object r5 = qw(r5, r6, r2, r0)
            if (r5 == 0) goto L_0x0028
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
        L_0x0028:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.th.uk.o.o(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean pf(Context context) {
        Context applicationContext = context.getApplicationContext();
        ActivityManager.RunningTaskInfo runningTaskInfo = m222if(applicationContext);
        if (runningTaskInfo == null) {
            return false;
        }
        return TextUtils.equals(applicationContext.getPackageName(), runningTaskInfo.baseActivity.getPackageName());
    }

    public static Object qw(Object obj, String str, Class[] clsArr, Object[] objArr) {
        Object obj2 = null;
        try {
            obj2 = obj.getClass().getMethod(str, clsArr).invoke(obj, objArr);
            qw.qw("Utility", "Method \"" + str + "\" invoked success!");
            return obj2;
        } catch (Exception e) {
            qw.qw("Utility", "Method \"" + str + "\" invoked failed: " + e.getMessage());
            return obj2;
        }
    }

    public static void rg(String str) {
        qw = str;
    }

    /* renamed from: switch  reason: not valid java name */
    public static void m223switch(Context context) {
        try {
            String de2 = ad.ad(context).de("lcsdk_xml", "apkName", "");
            if (!TextUtils.isEmpty(de2)) {
                String[] fileList = context.getApplicationContext().fileList();
                for (String str : fileList) {
                    if (str.endsWith(".apk") && str.contains(de2)) {
                        context.getApplicationContext().deleteFile(str);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean th(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        for (NetworkInfo networkInfo : connectivityManager.getAllNetworkInfo()) {
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static boolean uk(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    @TargetApi(9)
    public static Object[] when(Context context) {
        Object qw2;
        if (Build.VERSION.SDK_INT >= 9 && (qw2 = qw((StorageManager) context.getSystemService("storage"), "getVolumeList", (Class[]) null, (Object[]) null)) != null) {
            return (Object[]) qw2;
        }
        return null;
    }

    public static PackageInfo yj(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }
}
