package com.baidu.wallet.base.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
public class PhoneHistoryFixView extends LinearLayout implements View.OnClickListener {
    public View a;
    public View b;
    public View c;
    public ListView d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public a h;

    /* renamed from: i  reason: collision with root package name */
    public OnPhoneHistoryFixViewClickListener f1150i;
    public boolean j = false;

    public interface OnPhoneHistoryFixViewClickListener {
        void onFixViewClickClearHistory();

        void onFixViewClickListViewItemAndSetText(String str);

        void onFixViewDisplayHistoryViews(boolean z);
    }

    public class a extends BaseAdapter {
        public Context b;
        public final LayoutInflater c;
        public List<ContractInfo> d = new ArrayList();

        public a(Context context) {
            this.b = context;
            this.c = LayoutInflater.from(context);
        }

        /* renamed from: a */
        public String getItem(int i2) {
            return null;
        }

        public void a(List<ContractInfo> list) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.d = list;
        }

        public int getCount() {
            return this.d.size();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            b bVar;
            SpannableString spannableString;
            if (view == null) {
                b bVar2 = new b();
                View inflate = this.c.inflate(ResUtils.layout(this.b, "wallet_base_fix_item"), (ViewGroup) null);
                TextView unused = bVar2.b = (TextView) inflate.findViewById(ResUtils.id(this.b, "wallet_phone_fix"));
                TextView unused2 = bVar2.c = (TextView) inflate.findViewById(ResUtils.id(this.b, "wallet_name_fix"));
                inflate.setTag(bVar2);
                View view2 = inflate;
                bVar = bVar2;
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (i2 < this.d.size()) {
                if (!PhoneHistoryFixView.this.j) {
                    spannableString = new SpannableString(this.d.get(i2).getMobile().replace(" ", ""));
                } else {
                    spannableString = new SpannableString(this.d.get(i2).getMobile());
                }
                int errordigit = this.d.get(i2).getErrordigit();
                if (errordigit != -1 && errordigit < spannableString.length()) {
                    spannableString.setSpan(new ForegroundColorSpan(ResUtils.getColor(this.b, "bd_wallet_fp_fix_character")), errordigit, errordigit + 1, 34);
                }
                bVar.b.setText(spannableString);
                bVar.c.setText(this.d.get(i2).getName());
            }
            return view;
        }
    }

    public class b {
        public TextView b;
        public TextView c;

        public b() {
        }
    }

    public PhoneHistoryFixView(Context context) {
        super(context);
        a();
    }

    public void displayContactInfoData(List<ContractInfo> list) {
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.a.setVisibility(8);
        this.e.setVisibility(0);
        a(list);
    }

    public void displayHistoryData(ArrayList<String> arrayList) {
        displayHistoryData(a(arrayList));
    }

    public ListView getmListView() {
        return this.d;
    }

    public boolean isShow() {
        return this.e.isShown();
    }

    public void onClick(View view) {
        if (view != this.g) {
            return;
        }
        if (this.f.getVisibility() == 0) {
            setListViewState(false, false);
            return;
        }
        OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f1150i;
        if (onPhoneHistoryFixViewClickListener != null) {
            onPhoneHistoryFixViewClickListener.onFixViewClickClearHistory();
        }
        setListViewState(false, true);
    }

    public void setInputNumberHasSpace(boolean z) {
        this.j = z;
    }

    public void setListViewState(boolean z, boolean z2) {
        String str;
        int i2 = 0;
        this.e.setVisibility(z ? 0 : 8);
        this.f.setVisibility(z2 ? 8 : 0);
        View view = this.a;
        if (z2) {
            i2 = 8;
        }
        view.setVisibility(i2);
        OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener = this.f1150i;
        if (onPhoneHistoryFixViewClickListener != null) {
            onPhoneHistoryFixViewClickListener.onFixViewDisplayHistoryViews(z);
        }
        if (z) {
            TextView textView = this.g;
            if (z2) {
                str = ResUtils.getString(getContext(), "wallet_fp_history_clear");
            } else {
                str = ResUtils.getString(getContext(), "wallet_fp_fix_sure");
            }
            textView.setText(str);
        }
    }

    public void setOnPhoneHistoryFixViewClickListener(OnPhoneHistoryFixViewClickListener onPhoneHistoryFixViewClickListener) {
        this.f1150i = onPhoneHistoryFixViewClickListener;
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_mobile_phone_history_fix"), this);
        this.e = (LinearLayout) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_layout"));
        TextView textView = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_select"));
        this.g = textView;
        textView.setOnClickListener(this);
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_msg"));
        this.a = findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_line1"));
        this.b = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line1"));
        this.c = findViewById(ResUtils.id(getContext(), "wallet_mobile_divide_line2"));
        this.d = (ListView) findViewById(ResUtils.id(getContext(), "wallet_mobile_fix_list"));
        a aVar = new a(getContext());
        this.h = aVar;
        this.d.setAdapter(aVar);
        this.d.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                b bVar;
                if (view != null && (bVar = (b) view.getTag()) != null) {
                    PhoneHistoryFixView phoneHistoryFixView = PhoneHistoryFixView.this;
                    phoneHistoryFixView.setListViewState(false, phoneHistoryFixView.f.getVisibility() != 0);
                    if (PhoneHistoryFixView.this.f1150i != null) {
                        PhoneHistoryFixView.this.f1150i.onFixViewClickListViewItemAndSetText(bVar.b.getText().toString());
                    }
                }
            }
        });
    }

    public void displayHistoryData(List<ContractInfo> list) {
        this.g.setVisibility(0);
        this.b.setVisibility(0);
        this.c.setVisibility(0);
        a(list);
    }

    public PhoneHistoryFixView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public PhoneHistoryFixView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a(List<ContractInfo> list) {
        int i2;
        ListView listView = this.d;
        if (list.size() > 2) {
            i2 = DisplayUtils.dip2px(getContext(), 165.0f);
        } else {
            i2 = DisplayUtils.dip2px(getContext(), (float) (list.size() * 55));
        }
        listView.setLayoutParams(new LinearLayout.LayoutParams(-1, i2));
        this.h.a(list);
        this.h.notifyDataSetChanged();
        this.d.setSelection(0);
    }

    private List<ContractInfo> a(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = 5;
            if (arrayList.size() <= 5) {
                i3 = arrayList.size();
            }
            if (i2 >= i3) {
                return arrayList2;
            }
            String str = arrayList.get(i2);
            if (str.length() > 13) {
                str = str.substring(0, 13);
            }
            arrayList2.add(new ContractInfo(str, PhoneContactsMananger.getInstance(DxmApplicationContextImpl.getApplicationContext(getContext())).getPayphoneInfo(str)));
            i2++;
        }
    }
}
