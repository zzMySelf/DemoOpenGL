package com.baidu.wallet.base.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class Authorize implements NoProguard, Serializable {
    public static final long serialVersionUID = 8230495073093947333L;
    public AgreementInfo agreement_info;
    public String agreement_tag;
    public String authorize_action_desc;
    public String[] authorize_desc;
    public String cashback_desc;
    public AuthDetailInfo detail_info;
    public Extra extra;
    public String promotion_desc;
    public String pure_sign;
    public String sign_day_pay_limit;
    public String sp_company_title;
    public String sp_logo_url;
    public String status;
    public String title_url;
    public String top_title;

    public static class AgreementInfo extends GetCardInfoResponse.ProtocolInfo {
        public String agreement_tag;

        public boolean isProtocolCheckedDefault() {
            return "1".equals(this.agreement_tag);
        }
    }

    public static class AuthDetailInfo implements NoProguard, Serializable {
        public String[] detail;
        public String introduce;
    }

    public static class Extra implements NoProguard, Serializable {
        public String fee_tip;
    }

    public boolean isResonseValide() {
        return !TextUtils.isEmpty(this.pure_sign);
    }
}
