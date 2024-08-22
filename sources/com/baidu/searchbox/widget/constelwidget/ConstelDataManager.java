package com.baidu.searchbox.widget.constelwidget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ConstelJavaScriptInterface;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.net.SearchBoxCookieManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.searchbox.widget.ConstelWidgetProvider;
import com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000  2\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0014\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\tJ\u0010\u0010\u001e\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/widget/constelwidget/ConstelDataManager;", "", "()V", "DEBUG", "", "getDEBUG$annotations", "widgetConstels", "", "", "Lcom/baidu/searchbox/widget/constelwidget/ConstelWidgetModel;", "checkAndDelete", "", "appWidgetIds", "", "context", "Landroid/content/Context;", "deleteAllData", "deleteTempConstel", "getConstelWidgetPostData", "constelName", "getLocalVersion", "getTempConstel", "getWidgetModel", "isValid", "data", "parseConstel", "requestConstelData", "isForce", "saveConstelData", "constel", "saveDataBeforeAddConstel", "saveTempConstelSync", "Companion", "Holder", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConstelDataManager.kt */
public final class ConstelDataManager {
    private static final String CONSTEL_DATA = "data";
    private static final String CONSTEL_WIDGET_REQUEST = "constel_widget";
    private static final String CONSTEL_WIDGET_SERVER_URL = "https://mbd.baidu.com/searchbox?action=widget&cmd=3014&src=widget_c";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATA = "data";
    private static final String DEFAULT_VERSION = "0";
    private static final String REQUEST_CONSTEL_DATA_VERSION = "request_constel_data_version";
    private static final String RESP_DATA_3014 = "3014";
    private static final String RESP_DATA_CONSTEL_WIDGET = "constel_widget";
    private static final String TAG = "ConstelDataManager";
    private static final String VERSION = "version";
    public static final String WIDGET_TEMP_CONSTEL_KEY = "widget_temp_constel_key";
    /* access modifiers changed from: private */
    public static final ConstelDataManager instance = Holder.INSTANCE.getInstance();
    /* access modifiers changed from: private */
    public final boolean DEBUG = AppConfig.isDebug();
    private Map<String, ConstelWidgetModel> widgetConstels = new LinkedHashMap();

    private static /* synthetic */ void getDEBUG$annotations() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/widget/constelwidget/ConstelDataManager$Companion;", "", "()V", "CONSTEL_DATA", "", "CONSTEL_WIDGET_REQUEST", "CONSTEL_WIDGET_SERVER_URL", "DATA", "DEFAULT_VERSION", "REQUEST_CONSTEL_DATA_VERSION", "RESP_DATA_3014", "RESP_DATA_CONSTEL_WIDGET", "TAG", "VERSION", "WIDGET_TEMP_CONSTEL_KEY", "instance", "Lcom/baidu/searchbox/widget/constelwidget/ConstelDataManager;", "getInstance", "()Lcom/baidu/searchbox/widget/constelwidget/ConstelDataManager;", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConstelDataManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConstelDataManager getInstance() {
            return ConstelDataManager.instance;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/widget/constelwidget/ConstelDataManager$Holder;", "", "()V", "instance", "Lcom/baidu/searchbox/widget/constelwidget/ConstelDataManager;", "getInstance", "()Lcom/baidu/searchbox/widget/constelwidget/ConstelDataManager;", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConstelDataManager.kt */
    private static final class Holder {
        public static final Holder INSTANCE = new Holder();
        private static final ConstelDataManager instance = new ConstelDataManager();

        private Holder() {
        }

        public final ConstelDataManager getInstance() {
            return instance;
        }
    }

