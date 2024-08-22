package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.helios.common.gene.interfaces.HeliosKey;
import com.baidu.helios.trusts.zone.TrustSubject;
import fe.fe.pf.yj.rg.qw;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class TrustSubjectManager {

    /* renamed from: ad  reason: collision with root package name */
    public Context f856ad;

    /* renamed from: de  reason: collision with root package name */
    public TrustSubject f857de;
    public qw.C0142qw qw;

    public static class IntegrationException extends RuntimeException {
        public IntegrationException(String str) {
            super(str);
        }

        public IntegrationException(String str, Throwable th2) {
            super(str, th2);
        }

        public IntegrationException(Throwable th2) {
            super(th2);
        }
    }

    public static class ad {
    }

    public static class de {
        public List<String> qw;

        public de(List<String> list) {
            this.qw = list;
        }

        public static de qw(TrustSubject trustSubject) {
            try {
                String i2 = trustSubject.i("config-pkgs");
                if (TextUtils.isEmpty(i2)) {
                    return null;
                }
                JSONArray jSONArray = new JSONObject(i2).getJSONArray("value");
                int length = jSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
                return new de(arrayList);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public List<String> ad() {
            return this.qw;
        }
    }

    public static class fe {
        public int qw = 0;
    }

    public static class qw {

        /* renamed from: ad  reason: collision with root package name */
        public fe.fe.pf.yj.rg.qw f858ad;
        public Context qw;
    }

    public static class rg {
        public Set<String> qw;

        public rg(Set<String> set) {
            this.qw = set;
        }

        public static rg qw(TrustSubject trustSubject) {
            try {
                String i2 = trustSubject.i("config-revoke-sigs");
                if (TextUtils.isEmpty(i2)) {
                    return null;
                }
                JSONArray jSONArray = new JSONObject(i2).getJSONArray("revoke-sigs");
                int length = jSONArray.length();
                HashSet hashSet = new HashSet(length);
                for (int i3 = 0; i3 < length; i3++) {
                    hashSet.add(jSONArray.getString(i3));
                }
                return new rg(hashSet);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public Set<String> ad() {
            return this.qw;
        }
    }

    public static class th {

        /* renamed from: ad  reason: collision with root package name */
        public TrustSubject f859ad;
        public List<TrustSubject> qw;
    }

    public static void o(File file) {
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        o(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        } catch (Exception unused) {
        }
    }

    public final void ad(List<TrustSubject> list) {
        File[] listFiles;
        HashMap hashMap = new HashMap();
        for (TrustSubject next : list) {
            hashMap.put(next.qw, next);
        }
        File ad2 = this.qw.ad();
        if (ad2 != null && (listFiles = ad2.listFiles(new TrustSubject.fe())) != null) {
            for (File file : listFiles) {
                String ddd = TrustSubject.ddd(file.getName());
                if (!TextUtils.isEmpty(ddd) && !hashMap.containsKey(ddd)) {
                    o(file);
                }
            }
        }
    }

    public final void de(List<TrustSubject> list, TrustSubject trustSubject) {
        Set<String> ad2;
        rg qw2 = rg.qw(trustSubject);
        if (qw2 != null && (ad2 = qw2.ad()) != null && ad2.size() > 0) {
            Iterator<TrustSubject> it = list.iterator();
            while (it.hasNext()) {
                Set<String> o2 = it.next().o();
                if (o2 != null && o2.size() > 0) {
                    Iterator<String> it2 = o2.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (ad2.contains(it2.next())) {
                                it.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public final HeliosKey fe() {
        return fe.fe.pf.yj.de.de.qw(fe.fe.pf.pf.qw.qw.qw, fe.fe.pf.pf.qw.qw.f2825ad);
    }

    public final th i(HeliosKey heliosKey) {
        boolean z;
        TrustSubject trustSubject;
        th thVar = new th();
        List<ResolveInfo> queryBroadcastReceivers = this.f856ad.getPackageManager().queryBroadcastReceivers(new Intent("com.baidu.intent.action.HELIOS"), 0);
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        ArrayList<TrustSubject> arrayList2 = new ArrayList<>();
        if (queryBroadcastReceivers != null) {
            for (ResolveInfo next : queryBroadcastReceivers) {
                if (next.activityInfo.packageName.equals(this.f857de.qw)) {
                    trustSubject = this.f857de;
                } else {
                    TrustSubject trustSubject2 = new TrustSubject(next.activityInfo.packageName, this.f856ad, this.qw);
                    trustSubject2.m22switch();
                    trustSubject = trustSubject2;
                }
                arrayList2.add(trustSubject);
                boolean vvv = trustSubject.vvv();
                if (!vvv || trustSubject.uk().de(3) == 0) {
                    trustSubject.eee(heliosKey);
                } else {
                    HeliosKey heliosKey2 = heliosKey;
                }
                if (trustSubject.uk().de(3) == 1) {
                    hashSet.add(trustSubject);
                    if (!vvv || trustSubject.uk().de(384) == 0) {
                        trustSubject.qqq();
                    }
                    if (trustSubject.uk().de(384) == 128) {
                        arrayList.add(trustSubject);
                    }
                }
            }
        }
        TrustSubject trustSubject3 = null;
        Collections.sort(arrayList, TrustSubject.f841uk);
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TrustSubject trustSubject4 = (TrustSubject) it.next();
            if (trustSubject4.vvv()) {
                long de2 = trustSubject4.uk().de(48);
                if (de2 != 0) {
                    if (de2 != 32) {
                        if (de2 != 16 || trustSubject4.uk().de(64) == 64) {
                            z = false;
                            if ((!z || trustSubject4.mmm()) && trustSubject4.ggg()) {
                                trustSubject3 = trustSubject4;
                                break;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
            z = true;
            trustSubject3 = trustSubject4;
            break;
        }
        for (TrustSubject trustSubject5 : arrayList2) {
            if (!trustSubject5.equals(trustSubject3)) {
                trustSubject5.th();
                trustSubject5.yj();
            }
            trustSubject5.aaa();
            trustSubject5.rg();
            trustSubject5.nn();
        }
        ad(arrayList2);
        ArrayList arrayList3 = new ArrayList(hashSet);
        if (trustSubject3 != null) {
            de(arrayList3, trustSubject3);
        }
        Collections.sort(arrayList3, TrustSubject.f842yj);
        thVar.qw = arrayList3;
        if (trustSubject3 != null) {
            trustSubject3.xxx();
            thVar.f859ad = trustSubject3;
        }
        return thVar;
    }

    public void qw(qw qwVar) {
        this.f856ad = qwVar.qw;
        qw.C0142qw th2 = qwVar.f858ad.fe().th("tz");
        this.qw = th2;
        th2.qw();
    }

    public void rg(ad adVar) {
        th();
    }

    public final void th() {
        TrustSubject trustSubject = new TrustSubject(this.f856ad.getPackageName(), this.f856ad, this.qw);
        trustSubject.m22switch();
        boolean vvv = trustSubject.vvv();
        boolean z = false;
        boolean z2 = true;
        if (!vvv || trustSubject.uk().de(3) == 0) {
            trustSubject.eee(fe());
        }
        if (!vvv || trustSubject.uk().de(384) == 0) {
            trustSubject.qqq();
        }
        if (vvv) {
            long de2 = trustSubject.uk().de(48);
            if (de2 == 0 || !(de2 == 32 || de2 != 16 || trustSubject.uk().de(64) == 64)) {
                z = true;
            }
            z2 = z;
        }
        if (z2) {
            trustSubject.mmm();
        }
        trustSubject.aaa();
        trustSubject.nn();
        this.f857de = trustSubject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x0170 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.helios.trusts.zone.TrustSubjectManager.th uk(com.baidu.helios.common.gene.interfaces.HeliosKey r27) {
        /*
            r26 = this;
            r0 = r26
            com.baidu.helios.trusts.zone.TrustSubjectManager$th r1 = new com.baidu.helios.trusts.zone.TrustSubjectManager$th
            r1.<init>()
            com.baidu.helios.trusts.zone.TrustSubject r2 = r0.f857de
            boolean r3 = r2.when()
            if (r3 != 0) goto L_0x0010
            return r1
        L_0x0010:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r4 = r2.qw
            r3.put(r4, r2)
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            com.baidu.helios.trusts.zone.TrustSubject$de r5 = r2.uk()
            r6 = 3
            long r8 = r5.de(r6)
            r10 = 1
            int r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r5 != 0) goto L_0x0032
            r4.add(r2)
        L_0x0032:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r5.add(r2)
            r12 = r2
            r9 = 0
        L_0x003c:
            if (r9 == 0) goto L_0x0046
            boolean r9 = r9.equals(r12)
            if (r9 == 0) goto L_0x0046
            goto L_0x0178
        L_0x0046:
            com.baidu.helios.trusts.zone.TrustSubjectManager$de r9 = com.baidu.helios.trusts.zone.TrustSubjectManager.de.qw(r12)
            if (r9 == 0) goto L_0x0051
            java.util.List r9 = r9.ad()
            goto L_0x0052
        L_0x0051:
            r9 = 0
        L_0x0052:
            if (r9 == 0) goto L_0x0178
            java.util.Set r13 = r3.keySet()
            boolean r13 = r13.containsAll(r9)
            if (r13 == 0) goto L_0x0060
            goto L_0x0178
        L_0x0060:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x0069:
            boolean r14 = r9.hasNext()
            r15 = 0
            r17 = 0
            r18 = 1
            if (r14 == 0) goto L_0x0106
            java.lang.Object r14 = r9.next()
            java.lang.String r14 = (java.lang.String) r14
            boolean r19 = r3.containsKey(r14)
            if (r19 == 0) goto L_0x0082
            goto L_0x0069
        L_0x0082:
            java.lang.String r8 = r2.qw
            boolean r8 = r8.equals(r14)
            if (r8 == 0) goto L_0x008c
            r8 = r2
            goto L_0x0095
        L_0x008c:
            com.baidu.helios.trusts.zone.TrustSubject r8 = new com.baidu.helios.trusts.zone.TrustSubject
            android.content.Context r10 = r0.f856ad
            fe.fe.pf.yj.rg.qw$qw r11 = r0.qw
            r8.<init>(r14, r10, r11)
        L_0x0095:
            r3.put(r14, r8)
            boolean r10 = r8.ppp()
            if (r10 != 0) goto L_0x00a1
            r10 = 1
            goto L_0x0069
        L_0x00a1:
            r8.m22switch()
            r5.add(r8)
            boolean r10 = r8.vvv()
            if (r10 == 0) goto L_0x00bc
            com.baidu.helios.trusts.zone.TrustSubject$de r11 = r8.uk()
            long r22 = r11.de(r6)
            int r11 = (r22 > r15 ? 1 : (r22 == r15 ? 0 : -1))
            if (r11 != 0) goto L_0x00ba
            goto L_0x00bc
        L_0x00ba:
            r11 = 0
            goto L_0x00bd
        L_0x00bc:
            r11 = 1
        L_0x00bd:
            if (r11 == 0) goto L_0x00c5
            r11 = r27
            r8.eee(r11)
            goto L_0x00c7
        L_0x00c5:
            r11 = r27
        L_0x00c7:
            com.baidu.helios.trusts.zone.TrustSubject$de r14 = r8.uk()
            long r22 = r14.de(r6)
            r20 = 1
            int r14 = (r22 > r20 ? 1 : (r22 == r20 ? 0 : -1))
            if (r14 != 0) goto L_0x0100
            r4.add(r8)
            r6 = 384(0x180, double:1.897E-321)
            if (r10 == 0) goto L_0x00e8
            com.baidu.helios.trusts.zone.TrustSubject$de r10 = r8.uk()
            long r24 = r10.de(r6)
            int r10 = (r24 > r15 ? 1 : (r24 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x00ea
        L_0x00e8:
            r17 = 1
        L_0x00ea:
            if (r17 == 0) goto L_0x00ef
            r8.qqq()
        L_0x00ef:
            com.baidu.helios.trusts.zone.TrustSubject$de r10 = r8.uk()
            long r6 = r10.de(r6)
            r14 = 128(0x80, double:6.32E-322)
            int r10 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
            if (r10 != 0) goto L_0x0100
            r13.add(r8)
        L_0x0100:
            r10 = r20
            r6 = 3
            goto L_0x0069
        L_0x0106:
            r20 = r10
            r11 = r27
            java.util.Comparator<com.baidu.helios.trusts.zone.TrustSubject> r6 = com.baidu.helios.trusts.zone.TrustSubject.f841uk
            java.util.Collections.sort(r13, r6)
            java.util.Iterator r6 = r13.iterator()
        L_0x0113:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x016f
            java.lang.Object r7 = r6.next()
            com.baidu.helios.trusts.zone.TrustSubject r7 = (com.baidu.helios.trusts.zone.TrustSubject) r7
            boolean r8 = r7.vvv()
            if (r8 == 0) goto L_0x0152
            com.baidu.helios.trusts.zone.TrustSubject$de r8 = r7.uk()
            r9 = 48
            long r8 = r8.de(r9)
            int r10 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r10 != 0) goto L_0x0134
            goto L_0x0152
        L_0x0134:
            r13 = 32
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 != 0) goto L_0x013b
            goto L_0x0113
        L_0x013b:
            r13 = 16
            int r10 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r10 != 0) goto L_0x0150
            com.baidu.helios.trusts.zone.TrustSubject$de r8 = r7.uk()
            r9 = 64
            long r13 = r8.de(r9)
            int r8 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r8 == 0) goto L_0x0150
            goto L_0x0152
        L_0x0150:
            r8 = 0
            goto L_0x0153
        L_0x0152:
            r8 = 1
        L_0x0153:
            if (r8 == 0) goto L_0x015c
            boolean r8 = r7.mmm()
            if (r8 != 0) goto L_0x015c
            goto L_0x0113
        L_0x015c:
            boolean r8 = r7.ggg()
            if (r8 == 0) goto L_0x0113
            long r8 = r7.pf()
            long r13 = r12.pf()
            int r6 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r6 <= 0) goto L_0x016f
            goto L_0x0170
        L_0x016f:
            r7 = r12
        L_0x0170:
            r9 = r12
            r10 = r20
            r12 = r7
            r6 = 3
            goto L_0x003c
        L_0x0178:
            java.util.Iterator r2 = r5.iterator()
        L_0x017c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x019e
            java.lang.Object r3 = r2.next()
            com.baidu.helios.trusts.zone.TrustSubject r3 = (com.baidu.helios.trusts.zone.TrustSubject) r3
            boolean r6 = r3.equals(r12)
            if (r6 != 0) goto L_0x0194
            r3.th()
            r3.yj()
        L_0x0194:
            r3.aaa()
            r3.rg()
            r3.nn()
            goto L_0x017c
        L_0x019e:
            r0.ad(r5)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r4)
            if (r12 == 0) goto L_0x01ab
            r0.de(r2, r12)
        L_0x01ab:
            java.util.Comparator<com.baidu.helios.trusts.zone.TrustSubject> r3 = com.baidu.helios.trusts.zone.TrustSubject.f842yj
            java.util.Collections.sort(r2, r3)
            r1.qw = r2
            if (r12 == 0) goto L_0x01b9
            r12.xxx()
            r1.f859ad = r12
        L_0x01b9:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.helios.trusts.zone.TrustSubjectManager.uk(com.baidu.helios.common.gene.interfaces.HeliosKey):com.baidu.helios.trusts.zone.TrustSubjectManager$th");
    }

    public th yj(fe feVar) {
        HeliosKey fe2 = fe();
        int i2 = feVar.qw;
        if (i2 == 1) {
            return i(fe2);
        }
        if (i2 == 2) {
            return uk(fe2);
        }
        th i3 = i(fe2);
        List<TrustSubject> list = i3.qw;
        return (list == null || list.size() == 0) ? uk(fe2) : i3;
    }
}
