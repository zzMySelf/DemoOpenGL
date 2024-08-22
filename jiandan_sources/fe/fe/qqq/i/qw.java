package fe.fe.qqq.i;

import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static final boolean f4427fe = AppConfig.rg();

    /* renamed from: ad  reason: collision with root package name */
    public Map<String, String> f4428ad = new HashMap();

    /* renamed from: de  reason: collision with root package name */
    public Map<String, ad> f4429de = new HashMap();
    public float qw;

    public qw() {
        new ArrayList();
        new ArrayList();
    }

    public Map<String, ad> ad() {
        return this.f4429de;
    }

    public float de() {
        float f = this.qw;
        if (f <= 0.0f || Float.isNaN(f)) {
            this.qw = 20.0f;
        }
        return this.qw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fe(org.json.JSONObject r17, boolean r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            if (r1 == 0) goto L_0x0186
            int r2 = r17.length()
            if (r2 != 0) goto L_0x000e
            goto L_0x0186
        L_0x000e:
            boolean r2 = f4427fe
            if (r2 == 0) goto L_0x0026
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "yalog id content is: "
            r2.append(r3)
            java.lang.String r3 = r17.toString()
            r2.append(r3)
            r2.toString()
        L_0x0026:
            java.lang.String r2 = "set"
            org.json.JSONObject r2 = r1.optJSONObject(r2)
            if (r2 == 0) goto L_0x0111
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x0111
            java.util.Iterator r5 = r2.keys()
        L_0x0038:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0111
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            org.json.JSONObject r7 = r2.optJSONObject(r6)
            if (r7 != 0) goto L_0x004b
            goto L_0x0038
        L_0x004b:
            java.lang.String r8 = "version"
            long r13 = r7.optLong(r8)
            java.util.Map<java.lang.String, java.lang.String> r8 = r0.f4428ad     // Catch:{ NumberFormatException -> 0x0085 }
            if (r8 == 0) goto L_0x006a
            java.util.Map<java.lang.String, java.lang.String> r8 = r0.f4428ad     // Catch:{ NumberFormatException -> 0x0085 }
            boolean r8 = r8.containsKey(r6)     // Catch:{ NumberFormatException -> 0x0085 }
            if (r8 == 0) goto L_0x006a
            java.util.Map<java.lang.String, java.lang.String> r8 = r0.f4428ad     // Catch:{ NumberFormatException -> 0x0085 }
            java.lang.Object r8 = r8.get(r6)     // Catch:{ NumberFormatException -> 0x0085 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x0085 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x0085 }
            goto L_0x0087
        L_0x006a:
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r8 = r0.f4429de     // Catch:{ NumberFormatException -> 0x0085 }
            if (r8 == 0) goto L_0x0085
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r8 = r0.f4429de     // Catch:{ NumberFormatException -> 0x0085 }
            boolean r8 = r8.containsKey(r6)     // Catch:{ NumberFormatException -> 0x0085 }
            if (r8 == 0) goto L_0x0085
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r8 = r0.f4429de     // Catch:{ NumberFormatException -> 0x0085 }
            java.lang.Object r8 = r8.get(r6)     // Catch:{ NumberFormatException -> 0x0085 }
            fe.fe.qqq.i.ad r8 = (fe.fe.qqq.i.ad) r8     // Catch:{ NumberFormatException -> 0x0085 }
            if (r8 == 0) goto L_0x0085
            long r8 = r8.de()     // Catch:{ NumberFormatException -> 0x0085 }
            goto L_0x0087
        L_0x0085:
            r8 = 0
        L_0x0087:
            if (r18 == 0) goto L_0x008e
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 < 0) goto L_0x008e
            goto L_0x0038
        L_0x008e:
            java.lang.String r8 = "data"
            org.json.JSONObject r7 = r7.optJSONObject(r8)
            if (r7 == 0) goto L_0x0038
            int r8 = r7.length()
            if (r8 != 0) goto L_0x009d
            goto L_0x0038
        L_0x009d:
            java.lang.String r8 = "yalogswitch"
            boolean r9 = r7.has(r8)
            if (r9 != 0) goto L_0x00a6
            goto L_0x0038
        L_0x00a6:
            java.lang.String r8 = r7.optString(r8)
            java.lang.String r9 = "0"
            boolean r8 = android.text.TextUtils.equals(r8, r9)
            r15 = r8 ^ 1
            java.lang.String r8 = "yalogsize"
            double r7 = r7.optDouble(r8)
            float r7 = (float) r7
            r8 = 0
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c4
            boolean r8 = java.lang.Float.isNaN(r7)
            if (r8 == 0) goto L_0x00c8
        L_0x00c4:
            float r7 = r16.de()
        L_0x00c8:
            r12 = r7
            fe.fe.qqq.i.ad r11 = new fe.fe.qqq.i.ad
            r7 = r11
            r8 = r6
            r9 = r13
            r3 = r11
            r11 = r15
            r7.<init>(r8, r9, r11, r12)
            float r4 = r16.de()
            boolean r4 = r3.fe(r15, r4)
            if (r4 == 0) goto L_0x00f9
            java.util.Map<java.lang.String, java.lang.String> r3 = r0.f4428ad
            if (r3 == 0) goto L_0x00e8
            java.lang.String r4 = java.lang.String.valueOf(r13)
            r3.put(r6, r4)
        L_0x00e8:
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r3 = r0.f4429de
            if (r3 == 0) goto L_0x0038
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L_0x0038
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r3 = r0.f4429de
            r3.remove(r6)
            goto L_0x0038
        L_0x00f9:
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r4 = r0.f4429de
            if (r4 == 0) goto L_0x0100
            r4.put(r6, r3)
        L_0x0100:
            java.util.Map<java.lang.String, java.lang.String> r3 = r0.f4428ad
            if (r3 == 0) goto L_0x0038
            boolean r3 = r3.containsKey(r6)
            if (r3 == 0) goto L_0x0038
            java.util.Map<java.lang.String, java.lang.String> r3 = r0.f4428ad
            r3.remove(r6)
            goto L_0x0038
        L_0x0111:
            java.lang.String r2 = "del"
            org.json.JSONObject r1 = r1.optJSONObject(r2)
            if (r1 == 0) goto L_0x0185
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x0185
            java.util.Iterator r2 = r1.keys()
        L_0x0123:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0185
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            long r6 = r1.optLong(r3, r4)
            java.util.Map<java.lang.String, java.lang.String> r8 = r0.f4428ad
            if (r8 == 0) goto L_0x0160
            java.lang.Object r8 = r8.get(r3)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0160
            java.util.Map<java.lang.String, java.lang.String> r8 = r0.f4428ad     // Catch:{ NumberFormatException -> 0x0152 }
            java.lang.Object r8 = r8.get(r3)     // Catch:{ NumberFormatException -> 0x0152 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ NumberFormatException -> 0x0152 }
            long r8 = java.lang.Long.parseLong(r8)     // Catch:{ NumberFormatException -> 0x0152 }
            goto L_0x0153
        L_0x0152:
            r8 = r4
        L_0x0153:
            if (r18 == 0) goto L_0x015a
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x015a
            goto L_0x0123
        L_0x015a:
            java.util.Map<java.lang.String, java.lang.String> r6 = r0.f4428ad
            r6.remove(r3)
            goto L_0x0123
        L_0x0160:
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r8 = r0.f4429de
            if (r8 == 0) goto L_0x0123
            boolean r8 = r8.containsKey(r3)
            if (r8 == 0) goto L_0x0123
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r8 = r0.f4429de
            java.lang.Object r8 = r8.get(r3)
            fe.fe.qqq.i.ad r8 = (fe.fe.qqq.i.ad) r8
            if (r8 == 0) goto L_0x0123
            long r8 = r8.de()
            if (r18 == 0) goto L_0x017f
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 < 0) goto L_0x017f
            goto L_0x0123
        L_0x017f:
            java.util.Map<java.lang.String, fe.fe.qqq.i.ad> r6 = r0.f4429de
            r6.remove(r3)
            goto L_0x0123
        L_0x0185:
            return
        L_0x0186:
            boolean r1 = f4427fe
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.qqq.i.qw.fe(org.json.JSONObject, boolean):void");
    }

    public void ggg(float f) {
    }

    public void i(String str) {
    }

    /* renamed from: if  reason: not valid java name */
    public void m279if(float f) {
    }

    public void o(Map<String, ad> map) {
        this.f4429de = map;
    }

    public void pf(float f) {
        this.qw = f;
    }

    public void ppp(float f) {
    }

    public Map<String, String> qw() {
        return this.f4428ad;
    }

    public void rg() {
        this.qw = 20.0f;
    }

    /* renamed from: switch  reason: not valid java name */
    public void m280switch(List<de> list) {
    }

    public void th(String str) {
    }

    public void uk(List<String> list) {
    }

    public void when(float f) {
    }

    public void yj(Map<String, String> map) {
        this.f4428ad = map;
    }
}
