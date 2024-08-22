package com.baidu.searchbox.sport.page.generallive.repo;

import com.baidu.searchbox.sport.page.generallive.model.GeneralLivePageModel;
import com.baidu.searchbox.sport.page.match.model.DataSource;
import com.baidu.searchbox.sport.repo.SportApiResult;
import com.baidu.searchbox.ugc.aivideo.AiVideoActivityCreateHttpTask;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;
import rx.SingleSubscriber;
import rx.subjects.ReplaySubject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0002J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011J2\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/sport/page/generallive/repo/GeneralLiveRepo;", "", "eventId", "", "(Ljava/lang/String;)V", "activePreLoader", "", "Lrx/subjects/ReplaySubject;", "Lcom/baidu/searchbox/sport/repo/SportApiResult;", "Lcom/baidu/searchbox/sport/page/generallive/model/GeneralLivePageModel;", "liveService", "Lcom/baidu/searchbox/sport/page/generallive/repo/GeneralLiveApiService;", "getLoaderKey", "tabName", "getPageModel", "Lrx/Single;", "requestParams", "", "preLoadPageModel", "", "subscriber", "Lrx/SingleSubscriber;", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GeneralLiveRepo.kt */
public final class GeneralLiveRepo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map<String, GeneralLiveRepo> PRE_CREATED = new LinkedHashMap();
    private final Map<String, ReplaySubject<SportApiResult<GeneralLivePageModel>>> activePreLoader;
    private final String eventId;
    private final GeneralLiveApiService liveService;

    public /* synthetic */ GeneralLiveRepo(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private GeneralLiveRepo(String eventId2) {
        this.eventId = eventId2;
        this.liveService = new GeneralLiveApiService();
        this.activePreLoader = new LinkedHashMap();
    }

    public final void preLoadPageModel(String tabName, Map<String, String> requestParams, SingleSubscriber<GeneralLivePageModel> subscriber) {
        Intrinsics.checkNotNullParameter(requestParams, AiVideoActivityCreateHttpTask.REQUEST_PARAMS);
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        ReplaySubject replay = ReplaySubject.create();
        Map<String, ReplaySubject<SportApiResult<GeneralLivePageModel>>> map = this.activePreLoader;
        String loaderKey = getLoaderKey(tabName);
        Intrinsics.checkNotNullExpressionValue(replay, "replay");
        map.put(loaderKey, replay);
        this.liveService.getLivePageModel(this.eventId, tabName, requestParams).subscribe(new GeneralLiveRepo$$ExternalSyntheticLambda1(subscriber, replay), new GeneralLiveRepo$$ExternalSyntheticLambda2(subscriber, replay));
    }

    /* access modifiers changed from: private */
    /* renamed from: preLoadPageModel$lambda-0  reason: not valid java name */
    public static final void m3817preLoadPageModel$lambda0(SingleSubscriber $subscriber, ReplaySubject $replay, SportApiResult result) {
        Intrinsics.checkNotNullParameter($subscriber, "$subscriber");
        $subscriber.onSuccess(result.getData());
        $replay.onNext(result);
        $replay.onCompleted();
    }

    /* access modifiers changed from: private */
    /* renamed from: preLoadPageModel$lambda-1  reason: not valid java name */
    public static final void m3818preLoadPageModel$lambda1(SingleSubscriber $subscriber, ReplaySubject $replay, Throwable it) {
        Intrinsics.checkNotNullParameter($subscriber, "$subscriber");
        $subscriber.onError(it);
        $replay.onError(it);
    }

    public final Single<GeneralLivePageModel> getPageModel(String tabName, Map<String, String> requestParams) {
        Intrinsics.checkNotNullParameter(requestParams, AiVideoActivityCreateHttpTask.REQUEST_PARAMS);
        ReplaySubject replay = this.activePreLoader.remove(getLoaderKey(tabName));
        Single single = replay != null ? replay.toSingle() : null;
        if (single == null) {
            single = this.liveService.getLivePageModel(this.eventId, tabName, requestParams);
        }
        Single<R> map = single.map(new GeneralLiveRepo$$ExternalSyntheticLambda0(replay));
        Intrinsics.checkNotNullExpressionValue(map, "single.map { result ->\n …R\n            }\n        }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getPageModel$lambda-3  reason: not valid java name */
    public static final GeneralLivePageModel m3816getPageModel$lambda3(ReplaySubject $replay, SportApiResult result) {
        Object data = result.getData();
        Intrinsics.checkNotNullExpressionValue(data, "result.data");
        GeneralLivePageModel model = (GeneralLivePageModel) data;
        model.setDataSource($replay != null ? DataSource.PREFETCH : DataSource.SERVER);
        return model;
    }

    private final String getLoaderKey(String tabName) {
        CharSequence charSequence = tabName;
        return this.eventId + (charSequence == null || charSequence.length() == 0 ? "" : tabName);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/sport/page/generallive/repo/GeneralLiveRepo$Companion;", "", "()V", "PRE_CREATED", "", "", "Lcom/baidu/searchbox/sport/page/generallive/repo/GeneralLiveRepo;", "of", "eventId", "preCreate", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GeneralLiveRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GeneralLiveRepo of(String eventId) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            GeneralLiveRepo repo = (GeneralLiveRepo) GeneralLiveRepo.PRE_CREATED.remove(eventId);
            if (repo == null) {
                return new GeneralLiveRepo(eventId, (DefaultConstructorMarker) null);
            }
            return repo;
        }

        public final GeneralLiveRepo preCreate(String eventId) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            GeneralLiveRepo.PRE_CREATED.remove(eventId);
            GeneralLiveRepo $this$preCreate_u24lambda_u2d0 = new GeneralLiveRepo(eventId, (DefaultConstructorMarker) null);
            GeneralLiveRepo.PRE_CREATED.put(eventId, $this$preCreate_u24lambda_u2d0);
            return $this$preCreate_u24lambda_u2d0;
        }
    }
}
