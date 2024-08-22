package com.baidu.wallet.base.datamodel;

import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class Withholding implements NoProguard, Serializable {
    public AgreementInfo[] agreement_info;
    public String agreement_tag;
    public String authorize_action_desc;
    public String[] authorize_desc;
    public DetailInfo detail_info;
    public String disabled_msg;
    public String sp_company;
    public String sp_log_url;
    public String status;

    public static class AgreementInfo implements NoProguard, Serializable {
        public String title;
        public String url;
    }

    public static class DetailInfo implements NoProguard, Serializable {
        public String[] detail;
        public String introduce;
    }
}
