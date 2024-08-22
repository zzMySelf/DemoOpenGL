package com.baidu.sapi2.activity.social;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.social.SocialLoginBase;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.StatService;
import com.baidu.sapi2.utils.ThirdPartyUtil;
import com.baidu.sapi2.utils.enums.SocialType;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;

public class WXLoginActivity extends BaseSSOLoginActivity {
    public static String A = null;
    public static boolean B = false;
    public static final String u = WXLoginActivity.class.getSimpleName();
    public static final String v = "from_wx_auth";
    public static final String w = "state";
    public static final String x = "code";
    public static final String y = "error_code";
    public static int z;
    public String r;
    public String s;
    public int t;

    public class a implements b {
        public a() {
        }

        public void a() {
            Toast.makeText(WXLoginActivity.this, "微信未安装", 1).show();
            WXLoginActivity.this.a(WXLoginActivity.z);
        }

        public void onFinish() {
            Log.d(WXLoginActivity.u, "initView onFinish: ");
            WXLoginActivity.this.finish();
        }
    }

    public interface b {
        void a();

        void onFinish();
    }

    private void b(int i2, Intent intent) {
        String str = u;
        Log.d(str, "setInvokeResult: 3: " + i2);
        if (SocialLoginBase.getWXinvokeCallback() != null) {
            SocialLoginBase.getWXinvokeCallback().onResult(i2, intent);
        }
    }

    private void e() {
        String str;
        this.g = z;
        this.d = A;
        this.e = B;
        A = null;
        B = false;
        this.s = getIntent().getStringExtra("code");
        this.r = getIntent().getStringExtra(w);
        int intExtra = getIntent().getIntExtra(y, -1);
        this.t = intExtra;
        if (this.e) {
            String str2 = u;
            Log.d(str2, "handleWxResp mIsVerification" + this.s);
            Intent intent = new Intent();
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_AUTHORIZATION_CODE, this.s);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_CODE, String.valueOf(SocialType.WEIXIN.getType()));
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_TYPE_NAME, ThirdPartyUtil.TYPE_WEIXIN);
            intent.putExtra(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, SapiAccountManager.getInstance().getConfignation().wxAppID);
            a(4001, intent);
            finish();
        } else if (intExtra == 0) {
            Log.d(u, "handleWxResp: ERR_OK: 0");
            HashMap hashMap = new HashMap();
            hashMap.put("wxRespCode", this.s);
            hashMap.put("wxRespState", this.r);
            StatService.onEventAutoStat("third_login_wx_result", hashMap);
            if (TextUtils.equals(ThirdPartyUtil.wxAuthCodeMap.get(this.s), this.r)) {
                Log.d(u, "handleWxResp: + 已经请求");
                return;
            }
            ThirdPartyUtil.wxAuthCodeMap.put(this.s, this.r);
            WebSocialLoginDTO socialLoginDTO = CoreViewRouter.getInstance().getSocialLoginDTO();
            SapiConfiguration sapiConfiguration = this.configuration;
            String str3 = this.s;
            String str4 = this.r;
            boolean z2 = socialLoginDTO != null && socialLoginDTO.needBpPush;
            if (socialLoginDTO == null) {
                str = "";
            } else {
                str = socialLoginDTO.pushBpFrom;
            }
            String urlWeixinBind = ParamsUtil.getUrlWeixinBind(sapiConfiguration, str3, str4, z2, str, false);
            Log.d(u, "handleWxResp: + 授权微信账号登录中");
            a(urlWeixinBind, "授权微信账号登录中");
        } else {
            a(z);
        }
    }

    private void f() {
        Log.d(u, "initView: ");
        setupViews();
        setTitleText("微信账号登录");
        RelativeLayout relativeLayout = this.rootView;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
        if (!getIntent().getBooleanExtra(v, false)) {
            Log.d(u, "initView: 首次调起");
            z = getIntent().getIntExtra(BaseActivity.EXTRA_PARAM_BUSINESS_FROM, 2001);
            A = this.d;
            B = this.e;
            a((b) new a());
            return;
        }
        Log.d(u, "initView: 微信授权完成之后");
        e();
    }

    public void a(int i2) {
        super.a(i2);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f();
    }

    public void setPageAnim(boolean z2) {
    }

    public void a(int i2, Intent intent) {
        String str = u;
        Log.d(str, "setActivtyResult 2: " + i2);
        super.a(i2, intent);
        b(i2, intent);
    }

    public void b(int i2) {
        String str = u;
        Log.d(str, "setActivtyResult 1: " + i2);
        super.b(i2);
        b(i2, (Intent) null);
    }

    private void a(b bVar) {
        try {
            Log.d(u, "requestWXLogin: ");
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.configuration.context, this.configuration.wxAppID);
            if (!createWXAPI.isWXAppInstalled()) {
                bVar.a();
                return;
            }
            bVar.onFinish();
            SendAuth.Req req = new SendAuth.Req();
            req.scope = "snsapi_userinfo";
            createWXAPI.sendReq(req);
        } catch (Exception e) {
            Log.e(u, "requestWXLogin: ", e);
            e.printStackTrace();
            finish();
        }
    }
}
