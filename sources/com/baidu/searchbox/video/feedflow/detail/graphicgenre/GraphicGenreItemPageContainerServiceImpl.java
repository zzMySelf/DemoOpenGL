package com.baidu.searchbox.video.feedflow.detail.graphicgenre;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.video.service.PageContainerService;
import com.baidu.searchbox.video.service.vote.VoteSafeAreaModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\bH\u0016J\u000f\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/GraphicGenreItemPageContainerServiceImpl;", "Lcom/baidu/searchbox/video/service/PageContainerService;", "layoutManager", "Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/GraphicGenreItemLayoutManager;", "(Lcom/baidu/searchbox/video/feedflow/detail/graphicgenre/GraphicGenreItemLayoutManager;)V", "getPageContainerPortrait", "Landroid/view/ViewGroup;", "getPortraitAvailablePanelHeight", "", "()Ljava/lang/Integer;", "getRightContainerWidth", "getTitleContainerMaxHeight", "isRightContainerVisible", "", "feed-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraphicGenreItemPageContainerServiceImpl.kt */
public final class GraphicGenreItemPageContainerServiceImpl implements PageContainerService {
    private final GraphicGenreItemLayoutManager layoutManager;

    public GraphicGenreItemPageContainerServiceImpl(GraphicGenreItemLayoutManager layoutManager2) {
        Intrinsics.checkNotNullParameter(layoutManager2, "layoutManager");
        this.layoutManager = layoutManager2;
    }

    public ViewGroup getCenterContainer() {
        return PageContainerService.DefaultImpls.getCenterContainer(this);
    }

    public View getDetailMaskContainer() {
        return PageContainerService.DefaultImpls.getDetailMaskContainer(this);
    }

    public View getPlayerHolder() {
        return PageContainerService.DefaultImpls.getPlayerHolder(this);
    }

    public Float getPopupComponentRightMargin() {
        return PageContainerService.DefaultImpls.getPopupComponentRightMargin(this);
    }

    public int getRightContainerTop() {
        return PageContainerService.DefaultImpls.getRightContainerTop(this);
    }

    public Integer getRightFavorContainerTopMargin() {
        return PageContainerService.DefaultImpls.getRightFavorContainerTopMargin(this);
    }

    public Integer getSummaryParentContainerMaxHeight() {
        return PageContainerService.DefaultImpls.getSummaryParentContainerMaxHeight(this);
    }

    public VoteSafeAreaModel getVoteSafeArea() {
        return PageContainerService.DefaultImpls.getVoteSafeArea(this);
    }

    public ViewGroup getPageContainerPortrait() {
        return this.layoutManager.getPageContainerPortrait();
    }

    public Integer getPortraitAvailablePanelHeight() {
        return this.layoutManager.getPortraitAvailablePanelHeight();
    }

    public int getRightContainerWidth() {
        return this.layoutManager.getRightContainerWidth();
    }

    public Integer getTitleContainerMaxHeight() {
        return Integer.valueOf(this.layoutManager.getTitleContainerMaxHeight());
    }

    public boolean isRightContainerVisible() {
        return this.layoutManager.isRightContainerVisible();
    }
}
