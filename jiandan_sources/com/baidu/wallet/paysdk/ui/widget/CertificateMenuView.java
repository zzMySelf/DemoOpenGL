package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.utils.DisplayUtils;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.BdMenu;
import com.dxmpay.wallet.base.widget.BdMenuItem;

public class CertificateMenuView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static final String a = CertificateMenuView.class.getSimpleName();
    public boolean b = false;
    public ListView c;
    public a d;
    public b e;

    public class a extends BaseAdapter {
        public GetCardInfoResponse.CertificateTypeInfo[] b;

        public a() {
        }

        public void a(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
            this.b = certificateTypeInfoArr;
        }

        public int getCount() {
            GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr = this.b;
            if (certificateTypeInfoArr != null) {
                return certificateTypeInfoArr.length;
            }
            return 0;
        }

        public Object getItem(int i2) {
            return null;
        }

        public long getItemId(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            CertificateMenuItemView certificateMenuItemView;
            if (view == null) {
                certificateMenuItemView = new CertificateMenuItemView(CertificateMenuView.this.getContext());
            } else {
                certificateMenuItemView = (CertificateMenuItemView) view;
            }
            certificateMenuItemView.updateItem(this.b[i2]);
            return certificateMenuItemView;
        }
    }

    public interface b {
        void a(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo);
    }

    @SuppressLint({"NewApi"})
    public CertificateMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public String getBackgroundResId() {
        return "wallet_base_certifcate_dialog";
    }

    public String getMenuItemBackgroudResId(int i2, int i3) {
        return null;
    }

    public String getMenuItemViewLayoutId() {
        return "dxm_wallet_base_menu_item_view";
    }

    public int getSeparatorColor() {
        return -1710619;
    }

    public void layoutMenu(GetCardInfoResponse.CertificateTypeInfo[] certificateTypeInfoArr) {
        a aVar = this.d;
        if (aVar != null) {
            aVar.a(certificateTypeInfoArr);
            this.d.notifyDataSetChanged();
            return;
        }
        a aVar2 = new a();
        this.d = aVar2;
        aVar2.a(certificateTypeInfoArr);
        this.c.setAdapter(this.d);
    }

    public void onMenuItemUpdated(BdMenuItem bdMenuItem) {
    }

    public void onMenuSetChanged() {
        this.b = false;
    }

    public void setCertificertSelectListener(b bVar) {
        this.e = bVar;
    }

    private void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setBackgroundResource(ResUtils.drawable(getContext(), getBackgroundResId()));
        this.c = new ListView(getContext());
        int dip2px = DisplayUtils.dip2px(getContext(), 115.0f);
        this.c.setDivider(new ColorDrawable(getSeparatorColor()));
        this.c.setDividerHeight(1);
        this.c.setSelector(new ColorDrawable(0));
        this.c.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (view != null && (view instanceof CertificateMenuItemView)) {
                    GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo = ((CertificateMenuItemView) view).getCertificateTypeInfo();
                    if (CertificateMenuView.this.e != null) {
                        CertificateMenuView.this.e.a(certificateTypeInfo);
                    }
                }
            }
        });
        addView(this.c, new LinearLayout.LayoutParams(dip2px, -2));
        setFocusableInTouchMode(true);
    }

    public CertificateMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CertificateMenuView(Context context) {
        super(context);
        a();
    }
}
