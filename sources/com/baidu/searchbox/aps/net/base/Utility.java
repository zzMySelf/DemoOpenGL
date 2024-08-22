package com.baidu.searchbox.aps.net.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Xml;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.net.ProxyHttpClient;
import com.baidu.android.common.util.CommonParam;
import com.baidu.megapp.ma.Util;
import com.baidu.searchbox.aps.base.utils.BaseConfiger;
import com.baidu.searchbox.aps.base.utils.CommonUtils;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

public class Utility {
    public static final int FILE_STREAM_BUFFER_SIZE = 8192;
    public static final byte GZIP_HEAD_1 = 117;
    public static final byte GZIP_HEAD_2 = 123;
    private static final String TAG = "Utility";

    public static class QAConfig {
        public static String addressQueryList = (curHost + "/aps?service=sdk&action=api");
        public static String addressQueryOne = (curHost + "/aps?service=sdk&action=get");
        private static String curHost = "http://mbd.baidu.com/aps";
        private static String devHost = "http://mbd.baidu.com/aps";
    }

    public static boolean isUrl(String url) {
        if (Patterns.WEB_URL.matcher(url).matches()) {
            return true;
        }
        return Patterns.COARSE_WEB_URL.matcher(url).matches();
    }

    public static String getStringFromInput(InputStream inputStream) {
        byte[] buf = getByteFromInputStream(inputStream);
        if (buf == null) {
            return null;
        }
        String str = new String(buf);
        if (str.startsWith("﻿")) {
            return str.substring(1);
        }
        return str;
    }

    public static byte[] getByteFromInputStream(InputStream is) {
        if (is == null) {
            return null;
        }
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        while (true) {
            int len = 0;
            try {
                len = is.read(buffer, 0, buffer.length);
            } catch (IOException e2) {
                if (BaseConfiger.isDebug()) {
                    e2.printStackTrace();
                }
            }
            if (len != -1) {
                bos.write(buffer, 0, len);
            } else {
                byte[] buffer2 = bos.toByteArray();
                CommonUtils.closeSafely(bos);
                return buffer2;
            }
        }
    }

    public static String streamToString(InputStream is) {
        return streamToString(is, Xml.Encoding.UTF_8.toString());
    }

