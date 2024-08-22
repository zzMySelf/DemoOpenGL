package com.baidu.sapi2.views.logindialog.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.dto.WebLoginDTO;
import com.baidu.sapi2.dto.WebSocialLoginDTO;
import com.baidu.sapi2.enums.LoginTypes;
import com.baidu.sapi2.shell.listener.ThirdLoginCallback;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.utils.enums.FastLoginFeature;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import java.util.ArrayList;
import java.util.List;

public class ThirdPartyView extends LinearLayout implements View.OnClickListener {
    public Context a;
    public ImageView b;
    public ImageView c;
    public ImageView d;
    public ImageView e;
    public ImageView f;
    public ImageView g;
    public ImageView h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f987i;
    public ImageView j;
    public ImageView k;
    public ImageView l;
    public LinearLayout m;
    public ILoginConfirmCallback n;

    /* renamed from: o  reason: collision with root package name */
    public QuickLoginType f988o;
    public QuickLoginType p;

    public class a implements Runnable {
        public final /* synthetic */ WebSocialLoginDTO a;

        /* renamed from: com.baidu.sapi2.views.logindialog.view.ThirdPartyView$a$a  reason: collision with other inner class name */
        public class C0047a extends ThirdLoginCallback {
            public final /* synthetic */ long a;

            public C0047a(long j) {
                this.a = j;
            }

            public void onFailure(WebAuthResult webAuthResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a(ThirdPartyView.this.f988o.getValue(), System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                if (ThirdPartyView.this.n != null) {
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(webAuthResult.getResultCode());
                    quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                    quickLoginResult.mLoginType = ThirdPartyView.this.f988o;
                    ThirdPartyView.this.n.onFailure(quickLoginResult);
                }
            }

            public void onSuccess(WebAuthResult webAuthResult) {
                com.baidu.sapi2.views.logindialog.utils.a.a(ThirdPartyView.this.f988o.getValue(), System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                if (ThirdPartyView.this.n != null) {
                    QuickLoginResult quickLoginResult = new QuickLoginResult();
                    quickLoginResult.setResultCode(webAuthResult.getResultCode());
                    quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                    quickLoginResult.mLoginType = ThirdPartyView.this.f988o;
                    ThirdPartyView.this.n.onSuccess(quickLoginResult);
                }
            }
        }

        public a(WebSocialLoginDTO webSocialLoginDTO) {
            this.a = webSocialLoginDTO;
        }

        public void run() {
            CoreViewRouter.getInstance().loadThirdPartyLogin((WebAuthListener) new C0047a(System.currentTimeMillis()), this.a);
        }
    }

    public class b extends WebAuthListener {
        public final /* synthetic */ long a;

        public b(long j) {
            this.a = j;
        }

