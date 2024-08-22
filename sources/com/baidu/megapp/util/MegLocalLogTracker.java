package com.baidu.megapp.util;

import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public final class MegLocalLogTracker {
    public static final String PLUGIN_INSTALL_FAILURE = "plugin_install_failure";
    public static final String TAG = "MegLocalLogTracker";

    private MegLocalLogTracker() {
    }

    public static void store(String tag, String content) {
        if (MegUtils.isDebug() && !TextUtils.isEmpty(tag)) {
            Log.d(tag, content != null ? content : "");
        }
        if (MegUtils.isLogDebug()) {
            RecordManager.getInstance().addRecord(tag, content);
        }
    }

    public static final class RecordManager {
        private static RecordManager sInstance;
        private SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private List<Record> mRecords = new ArrayList();
        private RecordThread mThread;

        private RecordManager() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void addRecord(java.lang.String r5, java.lang.String r6) {
            /*
                r4 = this;
                monitor-enter(r4)
                boolean r0 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0046 }
                if (r0 == 0) goto L_0x0009
                monitor-exit(r4)
                return
            L_0x0009:
                com.baidu.megapp.util.MegLocalLogTracker$Record r0 = new com.baidu.megapp.util.MegLocalLogTracker$Record     // Catch:{ all -> 0x0046 }
                r0.<init>()     // Catch:{ all -> 0x0046 }
                r0.tag = r5     // Catch:{ all -> 0x0046 }
                r0.content = r6     // Catch:{ all -> 0x0046 }
                java.util.Calendar r1 = java.util.Calendar.getInstance()     // Catch:{ all -> 0x0046 }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0046 }
                r1.setTimeInMillis(r2)     // Catch:{ all -> 0x0046 }
                java.text.SimpleDateFormat r2 = r4.mFormat     // Catch:{ all -> 0x0046 }
                java.util.Date r3 = r1.getTime()     // Catch:{ all -> 0x0046 }
                java.lang.String r2 = r2.format(r3)     // Catch:{ all -> 0x0046 }
                r0.formattedTime = r2     // Catch:{ all -> 0x0046 }
                java.util.List<com.baidu.megapp.util.MegLocalLogTracker$Record> r2 = r4.mRecords     // Catch:{ all -> 0x0046 }
                r2.add(r0)     // Catch:{ all -> 0x0046 }
                com.baidu.megapp.util.MegLocalLogTracker$RecordThread r2 = r4.mThread     // Catch:{ all -> 0x0046 }
                if (r2 == 0) goto L_0x0038
                boolean r2 = r2.isRunning()     // Catch:{ all -> 0x0046 }
                if (r2 != 0) goto L_0x0044
            L_0x0038:
                com.baidu.megapp.util.MegLocalLogTracker$RecordThread r2 = new com.baidu.megapp.util.MegLocalLogTracker$RecordThread     // Catch:{ all -> 0x0046 }
                java.util.List<com.baidu.megapp.util.MegLocalLogTracker$Record> r3 = r4.mRecords     // Catch:{ all -> 0x0046 }
                r2.<init>(r3)     // Catch:{ all -> 0x0046 }
                r4.mThread = r2     // Catch:{ all -> 0x0046 }
                r2.start()     // Catch:{ all -> 0x0046 }
            L_0x0044:
                monitor-exit(r4)
                return
            L_0x0046:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.megapp.util.MegLocalLogTracker.RecordManager.addRecord(java.lang.String, java.lang.String):void");
        }

        public static RecordManager getInstance() {
            synchronized (RecordManager.class) {
                if (sInstance == null) {
                    sInstance = new RecordManager();
                }
            }
            return sInstance;
        }

        public static void release() {
            if (sInstance != null) {
                sInstance = null;
            }
        }
    }

    public static class Record {
        public String content;
        public String formattedTime;
        public String tag;

        public String toString() {
            return this.formattedTime + "\t" + this.tag + "\t" + this.content;
        }
    }

    public static class RecordThread extends Thread {
        private boolean mIsRunning;
        private List<Record> mRecords;

        public RecordThread(List<Record> records) {
            this.mRecords = records;
            if (records == null) {
                this.mIsRunning = false;
            } else {
                this.mIsRunning = true;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
            r2 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
            if (r2.hasNext() == false) goto L_0x0009;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
            r3 = r2.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
            if (r3 == null) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
            if (com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug() == false) goto L_0x0038;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
            android.util.Log.e(com.baidu.megapp.util.MegLocalLogTracker.TAG, r3.toString());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                r0 = 10
                android.os.Process.setThreadPriority(r0)
                com.baidu.megapp.util.MegLocalLogTracker$RecordManager r0 = com.baidu.megapp.util.MegLocalLogTracker.RecordManager.getInstance()
            L_0x0009:
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                monitor-enter(r0)
                java.util.List<com.baidu.megapp.util.MegLocalLogTracker$Record> r2 = r6.mRecords     // Catch:{ all -> 0x0057 }
                int r2 = r2.size()     // Catch:{ all -> 0x0057 }
                r3 = 0
                if (r2 != 0) goto L_0x001c
                r6.mIsRunning = r3     // Catch:{ all -> 0x0057 }
                monitor-exit(r0)     // Catch:{ all -> 0x0057 }
                return
            L_0x001c:
                java.util.List<com.baidu.megapp.util.MegLocalLogTracker$Record> r2 = r6.mRecords     // Catch:{ all -> 0x0057 }
                int r2 = r2.size()     // Catch:{ all -> 0x0057 }
                if (r2 <= 0) goto L_0x0033
                java.util.List<com.baidu.megapp.util.MegLocalLogTracker$Record> r2 = r6.mRecords     // Catch:{ all -> 0x0057 }
                java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0057 }
                r1.add(r2)     // Catch:{ all -> 0x0057 }
                java.util.List<com.baidu.megapp.util.MegLocalLogTracker$Record> r2 = r6.mRecords     // Catch:{ all -> 0x0057 }
                r2.remove(r3)     // Catch:{ all -> 0x0057 }
                goto L_0x001c
            L_0x0033:
                monitor-exit(r0)     // Catch:{ all -> 0x0057 }
                java.util.Iterator r2 = r1.iterator()
            L_0x0038:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x0056
                java.lang.Object r3 = r2.next()
                com.baidu.megapp.util.MegLocalLogTracker$Record r3 = (com.baidu.megapp.util.MegLocalLogTracker.Record) r3
                if (r3 == 0) goto L_0x0055
                boolean r4 = com.baidu.searchbox.aps.base.utils.BaseConfiger.isDebug()
                if (r4 == 0) goto L_0x0055
                java.lang.String r4 = "MegLocalLogTracker"
                java.lang.String r5 = r3.toString()
                android.util.Log.e(r4, r5)
            L_0x0055:
                goto L_0x0038
            L_0x0056:
                goto L_0x0009
            L_0x0057:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0057 }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.megapp.util.MegLocalLogTracker.RecordThread.run():void");
        }

        public boolean isRunning() {
            return this.mIsRunning;
        }
    }
}
