package com.baidu.monitor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LokiMonitor {
    private static final String DEFAULT_LOG_STORE_ROOT_DIR = "log_store";
    private static final String LOKI_MONITOR_DIR = "monitor";
    private static final String TAG = "LokiMonitor";
    private static Map<String, LokiMonitorSession> mCurrentSessions = new HashMap();
    public static File mMonitorRootDir;
    public static boolean sDebug = false;

    public static class LokiMonitorSession {
        public void onStage(String stage) {
        }

        public void onStage(String stage, Map<String, String> map) {
        }

        public void onStage(String stage, String key, String value) {
        }

        public void updateMetaStatus(int status) {
        }
    }

    public static class MonitorSessionImpl extends LokiMonitorSession {
        private BufferedWriter mBufferWriter = null;
        private Object mMetaUpdateLock = new Object();
        private File mSessionFile = null;
        private String mTraceId;

        public MonitorSessionImpl(String traceId) {
            this.mTraceId = traceId;
            try {
                if (LokiMonitor.mMonitorRootDir != null) {
                    File file = new File(LokiMonitor.mMonitorRootDir, traceId);
                    this.mSessionFile = file;
                    if (!file.exists()) {
                        this.mSessionFile.createNewFile();
                    }
                    if (this.mSessionFile.exists()) {
                        this.mBufferWriter = new BufferedWriter(new FileWriter(this.mSessionFile, true));
                    }
                }
            } catch (Throwable e2) {
                if (LokiMonitor.sDebug) {
                    e2.printStackTrace();
                }
            }
        }

        public void onStage(String stage) {
            onStage(stage, (Map<String, String>) null);
        }

        /* Debug info: failed to restart local var, previous not found, register: 3 */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0052, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0054, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void onStage(java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.String r0 = r3.mTraceId     // Catch:{ all -> 0x0055 }
                boolean r0 = com.baidu.monitor.LokiConfig.enableLokiMonitor(r0)     // Catch:{ all -> 0x0055 }
                if (r0 != 0) goto L_0x000b
                monitor-exit(r3)
                return
            L_0x000b:
                java.io.File r0 = r3.mSessionFile     // Catch:{ all -> 0x0055 }
                if (r0 == 0) goto L_0x0053
                java.io.BufferedWriter r0 = r3.mBufferWriter     // Catch:{ all -> 0x0055 }
                if (r0 != 0) goto L_0x0014
                goto L_0x0053
            L_0x0014:
                boolean r0 = com.baidu.monitor.LokiMonitor.sDebug     // Catch:{ all -> 0x0055 }
                if (r0 == 0) goto L_0x0031
                java.lang.String r0 = "LokiMonitor"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0055 }
                r1.<init>()     // Catch:{ all -> 0x0055 }
                java.lang.String r2 = "onStage: "
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0055 }
                java.lang.StringBuilder r1 = r1.append(r4)     // Catch:{ all -> 0x0055 }
                java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0055 }
                android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0055 }
            L_0x0031:
                java.io.File r0 = r3.mSessionFile     // Catch:{ all -> 0x0049 }
                boolean r0 = r0.exists()     // Catch:{ all -> 0x0049 }
                if (r0 != 0) goto L_0x003b
                monitor-exit(r3)
                return
            L_0x003b:
                org.json.JSONObject r0 = com.baidu.monitor.MonitorItemData.fromItemToJSON(r4, r5)     // Catch:{ all -> 0x0049 }
                if (r0 == 0) goto L_0x0048
                java.lang.String r1 = r0.toString()     // Catch:{ all -> 0x0049 }
                r3.appendLine(r1)     // Catch:{ all -> 0x0049 }
            L_0x0048:
                goto L_0x0051
            L_0x0049:
                r0 = move-exception
                boolean r1 = com.baidu.monitor.LokiMonitor.sDebug     // Catch:{ all -> 0x0055 }
                if (r1 == 0) goto L_0x0051
                r0.printStackTrace()     // Catch:{ all -> 0x0055 }
            L_0x0051:
                monitor-exit(r3)
                return
            L_0x0053:
                monitor-exit(r3)
                return
            L_0x0055:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.monitor.LokiMonitor.MonitorSessionImpl.onStage(java.lang.String, java.util.Map):void");
        }

        public void onStage(String stage, String key, String value) {
            Map<String, String> extra = new HashMap<>(1);
            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                extra.put(key, value);
            }
            onStage(stage, extra);
        }

        public void updateMetaStatus(int status) {
            File file;
            if (LokiMonitor.sDebug) {
                Log.d(LokiMonitor.TAG, "updateMetaStatus status:" + status);
            }
            if (status >= 0 && status <= 5 && (file = this.mSessionFile) != null && file.exists()) {
                synchronized (this.mMetaUpdateLock) {
                    File metaFile = new File(this.mSessionFile.getParentFile(), this.mTraceId + MonitorMetaData.SUFFIX_META);
                    MonitorMetaData metaData = null;
                    boolean isDirty = false;
                    if (LokiMonitor.sDebug) {
                        Log.d(LokiMonitor.TAG, "updateMetaStatus metaFile:" + metaFile.getName());
                    }
                    if (metaFile.exists()) {
                        metaData = MonitorMetaData.toMetaData(metaFile);
                    }
                    if (metaData == null) {
                        if (LokiMonitor.sDebug) {
                            Log.d(LokiMonitor.TAG, "updateMetaStatus create metaData");
                        }
                        metaData = new MonitorMetaData(metaFile);
                        metaData.startTime = this.mSessionFile.lastModified();
                        metaData.currentTime = System.currentTimeMillis();
                        metaData.status = status;
                        isDirty = true;
                    } else if (metaData.status != status) {
                        if (LokiMonitor.sDebug) {
                            Log.d(LokiMonitor.TAG, "updateMetaStatus update metaData");
                        }
                        metaData.status = status;
                        metaData.currentTime = System.currentTimeMillis();
                        isDirty = true;
                    }
                    if (isDirty && metaData != null) {
                        if (LokiMonitor.sDebug) {
                            Log.d(LokiMonitor.TAG, "updateMetaStatus writeToFile");
                        }
                        metaData.writeToFile();
                    }
                }
            }
        }

        private void appendLine(String content) {
            BufferedWriter bw;
            if (!TextUtils.isEmpty(content) && (bw = this.mBufferWriter) != null) {
                try {
                    bw.append(content);
                    bw.newLine();
                    bw.flush();
                } catch (IOException e2) {
                    if (LokiMonitor.sDebug) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static LokiMonitorSession getSession(String traceId) {
        LokiMonitorSession session;
        if (TextUtils.isEmpty(traceId) || !LokiConfig.enableLokiMonitor(traceId)) {
            return new LokiMonitorSession();
        }
        synchronized (mCurrentSessions) {
            session = mCurrentSessions.get(traceId);
            if (session == null) {
                session = new MonitorSessionImpl(traceId);
                mCurrentSessions.put(traceId, session);
            }
        }
        return session;
    }

    public static String getMonitorFilePath(String traceId) {
        File monitorDir;
        if (TextUtils.isEmpty(traceId) || !LokiConfig.enableLokiMonitor(traceId) || (monitorDir = mMonitorRootDir) == null || !monitorDir.exists()) {
            return null;
        }
        return new File(monitorDir, traceId).getAbsolutePath();
    }

    public static void initLokiMonitor(File file, boolean isDebug) {
        try {
            sDebug = isDebug;
            if (LokiConfig.enableLokiMonitor()) {
                if (file == null) {
                    file = new File(AppRuntime.getAppContext().getFilesDir(), DEFAULT_LOG_STORE_ROOT_DIR);
                }
                File file2 = new File(file, "monitor");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file2.exists()) {
                    mMonitorRootDir = file2;
                }
            }
        } catch (Throwable th2) {
        }
    }

    public static void onStage(String traceId, String stage) {
        getSession(traceId).onStage(stage);
    }

    public static void onStage(String traceId, String stage, Map<String, String> extraInfo) {
        getSession(traceId).onStage(stage, extraInfo);
    }

    public static void onStage(String traceId, String stage, String key, String value) {
        getSession(traceId).onStage(stage, key, value);
    }
}
