package th.na.na.th;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.etn.logger.Logging;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* compiled from: EtnDownSoConstant */
public class th {
    public static String li = "";
    public static String na;

    /* renamed from: th  reason: collision with root package name */
    public static String f7815th;

    public static String li() {
        return th.na.th.th.ma.th.th();
    }

    public static void ma(String str) {
        Logging.i("EtnDownSoConstan", th.th.th.th.th.th("setCurrentUseSoVersion old=").append(li).append(",new=").append(str).toString());
        li = str;
    }

    public static void mo(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "armeabi-v7a";
        }
        f7815th = str;
    }

    public static String na(Context context, String str) {
        return th.th.th.th.th.th(th(context)).append(File.separator).append(th("https://rtc-so.cdn.bcebos.com" + (File.separator + "etn" + File.separator + str + File.separator + th() + "_etn.zip"))).toString();
    }

    public static String th() {
        if (TextUtils.isEmpty(f7815th)) {
            return "armeabi-v7a";
        }
        return f7815th;
    }

    public static String li(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b2 : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                String hexString = Integer.toHexString(b2 & UByte.MAX_VALUE);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2.toLowerCase();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String ma() {
        StringBuilder append = th.th.th.th.th.th("https://rtc-so.cdn.bcebos.com").append(mo());
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        String sb = append.append("?md5hash=" + li(li() + mo() + currentTimeMillis) + "&timestamp=" + currentTimeMillis).toString();
        na = sb;
        return sb;
    }

    public static String mo() {
        StringBuilder append = new StringBuilder().append(File.separator).append("etn").append(File.separator);
        String str = li;
        if (TextUtils.isEmpty(str)) {
            str = "1.3.11";
        }
        Logging.i("EtnDownSoConstan", "getSoVersion " + str);
        return append.append(str).append(File.separator).append(th()).append("_etn.zip").toString();
    }

    public static String th(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = th(context);
        }
        return th.th.th.th.th.th(str2).append(File.separator).append(th(str)).toString();
    }

    public static String na(String str) {
        String str2 = File.separator + "etn" + File.separator + str + File.separator + th() + "_etn.zip";
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return "https://rtc-so.cdn.bcebos.com" + str2 + ("?md5hash=" + li(th.na.th.th.ma.th.th() + str2 + currentTimeMillis) + "&timestamp=" + currentTimeMillis);
    }

    public static String th(Context context) {
        return th(context, "etn");
    }

    public static String th(Context context, String str) {
        if (context == null) {
            return null;
        }
        StringBuilder append = th.th.th.th.th.th(context.getFilesDir().getAbsolutePath()).append(File.separator);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        File file = new File(append.append(str).toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String th(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains(GameCenterUtils.SCHEME_SWAN_SUFFIX)) {
            str = str.substring(0, str.indexOf(GameCenterUtils.SCHEME_SWAN_SUFFIX));
        }
        return li(str);
    }

    public static String na(Context context) {
        if (TextUtils.isEmpty(na)) {
            ma();
        }
        return th(context, na, th(context)) + File.separator + "jniLibs" + File.separator + th();
    }

    public static String na() {
        StringBuilder append = th.th.th.th.th.th("https://rtc-so.cdn.bcebos.com").append(mo());
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return append.append("?md5hash=" + li(th.na.th.th.ma.th.th() + mo() + currentTimeMillis) + "&timestamp=" + currentTimeMillis).toString();
    }

    public static boolean na(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str) || context == null) {
            return false;
        }
        return th.na.th.th.ma.th.na(th.th.th.th.th.th(th(context, str, str2)).append(File.separator).append("jniLibs").append(File.separator).append(th()).append(File.separator).append("libetn_play_proxy.so").toString());
    }
}
