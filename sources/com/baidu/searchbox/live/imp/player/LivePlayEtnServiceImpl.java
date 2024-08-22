package com.baidu.searchbox.live.imp.player;

import com.baidu.searchbox.live.etn.EtnPlayManager;
import com.baidu.searchbox.live.interfaces.service.ILivePlayEtnService;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/imp/player/LivePlayEtnServiceImpl;", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayEtnService;", "()V", "initEtnSdk", "", "listener", "Lcom/baidu/searchbox/live/interfaces/service/ILivePlayEtnService$InitListener;", "transEtnUrl", "", "url", "lib-feed-live_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LivePlayEtnServiceImpl.kt */
public final class LivePlayEtnServiceImpl implements ILivePlayEtnService {
    public void initEtnSdk(ILivePlayEtnService.InitListener listener) {
        EtnPlayManager.INSTANCE.initEtn(listener);
    }

    public String transEtnUrl(String url) {
        return EtnPlayManager.INSTANCE.getEtnUrl(url);
    }
}
