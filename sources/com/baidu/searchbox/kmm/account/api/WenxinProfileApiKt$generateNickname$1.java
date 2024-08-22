package com.baidu.searchbox.kmm.account.api;

import com.baidu.searchbox.kmm.account.entities.WenxinProfileResultModel;
import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonElement;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.foundation.network.HttpPostBodyType;
import com.baidu.searchbox.kmm.foundation.network.HttpRequest;
import com.baidu.searchbox.kmm.foundation.network.URLComposerKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WenxinProfileApi.kt */
final class WenxinProfileApiKt$generateNickname$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<WenxinProfileResultModel, Unit> $callback;
    final /* synthetic */ String $content;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WenxinProfileApiKt$generateNickname$1(String str, Function1<? super WenxinProfileResultModel, Unit> function1) {
        super(0);
        this.$content = str;
        this.$callback = function1;
    }

    public final void invoke() {
        String url = URLComposerKt.makeFullURL("/collect/nick/ai/create");
        Map mapOf = MapsKt.mapOf(TuplesKt.to("prompt", this.$content));
        HttpPostBodyType httpPostBodyType = HttpPostBodyType.URL_PARAMS;
        final Function1<WenxinProfileResultModel, Unit> function1 = this.$callback;
        final Function1<WenxinProfileResultModel, Unit> function12 = this.$callback;
        HttpRequest.doPOST$default(url, mapOf, httpPostBodyType, false, (Integer) null, (Integer) null, new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((String) p1);
                return Unit.INSTANCE;
            }

            public final void invoke(String it) {
                JsonObject obj = it != null ? JsonUtilKt.toJsonObject(it) : null;
                Integer errNum = obj != null ? Integer.valueOf(JsonUtilKt.getInt$default(obj, "errno", 0, 2, (Object) null)) : null;
                if (obj == null || errNum == null || WenxinProfileApiKt.isRequestError(errNum.intValue())) {
                    Function1 it2 = function1;
                    if (it2 != null) {
                        BackgroundTaskUtilsKt.mainWork(new WenxinProfileApiKt$generateNickname$1$1$1$1(it2));
                        return;
                    }
                    return;
                }
                WenxinProfileResultModel resultModel = new WenxinProfileResultModel();
                resultModel.decodeNickname$com_baidu_searchbox_kmm_business_account(JsonUtilKt.getJsonObject((JsonElement) obj, "data"), errNum.intValue(), JsonUtilKt.getString$default(obj, "errmsg", (String) null, 2, (Object) null));
                Function1 it3 = function1;
                if (it3 != null) {
                    BackgroundTaskUtilsKt.mainWork(new WenxinProfileApiKt$generateNickname$1$1$2$1(it3, resultModel));
                }
            }
        }, new Function2<Integer, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                invoke(((Number) p1).intValue(), (String) p2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, String str) {
                Function1 it = function12;
                if (it != null) {
                    BackgroundTaskUtilsKt.mainWork(new WenxinProfileApiKt$generateNickname$1$2$1$1(it));
                }
            }
        }, (Function2) null, 0.0f, 20.0d, 824, (Object) null);
    }
}
