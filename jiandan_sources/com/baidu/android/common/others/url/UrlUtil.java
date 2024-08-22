package com.baidu.android.common.others.url;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.i;
import com.baidu.android.common.others.java.Patterns;
import com.baidu.sapi2.SapiWebView;
import com.baidu.wallet.paysdk.datamodel.Bank;
import com.dxmpay.wallet.core.Domains;
import com.tera.scan.filetype.FileType;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

@Deprecated
public class UrlUtil {
    public static final boolean DEBUG = false;
    public static final String PERCENT_PATTEN = "%(?![0-9a-fA-F]{2})";
    public static final String PERCENT_TO_REPLACE = "%25";
    public static final String TAG = "UrlUtils";
    public static final String UTF_8 = "UTF-8";

    public static String addParam(String str, String str2, String str3) {
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

    public static String decodeUrl(String str, String str2) throws UnsupportedEncodingException {
        return URLDecoder.decode(str, str2);
    }

    public static String decodeWithUTF8(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
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
    public static java.lang.String delAllParamsFromUrl(java.lang.String r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.others.url.UrlUtil.delAllParamsFromUrl(java.lang.String):java.lang.String");
    }

    public static String deleteParam(String str, Set<String> set) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
            return str;
        }
        String str2 = null;
        try {
            str2 = new URL(str).getQuery();
        } catch (MalformedURLException unused) {
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

    public static String deleteParamAllowAll(String str, Set<String> set) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http") || set == null || set.size() == 0) {
            return str;
        }
        String str2 = null;
        try {
            str2 = new URL(str).getQuery();
        } catch (MalformedURLException unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        String deleteQueryParam = deleteQueryParam(str2, set);
        if (str == null) {
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

    public static String encodeUrl(String str, String str2) throws UnsupportedEncodingException {
        return URLEncoder.encode(str, str2);
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

    public static String getCookieStr(String str, String str2, String str3, long j) {
        return str2 + "=" + str3 + ";domain=" + str + ";path=/;max-age=" + j + i.b;
    }

    public static String getHost(String str) throws MalformedURLException {
        return new URL(str).getHost();
    }

    public static String getMime(String str) {
        String lowerCase = Uri.parse(str).getPath().toLowerCase(Locale.getDefault());
        if (lowerCase.contains(".css")) {
            return "text/css";
        }
        if (lowerCase.contains(".js")) {
            return "application/x-javascript";
        }
        return (lowerCase.contains(".jpg") || lowerCase.contains(FileType.GIF_PATTERN_SUFFIX) || lowerCase.contains(BrowserServiceFileProvider.FILE_EXTENSION) || lowerCase.contains(".jpeg")) ? "image/*" : SapiWebView.DATA_MIME_TYPE;
    }

    public static String getParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            return str.substring(indexOf + 1);
        }
        return null;
    }

    public static String getUrlField(String str, String str2, String str3, String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            String str5 = str2 + str3;
            int indexOf = str.indexOf("?");
            if (indexOf == -1) {
                indexOf = 0;
            }
            int indexOf2 = str.indexOf(str5, indexOf);
            if (indexOf2 != -1) {
                int indexOf3 = str.indexOf(str4, indexOf2);
                if (indexOf3 != -1) {
                    return str.substring(indexOf2 + str5.length(), indexOf3);
                }
                return str.substring(indexOf2 + str5.length());
            }
        }
        return "";
    }

    public static String getUrlhost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public static String handleAbnormalUrlIfNeeded(String str) {
        return (TextUtils.isEmpty(str) || !isUrl(str)) ? str : addSchemeIfNeed(fixUrl(str).trim());
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

    public static boolean isHttpSecurity(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("https://");
    }

    public static boolean isUrl(String str) {
        try {
            return Patterns.COARSE_WEB_URL.matcher(str).matches();
        } catch (Exception unused) {
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

    @SuppressLint({"BDThrowableCheck"})
    public static String mapToString(Map<String, String> map) {
        String str;
        String str2;
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String next : map.keySet()) {
            if (sb.length() > 0) {
                sb.append(a.n);
            }
            String str3 = map.get(next);
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
            if (str3 != null) {
                str2 = URLEncoder.encode(str3, "UTF-8");
            } else {
                str2 = "";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    @SuppressLint({"BDThrowableCheck"})
    public static Map<String, String> stringToMap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split(a.n);
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

    public static Uri toFileUri(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str));
    }

    public static String toFileUriString(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.fromFile(new File(str)).toString();
    }

    public static String getUrlField(String str, String str2) {
        return getUrlField(str, str2, "=", a.n);
    }

    public static String addParam(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String mapToString = mapToString(map);
        if (TextUtils.isEmpty(mapToString)) {
            return str;
        }
        if (str.contains("?")) {
            return str + a.n + mapToString;
        }
        return str + "?" + mapToString;
    }
}
