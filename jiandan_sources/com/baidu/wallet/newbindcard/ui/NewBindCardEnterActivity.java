package com.baidu.wallet.newbindcard.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.newbindcard.NewBindCardEntry;
import com.baidu.wallet.newbindcard.c.a;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.ab;
import com.baidu.wallet.paysdk.beans.p;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.CardAddResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.QueryBankBinResponse;
import com.baidu.wallet.paysdk.fingerprint.entrance.DxmCheckFingerprint;
import com.baidu.wallet.paysdk.payresult.datamodel.PayResultContent;
import com.baidu.wallet.paysdk.payresult.presenter.H5LifeCycleCallback;
import com.baidu.wallet.paysdk.precashier.PrecashierModifyPayTypeManager;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.SignChannelListActivity;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import com.dxmpay.apollon.base.widget.NetImageView;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.utils.GlobalUtils;
import com.dxmpay.apollon.utils.LogUtil;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.apollon.utils.support.Base64;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.DxmMarqueeView;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.SafeScrollView;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.dialog.PromptMultiBtnDialog;
import com.dxmpay.wallet.core.beans.BeanConstants;
import com.dxmpay.wallet.core.beans.BeanManager;
import com.dxmpay.wallet.core.lollipop.json.JSONException;
import com.dxmpay.wallet.core.lollipop.json.JSONObject;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.paysdk.datamodel.SdkInitResponse;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class NewBindCardEnterActivity extends PayBaseActivity implements View.OnClickListener, SafeKeyBoardEditText.OnMyFocusChangeListener {
    public static final String INITIATIVE_BIND_CARD_HASH_NAME = "入口";
    public static final String INITIATIVE_BIND_CARD_PAY_HASH_ID = "paySDKInitiativeBindCardEnter";
    public static boolean t = false;
    public boolean A = false;
    public boolean B = true;
    public ViewGroup a;
    public SafeScrollView b;
    public DivisionEditText c;
    public ImageView d;
    public ImageView e;
    public LinearLayout f;
    public LinearLayout g;
    public LinearLayout h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f3579i;
    public boolean j;
    public NetImageView k;
    public TextView l;
    public TextView m;
    public TextView n;

    /* renamed from: o  reason: collision with root package name */
    public DxmMarqueeView f3580o;
    public CardAddResponse p;
    public BindFastRequest q;
    public RelativeLayout r;
    public RelativeLayout s;
    public String u;
    public boolean v = false;
    public int w = 100027;
    public GetCardInfoResponse x;
    public View y;
    public String z;

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        SafeScrollView safeScrollView;
        if (motionEvent.getAction() == 0 && !a((View) this.d, motionEvent) && (safeScrollView = this.b) != null && safeScrollView.isShouldHideInput(getCurrentFocus(), motionEvent) && this.b.isPopupWindowShowing()) {
            this.c.clearFocus();
            this.b.dismissKeyBoard(this.c);
            if (this.j) {
                this.d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
                this.d.setContentDescription(ResUtils.getString(this, "wallet_access_scan_bank_card"));
                this.d.setOnClickListener(this);
            } else {
                this.d.setVisibility(8);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public String formatCardNo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 4;
            if (i3 < str.length()) {
                sb.append(str.substring(i2, i3));
                sb.append(" ");
            } else {
                sb.append(str.substring(i2, str.length()));
            }
            i2 = i3;
        }
        return sb.toString();
    }

    public void handleFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog(this, -2);
        if (i2 != 7 && i2 == 4) {
            this.mDialogMsg = str;
            if (i3 == 100010) {
                b(true);
            } else if (i3 == 100040 || i3 == 100026) {
                WalletGlobalUtils.safeShowDialog(this, 3, "");
            } else if (i3 == 100028) {
                this.w = i3;
                this.v = false;
                WalletGlobalUtils.safeShowDialog(this, 33, "");
            } else if (i3 == -8) {
                if (TextUtils.isEmpty(str)) {
                    str = getString(ResUtils.string(getActivity(), "dxm_ebpay_no_network"));
                }
                GlobalUtils.toast(this, str);
            } else {
                WalletGlobalUtils.safeShowDialog(this, 12, "");
            }
        }
    }

    public void handleResponse(int i2, Object obj, String str) {
        int i3;
        QueryBankBinResponse queryBankBinResponse;
        GetCardInfoResponse.CardInfo cardInfo;
        WalletGlobalUtils.safeDismissDialog(this, -2);
        if (i2 == 7) {
            if (obj != null && (obj instanceof QueryBankBinResponse) && (queryBankBinResponse = (QueryBankBinResponse) obj) != null && (cardInfo = queryBankBinResponse.card_info) != null) {
                a.a(cardInfo.front_bank_code);
                a.b(queryBankBinResponse.card_info.card_type + "");
                a.f(queryBankBinResponse.card_info.bank_name);
                a(queryBankBinResponse.card_info);
            }
        } else if (i2 == 4) {
            GetCardInfoResponse getCardInfoResponse = (GetCardInfoResponse) obj;
            this.x = getCardInfoResponse;
            if (getCardInfoResponse != null) {
                this.w = -1;
                this.mDialogMsg = "";
                Map<String, String> map = getCardInfoResponse.cashdesk;
                if (map != null && map.size() > 0) {
                    PayDataCache.getInstance().setSessionData(this.x.cashdesk);
                }
                GetCardInfoResponse.CardInfo cardInfo2 = this.x.card_info;
                if (cardInfo2 != null) {
                    a.a(cardInfo2.bank_no);
                    a.b(this.x.card_info.card_type + "");
                    a.f(this.x.card_info.bank_name);
                }
                GetCardInfoResponse.Algorithm algorithm = this.x.algorithm_check_info;
                if (algorithm == null || (i3 = algorithm.code) != 100027) {
                    GetCardInfoResponse.BindCardInfo bindCardInfo = this.x.bind_card_info;
                    if (bindCardInfo == null || TextUtils.isEmpty(bindCardInfo.bind_card_desc)) {
                        a(this.x);
                        return;
                    }
                    this.w = 100027;
                    this.mDialogMsg = this.x.bind_card_info.bind_card_desc;
                    this.v = true;
                    WalletGlobalUtils.safeShowDialog(this, 33, "");
                    return;
                }
                this.w = i3;
                this.mDialogMsg = algorithm.msg;
                this.v = false;
                WalletGlobalUtils.safeShowDialog(this, 33, "");
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 40976 && i3 == -1 && intent != null && intent.getExtras() != null) {
            b(intent.getExtras().getString("subbankcode"));
        }
    }

    public void onBackPressed() {
        NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardEnterActivity onBackPressed", false);
        super.onBackPressed();
    }

    public void onClick(View view) {
        if (view == this.d) {
            a(PayStatServiceEvent.NEW_CLICK_BANK_DETECT, "点击识别银行卡按钮");
            LocalRouter.getInstance(this).route(this, new RouterRequest().provider("bankdetection").action("bankcarddetction"), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 0) {
                        if (hashMap != null && !TextUtils.isEmpty((String) hashMap.get("card_num"))) {
                            String str = (String) hashMap.get("card_num");
                            if (!TextUtils.isEmpty(str) && !str.equals(NewBindCardEnterActivity.this.c.getRealText())) {
                                if (str.length() > 10) {
                                    NewBindCardEnterActivity.this.a(str.substring(0, 10));
                                }
                                NewBindCardEnterActivity.this.c.setText(str);
                                NewBindCardEnterActivity.this.c.setSelection(NewBindCardEnterActivity.this.c.getText().toString().length());
                                NewBindCardEnterActivity.this.c.requestFocus();
                                NewBindCardEnterActivity.this.g.setEnabled(true);
                            }
                        }
                    } else if (i2 == 5) {
                        StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ERROR, i2 + "");
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "bankdetection");
                        hashMap2.put("action", "bankcarddetction");
                        StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                    } else {
                        StatHelper.bankCardDetction(PayStatServiceEvent.BANKCARD_DETCTION_ERROR, i2 + "");
                    }
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_cashdesk_new_bind_card_enter_activity);
        setFlagActiveBindCard();
        CardAddResponse instance = CardAddResponse.getInstance();
        this.p = instance;
        if (instance == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardEnterActivity CardAddResponse is null", false);
            return;
        }
        BindFastRequest bindReq = NewBindCardEntry.getInstance().getBindReq();
        this.q = bindReq;
        if (bindReq == null) {
            NewBindCardEntry.getInstance().newBindCardCallback(StatHelper.SENSOR_ERR_2, "NewBindCardEnterActivity mBindFastRequest is null", false);
        } else {
            b();
        }
    }

    public Dialog onCreateDialog(int i2) {
        if (i2 != 67) {
            return super.onCreateDialog(i2);
        }
        PromptMultiBtnDialog promptMultiBtnDialog = new PromptMultiBtnDialog(this);
        promptMultiBtnDialog.setNewDialogStyle(true);
        return promptMultiBtnDialog;
    }

    public void onDestroy() {
        this.A = false;
        SafeScrollView safeScrollView = this.b;
        if (safeScrollView != null && safeScrollView.isPopupWindowShowing()) {
            this.b.dismissKeyBoard(this.c);
        }
        BeanManager.getInstance().removeAllBeans("NewBindCardEnterActivity");
        EventBus.getInstance().unregister((Object) this, DxmPayBeanConstants.EVENT_H5_QUICK_BIND_CARD);
        if (this.j) {
            LocalRouter.getInstance(this.mAct).route(this.mAct, new RouterRequest().provider("bankdetection").action("clearcallback"), new RouterCallback() {
                public void onResult(int i2, HashMap hashMap) {
                    if (i2 == 5) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("provider", "bankcarddetection");
                        hashMap2.put("action", "clearcallback");
                        StatisticManager.onEventEndWithValues("sdk_router_error", i2, (Collection<String>) hashMap2.values());
                    }
                }
            });
        }
        super.onDestroy();
    }

    public void onModuleEvent(EventBus.Event event) {
        if (event != null && DxmPayBeanConstants.EVENT_H5_QUICK_BIND_CARD.equals(event.mEventKey) && event.mEventObj != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) event.mEventObj);
                if (jSONObject.has("bind_card_result") && 1 == jSONObject.getInt("bind_card_result")) {
                    t = true;
                    this.z = jSONObject.optString("card_no", "");
                    a.a(PayStatServiceEvent.NEW_QUICK_BIND_SUCCESS, INITIATIVE_BIND_CARD_HASH_NAME, INITIATIVE_BIND_CARD_PAY_HASH_ID, "一键绑卡成功", a.a(), a.e(), a.f());
                }
            } catch (Exception e2) {
                LogUtil.e("NewBindCardEnterActivity", e2.getMessage(), e2);
            }
        }
    }

    public void onMyFocusChange(View view, boolean z2) {
        if (view == this.c) {
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            if (z2) {
                this.y.setBackgroundColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_2222"));
                layoutParams.height = (int) ResUtils.getDimension(this, "wallet_cashdesk_new_bind_card_hasfocus_line_size");
                if (!TextUtils.isEmpty(this.c.getRealText())) {
                    d();
                } else if (this.j) {
                    this.d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
                    this.d.setContentDescription(ResUtils.getString(this, "wallet_access_scan_bank_card"));
                    this.d.setOnClickListener(this);
                } else {
                    this.d.setVisibility(8);
                }
            } else {
                this.y.setBackgroundColor(ResUtils.getColor(this, "wallet_cashdesk_new_bind_card_E0EA"));
                layoutParams.height = (int) ResUtils.getDimension(this, "wallet_cashdesk_new_bind_card_line_size");
            }
            this.y.setLayoutParams(layoutParams);
        }
    }

    public void onPause() {
        super.onPause();
        this.c.clearFocus();
        this.b.dismissKeyBoard();
        EventBus.getInstance().unregister((Object) this, "ev_bean_execut_err_content");
    }

    public void onPrepareDialog(int i2, Dialog dialog) {
        if (i2 == 3) {
            PromptDialog promptDialog = (PromptDialog) dialog;
            promptDialog.setMessage((CharSequence) this.mDialogMsg);
            if (!TextUtils.isEmpty(this.u)) {
                promptDialog.setTitleText(formatCardNo(this.u));
            }
            a(PayStatServiceEvent.NEW_NOT_SUPPORT_BANK_DIALOG, "展示不支持该卡的弹窗");
            promptDialog.setCanceledOnTouchOutside(false);
            promptDialog.findViewById(ResUtils.id(this, "negative_btn")).setContentDescription(ResUtils.getString(this, "wallet_access_view_support_bank"));
            promptDialog.setNegativeBtn(ResUtils.string(getActivity(), "ebpay_choose_credit_tip2"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardEnterActivity.this.a(PayStatServiceEvent.NEW_CLICK_SUPPORT_BANK, "点击查看支持的银行");
                    WalletGlobalUtils.safeDismissDialog(NewBindCardEnterActivity.this, 3);
                    NewBindCardEnterActivity.this.b(false);
                }
            });
            promptDialog.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_confirm"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardEnterActivity.this.a(PayStatServiceEvent.NEW_NOT_SUPPORT_CHANGE_CARD, "展示不支持该卡的弹窗，点击更换卡");
                    WalletGlobalUtils.safeDismissDialog(NewBindCardEnterActivity.this, 3);
                }
            });
        } else if (i2 == 12) {
            PromptDialog promptDialog2 = (PromptDialog) dialog;
            promptDialog2.setMessage((CharSequence) this.mDialogMsg);
            promptDialog2.setCanceledOnTouchOutside(false);
            a(PayStatServiceEvent.NEW_CARD_INFO_ERR_DIALOG, "card_info接口报错展示的弹窗");
            promptDialog2.setPositiveBtn(ResUtils.string(getActivity(), "dxm_ebpay_know"), (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    NewBindCardEnterActivity.this.a(PayStatServiceEvent.NEW_CARD_INFO_ERR_CLICK, "点击card_info接口报错展示的弹窗我知道了按钮");
                    WalletGlobalUtils.safeDismissDialog(NewBindCardEnterActivity.this, 12);
                }
            });
            promptDialog2.hideNegativeButton();
        } else if (i2 == 33) {
            PromptDialog promptDialog3 = (PromptDialog) dialog;
            promptDialog3.setMessage((CharSequence) this.mDialogMsg);
            if (!this.v && !TextUtils.isEmpty(this.u)) {
                if (this.v) {
                    promptDialog3.setTitleText(ResUtils.string(getActivity(), "dxm_ebpay_tip"));
                } else {
                    promptDialog3.setTitleText(formatCardNo(this.u));
                }
            }
            a.a(PayStatServiceEvent.NEW_BIND_CARD_CHECK_DIALOG, INITIATIVE_BIND_CARD_HASH_NAME, INITIATIVE_BIND_CARD_PAY_HASH_ID, "输完卡号点击提交卡号后展示的弹窗", a.a(), a.b());
            promptDialog3.setCanceledOnTouchOutside(false);
            String string = ResUtils.getString(getActivity(), this.v ? "ebpay_choose_bind_sure" : "ebpay_choose_modify_card");
            String string2 = ResUtils.getString(getActivity(), this.v ? "ebpay_choose_bind_continue" : "ebpay_choose_confirm");
            promptDialog3.setNegativeBtn(string, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    a.a(PayStatServiceEvent.NEW_BIND_CARD_CHECK_DIALOG_MODIFY, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "输完卡号点击提交卡号后展示的弹窗，点击修改卡号按钮", a.a(), a.b());
                    WalletGlobalUtils.safeDismissDialog(NewBindCardEnterActivity.this, 33);
                }
            });
            promptDialog3.setPositiveBtn(string2, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    WalletGlobalUtils.safeDismissDialog(NewBindCardEnterActivity.this, 33);
                    a.a(PayStatServiceEvent.NEW_CONFIRM_CARD_NO, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "输完卡号点击提交卡号后展示的弹窗，点击确认无误按钮", a.a(), a.b());
                    if (NewBindCardEnterActivity.this.w == 100027) {
                        NewBindCardEnterActivity newBindCardEnterActivity = NewBindCardEnterActivity.this;
                        newBindCardEnterActivity.a(newBindCardEnterActivity.x);
                    } else if (NewBindCardEnterActivity.this.w == 100028) {
                        NewBindCardEnterActivity.this.b(true);
                    }
                }
            });
        } else if (i2 != 67) {
            super.onPrepareDialog(i2, dialog);
        } else {
            PromptMultiBtnDialog promptMultiBtnDialog = (PromptMultiBtnDialog) dialog;
            promptMultiBtnDialog.setTitle(R.string.dxm_wallet_tip);
            CardAddResponse cardAddResponse = this.p;
            if (cardAddResponse != null && !TextUtils.isEmpty(cardAddResponse.marketing_prompt)) {
                promptMultiBtnDialog.setMessage((CharSequence) this.p.marketing_prompt);
            }
            promptMultiBtnDialog.setHideDialogIcon(true);
            promptMultiBtnDialog.setHideSecondBtn(true);
            promptMultiBtnDialog.setHideThirdBtn(true);
            if ("walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) || "walletapppro".equalsIgnoreCase(BeanConstants.CHANNEL_ID)) {
                promptMultiBtnDialog.setFirstBtnResId(R.drawable.dxm_wallet_base_red_fa5050_btn);
            } else {
                promptMultiBtnDialog.setFirstBtnResId(R.drawable.dxm_wallet_base_blue_397be6_btn);
            }
            promptMultiBtnDialog.setFirstBtn((int) R.string.dxm_ebpay_know, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    String spNo = PrecashierModifyPayTypeManager.getInstance().getSpNo();
                    if (TextUtils.isEmpty(spNo)) {
                        NewBindCardEnterActivity.this.a(PayStatServiceEvent.CLOSE_MARKETING_DIALOG, "关闭营销弹窗");
                    } else {
                        HashMap hashMap = new HashMap();
                        hashMap.put(StatHelper.SP_NO, spNo);
                        a.a(PayStatServiceEvent.CLOSE_MARKETING_DIALOG, hashMap, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "关闭营销弹窗", new String[0]);
                    }
                    WalletGlobalUtils.safeDismissDialog(NewBindCardEnterActivity.this, 67);
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        this.c.clearFocus();
        this.b.dismissKeyBoard();
        EventBus.getInstance().registerSticky(this, "ev_bean_execut_err_content", 0, EventBus.ThreadMode.MainThread);
    }

    public void showPaySuccessPage(boolean z2, PayResultContent payResultContent, int i2) {
    }

    private void e() {
        final int i2;
        CardAddResponse cardAddResponse = this.p;
        if (cardAddResponse == null || TextUtils.isEmpty(cardAddResponse.marketing_top_title)) {
            this.f3579i.setVisibility(8);
            return;
        }
        this.f3579i.setVisibility(0);
        this.f3580o.setText(this.p.marketing_top_title);
        a(PayStatServiceEvent.BANK_ADD_MARKETING_SHOW, "有营销的绑卡页面展示");
        if (!TextUtils.isEmpty(this.p.marketing_prompt)) {
            this.e.setVisibility(0);
            i2 = 10;
        } else {
            this.e.setVisibility(8);
            i2 = 25;
        }
        this.f3579i.post(new Runnable() {
            public void run() {
                NewBindCardEnterActivity.this.f3580o.setMaxWidth(((NewBindCardEnterActivity.this.f3579i.getWidth() - NewBindCardEnterActivity.this.f3580o.getLeft()) - NewBindCardEnterActivity.this.e.getWidth()) - i2);
            }
        });
        this.e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String spNo = PrecashierModifyPayTypeManager.getInstance().getSpNo();
                if (TextUtils.isEmpty(spNo)) {
                    NewBindCardEnterActivity.this.a(PayStatServiceEvent.CLICK_MARKETING_TIP, "点击营销的提示");
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put(StatHelper.SP_NO, spNo);
                    a.a(PayStatServiceEvent.CLICK_MARKETING_TIP, hashMap, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "点击营销的提示", new String[0]);
                }
                WalletGlobalUtils.safeShowDialog(NewBindCardEnterActivity.this, 67, "");
            }
        });
        this.f3580o.postDelayed(new Runnable() {
            public void run() {
                NewBindCardEnterActivity.this.f3580o.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            }
        }, 1000);
    }

    private void f() {
        UserData.UserModel userModel;
        CardAddResponse cardAddResponse = this.p;
        if (!(cardAddResponse == null || (userModel = cardAddResponse.user) == null)) {
            String str = userModel.true_name;
            if (!TextUtils.isEmpty(str) && 1 == this.p.user.has_mobile_password) {
                DivisionEditText divisionEditText = this.c;
                divisionEditText.setHint("请输入" + str + "的银行卡号");
            }
        }
        this.c.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                NewBindCardEnterActivity.this.d.setVisibility(0);
                if (!NewBindCardEnterActivity.this.j || editable.length() != 0) {
                    NewBindCardEnterActivity.this.d();
                    String realText = NewBindCardEnterActivity.this.c.getRealText();
                    if (TextUtils.isEmpty(realText)) {
                        NewBindCardEnterActivity.this.d.setVisibility(8);
                        NewBindCardEnterActivity.this.c.setTypeface(Typeface.defaultFromStyle(0));
                        return;
                    }
                    NewBindCardEnterActivity.this.c.setTypeface(Typeface.defaultFromStyle(1));
                    if (realText.length() == 10 && NewBindCardEnterActivity.this.B) {
                        boolean unused = NewBindCardEnterActivity.this.B = false;
                        NewBindCardEnterActivity.this.a(realText);
                        NewBindCardEnterActivity.this.g.setEnabled(true);
                    } else if (realText.length() < 10) {
                        boolean unused2 = NewBindCardEnterActivity.this.B = true;
                        NewBindCardEnterActivity.this.f.setVisibility(8);
                        NewBindCardEnterActivity.this.g.setEnabled(false);
                    } else {
                        boolean unused3 = NewBindCardEnterActivity.this.B = true;
                        NewBindCardEnterActivity.this.g.setEnabled(true);
                    }
                } else {
                    NewBindCardEnterActivity.this.d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
                    NewBindCardEnterActivity.this.d.setContentDescription(ResUtils.getString(NewBindCardEnterActivity.this, "wallet_access_scan_bank_card"));
                    NewBindCardEnterActivity.this.c.setTypeface(Typeface.defaultFromStyle(0));
                    NewBindCardEnterActivity.this.d.setOnClickListener(NewBindCardEnterActivity.this);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.c.setOnMyFocusChangeListener(this);
    }

    private void g() {
        this.g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!NewBindCardEnterActivity.this.A) {
                    boolean unused = NewBindCardEnterActivity.this.A = true;
                    NewBindCardEnterActivity.this.a(PayStatServiceEvent.NEW_NA_BIND_CARD_ENTER, "NA主动绑卡入口");
                }
                NewBindCardEnterActivity.this.b.dismissKeyBoard(NewBindCardEnterActivity.this.c);
                NewBindCardEnterActivity newBindCardEnterActivity = NewBindCardEnterActivity.this;
                String unused2 = newBindCardEnterActivity.u = newBindCardEnterActivity.c.getRealText();
                a.a(PayStatServiceEvent.NEW_CLICK_SUBMIT_CARD, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "点击提交卡号", a.a(), a.b());
                NewBindCardEnterActivity.this.b("");
            }
        });
    }

    private void h() {
        CardAddResponse.QuickBindCardList[] quickBindCardListArr;
        this.h.removeAllViews();
        CardAddResponse cardAddResponse = this.p;
        if (cardAddResponse == null || (quickBindCardListArr = cardAddResponse.bank_list) == null || quickBindCardListArr.length <= 0) {
            this.s.setVisibility(8);
            return;
        }
        this.s.setVisibility(0);
        CardAddResponse.QuickBindCardList[] quickBindCardListArr2 = this.p.bank_list;
        for (int i2 = 0; i2 < quickBindCardListArr2.length; i2++) {
            final CardAddResponse.QuickBindCardList quickBindCardList = quickBindCardListArr2[i2];
            if (quickBindCardList != null) {
                View inflate = LayoutInflater.from(this).inflate(R.layout.wallet_base_new_quick_support_bank_card_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_quick_support_bank_marketing_tip);
                View findViewById = inflate.findViewById(R.id.view_line);
                ((NetImageView) inflate.findViewById(R.id.iv_new_quick_support_bank_icon)).setImageUrl(quickBindCardList.bank_icon_url);
                ((TextView) inflate.findViewById(R.id.tv_new_quick_support_bank_name)).setText(quickBindCardList.bank_name);
                if (!TextUtils.isEmpty(quickBindCardList.marketing_tips_info)) {
                    textView.setVisibility(0);
                    textView.setText(quickBindCardList.marketing_tips_info);
                } else {
                    textView.setVisibility(8);
                }
                if (i2 == quickBindCardListArr2.length - 1) {
                    findViewById.setVisibility(8);
                }
                this.h.addView(inflate);
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        a.f(quickBindCardList.bank_name);
                        a.a(quickBindCardList.bank_uniq_code);
                        a.e(quickBindCardList.marketing_tips_info);
                        a.a(PayStatServiceEvent.NEW_ENTER_QULICK_BIND, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_HASH_NAME, NewBindCardEnterActivity.INITIATIVE_BIND_CARD_PAY_HASH_ID, "进入一键绑卡", quickBindCardList.bank_uniq_code);
                        Bundle bundle = new Bundle();
                        String quickBindCardUrl = SdkInitResponse.getInstance().getQuickBindCardUrl(NewBindCardEnterActivity.this);
                        if (TextUtils.isEmpty(quickBindCardUrl)) {
                            quickBindCardUrl = DxmPayBeanConstants.API_QUICK_BIND_CARD_URL;
                        }
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(quickBindCardUrl);
                        CardAddResponse.QuickBindCardTypeList[] quickBindCardTypeListArr = quickBindCardList.type;
                        if (quickBindCardTypeListArr != null && quickBindCardTypeListArr.length > 0) {
                            for (int i2 = 0; i2 < quickBindCardList.type.length; i2++) {
                                stringBuffer.append(StatHelper.CARD_TYPE);
                                stringBuffer.append(quickBindCardList.type[i2].card_type);
                                stringBuffer.append("=");
                                stringBuffer.append(quickBindCardList.type[i2].front_bank_code);
                                stringBuffer.append(com.alipay.sdk.m.s.a.n);
                            }
                        }
                        stringBuffer.append("device_biometrics=");
                        if (NewBindCardEnterActivity.this.p.support_pwd_info == null || NewBindCardEnterActivity.this.p.support_pwd_info.length <= 0 || !"finger".equalsIgnoreCase(NewBindCardEnterActivity.this.p.support_pwd_info[0].verify_type)) {
                            stringBuffer.append("0&");
                        } else {
                            stringBuffer.append("1&");
                        }
                        stringBuffer.append("verify_type=2&");
                        stringBuffer.append("max_retry=");
                        stringBuffer.append(NewBindCardEnterActivity.this.p.support_pwd_info[0].max_retry);
                        if (NewBindCardEnterActivity.this.q != null) {
                            stringBuffer.append("&session_id=");
                            stringBuffer.append(NewBindCardEnterActivity.this.q.getSessionId());
                        }
                        stringBuffer.append("&is_from_sdk=1");
                        LogUtil.d("----d", stringBuffer.toString());
                        AnonymousClass1 r0 = new H5LifeCycleCallback() {
                            public void onActivityDestroyed(Activity activity) {
                                pop();
                                if (NewBindCardEnterActivity.t) {
                                    NewBindCardEntry.getInstance().newBindCardCallback("0", NewBindCardEnterActivity.this.z, true);
                                }
                                String unused = NewBindCardEnterActivity.this.z = null;
                                boolean unused2 = NewBindCardEnterActivity.t = false;
                            }
                        };
                        bundle.putBoolean("with_anim", false);
                        bundle.putBoolean("show_share", false);
                        bundle.putString("url", stringBuffer.toString());
                        bundle.putParcelable("lifecycleLsnr", r0);
                        r0.push();
                        EventBus.getInstance().register((Object) NewBindCardEnterActivity.this, DxmPayBeanConstants.EVENT_H5_QUICK_BIND_CARD, 0, EventBus.ThreadMode.MainThread);
                        BaiduWalletDelegate.getInstance().openH5Module((Context) NewBindCardEnterActivity.this, bundle);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        this.d.setImageResource(R.drawable.dxm_wallet_base_delete);
        this.d.setContentDescription(ResUtils.getString(this, "wallet_access_clean"));
        this.d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewBindCardEnterActivity.this.c.setText("");
                NewBindCardEnterActivity.this.f.setVisibility(8);
                NewBindCardEnterActivity.this.g.setEnabled(false);
            }
        });
    }

    private void b() {
        this.a = (ViewGroup) findViewById(R.id.new_bind_card_enter_activity);
        this.b = (SafeScrollView) findViewById(R.id.scroll_bindcard_enter);
        this.c = (DivisionEditText) findViewById(R.id.et_new_bank_card_no);
        this.d = (ImageView) findViewById(R.id.iv_new_bind_card_icon);
        this.f = (LinearLayout) findViewById(R.id.lin_new_bank_card_info);
        this.g = (LinearLayout) findViewById(R.id.btn_new_bank_card_submit);
        this.k = (NetImageView) findViewById(R.id.iv_new_bankinfo_logo);
        this.l = (TextView) findViewById(R.id.tv_new_bankinfo_name);
        this.s = (RelativeLayout) findViewById(R.id.relative_bank);
        this.h = (LinearLayout) findViewById(R.id.lin_support_bank_list);
        this.r = (RelativeLayout) findViewById(R.id.title_left_imgzone2);
        this.m = (TextView) findViewById(R.id.tv_support_bank);
        this.f3579i = (LinearLayout) findViewById(R.id.lin_marketing_bind_card);
        this.f3580o = (DxmMarqueeView) findViewById(R.id.tv_marketing_bind_card_txt);
        this.e = (ImageView) findViewById(R.id.iv_marketing_bind_card_icon);
        this.n = (TextView) findViewById(R.id.tv_marketing_bind_card_tip_txt);
        String string = ResUtils.getString(this, "wallet_access_button");
        AccessibilityUtils.changeRoleDescription(this.m, string);
        AccessibilityUtils.changeRoleDescription(this.g, string);
        this.y = findViewById(R.id.view_line);
        if ("walletapp".equalsIgnoreCase(BeanConstants.CHANNEL_ID) || "walletapppro".equalsIgnoreCase(BeanConstants.CHANNEL_ID)) {
            this.g.setBackgroundResource(R.drawable.dxm_wallet_base_red_fa5050_btn);
        } else {
            this.g.setBackgroundResource(R.drawable.dxm_wallet_base_blue_397be6_btn);
        }
        this.g.setEnabled(false);
        this.f.setVisibility(8);
        DivisionEditText divisionEditText = this.c;
        divisionEditText.initSafeKeyBoardParams(this.a, this.b, divisionEditText, false);
        c();
        f();
        g();
        h();
        e();
        this.r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewBindCardEnterActivity.this.onBackPressed();
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewBindCardEnterActivity.this.a(PayStatServiceEvent.NEW_CLICK_SUPPORT_BANK, "点击查看支持的银行");
                NewBindCardEnterActivity.this.b(false);
            }
        });
    }

    private void c() {
        CardAddResponse cardAddResponse;
        if (!LocalRouter.getInstance(getActivity()).isProviderExisted("bankdetection") || (cardAddResponse = this.p) == null || !"1".equals(cardAddResponse.bank_card_detect_enabled)) {
            this.j = false;
        } else {
            this.j = true;
        }
        if (this.j) {
            this.d.setImageResource(R.drawable.dxm_wallet_new_bind_card_camera_icon);
            this.d.setContentDescription(ResUtils.getString(this, "wallet_access_scan_bank_card"));
        } else {
            this.d.setImageResource(R.drawable.dxm_wallet_base_delete);
            this.d.setContentDescription(ResUtils.getString(this, "wallet_access_clean"));
        }
        this.c.setUseSafeKeyBoard(true);
        this.c.setViewType(25);
        if (!this.j || !TextUtils.isEmpty(this.c.getRealText())) {
            d();
        } else {
            this.d.setOnClickListener(this);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        ab abVar = (ab) PayBeanFactory.getInstance().getBean((Context) this, 7, "NewBindCardEnterActivity");
        abVar.setResponseCallback(this);
        abVar.a(str);
        abVar.execBean();
    }

    private void a(GetCardInfoResponse.CardInfo cardInfo) {
        String str;
        CardAddResponse cardAddResponse;
        Map<String, String> map;
        if (cardInfo != null && !TextUtils.isEmpty(cardInfo.bank_logourl) && !TextUtils.isEmpty(cardInfo.bank_name)) {
            this.f.setVisibility(0);
            this.k.setImageUrl(cardInfo.bank_logourl);
            TextView textView = this.l;
            StringBuilder sb = new StringBuilder();
            sb.append(cardInfo.bank_name);
            sb.append(" ");
            if (cardInfo.card_type == 1) {
                str = ResUtils.getString(getActivity(), "bd_wallet_credit");
            } else {
                str = ResUtils.getString(getActivity(), "bd_wallet_debit");
            }
            sb.append(str);
            textView.setText(sb.toString());
            String str2 = cardInfo.front_bank_code;
            if (TextUtils.isEmpty(str2) || (cardAddResponse = this.p) == null || (map = cardAddResponse.marketing_support_bank) == null || map.isEmpty() || TextUtils.isEmpty(this.p.marketing_support_bank.get(str2))) {
                a.e((String) null);
                this.n.setVisibility(8);
                return;
            }
            String str3 = this.p.marketing_support_bank.get(str2);
            a.e(str3);
            this.n.setVisibility(0);
            this.n.setText(str3);
        }
    }

    /* access modifiers changed from: private */
    public void a(GetCardInfoResponse getCardInfoResponse) {
        UserData.UserModel userModel;
        if (getCardInfoResponse != null && this.q != null) {
            GetCardInfoResponse.CardInfo cardInfo = getCardInfoResponse.card_info;
            if (cardInfo != null && !TextUtils.isEmpty(cardInfo.bank_no)) {
                this.q.mBankNo = getCardInfoResponse.card_info.bank_no;
            }
            this.q.setmBankInfo(getCardInfoResponse);
            CardAddResponse cardAddResponse = this.p;
            if (cardAddResponse != null && (userModel = cardAddResponse.user) != null) {
                if (1 == userModel.has_mobile_password) {
                    CardAddResponse.SupportPwdInfo[] supportPwdInfoArr = cardAddResponse.support_pwd_info;
                    if (supportPwdInfoArr == null || supportPwdInfoArr.length <= 0) {
                        a.d("1");
                        a(true, -1);
                        return;
                    }
                    CardAddResponse.SupportPwdInfo supportPwdInfo = supportPwdInfoArr[0];
                    if (supportPwdInfo == null || !"finger".equalsIgnoreCase(supportPwdInfo.verify_type)) {
                        a.d("1");
                        a(true, -1);
                        return;
                    }
                    a.d("1");
                    b(supportPwdInfo.max_retry);
                    return;
                }
                a.c("0");
                a.d("0");
                a(false, -1);
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putBoolean("isSelectBank", z2);
        Intent intent = new Intent(getActivity(), SignChannelListActivity.class);
        intent.putExtras(extras);
        startActivityForResult(intent, (int) DxmPayBeanConstants.REQUEST_CODE_SIGN_CHANNEL_LIST);
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        WalletGlobalUtils.safeShowDialog(this, -2, "");
        p pVar = (p) PayBeanFactory.getInstance().getBean((Context) this, 4, "NewBindCardEnterActivity");
        BindFastRequest bindFastRequest = this.q;
        if (bindFastRequest != null) {
            bindFastRequest.setSubBankCode(str);
        }
        a(this.q);
        pVar.a(this.u, "");
        pVar.a(this.q);
        pVar.setResponseCallback(this);
        pVar.execBean();
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, int i2) {
        Intent intent = new Intent();
        if (z2) {
            intent.setClass(this, NewCheckPwdActivity.class);
            intent.putExtra(NewCheckPwdActivity.CHECK_FINGERPRINGT_STATUS, i2);
        } else {
            intent.setClass(this, NewBindCardMainActivity.class);
        }
        intent.putExtra(NewBindCardMainActivity.BIND_CARD_NUMBER, this.c.getRealText());
        startActivityWithoutAnim(intent);
    }

    private void b(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("showSwitchPwd", 1);
            jSONObject.put("checkTimes", i2);
            DxmCheckFingerprint.getInstance().startCherkFingerprint(this, jSONObject.toString(), new RouterCallback() {
                /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
                /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onResult(int r6, java.util.HashMap r7) {
                    /*
                        r5 = this;
                        java.lang.String r0 = "data"
                        r1 = 1
                        r2 = 0
                        r3 = -1
                        if (r6 != 0) goto L_0x005d
                        if (r7 == 0) goto L_0x005d
                        java.lang.String r6 = "result"
                        java.lang.Object r4 = r7.get(r6)
                        if (r4 == 0) goto L_0x005d
                        com.dxmpay.wallet.core.lollipop.json.JSONObject r4 = new com.dxmpay.wallet.core.lollipop.json.JSONObject     // Catch:{ JSONException -> 0x0053 }
                        java.lang.Object r7 = r7.get(r6)     // Catch:{ JSONException -> 0x0053 }
                        java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x0053 }
                        r4.<init>((java.lang.String) r7)     // Catch:{ JSONException -> 0x0053 }
                        int r6 = r4.optInt(r6, r3)     // Catch:{ JSONException -> 0x0053 }
                        if (r6 != 0) goto L_0x005d
                        java.lang.String r6 = "cnt"
                        com.dxmpay.wallet.core.lollipop.json.JSONObject r6 = r4.optJSONObject(r6)     // Catch:{ JSONException -> 0x0053 }
                        if (r6 == 0) goto L_0x005d
                        java.lang.String r7 = r6.optString(r0)     // Catch:{ JSONException -> 0x0053 }
                        if (r7 == 0) goto L_0x005d
                        com.dxmpay.wallet.core.lollipop.json.JSONObject r7 = new com.dxmpay.wallet.core.lollipop.json.JSONObject     // Catch:{ JSONException -> 0x0053 }
                        java.lang.String r4 = new java.lang.String     // Catch:{ JSONException -> 0x0053 }
                        java.lang.String r6 = r6.optString(r0)     // Catch:{ JSONException -> 0x0053 }
                        byte[] r6 = com.dxmpay.apollon.utils.Base64Utils.decode((java.lang.String) r6)     // Catch:{ JSONException -> 0x0053 }
                        r4.<init>(r6)     // Catch:{ JSONException -> 0x0053 }
                        r7.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x0053 }
                        java.lang.String r6 = "statusCode"
                        int r6 = r7.optInt(r6, r3)     // Catch:{ JSONException -> 0x0053 }
                        if (r6 != 0) goto L_0x004e
                        r7 = 1
                        goto L_0x005f
                    L_0x004e:
                        r7 = -203(0xffffffffffffff35, float:NaN)
                        if (r6 != r7) goto L_0x005e
                        return
                    L_0x0053:
                        r6 = move-exception
                        java.lang.String r7 = r6.getMessage()
                        java.lang.String r0 = "NewBindCardEnterActivity"
                        com.dxmpay.apollon.utils.LogUtil.e(r0, r7, r6)
                    L_0x005d:
                        r6 = -1
                    L_0x005e:
                        r7 = 0
                    L_0x005f:
                        if (r7 == 0) goto L_0x0067
                        com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity r6 = com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.this
                        r6.a((boolean) r2, (int) r3)
                        goto L_0x006c
                    L_0x0067:
                        com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity r7 = com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.this
                        r7.a((boolean) r1, (int) r6)
                    L_0x006c:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.newbindcard.ui.NewBindCardEnterActivity.AnonymousClass10.onResult(int, java.util.HashMap):void");
                }
            });
        } catch (JSONException e2) {
            LogUtil.e("NewBindCardEnterActivity", e2.getMessage(), e2);
            a(true, -1);
        }
    }

    private void a(BindFastRequest bindFastRequest) {
        Pair<Integer, Object> checkSecurityEvn = BaiduWalletDelegate.getInstance().checkSecurityEvn();
        if (checkSecurityEvn != null && ((Integer) checkSecurityEvn.first).intValue() == 0) {
            Object obj = checkSecurityEvn.second;
            String str = null;
            if (obj != null && (obj instanceof String)) {
                str = (String) obj;
            }
            if (bindFastRequest != null && !TextUtils.isEmpty(str)) {
                bindFastRequest.mSecurityParams = Base64.encodeBytes(str.getBytes());
            }
        }
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        if (motionEvent.getX() < ((float) i2) || motionEvent.getX() > ((float) (i2 + view.getWidth())) || motionEvent.getY() < ((float) i3) || motionEvent.getY() > ((float) (i3 + view.getHeight()))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        a.a(str, INITIATIVE_BIND_CARD_HASH_NAME, INITIATIVE_BIND_CARD_PAY_HASH_ID, str2, new String[0]);
    }
}
