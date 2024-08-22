package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.wallet.base.datamodel.PayData;
import com.baidu.wallet.paysdk.a;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;
import java.util.Map;

public class GetCardInfoResponse implements IBeanResponse, Serializable {
    public static final long serialVersionUID = -7267923736947733889L;
    public Algorithm algorithm_check_info;
    public BindCardInfo bind_card_info;
    public CardInfo card_info;
    public Map<String, String> cashdesk;
    public ChannelInfo channel_info;
    public ProtocolInfo protocol_info;
    public ProtocolPlatformInfo protocol_platform_info;
    public SpInfo sp_info;

    public static class Algorithm implements Serializable {
        public static final long serialVersionUID = -1246105472340646254L;
        public int code;
        public String msg;
    }

    public static class BindCardInfo implements Serializable {
        public static final long serialVersionUID = 424736973323730942L;
        public String bind_card_desc;
    }

    public static class CalcPaymentResponseImpl extends CalcPaymentResponse implements Serializable {
        public static final long serialVersionUID = 1;
        public String card_no;
    }

    public static class CardInfo implements Serializable {
        public static final long serialVersionUID = 4241463573323730942L;
        public String bank_logourl;
        public String bank_name;
        public String bank_no;
        public int card_type;
        public String desc;
        public String easypay_amount;
        public String front_bank_code;
        public String type_name;
    }

    public static class CardItemRequired implements Serializable {
        public static final String IS_REQUIRED = "1";
        public static final String NOT_REQUIRED = "0";
        public static final long serialVersionUID = -7604429898684469632L;
        public String address;
        public String cert_end_date;
        public String cert_start_date;
        public String certificate_code;
        public String certificate_type;
        public String gender;
        public String job;
        public String mobile;
        public String nationality;
        public String true_name;
        public String valid_code;
        public String valid_date;
    }

    public static class CertificateTypeInfo implements Serializable {
        public static final String HONG_KONG_AND_MACAO_PASS = "4";
        public static final String ID_CARD = "1";
        public static final String OFFICER = "2";
        public static final String PASSPORT = "3";
        public static final long serialVersionUID = 2006299127113478802L;
        public String description;
        public boolean isDisplay = false;
        public String type;

        public a getValidator() {
            long j = "1".equals(this.type) ? 2 : 1;
            if ("2".equals(this.type)) {
                j = 16;
            }
            if ("3".equals(this.type)) {
                j = 4;
            }
            if ("4".equals(this.type)) {
                j = 8;
            }
            return new a(j);
        }

        public boolean isDisplay() {
            return this.isDisplay;
        }

        public void setDisplay(boolean z) {
            this.isDisplay = z;
        }

        public String toString() {
            return "CertificateTypeInfo [type=" + this.type + ", description=" + this.description + "]";
        }
    }

    public static class ChannelInfo implements Serializable {
        public static final long serialVersionUID = -1655363585956229526L;
        public CardItemRequired card_item_required;
        public CertificateTypeInfo[] certificate_type_info;
        public String channel_no;
        public int is_simplify_page;
        public CalcPaymentResponseImpl mkt_info;
        public String need_pay_one_cent;
        public String need_pay_one_cent_desc;
        public int need_send_sms;

        public boolean isNeedSendSms() {
            return this.need_send_sms == 1;
        }

        public boolean updatePhoneOnly() {
            return this.is_simplify_page == 1;
        }
    }

    public static class ProtocolInfo implements Serializable {
        public static final long serialVersionUID = -4330766379370170338L;
        public String is_agreement_checked;
        public String last_separator;
        public ProtocolItem[] list;
        public String prefix;
        public String separator;
        public String suffix;

        public boolean isProtocolCheckedDefault() {
            return "1".equals(this.is_agreement_checked);
        }
    }

    public static class ProtocolItem implements Serializable {
        public static final long serialVersionUID = -1246105472340646254L;
        public String title;
        public String url;
    }

    public static class ProtocolPlatformInfo implements Serializable {
        public static final long serialVersionUID = -4330766379370170338L;
        public ProtocolPlatformItem[] ext_list;
        public String is_agreement_checked;
        public ProtocolPlatformItem[] list;
        public String main_title = "服务协议";
        public String prefix = "我已阅读并同意";
        public String prompt = "您的个人信息、财产安全对我们至关重要，度小满将严格遵守相关法律法规，保护您的信息及财产安全";
        public String snapshotId;
        public String sub_title = "度小满钱包服务相关协议";
        public String suffix = "并知晓填写的卡信息将与百度账号绑定用于提升账号安全性";

        public boolean isProtocolCheckedDefault() {
            return "1".equals(this.is_agreement_checked);
        }
    }

    public static class ProtocolPlatformItem implements Serializable {
        public static final long serialVersionUID = -1246105472340646254L;
        public String accessPartyId;
        public String front_bank_code;
        public String protocolType;
        public String sign_bank_code;
        public String snapshotId;
        public String spId;
        public String templateCode;
        public String templateName;
    }

    public static class SpInfo implements Serializable {
        public static final long serialVersionUID = 4241462876393730942L;
        public String order_no;
        public String sp_no;
    }

    public boolean checkResponseValidity() {
        return (this.card_info == null || this.channel_info == null) ? false : true;
    }

    public String getCardInfoCouponDesc() {
        CalcPaymentResponseImpl calcPaymentResponseImpl;
        PayData.ChannelDiscountMap[] channelDiscountMapArr;
        ChannelInfo channelInfo = this.channel_info;
        if (channelInfo == null || (calcPaymentResponseImpl = channelInfo.mkt_info) == null || TextUtils.isEmpty(calcPaymentResponseImpl.card_no) || (channelDiscountMapArr = this.channel_info.mkt_info.activity_map) == null || channelDiscountMapArr.length <= 0) {
            return "";
        }
        int i2 = 0;
        while (true) {
            CalcPaymentResponseImpl calcPaymentResponseImpl2 = this.channel_info.mkt_info;
            PayData.ChannelDiscountMap[] channelDiscountMapArr2 = calcPaymentResponseImpl2.activity_map;
            if (i2 >= channelDiscountMapArr2.length) {
                return "";
            }
            if (calcPaymentResponseImpl2.card_no.equals(channelDiscountMapArr2[i2].card_no)) {
                return this.channel_info.mkt_info.activity_map[i2].description;
            }
            i2++;
        }
    }

    public String getOneCentsDesc() {
        ChannelInfo channelInfo = this.channel_info;
        return (channelInfo == null || TextUtils.isEmpty(channelInfo.need_pay_one_cent_desc)) ? "" : this.channel_info.need_pay_one_cent_desc;
    }

    public boolean isOneCentsBusiness() {
        ChannelInfo channelInfo = this.channel_info;
        return channelInfo != null && !TextUtils.isEmpty(channelInfo.need_pay_one_cent) && "1".equals(this.channel_info.need_pay_one_cent);
    }

    public void storeResponse(Context context) {
    }
}
