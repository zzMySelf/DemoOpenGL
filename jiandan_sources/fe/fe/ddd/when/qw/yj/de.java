package fe.fe.ddd.when.qw.yj;

import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.logsystem.logsys.LogExtra;
import com.baidu.searchbox.logsystem.util.AppExtraUtil;
import com.baidu.ubc.UBCManager;
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import fe.fe.ddd.i.qw.qw;
import fe.fe.ddd.mmm.qw.uk;
import fe.fe.ddd.when.fe.rg;
import fe.fe.ddd.when.fe.th;
import fe.fe.ddd.when.qw.yj.i.fe;
import fe.fe.ddd.when.yj.ad;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

public final class de {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ad A[Catch:{ IOException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00de A[Catch:{ IOException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e3 A[Catch:{ IOException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011c A[Catch:{ IOException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0171 A[Catch:{ IOException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0180 A[Catch:{ IOException -> 0x01aa }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x018d A[Catch:{ IOException -> 0x01aa }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void ad(@androidx.annotation.NonNull fe.fe.ddd.when.fe.rg r11, @androidx.annotation.Nullable java.util.List<fe.fe.ddd.when.fe.fe> r12, @androidx.annotation.NonNull android.util.JsonWriter r13) {
        /*
            java.lang.String r0 = "crashStage"
            java.lang.String r1 = "launchStage"
            com.baidu.searchbox.logsystem.logsys.LogExtra r2 = r11.fe()     // Catch:{ IOException -> 0x01aa }
            if (r2 == 0) goto L_0x01b2
            java.lang.String r3 = "content"
            r13.name(r3)     // Catch:{ IOException -> 0x01aa }
            r13.beginObject()     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = "page"
            android.util.JsonWriter r3 = r13.name(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = r2.mPage     // Catch:{ IOException -> 0x01aa }
            r3.value(r4)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = "type"
            android.util.JsonWriter r3 = r13.name(r3)     // Catch:{ IOException -> 0x01aa }
            com.baidu.searchbox.logsystem.logsys.LogType r4 = r11.qw     // Catch:{ IOException -> 0x01aa }
            com.baidu.searchbox.logsystem.logsys.LogType r5 = com.baidu.searchbox.logsystem.logsys.LogType.NATIVE_CRASH     // Catch:{ IOException -> 0x01aa }
            if (r4 != r5) goto L_0x002c
            java.lang.String r4 = "NATIVE"
            goto L_0x002e
        L_0x002c:
            java.lang.String r4 = "JAVA"
        L_0x002e:
            r3.value(r4)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = "crashtime"
            android.util.JsonWriter r3 = r13.name(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = r2.mCrashTime     // Catch:{ IOException -> 0x01aa }
            r3.value(r4)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = "launchTime"
            android.util.JsonWriter r3 = r13.name(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = r2.mLaunchTime     // Catch:{ IOException -> 0x01aa }
            r3.value(r4)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = "processLifeTime"
            android.util.JsonWriter r3 = r13.name(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = r2.mProcessLifeTime     // Catch:{ IOException -> 0x01aa }
            r3.value(r4)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = r2.mForeground     // Catch:{ IOException -> 0x01aa }
            if (r3 == 0) goto L_0x0061
            java.lang.String r3 = "foreground"
            android.util.JsonWriter r3 = r13.name(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = r2.mForeground     // Catch:{ IOException -> 0x01aa }
            r3.value(r4)     // Catch:{ IOException -> 0x01aa }
        L_0x0061:
            java.lang.String r3 = r11.ad()     // Catch:{ IOException -> 0x01aa }
            com.baidu.searchbox.logsystem.logsys.LogType r4 = r11.qw     // Catch:{ IOException -> 0x01aa }
            java.lang.String r4 = r4.getTypeName()     // Catch:{ IOException -> 0x01aa }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r6 = "stacktrace"
            java.lang.String r7 = ""
            if (r5 != 0) goto L_0x008b
            boolean r5 = r3.startsWith(r4)     // Catch:{ IOException -> 0x01aa }
            if (r5 == 0) goto L_0x008b
            java.lang.String r4 = java.util.regex.Matcher.quoteReplacement(r4)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = r3.replaceFirst(r4, r7)     // Catch:{ IOException -> 0x01aa }
            android.util.JsonWriter r4 = r13.name(r6)     // Catch:{ IOException -> 0x01aa }
            r4.value(r3)     // Catch:{ IOException -> 0x01aa }
            goto L_0x0092
        L_0x008b:
            android.util.JsonWriter r4 = r13.name(r6)     // Catch:{ IOException -> 0x01aa }
            r4.value(r3)     // Catch:{ IOException -> 0x01aa }
        L_0x0092:
            com.baidu.searchbox.logsystem.logsys.LogType r3 = r11.qw     // Catch:{ IOException -> 0x01aa }
            com.baidu.searchbox.logsystem.logsys.LogType r4 = com.baidu.searchbox.logsystem.logsys.LogType.NATIVE_CRASH     // Catch:{ IOException -> 0x01aa }
            if (r3 != r4) goto L_0x00e6
            if (r12 == 0) goto L_0x00e6
            int r3 = r12.size()     // Catch:{ IOException -> 0x01aa }
            if (r3 <= 0) goto L_0x00e6
            r3 = 0
            java.util.Iterator r12 = r12.iterator()     // Catch:{ IOException -> 0x01aa }
            r4 = 0
            r5 = r4
        L_0x00a7:
            boolean r6 = r12.hasNext()     // Catch:{ IOException -> 0x01aa }
            if (r6 == 0) goto L_0x00dc
            java.lang.Object r6 = r12.next()     // Catch:{ IOException -> 0x01aa }
            fe.fe.ddd.when.fe.fe r6 = (fe.fe.ddd.when.fe.fe) r6     // Catch:{ IOException -> 0x01aa }
            if (r6 == 0) goto L_0x00d9
            java.io.File r8 = r6.qw     // Catch:{ IOException -> 0x01aa }
            java.lang.String r8 = r8.getName()     // Catch:{ IOException -> 0x01aa }
            java.lang.String r9 = "minibdmp-"
            boolean r8 = r8.startsWith(r9)     // Catch:{ IOException -> 0x01aa }
            if (r8 == 0) goto L_0x00c8
            java.io.File r4 = r6.qw     // Catch:{ IOException -> 0x01aa }
        L_0x00c5:
            int r3 = r3 + 1
            goto L_0x00d9
        L_0x00c8:
            java.io.File r8 = r6.qw     // Catch:{ IOException -> 0x01aa }
            java.lang.String r8 = r8.getName()     // Catch:{ IOException -> 0x01aa }
            java.lang.String r9 = "json-extra_info"
            boolean r8 = r8.startsWith(r9)     // Catch:{ IOException -> 0x01aa }
            if (r8 == 0) goto L_0x00d9
            java.io.File r5 = r6.qw     // Catch:{ IOException -> 0x01aa }
            goto L_0x00c5
        L_0x00d9:
            r6 = 2
            if (r3 != r6) goto L_0x00a7
        L_0x00dc:
            if (r4 == 0) goto L_0x00e1
            fe.fe.ddd.when.qw.yj.fe.ad(r4, r13)     // Catch:{ IOException -> 0x01aa }
        L_0x00e1:
            if (r5 == 0) goto L_0x00e6
            fe.fe.ddd.when.qw.yj.fe.qw(r5, r13)     // Catch:{ IOException -> 0x01aa }
        L_0x00e6:
            java.lang.String r12 = "processName"
            android.util.JsonWriter r12 = r13.name(r12)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = r11.th()     // Catch:{ IOException -> 0x01aa }
            r12.value(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r12 = "crashThreadDes"
            r13.name(r12)     // Catch:{ IOException -> 0x01aa }
            r13.beginObject()     // Catch:{ IOException -> 0x01aa }
            java.lang.String r12 = "name"
            android.util.JsonWriter r12 = r13.name(r12)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = r2.mCrashThreadName     // Catch:{ IOException -> 0x01aa }
            r12.value(r3)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r12 = "priority"
            android.util.JsonWriter r12 = r13.name(r12)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = r2.mCrashThreadPriority     // Catch:{ IOException -> 0x01aa }
            r12.value(r3)     // Catch:{ IOException -> 0x01aa }
            r13.endObject()     // Catch:{ IOException -> 0x01aa }
            java.lang.String r12 = r2.mJSONAttach     // Catch:{ IOException -> 0x01aa }
            boolean r12 = android.text.TextUtils.isEmpty(r12)     // Catch:{ IOException -> 0x01aa }
            if (r12 != 0) goto L_0x0194
            java.lang.String r12 = "traceinfo"
            r13.name(r12)     // Catch:{ IOException -> 0x01aa }
            r13.beginObject()     // Catch:{ IOException -> 0x01aa }
            java.lang.String r12 = "traceid"
            android.util.JsonWriter r12 = r13.name(r12)     // Catch:{ IOException -> 0x01aa }
            java.lang.String r3 = r2.mTraceID     // Catch:{ IOException -> 0x01aa }
            r12.value(r3)     // Catch:{ IOException -> 0x01aa }
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x016b }
            java.lang.String r2 = r2.mJSONAttach     // Catch:{ JSONException -> 0x016b }
            r12.<init>(r2)     // Catch:{ JSONException -> 0x016b }
            java.lang.String r2 = r12.optString(r1)     // Catch:{ JSONException -> 0x016b }
            java.lang.String r7 = r12.optString(r0)     // Catch:{ JSONException -> 0x0166 }
            java.util.Iterator r3 = r12.keys()     // Catch:{ JSONException -> 0x0166 }
        L_0x0142:
            boolean r4 = r3.hasNext()     // Catch:{ JSONException -> 0x0166 }
            if (r4 == 0) goto L_0x0177
            java.lang.Object r4 = r3.next()     // Catch:{ JSONException -> 0x0166 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x0166 }
            boolean r5 = r1.equals(r4)     // Catch:{ JSONException -> 0x0166 }
            if (r5 != 0) goto L_0x0142
            boolean r5 = r0.equals(r4)     // Catch:{ JSONException -> 0x0166 }
            if (r5 != 0) goto L_0x0142
            android.util.JsonWriter r5 = r13.name(r4)     // Catch:{ JSONException -> 0x0166 }
            java.lang.String r4 = r12.optString(r4)     // Catch:{ JSONException -> 0x0166 }
            r5.value(r4)     // Catch:{ JSONException -> 0x0166 }
            goto L_0x0142
        L_0x0166:
            r12 = move-exception
            r10 = r7
            r7 = r2
            r2 = r10
            goto L_0x016d
        L_0x016b:
            r12 = move-exception
            r2 = r7
        L_0x016d:
            boolean r3 = fe.fe.ddd.when.yj.ad.qw     // Catch:{ IOException -> 0x01aa }
            if (r3 == 0) goto L_0x0174
            r12.getMessage()     // Catch:{ IOException -> 0x01aa }
        L_0x0174:
            r10 = r7
            r7 = r2
            r2 = r10
        L_0x0177:
            r13.endObject()     // Catch:{ IOException -> 0x01aa }
            boolean r12 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x01aa }
            if (r12 != 0) goto L_0x0187
            android.util.JsonWriter r12 = r13.name(r1)     // Catch:{ IOException -> 0x01aa }
            r12.value(r2)     // Catch:{ IOException -> 0x01aa }
        L_0x0187:
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IOException -> 0x01aa }
            if (r12 != 0) goto L_0x0194
            android.util.JsonWriter r12 = r13.name(r0)     // Catch:{ IOException -> 0x01aa }
            r12.value(r7)     // Catch:{ IOException -> 0x01aa }
        L_0x0194:
            java.lang.String r12 = "pageTrace"
            r13.name(r12)     // Catch:{ IOException -> 0x01aa }
            r13.beginArray()     // Catch:{ IOException -> 0x01aa }
            java.lang.String r11 = r11.th()     // Catch:{ IOException -> 0x01aa }
            de(r11, r13)     // Catch:{ IOException -> 0x01aa }
            r13.endArray()     // Catch:{ IOException -> 0x01aa }
            r13.endObject()     // Catch:{ IOException -> 0x01aa }
            goto L_0x01b2
        L_0x01aa:
            r11 = move-exception
            boolean r12 = fe.fe.ddd.when.yj.ad.qw
            if (r12 == 0) goto L_0x01b2
            r11.printStackTrace()
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.qw.yj.de.ad(fe.fe.ddd.when.fe.rg, java.util.List, android.util.JsonWriter):void");
    }

    public static void de(@NonNull String str, @NonNull JsonWriter jsonWriter) {
        JsonWriter jsonWriter2 = jsonWriter;
        File file = new File(th.o(str), "pre_p_activity_fragment_trace");
        if (file.exists()) {
            int i2 = 0;
            RandomAccessFile randomAccessFile = null;
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    long length = randomAccessFile2.length();
                    if (length > 0) {
                        long j = 1;
                        long j2 = length - 1;
                        while (true) {
                            if (j2 <= 0) {
                                break;
                            }
                            j2 -= j;
                            randomAccessFile2.seek(j2);
                            if (randomAccessFile2.readByte() == 10) {
                                String[] uk2 = uk.uk(randomAccessFile2.readLine());
                                if (uk2 != null && uk2.length == 4) {
                                    jsonWriter.beginObject();
                                    jsonWriter2.name("time").value(uk2[1]);
                                    jsonWriter2.name(UBCManager.CONTENT_KEY_PAGE).value(uk2[2]);
                                    jsonWriter2.name(NotificationCompat.CATEGORY_EVENT).value(uk2[3]);
                                    jsonWriter.endObject();
                                }
                                i2++;
                                if (i2 == 20) {
                                    break;
                                }
                            }
                            j = 1;
                        }
                        if (j2 == 0) {
                            randomAccessFile2.seek(0);
                            String[] uk3 = uk.uk(randomAccessFile2.readLine());
                            if (uk3 != null) {
                                jsonWriter.beginObject();
                                jsonWriter2.name("time").value(uk3[1]);
                                jsonWriter2.name(UBCManager.CONTENT_KEY_PAGE).value(uk3[2]);
                                jsonWriter2.name(NotificationCompat.CATEGORY_EVENT).value(uk3[3]);
                                jsonWriter.endObject();
                            }
                        }
                    }
                    Closeables.closeSafely((Closeable) randomAccessFile2);
                } catch (IOException e) {
                    e = e;
                    randomAccessFile = randomAccessFile2;
                    try {
                        e.printStackTrace();
                        Closeables.closeSafely((Closeable) randomAccessFile);
                    } catch (Throwable th2) {
                        th = th2;
                        Closeables.closeSafely((Closeable) randomAccessFile);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = randomAccessFile2;
                    Closeables.closeSafely((Closeable) randomAccessFile);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                Closeables.closeSafely((Closeable) randomAccessFile);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0073 A[Catch:{ all -> 0x006c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void fe(@androidx.annotation.NonNull fe.fe.ddd.when.fe.rg r5, @androidx.annotation.Nullable java.util.List<fe.fe.ddd.when.fe.fe> r6, @androidx.annotation.NonNull java.lang.String r7, @androidx.annotation.NonNull java.io.File r8) {
        /*
            java.lang.String r0 = "1"
            r1 = 0
            android.util.JsonWriter r2 = new android.util.JsonWriter     // Catch:{ IOException -> 0x006e }
            java.io.FileWriter r3 = new java.io.FileWriter     // Catch:{ IOException -> 0x006e }
            r3.<init>(r8)     // Catch:{ IOException -> 0x006e }
            r2.<init>(r3)     // Catch:{ IOException -> 0x006e }
            r2.beginObject()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r8 = "data"
            r2.name(r8)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r2.beginArray()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r2.beginObject()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r8 = "id"
            android.util.JsonWriter r8 = r2.name(r8)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r1 = "1156"
            r8.value(r1)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r8 = "timestamp"
            android.util.JsonWriter r8 = r2.name(r8)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r8.value(r3)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r8 = "idtype"
            android.util.JsonWriter r8 = r2.name(r8)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r8.value(r0)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r8 = "type"
            android.util.JsonWriter r8 = r2.name(r8)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r1 = "0"
            r8.value(r1)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            java.lang.String r8 = "isreal"
            android.util.JsonWriter r8 = r2.name(r8)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r8.value(r0)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            qw(r5, r7, r2)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            ad(r5, r6, r2)     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r2.endObject()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r2.endArray()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r2.endObject()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            r2.flush()     // Catch:{ IOException -> 0x0069, all -> 0x0066 }
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r2)
            goto L_0x0079
        L_0x0066:
            r5 = move-exception
            r1 = r2
            goto L_0x007a
        L_0x0069:
            r5 = move-exception
            r1 = r2
            goto L_0x006f
        L_0x006c:
            r5 = move-exception
            goto L_0x007a
        L_0x006e:
            r5 = move-exception
        L_0x006f:
            boolean r6 = fe.fe.ddd.when.yj.ad.qw     // Catch:{ all -> 0x006c }
            if (r6 == 0) goto L_0x0076
            r5.printStackTrace()     // Catch:{ all -> 0x006c }
        L_0x0076:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
        L_0x0079:
            return
        L_0x007a:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.qw.yj.de.fe(fe.fe.ddd.when.fe.rg, java.util.List, java.lang.String, java.io.File):void");
    }

    public static void qw(@NonNull rg rgVar, @NonNull String str, @NonNull JsonWriter jsonWriter) {
        try {
            jsonWriter.name("aperf");
            jsonWriter.beginObject();
            jsonWriter.name("launchid").value(rgVar.qw());
            jsonWriter.name("logid").value(UUID.randomUUID().toString());
            jsonWriter.name("appext").value(AppExtraUtil.qw());
            jsonWriter.name("packagename").value(qw.qw().getPackageName());
            String o2 = CommonUtils.o();
            if (o2 != null) {
                jsonWriter.name(UrlOcrConfig.IdCardKey.OS_VERSION).value(o2);
            }
            String uk2 = CommonUtils.uk();
            if (uk2 != null) {
                jsonWriter.name("memory").value(uk2);
            }
            String ppp = CommonUtils.ppp();
            if (ppp != null) {
                jsonWriter.name("root").value(ppp);
            }
            String de2 = CommonUtils.de();
            if (de2 != null) {
                jsonWriter.name("emulator").value(de2);
            }
            String th2 = CommonUtils.th();
            if (th2 != null) {
                jsonWriter.name("inStorage").value(th2);
            }
            String fe2 = CommonUtils.fe();
            if (fe2 != null) {
                jsonWriter.name("exStorage").value(fe2);
            }
            String when = CommonUtils.when();
            if (when != null) {
                jsonWriter.name("ROM").value(when);
            }
            String str2 = CommonUtils.m36switch();
            if (str2 != null) {
                jsonWriter.name("procBit").value(str2);
            }
            String ad2 = CommonUtils.ad();
            if (ad2 != null) {
                jsonWriter.name("cpu").value(ad2);
            }
            String ggg = CommonUtils.ggg("loki_config");
            if (ggg != null) {
                jsonWriter.name("sdkversion").value(ggg);
            }
            String qw = CommonUtils.qw();
            if (qw != null) {
                jsonWriter.name("appversion").value(qw);
            }
            jsonWriter.name("network").value(new fe().ad());
            String uk3 = th.qw().uk();
            if (!TextUtils.isEmpty(uk3)) {
                jsonWriter.name("devicescore").value(uk3);
            }
            jsonWriter.name("fileid").value(str);
            LogExtra fe3 = rgVar.fe();
            if (fe3 != null) {
                String str3 = fe3.mHeapMem;
                if (str3 != null) {
                    jsonWriter.name("heap").value(str3);
                }
                String str4 = fe3.mSysMem;
                if (str4 != null) {
                    jsonWriter.name("sysMem").value(str4);
                }
                if (fe3.mSysLowMem == 0) {
                    jsonWriter.name("isLowMemory").value(true);
                } else if (fe3.mSysLowMem == 1) {
                    jsonWriter.name("isLowMemory").value(false);
                }
                String str5 = fe3.mVSSRSS;
                if (str5 != null) {
                    jsonWriter.name("VSSRSS").value(str5);
                }
                String str6 = fe3.mPSS;
                if (str6 != null) {
                    jsonWriter.name("PSS").value(str6);
                }
            }
            jsonWriter.endObject();
        } catch (IOException e) {
            if (ad.qw) {
                e.printStackTrace();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void rg(@androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull java.io.File r11) {
        /*
            if (r10 == 0) goto L_0x0106
            if (r11 == 0) goto L_0x0106
            boolean r0 = r10.exists()
            if (r0 == 0) goto L_0x0106
            boolean r0 = r11.exists()
            if (r0 != 0) goto L_0x0012
            goto L_0x0106
        L_0x0012:
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            r3.<init>()     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            java.lang.String r4 = r11.getAbsolutePath()     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            r3.append(r4)     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            java.lang.String r4 = ".tmp"
            r3.append(r4)     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00d4, all -> 0x00cf }
            boolean r3 = fe.fe.ddd.when.yj.de.qw(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r4 = -1
            r5 = 0
            if (r3 == 0) goto L_0x006d
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r3.<init>(r6)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0069, all -> 0x0065 }
            r6.<init>(r10)     // Catch:{ IOException -> 0x0069, all -> 0x0065 }
        L_0x0048:
            int r10 = r6.read(r0)     // Catch:{ IOException -> 0x0062 }
            if (r10 == r4) goto L_0x0052
            r3.write(r0, r5, r10)     // Catch:{ IOException -> 0x0062 }
            goto L_0x0048
        L_0x0052:
            r3.flush()     // Catch:{ IOException -> 0x0062 }
            r3.close()     // Catch:{ IOException -> 0x0062 }
            r6.close()     // Catch:{ IOException -> 0x005f, all -> 0x005c }
            goto L_0x006d
        L_0x005c:
            r10 = move-exception
            goto L_0x00c2
        L_0x005f:
            r10 = move-exception
            goto L_0x00c7
        L_0x0062:
            r10 = move-exception
            goto L_0x00d8
        L_0x0065:
            r10 = move-exception
            r6 = r1
            goto L_0x00f1
        L_0x0069:
            r10 = move-exception
            r6 = r1
            goto L_0x00d8
        L_0x006d:
            java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            r10.<init>(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c4, all -> 0x00bf }
            r3.<init>(r11)     // Catch:{ IOException -> 0x00c4, all -> 0x00bf }
            r11 = 2
            byte[] r6 = new byte[r11]     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            r7 = 117(0x75, float:1.64E-43)
            r6[r5] = r7     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            r7 = 1
            r8 = 123(0x7b, float:1.72E-43)
            r6[r7] = r8     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            r3.write(r6)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            byte[] r11 = new byte[r11]     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            int r11 = r10.read(r11)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            if (r11 == r4) goto L_0x0098
        L_0x008e:
            int r11 = r10.read(r0)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            if (r11 == r4) goto L_0x0098
            r3.write(r0, r5, r11)     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            goto L_0x008e
        L_0x0098:
            r3.flush()     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            r3.close()     // Catch:{ IOException -> 0x00b8, all -> 0x00b1 }
            r10.close()     // Catch:{ IOException -> 0x00c4, all -> 0x00bf }
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x00ef
            goto L_0x00ec
        L_0x00b1:
            r11 = move-exception
            r6 = r10
            r10 = r11
            r9 = r3
            r3 = r1
            r1 = r9
            goto L_0x00f1
        L_0x00b8:
            r11 = move-exception
            r6 = r10
            r10 = r11
            r9 = r3
            r3 = r1
            r1 = r9
            goto L_0x00d8
        L_0x00bf:
            r11 = move-exception
            r6 = r10
            r10 = r11
        L_0x00c2:
            r3 = r1
            goto L_0x00f1
        L_0x00c4:
            r11 = move-exception
            r6 = r10
            r10 = r11
        L_0x00c7:
            r3 = r1
            goto L_0x00d8
        L_0x00c9:
            r10 = move-exception
            r3 = r1
            goto L_0x00d2
        L_0x00cc:
            r10 = move-exception
            r3 = r1
            goto L_0x00d7
        L_0x00cf:
            r10 = move-exception
            r2 = r1
            r3 = r2
        L_0x00d2:
            r6 = r3
            goto L_0x00f1
        L_0x00d4:
            r10 = move-exception
            r2 = r1
            r3 = r2
        L_0x00d7:
            r6 = r3
        L_0x00d8:
            r10.printStackTrace()     // Catch:{ all -> 0x00f0 }
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r3)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r6)
            if (r2 == 0) goto L_0x00ef
            boolean r10 = r2.exists()
            if (r10 == 0) goto L_0x00ef
        L_0x00ec:
            r2.delete()
        L_0x00ef:
            return
        L_0x00f0:
            r10 = move-exception
        L_0x00f1:
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r1)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r3)
            com.baidu.android.util.io.Closeables.closeSafely((java.io.Closeable) r6)
            if (r2 == 0) goto L_0x0105
            boolean r11 = r2.exists()
            if (r11 == 0) goto L_0x0105
            r2.delete()
        L_0x0105:
            throw r10
        L_0x0106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.when.qw.yj.de.rg(java.io.File, java.io.File):void");
    }
}
