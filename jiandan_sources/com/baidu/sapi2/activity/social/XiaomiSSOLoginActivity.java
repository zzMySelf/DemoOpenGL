package com.baidu.sapi2.activity.social;

import android.accounts.OperationCanceledException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.baidu.aiscan.R;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.enums.SocialType;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import java.util.HashMap;

public class XiaomiSSOLoginActivity extends BaseSSOLoginActivity {
    public Thread r;
    public c s;

    public class b implements Runnable {
        public final /* synthetic */ XiaomiOAuthFuture a;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                XiaomiSSOLoginActivity.this.s.a();
            }
        }

        /* renamed from: com.baidu.sapi2.activity.social.XiaomiSSOLoginActivity$b$b  reason: collision with other inner class name */
        public class C0037b implements Runnable {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public C0037b(String str, String str2, String str3) {
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            public void run() {
                XiaomiSSOLoginActivity.this.s.a(this.a, this.b, this.c);
            }
        }

        public class c implements Runnable {
            public c() {
            }

            public void run() {
                XiaomiSSOLoginActivity.this.s.a();
            }
        }

        public b(XiaomiOAuthFuture xiaomiOAuthFuture) {
            this.a = xiaomiOAuthFuture;
        }

        public void run() {
            try {
                XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) this.a.getResult();
                if (xiaomiOAuthResults.hasError()) {
                    new Handler(Looper.getMainLooper()).post(new a());
                    return;
                }
                new Handler(Looper.getMainLooper()).post(new C0037b(xiaomiOAuthResults.getCode(), xiaomiOAuthResults.getMacKey(), xiaomiOAuthResults.getMacAlgorithm()));
            } catch (OperationCanceledException e) {
                new Handler(Looper.getMainLooper()).post(new c());
                Log.e(e);
            } catch (Exception e2) {
                Log.e(e2);
            }
        }
    }

    public interface c {
        void a();

        void a(String str, String str2, String str3);
    }

    public void finish() {
        super.finish();
        Thread thread = this.r;
        if (thread != null && thread.isAlive()) {
            this.r.interrupt();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setupViews();
    }

    public void setupViews() {
        super.setupViews();
        setTitleText((int) R.string.sapi_sdk_title_login_xiaomi);
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        this.s = new a();
        try {
            d();
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
    }

    private void d() {
        Thread thread = new Thread(new b(new XiaomiOAuthorize().setAppId(this.configuration.xiaomiAppID.longValue()).setUseSystemAccountLogin(true).setScope(new int[]{1, 3}).setRedirectUrl(this.configuration.xiaomiRedirectUri).startGetOAuthCode(this)));
        this.r = thread;
        thread.start();
    }

    public class a implements c {
        public a() {
        }

        public void a(String str, String str2, String str3) {
            if (XiaomiSSOLoginActivity.this.sapiWebView != null) {
                SapiConfiguration b = XiaomiSSOLoginActivity.this.configuration;
                SocialType socialType = SocialType.XIAOMI;
                String urlBind = ParamsUtil.getUrlBind(b, socialType, "", str2, XiaomiSSOLoginActivity.this.configuration.xiaomiAppID + "");
                HashMap hashMap = new HashMap();
                hashMap.put("code", str);
                hashMap.put(SapiUtils.KEY_QR_LOGIN_REDIRECT_URI, XiaomiSSOLoginActivity.this.configuration.xiaomiRedirectUri);
                XiaomiSSOLoginActivity.this.a(ParamsUtil.addExtras(urlBind, hashMap), "小米授权登录中");
            }
        }

        public void a() {
            XiaomiSSOLoginActivity xiaomiSSOLoginActivity = XiaomiSSOLoginActivity.this;
            xiaomiSSOLoginActivity.a(xiaomiSSOLoginActivity.g);
        }
    }
}
