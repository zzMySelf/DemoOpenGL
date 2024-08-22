package com.baidu.cesium.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.cesium.a.i;
import com.baidu.cesium.b.a;
import com.baidu.cesium.h;
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
import kotlin.UByte;

public class d extends a {

    /* renamed from: e  reason: collision with root package name */
    private static final boolean f11332e = false;

    /* renamed from: f  reason: collision with root package name */
    private static final String f11333f = "Cesium";

    /* renamed from: h  reason: collision with root package name */
    private static final int f11334h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11335i = 2;

    /* renamed from: j  reason: collision with root package name */
    private static final int f11336j = 3;
    private static final int k = 2;
    private static final long l = 5;
    private static final int m = 6;
    private static final int n = 16;
    private static final String o = "yes";

    /* renamed from: g  reason: collision with root package name */
    private Context f11337g;
    private g p;

    static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f11338a = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: b  reason: collision with root package name */
        private final int f11339b;

        private a(int i2) {
            this.f11339b = i2;
        }

        public static a a(byte b2, boolean z) {
            byte b3 = b2 & UByte.MAX_VALUE;
            return a(z ? b3 >> 4 : b3 & 15);
        }

        public static a a(int i2) {
            if (i2 >= 0 && i2 < 16) {
                return new a(i2);
            }
            throw new IllegalArgumentException("invalid idx " + i2);
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return this.f11339b - aVar.f11339b;
        }

        public String a() {
            return f11338a[this.f11339b];
        }

        public byte b() {
            return (byte) this.f11339b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f11339b == ((a) obj).f11339b;
        }

