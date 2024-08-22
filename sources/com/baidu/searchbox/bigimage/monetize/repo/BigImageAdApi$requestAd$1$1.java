package com.baidu.searchbox.bigimage.monetize.repo;

import com.baidu.searchbox.bigimage.monetize.model.BigImageAdApiResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BigImageAdApi.kt */
final class BigImageAdApi$requestAd$1$1 extends Lambda implements Function1<String, Object> {
    final /* synthetic */ BigImageAdApi this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BigImageAdApi$requestAd$1$1(BigImageAdApi bigImageAdApi) {
        super(1);
        this.this$0 = bigImageAdApi;
    }

    public final Object invoke(String data) {
        if (data != null) {
            if (!(data.length() == 0)) {
                return this.this$0.parseAdResult(new JSONObject(data));
            }
        }
        BigImageAdApiResult bigImageAdApiResult = null;
        return null;
    }
}
