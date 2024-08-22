package com.baidu.wallet.paysdk.presenter;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.WalletApiExtListener;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.passport.LoginBackListenerProxy;
import com.dxmpay.wallet.passport.ThirdPartyLoginUtil;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.ArrayList;
import java.util.Map;

public abstract class k implements IBeanResponseCallback {
    public Handler a;
    public PayBaseBeanActivity b;
    public LoginBackListenerProxy c;

    public k(PayBaseBeanActivity payBaseBeanActivity) {
        this.b = payBaseBeanActivity;
    }

    private Handler f() {
        if (this.a == null) {
            this.a = new Handler(this.b.getMainLooper());
        }
        return this.a;
    }

    public abstract Dialog a(int i2);

    public abstract void a();

    public abstract void a(int i2, Dialog dialog);

    public abstract void a(int i2, Object obj, String str);

    public abstract void a(PrecashierCreateOrderResponse precashierCreateOrderResponse);

    public abstract void a(String str);

    public abstract boolean a(Bundle bundle);

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public void e() {
    }

    public void g() {
    }

    public void onBeanExecFailure(final int i2, final int i3, final String str) {
        f().post(new Runnable() {
            public void run() {
                k.this.a(i2, i3, str);
            }
        });
    }

    public void onBeanExecSuccess(final int i2, final Object obj, final String str) {
        f().post(new Runnable() {
            public void run() {
                k.this.a(i2, obj, str);
            }
        });
    }

    public void a(int i2, int i3, String str) {
        if (i3 == 100035 || i3 == 100036) {
            int i4 = 1;
            if (i3 == 100036) {
                i4 = 2;
            }
            StatisticManager.onEventWithValue(PayStatServiceEvent.THIRD_HALF_USER, StatHelper.getOrderNo());
            PassUtil.passNormalized(this.b, str, i4, new PassUtil.PassNormalize() {
                public boolean onNormalize(Context context, int i2, Map<String, String> map) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(StatHelper.getOrderNo());
                    if (map != null) {
                        arrayList.add(map.get("pass_error_code"));
                    } else {
                        arrayList.add("-1");
                    }
                    StatisticManager.onEventWithValues(PayStatServiceEvent.THIRD_HALF_USER_RESULT, arrayList);
                    if (super.onNormalize(context, i2, map)) {
                        k.this.b();
                        return false;
                    }
                    k.this.c();
                    return false;
                }
            });
            return;
        }
        if (i3 == 5003) {
            AccountManager.getInstance(this.b).logout();
            WalletLoginHelper.getInstance().logout(false);
            StatisticManager.onEventWithValue(PayStatServiceEvent.NOT_LOGIN, StatHelper.getOrderNo());
            final ArrayList arrayList = new ArrayList();
            if (WalletLoginHelper.getInstance().isInnerPassLogin()) {
                GlobalUtils.toast(this.b, str);
                this.c = new LoginBackListenerProxy(this.b, new ILoginBackListener() {
                    public void onFail(int i2, String str) {
                        arrayList.add(StatHelper.getOrderNo());
                        ArrayList arrayList = arrayList;
                        arrayList.add(i2 + "");
                        StatisticManager.onEventWithValues("login_result", arrayList);
                        if (i2 == 603) {
                            WalletLoginHelper.getInstance().onlyLogin(k.this.c);
                        }
                    }

                    public void onSuccess(int i2, String str) {
                        arrayList.add(StatHelper.getOrderNo());
                        arrayList.add("0");
                        StatisticManager.onEventWithValues("login_result", arrayList);
                        k.this.b();
                    }
                });
                WalletLoginHelper.getInstance().login(this.c);
                return;
            }
            WalletLoginHelper.getInstance().handlerWalletError(5003);
        } else if (ThirdPartyLoginUtil.getInstance().checkThirdPartyLogin(this.b.getActivity(), i3, str, new WalletApiExtListener.ThirdPartyLoginListener() {
            public void onCallFail(int i2, String str) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(StatHelper.getOrderNo());
                arrayList.add(i2 + "");
                StatisticManager.onEventWithValues(PayStatServiceEvent.THIRD_PARTY_LOGIN_RESULT, arrayList);
                PayCallBackManager.callBackClientCancel(k.this.b.getActivity(), "WelcomeBaseActivity.onPrepareDialog().1");
                k.this.b.finish();
            }

            public void onCallSuccess(int i2, String str) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(StatHelper.getOrderNo());
                arrayList.add("0");
                StatisticManager.onEventWithValues(PayStatServiceEvent.THIRD_PARTY_LOGIN_RESULT, arrayList);
                k.this.b();
            }
        })) {
            StatisticManager.onEventWithValue(PayStatServiceEvent.THIRD_PARTY_LOGIN, StatHelper.getOrderNo());
            return;
        }
        GlobalUtils.toast(this.b, str);
        c();
    }

    public void a(int i2, int i3, String str, Object obj) {
        a(i2, i3, str);
    }
}