    public final void saveDataBeforeAddConstel(String data) {
        if (!TextUtils.isEmpty(data)) {
            ExecutorUtilsExt.postOnElastic(new ConstelDataManager$$ExternalSyntheticLambda0(this, data), "add_constel_widget_file_data", 2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: saveDataBeforeAddConstel$lambda-0  reason: not valid java name */
    public static final void m7639saveDataBeforeAddConstel$lambda0(ConstelDataManager this$0, String $data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.saveTempConstelSync($data);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void saveTempConstelSync(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.baidu.searchbox.widget.constelwidget.ConstelWidgetModel r0 = r4.parseConstel(r5)     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils$Companion r1 = com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils.Companion     // Catch:{ all -> 0x002c }
            com.baidu.searchbox.widget.cache.WidgetSharePreferenceUtils r1 = r1.getInstance()     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "widget_temp_constel_key"
            com.google.gson.Gson r3 = new com.google.gson.Gson     // Catch:{ all -> 0x002c }
            r3.<init>()     // Catch:{ all -> 0x002c }
            java.lang.String r3 = r3.toJson((java.lang.Object) r0)     // Catch:{ all -> 0x002c }
            r1.putString(r2, r3)     // Catch:{ all -> 0x002c }
            boolean r1 = r4.DEBUG     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x002a
            java.lang.String r1 = "ConstelDataManager"
            java.lang.String r2 = "save temp constel data"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x002c }
        L_0x002a:
            monitor-exit(r4)
            return
        L_0x002c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.widget.constelwidget.ConstelDataManager.saveTempConstelSync(java.lang.String):void");
    }

    public final synchronized ConstelWidgetModel getTempConstel() {
        String addConstel = WidgetSharePreferenceUtils.Companion.getInstance().getString(WIDGET_TEMP_CONSTEL_KEY, "");
        if (!TextUtils.isEmpty(addConstel)) {
            try {
                return (ConstelWidgetModel) new Gson().fromJson(addConstel, ConstelWidgetModel.class);
            } catch (Exception e2) {
                if (this.DEBUG) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized void saveConstelData(ConstelWidgetModel constel) {
        Intrinsics.checkNotNullParameter(constel, ConstelJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME);
        this.widgetConstels.put(constel.getConstelName(), constel);
        WidgetSharePreferenceUtils.Companion.getInstance().putString(constel.getConstelName(), new Gson().toJson((Object) constel));
    }

    public final synchronized ConstelWidgetModel getWidgetModel(String constelName) {
        Intrinsics.checkNotNullParameter(constelName, "constelName");
        ConstelWidgetModel constelWidgetModel = this.widgetConstels.get(constelName);
        if (constelWidgetModel == null) {
            String constelStr = WidgetSharePreferenceUtils.Companion.getInstance().getString(constelName, "");
            if (!TextUtils.isEmpty(constelStr)) {
                try {
                    ConstelWidgetModel constelModel = (ConstelWidgetModel) new Gson().fromJson(constelStr, ConstelWidgetModel.class);
                    Map<String, ConstelWidgetModel> map = this.widgetConstels;
                    String constelName2 = constelModel.getConstelName();
                    Intrinsics.checkNotNullExpressionValue(constelModel, "constelModel");
                    map.put(constelName2, constelModel);
                    return constelModel;
                } catch (Exception e2) {
                    if (this.DEBUG) {
                        e2.printStackTrace();
                    }
                    return constelWidgetModel;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final ConstelWidgetModel parseConstel(String data) {
        String str = data;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return null;
        }
        try {
            JSONObject dataJson = new JSONObject(str);
            String constelName = dataJson.optString("constel_name");
            String iconUrl = dataJson.optString("icon_url");
            String scheme = dataJson.optString("scheme");
            String widgetColor = dataJson.optString("widget_color");
            String fortuneAnswer = dataJson.optString("fortune_answer");
            String description = dataJson.optString("description");
            String loveScore = dataJson.optString("love_score");
            String loveScoreTotal = dataJson.optString("love_score_total");
            String moneyScore = dataJson.optString("money_score");
            String moneyScoreTotal = dataJson.optString("money_score_total");
            String causeScore = dataJson.optString("cause_score");
            String causeScoreTotal = dataJson.optString("cause_score_total");
            Intrinsics.checkNotNullExpressionValue(constelName, "constelName");
            if (!StringsKt.isBlank(constelName)) {
                JSONObject jSONObject = dataJson;
                Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
                Intrinsics.checkNotNullExpressionValue(scheme, "scheme");
                Intrinsics.checkNotNullExpressionValue(widgetColor, "widgetColor");
                Intrinsics.checkNotNullExpressionValue(fortuneAnswer, "fortuneAnswer");
                Intrinsics.checkNotNullExpressionValue(description, "description");
                Intrinsics.checkNotNullExpressionValue(loveScore, "loveScore");
                Intrinsics.checkNotNullExpressionValue(loveScoreTotal, "loveScoreTotal");
                Intrinsics.checkNotNullExpressionValue(moneyScore, "moneyScore");
                Intrinsics.checkNotNullExpressionValue(moneyScoreTotal, "moneyScoreTotal");
                Intrinsics.checkNotNullExpressionValue(causeScore, "causeScore");
                Intrinsics.checkNotNullExpressionValue(causeScoreTotal, "causeScoreTotal");
                String str2 = fortuneAnswer;
                String str3 = widgetColor;
                String str4 = scheme;
                String str5 = iconUrl;
                return new ConstelWidgetModel(constelName, iconUrl, scheme, widgetColor, fortuneAnswer, description, loveScore, loveScoreTotal, moneyScore, moneyScoreTotal, causeScore, causeScoreTotal);
            }
            String str6 = moneyScoreTotal;
            String str7 = moneyScore;
            String str8 = loveScoreTotal;
            String str9 = loveScore;
            String str10 = description;
            String str11 = fortuneAnswer;
            String str12 = widgetColor;
            String str13 = scheme;
            String str14 = iconUrl;
            return null;
        } catch (Exception e2) {
            if (!this.DEBUG) {
                return null;
            }
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean isValid(String data) {
        CharSequence charSequence = data;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return false;
        }
        try {
            String constelName = new JSONObject(data).optString("constel_name");
            Intrinsics.checkNotNullExpressionValue(constelName, "constelName");
            return StringsKt.isBlank(constelName) ^ true;
        } catch (Exception e2) {
            if (this.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    public final void deleteTempConstel() {
        WidgetSharePreferenceUtils.Companion.getInstance().putString(WIDGET_TEMP_CONSTEL_KEY, "");
    }

    public final void checkAndDelete(int[] appWidgetIds, Context context) {
        int[] iArr = appWidgetIds;
        Context context2 = context;
        Intrinsics.checkNotNullParameter(iArr, "appWidgetIds");
        Intrinsics.checkNotNullParameter(context2, "context");
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int appWidgetId = iArr[i2];
            String constelName = WidgetSharePreferenceUtils.Companion.getInstance().getString(ConstelWidgetProvider.CONSTEL_WIDGET_ID_PREFIX + appWidgetId, "");
            WidgetSharePreferenceUtils.Companion.getInstance().remove(ConstelWidgetProvider.CONSTEL_WIDGET_ID_PREFIX + appWidgetId);
            int[] existAppWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context2, ConstelWidgetProvider.class));
            if (existAppWidgetIds != null) {
                if (!(existAppWidgetIds.length == 0)) {
                    boolean isDelete = true;
                    int length2 = existAppWidgetIds.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            break;
                        }
                        String constelStr = WidgetSharePreferenceUtils.Companion.getInstance().getString(ConstelWidgetProvider.CONSTEL_WIDGET_ID_PREFIX + existAppWidgetIds[i3], "");
                        CharSequence charSequence = constelStr;
                        if (!(charSequence == null || StringsKt.isBlank(charSequence)) && Intrinsics.areEqual((Object) constelStr, (Object) constelName)) {
                            isDelete = false;
                            break;
                        }
                        i3++;
                    }
                    if (isDelete) {
                        synchronized (this) {
                            WidgetSharePreferenceUtils.Companion.getInstance().remove(constelName);
                            ConstelWidgetModel constelWidgetModel = (ConstelWidgetModel) TypeIntrinsics.asMutableMap(this.widgetConstels).remove(constelName);
                        }
                    }
                    i2++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void deleteAllData() {
        WidgetSharePreferenceUtils.Companion.getInstance().remove(REQUEST_CONSTEL_DATA_VERSION);
    }

    public static /* synthetic */ void requestConstelData$default(ConstelDataManager constelDataManager, Context context, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        constelDataManager.requestConstelData(context, z);
    }

    public final void requestConstelData(Context context, boolean isForce) {
        Intrinsics.checkNotNullParameter(context, "context");
        String constelWidgets = getConstelWidgetPostData(context, "");
        CharSequence charSequence = constelWidgets;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            if (this.DEBUG) {
                Log.d(TAG, "request constel data");
            }
            String requestVersion = new JSONObject().put("constel_widget", isForce ? "0" : getLocalVersion()).toString();
            Intrinsics.checkNotNullExpressionValue(requestVersion, "JSONObject().put(CONSTEL…UEST, version).toString()");
            ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).postFormRequest().url(BaiduIdentityManager.getInstance().appendParam(CONSTEL_WIDGET_SERVER_URL, 1))).cookieManager(new SearchBoxCookieManager(true, false))).enableStat(true)).requestFrom(4)).requestSubFrom(8)).addParam("version", requestVersion)).addParam("data", constelWidgets)).build().executeAsync(new ConstelDataManager$requestConstelData$1(this));
        }
    }

    private final String getLocalVersion() {
        return WidgetSharePreferenceUtils.Companion.getInstance().getString(REQUEST_CONSTEL_DATA_VERSION, "0");
    }

    private final String getConstelWidgetPostData(Context context, String constelName) {
        List constelNames = new ArrayList();
        JSONArray constelArray = new JSONArray();
        CharSequence charSequence = constelName;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            int[] existAppWidgetIds = AppWidgetManager.getInstance(context).getAppWidgetIds(new ComponentName(context, ConstelWidgetProvider.class));
            if (existAppWidgetIds != null) {
                if (!(existAppWidgetIds.length == 0)) {
                    int length = existAppWidgetIds.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        String constelName2 = WidgetSharePreferenceUtils.Companion.getInstance().getString(ConstelWidgetProvider.CONSTEL_WIDGET_ID_PREFIX + existAppWidgetIds[i2], "");
                        CharSequence charSequence2 = constelName2;
                        if (!(charSequence2 == null || StringsKt.isBlank(charSequence2)) && !constelNames.contains(constelName2)) {
                            constelNames.add(constelName2);
                            constelArray.put(constelName2);
                        }
                    }
                }
            }
            return "";
        }
        constelArray.put(constelName);
        if (constelArray.length() == 0) {
            return "";
        }
        JSONObject contentJson = new JSONObject();
        contentJson.put("query", constelArray);
        JSONObject constelJson = new JSONObject();
        constelJson.put("constel_widget", contentJson);
        String jSONObject = constelJson.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "constelJson.toString()");
        return jSONObject;
    }
}
