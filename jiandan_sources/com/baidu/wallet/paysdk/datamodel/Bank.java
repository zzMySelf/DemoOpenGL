package com.baidu.wallet.paysdk.datamodel;

import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class Bank implements NoProguard, Serializable {
    public static final String HOT_BANK_LETTER = "#";
    public static final long serialVersionUID = 1;
    public String bank_code = "";
    public String display_letter = HOT_BANK_LETTER;
    public String display_name = "";
    public String is_hot;
    public String logo_url;
}
