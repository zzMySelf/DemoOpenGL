package fe.i.ad.fe;

import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.common.others.IStringUtil;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.core.Domains;
import com.dxmpay.wallet.dxmpass.DxmPassManagerDelegate;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import org.json.JSONException;

public class qw {

    /* renamed from: de  reason: collision with root package name */
    public static final String[] f4449de = {Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN, ".8.baidu.com", ".manhaoyong.duxiaoman-int.com", ".manhaoyong.dxmpay.com", ".wallet.baidu.com", ".umoney.baidu.com", ".icash.baidu.com", ".yqh.baidu.com", ".ibeauty.baidu.com", ".front.baidu.com", ".activity8.baidu.com", ".qianbao.baidu.com", ".dxmbaoxian.com", ".oneicash.baidu.com", ".twoicash.baidu.com", ".threeicash.baidu.com", ".onejin.baidu.com", ".twojin.baidu.com", ".threejin.baidu.com", ".dxmcash.baidu.com", ".dxmoney.baidu.com", ".fincash.baidu.com"};

    /* renamed from: ad  reason: collision with root package name */
    public String f4450ad;
    public Context qw;

    public static class ad {
        public static final qw qw = new qw();
    }

    public static qw qw() {
        return ad.qw;
    }

    public final void ad(int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, i2);
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        this.f4450ad = simpleDateFormat.format(time);
        "--DxmCookieManager---cookie----expires--->" + this.f4450ad;
    }

    public final void de(int i2, String str) {
        try {
            ad(i2);
            String[] th2 = th(SdkInitResponse.getInstance().getCookiesSyncDomainList(this.qw));
            if (th2 == null) {
                th2 = f4449de;
            }
            CookieSyncManager.createInstance(this.qw);
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            String str2 = "OPENBDUSS=" + str;
            String str3 = ";expires=" + this.f4450ad;
            int length = th2.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str4 = th2[i3];
                if (!str4.startsWith(IStringUtil.CURRENT_PATH)) {
                    str4 = IStringUtil.CURRENT_PATH + str4;
                }
                if (!Domains.DU_XIAO_MAN.equals(str4) || DxmPassManagerDelegate.getInstance().dxmGetLoginType() != 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(";path=/");
                    sb.append(str3);
                    sb.append(";domain=");
                    sb.append(str4);
                    sb.append(";httponly");
                    sb.append(";secure");
                    "---DxmCookieManager---setCookie value--->" + sb.toString();
                    instance.setCookie("https://www" + str4, sb.toString());
                }
            }
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.getInstance().sync();
            } else {
                instance.flush();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void fe(String str) {
        de(8, str);
    }

    public void rg() {
        de(-8, "");
    }

    public final String[] th(String str) {
        try {
            return (String[]) JsonUtils.fromJson(str, String[].class);
        } catch (JSONException unused) {
            return null;
        }
    }

    public qw() {
        this.qw = BaiduWalletDelegate.getInstance().getAppContext();
    }
}
