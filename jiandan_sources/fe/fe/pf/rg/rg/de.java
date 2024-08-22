package fe.fe.pf.rg.rg;

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
import com.alipay.sdk.m.x.d;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.helios.channels.upc.ReflectUtil;
import com.baidu.helios.ids.BaseIdProvider;
import com.baidu.sapi2.SapiAccount;
import fe.fe.pf.rg.qw;
import fe.fe.pf.yj.rg.qw;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONException;
import org.json.JSONObject;

public class de extends fe.fe.pf.rg.qw {

    /* renamed from: o  reason: collision with root package name */
    public static final boolean f2882o = qw.qw;

    /* renamed from: i  reason: collision with root package name */
    public o f2883i = new o();

    /* renamed from: th  reason: collision with root package name */
    public Context f2884th;

    /* renamed from: uk  reason: collision with root package name */
    public qw.C0142qw f2885uk;

    /* renamed from: yj  reason: collision with root package name */
    public pf f2886yj = new pf();

    public static abstract class ad<T extends ad> implements Comparable<T> {

        /* renamed from: ad  reason: collision with root package name */
        public int f2887ad;

        public ad(int i2, int i3) {
            int fe2 = fe(i3);
            if (i2 < 0 || i2 > fe2) {
                throw new IllegalArgumentException("invalid index " + i2);
            }
            this.f2887ad = i2;
        }

        public static int fe(int i2) {
            return (1 << i2) - 1;
        }

        public int ad() {
            return this.f2887ad;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass() && this.f2887ad == ((ad) obj).f2887ad) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f2887ad;
        }

