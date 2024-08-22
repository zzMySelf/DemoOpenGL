package com.baidu.searchbox.lockscreen.util;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TestFileUtil {
    public static boolean DEBUG = LockScreenUtil.GLOBAL_DEBUG;
    public static String FILE_NAME = "lockscreen.txt";
    public static String FILE_PATH = "lockscreen";

    public static String getDefaultFilePath() {
        File lockscreenRootDir = AppRuntime.getAppContext().getExternalFilesDir("");
        if (lockscreenRootDir == null) {
            lockscreenRootDir = AppRuntime.getAppContext().getFilesDir();
        }
        File file = new File(lockscreenRootDir, FILE_PATH);
        if (file.exists() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static synchronized void appendRecord(String content) {
        synchronized (TestFileUtil.class) {
            appendRecord(content, FILE_NAME);
        }
    }

    public static synchronized void appendRecord(String content, String fileName) {
        synchronized (TestFileUtil.class) {
            if (DEBUG && !TextUtils.isEmpty(getDefaultFilePath())) {
                writeFile(getDefaultFilePath(), fileName, transTime() + content);
            }
        }
    }

    public static void writeFile(String path, String fileName, String content) {
        makeFilePath(path, fileName);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(new File(path, fileName), true));
            out.write(content);
            out.newLine();
            out.newLine();
            out.flush();
            if (DEBUG) {
                Log.e("TestFileUtil", "写入成功");
            }
        } catch (Exception e2) {
            if (DEBUG) {
                e2.printStackTrace();
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
        Closeables.closeSafely((Closeable) out);
    }

    private static void makeFilePath(String path, String fileName) {
        File filePath = new File(path);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        File file = new File(path, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String transTime() {
        return new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
    }
}
