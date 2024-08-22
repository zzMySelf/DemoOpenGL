package com.baidu.wallet.paysdk.precashier;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.baidu.wallet.paysdk.datamodel.PrecashierModifyPayTypeResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class PrecashierModifyPayTypeDefaultData implements Serializable {
    public static final String TAG = "PrecashierModifyPayTypeDefaultData";
    public static final long serialVersionUID = 1641263196639015824L;
    public String balance_amount;
    public Card card;
    public String defaultType;
    public int updated;

    public static class Card implements Serializable {
        public String account_no;
        public String bank_name;
        public String bank_url;
        public String day_limit;
        public String month_limit;
        public String single_limit;
        public String single_quota;
    }

    public String getBalance() {
        return this.balance_amount;
    }

    public Card getCard() {
        return this.card;
    }

    public PrecashierModifyPayTypeDefaultData getData() {
        return this;
    }

    public String getDefaultType() {
        return this.defaultType;
    }

    public String getOriginalHttpResponse() {
        PrecashierModifyPayTypeResponse instance;
        JSONArray jSONArray;
        if ("balance".equals(this.defaultType) || "easypay".equals(this.defaultType)) {
            if (!PayDataCache.getInstance().isFromPreCashier() || (instance = PrecashierModifyPayTypeResponse.getInstance()) == null) {
                return "";
            }
            String originHttpResponse = instance.getOriginHttpResponse();
            if (TextUtils.isEmpty(originHttpResponse)) {
                return "";
            }
            try {
                JSONObject jSONObject = ((JSONObject) new JSONTokener(originHttpResponse).nextValue()).getJSONObject(QueryResponse.Options.PAY);
                if (jSONObject == null) {
                    return "";
                }
                JSONObject jSONObject2 = null;
                if ("balance".equals(this.defaultType)) {
                    jSONObject2 = jSONObject.getJSONObject("balance");
                } else {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("easypay");
                    if (jSONObject3 != null && (jSONArray = jSONObject3.getJSONArray("bind_card_arr")) != null) {
                        int length = jSONArray.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                                if (optJSONObject != null && this.card.account_no.equals(optJSONObject.get("account_no"))) {
                                    jSONObject2 = optJSONObject;
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (jSONObject2 == null) {
                    return "";
                }
                jSONObject2.put("pay_type", this.defaultType);
                jSONObject2.put("balance_amount", this.balance_amount);
                jSONObject2.put("updated", Integer.toString(this.updated));
                return jSONObject2.toString();
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
                return "";
            }
        } else if (1 != this.updated) {
            return "";
        } else {
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("updated", "1");
                if (this.card != null && !TextUtils.isEmpty(this.card.account_no)) {
                    jSONObject4.put("account_no", this.card.account_no);
                }
                return jSONObject4.toString();
            } catch (JSONException e2) {
                LogUtil.e(TAG, e2.getMessage(), e2);
                return "";
            }
        }
    }

    public boolean isNeedUpdate() {
        return this.updated == 1;
    }

    public void setBalance(String str) {
        this.balance_amount = str;
    }

    public void setDatas(String str, String str2, Card card2) {
        this.defaultType = str;
        this.balance_amount = str2;
        this.card = card2;
    }
}
