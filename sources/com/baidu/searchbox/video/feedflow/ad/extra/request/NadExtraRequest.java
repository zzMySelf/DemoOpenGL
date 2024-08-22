package com.baidu.searchbox.video.feedflow.ad.extra.request;

import com.baidu.nadcore.safe.JSONUtils;
import com.baidu.searchbox.ad.position.placehelper.IAdRequestCallback;
import com.baidu.searchbox.feed.ad.IAdDeviceInfo;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import com.baidu.searchbox.video.feedflow.ad.AdRedux;
import com.baidu.searchbox.video.feedflow.ad.extra.NadExtraModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/extra/request/NadExtraRequest;", "", "()V", "getDa", "Lorg/json/JSONObject;", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "getRequestParam", "Lcom/baidu/searchbox/video/feedflow/ad/extra/request/NadExtraParam;", "requestAd", "", "callback", "Lcom/baidu/searchbox/ad/position/placehelper/IAdRequestCallback;", "Lcom/baidu/searchbox/video/feedflow/ad/extra/NadExtraModel;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadExtraRequest.kt */
public final class NadExtraRequest {
    public final void requestAd(IAdRequestCallback<NadExtraModel> callback, CommonState state) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new NadExtraRequest$requestAd$1(this, state, callback, (Continuation<? super NadExtraRequest$requestAd$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
        r2 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r17.select(com.baidu.searchbox.video.detail.business.VideoBusiness.class);
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.video.feedflow.ad.extra.request.NadExtraParam getRequestParam(com.baidu.searchbox.feed.detail.arch.ext.CommonState r17) {
        /*
            r16 = this;
            org.json.JSONObject r1 = r16.getDa(r17)
            java.lang.String r0 = ""
            if (r17 == 0) goto L_0x0019
            r2 = r17
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.detail.core.model.IntentData r2 = (com.baidu.searchbox.video.detail.core.model.IntentData) r2
            if (r2 == 0) goto L_0x0019
            java.lang.String r2 = r2.pd
            if (r2 != 0) goto L_0x002e
        L_0x0019:
            if (r17 == 0) goto L_0x002d
            r2 = r17
            r3 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.business.VideoBusiness> r4 = com.baidu.searchbox.video.detail.business.VideoBusiness.class
            java.lang.Object r2 = r2.select(r4)
            com.baidu.searchbox.video.detail.business.VideoBusiness r2 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r2
            if (r2 == 0) goto L_0x002d
            java.lang.String r2 = r2.pd()
            goto L_0x002e
        L_0x002d:
            r2 = r0
        L_0x002e:
            if (r17 == 0) goto L_0x0044
            r3 = r17
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r5 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = (com.baidu.searchbox.video.detail.core.model.IntentData) r3
            if (r3 == 0) goto L_0x0044
            java.lang.String r3 = r3.page
            if (r3 != 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r4 = r3
            goto L_0x0059
        L_0x0044:
            if (r17 == 0) goto L_0x0058
            r3 = r17
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.business.VideoBusiness> r5 = com.baidu.searchbox.video.detail.business.VideoBusiness.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.detail.business.VideoBusiness r3 = (com.baidu.searchbox.video.detail.business.VideoBusiness) r3
            if (r3 == 0) goto L_0x0058
            java.lang.String r3 = r3.page()
            goto L_0x0042
        L_0x0058:
            r4 = r0
        L_0x0059:
            com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils r3 = com.baidu.searchbox.video.detail.export.IVideoScreenInfoUtils.Impl.get()
            boolean r3 = r3.isScreenLand()
            java.lang.String r5 = "1"
            if (r3 == 0) goto L_0x0067
            r3 = r5
            goto L_0x0069
        L_0x0067:
            java.lang.String r3 = "0"
        L_0x0069:
            if (r17 == 0) goto L_0x0081
            r6 = r17
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r6 = r6.select(r8)
            com.baidu.searchbox.video.detail.core.model.IntentData r6 = (com.baidu.searchbox.video.detail.core.model.IntentData) r6
            if (r6 == 0) goto L_0x0081
            java.lang.String r6 = r6.getResourceType()
            if (r6 != 0) goto L_0x007f
            goto L_0x0081
        L_0x007f:
            r8 = r6
            goto L_0x0082
        L_0x0081:
            r8 = r0
        L_0x0082:
            r6 = 0
            if (r17 == 0) goto L_0x009e
            r7 = r17
            r9 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r10 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r10)
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x009e
            org.json.JSONObject r7 = r7.extRequest
            if (r7 == 0) goto L_0x009e
            java.lang.String r9 = "tab_id"
            java.lang.String r7 = r7.optString(r9, r5)
            goto L_0x009f
        L_0x009e:
            r7 = r6
        L_0x009f:
            if (r7 != 0) goto L_0x00a2
            r7 = r5
        L_0x00a2:
            if (r17 == 0) goto L_0x00b7
            r9 = r17
            r10 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r11 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r9 = r9.select(r11)
            com.baidu.searchbox.video.feedflow.tab.TabState r9 = (com.baidu.searchbox.video.feedflow.tab.TabState) r9
            if (r9 == 0) goto L_0x00b7
            java.lang.String r9 = r9.getCurrentTabId()
            if (r9 != 0) goto L_0x00b8
        L_0x00b7:
            r9 = r5
        L_0x00b8:
            if (r17 == 0) goto L_0x00d2
            r5 = r17
            r10 = 0
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r11 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r5 = r5.select(r11)
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5
            if (r5 == 0) goto L_0x00d2
            org.json.JSONObject r5 = r5.extRequest
            if (r5 == 0) goto L_0x00d2
            java.lang.String r6 = "word"
            java.lang.String r6 = r5.optString(r6)
        L_0x00d2:
            if (r6 != 0) goto L_0x00d6
            r10 = r0
            goto L_0x00d7
        L_0x00d6:
            r10 = r6
        L_0x00d7:
            if (r17 == 0) goto L_0x00f5
            r5 = r17
            r6 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.FlowDetailState> r11 = com.baidu.searchbox.video.feedflow.detail.FlowDetailState.class
            java.lang.Object r5 = r5.select(r11)
            com.baidu.searchbox.video.feedflow.detail.FlowDetailState r5 = (com.baidu.searchbox.video.feedflow.detail.FlowDetailState) r5
            if (r5 == 0) goto L_0x00f5
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r5 = r5.getData()
            if (r5 == 0) goto L_0x00f5
            java.lang.String r5 = r5.getRequestAdParams()
            if (r5 != 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r11 = r5
            goto L_0x00f6
        L_0x00f5:
            r11 = r0
        L_0x00f6:
            com.baidu.searchbox.video.feedflow.ad.extra.request.NadExtraParam r13 = new com.baidu.searchbox.video.feedflow.ad.extra.request.NadExtraParam
            r12 = 0
            r14 = 64
            r15 = 0
            r0 = r13
            r5 = r7
            r6 = r9
            r7 = r12
            r9 = r10
            r10 = r11
            r11 = r14
            r12 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.ad.extra.request.NadExtraRequest.getRequestParam(com.baidu.searchbox.feed.detail.arch.ext.CommonState):com.baidu.searchbox.video.feedflow.ad.extra.request.NadExtraParam");
    }

    private final JSONObject getDa(CommonState state) {
        JSONObject extJson;
        IntentData intentData;
        String it;
        JSONObject buildCommonParams = IAdDeviceInfo.Impl.get().buildCommonParams();
        String requestExt = null;
        if (buildCommonParams == null) {
            return null;
        }
        JSONObject $this$getDa_u24lambda_u2d1 = buildCommonParams;
        boolean z = true;
        if (AdRedux.INSTANCE.isPaidInvoke(state)) {
            JSONUtils.put($this$getDa_u24lambda_u2d1, "is_external_invoke", 1);
        } else {
            JSONUtils.put($this$getDa_u24lambda_u2d1, "is_external_invoke", 0);
        }
        if (!(state == null || (intentData = (IntentData) state.select(IntentData.class)) == null || (it = intentData.extendBusiness) == null)) {
            try {
                requestExt = new JSONObject(it).optString("adRequestExt", "");
            } catch (JSONException e2) {
                String str = null;
            }
        }
        String ext = $this$getDa_u24lambda_u2d1.optString("ext", "");
        CharSequence charSequence = ext;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            extJson = new JSONObject();
        } else {
            extJson = JSONUtils.newJSONObject(ext);
            Intrinsics.checkNotNullExpressionValue(extJson, "newJSONObject(ext)");
        }
        CharSequence charSequence2 = requestExt;
        if (charSequence2 != null && !StringsKt.isBlank(charSequence2)) {
            z = false;
        }
        if (!z) {
            JSONUtils.put(extJson, "request_ext", requestExt);
        }
        JSONUtils.put(extJson, "session_start_time", String.valueOf(AdRedux.INSTANCE.getListState((AbsState) state).getSessionStartTime() / 1000));
        JSONUtils.put($this$getDa_u24lambda_u2d1, "ext", extJson.toString());
        return buildCommonParams;
    }
}
