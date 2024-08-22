package com.yy.sdk.crashreportbaidu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrashLog {
    public static final int DEFAULT_BUFF_SIZE = 81920;
    private static final Object mLock = new Object();
    private static volatile String mLogPath;
    private static BufferedWriter mWriter;

    private static boolean setLogPath(String logDir) {
        if (logDir == null || logDir.length() == 0) {
            return false;
        }
        new File(logDir).mkdirs();
        mLogPath = logDir.endsWith(File.separator) ? logDir : logDir + File.separator;
        mLogPath += ReportUtils.getCrashId() + ".syslog";
        Log.i("CrashLog", "Log file path : " + mLogPath);
        File logFile = new File(mLogPath);
        if (logFile.exists()) {
            logFile.delete();
        }
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        try {
            mWriter = new BufferedWriter(new FileWriter(mLogPath, true), DEFAULT_BUFF_SIZE);
        } catch (Exception e3) {
            e3.printStackTrace();
            mWriter = null;
        }
        return true;
    }

    public static String getlogPath() {
        return mLogPath;
    }

    public static void writeLog(String tag, String msg) {
        writeLog(tag, msg, true);
    }

    public static void writeLog(String tag, String msg, boolean out2Console) {
        if (out2Console) {
            Log.i(tag, msg);
        }
        try {
            synchronized (mLock) {
                if (mWriter == null) {
                    setLogPath(ReportUtils.getDumpDirectory());
                    return;
                }
                long currentTime = System.currentTimeMillis();
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                new Date(currentTime);
                mWriter.write(String.format("%s\n", new Object[]{msg}));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void flush() {
        synchronized (mLock) {
            BufferedWriter bufferedWriter = mWriter;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void close() {
        synchronized (mLock) {
            BufferedWriter bufferedWriter = mWriter;
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    mWriter.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            mWriter = null;
        }
    }
}
