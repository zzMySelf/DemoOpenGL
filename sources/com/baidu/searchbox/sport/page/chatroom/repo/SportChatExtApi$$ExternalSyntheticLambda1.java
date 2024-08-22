package com.baidu.searchbox.sport.page.chatroom.repo;

import rx.Single;
import rx.SingleSubscriber;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SportChatExtApi$$ExternalSyntheticLambda1 implements Single.OnSubscribe {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ SportChatExtApi f$2;

    public /* synthetic */ SportChatExtApi$$ExternalSyntheticLambda1(String str, String str2, SportChatExtApi sportChatExtApi) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = sportChatExtApi;
    }

    public final void call(Object obj) {
        SportChatExtApi.m3729reportUserEnter$lambda2(this.f$0, this.f$1, this.f$2, (SingleSubscriber) obj);
    }
}
