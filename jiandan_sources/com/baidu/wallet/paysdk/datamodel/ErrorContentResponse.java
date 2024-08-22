package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.PayCallBackManager;
import com.baidu.wallet.paysdk.beans.n;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.LicaiBalancePayResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.PayBaseActivity;
import com.baidu.wallet.paysdk.ui.PwdCheckActivity;
import com.baidu.wallet.paysdk.ui.PwdPayActivity;
import com.dxmpay.wallet.api.BaiduWalletDelegate;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ErrorContentResponse implements Serializable {
    public static final String NEED_UPDATE = "1";
    public static final String NINE_ELEMENTS_CARD_ERROR = "card";
    public static final String NINE_ELEMENTS_ID_CARD_ERROR = "id_card";
    public static final String NINE_ELEMENTS_NAME_ERROR = "name";
    public static final String NINE_ELEMENTS_PHONE_ERROR = "phone";
    public static final String PAY_BY_SMS_DISABLE = "0";
    public static final String PAY_BY_SMS_ENABLE = "1";
    public static final String TAG = "ErrorContentResponse";
    public static final long serialVersionUID = 1572006194091664237L;
    public BankLimit banklimit;
    public GetCardInfoResponse.CardItemRequired card_item_required;
    public GetCardInfoResponse.CertificateTypeInfo[] certificate_type_info;
    public LicaiBalancePayResponse.RepaymentOrder fund;
    public Guidance guidance;
    public String hint_sms;
    public LivingParam living_param;
    public MktSolution mkt_solution;
    public String need_cvv2;
    public String need_identity_code;
    public String need_identity_type;
    public String need_other_pay_method = "0";
    public String need_phone_num;
    public String need_send_sms;
    public String need_valid_date;
    public String nine_elements_error;
    public String nine_elements_error_msg;
    public String order_amount;
    public LicaiBalancePayResponse.RepaymentOrder repayment;
    public String use_vcode_to_pay;
    public Verify verify;

    public static class BankLimit implements Serializable {
        public String answer;
        public String question;
        public BankLimitTip[] tips;
        public String title;

        public static class BankLimitTip implements Serializable {
            public String money;
            public String title;
        }
    }

    public static class CardInfoCheck implements Serializable {
        public String card_no;
        public String certicicate_code;
        public String verify_code;
    }

    public static class Guidance implements Serializable {
        public Operations[] operations;
        public String prompt_body;
        public String prompt_head;

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r0 = r4.operations;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isGuidanceAvilable() {
            /*
                r4 = this;
                java.lang.String r0 = r4.prompt_body
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                r1 = 0
                if (r0 != 0) goto L_0x0012
                com.baidu.wallet.paysdk.datamodel.ErrorContentResponse$Operations[] r0 = r4.operations
                if (r0 == 0) goto L_0x0012
                int r0 = r0.length
                if (r0 <= 0) goto L_0x0012
                r0 = 1
                goto L_0x0013
            L_0x0012:
                r0 = 0
            L_0x0013:
                if (r0 != 0) goto L_0x0016
                return r0
            L_0x0016:
                com.baidu.wallet.paysdk.datamodel.ErrorContentResponse$Operations[] r2 = r4.operations
                int r3 = r2.length
            L_0x0019:
                if (r1 >= r3) goto L_0x0027
                r0 = r2[r1]
                boolean r0 = r0.isOperationAvilable()
                if (r0 != 0) goto L_0x0024
                goto L_0x0027
            L_0x0024:
                int r1 = r1 + 1
                goto L_0x0019
            L_0x0027:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.paysdk.datamodel.ErrorContentResponse.Guidance.isGuidanceAvilable():boolean");
        }
    }

    public static class LivingParam implements Serializable {
        public String auth_protocol;
        public String show_guide_page;
        public String sp_params;
        public String user_display_name;
        public String usertoken;
    }

    public static class MktSolution implements Serializable {
        public static final long serialVersionUID = 1;
        public PayData.Discount[] activity_list;
        public String balance_amount;
        public PayData.Coupon[] coupon_list;
        public String easypay_amount;

        public String toString() {
            return "& easypay_amount = " + this.easypay_amount;
        }
    }

    public static class Operations implements Serializable {
        public static final String BALANCE_PAY = "balance_pay";
        public static final String BIND_CARD_PAY = "bind_card_pay";
        public static final String BIND_OTHER_CARDS = "bind_other_cards";
        public static final String CALL_UP = "call_up";
        public static final String CASHDESK_CLOSE = "cashdesk_close";
        public static final String CHANGE_MOBILE = "change_mobile";
        public static final String CHANGE_PAYTYPE = "change_paytype";
        public static final String CLOSE_DIALOG = "close_dialog";
        public static final String CONTINUE_PAY = "continue_pay";
        public static final String FIND_PWD = "find_pwd";
        public static final String HELP_CENTER = "help_center";
        public static final String LIVING_AGAIN = "living_again";
        public static final String NOTICE = "notice";
        public static final String OFFLINE_PAY = "offline_pay";
        public static final String OFFLINE_RECORD = "offline_record";
        public static final String RETRY_PAY = "retry_pay";
        public static final String SEND_SMS = "send_sms";
        public String card_no;
        public transient Map<String, n> handlers = new HashMap();
        public String hint;
        public String jump_uri;
        public String mobile;
        public String need_close;
        public String otp_reuse_code;
        public String tip;
        public String type;

        public boolean equals(Object obj) {
            return (obj instanceof Operations) && TextUtils.equals(((Operations) obj).type, this.type);
        }

        public n getAction() {
            final HashMap hashMap = new HashMap();
            hashMap.put(StatHelper.HASH_NAME, PayBaseActivity.PAY_DIALOG_HASH_NAME);
            hashMap.put("hash", PayBaseActivity.PAY_DIALOG_HASH_ID);
            hashMap.put(StatHelper.EVENT_TAG, "点击弹窗按钮");
            hashMap.put(StatHelper.PAGE_NAME, StatHelper.PAY_SDK_CASHDESH_PAY_NAME);
            hashMap.put(StatHelper.PAGE_ID, StatHelper.PAY_SDK_CASHDESH_PAY_ID);
            hashMap.put(StatHelper.EVENT_PATH, "paySDK_pay_guidance_click");
            hashMap.put(StatHelper.EVENT_MOLD, StatHelper.PAY_SDK_AUTO_ACTION);
            if (CASHDESK_CLOSE.equals(this.type)) {
                return new n<Operations, Context>() {
                    public void a(Operations operations, Context context) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, Operations.this.type);
                        PayCallBackManager.callBackClientPaying(context);
                    }
                };
            }
            if (HELP_CENTER.equals(this.type)) {
                return new n<Operations, Context>() {
                    public void a(Operations operations, final Context context) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, Operations.this.type);
                        if (context != null && operations != null && !TextUtils.isEmpty(operations.jump_uri)) {
                            BaiduWalletDelegate.getInstance().openH5Module(context, Operations.this.jump_uri, false);
                            if ("1".equals(Operations.this.need_close)) {
                                StatisticManager.onEvent("payTimeoutGuideToOrderDetail", PayDataCache.getInstance().getInsideTransOrder());
                                new Handler().postDelayed(new Runnable() {
                                    public void run() {
                                        PayCallBackManager.callBackClientPaying(context);
                                    }
                                }, 20);
                            }
                        }
                    }
                };
            }
            if (FIND_PWD.equals(this.type)) {
                return new n<Operations, Context>() {
                    public void a(Operations operations, Context context) {
                        StatHelper.statServiceEvent(PayStatServiceEvent.PAY_GUIDANCE_CICK, hashMap, Operations.this.type);
                        if (context instanceof PwdPayActivity) {
                            ((PwdPayActivity) context).forgetPassword();
                        } else if (context instanceof PwdCheckActivity) {
                            ((PwdCheckActivity) context).forgetPasswd(PayRequestCache.BindCategory.Other.name());
                        }
                    }
                };
            }
            return this.handlers.get(this.type);
        }

        public String getActionName() {
            return this.hint;
        }

        public boolean isOperationAvilable() {
            return !TextUtils.isEmpty(this.type) && !TextUtils.isEmpty(this.hint);
        }

        public void registerActionHandler(String str, n nVar) {
            this.handlers.put(str, nVar);
        }
    }

    public static class Verify implements Serializable {
        public static final String VERIFY_CARD_NO = "card_no";
        public static final String VERIFY_CETIFICATE_CODE = "certificate_code";
        public static final String VERIFY_CVV2 = "verify_code";
        public static final long serialVersionUID = 1747811045878020816L;
        public String[] card_item_required;
        public String card_item_required_msg;
        public LivingParam living_param;
        public String mobile_ec;
        public String sms_length;
        public String sms_pattern;
        public String sms_type;
        public String type;
        public String voice_msg;

        public String getVerifyMobile() {
            return this.mobile_ec;
        }

        public String getVerifyType() {
            return this.type;
        }

        public String getVoiceMsg() {
            return this.voice_msg;
        }
    }

    public boolean isNeedId() {
        return needUpdate(this.need_identity_code);
    }

    public boolean isNeedPhoneNum() {
        return needUpdate(this.need_phone_num);
    }

    public boolean isNeedSendSms() {
        return needUpdate(this.need_send_sms);
    }

    public boolean isNeedType() {
        return needUpdate(this.need_identity_type);
    }

    public boolean isNeedValidCode() {
        return needUpdate(this.need_cvv2);
    }

    public boolean isNeedValidDate() {
        return needUpdate(this.need_valid_date);
    }

    public boolean needUpdate(String str) {
        return !TextUtils.isEmpty(str) && "1".equals(str);
    }
}
