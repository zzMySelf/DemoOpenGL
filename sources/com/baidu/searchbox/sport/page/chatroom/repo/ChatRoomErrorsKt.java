package com.baidu.searchbox.sport.page.chatroom.repo;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.push.MessageStatistic;
import com.baidu.searchbox.sport.R;
import com.baidu.searchbox.sport.repo.SportApiException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0006\u0010\u0006\u001a\u00020\u0005\u001a\u0010\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u001a\n\u0010\t\u001a\u00020\n*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"ERROR_NOT_LOGIN", "", "ERROR_ROOM_CLOSED", "ERROR_ROOM_NOT_FOUND", "errorNotLogin", "Lcom/baidu/searchbox/sport/repo/SportApiException;", "errorRoomClosed", "queryLikeDataError", "errorMsg", "isRoomClosed", "", "lib-search-sport_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatRoomErrors.kt */
public final class ChatRoomErrorsKt {
    public static final String ERROR_NOT_LOGIN = "1000";
    public static final String ERROR_ROOM_CLOSED = "2001";
    public static final String ERROR_ROOM_NOT_FOUND = "404";

    public static final SportApiException errorRoomClosed() {
        return new SportApiException("2001", AppRuntime.getAppContext().getString(R.string.sport_chatroom_closed));
    }

    public static final SportApiException errorNotLogin() {
        return new SportApiException("1000", "未登录");
    }

    public static final boolean isRoomClosed(SportApiException $this$isRoomClosed) {
        Intrinsics.checkNotNullParameter($this$isRoomClosed, "<this>");
        return Intrinsics.areEqual((Object) $this$isRoomClosed.getStatus(), (Object) "2001");
    }

    public static final SportApiException queryLikeDataError(String errorMsg) {
        return new SportApiException(MessageStatistic.UBC_ICON_BADGE_COUNT_CHANGE, errorMsg == null ? "点赞查询错误" : errorMsg);
    }
}
