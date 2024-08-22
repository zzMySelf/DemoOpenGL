package com.baidu.searchbox.sport.page.chatroom.repo.restful;

import com.baidu.searchbox.sport.page.chatroom.model.SportChatSendMessage;
import com.baidu.searchbox.sport.repo.SportApiResult;
import rx.functions.Func1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RestfulChatRoomService$$ExternalSyntheticLambda4 implements Func1 {
    public final /* synthetic */ RestfulChatRoomService f$0;
    public final /* synthetic */ SportChatSendMessage f$1;

    public /* synthetic */ RestfulChatRoomService$$ExternalSyntheticLambda4(RestfulChatRoomService restfulChatRoomService, SportChatSendMessage sportChatSendMessage) {
        this.f$0 = restfulChatRoomService;
        this.f$1 = sportChatSendMessage;
    }

    public final Object call(Object obj) {
        return RestfulChatRoomService.m3793sendMessage$lambda7(this.f$0, this.f$1, (SportApiResult) obj);
    }
}
