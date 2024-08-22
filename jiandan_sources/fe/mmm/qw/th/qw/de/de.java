package fe.mmm.qw.th.qw.de;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.tera.scan.component.base.base.NativeChannelManager;
import com.tera.scan.network.network.request.RequestCommonParams;
import fe.mmm.qw.i.qw;
import fe.mmm.qw.th.qw.ad;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class de {
    public static boolean qw = false;

    public static String ad(Context context) {
        String th2 = th(context);
        if (!TextUtils.isEmpty(th2)) {
            return th2;
        }
        String de2 = de(context, "channel");
        return TextUtils.isEmpty(de2) ? "8679v" : de2;
    }

    public static String de(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getResources().getAssets().open(str);
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            String trim = new String(bArr, StandardCharsets.UTF_8).trim();
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    qw.th("BaiduNetdiskCommonConfig", e.getMessage(), e);
                }
            }
            return trim;
        } catch (Exception e2) {
            qw.th("BaiduNetdiskCommonConfig", e2.getMessage(), e2);
            if (inputStream == null) {
                return "";
            }
            try {
                inputStream.close();
                return "";
            } catch (IOException e3) {
                qw.th("BaiduNetdiskCommonConfig", e3.getMessage(), e3);
                return "";
            }
        } catch (Throwable th2) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    qw.th("BaiduNetdiskCommonConfig", e4.getMessage(), e4);
                }
            }
            throw th2;
        }
    }

    public static long fe(boolean z) {
        fe.mmm.qw.yj.de ppp = fe.mmm.qw.yj.de.ppp();
        if (!ppp.i("first_launch_time") && z) {
            ppp.m1012if("first_launch_time", System.currentTimeMillis() / 1000);
            ppp.qw();
        }
        return ppp.th("first_launch_time", -1);
    }

    public static void qw(Application application, boolean z, String str, String str2, String str3) {
        qw.uk("BaiduNetdiskCommonConfig", "TestAApplication init");
        if (!qw) {
            qw.uk("BaiduNetdiskCommonConfig", "TestAApplication init 2");
            new qw().th(application);
            System.setProperty("java.net.preferIPv6Addresses", "false");
            String packageName = application.getPackageName();
            if (!TextUtils.isEmpty(packageName) && !SapiDeviceInfo.OS_TYPE.equals(packageName)) {
                fe.mmm.qw.de.ad.qw.qw.f7755yj = packageName;
            }
            fe.mmm.qw.de.ad.qw.qw.f7750o = DeviceId.getCUID(application);
            fe.mmm.qw.de.ad.qw.qw.f7749i = "19884805";
            fe.mmm.qw.de.ad.qw.qw.f7748fe = "8679v";
            String ad2 = ad(application);
            fe.mmm.qw.de.ad.qw.qw.fe(application, ad2, rg(ad2), fe(z), str, str2);
            qw.uk("BaiduNetdiskCommonConfig", "CHANNEL_NUM = " + fe.mmm.qw.de.ad.qw.qw.f7752rg);
            qw.uk("BaiduNetdiskCommonConfig", "SETUP_CHANNEL_NUM = " + fe.mmm.qw.de.ad.qw.qw.f7753th);
            qw.ad("BaiduNetdiskCommonConfig", "PACKAGE_NAME：" + fe.mmm.qw.de.ad.qw.qw.f7755yj);
            qw.ad("BaiduNetdiskCommonConfig", "DEVUID = " + fe.mmm.qw.de.ad.qw.qw.f7750o);
            qw.ad("BaiduNetdiskCommonConfig", "APPID = " + str2);
            RequestCommonParams.m848if(new ad(str3));
            qw = true;
        }
        ad.qw();
    }

    public static String rg(String str) {
        String yj2 = fe.mmm.qw.yj.de.ppp().yj("first_setup_channel_key");
        if (!TextUtils.isEmpty(yj2)) {
            return yj2;
        }
        fe.mmm.qw.yj.de.ppp().m1013switch("first_setup_channel_key", str);
        fe.mmm.qw.yj.de.ppp().qw();
        return str;
    }

    public static String th(Context context) {
        if (context == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String fe2 = new NativeChannelManager(context).fe();
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        qw.ad("BaiduNetdiskCommonConfig", "预装渠道号：" + fe2 + "  耗时：" + currentTimeMillis2);
        return fe2;
    }
}
