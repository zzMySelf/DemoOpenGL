package fe.mmm.qw.m;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.common.others.IStringUtil;
import com.tera.scan.webview.ICookiesSyncable;
import fe.mmm.qw.rg.ad.ad;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

public final class uk implements ICookiesSyncable {
    public final Context qw;

    public uk(Context context) {
        this.qw = context;
    }

    public final void ad(CookieManager cookieManager, String str) {
        String qw2 = i.qw();
        String ad2 = i.ad();
        Iterator<String> it = ad.qw().iterator();
        while (it.hasNext()) {
            String next = it.next();
            cookieManager.setCookie(IStringUtil.CURRENT_PATH + next, qw2);
            cookieManager.setCookie("www." + next, ad2);
        }
        String yj2 = ad.yj();
        cookieManager.setCookie(IStringUtil.CURRENT_PATH + yj2, qw2);
        cookieManager.setCookie("www." + yj2, ad2);
        try {
            cookieManager.setCookie(new URL(str).getHost(), "HTTPOnly");
        } catch (MalformedURLException unused) {
            cookieManager.setCookie(str, "HTTPOnly");
        }
        CookieSyncManager.getInstance().sync();
    }

    public void qw(String str) {
        CookieSyncManager.createInstance(this.qw);
        CookieManager instance = CookieManager.getInstance();
        instance.setAcceptCookie(true);
        instance.removeSessionCookie();
        ad(instance, str);
    }
}
