package com.baidu.searchbox.player.helper;

import com.baidu.cyberplayer.sdk.context.ICyberPlayConfig;
import com.baidu.searchbox.player.config.CyberConfigUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/player/helper/CyberConfigImp;", "Lcom/baidu/cyberplayer/sdk/context/ICyberPlayConfig;", "()V", "getConfigContent", "", "getConfigFileName", "lib-player-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BdCyberMediaContext.kt */
public final class CyberConfigImp implements ICyberPlayConfig {
    public String getConfigFileName() {
        return "";
    }

    public String getConfigContent() {
        return CyberConfigUtils.getCyberConfig();
    }
}
