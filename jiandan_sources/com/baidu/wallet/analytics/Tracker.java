package com.baidu.wallet.analytics;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import com.baidu.apollon.restnet.RestNameValuePair;
import com.baidu.apollon.utils.NetworkUtils;
import com.baidu.wallet.api.WalletApiExt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Tracker {
    public static void send(@NonNull String str, @NonNull Collection<String> collection, @NonNull Context context) {
        send(str, collection, context, ShareTarget.METHOD_GET);
    }

    public static void sendPerformanceInfoToSensors(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context) {
        if (WalletApiExt.getInstance().getSensorsAdapter() != null) {
            WalletApiExt.getInstance().getSensorsAdapter().sendPerformanceInfo(map);
        }
    }

    public static void send(@NonNull String str, @NonNull Collection<String> collection, @NonNull Context context, String str2) {
        ArrayList arrayList = new ArrayList(collection.size() + 2);
        arrayList.add(new RestNameValuePair("type", str));
        int i2 = 1;
        for (String restNameValuePair : collection) {
            arrayList.add(new RestNameValuePair("value" + i2, restNameValuePair));
            i2++;
        }
        arrayList.add(new RestNameValuePair("netType", String.valueOf(NetworkUtils.getNetworkType(context))));
        new TraceBean(context).buildParams(arrayList, str2).execBean();
    }

    public static void send(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context) {
        send(str, map, context, ShareTarget.METHOD_GET);
    }

    public static void send(@NonNull String str, @NonNull Map<String, String> map, @NonNull Context context, @NonNull String str2) {
        ArrayList arrayList = new ArrayList(map.size() + 2);
        arrayList.add(new RestNameValuePair("type", str));
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
        }
        arrayList.add(new RestNameValuePair("netType", String.valueOf(NetworkUtils.getNetworkType(context))));
        new TraceBean(context).buildParams(arrayList, str2).execBean();
    }

    public static void send(@NonNull String str, @NonNull Map<String, String> map, @NonNull Map<String, String> map2, @Nullable String str2, @NonNull Context context) {
        ArrayList arrayList = new ArrayList(map.size() + 2);
        arrayList.add(new RestNameValuePair("type", str));
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new RestNameValuePair((String) next.getKey(), (String) next.getValue()));
        }
        arrayList.add(new RestNameValuePair("netType", String.valueOf(NetworkUtils.getNetworkType(context))));
        ArrayList arrayList2 = new ArrayList(map2.size());
        for (Map.Entry next2 : map2.entrySet()) {
            arrayList2.add(new RestNameValuePair((String) next2.getKey(), (String) next2.getValue()));
        }
        new TraceBean(context).buildQueryParams(arrayList).buildPostParams(arrayList2).buildBaseUrl(str2).execBean();
    }
}