        public int hashCode() {
            return this.f11339b;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private Map<a, Integer> f11340a = new HashMap();

        b() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f11340a.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<a, Integer>>() {
                /* renamed from: a */
                public int compare(Map.Entry<a, Integer> entry, Map.Entry<a, Integer> entry2) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    return intValue != 0 ? intValue : entry.getKey().compareTo(entry2.getKey());
                }
            });
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

        public void a(a aVar) {
            Integer num = this.f11340a.get(aVar);
            this.f11340a.put(aVar, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
    }

    class c {

        /* renamed from: b  reason: collision with root package name */
        private int f11343b = 33;

        /* renamed from: c  reason: collision with root package name */
        private a[] f11344c = new a[33];

        /* renamed from: d  reason: collision with root package name */
        private int f11345d;

        public c() {
        }

        public c(byte[] bArr) {
            if (bArr != null && bArr.length > 0) {
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    a a2 = a.a(bArr[i2], false);
                    a a3 = a.a(bArr[i2], true);
                    a(a2);
                    a(a3);
                }
            }
        }

        private void b(int i2) {
            a[] aVarArr = this.f11344c;
            if (i2 - aVarArr.length > 0) {
                int length = aVarArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f11344c = (a[]) Arrays.copyOf(aVarArr, i2);
            }
        }

        public int a() {
            return this.f11345d;
        }

        public a a(int i2) {
            if (i2 < this.f11345d) {
                return this.f11344c[i2];
            }
            throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f11345d);
        }

        public void a(a aVar) {
            b(this.f11345d + 1);
            a[] aVarArr = this.f11344c;
            int i2 = this.f11345d;
            this.f11345d = i2 + 1;
            aVarArr[i2] = aVar;
        }

        public byte[] b() {
            int i2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i3 = 0;
            while (true) {
                i2 = this.f11345d;
                if (i3 >= i2 / 2) {
                    break;
                }
                int i4 = i3 * 2;
                byteArrayOutputStream.write((byte) (((a(i4 + 1).b() & UByte.MAX_VALUE) << 4) | (a(i4).b() & UByte.MAX_VALUE)));
                i3++;
            }
            if (i2 % 2 != 0) {
                byteArrayOutputStream.write((byte) (a(i2 - 1).b() & UByte.MAX_VALUE));
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* renamed from: com.baidu.cesium.b.d$d  reason: collision with other inner class name */
    static class C0214d {

        /* renamed from: a  reason: collision with root package name */
        private List<a> f11346a = new ArrayList();

        /* renamed from: com.baidu.cesium.b.d$d$a */
        static class a {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f11348a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public a f11349b;

            public a(a aVar) {
                this.f11349b = aVar;
            }

            public void a() {
                this.f11348a++;
            }

            public a b() {
                return this.f11349b;
            }
        }

        C0214d() {
        }

        public List<a> a() {
            ArrayList arrayList = new ArrayList(this.f11346a);
            Collections.sort(arrayList, new Comparator<a>() {
                /* renamed from: a */
                public int compare(a aVar, a aVar2) {
                    return aVar.f11348a - aVar2.f11348a;
                }
            });
            return arrayList;
        }

        public void a(a aVar) {
            this.f11346a.add(new a(aVar));
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        byte[] f11350a;

        /* renamed from: b  reason: collision with root package name */
        byte f11351b;

        /* renamed from: c  reason: collision with root package name */
        byte[] f11352c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11353d;

        /* renamed from: e  reason: collision with root package name */
        String f11354e = "";

        public e(byte[] bArr, byte b2, byte[] bArr2, boolean z, String str) {
            this.f11350a = bArr;
            this.f11351b = b2;
            this.f11352c = bArr2;
            this.f11353d = z;
            this.f11354e = str;
        }

        public static e a(h.a aVar) {
            try {
                byte[] a2 = d.b(aVar.b());
                if (a2.length > 16) {
                    return null;
                }
                return new e(a2, aVar.d().getBytes("UTF-8")[0], aVar.c() != null ? aVar.c().getBytes("UTF-8") : null, aVar.e(), aVar.f());
            } catch (Exception e2) {
                return null;
            }
        }

        public h.a a() {
            try {
                return h.a(com.baidu.cesium.d.c.a(this.f11350a, "", true), new String(new byte[]{this.f11351b}, "UTF-8"), this.f11352c != null ? new String(this.f11352c, "UTF-8") : null, this.f11353d, this.f11354e);
            } catch (Exception e2) {
                return null;
            }
        }
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        public int f11355a;

        /* renamed from: b  reason: collision with root package name */
        public int f11356b;

        /* renamed from: c  reason: collision with root package name */
        public int f11357c = 16;

        f() {
        }

        public String toString() {
            return "";
        }
    }

    static class g {

        /* renamed from: a  reason: collision with root package name */
        private Method f11358a;

        /* renamed from: b  reason: collision with root package name */
        private Method f11359b;

        /* renamed from: c  reason: collision with root package name */
        private Method f11360c;

        /* renamed from: d  reason: collision with root package name */
        private Method f11361d;

        /* renamed from: e  reason: collision with root package name */
        private Method f11362e;

        g() {
        }

        public int a(Context context, Uri uri, int i2, int i3, int i4) {
            try {
                return ((Integer) this.f11358a.invoke(context, new Object[]{uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
            } catch (Exception e2) {
                throw new i.a((Throwable) e2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                this.f11358a = i.a(Context.class, i.a(com.baidu.cesium.a.h.d()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f11359b = i.a(Context.class, i.a(com.baidu.cesium.a.h.e()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f11360c = i.a(ContentResolver.class, i.a(com.baidu.cesium.a.h.f()), new Class[]{Uri.class, Integer.TYPE});
                this.f11361d = i.a(Context.class, i.a(com.baidu.cesium.a.h.g()), new Class[]{Uri.class, Integer.TYPE});
                this.f11362e = i.a(ContentResolver.class, i.a(com.baidu.cesium.a.h.h()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception e2) {
            }
        }

        public void a(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f11360c.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new i.a((Throwable) e2);
            }
        }

        public void a(Context context, Uri uri, int i2) {
            try {
                this.f11361d.invoke(context, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new i.a((Throwable) e2);
            }
        }

        public void a(Context context, String str, Uri uri, int i2) {
            try {
                this.f11359b.invoke(context, new Object[]{str, uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new i.a((Throwable) e2);
            }
        }

        public void b(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f11362e.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new i.a((Throwable) e2);
            }
        }
    }

    public d() {
        super("upc", 9000000);
        g gVar = new g();
        this.p = gVar;
        gVar.a();
    }

    private a a(String str, int i2, List<C0214d.a> list, int i3, f fVar) {
        for (C0214d.a next : list) {
            if (a(str, i2, next.f11349b, i3, fVar)) {
                next.a();
                return next.f11349b;
            }
        }
        return null;
    }

    private String a(String str, int i2, a aVar) {
        return String.format("content://%s/dat/v1/i%d/%s", new Object[]{c(str), Integer.valueOf(i2), aVar.a()});
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", new Object[]{c(str), aVar.a()});
    }

    private String a(String str, String str2) {
        return String.format("content://%s/clo/v1/%s", new Object[]{c(str), str2});
    }

    private void a(UriMatcher uriMatcher) {
        uriMatcher.addURI(c(this.f11337g.getPackageName()), "dat/v1/*/*", 1);
        uriMatcher.addURI(c(this.f11337g.getPackageName()), "dic/v1/*", 2);
        uriMatcher.addURI(c(this.f11337g.getPackageName()), "clo/v1/*", 3);
    }

    private boolean a(int i2, a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return a(Uri.parse(a(this.f11337g.getPackageName(), i2, aVar)));
    }

    private boolean a(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f11337g;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.p.a(context, context.getPackageName(), uri, 65);
            this.p.a(contentResolver, uri, 1);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean a(Uri uri, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f11337g;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.p.a(context, uri, i2);
            this.p.b(contentResolver, uri, i2);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean a(a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return a(Uri.parse(a(this.f11337g.getPackageName(), aVar)));
    }

    private boolean a(c cVar, List<a> list) {
        boolean z;
        int i2;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        ContentResolver contentResolver = this.f11337g.getContentResolver();
        UriMatcher uriMatcher = new UriMatcher(-1);
        a(uriMatcher);
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
                a(uri, i3);
            } else {
                if (match == 1) {
                    try {
                        i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                    } catch (Exception e2) {
                        i2 = -1;
                    }
                    if (i2 >= 0 && i2 < cVar.a()) {
                        if (cVar.a(i2).a().equals(pathSegments.get(3))) {
                        }
                    }
                } else if (match == 2) {
                    String str = pathSegments.get(2);
                    Iterator<a> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().a().equals(str)) {
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
                    if (!TextUtils.equals(str2, h.b())) {
                        if (TextUtils.equals(str2, "yes")) {
                        }
                    }
                }
                a(uri, 1);
            }
        }
        int a2 = cVar.a();
        for (int i4 = 0; i4 < a2; i4++) {
            if (!a(this.f11337g.getPackageName(), i4, cVar.a(i4), Process.myUid(), (f) null)) {
                return true;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!a(this.f11337g.getPackageName(), list.get(i5), Process.myUid())) {
                return true;
            }
        }
        if (!a(this.f11337g.getPackageName(), Process.myUid())) {
            return true;
        }
        String b2 = h.b();
        return !TextUtils.isEmpty(b2) && !a(this.f11337g.getPackageName(), b2, Process.myUid());
    }

    private boolean a(String str, int i2) {
        int i3;
        Uri parse = Uri.parse(d(str));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.p.a(this.f11337g, parse, 0, i2, 1);
                break;
            } catch (Throwable th2) {
                try {
                    Thread.sleep(5);
                } catch (Exception e2) {
                }
                i4++;
            }
        }
        return i3 == 0;
    }

    private boolean a(String str, int i2, a aVar, int i3, f fVar) {
        int i4;
        Uri parse = Uri.parse(a(str, i2, aVar));
        int i5 = 0;
        while (true) {
            if (i5 < 2) {
                if (fVar == null) {
                    break;
                }
                try {
                    fVar.f11355a++;
                    break;
                } catch (Throwable th2) {
                    try {
                        Thread.sleep(5);
                    } catch (Exception e2) {
                    }
                    i5++;
                }
            } else {
                i4 = -1;
                break;
            }
        }
        i4 = this.p.a(this.f11337g, parse, 0, i3, 1);
        if (i4 == 0) {
            return true;
        }
        if (fVar != null) {
            fVar.f11356b++;
        }
        return false;
    }

    private boolean a(String str, a aVar, int i2) {
        int i3;
        Uri parse = Uri.parse(a(str, aVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.p.a(this.f11337g, parse, 0, i2, 1);
                break;
            } catch (Throwable th2) {
                try {
                    Thread.sleep(5);
                } catch (Exception e2) {
                }
                i4++;
            }
        }
        return i3 == 0;
    }

    private boolean a(String str, String str2, int i2) {
        int i3;
        Uri parse = Uri.parse(a(str, str2));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.p.a(this.f11337g, parse, 0, i2, 1);
                break;
            } catch (Throwable th2) {
                try {
                    Thread.sleep(5);
                } catch (Exception e2) {
                }
                i4++;
            }
        }
        return i3 == 0;
    }

    /* access modifiers changed from: private */
    public static byte[] b(String str) {
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

    private String c(String str) {
        return str + ".cesium";
    }

    private String d(String str) {
        return String.format("content://%s/clo/v1/%s", new Object[]{c(str), "yes"});
    }

    private boolean e(String str) {
        if (TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return a(Uri.parse(d(this.f11337g.getPackageName()))) && a(Uri.parse(a(this.f11337g.getPackageName(), str)));
    }

    public a.e a(a.d dVar, h.a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return a.e.d();
        }
        e a2 = e.a(aVar);
        if (a2 == null) {
            return a.e.d();
        }
        c cVar = new c(a2.f11350a);
        cVar.a(a.a(a2.f11351b, false));
        cVar.a(a.a(a2.f11351b, true));
        if (a2.f11352c != null) {
            for (byte b2 : a2.f11352c) {
                cVar.a(a.a(b2, false));
                cVar.a(a.a(b2, true));
            }
        }
        b bVar = new b();
        for (int i2 = 0; i2 < cVar.a(); i2++) {
            bVar.a(cVar.a(i2));
        }
        List<a> a3 = bVar.a();
        if (!a(cVar, a3)) {
            return a.e.c();
        }
        for (int a4 = cVar.a() - 1; a4 >= 0; a4--) {
            a(a4, cVar.a(a4));
        }
        for (a a5 : a3) {
            a(a5);
        }
        e(h.b());
        return a.e.c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.cesium.b.a.g a(java.lang.String r21, com.baidu.cesium.b.a.f r22) {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 26
            if (r0 >= r1) goto L_0x000f
            com.baidu.cesium.b.a$g r0 = com.baidu.cesium.b.a.g.c()
            return r0
        L_0x000f:
            r1 = -1
            android.content.Context r0 = r7.f11337g
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r9 = 0
            int r1 = r0.getPackageUid(r8, r9)     // Catch:{ NameNotFoundException -> 0x001d }
        L_0x001b:
            r0 = r1
            goto L_0x001f
        L_0x001d:
            r0 = move-exception
            goto L_0x001b
        L_0x001f:
            if (r0 >= 0) goto L_0x0026
            com.baidu.cesium.b.a$g r0 = com.baidu.cesium.b.a.g.c()
            return r0
        L_0x0026:
            com.baidu.cesium.b.d$f r10 = new com.baidu.cesium.b.d$f
            r10.<init>()
            com.baidu.cesium.b.d$c r11 = new com.baidu.cesium.b.d$c
            r11.<init>()
            com.baidu.cesium.b.d$d r12 = new com.baidu.cesium.b.d$d
            r12.<init>()
            com.baidu.cesium.b.d$d r13 = new com.baidu.cesium.b.d$d
            r13.<init>()
            r1 = r9
        L_0x003b:
            r2 = 16
            if (r1 >= r2) goto L_0x0053
            com.baidu.cesium.b.d$a r2 = com.baidu.cesium.b.d.a.a((int) r1)
            boolean r3 = r7.a((java.lang.String) r8, (com.baidu.cesium.b.d.a) r2, (int) r0)
            if (r3 == 0) goto L_0x004d
            r12.a(r2)
            goto L_0x0050
        L_0x004d:
            r13.a(r2)
        L_0x0050:
            int r1 = r1 + 1
            goto L_0x003b
        L_0x0053:
            r14 = r9
        L_0x0054:
            r15 = 32
            if (r14 >= r15) goto L_0x0085
            java.util.List r4 = r12.a()
            r1 = r20
            r2 = r21
            r3 = r14
            r5 = r0
            r6 = r10
            com.baidu.cesium.b.d$a r1 = r1.a((java.lang.String) r2, (int) r3, (java.util.List<com.baidu.cesium.b.d.C0214d.a>) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
            if (r1 != 0) goto L_0x0078
            java.util.List r4 = r13.a()
            r1 = r20
            r2 = r21
            r3 = r14
            r5 = r0
            r6 = r10
            com.baidu.cesium.b.d$a r1 = r1.a((java.lang.String) r2, (int) r3, (java.util.List<com.baidu.cesium.b.d.C0214d.a>) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
        L_0x0078:
            if (r1 != 0) goto L_0x007f
            com.baidu.cesium.b.a$g r0 = com.baidu.cesium.b.a.g.c()
            return r0
        L_0x007f:
            r11.a((com.baidu.cesium.b.d.a) r1)
            int r14 = r14 + 1
            goto L_0x0054
        L_0x0085:
            byte[] r11 = r11.b()
            r14 = 3
            byte[] r6 = new byte[r14]
            java.lang.String r1 = "0"
            byte[] r1 = r1.getBytes()
            byte r1 = r1[r9]
            r6[r9] = r1
            java.lang.String r1 = "O"
            byte[] r1 = r1.getBytes()
            byte r1 = r1[r9]
            r5 = 1
            r6[r5] = r1
            r1 = 2
            java.lang.String r2 = "V"
            byte[] r2 = r2.getBytes()
            byte r2 = r2[r9]
            r6[r1] = r2
            r4 = r9
        L_0x00ad:
            r16 = 0
            if (r4 >= r14) goto L_0x0105
            byte r3 = r6[r4]
            com.baidu.cesium.b.d$a r2 = com.baidu.cesium.b.d.a.a(r3, r9)
            r17 = 32
            r1 = r20
            r22 = r2
            r2 = r21
            r14 = r3
            r3 = r17
            r17 = r4
            r4 = r22
            r15 = r5
            r5 = r0
            r19 = r6
            r6 = r10
            boolean r1 = r1.a((java.lang.String) r2, (int) r3, (com.baidu.cesium.b.d.a) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
            if (r1 == 0) goto L_0x00fc
            com.baidu.cesium.b.d$a r14 = com.baidu.cesium.b.d.a.a(r14, r15)
            r3 = 33
            r1 = r20
            r2 = r21
            r4 = r14
            r5 = r0
            r6 = r10
            boolean r1 = r1.a((java.lang.String) r2, (int) r3, (com.baidu.cesium.b.d.a) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
            if (r1 == 0) goto L_0x00fc
            com.baidu.cesium.b.d$c r1 = new com.baidu.cesium.b.d$c
            r1.<init>()
            r2 = r22
            r1.a((com.baidu.cesium.b.d.a) r2)
            r1.a((com.baidu.cesium.b.d.a) r14)
            byte[] r1 = r1.b()
            byte r1 = r1[r9]
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)
            goto L_0x0108
        L_0x00fc:
            int r4 = r17 + 1
            r5 = r15
            r6 = r19
            r14 = 3
            r15 = 32
            goto L_0x00ad
        L_0x0105:
            r15 = r5
            r1 = r16
        L_0x0108:
            r14 = 34
            if (r1 != 0) goto L_0x0157
            com.baidu.cesium.b.d$c r6 = new com.baidu.cesium.b.d$c
            r6.<init>()
            r5 = 32
        L_0x0113:
            if (r5 >= r14) goto L_0x0149
            java.util.List r4 = r12.a()
            r1 = r20
            r2 = r21
            r3 = r5
            r18 = r5
            r5 = r0
            r14 = r6
            r6 = r10
            com.baidu.cesium.b.d$a r1 = r1.a((java.lang.String) r2, (int) r3, (java.util.List<com.baidu.cesium.b.d.C0214d.a>) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
            if (r1 != 0) goto L_0x0139
            java.util.List r4 = r13.a()
            r1 = r20
            r2 = r21
            r3 = r18
            r5 = r0
            r6 = r10
            com.baidu.cesium.b.d$a r1 = r1.a((java.lang.String) r2, (int) r3, (java.util.List<com.baidu.cesium.b.d.C0214d.a>) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
        L_0x0139:
            if (r1 != 0) goto L_0x0140
            com.baidu.cesium.b.a$g r0 = com.baidu.cesium.b.a.g.c()
            return r0
        L_0x0140:
            r14.a((com.baidu.cesium.b.d.a) r1)
            int r5 = r18 + 1
            r6 = r14
            r14 = 34
            goto L_0x0113
        L_0x0149:
            r14 = r6
            byte[] r1 = r14.b()
            byte r1 = r1[r9]
            java.lang.Byte r1 = java.lang.Byte.valueOf(r1)
            r14 = r1
            r5 = r15
            goto L_0x0159
        L_0x0157:
            r14 = r1
            r5 = r9
        L_0x0159:
            if (r5 == 0) goto L_0x01a2
            com.baidu.cesium.b.d$c r6 = new com.baidu.cesium.b.d$c
            r6.<init>()
            r5 = 34
        L_0x0162:
            r1 = 94
            if (r5 >= r1) goto L_0x0195
            java.util.List r4 = r12.a()
            r1 = r20
            r2 = r21
            r3 = r5
            r17 = r5
            r5 = r0
            r9 = r6
            r6 = r10
            com.baidu.cesium.b.d$a r1 = r1.a((java.lang.String) r2, (int) r3, (java.util.List<com.baidu.cesium.b.d.C0214d.a>) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
            if (r1 != 0) goto L_0x018a
            java.util.List r4 = r13.a()
            r1 = r20
            r2 = r21
            r3 = r17
            r5 = r0
            r6 = r10
            com.baidu.cesium.b.d$a r1 = r1.a((java.lang.String) r2, (int) r3, (java.util.List<com.baidu.cesium.b.d.C0214d.a>) r4, (int) r5, (com.baidu.cesium.b.d.f) r6)
        L_0x018a:
            if (r1 != 0) goto L_0x018d
            goto L_0x0196
        L_0x018d:
            r9.a((com.baidu.cesium.b.d.a) r1)
            int r5 = r17 + 1
            r6 = r9
            r9 = 0
            goto L_0x0162
        L_0x0195:
            r9 = r6
        L_0x0196:
            int r1 = r9.a()
            if (r1 <= 0) goto L_0x01a2
            byte[] r1 = r9.b()
            r4 = r1
            goto L_0x01a4
        L_0x01a2:
            r4 = r16
        L_0x01a4:
            boolean r1 = r7.a((java.lang.String) r8, (int) r0)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x01bf
            java.lang.String r1 = com.baidu.cesium.h.b()
            boolean r0 = r7.a((java.lang.String) r8, (java.lang.String) r1, (int) r0)
            if (r0 == 0) goto L_0x01bc
            java.lang.String r0 = com.baidu.cesium.h.b()
            r6 = r0
            goto L_0x01bd
        L_0x01bc:
            r6 = r2
        L_0x01bd:
            r5 = r15
            goto L_0x01c1
        L_0x01bf:
            r6 = r2
            r5 = 0
        L_0x01c1:
            com.baidu.cesium.b.d$e r0 = new com.baidu.cesium.b.d$e
            byte r3 = r14.byteValue()
            r1 = r0
            r2 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            com.baidu.cesium.h$a r0 = r0.a()
            com.baidu.cesium.b.a$g r0 = com.baidu.cesium.b.a.g.a((com.baidu.cesium.h.a) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.cesium.b.d.a(java.lang.String, com.baidu.cesium.b.a$f):com.baidu.cesium.b.a$g");
    }

    public void a(a.c cVar) {
        this.f11337g = this.f11272a.f11276a;
    }
}
