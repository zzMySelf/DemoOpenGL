package com.baidu.searchbox.combinepublisher.fragment.mvp;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.searchbox.mvp.container.IMvpLayoutManagerService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/combinepublisher/fragment/mvp/MvpPublisherLayoutManagerService;", "Lcom/baidu/searchbox/mvp/container/IMvpLayoutManagerService;", "layoutManager", "Lcom/baidu/searchbox/combinepublisher/fragment/mvp/MvpPublisherManager;", "(Lcom/baidu/searchbox/combinepublisher/fragment/mvp/MvpPublisherManager;)V", "isLocateMvpTab", "", "getCardViewContainer", "Landroid/widget/FrameLayout;", "getCardViewContainerTop", "getRootContainer", "Landroid/view/ViewGroup;", "setLocateMvpTab", "", "lib-publisher-dynamic_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MvpPublisherLayoutManagerService.kt */
public final class MvpPublisherLayoutManagerService implements IMvpLayoutManagerService {
    private boolean isLocateMvpTab;
    private final MvpPublisherManager layoutManager;

    public MvpPublisherLayoutManagerService(MvpPublisherManager layoutManager2) {
        Intrinsics.checkNotNullParameter(layoutManager2, "layoutManager");
        this.layoutManager = layoutManager2;
    }

    public ViewGroup getRootContainer() {
        return this.layoutManager.getRootContainer();
    }

    public FrameLayout getCardViewContainer() {
        return this.layoutManager.getCardViewContainer();
    }

    public FrameLayout getCardViewContainerTop() {
        return this.layoutManager.getCardViewContainerTop();
    }

    public void setLocateMvpTab(boolean isLocateMvpTab2) {
        this.isLocateMvpTab = isLocateMvpTab2;
    }

    public boolean isLocateMvpTab() {
        return this.isLocateMvpTab;
    }
}