    public static String streamToString(InputStream is, String enc) {
        if (is == null) {
            return null;
        }
        StringBuilder buffer = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, enc), 8192);
            while (true) {
                String readLine = reader.readLine();
                String line = readLine;
                if (readLine == null) {
                    break;
                }
                buffer.append(line);
            }
        } catch (OutOfMemoryError e2) {
            if (BaseConfiger.isDebug()) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            if (BaseConfiger.isDebug()) {
                e3.printStackTrace();
            }
        } catch (Throwable th2) {
            CommonUtils.closeSafely(is);
            throw th2;
        }
        CommonUtils.closeSafely(is);
        return buffer.toString();
    }

    public static HttpEntity getPostDataReplaceBy757B(String postParams) {
        byte[] compressBuffer;
        if (TextUtils.isEmpty(postParams) || (compressBuffer = GZIP.gzip(postParams.getBytes())) == null) {
            return null;
        }
        compressBuffer[0] = 117;
        compressBuffer[1] = 123;
        ByteArrayEntity entity = new ByteArrayEntity(compressBuffer);
        entity.setContentType("application/octet-stream");
        return entity;
    }

    public static ProxyHttpClient createHttpClient(Context context) {
        ProxyHttpClient httpclient = new ProxyHttpClient(context);
        HttpConnectionParams.setConnectionTimeout(httpclient.getParams(), 30000);
        HttpConnectionParams.setSoTimeout(httpclient.getParams(), 50000);
        return httpclient;
    }

    public static String getUID(Context context) {
        SharedPreferences mSettings = context.getSharedPreferences("aps_identity", 0);
        String uid = mSettings.getString("uid_v3", "");
        if (TextUtils.isEmpty(uid)) {
            uid = generateUID(context);
            if (BaseConfiger.isDebug()) {
                Log.d("Utility", "new generated uid " + uid);
            }
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString("uid_v3", uid);
            editor.commit();
        } else if (BaseConfiger.isDebug()) {
            Log.d("Utility", "load uid from local " + uid);
        }
        return uid;
    }

    private static String generateUID(Context context) {
        return CommonParam.getCUID(context);
    }

    public static String getInstalledApkPath(Context context, String packageName) {
        return Util.getInstalledApkPath(context, packageName);
    }

    public static class GZIP {
        public static final int NUM_1024 = 1024;

        private GZIP() {
        }

        public static byte[] gzip(byte[] data) {
            byte[] b2;
            if (data == null) {
                return null;
            }
            GZIPOutputStream gzip = null;
            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                gzip = new GZIPOutputStream(bos);
                gzip.write(data);
                gzip.flush();
                b2 = bos.toByteArray();
            } catch (OutOfMemoryError e2) {
                if (BaseConfiger.isDebug()) {
                    e2.printStackTrace();
                }
                b2 = null;
            } catch (Exception e3) {
                if (BaseConfiger.isDebug()) {
                    e3.printStackTrace();
                }
                b2 = null;
            } catch (Throwable th2) {
                CommonUtils.closeSafely((Closeable) null);
                throw th2;
            }
            CommonUtils.closeSafely(gzip);
            return b2;
        }

        public static byte[] unGzip(byte[] data) {
            byte[] b2;
            if (data == null) {
                return null;
            }
            GZIPInputStream gzip = null;
            ByteArrayOutputStream baos = null;
            try {
                gzip = new GZIPInputStream(new ByteArrayInputStream(data));
                byte[] buf = new byte[1024];
                baos = new ByteArrayOutputStream();
                while (true) {
                    int read = gzip.read(buf, 0, buf.length);
                    int num = read;
                    if (read == -1) {
                        break;
                    }
                    baos.write(buf, 0, num);
                }
                baos.flush();
                b2 = baos.toByteArray();
            } catch (OutOfMemoryError e2) {
                if (BaseConfiger.isDebug()) {
                    e2.printStackTrace();
                }
                b2 = null;
            } catch (Exception e3) {
                if (BaseConfiger.isDebug()) {
                    e3.printStackTrace();
                }
                b2 = null;
            } catch (Throwable th2) {
                CommonUtils.closeSafely((Closeable) null);
                CommonUtils.closeSafely((Closeable) null);
                throw th2;
            }
            CommonUtils.closeSafely(baos);
            CommonUtils.closeSafely(gzip);
            return b2;
        }
    }

    public static class Patterns {
        public static final Pattern COARSE_WEB_URL = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-80akhbyknj4f|xn\\-\\-9t4b11yi5a|xn\\-\\-deba0ad|xn\\-\\-g6w251d|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-zckzah)|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\?(?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\;\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
        public static final String GOOD_IRI_CHAR = "a-zA-Z0-9 -퟿豈-﷏ﷰ-￯";
        public static final String TOP_LEVEL_DOMAIN_STR_FOR_WEB_URL = "(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-80akhbyknj4f|xn\\-\\-9t4b11yi5a|xn\\-\\-deba0ad|xn\\-\\-g6w251d|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-zckzah)|y[etu]|z[amw]))";
        public static final Pattern WEB_URL = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-80akhbyknj4f|xn\\-\\-9t4b11yi5a|xn\\-\\-deba0ad|xn\\-\\-g6w251d|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-zckzah)|y[etu]|z[amw]))|(?:(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(?:25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\;\\/\\?\\:\\@\\&\\=\\#\\~\\[\\]\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");

        private Patterns() {
        }
    }

    public static final class CPUInfo {
        public static final String FEATURE_COMMON = "common";
        public static final String FEATURE_NEON = "neon";
        public static final String FEATURE_VFP = "vfp";
        private static final String PREFIX_FEATURES = "features";
        private static final String PREFIX_PROCESSOR = "processor";
        public static final String PROCESSOR_ARMV5 = "armv5";
        public static final String PROCESSOR_ARMV6 = "armv6";
        public static final String PROCESSOR_ARMV7 = "armv7";
        public static final String PROCESSOR_X86 = "x86";
        private static CPUInfo mSystemCPUInfo;
        public String features = "";
        public String processor = "";

        public static CPUInfo getSystemCPUInfo() {
            CPUInfo cPUInfo = mSystemCPUInfo;
            if (cPUInfo != null) {
                return cPUInfo;
            }
            CPUInfo info = new CPUInfo();
            try {
                FileReader fr = new FileReader("/proc/cpuinfo");
                BufferedReader bufferedReader = new BufferedReader(fr);
                Object obj = ":";
                Object obj2 = "__";
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    String item = line.trim().toLowerCase();
                    if (item.startsWith("processor") && item.indexOf(":", "processor".length()) != -1) {
                        if (info.processor.length() > 0) {
                            info.processor += "__";
                        }
                        info.processor += item.split(":")[1].trim();
                    } else if (item.startsWith("features") && item.indexOf(":", "features".length()) != -1) {
                        if (info.features.length() > 0) {
                            info.features += "__";
                        }
                        info.features += item.split(":")[1].trim();
                    }
                }
                bufferedReader.close();
                fr.close();
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
                info.processor = "x86";
            }
            mSystemCPUInfo = info;
            return info;
        }

        public static String getCpuArchInfo() {
            String arch = System.getProperty("os.arch").toLowerCase();
            if (arch == null || arch.length() == 0) {
                return null;
            }
            return arch;
        }

        public static String getCpuArch() {
            return getSystemCPUInfo().processor;
        }

        public static String getCpuFeature() {
            return getSystemCPUInfo().features;
        }
    }
}