        /* renamed from: qw */
        public int compareTo(T t) {
            return this.f2887ad - t.ad();
        }
    }

    /* renamed from: fe.fe.pf.rg.rg.de$de  reason: collision with other inner class name */
    public static class C0138de<T extends ad> {
        public List<C0139de<T>> qw = new ArrayList();

        /* renamed from: fe.fe.pf.rg.rg.de$de$ad */
        public class ad implements Comparator<C0139de<T>> {
            public ad(C0138de deVar) {
            }

            /* renamed from: qw */
            public int compare(C0139de<T> deVar, C0139de<T> deVar2) {
                return deVar2.qw - deVar.qw;
            }
        }

        /* renamed from: fe.fe.pf.rg.rg.de$de$de  reason: collision with other inner class name */
        public static class C0139de<T> {

            /* renamed from: ad  reason: collision with root package name */
            public T f2888ad;
            public int qw;

            public C0139de(T t) {
                this.f2888ad = t;
            }

            public T de() {
                return this.f2888ad;
            }

            public void fe() {
                this.qw++;
            }
        }

        /* renamed from: fe.fe.pf.rg.rg.de$de$qw */
        public class qw implements Comparator<C0139de<T>> {
            public qw(C0138de deVar) {
            }

            /* renamed from: qw */
            public int compare(C0139de<T> deVar, C0139de<T> deVar2) {
                return deVar.qw - deVar2.qw;
            }
        }

        public List<C0139de<T>> ad() {
            ArrayList arrayList = new ArrayList(this.qw);
            Collections.sort(arrayList, new qw(this));
            return arrayList;
        }

        public List<C0139de<T>> de() {
            ArrayList arrayList = new ArrayList(this.qw);
            Collections.sort(arrayList, new ad(this));
            return arrayList;
        }

        public String fe(int i2) {
            StringBuilder sb = new StringBuilder();
            List<C0139de> ad2 = ad();
            sb.append(StringUtil.ARRAY_START);
            for (C0139de deVar : ad2) {
                sb.append(((ad) deVar.f2888ad).ad());
                sb.append(":");
                sb.append(deVar.qw / i2);
                sb.append("; ");
            }
            sb.append("}");
            return sb.toString();
        }

        public C0139de qw(T t) {
            C0139de deVar = new C0139de(t);
            this.qw.add(deVar);
            return deVar;
        }

        public String rg() {
            return fe(1);
        }
    }

    public static final class fe extends ad<fe> {

        /* renamed from: th  reason: collision with root package name */
        public static final int f2889th;

        /* renamed from: yj  reason: collision with root package name */
        public static final String[] f2890yj;

        static {
            int fe2 = ad.fe(6);
            f2889th = fe2;
            f2890yj = new String[(fe2 + 1)];
            String[] strArr = {"read", "access", "sync", "open", d.w, "check", "close", "release"};
            for (int i2 = 0; i2 <= f2889th; i2++) {
                String str = strArr[i2 / 8];
                String valueOf = String.valueOf(i2 % 8);
                String[] strArr2 = f2890yj;
                strArr2[i2] = str + valueOf;
            }
        }

        public fe(int i2) {
            super(i2, 6);
        }

        public static fe pf(byte b) {
            return th(b & 255);
        }

        public static fe rg(yj yjVar, qw qwVar) {
            return th((yjVar.ad() << 4) | qwVar.ad());
        }

        public static fe th(int i2) {
            return new fe(i2);
        }

        public byte i() {
            return (byte) ad();
        }

        public String o() {
            return f2890yj[ad()];
        }

        public qw uk() {
            return qw.rg(ad() & 15);
        }
    }

    public static class i {

        /* renamed from: ad  reason: collision with root package name */
        public int f2891ad;

        /* renamed from: de  reason: collision with root package name */
        public int f2892de = 16;
        public int qw;

        public String toString() {
            if (!de.f2882o) {
                return "";
            }
            return "stat {total count = " + (this.qw + this.f2892de) + ", miss count = " + this.f2891ad + ", data probe count = " + this.qw + ExtendedMessageFormat.END_FE;
        }
    }

    /* renamed from: fe.fe.pf.rg.rg.de$if  reason: invalid class name */
    public class Cif extends qw.de {

        /* renamed from: fe  reason: collision with root package name */
        public String f2893fe;

        /* renamed from: rg  reason: collision with root package name */
        public long f2894rg;

        /* renamed from: th  reason: collision with root package name */
        public String f2895th;

        public Cif(de deVar, String str) {
            super(deVar.f2885uk, str);
        }

        public void de(JSONObject jSONObject) throws JSONException {
            this.f2893fe = jSONObject.getString(SapiAccount.ExtraProperty.EXTRA_PKG);
            this.f2894rg = jSONObject.getLong("last_fe_ts");
            this.f2895th = jSONObject.getString("id");
            jSONObject.getInt("d_form_ver");
        }

        public void i(long j) {
            if (this.f2894rg != j) {
                this.f2894rg = j;
                qw(true);
            }
        }

        public void o(String str) {
            if (!str.equals(this.f2893fe)) {
                this.f2893fe = str;
                qw(true);
            }
        }

        public void rg(JSONObject jSONObject) throws JSONException {
            jSONObject.put(SapiAccount.ExtraProperty.EXTRA_PKG, this.f2893fe);
            jSONObject.put("last_fe_ts", this.f2894rg);
            jSONObject.put("id", this.f2895th);
            jSONObject.put("d_form_ver", 1);
        }

        public String th() {
            return this.f2895th;
        }

        public void uk(String str) {
            if (!str.equals(this.f2895th)) {
                this.f2895th = str;
                qw(true);
            }
        }

        public String yj() {
            return this.f2893fe;
        }
    }

    public class o {

        /* renamed from: ad  reason: collision with root package name */
        public long f2896ad;

        /* renamed from: de  reason: collision with root package name */
        public fe.fe.pf.yj.fe.de.rg f2897de = new fe.fe.pf.yj.fe.de.rg();

        /* renamed from: fe  reason: collision with root package name */
        public long f2898fe;
        public int qw;

        /* renamed from: rg  reason: collision with root package name */
        public String f2899rg;

        /* renamed from: th  reason: collision with root package name */
        public boolean f2900th = true;

        public o() {
        }

        public long ad(long j) {
            return this.f2897de.qw(j);
        }

        public long de() {
            return this.f2898fe;
        }

        public boolean fe() {
            if (this.f2900th) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("pub_ver", this.qw);
                    jSONObject.put("pub_lst_ts", this.f2896ad);
                    jSONObject.put("pkg_lst_up_ts", this.f2898fe);
                    jSONObject.put("flags", this.f2897de.fe());
                    jSONObject.put("d_form_ver", 1);
                    jSONObject.put("aid", this.f2899rg);
                    de.this.f2885uk.i("pub.dat", jSONObject.toString(), true);
                    this.f2900th = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public boolean i(long j) {
            if (this.f2898fe == j) {
                return false;
            }
            this.f2898fe = j;
            this.f2900th = true;
            return true;
        }

        public String qw() {
            return this.f2899rg;
        }

        public void rg() {
            String yj2 = de.this.f2885uk.yj("pub.dat", true);
            if (!TextUtils.isEmpty(yj2)) {
                try {
                    JSONObject jSONObject = new JSONObject(yj2);
                    this.qw = jSONObject.getInt("pub_ver");
                    this.f2896ad = jSONObject.getLong("pub_lst_ts");
                    this.f2898fe = jSONObject.getLong("pkg_lst_up_ts");
                    this.f2897de.ad(jSONObject.getLong("flags"));
                    jSONObject.getInt("d_form_ver");
                    this.f2899rg = jSONObject.optString("aid");
                    this.f2900th = false;
                } catch (Exception unused) {
                    this.f2900th = true;
                }
            }
        }

        public boolean th(String str) {
            String str2 = this.f2899rg;
            if (str2 == str) {
                return false;
            }
            if (str != null && str.equals(str2)) {
                return false;
            }
            this.f2900th = true;
            this.f2899rg = str;
            return true;
        }

        public void uk(long j) {
            if (this.f2896ad != j) {
                this.f2896ad = j;
                this.f2900th = true;
            }
        }

        public boolean yj(long j, long j2) {
            if (!this.f2897de.de(j, j2)) {
                return false;
            }
            this.f2900th = true;
            return true;
        }
    }

    public static class pf {

        /* renamed from: ad  reason: collision with root package name */
        public Method f2902ad;

        /* renamed from: de  reason: collision with root package name */
        public Method f2903de;

        /* renamed from: fe  reason: collision with root package name */
        public Method f2904fe;
        public Method qw;

        /* renamed from: rg  reason: collision with root package name */
        public Method f2905rg;

        public void ad(Context context, String str, Uri uri, int i2) throws ReflectUtil.MethodInvokeException {
            try {
                this.f2902ad.invoke(context, new Object[]{str, uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new ReflectUtil.MethodInvokeException((Throwable) e);
            }
        }

        public void de() {
            try {
                this.qw = ReflectUtil.qw(Context.class, ReflectUtil.ad(fe.qw()), new Class[]{Uri.class, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                this.f2902ad = ReflectUtil.qw(Context.class, ReflectUtil.ad(fe.ad()), new Class[]{String.class, Uri.class, Integer.TYPE});
                this.f2903de = ReflectUtil.qw(ContentResolver.class, ReflectUtil.ad(fe.rg()), new Class[]{Uri.class, Integer.TYPE});
                this.f2904fe = ReflectUtil.qw(Context.class, ReflectUtil.ad(fe.fe()), new Class[]{Uri.class, Integer.TYPE});
                this.f2905rg = ReflectUtil.qw(ContentResolver.class, ReflectUtil.ad(fe.de()), new Class[]{Uri.class, Integer.TYPE});
            } catch (Exception unused) {
            }
        }

        public void fe(ContentResolver contentResolver, Uri uri, int i2) throws ReflectUtil.MethodInvokeException {
            try {
                this.f2905rg.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new ReflectUtil.MethodInvokeException((Throwable) e);
            }
        }

        public int qw(Context context, Uri uri, int i2, int i3, int i4) throws ReflectUtil.MethodInvokeException {
            try {
                return ((Integer) this.qw.invoke(context, new Object[]{uri, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})).intValue();
            } catch (Exception e) {
                throw new ReflectUtil.MethodInvokeException((Throwable) e);
            }
        }

        public void rg(Context context, Uri uri, int i2) throws ReflectUtil.MethodInvokeException {
            try {
                this.f2904fe.invoke(context, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new ReflectUtil.MethodInvokeException((Throwable) e);
            }
        }

        public void th(ContentResolver contentResolver, Uri uri, int i2) throws ReflectUtil.MethodInvokeException {
            try {
                this.f2903de.invoke(contentResolver, new Object[]{uri, Integer.valueOf(i2)});
            } catch (Exception e) {
                throw new ReflectUtil.MethodInvokeException((Throwable) e);
            }
        }
    }

    public static final class qw extends ad<qw> {

        /* renamed from: th  reason: collision with root package name */
        public static final String[] f2906th = {"read0", "read1", "read2", "read3", "access0", "access1", "access2", "access3", "sync0", "sync1", "sync2", "sync3", "open0", "open1", "open2", "open3"};

        static {
            ad.fe(4);
        }

        public qw(int i2) {
            super(i2, 4);
        }

        public static qw rg(int i2) {
            return new qw(i2);
        }

        public String th() {
            return f2906th[ad()];
        }
    }

    public static class rg {

        /* renamed from: ad  reason: collision with root package name */
        public fe[] f2907ad = new fe[27];

        /* renamed from: de  reason: collision with root package name */
        public int f2908de;
        public int qw = 27;

        public static rg th(byte[] bArr) {
            rg rgVar = new rg();
            for (byte pf2 : ad.de(bArr)) {
                rgVar.qw(fe.pf(pf2));
            }
            return rgVar;
        }

        public final void ad(int i2) {
            fe[] feVarArr = this.f2907ad;
            if (i2 - feVarArr.length > 0) {
                int length = feVarArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f2907ad = (fe[]) Arrays.copyOf(this.f2907ad, i2);
            }
        }

        public fe de(int i2) {
            if (i2 < this.f2908de) {
                return this.f2907ad[i2];
            }
            throw new IndexOutOfBoundsException("idx " + i2 + " size " + this.f2908de);
        }

        public int fe() {
            return this.f2908de;
        }

        public void qw(fe feVar) {
            ad(this.f2908de + 1);
            fe[] feVarArr = this.f2907ad;
            int i2 = this.f2908de;
            this.f2908de = i2 + 1;
            feVarArr[i2] = feVar;
        }

        public byte[] rg() {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for (int i2 = 0; i2 < this.f2908de; i2++) {
                byteArrayOutputStream.write(this.f2907ad[i2].i());
            }
            return ad.qw(byteArrayOutputStream.toByteArray());
        }
    }

    public static class th<T extends ad> {

        /* renamed from: ad  reason: collision with root package name */
        public Map<T, Integer> f2909ad = new HashMap();
        public int qw;

        public class qw implements Comparator<Map.Entry<T, Integer>> {
            public qw(th thVar) {
            }

            /* renamed from: qw */
            public int compare(Map.Entry<T, Integer> entry, Map.Entry<T, Integer> entry2) {
                int intValue = entry2.getValue().intValue() - entry.getValue().intValue();
                if (intValue != 0) {
                    return intValue;
                }
                return ((ad) entry.getKey()).compareTo((ad) entry2.getKey());
            }
        }

        public th(int i2) {
            this.qw = i2;
        }

        public List<T> ad() {
            ArrayList arrayList = new ArrayList(this.f2909ad.entrySet());
            Collections.sort(arrayList, new qw(this));
            ArrayList arrayList2 = new ArrayList(this.qw);
            int min = Math.min(this.qw, arrayList.size());
            for (int i2 = 0; i2 < min; i2++) {
                Map.Entry entry = (Map.Entry) arrayList.get(i2);
                if (((Integer) entry.getValue()).intValue() > 1) {
                    arrayList2.add(entry.getKey());
                }
            }
            return arrayList2;
        }

        public void qw(T t) {
            int i2;
            Integer num = this.f2909ad.get(t);
            if (num == null) {
                i2 = 1;
            } else {
                i2 = Integer.valueOf(num.intValue() + 1);
            }
            this.f2909ad.put(t, i2);
        }
    }

    public static class uk {
    }

    public static final class yj extends ad<yj> {

        /* renamed from: th  reason: collision with root package name */
        public static final int f2910th = ad.fe(2);

        public yj(int i2) {
            super(i2, 2);
        }

        public static yj rg(int i2) {
            return new yj(i2);
        }
    }

    public de() {
        super("upc", 8500000);
    }

    public final boolean aaa(String str, qw qwVar, int i2) {
        int i3;
        Uri parse = Uri.parse(m199if(str, qwVar));
        int i4 = 0;
        while (true) {
            if (i4 >= 2) {
                i3 = -1;
                break;
            }
            try {
                i3 = this.f2886yj.qw(this.f2884th, parse, 0, i2, 1);
                break;
            } catch (Throwable unused) {
                try {
                    Thread.sleep(5);
                } catch (Exception unused2) {
                }
                i4++;
            }
        }
        if (i3 == 0) {
            return true;
        }
        return false;
    }

    public qw.uk ad(String str, qw.yj yjVar) {
        PackageInfo packageInfo;
        String str2 = str;
        qw.yj yjVar2 = yjVar;
        if (Build.VERSION.SDK_INT < 26) {
            return qw.uk.qw();
        }
        uk ukVar = new uk();
        Cif ifVar = null;
        try {
            packageInfo = this.f2884th.getPackageManager().getPackageInfo(str2, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return qw.uk.qw();
        }
        if (yjVar2.qw) {
            ifVar = new Cif(this, str2);
            ifVar.fe();
            if (str2.equals(ifVar.yj())) {
                String th2 = ifVar.th();
                if (!TextUtils.isEmpty(th2)) {
                    return qw.uk.th(th2);
                }
            }
            ifVar.o(str2);
        }
        Cif ifVar2 = ifVar;
        int i2 = packageInfo.applicationInfo.uid;
        i iVar = new i();
        C0138de deVar = new C0138de();
        C0138de deVar2 = new C0138de();
        int i3 = 0;
        while (i3 < 16) {
            try {
                qw rg2 = qw.rg(i3);
                if (aaa(str2, rg2, i2)) {
                    deVar.qw(rg2);
                } else {
                    deVar2.qw(rg2);
                }
                i3++;
            } catch (Throwable th3) {
                if (yjVar2.qw && ifVar2 != null) {
                    ifVar2.ad();
                }
                throw th3;
            }
        }
        rg rgVar = new rg();
        int rg3 = ad.rg(20);
        C0138de deVar3 = new C0138de();
        for (int i4 = 0; i4 <= yj.f2910th; i4++) {
            deVar3.qw(yj.rg(i4));
        }
        int i5 = 0;
        while (i5 < rg3) {
            int i6 = i5;
            C0138de deVar4 = deVar3;
            int i7 = rg3;
            rg rgVar2 = rgVar;
            fe nn = nn(str, i5, deVar.ad(), deVar3.de(), i2, iVar);
            if (nn == null) {
                nn = nn(str, i6, deVar2.ad(), deVar4.de(), i2, iVar);
            }
            if (nn == null) {
                qw.uk qw2 = qw.uk.qw();
                if (yjVar2.qw && ifVar2 != null) {
                    ifVar2.ad();
                }
                return qw2;
            }
            rgVar2.qw(nn);
            i5 = i6 + 1;
            rgVar = rgVar2;
            deVar3 = deVar4;
            rg3 = i7;
            String str3 = str;
        }
        C0138de deVar5 = deVar3;
        rg rgVar3 = rgVar;
        if (f2882o) {
            "hi he dict count usage : " + deVar5.rg();
            "lo dict count usage : " + deVar.rg();
            "lo normal count usage : " + deVar2.rg();
        }
        String i8 = fe.fe.pf.i.qw.qw.i(rgVar3.rg());
        if (yjVar2.qw && ifVar2 != null) {
            ifVar2.uk(i8);
            ifVar2.i(System.currentTimeMillis());
        }
        if (f2882o) {
            "probe suc, stat = " + iVar;
        }
        qw.uk th4 = qw.uk.th(i8);
        if (yjVar2.f2868ad) {
            th4.f2867de = ukVar;
        }
        if (yjVar2.qw && ifVar2 != null) {
            ifVar2.ad();
        }
        return th4;
    }

    public final boolean ddd(Uri uri, int i2) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f2884th;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f2886yj.rg(context, uri, i2);
            this.f2886yj.fe(contentResolver, uri, i2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean ggg(qw qwVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return when(Uri.parse(m199if(this.f2884th.getPackageName(), qwVar)));
    }

    public final boolean i(rg rgVar, List<qw> list) {
        boolean z;
        int i2;
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        ContentResolver contentResolver = this.f2884th.getContentResolver();
        UriMatcher uriMatcher = new UriMatcher(-1);
        o(uriMatcher);
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
                ddd(uri, i3);
            } else if (match == 1) {
                try {
                    i2 = Integer.valueOf(pathSegments.get(2).substring(1)).intValue();
                } catch (Exception unused) {
                    i2 = -1;
                }
                if (i2 < 0 || i2 >= rgVar.fe()) {
                    ddd(uri, 1);
                } else {
                    if (!rgVar.de(i2).o().equals(pathSegments.get(3))) {
                        ddd(uri, 1);
                    }
                }
            } else if (match == 2) {
                String str = pathSegments.get(2);
                Iterator<qw> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().th().equals(str)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    ddd(uri, 1);
                }
            }
        }
        int fe2 = rgVar.fe();
        for (int i4 = 0; i4 < fe2; i4++) {
            if (!mmm(this.f2884th.getPackageName(), i4, rgVar.de(i4), Process.myUid(), (i) null)) {
                return true;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!aaa(this.f2884th.getPackageName(), list.get(i5), Process.myUid())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: if  reason: not valid java name */
    public final String m199if(String str, qw qwVar) {
        return String.format("content://%s/dic/v1/%s", new Object[]{pf(str), qwVar.th()});
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:4|5|(3:9|10|11)|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x001f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mmm(java.lang.String r8, int r9, fe.fe.pf.rg.rg.de.fe r10, int r11, fe.fe.pf.rg.rg.de.i r12) {
        /*
            r7 = this;
            java.lang.String r8 = r7.m200switch(r8, r9, r10)
            android.net.Uri r8 = android.net.Uri.parse(r8)
            r9 = 0
            r10 = 0
        L_0x000a:
            r0 = 2
            r6 = 1
            if (r10 >= r0) goto L_0x0039
            if (r12 == 0) goto L_0x0024
            int r0 = r12.qw     // Catch:{ all -> 0x0031 }
            if (r0 <= 0) goto L_0x001f
            int r0 = r12.qw     // Catch:{ all -> 0x0031 }
            int r0 = r0 % 100
            if (r0 != 0) goto L_0x001f
            r0 = 10
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            int r0 = r12.qw     // Catch:{ all -> 0x0031 }
            int r0 = r0 + r6
            r12.qw = r0     // Catch:{ all -> 0x0031 }
        L_0x0024:
            fe.fe.pf.rg.rg.de$pf r0 = r7.f2886yj     // Catch:{ all -> 0x0031 }
            android.content.Context r1 = r7.f2884th     // Catch:{ all -> 0x0031 }
            r3 = 0
            r5 = 1
            r2 = r8
            r4 = r11
            int r8 = r0.qw(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0031 }
            goto L_0x003a
        L_0x0031:
            r0 = 5
            java.lang.Thread.sleep(r0)     // Catch:{ Exception -> 0x0036 }
        L_0x0036:
            int r10 = r10 + 1
            goto L_0x000a
        L_0x0039:
            r8 = -1
        L_0x003a:
            if (r8 != 0) goto L_0x003d
            return r6
        L_0x003d:
            if (r12 == 0) goto L_0x0044
            int r8 = r12.f2891ad
            int r8 = r8 + r6
            r12.f2891ad = r8
        L_0x0044:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.pf.rg.rg.de.mmm(java.lang.String, int, fe.fe.pf.rg.rg.de$fe, int, fe.fe.pf.rg.rg.de$i):boolean");
    }

    public final fe nn(String str, int i2, List<C0138de.C0139de<qw>> list, List<C0138de.C0139de<yj>> list2, int i3, i iVar) {
        for (C0138de.C0139de next : list) {
            Iterator<C0138de.C0139de<yj>> it = list2.iterator();
            while (true) {
                if (it.hasNext()) {
                    C0138de.C0139de next2 = it.next();
                    fe rg2 = fe.rg((yj) next2.de(), (qw) next.de());
                    if (mmm(str, i2, rg2, i3, iVar)) {
                        next.fe();
                        next2.fe();
                        return rg2;
                    }
                }
            }
        }
        return null;
    }

    public final void o(UriMatcher uriMatcher) {
        uriMatcher.addURI(pf(this.f2884th.getPackageName()), "dat/v1/*/*", 1);
        uriMatcher.addURI(pf(this.f2884th.getPackageName()), "dic/v1/*", 2);
    }

    public final String pf(String str) {
        return str + ".helios.quark";
    }

    public final boolean ppp(int i2, fe feVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return when(Uri.parse(m200switch(this.f2884th.getPackageName(), i2, feVar)));
    }

    public void rg(qw.fe feVar) {
        this.f2884th = this.qw.qw;
        this.f2885uk = this.f2859ad.th("upc");
        this.f2886yj.de();
    }

    /* renamed from: switch  reason: not valid java name */
    public final String m200switch(String str, int i2, fe feVar) {
        return String.format("content://%s/dat/v1/i%d/%s", new Object[]{pf(str), Integer.valueOf(i2), feVar.o()});
    }

    public qw.th th(qw.rg rgVar) {
        this.f2883i.rg();
        try {
            return xxx(rgVar);
        } finally {
            this.f2883i.fe();
        }
    }

    public final qw.th vvv(rg rgVar) {
        th thVar = new th(6);
        for (int i2 = 0; i2 < rgVar.fe(); i2++) {
            thVar.qw(rgVar.de(i2).uk());
        }
        List<qw> ad2 = thVar.ad();
        if (!i(rgVar, ad2)) {
            this.f2883i.yj(1, 1);
            return qw.th.fe();
        }
        for (int fe2 = rgVar.fe() - 1; fe2 >= 0; fe2--) {
            ppp(fe2, rgVar.de(fe2));
        }
        for (qw ggg : ad2) {
            ggg(ggg);
        }
        this.f2883i.uk(System.currentTimeMillis());
        this.f2883i.yj(1, 1);
        return qw.th.fe();
    }

    public final boolean when(Uri uri) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Context context = this.f2884th;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            this.f2886yj.ad(context, context.getPackageName(), uri, 65);
            this.f2886yj.th(contentResolver, uri, 1);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final qw.th xxx(qw.rg rgVar) {
        String qw2;
        if (Build.VERSION.SDK_INT < 26) {
            return qw.th.qw();
        }
        Context context = this.qw.qw;
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            boolean z = packageInfo.lastUpdateTime != this.f2883i.de();
            this.f2883i.i(packageInfo.lastUpdateTime);
            if (!z && this.f2883i.ad(6) == 4) {
                return qw.th.qw();
            }
            BaseIdProvider qw3 = this.qw.f2863de.qw("aid");
            rg th2 = rg.th(qw3.fe());
            if (th2 == null) {
                return qw.th.qw();
            }
            if (this.f2883i.ad(1) == 1 && (qw2 = this.f2883i.qw()) != null && qw2.equals(qw3.de())) {
                return qw.th.fe();
            }
            this.f2883i.th(qw3.de());
            ProviderInfo providerInfo = null;
            try {
                providerInfo = packageManager.resolveContentProvider(pf(packageName), 0);
            } catch (Exception unused) {
            }
            if (providerInfo == null) {
                this.f2883i.yj(4, 6);
            } else {
                this.f2883i.yj(2, 6);
            }
            return vvv(th2);
        } catch (PackageManager.NameNotFoundException unused2) {
            return qw.th.qw();
        }
    }
}
