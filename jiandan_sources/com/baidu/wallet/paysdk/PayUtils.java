package com.baidu.wallet.paysdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.apollon.armor.SafePay;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.Md5Utils;
import com.baidu.wallet.api.WalletLoginHelper;
import com.baidu.wallet.base.datamodel.AccountManager;
import com.baidu.wallet.core.utils.LogUtil;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

@SuppressLint({"UseSparseArrays"})
public final class PayUtils {
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_VALID_DATE = "valid_date";
    public static String a = "PayUtils";
    public static final String b = "";
    public static ArrayList<String> c;

    public static class a implements Comparator<String> {
        public a() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        c = arrayList;
        arrayList.add("card_no");
        c.add("valid_date");
        c.add("cvv2");
        c.add("identity_code");
        c.add("phone_number");
    }

    public static String a(List<String> list) {
        Collections.sort(list, new a());
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : list) {
            stringBuffer.append(append);
            stringBuffer.append(com.alipay.sdk.m.s.a.n);
        }
        stringBuffer.append("key=");
        stringBuffer.append("");
        return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
    }

    public static String encrypt(String str, String str2) {
        LogUtil.d(str + "加密=" + str2);
        if (!c.contains(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String encryptProxy = SafePay.getInstance().encryptProxy(str2);
        LogUtil.d(str + "加密=" + encryptProxy);
        return encryptProxy;
    }

    public static String genAPIsig(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList();
        for (RestNameValuePair next : list) {
            arrayList.add(next.getName() + "=" + next.getValue());
        }
        return a(arrayList);
    }

    public static String getNewCookie(Context context) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> loginData = AccountManager.getInstance(context).getLoginData();
        String str = "";
        if (loginData == null) {
            return str;
        }
        String str2 = loginData.get("pass_open_bduss");
        LogUtil.d("openbduss", "openbduss = " + str2);
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (AccountManager.getInstance(context).getLoginType() == 0) {
            sb.append("OPENBDUSS=");
            sb.append(str);
        } else if (AccountManager.getInstance(context).getLoginType() == 1) {
            sb.append("access_token=");
            sb.append(str);
        }
        String str3 = loginData.get("pass_stoken");
        if (!TextUtils.isEmpty(str3)) {
            sb.append(";stoken=");
            sb.append(str3);
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getTpl())) {
                sb.append(";tpl=");
                sb.append(WalletLoginHelper.getInstance().getTpl());
            }
        }
        return sb.toString();
    }

    public static String getNonce(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new Comparator<RestNameValuePair>() {
            /* renamed from: a */
            public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
                return restNameValuePair.getName().compareTo(restNameValuePair2.getName());
            }
        });
        String list2String = list2String(arrayList);
        return !TextUtils.isEmpty(list2String) ? encrypt("phone_number", Md5Utils.toMD5(list2String, "UTF-8")) : "";
    }

    public static String getParamsSign(Map<String, String> map, String str) {
        return (map == null || map.size() == 0) ? "" : a(mapToList(map), str);
    }

    public static String list2String(List<RestNameValuePair> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (RestNameValuePair next : list) {
            String name = next.getName();
            String value = next.getValue();
            if (!TextUtils.isEmpty(name)) {
                if (value == null) {
                    value = "";
                }
                sb.append(name);
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(value);
                sb.append(Typography.amp);
            }
        }
        if (sb.length() > 1) {
            sb.replace(sb.length() - 1, sb.length(), "");
        }
        return sb.toString();
    }

    public static List<String> mapToList(Map<String, String> map) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append((String) next.getKey());
            sb.append("=");
            if (TextUtils.isEmpty((CharSequence) next.getValue())) {
                str = "";
            } else {
                str = (String) next.getValue();
            }
            sb.append(str);
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    public static String a(List<String> list, String str) {
        Collections.sort(list, new a());
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : list) {
            stringBuffer.append(append);
            stringBuffer.append(com.alipay.sdk.m.s.a.n);
        }
        stringBuffer.append("key=");
        stringBuffer.append(str);
        return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
    }
}
