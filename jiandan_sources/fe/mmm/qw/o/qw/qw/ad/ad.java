package fe.mmm.qw.o.qw.qw.ad;

import android.text.TextUtils;
import com.baidu.android.common.others.IStringUtil;

public class ad {
    public static boolean ad(String str) {
        return qw(str, ".doc") || qw(str, ".docx");
    }

    public static boolean de(String str) {
        return qw(str, ".xls") || qw(str, ".xlsx");
    }

    public static boolean fe(String str) {
        return ad(str) || de(str) || th(str);
    }

    public static boolean qw(String str, String str2) {
        return (IStringUtil.CURRENT_PATH + fe.mmm.qw.j.xxx.ad.o(str)).equalsIgnoreCase(str2);
    }

    public static boolean rg(String str) {
        return qw(str, ".pdf");
    }

    public static boolean th(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (qw(str, ".ppt") || qw(str, ".pptx")) {
            return true;
        }
        return false;
    }

    public static boolean yj(String str) {
        return qw(str, ".txt");
    }
}
