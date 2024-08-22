package fe.th.qw.qw.qw;

import android.content.Context;
import android.content.res.Resources;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.sapi2.utils.SapiDeviceInfo;

public class i {
    public static String qw;

    public static boolean ad() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equalsIgnoreCase(String.valueOf(cls.getDeclaredMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean de(Context context) {
        if (fe(context)) {
            return true;
        }
        return ad();
    }

    public static boolean fe(Context context) {
        try {
            return "harmony".equalsIgnoreCase(context.getString(Resources.getSystem().getIdentifier("config_os_brand", ResUtils.b, SapiDeviceInfo.OS_TYPE)));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String qw(Context context) {
        String str = qw;
        if (str != null) {
            return str;
        }
        if (de(context)) {
            qw = "harmony";
            return "harmony";
        }
        qw = SapiDeviceInfo.OS_TYPE;
        return SapiDeviceInfo.OS_TYPE;
    }
}
