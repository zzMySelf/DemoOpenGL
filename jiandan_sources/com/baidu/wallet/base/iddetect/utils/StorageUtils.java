package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.os.Environment;
import com.baidu.apollon.permission.PermissionManager;
import com.baidu.sapi2.SapiOptions;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.File;
import java.io.IOException;

public final class StorageUtils {
    public static final String EXTERNAL_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    public static final String TAG = "StorageUtils";

    public static File getCacheDirectory(Context context) {
        File file = new File(context.getCacheDir(), "idcard_cache");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getExternalCacheDir(Context context) {
        File file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), SapiOptions.KEY_CACHE);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                LogUtil.d(TAG, "Unable to create external cache directory");
                return null;
            }
            try {
                new File(file, ".nomedia").createNewFile();
            } catch (IOException unused) {
                LogUtil.d(TAG, "Can't create \".nomedia\" file in application external cache directory");
            }
        }
        return file;
    }

    public static boolean hasExternalStoragePermission(Context context) {
        return PermissionManager.checkCallingPermission(context, EXTERNAL_STORAGE_PERMISSION);
    }

    public static File getCacheDirectory(Context context, boolean z) {
        String str;
        try {
            str = Environment.getExternalStorageState();
        } catch (NullPointerException unused) {
            str = "";
        }
        File externalCacheDir = (!z || !"mounted".equals(str) || !hasExternalStoragePermission(context)) ? null : getExternalCacheDir(context);
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir;
        }
        String str2 = "/data/data/" + context.getPackageName() + "/cache/";
        LogUtil.d(TAG, "Can't define system cache directory! " + str2 + "will be used.");
        return new File(str2);
    }
}
