package com.baidu.browser.explore.mutable.personalrecommend;

import android.util.Log;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.browser.BrowserRuntime;
import com.baidu.browser.explore.container.SearchBoxContainer;
import com.baidu.browser.explore.mutable.personalrecommend.data.ResultPageConsumeInfo;
import com.baidu.browser.explore.mutable.personalrecommend.data.ResultpageCardInfo;
import com.baidu.browser.explore.network.NaRequestManager;
import com.baidu.browser.explore.network.SearchOutbackCookieManager;
import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.searchbox.appframework.BdBoxActivityManager;
import com.baidu.searchbox.browserenhanceengine.container.BeeSchemeRouter;
import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.IContainerManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.network.outback.manager.HttpManager;
import com.baidu.searchbox.network.outback.request.GetRequest;
import com.baidu.searchbox.ng.browser.NgWebView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u001c\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0012\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J$\u0010%\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010&\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J0\u0010'\u001a\u00020\u00172\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010+\u001a\u00020\u00142\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J(\u0010,\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u00122\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/browser/explore/mutable/personalrecommend/ResultPageCardConsumeManage;", "", "()V", "ACTION_CONSUMEREQUEST", "", "ACTION_GETCONSUMEPARAMS", "ACTION_RESULTPAGE_CARDINFOLIST", "DATA_URL_SIGN", "LID", "ORDER", "PERSONAL_REQURL", "PERSONAL_RESURLT", "SOURCE_OTHER", "TAG", "TYPE_OTHER", "UBC_ID", "resultCardList", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/baidu/browser/explore/mutable/personalrecommend/data/ResultPageConsumeInfo;", "clearCardList", "", "containerId", "getConsumeParams", "", "action", "callbackHandler", "Lcom/baidu/searchbox/unitedscheme/CallbackHandler;", "getSource", "source", "insertCardInfo", "container", "Lcom/baidu/browser/explore/container/SearchBoxContainer;", "insertResultCardInfo", "consumeInfo", "parseCardList", "data", "Lorg/json/JSONObject;", "parseDeepConsumeInfo", "removeCardList", "requestConsumeInfo", "lid", "order", "type", "requestStatistic", "sendRequest", "cardInfo", "Lcom/baidu/browser/explore/mutable/personalrecommend/data/ResultpageCardInfo;", "key", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ResultPageCardConsumeManage.kt */
public final class ResultPageCardConsumeManage {
    private static final String ACTION_CONSUMEREQUEST = "startConsumeRequest";
    private static final String ACTION_GETCONSUMEPARAMS = "getConsumeParams";
    private static final String ACTION_RESULTPAGE_CARDINFOLIST = "resultPageCardInfoList";
    public static final String DATA_URL_SIGN = "dataUrlSign";
    public static final ResultPageCardConsumeManage INSTANCE = new ResultPageCardConsumeManage();
    public static final String LID = "lid";
    public static final String ORDER = "order";
    public static final String PERSONAL_REQURL = "personalReqUrl";
    public static final String PERSONAL_RESURLT = "personalResult";
    private static final String SOURCE_OTHER = "5";
    private static final String TAG = "CardConsumeManage";
    private static final String TYPE_OTHER = "3";
    private static final String UBC_ID = "6197";
    private static ConcurrentHashMap<String, ResultPageConsumeInfo> resultCardList;

