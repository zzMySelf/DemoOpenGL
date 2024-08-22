package com.baidu.searchbox.log.trace;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.ubc.UBCManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogTraceRecord {
    private static final String FROM_BLOCK = "1157";
    private static final String FROM_CRASH = "1156";
    private static final String TRACE_FILE = "logger_store/trace_record.txt";
    private static final String TRACE_UBC_FROM = "trace";
    private static final String TRACE_UBC_ID = "1347";

    public static void init() {
        TraceStep.init();
        TraceType.init();
        Constant.init();
    }

    public static void recordTraceState(String traceId, TraceType type, TraceStep step) {
        recordTraceContentAsync(traceId, type, step, (JSONObject) null);
    }

    public static void recordTraceState(String traceId, TraceType type, TraceStep step, JSONObject ext) {
        recordTraceContentAsync(traceId, type, step, ext);
    }

    public static void recordTraceStateSync(String traceId, TraceType type, TraceStep step) {
        recordTraceContentSync(traceId, type, step, (JSONObject) null);
    }

    public static void recordTraceStateSync(String traceId, TraceType type, TraceStep step, JSONObject ext) {
        recordTraceContentSync(traceId, type, step, ext);
    }

    private static void recordTraceContentAsync(final String traceId, final TraceType traceType, final TraceStep step, final JSONObject ext) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                LogTraceRecord.recordTraceContentSync(traceId, traceType, step, ext);
            }
        }, "logger_trace_log", 3);
    }

    /* access modifiers changed from: private */
    public static void recordTraceContentSync(String traceId, TraceType traceType, TraceStep step, JSONObject ext) {
        int bufSize;
        InputStreamReader isr;
        FileInputStream fis;
        InputStreamReader isr2;
        FileInputStream fis2;
        String str = traceId;
        TraceType traceType2 = traceType;
        TraceStep traceStep = step;
        JSONObject jSONObject = ext;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            JSONObject traceObject = new JSONObject();
            if (traceType2 == TraceType.BLOCK) {
                traceObject.put("from", "1157");
            }
            if (traceType2 == TraceType.JAVA_CRASH || traceType2 == TraceType.NATIVE_CRASH) {
                traceObject.put("from", "1156");
                traceObject.put(Constant.CRASH_TYPE, traceType.name().toLowerCase());
            }
            traceObject.put("step", step.name());
            if (jSONObject != null) {
                traceObject.put("ext", jSONObject);
            }
            if (AppConfig.isDebug()) {
                Log.d("LogTraceRecord", "recordTraceContent 打点 " + str + " step " + step.name() + " ext " + jSONObject);
            }
            File traceFile = new File(AppRuntime.getAppContext().getFilesDir(), TRACE_FILE);
            if (!traceFile.exists()) {
                traceFile.createNewFile();
            }
            FileInputStream fis3 = new FileInputStream(traceFile);
            InputStreamReader isr3 = new InputStreamReader(fis3);
            br = new BufferedReader(isr3);
            StringBuffer buf = new StringBuffer();
            int bufSize2 = 0;
            boolean added = false;
            while (true) {
                String readLine = br.readLine();
                String temp = readLine;
                if (readLine == null) {
                    break;
                }
                String[] tempData = temp.split("&");
                if (tempData.length <= 0) {
                    fis = fis3;
                    isr = isr3;
                } else if (!temp.contains("&")) {
                    fis = fis3;
                    isr = isr3;
                } else {
                    String tid = tempData[0];
                    if (TextUtils.equals(tid, str)) {
                        added = true;
                        fis2 = fis3;
                        if (!traceStep.equals(TraceStep.UPLOADED)) {
                            StringBuffer content = new StringBuffer();
                            isr2 = isr3;
                            content.append(tid).append("&").append(traceObject.toString());
                            buf.append(content);
                            buf.append(System.getProperty("line.separator"));
                            bufSize2 += content.toString().getBytes().length;
                        } else {
                            isr2 = isr3;
                        }
                    } else {
                        fis2 = fis3;
                        isr2 = isr3;
                        buf.append(temp);
                        buf.append(System.getProperty("line.separator"));
                        bufSize2 += temp.getBytes().length;
                    }
                    TraceType traceType3 = traceType;
                    JSONObject jSONObject2 = ext;
                    fis3 = fis2;
                    isr3 = isr2;
                }
                TraceType traceType4 = traceType;
                JSONObject jSONObject3 = ext;
                fis3 = fis;
                isr3 = isr;
            }
            InputStreamReader inputStreamReader = isr3;
            if (added || traceStep == TraceStep.UPLOADED) {
                bufSize = bufSize2;
            } else {
                StringBuffer content2 = new StringBuffer();
                content2.append(str).append("&").append(traceObject.toString());
                buf.append(content2);
                buf.append(System.getProperty("line.separator"));
                bufSize = bufSize2 + content2.toString().getBytes().length;
            }
            if (bufSize > 51200) {
                try {
                    br.close();
                } catch (IOException e2) {
                }
                if (pw != null) {
                    pw.close();
                    return;
                }
                return;
            }
            pw = new PrintWriter(new FileOutputStream(traceFile));
            pw.write(buf.toString().toCharArray());
            pw.flush();
            try {
                br.close();
            } catch (IOException e3) {
            }
            pw.close();
        } catch (Exception e4) {
            if (AppConfig.isDebug()) {
                e4.printStackTrace();
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e5) {
                }
            }
            if (pw == null) {
            }
        } catch (Throwable th2) {
            Throwable th3 = th2;
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e6) {
                }
            }
            if (pw != null) {
                pw.close();
            }
            throw th3;
        }
    }

    public static void checkFailTraceState() {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                JSONObject ext;
                try {
                    File traceFile = new File(AppRuntime.getAppContext().getFilesDir(), LogTraceRecord.TRACE_FILE);
                    if (traceFile.exists()) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(traceFile)));
                        JSONArray traceArray = new JSONArray();
                        while (true) {
                            String readLine = br.readLine();
                            String temp = readLine;
                            if (readLine == null) {
                                break;
                            }
                            String[] tempData = temp.split("&");
                            String tid = null;
                            if (tempData.length > 0) {
                                tid = tempData[0];
                            }
                            String extData = null;
                            if (tempData.length > 1) {
                                extData = tempData[1];
                            }
                            JSONObject traceItem = new JSONObject();
                            if (TextUtils.isEmpty(tid) || TextUtils.isEmpty(extData)) {
                            } else {
                                JSONObject extJson = new JSONObject(extData);
                                String from = extJson.optString("from");
                                String type = extJson.optString("step");
                                String crashType = extJson.optString(Constant.CRASH_TYPE);
                                JSONObject ext2 = extJson.optJSONObject("ext");
                                String[] strArr = tempData;
                                traceItem.put("traceid", tid);
                                if (!TextUtils.isEmpty(from)) {
                                    traceItem.put("from", from);
                                }
                                if (!TextUtils.isEmpty(type)) {
                                    traceItem.put("type", type.toLowerCase());
                                }
                                if (!TextUtils.isEmpty(crashType)) {
                                    if (ext2 == null) {
                                        ext = new JSONObject();
                                    } else {
                                        ext = ext2;
                                    }
                                    ext.put("type", crashType);
                                } else {
                                    ext = ext2;
                                }
                                if (ext != null) {
                                    traceItem.put("ext", ext);
                                }
                                traceArray.put(traceItem);
                            }
                        }
                        br.close();
                        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                        if (ubc != null && traceArray.length() != 0) {
                            JSONObject data = new JSONObject();
                            JSONObject items = new JSONObject();
                            try {
                                data.put("from", "trace");
                                items.put("items", traceArray);
                                data.put("ext", items);
                                ubc.onEvent(LogTraceRecord.TRACE_UBC_ID, data);
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            if (AppConfig.isDebug()) {
                                Log.d("LogTraceRecord", "checkFailTraceState ubc data " + data);
                            }
                            StringBuffer buf = new StringBuffer();
                            PrintWriter pw = new PrintWriter(new FileOutputStream(traceFile));
                            pw.write(buf.toString().toCharArray());
                            pw.flush();
                            pw.close();
                        }
                    }
                } catch (Exception e3) {
                    if (AppConfig.isDebug()) {
                        e3.printStackTrace();
                    }
                }
            }
        }, "logger_trace_log", 3);
    }

    public static String getTraceID(String content) {
        JSONObject traceInfo;
        try {
            if (TextUtils.isEmpty(content) || (traceInfo = new JSONObject(content).optJSONObject(Constant.TRACE_INFO)) == null) {
                return null;
            }
            return traceInfo.optString("traceid");
        } catch (JSONException e2) {
            if (!AppConfig.isDebug()) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static JSONObject getTraceInfo(String content) {
        try {
            if (!TextUtils.isEmpty(content)) {
                return new JSONObject(content).optJSONObject(Constant.TRACE_INFO);
            }
            return null;
        } catch (JSONException e2) {
            if (!AppConfig.isDebug()) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public static String getCrashType(String content) {
        try {
            if (!TextUtils.isEmpty(content)) {
                return new JSONObject(content).optString("type");
            }
            return null;
        } catch (JSONException e2) {
            if (!AppConfig.isDebug()) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public enum TraceStep {
        OCCUR_START,
        OCCURRED,
        GENERATE_START,
        GENERATED,
        RECEIVED,
        SAVED,
        UPLOADED;

        public static void init() {
        }
    }

    public enum TraceType {
        JAVA_CRASH,
        NATIVE_CRASH,
        BLOCK;

        public static void init() {
        }
    }

    public static final class Constant {
        public static final String CRASH_TYPE = "crashtype";
        public static final String EXT = "ext";
        public static final String FROM = "from";
        public static final String ITEMS = "items";
        public static final String STEP = "step";
        public static final String TRACE_ID = "traceid";
        public static final String TRACE_INFO = "traceinfo";
        public static final String TYPE = "type";
        public static final String TYPE_JAVA = "JAVA";
        public static final String TYPE_NATIVE = "NATIVE";

        public static void init() {
        }
    }
}
