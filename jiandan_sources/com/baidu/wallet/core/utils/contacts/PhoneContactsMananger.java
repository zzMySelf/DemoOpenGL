package com.baidu.wallet.core.utils.contacts;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.baidu.apollon.utils.DxmApplicationContextImpl;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.core.utils.contacts.ContactSelectModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"StaticFieldLeak"})
public class PhoneContactsMananger {
    public static final String a = "PhoneContactsMananger";
    public static PhoneContactsMananger b;
    public Context c;
    public ConcurrentHashMap<String, ContractInfo> d = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String, ContractInfo> e = new ConcurrentHashMap<>();
    public ArrayList<ContractInfo> f = new ArrayList<>();
    public b g = null;

    /* renamed from: com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$ContactStatus[] r0 = com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.ContactStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$ContactStatus r1 = com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.ContactStatus.unload     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$ContactStatus r1 = com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.ContactStatus.loading     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.wallet.core.utils.contacts.PhoneContactsMananger$ContactStatus r1 = com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.ContactStatus.complited     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.core.utils.contacts.PhoneContactsMananger.AnonymousClass1.<clinit>():void");
        }
    }

    public enum ContactStatus {
        unload,
        loading,
        complited
    }

    public interface LoadAddressInfoComplitedListener {
        void onLoadContractsComplited(ArrayList<ContractInfo> arrayList);
    }

    public interface LoadAddressInfoListener {
        void onFixPhoneList(String str, List<ContractInfo> list);

        void onLoadFastPayPhoneInfo(String str, ContractInfo contractInfo);
    }

    public interface LoadAllContactListener {
        void onLoadSuccess(List<ContactSelectModel.AllContact> list, int i2);
    }

    public class a extends AsyncTask<String, String, String> {
        public int b;
        public ArrayList<ContactSelectModel.AllContact> c = new ArrayList<>();
        public LoadAllContactListener d;

        public a() {
        }

        public int a() {
            return this.b;
        }

        public void a(int i2, LoadAllContactListener loadAllContactListener) {
            this.b = i2;
            this.d = loadAllContactListener;
        }

        /* renamed from: a */
        public String doInBackground(String... strArr) {
            try {
                List<ContractInfo> allPhone = AddressUtils.getAllPhone(PhoneContactsMananger.this.c);
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                for (int i2 = 0; i2 < allPhone.size(); i2++) {
                    String name = allPhone.get(i2).getName();
                    if (concurrentHashMap.containsKey(name)) {
                        ContactSelectModel.AllContact allContact = (ContactSelectModel.AllContact) concurrentHashMap.get(name);
                        if (allContact != null) {
                            ContactSelectModel.PhoneNumberUnit phoneNumberUnit = new ContactSelectModel.PhoneNumberUnit();
                            phoneNumberUnit.num = allPhone.get(i2).getMobile();
                            allContact.getList().add(phoneNumberUnit);
                            concurrentHashMap.put(name, allContact);
                        } else {
                            ContactSelectModel.AllContact allContact2 = new ContactSelectModel.AllContact();
                            allContact2.setName(name);
                            ArrayList arrayList = new ArrayList();
                            ContactSelectModel.PhoneNumberUnit phoneNumberUnit2 = new ContactSelectModel.PhoneNumberUnit();
                            phoneNumberUnit2.num = allPhone.get(i2).getMobile();
                            arrayList.add(phoneNumberUnit2);
                            allContact2.setList(arrayList);
                            concurrentHashMap.put(name, allContact2);
                        }
                    } else {
                        ContactSelectModel.AllContact allContact3 = (ContactSelectModel.AllContact) concurrentHashMap.get(name);
                        ContactSelectModel.AllContact allContact4 = new ContactSelectModel.AllContact();
                        allContact4.setName(name);
                        ArrayList arrayList2 = new ArrayList();
                        ContactSelectModel.PhoneNumberUnit phoneNumberUnit3 = new ContactSelectModel.PhoneNumberUnit();
                        phoneNumberUnit3.num = allPhone.get(i2).getMobile();
                        arrayList2.add(phoneNumberUnit3);
                        allContact4.setList(arrayList2);
                        concurrentHashMap.put(name, allContact4);
                    }
                }
                for (Map.Entry value : concurrentHashMap.entrySet()) {
                    this.c.add((ContactSelectModel.AllContact) value.getValue());
                }
                return null;
            } catch (Throwable th2) {
                LogUtil.d(PhoneContactsMananger.a, th2.getMessage());
                return null;
            }
        }

