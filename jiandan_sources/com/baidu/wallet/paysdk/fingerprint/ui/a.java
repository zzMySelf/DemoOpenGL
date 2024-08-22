package com.baidu.wallet.paysdk.fingerprint.ui;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.b;
import com.baidu.wallet.paysdk.fingerprint.bean.FingerprintBeanFactory;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.core.utils.AnimUtils;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.security.KeyStoreException;

@RequiresApi(api = 23)
public class a extends DialogFragment implements b {
    public static final String a = a.class.getSimpleName();
    public LayoutInflater b;
    public Activity c;
    public ViewGroup d;
    public TextView e;
    public Button f;
    public Button g;
    public com.baidu.wallet.paysdk.fingerprint.b.a h;

    /* renamed from: i  reason: collision with root package name */
    public FingerprintCallback f3600i;
    public int j;
    public IFingerprintPay.Action k;
    public String l;

    public void onAttach(Activity activity) {
        this.c = activity;
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, ResUtils.style(this.c, "EbpayPromptDialog"));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        getDialog().requestWindowFeature(1);
        LayoutInflater from = LayoutInflater.from(this.c);
        this.b = from;
        ViewGroup viewGroup2 = (ViewGroup) from.inflate(ResUtils.layout(this.c, "wallet_cashdesk_fingerprint_dialog"), (ViewGroup) null);
        this.d = viewGroup2;
        this.f = (Button) viewGroup2.findViewById(ResUtils.id(this.c, "negative_btn"));
        this.g = (Button) this.d.findViewById(ResUtils.id(this.c, "positive_btn"));
        this.e = (TextView) this.d.findViewById(ResUtils.id(this.c, "fingerprint_title"));
        getDialog().setCanceledOnTouchOutside(false);
        setCancelable(false);
        this.f.setVisibility(8);
        this.g.setVisibility(0);
        a(this.g);
        this.g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StatHelper.cachePayWay(1);
                a.this.b();
                a.this.h.a();
                if (a.this.f3600i != null) {
                    a.this.f3600i.onAuthorizeResult(a.this.k, 1, "cancle");
                }
                a.this.dismissAllowingStateLoss();
            }
        });
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (PayDataCache.getInstance().isPaySettingOpenFingerprintPay()) {
            PayDataCache.getInstance().setPaySettingOpenFingerprintPay(false);
            str = ResUtils.getString(this.c, "wallet_fp_open_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 3) {
            str = ResUtils.getString(this.c, "wallet_fp_upgrade_content");
        } else if (payRequest != null && payRequest.FP_Guide_Strategy == 2) {
            str = ResUtils.getString(this.c, "wallet_fp_reopen_content");
        } else if (payRequest == null || payRequest.FP_Guide_Strategy != 1) {
            str = ResUtils.getString(this.c, "wallet_fp_bdwallet_fingerprintpay");
        } else {
            str = ResUtils.getString(this.c, "wallet_fp_open_content");
        }
        this.e.setText(str);
        return this.d;
    }

    public void onDestroy() {
        super.onDestroy();
        this.c = null;
        com.baidu.wallet.paysdk.fingerprint.b.a aVar = this.h;
        if (aVar != null) {
            aVar.d();
            this.h = null;
        }
        this.d = null;
        this.f3600i = null;
        this.b = null;
    }

    public void onPause() {
        super.onPause();
        this.h.a();
    }

    public void onResume() {
        super.onResume();
        this.h.a(this.j);
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.j == 1) {
            final com.baidu.wallet.paysdk.fingerprint.bean.a aVar = (com.baidu.wallet.paysdk.fingerprint.bean.a) FingerprintBeanFactory.getInstance().getBean((Context) this.c, (int) FingerprintBeanFactory.BEAN_ID_SYS_FINGERPRINT_CLOSE, a);
            aVar.a(this.l);
            aVar.setResponseCallback(new IBeanResponseCallback() {
                public void onBeanExecFailure(int i2, int i3, String str) {
                    String unused = a.a;
                    aVar.destroyBean();
                    StatisticManager.onEvent("fp_close_system_failed_after_get_otptoken");
                }

                public void onBeanExecSuccess(int i2, Object obj, String str) {
                    String unused = a.a;
                    aVar.destroyBean();
                }
            });
            aVar.execBean();
        }
    }

    public static a a(Activity activity, int i2, String str, FingerprintCallback fingerprintCallback) throws KeyStoreException {
        a aVar = new a();
        if (i2 != 1 || !TextUtils.isEmpty(str)) {
            if (i2 == 1) {
                aVar.k = IFingerprintPay.Action.OPEN;
                aVar.l = SecurePay.getInstance().localDecrypt1(str.split("\\|")[0]);
            } else {
                aVar.k = IFingerprintPay.Action.VERIFY;
            }
            com.baidu.wallet.paysdk.fingerprint.b.a aVar2 = new com.baidu.wallet.paysdk.fingerprint.b.a(activity.getApplicationContext());
            aVar.h = aVar2;
            aVar2.a((b) aVar);
            aVar.h.a(str);
            aVar.j = i2;
            aVar.f3600i = fingerprintCallback;
            aVar.c = activity;
            return aVar;
        }
        throw new IllegalArgumentException(" operaterData cannot be null when openning fingerprintpay !");
    }

    private void a(Button button) {
        View findViewById = this.d.findViewById(ResUtils.id(button.getContext(), "btn_line"));
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        button.setBackgroundDrawable(ResUtils.getDrawable(button.getContext(), "dxm_wallet_base_dialog_btn_selector"));
        button.setText("取消");
        TextPaint paint = button.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
    }

    public void a(int i2, String str) {
        if (i2 == 0) {
            FingerprintCallback fingerprintCallback = this.f3600i;
            if (fingerprintCallback != null) {
                fingerprintCallback.onAuthorizeResult(this.k, 0, str);
            }
            this.f3600i = null;
            dismissAllowingStateLoss();
        } else if (i2 == -3) {
            StatisticManager.onEvent("fp_fingerprint_changed");
            b();
            FingerprintCallback fingerprintCallback2 = this.f3600i;
            if (fingerprintCallback2 != null) {
                fingerprintCallback2.onAuthorizeResult(this.k, 2, str);
            }
            this.f3600i = null;
            dismissAllowingStateLoss();
        } else if (i2 == -6 || i2 == -4) {
            if (i2 == -4) {
                StatisticManager.onEvent("fp_verify_error_3_times_auto_changeto_pwdpay");
            } else {
                StatisticManager.onEvent("fp_verify_error_fingerprint_setdisable_fp_serval_seconds");
            }
            b();
            FingerprintCallback fingerprintCallback3 = this.f3600i;
            if (fingerprintCallback3 != null) {
                fingerprintCallback3.onAuthorizeResult(this.k, 2, str);
            }
            this.f3600i = null;
            dismissAllowingStateLoss();
        } else if (i2 == -1) {
            if (this.f3600i != null) {
                b();
                this.f3600i.onAuthorizeResult(this.k, 2, "");
            }
            this.f3600i = null;
            dismissAllowingStateLoss();
        } else if (i2 == -5) {
            if (this.j == 1) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(ResUtils.getString(this.c, "wallet_cashdesk_pwd_pay"));
            }
            this.f.setVisibility(0);
            a(this.f);
            this.e.setVisibility(0);
            this.e.setText(str);
            AnimUtils.startSharkAnim(this.e);
            this.g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StatisticManager.onEvent("fp_error_fingerprint_click_pwdpay");
                    if (a.this.f3600i != null) {
                        a.this.f3600i.onAuthorizeResult(a.this.k, 3, "");
                    }
                    FingerprintCallback unused = a.this.f3600i = null;
                    a.this.dismissAllowingStateLoss();
                }
            });
            this.f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.b();
                    if (a.this.f3600i != null) {
                        a.this.f3600i.onAuthorizeResult(a.this.k, 1, "");
                    }
                    FingerprintCallback unused = a.this.f3600i = null;
                    a.this.dismissAllowingStateLoss();
                }
            });
        } else if (i2 == -7) {
            FingerprintCallback fingerprintCallback4 = this.f3600i;
            if (fingerprintCallback4 != null) {
                fingerprintCallback4.onAuthorizeResult(this.k, -7, str);
            }
            this.f3600i = null;
            dismissAllowingStateLoss();
        } else if (i2 == -8) {
            FingerprintCallback fingerprintCallback5 = this.f3600i;
            if (fingerprintCallback5 != null) {
                fingerprintCallback5.onAuthorizeResult(this.k, 1, "");
            }
            this.f3600i = null;
            dismissAllowingStateLoss();
        } else {
            b();
            FingerprintCallback fingerprintCallback6 = this.f3600i;
            if (fingerprintCallback6 != null) {
                fingerprintCallback6.onAuthorizeResult(this.k, 2, "");
            }
            this.f3600i = null;
            dismissAllowingStateLoss();
        }
    }
}
