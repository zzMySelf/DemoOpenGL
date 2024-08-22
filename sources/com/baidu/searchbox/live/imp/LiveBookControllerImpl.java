package com.baidu.searchbox.live.imp;

import com.baidu.searchbox.live.interfaces.book.LiveBookControllerService;
import com.baidu.searchbox.player.layer.AbsLayer;
import com.baidu.searchbox.player.layer.SimpleControlLayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/live/imp/LiveBookControllerImpl;", "Lcom/baidu/searchbox/live/interfaces/book/LiveBookControllerService;", "()V", "createSimpleVideoController", "Lcom/baidu/searchbox/player/layer/AbsLayer;", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveBookControllerImpl.kt */
public final class LiveBookControllerImpl implements LiveBookControllerService {
    public AbsLayer createSimpleVideoController() {
        return new SimpleControlLayer();
    }
}
