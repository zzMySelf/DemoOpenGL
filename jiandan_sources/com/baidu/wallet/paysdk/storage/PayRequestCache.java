package com.baidu.wallet.paysdk.storage;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.api.BaiduPay;
import com.baidu.wallet.paysdk.beans.DxmPayBeanConstants;
import com.baidu.wallet.paysdk.datamodel.BindFastRequest;
import com.baidu.wallet.paysdk.datamodel.PayRequest;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.beans.BeanRequestBase;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class PayRequestCache implements NoProguard {
    public final HashMap<String, BeanRequestBase> a;

    public enum BindCategory {
        Other(0),
        Initiative(11),
        Pwd(4);
        
        public int mScenario;

        /* access modifiers changed from: public */
        BindCategory(int i2) {
            this.mScenario = i2;
        }

        public static BindCategory from(int i2) {
            if (11 == i2) {
                return Initiative;
            }
            if (4 == i2) {
                return Pwd;
            }
            return Other;
        }

        public int getScenario() {
            return this.mScenario;
        }
    }

    public static class a {
        public static PayRequestCache a = new PayRequestCache();
    }

    public static BindFastRequest getBindRequest(Activity activity) {
        BindCategory bindCategory = BindCategory.Other;
        if (activity != null) {
            bindCategory = getInstance().getBindCategoryByIntent(activity.getIntent());
        }
        return (BindFastRequest) getInstance().getRequest(bindCategory);
    }

    public static PayRequestCache getInstance() {
        return a.a;
    }

    public void addBeanRequestToCache(String str, BeanRequestBase beanRequestBase) {
        if (str != null && !str.equals("") && beanRequestBase != null) {
            this.a.put(str, beanRequestBase);
        }
    }

    public void clearPaySdkRequestCache() {
        LogUtil.e(PayRequestCache.class.getSimpleName(), "clearPaySdkRequestCache", (Throwable) null);
        Set<String> keySet = this.a.keySet();
        HashSet<String> hashSet = new HashSet<>();
        for (String next : keySet) {
            if (this.a.get(next) != null && this.a.get(next).mBelongPaySdk) {
                hashSet.add(next);
            }
        }
        for (String removeBeanRequestFromCache : hashSet) {
            removeBeanRequestFromCache(removeBeanRequestFromCache);
        }
    }

    public void clearRequestCache() {
        this.a.clear();
    }

    public BeanRequestBase getBeanRequestFromCache(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        return this.a.get(str);
    }

    public BindCategory getBindCategoryByIntent(Intent intent) {
        if (intent == null) {
            return BindCategory.Other;
        }
        BindCategory bindCategory = BindCategory.Other;
        String stringExtra = intent.getStringExtra("baidu.wallet.from");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                bindCategory = BindCategory.valueOf(stringExtra);
                if (isPaying()) {
                    return BindCategory.Other;
                }
            } catch (Exception e) {
                LogUtil.e("PayRequestCache", e.getMessage(), e);
            }
        }
        return bindCategory;
    }

    public BeanRequestBase getRequest(BindCategory bindCategory) {
        if (bindCategory == null) {
            return null;
        }
        return getBeanRequestFromCache(bindCategory.name());
    }

    public CardData.BondCard getSelectCard() {
        PayRequest.PayPrice payPrice;
        PayRequest payRequest = (PayRequest) getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        if (payRequest == null || (payPrice = payRequest.getPayPrice()) == null || payPrice.payType != PayRequest.PayPrice.PayType.BANKCARD) {
            return null;
        }
        return payRequest.mBondCard;
    }

    public boolean isAuthFastPay() {
        BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
        return bindFastRequest != null && bindFastRequest.getmBindFrom() == 8;
    }

    public boolean isBondPay() {
        if (!PayDataCache.getInstance().hasBondCards()) {
            return false;
        }
        PayRequest payRequest = (PayRequest) getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
        if (payRequest == null || payRequest.getPayPrice().payType != PayRequest.PayPrice.PayType.BANKCARD || payRequest.mBondCard == null) {
            return false;
        }
        int indexOf = Arrays.asList(PayDataCache.getInstance().getBondCards()).indexOf(payRequest.mBondCard);
        if (bindFastRequest == null || !payRequest.mBondCard.equals(bindFastRequest.mBondCard)) {
            if (indexOf >= 0) {
                return true;
            }
            return false;
        } else if (isCompletePay() || isAuthFastPay() || indexOf < 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isCompletePay() {
        BindFastRequest bindFastRequest = (BindFastRequest) getBeanRequestFromCache(BindCategory.Other.name());
        return bindFastRequest != null && (bindFastRequest.getmBindFrom() == 2 || bindFastRequest.getmBindFrom() == 7);
    }

    public boolean isPaying() {
        PayRequest payRequest = (PayRequest) getBeanRequestFromCache(DxmPayBeanConstants.REQUEST_ID_PAY);
        return payRequest != null && !BaiduPay.PAY_FROM_BIND_CARD.equals(payRequest.getPayFrom());
    }

    public void removeBeanRequestFromCache(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.remove(str);
        }
    }

    public PayRequestCache() {
        this.a = new HashMap<>();
    }
}
