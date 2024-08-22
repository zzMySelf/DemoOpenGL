package fe.fe.pf.th.qw;

import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class ggg {
    public static String ad(String str, Map<String, String> map) {
        StringBuilder sb;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String qw = qw(map);
        if (TextUtils.isEmpty(qw)) {
            return str;
        }
        if (str.contains("?")) {
            boolean z = true;
            if (str.lastIndexOf("?") != str.length() - 1) {
                z = false;
            }
            if (z) {
                sb.append(str);
                sb.append(qw);
                return sb.toString();
            }
            sb = new StringBuilder();
            sb.append(str);
            sb.append(a.n);
            sb.append(qw);
            return sb.toString();
        }
        return str + "?" + qw;
    }

    public static String qw(Map<String, String> map) {
        String str;
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String next : map.keySet()) {
            if (sb.length() > 0) {
                sb.append(a.n);
            }
            String str2 = map.get(next);
            if (next != null) {
                try {
                    str = URLEncoder.encode(next, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("This method requires UTF-8 encoding support", e);
                }
            } else {
                str = "";
            }
            sb.append(str);
            sb.append("=");
            sb.append(str2 != null ? URLEncoder.encode(str2, "UTF-8") : "");
        }
        return sb.toString();
    }
}
