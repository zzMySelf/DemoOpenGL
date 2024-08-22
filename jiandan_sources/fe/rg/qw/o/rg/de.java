package fe.rg.qw.o.rg;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.model.Headers;
import fe.rg.qw.ggg.uk;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class de implements Key {

    /* renamed from: ad  reason: collision with root package name */
    public final Headers f4917ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public final URL f4918de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public final String f4919fe;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public String f4920rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public URL f4921th;

    /* renamed from: uk  reason: collision with root package name */
    public int f4922uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public volatile byte[] f4923yj;

    public de(URL url) {
        this(url, Headers.qw);
    }

    public String de() {
        String str = this.f4919fe;
        if (str != null) {
            return str;
        }
        URL url = this.f4918de;
        uk.fe(url);
        return url.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof de)) {
            return false;
        }
        de deVar = (de) obj;
        if (!de().equals(deVar.de()) || !this.f4917ad.equals(deVar.f4917ad)) {
            return false;
        }
        return true;
    }

    public final byte[] fe() {
        if (this.f4923yj == null) {
            this.f4923yj = de().getBytes(Key.qw);
        }
        return this.f4923yj;
    }

    public int hashCode() {
        if (this.f4922uk == 0) {
            int hashCode = de().hashCode();
            this.f4922uk = hashCode;
            this.f4922uk = (hashCode * 31) + this.f4917ad.hashCode();
        }
        return this.f4922uk;
    }

    public void qw(@NonNull MessageDigest messageDigest) {
        messageDigest.update(fe());
    }

    public Map<String, String> rg() {
        return this.f4917ad.qw();
    }

    public final String th() {
        if (TextUtils.isEmpty(this.f4920rg)) {
            String str = this.f4919fe;
            if (TextUtils.isEmpty(str)) {
                URL url = this.f4918de;
                uk.fe(url);
                str = url.toString();
            }
            this.f4920rg = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f4920rg;
    }

    public String toString() {
        return de();
    }

    public URL uk() throws MalformedURLException {
        return yj();
    }

    public final URL yj() throws MalformedURLException {
        if (this.f4921th == null) {
            this.f4921th = new URL(th());
        }
        return this.f4921th;
    }

    public de(String str) {
        this(str, Headers.qw);
    }

    public de(URL url, Headers headers) {
        uk.fe(url);
        this.f4918de = url;
        this.f4919fe = null;
        uk.fe(headers);
        this.f4917ad = headers;
    }

    public de(String str, Headers headers) {
        this.f4918de = null;
        uk.ad(str);
        this.f4919fe = str;
        uk.fe(headers);
        this.f4917ad = headers;
    }
}
