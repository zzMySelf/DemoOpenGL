package com.baidu.wallet.paysdk.ui.widget.quota;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.dialog.WalletDialog;

public class a extends WalletDialog.Adapter<C0171a> {
    public c a;

    /* renamed from: com.baidu.wallet.paysdk.ui.widget.quota.a$a  reason: collision with other inner class name */
    public class C0171a extends WalletDialog.ViewHolder {
        public final b a;

        public C0171a(b bVar) {
            super(bVar.rootView);
            this.a = bVar;
        }
    }

    public a(c cVar) {
        this.a = cVar;
    }

    /* renamed from: a */
    public C0171a onCreateViewHolder(ViewGroup viewGroup) {
        return new C0171a(new b(LayoutInflater.from(viewGroup.getContext()).inflate(ResUtils.layout(viewGroup.getContext(), "wallet_cashdesk_quota_content_dialog"), (ViewGroup) null)));
    }

    /* renamed from: a */
    public void onBindViewHolder(C0171a aVar) {
        aVar.a.setViewModel(this.a);
    }
}
