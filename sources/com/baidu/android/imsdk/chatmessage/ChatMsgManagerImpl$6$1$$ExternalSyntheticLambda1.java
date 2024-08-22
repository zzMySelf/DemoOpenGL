package com.baidu.android.imsdk.chatmessage;

import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.chatmessage.response.FetchMsgResponse;
import com.baidu.android.imsdk.group.BIMValueCallBack;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ChatMsgManagerImpl$6$1$$ExternalSyntheticLambda1 implements BIMValueCallBack {
    public final /* synthetic */ long f$0;

    public /* synthetic */ ChatMsgManagerImpl$6$1$$ExternalSyntheticLambda1(long j2) {
        this.f$0 = j2;
    }

    public final void onResult(int i2, String str, Object obj) {
        ChatMsgManagerImpl.AnonymousClass6.AnonymousClass1.lambda$run$1(this.f$0, i2, str, (FetchMsgResponse) obj);
    }
}
