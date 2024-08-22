package com.baidu.android.lbspay.channelpay;

import com.baidu.android.lbspay.channelpay.alipay.ChannelAliPay;
import com.baidu.android.lbspay.channelpay.baidu.ChannelBaiduPay;
import com.baidu.android.lbspay.channelpay.fast.ChannelFastPay;
import com.baidu.android.lbspay.channelpay.wxpay.ChannelWXPay;
import com.baidu.android.lbspay.presenter.LBSTransAuthPresenter;
import com.baidu.android.lbspay.utils.PayMode;
import com.baidu.android.util.io.PathUtils;
import com.dxmpay.wallet.core.utils.LogUtil;

public class ChannelPayUtil {
    public static final String TAG = "ChannelPayUtil";

    public static IChannelPay getChannelPay(int i2) {
        "channelId=" + i2;
        if (i2 != -3) {
            if (i2 != -2) {
                if (i2 != -1) {
                    if (i2 == 105) {
                        return new ChannelAliPay();
                    }
                    if (i2 != 107) {
                        if (i2 != 126) {
                            if (i2 == 158) {
                                return ChannelWXPay.getInstance();
                            }
                            if (!(i2 == 175 || i2 == 178)) {
                                switch (i2) {
                                    case IChannelPay.ID_IPAY_PAY_RECHARGEABLE_CARD /*163*/:
                                    case IChannelPay.ID_IPAY_PAY_GAME /*164*/:
                                    case IChannelPay.ID_IPAY_PAY_SMS /*165*/:
                                    case IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE /*166*/:
                                        try {
                                            Class<?> cls = Class.forName("com.baidu.android.lbspay.channelpay.ipay.ChannelIpay");
                                            if (cls != null) {
                                                return (IChannelPay) cls.newInstance();
                                            }
                                        } catch (Exception e) {
                                            LogUtil.e(TAG, e.getMessage(), e);
                                        }
                                        return null;
                                    default:
                                        return null;
                                }
                            }
                        }
                    }
                }
            }
            return new ChannelBaiduPay();
        }
        return new ChannelFastPay();
    }

    public static String getChannelTag(int i2) {
        "channelId=" + i2;
        if (i2 == -2) {
            return "wise_card";
        }
        if (i2 == -1) {
            return "card_pay";
        }
        if (i2 == 105) {
            return LBSTransAuthPresenter.AUTH_CHANNEL_ALI;
        }
        if (i2 == 107) {
            return "fast_pay";
        }
        if (i2 == 126) {
            return PathUtils.DIRCTORY_BAIDU;
        }
        if (i2 == 158) {
            return "wxpay";
        }
        if (i2 == 178) {
            return "ipay";
        }
        switch (i2) {
            case IChannelPay.ID_IPAY_PAY_RECHARGEABLE_CARD /*163*/:
            case IChannelPay.ID_IPAY_PAY_GAME /*164*/:
            case IChannelPay.ID_IPAY_PAY_SMS /*165*/:
            case IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE /*166*/:
                return "ipay";
            default:
                return "";
        }
    }

    public static PayMode getPayMode(int i2) {
        "channelId=" + i2;
        if (getChannelPay(i2) == null) {
            return PayMode.unknownPay;
        }
        if (i2 == -2) {
            return PayMode.BaiduCardPay;
        }
        if (i2 == -1) {
            return PayMode.CardPay;
        }
        if (i2 == 105) {
            return PayMode.AliPay;
        }
        if (i2 == 107) {
            return PayMode.FastPay;
        }
        if (i2 == 126) {
            return PayMode.BaiduPay;
        }
        if (i2 == 158) {
            return PayMode.WXPay;
        }
        if (i2 == 178) {
            return PayMode.BankCard;
        }
        switch (i2) {
            case IChannelPay.ID_IPAY_PAY_RECHARGEABLE_CARD /*163*/:
                return PayMode.IPAYRECHARGECARD;
            case IChannelPay.ID_IPAY_PAY_GAME /*164*/:
                return PayMode.IPayGame;
            case IChannelPay.ID_IPAY_PAY_SMS /*165*/:
                return PayMode.IPAYSMS;
            case IChannelPay.ID_IPAY_PAY_VIRTUALBALANCE /*166*/:
                return PayMode.IPAYBALANCE;
            default:
                return PayMode.unknownPay;
        }
    }
}
