package com.baidu.wallet.paysdk.ui.widget.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;

public class b extends BaseAdapter {
    public GetCardInfoResponse.ProtocolPlatformItem[] a;
    public Context b;

    public static class a {
        public TextView a;
    }

    public b(Context context, GetCardInfoResponse.ProtocolPlatformItem[] protocolPlatformItemArr) {
        this.a = protocolPlatformItemArr;
        this.b = context.getApplicationContext();
    }

    /* renamed from: a */
    public GetCardInfoResponse.ProtocolPlatformItem getItem(int i2) {
        return this.a[i2];
    }

    public int getCount() {
        return this.a.length;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        a aVar;
        if (view == null) {
            aVar = new a();
            view2 = LayoutInflater.from(this.b).inflate(R.layout.wallet_cashdesk_bind_card_protocol_list_item_view, viewGroup, false);
            aVar.a = (TextView) view2.findViewById(R.id.tv_protocol_name);
            view2.setTag(aVar);
        } else {
            view2 = view;
            aVar = (a) view.getTag();
        }
        aVar.a.setText(this.a[i2].templateName);
        String str = (TextUtils.isEmpty(this.a[i2].templateName) || (!this.a[i2].templateName.endsWith("协议》") && !this.a[i2].templateName.endsWith("协议"))) ? "协议详情" : "详情";
        TextView textView = aVar.a;
        textView.setContentDescription("查看" + this.a[i2].templateName + str);
        return view2;
    }
}
