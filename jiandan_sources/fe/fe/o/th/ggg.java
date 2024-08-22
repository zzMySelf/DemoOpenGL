package fe.fe.o.th;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.browser.browseractions.BrowserServiceFileProvider;
import androidx.webkit.internal.AssetHelper;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.apollon.heartbeat.a;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.tera.scan.filetype.FileType;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ggg {
    public static final Map qw;

    static {
        HashMap hashMap = new HashMap();
        qw = hashMap;
        hashMap.put(".au", "audio/basic");
        qw.put(".avi", "video/x-msvideo");
        qw.put(".bmp", "image/bmp");
        qw.put(".dif", "video/x-dv");
        qw.put(".dv", "video/x-dv");
        qw.put(FileType.GIF_PATTERN_SUFFIX, "image/gif");
        qw.put(".jp2", "image/jp2");
        qw.put(".jpe", "image/jpeg");
        qw.put(".jpeg", "image/jpeg");
        qw.put(".jpg", "image/jpeg");
        qw.put(".kar", "audio/midi");
        qw.put(".m3u", "audio/x-mpegurl");
        qw.put(".m4a", "audio/mp4a-latm");
        qw.put(".m4b", "audio/mp4a-latm");
        qw.put(".m4p", "audio/mp4a-latm");
        qw.put(".m4u", "video/vnd.mpegurl");
        qw.put(".m4v", "video/x-m4v");
        qw.put(".mac", "image/x-macpaint");
        qw.put(".mid", "audio/midi");
        qw.put(".midi", "audio/midi");
        qw.put(".mov", "video/quicktime");
        qw.put(".movie", "video/x-sgi-movie");
        qw.put(".mp2", "audio/mpeg");
        qw.put(".mp3", "audio/mpeg");
        qw.put(".mp4", "video/mp4");
        qw.put(".mpe", "video/mpeg");
        qw.put(".mpeg", "video/mpeg");
        qw.put(".mpg", "video/mpeg");
        qw.put(".mpga", "audio/mpeg");
        qw.put(".mxu", "video/vnd.mpegurl");
        qw.put(".pct", "image/pict");
        qw.put(".pic", "image/pict");
        qw.put(".pict", "image/pict");
        qw.put(BrowserServiceFileProvider.FILE_EXTENSION, "image/png");
        qw.put(".pnm", "image/x-portable-anymap");
        qw.put(".pnt", "image/x-macpaint");
        qw.put(".pntg", "image/x-macpaint");
        qw.put(".ppm", "image/x-portable-pixmap");
        qw.put(".qt", "video/quicktime");
        qw.put(".qti", "image/x-quicktime");
        qw.put(".qtif", "image/x-quicktime");
        qw.put(".ra", "audio/x-pn-realaudio");
        qw.put(".ram", "audio/x-pn-realaudio");
        qw.put(".ras", "image/x-cmu-raster");
        qw.put(".rgb", "image/x-rgb");
        qw.put(".snd", "audio/basic");
        qw.put(".svg", "image/svg+xml");
        qw.put(".tif", "image/tiff");
        qw.put(".tiff", "image/tiff");
        qw.put(".wav", "audio/x-wav");
        qw.put(".apk", "application/apk");
        qw.put(".rtf", "text/rtf");
        qw.put(".rtx", "text/richtext");
        qw.put(".txt", AssetHelper.DEFAULT_MIME_TYPE);
        qw.put(".pdf", DocumentOpenUtil.PDF_TYPE);
        qw.put(".doc", DocumentOpenUtil.WORD_TYPE);
        qw.put(".ppt", DocumentOpenUtil.PPT_TYPE);
        qw.put(".xls", DocumentOpenUtil.EXCEL_TYPE);
        qw.put(".xlsx", DocumentOpenUtil.SHEET_TYPE);
        qw.put(".pptx", DocumentOpenUtil.PRESENT_TYPE);
        qw.put(".docx", DocumentOpenUtil.DOCUMENT_TYPE);
    }

    public static String ad(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length + length2 > 243) {
            if (length2 < 243) {
                str = str.substring(0, LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK - length2);
            } else {
                str = "" + System.currentTimeMillis();
                str2 = ".bin";
            }
        }
        String str3 = str + str2;
        if (str.endsWith(str2)) {
            str3 = str;
        }
        if (!new File(str3).exists()) {
            return str3;
        }
        String str4 = str + "_";
        int i2 = 1;
        for (int i3 = 1; i3 < 1000000000; i3 *= 10) {
            for (int i4 = 0; i4 < 9; i4++) {
                String str5 = str4 + i2 + str2;
                if (!new File(str5).exists()) {
                    return str5;
                }
                i2 += new Random(SystemClock.uptimeMillis()).nextInt(i3) + 1;
            }
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String de(java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r0 = 46
            java.lang.String r1 = "/"
            if (r7 == 0) goto L_0x0011
            boolean r2 = r7.endsWith(r1)
            if (r2 != 0) goto L_0x0011
            int r2 = r7.lastIndexOf(r0)
            goto L_0x0012
        L_0x0011:
            r2 = -1
        L_0x0012:
            r3 = 0
            java.lang.String r4 = "."
            if (r2 < 0) goto L_0x0043
            int r5 = r7.length()
            int r5 = r5 + -1
            if (r2 >= r5) goto L_0x0043
            int r2 = r2 + 1
            java.lang.String r7 = r7.substring(r2)
            android.webkit.MimeTypeMap r2 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r2 = r2.getMimeTypeFromExtension(r7)
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0043
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            goto L_0x0044
        L_0x0043:
            r7 = r3
        L_0x0044:
            boolean r2 = android.text.TextUtils.isEmpty(r8)
            java.lang.String r5 = ".bin"
            if (r2 != 0) goto L_0x00a5
            android.webkit.MimeTypeMap r6 = android.webkit.MimeTypeMap.getSingleton()
            java.lang.String r7 = r6.getExtensionFromMimeType(r8)
            if (r7 == 0) goto L_0x0067
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
        L_0x005e:
            r6.append(r7)
            java.lang.String r7 = r6.toString()
            goto L_0x00d3
        L_0x0067:
            java.lang.String r6 = r8.toLowerCase()
            java.lang.String r0 = "text/"
            boolean r6 = r6.startsWith(r0)
            if (r6 == 0) goto L_0x008b
            java.lang.String r6 = "text/html"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x007e
            java.lang.String r7 = ".html"
            goto L_0x00d3
        L_0x007e:
            java.lang.String r6 = "text/bin"
            boolean r6 = r8.equalsIgnoreCase(r6)
            if (r6 == 0) goto L_0x0088
            r7 = r5
            goto L_0x00d3
        L_0x0088:
            java.lang.String r7 = ".txt"
            goto L_0x00d3
        L_0x008b:
            java.lang.String r6 = r8.toLowerCase()
            java.lang.String r0 = "audio/"
            boolean r6 = r6.startsWith(r0)
            if (r6 == 0) goto L_0x00d3
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r7 = 6
            java.lang.String r7 = r8.substring(r7)
            goto L_0x005e
        L_0x00a5:
            java.lang.String r6 = android.net.Uri.decode(r6)
            if (r6 == 0) goto L_0x00c7
            boolean r8 = r6.endsWith(r1)
            if (r8 != 0) goto L_0x00c7
            r8 = 63
            int r8 = r6.indexOf(r8)
            if (r8 >= 0) goto L_0x00c7
            r8 = 47
            int r8 = r6.lastIndexOf(r8)
            int r8 = r8 + 1
            if (r8 <= 0) goto L_0x00c7
            java.lang.String r3 = r6.substring(r8)
        L_0x00c7:
            if (r3 == 0) goto L_0x00d3
            int r6 = r3.lastIndexOf(r0)
            if (r6 <= 0) goto L_0x00d3
            java.lang.String r7 = r3.substring(r6)
        L_0x00d3:
            if (r7 != 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r5 = r7
        L_0x00d7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fe.fe.o.th.ggg.de(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static void fe(Map map, String str) {
        if (map != null && str != null) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (((String) ((Map.Entry) it.next()).getKey()).equalsIgnoreCase(str)) {
                    it.remove();
                }
            }
        }
    }

    public static String i(String str, String str2, String str3) {
        String decode;
        int lastIndexOf;
        if (str2 == null || str2.endsWith("/")) {
            str2 = null;
        } else {
            int lastIndexOf2 = str2.lastIndexOf(47) + 1;
            if (lastIndexOf2 > 0) {
                str2 = str2.substring(lastIndexOf2);
            }
        }
        if (str2 == null && (decode = Uri.decode(str)) != null && !decode.endsWith("/") && decode.indexOf(63) < 0 && (lastIndexOf = decode.lastIndexOf(47) + 1) > 0) {
            str2 = decode.substring(lastIndexOf);
        }
        if (str2 == null) {
            str2 = "downloadfile";
        } else {
            int lastIndexOf3 = str2.lastIndexOf(46);
            if (lastIndexOf3 > 0) {
                str2 = str2.substring(0, lastIndexOf3);
            }
        }
        String replaceAll = str2.replaceAll("[()（）.,：:\\-|^$#_，。：=、/+《》<>*?？‘“”''\"\"]", "_");
        try {
            return URLEncoder.encode(replaceAll, a.h);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return replaceAll;
        }
    }

    /* renamed from: if  reason: not valid java name */
    public static int m176if(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo != null) {
            return connectionInfo.getRssi();
        }
        return 0;
    }

    public static NetworkInfo o(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean pf(String str) {
        return str.indexOf("?") > 0;
    }

    public static String qw(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                    if (activeNetworkInfo.getTypeName().toLowerCase().equals("wifi")) {
                        return "WF";
                    }
                    switch (activeNetworkInfo.getSubtype()) {
                        case 3:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return "3G";
                        case 13:
                            return "4G";
                        default:
                            return "2G";
                    }
                }
            } catch (Exception unused) {
                return "";
            }
        }
        return "";
    }

    public static boolean rg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int indexOf = str.indexOf(46);
        int i2 = 0;
        int i3 = 0;
        while (i2 < str.length()) {
            if (indexOf == -1) {
                indexOf = str.length();
            }
            try {
                int parseInt = Integer.parseInt(str.substring(i2, indexOf));
                if (parseInt <= 255 && parseInt >= 0) {
                    i3++;
                    i2 = indexOf + 1;
                    indexOf = str.indexOf(46, i2);
                }
            } catch (NumberFormatException unused) {
            }
            return false;
        }
        return i3 == 4;
    }

    /* renamed from: switch  reason: not valid java name */
    public static String m177switch(String str) {
        System.currentTimeMillis();
        try {
            rg xxx = rg.xxx(str);
            return xxx == null ? str : xxx.toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static boolean th(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static String uk(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, a.h);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static int when(Context context) {
        return (!fe.de(context, "pref_config_http_lib_type", fe.f2669de).equals(fe.f2669de) || Integer.parseInt(Build.VERSION.SDK) < 11) ? 0 : 1;
    }

    public static String yj(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null) ? "" : activeNetworkInfo.getExtraInfo().toLowerCase();
    }
}
