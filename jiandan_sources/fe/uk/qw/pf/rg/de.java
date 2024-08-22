package fe.uk.qw.pf.rg;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dxmbumptech.glide.load.Key;
import com.dxmbumptech.glide.load.model.Headers;
import fe.uk.qw.vvv.i;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class de implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Headers f5897ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final URL f5898de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final String f5899fe;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public String f5900rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public URL f5901th;

    /* renamed from: uk  reason: collision with root package name */
    public int f5902uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public volatile byte[] f5903yj;

    public de(URL url) {
        this(url, Headers.qw);
    }

    public String de() {
        String str = this.f5899fe;
        if (str != null) {
            return str;
        }
        URL url = this.f5898de;
        i.fe(url);
        return url.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof de)) {
            return false;
        }
        de deVar = (de) obj;
        if (!de().equals(deVar.de()) || !this.f5897ad.equals(deVar.f5897ad)) {
            return false;
        }
        return true;
    }

    public final byte[] fe() {
        if (this.f5903yj == null) {
            this.f5903yj = de().getBytes(Key.qw);
        }
        return this.f5903yj;
    }

    public int hashCode() {
        if (this.f5902uk == 0) {
            int hashCode = de().hashCode();
            this.f5902uk = hashCode;
            this.f5902uk = (hashCode * 31) + this.f5897ad.hashCode();
        }
        return this.f5902uk;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(fe());
    }

    public Map<String, String> rg() {
        return this.f5897ad.qw();
    }

    public final String th() {
        if (TextUtils.isEmpty(this.f5900rg)) {
            String str = this.f5899fe;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f5898de;
                i.fe(url);
                str = url.toString();
            }
            this.f5900rg = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f5900rg;
    }

    public String toString() {
        return de();
    }

    public URL uk() throws MalformedURLException {
        return yj();
    }

    public final URL yj() throws MalformedURLException {
        if (this.f5901th == null) {
            this.f5901th = new URL(th());
        }
        return this.f5901th;
    }

    public de(String str) {
        this(str, Headers.qw);
    }

    public de(URL url, Headers headers) {
        i.fe(url);
        this.f5898de = url;
        this.f5899fe = null;
        i.fe(headers);
        this.f5897ad = headers;
    }

    public de(String str, Headers headers) {
        this.f5898de = null;
        i.ad(str);
        this.f5899fe = str;
        i.fe(headers);
        this.f5897ad = headers;
    }
}
