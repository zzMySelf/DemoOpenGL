package com.baidu.searchbox.live.model.net;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J!\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00018\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/live/model/net/MixNetCallback;", "T", "", "onNetResponse", "", "res", "Lcom/baidu/searchbox/live/interfaces/net/NetResponse;", "resData", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;Ljava/lang/Object;)V", "onParseResponseInBackground", "(Lcom/baidu/searchbox/live/interfaces/net/NetResponse;)Ljava/lang/Object;", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: MixNetCallback.kt */
public interface MixNetCallback<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
