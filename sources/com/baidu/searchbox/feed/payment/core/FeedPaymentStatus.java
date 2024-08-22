package com.baidu.searchbox.feed.payment.core;

public class FeedPaymentStatus {
    public static final int NET_DISCOUNT_BALANCE_NOT_ENOUGH = 60001005;
    private static final int NET_DISCOUNT_CANNOT_USE = 60001008;
    private static final int NET_DISCOUNT_FINISH = 60001004;
    private static final int NET_DISCOUNT_PRICE_ERROR = 60001009;
    private static final int NET_DISCOUNT_SERVER_ERROR = 60001010;
    private static final int NET_RESTORE_ORIGINAL_PRICE = 60001007;
    public static final int NET_RESULT_DUPLICATE = 60001003;
    public static final int NET_RESULT_HAS_BOUGHT = 1;
    public static final int NET_RESULT_OK = 0;
    public static final String PAY_RESULT_GETTING = "领取中";
    public static final String PAY_RESULT_MSG_CANCEL = "购买已取消";
    public static final String PAY_RESULT_MSG_FAIL = "支付失败";
    public static final String PAY_RESULT_MSG_FAIL_NOT_INSTALL_WX = "没有安装微信，请选择其他支付方式";
    public static final String PAY_RESULT_MSG_NOT_INSTALL_WX = "wx_not_installed";
    public static final String PAY_RESULT_MSG_OPEN_PAY_PANEL = "调起支付";
    public static final String PAY_RESULT_MSG_ORDER_DUPLICATE = "请勿重复购买";
    public static final String PAY_RESULT_MSG_ORDER_ERROR = "创建订单失败";
    public static final String PAY_RESULT_MSG_ORDER_START = "下单中";
    public static final String PAY_RESULT_MSG_ORDER_SUCCESS = "创建订单成功";
    public static final String PAY_RESULT_MSG_SUCCESS = "支付成功";
    public static final String PAY_RESULT_PAYING = "支付中";
    public static final String PAY_RESULT_RECHARGED = "充值中";
    public static final int SDK_ERROR_NOT_INSTALL_WX = 4;
    public static final int SDK_ERROR_PAY_CANCEL = 2;
    public static final int STATUS_CODE_BALANCE_NOT_ENOUGH = 12;
    public static final int STATUS_CODE_CHARGED_SUCCESS = 11;
    public static final int STATUS_CODE_FAIL_DISCOUNT_ERROR = 10;
    public static final int STATUS_CODE_FAIL_NET_ERROR = 8;
    public static final int STATUS_CODE_FAIL_OTHER_ERROR = -1;
    public static final int STATUS_CODE_FAIL_SERVER_ERROR = 9;
    public static final int STATUS_CODE_OPEN_PAY_PANEL = 30;
    public static final int STATUS_CODE_ORDER_DUPLICATE = 23;
    public static final int STATUS_CODE_ORDER_FAIL = 22;
    public static final int STATUS_CODE_ORDER_START = 20;
    public static final int STATUS_CODE_ORDER_SUCCESS = 21;
    public static final int STATUS_CODE_PAYING = 1;
    public static final int STATUS_CODE_PAY_CANCEL = 2;
    public static final int STATUS_CODE_PAY_FAIL = 3;
    public static final int STATUS_CODE_PAY_FAIL_CHECK_ERROR = 5;
    public static final int STATUS_CODE_PAY_FAIL_NOT_INSTALL_WX = 4;
    public static final int STATUS_CODE_PAY_FAIL_SDK_ERROR = 6;
    public static final int STATUS_CODE_PAY_SUCCESS = 0;

    public static String netCode(int code) {
        return String.valueOf(code);
    }

    public static int adaptNetError(int errorCode) {
        if (errorCode == 60001003) {
            return 23;
        }
        if (errorCode == NET_DISCOUNT_PRICE_ERROR || errorCode == NET_DISCOUNT_SERVER_ERROR || errorCode == NET_DISCOUNT_CANNOT_USE || errorCode == NET_DISCOUNT_FINISH) {
            return 10;
        }
        return -1;
    }

    public static int adaptSDKError(int sdkCode) {
        if (sdkCode == 2) {
            return 2;
        }
        if (sdkCode == 4) {
            return 4;
        }
        return 6;
    }

    public static boolean isSDKError(int statusCode) {
        return statusCode == 2 || statusCode == 4 || statusCode == 6;
    }
}
