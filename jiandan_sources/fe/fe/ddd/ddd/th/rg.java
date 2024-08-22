package fe.fe.ddd.ddd.th;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import fe.fe.ddd.ddd.de.de.de;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class rg {
    public static final boolean qw = AppConfig.rg();

    public static class qw implements Comparator<Map.Entry<String, String>> {
        /* renamed from: qw */
        public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
            return entry.getKey().compareTo(entry2.getKey());
        }
    }

    public static yj ad(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new yj(jSONObject.optString("jobid"), jSONObject.optString("valid"));
    }

    public static String de(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                String string = jSONObject.getString(next);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(next, string);
                }
            } catch (JSONException e) {
                if (qw) {
                    e.printStackTrace();
                }
            }
        }
        ArrayList<Map.Entry> arrayList = new ArrayList<>(hashMap.entrySet());
        Collections.sort(arrayList, new qw());
        for (Map.Entry entry : arrayList) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) entry.getValue());
        }
        stringBuffer.append(str);
        return de.de(stringBuffer.toString().getBytes(), false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject qw(@androidx.annotation.NonNull fe.fe.ddd.ddd.th.uk r6) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x009b }
            r1.<init>()     // Catch:{ JSONException -> 0x009b }
            java.lang.String r0 = "type"
            java.lang.String r2 = r6.th()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "value"
            java.lang.String r2 = r6.yj()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "jobid"
            java.lang.String r2 = r6.de()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "version"
            java.lang.String r2 = r6.uk()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = r6.rg()     // Catch:{ JSONException -> 0x0098 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0098 }
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "status"
            java.lang.String r2 = r6.rg()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0098 }
        L_0x003d:
            java.lang.String r0 = r6.fe()     // Catch:{ JSONException -> 0x0098 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0098 }
            if (r0 != 0) goto L_0x0050
            java.lang.String r0 = "origin"
            java.lang.String r2 = r6.fe()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0098 }
        L_0x0050:
            java.lang.String r0 = r6.ad()     // Catch:{ JSONException -> 0x0098 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0098 }
            if (r0 != 0) goto L_0x0063
            java.lang.String r0 = "filemeta"
            java.lang.String r2 = r6.ad()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r2)     // Catch:{ JSONException -> 0x0098 }
        L_0x0063:
            java.lang.String r0 = r6.qw()     // Catch:{ JSONException -> 0x0098 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ JSONException -> 0x0098 }
            if (r0 != 0) goto L_0x0076
            java.lang.String r0 = "fileid"
            java.lang.String r6 = r6.qw()     // Catch:{ JSONException -> 0x0098 }
            r1.put(r0, r6)     // Catch:{ JSONException -> 0x0098 }
        L_0x0076:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0098 }
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ JSONException -> 0x0098 }
            r4 = 1
            long r4 = r6.toMillis(r4)     // Catch:{ JSONException -> 0x0098 }
            long r2 = r2 / r4
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r0 = "timestamp"
            r1.put(r0, r6)     // Catch:{ JSONException -> 0x0098 }
            java.lang.String r6 = "sign"
            java.lang.String r0 = "fetchlog"
            java.lang.String r0 = de(r1, r0)     // Catch:{ JSONException -> 0x0098 }
            r1.put(r6, r0)     // Catch:{ JSONException -> 0x0098 }
            goto L_0x00a4
        L_0x0098:
            r6 = move-exception
            r0 = r1
            goto L_0x009c
        L_0x009b:
            r6 = move-exception
        L_0x009c:
            boolean r1 = qw
            if (r1 == 0) goto L_0x00a3
            r6.printStackTrace()
        L_0x00a3:
            r1 = r0
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.ddd.th.rg.qw(fe.fe.ddd.ddd.th.uk):org.json.JSONObject");
    }
}
