package com.baidu.wallet.lightapp.base;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.utils.Base64Utils;
import com.baidu.apollon.utils.BussinessUtils;
import com.baidu.apollon.utils.PhoneUtils;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.core.Domains;

public class a {
    public int a;

    /* renamed from: com.baidu.wallet.lightapp.base.a$a  reason: collision with other inner class name */
    public static class C0155a {
        public static a a = new a();
    }

    public static a a() {
        return C0155a.a;
    }

    public a() {
        this.a = -1;
    }

    public void a(Context context) {
        try {
            CookieSyncManager.createInstance(context);
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            StringBuilder sb = new StringBuilder();
            sb.append("STDCJUVF=");
            sb.append(Base64Utils.encodeToString(("{\"ua\":" + "\"" + BussinessUtils.getUA(context) + "\",\"cu\":\"" + PhoneUtils.getCUID(context) + "\",\"cu2\":\"" + PhoneUtils.getCUID2(context) + "\"}").getBytes()));
            String sb2 = sb.toString();
            String[] strArr = {Domains.BAIDU, ".baifubao.com", Domains.DU_XIAO_MAN, Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT, ".dxmbaoxian.com", Domains.DU_XIAO_MAN_FUND, Domains.BAI_YING_FUND};
            if (WalletLoginHelper.getInstance().isDxmLogin() && WalletLoginHelper.getInstance().isDxmPassportLogin()) {
                strArr = new String[]{Domains.BAIDU, ".baifubao.com", Domains.DU_XIAO_MAN_PAY, Domains.DU_XIAO_MAN_INT, ".dxmbaoxian.com", Domains.DU_XIAO_MAN_FUND, Domains.BAI_YING_FUND};
            }
            for (String str : strArr) {
                instance.setCookie("https://www" + str, sb2 + ";path=/" + ";domain=" + str + ";secure" + ";httponly");
            }
            String str2 = "" + System.currentTimeMillis();
            String str3 = SafePay.getInstance().getpwProxy();
            String encryptProxy = SafePay.getInstance().encryptProxy(str2);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("TIMETOKEN=");
            sb3.append(Base64Utils.encodeToString(("{\"timestamp\":" + "\"" + str2 + "\",\"key\":\"" + str3 + "\",\"timeencrypt\":\"" + encryptProxy + "\"}").getBytes()));
            String sb4 = sb3.toString();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(sb4);
            sb5.append(";domain=" + DomainConfig.getInstance().getAppHost(new Boolean[]{Boolean.FALSE}).substring(8));
            sb5.append(";path=/walletapp/misc/");
            sb5.append(";secure");
            sb5.append(";httponly");
            instance.setCookie(DomainConfig.getInstance().getAppHost(new Boolean[]{Boolean.FALSE}) + "/walletapp/misc/jump", sb5.toString());
            CookieSyncManager.getInstance().sync();
        } catch (Exception unused) {
        }
    }

    public int a(Context context, String str, int i2) {
        int bdussState = WalletLoginHelper.getInstance().getBdussState();
        if (!(i2 == -1 || i2 == bdussState || (bdussState != 0 && bdussState != 3 && bdussState != 4))) {
            WalletLoginHelper.getInstance().getOpenBduss(false, (ILoginBackListener) null, 4);
        }
        if (WalletLoginHelper.getInstance().getSyncLoginListener() == null) {
            return bdussState;
        }
        WalletLoginHelper.getInstance().syncH5LoginStatus(context, str);
        return bdussState;
    }
}
