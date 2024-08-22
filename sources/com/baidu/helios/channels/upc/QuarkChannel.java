package com.baidu.helios.channels.upc;

import android.content.ContentResolver;
import android.content.Context;
import android.content.UriMatcher;
import android.content.UriPermission;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.helios.channels.BaseChannel;
import com.baidu.helios.channels.ChannelFactory;
import com.baidu.helios.channels.upc.d;
import com.baidu.helios.common.internal.util.LongFlags;
import com.baidu.helios.common.storage.HeliosStorageManager;
import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.helios.ids.aid.AidProvider;
import com.baidu.nps.pm.provider.BundleOpProvider;
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
import org.json.JSONObject;

public class QuarkChannel extends BaseChannel {

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f12887b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final String f12888c = "Helios";

    /* renamed from: e  reason: collision with root package name */
    private static final int f12889e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12890f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static final int f12891g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static final long f12892h = 5;

    /* renamed from: i  reason: collision with root package name */
    private static final int f12893i = 6;

    /* renamed from: j  reason: collision with root package name */
    private static final int f12894j = 20;
    private static final int k = 100;
    private static final int l = 10;

    /* renamed from: a  reason: collision with root package name */
    HeliosStorageManager.StorageSession f12895a;

    /* renamed from: d  reason: collision with root package name */
    private Context f12896d;
    private k m = new k();
    private j n = new j();

    public static final class a extends b<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f12897a = 0;

        /* renamed from: b  reason: collision with root package name */
        public static final int f12898b = b.b(4);

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f12899c = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        /* renamed from: d  reason: collision with root package name */
        private static final int f12900d = 4;

        private a(int i2) {
            super(i2, 4);
        }

        public static a a(byte b2, boolean z) {
            byte b3 = b2 & UByte.MAX_VALUE;
            return a(z ? b3 >> 4 : b3 & 15);
        }

        public static a a(int i2) {
            return new a(i2);
        }

        public /* bridge */ /* synthetic */ int a(b bVar) {
            return super.compareTo(bVar);
        }

        public String a() {
            return f12899c[c()];
        }

