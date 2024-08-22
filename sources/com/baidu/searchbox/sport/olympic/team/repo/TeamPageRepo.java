package com.baidu.searchbox.sport.olympic.team.repo;

import com.baidu.searchbox.sport.olympic.team.model.TeamModel;
import com.baidu.searchbox.sport.repo.SportApiResult;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;
import rx.SingleSubscriber;
import rx.subjects.ReplaySubject;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011J>\u0010\u0012\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/team/repo/TeamPageRepo;", "", "teamId", "", "(Ljava/lang/String;)V", "activePreloads", "", "Lrx/subjects/ReplaySubject;", "Lcom/baidu/searchbox/sport/repo/SportApiResult;", "Lcom/baidu/searchbox/sport/olympic/team/model/TeamModel;", "apiService", "Lcom/baidu/searchbox/sport/olympic/team/repo/TeamPageApiService;", "getTeamPageInfo", "Lrx/Single;", "tabId", "current", "requestParams", "", "preloadTeamPageModel", "", "subscriber", "Lrx/SingleSubscriber;", "Companion", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TeamPageRepo.kt */
public final class TeamPageRepo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Map<String, TeamPageRepo> PRE_CREATED = new LinkedHashMap();
    private final Map<String, ReplaySubject<SportApiResult<TeamModel>>> activePreloads = new LinkedHashMap();
    private final TeamPageApiService apiService = new TeamPageApiService();
    private final String teamId;

    public TeamPageRepo(String teamId2) {
        Intrinsics.checkNotNullParameter(teamId2, "teamId");
        this.teamId = teamId2;
    }

    public final void preloadTeamPageModel(String tabId, String current, Map<String, String> requestParams, SingleSubscriber<TeamModel> subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        ReplaySubject replay = ReplaySubject.create();
        Intrinsics.checkNotNullExpressionValue(replay, "create()");
        this.activePreloads.put(this.teamId, replay);
        this.apiService.getTeamPageModel(this.teamId, tabId, current, requestParams).subscribe(new TeamPageRepo$$ExternalSyntheticLambda1(subscriber, replay), new TeamPageRepo$$ExternalSyntheticLambda2(subscriber, replay));
    }

    /* access modifiers changed from: private */
    /* renamed from: preloadTeamPageModel$lambda-0  reason: not valid java name */
    public static final void m3601preloadTeamPageModel$lambda0(SingleSubscriber $subscriber, ReplaySubject $replay, SportApiResult it) {
        Intrinsics.checkNotNullParameter($subscriber, "$subscriber");
        Intrinsics.checkNotNullParameter($replay, "$replay");
        $subscriber.onSuccess(it.getData());
        $replay.onNext(it);
        $replay.onCompleted();
    }

    /* access modifiers changed from: private */
    /* renamed from: preloadTeamPageModel$lambda-1  reason: not valid java name */
    public static final void m3602preloadTeamPageModel$lambda1(SingleSubscriber $subscriber, ReplaySubject $replay, Throwable it) {
        Intrinsics.checkNotNullParameter($subscriber, "$subscriber");
        Intrinsics.checkNotNullParameter($replay, "$replay");
        $subscriber.onError(it);
        $replay.onError(it);
    }

    public final Single<TeamModel> getTeamPageInfo(String tabId, String current, Map<String, String> requestParams) {
        ReplaySubject replay = this.activePreloads.remove(this.teamId);
        Single single = replay != null ? replay.toSingle() : null;
        if (single == null) {
            single = this.apiService.getTeamPageModel(this.teamId, tabId, current, requestParams);
        }
        Single<R> map = single.map(new TeamPageRepo$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNullExpressionValue(map, "single.map { it.data }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getTeamPageInfo$lambda-2  reason: not valid java name */
    public static final TeamModel m3600getTeamPageInfo$lambda2(SportApiResult it) {
        return (TeamModel) it.getData();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0005R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/sport/olympic/team/repo/TeamPageRepo$Companion;", "", "()V", "PRE_CREATED", "", "", "Lcom/baidu/searchbox/sport/olympic/team/repo/TeamPageRepo;", "of", "teamId", "preCreate", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TeamPageRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TeamPageRepo preCreate(String teamId) {
            Intrinsics.checkNotNullParameter(teamId, "teamId");
            TeamPageRepo.PRE_CREATED.remove(teamId);
            TeamPageRepo repo = new TeamPageRepo(teamId);
            TeamPageRepo.PRE_CREATED.put(teamId, repo);
            return repo;
        }

        public final TeamPageRepo of(String teamId) {
            Intrinsics.checkNotNullParameter(teamId, "teamId");
            TeamPageRepo teamPageRepo = (TeamPageRepo) TeamPageRepo.PRE_CREATED.remove(teamId);
            return teamPageRepo == null ? new TeamPageRepo(teamId) : teamPageRepo;
        }
    }
}
