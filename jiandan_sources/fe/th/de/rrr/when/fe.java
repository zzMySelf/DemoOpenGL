package fe.th.de.rrr.when;

import com.baidu.android.common.others.IStringUtil;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import okhttp3.CertificatePinner;

public final class fe implements HostnameVerifier {
    public static final fe qw = new fe();

    public static List<String> ad(X509Certificate x509Certificate, int i2) {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List next : subjectAlternativeNames) {
                if (next != null) {
                    if (next.size() >= 2) {
                        Integer num = (Integer) next.get(0);
                        if (num != null) {
                            if (num.intValue() == i2 && (str = (String) next.get(1)) != null) {
                                arrayList.add(str);
                            }
                        }
                    }
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    public static List<String> qw(X509Certificate x509Certificate) {
        List<String> ad2 = ad(x509Certificate, 7);
        List<String> ad3 = ad(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(ad2.size() + ad3.size());
        arrayList.addAll(ad2);
        arrayList.addAll(ad3);
        return arrayList;
    }

    public boolean de(String str, X509Certificate x509Certificate) {
        if (fe.th.de.rrr.fe.k(str)) {
            return th(str, x509Certificate);
        }
        return rg(str, x509Certificate);
    }

    public boolean fe(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(IStringUtil.CURRENT_PATH) && !str.endsWith(IStringUtil.TOP_PATH) && str2 != null && str2.length() != 0 && !str2.startsWith(IStringUtil.CURRENT_PATH) && !str2.endsWith(IStringUtil.TOP_PATH)) {
            if (!str.endsWith(IStringUtil.CURRENT_PATH)) {
                str = str + '.';
            }
            if (!str2.endsWith(IStringUtil.CURRENT_PATH)) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith(CertificatePinner.Pin.WILDCARD) || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || CertificatePinner.Pin.WILDCARD.equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            if (length <= 0 || str.lastIndexOf(46, length - 1) == -1) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean rg(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        for (String fe2 : ad(x509Certificate, 2)) {
            if (fe(lowerCase, fe2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean th(String str, X509Certificate x509Certificate) {
        List<String> ad2 = ad(x509Certificate, 7);
        int size = ad2.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (str.equalsIgnoreCase(ad2.get(i2))) {
                return true;
            }
        }
        return false;
    }

    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return de(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
