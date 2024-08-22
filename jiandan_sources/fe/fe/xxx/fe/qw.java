package fe.fe.xxx.fe;

/* compiled from: SapiCallBacks */
public final /* synthetic */ class qw {
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void $default$postResult(com.baidu.sapi2.booster.SapiCallBacks.EvalJavaScript r12, android.webkit.WebView r13, java.lang.String r14, com.baidu.sapi2.booster.SapiUtil.Command r15) {
        /*
            java.lang.String r0 = r15.getKey()
            java.lang.String r1 = r15.getActionName()
            r2 = 0
            r3 = 0
            r4 = 1
            java.util.List<java.lang.String> r5 = com.baidu.sapi2.booster.SapiUtil.SUCCESS_NO_RESULT_LIST     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            boolean r5 = r5.contains(r1)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            if (r5 == 0) goto L_0x0033
            java.lang.String r14 = com.baidu.sapi2.booster.SapiCallBacks.TAG     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r6.<init>()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r7 = "postResult: SUCCESS_NO_RESULT_LIST: "
            r6.append(r7)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r6.append(r1)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r6 = r6.toString()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r5[r3] = r6     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            com.baidu.sapi2.utils.Log.d(r14, r5)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r5 = r2
            r14 = 0
            goto L_0x00f0
        L_0x0033:
            java.lang.String r5 = "sapi_action_check_method_support"
            boolean r5 = r5.equals(r1)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r6 = ""
            java.lang.String r7 = "errmsg"
            java.lang.String r8 = "errno"
            if (r5 == 0) goto L_0x0068
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r5.<init>()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r5.put(r8, r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r5.put(r7, r6)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r5 = r5.toString()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r5 = com.baidu.sapi2.booster.SapiUtil.success(r0, r5)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r15.errno = r14     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r14 = com.baidu.sapi2.booster.SapiCallBacks.TAG     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r7 = "post result "
            r6[r3] = r7     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r6[r4] = r5     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            com.baidu.sapi2.utils.Log.d(r14, r6)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            goto L_0x00ef
        L_0x0068:
            java.lang.String r5 = com.baidu.sapi2.booster.SapiCallBacks.TAG     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r10.<init>()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r11 = "postResult: result: "
            r10.append(r11)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r10.append(r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r10 = r10.toString()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r9[r3] = r10     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            com.baidu.sapi2.utils.Log.d(r5, r9)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r5.<init>(r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r14 = -1
            int r9 = r5.optInt(r8, r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            if (r9 != 0) goto L_0x009c
            r5.put(r7, r6)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r14 = r5.toString()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r5 = com.baidu.sapi2.booster.SapiUtil.success(r0, r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            goto L_0x00ef
        L_0x009c:
            boolean r9 = r5.has(r8)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            if (r9 != 0) goto L_0x00b5
            r5.put(r8, r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            r5.put(r7, r6)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r14 = r5.toString()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r5 = com.baidu.sapi2.booster.SapiUtil.fail(r0, r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r14 = "-1"
            r15.errno = r14     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            goto L_0x00ef
        L_0x00b5:
            java.lang.String r14 = r5.toString()     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            java.lang.String r5 = com.baidu.sapi2.booster.SapiUtil.fail(r0, r14)     // Catch:{ NullPointerException -> 0x00c0, JSONException -> 0x00be }
            goto L_0x00ef
        L_0x00be:
            r14 = move-exception
            goto L_0x00c1
        L_0x00c0:
            r14 = move-exception
        L_0x00c1:
            java.lang.String r5 = com.baidu.sapi2.booster.SapiCallBacks.TAG
            java.lang.Object[] r6 = new java.lang.Object[r4]
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "postResult:  "
            r7.append(r8)
            r7.append(r1)
            java.lang.String r1 = ", msg:"
            r7.append(r1)
            java.lang.String r14 = r14.getMessage()
            r7.append(r14)
            java.lang.String r14 = r7.toString()
            r6[r3] = r14
            com.baidu.sapi2.utils.Log.e((java.lang.String) r5, (java.lang.Object[]) r6)
            java.lang.String r14 = "{\"errno\" : \"-1\", \"errmsg\" : \"\"}"
            java.lang.String r5 = com.baidu.sapi2.booster.SapiUtil.fail(r0, r14)
        L_0x00ef:
            r14 = 1
        L_0x00f0:
            r15.setEndTime()
            java.lang.String r15 = com.baidu.sapi2.booster.SapiCallBacks.TAG
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "postResult: final url: "
            r1.append(r4)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            com.baidu.sapi2.utils.Log.d(r15, r0)
            if (r14 == 0) goto L_0x0122
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 19
            if (r14 < r15) goto L_0x011b
            r13.evaluateJavascript(r5, r2)
            goto L_0x0122
        L_0x011b:
            java.lang.String r14 = com.baidu.sapi2.booster.SapiUtil.packUrl(r5)
            r13.loadUrl(r14)
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.xxx.fe.qw.$default$postResult(com.baidu.sapi2.booster.SapiCallBacks$EvalJavaScript, android.webkit.WebView, java.lang.String, com.baidu.sapi2.booster.SapiUtil$Command):void");
    }
}
