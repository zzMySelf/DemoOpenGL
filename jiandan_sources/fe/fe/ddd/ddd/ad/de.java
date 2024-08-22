package fe.fe.ddd.ddd.ad;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.retrieve.upload.IUploadListener;
import fe.fe.ddd.ddd.th.yj;
import java.util.List;
import org.json.JSONObject;

public class de {
    public static final boolean qw = AppConfig.rg();

    public static class qw implements IUploadListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ String f1315ad;
        public final /* synthetic */ JSONObject qw;

        public qw(JSONObject jSONObject, String str) {
            this.qw = jSONObject;
            this.f1315ad = str;
        }

        public void onFailure() {
        }

        public void qw(yj yjVar) {
            if (yjVar != null && TextUtils.equals("1", yjVar.qw())) {
                de.ad(qw.ad().qw(), this.qw, this.f1315ad);
            }
        }
    }

    public static void ad(List<fe.fe.ddd.ddd.fe.qw> list, JSONObject jSONObject, String str) {
        if (list != null && list.size() != 0) {
            boolean z = qw;
            boolean z2 = false;
            for (fe.fe.ddd.ddd.fe.qw next : list) {
                if (TextUtils.equals(str, next.ad())) {
                    next.qw(jSONObject);
                    z2 = true;
                }
            }
            if (!z2) {
                ad.de(str, "", "", jSONObject, "2");
                boolean z3 = qw;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b1, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean de(org.json.JSONObject r14) {
        /*
            java.lang.Class<fe.fe.ddd.ddd.ad.de> r0 = fe.fe.ddd.ddd.ad.de.class
            monitor-enter(r0)
            r1 = 0
            if (r14 != 0) goto L_0x000b
            fe.fe.ddd.ddd.ad.ad.ad()     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)
            return r1
        L_0x000b:
            boolean r2 = qw     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x0023
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r2.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "收到回捞命令 "
            r2.append(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = r14.toString()     // Catch:{ all -> 0x00b2 }
            r2.append(r3)     // Catch:{ all -> 0x00b2 }
            r2.toString()     // Catch:{ all -> 0x00b2 }
        L_0x0023:
            java.lang.String r2 = "type"
            java.lang.String r2 = r14.optString(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "jobId"
            java.lang.String r6 = r14.optString(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "version"
            java.lang.String r7 = r14.optString(r3)     // Catch:{ all -> 0x00b2 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x00b2 }
            if (r3 != 0) goto L_0x0095
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00b2 }
            if (r3 != 0) goto L_0x0095
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00b2 }
            if (r3 == 0) goto L_0x0048
            goto L_0x0095
        L_0x0048:
            java.lang.String r3 = "expiredTime"
            java.lang.String r3 = r14.optString(r3)     // Catch:{ all -> 0x00b2 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x00b2 }
            r11 = 1
            if (r4 != 0) goto L_0x0078
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0073 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x0073 }
            long r8 = r3.longValue()     // Catch:{ Exception -> 0x0073 }
            r12 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r12
            int r3 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0071
            java.lang.String r3 = "1"
            fe.fe.ddd.ddd.ad.ad.de(r2, r6, r7, r14, r3)     // Catch:{ Exception -> 0x0073 }
            boolean r3 = qw     // Catch:{ Exception -> 0x0073 }
            goto L_0x0073
        L_0x0071:
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            if (r3 != 0) goto L_0x0078
            monitor-exit(r0)
            return r1
        L_0x0078:
            java.lang.String r5 = "1"
            fe.fe.ddd.ddd.th.uk r1 = new fe.fe.ddd.ddd.th.uk     // Catch:{ all -> 0x00b2 }
            java.lang.String r8 = "0"
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r3 = r1
            r4 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00b2 }
            fe.fe.ddd.ddd.th.i r3 = fe.fe.ddd.ddd.th.i.qw()     // Catch:{ all -> 0x00b2 }
            fe.fe.ddd.ddd.ad.de$qw r4 = new fe.fe.ddd.ddd.ad.de$qw     // Catch:{ all -> 0x00b2 }
            r4.<init>(r14, r2)     // Catch:{ all -> 0x00b2 }
            r3.de(r1, r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)
            return r11
        L_0x0095:
            fe.fe.ddd.ddd.ad.ad.qw(r2, r6, r7, r14)     // Catch:{ all -> 0x00b2 }
            boolean r2 = qw     // Catch:{ all -> 0x00b2 }
            if (r2 == 0) goto L_0x00b0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b2 }
            r2.<init>()     // Catch:{ all -> 0x00b2 }
            java.lang.String r3 = "回捞命令校验错误 "
            r2.append(r3)     // Catch:{ all -> 0x00b2 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x00b2 }
            r2.append(r14)     // Catch:{ all -> 0x00b2 }
            r2.toString()     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r0)
            return r1
        L_0x00b2:
            r14 = move-exception
            monitor-exit(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.ddd.ddd.ad.de.de(org.json.JSONObject):boolean");
    }
}
