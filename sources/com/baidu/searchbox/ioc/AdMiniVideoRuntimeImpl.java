package com.baidu.searchbox.ioc;

import com.baidu.searchbox.ad.IAdMiniVideoRuntime;
import com.baidu.searchbox.feed.ad.model.MiniVideoDynamicConfig;
import com.baidu.searchbox.feed.ad.model.VoteLottieResource;
import com.baidu.searchbox.util.MiniVideoConfigUtils;

public class AdMiniVideoRuntimeImpl implements IAdMiniVideoRuntime {
    public boolean isInAsynWhiteList(String realPd) {
        return MiniVideoConfigUtils.INSTANCE.isInWhiteList(realPd);
    }

    public String getWhiteList() {
        return MiniVideoConfigUtils.INSTANCE.getWhiteListStr();
    }

    public int getMinFloorForRequest() {
        return MiniVideoConfigUtils.INSTANCE.getMinFloorForRequest();
    }

    public VoteLottieResource getVoteLottieRes() {
        return MiniVideoConfigUtils.INSTANCE.getVoteLottieResource();
    }

    public MiniVideoDynamicConfig getDynamicConfig() {
        return MiniVideoConfigUtils.INSTANCE.getDynamicInsertConfig();
    }
}
