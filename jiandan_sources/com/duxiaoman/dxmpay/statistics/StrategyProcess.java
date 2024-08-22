package com.duxiaoman.dxmpay.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.duxiaoman.dxmpay.statistics.internal.IStatConfig;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class StrategyProcess {

    /* renamed from: ad  reason: collision with root package name */
    public Context f3787ad;

    /* renamed from: de  reason: collision with root package name */
    public JSONObject f3788de;

    /* renamed from: fe  reason: collision with root package name */
    public final byte[] f3789fe;

    /* renamed from: i  reason: collision with root package name */
    public String f3790i;
    public boolean qw;

    /* renamed from: rg  reason: collision with root package name */
    public volatile int f3791rg;

    /* renamed from: th  reason: collision with root package name */
    public volatile int f3792th;

    /* renamed from: uk  reason: collision with root package name */
    public String[] f3793uk;

    /* renamed from: yj  reason: collision with root package name */
    public String[] f3794yj;

    public static final class qw {
        public static final StrategyProcess qw = new StrategyProcess();
    }

    public static StrategyProcess getInstance() {
        return qw.qw;
    }

    public final void ad(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
                jSONObject.put("strategy_timestamp", System.currentTimeMillis());
                fe.th.qw.qw.qw.ad.qw().th(this.f3787ad, jSONObject.toString());
                this.f3788de = jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void de() {
        int i2;
        int i3;
        JSONObject jSONObject = this.f3788de;
        if (jSONObject == null || !jSONObject.has("strategy_timestamp")) {
            getDefaultStrategy(3);
            return;
        }
        synchronized (this.f3789fe) {
            JSONObject optJSONObject = this.f3788de.optJSONObject("content");
            if (optJSONObject == null) {
                optJSONObject = this.f3788de;
            }
            boolean z = true;
            if (optJSONObject != null) {
                this.f3791rg = optJSONObject.optInt("wifi", 3);
                this.f3792th = optJSONObject.optInt("3G", 5);
                if (1 == optJSONObject.optInt("disable", 0)) {
                    z = false;
                }
                this.qw = z;
                JSONArray optJSONArray = optJSONObject.optJSONArray("now");
                if (optJSONArray == null) {
                    i2 = 0;
                } else {
                    i2 = optJSONArray.length();
                }
                this.f3794yj = new String[i2];
                if (optJSONArray != null) {
                    for (int i4 = 0; i4 < this.f3794yj.length; i4++) {
                        this.f3794yj[i4] = optJSONArray.optString(i4);
                    }
                }
                Arrays.sort(this.f3794yj);
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("never");
                if (optJSONArray2 == null) {
                    i3 = 0;
                } else {
                    i3 = optJSONArray2.length();
                }
                this.f3793uk = new String[i3];
                for (int i5 = 0; i5 < this.f3793uk.length; i5++) {
                    this.f3793uk[i5] = optJSONArray2.optString(i5);
                }
                Arrays.sort(this.f3793uk);
            } else {
                getDefaultStrategy(1);
            }
        }
    }

    public int get3GSendingInterval() {
        return this.f3792th;
    }

    public void getDefaultStrategy(int i2) {
        synchronized (this.f3789fe) {
            if ((i2 & 1) != 0) {
                this.f3794yj = new String[0];
                this.f3793uk = new String[0];
                this.qw = true;
                this.f3792th = 5;
                this.f3791rg = 3;
            }
        }
        if (3 == (i2 & 3)) {
            try {
                this.f3788de = (JSONObject) new JSONTokener(this.f3790i).nextValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int getWifiSendingInterval() {
        return this.f3791rg;
    }

    public boolean isDataItemEnable() {
        return this.qw;
    }

    public boolean isForceToSend(String str) {
        boolean z;
        synchronized (this.f3789fe) {
            z = false;
            if (!TextUtils.isEmpty(str) && this.f3794yj != null && this.f3794yj.length > 0) {
                try {
                    if (Arrays.binarySearch(this.f3794yj, str) >= 0) {
                        z = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        if (java.util.Arrays.binarySearch(r4.f3793uk, r5) >= 0) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isIgnoreToSend(java.lang.String r5) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            byte[] r0 = r4.f3789fe
            monitor-enter(r0)
            java.lang.String[] r2 = r4.f3793uk     // Catch:{ all -> 0x0025 }
            r3 = 0
            if (r2 == 0) goto L_0x0022
            java.lang.String[] r2 = r4.f3793uk     // Catch:{ all -> 0x0025 }
            int r2 = r2.length     // Catch:{ all -> 0x0025 }
            if (r2 <= 0) goto L_0x0022
            java.lang.String[] r2 = r4.f3793uk     // Catch:{ Exception -> 0x001e }
            int r5 = java.util.Arrays.binarySearch(r2, r5)     // Catch:{ Exception -> 0x001e }
            if (r5 < 0) goto L_0x0022
            goto L_0x0023
        L_0x001e:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ all -> 0x0025 }
        L_0x0022:
            r1 = 0
        L_0x0023:
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            return r1
        L_0x0025:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0025 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duxiaoman.dxmpay.statistics.StrategyProcess.isIgnoreToSend(java.lang.String):boolean");
    }

    public void loadCachedStrategy(Context context) {
        if (this.f3787ad == null && context != null) {
            this.f3787ad = context.getApplicationContext();
        }
        if (this.f3787ad != null) {
            IStatConfig settings = StatApi.getInstance().getSettings();
            if (settings != null) {
                this.f3790i = settings.loadDefaultStrategy();
            }
            String yj2 = fe.th.qw.qw.qw.ad.qw().yj(this.f3787ad);
            if (TextUtils.isEmpty(yj2) && !TextUtils.isEmpty(this.f3790i)) {
                yj2 = this.f3790i;
            }
            try {
                this.f3788de = (JSONObject) new JSONTokener(yj2).nextValue();
                if (fe.th.qw.qw.qw.qw.uk(this.f3787ad) && needDownloadStrategy()) {
                    qw();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            de();
        }
    }

    public boolean needDownloadStrategy() {
        long j;
        JSONObject jSONObject = this.f3788de;
        if (jSONObject == null || !jSONObject.has("strategy_timestamp")) {
            return true;
        }
        try {
            j = this.f3788de.getLong("strategy_timestamp");
        } catch (Exception e) {
            e.printStackTrace();
            j = 0;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (86400000 < currentTimeMillis || 0 > currentTimeMillis) {
            return true;
        }
        return false;
    }

    public final void qw() {
        IStatConfig settings = StatApi.getInstance().getSettings();
        if (settings != null) {
            ad(settings.loadStrategy());
        }
    }

    public StrategyProcess() {
        this.f3789fe = new byte[0];
        this.f3791rg = 3;
        this.f3792th = 5;
        this.qw = true;
    }
}
