package com.baidu.wallet.lightapp.business.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.BaseDialog;
import com.baidu.wallet.lightapp.business.datamodel.ContactInfo;
import java.util.List;
import java.util.Objects;

public class PhoneNumberSelectDialog extends BaseDialog {
    public ListView a;
    public Context b;
    public a c;
    public List<ContactInfo.Phone> d;

    public class a extends BaseAdapter {
        public a() {
        }

        public int getCount() {
            if (PhoneNumberSelectDialog.this.d == null) {
                return 0;
            }
            return PhoneNumberSelectDialog.this.d.size();
        }

        public Object getItem(int i2) {
            return PhoneNumberSelectDialog.this.d.get(i2);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(final int i2, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(PhoneNumberSelectDialog.this.b).inflate(ResUtils.layout(PhoneNumberSelectDialog.this.b, "wallet_langbridge_contact_phone_item"), (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(ResUtils.id(PhoneNumberSelectDialog.this.b, "wallet_base_type"));
            textView.setText(((ContactInfo.Phone) PhoneNumberSelectDialog.this.d.get(i2)).getTypeName() + " : " + ((ContactInfo.Phone) PhoneNumberSelectDialog.this.d.get(i2)).number);
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    EventBus instance = EventBus.getInstance();
                    EventBus instance2 = EventBus.getInstance();
                    Objects.requireNonNull(instance2);
                    instance.post(new EventBus.Event("read_contact", ((ContactInfo.Phone) PhoneNumberSelectDialog.this.d.get(i2)).number));
                    PhoneNumberSelectDialog.this.dismiss();
                }
            });
            return inflate;
        }
    }

    public PhoneNumberSelectDialog(Context context) {
        super(context);
        this.b = context;
    }

    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.b).inflate(ResUtils.layout(this.b, "wallet_langbridge_contact_phone"), (ViewGroup) null);
        this.a = (ListView) inflate.findViewById(ResUtils.id(this.b, "wallet_base_lv"));
        a aVar = new a();
        this.c = aVar;
        this.a.setAdapter(aVar);
        addContentView(inflate);
        getNegativeBtn().setTextColor(this.b.getResources().getColor(ResUtils.color(this.b, "wallet_base_mainColor")));
        showCloseBtn(false);
        setTitleText(ResUtils.string(this.b, "wallet_lightapp_contact_please_select_phone"));
        hidePositiveButton();
    }

    public void setPhones(List<ContactInfo.Phone> list) {
        this.d = list;
    }
}
