package com.alipay.sdk.m.n0;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.l0.b;
import com.alipay.sdk.m.l0.c;
import com.alipay.sdk.m.l0.e;
import com.alipay.sdk.m.l0.f;
import com.alipay.sdk.m.m0.a;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.lang3.StringUtils;

public class d {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f672i = new Object();
    public static d j;
    public static final String k = (".UTSystemConfig" + File.separator + "Global");
    public Context a = null;
    public String b = null;
    public e c = null;
    public String d = "xx_utdid_key";
    public String e = "xx_utdid_domain";
    public a f = null;
    public a g = null;
    public Pattern h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public d(Context context) {
        this.a = context;
        this.g = new a(context, k, "Alvin2", false, true);
        this.f = new a(context, ".DataStorage", "ContextData", false, true);
        this.c = new e();
        this.d = String.format("K_%d", new Object[]{Integer.valueOf(f.a(this.d))});
        this.e = String.format("D_%d", new Object[]{Integer.valueOf(f.a(this.e))});
    }

    public static d a(Context context) {
        if (context != null && j == null) {
            synchronized (f672i) {
                if (j == null) {
                    d dVar = new d(context);
                    j = dVar;
                    dVar.d();
                }
            }
        }
        return j;
    }

    private void b(String str) {
        a aVar;
        if (a(str)) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (aVar = this.g) != null) {
                aVar.a("UTDID2", str);
                this.g.a();
            }
        }
    }

    private void c(String str) {
        a aVar;
        if (str != null && (aVar = this.f) != null && !str.equals(aVar.a(this.d))) {
            this.f.a(this.d, str);
            this.f.a();
        }
    }

    private void d() {
        a aVar = this.g;
        if (aVar != null) {
            if (f.a(aVar.a("UTDID2"))) {
                String a2 = this.g.a("UTDID");
                if (!f.a(a2)) {
                    b(a2);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!f.a(this.g.a("DID"))) {
                this.g.b("DID");
                z = true;
            }
            if (!f.a(this.g.a("EI"))) {
                this.g.b("EI");
                z = true;
            }
            if (!f.a(this.g.a("SI"))) {
                this.g.b("SI");
            } else {
                z2 = z;
            }
            if (z2) {
                this.g.a();
            }
        }
    }

    private byte[] e() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = c.a(currentTimeMillis);
        byte[] a3 = c.a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = com.alipay.sdk.m.l0.d.a(this.a);
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(c.a(f.a(str)), 0, 4);
        byteArrayOutputStream.write(c.a(f.a(a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private String f() {
        a aVar = this.g;
        if (aVar == null) {
            return null;
        }
        String a2 = aVar.a("UTDID2");
        if (f.a(a2) || this.c.a(a2) == null) {
            return null;
        }
        return a2;
    }

    public synchronized String c() {
        String f2 = f();
        if (a(f2)) {
            c(this.c.a(f2));
            this.b = f2;
            return f2;
        }
        String a2 = this.f.a(this.d);
        if (!f.a(a2)) {
            String a3 = new f().a(a2);
            if (!a(a3)) {
                a3 = this.c.b(a2);
            }
            if (a(a3) && !f.a(a3)) {
                this.b = a3;
                b(a3);
                return this.b;
            }
        }
        return null;
    }

    private boolean a(String str) {
        if (str != null) {
            if (str.endsWith(StringUtils.LF)) {
                str = str.substring(0, str.length() - 1);
            }
            return 24 == str.length() && !this.h.matcher(str).find();
        }
    }

    public synchronized String b() {
        String str = this.b;
        if (str != null) {
            return str;
        }
        return a();
    }

    public synchronized String a() {
        String c2 = c();
        this.b = c2;
        if (!TextUtils.isEmpty(c2)) {
            return this.b;
        }
        try {
            byte[] e2 = e();
            if (e2 != null) {
                String c3 = b.c(e2, 2);
                this.b = c3;
                b(c3);
                String a2 = this.c.a(e2);
                if (a2 != null) {
                    c(a2);
                }
                return this.b;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    public static String a(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, ExifInterface.MARKER_SOF10, ExifInterface.MARKER_APP1, 86, -11, 11, -78, -96, -17, -99, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, -95, -126, -82, ExifInterface.MARKER_SOF0, 113, 116, -16, -103, 49, -30, 9, ExifInterface.MARKER_EOI, PublicSuffixDatabase.EXCEPTION_MARKER, -80, -68, -78, -117, 53, Ascii.RS, -122, SignedBytes.MAX_POWER_OF_TWO, -104, 74, ExifInterface.MARKER_SOF15, 106, 85, ExifInterface.MARKER_SOS, -93};
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(e.a(bArr2), instance.getAlgorithm()));
        return b.c(instance.doFinal(bArr), 2);
    }
}
