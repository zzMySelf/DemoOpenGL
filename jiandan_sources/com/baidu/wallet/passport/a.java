package com.baidu.wallet.passport;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.apollon.utils.JsonUtils;
import com.baidu.wallet.api.BaiduWalletDelegate;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.core.Domains;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

public class a {
    public static final String[] a = {"dxmpay.com", "duxiaoman.com", "baifubao.com", "8.baidu.com", "wallet.baidu.com", "umoney.baidu.com", "icash.baidu.com", "yqh.baidu.com", "ibeauty.baidu.com", "front.baidu.com", "activity8.baidu.com", "qianbao.baidu.com", "dxmbaoxian.com", "oneicash.baidu.com", "twoicash.baidu.com", "threeicash.baidu.com", "onejin.baidu.com", "twojin.baidu.com", "threejin.baidu.com", "dxmcash.baidu.com", "dxmoney.baidu.com", "fincash.baidu.com", "www.baiyingfund.com", "www.duxiaomanfund.com"};
    public static final int b = 8;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 5;

    /* renamed from: i  reason: collision with root package name */
    public static final int f3589i = 10;
    public Context c;
    public String d;
    public ThreadPoolExecutor e;

    /* renamed from: com.baidu.wallet.passport.a$a  reason: collision with other inner class name */
    public static class C0160a {
        public static final a a = new a();
    }

    private void a(int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(1, i2);
        Date time = instance.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        this.d = simpleDateFormat.format(time);
        LogUtil.d("--DxmCookieManager---cookie----expires--->" + this.d);
    }

    public void b() {
        a(-8, "");
    }

    public a() {
        this.c = BaiduWalletDelegate.getInstance().getAppContext();
    }

    private String[] b(String str) {
        try {
            return (String[]) JsonUtils.fromJson(str, String[].class);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static a a() {
        return C0160a.a;
    }

    public void a(String str) {
        a(8, str);
    }

    private void a(int i2, String str) {
        try {
            a(i2);
            String[] b2 = b(SdkInitResponse.getInstance().getCookiesSyncDomainList(this.c));
            if (b2 == null) {
                LogUtil.d("Cookie", "use default: " + Arrays.toString(a));
                b2 = a;
            }
            CookieSyncManager.createInstance(this.c);
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            String str2 = "OPENBDUSS=" + str;
            String str3 = ";expires=" + this.d;
            LogUtil.d("------------------DxmCookieManager start setCookie--------------");
            int length = b2.length;
            for (int i3 = 0; i3 < length; i3++) {
                String str4 = b2[i3];
                if (!str4.startsWith(IStringUtil.CURRENT_PATH)) {
                    str4 = IStringUtil.CURRENT_PATH + str4;
                }
                if (!WalletLoginHelper.getInstance().isDxmLogin() || !WalletLoginHelper.getInstance().isDxmPassportLogin() || !TextUtils.equals(Domains.DU_XIAO_MAN, str4)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    sb.append(";path=/");
                    sb.append(str3);
                    sb.append(";domain=");
                    sb.append(str4);
                    sb.append(";httponly");
                    sb.append(";secure");
                    LogUtil.d("---DxmCookieManager---setCookie value--->" + sb.toString());
                    instance.setCookie("https://www" + str4, sb.toString());
                }
            }
            a(instance);
        } catch (Exception e2) {
            LogUtil.d(e2.getMessage());
        }
    }

    private void a(final CookieManager cookieManager) {
        if (this.e == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());
            this.e = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        this.e.execute(new Runnable() {
            public void run() {
                synchronized (a.class) {
                    if (Build.VERSION.SDK_INT < 21) {
                        CookieSyncManager.getInstance().sync();
                    } else if (cookieManager != null) {
                        cookieManager.flush();
                    }
                }
            }
        });
    }
}
