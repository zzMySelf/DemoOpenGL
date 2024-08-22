package com.baidu.searchbox.feed.tab.navigation.utils;

import com.baidu.searchbox.feed.widget.tabfloat.TabDefaultSettingModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedTabDefaultSettingDataManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ FeedTabDefaultSettingDataManager f$0;
    public final /* synthetic */ TabDefaultSettingModel f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ FeedTabDefaultSettingDataManager$$ExternalSyntheticLambda0(FeedTabDefaultSettingDataManager feedTabDefaultSettingDataManager, TabDefaultSettingModel tabDefaultSettingModel, String str) {
        this.f$0 = feedTabDefaultSettingDataManager;
        this.f$1 = tabDefaultSettingModel;
        this.f$2 = str;
    }

    public final void run() {
        FeedTabDefaultSettingDataManager.m19381loadTabDefaultSettingFromFile$lambda2$lambda1$lambda0(this.f$0, this.f$1, this.f$2);
    }
}
