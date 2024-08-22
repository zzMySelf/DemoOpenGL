package com.baidu.searchbox.aps.center.install.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.megapp.ma.Util;
import com.baidu.nadcore.utils.ZipUtils;
import com.baidu.nps.utils.Constant;
import com.baidu.ops.lc.patchupdate.GDiffPatcher;
import com.baidu.searchbox.aps.base.Plugin;
import com.baidu.searchbox.aps.base.utils.BaseConfiger;
import com.baidu.searchbox.aps.base.utils.CommonUtils;
import com.baidu.searchbox.aps.center.install.download.PluginDownloadManager;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;

public class PluginIncrementalInstallUtils {
    private static final int FILE_STREAM_BUFFER_SIZE = 8192;
    private static final String TAG = "PluginIncrementalInstallUtils";

    private static File getInstalledPluginFile(Context context, String packageName) {
        String installedPath = Util.getInstalledApkPath(context, packageName);
        if (!TextUtils.isEmpty(installedPath)) {
            return new File(installedPath);
        }
        return null;
    }

    public static File incrementalUpgrade(Context context, Plugin plugin, PluginDownloadManager.DownloadInfo info) {
        if (plugin == null || info == null || TextUtils.isEmpty(info.filePath)) {
            return null;
        }
        File patchGzipFile = new File(info.filePath);
        File sourceFile = getInstalledPluginFile(context, plugin.getPackageName());
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "incrementalUpgrade: sourceFile=" + sourceFile.getAbsolutePath());
        }
        File patchFile = patchGzipFile;
        if (isGzipFile(patchGzipFile)) {
            if (BaseConfiger.isDebug()) {
                Log.d(TAG, "incrementalUpgrade: is gzip file!");
            }
            patchFile = new File(patchGzipFile.getParentFile().getPath() + File.separator + plugin.getPackageName() + Constant.FILE.SUFFIX.APK_PATCH_SUFFIX);
            if (!unGzipFile(patchGzipFile, patchFile)) {
                if (BaseConfiger.isDebug()) {
                    Log.d(TAG, "incrementalUpgrade: ungzip failed!");
                }
                patchFile = null;
            }
        }
        if (patchFile == null) {
            return null;
        }
        File outputFile = new File(patchFile.getParentFile(), getCombineApkName(plugin.getPackageName()));
        if (outputFile.exists()) {
            outputFile.delete();
        }
        boolean success = patchFile(sourceFile, patchFile, outputFile);
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "incrementalUpgrade: patchFile " + success);
        }
        if (!success || !outputFile.exists()) {
            return outputFile;
        }
        String md5 = plugin.fullApkMd5;
        if (!TextUtils.isEmpty(md5) && isMd5Correct(outputFile, md5)) {
            return outputFile;
        }
        if (BaseConfiger.isDebug()) {
            Log.d(TAG, "incrementalUpgrade: outputFile md5=" + CommonUtils.toMd5(outputFile, false) + ", md5=" + md5);
        }
        return null;
    }

    private static String getCombineApkName(String packageName) {
        return packageName + "_" + System.currentTimeMillis() + ".apk";
    }

    private static boolean isGzipFile(File srcFile) {
        if (srcFile == null || !srcFile.exists()) {
            return false;
        }
        byte[] fileType = new byte[4];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(srcFile);
            fis.read(fileType);
            if (ZipUtils.GZIP_FILE_NAME.equalsIgnoreCase(CommonUtils.toHexString(fileType, "", true))) {
                CommonUtils.closeSafely(fis);
                return true;
            }
        } catch (Exception e2) {
            if (BaseConfiger.isDebug()) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            CommonUtils.closeSafely((Closeable) null);
            throw th2;
        }
        CommonUtils.closeSafely(fis);
        return false;
    }

    private static boolean unGzipFile(File srcFile, File outFile) {
        if (srcFile == null) {
            return false;
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        GZIPInputStream gzip = null;
        try {
            fis = new FileInputStream(srcFile);
            gzip = new GZIPInputStream(fis);
            fos = new FileOutputStream(outFile);
            byte[] buf = new byte[8192];
            while (true) {
                int read = gzip.read(buf, 0, buf.length);
                int num = read;
                if (read != -1) {
                    fos.write(buf, 0, num);
                } else {
                    fos.flush();
                    return true;
                }
            }
        } catch (Exception e2) {
            if (BaseConfiger.isDebug()) {
                e2.printStackTrace();
            }
            return false;
        } finally {
            CommonUtils.closeSafely(fis);
            CommonUtils.closeSafely(fos);
            CommonUtils.closeSafely(gzip);
        }
    }

    private static boolean patchFile(File sourceFile, File patchFile, File outputFile) {
        if (sourceFile == null || patchFile == null || outputFile == null) {
            return false;
        }
        try {
            new GDiffPatcher().patch(sourceFile, patchFile, outputFile);
            return true;
        } catch (Exception e2) {
            if (!BaseConfiger.isDebug()) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean isMd5Correct(File file, String md5) {
        if (file == null || TextUtils.isEmpty(md5) || !TextUtils.equals(CommonUtils.toMd5(file, false), md5.toLowerCase())) {
            return false;
        }
        return true;
    }
}
