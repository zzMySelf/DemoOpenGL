package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.Serializable;
import java.util.List;

public class UserInfoContentResponse implements IBeanResponse, Serializable {
    public static final String TAG = "UserInfoContentResponse";
    public BindCardListBean[] bind_card_list;
    public CardExtInfoBean card_ext_info;
    public String token;
    public UserBean user_info;

    public static class BindCardListBean implements NoProguard, Serializable {
        public String account_no;
        public String background_url;
        public String bank_code;
        public String bank_name;
        public String bank_url;
        public String bind_time;
        public String card_type;
        public String certificate_code;
        public String certificate_code_ec;
        public String certificate_type;
        public String foreign_card;
        public String is_need_repaired;
        public String is_need_repaired_ext;
        public String is_support_withdraw;
        public String mobile;
        public String mobile_ec;
        public String true_name;
        public String type_name;
        public List<String> unbind_tips;
        public String unbund_card_desc;
        public String unbund_card_enabled;
        public String valid_date;
        public String verify_code;

        public void decrypt() {
            try {
                if (!TextUtils.isEmpty(this.certificate_code_ec)) {
                    this.certificate_code = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.certificate_code_ec));
                }
                if (!TextUtils.isEmpty(this.mobile_ec)) {
                    this.mobile = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.mobile_ec));
                }
            } catch (Exception e) {
                LogUtil.e(UserInfoContentResponse.TAG, e.getMessage(), e);
            }
        }
    }

    public static class CardExtInfoBean implements NoProguard, Serializable {
        public String bank_card_detect_enabled;
        public String can_bind_card_flag;
    }

    public static class UserBean implements NoProguard, Serializable {
        public AccountBean account;
        public String certificate_code;
        public String certificate_code_ec;
        public String certificate_type;
        public DisplayFlagBean display_flag;
        public String display_name;
        public int has_mobile_password;
        public String is_bind;
        public String is_semi_account;
        public String mobile_ec;
        public String mobile_number;
        public String pay_type_default;
        public String true_name;

        public static class AccountBean implements Serializable {
            public String available_withdraw_amount;
            public String balance_amount;
            public String can_amount;
            public String freeze_amount;
            public String virtual_amount;
        }

        public static class DisplayFlagBean implements Serializable {
            public String certificate_code;
            public String certificate_type;
            public String mobile;
            public String true_name;
        }

        public void decrypt() {
            try {
                if (!TextUtils.isEmpty(this.certificate_code_ec)) {
                    this.certificate_code = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.certificate_code_ec));
                }
                if (!TextUtils.isEmpty(this.mobile_ec)) {
                    this.mobile_number = SecurePay.unicodeDecode(SecurePay.getInstance().localDecryptProxy(this.mobile_ec));
                }
            } catch (Exception e) {
                LogUtil.e(UserInfoContentResponse.TAG, e.getMessage(), e);
            }
        }

        public boolean hasMobilePwd() {
            return this.has_mobile_password == 1;
        }
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public void decrypt() {
        BindCardListBean[] bindCardListBeanArr = this.bind_card_list;
        if (bindCardListBeanArr != null && bindCardListBeanArr.length > 0) {
            for (BindCardListBean decrypt : bindCardListBeanArr) {
                decrypt.decrypt();
            }
        }
    }

    public void storeResponse(Context context) {
    }
}
