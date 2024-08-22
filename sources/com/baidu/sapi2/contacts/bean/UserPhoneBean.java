package com.baidu.sapi2.contacts.bean;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.utils.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserPhoneBean implements NoProguard {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18210a = "UserPhoneBean";

    /* renamed from: b  reason: collision with root package name */
    private static final String f18211b = "name";

    /* renamed from: c  reason: collision with root package name */
    private static final String f18212c = "phones";

    /* renamed from: d  reason: collision with root package name */
    private static final String f18213d = "uid";

    /* renamed from: e  reason: collision with root package name */
    private static final String f18214e = "tag";

    /* renamed from: f  reason: collision with root package name */
    private static final String f18215f = "displayname";

    /* renamed from: g  reason: collision with root package name */
    private static final String f18216g = "enc_phone";

    /* renamed from: h  reason: collision with root package name */
    private static final String f18217h = "phone";
    public boolean checked;
    public String name;
    public List<Phone> phones = new ArrayList();

    public static class Phone implements NoProguard {
        public String displayname;
        public String encryptPhone;
        public String phone;
        public String tag;
        public String uid;

        public Phone() {
        }

        private void a(String str, String str2, JSONObject jSONObject) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    Log.e(e2);
                }
            }
        }

        public static Phone fromJSON(JSONObject jSONObject) {
            Phone phone2 = new Phone();
            phone2.uid = jSONObject.optString("uid");
            phone2.tag = jSONObject.optString("tag");
            phone2.displayname = jSONObject.optString("displayname");
            phone2.encryptPhone = jSONObject.optString(UserPhoneBean.f18216g);
            phone2.phone = jSONObject.optString("phone");
            return phone2;
        }

        public boolean compareWithNewPhone(Phone phone2) {
            if (phone2 == null) {
                return false;
            }
            return (this.tag + "" + this.phone).equals(phone2.tag + "" + phone2.phone);
        }

        public JSONObject toJSON() {
            JSONObject jSONObject = new JSONObject();
            a("uid", this.uid, jSONObject);
            a("tag", this.tag, jSONObject);
            a("displayname", this.displayname, jSONObject);
            a(UserPhoneBean.f18216g, this.encryptPhone, jSONObject);
            a("phone", this.phone, jSONObject);
            return jSONObject;
        }

        public Phone(String str, String str2) {
            this.tag = str;
            this.phone = str2;
        }

        public Phone(String str, String str2, String str3, String str4) {
            this.uid = str;
            this.displayname = str2;
            this.tag = str3;
            this.encryptPhone = str4;
        }
    }

    public UserPhoneBean() {
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.name);
            JSONArray jSONArray = new JSONArray();
            for (Phone json : this.phones) {
                jSONArray.put(json.toJSON());
            }
            jSONObject.put(f18212c, jSONArray);
            return jSONObject;
        } catch (Throwable th2) {
            Log.e(th2);
            return null;
        }
    }

    public UserPhoneBean(String str, List list) {
        this.name = str;
        this.phones = list;
    }
}
