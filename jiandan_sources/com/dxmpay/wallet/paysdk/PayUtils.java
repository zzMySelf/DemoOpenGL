package com.dxmpay.wallet.paysdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.dxmpay.apollon.armor.SecurePay;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.base.datamodel.AccountManager;
import com.dxmpay.wallet.base.statistics.StatServiceEvent;
import com.dxmpay.wallet.core.utils.PassUtil;
import com.dxmpay.wallet.paysdk.entrance.EnterDxmPayServiceAction;
import com.dxmpay.wallet.statistics.api.StatisticManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

@SuppressLint({"UseSparseArrays"})
public final class PayUtils {
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_CARD_NO = "card_no";
    public static final String KEY_CERT_END_DATE = "cert_end_date";
    public static final String KEY_CERT_START_DATE = "cert_start_date";
    public static final String KEY_CITY_ID = "city_id";
    public static final String KEY_COUNTY_ID = "county_id";
    public static final String KEY_CVV2 = "cvv2";
    public static final String KEY_GENDER = "gender";
    public static final String KEY_IDENTITY_CODE = "identity_code";
    public static final String KEY_JOB = "job";
    public static final String KEY_LOWER_JOB_ID = "lower_job_id";
    public static final String KEY_NATIONALITY = "nationality";
    public static final String KEY_OTP_REUSE_CODE = "otp_reuse_code";
    public static final String KEY_PHONE_NUMBER = "phone_number";
    public static final String KEY_PROVINCE_ID = "province_id";
    public static final String KEY_VALID_DATE = "valid_date";
    public static ArrayList<String> qw;

    public static class ad implements Comparator<String> {
        public ad() {
        }

        /* renamed from: qw */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }

        public /* synthetic */ ad(qw qwVar) {
            this();
        }
    }

    public static class qw implements Comparator<RestNameValuePair> {
        /* renamed from: qw */
        public int compare(RestNameValuePair restNameValuePair, RestNameValuePair restNameValuePair2) {
            return restNameValuePair.getName().compareTo(restNameValuePair2.getName());
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        qw = arrayList;
        arrayList.add("card_no");
        qw.add("valid_date");
        qw.add("cvv2");
        qw.add("identity_code");
        qw.add("phone_number");
        qw.add(KEY_CERT_START_DATE);
        qw.add(KEY_CERT_END_DATE);
        qw.add(KEY_NATIONALITY);
        qw.add(KEY_GENDER);
        qw.add(KEY_PROVINCE_ID);
        qw.add(KEY_CITY_ID);
        qw.add(KEY_COUNTY_ID);
        qw.add("address");
        qw.add(KEY_JOB);
        qw.add(KEY_LOWER_JOB_ID);
    }

    public static String ad(List<String> list, String str) {
        Collections.sort(list, new ad((qw) null));
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : list) {
            stringBuffer.append(append);
            stringBuffer.append(a.n);
        }
        stringBuffer.append("key=");
        stringBuffer.append(str);
        return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
    }

    public static String encrypt(String str, String str2) {
        str + "加密=" + str2;
        if (!qw.contains(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String encryptProxy = SecurePay.getInstance().encryptProxy(str2);
        str + "加密=" + encryptProxy;
        return encryptProxy;
    }

    public static String genAPIsig(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList();
        for (RestNameValuePair next : list) {
            arrayList.add(next.getName() + "=" + next.getValue());
        }
        return qw(arrayList);
    }

    public static String getCookie(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        if (AccountManager.getInstance(context).getLoginType() == 1) {
            stringBuffer.append("access_token=");
        }
        String loginStoken = WalletLoginHelper.getInstance().getLoginStoken();
        if (!TextUtils.isEmpty(loginStoken)) {
            stringBuffer.append(";stoken=" + loginStoken);
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getTpl())) {
                stringBuffer.append(";tpl=" + WalletLoginHelper.getInstance().getTpl());
            }
        }
        return stringBuffer.toString();
    }

    public static String getDxmDid(Context context) {
        return AccountManager.getInstance(context).getLoginData().get(PassUtil.DXM_DID);
    }

    public static String getDxmOaid() {
        return (String) fe.i.ad.yj.qw.ad(EnterDxmPayServiceAction.GET_DXM_OAID);
    }

    public static String getNewCookie(Context context) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> loginData = AccountManager.getInstance(context).getLoginData();
        String str = loginData.get("pass_open_bduss");
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (AccountManager.getInstance(context).getLoginType() == 0) {
            sb.append("OPENBDUSS=");
            sb.append(str);
        } else if (AccountManager.getInstance(context).getLoginType() == 1) {
            sb.append("access_token=");
            sb.append(str);
        }
        String str2 = loginData.get("pass_stoken");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(";stoken=");
            sb.append(str2);
            if (!TextUtils.isEmpty(WalletLoginHelper.getInstance().getTpl())) {
                sb.append(";tpl=");
                sb.append(WalletLoginHelper.getInstance().getTpl());
            }
        }
        return sb.toString();
    }

    public static String getNonce(List<RestNameValuePair> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList, new qw());
        String list2String = list2String(arrayList);
        return !TextUtils.isEmpty(list2String) ? encrypt("phone_number", Md5Utils.toMD5(list2String, "UTF-8")) : "";
    }

    public static String getParamsSign(Map<String, String> map, String str) {
        return (map == null || map.size() == 0) ? "" : ad(mapToList(map), str);
    }

    public static String getUnionID(Context context) {
        return AccountManager.getInstance(context).getLoginData().get("pass_union_id");
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

    public static String qw(List<String> list) {
        Collections.sort(list, new ad((qw) null));
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : list) {
            stringBuffer.append(append);
            stringBuffer.append(a.n);
        }
        stringBuffer.append("key=");
        stringBuffer.append("");
        return URLEncoder.encode(Md5Utils.md5Hex(stringBuffer.toString()));
    }

    public static void setDxmOaid(String str) {
        StatisticManager.onEventWithValue(StatServiceEvent.SET_DXM_OAID, str);
        fe.i.ad.yj.qw.de(EnterDxmPayServiceAction.GET_DXM_OAID, str);
    }
}
