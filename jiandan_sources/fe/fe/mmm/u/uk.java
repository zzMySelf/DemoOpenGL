package fe.fe.mmm.u;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.baidu.wallet.paysdk.datamodel.Bank;

public class uk {
    public static String qw(String str, String str2, String str3) {
        StringBuilder sb;
        StringBuilder sb2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = str2 + "=";
        int indexOf = str.indexOf("?");
        String str5 = null;
        if (indexOf < 0) {
            int indexOf2 = str.indexOf(Bank.HOT_BANK_LETTER);
            if (indexOf2 < 0) {
                sb2 = new StringBuilder(str);
            } else {
                str5 = str.substring(indexOf2);
                sb2 = new StringBuilder(str.substring(0, indexOf2));
            }
            sb2.append("?");
            sb2.append(str4);
            sb2.append(str3);
            if (str5 != null) {
                sb2.append(str5);
            }
            return sb2.toString();
        }
        if (str.indexOf(a.n + str4, indexOf) >= 0) {
            return str;
        }
        if (str.indexOf("?" + str4, indexOf) >= 0) {
            return str;
        }
        int indexOf3 = str.indexOf(Bank.HOT_BANK_LETTER);
        if (indexOf3 < 0) {
            sb = new StringBuilder(str);
        } else {
            str5 = str.substring(indexOf3);
            str = str.substring(0, indexOf3);
            sb = new StringBuilder(str);
        }
        if (!str.endsWith(a.n) && !str.endsWith("?")) {
            sb.append(a.n);
        }
        sb.append(str4);
        sb.append(str3);
        if (str5 != null) {
            sb.append(str5);
        }
        return sb.toString();
    }
}
