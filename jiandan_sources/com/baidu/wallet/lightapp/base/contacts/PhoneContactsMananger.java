package com.baidu.wallet.lightapp.base.contacts;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.apollon.utils.LogUtil;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import com.baidu.wallet.core.utils.contacts.ContractInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class PhoneContactsMananger {
    public static final String a = "PhoneContactsMananger";
    public static PhoneContactsMananger b;
    public Context c;
    public c d;
    public d e;
    public ConcurrentHashMap<String, ContractInfo> f = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, ContractInfo> g = new ConcurrentHashMap<>();
    public ArrayList<ContractInfo> h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    public AtomicBoolean f3562i = new AtomicBoolean(false);
    public ContactStatus j = ContactStatus.unload;
    public List<ContactSelectModel.AllContact> k = null;
    public b l = null;

    public enum ContactStatus {
        unload,
        loading,
        complited
    }

    public interface c {
        void a(ArrayList<ContractInfo> arrayList);
    }

    public interface d {
        void a(List<ContactSelectModel.AllContact> list, int i2);
    }

    public PhoneContactsMananger(Context context) {
        b(context);
    }

    private boolean b(Context context) {
        if (this.c == null && context != null) {
            this.c = DxmApplicationContextImpl.getApplicationContext(context);
        }
        return this.c != null;
    }

    /* access modifiers changed from: private */
    public void b() {
        for (String next : this.f.keySet()) {
            if (!this.h.contains(this.f.get(next))) {
                this.h.add(this.f.get(next));
            }
        }
        for (String next2 : this.g.keySet()) {
            if (!this.h.contains(this.g.get(next2))) {
                this.h.add(this.g.get(next2));
            }
        }
    }

    public class a extends AsyncTask<Integer, Void, List<ContactSelectModel.AllContact>> {
        public a() {
        }

        /* renamed from: a */
        public List<ContactSelectModel.AllContact> doInBackground(Integer... numArr) {
            ContactStatus unused = PhoneContactsMananger.this.j = ContactStatus.loading;
            int i2 = 350;
            int intValue = (numArr == null || 1 > numArr.length) ? 350 : numArr[0].intValue();
            if (intValue > 0) {
                i2 = 1000 < intValue ? 1000 : intValue;
            }
            try {
                List unused2 = PhoneContactsMananger.this.k = PhoneContactsMananger.this.a(a.c(PhoneContactsMananger.this.c), i2);
            } catch (Throwable unused3) {
                List unused4 = PhoneContactsMananger.this.k = null;
            }
            ContactStatus unused5 = PhoneContactsMananger.this.j = ContactStatus.complited;
            return PhoneContactsMananger.this.k;
        }

        /* renamed from: a */
        public void onPostExecute(List<ContactSelectModel.AllContact> list) {
            if (PhoneContactsMananger.this.e != null) {
                PhoneContactsMananger.this.e.a(PhoneContactsMananger.this.k, PhoneContactsMananger.this.k == null ? 0 : PhoneContactsMananger.this.k.size());
            }
        }
    }

    public static synchronized PhoneContactsMananger a(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (b == null) {
                b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = b;
        }
        return phoneContactsMananger;
    }

    public void a(int i2, boolean z) {
        List<ContactSelectModel.AllContact> list;
        if (!this.f3562i.getAndSet(true) || !z) {
            this.j = ContactStatus.unload;
            new a().execute(new Integer[]{Integer.valueOf(i2)});
        } else if (this.e != null && (list = this.k) != null && ContactStatus.complited == this.j) {
            if (list.size() > i2) {
                this.e.a(this.k.subList(0, i2), i2);
            } else {
                this.e.a(this.k, i2);
            }
        }
    }

    public class b extends AsyncTask<String, String, String> {
        public final /* synthetic */ PhoneContactsMananger a;
        public ContactStatus b;

        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.b = ContactStatus.loading;
            if (this.a.f.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = this.a;
                ConcurrentHashMap unused = phoneContactsMananger.f = a.a(phoneContactsMananger.c);
            }
            String a2 = PhoneContactsMananger.a;
            LogUtil.d(a2, "手机里面的通讯：" + this.a.f.toString());
            if (this.a.g.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = this.a;
                ConcurrentHashMap unused2 = phoneContactsMananger2.g = a.b(phoneContactsMananger2.c);
            }
            String a3 = PhoneContactsMananger.a;
            LogUtil.d(a3, "Sim里面的通讯：" + this.a.g.toString());
            if (this.a.h == null || this.a.h.size() == 0) {
                this.a.b();
            }
            String a4 = PhoneContactsMananger.a;
            LogUtil.d(a4, "本地所有的通讯录信息：" + this.a.h.toString());
            this.b = ContactStatus.complited;
            return null;
        }

        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.a.d != null) {
                this.a.d.a(this.a.h);
            }
            super.onPostExecute(str);
        }
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    private ContactSelectModel.AllContact a(String str, String str2) {
        if (str == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        ContactSelectModel.PhoneNumberUnit phoneNumberUnit = new ContactSelectModel.PhoneNumberUnit();
        phoneNumberUnit.num = str2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(phoneNumberUnit);
        ContactSelectModel.AllContact allContact = new ContactSelectModel.AllContact();
        allContact.setName(str);
        allContact.setList(arrayList);
        return allContact;
    }

    /* access modifiers changed from: private */
    public List<ContactSelectModel.AllContact> a(List<ContractInfo> list, int i2) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (ContractInfo next : list) {
            if (next != null) {
                String name = next.getName();
                String mobile = next.getMobile();
                if (name != null) {
                    ContactSelectModel.AllContact allContact = (ContactSelectModel.AllContact) hashMap.get(name);
                    if (allContact == null) {
                        ContactSelectModel.AllContact a2 = a(name, mobile);
                        if (a2 != null) {
                            hashMap.put(name, a2);
                        }
                    } else {
                        ContactSelectModel.PhoneNumberUnit phoneNumberUnit = new ContactSelectModel.PhoneNumberUnit();
                        phoneNumberUnit.num = mobile;
                        allContact.getList().add(phoneNumberUnit);
                    }
                }
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Map.Entry value : hashMap.entrySet()) {
            int i4 = i3 + 1;
            if (i2 <= i3) {
                break;
            }
            arrayList.add(value.getValue());
            i3 = i4;
        }
        return arrayList;
    }
}
