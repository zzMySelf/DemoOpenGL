package com.baidu.searchbox.feed;

import com.baidu.searchbox.feed.FeedConfig;
import com.baidu.searchbox.feed.config.DefaultFeedTabConfigData;
import com.baidu.searchbox.feed.tab.navigation.constant.MultiTabItemPreSetData;

public class DefaultFeedConfigFactory implements IFeedConfigFactory {
    private static final String AD_PRODUCT_ID = "8";

    public FeedConfig.Module createModuleConfig() {
        return new FeedConfig.Module.Builder().needTTSModule(true).build();
    }

    public FeedConfig.AdConfig createAdConfig() {
        return new FeedConfig.AdConfig.Builder().setProductID("8").build();
    }

    public FeedConfig.Channel createChannelConfig() {
        return new FeedConfig.Channel.Builder().setAddedTabData(MultiTabItemPreSetData.getAddedTabData()).setUnAddedTabData(MultiTabItemPreSetData.getUnAddedTabData()).setForceOffLineTabData(MultiTabItemPreSetData.getForceOffLineTabData()).setForceInsertTabData(MultiTabItemPreSetData.getForceInsertTabData()).build();
    }

    public FeedConfig.Tab createTabConfig() {
        return new FeedConfig.Tab.Builder().setTextUi(DefaultFeedTabConfigData.getSelectedColor(), DefaultFeedTabConfigData.getUnselectedColor(), DefaultFeedTabConfigData.getTextSizeMode(), DefaultFeedTabConfigData.getNormalTextSize(), DefaultFeedTabConfigData.getSelectedTextSize(), DefaultFeedTabConfigData.getUnselectedTextSize(), true).setPlusUi(DefaultFeedTabConfigData.getPlusIconResId(), DefaultFeedTabConfigData.getPlusIconSize(), DefaultFeedTabConfigData.getPlusPadding()).setPlusIconVisibility(DefaultFeedTabConfigData.getPlusIconVisibility()).setTabAlign(DefaultFeedTabConfigData.getTabAlign()).setIndicatorUi(DefaultFeedTabConfigData.getIndicatorColor(), DefaultFeedTabConfigData.getIndicatorMargin()).build();
    }
}
