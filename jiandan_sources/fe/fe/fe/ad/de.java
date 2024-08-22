package fe.fe.fe.ad;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cesium.a.i;
import com.baidu.cesium.h;
import com.google.common.base.Ascii;
import fe.fe.fe.ad.qw;
import fe.fe.fe.th;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class de extends qw {

    /* renamed from: th  reason: collision with root package name */
    public Context f1808th;

    /* renamed from: yj  reason: collision with root package name */
    public yj f1809yj;

    public static class ad {
        public Map<qw, Integer> qw = new HashMap();

        public class qw implements Comparator<Map.Entry<qw, Integer>> {
            public qw(ad adVar) {
            }

            /* renamed from: qw */
            public int compare(Map.Entry<qw, Integer> entry, Map.Entry<qw, Integer> entry2) {
                int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
            }
        }

        public void ad(qw qwVar) {
            Integer num = this.qw.get(qwVar);
            this.qw.put(qwVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }

        public List<qw> qw() {
            ArrayList arrayList = new ArrayList(this.qw.entrySet());
            Collections.sort(arrayList, new qw(this));
            ArrayList arrayList2 = new ArrayList(6);
            int min = Math.min(6, arrayList.size());
            for (int i2 = 0; i2 < min; i2++) {
                Map.Entry entry = (Map.Entry) arrayList.get(i2);
                if (((Integer) entry.getValue()).intValue() > 1) {
                    arrayList2.add(entry.getKey());
                }
            }
            return arrayList2;
        }
    }

    /* renamed from: fe.fe.fe.ad.de$de  reason: collision with other inner class name */
    public class C0102de {

        /* renamed from: ad  reason: collision with root package name */
        public qw[] f1810ad = new qw[33];

        /* renamed from: de  reason: collision with root package name */
        public int f1811de;
        public int qw = 33;

        public C0102de(de deVar) {
        }

        public C0102de(de deVar, byte[] bArr) {
            if (bArr != null && bArr.length > 0) {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    qw ad2 = qw.ad(bArr[i2], false);
                    qw ad3 = qw.ad(bArr[i2], true);
                    de(ad2);
                    de(ad3);
                }
            }
        }

        public qw ad(int i2) {
            if (i2 < this.f1811de) {
                return this.f1810ad[i2];
            }
            throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f1811de);
        }

        public void de(qw qwVar) {
            fe(this.f1811de + 1);
            qw[] qwVarArr = this.f1810ad;
            int i2 = this.f1811de;
            this.f1811de = i2 + 1;
            qwVarArr[i2] = qwVar;
        }

        public final void fe(int i2) {
            qw[] qwVarArr = this.f1810ad;
            if (i2 - qwVarArr.length > 0) {
                int length = qwVarArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f1810ad = (qw[]) Arrays.copyOf(this.f1810ad, i2);
            }
        }

        public int qw() {
            return this.f1811de;
        }

        public byte[] rg() {
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (true) {
                i2 = this.f1811de;
                if (i3 >= i2 / 2) {
                    break;
                }
                int i4 = i3 * 2;
                byteArrayOutputStream.write((byte) (((ad(i4 + 1).th() & 255) << 4) | (ad(i4).th() & 255)));
                i3++;
            }
            if (i2 % 2 != 0) {
                byteArrayOutputStream.write((byte) (ad(i2 - 1).th() & 255));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    public static class fe {
        public List<ad> qw = new ArrayList();

        public static class ad {

            /* renamed from: ad  reason: collision with root package name */
            public qw f1812ad;
            public int qw;

            public ad(qw qwVar) {
                this.f1812ad = qwVar;
            }

            public void ad() {
                this.qw++;
            }
        }

        public class qw implements Comparator<ad> {
            public qw(fe feVar) {
            }

            /* renamed from: qw */
            public int compare(ad adVar, ad adVar2) {
                return adVar.qw - adVar2.qw;
            }
        }

        public void ad(qw qwVar) {
            this.qw.add(new ad(qwVar));
        }

        public List<ad> qw() {
            ArrayList arrayList = new ArrayList(this.qw);
            Collections.sort(arrayList, new qw(this));
            return arrayList;
        }
    }

    public static final class qw implements Comparable<qw> {

        /* renamed from: th  reason: collision with root package name */
        public static final String[] f1813th = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: ad  reason: collision with root package name */
        public final int f1814ad;

        public qw(int i2) {
            this.f1814ad = i2;
        }

        public static qw ad(byte b, boolean z) {
            byte b2 = b & 255;
            return fe(z ? b2 >> 4 : b2 & Ascii.SI);
        }

        public static qw fe(int i2) {
            if (i2 >= 0 && i2 < 16) {
                return new qw(i2);
            }
            throw new IllegalArgumentException("invalid idx " + i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && qw.class == obj.getClass() && this.f1814ad == ((qw) obj).f1814ad;
        }

        public int hashCode() {
            return this.f1814ad;
        }

        /* renamed from: qw */
        public int compareTo(qw qwVar) {
            return this.f1814ad - qwVar.f1814ad;
        }

        public String rg() {
            return f1813th[this.f1814ad];
        }

        public byte th() {
            return (byte) this.f1814ad;
        }
    }

    public static class rg {

        /* renamed from: ad  reason: collision with root package name */
        public byte f1815ad;

        /* renamed from: de  reason: collision with root package name */
        public byte[] f1816de;

        /* renamed from: fe  reason: collision with root package name */
        public boolean f1817fe;
        public byte[] qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f1818rg = "";

        public rg(byte[] bArr, byte b, byte[] bArr2, boolean z, String str) {
            this.qw = bArr;
            this.f1815ad = b;
            this.f1816de = bArr2;
            this.f1817fe = z;
            this.f1818rg = str;
        }

        public static rg qw(h.a aVar) {
            try {
                byte[] mmm = de.aaa(aVar.uk());
                if (mmm.length > 16) {
                    return null;
                }
                return new rg(mmm, aVar.ppp().getBytes("UTF-8")[0], aVar.m11if() != null ? aVar.m11if().getBytes("UTF-8") : null, aVar.xxx(), aVar.ddd());
            } catch (Exception unused) {
                return null;
            }
        }

        public h.a ad() {
            try {
                return h.rg(th.de.qw(this.qw, "", true), new String(new byte[]{this.f1815ad}, "UTF-8"), this.f1816de != null ? new String(this.f1816de, "UTF-8") : null, this.f1817fe, this.f1818rg);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class th {

        /* renamed from: ad  reason: collision with root package name */
        public int f1819ad;
        public int qw;

        public String toString() {
            return "";
        }
    }

    public static class yj {

        /* renamed from: ad  reason: collision with root package name */
        public Method f1820ad;

        /* renamed from: de  reason: collision with root package name */
        public Method f1821de;

        /* renamed from: fe  reason: collision with root package name */
        public Method f1822fe;
        public Method qw;

        /* renamed from: rg  reason: collision with root package name */
        public Method f1823rg;

        public void ad() {
            try {
                this.qw = i.ad(Context.class, i.qw(fe.fe.fe.qw.de.fe()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f1820ad = i.ad(Context.class, i.qw(fe.fe.fe.qw.de.rg()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f1821de = i.ad(ContentResolver.class, i.qw(fe.fe.fe.qw.de.th()), new Class[]{Uri.class, Integer.TYPE});
                this.f1822fe = i.ad(Context.class, i.qw(fe.fe.fe.qw.de.yj()), new Class[]{Uri.class, Integer.TYPE});
                this.f1823rg = i.ad(ContentResolver.class, i.qw(fe.fe.fe.qw.de.uk()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception unused) {
            }
        }

        public void de(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f1821de.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new i.a((Throwable) e);
            }
        }

        public void fe(Context context, Uri uri, int i2) {
            try {
                this.f1822fe.invoke(context, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new i.a((Throwable) e);
            }
        }

        public int qw(Context context, Uri uri, int i2, int i3, int i4) {
            try {
                return ((Integer) this.qw.invoke(context, new Object[]{uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
            } catch (Exception e) {
                throw new i.a((Throwable) e);
            }
        }

        public void rg(Context context, String str, Uri uri, int i2) {
            try {
                this.f1820ad.invoke(context, new Object[]{str, uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new i.a((Throwable) e);
            }
        }

        public void th(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f1823rg.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new i.a((Throwable) e);
            }
        }
    }

    public de() {
        super("upc", 9000000);
        yj yjVar = new yj();
        this.f1809yj = yjVar;
        yjVar.ad();
    }

    public static byte[] aaa(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                int digit = Character.digit(str.charAt(i3), 16);
                int digit2 = Character.digit(str.charAt(i3 + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
                bArr[i2] = (byte) ((digit * 16) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public fe.fe.fe.ad.qw.uk ad(java.lang.String r21, fe.fe.fe.ad.qw.yj r22) {
        /*
            r20 = this;
            r6 = r20
            r7 = r21
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x000f
            fe.fe.fe.ad.qw$uk r0 = fe.fe.fe.ad.qw.uk.fe()
            return r0
        L_0x000f:
            r0 = -1
            android.content.Context r1 = r6.f1808th
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r8 = 0
            int r0 = r1.getPackageUid(r7, r8)     // Catch:{ NameNotFoundException -> 0x001d }
            r9 = r0
            goto L_0x001e
        L_0x001d:
            r9 = -1
        L_0x001e:
            if (r9 >= 0) goto L_0x0025
            fe.fe.fe.ad.qw$uk r0 = fe.fe.fe.ad.qw.uk.fe()
            return r0
        L_0x0025:
            fe.fe.fe.ad.de$th r10 = new fe.fe.fe.ad.de$th
            r10.<init>()
            fe.fe.fe.ad.de$de r11 = new fe.fe.fe.ad.de$de
            r11.<init>(r6)
            fe.fe.fe.ad.de$fe r12 = new fe.fe.fe.ad.de$fe
            r12.<init>()
            fe.fe.fe.ad.de$fe r13 = new fe.fe.fe.ad.de$fe
            r13.<init>()
            r0 = 0
        L_0x003a:
            r1 = 16
            if (r0 >= r1) goto L_0x0052
            fe.fe.fe.ad.de$qw r1 = fe.fe.fe.ad.de.qw.fe(r0)
            boolean r2 = r6.ddd(r7, r1, r9)
            if (r2 == 0) goto L_0x004c
            r12.ad(r1)
            goto L_0x004f
        L_0x004c:
            r13.ad(r1)
        L_0x004f:
            int r0 = r0 + 1
            goto L_0x003a
        L_0x0052:
            r14 = 0
        L_0x0053:
            r15 = 32
            if (r14 >= r15) goto L_0x0084
            java.util.List r3 = r12.qw()
            r0 = r20
            r1 = r21
            r2 = r14
            r4 = r9
            r5 = r10
            fe.fe.fe.ad.de$qw r0 = r0.yj(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0077
            java.util.List r3 = r13.qw()
            r0 = r20
            r1 = r21
            r2 = r14
            r4 = r9
            r5 = r10
            fe.fe.fe.ad.de$qw r0 = r0.yj(r1, r2, r3, r4, r5)
        L_0x0077:
            if (r0 != 0) goto L_0x007e
            fe.fe.fe.ad.qw$uk r0 = fe.fe.fe.ad.qw.uk.fe()
            return r0
        L_0x007e:
            r11.de(r0)
            int r14 = r14 + 1
            goto L_0x0053
        L_0x0084:
            byte[] r11 = r11.rg()
            r14 = 3
            byte[] r5 = new byte[r14]
            java.lang.String r0 = "0"
            byte[] r0 = r0.getBytes()
            byte r0 = r0[r8]
            r5[r8] = r0
            java.lang.String r0 = "O"
            byte[] r0 = r0.getBytes()
            byte r0 = r0[r8]
            r4 = 1
            r5[r4] = r0
            r0 = 2
            java.lang.String r1 = "V"
            byte[] r1 = r1.getBytes()
            byte r1 = r1[r8]
            r5[r0] = r1
            r3 = 0
        L_0x00ac:
            r16 = 0
            if (r3 >= r14) goto L_0x0104
            byte r2 = r5[r3]
            fe.fe.fe.ad.de$qw r1 = fe.fe.fe.ad.de.qw.ad(r2, r8)
            r17 = 32
            r0 = r20
            r22 = r1
            r1 = r21
            r14 = r2
            r2 = r17
            r17 = r3
            r3 = r22
            r15 = 1
            r4 = r9
            r19 = r5
            r5 = r10
            boolean r0 = r0.xxx(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00fb
            fe.fe.fe.ad.de$qw r14 = fe.fe.fe.ad.de.qw.ad(r14, r15)
            r2 = 33
            r0 = r20
            r1 = r21
            r3 = r14
            r4 = r9
            r5 = r10
            boolean r0 = r0.xxx(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00fb
            fe.fe.fe.ad.de$de r0 = new fe.fe.fe.ad.de$de
            r0.<init>(r6)
            r1 = r22
            r0.de(r1)
            r0.de(r14)
            byte[] r0 = r0.rg()
            byte r0 = r0[r8]
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
            goto L_0x0107
        L_0x00fb:
            int r3 = r17 + 1
            r5 = r19
            r4 = 1
            r14 = 3
            r15 = 32
            goto L_0x00ac
        L_0x0104:
            r15 = 1
            r0 = r16
        L_0x0107:
            r14 = 34
            if (r0 != 0) goto L_0x0156
            fe.fe.fe.ad.de$de r5 = new fe.fe.fe.ad.de$de
            r5.<init>(r6)
            r4 = 32
        L_0x0112:
            if (r4 >= r14) goto L_0x0148
            java.util.List r3 = r12.qw()
            r0 = r20
            r1 = r21
            r2 = r4
            r18 = r4
            r4 = r9
            r14 = r5
            r5 = r10
            fe.fe.fe.ad.de$qw r0 = r0.yj(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0138
            java.util.List r3 = r13.qw()
            r0 = r20
            r1 = r21
            r2 = r18
            r4 = r9
            r5 = r10
            fe.fe.fe.ad.de$qw r0 = r0.yj(r1, r2, r3, r4, r5)
        L_0x0138:
            if (r0 != 0) goto L_0x013f
            fe.fe.fe.ad.qw$uk r0 = fe.fe.fe.ad.qw.uk.fe()
            return r0
        L_0x013f:
            r14.de(r0)
            int r4 = r18 + 1
            r5 = r14
            r14 = 34
            goto L_0x0112
        L_0x0148:
            r14 = r5
            byte[] r0 = r14.rg()
            byte r0 = r0[r8]
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)
            r14 = r0
            r4 = 1
            goto L_0x0158
        L_0x0156:
            r14 = r0
            r4 = 0
        L_0x0158:
            if (r4 == 0) goto L_0x01a1
            fe.fe.fe.ad.de$de r5 = new fe.fe.fe.ad.de$de
            r5.<init>(r6)
            r4 = 34
        L_0x0161:
            r0 = 94
            if (r4 >= r0) goto L_0x0194
            java.util.List r3 = r12.qw()
            r0 = r20
            r1 = r21
            r2 = r4
            r17 = r4
            r4 = r9
            r8 = r5
            r5 = r10
            fe.fe.fe.ad.de$qw r0 = r0.yj(r1, r2, r3, r4, r5)
            if (r0 != 0) goto L_0x0189
            java.util.List r3 = r13.qw()
            r0 = r20
            r1 = r21
            r2 = r17
            r4 = r9
            r5 = r10
            fe.fe.fe.ad.de$qw r0 = r0.yj(r1, r2, r3, r4, r5)
        L_0x0189:
            if (r0 != 0) goto L_0x018c
            goto L_0x0195
        L_0x018c:
            r8.de(r0)
            int r4 = r17 + 1
            r5 = r8
            r8 = 0
            goto L_0x0161
        L_0x0194:
            r8 = r5
        L_0x0195:
            int r0 = r8.qw()
            if (r0 <= 0) goto L_0x01a1
            byte[] r0 = r8.rg()
            r3 = r0
            goto L_0x01a3
        L_0x01a1:
            r3 = r16
        L_0x01a3:
            boolean r0 = r6.vvv(r7, r9)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x01be
            java.lang.String r0 = com.baidu.cesium.h.m8if()
            boolean r0 = r6.nn(r7, r0, r9)
            if (r0 == 0) goto L_0x01bb
            java.lang.String r0 = com.baidu.cesium.h.m8if()
            r5 = r0
            goto L_0x01bc
        L_0x01bb:
            r5 = r1
        L_0x01bc:
            r4 = 1
            goto L_0x01c0
        L_0x01be:
            r5 = r1
            r4 = 0
        L_0x01c0:
            fe.fe.fe.ad.de$rg r7 = new fe.fe.fe.ad.de$rg
            byte r2 = r14.byteValue()
            r0 = r7
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5)
            com.baidu.cesium.h$a r0 = r7.ad()
            fe.fe.fe.ad.qw$uk r0 = fe.fe.fe.ad.qw.uk.ad(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.fe.ad.de.ad(java.lang.String, fe.fe.fe.ad.qw$yj):fe.fe.fe.ad.qw$uk");
    }

    public final boolean ddd(String str, qw qwVar, int i2) {
        int i3;
        Uri parse = Uri.parse(i(str, qwVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.f1809yj.qw(this.f1808th, parse, 0, i2, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5);
                } catch (Exception unused2) {
                }
                i4++;
            }
        }
        return i3 == 0;
    }

    public final String eee(String str) {
        return String.format("content://%s/clo/v1/%s", new Object[]{qqq(str), "yes"});
    }

    public final boolean ggg(C0102de deVar, List<qw> list) {
        boolean z;
        int i2;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        ContentResolver contentResolver = this.f1808th.getContentResolver();
        UriMatcher uriMatcher = new UriMatcher(-1);
        pf(uriMatcher);
        List<UriPermission> persistedUriPermissions = contentResolver.getPersistedUriPermissions();
        if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
            persistedUriPermissions = contentResolver.getOutgoingPersistedUriPermissions();
        }
        if (persistedUriPermissions == null || persistedUriPermissions.size() == 0) {
            return true;
        }
        for (UriPermission next : persistedUriPermissions) {
            Uri uri = next.getUri();
            int match = uriMatcher.match(uri);
            List<String> pathSegments = uri.getPathSegments();
            int i3 = 3;
            if ((match == 1 || match == 2 || match == 3) && next.isWritePermission()) {
                if (!next.isReadPermission()) {
                    i3 = 2;
                }
                when(uri, i3);
            } else {
                if (match == 1) {
                    try {
                        i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                    } catch (Exception unused) {
                        i2 = -1;
                    }
                    if (i2 >= 0 && i2 < deVar.qw()) {
                        if (deVar.ad(i2).rg().equals(pathSegments.get(3))) {
                        }
                    }
                } else if (match == 2) {
                    String str = pathSegments.get(2);
                    Iterator<qw> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().rg().equals(str)) {
                                z = true;
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                    }
                } else if (match == 3) {
                    String str2 = pathSegments.get(2);
                    if (!TextUtils.equals(str2, h.m8if())) {
                        if (TextUtils.equals(str2, "yes")) {
                        }
                    }
                }
                when(uri, 1);
            }
        }
        int qw2 = deVar.qw();
        for (int i4 = 0; i4 < qw2; i4++) {
            if (!xxx(this.f1808th.getPackageName(), i4, deVar.ad(i4), Process.myUid(), (th) null)) {
                return true;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!ddd(this.f1808th.getPackageName(), list.get(i5), Process.myUid())) {
                return true;
            }
        }
        if (!vvv(this.f1808th.getPackageName(), Process.myUid())) {
            return true;
        }
        String str3 = h.m8if();
        return !TextUtils.isEmpty(str3) && !nn(this.f1808th.getPackageName(), str3, Process.myUid());
    }

    public final String i(String str, qw qwVar) {
        return String.format("content://%s/dic/v1/%s", new Object[]{qqq(str), qwVar.rg()});
    }

    /* renamed from: if  reason: not valid java name */
    public final boolean m101if(int i2, qw qwVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return m102switch(Uri.parse(uk(this.f1808th.getPackageName(), i2, qwVar)));
    }

    public final boolean nn(String str, String str2, int i2) {
        int i3;
        Uri parse = Uri.parse(o(str, str2));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.f1809yj.qw(this.f1808th, parse, 0, i2, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5);
                } catch (Exception unused2) {
                }
                i4++;
            }
        }
        return i3 == 0;
    }

    public final String o(String str, String str2) {
        return String.format("content://%s/clo/v1/%s", new Object[]{qqq(str), str2});
    }

    public final void pf(UriMatcher uriMatcher) {
        uriMatcher.addURI(qqq(this.f1808th.getPackageName()), "dat/v1/*/*", 1);
        uriMatcher.addURI(qqq(this.f1808th.getPackageName()), "dic/v1/*", 2);
        uriMatcher.addURI(qqq(this.f1808th.getPackageName()), "clo/v1/*", 3);
    }

    public final boolean ppp(qw qwVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return m102switch(Uri.parse(i(this.f1808th.getPackageName(), qwVar)));
    }

    public final String qqq(String str) {
        return str + ".cesium";
    }

    public qw.th qw(qw.rg rgVar, h.a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return qw.th.de();
        }
        rg qw2 = rg.qw(aVar);
        if (qw2 == null) {
            return qw.th.de();
        }
        C0102de deVar = new C0102de(this, qw2.qw);
        deVar.de(qw.ad(qw2.f1815ad, false));
        deVar.de(qw.ad(qw2.f1815ad, true));
        byte[] bArr = qw2.f1816de;
        if (bArr != null) {
            for (byte b : bArr) {
                deVar.de(qw.ad(b, false));
                deVar.de(qw.ad(b, true));
            }
        }
        ad adVar = new ad();
        for (int i2 = 0; i2 < deVar.qw(); i2++) {
            adVar.ad(deVar.ad(i2));
        }
        List<qw> qw3 = adVar.qw();
        if (!ggg(deVar, qw3)) {
            return qw.th.ad();
        }
        for (int qw4 = deVar.qw() - 1; qw4 >= 0; qw4--) {
            m101if(qw4, deVar.ad(qw4));
        }
        for (qw ppp : qw3) {
            ppp(ppp);
        }
        rrr(h.m8if());
        return qw.th.ad();
    }

    public void rg(qw.fe feVar) {
        this.f1808th = this.qw.qw;
    }

    public final boolean rrr(String str) {
        if (TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return m102switch(Uri.parse(eee(this.f1808th.getPackageName()))) && m102switch(Uri.parse(o(this.f1808th.getPackageName(), str)));
    }

    /* renamed from: switch  reason: not valid java name */
    public final boolean m102switch(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f1808th;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f1809yj.rg(context, context.getPackageName(), uri, 65);
            this.f1809yj.de(contentResolver, uri, 1);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String uk(String str, int i2, qw qwVar) {
        return String.format("content://%s/dat/v1/i%d/%s", new Object[]{qqq(str), Integer.valueOf(i2), qwVar.rg()});
    }

    public final boolean vvv(String str, int i2) {
        int i3;
        Uri parse = Uri.parse(eee(str));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.f1809yj.qw(this.f1808th, parse, 0, i2, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5);
                } catch (Exception unused2) {
                }
                i4++;
            }
        }
        return i3 == 0;
    }

    public final boolean when(Uri uri, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f1808th;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f1809yj.fe(context, uri, i2);
            this.f1809yj.th(contentResolver, uri, i2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean xxx(String str, int i2, qw qwVar, int i3, th thVar) {
        int i4;
        Uri parse = Uri.parse(uk(str, i2, qwVar));
        int i5 = 0;
        while (true) {
            if (i5 < 2) {
                if (thVar == null) {
                    break;
                }
                try {
                    thVar.qw++;
                    break;
                } catch (Throwable unused) {
                    try {
                        Thread.sleep(5);
                    } catch (Exception unused2) {
                    }
                    i5++;
                }
            } else {
                i4 = -1;
                break;
            }
        }
        i4 = this.f1809yj.qw(this.f1808th, parse, 0, i3, 1);
        if (i4 == 0) {
            return true;
        }
        if (thVar != null) {
            thVar.f1819ad++;
        }
        return false;
    }

    public final qw yj(String str, int i2, List<fe.ad> list, int i3, th thVar) {
        for (fe.ad next : list) {
            if (xxx(str, i2, next.f1812ad, i3, thVar)) {
                next.ad();
                return next.f1812ad;
            }
        }
        return null;
    }
}
