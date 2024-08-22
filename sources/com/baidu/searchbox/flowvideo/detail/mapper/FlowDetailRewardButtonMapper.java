package com.baidu.searchbox.flowvideo.detail.mapper;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.api.FlowDetailAuthorBean;
import com.baidu.searchbox.flowvideo.detail.api.FlowDetailBean;
import com.baidu.searchbox.flowvideo.detail.api.RewardBean;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailRewardButtonModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/flowvideo/detail/mapper/FlowDetailRewardButtonMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/detail/api/FlowDetailBean;", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailRewardButtonModel;", "()V", "map", "input", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowDetailRewardButtonMapper.kt */
public final class FlowDetailRewardButtonMapper implements Mapper<FlowDetailBean, FlowDetailRewardButtonModel> {
    public static final FlowDetailRewardButtonMapper INSTANCE = new FlowDetailRewardButtonMapper();

    private FlowDetailRewardButtonMapper() {
    }

    public FlowDetailRewardButtonModel map(FlowDetailBean input) {
        String str = null;
        if (input == null) {
            return null;
        }
        FlowDetailBean bean = input;
        RewardBean rewardButton = bean.getRewardButton();
        String type = rewardButton != null ? rewardButton.getType() : null;
        RewardBean rewardButton2 = bean.getRewardButton();
        String text = rewardButton2 != null ? rewardButton2.getText() : null;
        RewardBean rewardButton3 = bean.getRewardButton();
        int isRewarded = rewardButton3 != null ? rewardButton3.isRewarded() : -1;
        RewardBean rewardButton4 = bean.getRewardButton();
        int displayPercent = rewardButton4 != null ? rewardButton4.getDisplayPercent() : -1;
        RewardBean rewardButton5 = bean.getRewardButton();
        int enhanceTime = rewardButton5 != null ? rewardButton5.getEnhanceTime() : -1;
        RewardBean rewardButton6 = bean.getRewardButton();
        String icon = rewardButton6 != null ? rewardButton6.getIcon() : null;
        RewardBean rewardButton7 = bean.getRewardButton();
        String cmd = rewardButton7 != null ? rewardButton7.getCmd() : null;
        FlowDetailAuthorBean author = bean.getAuthor();
        if (author != null) {
            str = author.getId();
        }
        return new FlowDetailRewardButtonModel(type, text, isRewarded, displayPercent, enhanceTime, icon, cmd, str);
    }
}
