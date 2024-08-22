package com.baidu.android.common.others.url;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import androidx.core.util.PatternsCompat;
import com.alipay.sdk.m.s.a;
import com.baidu.sapi2.SapiWebView;
import com.dxmpay.wallet.core.Domains;
import com.tera.scan.filetype.FileType;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public final class UrlUtils {
    public static final Pattern COARSE_WEB_URL = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)([?/](?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\;\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_\\s+\\{\\}\\/\\[\\]\\$\\%\\<\\>\\^\\`\\|\\\\])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
    public static final String TAG = "UrlUtils";
    public static final String UTF_8 = "UTF-8";

    public static String addSchemeIfNeed(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("rtsp://")) {
            return str;
        }
        return "http://" + str;
    }

    public static String appendParam(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str.trim();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str2, str3);
        return appendParams(str, hashMap);
    }

    public static String appendParams(String str, @NonNull Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (map.size() == 0) {
            return str.trim();
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String next : map.keySet()) {
            stringBuffer.append(next);
            stringBuffer.append("=");
            stringBuffer.append(map.get(next));
            stringBuffer.append(a.n);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        String trim = str.trim();
        int length = trim.length();
        int indexOf = trim.indexOf("?");
        if (indexOf <= -1) {
            return trim + "?" + stringBuffer.toString();
        } else if (length - 1 == indexOf) {
            return trim + stringBuffer.toString();
        } else {
            return trim + a.n + stringBuffer.toString();
        }
    }

    public static String decode(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r2.indexOf("?");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String deleteAllParams(java.lang.String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 == 0) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r0 = "?"
            int r0 = r2.indexOf(r0)
            if (r0 <= 0) goto L_0x0014
            r1 = 0
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x0014:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.others.url.UrlUtils.deleteAllParams(java.lang.String):java.lang.String");
    }

    public static String deleteParam(String str, Set<String> set) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
            return str;
        }
        String str2 = null;
        try {
            str2 = new URL(str).getQuery();
        } catch (MalformedURLException e) {
            e.toString();
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String deleteQueryParam = deleteQueryParam(str2, set);
        if (TextUtils.isEmpty(deleteQueryParam)) {
            return str;
        }
        return str.replace(str2, deleteQueryParam);
    }

    public static String deleteQueryParam(String str, Set<String> set) {
        String[] split;
        if (TextUtils.isEmpty(str) || set == null || (split = str.split(a.n)) == null || split.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length > 0 && !set.contains(split2[0])) {
                sb.append(str2);
                sb.append(a.n);
            }
        }
        int length = sb.length();
        if (length > 0) {
            int i2 = length - 1;
            if (sb.charAt(i2) == '&') {
                sb.deleteCharAt(i2);
            }
        }
        return sb.toString();
    }

    public static String fixUrl(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(58);
        boolean z = true;
        for (int i2 = 0; i2 < indexOf; i2++) {
            char charAt = str.charAt(i2);
            if (!Character.isLetter(charAt)) {
                break;
            }
            z &= Character.isLowerCase(charAt);
            if (i2 == indexOf - 1 && !z) {
                str = str.substring(0, indexOf).toLowerCase(Locale.getDefault()) + str.substring(indexOf);
            }
        }
        if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith("rtsp://")) {
            return str;
        }
        if (!str.startsWith("http:") && !str.startsWith("https:") && !str.startsWith("rtsp:")) {
            return str;
        }
        if (str.startsWith("http:/") || str.startsWith("https:/") || str.startsWith("rtsp:/")) {
            return str.replaceFirst("/", "//");
        }
        return str.replaceFirst(":", "://");
    }

    public static String getHost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            "Incorrect url: " + e.getMessage();
            return null;
        }
    }

    public static String getMime(String str) {
        String path = Uri.parse(str).getPath();
        if (path != null) {
            String lowerCase = path.toLowerCase(Locale.getDefault());
            if (lowerCase.contains(".css")) {
                return "text/css";
            }
            if (lowerCase.contains(".js")) {
                return "application/x-javascript";
            }
            if (lowerCase.contains(".jpg") || lowerCase.contains(FileType.GIF_PATTERN_SUFFIX) || lowerCase.contains(BrowserServiceFileProvider.FILE_EXTENSION) || lowerCase.contains(".jpeg")) {
                return "image/*";
            }
        }
        return SapiWebView.DATA_MIME_TYPE;
    }

    public static String getParamValue(String str, String str2) {
        return getParamValue(str, str2, false);
    }

    @SuppressLint({"BDThrowableCheck"})
    public static Map<String, String> getParamsMap(String str) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        String str2 = null;
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str2 = str.substring(indexOf + 1);
        }
        if (TextUtils.isEmpty(str2)) {
            return hashMap;
        }
        String[] split = str2.split(a.n);
        int length = split.length;
        int i2 = 0;
        while (i2 < length) {
            String[] split2 = split[i2].split("=");
            try {
                hashMap.put(URLDecoder.decode(split2[0], "UTF-8"), split2.length > 1 ? URLDecoder.decode(split2[1], "UTF-8") : "");
                i2++;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("This method requires UTF-8 encoding support", e);
            }
        }
        return hashMap;
    }

    public static String getUrlField(String str, String str2, boolean z) {
        int indexOf;
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String str4 = str2 + "=";
        int indexOf2 = str.indexOf("?");
        if (indexOf2 == -1 || (indexOf = str.indexOf(str4, indexOf2)) == -1) {
            return "";
        }
        int indexOf3 = str.indexOf(a.n, indexOf);
        if (indexOf3 != -1) {
            str3 = str.substring(indexOf + str4.length(), indexOf3);
        } else {
            str3 = str.substring(indexOf + str4.length());
        }
        String str5 = str3;
        return z ? Uri.decode(str5) : str5;
    }

    public static String handleAbnormalUrlIfNeeded(String str) {
        return (TextUtils.isEmpty(str) || !isValidUrl(str)) ? str : addSchemeIfNeed(fixUrl(str).trim());
    }

    public static boolean isBaiduDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        if (host.endsWith(Domains.BAIDU) || host.equals("baidu.com")) {
            return true;
        }
        return false;
    }

    public static boolean isHttps(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("https://");
    }

    public static boolean isStandardUrl(String str) {
        try {
            return PatternsCompat.WEB_URL.matcher(str).matches();
        } catch (Exception e) {
            "isValidUrl ： query.matcher failed! " + e.toString();
            return false;
        }
    }

    public static boolean isStandardUrlValidUrl(String str) {
        return isStandardUrl(str) || isUrlAuxiliary(str);
    }

    public static boolean isUrl(String str) {
        try {
            return COARSE_WEB_URL.matcher(str).matches();
        } catch (Exception e) {
            "isValidUrl ： query.matcher failed! " + e.toString();
            return false;
        }
    }

    public static boolean isUrlAuxiliary(String str) {
        try {
            return Pattern.compile("(https?|ftp)://[-A-Za-z0-9+&@#/%?=~_|!:,.;{]+[-A-Za-z0-9+&@#/%=~_|}]").matcher(str).matches();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isValidUrl(String str) {
        return isUrl(str) || isUrlAuxiliary(str);
    }

    public static String getParamValue(String str, String str2, boolean z) {
        return getUrlField(str, str2, z);
    }
}