        /* renamed from: a */
        public void onPostExecute(String str) {
            if (this.d != null) {
                int size = this.c.size();
                int i2 = this.b;
                if (size > i2) {
                    this.d.onLoadSuccess(this.c.subList(0, i2), this.b);
                } else {
                    this.d.onLoadSuccess(this.c, i2);
                }
                this.d = null;
            }
            super.onPostExecute(str);
        }
    }

    public class b extends AsyncTask<String, String, String> {
        public ContactStatus b = ContactStatus.unload;
        public LoadAddressInfoComplitedListener c;

        public b() {
        }

        public void a(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
            this.c = loadAddressInfoComplitedListener;
        }

        public ContactStatus a() {
            return this.b;
        }

        /* renamed from: a */
        public String doInBackground(String... strArr) {
            this.b = ContactStatus.loading;
            if (PhoneContactsMananger.this.d.size() == 0) {
                PhoneContactsMananger phoneContactsMananger = PhoneContactsMananger.this;
                ConcurrentHashMap unused = phoneContactsMananger.d = AddressUtils.getPhoneContracts(phoneContactsMananger.c);
            }
            String a2 = PhoneContactsMananger.a;
            LogUtil.d(a2, "手机里面的通讯：" + PhoneContactsMananger.this.d.toString());
            if (PhoneContactsMananger.this.e.size() == 0) {
                PhoneContactsMananger phoneContactsMananger2 = PhoneContactsMananger.this;
                ConcurrentHashMap unused2 = phoneContactsMananger2.e = AddressUtils.getSimContracts(phoneContactsMananger2.c);
            }
            String a3 = PhoneContactsMananger.a;
            LogUtil.d(a3, "Sim里面的通讯：" + PhoneContactsMananger.this.e.toString());
            if (PhoneContactsMananger.this.f == null || PhoneContactsMananger.this.f.size() == 0) {
                PhoneContactsMananger.this.b();
            }
            String a4 = PhoneContactsMananger.a;
            LogUtil.d(a4, "本地所有的通讯录信息：" + PhoneContactsMananger.this.f.toString());
            this.b = ContactStatus.complited;
            return null;
        }

        /* renamed from: a */
        public void onPostExecute(String str) {
            if (PhoneContactsMananger.this.f.isEmpty()) {
                this.b = ContactStatus.unload;
            }
            LoadAddressInfoComplitedListener loadAddressInfoComplitedListener = this.c;
            if (loadAddressInfoComplitedListener != null) {
                loadAddressInfoComplitedListener.onLoadContractsComplited(PhoneContactsMananger.this.f);
                this.c = null;
            }
            super.onPostExecute(str);
        }
    }

    public PhoneContactsMananger(Context context) {
        if (context != null) {
            this.c = DxmApplicationContextImpl.getApplicationContext(context);
        }
    }

    public static synchronized PhoneContactsMananger getInstance(Context context) {
        PhoneContactsMananger phoneContactsMananger;
        synchronized (PhoneContactsMananger.class) {
            if (b == null) {
                b = new PhoneContactsMananger(context);
            }
            phoneContactsMananger = b;
        }
        return phoneContactsMananger;
    }

    public String getPayphoneInfo(String str) {
        String str2;
        ContractInfo contractInfo = this.d.get(str);
        if (contractInfo == null) {
            contractInfo = this.e.get(str);
        }
        String str3 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("手机号：");
        sb.append(str);
        sb.append(" ");
        if (contractInfo != null) {
            str2 = "关联到的信息是" + contractInfo.toString();
        } else {
            str2 = "该手机号没有关联通讯录";
        }
        sb.append(str2);
        LogUtil.d(str3, sb.toString());
        return contractInfo != null ? contractInfo.getName() : "";
    }

    public void loadAllContacts(int i2, LoadAllContactListener loadAllContactListener) {
        a aVar = new a();
        aVar.a(i2, loadAllContactListener);
        aVar.execute(new String[]{""});
    }

    public void loadFixPhoneList(String str, int i2, boolean z, LoadAddressInfoListener loadAddressInfoListener) {
        ContractInfo contractInfo;
        char[] cArr;
        if (z) {
            contractInfo = this.d.get(str);
            if (contractInfo == null) {
                contractInfo = this.e.get(str);
            }
        } else {
            String formatPhoneNumber = StringUtils.formatPhoneNumber(str);
            if (!TextUtils.isEmpty(formatPhoneNumber)) {
                ContractInfo contractInfo2 = this.d.get(formatPhoneNumber);
                contractInfo = contractInfo2 == null ? this.e.get(formatPhoneNumber) : contractInfo2;
            } else {
                contractInfo = null;
            }
        }
        if (contractInfo != null) {
            String str2 = a;
            LogUtil.d(str2, "该手机号：" + str + " 是通讯录里面的号码");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onFixPhoneList(str, new ArrayList());
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < this.f.size(); i3++) {
            if (this.f.get(i3) != null && !TextUtils.isEmpty(this.f.get(i3).getMobile())) {
                String mobile = this.f.get(i3).getMobile();
                if (z) {
                    cArr = mobile.toCharArray();
                } else {
                    cArr = mobile.replace(" ", "").toCharArray();
                }
                this.f.get(i3).setErrordigit(-1);
                int i4 = 0;
                for (int i5 = 0; i5 < cArr.length; i5++) {
                    if (charArray[i5] != cArr[i5] && (i4 = i4 + 1) == 1) {
                        this.f.get(i3).setErrordigit(i5);
                    }
                    if (i4 > i2) {
                        break;
                    }
                }
                if (i4 <= 0 || i4 > i2) {
                    this.f.get(i3).setErrordigit(-1);
                } else {
                    arrayList.add(this.f.get(i3));
                }
            }
        }
        String str3 = a;
        LogUtil.d(str3, "与手机号：" + str + " 是通讯录里面最多有" + i2 + "位不一样的号码是：" + arrayList.toString());
        if (loadAddressInfoListener != null) {
            loadAddressInfoListener.onFixPhoneList(str, arrayList);
        }
    }

    public void loadPayphoneInfo(String str, LoadAddressInfoListener loadAddressInfoListener) {
        String str2;
        ContractInfo contractInfo = this.d.get(str);
        if (contractInfo == null) {
            contractInfo = this.e.get(str);
        }
        if (contractInfo == null && this.f.size() == 0) {
            LogUtil.d(a, "通讯录为空，视为没有权限为关闭");
            if (loadAddressInfoListener != null) {
                loadAddressInfoListener.onLoadFastPayPhoneInfo(str, new ContractInfo());
                return;
            }
            return;
        }
        String str3 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("手机号：");
        sb.append(str);
        sb.append(" ");
        if (contractInfo != null) {
            str2 = "关联到的信息是" + contractInfo.toString();
        } else {
            str2 = "该手机号没有关联通讯录";
        }
        sb.append(str2);
        LogUtil.d(str3, sb.toString());
        if (loadAddressInfoListener != null) {
            loadAddressInfoListener.onLoadFastPayPhoneInfo(str, contractInfo);
        }
    }

    public void loadPhoneContacts(LoadAddressInfoComplitedListener loadAddressInfoComplitedListener) {
        if (this.g == null || this.f.isEmpty()) {
            this.g = new b();
        }
        int i2 = AnonymousClass1.a[this.g.a().ordinal()];
        if (i2 == 1) {
            try {
                this.g.a(loadAddressInfoComplitedListener);
                this.g.execute(new String[]{""});
            } catch (IllegalStateException e2) {
                LogUtil.d(PhoneContactsMananger.class.toString(), e2.toString());
            }
        } else if (i2 == 3 && loadAddressInfoComplitedListener != null) {
            loadAddressInfoComplitedListener.onLoadContractsComplited(this.f);
        }
    }

    public void reset() {
        if (this.g != null) {
            this.g = null;
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        ConcurrentHashMap<String, ContractInfo> concurrentHashMap2 = this.e;
        if (concurrentHashMap2 != null) {
            concurrentHashMap2.clear();
        }
        ArrayList<ContractInfo> arrayList = this.f;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        for (String next : this.d.keySet()) {
            if (!this.f.contains(this.d.get(next))) {
                this.f.add(this.d.get(next));
            }
        }
        for (String next2 : this.e.keySet()) {
            if (!this.f.contains(this.e.get(next2))) {
                this.f.add(this.e.get(next2));
            }
        }
    }
}
