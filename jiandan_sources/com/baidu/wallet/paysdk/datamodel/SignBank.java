package com.baidu.wallet.paysdk.datamodel;

import com.dxmpay.wallet.core.NoProguard;
import java.io.Serializable;

public class SignBank implements NoProguard, Serializable {
    public static final long serialVersionUID = 1;
    public String bank_code = "";
    public String bank_name = "";
    public String bank_url;
}
