package com.baidu.searchbox.sport.page.match.repo;

import android.text.TextUtils;
import com.baidu.searchbox.sport.model.CommonModelFactory;
import com.baidu.searchbox.sport.model.MatchInfo;
import com.baidu.searchbox.sport.page.chatroom.ChatRoomFragment;
import com.baidu.searchbox.sport.page.match.model.MatchModelFactory;
import com.baidu.searchbox.sport.page.match.model.MatchPageModel;
import com.baidu.searchbox.sport.repo.SportApiResult;
import com.baidu.searchbox.sport.repo.SportApiService;
import java.util.HashMap;
import java.util.Map;
import rx.Single;
import rx.SingleSubscriber;

class SportMatchApiService extends SportApiService {
    private static final String GET_MATCH_HEAD = (getApiEnv() + "/sports/api/live/head");
    /* access modifiers changed from: private */
    public static final String REFRESH_MATCH_INFO = (getApiEnv() + "/sports/api/live/refresh");

    SportMatchApiService() {
    }

    /* access modifiers changed from: package-private */
    public Single<SportApiResult<MatchPageModel>> getMatchPageModel(String matchId, String tabName, Map<String, String> requestParams) {
        return Single.create(new SportMatchApiService$$ExternalSyntheticLambda0(this, requestParams, matchId, tabName));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getMatchPageModel$0$com-baidu-searchbox-sport-page-match-repo-SportMatchApiService  reason: not valid java name */
    public /* synthetic */ void m3926lambda$getMatchPageModel$0$combaidusearchboxsportpagematchrepoSportMatchApiService(Map requestParams, String matchId, String tabName, SingleSubscriber subscriber) {
        HashMap hashMap = new HashMap(requestParams);
        hashMap.put(ChatRoomFragment.INVOKE_PARAM_MATCH_ID, matchId);
        if (!TextUtils.isEmpty(tabName)) {
            hashMap.put("tab", tabName);
        }
        sendPostFormRequest(GET_MATCH_HEAD, (Map<String, String>) null, hashMap, (Map<String, String>) null, MatchModelFactory.GET_MATCH_HEAD, subscriber, true);
    }

    /* access modifiers changed from: package-private */
    public Single<SportApiResult<MatchInfo>> getMatchInfo(final String matchId) {
        return Single.create(new Single.OnSubscribe<SportApiResult<MatchInfo>>() {
            public void call(SingleSubscriber<? super SportApiResult<MatchInfo>> subscriber) {
                Map<String, String> params = new HashMap<>();
                params.put(ChatRoomFragment.INVOKE_PARAM_MATCH_ID, matchId);
                SportMatchApiService.this.sendPostFormRequest(SportMatchApiService.REFRESH_MATCH_INFO, params, CommonModelFactory.PARSE_MATCH_INFO, subscriber);
            }
        });
    }
}
