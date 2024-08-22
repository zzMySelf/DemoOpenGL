package com.duxiaoman.dxmpay.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.duxiaoman.dxmpay.statistics.internal.IStatConfig;
import com.duxiaoman.dxmpay.statistics.internal.ISyncHttpImpl;
import com.duxiaoman.dxmpay.statistics.internal.LogSender;
import com.duxiaoman.dxmpay.statistics.internal.StatService;
import fe.th.qw.qw.qw.rg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class StatApi {

    /* renamed from: fe  reason: collision with root package name */
    public static Context f3784fe;

    /* renamed from: ad  reason: collision with root package name */
    public boolean f3785ad;

    /* renamed from: de  reason: collision with root package name */
    public ISyncHttpImpl f3786de;
    public IStatConfig qw;

    public static class qw {
        public static StatApi qw = new StatApi();
    }

    public static boolean cacheAppContext(Context context) {
        if (f3784fe == null && context != null) {
            f3784fe = context.getApplicationContext();
        }
        return f3784fe != null;
    }

    public static Context getAppContext() {
        return f3784fe;
    }

    public static StatApi getInstance() {
        return qw.qw;
    }

    public static void init(Context context, IStatConfig iStatConfig) {
        getInstance();
        if (cacheAppContext(context) && iStatConfig != null) {
            StatApi instance = getInstance();
            instance.qw = iStatConfig;
            try {
                if (!instance.f3785ad) {
                    instance.f3785ad = true;
                    rg.qw().fe();
                    LogSender.getInstance().triggerSending("normal_log");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void initData(Context context) {
        cacheAppContext(context);
        rg.qw().fe();
    }

    public static void onBack(String str) {
        if (getInstance().f3785ad && !getInstance().qw()) {
            try {
                StatService.de(str, StatService.ETag.back, (Collection<String>) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onEvent(String str) {
        if (getInstance().f3785ad && !getInstance().qw()) {
            onEventWithValues(str, (Collection<String>) null, (Map<String, Object>) null, (String) null);
        }
    }

    public static void onEventEnd(String str, int i2) {
        onEventEndWithValue(str, i2, (String) null, (String) null);
    }

    public static void onEventEndWithValue(String str, int i2, String str2) {
        onEventEndWithValue(str, i2, str2, (String) null);
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection) {
        onEventEndWithValues(str, i2, collection, (Map<String, Object>) null, (String) null);
    }

    public static void onEventStart(String str) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            try {
                StatService.ad(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onEventWithValue(String str, String str2) {
        onEventWithValue(str, str2, (String) null);
    }

    public static void onEventWithValues(String str, Collection<String> collection) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            onEventWithValues(str, collection, (Map<String, Object>) null, (String) null);
        }
    }

    public static void onIn(String str, long j) {
        if (!getInstance().f3785ad || getInstance().qw()) {
            return;
        }
        if (0 < j) {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Long.toString(j));
                StatService.de(str, StatService.ETag.in, arrayList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            StatService.de(str, StatService.ETag.in, (Collection<String>) null);
        }
    }

    public static void onOut(String str) {
        if (getInstance().f3785ad && !getInstance().qw()) {
            try {
                StatService.de(str, StatService.ETag.out, (Collection<String>) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onPush(String str) {
        if (getInstance().f3785ad && !getInstance().qw()) {
            try {
                StatService.de(str, StatService.ETag.push, (Collection<String>) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void setSyncHttpImpl(ISyncHttpImpl iSyncHttpImpl) {
        getInstance().f3786de = iSyncHttpImpl;
    }

    public ISyncHttpImpl getHttpImpl() {
        return this.f3786de;
    }

    public IStatConfig getSettings() {
        return this.qw;
    }

    public final boolean qw() {
        return !StrategyProcess.getInstance().isDataItemEnable();
    }

    public StatApi() {
    }

    public static void onEventEnd(String str, int i2, String str2) {
        onEventEndWithValue(str, i2, (String) null, str2);
    }

    public static void onEventEndWithValue(String str, int i2, String str2, String str3) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            try {
                StatService.rg(str, Integer.toString(i2), str2, str3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map) {
        onEventEndWithValues(str, i2, collection, map, (String) null);
    }

    public static void onEventWithValue(String str, String str2, String str3) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            try {
                StatService.fe(str, str2, str3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onEventEnd(String str) {
        onEventEndWithValue(str, (String) null);
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, String str2) {
        onEventEndWithValues(str, i2, collection, (Map<String, Object>) null, str2);
    }

    public static void onEvent(String str, String str2) {
        if (getInstance().f3785ad && !getInstance().qw()) {
            onEventWithValues(str, (Collection<String>) null, str2);
        }
    }

    public static void onEventEnd(String str, String str2) {
        onEventEndWithValue(str, str2);
    }

    public static void onEventEndWithValues(String str, int i2, Collection<String> collection, Map<String, Object> map, String str2) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            try {
                StatService.pf(str, Integer.toString(i2), collection, map, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        onEventWithValues(str, collection, map, (String) null);
    }

    public static void onEventWithValues(String str, Collection<String> collection, String str2) {
        onEventWithValues(str, collection, (Map<String, Object>) null, str2);
    }

    public static void onEventEndWithValue(String str, String str2) {
        onEventEndWithValue(str, str2, (String) null);
    }

    public static void onEventWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            try {
                StatService.yj(str, (String) null, collection, map, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onEventEndWithValue(String str, String str2, String str3) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            try {
                StatService.o(str, str2, str3);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void onEventEndWithValues(String str, Collection<String> collection) {
        onEventEndWithValues(str, collection, (Map<String, Object>) null, (String) null);
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, String str2) {
        onEventEndWithValues(str, collection, (Map<String, Object>) null, str2);
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map) {
        onEventEndWithValues(str, collection, map, (String) null);
    }

    public static void onEventEndWithValues(String str, Collection<String> collection, Map<String, Object> map, String str2) {
        if (getInstance().f3785ad && !getInstance().qw() && !TextUtils.isEmpty(str)) {
            try {
                StatService.uk(str, collection, map, str2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
