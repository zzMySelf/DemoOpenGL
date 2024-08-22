package com.baidu.sapi2.utils;

import com.baidu.sapi2.NoProguard;

public class SyncAccountUtils implements NoProguard {
    public static final String KEY_DISPLAYNAME = "displayname";
    public static final String KEY_DISPLAYNAME_TO_NA = "displayname_to_na";
    public static final String KEY_PORTRAIT_SIGN = "portraitSign";
    public static final String KEY_USERNAME = "username";
    public static final String TAG = "SyncAccountUtils";

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0077 A[SYNTHETIC, Splitter:B:41:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean syncAccount(java.lang.String r4, com.baidu.sapi2.SapiAccount r5) {
        /*
            r0 = 0
            r1 = 1
            if (r4 != 0) goto L_0x0010
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r5 = "data is null, please check FE sync data is OK"
            r4[r0] = r5
            java.lang.String r5 = "SyncAccountUtils"
            com.baidu.sapi2.utils.Log.e((java.lang.String) r5, (java.lang.Object[]) r4)
            return r0
        L_0x0010:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007f }
            r2.<init>(r4)     // Catch:{ JSONException -> 0x007f }
            java.lang.String r4 = "displayname_to_na"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x007f }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x007f }
            if (r3 != 0) goto L_0x0030
            java.lang.String r3 = r5.displayname     // Catch:{ JSONException -> 0x007f }
            boolean r3 = r4.equals(r3)     // Catch:{ JSONException -> 0x007f }
            if (r3 != 0) goto L_0x0030
            r5.displayname = r4     // Catch:{ JSONException -> 0x002d }
        L_0x002b:
            r0 = 1
            goto L_0x0047
        L_0x002d:
            r4 = move-exception
            r0 = 1
            goto L_0x0080
        L_0x0030:
            java.lang.String r4 = "displayname"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x007f }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x007f }
            if (r3 != 0) goto L_0x0047
            java.lang.String r3 = r5.displayname     // Catch:{ JSONException -> 0x007f }
            boolean r3 = r4.equals(r3)     // Catch:{ JSONException -> 0x007f }
            if (r3 != 0) goto L_0x0047
            r5.displayname = r4     // Catch:{ JSONException -> 0x002d }
            goto L_0x002b
        L_0x0047:
            java.lang.String r4 = "username"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x007f }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x007f }
            if (r3 != 0) goto L_0x005e
            java.lang.String r3 = r5.username     // Catch:{ JSONException -> 0x007f }
            boolean r3 = r4.equals(r3)     // Catch:{ JSONException -> 0x007f }
            if (r3 != 0) goto L_0x005e
            r5.username = r4     // Catch:{ JSONException -> 0x002d }
            r0 = 1
        L_0x005e:
            java.lang.String r4 = "portraitSign"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ JSONException -> 0x007f }
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x007f }
            if (r2 != 0) goto L_0x0075
            java.lang.String r2 = r5.portrait     // Catch:{ JSONException -> 0x007f }
            boolean r2 = r4.equals(r2)     // Catch:{ JSONException -> 0x007f }
            if (r2 != 0) goto L_0x0075
            r5.portrait = r4     // Catch:{ JSONException -> 0x002d }
            r0 = 1
        L_0x0075:
            if (r0 == 0) goto L_0x0083
            com.baidu.sapi2.SapiAccountManager r4 = com.baidu.sapi2.SapiAccountManager.getInstance()     // Catch:{ JSONException -> 0x007f }
            r4.validate(r5)     // Catch:{ JSONException -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r4 = move-exception
        L_0x0080:
            r4.printStackTrace()
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.utils.SyncAccountUtils.syncAccount(java.lang.String, com.baidu.sapi2.SapiAccount):boolean");
    }
}
