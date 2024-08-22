package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.ui.widget.CertificateMenuView;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;
import java.util.List;

public class b extends BdMenu {
    public GetCardInfoResponse.CertificateTypeInfo[] a;
    public CertificateMenuView.b b;

    public b(View view, GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        super(view);
        this.a = certificateTypeInfoArr;
        setDismissOnClick(true);
    }

    public void a(CertificateMenuView.b bVar) {
        this.b = bVar;
    }

    public void ensureMenuLoaded(View view, List<BdMenuItem> list) {
        CertificateMenuView certificateMenuView = (CertificateMenuView) view;
        certificateMenuView.setCertificertSelectListener(this.b);
        certificateMenuView.layoutMenu(this.a);
    }

    public View getMenuView(Context context) {
        return new CertificateMenuView(context);
    }

    public void showMenu(PopupWindow popupWindow) {
        popupWindow.showAsDropDown(this.mViewToAttach);
    }
}
