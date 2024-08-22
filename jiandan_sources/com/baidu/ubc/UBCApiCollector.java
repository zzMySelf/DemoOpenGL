package com.baidu.ubc;

import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class UBCApiCollector {

    /* renamed from: ad  reason: collision with root package name */
    public final ConcurrentHashMap<String, Integer> f1114ad;
    public final Executor qw;

    public enum ApiType {
        ON_EVENT_1(1),
        ON_EVENT_2(2),
        ON_EVENT_3(3),
        ON_EVENT_4(4),
        ON_EVENT_5(5),
        ON_EVENT_6(6),
        ON_EVENT_7(7),
        ON_EVENT_8(8),
        BEGIN_FLOW_1(9),
        BEGIN_FLOW_2(10),
        BEGIN_FLOW_3(11),
        BEGIN_FLOW_4(12),
        BEGIN_FLOW_5(13),
        BEGIN_FLOW_6(14),
        BEGIN_FLOW_7(15),
        BEGIN_FLOW_8(16),
        FLOW_END(17),
        FLOW_ADD_EVENT_1(18),
        FLOW_ADD_EVENT_2(19),
        FLOW_ADD_EVENT_WITH_DATE(20),
        FLOW_SET_VALUE_1(21),
        FLOW_SET_VALUE_2(22),
        FLOW_SET_VALUE_WITH_DURATION(23),
        FLOW_START_SLOT(24),
        FLOW_END_SLOT(25),
        FLOW_CANCEL(26),
        MULTI_PROCESS_EVENT(27);
        
        public final int mType;

        /* access modifiers changed from: public */
        ApiType(int i2) {
            this.mType = i2;
        }

        public int getType() {
            return this.mType;
        }
    }

    public static final class ad {
        public static final UBCApiCollector qw = new UBCApiCollector((qw) null);
    }

    public static /* synthetic */ class qw {
        public static final /* synthetic */ int[] qw;

        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.baidu.ubc.UBCApiCollector$ApiType[] r0 = com.baidu.ubc.UBCApiCollector.ApiType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                qw = r0
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.ON_EVENT_1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x001d }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.ON_EVENT_2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.ON_EVENT_3     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.ON_EVENT_6     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x003e }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.ON_EVENT_4     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.ON_EVENT_5     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.BEGIN_FLOW_1     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.BEGIN_FLOW_2     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x006c }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.BEGIN_FLOW_3     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.BEGIN_FLOW_6     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.BEGIN_FLOW_4     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.BEGIN_FLOW_5     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x009c }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.FLOW_ADD_EVENT_1     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = qw     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.baidu.ubc.UBCApiCollector$ApiType r1 = com.baidu.ubc.UBCApiCollector.ApiType.FLOW_SET_VALUE_2     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.ubc.UBCApiCollector.qw.<clinit>():void");
        }
    }

    public /* synthetic */ UBCApiCollector(qw qwVar) {
        this();
    }

    public static UBCApiCollector ad() {
        return ad.qw;
    }

    public final String de(String str, int i2, ApiType apiType) {
        ApiType apiType2;
        switch (qw.qw[apiType.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                apiType2 = ApiType.ON_EVENT_7;
                break;
            case 5:
                apiType2 = ApiType.ON_EVENT_8;
                break;
            case 6:
                apiType2 = ApiType.ON_EVENT_6;
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                apiType2 = ApiType.BEGIN_FLOW_7;
                break;
            case 11:
                apiType2 = ApiType.BEGIN_FLOW_8;
                break;
            case 12:
                apiType2 = ApiType.BEGIN_FLOW_6;
                break;
            case 13:
                apiType2 = ApiType.FLOW_ADD_EVENT_2;
                break;
            case 14:
                apiType2 = ApiType.FLOW_SET_VALUE_1;
                break;
            default:
                apiType2 = null;
                break;
        }
        if (apiType2 == null) {
            return null;
        }
        return str + "_" + i2 + "_" + apiType2.getType();
    }

    public /* synthetic */ void fe(String str, int i2, ApiType apiType) {
        String str2 = str + "_" + i2 + "_" + apiType.getType();
        Integer num = this.f1114ad.get(str2);
        this.f1114ad.put(str2, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
        String de2 = de(str, i2, apiType);
        if (!TextUtils.isEmpty(de2)) {
            Integer num2 = this.f1114ad.get(de2);
            this.f1114ad.put(de2, Integer.valueOf(num2 != null ? num2.intValue() - 1 : -1));
        }
    }

    public void qw(String str, int i2, ApiType apiType) {
        this.qw.execute(new fe.fe.mmm.qw(this, str, i2, apiType));
    }

    public /* synthetic */ void rg() {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : this.f1114ad.entrySet()) {
                int intValue = ((Integer) next.getValue()).intValue();
                if (intValue > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    String[] split = ((String) next.getKey()).split("_");
                    jSONObject2.put("id", split[0]);
                    if (!split[1].equals(String.valueOf(0))) {
                        jSONObject2.put("o", Integer.valueOf(split[1]));
                    }
                    jSONObject2.put("m", Integer.valueOf(split[2]));
                    jSONObject2.put(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION, intValue);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("data", jSONArray);
            this.f1114ad.clear();
            UBCManager uBCManager = (UBCManager) fe.fe.vvv.ad.ad.ad.qw(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent("6312", jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void th() {
        if (this.f1114ad.size() != 0) {
            this.qw.execute(new fe.fe.mmm.ad(this));
        }
    }

    public UBCApiCollector() {
        this.qw = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this.f1114ad = new ConcurrentHashMap<>();
    }
}
