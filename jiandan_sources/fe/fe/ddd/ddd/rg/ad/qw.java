package fe.fe.ddd.ddd.rg.ad;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.inter.IFetchTask;
import fe.fe.vvv.ad.ad.ad;
import org.json.JSONObject;

public class qw {
    public static final boolean qw = AppConfig.rg();

    public static void ad(String str, String str2, String str3, JSONObject jSONObject) {
        ((IFetchTask) ad.qw(IFetchTask.qw)).qw(str, str2, str3, jSONObject);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static fe.fe.ddd.ddd.rg.ad.ad qw(org.json.JSONObject r20) {
        /*
            r1 = r20
            r2 = 0
            if (r1 != 0) goto L_0x0006
            return r2
        L_0x0006:
            java.lang.String r0 = "info"
            org.json.JSONObject r0 = r1.optJSONObject(r0)
            if (r0 != 0) goto L_0x000f
            return r2
        L_0x000f:
            java.lang.String r3 = "type"
            java.lang.String r3 = r1.optString(r3)
            java.lang.String r4 = "flow"
            boolean r4 = android.text.TextUtils.equals(r4, r3)
            if (r4 != 0) goto L_0x001e
            return r2
        L_0x001e:
            java.lang.String r4 = "jobId"
            java.lang.String r14 = r1.optString(r4)
            java.lang.String r4 = "version"
            java.lang.String r15 = r1.optString(r4)
            java.lang.String r4 = "expiredTime"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ Exception -> 0x00b2 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ Exception -> 0x00b2 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x00b2 }
            r6 = 1000(0x3e8, double:4.94E-321)
            long r8 = r4 * r6
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00b2 }
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x004e
            ad(r3, r14, r14, r1)     // Catch:{ Exception -> 0x0048 }
            return r2
        L_0x0048:
            r0 = move-exception
            r4 = r1
            r2 = r14
            r1 = r15
            goto L_0x00b7
        L_0x004e:
            java.lang.String r4 = "startTime"
            java.lang.String r4 = r0.optString(r4)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r5 = "endTime"
            java.lang.String r5 = r0.optString(r5)     // Catch:{ Exception -> 0x00b2 }
            long r10 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x00b2 }
            long r10 = r10 * r6
            long r4 = java.lang.Long.parseLong(r5)     // Catch:{ Exception -> 0x00b2 }
            long r12 = r4 * r6
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ Exception -> 0x00b2 }
            r7.<init>()     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r4 = "space"
            org.json.JSONArray r4 = r0.optJSONArray(r4)     // Catch:{ Exception -> 0x00b2 }
            if (r4 == 0) goto L_0x0090
            int r5 = r4.length()     // Catch:{ Exception -> 0x0048 }
            if (r5 <= 0) goto L_0x0090
            r5 = 0
        L_0x007a:
            int r6 = r4.length()     // Catch:{ Exception -> 0x0048 }
            if (r5 >= r6) goto L_0x0090
            java.lang.String r6 = r4.getString(r5)     // Catch:{ Exception -> 0x0048 }
            boolean r16 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0048 }
            if (r16 != 0) goto L_0x008d
            r7.add(r6)     // Catch:{ Exception -> 0x0048 }
        L_0x008d:
            int r5 = r5 + 1
            goto L_0x007a
        L_0x0090:
            java.lang.String r4 = "network"
            java.lang.String r17 = r0.optString(r4)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r4 = "maxTotalFileSize"
            java.lang.String r0 = r0.optString(r4)     // Catch:{ Exception -> 0x00b2 }
            long r18 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00b2 }
            fe.fe.ddd.ddd.rg.ad.ad r0 = new fe.fe.ddd.ddd.rg.ad.ad     // Catch:{ Exception -> 0x00b2 }
            r4 = r0
            r5 = r14
            r6 = r3
            r16 = r7
            r7 = r15
            r2 = r14
            r1 = r15
            r14 = r18
            r4.<init>(r5, r6, r7, r8, r10, r12, r14, r16, r17)     // Catch:{ Exception -> 0x00b0 }
            return r0
        L_0x00b0:
            r0 = move-exception
            goto L_0x00b5
        L_0x00b2:
            r0 = move-exception
            r2 = r14
            r1 = r15
        L_0x00b5:
            r4 = r20
        L_0x00b7:
            ad(r3, r2, r1, r4)
            boolean r5 = qw
            if (r5 == 0) goto L_0x00c1
            r0.getMessage()
        L_0x00c1:
            ad(r3, r2, r1, r4)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.ddd.rg.ad.qw.qw(org.json.JSONObject):fe.fe.ddd.ddd.rg.ad.ad");
    }
}
