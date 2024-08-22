package com.baidu.wallet.lightapp.business.datamodel;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.datamodel.Bank;
import java.io.Serializable;
import java.util.Comparator;

public class ContactInfo implements Comparator<ContactInfo> {
    public String a;
    public String b;

    public static class Phone implements Serializable {
        public String number;
        public int type;

        public String getTypeName() {
            int i2 = this.type;
            if (i2 == 0) {
                return "自定义";
            }
            if (i2 == 1) {
                return "住宅";
            }
            if (i2 == 2) {
                return "手机";
            }
            if (i2 == 3) {
                return "工作";
            }
            if (i2 == 4) {
                return "工作传真";
            }
            if (i2 == 5) {
                return "家庭传真";
            }
            if (i2 != 10) {
                return i2 != 12 ? "其他" : "主机";
            }
            return "公司总机";
        }
    }

    /* renamed from: a */
    public int compare(ContactInfo contactInfo, ContactInfo contactInfo2) {
        if (contactInfo == null && contactInfo2 == null) {
            return 0;
        }
        if (contactInfo == null) {
            return contactInfo2 == null ? 0 : 1;
        }
        if (contactInfo2 == null) {
            return contactInfo == null ? 0 : -1;
        }
        contactInfo.b = a(contactInfo.a);
        contactInfo2.b = a(contactInfo2.a);
        if (TextUtils.isEmpty(contactInfo.b) && TextUtils.isEmpty(contactInfo2.b)) {
            return 0;
        }
        if (TextUtils.isEmpty(contactInfo.b)) {
            return TextUtils.isEmpty(contactInfo2.b) ^ true ? 1 : 0;
        }
        if (!TextUtils.isEmpty(contactInfo2.b)) {
            contactInfo.b = contactInfo.b.toUpperCase();
            String upperCase = contactInfo2.b.toUpperCase();
            contactInfo2.b = upperCase;
            if (contactInfo.b.equals(upperCase)) {
                return 0;
            }
            if (contactInfo.b.equals(Bank.HOT_BANK_LETTER)) {
                return 1;
            }
            if (contactInfo2.b.equals(Bank.HOT_BANK_LETTER)) {
                return -1;
            }
            return contactInfo.b.compareTo(contactInfo2.b);
        } else if (TextUtils.isEmpty(contactInfo.b)) {
            return 0;
        } else {
            return -1;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 1 || !str.substring(0, 1).toUpperCase().matches("[A-Z]")) {
            return Bank.HOT_BANK_LETTER;
        }
        return str;
    }
}
