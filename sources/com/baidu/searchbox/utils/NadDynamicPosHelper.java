package com.baidu.searchbox.utils;

import android.webkit.URLUtil;
import com.baidu.searchbox.ad.position.list.AdListState;
import com.baidu.searchbox.ad.position.place.IAdPlace;
import com.baidu.searchbox.ad.position.strategy.AdPosStrategy;
import com.baidu.searchbox.ad.util.NadConsoleLog;
import com.baidu.searchbox.config.HostConfig;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.IAdDeviceInfo;
import com.baidu.searchbox.feed.ad.NotifyListChangeCallback;
import com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedFlowModel;
import com.baidu.searchbox.feed.net.FeedRequester;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.PostFormRequest;
import com.baidu.searchbox.http.request.PostFormRequestNew;
import com.baidu.searchbox.privacy.FeedIdentityManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010 \u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020%H\u0016J,\u0010&\u001a\u00020'2\"\u0010(\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bj\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f`\rH\u0016J\b\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020\fH\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\b\u0010,\u001a\u00020\u000fH\u0016J\u0018\u0010-\u001a\u00020'2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/H\u0014J\u0010\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u0004J.\u00103\u001a\u00020'2&\u0010(\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`\rR.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u0001`\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0015\u0010\u0011R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/baidu/searchbox/utils/NadDynamicPosHelper;", "Lcom/baidu/searchbox/utils/NadFeedHelper;", "list", "", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "adListState", "Lcom/baidu/searchbox/ad/position/list/AdListState;", "callback", "Lcom/baidu/searchbox/feed/ad/NotifyListChangeCallback;", "(Ljava/util/List;Lcom/baidu/searchbox/ad/position/list/AdListState;Lcom/baidu/searchbox/feed/ad/NotifyListChangeCallback;)V", "commonParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "eShowDupSwitch", "", "getEShowDupSwitch", "()Z", "eShowDupSwitch$delegate", "Lkotlin/Lazy;", "fluencyOptSwitch", "getFluencyOptSwitch", "fluencyOptSwitch$delegate", "placeDesc", "Lcom/baidu/searchbox/ad/position/place/IAdPlace;", "adControlDynamicIntervalMax", "", "ad", "Lcom/baidu/searchbox/feed/ad/model/NadAsyncFeedBaseModel;", "adControlDynamicIntervalMin", "adControlDynamicScreenInterval", "", "adControlFirstPos", "adControlFirstPvFloorDef", "adControlInsertAfterRequestWithUserPosDef", "adControlPlaceDesc", "adControlStrategyTypeDef", "Lcom/baidu/searchbox/ad/position/strategy/AdPosStrategy;", "buildPostParams", "", "params", "getCmd", "getConfigUrl", "isDuplicated", "isRestful", "postRequest", "responseCallback", "Lcom/baidu/searchbox/http/callback/ResponseCallback;", "Lcom/baidu/searchbox/feed/model/FeedFlowModel;", "recordNidOnEShow", "feed", "setUserPostParams", "lib-ad-feed_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDynamicPosHelper.kt */
public final class NadDynamicPosHelper extends NadFeedHelper {
    private HashMap<String, String> commonParams;
    private final Lazy eShowDupSwitch$delegate = LazyKt.lazy(NadDynamicPosHelper$eShowDupSwitch$2.INSTANCE);
    private final Lazy fluencyOptSwitch$delegate = LazyKt.lazy(NadDynamicPosHelper$fluencyOptSwitch$2.INSTANCE);
    private final IAdPlace placeDesc = new NadDynamicPosHelper$placeDesc$1();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NadDynamicPosHelper(List<FeedBaseModel> list, AdListState adListState, NotifyListChangeCallback callback) {
        super(list, adListState, callback);
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(adListState, "adListState");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    private final boolean getEShowDupSwitch() {
        return ((Boolean) this.eShowDupSwitch$delegate.getValue()).booleanValue();
    }

    private final boolean getFluencyOptSwitch() {
        return ((Boolean) this.fluencyOptSwitch$delegate.getValue()).booleanValue();
    }

    public boolean isRestful() {
        return true;
    }

    public void buildPostParams(HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    public String getCmd() {
        return "";
    }

    public IAdPlace adControlPlaceDesc() {
        return this.placeDesc;
    }

    /* access modifiers changed from: protected */
    public void postRequest(ResponseCallback<FeedFlowModel> responseCallback) {
        Intrinsics.checkNotNullParameter(responseCallback, "responseCallback");
        HashMap<String, String> hashMap = this.commonParams;
        if (hashMap != null) {
            HashMap<String, String> hashMap2 = hashMap;
            try {
                JSONObject dataJson = new JSONObject(hashMap.get("data"));
                JSONObject it = IAdDeviceInfo.Impl.get().buildCommonParams();
                if (it != null) {
                    it.put("pd", "dynamic");
                    dataJson.put("da", it);
                    dataJson.put("context", getPvContext());
                }
                String jSONObject = dataJson.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "dataJson.toString()");
                hashMap.put("data", jSONObject);
            } catch (Throwable th2) {
            }
            String url = FeedIdentityManager.commonProcessUrl(getConfigUrl());
            boolean isUseHttps = URLUtil.isHttpsUrl(url);
            HttpManager manager = FeedRequester.getHttpManager();
            if (isUseHttps) {
                CookieManager cookieManager = FeedRuntime.getFeedContext().newCookieManagerInstance(true, false);
                if (getFluencyOptSwitch()) {
                    ((PostFormRequestNew.PostFormRequestNewBuilder) ((PostFormRequestNew.PostFormRequestNewBuilder) ((PostFormRequestNew.PostFormRequestNewBuilder) manager.postFormRequestNew().url(url)).cookieManager(cookieManager)).params(hashMap)).build().executeAsyncOnUIBack(responseCallback);
                } else {
                    ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) manager.postFormRequest().url(url)).cookieManager(cookieManager)).params(hashMap)).build().executeAsyncOnUIBack(responseCallback);
                }
            } else if (getFluencyOptSwitch()) {
                ((PostFormRequestNew.PostFormRequestNewBuilder) ((PostFormRequestNew.PostFormRequestNewBuilder) manager.postFormRequestNew().url(url)).params(hashMap)).build().executeAsyncOnUIBack(responseCallback);
            } else {
                ((PostFormRequest.PostFormRequestBuilder) ((PostFormRequest.PostFormRequestBuilder) manager.postFormRequest().url(url)).params(hashMap)).build().executeAsyncOnUIBack(responseCallback);
            }
        }
    }

    private final String getConfigUrl() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s/feedcmp/V1/list/feeddynamic", Arrays.copyOf(new Object[]{HostConfig.getSearchboxHostForHttps()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r4.getModel()).data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int adControlFirstPos(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedBaseModel r1 = r4.getModel()
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedItemData r1 = r1.data
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.ad.model.AdModuleData r1 = r1.ad
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            boolean r2 = r1 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r2 == 0) goto L_0x0016
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x001f
            com.baidu.searchbox.ad.model.NadDynamicPolicyModel r0 = r0.dynamicPolicyModel
            if (r0 == 0) goto L_0x001f
            int r0 = r0.adFirstFloor
            goto L_0x0026
        L_0x001f:
            r0 = r4
            com.baidu.searchbox.ad.position.type.IAdItemModel r0 = (com.baidu.searchbox.ad.position.type.IAdItemModel) r0
            int r0 = super.adControlFirstPos(r0)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.utils.NadDynamicPosHelper.adControlFirstPos(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r4.getModel()).data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float adControlDynamicScreenInterval(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedBaseModel r1 = r4.getModel()
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedItemData r1 = r1.data
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.ad.model.AdModuleData r1 = r1.ad
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            boolean r2 = r1 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r2 == 0) goto L_0x0016
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x001f
            com.baidu.searchbox.ad.model.NadDynamicPolicyModel r0 = r0.dynamicPolicyModel
            if (r0 == 0) goto L_0x001f
            float r0 = r0.adIntervalScreen
            goto L_0x0026
        L_0x001f:
            r0 = r4
            com.baidu.searchbox.ad.position.type.IAdItemModel r0 = (com.baidu.searchbox.ad.position.type.IAdItemModel) r0
            float r0 = super.adControlDynamicScreenInterval(r0)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.utils.NadDynamicPosHelper.adControlDynamicScreenInterval(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel):float");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r4.getModel()).data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int adControlDynamicIntervalMax(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedBaseModel r1 = r4.getModel()
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedItemData r1 = r1.data
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.ad.model.AdModuleData r1 = r1.ad
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            boolean r2 = r1 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r2 == 0) goto L_0x0016
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x001f
            com.baidu.searchbox.ad.model.NadDynamicPolicyModel r0 = r0.dynamicPolicyModel
            if (r0 == 0) goto L_0x001f
            int r0 = r0.adIntervalUpLimit
            goto L_0x0026
        L_0x001f:
            r0 = r4
            com.baidu.searchbox.ad.position.type.IAdItemModel r0 = (com.baidu.searchbox.ad.position.type.IAdItemModel) r0
            int r0 = super.adControlDynamicIntervalMax(r0)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.utils.NadDynamicPosHelper.adControlDynamicIntervalMax(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r1 = (r1 = r4.getModel()).data;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int adControlDynamicIntervalMin(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedBaseModel r1 = r4.getModel()
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.model.FeedItemData r1 = r1.data
            if (r1 == 0) goto L_0x0010
            com.baidu.searchbox.feed.ad.model.AdModuleData r1 = r1.ad
            goto L_0x0011
        L_0x0010:
            r1 = r0
        L_0x0011:
            boolean r2 = r1 instanceof com.baidu.searchbox.feed.ad.model.AdModuleData
            if (r2 == 0) goto L_0x0016
            r0 = r1
        L_0x0016:
            if (r0 == 0) goto L_0x001f
            com.baidu.searchbox.ad.model.NadDynamicPolicyModel r0 = r0.dynamicPolicyModel
            if (r0 == 0) goto L_0x001f
            int r0 = r0.adIntervalLowLimit
            goto L_0x0026
        L_0x001f:
            r0 = r4
            com.baidu.searchbox.ad.position.type.IAdItemModel r0 = (com.baidu.searchbox.ad.position.type.IAdItemModel) r0
            int r0 = super.adControlDynamicIntervalMin(r0)
        L_0x0026:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.utils.NadDynamicPosHelper.adControlDynamicIntervalMin(com.baidu.searchbox.feed.ad.model.NadAsyncFeedBaseModel):int");
    }

    public AdPosStrategy adControlStrategyTypeDef() {
        return AdPosStrategy.DYNAMIC_SCREEN_DISTANCE;
    }

    public final void setUserPostParams(HashMap<String, String> params) {
        this.commonParams = params;
    }

    public int adControlFirstPvFloorDef() {
        return 1;
    }

    public boolean adControlInsertAfterRequestWithUserPosDef() {
        return true;
    }

    public final void recordNidOnEShow(FeedBaseModel feed) {
        if (getEShowDupSwitch()) {
            HashSet<String> nidSet = getListState().getNidSet();
            String str = feed != null ? feed.id : null;
            if (str == null) {
                str = "";
            }
            nidSet.add(str);
            NadConsoleLog.INSTANCE.eShowDupUpgrade("eshow频控", "广告【曝光】，记录广告id");
        }
    }

    /* access modifiers changed from: protected */
    public boolean isDuplicated(NadAsyncFeedBaseModel ad) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        if (getEShowDupSwitch()) {
            CharSequence charSequence = ad.getModel().id;
            if ((charSequence == null || StringsKt.isBlank(charSequence)) || getListState().getNidSet().contains(ad.getModel().id)) {
                return true;
            }
            return false;
        }
        NadConsoleLog.INSTANCE.eShowDupUpgrade("show频控", "广告【下发】，记录广告id");
        return super.isDuplicated(ad);
    }
}
