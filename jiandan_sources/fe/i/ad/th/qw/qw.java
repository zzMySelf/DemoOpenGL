package fe.i.ad.th.qw;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.UAFilterUtil;
import java.util.regex.Pattern;

public class qw {
    public Pattern qw;

    public static class ad {
        public static qw qw = new qw();
    }

    public static qw qw() {
        return ad.qw;
    }

    public String ad(Context context) {
        String str;
        try {
            str = PhoneUtils.getCUID(context);
            try {
                return this.qw.matcher(str).replaceAll("");
            } catch (Exception e) {
                e = e;
                LogUtil.e("HeaderService", e.getMessage(), e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
            LogUtil.e("HeaderService", e.getMessage(), e);
            return str;
        }
    }

    public String de(Context context) {
        String str;
        try {
            str = PhoneUtils.getCUID2(context);
            try {
                return this.qw.matcher(str).replaceAll("");
            } catch (Exception e) {
                e = e;
                LogUtil.e("HeaderService", e.getMessage(), e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
            LogUtil.e("HeaderService", e.getMessage(), e);
            return str;
        }
    }

    public String fe(Context context) {
        try {
            return UAFilterUtil.getInstance().getTrueUA(context);
        } catch (Exception unused) {
            return null;
        }
    }

    public String rg(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e) {
            LogUtil.e("HeaderService", e.getMessage(), e);
            return null;
        }
    }

    public qw() {
        this.qw = Pattern.compile("\\s*|\t|\r|\n");
    }
}
