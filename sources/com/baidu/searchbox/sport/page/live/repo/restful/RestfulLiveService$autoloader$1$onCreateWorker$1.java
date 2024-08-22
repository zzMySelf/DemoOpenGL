package com.baidu.searchbox.sport.page.live.repo.restful;

import com.baidu.searchbox.sport.page.live.model.PicTextLiveMessage;
import com.baidu.searchbox.sport.page.live.model.PicTextLiveModel;
import com.baidu.searchbox.sport.repo.SportApiAutoloader;
import com.baidu.searchbox.sport.repo.SportApiResult;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/sport/page/live/repo/restful/RestfulLiveService$autoloader$1$onCreateWorker$1", "Lcom/baidu/searchbox/sport/repo/SportApiAutoloader$AutoLoadWorker;", "Lcom/baidu/searchbox/sport/page/live/model/PicTextLiveModel;", "autoLoadNext", "Lrx/Single;", "lastResult", "getInterval", "", "result", "isResultValid", "", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RestfulLiveService.kt */
public final class RestfulLiveService$autoloader$1$onCreateWorker$1 implements SportApiAutoloader.AutoLoadWorker<PicTextLiveModel> {
    final /* synthetic */ RestfulLiveService this$0;

    RestfulLiveService$autoloader$1$onCreateWorker$1(RestfulLiveService $receiver) {
        this.this$0 = $receiver;
    }

    public long getInterval(PicTextLiveModel result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return result.getRefreshInterval();
    }

    public boolean isResultValid(PicTextLiveModel result) {
        Intrinsics.checkNotNullParameter(result, "result");
        Collection messages = result.getMessages();
        return !(messages == null || messages.isEmpty());
    }

    public Single<PicTextLiveModel> autoLoadNext(PicTextLiveModel lastResult) {
        Intrinsics.checkNotNullParameter(lastResult, "lastResult");
        List<PicTextLiveMessage> messages = lastResult.getMessages();
        PicTextLiveMessage lastMessage = messages != null ? (PicTextLiveMessage) CollectionsKt.lastOrNull(messages) : null;
        if (lastMessage != null) {
            Single<R> map = this.this$0.webService.getNewMessages(this.this$0.roomId, lastMessage).map(new RestfulLiveService$autoloader$1$onCreateWorker$1$$ExternalSyntheticLambda0());
            Intrinsics.checkNotNullExpressionValue(map, "{\n                      …                        }");
            return map;
        }
        Single<R> map2 = this.this$0.webService.getInitialMessages(this.this$0.roomId).map(new RestfulLiveService$autoloader$1$onCreateWorker$1$$ExternalSyntheticLambda1());
        Intrinsics.checkNotNullExpressionValue(map2, "{\n                      …                        }");
        return map2;
    }

    /* access modifiers changed from: private */
    /* renamed from: autoLoadNext$lambda-0  reason: not valid java name */
    public static final PicTextLiveModel m3906autoLoadNext$lambda0(SportApiResult it) {
        return (PicTextLiveModel) it.getData();
    }

    /* access modifiers changed from: private */
    /* renamed from: autoLoadNext$lambda-1  reason: not valid java name */
    public static final PicTextLiveModel m3907autoLoadNext$lambda1(SportApiResult it) {
        return (PicTextLiveModel) it.getData();
    }
}
