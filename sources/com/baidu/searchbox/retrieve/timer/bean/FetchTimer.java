package com.baidu.searchbox.retrieve.timer.bean;

public class FetchTimer extends FetchBasicTimer {
    private static final String END_TIME = "endTime";
    private static final String FREQUENCY = "frequency";
    private static final String MAX_TOTAL_FILE_SIZE = "maxTotalFileSize";
    private static final String NETWORK = "network";
    private static final String SPACE = "space";
    private static final String START_TIME = "startTime";

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.searchbox.retrieve.timer.bean.FetchTimerBean parseJsonContent(org.json.JSONObject r32) {
        /*
            r1 = r32
            r2 = 0
            if (r1 != 0) goto L_0x0006
            return r2
        L_0x0006:
            com.baidu.searchbox.retrieve.timer.bean.FetchTimerBasicBean r3 = com.baidu.searchbox.retrieve.timer.bean.FetchBasicTimer.parseJsonContent(r32)
            if (r3 != 0) goto L_0x000d
            return r2
        L_0x000d:
            java.lang.String r0 = "info"
            org.json.JSONObject r4 = r1.optJSONObject(r0)
            if (r4 != 0) goto L_0x0016
            return r2
        L_0x0016:
            java.lang.String r13 = r3.getType()
            java.lang.String r0 = "timer_upload_yalog"
            boolean r0 = android.text.TextUtils.equals(r0, r13)
            if (r0 != 0) goto L_0x0024
            return r2
        L_0x0024:
            java.lang.String r14 = r3.getJobId()
            java.lang.String r11 = r3.getVersion()
            long r9 = r3.getExpiredTime()     // Catch:{ Exception -> 0x00bf }
            java.lang.String r0 = "startTime"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r5 = "endTime"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ Exception -> 0x00bf }
            r20 = r5
            long r5 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00bf }
            r7 = 1000(0x3e8, double:4.94E-321)
            long r21 = r5 * r7
            long r5 = java.lang.Long.parseLong(r20)     // Catch:{ Exception -> 0x00bf }
            long r23 = r5 * r7
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00bf }
            r5.<init>()     // Catch:{ Exception -> 0x00bf }
            r12 = r5
            java.lang.String r5 = "space"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ Exception -> 0x00bf }
            r8 = r5
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00bf }
            if (r5 != 0) goto L_0x0078
            java.lang.String r5 = ","
            java.lang.String[] r5 = r8.split(r5)     // Catch:{ Exception -> 0x006f }
            java.util.List r5 = java.util.Arrays.asList(r5)     // Catch:{ Exception -> 0x006f }
            r12.addAll(r5)     // Catch:{ Exception -> 0x006f }
            goto L_0x0078
        L_0x006f:
            r0 = move-exception
            r30 = r3
            r31 = r4
            r2 = r11
            r3 = r13
            r4 = r14
            goto L_0x00c7
        L_0x0078:
            java.lang.String r5 = "network"
            java.lang.String r18 = r4.optString(r5)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r5 = "maxTotalFileSize"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ Exception -> 0x00bf }
            r25 = r5
            long r15 = java.lang.Long.parseLong(r25)     // Catch:{ Exception -> 0x00bf }
            java.lang.String r5 = "frequency"
            java.lang.String r5 = r4.optString(r5)     // Catch:{ Exception -> 0x00bf }
            r26 = r5
            boolean r5 = android.text.TextUtils.isEmpty(r26)     // Catch:{ Exception -> 0x00bf }
            if (r5 == 0) goto L_0x009d
            reportTaskCheckFail(r13, r14, r11, r1)     // Catch:{ Exception -> 0x006f }
        L_0x009d:
            int r19 = java.lang.Integer.parseInt(r26)     // Catch:{ Exception -> 0x00bf }
            com.baidu.searchbox.retrieve.timer.bean.FetchTimerBean r27 = new com.baidu.searchbox.retrieve.timer.bean.FetchTimerBean     // Catch:{ Exception -> 0x00bf }
            r5 = r27
            r6 = r14
            r7 = r13
            r28 = r8
            r8 = r11
            r2 = r11
            r29 = r12
            r11 = r21
            r30 = r3
            r31 = r4
            r3 = r13
            r4 = r14
            r13 = r23
            r17 = r29
            r5.<init>(r6, r7, r8, r9, r11, r13, r15, r17, r18, r19)     // Catch:{ Exception -> 0x00bd }
            return r27
        L_0x00bd:
            r0 = move-exception
            goto L_0x00c7
        L_0x00bf:
            r0 = move-exception
            r30 = r3
            r31 = r4
            r2 = r11
            r3 = r13
            r4 = r14
        L_0x00c7:
            reportTaskCheckFail(r3, r4, r2, r1)
            boolean r5 = DEBUG
            if (r5 == 0) goto L_0x00d7
            java.lang.String r5 = r0.getMessage()
            java.lang.String r6 = "FetchTimerData"
            android.util.Log.d(r6, r5)
        L_0x00d7:
            reportTaskCheckFail(r3, r4, r2, r1)
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.retrieve.timer.bean.FetchTimer.parseJsonContent(org.json.JSONObject):com.baidu.searchbox.retrieve.timer.bean.FetchTimerBean");
    }
}
