package dxm.sasdk;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.android.util.devices.RomUtils;
import dxm.sasdk.exceptions.InvalidDataException;
import dxm.sasdk.util.SensorsDataUtils;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rg.qw.Cif;
import rg.qw.Cswitch;
import rg.qw.de;
import rg.qw.fe;
import rg.qw.ggg;
import rg.qw.i;
import rg.qw.o;
import rg.qw.pf;
import rg.qw.ppp;
import rg.qw.rg;
import rg.qw.th;
import rg.qw.when;
import rg.qw.yj;

public class DxmSdkSensorsDataAPI {
    public static Cswitch aaa;
    public static final Pattern ddd = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$)[a-zA-Z_$][a-zA-Z\\d_$]{0,99})$", 2);
    public static final ggg mmm = new ggg();
    public static final Map<Context, DxmSdkSensorsDataAPI> nn = new HashMap();
    public static final SimpleDateFormat qqq = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    public static Boolean xxx = Boolean.FALSE;

    /* renamed from: ad  reason: collision with root package name */
    public String f7546ad;

    /* renamed from: de  reason: collision with root package name */
    public DebugMode f7547de;

    /* renamed from: fe  reason: collision with root package name */
    public int f7548fe;
    public int ggg;

    /* renamed from: i  reason: collision with root package name */
    public final rg f7549i;

    /* renamed from: if  reason: not valid java name */
    public final yj f319if;

    /* renamed from: o  reason: collision with root package name */
    public final i f7550o;

    /* renamed from: pf  reason: collision with root package name */
    public final o f7551pf;
    public final Map<String, fe> ppp;
    public String qw;

    /* renamed from: rg  reason: collision with root package name */
    public int f7552rg;

    /* renamed from: switch  reason: not valid java name */
    public final th f320switch;

    /* renamed from: th  reason: collision with root package name */
    public boolean f7553th;

    /* renamed from: uk  reason: collision with root package name */
    public final rg.qw.qw f7554uk;
    public when vvv;
    public final Map<String, Object> when;

    /* renamed from: yj  reason: collision with root package name */
    public final Context f7555yj;

    public enum DebugMode {
        DEBUG_OFF(false, false),
        DEBUG_ONLY(true, false),
        DEBUG_AND_TRACK(true, true);
        
        public final boolean debugMode;
        public final boolean debugWriteData;

        /* access modifiers changed from: public */
        DebugMode(boolean z, boolean z2) {
            this.debugMode = z;
            this.debugWriteData = z2;
        }

        public boolean isDebugMode() {
            return this.debugMode;
        }

        public boolean isDebugWriteData() {
            return this.debugWriteData;
        }
    }

    public class ad implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ EventType f7556ad;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f7557i;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ String f7559th;

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ fe f7560uk;

        /* renamed from: yj  reason: collision with root package name */
        public final /* synthetic */ JSONObject f7561yj;

        public ad(EventType eventType, String str, JSONObject jSONObject, fe feVar, String str2) {
            this.f7556ad = eventType;
            this.f7559th = str;
            this.f7561yj = jSONObject;
            this.f7560uk = feVar;
            this.f7557i = str2;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|(1:3)|4|5|6|(10:8|31|13|14|15|16|(1:18)|22|23|(1:25))(2:34|(1:36)(1:101))|37|(4:39|40|(1:42)|46)|47|(4:49|50|51|(2:55|(1:57)))|61|(1:63)|64|(1:68)|69|70|71|72|73|74|(5:75|76|(1:78)|79|(1:81))|85|(1:87)(1:88)|89|(1:91)(2:92|(1:94))|95|(2:97|(1:99))|100|110) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:102:0x027f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x016a */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x0186 A[Catch:{ Exception -> 0x01af }] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x019e A[Catch:{ Exception -> 0x01af }] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x01c4 A[Catch:{ all -> 0x0098, JSONException -> 0x027f }] */
        /* JADX WARNING: Removed duplicated region for block: B:88:0x01ca A[Catch:{ all -> 0x0098, JSONException -> 0x027f }] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01e0 A[Catch:{ all -> 0x0098, JSONException -> 0x027f }] */
        /* JADX WARNING: Removed duplicated region for block: B:92:0x01f3 A[Catch:{ all -> 0x0098, JSONException -> 0x027f }] */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0214 A[Catch:{ all -> 0x0098, JSONException -> 0x027f }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                dxm.sasdk.EventType r0 = r8.f7556ad     // Catch:{ Exception -> 0x0287 }
                boolean r0 = r0.isTrack()     // Catch:{ Exception -> 0x0287 }
                if (r0 == 0) goto L_0x000f
                dxm.sasdk.DxmSdkSensorsDataAPI r0 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ Exception -> 0x0287 }
                java.lang.String r1 = r8.f7559th     // Catch:{ Exception -> 0x0287 }
                r0.m952if(r1)     // Catch:{ Exception -> 0x0287 }
            L_0x000f:
                dxm.sasdk.DxmSdkSensorsDataAPI r0 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ Exception -> 0x0287 }
                dxm.sasdk.EventType r1 = r8.f7556ad     // Catch:{ Exception -> 0x0287 }
                org.json.JSONObject r2 = r8.f7561yj     // Catch:{ Exception -> 0x0287 }
                r0.m953switch(r1, r2)     // Catch:{ Exception -> 0x0287 }
                dxm.sasdk.EventType r0 = r8.f7556ad     // Catch:{ JSONException -> 0x027f }
                boolean r0 = r0.isTrack()     // Catch:{ JSONException -> 0x027f }
                if (r0 == 0) goto L_0x009b
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.DxmSdkSensorsDataAPI r1 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                java.util.Map r1 = r1.when     // Catch:{ JSONException -> 0x027f }
                r0.<init>(r1)     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.DxmSdkSensorsDataAPI r1 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                rg.qw.o r1 = r1.f7551pf     // Catch:{ JSONException -> 0x027f }
                monitor-enter(r1)     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.DxmSdkSensorsDataAPI r2 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ all -> 0x0098 }
                rg.qw.o r2 = r2.f7551pf     // Catch:{ all -> 0x0098 }
                java.lang.Object r2 = r2.ad()     // Catch:{ all -> 0x0098 }
                org.json.JSONObject r2 = (org.json.JSONObject) r2     // Catch:{ all -> 0x0098 }
                dxm.sasdk.util.SensorsDataUtils.uk(r2, r0)     // Catch:{ all -> 0x0098 }
                monitor-exit(r1)     // Catch:{ all -> 0x0098 }
                dxm.sasdk.DxmSdkSensorsDataAPI r1 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                android.content.Context r1 = r1.f7555yj     // Catch:{ JSONException -> 0x027f }
                java.lang.String r1 = dxm.sasdk.util.SensorsDataUtils.i(r1)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r2 = "$wifi"
                java.lang.String r3 = "WIFI"
                boolean r3 = r1.equals(r3)     // Catch:{ JSONException -> 0x027f }
                r0.put(r2, r3)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r2 = "$network_type"
                r0.put(r2, r1)     // Catch:{ JSONException -> 0x027f }
                rg.qw.switch r1 = dxm.sasdk.DxmSdkSensorsDataAPI.aaa     // Catch:{ Exception -> 0x007d }
                if (r1 == 0) goto L_0x0081
                java.lang.String r1 = "$latitude"
                rg.qw.switch r2 = dxm.sasdk.DxmSdkSensorsDataAPI.aaa     // Catch:{ Exception -> 0x007d }
                long r2 = r2.qw()     // Catch:{ Exception -> 0x007d }
                r0.put(r1, r2)     // Catch:{ Exception -> 0x007d }
                java.lang.String r1 = "$longitude"
                rg.qw.switch r2 = dxm.sasdk.DxmSdkSensorsDataAPI.aaa     // Catch:{ Exception -> 0x007d }
                long r2 = r2.ad()     // Catch:{ Exception -> 0x007d }
                r0.put(r1, r2)     // Catch:{ Exception -> 0x007d }
                goto L_0x0081
            L_0x007d:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ JSONException -> 0x027f }
            L_0x0081:
                dxm.sasdk.DxmSdkSensorsDataAPI r1 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ Exception -> 0x0093 }
                java.lang.String r1 = r1.aaa()     // Catch:{ Exception -> 0x0093 }
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0093 }
                if (r2 != 0) goto L_0x00a8
                java.lang.String r2 = "$screen_orientation"
                r0.put(r2, r1)     // Catch:{ Exception -> 0x0093 }
                goto L_0x00a8
            L_0x0093:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ JSONException -> 0x027f }
                goto L_0x00a8
            L_0x0098:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0098 }
                throw r0     // Catch:{ JSONException -> 0x027f }
            L_0x009b:
                dxm.sasdk.EventType r0 = r8.f7556ad     // Catch:{ JSONException -> 0x027f }
                boolean r0 = r0.isProfile()     // Catch:{ JSONException -> 0x027f }
                if (r0 == 0) goto L_0x027e
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x027f }
                r0.<init>()     // Catch:{ JSONException -> 0x027f }
            L_0x00a8:
                r1 = 0
                org.json.JSONObject r2 = r8.f7561yj     // Catch:{ JSONException -> 0x027f }
                if (r2 == 0) goto L_0x00d0
                org.json.JSONObject r2 = r8.f7561yj     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r3 = "$lib_detail"
                boolean r2 = r2.has(r3)     // Catch:{ Exception -> 0x00c7 }
                if (r2 == 0) goto L_0x00cb
                org.json.JSONObject r2 = r8.f7561yj     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r3 = "$lib_detail"
                java.lang.String r1 = r2.getString(r3)     // Catch:{ Exception -> 0x00c7 }
                org.json.JSONObject r2 = r8.f7561yj     // Catch:{ Exception -> 0x00c7 }
                java.lang.String r3 = "$lib_detail"
                r2.remove(r3)     // Catch:{ Exception -> 0x00c7 }
                goto L_0x00cb
            L_0x00c7:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ JSONException -> 0x027f }
            L_0x00cb:
                org.json.JSONObject r2 = r8.f7561yj     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.util.SensorsDataUtils.uk(r2, r0)     // Catch:{ JSONException -> 0x027f }
            L_0x00d0:
                rg.qw.fe r2 = r8.f7560uk     // Catch:{ JSONException -> 0x027f }
                if (r2 == 0) goto L_0x0104
                java.lang.String r2 = "event_duration"
                boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x0100 }
                r3 = 0
                if (r2 == 0) goto L_0x00e8
                java.lang.String r2 = "event_duration"
                double r5 = r0.optDouble(r2)     // Catch:{ Exception -> 0x0100 }
                int r2 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r2 > 0) goto L_0x0104
            L_0x00e8:
                rg.qw.fe r2 = r8.f7560uk     // Catch:{ Exception -> 0x0100 }
                java.lang.String r2 = r2.qw()     // Catch:{ Exception -> 0x0100 }
                java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ Exception -> 0x0100 }
                double r5 = r2.doubleValue()     // Catch:{ Exception -> 0x0100 }
                int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
                if (r7 <= 0) goto L_0x0104
                java.lang.String r3 = "event_duration"
                r0.put(r3, r2)     // Catch:{ Exception -> 0x0100 }
                goto L_0x0104
            L_0x0100:
                r2 = move-exception
                r2.printStackTrace()     // Catch:{ JSONException -> 0x027f }
            L_0x0104:
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x027f }
                r2.<init>()     // Catch:{ JSONException -> 0x027f }
                java.lang.String r3 = "$lib"
                java.lang.String r4 = "Android"
                r2.put(r3, r4)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r3 = "$lib_version"
                java.lang.String r4 = "1.10.4"
                r2.put(r3, r4)     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.DxmSdkSensorsDataAPI r3 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                java.util.Map r3 = r3.when     // Catch:{ JSONException -> 0x027f }
                java.lang.String r4 = "$app_version"
                boolean r3 = r3.containsKey(r4)     // Catch:{ JSONException -> 0x027f }
                if (r3 == 0) goto L_0x0136
                java.lang.String r3 = "$app_version"
                dxm.sasdk.DxmSdkSensorsDataAPI r4 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                java.util.Map r4 = r4.when     // Catch:{ JSONException -> 0x027f }
                java.lang.String r5 = "$app_version"
                java.lang.Object r4 = r4.get(r5)     // Catch:{ JSONException -> 0x027f }
                r2.put(r3, r4)     // Catch:{ JSONException -> 0x027f }
            L_0x0136:
                dxm.sasdk.DxmSdkSensorsDataAPI r3 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                rg.qw.o r3 = r3.f7551pf     // Catch:{ JSONException -> 0x027f }
                java.lang.Object r3 = r3.ad()     // Catch:{ JSONException -> 0x027f }
                org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ JSONException -> 0x027f }
                if (r3 == 0) goto L_0x0157
                java.lang.String r4 = "$app_version"
                boolean r4 = r3.has(r4)     // Catch:{ JSONException -> 0x027f }
                if (r4 == 0) goto L_0x0157
                java.lang.String r4 = "$app_version"
                java.lang.String r5 = "$app_version"
                java.lang.Object r3 = r3.get(r5)     // Catch:{ JSONException -> 0x027f }
                r2.put(r4, r3)     // Catch:{ JSONException -> 0x027f }
            L_0x0157:
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x027f }
                r3.<init>()     // Catch:{ JSONException -> 0x027f }
                java.util.Random r4 = new java.util.Random     // Catch:{ Exception -> 0x016a }
                r4.<init>()     // Catch:{ Exception -> 0x016a }
                java.lang.String r5 = "_track_id"
                int r4 = r4.nextInt()     // Catch:{ Exception -> 0x016a }
                r3.put(r5, r4)     // Catch:{ Exception -> 0x016a }
            L_0x016a:
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x027f }
                java.lang.String r6 = "time"
                r3.put(r6, r4)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r4 = "type"
                dxm.sasdk.EventType r5 = r8.f7556ad     // Catch:{ JSONException -> 0x027f }
                java.lang.String r5 = r5.getEventType()     // Catch:{ JSONException -> 0x027f }
                r3.put(r4, r5)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r4 = "$project"
                boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x01af }
                if (r4 == 0) goto L_0x0196
                java.lang.String r4 = "project"
                java.lang.String r5 = "$project"
                java.lang.String r5 = r0.optString(r5)     // Catch:{ Exception -> 0x01af }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x01af }
                java.lang.String r4 = "$project"
                r0.remove(r4)     // Catch:{ Exception -> 0x01af }
            L_0x0196:
                java.lang.String r4 = "$token"
                boolean r4 = r0.has(r4)     // Catch:{ Exception -> 0x01af }
                if (r4 == 0) goto L_0x01b3
                java.lang.String r4 = "token"
                java.lang.String r5 = "$token"
                java.lang.String r5 = r0.optString(r5)     // Catch:{ Exception -> 0x01af }
                r3.put(r4, r5)     // Catch:{ Exception -> 0x01af }
                java.lang.String r4 = "$token"
                r0.remove(r4)     // Catch:{ Exception -> 0x01af }
                goto L_0x01b3
            L_0x01af:
                r4 = move-exception
                r4.printStackTrace()     // Catch:{ JSONException -> 0x027f }
            L_0x01b3:
                java.lang.String r4 = "properties"
                r3.put(r4, r0)     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.DxmSdkSensorsDataAPI r4 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                java.lang.String r4 = r4.mmm()     // Catch:{ JSONException -> 0x027f }
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x027f }
                if (r5 != 0) goto L_0x01ca
                java.lang.String r5 = "distinct_id"
                r3.put(r5, r4)     // Catch:{ JSONException -> 0x027f }
                goto L_0x01d5
            L_0x01ca:
                java.lang.String r4 = "distinct_id"
                dxm.sasdk.DxmSdkSensorsDataAPI r5 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                java.lang.String r5 = r5.vvv()     // Catch:{ JSONException -> 0x027f }
                r3.put(r4, r5)     // Catch:{ JSONException -> 0x027f }
            L_0x01d5:
                java.lang.String r4 = "lib"
                r3.put(r4, r2)     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.EventType r4 = r8.f7556ad     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.EventType r5 = dxm.sasdk.EventType.TRACK     // Catch:{ JSONException -> 0x027f }
                if (r4 != r5) goto L_0x01f3
                java.lang.String r4 = "event"
                java.lang.String r5 = r8.f7559th     // Catch:{ JSONException -> 0x027f }
                r3.put(r4, r5)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r4 = "$is_first_day"
                dxm.sasdk.DxmSdkSensorsDataAPI r5 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                boolean r5 = r5.a()     // Catch:{ JSONException -> 0x027f }
                r0.put(r4, r5)     // Catch:{ JSONException -> 0x027f }
                goto L_0x0207
            L_0x01f3:
                dxm.sasdk.EventType r0 = r8.f7556ad     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.EventType r4 = dxm.sasdk.EventType.TRACK_SIGNUP     // Catch:{ JSONException -> 0x027f }
                if (r0 != r4) goto L_0x0207
                java.lang.String r0 = "event"
                java.lang.String r4 = r8.f7559th     // Catch:{ JSONException -> 0x027f }
                r3.put(r0, r4)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r0 = "original_id"
                java.lang.String r4 = r8.f7557i     // Catch:{ JSONException -> 0x027f }
                r3.put(r0, r4)     // Catch:{ JSONException -> 0x027f }
            L_0x0207:
                java.lang.String r0 = "$lib_method"
                java.lang.String r4 = "code"
                r2.put(r0, r4)     // Catch:{ JSONException -> 0x027f }
                boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x027f }
                if (r0 == 0) goto L_0x024b
                java.lang.Exception r0 = new java.lang.Exception     // Catch:{ JSONException -> 0x027f }
                r0.<init>()     // Catch:{ JSONException -> 0x027f }
                java.lang.StackTraceElement[] r0 = r0.getStackTrace()     // Catch:{ JSONException -> 0x027f }
                int r4 = r0.length     // Catch:{ JSONException -> 0x027f }
                r5 = 2
                if (r4 <= r5) goto L_0x024b
                r0 = r0[r5]     // Catch:{ JSONException -> 0x027f }
                java.lang.String r1 = "%s##%s##%s##%s"
                r4 = 4
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ JSONException -> 0x027f }
                r6 = 0
                java.lang.String r7 = r0.getClassName()     // Catch:{ JSONException -> 0x027f }
                r4[r6] = r7     // Catch:{ JSONException -> 0x027f }
                r6 = 1
                java.lang.String r7 = r0.getMethodName()     // Catch:{ JSONException -> 0x027f }
                r4[r6] = r7     // Catch:{ JSONException -> 0x027f }
                java.lang.String r6 = r0.getFileName()     // Catch:{ JSONException -> 0x027f }
                r4[r5] = r6     // Catch:{ JSONException -> 0x027f }
                r5 = 3
                int r0 = r0.getLineNumber()     // Catch:{ JSONException -> 0x027f }
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ JSONException -> 0x027f }
                r4[r5] = r0     // Catch:{ JSONException -> 0x027f }
                java.lang.String r1 = java.lang.String.format(r1, r4)     // Catch:{ JSONException -> 0x027f }
            L_0x024b:
                java.lang.String r0 = "$lib_detail"
                r2.put(r0, r1)     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.DxmSdkSensorsDataAPI r0 = dxm.sasdk.DxmSdkSensorsDataAPI.this     // Catch:{ JSONException -> 0x027f }
                rg.qw.qw r0 = r0.f7554uk     // Catch:{ JSONException -> 0x027f }
                dxm.sasdk.EventType r1 = r8.f7556ad     // Catch:{ JSONException -> 0x027f }
                java.lang.String r1 = r1.getEventType()     // Catch:{ JSONException -> 0x027f }
                r0.ad(r1, r3)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r0 = "SA.SensorsDataAPI"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x027f }
                r1.<init>()     // Catch:{ JSONException -> 0x027f }
                java.lang.String r2 = "track event:\n"
                r1.append(r2)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x027f }
                java.lang.String r2 = rg.qw.vvv.ad.ad(r2)     // Catch:{ JSONException -> 0x027f }
                r1.append(r2)     // Catch:{ JSONException -> 0x027f }
                java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x027f }
                rg.qw.pf.ad(r0, r1)     // Catch:{ JSONException -> 0x027f }
                goto L_0x028b
            L_0x027e:
                return
            L_0x027f:
                dxm.sasdk.exceptions.InvalidDataException r0 = new dxm.sasdk.exceptions.InvalidDataException     // Catch:{ Exception -> 0x0287 }
                java.lang.String r1 = "Unexpected property"
                r0.<init>((java.lang.String) r1)     // Catch:{ Exception -> 0x0287 }
                throw r0     // Catch:{ Exception -> 0x0287 }
            L_0x0287:
                r0 = move-exception
                r0.printStackTrace()
            L_0x028b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dxm.sasdk.DxmSdkSensorsDataAPI.ad.run():void");
        }
    }

    public class qw implements ggg.ad {
        public qw(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI) {
        }

        public void qw(SharedPreferences sharedPreferences) {
        }
    }

    public DxmSdkSensorsDataAPI() {
        this.ggg = 14;
        this.f7555yj = null;
        this.f7554uk = null;
        this.f7549i = null;
        this.f7550o = null;
        this.f7551pf = null;
        this.f319if = null;
        this.f320switch = null;
        this.when = null;
        this.ppp = null;
    }

    public static DxmSdkSensorsDataAPI h() {
        synchronized (nn) {
            if (nn.size() > 0) {
                Iterator<DxmSdkSensorsDataAPI> it = nn.values().iterator();
                if (it.hasNext()) {
                    DxmSdkSensorsDataAPI next = it.next();
                    return next;
                }
            }
            de deVar = new de();
            return deVar;
        }
    }

    public static DxmSdkSensorsDataAPI j(Context context) {
        if (context == null) {
            return new de();
        }
        synchronized (nn) {
            DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI = nn.get(context.getApplicationContext());
            if (dxmSdkSensorsDataAPI != null) {
                return dxmSdkSensorsDataAPI;
            }
            de deVar = new de();
            return deVar;
        }
    }

    public static DxmSdkSensorsDataAPI k(Context context, String str, DebugMode debugMode) {
        if (context == null) {
            return new de();
        }
        synchronized (nn) {
            Context applicationContext = context.getApplicationContext();
            DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI = nn.get(applicationContext);
            if (dxmSdkSensorsDataAPI == null && rg.qw.ad.qw(applicationContext)) {
                dxmSdkSensorsDataAPI = new DxmSdkSensorsDataAPI(applicationContext, str, debugMode);
                nn.put(applicationContext, dxmSdkSensorsDataAPI);
            }
            if (dxmSdkSensorsDataAPI != null) {
                return dxmSdkSensorsDataAPI;
            }
            de deVar = new de();
            return deVar;
        }
    }

    public final boolean a() {
        String str = (String) this.f320switch.ad();
        if (str == null) {
            return true;
        }
        return str.equals(qqq.format(Long.valueOf(System.currentTimeMillis())));
    }

    public String aaa() {
        try {
            if (this.vvv != null) {
                return this.vvv.qw();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean b(String str) {
        return (m(str) & this.ggg) != 0;
    }

    public void c(String str) {
        try {
            pf(str);
            synchronized (this.f7550o) {
                if (!str.equals(this.f7550o.ad())) {
                    this.f7550o.qw(str);
                    if (!str.equals(vvv())) {
                        p(EventType.TRACK_SIGNUP, "$SignUp", (JSONObject) null, vvv());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void d() {
        synchronized (this.f7550o) {
            this.f7550o.qw(null);
        }
    }

    public int ddd() {
        return this.f7552rg;
    }

    public void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                m953switch(EventType.REGISTER_SUPER_PROPERTIES, jSONObject);
                synchronized (this.f7551pf) {
                    JSONObject jSONObject2 = (JSONObject) this.f7551pf.ad();
                    SensorsDataUtils.uk(jSONObject, jSONObject2);
                    this.f7551pf.qw(jSONObject2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void eee(String str) {
        try {
            pf(str);
            synchronized (this.f7549i) {
                this.f7549i.qw(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void f() {
        try {
            if (this.vvv != null) {
                this.vvv.enable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(String str) {
        try {
            this.f7546ad = str;
            if (!TextUtils.isEmpty(str)) {
                if (this.f7547de != DebugMode.DEBUG_OFF) {
                    Uri parse = Uri.parse(str);
                    int lastIndexOf = parse.getPath().lastIndexOf(47);
                    if (lastIndexOf != -1) {
                        this.qw = parse.buildUpon().path(parse.getPath().substring(0, lastIndexOf) + "/debug").build().toString();
                        return;
                    }
                    return;
                }
            }
            this.qw = str;
            when();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ggg() {
        this.f7554uk.de();
    }

    public void i() {
        fe feVar;
        synchronized (this.ppp) {
            try {
                for (Map.Entry next : this.ppp.entrySet()) {
                    if (!(next == null || (feVar = (fe) next.getValue()) == null)) {
                        feVar.rg(SystemClock.elapsedRealtime());
                    }
                }
            } catch (Exception e) {
                pf.ad("SA.SensorsDataAPI", "appBecomeActive error:" + e.getMessage());
            }
        }
    }

    /* renamed from: if  reason: not valid java name */
    public final void m952if(String str) throws InvalidDataException {
        if (str == null || str.length() < 1) {
            throw new InvalidDataException("The key is empty.");
        } else if (!ddd.matcher(str).matches()) {
            throw new InvalidDataException("The key '" + str + "' is invalid.");
        }
    }

    public void l() {
        try {
            if (this.vvv != null) {
                this.vvv.disable();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final int m(String str) {
        if ("NULL".equals(str)) {
            return 255;
        }
        if ("WIFI".equals(str)) {
            return 8;
        }
        if ("2G".equals(str)) {
            return 1;
        }
        if ("3G".equals(str)) {
            return 2;
        }
        if ("4G".equals(str)) {
            return 4;
        }
        return 255;
    }

    public String mmm() {
        String str;
        synchronized (this.f7550o) {
            str = (String) this.f7550o.ad();
        }
        return str;
    }

    public void n(String str, JSONObject jSONObject) {
        try {
            p(EventType.TRACK, str, jSONObject, (String) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int nn() {
        return this.f7548fe;
    }

    public void o() {
        synchronized (this.ppp) {
            try {
                for (Map.Entry next : this.ppp.entrySet()) {
                    if (next != null) {
                        if (!"$AppEnd".equals(next.getKey().toString())) {
                            fe feVar = (fe) next.getValue();
                            if (feVar != null) {
                                feVar.fe((feVar.ad() + SystemClock.elapsedRealtime()) - feVar.de());
                                feVar.rg(SystemClock.elapsedRealtime());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                pf.ad("SA.SensorsDataAPI", "appEnterBackground error:" + e.getMessage());
            }
        }
    }

    public final void p(EventType eventType, String str, JSONObject jSONObject, String str2) {
        fe feVar;
        if (str != null) {
            synchronized (this.ppp) {
                feVar = this.ppp.get(str);
                this.ppp.remove(str);
            }
        } else {
            feVar = null;
        }
        ppp.ad().qw(new ad(eventType, str, jSONObject, feVar, str2));
    }

    public final void pf(String str) throws InvalidDataException {
        if (str == null || str.length() < 1) {
            throw new InvalidDataException("The distinct_id or original_id or login_id is empty.");
        } else if (str.length() > 255) {
            throw new InvalidDataException("The max length of distinct_id or original_id or login_id is 255.");
        }
    }

    public void ppp(boolean z) {
        xxx = Boolean.valueOf(z);
    }

    public void q(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("event_key");
            if (!TextUtils.isEmpty(optString)) {
                double xxx2 = xxx(optString);
                if (xxx2 > 0.0d) {
                    try {
                        jSONObject.put("event_duration", xxx2);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        n(str, jSONObject);
    }

    public String qqq() {
        return this.qw;
    }

    public void r(String str) {
        try {
            m952if(str);
            synchronized (this.ppp) {
                this.ppp.put(str, new fe(TimeUnit.SECONDS));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean rrr() {
        return this.f7547de.isDebugMode();
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m953switch(EventType eventType, JSONObject jSONObject) throws InvalidDataException {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                m952if(next);
                try {
                    Object obj = jSONObject.get(next);
                    if (!(obj instanceof String)) {
                        if (!(obj instanceof Number) && !(obj instanceof JSONArray) && !(obj instanceof Boolean)) {
                            if (!(obj instanceof Date)) {
                                throw new InvalidDataException("The property value must be an instance of String/Number/Boolean/JSONArray. [key='" + next + "', value='" + obj.toString() + "']");
                            }
                        }
                    }
                    if ("app_crashed_reason".equals(next)) {
                        if ((obj instanceof String) && !next.startsWith("$") && ((String) obj).length() > 16382) {
                            pf.qw("SA.SensorsDataAPI", "The property value is too long. [key='" + next + "', value='" + obj.toString() + "']");
                        }
                    } else if ((obj instanceof String) && !next.startsWith("$") && ((String) obj).length() > 8191) {
                        pf.qw("SA.SensorsDataAPI", "The property value is too long. [key='" + next + "', value='" + obj.toString() + "']");
                    }
                } catch (JSONException unused) {
                    throw new InvalidDataException("Unexpected property key. [key='" + next + "']");
                }
            }
        }
    }

    public boolean tt() {
        return this.f7547de.isDebugWriteData();
    }

    public String vvv() {
        String str;
        synchronized (this.f7549i) {
            str = (String) this.f7549i.ad();
        }
        return str;
    }

    public final void when() {
        this.f7547de = DebugMode.DEBUG_OFF;
        ppp(false);
        this.qw = this.f7546ad;
    }

    public final double xxx(String str) {
        fe feVar;
        if (str != null) {
            synchronized (this.ppp) {
                feVar = this.ppp.get(str);
                this.ppp.remove(str);
            }
        } else {
            feVar = null;
        }
        if (feVar == null) {
            return -1.0d;
        }
        try {
            Double valueOf = Double.valueOf(feVar.qw());
            if (valueOf.doubleValue() > 0.0d) {
                return valueOf.doubleValue();
            }
            return -1.0d;
        } catch (Exception e) {
            e.printStackTrace();
            return -1.0d;
        }
    }

    public DxmSdkSensorsDataAPI(Context context, String str, DebugMode debugMode) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        this.ggg = 14;
        this.f7555yj = context;
        this.f7547de = debugMode;
        String packageName = context.getApplicationContext().getPackageName();
        try {
            SensorsDataUtils.ad(this.f7555yj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            pf.fe(this);
            Bundle bundle = null;
            if (!(context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null || (applicationInfo = packageManager.getApplicationInfo(packageName, 128)) == null)) {
                bundle = applicationInfo.metaData;
            }
            bundle = bundle == null ? new Bundle() : bundle;
            g(str);
            if (debugMode == DebugMode.DEBUG_OFF) {
                xxx = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", false));
            } else {
                xxx = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", true));
            }
            this.f7548fe = bundle.getInt("com.sensorsdata.analytics.android.FlushInterval", 15000);
            this.f7552rg = bundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100);
            this.f7553th = bundle.getBoolean("com.sensorsdata.analytics.android.AndroidId", true);
            pf.qw("SA.SensorsDataAPI", "mEnableAndroidId :" + this.f7553th);
            this.f7554uk = rg.qw.qw.fe(this.f7555yj, "dxm.sasdk.sa");
            Future<SharedPreferences> qw2 = mmm.qw(context, "dxm.sasdk.sa", new qw(this));
            this.f7549i = new rg(qw2);
            if (this.f7553th) {
                try {
                    String de2 = SensorsDataUtils.de(this.f7555yj);
                    if (SensorsDataUtils.yj(de2)) {
                        eee(rg.qw.vvv.de.ad(de2));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            pf.qw("SA.SensorsDataAPI", "mEnableAndroidId :" + this.f7553th + " ; mDistinctId MD5 = " + ((String) this.f7549i.ad()));
            this.f7550o = new i(qw2);
            this.f7551pf = new o(qw2);
            this.f319if = new yj(qw2);
            this.f320switch = new th(qw2);
            if (Build.VERSION.SDK_INT >= 14) {
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new Cif(this, this.f319if, this.f320switch));
            }
            if (debugMode != DebugMode.DEBUG_OFF) {
                String.format(Locale.CHINA, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", new Object[]{this.qw, Integer.valueOf(this.f7548fe), debugMode});
            }
            HashMap hashMap = new HashMap();
            hashMap.put("$lib", "Android");
            hashMap.put("$lib_version", "1.10.4");
            hashMap.put("$os", "Android");
            String str2 = Build.VERSION.RELEASE;
            hashMap.put("$os_version", str2 == null ? RomUtils.UNKNOWN : str2);
            String str3 = Build.MANUFACTURER;
            hashMap.put("$manufacturer", str3 == null ? RomUtils.UNKNOWN : str3);
            if (TextUtils.isEmpty(Build.MODEL)) {
                hashMap.put("$model", RomUtils.UNKNOWN);
            } else {
                hashMap.put("$model", Build.MODEL.trim());
            }
            try {
                hashMap.put("$app_version", this.f7555yj.getPackageManager().getPackageInfo(this.f7555yj.getPackageName(), 0).versionName);
            } catch (Exception unused) {
                DebugMode debugMode2 = DebugMode.DEBUG_OFF;
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("$screen_width", Integer.valueOf(displayMetrics.widthPixels));
            try {
                WindowManager windowManager = (WindowManager) this.f7555yj.getSystemService("window");
                if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point();
                    if (windowManager != null) {
                        windowManager.getDefaultDisplay().getRealSize(point);
                        hashMap.put("$screen_height", Integer.valueOf(point.y));
                    }
                }
            } catch (Exception unused2) {
                hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            }
            if (this.f7553th) {
                String de3 = SensorsDataUtils.de(this.f7555yj);
                pf.qw("SA.SensorsDataAPI", "device_id android id = " + de3);
                if (!TextUtils.isEmpty(de3)) {
                    pf.qw("SA.SensorsDataAPI", "device_id Md5 android id = " + rg.qw.vvv.de.ad(de3));
                    hashMap.put("$device_id", rg.qw.vvv.de.ad(de3));
                }
            }
            this.when = Collections.unmodifiableMap(hashMap);
            this.ppp = new HashMap();
        } catch (PackageManager.NameNotFoundException e3) {
            throw new RuntimeException("Can't configure SensorsDataAPI with package name " + packageName, e3);
        }
    }
}
