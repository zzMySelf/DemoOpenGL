package com.baidu.searchbox.video.feedflow.detail.dynamic.summary;

import com.baidu.searchbox.feed.detail.ext.mapper.Mapper;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailVideoFlowTargetModel;
import com.baidu.searchbox.flowvideo.detail.repos.PlayLetLimitFreeModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicDetailModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicTitleParagraphsModel;
import com.baidu.searchbox.flowvideo.dynamic.repos.DynamicTitleZoneModel;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrExt;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryModel;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryUnfoldStyle;
import com.baidu.searchbox.video.feedflow.detail.summary.mapper.SummaryAttributeMapper;
import com.baidu.searchbox.video.feedflow.detail.summary.mapper.SummaryParagraphsMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/summary/DynamicDetailModelSummaryMapper;", "Lcom/baidu/searchbox/feed/detail/ext/mapper/Mapper;", "Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicDetailModel;", "Lcom/baidu/searchbox/video/feedflow/detail/summary/SummaryModel;", "()V", "map", "input", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailModelSummaryMapper.kt */
public final class DynamicDetailModelSummaryMapper implements Mapper<DynamicDetailModel, SummaryModel> {
    public static final DynamicDetailModelSummaryMapper INSTANCE = new DynamicDetailModelSummaryMapper();

    private DynamicDetailModelSummaryMapper() {
    }

    public SummaryModel map(DynamicDetailModel input) {
        ArrayList titleParagraphs;
        ArrayList linkAttribute;
        Intrinsics.checkNotNullParameter(input, "input");
        SummaryModel summaryModel = new SummaryModel((String) null, (ArrayList) null, (String) null, (ArrayList) null, false, false, 0, (SummaryUnfoldStyle) null, (ArrayList) null, (String) null, false, false, (String) null, (String) null, (String) null, (String) null, (String) null, (OcrExt.OcrPanelScene) null, false, false, false, false, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, 0, (String) null, (String) null, 0, (String) null, false, (String) null, (String) null, false, (String) null, (PlayLetLimitFreeModel) null, -1, 127, (DefaultConstructorMarker) null);
        DynamicTitleZoneModel titleZone = input.getTitleZone();
        if (!(titleZone == null || (linkAttribute = titleZone.getLinkAttribute()) == null)) {
            summaryModel.setLinkAttribute(SummaryAttributeMapper.INSTANCE.map((ArrayList<FlowDetailVideoFlowTargetModel>) linkAttribute));
        }
        DynamicTitleZoneModel titleZone2 = input.getTitleZone();
        if (!(titleZone2 == null || (titleParagraphs = titleZone2.getTitleParagraphs()) == null)) {
            summaryModel.setSummaryParagraphs(SummaryParagraphsMapper.INSTANCE.map((ArrayList<DynamicTitleParagraphsModel>) titleParagraphs));
        }
        summaryModel.setTitle(input.getTitle());
        summaryModel.setNeedShow(false);
        summaryModel.setOffline(input.isOffLine());
        summaryModel.setDetailsCmd(input.getDetailsCmd());
        summaryModel.setArticleIntroduction(input.getArticleIntroduction());
        return summaryModel;
    }
}
