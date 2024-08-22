package com.baidu.searchbox.sport.page.chatroom.repo.bim;

import com.baidu.searchbox.account.data.BoxAccount;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatSendMessage;
import com.baidu.searchbox.sport.page.chatroom.repo.bim.ChatMsgBuilder;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ChatMsgBuilder$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ChatMsgBuilder.BuildChatMsgCallback f$0;
    public final /* synthetic */ SportChatSendMessage f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ BoxAccount f$3;

    public /* synthetic */ ChatMsgBuilder$$ExternalSyntheticLambda1(ChatMsgBuilder.BuildChatMsgCallback buildChatMsgCallback, SportChatSendMessage sportChatSendMessage, long j2, BoxAccount boxAccount) {
        this.f$0 = buildChatMsgCallback;
        this.f$1 = sportChatSendMessage;
        this.f$2 = j2;
        this.f$3 = boxAccount;
    }

    public final void run() {
        ChatMsgBuilder.m3760buildChatMsg$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
