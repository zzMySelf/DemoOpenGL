package com.dxmpay.wallet.utils.realtimeevent;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.dxmpay.apollon.beans.IBeanResponseCallback;
import com.dxmpay.apollon.utils.Md5Utils;
import com.dxmpay.apollon.utils.PhoneUtils;
import com.dxmpay.wallet.api.WalletLoginHelper;
import com.dxmpay.wallet.core.domain.DomainConfig;
import com.dxmpay.wallet.utils.StatHelper;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class RealTimeEventHelper {

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

    public static class qw implements IBeanResponseCallback {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ fe.i.ad.yj.de.qw f4376ad;

        public qw(fe.i.ad.yj.de.qw qwVar) {
            this.f4376ad = qwVar;
        }

        public void onBeanExecFailure(int i2, int i3, String str) {
            this.f4376ad.destroyBean();
        }

        public void onBeanExecSuccess(int i2, Object obj, String str) {
            this.f4376ad.destroyBean();
        }
    }

    public static String ad(List<String> list) {
        Collections.sort(list, new ad((qw) null));
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : list) {
            stringBuffer.append(append);
            stringBuffer.append(a.n);
        }
        stringBuffer.append("key=");
        stringBuffer.append("MhxzKhl");
        return Md5Utils.toMD5(stringBuffer.toString());
    }

    public static void eventStatBean(Context context, String str, String str2, Map<String, String> map, String str3, String str4) {
        fe.i.ad.yj.de.qw qwVar = new fe.i.ad.yj.de.qw(context, qw(getEventValues(context, str, str2, map, str3, str4)));
        qwVar.setResponseCallback(new qw(qwVar));
        qwVar.execBean();
    }

    public static ArrayList<String> genEventValue(String str, String... strArr) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        try {
            arrayList.add(getSinalParam(str, StatHelper.SP_NO));
            arrayList.add(getSinalParam(str, "order_no"));
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (!TextUtils.isEmpty(strArr[i2])) {
                    arrayList.add(strArr[i2]);
                } else {
                    arrayList.add("empty");
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static String getEventValues(Context context, String str, String str2, Map<String, String> map, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str2) && map == null) {
            return sb.toString();
        }
        try {
            sb.append("event=" + str);
            String sinalParam = getSinalParam(str2, StatHelper.SP_NO);
            sb.append("&sp_no=" + sinalParam);
            String sinalParam2 = getSinalParam(str2, "order_no");
            sb.append("&order_no=" + sinalParam2);
            sb.append("&pay=" + str3);
            String str5 = "";
            if (map.containsKey("key_remote_pkg_name")) {
                String str6 = map.get("key_remote_pkg_name");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("&caller=");
                if (TextUtils.isEmpty(str6)) {
                    str6 = str5;
                }
                sb2.append(str6);
                sb.append(sb2.toString());
            }
            if (map.containsKey("key_remote_pkg_ver")) {
                String str7 = map.get("key_remote_pkg_ver");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("&caller_ver=");
                if (!TextUtils.isEmpty(str7)) {
                    str5 = str7;
                }
                sb3.append(str5);
                sb.append(sb3.toString());
            }
            sb.append("&result=" + str4);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("&is_login=");
            sb4.append(WalletLoginHelper.getInstance().isLogin() ? "1" : "0");
            sb.append(sb4.toString());
            sb.append("&cuid_1=" + PhoneUtils.getCUID(context));
            sb.append("&time=" + System.currentTimeMillis());
            sb.append("&version=2");
            sb.append("&sign_method=1");
            String[] split = sb.toString().split(a.n);
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, split);
            sb.append("&sign=" + ad(arrayList));
            return sb.toString();
        } catch (Exception unused) {
            return sb.toString();
        }
    }

    public static String getSinalParam(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            for (String split : str.split(a.n)) {
                String[] split2 = split.split("=");
                if (split2 != null && !TextUtils.isEmpty(split2[0]) && str2.equalsIgnoreCase(split2[0]) && split2.length > 1) {
                    return URLDecoder.decode(split2[1]);
                }
            }
            return "";
        } catch (Exception e) {
            e.toString();
            return "";
        }
    }

    public static String qw(String str) {
        return DomainConfig.getInstance().getAppHost() + "/chanpin_stat?" + str;
    }
}