        public void onFailure(WebAuthResult webAuthResult) {
            com.baidu.sapi2.views.logindialog.utils.a.a("more_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
            if (ThirdPartyView.this.n != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = ThirdPartyView.this.f988o;
                ThirdPartyView.this.n.onFailure(quickLoginResult);
            }
        }

        public void onSuccess(WebAuthResult webAuthResult) {
            com.baidu.sapi2.views.logindialog.utils.a.a("more_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
            if (ThirdPartyView.this.n != null) {
                QuickLoginResult quickLoginResult = new QuickLoginResult();
                quickLoginResult.setResultCode(webAuthResult.getResultCode());
                quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                quickLoginResult.mLoginType = ThirdPartyView.this.f988o;
                ThirdPartyView.this.n.onSuccess(quickLoginResult);
            }
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType[] r0 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType r1 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.HISTORY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType r1 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.SHARE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.sapi2.views.logindialog.enums.QuickLoginType r1 = com.baidu.sapi2.views.logindialog.enums.QuickLoginType.ONEKEY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.sapi2.views.logindialog.view.ThirdPartyView.c.<clinit>():void");
        }
    }

    public ThirdPartyView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void d() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_threepatry, this);
        this.b = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_wechat);
        this.c = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_qq);
        this.d = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_sina);
        this.e = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_yy);
        this.f = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_huawei);
        this.g = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_honor);
        this.h = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_xiaomi);
        this.f987i = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_meizu);
        this.j = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_dingding);
        this.k = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_oppo);
        this.l = (ImageView) findViewById(R.id.sapi_sdk_iv_third_party_more);
        this.m = (LinearLayout) findViewById(R.id.sapi_sdk_ll_other_login_type_tip);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.f987i.setOnClickListener(this);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        List<FastLoginFeature> thirdPartyConfig = getThirdPartyConfig();
        int min = Math.min(thirdPartyConfig.size(), 5);
        for (int i2 = 0; i2 < min; i2++) {
            FastLoginFeature fastLoginFeature = thirdPartyConfig.get(i2);
            if (fastLoginFeature == FastLoginFeature.TX_WEIXIN_SSO) {
                this.b.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.TX_QQ_SSO) {
                this.c.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.SINA_WEIBO_SSO) {
                this.d.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.YY_SSO) {
                this.e.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.HUAWEI_LOGIN) {
                this.f.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.XIAOMI_SSO) {
                this.h.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.MEIZU_SSO) {
                this.f987i.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.HONOR_LOGIN) {
                this.g.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.DINGDING_SSO) {
                this.j.setVisibility(0);
            } else if (fastLoginFeature == FastLoginFeature.OPPO_SSO) {
                this.k.setVisibility(0);
            }
        }
    }

    private void e() {
        if (this.n != null) {
            WebLoginDTO webLoginDTO = new WebLoginDTO();
            webLoginDTO.config = null;
            QuickLoginType quickLoginType = this.p;
            if (quickLoginType != null) {
                int i2 = c.a[quickLoginType.ordinal()];
                if (i2 == 1) {
                    webLoginDTO.excludeTypes = LoginTypes.HISTORY;
                } else if (i2 == 2) {
                    webLoginDTO.excludeTypes = LoginTypes.SHARE;
                } else if (i2 == 3) {
                    webLoginDTO.excludeTypes = LoginTypes.ONE_KEY_LOGIN;
                }
            }
            CoreViewRouter.getInstance().startLogin(new b(System.currentTimeMillis()), webLoginDTO);
        }
    }

    private List<FastLoginFeature> getThirdPartyConfig() {
        SapiConfiguration confignation;
        ArrayList arrayList = new ArrayList();
        SapiAccountManager instance = SapiAccountManager.getInstance();
        if (instance == null || (confignation = instance.getConfignation()) == null) {
            return arrayList;
        }
        arrayList.addAll(confignation.fastLoginFeatureList);
        return arrayList;
    }

    public void a() {
    }

    public void c() {
        this.m.setVisibility(0);
    }

    public void onClick(View view) {
        WebSocialLoginDTO webSocialLoginDTO = new WebSocialLoginDTO();
        if (view.getId() == R.id.sapi_sdk_iv_third_party_wechat) {
            this.f988o = QuickLoginType.WECHAT;
            webSocialLoginDTO.socialType = SocialType.WEIXIN;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_qq) {
            this.f988o = QuickLoginType.QQ;
            webSocialLoginDTO.socialType = SocialType.QQ_SSO;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_yy) {
            this.f988o = QuickLoginType.YY;
            webSocialLoginDTO.socialType = SocialType.YY;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_sina) {
            this.f988o = QuickLoginType.SINA;
            webSocialLoginDTO.socialType = SocialType.SINA_WEIBO_SSO;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_huawei) {
            this.f988o = QuickLoginType.HUAWEI;
            webSocialLoginDTO.socialType = SocialType.HUAWEI;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_honor) {
            this.f988o = QuickLoginType.HONOR;
            webSocialLoginDTO.socialType = SocialType.HONOR;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_xiaomi) {
            this.f988o = QuickLoginType.XIAOMI;
            webSocialLoginDTO.socialType = SocialType.XIAOMI;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_meizu) {
            this.f988o = QuickLoginType.MEIZU;
            webSocialLoginDTO.socialType = SocialType.MEIZU;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_dingding) {
            this.f988o = QuickLoginType.DINGDING;
            webSocialLoginDTO.socialType = SocialType.DINGDING;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_oppo) {
            this.f988o = QuickLoginType.OPPO;
            webSocialLoginDTO.socialType = SocialType.OPPO;
            a(webSocialLoginDTO);
        } else if (view.getId() == R.id.sapi_sdk_iv_third_party_more) {
            this.f988o = QuickLoginType.FULL_SCREEN;
            e();
        }
    }

    public void setDialogLoginType(QuickLoginType quickLoginType) {
        this.p = quickLoginType;
    }

    public void setLoginCallback(ILoginConfirmCallback iLoginConfirmCallback) {
        this.n = iLoginConfirmCallback;
    }

    public ThirdPartyView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(WebSocialLoginDTO webSocialLoginDTO) {
        ILoginConfirmCallback iLoginConfirmCallback = this.n;
        if (iLoginConfirmCallback != null) {
            iLoginConfirmCallback.onPostLogin(false, new a(webSocialLoginDTO));
        }
    }

    public void b() {
        this.m.setVisibility(8);
    }

    public ThirdPartyView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        d();
    }
}
