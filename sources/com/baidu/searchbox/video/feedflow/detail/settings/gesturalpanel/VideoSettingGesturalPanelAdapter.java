package com.baidu.searchbox.video.feedflow.detail.settings.gesturalpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.detail.settings.IMoreVideoSettingWindowListener;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.LimbicView;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.PanelAdapter;
import com.baidu.searchbox.video.feedflow.flow.collection.view.common.PanelContentView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ \u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010-\u001a\u0004\u0018\u00010,2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010.\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\u001b\u00104\u001a\u0002022\u000b\u00105\u001a\u00070#¢\u0006\u0002\b62\u0006\u00107\u001a\u00020!J\u0006\u00108\u001a\u000202J\u0006\u00109\u001a\u000202R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/settings/gesturalpanel/VideoSettingGesturalPanelAdapter;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/PanelAdapter;", "context", "Landroid/content/Context;", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/detail/frame/Store;Landroidx/lifecycle/LifecycleOwner;Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;)V", "iMoreVideoSettingWindowListener", "Lcom/baidu/searchbox/video/feedflow/detail/settings/IMoreVideoSettingWindowListener;", "getIMoreVideoSettingWindowListener", "()Lcom/baidu/searchbox/video/feedflow/detail/settings/IMoreVideoSettingWindowListener;", "setIMoreVideoSettingWindowListener", "(Lcom/baidu/searchbox/video/feedflow/detail/settings/IMoreVideoSettingWindowListener;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getManager", "()Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "panelShowListener", "Lcom/baidu/searchbox/video/feedflow/detail/settings/gesturalpanel/IPanelShowListener;", "getPanelShowListener", "()Lcom/baidu/searchbox/video/feedflow/detail/settings/gesturalpanel/IPanelShowListener;", "setPanelShowListener", "(Lcom/baidu/searchbox/video/feedflow/detail/settings/gesturalpanel/IPanelShowListener;)V", "settingContainerView", "Lcom/baidu/searchbox/video/feedflow/detail/settings/gesturalpanel/VideoSettingGesturalPanelContainerView;", "getStore", "()Lcom/baidu/searchbox/feed/detail/frame/Store;", "canScrollVertically", "", "direction", "", "startX", "", "startY", "createContent", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/PanelContentView;", "data", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/CollectionCommonModel;", "createFooter", "Lcom/baidu/searchbox/video/feedflow/flow/collection/view/common/LimbicView;", "createHeader", "isContentData", "isFooterData", "isHeaderData", "onPopDismiss", "", "onPopShow", "refreshBottomItemView", "itemType", "Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/model/NewMoreItemType;", "checked", "setRespondFontSize", "updateSkin", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSettingGesturalPanelAdapter.kt */
public final class VideoSettingGesturalPanelAdapter extends PanelAdapter {
    private IMoreVideoSettingWindowListener iMoreVideoSettingWindowListener;
    private final LifecycleOwner lifecycleOwner;
    private final ComponentArchManager manager;
    private IPanelShowListener panelShowListener;
    private VideoSettingGesturalPanelContainerView settingContainerView;
    private final Store<AbsState> store;

    public final Store<AbsState> getStore() {
        return this.store;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final ComponentArchManager getManager() {
        return this.manager;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoSettingGesturalPanelAdapter(Context context, Store<AbsState> store2, LifecycleOwner lifecycleOwner2, ComponentArchManager manager2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.store = store2;
        this.lifecycleOwner = lifecycleOwner2;
        this.manager = manager2;
    }

    public final IPanelShowListener getPanelShowListener() {
        return this.panelShowListener;
    }

    public final void setPanelShowListener(IPanelShowListener iPanelShowListener) {
        this.panelShowListener = iPanelShowListener;
    }

    public final IMoreVideoSettingWindowListener getIMoreVideoSettingWindowListener() {
        return this.iMoreVideoSettingWindowListener;
    }

    public final void setIMoreVideoSettingWindowListener(IMoreVideoSettingWindowListener iMoreVideoSettingWindowListener2) {
        this.iMoreVideoSettingWindowListener = iMoreVideoSettingWindowListener2;
    }

    public LimbicView createHeader(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new VideoSettingGesturalHeaderView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public LimbicView createFooter(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return null;
    }

    public PanelContentView createContent(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        VideoSettingGesturalPanelContainerView $this$createContent_u24lambda_u2d1 = new VideoSettingGesturalPanelContainerView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createContent_u24lambda_u2d1.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = $this$createContent_u24lambda_u2d1.getLayoutParams();
        $this$createContent_u24lambda_u2d1.setLayoutParams(layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null);
        $this$createContent_u24lambda_u2d1.setLandscapeMode(new VideoSettingGesturalPanelAdapter$$ExternalSyntheticLambda0());
        $this$createContent_u24lambda_u2d1.setIMoreVideoSettingWindowListener(this.iMoreVideoSettingWindowListener);
        this.settingContainerView = $this$createContent_u24lambda_u2d1;
        return $this$createContent_u24lambda_u2d1;
    }

    /* access modifiers changed from: private */
    /* renamed from: createContent$lambda-1$lambda-0  reason: not valid java name */
    public static final boolean m13464createContent$lambda1$lambda0() {
        return false;
    }

    public void onPopShow() {
        IPanelShowListener iPanelShowListener = this.panelShowListener;
        if (iPanelShowListener != null) {
            iPanelShowListener.onPopShow();
        }
    }

    public void onPopDismiss() {
    }

    public final void updateSkin() {
        VideoSettingGesturalPanelContainerView videoSettingGesturalPanelContainerView = this.settingContainerView;
        if (videoSettingGesturalPanelContainerView != null) {
            videoSettingGesturalPanelContainerView.updateSkin();
        }
    }

    public boolean canScrollVertically(int direction, float startX, float startY) {
        return false;
    }

    public boolean isHeaderData(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.isVideoSettingHeader();
    }

    public boolean isContentData(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.isVideoSettingContainer();
    }

    public boolean isFooterData(CollectionCommonModel data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return false;
    }

    public final void refreshBottomItemView(int itemType, boolean checked) {
        VideoSettingGesturalPanelContainerView videoSettingGesturalPanelContainerView = this.settingContainerView;
        if (videoSettingGesturalPanelContainerView != null) {
            videoSettingGesturalPanelContainerView.refreshBottomItemView(itemType, checked);
        }
    }

    public final void setRespondFontSize() {
    }
}
