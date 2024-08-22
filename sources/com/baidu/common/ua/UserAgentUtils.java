package com.baidu.common.ua;

public class UserAgentUtils {
    public static String encodeIllegalInfo(String userAgentInfo) {
        StringBuilder sb = new StringBuilder();
        int length = userAgentInfo.length();
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = userAgentInfo.charAt(i2);
            if (c2 <= 31 || c2 >= 127) {
                sb.append(String.format("\\u%04x", new Object[]{Integer.valueOf(c2)}));
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }
}
