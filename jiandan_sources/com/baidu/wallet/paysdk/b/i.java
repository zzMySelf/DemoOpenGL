package com.baidu.wallet.paysdk.b;

import android.content.Context;
import com.baidu.wallet.base.datamodel.CardData;
import com.baidu.wallet.paysdk.datamodel.ErrorContentResponse;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.HalfScreenBaseActivity;
import com.baidu.wallet.paysdk.ui.WalletSmsActivity;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.util.ArrayList;

public final class i {

    public static class a {
        public static i a = new i();
    }

    public static i a() {
        return a.a;
    }

    public i() {
    }

    public int a(Context context, CardData.BondCard bondCard, boolean z) {
        int i2 = 0;
        if (DisplayUtils.getDisplayHeight(context) < DisplayUtils.dip2px(context, 568.0f)) {
            return 0;
        }
        if (!(context instanceof HalfScreenBaseActivity) && !(context instanceof WalletSmsActivity)) {
            return 0;
        }
        if (bondCard != null && 1 == bondCard.is_need_repaired) {
            if ("1".equals(bondCard.need_true_name)) {
                return 0;
            }
            if ("1".equals(bondCard.need_cvv2)) {
                i2 = 1;
            }
            if (z || "1".equals(bondCard.need_phone_num)) {
                i2++;
            }
            if ("1".equals(bondCard.need_valid_date)) {
                i2++;
            }
            if ("1".equals(bondCard.need_identity_code) && "1".equals(bondCard.need_identity_type)) {
                i2++;
            }
            if (1 == i2 || 2 == i2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("1");
                arrayList.add(Integer.toString(i2));
                StatisticManager.onEventWithValues(StatServiceEvent.EVENT_BANKCARD_MISSINFO, arrayList);
            }
        }
        return i2;
    }

    public int a(Context context, ErrorContentResponse errorContentResponse) {
        GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr;
        if (DisplayUtils.getDisplayHeight(context) < DisplayUtils.dip2px(context, 568.0f)) {
            return 0;
        }
        if ((!(context instanceof HalfScreenBaseActivity) && !(context instanceof WalletSmsActivity)) || errorContentResponse == null || errorContentResponse.card_item_required == null || ((certificateTypeInfoArr = errorContentResponse.certificate_type_info) != null && 1 < certificateTypeInfoArr.length)) {
            return 0;
        }
        int i2 = "1".equals(errorContentResponse.card_item_required.valid_code) ? 1 : 0;
        if ("1".equals(errorContentResponse.card_item_required.valid_date)) {
            i2++;
        }
        if ("1".equals(errorContentResponse.card_item_required.mobile)) {
            i2++;
        }
        if ("1".equals(errorContentResponse.card_item_required.certificate_code)) {
            GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr2 = errorContentResponse.certificate_type_info;
            if (1 == certificateTypeInfoArr2.length && "1".equals(certificateTypeInfoArr2[0].type)) {
                i2++;
            }
        }
        if (1 == i2 || 2 == i2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("2");
            arrayList.add(Integer.toString(i2));
            StatisticManager.onEventWithValues(StatServiceEvent.EVENT_BANKCARD_MISSINFO, arrayList);
        }
        return i2;
    }
}