    private ResultPageCardConsumeManage() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean parseDeepConsumeInfo(java.lang.String r5, org.json.JSONObject r6, com.baidu.searchbox.unitedscheme.CallbackHandler r7) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0067
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case 447339528: goto L_0x0050;
                case 1348573173: goto L_0x0019;
                case 1918939372: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0067
        L_0x000b:
            java.lang.String r0 = "getConsumeParams"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0014
            goto L_0x0067
        L_0x0014:
            boolean r0 = r4.getConsumeParams(r5, r7)
            goto L_0x0068
        L_0x0019:
            java.lang.String r0 = "startConsumeRequest"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0023
            goto L_0x0067
        L_0x0023:
            if (r6 == 0) goto L_0x002c
            java.lang.String r0 = "lid"
            java.lang.String r0 = r6.optString(r0)
            goto L_0x002d
        L_0x002c:
            r0 = r1
        L_0x002d:
            if (r6 == 0) goto L_0x0036
            java.lang.String r2 = "order"
            java.lang.String r2 = r6.optString(r2)
            goto L_0x0037
        L_0x0036:
            r2 = r1
        L_0x0037:
            if (r6 == 0) goto L_0x0041
            java.lang.String r3 = "source"
            java.lang.String r3 = r6.optString(r3)
            goto L_0x0042
        L_0x0041:
            r3 = r1
        L_0x0042:
            if (r6 == 0) goto L_0x004b
            java.lang.String r1 = "type"
            java.lang.String r1 = r6.optString(r1)
        L_0x004b:
            boolean r0 = r4.requestConsumeInfo(r0, r2, r3, r1)
            goto L_0x0068
        L_0x0050:
            java.lang.String r0 = "resultPageCardInfoList"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005a
            goto L_0x0067
        L_0x005a:
            if (r6 == 0) goto L_0x0062
            java.lang.String r0 = "cardList"
            org.json.JSONObject r1 = r6.optJSONObject(r0)
        L_0x0062:
            boolean r0 = r4.parseCardList(r1)
            goto L_0x0068
        L_0x0067:
            r0 = 0
        L_0x0068:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.personalrecommend.ResultPageCardConsumeManage.parseDeepConsumeInfo(java.lang.String, org.json.JSONObject, com.baidu.searchbox.unitedscheme.CallbackHandler):boolean");
    }

    private final boolean parseCardList(JSONObject data) {
        ResultPageConsumeInfo resConsumeInfo;
        JSONObject jSONObject = data;
        if (jSONObject == null) {
            return false;
        }
        if (data.length() == 0) {
            return false;
        }
        if (resultCardList == null) {
            resultCardList = new ConcurrentHashMap<>();
        }
        IContainerManager containerManager = BeeSchemeRouter.getContainerManager();
        Container currentContainer = containerManager != null ? containerManager.getCurrentContainer() : null;
        SearchBoxContainer container = currentContainer instanceof SearchBoxContainer ? (SearchBoxContainer) currentContainer : null;
        if (container == null) {
            IContainerManager iContainerManager = containerManager;
            return false;
        } else if (!container.isResultPageFeature()) {
            IContainerManager iContainerManager2 = containerManager;
            return false;
        } else {
            if (AppConfig.isDebug()) {
                Log.i(TAG, "parseCardList data = " + jSONObject);
            }
            String containerId = container.getContainerId();
            if (containerId == null) {
                return false;
            }
            ConcurrentHashMap<String, ResultPageConsumeInfo> concurrentHashMap = resultCardList;
            if (concurrentHashMap == null || (resConsumeInfo = concurrentHashMap.get(containerId)) == null) {
                resConsumeInfo = new ResultPageConsumeInfo(new LinkedHashMap(), (String) null, (String) null, 6, (DefaultConstructorMarker) null);
            }
            resConsumeInfo.setCurLid(container.getResultPageLid());
            Iterator<String> keys = data.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "data.keys()");
            while (keys.hasNext()) {
                String key = keys.next();
                Object obj = jSONObject.get(key);
                JSONObject cardobj = obj instanceof JSONObject ? (JSONObject) obj : null;
                if (cardobj != null) {
                    String lid = cardobj.optString("lid");
                    String order = cardobj.optString("order");
                    String personalReqUrl = cardobj.optString(PERSONAL_REQURL);
                    String dataUrlSign = cardobj.optString(DATA_URL_SIGN);
                    CharSequence charSequence = lid;
                    boolean z = true;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        CharSequence charSequence2 = order;
                        if (!(charSequence2 == null || charSequence2.length() == 0)) {
                            CharSequence charSequence3 = personalReqUrl;
                            if (!(charSequence3 == null || charSequence3.length() == 0)) {
                                CharSequence charSequence4 = dataUrlSign;
                                if (!(charSequence4 == null || charSequence4.length() == 0)) {
                                    z = false;
                                }
                                if (!z) {
                                    ResultpageCardInfo cardInfo = resConsumeInfo.getCardList().get(key);
                                    if (cardInfo != null) {
                                        Intrinsics.checkNotNullExpressionValue(lid, "lid");
                                        Intrinsics.checkNotNullExpressionValue(order, "order");
                                        Intrinsics.checkNotNullExpressionValue(personalReqUrl, PERSONAL_REQURL);
                                        Intrinsics.checkNotNullExpressionValue(dataUrlSign, DATA_URL_SIGN);
                                        cardInfo.updateCardInfo(lid, order, personalReqUrl, dataUrlSign);
                                        jSONObject = data;
                                    } else {
                                        ResultpageCardInfo resultpageCardInfo = cardInfo;
                                        Map<String, ResultpageCardInfo> cardList = resConsumeInfo.getCardList();
                                        Intrinsics.checkNotNullExpressionValue(key, "key");
                                        Intrinsics.checkNotNullExpressionValue(lid, "lid");
                                        Intrinsics.checkNotNullExpressionValue(order, "order");
                                        Intrinsics.checkNotNullExpressionValue(personalReqUrl, PERSONAL_REQURL);
                                        Intrinsics.checkNotNullExpressionValue(dataUrlSign, DATA_URL_SIGN);
                                        String str = order;
                                        String str2 = lid;
                                        cardList.put(key, new ResultpageCardInfo(lid, order, personalReqUrl, dataUrlSign, false, 16, (DefaultConstructorMarker) null));
                                        jSONObject = data;
                                        containerManager = containerManager;
                                    }
                                }
                            }
                        }
                    }
                    String str3 = personalReqUrl;
                    String str4 = order;
                    String str5 = lid;
                    jSONObject = data;
                    containerManager = containerManager;
                }
            }
            ConcurrentHashMap<String, ResultPageConsumeInfo> concurrentHashMap2 = resultCardList;
            if (concurrentHashMap2 == null) {
                return false;
            }
            ResultPageConsumeInfo put = concurrentHashMap2.put(containerId, resConsumeInfo);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001a A[Catch:{ JSONException -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c A[Catch:{ JSONException -> 0x0053 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002e A[Catch:{ JSONException -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean getConsumeParams(java.lang.String r10, com.baidu.searchbox.unitedscheme.CallbackHandler r11) {
        /*
            r9 = this;
            java.lang.String r0 = "CardConsumeManage"
            java.lang.String r1 = ""
            r2 = 1
            java.lang.String r3 = com.baidu.search.basic.utils.SearchABTestUtils.getConsumeParams()     // Catch:{ JSONException -> 0x0053 }
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ JSONException -> 0x0053 }
            if (r4 == 0) goto L_0x0017
            int r4 = r4.length()     // Catch:{ JSONException -> 0x0053 }
            if (r4 != 0) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r4 = 0
            goto L_0x0018
        L_0x0017:
            r4 = r2
        L_0x0018:
            if (r4 == 0) goto L_0x001c
            r4 = r1
            goto L_0x002b
        L_0x001c:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0053 }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x0053 }
            java.lang.String r4 = r4.toString()     // Catch:{ JSONException -> 0x0053 }
            java.lang.String r5 = "{\n                JSONOb….toString()\n            }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ JSONException -> 0x0053 }
        L_0x002b:
            if (r11 == 0) goto L_0x0079
            r5 = r4
            r6 = 0
            boolean r7 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ JSONException -> 0x0053 }
            if (r7 == 0) goto L_0x004c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0053 }
            r7.<init>()     // Catch:{ JSONException -> 0x0053 }
            java.lang.String r8 = "getConsumeParams = "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ JSONException -> 0x0053 }
            java.lang.StringBuilder r7 = r7.append(r5)     // Catch:{ JSONException -> 0x0053 }
            java.lang.String r7 = r7.toString()     // Catch:{ JSONException -> 0x0053 }
            android.util.Log.i(r0, r7)     // Catch:{ JSONException -> 0x0053 }
        L_0x004c:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ JSONException -> 0x0053 }
            r11.handleSchemeDispatchCallback(r10, r4)     // Catch:{ JSONException -> 0x0053 }
            goto L_0x0079
        L_0x0053:
            r3 = move-exception
            if (r11 == 0) goto L_0x0059
            r11.handleSchemeDispatchCallback(r10, r1)
        L_0x0059:
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x0079
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "getConsumeParams exception = "
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r4 = r3.getLocalizedMessage()
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
        L_0x0079:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.personalrecommend.ResultPageCardConsumeManage.getConsumeParams(java.lang.String, com.baidu.searchbox.unitedscheme.CallbackHandler):boolean");
    }

    private final boolean requestConsumeInfo(String lid, String order, String source, String type) {
        ConcurrentHashMap resultCardList2;
        CharSequence charSequence = lid;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = order;
            if ((charSequence2 == null || charSequence2.length() == 0) || (resultCardList2 = resultCardList) == null || resultCardList2.isEmpty()) {
                return false;
            }
            String key = lid + order;
            for (ResultPageConsumeInfo consumeinfo : resultCardList2.values()) {
                ResultpageCardInfo resultpageCardInfo = consumeinfo.getCardList().get(key);
                if (resultpageCardInfo != null) {
                    ResultpageCardInfo cardInfo = resultpageCardInfo;
                    String cardSource = getSource(source);
                    if (!SearchABTestUtils.isPersonalConsume()) {
                        if (!cardInfo.getConsumed()) {
                            cardInfo.setConsumed(true);
                            requestStatistic(lid, order, type, cardSource);
                        }
                        return true;
                    }
                    if (!cardInfo.getConsumed()) {
                        Intrinsics.checkNotNullExpressionValue(consumeinfo, "consumeinfo");
                        sendRequest(consumeinfo, cardInfo, key, cardSource);
                    }
                    requestStatistic(lid, order, type, cardSource);
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    private final void sendRequest(ResultPageConsumeInfo consumeInfo, ResultpageCardInfo cardInfo, String key, String source) {
        GetRequest.GetRequestBuilder builder;
        GetRequest.GetRequestBuilder request;
        GetRequest.GetRequestBuilder getRequestBuilder;
        GetRequest.GetRequestBuilder getRequestBuilder2;
        GetRequest.GetRequestBuilder getRequestBuilder3;
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        if (httpManager == null || (request = httpManager.getRequest()) == null || (getRequestBuilder = (GetRequest.GetRequestBuilder) request.url(cardInfo.getPersonalReqUrl())) == null || (getRequestBuilder2 = (GetRequest.GetRequestBuilder) getRequestBuilder.requestFrom(4)) == null || (getRequestBuilder3 = (GetRequest.GetRequestBuilder) getRequestBuilder2.addHeader("User-Agent", NaRequestManager.INSTANCE.getUserAgentString())) == null) {
            builder = null;
        } else {
            builder = (GetRequest.GetRequestBuilder) getRequestBuilder3.requestSubFrom(22);
        }
        if (builder != null) {
            builder.cookieManager(new SearchOutbackCookieManager(false, false));
            builder.build().executeAsync(new ResultPageCardConsumeManage$sendRequest$1(cardInfo, consumeInfo, key, source));
        }
    }

    /* access modifiers changed from: private */
    public final void insertResultCardInfo(ResultPageConsumeInfo consumeInfo) {
        String containerId;
        if (BrowserRuntime.getContext().isLightSearchActivity(BdBoxActivityManager.getTopActivity())) {
            IContainerManager containerManager = BeeSchemeRouter.getContainerManager();
            ResultPageConsumeInfo resultPageConsumeInfo = null;
            Container currentContainer = containerManager != null ? containerManager.getCurrentContainer() : null;
            SearchBoxContainer container = currentContainer instanceof SearchBoxContainer ? (SearchBoxContainer) currentContainer : null;
            boolean z = true;
            if (container == null || !container.isResultPageFeature()) {
                z = false;
            }
            if (z && (containerId = container.getContainerId()) != null) {
                ConcurrentHashMap<String, ResultPageConsumeInfo> concurrentHashMap = resultCardList;
                if (concurrentHashMap != null) {
                    resultPageConsumeInfo = concurrentHashMap.get(containerId);
                }
                if (Intrinsics.areEqual((Object) resultPageConsumeInfo, (Object) consumeInfo)) {
                    insertCardInfo(container);
                }
            }
        }
    }

    public final void insertCardInfo(SearchBoxContainer container) {
        String containerId;
        ConcurrentHashMap<String, ResultPageConsumeInfo> concurrentHashMap;
        ResultPageConsumeInfo consumeInfo;
        if (SearchABTestUtils.isPersonalConsume()) {
            boolean z = true;
            if (container != null && container.isResultPageAllTab()) {
                NgWebView webView = container.getWebView();
                if (!(webView != null && webView.isPaused()) && (containerId = container.getContainerId()) != null && (concurrentHashMap = resultCardList) != null && (consumeInfo = concurrentHashMap.get(containerId)) != null) {
                    CharSequence personalResult = consumeInfo.getPersonalResult();
                    if (!(personalResult == null || personalResult.length() == 0)) {
                        z = false;
                    }
                    if (!z) {
                        UiThreadUtils.runOnUiThread(new ResultPageCardConsumeManage$$ExternalSyntheticLambda0(container, consumeInfo));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: insertCardInfo$lambda-1  reason: not valid java name */
    public static final void m12907insertCardInfo$lambda1(SearchBoxContainer $container, ResultPageConsumeInfo $consumeInfo) {
        Intrinsics.checkNotNullParameter($consumeInfo, "$consumeInfo");
        if (AppConfig.isDebug()) {
            Log.i(TAG, "loadjs");
        }
        $container.loadJavaScript($consumeInfo.getPersonalResult());
        $consumeInfo.setPersonalResult((String) null);
    }

    public final void clearCardList(String containerId) {
        ConcurrentHashMap<String, ResultPageConsumeInfo> concurrentHashMap;
        CharSequence charSequence = containerId;
        if (!(charSequence == null || charSequence.length() == 0) && (concurrentHashMap = resultCardList) != null) {
            ResultPageConsumeInfo put = concurrentHashMap.put(containerId, new ResultPageConsumeInfo(new LinkedHashMap(), (String) null, (String) null, 6, (DefaultConstructorMarker) null));
        }
    }

    public final void removeCardList(String containerId) {
        ConcurrentHashMap<String, ResultPageConsumeInfo> concurrentHashMap;
        if (containerId != null && (concurrentHashMap = resultCardList) != null) {
            ResultPageConsumeInfo remove = concurrentHashMap.remove(containerId);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void requestStatistic(java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r3 = this;
            r0 = r4
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 != 0) goto L_0x00ab
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x001e
            int r0 = r0.length()
            if (r0 != 0) goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            if (r1 == 0) goto L_0x0023
            goto L_0x00ab
        L_0x0023:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x008a }
            r0.<init>()     // Catch:{ JSONException -> 0x008a }
            java.lang.String r1 = "type"
            if (r6 == 0) goto L_0x0064
            int r2 = r6.hashCode()     // Catch:{ JSONException -> 0x008a }
            switch(r2) {
                case -335068105: goto L_0x0054;
                case 504042819: goto L_0x0046;
                case 2036079407: goto L_0x0036;
                default: goto L_0x0035;
            }     // Catch:{ JSONException -> 0x008a }
        L_0x0035:
            goto L_0x0064
        L_0x0036:
            java.lang.String r2 = "videoDuration"
            boolean r2 = r6.equals(r2)     // Catch:{ JSONException -> 0x008a }
            if (r2 != 0) goto L_0x0040
            goto L_0x0064
        L_0x0040:
            java.lang.String r2 = "1"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x008a }
            goto L_0x0069
        L_0x0046:
            java.lang.String r2 = "pageDuration"
            boolean r2 = r6.equals(r2)     // Catch:{ JSONException -> 0x008a }
            if (r2 == 0) goto L_0x0064
            java.lang.String r2 = "0"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x008a }
            goto L_0x0069
        L_0x0054:
            java.lang.String r2 = "videoCompletionRate"
            boolean r2 = r6.equals(r2)     // Catch:{ JSONException -> 0x008a }
            if (r2 != 0) goto L_0x005e
            goto L_0x0064
        L_0x005e:
            java.lang.String r2 = "2"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x008a }
            goto L_0x0069
        L_0x0064:
            java.lang.String r2 = TYPE_OTHER     // Catch:{ JSONException -> 0x008a }
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x008a }
        L_0x0069:
            java.lang.String r1 = "source"
            r0.put(r1, r7)     // Catch:{ JSONException -> 0x008a }
            java.lang.String r1 = "lid"
            r0.put(r1, r4)     // Catch:{ JSONException -> 0x008a }
            java.lang.String r1 = "from"
            java.lang.String r2 = "search"
            r0.put(r1, r2)     // Catch:{ JSONException -> 0x008a }
            com.baidu.pyramid.runtime.service.ServiceReference r1 = com.baidu.ubc.UBCManager.SERVICE_REFERENCE     // Catch:{ JSONException -> 0x008a }
            java.lang.Object r1 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r1)     // Catch:{ JSONException -> 0x008a }
            com.baidu.ubc.UBCManager r1 = (com.baidu.ubc.UBCManager) r1     // Catch:{ JSONException -> 0x008a }
            java.lang.String r2 = UBC_ID     // Catch:{ JSONException -> 0x008a }
            r1.onEvent((java.lang.String) r2, (org.json.JSONObject) r0)     // Catch:{ JSONException -> 0x008a }
            goto L_0x00aa
        L_0x008a:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x00aa
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "requestStatistic Failed: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CardConsumeManage"
            android.util.Log.i(r2, r1)
        L_0x00aa:
            return
        L_0x00ab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.personalrecommend.ResultPageCardConsumeManage.requestStatistic(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    private final String getSource(String source) {
        CharSequence charSequence = source;
        if (charSequence == null || charSequence.length() == 0) {
            return SOURCE_OTHER;
        }
        if (Intrinsics.areEqual((Object) source, (Object) "swan")) {
            return "2";
        }
        if (Intrinsics.areEqual((Object) source, (Object) "video_a")) {
            return "4";
        }
        if (Intrinsics.areEqual((Object) source, (Object) "video_c")) {
            return "1";
        }
        return source;
    }
}
