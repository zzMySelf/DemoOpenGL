package fe.th.de.rrr.uk;

import com.duxiaoman.okhttp3.Protocol;
import com.google.common.base.Ascii;
import fe.th.de.mmm;
import java.io.IOException;
import java.net.ProtocolException;

public final class o {

    /* renamed from: ad  reason: collision with root package name */
    public final int f5474ad;

    /* renamed from: de  reason: collision with root package name */
    public final String f5475de;
    public final Protocol qw;

    public o(Protocol protocol, int i2, String str) {
        this.qw = protocol;
        this.f5474ad = i2;
        this.f5475de = str;
    }

    public static o ad(String str) throws IOException {
        Protocol protocol;
        String str2;
        int i2 = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i2 = 4;
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
        int i3 = i2 + 3;
        if (str.length() >= i3) {
            try {
                int parseInt = Integer.parseInt(str.substring(i2, i3));
                if (str.length() <= i3) {
                    str2 = "";
                } else if (str.charAt(i3) == ' ') {
                    str2 = str.substring(i2 + 4);
                } else {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                return new o(protocol, parseInt, str2);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        } else {
            throw new ProtocolException("Unexpected status line: " + str);
        }
    }

    public static o qw(mmm mmm) {
        return new o(mmm.xxx(), mmm.rg(), mmm.when());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.qw == Protocol.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(Ascii.CASE_MASK);
        sb.append(this.f5474ad);
        if (this.f5475de != null) {
            sb.append(Ascii.CASE_MASK);
            sb.append(this.f5475de);
        }
        return sb.toString();
    }
}
