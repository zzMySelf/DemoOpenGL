package com.baidu.searchbox.music.player.lyrics.tools;

import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.music.player.lyrics.text.CharsetDetector;
import com.baidu.searchbox.music.player.lyrics.text.CharsetMatch;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class LyricPathHelper {
    private static final int BUF_SIZE = 1024;
    private static final String DIR_HOME = "baidu_music_sdk";
    private static final String DIR_LYRIC = "lyric";
    private static final char EXTENSION_SEPARATOR = '.';
    public static final String SYSTEM_SEPARATOR = System.getProperty("file.separator");
    private static final char UNIX_SEPARATOR = '/';

    public static void checkLyricDirectorys() {
        Iterator<File> it = getTingMp3AllDirectory().iterator();
        while (it.hasNext()) {
            FileUtils.ensureDirectoryExist(it.next());
        }
    }

    public static ArrayList<File> getTingMp3AllDirectory() {
        ArrayList<File> dirList = new ArrayList<>();
        dirList.add(new File(getTingHomePath()));
        dirList.add(new File(getTingLyricPath()));
        return dirList;
    }

    public static String getExternalStoragePath() {
        try {
            return AppRuntime.getAppContext().getPackageManager().getPackageInfo(AppRuntime.getAppContext().getPackageName(), 0).applicationInfo.dataDir + "/files";
        } catch (Exception e2) {
            return AppRuntime.getAppContext().getFilesDir().getAbsolutePath();
        }
    }

    public static String getTingHomePath() {
        return getExternalStoragePath() + SYSTEM_SEPARATOR + DIR_HOME;
    }

    public static String getTingLyricPath() {
        return getTingHomePath() + SYSTEM_SEPARATOR + "lyric";
    }

    public static String getExtension(String uri) {
        int extensionIndex;
        if (uri != null && uri.lastIndexOf(47) <= (extensionIndex = uri.lastIndexOf(46)) && extensionIndex >= 0) {
            return uri.substring(extensionIndex + 1);
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
        r2.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0062, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x007a, code lost:
        if (com.baidu.searchbox.config.AppConfig.isDebug() == false) goto L_0x007d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFileToBytes(java.io.File r6) {
        /*
            if (r6 != 0) goto L_0x0004
            r0 = 0
            return r0
        L_0x0004:
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            r1.<init>()
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0065, SecurityException -> 0x004d, IOException -> 0x0035 }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0065, SecurityException -> 0x004d, IOException -> 0x0035 }
            r0 = r2
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0065, SecurityException -> 0x004d, IOException -> 0x0035 }
        L_0x0014:
            int r4 = r0.read(r3)     // Catch:{ FileNotFoundException -> 0x0065, SecurityException -> 0x004d, IOException -> 0x0035 }
            r5 = -1
            if (r4 == r5) goto L_0x0023
            r4 = 0
            r1.write(r3, r4, r2)     // Catch:{ FileNotFoundException -> 0x0065, SecurityException -> 0x004d, IOException -> 0x0035 }
            byte[] r4 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0065, SecurityException -> 0x004d, IOException -> 0x0035 }
            r3 = r4
            goto L_0x0014
        L_0x0023:
            r0.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0027:
            goto L_0x007d
        L_0x0028:
            r2 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r3 == 0) goto L_0x0027
        L_0x002f:
            r2.printStackTrace()
            goto L_0x0027
        L_0x0033:
            r2 = move-exception
            goto L_0x0082
        L_0x0035:
            r2 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x003f
            r2.printStackTrace()     // Catch:{ all -> 0x0033 }
        L_0x003f:
            if (r0 == 0) goto L_0x007d
            r0.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0027
        L_0x0045:
            r2 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r3 == 0) goto L_0x0027
            goto L_0x002f
        L_0x004d:
            r2 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x0057
            r2.printStackTrace()     // Catch:{ all -> 0x0033 }
        L_0x0057:
            if (r0 == 0) goto L_0x007d
            r0.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0027
        L_0x005d:
            r2 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r3 == 0) goto L_0x0027
            goto L_0x002f
        L_0x0065:
            r2 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x0033 }
            if (r3 == 0) goto L_0x006f
            r2.printStackTrace()     // Catch:{ all -> 0x0033 }
        L_0x006f:
            if (r0 == 0) goto L_0x007d
            r0.close()     // Catch:{ IOException -> 0x0075 }
            goto L_0x0027
        L_0x0075:
            r2 = move-exception
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r3 == 0) goto L_0x0027
            goto L_0x002f
        L_0x007d:
            byte[] r2 = r1.toByteArray()
            return r2
        L_0x0082:
            if (r0 == 0) goto L_0x0092
            r0.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x0092
        L_0x0088:
            r3 = move-exception
            boolean r4 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r4 == 0) goto L_0x0092
            r3.printStackTrace()
        L_0x0092:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.music.player.lyrics.tools.LyricPathHelper.readFileToBytes(java.io.File):byte[]");
    }

    public static String getFileCharset(byte[] sourceFileBytes) {
        CharsetMatch charsetMatch = new CharsetDetector().setText(sourceFileBytes).detect();
        if (charsetMatch == null) {
            return "ISO-8859-1";
        }
        return charsetMatch.getName();
    }

    public static String getLyricFilePath(String lyricUrl) {
        if (TextUtils.isEmpty(lyricUrl)) {
            return "";
        }
        String savePath = getTingLyricPath();
        String ext = getExtension(lyricUrl);
        if (TextUtils.isEmpty(ext)) {
            ext = "lrc";
        }
        return savePath + SYSTEM_SEPARATOR + (MD5Util.toMd5(lyricUrl.getBytes(), false) + "." + ext);
    }

    public static boolean isLyricFileExit(String lyricPath) {
        try {
            return !TextUtils.isEmpty(lyricPath) && new File(lyricPath).exists();
        } catch (Throwable th2) {
            return false;
        }
    }
}
