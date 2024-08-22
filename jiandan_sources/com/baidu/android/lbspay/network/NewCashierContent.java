package com.baidu.android.lbspay.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.lbspay.channelpay.PayDataBean;
import com.baidu.wallet.paysdk.datamodel.PrecashierCreateOrderResponse;
import com.dxmpay.apollon.beans.IBeanResponse;
import com.dxmpay.apollon.utils.JsonUtils;
import com.dxmpay.wallet.core.utils.LogUtil;
import java.io.Serializable;
import org.json.JSONException;

public class NewCashierContent implements IBeanResponse, Serializable {
    public static final String TAG = "NewCashierContent";
    public static final long serialVersionUID = -6404441585155615479L;
    public String bdstoken;
    public int bfb_only;
    public CommonMarketing[] common_marketing;
    public String customerId;
    public String data;
    public CashierOrder order;
    public long order_expire_time;
    public CashierPay pay;
    public String paydata;
    public PrecashierCreateOrderResponse sdk_info;
    public long system_time;
    public String tn;
    public String token;

    public static class Brand implements Serializable {
        public static final long serialVersionUID = 1;
        public String desc;
        public String icon;
    }

    public static class CashierChannel implements IBaseChannel, Serializable {
        public static final long serialVersionUID = 1;
        public String activity_icon;
        public String agent_channel_code;
        public String agent_name;
        public String balance;
        public String channel_alias;
        public String channel_code;
        public String channel_desc_only;
        public String channel_ext;
        public String channel_icon;
        public String channel_name;
        public String channel_rank;
        public CommonUsedCard commonUsed;
        public String create_time;
        public int desc_is_red;
        public String group_name;
        public String icon_position;
        public int is_available;
        public int is_show;
        public String is_visible;
        public String marketing_desc;
        public String marketing_need_pay_amount;
        public int pay_channel_id;
        public int priority;
        public int showDefault;
        public String uc_ext;
        public String update_time;

        public String getActiveIcon() {
            return this.activity_icon;
        }

        public String getBankId() {
            return "";
        }

        public int getChanelId() {
            return this.pay_channel_id;
        }

        public String getChannelAlias() {
            return this.channel_alias;
        }

        public CommonUsedCard getCommonUsedCard() {
            return this.commonUsed;
        }

        public String getDesc() {
            return this.channel_desc_only;
        }

        public String getIcon() {
            return this.channel_icon;
        }

        public boolean getIsRed() {
            return this.desc_is_red == 1;
        }

        public String getMarketingDesc() {
            return this.marketing_desc;
        }

        public String getName() {
            return this.channel_name;
        }

        public String getPayAmount() {
            return this.marketing_need_pay_amount;
        }

        public int getPriority() {
            return this.priority;
        }

        public String getRecommendIcon() {
            return "";
        }

        public String getShortCard() {
            return "";
        }

        public String getUc_ext() {
            return this.uc_ext;
        }

        public boolean isAvailable() {
            return this.is_available == 1;
        }

        public boolean isChecked() {
            return this.showDefault == 1;
        }

        public boolean isShow() {
            return this.is_show == 1;
        }
    }

    public static class CashierChannelCoupon implements Serializable {
        public static final long serialVersionUID = 8163949050735544670L;
        public String amount;
        public String desc;
        public String icon;
        public String type;

        public String getAmount() {
            return this.amount;
        }

        public String getDesc() {
            return this.desc;
        }
    }

    public static class CashierChannels implements Serializable {
        public static final long serialVersionUID = 1;
        public CashierChannel[] official_platform;
        public String official_platform_name;
        public CashierChannel[] platform;
        public String platform_name;
    }

    public static class CashierOrder implements Serializable {
        public static final long serialVersionUID = 1;
        public String paid_amount;
        public String total_amount;
    }

    public static class CashierPay implements Serializable {
        public static final long serialVersionUID = 1;
        public Brand brand;
        public CashierChannels channels;
        public String tn;
    }

    public static class CommonMarketing implements Serializable {
        public String pic;
        public String text;
        public String url;
    }

    public static class CommonUsedCard implements Serializable {
        public static final long serialVersionUID = 1;
        public String[] cardMarketings;
        public String cardName;

        public String[] getCardMarketings() {
            return this.cardMarketings;
        }

        public String getCardName() {
            return this.cardName;
        }
    }

    public interface IBaseChannel {
        String getActiveIcon();

        String getBankId();

        int getChanelId();

        String getChannelAlias();

        CommonUsedCard getCommonUsedCard();

        String getDesc();

        String getIcon();

        boolean getIsRed();

        String getMarketingDesc();

        String getName();

        String getPayAmount();

        int getPriority();

        String getRecommendIcon();

        String getShortCard();

        String getUc_ext();

        boolean isAvailable();

        boolean isChecked();

        boolean isShow();
    }

    public static class ReqField implements Serializable {
        public static final long serialVersionUID = 1;
        public String card_holder_id;
        public String card_holder_name;
        public String card_no;
        public String cvv2;
        public String expired_date;
        public String id_type;
        public String phone;
    }

    public boolean checkResponseValidity() {
        return true;
    }

    public String getOrderInfo() {
        if (TextUtils.isEmpty(this.paydata)) {
            return "";
        }
        String str = new String(Base64.decode(this.paydata, 0));
        "decodeddata=" + str;
        try {
            PayDataBean payDataBean = (PayDataBean) JsonUtils.fromJson(str, PayDataBean.class);
            if (payDataBean != null) {
                return payDataBean.params;
            }
            return "";
        } catch (JSONException e) {
            LogUtil.e(TAG, e.getMessage(), e);
            return "";
        }
    }

    public void storeResponse(Context context) {
    }
}
