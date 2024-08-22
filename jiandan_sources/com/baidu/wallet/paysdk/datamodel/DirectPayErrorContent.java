package com.baidu.wallet.paysdk.datamodel;

import java.io.Serializable;

public class DirectPayErrorContent implements Serializable {
    public static final long serialVersionUID = 3623785623246088032L;
    public String auth_url_sdk;
    public String no_need_downgrade_retry;
    public String order_url;
}
