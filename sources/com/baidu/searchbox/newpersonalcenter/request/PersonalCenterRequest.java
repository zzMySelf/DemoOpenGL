package com.baidu.searchbox.newpersonalcenter.request;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.GetRequest;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel;
import com.baidu.searchbox.net.SearchBoxCookieManager;
import com.baidu.searchbox.personalcenter.config.PersonalCenterUrlConfig;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00050\u000bJJ\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e28\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00040\u0010¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/request/PersonalCenterRequest;", "", "()V", "getRequestOnUIBack", "", "T", "url", "", "params", "", "responseCallback", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "reqStockInfo", "personalCenterGroupModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterGroupModel;", "callBack", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "data", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterRequest.kt */
public final class PersonalCenterRequest {
    public static final PersonalCenterRequest INSTANCE = new PersonalCenterRequest();

    private PersonalCenterRequest() {
    }

    public final <T> void getRequestOnUIBack(String url, Map<String, String> params, ResponseCallback<T> responseCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) ((GetRequest.GetRequestBuilder) HttpManager.getDefault(AppRuntime.getAppContext()).getRequest().url(url)).addUrlParams(params)).requestFrom(10)).requestSubFrom(1015)).cookieManager(new SearchBoxCookieManager(false, false))).build().executeAsyncOnUIBack(responseCallback);
    }

    public final void reqStockInfo(PersonalCenterGroupModel personalCenterGroupModel, Function2<? super Boolean, ? super PersonalCenterGroupModel, Unit> callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        PersonalCenterRequest$reqStockInfo$responseCallback$1 responseCallback = new PersonalCenterRequest$reqStockInfo$responseCallback$1(personalCenterGroupModel, callBack);
        String url = BaiduIdentityManager.getInstance().appendParam(PersonalCenterUrlConfig.getStockDataUrl(), 1);
        Intrinsics.checkNotNullExpressionValue(url, "url");
        getRequestOnUIBack(url, new LinkedHashMap(), responseCallback);
    }
}
