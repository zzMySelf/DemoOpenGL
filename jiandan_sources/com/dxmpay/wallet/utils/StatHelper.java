package com.dxmpay.wallet.utils;

import android.text.TextUtils;
import com.baidu.sapi2.activity.social.WXLoginActivity;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import com.dxmpay.wallet.utils.realtimeevent.RealTimeEventHelper;
import fe.i.ad.yj.qw;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StatHelper {
    public static final String BANK_CODE = "bank_code";
    public static final String BANK_SIGN_TYPE = "bank_sign_type";
    public static final String BIND_CARD_USER_TYPE = "bind_card_user_type";
    public static final String CARD_TYPE = "card_type";
    public static final String CODE = "code";
    public static final String CURRENT_DOMAIN = "currentDomain";
    public static final String ERROR_CODE = "errorCode";
    public static final String ERROR_MSG = "errorMsg";
    public static final String EVENT_MOLD = "event_mold";
    public static final String EVENT_PATH = "event_path";
    public static final String EVENT_TAG = "event_tag";
    public static final String HASH_ID = "hash";
    public static final String HASH_NAME = "hash_name";
    public static final String HAS_BANK_CARD = "has_bank_card";
    public static final String LBS_PAY_CHANNEL = "2";
    public static final String LBS_SIGN_QUERY_FAIL = "-1";
    public static final String LBS_SIGN_QUERY_OK = "0";
    public static final String MSG = "msg";
    public static final String PAGE_ID = "page_id";
    public static final String PAGE_NAME = "page_name";
    public static final String PAY_AMOUNT = "pay_amount";
    public static final String PAY_BANKSIGN = "pay_banksign";
    public static final String PAY_CATEGORY = "pay_category";
    public static final String PAY_FROM = "pay_from";
    public static final String PAY_SDK_AUTO_ACTION = "paysdk_auto_action";
    public static final String PAY_SDK_CASHDESH_PAY_ID = "paySDKCashDeshPay";
    public static final String PAY_SDK_CASHDESH_PAY_NAME = "支付SDK收银台支付流程";
    public static final String PAY_SDK_EVENT_PATH = "paySDK_";
    public static final String PAY_SDK_INITIATIVE_BIND_CARD_ID = "paySDKInitiativeBindCard";
    public static final String PAY_SDK_INITIATIVE_BIND_CARD_NAME = "支付SDK主动绑卡流程";
    public static final int PAY_SENSOR_0 = 0;
    public static final int PAY_SENSOR_1 = 1;
    public static final int PAY_SENSOR_2 = 2;
    public static final int PAY_SENSOR_3 = 3;
    public static final int PAY_SENSOR_4 = 4;
    public static final String PAY_WAY = "pay_way";
    public static final String PRECASHIER_PAY_CHANNEL = "1";
    public static final String REMOTE_PAY_CHANNEL = "3";
    public static final String REQ_URI = "req_uri";
    public static final String SENSOR_0 = "0";
    public static final String SENSOR_1 = "1";
    public static final String SENSOR_2 = "2";
    public static final String SENSOR_ERR_1 = "-1";
    public static final String SENSOR_ERR_2 = "-2";
    public static final String SENSOR_OK = "OK";
    public static final String SIGN_PAY = "sign_pay";
    public static final String SIGN_PAY_CHANNEL = "4";
    public static final String SP_NO = "sp_no";
    public static final String STD_PAY_CHANNEL = "0";

    /* renamed from: ad  reason: collision with root package name */
    public static boolean f4372ad = false;

    /* renamed from: de  reason: collision with root package name */
    public static String f4373de = "";
    public static boolean qw = false;

    public enum Key {
        orderNo,
        spNo,
        fromPkg,
        hasPwd,
        payType,
        payWay,
        orderId,
        channelId,
        passLoginStatus,
        sessionId,
        payAmount,
        precashierMark,
        bankCode,
        cardType,
        payFrom,
        bindCardUserType,
        signPay,
        hasBankCard,
        code,
        msg,
        bankCardStartTime,
        alipayVersion,
        useOcrBankCard,
        realityBankCard,
        signChannel
    }

    public static void ad(String str, Map<String, Object> map, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            List<String> collectData = collectData(getOrderNo(), getHasPwd(), getPayType(), getPayWay());
            if (strArr != null) {
                for (String add : strArr) {
                    collectData.add(add);
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put(SP_NO, getSpNo());
            hashMap.put("pay_amount", getPayAmount());
            hashMap.put(BANK_CODE, getBankCode());
            hashMap.put(CARD_TYPE, getCardType());
            hashMap.put("pay_from", getPayFrom());
            hashMap.put(HAS_BANK_CARD, getHasBankCard());
            if (qw) {
                hashMap.put(PAY_BANKSIGN, "1");
            }
            if (f4372ad) {
                hashMap.put(PAY_CATEGORY, "1");
            }
            if ("4".equals(getPayFrom())) {
                hashMap.put(SIGN_PAY, getSignPay());
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    hashMap.put(next.getKey(), next.getValue());
                }
            }
            StatisticManager.onEventWithValues(str, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        }
    }

    public static void bankCardDetction(String str, String str2) {
        bankCardDetctionDuration(str, str2, -1);
    }

    public static void bankCardDetctionDuration(String str, String str2, long j) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(getPayFrom())) {
            arrayList.add(getSessionId());
            hashMap.put(BIND_CARD_USER_TYPE, getBindCardUserType());
        } else {
            arrayList.add(getOrderNo());
            arrayList.add(getHasPwd());
            hashMap.put("pay_from", getPayFrom());
        }
        arrayList.add(getUseOcrBankCard() + "");
        arrayList.add(getRealityBankCard() + "");
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put(WXLoginActivity.y, str2);
        }
        if (j >= 0) {
            hashMap.put("duration", Long.valueOf(j));
        }
        StatisticManager.onEventWithValues(str, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
    }

    public static void cacheAlipayVersion(String str) {
        qw.de(Key.alipayVersion.name(), str);
    }

    public static void cacheBankCardStartTime(long j) {
        qw.de(Key.bankCardStartTime.name(), Long.valueOf(j));
    }

    public static void cacheBankCode(String str) {
        qw.de(Key.bankCode.name(), str);
    }

    public static void cacheBindCardUserType(String str) {
        qw.de(Key.bindCardUserType.name(), str);
    }

    public static void cacheCardType(String str) {
        qw.de(Key.cardType.name(), str);
    }

    public static void cacheChannelId(String str) {
        qw.de(Key.channelId.name(), str);
    }

    public static void cacheCodeAndMsg(String str, String str2) {
        qw.de(Key.code.name(), str);
        qw.de(Key.msg.name(), str2);
    }

    public static void cacheFromPkg(String str) {
        qw.de(Key.fromPkg.name(), str);
    }

    public static void cacheHasBankCard(boolean z) {
        qw.de(Key.hasBankCard.name(), z ? "1" : "0");
    }

    public static void cacheHasPwd(boolean z) {
        qw.de(Key.hasPwd.name(), z ? "1" : "0");
    }

    public static void cacheOrderId(String str) {
        qw.de(Key.orderId.name(), str);
    }

    public static void cacheOrderNo(String str) {
        qw.de(Key.orderNo.name(), str);
    }

    public static void cachePassLoginStatus(String str) {
        qw.de(Key.passLoginStatus.name(), str);
    }

    public static void cachePayAmount(double d) {
        qw.de(Key.payAmount.name(), Double.valueOf(d));
    }

    public static void cachePayFrom(String str) {
        qw.de(Key.payFrom.name(), str);
    }

    public static void cachePayType(int i2) {
        qw.de(Key.payType.name(), String.valueOf(i2));
    }

    public static void cachePayWay(int i2) {
        qw.de(Key.payWay.name(), String.valueOf(i2));
    }

    public static void cacheRealityBankCard(int i2) {
        qw.de(Key.realityBankCard.name(), Integer.valueOf(i2));
    }

    public static void cacheSessionId(String str) {
        qw.de(Key.sessionId.name(), str);
    }

    public static void cacheSignChannel(String str) {
        qw.de(Key.signChannel.name(), str);
    }

    public static void cacheSignPay(String str) {
        qw.de(Key.signPay.name(), str);
    }

    public static void cacheSpNo(String str) {
        qw.de(Key.spNo.name(), str);
    }

    public static void cacheUseOcrBankCard(int i2) {
        qw.de(Key.useOcrBankCard.name(), Integer.valueOf(i2));
    }

    public static void clearProcesssId() {
        f4373de = null;
    }

    public static void clearSensor() {
        qw.de(Key.payWay.name(), (Object) null);
        qw.de(Key.payType.name(), (Object) null);
        qw.de(Key.hasPwd.name(), (Object) null);
        qw.de(Key.bankCode.name(), (Object) null);
        qw.de(Key.cardType.name(), (Object) null);
        qw.de(Key.orderNo.name(), (Object) null);
        qw.de(Key.spNo.name(), (Object) null);
        qw.de(Key.orderId.name(), (Object) null);
        qw.de(Key.channelId.name(), (Object) null);
        qw.de(Key.sessionId.name(), (Object) null);
        qw.de(Key.payAmount.name(), (Object) null);
        qw.de(Key.bindCardUserType.name(), (Object) null);
        qw.de(Key.payFrom.name(), (Object) null);
        qw.de(Key.signPay.name(), (Object) null);
        qw.de(Key.code.name(), (Object) null);
        qw.de(Key.msg.name(), (Object) null);
        qw.de(Key.alipayVersion.name(), (Object) null);
        qw.de(Key.signChannel.name(), (Object) null);
        qw = false;
        f4372ad = false;
    }

    public static List<String> collectData(String str, String... strArr) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            arrayList.add(str);
        }
        for (String add : strArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static void de(String str, Map<String, Object> map, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            List<String> collectData = collectData(getSessionId(), new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put(BIND_CARD_USER_TYPE, getBindCardUserType());
            if (strArr != null) {
                for (String add : strArr) {
                    collectData.add(add);
                }
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    hashMap.put(next.getKey(), next.getValue());
                }
            }
            StatisticManager.onEventWithValues(str, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        }
    }

    public static double fen2YuanBigDecimal(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        try {
            return new BigDecimal(str).divide(BigDecimal.valueOf(100)).setScale(2, 4).doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static String getAlipayVersion() {
        return (String) qw.ad(Key.alipayVersion.name());
    }

    public static long getBankCardStartTime() {
        Object ad2 = qw.ad(Key.bankCardStartTime.name());
        if (ad2 == null) {
            return 0;
        }
        return ((Long) ad2).longValue();
    }

    public static String getBankCode() {
        return (String) qw.ad(Key.bankCode.name());
    }

    public static String getBindCardUserType() {
        return (String) qw.ad(Key.bindCardUserType.name());
    }

    public static String getCardType() {
        return (String) qw.ad(Key.cardType.name());
    }

    public static String getChannelId() {
        return (String) qw.ad(Key.channelId.name());
    }

    public static String getCode() {
        return (String) qw.ad(Key.code.name());
    }

    public static String getFromPkg() {
        return (String) qw.ad(Key.fromPkg.name());
    }

    public static String getHasBankCard() {
        return (String) qw.ad(Key.hasBankCard.name());
    }

    public static String getHasPwd() {
        return (String) qw.ad(Key.hasPwd.name());
    }

    public static String getMsg() {
        return (String) qw.ad(Key.msg.name());
    }

    public static String getOrderId() {
        return (String) qw.ad(Key.orderId.name());
    }

    public static String getOrderNo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return RealTimeEventHelper.getSinalParam(str, "order_no");
    }

    public static String getPassLoginStatus() {
        return (String) qw.ad(Key.passLoginStatus.name());
    }

    public static String getPayAmount(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return RealTimeEventHelper.getSinalParam(str, "total_amount");
    }

    public static String getPayFrom() {
        return (String) qw.ad(Key.payFrom.name());
    }

    public static String getPayType() {
        return (String) qw.ad(Key.payType.name());
    }

    public static String getPayWay() {
        return (String) qw.ad(Key.payWay.name());
    }

    public static String getProcesssId() {
        if (!TextUtils.isEmpty(f4373de)) {
            return f4373de;
        }
        String qw2 = qw();
        f4373de = qw2;
        return qw2;
    }

    public static String getPureSign(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return RealTimeEventHelper.getSinalParam(str, "pure_sign");
    }

    public static int getRealityBankCard() {
        return ((Integer) qw.ad(Key.realityBankCard.name())).intValue();
    }

    public static String getSessionId() {
        return (String) qw.ad(Key.sessionId.name());
    }

    public static String getSignChannel() {
        return (String) qw.ad(Key.signChannel.name());
    }

    public static String getSignPay() {
        return (String) qw.ad(Key.signPay.name());
    }

    public static String getSpNo(String str) {
        return RealTimeEventHelper.getSinalParam(str, SP_NO);
    }

    public static int getUseOcrBankCard() {
        return ((Integer) qw.ad(Key.useOcrBankCard.name())).intValue();
    }

    public static boolean isPrecashierPay(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals(qw.ad(Key.precashierMark.name()));
    }

    public static void payEventEndWithValues(String str, Map<String, Object> map, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            List<String> collectData = collectData(getOrderNo(), new String[0]);
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", getPayFrom());
            hashMap.put("code", getCode());
            hashMap.put("msg", getMsg());
            if (strArr != null) {
                for (String add : strArr) {
                    collectData.add(add);
                }
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    hashMap.put(next.getKey(), next.getValue());
                }
            }
            StatisticManager.onEventEndWithValues(str, (Collection<String>) collectData, (Map<String, Object>) hashMap);
        }
    }

    public static void payLoginSeneor(String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pay_from", getPayFrom());
            ArrayList arrayList = new ArrayList();
            arrayList.add(getOrderNo());
            arrayList.add(getSpNo());
            if (strArr != null) {
                for (String add : strArr) {
                    arrayList.add(add);
                }
            }
            StatisticManager.onEventWithValues(str, (Collection<String>) arrayList, (Map<String, Object>) hashMap);
        }
    }

    public static String qw() {
        String uuid = UUID.randomUUID().toString();
        return !TextUtils.isEmpty(uuid) ? uuid.replace("-", "") : uuid;
    }

    public static void setDowngrade(boolean z) {
        f4372ad = z;
    }

    public static void setPayBankSign(boolean z) {
        qw = z;
    }

    public static void setPrecashierMark(String str) {
        qw.de(Key.precashierMark.name(), str);
    }

    public static void signServiceEvent(String str, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            List<String> collectData = collectData(getOrderId(), getSignChannel());
            if (strArr != null) {
                for (String add : strArr) {
                    collectData.add(add);
                }
            }
            StatisticManager.onEventWithValues(str, collectData);
        }
    }

    public static void statPayAllServiceEvent(String str, String str2, String str3, String str4, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(PAGE_NAME, PAY_SDK_CASHDESH_PAY_NAME);
            hashMap.put(PAGE_ID, PAY_SDK_CASHDESH_PAY_ID);
            hashMap.put(HASH_NAME, str2);
            hashMap.put("hash", str3);
            hashMap.put(EVENT_TAG, str4);
            hashMap.put(EVENT_PATH, PAY_SDK_EVENT_PATH + str);
            hashMap.put(EVENT_MOLD, PAY_SDK_AUTO_ACTION);
            statServiceEvent(str, hashMap, strArr);
        }
    }

    public static void statServiceEvent(String str) {
        if (!TextUtils.isEmpty(str)) {
            statServiceEvent(str, (Map<String, Object>) null, new String[0]);
        }
    }

    public static String getSpNo() {
        return (String) qw.ad(Key.spNo.name());
    }

    public static String getOrderNo() {
        return (String) qw.ad(Key.orderNo.name());
    }

    public static Double getPayAmount() {
        return (Double) qw.ad(Key.payAmount.name());
    }

    public static void statServiceEvent(String str, Map<String, Object> map, String... strArr) {
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(getPayFrom())) {
                de(str, map, strArr);
            } else {
                ad(str, map, strArr);
            }
        }
    }
}
