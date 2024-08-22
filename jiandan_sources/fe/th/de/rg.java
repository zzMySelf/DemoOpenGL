package fe.th.de;

import androidx.renderscript.ScriptIntrinsicBLAS;
import com.baidu.android.lbspay.channelpay.IChannelPay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class rg {

    /* renamed from: ad  reason: collision with root package name */
    public static final Comparator<String> f5243ad = new qw();
    public static final rg ddd = de("TLS_CHACHA20_POLY1305_SHA256", 4867);

    /* renamed from: de  reason: collision with root package name */
    public static final Map<String, rg> f5244de = new LinkedHashMap();

    /* renamed from: fe  reason: collision with root package name */
    public static final rg f5245fe = de("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final rg ggg = de("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);

    /* renamed from: i  reason: collision with root package name */
    public static final rg f5246i = de("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);

    /* renamed from: if  reason: not valid java name */
    public static final rg f208if = de("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final rg mmm = de("TLS_AES_256_CCM_8_SHA256", 4869);
    public static final rg nn = de("TLS_AES_128_CCM_SHA256", 4868);

    /* renamed from: o  reason: collision with root package name */
    public static final rg f5247o = de("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);

    /* renamed from: pf  reason: collision with root package name */
    public static final rg f5248pf = de("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final rg ppp = de("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);

    /* renamed from: rg  reason: collision with root package name */
    public static final rg f5249rg = de("TLS_RSA_WITH_AES_128_CBC_SHA", 47);

    /* renamed from: switch  reason: not valid java name */
    public static final rg f209switch = de("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);

    /* renamed from: th  reason: collision with root package name */
    public static final rg f5250th = de("TLS_RSA_WITH_AES_256_CBC_SHA", 53);

    /* renamed from: uk  reason: collision with root package name */
    public static final rg f5251uk = de("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final rg vvv = de("TLS_AES_128_GCM_SHA256", 4865);
    public static final rg when = de("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final rg xxx = de("TLS_AES_256_GCM_SHA384", 4866);

    /* renamed from: yj  reason: collision with root package name */
    public static final rg f5252yj = de("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public final String qw;

    public class qw implements Comparator<String> {
        /* renamed from: qw */
        public int compare(String str, String str2) {
            int min = Math.min(str.length(), str2.length());
            int i2 = 4;
            while (i2 < min) {
                char charAt = str.charAt(i2);
                char charAt2 = str2.charAt(i2);
                if (charAt == charAt2) {
                    i2++;
                } else if (charAt < charAt2) {
                    return -1;
                } else {
                    return 1;
                }
            }
            int length = str.length();
            int length2 = str2.length();
            if (length == length2) {
                return 0;
            }
            if (length < length2) {
                return -1;
            }
            return 1;
        }
    }

    static {
        de("SSL_RSA_WITH_NULL_MD5", 1);
        de("SSL_RSA_WITH_NULL_SHA", 2);
        de("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        de("SSL_RSA_WITH_RC4_128_MD5", 4);
        de("SSL_RSA_WITH_RC4_128_SHA", 5);
        de("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        de("SSL_RSA_WITH_DES_CBC_SHA", 9);
        de("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        de("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        de("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        de("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        de("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        de("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        de("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        de("SSL_DH_anon_WITH_RC4_128_MD5", 24);
        de("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        de("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        de("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        de("TLS_KRB5_WITH_DES_CBC_SHA", 30);
        de("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        de("TLS_KRB5_WITH_RC4_128_SHA", 32);
        de("TLS_KRB5_WITH_DES_CBC_MD5", 34);
        de("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        de("TLS_KRB5_WITH_RC4_128_MD5", 36);
        de("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        de("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        de("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        de("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        de("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        de("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        de("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        de("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        de("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        de("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        de("TLS_RSA_WITH_NULL_SHA256", 59);
        de("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        de("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        de("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        de("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        de("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        de("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        de("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        de("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        de("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        de("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        de("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        de("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        de("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", ScriptIntrinsicBLAS.RsBlas_ztrmm);
        de("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", ScriptIntrinsicBLAS.RsBlas_ztrsm);
        de("TLS_PSK_WITH_RC4_128_SHA", ScriptIntrinsicBLAS.RsBlas_cherk);
        de("TLS_PSK_WITH_3DES_EDE_CBC_SHA", ScriptIntrinsicBLAS.RsBlas_cher2k);
        de("TLS_PSK_WITH_AES_128_CBC_SHA", ScriptIntrinsicBLAS.RsBlas_zhemm);
        de("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        de("TLS_RSA_WITH_SEED_CBC_SHA", 150);
        de("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", IChannelPay.ID_WX_PAY);
        de("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        de("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        de("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", IChannelPay.ID_IPAY_PAY_RECHARGEABLE_CARD);
        de("TLS_DH_anon_WITH_AES_128_GCM_SHA256", IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE);
        de("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        de("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        de("TLS_FALLBACK_SCSV", 22016);
        de("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        de("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        de("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        de("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        de("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        de("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        de("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        de("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        de("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        de("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        de("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        de("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        de("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        de("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        de("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        de("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        de("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        de("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        de("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        de("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        de("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        de("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        de("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        de("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        de("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        de("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        de("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        de("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        de("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        de("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        de("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        de("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        de("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        de("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        de("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        de("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        de("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        de("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        de("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    }

    public rg(String str) {
        if (str != null) {
            this.qw = str;
            return;
        }
        throw null;
    }

    public static List<rg> ad(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String qw2 : strArr) {
            arrayList.add(qw(qw2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static rg de(String str, int i2) {
        rg rgVar = new rg(str);
        f5244de.put(str, rgVar);
        return rgVar;
    }

    public static synchronized rg qw(String str) {
        rg rgVar;
        synchronized (rg.class) {
            rgVar = f5244de.get(str);
            if (rgVar == null) {
                rgVar = f5244de.get(rg(str));
                if (rgVar == null) {
                    rgVar = new rg(str);
                }
                f5244de.put(str, rgVar);
            }
        }
        return rgVar;
    }

    public static String rg(String str) {
        if (str.startsWith("TLS_")) {
            return "SSL_" + str.substring(4);
        } else if (!str.startsWith("SSL_")) {
            return str;
        } else {
            return "TLS_" + str.substring(4);
        }
    }

    public String fe() {
        return this.qw;
    }

    public String toString() {
        return this.qw;
    }
}
