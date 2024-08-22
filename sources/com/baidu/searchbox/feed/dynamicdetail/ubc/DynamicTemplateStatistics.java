package com.baidu.searchbox.feed.dynamicdetail.ubc;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.template.statistic.TemplateStatisticsAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J&\u0010\u000f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\u0011\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J$\u0010\u0016\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u0017\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0019\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\"\u0010\u001a\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J6\u0010\u001d\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/feed/dynamicdetail/ubc/DynamicTemplateStatistics;", "Lcom/baidu/searchbox/feed/template/statistic/TemplateStatisticsAdapter;", "source", "", "strategyType", "(Ljava/lang/String;Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "getStrategyType", "dislikeClick", "", "business", "baseModel", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "feedbackClick", "forwardClick", "originType", "imgAutoPlayIndex", "index", "", "isRepost", "", "imgBannerSlide", "insideCardClick", "ext", "picClick", "poiClick", "poiExt", "relatedContentClick", "videoClick", "isPlaying", "time", "lib-feed-dynamic-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicTemplateStatistics.kt */
public final class DynamicTemplateStatistics extends TemplateStatisticsAdapter {
    private final String source;
    private final String strategyType;

    public DynamicTemplateStatistics(String source2, String strategyType2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        this.source = source2;
        this.strategyType = strategyType2;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getStrategyType() {
        return this.strategyType;
    }

    public void picClick(String business, FeedBaseModel baseModel, int index, boolean isRepost) {
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, "picture", this.source, isRepost, (String) null, 16, (Object) null);
    }

    public void imgBannerSlide(String business, FeedBaseModel baseModel, boolean isRepost) {
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, "pic_slide", this.source, isRepost, (String) null, 16, (Object) null);
    }

    public void imgAutoPlayIndex(FeedBaseModel baseModel, int index, boolean isRepost) {
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, DynamicStatisticsHelper.DYNAMIC_VALUE_PIC_PLAY_INDEX + index, this.source, isRepost, (String) null, 16, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r1 = r10.runtimeStatus;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void videoClick(java.lang.String r9, com.baidu.searchbox.feed.model.FeedBaseModel r10, boolean r11, java.lang.String r12, boolean r13) {
        /*
            r8 = this;
            com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper r0 = com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper.INSTANCE
            java.lang.String r3 = r8.source
            java.lang.String r2 = "video"
            r5 = 0
            r6 = 16
            r7 = 0
            r1 = r10
            r4 = r13
            com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper.handleTemplateClick$default(r0, r1, r2, r3, r4, r5, r6, r7)
            com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper r0 = com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicStatisticsHelper.INSTANCE
            if (r10 == 0) goto L_0x001b
            com.baidu.searchbox.feed.model.FeedRuntimeStatus r1 = r10.runtimeStatus
            if (r1 == 0) goto L_0x001b
            int r1 = r1.viewPosition
            goto L_0x001c
        L_0x001b:
            r1 = 0
        L_0x001c:
            java.lang.String r2 = r8.strategyType
            r0.clickTemplateCmdReport(r10, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.dynamicdetail.ubc.DynamicTemplateStatistics.videoClick(java.lang.String, com.baidu.searchbox.feed.model.FeedBaseModel, boolean, java.lang.String, boolean):void");
    }

    public void poiClick(FeedBaseModel baseModel, String poiExt, boolean isRepost) {
        Intrinsics.checkNotNullParameter(baseModel, "baseModel");
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, "poi", this.source, isRepost, (String) null, 16, (Object) null);
    }

    public void insideCardClick(FeedBaseModel baseModel, String ext, boolean isRepost) {
        Intrinsics.checkNotNullParameter(baseModel, "baseModel");
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, "guazai", this.source, isRepost, (String) null, 16, (Object) null);
    }

    public void dislikeClick(String business, FeedBaseModel baseModel) {
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, "dislike", this.source, false, (String) null, 24, (Object) null);
    }

    public void feedbackClick(String business, FeedBaseModel baseModel) {
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, DynamicStatisticsHelper.DYNAMIC_VALUE_JUBAO, this.source, false, (String) null, 24, (Object) null);
    }

    public void forwardClick(String business, FeedBaseModel baseModel, String originType) {
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, DynamicStatisticsHelper.UBC_VALUE_TEXT_CLICK, this.source, true, (String) null, 16, (Object) null);
    }

    public void relatedContentClick(FeedBaseModel baseModel) {
        DynamicStatisticsHelper.handleTemplateClick$default(DynamicStatisticsHelper.INSTANCE, baseModel, "guazai", this.source, false, (String) null, 24, (Object) null);
    }
}
