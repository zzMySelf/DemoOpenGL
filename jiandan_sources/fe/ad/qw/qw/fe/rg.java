package fe.ad.qw.qw.fe;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class rg {
    public static boolean ad(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static Map<String, String> de(Uri uri) {
        String str;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i2 = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i2);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i2);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            String substring = encodedQuery.substring(i2, indexOf2);
            if (!TextUtils.isEmpty(substring)) {
                if (indexOf2 == indexOf) {
                    str = "";
                } else {
                    str = encodedQuery.substring(indexOf2 + 1, indexOf);
                }
                linkedHashMap.put(Uri.decode(substring), Uri.decode(str));
            }
            i2 = indexOf + 1;
        } while (i2 < encodedQuery.length());
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static String qw(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("    at ");
            sb.append(stackTraceElement.toString());
            sb.append(StringUtils.LF);
        }
        return sb.toString();
    }
}
