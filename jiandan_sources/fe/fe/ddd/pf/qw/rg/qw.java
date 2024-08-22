package fe.fe.ddd.pf.qw.rg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.helios.OnGetIdResultCallback;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.datacollector.growth.privacy.ICommonDataPrivacy;
import com.baidu.searchbox.datacollector.growth.utils.IDeviceCallback;
import com.baidu.sofire.xclient.privacycontrol.lib.OaidHelper;
import com.baidu.sofire.xclient.privacycontrol.lib.TelephonyHelper;
import fe.fe.pf.ad;

public class qw {
    public static final boolean qw = AppConfig.rg();

    /* renamed from: fe.fe.ddd.pf.qw.rg.qw$qw  reason: collision with other inner class name */
    public class C0084qw implements OnGetIdResultCallback<String> {
        public final /* synthetic */ IDeviceCallback qw;

        public C0084qw(IDeviceCallback iDeviceCallback) {
            this.qw = iDeviceCallback;
        }

        public void onError(int i2, Throwable th2, Bundle bundle) {
            IDeviceCallback iDeviceCallback = this.qw;
            if (iDeviceCallback != null) {
                iDeviceCallback.qw();
            }
        }

        /* renamed from: qw */
        public void onResult(String str, Bundle bundle) {
            IDeviceCallback iDeviceCallback = this.qw;
            if (iDeviceCallback != null) {
                iDeviceCallback.onSuccess(str);
            }
        }
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String ad(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return "";
        }
        if (i2 >= 23 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return "";
        }
        String str = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                str = TelephonyHelper.getDeviceId(telephonyManager);
            }
        } catch (Exception e) {
            if (qw) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static void qw(Context context, IDeviceCallback iDeviceCallback) {
        ad th2 = ad.th(context);
        ICommonDataPrivacy qw2 = fe.fe.ddd.pf.qw.de.qw.qw();
        if (th2 != null && qw2 != null && qw2.qw()) {
            OaidHelper.requestOid(th2, new C0084qw(iDeviceCallback));
        } else if (iDeviceCallback != null) {
            iDeviceCallback.qw();
        }
    }
}
