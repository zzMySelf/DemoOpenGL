package com.baidu.searchbox.video.feedflow.tab;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/tab/SecondaryPanelVisibleModel;", "", "isShow", "", "withAnim", "tabInfoModel", "Lcom/baidu/searchbox/video/feedflow/tab/TabInfoModel;", "(ZZLcom/baidu/searchbox/video/feedflow/tab/TabInfoModel;)V", "()Z", "getTabInfoModel", "()Lcom/baidu/searchbox/video/feedflow/tab/TabInfoModel;", "getWithAnim", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TabState.kt */
public final class SecondaryPanelVisibleModel {
    private final boolean isShow;
    private final TabInfoModel tabInfoModel;
    private final boolean withAnim;

    public SecondaryPanelVisibleModel(boolean isShow2, boolean withAnim2, TabInfoModel tabInfoModel2) {
        this.isShow = isShow2;
        this.withAnim = withAnim2;
        this.tabInfoModel = tabInfoModel2;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final boolean getWithAnim() {
        return this.withAnim;
    }

    public final TabInfoModel getTabInfoModel() {
        return this.tabInfoModel;
    }
}
