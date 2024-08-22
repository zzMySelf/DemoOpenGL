package com.baidu.swan.support.v4.conent;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.io.File;

public class ContextCompat {
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    private static final String TAG = "ContextCompat";

    public static boolean startActivities(Context context, Intent[] intents) {
        return startActivities(context, intents, (Bundle) null);
    }

    public static boolean startActivities(Context context, Intent[] intents, Bundle options) {
        return true;
    }

    public static File[] getObbDirs(Context context) {
        return ContextCompatKitKat.getObbDirs(context);
    }

    public static File[] getExternalFilesDirs(Context context, String type) {
        return ContextCompatKitKat.getExternalFilesDirs(context, type);
    }

    public static File[] getExternalCacheDirs(Context context) {
        return ContextCompatKitKat.getExternalCacheDirs(context);
    }

    private static File buildPath(File base, String... segments) {
        File cur = base;
        for (String segment : segments) {
            if (cur == null) {
                cur = new File(segment);
            } else if (segment != null) {
                cur = new File(cur, segment);
            }
        }
        return cur;
    }

    public static final Drawable getDrawable(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.getDrawable(context, id);
        }
        return context.getResources().getDrawable(id);
    }

    public static final ColorStateList getColorStateList(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ContextCompatApi23.getColorStateList(context, id);
        }
        return context.getResources().getColorStateList(id);
    }

    public static final int getColor(Context context, int id) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ContextCompatApi23.getColor(context, id);
        }
        return context.getResources().getColor(id);
    }

    public static int checkSelfPermission(Context context, String permission) {
        if (permission != null) {
            return context.checkPermission(permission, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public final File getNoBackupFilesDir(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.getNoBackupFilesDir(context);
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    public final File getCodeCacheDir(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ContextCompatApi21.getCodeCacheDir(context);
        }
        return createFilesDir(new File(context.getApplicationInfo().dataDir, "code_cache"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.io.File createFilesDir(java.io.File r4) {
        /*
            java.lang.Class<com.baidu.swan.support.v4.conent.ContextCompat> r0 = com.baidu.swan.support.v4.conent.ContextCompat.class
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0038 }
            if (r1 != 0) goto L_0x0036
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x0038 }
            if (r1 != 0) goto L_0x0036
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0038 }
            if (r1 == 0) goto L_0x0017
            monitor-exit(r0)
            return r4
        L_0x0017:
            java.lang.String r1 = "ContextCompat"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r2.<init>()     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = "Unable to create files subdir "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r3 = r4.getPath()     // Catch:{ all -> 0x0038 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0038 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0038 }
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0038 }
            r1 = 0
            monitor-exit(r0)
            return r1
        L_0x0036:
            monitor-exit(r0)
            return r4
        L_0x0038:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.support.v4.conent.ContextCompat.createFilesDir(java.io.File):java.io.File");
    }
}
