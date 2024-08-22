package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import com.baidu.wallet.base.datamodel.PayData;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.wallet.core.NoProguard;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

public class CalcPaymentResponse implements IBeanResponse, NoProguard, Serializable {
    public static final int SELECTION_NO_CHANGE = -1;
    public static final String TAG = "CalcPaymentResponse";
    public static final long serialVersionUID = 2906317784498976013L;
    public PayData.Discount[] activity_list;
    public PayData.ChannelDiscountMap[] activity_map;
    public String balance_amount;
    public String balance_jump_url;
    public String balance_select_desc;
    public String balance_trans_amount;
    public PayData.Coupon[] coupon_list;
    public String credit_amount;
    public String credit_select_desc;
    public String credit_trans_amount;
    public String easypay_amount;
    public String easypay_select_desc;
    public String easypay_trans_amount;
    public String total_discount_amount;
    public String total_discount_msg;

    public boolean checkResponseValidity() {
        return true;
    }

    public String getActivitiesJsonParams(int i2, String str) {
        PayData.Discount[] discountArr = this.activity_list;
        if (discountArr == null || discountArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        while (true) {
            PayData.Discount[] discountArr2 = this.activity_list;
            if (i3 >= discountArr2.length) {
                return jSONArray.toString();
            }
            PayData.Discount discount = discountArr2[i3];
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", discount.id);
                if (i3 == i2) {
                    jSONObject.put("selected", str);
                } else {
                    jSONObject.put("selected", discount.getSelectedString());
                }
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
            i3++;
        }
    }

    public String getCouponJsonParams(int i2, String str) {
        PayData.Coupon[] couponArr = this.coupon_list;
        if (couponArr == null || couponArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i3 = 0;
        while (true) {
            PayData.Coupon[] couponArr2 = this.coupon_list;
            if (i3 >= couponArr2.length) {
                return jSONArray.toString();
            }
            PayData.Coupon coupon = couponArr2[i3];
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", coupon.id);
                if (i3 == i2) {
                    jSONObject.put("selected", str);
                } else {
                    jSONObject.put("selected", coupon.getSelectedString());
                }
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
            i3++;
        }
    }

    public String getDiscountMapJsonParams() {
        PayData.ChannelDiscountMap[] channelDiscountMapArr = this.activity_map;
        if (channelDiscountMapArr == null || channelDiscountMapArr.length == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i2 = 0;
        while (true) {
            PayData.ChannelDiscountMap[] channelDiscountMapArr2 = this.activity_map;
            if (i2 >= channelDiscountMapArr2.length) {
                return jSONArray.toString();
            }
            PayData.ChannelDiscountMap channelDiscountMap = channelDiscountMapArr2[i2];
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("card_no", channelDiscountMap.card_no);
                jSONObject.put("id", channelDiscountMap.id);
                jSONArray.put(jSONObject);
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
            }
            i2++;
        }
    }

    public String getSelectedCouponIds() {
        return getSelectedCouponIds(this.coupon_list);
    }

    public String getSelectedDiscountIds() {
        return getSelectedDiscountIds(this.activity_list);
    }

    public void storeResponse(Context context) {
    }

    public String getSelectedCouponIds(PayData.Coupon[] couponArr) {
        if (couponArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (PayData.Coupon coupon : couponArr) {
            if (coupon.getSelected()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(coupon.id);
            }
        }
        return sb.toString();
    }

    public String getSelectedDiscountIds(PayData.Discount[] discountArr) {
        if (discountArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (PayData.Discount discount : discountArr) {
            if (discount.getSelected()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                sb.append(discount.id);
            }
        }
        return sb.toString();
    }

    public String getActivitiesJsonParams() {
        return getActivitiesJsonParams(-1, (String) null);
    }

    public String getCouponJsonParams() {
        return getCouponJsonParams(-1, (String) null);
    }
}
