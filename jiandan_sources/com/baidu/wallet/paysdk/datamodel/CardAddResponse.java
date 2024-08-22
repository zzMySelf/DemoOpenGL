package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.dxmpay.wallet.base.datamodel.UserData;
import java.io.Serializable;
import java.util.Map;

public class CardAddResponse extends DirectPayContentResponse {
    public static final String CHECK_PWD_TYPE_DIGIT = "digit";
    public static final String CHECK_PWD_TYPE_FINGER = "finger";
    public QuickBindCardList[] bank_list;
    public int bind_card_num;
    public ConfirmWindow confirm_window;
    public CustomerSvcCfg intelligent_service;
    public String marketing_prompt;
    public Map<String, String> marketing_support_bank;
    public String marketing_top_title;
    public int request_type;
    public SupportPwdInfo[] support_pwd_info;

    public static class ConfirmWindow implements Serializable {
        public String btn_name;
        public String content;
        public String title;
    }

    public static class CustomerSvcCfg implements Serializable {
        public String customer_service_copy = "";
        public String customer_service_icon = "";
        public String customer_service_url = "";
    }

    public static class QuickBindCardList implements Serializable {
        public String bank_icon_url;
        public String bank_name;
        public String bank_uniq_code;
        public String marketing_tips_info;
        public QuickBindCardTypeList[] type;
    }

    public static class QuickBindCardTypeList implements Serializable {
        public String card_type;
        public String front_bank_code;
    }

    public static class SupportPwdInfo implements Serializable {
        public int max_retry;
        public String verify_type;
    }

    public static class a {
        public static CardAddResponse a = new CardAddResponse();
    }

    public static CardAddResponse getInstance() {
        return a.a;
    }

    public static void updateContent(Object obj) {
        if (obj instanceof CardAddResponse) {
            CardAddResponse unused = a.a = (CardAddResponse) obj;
        }
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public boolean hasBindCards() {
        return this.bind_card_num > 0;
    }

    public void storeResponse(Context context) {
        UserData.UserModel userModel = this.user;
        if (userModel != null) {
            userModel.decrypt();
        }
        super.storeResponse(context);
    }
}