        public byte b() {
            return (byte) c();
        }

        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return super.equals(obj);
        }

        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }
    }

    static abstract class b<T extends b> implements Comparable<T> {

        /* renamed from: a  reason: collision with root package name */
        private int f12901a;

        public b(int i2, int i3) {
            int b2 = b(i3);
            if (i2 < 0 || i2 > b2) {
                throw new IllegalArgumentException("invalid index " + i2);
            }
            this.f12901a = i2;
        }

        static int b(int i2) {
            return (1 << i2) - 1;
        }

        /* renamed from: a */
        public int compareTo(T t) {
            return this.f12901a - t.c();
        }

        public abstract String a();

        public int c() {
            return this.f12901a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f12901a == ((b) obj).f12901a;
        }

        public int hashCode() {
            return this.f12901a;
        }
    }

    public static class c<T extends b> {

        /* renamed from: a  reason: collision with root package name */
        private List<a<T>> f12902a = new ArrayList();

        static class a<T> {
            /* access modifiers changed from: private */

            /* renamed from: a  reason: collision with root package name */
            public int f12905a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public T f12906b;

            public a(T t) {
                this.f12906b = t;
            }

            static /* synthetic */ int a(a aVar, int i2) {
                int i3 = aVar.f12905a + i2;
                aVar.f12905a = i3;
                return i3;
            }

            public void a() {
                this.f12905a++;
            }

            public T b() {
                return this.f12906b;
            }
        }

        public a<T> a(T t) {
            for (a<T> next : this.f12902a) {
                if (((b) next.f12906b).equals(t)) {
                    return next;
                }
            }
            return null;
        }

        public String a(int i2) {
            StringBuilder sb = new StringBuilder();
            List<a> a2 = a();
            sb.append("{");
            for (a aVar : a2) {
                sb.append(((b) aVar.f12906b).c());
                sb.append(":");
                sb.append(aVar.f12905a / i2);
                sb.append("; ");
            }
            sb.append(com.alipay.sdk.m.u.i.f2534d);
            return sb.toString();
        }

        public List<a<T>> a() {
            ArrayList arrayList = new ArrayList(this.f12902a);
            Collections.sort(arrayList, new Comparator<a<T>>() {
                /* renamed from: a */
                public int compare(a<T> aVar, a<T> aVar2) {
                    return aVar.f12905a - aVar2.f12905a;
                }
            });
            return arrayList;
        }

        public void a(c<T> cVar) {
            for (a next : cVar.f12902a) {
                a a2 = a((b) next.f12906b);
                if (a2 == null) {
                    a2 = b((b) next.f12906b);
                }
                a.a(a2, next.f12905a);
            }
        }

        public a b(T t) {
            a aVar = new a(t);
            this.f12902a.add(aVar);
            return aVar;
        }

        public List<a<T>> b() {
            ArrayList arrayList = new ArrayList(this.f12902a);
            Collections.sort(arrayList, new Comparator<a<T>>() {
                /* renamed from: a */
                public int compare(a<T> aVar, a<T> aVar2) {
                    return aVar2.f12905a - aVar.f12905a;
                }
            });
            return arrayList;
        }

        public String c() {
            return a(1);
        }
    }

    static final class d extends b<d> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f12907a = 6;

        /* renamed from: b  reason: collision with root package name */
        public static final int f12908b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f12909c;

        /* renamed from: d  reason: collision with root package name */
        private static final String[] f12910d;

        static {
            int b2 = b.b(6);
            f12909c = b2;
            f12910d = new String[(b2 + 1)];
            String[] strArr = {"read", "access", "sync", "open", "refresh", BundleOpProvider.METHOD_BUNDLE_CHECK, "close", "release"};
            for (int i2 = 0; i2 <= f12909c; i2++) {
                String str = strArr[i2 / 8];
                f12910d[i2] = str + String.valueOf(i2 % 8);
            }
        }

        private d(int i2) {
            super(i2, 6);
        }

        public static d a(byte b2) {
            return a((int) b2 & UByte.MAX_VALUE);
        }

        public static d a(int i2) {
            return new d(i2);
        }

        public static d a(g gVar, a aVar) {
            return a((gVar.c() << 4) | aVar.c());
        }

        public String a() {
            return f12910d[c()];
        }

        public byte b() {
            return (byte) c();
        }

        public a d() {
            return a.a(c() & 15);
        }

        public g e() {
            return g.a(c() >> 4);
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        private int f12911a = 27;

        /* renamed from: b  reason: collision with root package name */
        private d[] f12912b = new d[27];

        /* renamed from: c  reason: collision with root package name */
        private int f12913c;

        public static e a(byte[] bArr) {
            e eVar = new e();
            for (byte a2 : b.b(bArr)) {
                eVar.a(d.a(a2));
            }
            return eVar;
        }

        private void b(int i2) {
            d[] dVarArr = this.f12912b;
            if (i2 - dVarArr.length > 0) {
                int length = dVarArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f12912b = (d[]) Arrays.copyOf(dVarArr, i2);
            }
        }

        public int a() {
            return this.f12913c;
        }

        public d a(int i2) {
            if (i2 < this.f12913c) {
                return this.f12912b[i2];
            }
            throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f12913c);
        }

        public void a(d dVar) {
            b(this.f12913c + 1);
            d[] dVarArr = this.f12912b;
            int i2 = this.f12913c;
            this.f12913c = i2 + 1;
            dVarArr[i2] = dVar;
        }

        public byte[] b() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < this.f12913c; i2++) {
                byteArrayOutputStream.write(this.f12912b[i2].b());
            }
            return b.a(byteArrayOutputStream.toByteArray());
        }
    }

    static class f<T extends b> {

        /* renamed from: a  reason: collision with root package name */
        private int f12914a;

        /* renamed from: b  reason: collision with root package name */
        private Map<T, Integer> f12915b = new HashMap();

        public f(int i2) {
            this.f12914a = i2;
        }

        public List<T> a() {
            ArrayList arrayList = new ArrayList(this.f12915b.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<T, Integer>>() {
                /* renamed from: a */
                public int compare(Map.Entry<T, Integer> entry, Map.Entry<T, Integer> entry2) {
                    int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                    return intValue != 0 ? intValue : ((b) entry.getKey()).compareTo((b) entry2.getKey());
                }
            });
            ArrayList arrayList2 = new ArrayList(this.f12914a);
            int min = Math.min(this.f12914a, arrayList.size());
            for (int i2 = 0; i2 < min; i2++) {
                Map.Entry entry = (Map.Entry) arrayList.get(i2);
                if (((Integer) entry.getValue()).intValue() > 1) {
                    arrayList2.add(entry.getKey());
                }
            }
            return arrayList2;
        }

        public void a(T t) {
            Integer num = this.f12915b.get(t);
            this.f12915b.put(t, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
        }
    }

    public static final class g extends b<g> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f12917a = 2;

        /* renamed from: b  reason: collision with root package name */
        public static final int f12918b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f12919c = b.b(2);

        public g(int i2) {
            super(i2, 2);
        }

        public static g a(int i2) {
            return new g(i2);
        }

        public /* bridge */ /* synthetic */ int a(b bVar) {
            return super.compareTo(bVar);
        }

        public String a() {
            return null;
        }

        public byte b() {
            return (byte) c();
        }

        public /* bridge */ /* synthetic */ int c() {
            return super.c();
        }

        public /* bridge */ /* synthetic */ boolean equals(Object obj) {
            return super.equals(obj);
        }

        public /* bridge */ /* synthetic */ int hashCode() {
            return super.hashCode();
        }
    }

    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public i f12920a;

        /* renamed from: b  reason: collision with root package name */
        public c<a> f12921b;

        /* renamed from: c  reason: collision with root package name */
        public c<a> f12922c;

        /* renamed from: d  reason: collision with root package name */
        public c<g> f12923d;
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public int f12924a;

        /* renamed from: b  reason: collision with root package name */
        public int f12925b;

        /* renamed from: c  reason: collision with root package name */
        public int f12926c = 16;

        public String a(int i2) {
            return "";
        }

        public void a(i iVar) {
            this.f12924a += iVar.f12924a;
            this.f12925b += iVar.f12925b;
        }

        public String toString() {
            return "";
        }
    }

    class j {

        /* renamed from: b  reason: collision with root package name */
        public static final long f12927b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final long f12928c = 1;

        /* renamed from: d  reason: collision with root package name */
        public static final long f12929d = 1;

        /* renamed from: e  reason: collision with root package name */
        public static final long f12930e = 0;

        /* renamed from: f  reason: collision with root package name */
        public static final long f12931f = 2;

        /* renamed from: g  reason: collision with root package name */
        public static final long f12932g = 4;

        /* renamed from: h  reason: collision with root package name */
        public static final long f12933h = 6;

        /* renamed from: j  reason: collision with root package name */
        private static final String f12934j = "pub.dat";
        private static final String k = "pub_ver";
        private static final String l = "pub_lst_ts";
        private static final String m = "pkg_lst_up_ts";
        private static final String n = "aid";
        private static final String o = "flags";
        private static final String p = "d_form_ver";
        private static final int q = 1;

        /* renamed from: a  reason: collision with root package name */
        public long f12935a;
        private int r;
        private LongFlags s = new LongFlags();
        private long t;
        private String u;
        private int v;
        private boolean w = true;

        j() {
        }

        public long a() {
            return this.f12935a;
        }

        public void a(long j2) {
            if (this.f12935a != j2) {
                this.f12935a = j2;
                this.w = true;
            }
        }

        public boolean a(long j2, long j3) {
            if (!this.s.setFlags(j2, j3)) {
                return false;
            }
            this.w = true;
            return true;
        }

        public boolean a(String str) {
            String str2 = this.u;
            if (str2 == str) {
                return false;
            }
            if (str != null && str.equals(str2)) {
                return false;
            }
            this.w = true;
            this.u = str;
            return true;
        }

        public long b() {
            return this.t;
        }

        public long b(long j2) {
            return this.s.getFlags(j2);
        }

        public String c() {
            return this.u;
        }

        public boolean c(long j2) {
            if (this.t == j2) {
                return false;
            }
            this.t = j2;
            this.w = true;
            return true;
        }

        public void d() {
            String readFileAsString = QuarkChannel.this.f12895a.readFileAsString(f12934j, true);
            if (!TextUtils.isEmpty(readFileAsString)) {
                try {
                    JSONObject jSONObject = new JSONObject(readFileAsString);
                    this.r = jSONObject.getInt(k);
                    this.f12935a = jSONObject.getLong(l);
                    this.t = jSONObject.getLong(m);
                    this.s.resetFlags(jSONObject.getLong("flags"));
                    this.v = jSONObject.getInt(p);
                    this.u = jSONObject.optString("aid");
                    this.w = false;
                } catch (Exception e2) {
                    this.w = true;
                }
            }
        }

        public boolean e() {
            if (this.w) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(k, this.r);
                    jSONObject.put(l, this.f12935a);
                    jSONObject.put(m, this.t);
                    jSONObject.put("flags", this.s.toLongValues());
                    jSONObject.put(p, 1);
                    jSONObject.put("aid", this.u);
                    QuarkChannel.this.f12895a.writeStringToFile(f12934j, jSONObject.toString(), true);
                    this.w = false;
                    return true;
                } catch (Exception e2) {
                }
            }
            return false;
        }
    }

    static class k {

        /* renamed from: a  reason: collision with root package name */
        private Method f12937a;

        /* renamed from: b  reason: collision with root package name */
        private Method f12938b;

        /* renamed from: c  reason: collision with root package name */
        private Method f12939c;

        /* renamed from: d  reason: collision with root package name */
        private Method f12940d;

        /* renamed from: e  reason: collision with root package name */
        private Method f12941e;

        k() {
        }

        public int a(Context context, Uri uri, int i2, int i3, int i4) {
            try {
                return ((Integer) this.f12937a.invoke(context, new Object[]{uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
            } catch (Exception e2) {
                throw new d.a((Throwable) e2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                this.f12937a = d.a(Context.class, d.a(c.a()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f12938b = d.a(Context.class, d.a(c.b()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f12939c = d.a(ContentResolver.class, d.a(c.c()), new Class[]{Uri.class, Integer.TYPE});
                this.f12940d = d.a(Context.class, d.a(c.d()), new Class[]{Uri.class, Integer.TYPE});
                this.f12941e = d.a(ContentResolver.class, d.a(c.e()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception e2) {
            }
        }

        public void a(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f12939c.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new d.a((Throwable) e2);
            }
        }

        public void a(Context context, Uri uri, int i2) {
            try {
                this.f12940d.invoke(context, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new d.a((Throwable) e2);
            }
        }

        public void a(Context context, String str, Uri uri, int i2) {
            try {
                this.f12938b.invoke(context, new Object[]{str, uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new d.a((Throwable) e2);
            }
        }

        public void b(ContentResolver contentResolver, Uri uri, int i2) {
            try {
                this.f12941e.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e2) {
                throw new d.a((Throwable) e2);
            }
        }
    }

    class l extends BaseChannel.BaseTargetIdCacheData {

        /* renamed from: b  reason: collision with root package name */
        private static final String f12942b = "pkg";

        /* renamed from: c  reason: collision with root package name */
        private static final String f12943c = "last_fe_ts";

        /* renamed from: d  reason: collision with root package name */
        private static final String f12944d = "id";

        /* renamed from: e  reason: collision with root package name */
        private static final String f12945e = "d_form_ver";

        /* renamed from: f  reason: collision with root package name */
        private static final int f12946f = 1;

        /* renamed from: g  reason: collision with root package name */
        private String f12948g;

        /* renamed from: h  reason: collision with root package name */
        private long f12949h;

        /* renamed from: i  reason: collision with root package name */
        private String f12950i;

        /* renamed from: j  reason: collision with root package name */
        private int f12951j;

        public l(String str) {
            super(QuarkChannel.this.f12895a, str);
        }

        public String a() {
            return this.f12948g;
        }

        public void a(long j2) {
            if (this.f12949h != j2) {
                this.f12949h = j2;
                markDirty(true);
            }
        }

        public void a(String str) {
            if (!str.equals(this.f12948g)) {
                this.f12948g = str;
                markDirty(true);
            }
        }

        public String b() {
            return this.f12950i;
        }

        public void b(String str) {
            if (!str.equals(this.f12950i)) {
                this.f12950i = str;
                markDirty(true);
            }
        }

        public void readFromJson(JSONObject jSONObject) {
            this.f12948g = jSONObject.getString("pkg");
            this.f12949h = jSONObject.getLong(f12943c);
            this.f12950i = jSONObject.getString("id");
            this.f12951j = jSONObject.getInt(f12945e);
        }

        public void writeToJson(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f12948g);
            jSONObject.put(f12943c, this.f12949h);
            jSONObject.put("id", this.f12950i);
            jSONObject.put(f12945e, 1);
        }
    }

    public QuarkChannel() {
        super("upc", ChannelFactory.CHANNEL_NAME_QUARK_PRIORITY);
    }

    private BaseChannel.PublishResult a(BaseChannel.PublishOptions publishOptions) {
        String c2;
        if (Build.VERSION.SDK_INT < 26) {
            return BaseChannel.PublishResult.errorOf();
        }
        Context context = this.attachInfo.applicationContext;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.n.b();
            this.n.c(packageInfo.lastUpdateTime);
            if (!z && this.n.b(6) == 4) {
                return BaseChannel.PublishResult.errorOf();
            }
            BaseIdProvider idProvider = this.attachInfo.idProviderFactory.getIdProvider("aid");
            e a2 = e.a(idProvider.getIdRawBytes());
            if (a2 == null) {
                return BaseChannel.PublishResult.errorOf();
            }
            if (this.n.b(1) == 1 && (c2 = this.n.c()) != null && c2.equals(idProvider.getFormattedId())) {
                return BaseChannel.PublishResult.successOf();
            }
            this.n.a(idProvider.getFormattedId());
            ProviderInfo providerInfo = null;
            try {
                providerInfo = packageManager.resolveContentProvider(a(packageName), 0);
            } catch (Exception e2) {
            }
            if (providerInfo == null) {
                this.n.a(4, 6);
            } else {
                this.n.a(2, 6);
            }
            return a(a2);
        } catch (PackageManager.NameNotFoundException e3) {
            return BaseChannel.PublishResult.errorOf();
        }
    }

    private BaseChannel.PublishResult a(e eVar) {
        f fVar = new f(6);
        for (int i2 = 0; i2 < eVar.a(); i2++) {
            fVar.a(eVar.a(i2).d());
        }
        List<a> a2 = fVar.a();
        if (a(eVar, a2)) {
            for (int a3 = eVar.a() - 1; a3 >= 0; a3--) {
                a(a3, eVar.a(a3));
            }
            for (a a4 : a2) {
                a(a4);
            }
            this.n.a(System.currentTimeMillis());
        }
        this.n.a(1, 1);
        return BaseChannel.PublishResult.successOf();
    }

    private d a(String str, int i2, List<c.a<a>> list, List<c.a<g>> list2, int i3, i iVar) {
        for (c.a next : list) {
            Iterator<c.a<g>> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    c.a next2 = it.next();
                    d a2 = d.a((g) next2.b(), (a) next.b());
                    if (a(str, i2, a2, i3, iVar)) {
                        next.a();
                        next2.a();
                        return a2;
                    }
                }
            }
        }
        return null;
    }

    private String a(String str) {
        return str + ".helios.quark";
    }

    private String a(String str, int i2, d dVar) {
        return String.format("content://%s/dat/v1/i%d/%s", new Object[]{a(str), Integer.valueOf(i2), dVar.a()});
    }

    private String a(String str, a aVar) {
        return String.format("content://%s/dic/v1/%s", new Object[]{a(str), aVar.a()});
    }

    private void a(UriMatcher uriMatcher) {
        uriMatcher.addURI(a(this.f12896d.getPackageName()), "dat/v1/*/*", 1);
        uriMatcher.addURI(a(this.f12896d.getPackageName()), "dic/v1/*", 2);
    }

    private boolean a(int i2, d dVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return a(Uri.parse(a(this.f12896d.getPackageName(), i2, dVar)));
    }

    private boolean a(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f12896d;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.m.a(context, context.getPackageName(), uri, 65);
            this.m.a(contentResolver, uri, 1);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean a(Uri uri, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f12896d;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.m.a(context, uri, i2);
            this.m.b(contentResolver, uri, i2);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    private boolean a(a aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return a(Uri.parse(a(this.f12896d.getPackageName(), aVar)));
    }

    private boolean a(e eVar, List<a> list) {
        boolean z;
        int i2;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        ContentResolver contentResolver = this.f12896d.getContentResolver();
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
            if ((match == 1 || match == 2) && next.isWritePermission()) {
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
                    if (i2 >= 0 && i2 < eVar.a()) {
                        if (eVar.a(i2).a().equals(pathSegments.get(3))) {
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
                }
                a(uri, 1);
            }
        }
        int a2 = eVar.a();
        for (int i4 = 0; i4 < a2; i4++) {
            if (!a(this.f12896d.getPackageName(), i4, eVar.a(i4), Process.myUid(), (i) null)) {
                return true;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!a(this.f12896d.getPackageName(), list.get(i5), Process.myUid())) {
                return true;
            }
        }
        return false;
    }

    private boolean a(String str, int i2, d dVar, int i3, i iVar) {
        int i4;
        Uri parse = Uri.parse(a(str, i2, dVar));
        int i5 = 0;
        while (true) {
            if (i5 < 2) {
                if (iVar == null) {
                    break;
                }
                try {
                    if (iVar.f12924a > 0 && iVar.f12924a % 100 == 0) {
                        try {
                            Thread.sleep(10);
                        } catch (Exception e2) {
                        }
                    }
                    iVar.f12924a++;
                    break;
                } catch (Throwable th2) {
                    try {
                        Thread.sleep(5);
                    } catch (Exception e3) {
                    }
                    i5++;
                }
            } else {
                i4 = -1;
                break;
            }
        }
        i4 = this.m.a(this.f12896d, parse, 0, i3, 1);
        if (i4 == 0) {
            return true;
        }
        if (iVar != null) {
            iVar.f12925b++;
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
                i3 = this.m.a(this.f12896d, parse, 0, i2, 1);
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

    public BaseChannel.TargetIdResult getIdForPackage(String str, BaseChannel.TargetIdOptions targetIdOptions) {
        PackageInfo packageInfo;
        String str2 = str;
        BaseChannel.TargetIdOptions targetIdOptions2 = targetIdOptions;
        if (Build.VERSION.SDK_INT < 26) {
            return BaseChannel.TargetIdResult.errorOf();
        }
        h hVar = new h();
        l lVar = null;
        try {
            packageInfo = this.f12896d.getPackageManager().getPackageInfo(str2, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return BaseChannel.TargetIdResult.errorOf();
        }
        if (targetIdOptions2.useCache) {
            lVar = new l(str2);
            lVar.resetFromCache();
            if (str2.equals(lVar.a())) {
                String b2 = lVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    return BaseChannel.TargetIdResult.successOf(b2);
                }
            }
            lVar.a(str2);
        }
        l lVar2 = lVar;
        int i2 = packageInfo.applicationInfo.uid;
        i iVar = new i();
        hVar.f12920a = iVar;
        c<a> cVar = new c<>();
        c<a> cVar2 = new c<>();
        hVar.f12921b = cVar;
        hVar.f12922c = cVar2;
        int i3 = 0;
        while (i3 < 16) {
            try {
                a a2 = a.a(i3);
                if (a(str2, a2, i2)) {
                    cVar.b(a2);
                } else {
                    cVar2.b(a2);
                }
                i3++;
            } catch (Throwable th2) {
                if (targetIdOptions2.useCache && lVar2 != null) {
                    lVar2.persist();
                }
                throw th2;
            }
        }
        e eVar = new e();
        int a3 = b.a(20);
        c<g> cVar3 = new c<>();
        hVar.f12923d = cVar3;
        for (int i4 = 0; i4 <= g.f12919c; i4++) {
            cVar3.b(g.a(i4));
        }
        int i5 = 0;
        while (i5 < a3) {
            int i6 = i5;
            c<g> cVar4 = cVar3;
            int i7 = a3;
            e eVar2 = eVar;
            d a4 = a(str, i5, cVar.a(), cVar3.b(), i2, iVar);
            if (a4 == null) {
                a4 = a(str, i6, cVar2.a(), cVar4.b(), i2, iVar);
            }
            if (a4 == null) {
                BaseChannel.TargetIdResult errorOf = BaseChannel.TargetIdResult.errorOf();
                if (targetIdOptions2.useCache && lVar2 != null) {
                    lVar2.persist();
                }
                return errorOf;
            }
            eVar2.a(a4);
            i5 = i6 + 1;
            eVar = eVar2;
            cVar3 = cVar4;
            a3 = i7;
        }
        String finalIdFromRawBytes = AidProvider.getFinalIdFromRawBytes(eVar.b());
        if (targetIdOptions2.useCache && lVar2 != null) {
            lVar2.b(finalIdFromRawBytes);
            lVar2.a(System.currentTimeMillis());
        }
        BaseChannel.TargetIdResult successOf = BaseChannel.TargetIdResult.successOf(finalIdFromRawBytes);
        if (targetIdOptions2.useDebugInfo) {
            successOf.extra = hVar;
        }
        if (targetIdOptions2.useCache && lVar2 != null) {
            lVar2.persist();
        }
        return successOf;
    }

    public void init(BaseChannel.InitOptions initOptions) {
        this.f12896d = this.attachInfo.applicationContext;
        this.f12895a = this.storageSessionBase.nextSession("upc");
        this.m.a();
    }

    public BaseChannel.PublishResult publish(BaseChannel.PublishOptions publishOptions) {
        this.n.d();
        try {
            return a(publishOptions);
        } finally {
            this.n.e();
        }
    }
}
