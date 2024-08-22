package com.baidu.monitor;

import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import com.baidu.android.util.io.Closeables;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

public class MonitorMetaData {
    private static final boolean DEBUG = LokiMonitor.sDebug;
    private static final String KEY_CURRENT_TIME = "ctime";
    private static final String KEY_START_TIME = "stime";
    private static final String KEY_STATUS = "status";
    public static final int STATUS_CREATED = 0;
    public static final int STATUS_FINISH_UPLOAD = 5;
    public static final int STATUS_FINISH_WRITE = 2;
    public static final int STATUS_INVALID_VALUE = -1;
    public static final int STATUS_MAX_VALUE = 5;
    public static final int STATUS_MIN_VALUE = 0;
    public static final int STATUS_UBC_PREPARING = 3;
    public static final int STATUS_UPLOADING = 4;
    public static final int STATUS_WRITING = 1;
    public static final String SUFFIX_META = ".meta";
    private static final String TAG = "LokiMonitor";
    long currentTime;
    private File mMetaFile;
    long startTime;
    int status;

    public MonitorMetaData(File file) {
        this.mMetaFile = file;
    }

    public static MonitorMetaData toMetaData(File metaFile) {
        if (metaFile == null) {
            return null;
        }
        if (DEBUG) {
            Log.d(TAG, "toMetaData metaFile: " + metaFile.getAbsolutePath());
        }
        if (!metaFile.exists()) {
            return null;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(metaFile));
            while (true) {
                String readLine = br.readLine();
                String line = readLine;
                if (readLine == null) {
                    break;
                }
                String line2 = line.trim();
                if (!TextUtils.isEmpty(line2)) {
                    boolean z = DEBUG;
                    if (z) {
                        Log.d(TAG, "toMetaData metaFile content: " + line2);
                    }
                    JSONObject jsonObject = new JSONObject(line2);
                    if (jsonObject.has(KEY_START_TIME) && jsonObject.has("ctime") && jsonObject.has("status")) {
                        long stime = jsonObject.optLong(KEY_START_TIME, -1);
                        long ctime = jsonObject.optLong("ctime", -1);
                        int status2 = jsonObject.optInt("status", -1);
                        if (z) {
                            Log.d(TAG, "toMetaData stime=" + stime + ", ctime=" + ctime + ", status=" + status2);
                        }
                        if (stime > 0 && ctime > 0 && status2 >= 0) {
                            if (status2 <= 5) {
                                MonitorMetaData metaData = new MonitorMetaData(metaFile);
                                metaData.startTime = stime;
                                metaData.currentTime = ctime;
                                metaData.status = status2;
                                Closeables.closeSafely((Closeable) br);
                                return metaData;
                            }
                        }
                        Closeables.closeSafely((Closeable) br);
                        return null;
                    }
                }
            }
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) null);
            throw th2;
        }
        Closeables.closeSafely((Closeable) br);
        return null;
    }

    public void writeToFile() {
        File file = this.mMetaFile;
        if (file != null && file.exists()) {
            JsonWriter jsonWriter = null;
            try {
                jsonWriter = new JsonWriter(new FileWriter(this.mMetaFile));
                jsonWriter.beginObject();
                jsonWriter.name(KEY_START_TIME).value(this.startTime);
                jsonWriter.name("ctime").value(this.currentTime);
                jsonWriter.name("status").value((long) this.status);
                jsonWriter.endObject();
                jsonWriter.flush();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (Throwable th2) {
                Closeables.closeSafely((Closeable) jsonWriter);
                throw th2;
            }
            Closeables.closeSafely((Closeable) jsonWriter);
        }
    }

    public String toString() {
        return "MonitorMetaData{startTime=" + this.startTime + ", currentTime=" + this.currentTime + ", status=" + this.status + AbstractJsonLexerKt.END_OBJ;
    }
}
