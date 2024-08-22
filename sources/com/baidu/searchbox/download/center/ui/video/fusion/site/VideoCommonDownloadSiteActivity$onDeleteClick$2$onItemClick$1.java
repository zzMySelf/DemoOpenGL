package com.baidu.searchbox.download.center.ui.video.fusion.site;

import com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "commonDownloadSiteDataList", "", "Lcom/baidu/searchbox/download/center/ui/video/fusion/model/AbsVideoTemplateModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonDownloadSiteActivity.kt */
final class VideoCommonDownloadSiteActivity$onDeleteClick$2$onItemClick$1 extends Lambda implements Function1<List<? extends AbsVideoTemplateModel>, Unit> {
    final /* synthetic */ VideoCommonDownloadSiteActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoCommonDownloadSiteActivity$onDeleteClick$2$onItemClick$1(VideoCommonDownloadSiteActivity videoCommonDownloadSiteActivity) {
        super(1);
        this.this$0 = videoCommonDownloadSiteActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke((List<? extends AbsVideoTemplateModel>) (List) p1);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends AbsVideoTemplateModel> commonDownloadSiteDataList) {
        Intrinsics.checkNotNullParameter(commonDownloadSiteDataList, "commonDownloadSiteDataList");
        this.this$0.updateCommonDownloadSiteData(commonDownloadSiteDataList);
    }
}
