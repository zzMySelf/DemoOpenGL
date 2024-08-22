package com.baidu.wallet.paysdk.fingerprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.fingerprint.FingerprintCallback;
import com.baidu.wallet.paysdk.fingerprint.IFingerprintPay;
import com.baidu.wallet.paysdk.fingerprint.WalletFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.H5ResultParams;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.CashierDeskPayResult;
import com.baidu.wallet.paysdk.payresult.view.WalletPayResultCommonActivity;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.utils.CheckUtils;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.Map;

public class FingerprintOpenGuideActivity extends HalfScreenBaseActivity implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public Button c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public PayController.PayResultWrapper h;

    public void addContentView() {
        this.mContentView = (ViewGroup) View.inflate(this, ResUtils.layout(getActivity(), "wallet_fingerprint_open_guide"), (ViewGroup) null);
        this.mContentView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.mHalfScreenContainer.addView(this.mContentView);
    }

    public void onBackPressed() {
        StatHelper.cacheCodeAndMsg(StatHelper.SENSOR_ERR_2, "FingerprintOpenGuideCancel");
    }

    public void onClick(View view) {
        if (!CheckUtils.isFastDoubleClick()) {
            if (view == this.c) {
                final PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                final IFingerprintPay fingerprintPay = WalletFingerprint.getInstance(getActivity()).getFingerprintPay(WalletFingerprint.FpType.SYSTEM_FINGERPRINT);
                if (payRequest != null && fingerprintPay != null) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.FP_OPEN_START);
                    StatisticManager.onEventStart(PayStatServiceEvent.PAY_OPEN_FINGERPRINT_DURATION);
                    fingerprintPay.open(getActivity(), new FingerprintCallback() {
                        public void onAuthorizeResult(IFingerprintPay.Action action, int i2, String str) {
                            if (i2 == 0) {
                                StatHelper.cacheCodeAndMsg(i2 + "", StatHelper.SENSOR_OK);
                            } else {
                                StatHelper.cacheCodeAndMsg(i2 + "", str);
                            }
                            if (i2 == 0) {
                                int i3 = payRequest.FP_Guide_Strategy;
                                if (i3 == 1) {
                                    GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_open_success"));
                                    StatHelper.statServiceEvent("fp_open_success");
                                } else if (i3 == 2) {
                                    GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_reopen_success"));
                                    StatHelper.statServiceEvent("fp_reopen_success");
                                } else if (i3 == 3) {
                                    GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_upgrade_success"));
                                    StatHelper.statServiceEvent("fp_upgrade_success");
                                }
                                FingerprintOpenGuideActivity.this.c.postDelayed(new Runnable() {
                                    public void run() {
                                        FingerprintOpenGuideActivity.this.c();
                                    }
                                }, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
                                FingerprintOpenGuideActivity.this.c.setClickable(false);
                                FingerprintOpenGuideActivity.this.mRightTxt.setClickable(false);
                            } else if (i2 == 2) {
                                if (TextUtils.isEmpty(str)) {
                                    int i4 = payRequest.FP_Guide_Strategy;
                                    if (i4 == 1) {
                                        StatHelper.statServiceEvent("fp_open_failed");
                                        str = ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_open_failed");
                                    } else if (i4 == 2) {
                                        str = ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_reopen_failed");
                                        StatHelper.statServiceEvent("fp_reopen_failed");
                                    } else if (i4 != 3) {
                                        str = "";
                                    } else {
                                        str = ResUtils.getString(FingerprintOpenGuideActivity.this.getActivity(), "wallet_fp_upgrade_failed");
                                        StatHelper.statServiceEvent("fp_upgrade_failed");
                                    }
                                }
                                GlobalUtils.toast(FingerprintOpenGuideActivity.this.getActivity(), str);
                                FingerprintOpenGuideActivity.this.c.postDelayed(new Runnable() {
                                    public void run() {
                                        FingerprintOpenGuideActivity.this.c();
                                    }
                                }, ItemTouchHelper.Callback.DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS);
                                FingerprintOpenGuideActivity.this.c.setClickable(false);
                                FingerprintOpenGuideActivity.this.mRightTxt.setClickable(false);
                            } else if (i2 == 1) {
                                int i5 = payRequest.FP_Guide_Strategy;
                                if (i5 == 1) {
                                    StatHelper.statServiceEvent("fp_open_cancle");
                                } else if (i5 == 2) {
                                    StatHelper.statServiceEvent("fp_reopen_cancle");
                                } else if (i5 == 3) {
                                    StatHelper.statServiceEvent("fp_upgrade_cancle");
                                }
                            }
                            fingerprintPay.destory();
                        }
                    }, false);
                }
            } else if (view == this.mRightTxt) {
                StatHelper.statServiceEvent(PayStatServiceEvent.FP_OPEN_SKIP);
                c();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            Serializable serializable = bundle.getSerializable("payresultwrapper");
            if (serializable instanceof PayController.PayResultWrapper) {
                this.h = (PayController.PayResultWrapper) serializable;
            }
        } else {
            Intent intent = getIntent();
            if (intent != null && (intent.getSerializableExtra("payresultwrapper") instanceof PayController.PayResultWrapper)) {
                this.h = (PayController.PayResultWrapper) intent.getSerializableExtra("payresultwrapper");
            }
        }
        if (this.h == null) {
            PayBaseBeanActivity.exitEbpay();
            finish();
        }
        a();
        b();
    }

    public void onDestroy() {
        super.onDestroy();
        StatHelper.payEventEndWithValues(PayStatServiceEvent.PAY_OPEN_FINGERPRINT_DURATION, (Map<String, Object>) null, new String[0]);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("payresultwrapper", this.h);
    }

    public void showPaySuccessPage(boolean z, PayResultContent payResultContent, int i2) {
    }

    private void a() {
        this.mLeftImg.setVisibility(4);
        this.a = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_title"));
        this.b = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_subtitle"));
        this.d = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_hint1"));
        this.e = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_hint2"));
        this.mRightTxt.setTextColor(ResUtils.getColor(this, "wallet_base_primary_color"));
        this.mRightTxt.setText(ResUtils.getString(this, "wallet_base_skip"));
        this.mRightTxt.setOnClickListener(this);
        Button button = (Button) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_open_btn"));
        this.c = button;
        button.setOnClickListener(this);
        this.f = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_protocol_prefix"));
        this.g = (TextView) this.mContentView.findViewById(ResUtils.id(this, "fingerprint_protocol_msg"));
    }

    private void b() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String string;
        String str7;
        String string2;
        String str8;
        PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        final UserData.UserModel.FingerprintMsg fingerprintMsg = PayDataCache.getInstance().getFingerprintMsg();
        if (payRequest != null) {
            int i2 = payRequest.FP_Guide_Strategy;
            String str9 = "";
            String[] strArr = null;
            if (i2 == 1) {
                StatisticManager.onEvent("fp_guide_show_open_system_fingerprint_dialog");
                if (fingerprintMsg == null || fingerprintMsg.getOpen() == null || TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                    str8 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide");
                } else {
                    str8 = fingerprintMsg.getOpen().getTitle();
                }
                str9 = str8;
                if (fingerprintMsg == null || fingerprintMsg.getOpen() == null || TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                    str2 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_subtitle");
                } else {
                    str2 = fingerprintMsg.getOpen().getSubtitle();
                }
                String string3 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_btn");
                String[] strArr2 = fingerprintMsg != null ? fingerprintMsg.getOpen().hints : new String[]{ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0"), ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1")};
                if (fingerprintMsg == null || fingerprintMsg.getOpen() == null || fingerprintMsg.getOpen().getFingerprintProtocol() == null || TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolPrefix()) || TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolMsg()) || TextUtils.isEmpty(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolUrl())) {
                    this.g.setVisibility(8);
                    this.f.setVisibility(8);
                } else {
                    this.f.setText(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolPrefix());
                    this.g.setText(fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolMsg());
                    this.g.setVisibility(0);
                    this.f.setVisibility(0);
                    this.g.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            BaiduWalletDelegate.getInstance().openH5Module(FingerprintOpenGuideActivity.this, fingerprintMsg.getOpen().getFingerprintProtocol().getFingerprintProtocolUrl(), false);
                        }
                    });
                }
                str = string3;
                strArr = strArr2;
            } else if (i2 == 2) {
                StatHelper.statServiceEvent("fp_show_reopen_system_dialog");
                if (fingerprintMsg == null || fingerprintMsg.getReopen() == null || TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                    str7 = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide");
                } else {
                    str7 = fingerprintMsg.getReopen().getTitle();
                }
                str9 = str7;
                if (fingerprintMsg == null || fingerprintMsg.getReopen() == null || TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                    string2 = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide_subtitle");
                } else {
                    string2 = fingerprintMsg.getReopen().getSubtitle();
                }
                String string4 = ResUtils.getString(this, "bd_wallet_fingerprint_reopen_guide_btn");
                if (fingerprintMsg == null || fingerprintMsg.getReopen() == null || fingerprintMsg.getReopen().getFingerprintProtocol() == null || TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolPrefix()) || TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolMsg()) || TextUtils.isEmpty(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolUrl())) {
                    this.g.setVisibility(8);
                    this.f.setVisibility(8);
                } else {
                    this.f.setText(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolPrefix());
                    this.g.setText(fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolMsg());
                    this.g.setVisibility(0);
                    this.f.setVisibility(0);
                    this.g.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            BaiduWalletDelegate.getInstance().openH5Module(FingerprintOpenGuideActivity.this, fingerprintMsg.getReopen().getFingerprintProtocol().getFingerprintProtocolUrl(), false);
                        }
                    });
                }
                str = string4;
            } else if (i2 == 3) {
                StatisticManager.onEvent("fp_show_upgrade_system_dialog");
                if (fingerprintMsg == null || fingerprintMsg.getUpdate() == null || TextUtils.isEmpty(fingerprintMsg.getOpen().getTitle())) {
                    str6 = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide");
                } else {
                    str6 = fingerprintMsg.getUpdate().getTitle();
                }
                str9 = str6;
                if (fingerprintMsg == null || fingerprintMsg.getUpdate() == null || TextUtils.isEmpty(fingerprintMsg.getOpen().getSubtitle())) {
                    string = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide_subtitle");
                } else {
                    string = fingerprintMsg.getUpdate().getSubtitle();
                }
                str = ResUtils.getString(this, "bd_wallet_fingerprint_upgrade_guide_btn");
            } else {
                str2 = str9;
                str = str2;
            }
            this.a.setText(str9);
            this.b.setText(str2);
            this.c.setText(str);
            if (strArr == null || strArr.length <= 0) {
                this.d.setVisibility(8);
                this.e.setVisibility(8);
                return;
            }
            this.d.setVisibility(0);
            this.e.setVisibility(0);
            if (strArr.length == 1) {
                TextView textView = this.d;
                if (!TextUtils.isEmpty(strArr[0])) {
                    str5 = strArr[0];
                } else {
                    str5 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0");
                }
                textView.setText(str5);
                this.e.setText(ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1"));
            } else if (strArr.length >= 2) {
                TextView textView2 = this.d;
                if (!TextUtils.isEmpty(strArr[0])) {
                    str3 = strArr[0];
                } else {
                    str3 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint0");
                }
                textView2.setText(str3);
                TextView textView3 = this.e;
                if (!TextUtils.isEmpty(strArr[1])) {
                    str4 = strArr[1];
                } else {
                    str4 = ResUtils.getString(this, "bd_wallet_fingerprint_open_guide_hint1");
                }
                textView3.setText(str4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        PayController.PayResultWrapper payResultWrapper = this.h;
        if (payResultWrapper.payResult == 0) {
            PayResultContent payResultContent = payResultWrapper.payResultContent;
            if (payResultContent != null) {
                payResultContent.isPaySuccess = true;
            }
            PayDataCache.getInstance().setPayReslutContent(payResultContent);
            H5ResultParams h5ResultParams = PayDataCache.getInstance().getH5ResultParams();
            if (h5ResultParams == null || !h5ResultParams.toShowH5ResultPage()) {
                PayDataCache.getInstance().setPayReslutContent(payResultContent);
                Bundle bundle = new Bundle();
                bundle.putInt(DxmPayBeanConstants.KEY_PAY_RESULT_TYPE, this.h.payResultType);
                startActivityWithExtras(bundle, WalletPayResultCommonActivity.class);
                PayBaseBeanActivity.exitEbpay();
                return;
            }
            CashierDeskPayResult cashierDeskPayResult = new CashierDeskPayResult(getActivity(), h5ResultParams);
            cashierDeskPayResult.beforeShow();
            cashierDeskPayResult.show();
        }
    }
}
