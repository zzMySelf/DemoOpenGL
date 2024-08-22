package com.baidu.searchbox.download.util;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import java.text.DecimalFormat;

public final class DownloadByteConverter {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String FILE_SUFFIX_DOT = ".";
    public static final int GB = 1073741824;
    public static final int KB = 1024;
    public static final int MB = 1048576;
    private static final String SIZE_ZERO = "0";

    public static String convertByteWithKB(double size, int accuracy, boolean saveZero) {
        float outNumber;
        String unit;
        int len;
        if (size < 1048576.0d) {
            unit = "KB";
            outNumber = ((float) size) / 1024.0f;
        } else if (size < 1.073741824E9d) {
            unit = "MB";
            outNumber = ((float) size) / 1048576.0f;
        } else {
            unit = "GB";
            outNumber = ((float) size) / 1.07374182E9f;
        }
        try {
            String pattern = calculatePattern(accuracy);
            if (TextUtils.isEmpty(pattern)) {
                return "";
            }
            String result = new DecimalFormat(pattern).format((double) outNumber);
            if (!saveZero) {
                if (accuracy != 0) {
                    if (!result.endsWith(pattern.substring(1)) || (len = result.lastIndexOf(".")) <= 0) {
                        return result + unit;
                    }
                    return result.substring(0, len) + unit;
                }
            }
            return result + unit;
        } catch (Exception e2) {
            if (!DEBUG) {
                return "";
            }
            e2.printStackTrace();
            throw e2;
        }
    }

    public static String convertByte(double size, int accuracy, boolean saveZero) {
        float outNumber;
        String unit;
        int len;
        if (size < 1024.0d) {
            unit = "B";
            outNumber = (float) size;
        } else if (size < 1048576.0d) {
            unit = "KB";
            outNumber = ((float) size) / 1024.0f;
        } else if (size < 1.073741824E9d) {
            unit = "MB";
            outNumber = ((float) size) / 1048576.0f;
        } else {
            unit = "GB";
            outNumber = ((float) size) / 1.07374182E9f;
        }
        try {
            String pattern = calculatePattern(accuracy);
            if (TextUtils.isEmpty(pattern)) {
                return "";
            }
            String result = new DecimalFormat(pattern).format((double) outNumber);
            if (!saveZero) {
                if (accuracy != 0) {
                    if (!result.endsWith(pattern.substring(1)) || (len = result.lastIndexOf(".")) <= 0) {
                        return result + unit;
                    }
                    return result.substring(0, len) + unit;
                }
            }
            return result + unit;
        } catch (Exception e2) {
            if (!DEBUG) {
                return "";
            }
            e2.printStackTrace();
            throw e2;
        }
    }

    private static String calculatePattern(int accuracy) {
        StringBuilder str = new StringBuilder("0");
        if (accuracy < 0) {
            return "";
        }
        if (accuracy == 0) {
            return str.toString();
        }
        StringBuilder str2 = str.append(".");
        for (int i2 = 0; i2 < accuracy; i2++) {
            str2.append("0");
        }
        return str2.toString();
    }
}
