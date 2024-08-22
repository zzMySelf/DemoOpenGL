package fe.fe.o.th;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.apollon.heartbeat.a;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class when {

    /* renamed from: ad  reason: collision with root package name */
    public String f2694ad = "";

    /* renamed from: de  reason: collision with root package name */
    public ppp f2695de = null;
    public Uri qw = null;

    public when(String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri parse = Uri.parse(str);
            this.qw = parse;
            ad(parse);
            return;
        }
        throw new NullPointerException("uri is null");
    }

    public static String qw(String str) {
        try {
            return URLDecoder.decode(str, a.h);
        } catch (UnsupportedEncodingException | Exception unused) {
            return str;
        }
    }

    public final void ad(Uri uri) {
        this.f2695de = new ppp(uri.getEncodedQuery());
        String uri2 = uri.toString();
        this.f2694ad = uri2;
        int indexOf = uri2.indexOf("?");
        if (indexOf > 0) {
            this.f2694ad = this.f2694ad.substring(0, indexOf);
        }
    }

    public void de(String str, String str2) {
        this.f2695de.de(str, str2);
    }

    public String toString() {
        String str = this.f2694ad;
        if (TextUtils.isEmpty(this.f2695de.qw())) {
            return str;
        }
        return str + "?" + this.f2695de.qw();
    }
}
