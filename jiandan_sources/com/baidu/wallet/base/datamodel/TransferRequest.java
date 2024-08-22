package com.baidu.wallet.base.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.core.beans.BeanRequestBase;
import java.io.Serializable;

public class TransferRequest extends BeanRequestBase implements Serializable {
    public static final int TRANSFER_TO_ACCOUNT = 2;
    public static final int TRANSFER_TO_CARD = 1;
    public static final long serialVersionUID = -2837911236870472628L;
    public String mAccount;
    public String mAccountToDisplay = "";
    public String mAmountDefaultHint;
    public String mCardNo;
    public String mCashdeskParam = "";
    public String mChannelNo;
    public String mCheckName = "";
    public String mCosttimeDesp;
    public String mIconShow = "";
    public String mIdTpl = "0";
    public String mInputAmount;
    public boolean mIsUnregesterPhone = false;
    public String mOrderIdExt;
    public String mPayAmount;
    public String mPayType = "";
    public String mPayeeBankCode;
    public String mPayeeBankName;
    public String mPayeeCanCheck;
    public String mPayeeIsAuthod;
    public String mPayeeMobile;
    public String mPayeeName;
    public String mPayeeReason;
    public String mPayeeSpName;
    public String mPayee_type;
    public String mPayerBankName;
    public String mPayerIconShow = "";
    public String mPreCashdesk;
    public String mSerialNum;
    public String mSuggetNotifyPayeeMobileBack;
    public String mSuggetNotifyPayeeMobileShow;
    public TransferArriveInfo mTransferArriveInfo;
    public String mTransferArriveType;
    public String mTransferBankCardArriveTime;
    public int mTransferType;
    public String mTrueName = "";
    public String qrcode;

    public boolean checkRequestValidity() {
        if (this.mTransferType == 1) {
            if (TextUtils.isEmpty(this.mPayAmount) || TextUtils.isEmpty(this.mPayeeName) || TextUtils.isEmpty(this.mAccount)) {
                return false;
            }
            return true;
        } else if (TextUtils.isEmpty(this.mPayAmount) || TextUtils.isEmpty(this.mAccount)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean checkRequestValidityWithOutPayAmount() {
        if (this.mTransferType != 1) {
            return !TextUtils.isEmpty(this.mAccount);
        }
        if (TextUtils.isEmpty(this.mPayeeName) || TextUtils.isEmpty(this.mAccount)) {
            return false;
        }
        return true;
    }

    public String getRequestId() {
        return "request_id_transfer";
    }
}
