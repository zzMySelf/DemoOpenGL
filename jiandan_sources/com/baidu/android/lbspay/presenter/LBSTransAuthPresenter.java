package com.baidu.android.lbspay.presenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.aiscan.R;
import com.baidu.android.lbspay.LBSPayResult;
import com.baidu.android.lbspay.activity.LBSTransActivity;
import com.baidu.android.lbspay.activity.WXSignActivity;
import com.baidu.android.lbspay.beans.AuthorizeSignBean;
import com.baidu.android.lbspay.beans.LbsPayBeanFactory;
import com.baidu.android.lbspay.channelpay.alipay.LBSPayAli;
import com.baidu.android.lbspay.datamodel.AuthorizeData;
import com.baidu.android.lbspay.datamodel.LBSOriginalPayBackManage;
import com.baidu.android.lbspay.network.AuthorizeSignContent;
import com.baidu.android.lbspay.view.PayChannelController;
import com.baidu.wallet.base.statistics.PayStatServiceEvent;
import com.dxmpay.wallet.utils.StatHelper;
import java.io.Serializable;

public class LBSTransAuthPresenter implements LBSTransPresenter {
    public static final String AUTH_CHANNEL_ALI = "alipay";
    public static final String AUTH_CHANNEL_WECHAT = "wechat";
    public static final String SAVED_AUTH_DATA = "mAuthorizeData";
    public LBSTransActivity mAct;
    public AuthorizeSignBean mAuthBean;
    public AuthorizeData mAuthorizeData = null;

    public LBSTransAuthPresenter(LBSTransActivity lBSTransActivity) {
        this.mAct = lBSTransActivity;
    }

    public void SaveInstanceState(Bundle bundle) {
        AuthorizeData authorizeData = this.mAuthorizeData;
        if (authorizeData != null) {
            bundle.putSerializable(SAVED_AUTH_DATA, authorizeData);
        }
    }

    public void cancelBean() {
        AuthorizeSignBean authorizeSignBean = this.mAuthBean;
        if (authorizeSignBean != null) {
            authorizeSignBean.destroyBean();
        }
        LBSPayResult.payResult(this.mAct, 2, (String) null);
    }

    public void execBean() {
        if (this.mAuthorizeData != null) {
            AuthorizeSignBean authorizeSignBean = (AuthorizeSignBean) LbsPayBeanFactory.getInstance().getBean((Context) this.mAct, 3, LBSTransActivity.BEAN_TAG);
            this.mAuthBean = authorizeSignBean;
            authorizeSignBean.setAuthorizeData(this.mAuthorizeData);
            this.mAuthBean.setResponseCallback(this.mAct);
            this.mAuthBean.execBean();
        }
    }

    public void handleFailure(int i2, int i3, String str) {
        StatHelper.signServiceEvent(PayStatServiceEvent.LBS_AUTHORIZE_SIGN_RESULT, "-1", str);
        LBSPayResult.payResult((Context) null, 3, str);
        this.mAct.onBackPressedWithoutAnim();
    }

    public void handleResponse(int i2, Object obj, String str) {
        AuthorizeSignContent authorizeSignContent = obj instanceof AuthorizeSignContent ? (AuthorizeSignContent) obj : null;
        if (authorizeSignContent != null) {
            if (AUTH_CHANNEL_ALI.equals(authorizeSignContent.sign_data.sign_channel)) {
                if (!LBSPayAli.getInstance().aliAuthorizeSign(this.mAct, authorizeSignContent.sign_data.sign_url)) {
                    LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.ALIPAY_PAYCHANNEL, "2", "未成功调起支付宝");
                    LBSPayResult.payResult(this.mAct, 2, (String) null);
                }
            } else if ("wechat".equals(authorizeSignContent.sign_data.sign_channel)) {
                AuthorizeSignContent.SignData signData = authorizeSignContent.sign_data;
                String str2 = signData.sign_url;
                String str3 = signData.sign_query_url;
                if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    StatHelper.signServiceEvent(PayStatServiceEvent.LBS_AUTHORIZE_SIGN_RESULT, "-1", this.mAct.getString(R.string.lbspay_pay_id_url_isnull));
                    LBSOriginalPayBackManage.getInstance().originalCallbackResult(PayChannelController.WXPAY_PAYCHANNEL, "3", this.mAct.getString(R.string.lbspay_pay_sign_fail));
                    LBSPayResult.payResult((Context) null, 3, this.mAct.getString(R.string.lbspay_pay_sign_fail));
                } else {
                    StatHelper.signServiceEvent(PayStatServiceEvent.LBS_AUTHORIZE_SIGN_RESULT, "0", this.mAct.getString(R.string.lbspay_pay_sign_success));
                    Intent intent = new Intent(this.mAct, WXSignActivity.class);
                    intent.putExtra(WXSignActivity.WX_PRE_SIGN_ID, str2);
                    intent.putExtra(WXSignActivity.SIGN_REQUEST_URL, str3);
                    this.mAct.startActivity(intent);
                }
            } else {
                StatHelper.signServiceEvent(PayStatServiceEvent.LBS_AUTHORIZE_SIGN_RESULT, "-1", this.mAct.getString(R.string.lbspay_pay_not_wechat_alipay));
                LBSPayResult.payResult(this.mAct, 2, (String) null);
            }
        }
        this.mAct.onBackPressedWithoutAnim();
    }

    public void init(Bundle bundle) {
        LBSTransActivity lBSTransActivity;
        Serializable serializable;
        if (!(bundle == null || (serializable = bundle.getSerializable(SAVED_AUTH_DATA)) == null || !(serializable instanceof AuthorizeData))) {
            this.mAuthorizeData = (AuthorizeData) serializable;
        }
        if (this.mAuthorizeData == null && (lBSTransActivity = this.mAct) != null) {
            this.mAuthorizeData = (AuthorizeData) lBSTransActivity.getIntent().getExtras().get(AuthorizeData.DELIVERY_AUTHORIZE_DATA);
        }
    }
}
