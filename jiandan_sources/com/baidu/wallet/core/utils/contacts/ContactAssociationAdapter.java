package com.baidu.wallet.core.utils.contacts;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.core.utils.contacts.PhoneContactsMananger;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ContactAssociationAdapter extends BaseAdapter implements Filterable, PhoneContactsMananger.LoadAddressInfoComplitedListener {
    public String[] a = {"@qq.com", "@163.com", "@126.com", "@sina.com", "@gmail.com", "@hotmail.com"};
    public ArrayList<ContractInfo> b;
    public ArrayList<ContractInfo> c;
    public final LayoutInflater d;
    public Filter e;
    public ArrayList<String> f;
    public ArrayList<String> g;
    public Context h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f3557i = false;

    public class AssociationViewHolder {
        public TextView mName;
        public TextView mPhone;

        public AssociationViewHolder() {
        }
    }

    public ContactAssociationAdapter(Context context, boolean z) {
        this.h = context;
        this.d = LayoutInflater.from(context);
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.f3557i = z;
        loadPhoneContact();
    }

    public void clearMailInput() {
        this.c = new ArrayList<>();
    }

    public List<ContractInfo> getContractInfo() {
        ArrayList arrayList = new ArrayList();
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < this.g.size()) {
                arrayList.add(new ContractInfo(this.f.get(i2), this.g.get(i2)));
            } else {
                arrayList.add(new ContractInfo(this.f.get(i2), ""));
            }
        }
        return arrayList;
    }

    public int getCount() {
        return this.f.size();
    }

    public Filter getFilter() {
        if (this.e == null) {
            this.e = new Filter() {
                public final ConcurrentHashMap<String, ArrayList<String>> b = new ConcurrentHashMap<>();
                public final ArrayList<String> c = new ArrayList<>();
                public final ArrayList<String> d = new ArrayList<>();

                public Filter.FilterResults performFiltering(CharSequence charSequence) {
                    this.c.clear();
                    this.d.clear();
                    this.b.clear();
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    if (!TextUtils.isEmpty(charSequence)) {
                        if (charSequence.toString().contains("@")) {
                            if (ContactAssociationAdapter.this.c != null && ContactAssociationAdapter.this.c.size() > 0) {
                                Iterator it = ContactAssociationAdapter.this.c.iterator();
                                while (it.hasNext()) {
                                    ContractInfo contractInfo = (ContractInfo) it.next();
                                    if (contractInfo != null) {
                                        String mobile = contractInfo.getMobile();
                                        if (!TextUtils.isEmpty(mobile) && mobile.startsWith(charSequence.toString())) {
                                            this.c.add(contractInfo.getMobile());
                                            this.d.add("");
                                        }
                                    }
                                }
                            }
                        } else if (ContactAssociationAdapter.this.f3557i && (charSequence.length() <= 4 || charSequence.length() >= 13)) {
                            return filterResults;
                        } else {
                            if (!ContactAssociationAdapter.this.f3557i && (charSequence.length() <= 3 || charSequence.length() >= 11)) {
                                return filterResults;
                            }
                            if (ContactAssociationAdapter.this.b == null) {
                                ArrayList unused = ContactAssociationAdapter.this.b = new ArrayList();
                            }
                            if (!ContactAssociationAdapter.this.b.isEmpty()) {
                                if (ContactAssociationAdapter.this.f3557i) {
                                    String a2 = ContactAssociationAdapter.this.a(charSequence);
                                    if (TextUtils.isEmpty(a2) || a2.length() < 4) {
                                        return filterResults;
                                    }
                                    Iterator it2 = ContactAssociationAdapter.this.b.iterator();
                                    while (it2.hasNext()) {
                                        ContractInfo contractInfo2 = (ContractInfo) it2.next();
                                        if (contractInfo2 != null) {
                                            String mobile2 = contractInfo2.getMobile();
                                            String name = contractInfo2.getName();
                                            if (charSequence.length() < 13 && !TextUtils.isEmpty(mobile2) && mobile2.startsWith(a2)) {
                                                if (mobile2.length() > 13) {
                                                    this.c.add(mobile2.substring(0, 13));
                                                } else {
                                                    this.c.add(mobile2);
                                                }
                                                ArrayList<String> arrayList = this.d;
                                                if (TextUtils.isEmpty(name)) {
                                                    name = "";
                                                }
                                                arrayList.add(name);
                                            }
                                        }
                                    }
                                } else {
                                    Iterator it3 = ContactAssociationAdapter.this.b.iterator();
                                    while (it3.hasNext()) {
                                        ContractInfo contractInfo3 = (ContractInfo) it3.next();
                                        if (contractInfo3 != null) {
                                            String mobile3 = contractInfo3.getMobile();
                                            String name2 = contractInfo3.getName();
                                            if (charSequence.length() < 11 && !TextUtils.isEmpty(mobile3)) {
                                                String replace = mobile3.replace(" ", "");
                                                if (!TextUtils.isEmpty(replace) && replace.startsWith(charSequence.toString())) {
                                                    if (replace.length() > 11) {
                                                        this.c.add(replace.substring(0, 11));
                                                    } else {
                                                        this.c.add(replace);
                                                    }
                                                    ArrayList<String> arrayList2 = this.d;
                                                    if (TextUtils.isEmpty(name2)) {
                                                        name2 = "";
                                                    }
                                                    arrayList2.add(name2);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    int size = this.c.size();
                    filterResults.count = size;
                    if (size > 0) {
                        this.b.put("mD1", this.c);
                        this.b.put("mD2", this.d);
                    }
                    return filterResults;
                }

                public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ConcurrentHashMap<String, ArrayList<String>> concurrentHashMap;
                    ContactAssociationAdapter.this.f.clear();
                    ContactAssociationAdapter.this.g.clear();
                    if (filterResults.count <= 0 || (concurrentHashMap = this.b) == null || concurrentHashMap.get("mD1") == null || this.b.get("mD2") == null) {
                        ContactAssociationAdapter.this.notifyDataSetInvalidated();
                        return;
                    }
                    ContactAssociationAdapter.this.f.addAll(this.b.get("mD1"));
                    ContactAssociationAdapter.this.g.addAll(this.b.get("mD2"));
                    ContactAssociationAdapter.this.notifyDataSetChanged();
                }
            };
        }
        return this.e;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        AssociationViewHolder associationViewHolder;
        if (view == null) {
            associationViewHolder = new AssociationViewHolder();
            view2 = this.d.inflate(ResUtils.layout(this.h, "wallet_base_history_item"), (ViewGroup) null);
            associationViewHolder.mPhone = (TextView) view2.findViewById(ResUtils.id(this.h, "wallet_phone"));
            associationViewHolder.mName = (TextView) view2.findViewById(ResUtils.id(this.h, "wallet_name"));
            view2.setTag(associationViewHolder);
        } else {
            view2 = view;
            associationViewHolder = (AssociationViewHolder) view.getTag();
        }
        associationViewHolder.mPhone.setText(getItem(i2));
        if (i2 < this.g.size()) {
            associationViewHolder.mName.setText(this.g.get(i2));
        }
        return view2;
    }

    public void loadPhoneContact() {
        PhoneContactsMananger.getInstance(DxmApplicationContextImpl.getApplicationContext(this.h)).loadPhoneContacts(this);
    }

    public void onLoadContractsComplited(ArrayList<ContractInfo> arrayList) {
        this.b = arrayList;
    }

    public void setMailInput(String str) {
        if (!TextUtils.isEmpty(str)) {
            clearMailInput();
            if (this.c != null) {
                for (int i2 = 0; i2 < this.a.length; i2++) {
                    String str2 = str + this.a[i2];
                    if (!TextUtils.isEmpty(str2) && str2.length() <= 32) {
                        this.c.add(new ContractInfo(str2, ""));
                    }
                }
            }
        }
    }

    public String getItem(int i2) {
        if (i2 < this.f.size()) {
            return this.f.get(i2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public String a(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() <= 0) {
            return "";
        }
        int length = charSequence.length();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (charAt != ' ') {
                stringBuffer.append(charAt);
            }
        }
        if (stringBuffer.length() >= 4) {
            if (stringBuffer.length() < 8) {
                stringBuffer.insert(3, Ascii.CASE_MASK);
            } else {
                stringBuffer.insert(7, Ascii.CASE_MASK);
                stringBuffer.insert(3, Ascii.CASE_MASK);
            }
        }
        return stringBuffer.toString();
    }
}
