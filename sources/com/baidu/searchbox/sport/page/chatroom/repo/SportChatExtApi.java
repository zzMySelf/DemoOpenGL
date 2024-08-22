package com.baidu.searchbox.sport.page.chatroom.repo;

import com.baidu.searchbox.sport.page.chatroom.ChatRoomFragment;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatModelFactory;
import com.baidu.searchbox.sport.page.chatroom.model.SportQuickModel;
import com.baidu.searchbox.sport.repo.SportApiResult;
import com.baidu.searchbox.sport.repo.SportApiService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.Single;
import rx.SingleSubscriber;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\"\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00070\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/repo/SportChatExtApi;", "Lcom/baidu/searchbox/sport/repo/SportApiService;", "isOlympic", "", "(Z)V", "getQuickChatData", "Lrx/Single;", "Lcom/baidu/searchbox/sport/repo/SportApiResult;", "Lcom/baidu/searchbox/sport/page/chatroom/model/SportQuickModel;", "chatId", "", "league", "reportUserEnter", "matchId", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SportChatExtApi.kt */
public final class SportChatExtApi extends SportApiService {
    private final boolean isOlympic;

    public SportChatExtApi(boolean isOlympic2) {
        this.isOlympic = isOlympic2;
    }

    public final Single<SportApiResult<SportQuickModel>> getQuickChatData(String chatId, String league) {
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        Intrinsics.checkNotNullParameter(league, "league");
        if (this.isOlympic) {
            String access$getOLYMPIC_GET_QUICK_LIST$p = SportChatExtApiKt.OLYMPIC_GET_QUICK_LIST;
        } else {
            String access$getGET_QUICK_LIST$p = SportChatExtApiKt.GET_QUICK_LIST;
        }
        Single<SportApiResult<SportQuickModel>> create = Single.create(new SportChatExtApi$$ExternalSyntheticLambda0(this, chatId, league));
        Intrinsics.checkNotNullExpressionValue(create, "create { subscriber ->\n …TA, subscriber)\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: getQuickChatData$lambda-1  reason: not valid java name */
    public static final void m3728getQuickChatData$lambda1(SportChatExtApi this$0, String $chatId, String $league, SingleSubscriber subscriber) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($chatId, "$chatId");
        Intrinsics.checkNotNullParameter($league, "$league");
        Map params = new LinkedHashMap();
        Map $this$getQuickChatData_u24lambda_u2d1_u24lambda_u2d0 = params;
        $this$getQuickChatData_u24lambda_u2d1_u24lambda_u2d0.put("chatid", $chatId);
        $this$getQuickChatData_u24lambda_u2d1_u24lambda_u2d0.put("league", $league);
        this$0.sendGetRequest(SportChatExtApiKt.OLYMPIC_GET_QUICK_LIST, params, SportChatModelFactory.GET_QUICK_CHAT_DATA, subscriber);
    }

    public final Single<SportApiResult<String>> reportUserEnter(String matchId, String league) {
        Intrinsics.checkNotNullParameter(matchId, ChatRoomFragment.INVOKE_PARAM_MATCH_ID);
        Intrinsics.checkNotNullParameter(league, "league");
        Single<SportApiResult<String>> create = Single.create(new SportChatExtApi$$ExternalSyntheticLambda1(matchId, league, this));
        Intrinsics.checkNotNullExpressionValue(create, "create { subscriber ->\n …r\n            )\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: reportUserEnter$lambda-2  reason: not valid java name */
    public static final void m3729reportUserEnter$lambda2(String $matchId, String $league, SportChatExtApi this$0, SingleSubscriber subscriber) {
        Intrinsics.checkNotNullParameter($matchId, "$matchId");
        Intrinsics.checkNotNullParameter($league, "$league");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap bodyParams = new HashMap();
        bodyParams.put(ChatRoomFragment.INVOKE_PARAM_MATCH_ID, $matchId);
        bodyParams.put("league", $league);
        this$0.sendPostFormRequest(SportChatExtApiKt.POST_WELCOME_URL, bodyParams, SportChatModelFactory.POST_WELCOME_DATA, subscriber);
    }
}
