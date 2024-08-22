package fe.th.de.rrr.o;

import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import fe.th.de.pf;
import fe.th.de.rrr.fe;
import okhttp3.internal.http2.Header;
import okio.ByteString;

public final class qw {

    /* renamed from: fe  reason: collision with root package name */
    public static final ByteString f5344fe = ByteString.encodeUtf8(":");

    /* renamed from: i  reason: collision with root package name */
    public static final ByteString f5345i = ByteString.encodeUtf8(Header.TARGET_AUTHORITY_UTF8);

    /* renamed from: rg  reason: collision with root package name */
    public static final ByteString f5346rg = ByteString.encodeUtf8(Header.RESPONSE_STATUS_UTF8);

    /* renamed from: th  reason: collision with root package name */
    public static final ByteString f5347th = ByteString.encodeUtf8(Header.TARGET_METHOD_UTF8);

    /* renamed from: uk  reason: collision with root package name */
    public static final ByteString f5348uk = ByteString.encodeUtf8(Header.TARGET_SCHEME_UTF8);

    /* renamed from: yj  reason: collision with root package name */
    public static final ByteString f5349yj = ByteString.encodeUtf8(Header.TARGET_PATH_UTF8);

    /* renamed from: ad  reason: collision with root package name */
    public final ByteString f5350ad;

    /* renamed from: de  reason: collision with root package name */
    public final int f5351de;
    public final ByteString qw;

    /* renamed from: fe.th.de.rrr.o.qw$qw  reason: collision with other inner class name */
    public interface C0225qw {
        void qw(pf pfVar);
    }

    public qw(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof qw)) {
            return false;
        }
        qw qwVar = (qw) obj;
        if (!this.qw.equals(qwVar.qw) || !this.f5350ad.equals(qwVar.f5350ad)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((PayBeanFactory.BEAN_ID_WIDTHDRAW + this.qw.hashCode()) * 31) + this.f5350ad.hashCode();
    }

    public String toString() {
        return fe.xxx("%s: %s", this.qw.utf8(), this.f5350ad.utf8());
    }

    public qw(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public qw(ByteString byteString, ByteString byteString2) {
        this.qw = byteString;
        this.f5350ad = byteString2;
        this.f5351de = byteString.size() + 32 + byteString2.size();
    }
}
