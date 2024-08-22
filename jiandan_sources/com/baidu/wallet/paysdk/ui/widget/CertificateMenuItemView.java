package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.utils.ResUtils;

public class CertificateMenuItemView extends RelativeLayout {
    public TextView a;
    public GetCardInfoResponse.CertificateTypeInfo b;

    public CertificateMenuItemView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_menu_cert_item_view"), this);
        this.a = (TextView) findViewById(ResUtils.id(getContext(), "certi_text"));
    }

    public GetCardInfoResponse.CertificateTypeInfo getCertificateTypeInfo() {
        return this.b;
    }

    public void updateItem(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        if (certificateTypeInfo != null) {
            this.b = certificateTypeInfo;
            this.a.setTextColor(ResUtils.getColor(getContext(), certificateTypeInfo.isDisplay() ? "dxm_wallet_base_mainColor" : "dxm_wallet_base_font_text2Color"));
            this.a.setText(certificateTypeInfo.description);
        }
    }
}
