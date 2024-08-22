package com.baidu.chatsearch.aicall.comps.player.cb;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\"\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010\t\u001a\u00020\u0003H'¨\u0006\n"}, d2 = {"Lcom/baidu/chatsearch/aicall/comps/player/cb/IAIVideoCallback;", "", "onCompletion", "", "onError", "what", "", "extra", "o", "onPrepared", "lib-chatsearch-aicall-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IAIVideoCallback.kt */
public interface IAIVideoCallback {
    void onCompletion();

    void onError(int i2, int i3, Object obj);

    void onPrepared();
}
