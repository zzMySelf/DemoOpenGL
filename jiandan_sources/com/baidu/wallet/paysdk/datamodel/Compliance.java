package com.baidu.wallet.paysdk.datamodel;

import java.io.Serializable;

public class Compliance implements Serializable {
    public AntiMoneyLaundering anti_money_laundering;

    public static class AntiMoneyLaundering implements Serializable {
        public int after_pay_identity;
        public String auth_msg;
        public String sdk_auth_url;
    }
}
