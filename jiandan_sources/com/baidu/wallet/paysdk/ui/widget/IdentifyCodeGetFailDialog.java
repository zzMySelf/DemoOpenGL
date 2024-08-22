package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.View;
import com.baidu.wallet.base.controllers.PayController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.beans.PayBeanFactory;
import com.baidu.wallet.paysdk.beans.o;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.baidu.wallet.paysdk.storage.PayRequestCache;
import com.baidu.wallet.paysdk.ui.BindCardImplActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.core.BaseActivity;
import com.dxmpay.wallet.core.utils.LogUtil;
import com.dxmpay.wallet.core.utils.WalletGlobalUtils;
import com.dxmpay.wallet.utils.BdWalletUtils;
import com.dxmpay.wallet.utils.StatHelper;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

public class IdentifyCodeGetFailDialog extends PromptDialog implements IBeanResponseCallback {
    public int a;
    public VerifyCodeType b;
    public String c;

    public enum VerifyCodeType {
        SMS,
        VOICE
    }

    public IdentifyCodeGetFailDialog(Context context) {
        this(context, VerifyCodeType.SMS);
    }

    private SpannableStringBuilder d() {
        String string = ResUtils.getString(this.mContext, "ebpay_operation_tip1");
        String string2 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip2");
        String string3 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip3");
        String string4 = ResUtils.getString(this.mContext, "ebpay_operation_voice_verify_tip4");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        a(string, spannableStringBuilder);
        spannableStringBuilder.append(string2);
        spannableStringBuilder.append(string3);
        spannableStringBuilder.append(string4);
        spannableStringBuilder.append(BdWalletUtils.getKefuPhoneNum(this.mContext));
        return spannableStringBuilder;
    }

    public void onBeanExecFailure(int i2, int i3, String str) {
        WalletGlobalUtils.safeDismissDialog((BaseActivity) this.mContext, this.a);
    }

    public void onBeanExecSuccess(int i2, Object obj, String str) {
        Context context = this.mContext;
        if (context != null && (context instanceof BaseActivity)) {
            BaseActivity baseActivity = (BaseActivity) context;
            LinkedList<BaseActivity> linkedList = BaseActivity.mActivityStack;
            boolean z = false;
            if (linkedList != null && linkedList.size() > 0) {
                int i3 = 0;
                while (true) {
                    if (i3 >= linkedList.size()) {
                        break;
                    } else if (linkedList.get(i3) instanceof BindCardImplActivity) {
                        linkedList.get(i3).finishWithoutAnim();
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            WalletGlobalUtils.safeDismissDialog(baseActivity, this.a);
            if (obj instanceof GetCardInfoResponse) {
                GetCardInfoResponse getCardInfoResponse = (GetCardInfoResponse) obj;
                PayRequest payRequest = (PayRequest) PayRequestCache.getInstance().getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
                if (payRequest != null) {
                    if (z) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            LogUtil.e("IdentifyCodeGetFailDialog", e.getMessage(), e);
                        }
                        PayController.getInstance().completeCardPay(this.mContext, payRequest.mBondCard, getCardInfoResponse);
                    } else {
                        PayController.getInstance().completeCardPay(this.mContext, payRequest.mBondCard, getCardInfoResponse);
                    }
                }
                if (baseActivity instanceof WalletSmsActivity) {
                    baseActivity.finish();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitleText(ResUtils.getString(this.mContext, b()));
        showCloseBtn(false);
        setMessage((CharSequence) a());
        findViewById(ResUtils.id(this.mContext, "positive_btn")).setContentDescription(ResUtils.getString(this.mContext, "wallet_access_view_help_number"));
    }

    public void setModifyMobileDesc(String str) {
        this.c = str;
        setMessage((CharSequence) a());
    }

    public IdentifyCodeGetFailDialog(Context context, VerifyCodeType verifyCodeType) {
        super(context);
        this.a = 0;
        this.b = verifyCodeType;
    }

    private SpannableStringBuilder a() {
        return this.b == VerifyCodeType.VOICE ? d() : c();
    }

    private String b() {
        return this.b == VerifyCodeType.VOICE ? "ebpay_get_voice_code_error_title" : "ebpay_get_sms_error_dialog_title";
    }

    private SpannableStringBuilder c() {
        String string = ResUtils.getString(this.mContext, "ebpay_operation_tip1");
        String string2 = ResUtils.getString(this.mContext, "ebpay_operation_tip2");
        String string3 = ResUtils.getString(this.mContext, "ebpay_operation_tip3");
        String string4 = ResUtils.getString(this.mContext, "ebpay_operation_tip4");
        String string5 = ResUtils.getString(this.mContext, "ebpay_operation_tip5");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(string);
        a(string, spannableStringBuilder);
        spannableStringBuilder.append(StringUtils.LF);
        spannableStringBuilder.append(string2);
        spannableStringBuilder.append(string3);
        spannableStringBuilder.append(string4);
        spannableStringBuilder.append(string5);
        spannableStringBuilder.append(BdWalletUtils.getKefuPhoneNum(this.mContext));
        return spannableStringBuilder;
    }

    private void a(String str, SpannableStringBuilder spannableStringBuilder) {
        if (!TextUtils.isEmpty(this.c)) {
            spannableStringBuilder.append("，");
            spannableStringBuilder.append(this.c);
            AnonymousClass1 r0 = new ClickableSpan() {
                public void onClick(View view) {
                    StatHelper.statServiceEvent(PayStatServiceEvent.SMS_MODIFY_PHONE);
                    o oVar = (o) PayBeanFactory.getInstance().getBean(IdentifyCodeGetFailDialog.this.mContext, 15, "IdentifyCodeGetFailDialog");
                    oVar.setResponseCallback(IdentifyCodeGetFailDialog.this);
                    WalletGlobalUtils.safeShowDialog((BaseActivity) IdentifyCodeGetFailDialog.this.mContext, IdentifyCodeGetFailDialog.this.a, "");
                    oVar.execBean();
                    IdentifyCodeGetFailDialog.this.dismiss();
                }

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(ResUtils.getColor(IdentifyCodeGetFailDialog.this.mContext, "dxm_wallet_base_color_clickable"));
                }
            };
            spannableStringBuilder.setSpan(new BackgroundColorSpan(-1), str.length(), spannableStringBuilder.length(), 33);
            spannableStringBuilder.setSpan(r0, str.length() + 1, spannableStringBuilder.length(), 33);
        }
    }
}
