package com.baidu.wallet.newbindcard.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity;
import com.baidu.wallet.paysdk.api.BindCardEntry;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.e;
import com.baidu.wallet.paysdk.datamodel.CardAddErrorContent;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.presenter.k;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.beans.NetworkBean;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b extends k {
    public boolean a = false;
    public String c;

    public b(PayBaseBeanActivity payBaseBeanActivity) {
        super(payBaseBeanActivity);
    }

    public void a(PrecashierCreateOrderResponse precashierCreateOrderResponse) {
    }

    public void a(String str) {
    }

    public boolean a(Bundle bundle) {
        return true;
    }

    public void e() {
    }

    private String f() {
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public void b() {
        StringBuilder sb = new StringBuilder();
        String extraParam = NewBindCardEntry.getInstance().getExtraParam();
        if (!TextUtils.isEmpty(extraParam)) {
            sb.append(extraParam);
            sb.setCharAt(sb.length() - 1, ',');
        } else {
            sb.append(StringUtil.ARRAY_START);
        }
        sb.append("request_type:11}");
        e eVar = new e(this.b);
        eVar.a(NewBindCardEntry.getInstance().getBindReq());
        eVar.a(sb.toString());
        eVar.setResponseCallback(this);
        eVar.execBean();
    }

    public void c() {
        NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "WelcomeActivity callBackCancel", false);
        PayBaseBeanActivity payBaseBeanActivity = this.b;
        if (payBaseBeanActivity != null) {
            payBaseBeanActivity.finishWithoutAnim();
        }
    }

    public void d() {
        PayBaseBeanActivity payBaseBeanActivity = this.b;
        if (payBaseBeanActivity != null) {
            payBaseBeanActivity.setFlagActiveBindCard();
        }
    }

    public void a() {
        b();
    }

    public void a(int i2, Object obj, String str) {
        CardAddResponse.updateContent(obj);
        CardAddResponse cardAddResponse = (CardAddResponse) obj;
        StatHelper.clearSensor();
        if (cardAddResponse != null && this.b != null) {
            String sessionId = NetworkBean.SessionCache.getInstance().getSessionId(NetworkBean.BizType.BindCard);
            StatHelper.cacheSessionId(sessionId);
            UserData.UserModel userModel = cardAddResponse.user;
            if (userModel == null || 1 != userModel.has_mobile_password) {
                StatHelper.cacheBindCardUserType("0");
            } else {
                StatHelper.cacheBindCardUserType("1");
            }
            List<String> collectData = StatHelper.collectData(sessionId, new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.BIND_CARD_USER_TYPE, StatHelper.getBindCardUserType());
            StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, (Collection<String>) collectData, (Map<String, Object>) hashMap);
            this.b.startActivity(new Intent(this.b, NewBindCardEnterActivity.class));
            this.b.finishWithoutAnim();
        }
    }

    public void a(int i2, int i3, String str) {
        this.c = str;
        CardAddResponse.updateContent((Object) null);
        StatHelper.clearSensor();
        String f = f();
        List<String> collectData = StatHelper.collectData(f, "cardAdd is failed");
        HashMap hashMap = new HashMap();
        hashMap.put(StatHelper.BIND_CARD_USER_TYPE, "-1");
        StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_ENTER, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        StatisticManager.onEventWithValues(PayStatServiceEvent.INITIVATIVE_BIND_CARD_FAILED, (Collection<String>) StatHelper.collectData(f, i3 + "", str), (Map<String, Object>) hashMap);
        if (i3 == 5003) {
            PayBaseBeanActivity payBaseBeanActivity = this.b;
            GlobalUtils.toast(payBaseBeanActivity, ResUtils.getString(payBaseBeanActivity, "dxm_wallet_base_please_login"));
            AccountManager.getInstance(this.b).logout();
            WalletLoginHelper.getInstance().logout(false);
        } else if (-2 == i3 || -3 == i3) {
            PayBaseBeanActivity payBaseBeanActivity2 = this.b;
            GlobalUtils.toast(payBaseBeanActivity2, ResUtils.getString(payBaseBeanActivity2, "dxm_fp_get_data_fail"));
        } else if (-8 == i3) {
            PayBaseBeanActivity payBaseBeanActivity3 = this.b;
            GlobalUtils.toast(payBaseBeanActivity3, ResUtils.getString(payBaseBeanActivity3, "dxm_ebpay_no_network"));
        } else if (16309 == i3) {
            WalletGlobalUtils.safeShowDialog(this.b, 64, "");
            return;
        } else if (16310 == i3) {
            AnonymousClass1 r6 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    b.this.a(PayStatServiceEvent.NEW_BIND_CARD_CLOSE_REVIEW_PAGE, "关闭审核页面");
                    pop();
                    b.this.c();
                }
            };
            r6.push();
            String reviewingUrl = SdkInitResponse.getInstance().getReviewingUrl(this.b);
            if (TextUtils.isEmpty(reviewingUrl)) {
                reviewingUrl = DxmPayBeanConstants.API_BIND_CARD_REVIEWING_URL;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", reviewingUrl);
            bundle.putParcelable("lifecycleLsnr", r6);
            a(PayStatServiceEvent.NEW_BIND_CARD_REVIEWING, "结果审核中");
            BaiduWalletDelegate.getInstance().openH5Module((Context) this.b, bundle);
            return;
        } else {
            if (TextUtils.isEmpty(str)) {
                str = ResUtils.getString(this.b, "dxm_fp_get_data_fail");
            }
            GlobalUtils.toast(this.b, str);
        }
        c();
    }

    public void a(int i2, int i3, String str, Object obj) {
        CardAddResponse.updateContent((Object) null);
        StatHelper.clearSensor();
        if (i3 != 16254 || obj == null || !(obj instanceof CardAddErrorContent)) {
            c();
            return;
        }
        CardAddErrorContent cardAddErrorContent = (CardAddErrorContent) obj;
        if (!TextUtils.isEmpty(cardAddErrorContent.goto_url)) {
            BindCardEntry.newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_ENTER, "进入");
            AnonymousClass2 r4 = new H5LifeCycleCallback() {
                public void onActivityDestroyed(Activity activity) {
                    pop();
                    EventBus.getInstance().unregister((Object) b.this.b, DxmPayBeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT);
                    if (!b.this.a) {
                        BindCardEntry.newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_FAILED, "用户取消授权");
                        b.this.c();
                    } else if (b.this.b != null) {
                        b.this.b.finishWithoutAnim();
                    }
                    boolean unused = b.this.a = false;
                }
            };
            r4.push();
            EventBus.getInstance().register((Object) this.b, DxmPayBeanConstants.EVENT_H5_AUTH_ADMIT_SUBMIT, 0, EventBus.ThreadMode.MainThread);
            Bundle bundle = new Bundle();
            bundle.putBoolean("with_anim", false);
            bundle.putBoolean("show_share", false);
            bundle.putString("url", cardAddErrorContent.goto_url + "?is_from_sdk=1");
            bundle.putParcelable("lifecycleLsnr", r4);
            BaiduWalletDelegate.getInstance().openH5Module((Context) this.b, bundle);
            return;
        }
        c();
    }

    public void a(int i2, Dialog dialog) {
        if (i2 == 64) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.c);
            promptDialog.setCanceledOnTouchOutside(false);
            a(PayStatServiceEvent.NEW_BIND_CARD_SHOW_RESCIND_DIALOG, "展示解约弹窗");
            promptDialog.setNegativeBtn(ResUtils.string(this.b, "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.a(PayStatServiceEvent.NEW_BIND_CARD_CLOSE_RESCIND_DIALOG, "关闭解约弹窗");
                    WalletGlobalUtils.safeDismissDialog(b.this.b, 64);
                    b.this.c();
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(this.b, "ebpay_contact_kefu"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.a(PayStatServiceEvent.NEW_BIND_CARD_PHONE_RESCIND_DIALOG, "解约弹窗点击联系客服");
                    WalletGlobalUtils.safeDismissDialog(b.this.b, 64);
                    b.this.b.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + BdWalletUtils.getKefuPhoneNum(b.this.b))));
                    b.this.c();
                }
            });
        }
    }

    public Dialog a(int i2) {
        return this.b.onCreateDialog(i2);
    }

    public void a(EventBus.Event event) {
        if (event == null || event.mEventObj == null) {
            BindCardEntry.newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_FAILED, "用户取消授权");
            c();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) event.mEventObj);
            if (!jSONObject.has("confirm_result") || 1 != jSONObject.getInt("confirm_result")) {
                BindCardEntry.newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_FAILED, "用户取消授权");
                c();
                return;
            }
            BindCardEntry.newBindCardEventEndWithValues(PayStatServiceEvent.BIND_CARD_PASS_AGREE, "用户同意授权");
            this.a = true;
            NewBindCardEntry.getInstance().startWelcomeActivity(this.b);
        } catch (Exception e) {
            LogUtil.e("NewBindCardWelcomePresenter", e.getMessage(), e);
            c();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        a.a(str, "九要素审核页", "paySDKInitiativeBindCardReview", str2, new String[0]);
    }
}
