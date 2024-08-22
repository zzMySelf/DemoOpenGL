package com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim;

import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.player.config.PlayerConfig;
import com.baidu.searchbox.video.feedflow.common.FlowSwitchState;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/panelBgmAndAnim/CardBgmPlayerConfigHelper;", "", "()V", "bgmPlayerConfig", "Lcom/baidu/searchbox/player/config/PlayerConfig;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardBgmPlayerConfigHelper.kt */
public final class CardBgmPlayerConfigHelper {
    public static final CardBgmPlayerConfigHelper INSTANCE = new CardBgmPlayerConfigHelper();

    private CardBgmPlayerConfigHelper() {
    }

    public final PlayerConfig bgmPlayerConfig(Store<AbsState> store) {
        DIFactory dIFactory = DIFactory.INSTANCE;
        String str = null;
        String page = UBCManifestKt.getPage(store != null ? store.getState() : null);
        AbsState state = store != null ? store.getState() : null;
        if (store != null) {
            AbsState state2 = store.getState();
            CommonState commonState = state2 instanceof CommonState ? (CommonState) state2 : null;
            FlowSwitchState flowSwitchState = (FlowSwitchState) (commonState != null ? commonState.select(FlowSwitchState.class) : null);
            if (flowSwitchState != null) {
                str = flowSwitchState.getMutePropertyGroupName();
            }
        }
        if (str == null) {
            str = "";
        }
        return dIFactory.getPlayerConfig("", CardBgmPlayerConfigHelper$bgmPlayerConfig$1.INSTANCE, page, str, state, "");
    }
}
