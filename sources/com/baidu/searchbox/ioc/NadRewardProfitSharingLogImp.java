package com.baidu.searchbox.ioc;

import com.baidu.nadcore.lp.reward.ioc.INadRewardProfitSharingLog;
import com.baidu.pyramid.annotation.ServiceProvider;
import com.baidu.pyramid.runtime.service.CachedServiceFetcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/ioc/NadRewardProfitSharingLogImp;", "Lcom/baidu/pyramid/runtime/service/CachedServiceFetcher;", "Lcom/baidu/nadcore/lp/reward/ioc/INadRewardProfitSharingLog;", "()V", "createService", "ubcContentJson", "Lorg/json/JSONObject;", "adExt", "", "lib-ad-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ServiceProvider(module = "nad.core", name = "profitSharingLog")
/* compiled from: NadRewardProfitSharingLogImp.kt */
public final class NadRewardProfitSharingLogImp extends CachedServiceFetcher<INadRewardProfitSharingLog> {
    /* access modifiers changed from: protected */
    public INadRewardProfitSharingLog createService() {
        return new NadRewardProfitSharingLogImp$createService$1(this);
    }

    /* access modifiers changed from: private */
    public final JSONObject ubcContentJson(String adExt) {
        JSONObject contentJson = new JSONObject();
        if (adExt.length() == 0) {
            return contentJson;
        }
        try {
            JSONObject $this$ubcContentJson_u24lambda_u2d0 = new JSONObject();
            $this$ubcContentJson_u24lambda_u2d0.putOpt("ad_ext", adExt);
            String ext = $this$ubcContentJson_u24lambda_u2d0.toString();
            Intrinsics.checkNotNullExpressionValue(ext, "JSONObject().apply {\n   …\n            }.toString()");
            contentJson.putOpt("ext", ext);
        } catch (JSONException e2) {
        }
        return contentJson;
    }
}
