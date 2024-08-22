package com.baidu.searchbox.video.collectionflow.detail;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.video.service.PageContainerService;
import com.baidu.searchbox.video.service.vote.VoteSafeAreaModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\tH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u000f\u0010\r\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/collectionflow/detail/CollectionVideoItemPageContainerServiceImpl;", "Lcom/baidu/searchbox/video/service/PageContainerService;", "layoutManager", "Lcom/baidu/searchbox/video/collectionflow/detail/CollectionVideoItemLayoutManager;", "(Lcom/baidu/searchbox/video/collectionflow/detail/CollectionVideoItemLayoutManager;)V", "getCenterContainer", "Landroid/view/ViewGroup;", "getPageContainerPortrait", "getPortraitAvailablePanelHeight", "", "()Ljava/lang/Integer;", "getRightContainerWidth", "getRightFavorContainerTopMargin", "getSummaryParentContainerMaxHeight", "getVoteSafeArea", "Lcom/baidu/searchbox/video/service/vote/VoteSafeAreaModel;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionVideoItemPageContainerServiceImpl.kt */
public final class CollectionVideoItemPageContainerServiceImpl implements PageContainerService {
    private final CollectionVideoItemLayoutManager layoutManager;

    public CollectionVideoItemPageContainerServiceImpl(CollectionVideoItemLayoutManager layoutManager2) {
        Intrinsics.checkNotNullParameter(layoutManager2, "layoutManager");
        this.layoutManager = layoutManager2;
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

    public Integer getTitleContainerMaxHeight() {
        return PageContainerService.DefaultImpls.getTitleContainerMaxHeight(this);
    }

    public boolean isRightContainerVisible() {
        return PageContainerService.DefaultImpls.isRightContainerVisible(this);
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

    public Integer getSummaryParentContainerMaxHeight() {
        return Integer.valueOf(this.layoutManager.getSummaryParentContainerMaxHeight());
    }

    public Integer getRightFavorContainerTopMargin() {
        return null;
    }

    public VoteSafeAreaModel getVoteSafeArea() {
        return this.layoutManager.getVoteSafeAreaModel();
    }

    public ViewGroup getCenterContainer() {
        return this.layoutManager.getCenterContainer();
    }
}
