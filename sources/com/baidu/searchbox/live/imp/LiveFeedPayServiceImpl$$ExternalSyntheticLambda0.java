package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.feed.payment.PayResponseCallback;
import java.util.Map;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LiveFeedPayServiceImpl$$ExternalSyntheticLambda0 implements PayResponseCallback {
    public final /* synthetic */ Function3 f$0;

    public /* synthetic */ LiveFeedPayServiceImpl$$ExternalSyntheticLambda0(Function3 function3) {
        this.f$0 = function3;
    }

    public final void onResponse(boolean z, Object obj, Exception exc) {
        LiveFeedPayServiceImpl.m148doSendRequestAsyncIsInShelf$lambda3(this.f$0, z, (Map) obj, exc);
    }
}
