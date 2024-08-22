package com.baidu.poly.wallet.paychannel;

/* compiled from: SearchBox */
public interface ChannelPayCallback {
    public static final String MSG_WX_NOT_INSTALLED = "wx_not_installed";
    public static final String MSG_WX_NOT_VERSION_NOT_SUPPORT = "wx_version_not_supported";
    public static final int PAY_CANCEL = 2;
    public static final int PAY_FAILED = 3;
    public static final int PAY_SUCCESS = 0;
    public static final String PAY_UNKNOWN_MSG = "支付结果查询失败，请重试";
    public static final int PAY_UNKNOWN_STATUS = 6;
    public static final int PAY_WAIT = 1;

    void onResult(int i2, String str);
}
