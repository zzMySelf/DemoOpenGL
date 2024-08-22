package com.yy.mediaframework.utils;

import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.yy.mediaframework.utils.FP;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Vector;
import kotlin.text.Typography;

public class StringUtils {
    public static final boolean IGNORE_CASE = true;
    public static final boolean IGNORE_WIDTH = true;
    private static final int SHA1_LENGTH = 40;

    public static boolean isNullOrEmpty(String str) {
        return FP.empty((CharSequence) str);
    }

    public static boolean isAllWhitespaces(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAllDigits(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char c2 = str.charAt(i2);
            if (c2 < '0' || c2 > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean equal(String s1, String s2) {
        return equal(s1, s2, false);
    }

    public static boolean equal(String s1, String s2, boolean ignoreCase) {
        if (s1 == null || s2 == null) {
            return s1 == null && s2 == null;
        }
        if (ignoreCase) {
            return s1.equalsIgnoreCase(s2);
        }
        return s1.equals(s2);
    }

    public static Vector<String> parseMediaUrls(String str, String beginTag, String endTag) {
        Vector<String> list = new Vector<>();
        if (!isNullOrEmpty(str)) {
            int beginIndex = str.indexOf(beginTag, 0);
            int endIndex = str.indexOf(endTag, 0);
            while (beginIndex != -1 && endIndex != -1 && endIndex > beginIndex) {
                String imgUrl = str.substring(beginIndex + beginTag.length(), endIndex);
                if (!isNullOrEmpty(imgUrl) && imgUrl.charAt(0) != '[') {
                    list.add(imgUrl);
                }
                int endIndex2 = endIndex + endTag.length() + endIndex;
                beginIndex = str.indexOf(beginTag, endIndex2);
                endIndex = str.indexOf(endTag, endIndex2);
            }
        }
        return list;
    }

    public static int find(String pattern, String s) {
        return find(pattern, s, false);
    }

    public static int find(String pattern, String s, boolean ignoreCase) {
        return find(pattern, s, ignoreCase, false);
    }

    public static int find(String pattern, String s, boolean ignoreCase, boolean ignoreWidth) {
        if (FP.empty((CharSequence) s)) {
            return -1;
        }
        String pattern2 = FP.ref(pattern);
        if (ignoreCase) {
            pattern2 = pattern2.toLowerCase();
            s = s.toLowerCase();
        }
        if (ignoreWidth) {
            pattern2 = narrow(pattern2);
            s = narrow(s);
        }
        return s.indexOf(pattern2);
    }

    public static String narrow(String s) {
        if (FP.empty((CharSequence) s)) {
            return "";
        }
        char[] cs = s.toCharArray();
        for (int i2 = 0; i2 < cs.length; i2++) {
            cs[i2] = narrow(cs[i2]);
        }
        return new String(cs);
    }

    public static char narrow(char c2) {
        int code = c2;
        if (code >= 65281 && code <= 65373) {
            return (char) (code - 65248);
        }
        if (code == 12288) {
            return (char) ((code - 12288) + 32);
        }
        if (code == 65377) {
            return 12290;
        }
        if (code == 12539 || code == 8226) {
            return Typography.middleDot;
        }
        return c2;
    }

    public static int ord(char c2) {
        if ('a' <= c2 && c2 <= 'z') {
            return c2;
        }
        if ('A' > c2 || c2 > 'Z') {
            return 0;
        }
        return (c2 - 'A') + 97;
    }

    public static int compare(String x, String y) {
        return FP.ref(x).compareTo(FP.ref(y));
    }

    public static String getHashIfPassIsPlainText(String password) {
        if (isNullOrEmpty(password) || password.length() >= 40) {
            return password;
        }
        return sha1(password);
    }

    public static String sha1(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(bytesToHexString(MessageDigest.getInstance("SHA1").digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e2) {
            YMFLog.error((Object) null, "[Util    ]", "sha1 exception:" + e2.toString());
        }
        return sb.toString();
    }

    public static String bytesToHexString(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bytes) {
            int val = b2 & 255;
            if (val < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString();
    }

    public static boolean isValidMobileNumber(String phone) {
        if (phone == null || phone.length() != 11 || !phone.startsWith("1")) {
            return false;
        }
        return isAllDigits(phone);
    }

    public static boolean isNameMatchMobilePattern(String name) {
        return name != null && name.matches("1\\d{10}(y*|s*)");
    }

    public static String getMobileFromName(String name) {
        YMFLog.debug((Object) null, "[Util    ]", "mobile user name:%s", name);
        if (name != null && name.startsWith("1") && name.length() >= 11) {
            String mobile = name.substring(0, 11);
            if (isValidMobileNumber(mobile)) {
                return mobile;
            }
        }
        return "";
    }

    public static boolean isIpv4Addr(String addr) {
        return addr != null && addr.matches("(\\d{1,3}\\.){3}\\d{1,3}");
    }

    public static <A, B> String fromPair(Pair<A, B> p) {
        return p.first + ":" + p.second;
    }

    public static <A, B> String join(CharSequence delim, List<Pair<A, B>> xs) {
        return TextUtils.join(delim, FP.map(new FP.UnaryFunc<String, Pair<A, B>>() {
            public String apply(Pair<A, B> p) {
                return StringUtils.fromPair(p);
            }
        }, xs));
    }

    public static <E> String join(CharSequence delim, SparseArray<E> xs) {
        return join(delim, FP.toList(xs));
    }

    public static String join(CharSequence delim, SparseIntArray xs) {
        return join(delim, FP.toList(xs));
    }
}
