package com.yy.transvod.preference.subprocess;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yy.render.trans.SimpleClientMessageSender;
import com.yy.transvod.common.ProcessTransData;
import com.yy.transvod.player.log.TLog;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class PreferenceClient extends SimpleClientMessageSender {
    private static int threadInitNumber = 0;
    /* access modifiers changed from: private */
    public final Gson gsonSend;
    private final String mChannelId;
    private final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "C-preference-" + PreferenceClient.nextThreadNum());
        }
    });
    private final String tag = "PreferenceClient";

    /* access modifiers changed from: private */
    public static synchronized int nextThreadNum() {
        int i2;
        synchronized (PreferenceClient.class) {
            i2 = threadInitNumber;
            threadInitNumber = i2 + 1;
        }
        return i2;
    }

    public PreferenceClient(String channelId) {
        super(channelId);
        this.mChannelId = channelId;
        this.gsonSend = new GsonBuilder().excludeFieldsWithModifiers(128, 8).serializeNulls().create();
    }

    public void initPreference() {
        this.singleThreadExecutor.execute(new Runnable() {
            public void run() {
                TLog.info("PreferenceClient", PreferenceCmd.initPreference);
                ProcessTransData data = new ProcessTransData();
                data.cmd = PreferenceCmd.initPreference;
                PreferenceClient preferenceClient = PreferenceClient.this;
                preferenceClient.sendDataToServer(preferenceClient.gsonSend.toJson((Object) data));
            }
        });
    }

    public void setMediaConfig(final HashMap<String, String> configs) {
        if (configs != null) {
            this.singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    TLog.info("PreferenceClient", PreferenceCmd.setMediaConfig);
                    String info = PreferenceClient.this.gsonSend.toJson((Object) configs);
                    ProcessTransData data = new ProcessTransData();
                    data.cmd = PreferenceCmd.setMediaConfig;
                    data.data.put("configs", info);
                    PreferenceClient preferenceClient = PreferenceClient.this;
                    preferenceClient.sendDataToServer(preferenceClient.gsonSend.toJson((Object) data));
                }
            });
        }
    }

    public void testSubprocessCrash() {
        this.singleThreadExecutor.execute(new Runnable() {
            public void run() {
                TLog.info("PreferenceClient", PreferenceCmd.testSubprocessCrash);
                ProcessTransData data = new ProcessTransData();
                data.cmd = PreferenceCmd.testSubprocessCrash;
                PreferenceClient preferenceClient = PreferenceClient.this;
                preferenceClient.sendDataToServer(preferenceClient.gsonSend.toJson((Object) data));
            }
        });
    }

    public void onBitmapFromServer(String s, Bitmap bitmap) {
    }

    public void onBundleFromServer(String s, Bundle bundle) {
    }

    public void onDataFromServer(String s, String s1) {
        if (s.equals(this.mChannelId)) {
            try {
                execCmd(s1);
            } catch (Exception e2) {
                e2.printStackTrace();
                TLog.error("PreferenceClient", "(onDataFromServer) ex" + e2.getMessage());
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void execCmd(java.lang.String r20) throws java.lang.Exception {
        /*
            r19 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r1 = r20
            r0.<init>(r1)
            java.lang.String r2 = "cmd"
            java.lang.String r2 = r0.optString(r2)
            int r3 = r2.hashCode()
            switch(r3) {
                case -1048965022: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0020
        L_0x0015:
            java.lang.String r3 = "onStatistics"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x0014
            r3 = 0
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            switch(r3) {
                case 0: goto L_0x0027;
                default: goto L_0x0024;
            }
        L_0x0024:
            r18 = r0
            goto L_0x006d
        L_0x0027:
            com.yy.transvod.preference.OnPlayerStatistics r3 = com.yy.transvod.preference.Preference.getStatisticsCallback()
            com.yy.transvod.player.OnPlayerStatisticsParams r12 = com.yy.transvod.preference.Preference.getStatisticsParamsCallback()
            java.lang.String r4 = "data"
            org.json.JSONObject r13 = r0.getJSONObject(r4)
            java.lang.String r4 = "taskId"
            int r14 = r13.optInt(r4)
            java.lang.String r4 = "type"
            int r15 = r13.optInt(r4)
            java.lang.String r4 = "text"
            java.lang.String r16 = r13.optString(r4)
            java.lang.String r4 = "stop"
            boolean r17 = r13.optBoolean(r4)
            r11 = r19
            java.util.concurrent.ExecutorService r10 = r11.singleThreadExecutor
            com.yy.transvod.preference.subprocess.PreferenceClient$5 r9 = new com.yy.transvod.preference.subprocess.PreferenceClient$5
            r4 = r9
            r5 = r19
            r6 = r3
            r7 = r15
            r8 = r14
            r18 = r0
            r0 = r9
            r9 = r16
            r1 = r10
            r10 = r12
            r11 = r17
            r4.<init>(r6, r7, r8, r9, r10, r11)
            r1.execute(r0)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.transvod.preference.subprocess.PreferenceClient.execCmd(java.lang.String):void");
    }

    public String onBitmapFromServerForStr(String s, Bitmap bitmap) {
        return null;
    }

    public String onBundleFromServerForStr(String s, Bundle bundle) {
        return null;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String onDataFromServerForStr(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = "PreferenceClient"
            java.lang.String r1 = ""
            java.lang.String r2 = r10.mChannelId
            boolean r2 = r11.equals(r2)
            if (r2 != 0) goto L_0x000d
            return r1
        L_0x000d:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0065 }
            r2.<init>(r12)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = "cmd"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r4 = "data"
            org.json.JSONObject r4 = r2.getJSONObject(r4)     // Catch:{ Exception -> 0x0065 }
            r5 = -1
            int r6 = r3.hashCode()     // Catch:{ Exception -> 0x0065 }
            switch(r6) {
                case 2015108602: goto L_0x0027;
                default: goto L_0x0026;
            }     // Catch:{ Exception -> 0x0065 }
        L_0x0026:
            goto L_0x0031
        L_0x0027:
            java.lang.String r6 = "onDnsHostResolve"
            boolean r6 = r3.equals(r6)     // Catch:{ Exception -> 0x0065 }
            if (r6 == 0) goto L_0x0026
            r5 = 0
        L_0x0031:
            switch(r5) {
                case 0: goto L_0x0035;
                default: goto L_0x0034;
            }     // Catch:{ Exception -> 0x0065 }
        L_0x0034:
            goto L_0x0064
        L_0x0035:
            com.yy.transvod.preference.OnDnsHostResolveCallback r5 = com.yy.transvod.preference.Preference.getDnsHostResolveCallback()     // Catch:{ Exception -> 0x0065 }
            if (r5 == 0) goto L_0x0063
            java.lang.String r6 = "hostName"
            java.lang.String r6 = r4.optString(r6)     // Catch:{ Exception -> 0x0065 }
            com.yy.transvod.preference.DnsHostInfo r7 = r5.onDnsHostResolve(r6)     // Catch:{ Exception -> 0x0065 }
            if (r7 == 0) goto L_0x0063
            java.lang.String r8 = com.yy.transvod.preference.DnsHostInfo.toJson(r7)     // Catch:{ Exception -> 0x0065 }
            r1 = r8
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0065 }
            r8.<init>()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r9 = "return DnsHostResolve result to subprocess:"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch:{ Exception -> 0x0065 }
            java.lang.StringBuilder r8 = r8.append(r1)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0065 }
            com.yy.transvod.player.log.TLog.info(r0, r8)     // Catch:{ Exception -> 0x0065 }
        L_0x0063:
        L_0x0064:
            goto L_0x0083
        L_0x0065:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "(onDataFromServerForStr) ex"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r4 = r2.getMessage()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.yy.transvod.player.log.TLog.error(r0, r3)
        L_0x0083:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yy.transvod.preference.subprocess.PreferenceClient.onDataFromServerForStr(java.lang.String, java.lang.String):java.lang.String");
    }

    public void onServiceCrash(String s) {
    }

    public void onLog(String s, int i2, String s1, String s2) {
    }
}
