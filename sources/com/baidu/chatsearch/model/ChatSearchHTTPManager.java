package com.baidu.chatsearch.model;

import com.baidu.appsearch.lite.AppsearchNetService;
import com.baidu.chatsearch.aisearch.resultpage.utils.SSAiSpeedUbcManagerKt;
import com.baidu.chatsearch.model.ioc.ChatSearchModelRuntime;
import com.baidu.chatsearch.model.sug.model.SSAgentSugModel;
import com.baidu.chatsearch.utils.AppUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.http.Cancelable;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.imagesearch.image.ImageSearchRequest;
import com.baidu.searchbox.net.SearchBoxCookieManager;
import com.baidu.searchbox.util.BaiduIdentityManager;
import com.baidu.util.Base64Encoder;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJk\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042O\u0010\u0012\u001aK\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0013JÉ\u0001\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u00042\u0001\u0010\u0012\u001a\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u001b\u0012\u0019\u0018\u00010!j\u0004\u0018\u0001`\"¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(%\u0012'\u0012%\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040'\u0018\u00010&¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b((\u0012\u0013\u0012\u00110)¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001b0 R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006+"}, d2 = {"Lcom/baidu/chatsearch/model/ChatSearchHTTPManager;", "", "()V", "TAG", "", "useDebugUrl", "", "getUseDebugUrl", "()Z", "setUseDebugUrl", "(Z)V", "generateRandomNumberString", "length", "", "syncAgentSugList", "Lcom/baidu/searchbox/http/Cancelable;", "sugQuery", "ua", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "inputText", "", "throwable", "Lcom/baidu/chatsearch/model/sug/model/SSAgentSugModel;", "sugModel", "", "syncNewSugData", "category", "theme", "mOriLid", "Lkotlin/Function5;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lorg/json/JSONObject;", "response", "", "", "responseHeaders", "", "responseDuration", "lib-chatsearch-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchHTTPManager.kt */
public final class ChatSearchHTTPManager {
    public static final ChatSearchHTTPManager INSTANCE = new ChatSearchHTTPManager();
    private static final String TAG = "ChatSearchHTTPManager";
    private static boolean useDebugUrl;

    private ChatSearchHTTPManager() {
    }

    public final boolean getUseDebugUrl() {
        return useDebugUrl;
    }

    public final void setUseDebugUrl(boolean z) {
        useDebugUrl = z;
    }

    public static /* synthetic */ Cancelable syncNewSugData$default(ChatSearchHTTPManager chatSearchHTTPManager, String str, String str2, String str3, String str4, String str5, Function5 function5, int i2, Object obj) {
        String str6;
        String str7;
        if ((i2 & 8) != 0) {
            str6 = "default";
        } else {
            str6 = str4;
        }
        if ((i2 & 16) != 0) {
            str7 = "";
        } else {
            str7 = str5;
        }
        return chatSearchHTTPManager.syncNewSugData(str, str2, str3, str6, str7, function5);
    }

    public final Cancelable syncNewSugData(String inputText, String ua, String category, String theme, String mOriLid, Function5<? super String, ? super Exception, ? super JSONObject, ? super Map<String, ? extends List<String>>, ? super Long, Unit> callback) {
        String str = inputText;
        String str2 = ua;
        String str3 = mOriLid;
        Function5<? super String, ? super Exception, ? super JSONObject, ? super Map<String, ? extends List<String>>, ? super Long, Unit> function5 = callback;
        Intrinsics.checkNotNullParameter(str, "inputText");
        Intrinsics.checkNotNullParameter(str2, "ua");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(str3, "mOriLid");
        Intrinsics.checkNotNullParameter(function5, "callback");
        long startTime = System.currentTimeMillis();
        String baiduCuid = AppUtils.INSTANCE.getBaiduCuid();
        if (baiduCuid == null) {
            baiduCuid = "";
        }
        byte[] bytes = baiduCuid.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] b64Encode = Base64Encoder.b64Encode(bytes);
        Intrinsics.checkNotNullExpressionValue(b64Encode, "b64Encode((AppUtils.getB…d() ?: \"\").toByteArray())");
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        Intrinsics.checkNotNullExpressionValue(httpManager, "getDefault(AppRuntime.getAppContext())");
        Cancelable executeAsync = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) httpManager.getRequest().url("https://m.baidu.com/suggest")).addUrlParams(MapsKt.hashMapOf(TuplesKt.to("query", str), TuplesKt.to("ctl", "sug"), TuplesKt.to("v", "2"), TuplesKt.to("ua", str2), TuplesKt.to("uid", new String(b64Encode, Charsets.UTF_8)), TuplesKt.to("lid", generateRandomNumberString(20)), TuplesKt.to(AppsearchNetService.KEY_CEN, "uid_ua"), TuplesKt.to("ctv", "2"), TuplesKt.to("ori_lid", str3), TuplesKt.to("service", BaiduIdentityManager.PARAM_SERVICE), TuplesKt.to(SSAiSpeedUbcManagerKt.UBC_LOG_FROM, "1"), TuplesKt.to(ImageSearchRequest.KEY_OS_NAME, ChatSearchModelRuntime.INSTANCE.getChatSearchParam().getOsname())))).addHeader("personal-switch", ChatSearchModelRuntime.INSTANCE.getChatSearchParam().getPersonalRecSwitchValue())).cookieManager(new SearchBoxCookieManager(false, false))).build().executeAsync(new ChatSearchHTTPManager$syncNewSugData$okhttpCallBack$1(function5, str, startTime));
        Intrinsics.checkNotNullExpressionValue(executeAsync, "request.executeAsync(okhttpCallBack)");
        return executeAsync;
    }

    public final String generateRandomNumberString(int length) {
        Random random = new Random(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2;
            stringBuilder.append(random.nextInt(10));
        }
        String sb = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "stringBuilder.toString()");
        return sb;
    }

    public final Cancelable syncAgentSugList(String sugQuery, String ua, Function3<? super String, ? super Throwable, ? super SSAgentSugModel, Unit> callback) {
        String str;
        Intrinsics.checkNotNullParameter(callback, "callback");
        String urlPath = "https://m.baidu.com/suggest";
        if (AppConfig.isDebug()) {
            if (useDebugUrl) {
                str = "http://10.12.212.65:8087/suggest";
            } else {
                str = "https://m.baidu.com/suggest";
            }
            urlPath = str;
        }
        HttpManager httpManager = HttpManager.getDefault(AppRuntime.getAppContext());
        Intrinsics.checkNotNullExpressionValue(httpManager, "getDefault(AppRuntime.getAppContext())");
        String baiduCuid = AppUtils.INSTANCE.getBaiduCuid();
        String str2 = "";
        if (baiduCuid == null) {
            baiduCuid = str2;
        }
        byte[] bytes = baiduCuid.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] b64Encode = Base64Encoder.b64Encode(bytes);
        Intrinsics.checkNotNullExpressionValue(b64Encode, "b64Encode((AppUtils.getB…d() ?: \"\").toByteArray())");
        String uid = new String(b64Encode, Charsets.UTF_8);
        GetRequest.GetRequestBuilder getRequestBuilder = (GetRequest.GetRequestBuilder) httpManager.getRequest().url(urlPath);
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to("ctl", "ai");
        pairArr[1] = TuplesKt.to("action", "agent");
        if (sugQuery != null) {
            str2 = sugQuery;
        }
        pairArr[2] = TuplesKt.to("query", str2);
        pairArr[3] = TuplesKt.to("service", BaiduIdentityManager.PARAM_SERVICE);
        pairArr[4] = TuplesKt.to("ua", ua);
        pairArr[5] = TuplesKt.to("uid", uid);
        pairArr[6] = TuplesKt.to(SSAiSpeedUbcManagerKt.UBC_LOG_FROM, "1");
        pairArr[7] = TuplesKt.to(ImageSearchRequest.KEY_OS_NAME, ChatSearchModelRuntime.INSTANCE.getChatSearchParam().getOsname());
        Cancelable executeAsync = ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) getRequestBuilder.addUrlParams(MapsKt.hashMapOf(pairArr))).cookieManager(new SearchBoxCookieManager(false, false))).build().executeAsync(new ChatSearchHTTPManager$syncAgentSugList$okhttpCallBack$1(callback, sugQuery));
        Intrinsics.checkNotNullExpressionValue(executeAsync, "request.executeAsync(okhttpCallBack)");
        return executeAsync;
    }
}
