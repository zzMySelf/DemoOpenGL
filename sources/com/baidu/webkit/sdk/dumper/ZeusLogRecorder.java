package com.baidu.webkit.sdk.dumper;

import android.app.ActivityManager;
import android.os.Process;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import com.baidu.webkit.sdk.dumper.ZeusLogUploader;
import java.io.File;
import java.io.Writer;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ZeusLogRecorder extends ZeusCrashHandler {
    /* access modifiers changed from: private */
    public static String TAG = "ZeusLogRecorder";
    private static ZeusLogRecorder instance;
    public List<String> fileNameList = new ArrayList();
    private boolean isFilterLogRecord;
    /* access modifiers changed from: private */
    public boolean isUploading;
    /* access modifiers changed from: private */
    public List<LogRecordBean> list = new ArrayList();
    /* access modifiers changed from: private */
    public OnFinishedUploadLogListener listener;
    private Lock lock = new ReentrantLock();
    private File logDir;
    private ZeusCrashHandler.ZeusCrashHandlerClient mClient;
    private File mLogFile;
    private int mPid;
    private ZeusLogUploader mUploader;
    private String recordPrefName = "recordlog";
    /* access modifiers changed from: private */
    public AtomicInteger unUploadFileSize;

    public interface OnFinishedUploadLogListener {
        void onFinishedUploadLog(List<LogRecordBean> list, String str);
    }

    public static ZeusLogRecorder getInstance() {
        synchronized (ZeusLogRecorder.class) {
            if (instance == null) {
                instance = new ZeusLogRecorder();
            }
        }
        return instance;
    }

    private ZeusLogRecorder() {
        super((Thread.UncaughtExceptionHandler) null);
        try {
            File file = new File(WebViewFactory.getContext().getFilesDir(), this.recordPrefName);
            this.logDir = file;
            if (file.exists() && !this.logDir.isDirectory()) {
                this.logDir.delete();
            }
            if (!this.logDir.exists()) {
                this.logDir.mkdirs();
            }
        } catch (Throwable th2) {
            Log.e(TAG, Log.getStackTraceString(th2));
        }
        this.mPid = Process.myPid();
        this.mUploader = new ZeusLogUploader(this.recordPrefName, (String) null, true);
        this.mClient = new ZeusCrashHandler.ZeusCrashHandlerClient(this);
        this.isFilterLogRecord = this.isFilterLogRecord;
    }

    public void setListener(OnFinishedUploadLogListener onFinishedUploadLogListener) {
        this.listener = onFinishedUploadLogListener;
    }

    public class LogRecordBean {
        private String upLoadFileName;
        private boolean uploadSuccess;

        public LogRecordBean(String str, boolean z) {
            this.upLoadFileName = str;
            this.uploadSuccess = z;
        }

        public void setUpLoadFileName(String str) {
            this.upLoadFileName = str;
        }

        public String getUpLoadFileName() {
            return this.upLoadFileName;
        }

        public boolean isUploadSuccess() {
            return this.uploadSuccess;
        }

        public void setUploadSuccess(boolean z) {
            this.uploadSuccess = z;
        }
    }

    public void initAndUpload() {
        Log.i(TAG, "[ZeusLogRecorder] initAndUpload");
        new Thread() {
            public void run() {
                try {
                    synchronized (ZeusLogRecorder.this) {
                        ZeusLogRecorder.this.showToastAndLog(Thread.currentThread().getId() + " isUploading: " + ZeusLogRecorder.this.isUploading);
                        if (ZeusLogRecorder.this.isUploading) {
                            ZeusLogRecorder.this.showToastAndLog("some log is uploadiing now, please retry after a few minuite");
                            return;
                        }
                        boolean unused = ZeusLogRecorder.this.isUploading = true;
                        ZeusLogRecorder.this.uploadLogRecord();
                    }
                } catch (Exception e2) {
                    Log.e(ZeusLogRecorder.TAG, Log.getStackTraceString(e2));
                    ZeusLogRecorder.this.quitUploadLog();
                }
            }
        }.start();
    }

    public void shouldWaitForUploadiing() {
    }

    class WatchThread extends Thread {
        boolean over = false;
        Process p;
        ArrayList<String> stream;
        private final Writer writer;

        public WatchThread(Process process, Writer writer2) {
            this.p = process;
            this.writer = writer2;
            this.stream = new ArrayList<>();
        }

        public void run() {
            try {
                if (this.p != null) {
                    Scanner scanner = new Scanner(this.p.getInputStream());
                    this.writer.write("Logcat:\n");
                    while (this.p != null && !this.over && !Thread.interrupted()) {
                        while (scanner.hasNextLine()) {
                            String nextLine = scanner.nextLine();
                            if (!(!ZeusLogRecorder.this.isProcessIdInLine(nextLine) || nextLine == null || nextLine.trim().length() == 0)) {
                                this.writer.write(nextLine);
                                this.writer.write("\n");
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                Log.e(ZeusLogRecorder.TAG, Log.getStackTraceString(e2));
            }
        }

        public void setOver(boolean z) {
            this.over = z;
        }

        public ArrayList<String> getStream() {
            return this.stream;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[SYNTHETIC, Splitter:B:15:0x0032] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean generateLogRecord(java.io.File r4) {
        /*
            r3 = this;
            r0 = 0
            java.io.BufferedWriter r1 = new java.io.BufferedWriter     // Catch:{ all -> 0x002c }
            java.io.FileWriter r2 = new java.io.FileWriter     // Catch:{ all -> 0x002c }
            r2.<init>(r4)     // Catch:{ all -> 0x002c }
            r1.<init>(r2)     // Catch:{ all -> 0x002c }
            r3.dumpExtraLogcatInfo(r1)     // Catch:{ all -> 0x0029 }
            java.lang.String r4 = "===============end==============="
            r1.write(r4)     // Catch:{ all -> 0x0029 }
            java.lang.String r4 = "\n\n"
            r1.write(r4)     // Catch:{ all -> 0x0029 }
            r1.close()     // Catch:{ all -> 0x001d }
            goto L_0x0027
        L_0x001d:
            r4 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r4 = com.baidu.webkit.sdk.Log.getStackTraceString(r4)
            com.baidu.webkit.sdk.Log.e(r0, r4)
        L_0x0027:
            r4 = 1
            return r4
        L_0x0029:
            r4 = move-exception
            r0 = r1
            goto L_0x002d
        L_0x002c:
            r4 = move-exception
        L_0x002d:
            r4.printStackTrace()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0040
            r0.close()     // Catch:{ all -> 0x0036 }
            goto L_0x0040
        L_0x0036:
            r4 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r4 = com.baidu.webkit.sdk.Log.getStackTraceString(r4)
            com.baidu.webkit.sdk.Log.e(r0, r4)
        L_0x0040:
            r4 = 0
            return r4
        L_0x0042:
            r4 = move-exception
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ all -> 0x0049 }
            goto L_0x0053
        L_0x0049:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r0 = com.baidu.webkit.sdk.Log.getStackTraceString(r0)
            com.baidu.webkit.sdk.Log.e(r1, r0)
        L_0x0053:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.sdk.dumper.ZeusLogRecorder.generateLogRecord(java.io.File):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a6 A[SYNTHETIC, Splitter:B:36:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00aa A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad A[SYNTHETIC, Splitter:B:41:0x00ad] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dumpExtraLogcatInfo(java.io.Writer r9) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            java.lang.String r1 = "Logcat:"
            java.lang.String r2 = "logcat"
            java.lang.String r3 = "-d"
            java.lang.String r4 = "-t5000"
            java.lang.String r5 = "-vthreadtime"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5}     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            java.lang.ProcessBuilder r3 = new java.lang.ProcessBuilder     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            r3.<init>(r2)     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            java.lang.Process r2 = r3.start()     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            r4.<init>(r5)     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            r3.<init>(r4)     // Catch:{ InterruptedException -> 0x00a0, Exception -> 0x0090 }
            com.baidu.webkit.sdk.dumper.ZeusLogRecorder$WatchThread r0 = new com.baidu.webkit.sdk.dumper.ZeusLogRecorder$WatchThread     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            r0.<init>(r2, r9)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            r0.start()     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            r2.waitFor()     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            r2 = 1
            r0.setOver(r2)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            r0.interrupt()     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            r4 = 0
            r5 = r4
        L_0x003c:
            boolean r6 = r0.isAlive()     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            if (r6 == 0) goto L_0x0062
            r6 = 1000(0x3e8, double:4.94E-321)
            java.lang.Thread.sleep(r6)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            int r6 = r5 + 1
            r7 = 30
            if (r5 <= r7) goto L_0x0060
            java.lang.String r0 = TAG     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            java.lang.String r5 = "thread over %1$d secs, WatchThread is still alive"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            int r6 = r6 * 20
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            r2[r4] = r6     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            com.baidu.webkit.sdk.Log.e((java.lang.String) r0, (java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            goto L_0x0062
        L_0x0060:
            r5 = r6
            goto L_0x003c
        L_0x0062:
            boolean r0 = r8.isProcessIdInLine(r1)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            if (r0 == 0) goto L_0x0070
            r9.write(r1)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            java.lang.String r0 = "\n"
            r9.write(r0)     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
        L_0x0070:
            java.lang.String r1 = r3.readLine()     // Catch:{ InterruptedException -> 0x008b, Exception -> 0x0088, all -> 0x0085 }
            if (r1 != 0) goto L_0x0062
            r3.close()     // Catch:{ all -> 0x007a }
            return
        L_0x007a:
            r9 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r9 = com.baidu.webkit.sdk.Log.getStackTraceString(r9)
            com.baidu.webkit.sdk.Log.e(r0, r9)
            return
        L_0x0085:
            r9 = move-exception
            r0 = r3
            goto L_0x00ab
        L_0x0088:
            r9 = move-exception
            r0 = r3
            goto L_0x0091
        L_0x008b:
            r9 = move-exception
            r0 = r3
            goto L_0x00a1
        L_0x008e:
            r9 = move-exception
            goto L_0x00ab
        L_0x0090:
            r9 = move-exception
        L_0x0091:
            java.lang.String r1 = TAG     // Catch:{ all -> 0x008e }
            java.lang.String r2 = com.baidu.webkit.sdk.Log.getStackTraceString(r9)     // Catch:{ all -> 0x008e }
            com.baidu.webkit.sdk.Log.e(r1, r2)     // Catch:{ all -> 0x008e }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ all -> 0x008e }
            r1.<init>(r9)     // Catch:{ all -> 0x008e }
            throw r1     // Catch:{ all -> 0x008e }
        L_0x00a0:
            r9 = move-exception
        L_0x00a1:
            r9.printStackTrace()     // Catch:{ all -> 0x008e }
            if (r0 == 0) goto L_0x00aa
            r0.close()     // Catch:{ all -> 0x007a }
            return
        L_0x00aa:
            return
        L_0x00ab:
            if (r0 == 0) goto L_0x00bb
            r0.close()     // Catch:{ all -> 0x00b1 }
            goto L_0x00bb
        L_0x00b1:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r0 = com.baidu.webkit.sdk.Log.getStackTraceString(r0)
            com.baidu.webkit.sdk.Log.e(r1, r0)
        L_0x00bb:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.webkit.sdk.dumper.ZeusLogRecorder.dumpExtraLogcatInfo(java.io.Writer):void");
    }

    /* access modifiers changed from: private */
    public boolean isProcessIdInLine(String str) {
        if (this.isFilterLogRecord) {
            return str.contains(new StringBuilder().append(this.mPid).toString());
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void uploadLogRecord() throws Exception {
        Log.i(TAG, Thread.currentThread() + " begin to upload log files");
        setCrashTime(System.currentTimeMillis());
        Log.i(TAG, "generate log file");
        File logFile = this.mClient.getLogFile("recordlog-" + getCurrentProcessName() + "-" + Process.myPid() + "-", this.recordPrefName);
        this.mLogFile = logFile;
        this.fileNameList.add(logFile.getName());
        showToastAndLog("log file " + this.mLogFile.getName() + " is generating now, maybe wait more than a minute");
        if (!generateLogRecord(this.mLogFile)) {
            Log.e(TAG, "[ZeusLogRecorder] create log file error");
        }
        if (this.fileNameList.contains(this.mLogFile.getName())) {
            this.fileNameList.remove(this.mLogFile.getName());
        }
        Log.i(TAG, "logDir path: %1$s", this.logDir.getAbsolutePath());
        File[] directoryFiles = getDirectoryFiles(this.logDir);
        if (directoryFiles == null || directoryFiles.length == 0) {
            Log.i(TAG, "files count in directory recordlog is 0, set isUploading = false");
            this.isUploading = false;
            quitUploadLog();
            return;
        }
        showToastAndLog("Start uploading files");
        this.unUploadFileSize = new AtomicInteger(directoryFiles.length);
        this.mUploader.uploadLogDirectory(this.logDir.getAbsolutePath(), true, new ZeusLogUploader.OnFinishedListener() {
            public void onFinished(String str, int i2, String str2) {
                int decrementAndGet = ZeusLogRecorder.this.unUploadFileSize.decrementAndGet();
                if (decrementAndGet < 0) {
                    Log.e(ZeusLogRecorder.TAG, "upload file over length, file name is %1$s: ", str);
                    ZeusLogRecorder.this.quitUploadLog();
                    return;
                }
                boolean z = i2 == 0;
                String substring = str.substring(str.lastIndexOf("/") + 1);
                Log.i(ZeusLogRecorder.TAG, "upload %1$s %2$s", substring, Boolean.valueOf(z));
                ZeusLogRecorder.this.list.add(new LogRecordBean(substring, z));
                if (decrementAndGet == 0) {
                    ZeusLogRecorder.this.showToastAndLog("Finish uploading files!");
                    boolean unused = ZeusLogRecorder.this.isUploading = false;
                    if (ZeusLogRecorder.this.listener != null) {
                        ZeusLogRecorder.this.listener.onFinishedUploadLog(ZeusLogRecorder.this.list, str2);
                    }
                    ZeusLogRecorder.this.quitUploadLog();
                }
            }
        });
        Log.i(TAG, "upload log finished");
    }

    /* access modifiers changed from: private */
    public void showToastAndLog(String str) {
        Log.i(TAG, "[ZeusLogRecorder] %1$s", str);
    }

    /* access modifiers changed from: private */
    public void quitUploadLog() {
    }

    private File[] getDirectoryFiles(File file) {
        if (!file.exists()) {
            return null;
        }
        return file.listFiles(new ZeusLogUploader.LogFilter(this.recordPrefName));
    }

    private static String getCurrentProcessName() {
        int myPid = Process.myPid();
        String str = "";
        for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) WebViewFactory.getContext().getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
            if (next.pid == myPid) {
                str = next.processName;
            }
        }
        return str;
    }
}
