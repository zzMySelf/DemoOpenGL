package com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.searchbox.feed.detail.arch.ComponentArchManager;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.flowvideo.collection.repos.PlayLetInfoModel;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.component.router.RouterAction;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelPluginKt;
import com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord.RecordCollectionAction;
import com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.ShortMoreItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.PagesContentClickType;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0010J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0010H\u0002J\u001c\u0010$\u001a\u00020\u001f2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030&2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0014\u0010(\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030&\u0018\u00010)H\u0002J\u000e\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\b\u0010+\u001a\u00020\u001fH\u0002J\b\u0010,\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u001fH\u0002J\b\u0010.\u001a\u00020\u001fH\u0002J\u0012\u0010/\u001a\u00020\u00102\b\u00100\u001a\u0004\u0018\u000101H\u0002J\u0018\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0002J\b\u00105\u001a\u00020\u001fH\u0014J\b\u00106\u001a\u00020\u001fH\u0014J \u00107\u001a\u00020\u001f2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&2\b\b\u0002\u0010'\u001a\u00020\u0010H\u0002J6\u00108\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0)2\u0010\u00109\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0)2\u0010\u0010:\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0;H\u0002J\u0018\u0010<\u001a\u00020\u001f2\u000e\b\u0002\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u0018\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u0010H\u0002J\n\u0010@\u001a\u0004\u0018\u00010AH\u0002J\u0010\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020\u0010H\u0016J\u0006\u0010D\u001a\u00020\u001fJ*\u0010E\u001a\u00020\u001f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\n\u0010F\u001a\u0004\u0018\u00010AH\u0002J\b\u0010G\u001a\u00020\u001fH\u0002J\b\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020\u001fH\u0002J\u0016\u0010J\u001a\u00020\u001f2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0002J\u0010\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u00020\u001fH\u0002J\b\u0010N\u001a\u00020\u001fH\u0002J\b\u0010O\u001a\u00020\u001fH\u0002JH\u0010P\u001a\u00020\u001f2\u0006\u0010Q\u001a\u00020\u00102\u0010\u0010R\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030&0)2\u0006\u0010S\u001a\u00020\u00102\u0006\u0010T\u001a\u00020\u00102\b\u0010U\u001a\u0004\u0018\u00010V2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010XH\u0002J\b\u0010Y\u001a\u00020\u001fH\u0016J\b\u0010Z\u001a\u00020\u001fH\u0016J\b\u0010[\u001a\u00020\u001fH\u0014J\u0014\u0010\\\u001a\u00020\u001f*\u00020A2\u0006\u0010]\u001a\u00020\u0019H\u0002R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/ShortPlayCommonListView;", "Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/ShortPlayListView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "commonListViewListener", "Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/CommonListViewListener;", "getCommonListViewListener", "()Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/CommonListViewListener;", "setCommonListViewListener", "(Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/CommonListViewListener;)V", "isFirstScreenShow", "", "isLoadFirstScreen", "isSubscribe", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "manager", "Lcom/baidu/searchbox/feed/detail/arch/ComponentArchManager;", "modelChangeObserver", "Landroidx/lifecycle/Observer;", "Lcom/baidu/searchbox/video/feedflow/flow/collection/CollectionFlowModel;", "scrollActionSend", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "syncObserver", "", "autoShowPanel", "isShow", "bannerLoadFinish", "isSucceed", "dealVideoItemClick", "itemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "isAutoPlay", "getDataSourceFromCollectionPoster", "", "getSelectedModel", "initDataFromFlowIfNeed", "initFirstDataForSupportPage", "initListener", "initSupportPageFirstScreenData", "isPageFromMerge", "page", "", "markNeedReportShow", "fPosition", "lPosition", "onAttachedToWindow", "onDetachedFromWindow", "onItemClick", "removeDuplicateOrAd", "oldList", "newList", "", "scrollToPositionAndHighlight", "scrollToPositionById", "id", "isFromFirstShow", "selectPanelState", "Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/ShortPlayPanelState;", "setBannerState", "canUpload", "showPanel", "subscribeData", "subscribePanelState", "subscriberInternal", "supportPages", "syncDataSource", "syncRecordCollection", "tryDispatchFirstScreenShow", "itemCount", "tryLoadNextPage", "tryLoadPrePage", "unSubscriberInternal", "updateFirstScreenList", "isCollectionRequest", "items", "hasPrev", "hasNext", "playLetInfo", "Lcom/baidu/searchbox/flowvideo/collection/repos/PlayLetInfoModel;", "shortPlayIntroduceModel", "Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/model/ShortPlayIntroduceModel;", "uploadBannerShow", "uploadIntroduceContentShow", "uploadShortMoreViewShow", "handleReceiveData", "model", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayCommonListView.kt */
public final class ShortPlayCommonListView extends ShortPlayListView {
    private CommonListViewListener commonListViewListener;
    private boolean isFirstScreenShow;
    private boolean isLoadFirstScreen;
    private boolean isSubscribe;
    private LifecycleOwner lifecycleOwner;
    private ComponentArchManager manager;
    private final Observer<CollectionFlowModel> modelChangeObserver;
    /* access modifiers changed from: private */
    public boolean scrollActionSend;
    /* access modifiers changed from: private */
    public Store<AbsState> store;
    private final Observer<Unit> syncObserver;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShortPlayCommonListView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ShortPlayCommonListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShortPlayCommonListView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortPlayCommonListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        ShortPlayIntroduceView $this$_init__u24lambda_u2d0 = getShortPlayIntroduceView();
        $this$_init__u24lambda_u2d0.setListener(new ShortPlayCommonListView$1$1(this));
        $this$_init__u24lambda_u2d0.setBannerLoadFinishCallback(new ShortPlayCommonListView$1$2(this));
        this.modelChangeObserver = new ShortPlayCommonListView$$ExternalSyntheticLambda1(this);
        this.syncObserver = new ShortPlayCommonListView$$ExternalSyntheticLambda2(this);
    }

    public final CommonListViewListener getCommonListViewListener() {
        return this.commonListViewListener;
    }

    public final void setCommonListViewListener(CommonListViewListener commonListViewListener2) {
        this.commonListViewListener = commonListViewListener2;
    }

    public void uploadIntroduceContentShow() {
        Store<AbsState> store2 = this.store;
        if (store2 != null) {
            StoreExtKt.post(store2, ShortPlayPanelAction.ShortPlayPanelIntroduceFoldViewShow.INSTANCE);
        }
    }

    public void uploadBannerShow() {
        Store $this$select$iv = this.store;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(ShortPlayPanelState.class);
            }
            ShortPlayPanelState shortPlayPanelState = (ShortPlayPanelState) obj;
            if (shortPlayPanelState != null) {
                ShortPlayPanelState $this$uploadBannerShow_u24lambda_u2d1 = shortPlayPanelState;
                if (!$this$uploadBannerShow_u24lambda_u2d1.getHasReportedBannerShowOnce() && $this$uploadBannerShow_u24lambda_u2d1.getHasBannerLoadSucceed() && $this$uploadBannerShow_u24lambda_u2d1.getCanUploadBannerShow()) {
                    $this$uploadBannerShow_u24lambda_u2d1.setHasReportedBannerShowOnce(true);
                    Store<AbsState> store2 = this.store;
                    if (store2 != null) {
                        StoreExtKt.post(store2, ShortPlayPanelAction.ShortPlayPanelBannerShowAction.INSTANCE);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bannerLoadFinish(boolean r6) {
        /*
            r5 = this;
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r0 = r5.store
            r1 = 0
            if (r0 == 0) goto L_0x001c
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0011
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0012
        L_0x0011:
            r3 = r1
        L_0x0012:
            if (r3 == 0) goto L_0x001a
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r1 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x001a:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r1 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r1
        L_0x001c:
            if (r1 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r1.setHasBannerLoadSucceed(r6)
        L_0x0022:
            r5.uploadBannerShow()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.bannerLoadFinish(boolean):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setBannerState(boolean r6) {
        /*
            r5 = this;
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r0 = r5.store
            r1 = 0
            if (r0 == 0) goto L_0x001c
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0011
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0012
        L_0x0011:
            r3 = r1
        L_0x0012:
            if (r3 == 0) goto L_0x001a
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r1 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r1 = r3.select(r1)
        L_0x001a:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r1 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r1
        L_0x001c:
            if (r1 != 0) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r1.setCanUploadBannerShow(r6)
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.setBannerState(boolean):void");
    }

    private final ShortPlayPanelState selectPanelState() {
        Store $this$select$iv = this.store;
        Object obj = null;
        if ($this$select$iv == null) {
            return null;
        }
        AbsState state = $this$select$iv.getState();
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        if (commonState != null) {
            obj = commonState.select(ShortPlayPanelState.class);
        }
        return (ShortPlayPanelState) obj;
    }

    private final ShortPlayPanelState subscribePanelState() {
        Store $this$subscribe$iv = this.store;
        if ($this$subscribe$iv != null) {
            return (ShortPlayPanelState) $this$subscribe$iv.subscribe(ShortPlayPanelState.class);
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: modelChangeObserver$lambda-2  reason: not valid java name */
    public static final void m6632modelChangeObserver$lambda2(ShortPlayCommonListView this$0, CollectionFlowModel model) {
        ShortPlayPanelState selectPanelState;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (model == null) {
            this$0.bindData(ShortPlayListViewKt.createShortPlayListModel(new ShortPlayListModel((List) null, false, false, false, 0, (ShortPlayIntroduceModel) null, (PlayLetInfoModel) null, false, 248, (DefaultConstructorMarker) null)));
        } else if (!model.isRepeatSubscribe() && (selectPanelState = this$0.selectPanelState()) != null) {
            this$0.handleReceiveData(selectPanelState, model);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: syncObserver$lambda-3  reason: not valid java name */
    public static final void m6633syncObserver$lambda3(ShortPlayCommonListView this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.syncDataSource();
    }

    public final void subscribeData(Store<AbsState> store2, LifecycleOwner lifecycleOwner2, ComponentArchManager manager2) {
        this.store = store2;
        this.lifecycleOwner = lifecycleOwner2;
        this.manager = manager2;
        this.isFirstScreenShow = false;
        this.isLoadFirstScreen = false;
        if (store2 != null && lifecycleOwner2 != null) {
            initListener();
            subscriberInternal();
            initSupportPageFirstScreenData();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        subscriberInternal();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unSubscriberInternal();
    }

    private final void initSupportPageFirstScreenData() {
        Store $this$select$iv;
        if (supportPages() && ($this$select$iv = this.store) != null) {
            AbsState state = $this$select$iv.getState();
            Object obj = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            if (commonState != null) {
                obj = commonState.select(ShortPlayPanelState.class);
            }
            ShortPlayPanelState shortPlayPanelState = (ShortPlayPanelState) obj;
            if (shortPlayPanelState != null) {
                ShortPlayPanelState $this$initSupportPageFirstScreenData_u24lambda_u2d4 = shortPlayPanelState;
                if (!$this$initSupportPageFirstScreenData_u24lambda_u2d4.getDataShortPlaySource().isEmpty()) {
                    $this$initSupportPageFirstScreenData_u24lambda_u2d4.getFirstScreenDataSource().addAll($this$initSupportPageFirstScreenData_u24lambda_u2d4.getDataShortPlaySource());
                }
            }
        }
    }

    private final void subscriberInternal() {
        if (!this.isSubscribe) {
            Store store2 = this.store;
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            if (store2 != null && lifecycleOwner2 != null) {
                initDataFromFlowIfNeed();
                ShortPlayPanelState $this$subscriberInternal_u24lambda_u2d5 = subscribePanelState();
                if ($this$subscriberInternal_u24lambda_u2d5 != null) {
                    $this$subscriberInternal_u24lambda_u2d5.getCollectionShortPlayModel().observe(lifecycleOwner2, this.modelChangeObserver);
                    $this$subscriberInternal_u24lambda_u2d5.getSyncDataSource().observe(lifecycleOwner2, this.syncObserver);
                    this.isSubscribe = true;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0218  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x02ca  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:273:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initDataFromFlowIfNeed() {
        /*
            r14 = this;
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r0 = r14.store
            r1 = 0
            if (r0 == 0) goto L_0x0023
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0011
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0012
        L_0x0011:
            r3 = r1
        L_0x0012:
            if (r3 == 0) goto L_0x001b
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x001c
        L_0x001b:
            r3 = r1
        L_0x001c:
            com.baidu.searchbox.video.detail.core.model.IntentData r3 = (com.baidu.searchbox.video.detail.core.model.IntentData) r3
            if (r3 == 0) goto L_0x0023
            java.lang.String r0 = r3.page
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r14.store
            if (r2 == 0) goto L_0x002f
            com.baidu.searchbox.feed.detail.frame.State r2 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r2 = (com.baidu.searchbox.feed.detail.frame.AbsState) r2
            goto L_0x0030
        L_0x002f:
            r2 = r1
        L_0x0030:
            boolean r3 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r3 == 0) goto L_0x0037
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x0038
        L_0x0037:
            r2 = r1
        L_0x0038:
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0044
            boolean r2 = com.baidu.searchbox.video.feedflow.utils.TabUtilsKt.isFromMergeCollection(r2)
            if (r2 != r4) goto L_0x0044
            r2 = r4
            goto L_0x0045
        L_0x0044:
            r2 = r3
        L_0x0045:
            if (r2 == 0) goto L_0x026b
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r2 = r14.manager
            if (r2 == 0) goto L_0x005b
            r5 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService> r6 = com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r2 = r2.getService(r6)
            com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService r2 = (com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService) r2
            if (r2 == 0) goto L_0x005b
            java.util.List r2 = r2.getDataSource()
            goto L_0x005c
        L_0x005b:
            r2 = r1
        L_0x005c:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            if (r2 == 0) goto L_0x0072
            r6 = r2
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r4
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            goto L_0x0073
        L_0x0072:
            r6 = r1
        L_0x0073:
            boolean r6 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r6)
            if (r6 == 0) goto L_0x009f
            if (r2 == 0) goto L_0x009f
            r6 = r2
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 0
            r8 = 0
            java.util.Iterator r9 = r6.iterator()
        L_0x0084:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x009e
            java.lang.Object r10 = r9.next()
            int r11 = r8 + 1
            if (r8 >= 0) goto L_0x0095
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0095:
            r8 = r10
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r8 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r8
            r12 = 0
            r5.add(r8)
            r8 = r11
            goto L_0x0084
        L_0x009e:
        L_0x009f:
            int r6 = r5.size()
            java.util.ListIterator r6 = r5.listIterator(r6)
        L_0x00a7:
            boolean r7 = r6.hasPrevious()
            if (r7 == 0) goto L_0x00bc
            java.lang.Object r7 = r6.previous()
            r8 = r7
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r8 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r8
            r9 = 0
            boolean r8 = com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt.isVideoItem((com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>) r8)
            if (r8 == 0) goto L_0x00a7
            goto L_0x00bd
        L_0x00bc:
            r7 = r1
        L_0x00bd:
            r13 = r7
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r13 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r13
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r13)
            if (r6 == 0) goto L_0x00ee
            java.lang.Integer r6 = r6.getPosition()
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = r14.selectPanelState()
            if (r7 == 0) goto L_0x00df
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r7 = r7.getCurCollectionModel()
            if (r7 == 0) goto L_0x00df
            int r7 = r7.getCollNum()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            goto L_0x00e0
        L_0x00df:
            r7 = r1
        L_0x00e0:
            int r7 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r7)
            if (r6 != 0) goto L_0x00e7
            goto L_0x00ee
        L_0x00e7:
            int r6 = r6.intValue()
            if (r6 != r7) goto L_0x00ee
            r3 = r4
        L_0x00ee:
            if (r3 == 0) goto L_0x0109
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r3 = r14.selectPanelState()
            if (r3 == 0) goto L_0x0109
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r3 = r3.getShortPlayMoreModel()
            if (r3 == 0) goto L_0x0109
            java.util.List r3 = r3.getItems()
            if (r3 == 0) goto L_0x0109
            r6 = 0
            r7 = r3
            java.util.Collection r7 = (java.util.Collection) r7
            r5.addAll(r7)
        L_0x0109:
            if (r2 == 0) goto L_0x0114
            int r3 = r2.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0115
        L_0x0114:
            r3 = r1
        L_0x0115:
            int r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r3)
            if (r3 > r4) goto L_0x014a
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x0147
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r3.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x012b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x012c
        L_0x012b:
            r7 = r1
        L_0x012c:
            if (r7 == 0) goto L_0x0135
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0136
        L_0x0135:
            r7 = r1
        L_0x0136:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r7
            if (r7 == 0) goto L_0x0147
            androidx.lifecycle.MutableLiveData r3 = r7.getCollectionShortPlayModel()
            if (r3 == 0) goto L_0x0147
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r3 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel) r3
            goto L_0x0148
        L_0x0147:
            r3 = r1
        L_0x0148:
            if (r3 == 0) goto L_0x037c
        L_0x014a:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x0176
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r3.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x015a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x015b
        L_0x015a:
            r7 = r1
        L_0x015b:
            if (r7 == 0) goto L_0x0164
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0165
        L_0x0164:
            r7 = r1
        L_0x0165:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r7
            if (r7 == 0) goto L_0x0176
            androidx.lifecycle.MutableLiveData r3 = r7.getCollectionShortPlayModel()
            if (r3 == 0) goto L_0x0176
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r3 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel) r3
            goto L_0x0177
        L_0x0176:
            r3 = r1
        L_0x0177:
            if (r3 != 0) goto L_0x017a
            goto L_0x017d
        L_0x017a:
            r3.setRepeatSubscribe(r4)
        L_0x017d:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x01b4
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x018e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x018f
        L_0x018e:
            r6 = r1
        L_0x018f:
            if (r6 == 0) goto L_0x0198
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r7 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0199
        L_0x0198:
            r6 = r1
        L_0x0199:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r6 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r6
            if (r6 == 0) goto L_0x01b4
            androidx.lifecycle.MutableLiveData r3 = r6.getCollectionShortPlayModel()
            if (r3 == 0) goto L_0x01b4
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r3 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel) r3
            if (r3 == 0) goto L_0x01b4
            boolean r3 = r3.isCollectionRequest()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x01b5
        L_0x01b4:
            r3 = r1
        L_0x01b5:
            boolean r7 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x01e2
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r8 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x01ca
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x01cb
        L_0x01ca:
            r6 = r1
        L_0x01cb:
            if (r6 == 0) goto L_0x01d4
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r8 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r6 = r6.select(r8)
            goto L_0x01d5
        L_0x01d4:
            r6 = r1
        L_0x01d5:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r6 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r6
            if (r6 == 0) goto L_0x01e2
            boolean r3 = r6.getHasPrev()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x01e3
        L_0x01e2:
            r3 = r1
        L_0x01e3:
            boolean r9 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x020f
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r8 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x01f7
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x01f8
        L_0x01f7:
            r6 = r1
        L_0x01f8:
            if (r6 == 0) goto L_0x0201
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r8 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r6 = r6.select(r8)
            goto L_0x0202
        L_0x0201:
            r6 = r1
        L_0x0202:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r6 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r6
            if (r6 == 0) goto L_0x020f
            boolean r3 = r6.getHasMore()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0210
        L_0x020f:
            r3 = r1
        L_0x0210:
            boolean r10 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x023f
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r8 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0224
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0225
        L_0x0224:
            r6 = r1
        L_0x0225:
            if (r6 == 0) goto L_0x022e
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r6 = r6.select(r8)
            goto L_0x022f
        L_0x022e:
            r6 = r1
        L_0x022f:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r6 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r6
            if (r6 == 0) goto L_0x023f
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r3 = r6.getCurCollectionModel()
            if (r3 == 0) goto L_0x023f
            com.baidu.searchbox.flowvideo.collection.repos.PlayLetInfoModel r3 = r3.getPlayLetInfo()
            r11 = r3
            goto L_0x0240
        L_0x023f:
            r11 = r1
        L_0x0240:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x0263
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r8 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0250
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0251
        L_0x0250:
            r6 = r1
        L_0x0251:
            if (r6 == 0) goto L_0x025a
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r6 = r6.select(r8)
            goto L_0x025b
        L_0x025a:
            r6 = r1
        L_0x025b:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r6 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r6
            if (r6 == 0) goto L_0x0263
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel r1 = r6.getShortPlayIntroduceModel()
        L_0x0263:
            r12 = r1
            r6 = r14
            r8 = r5
            r6.updateFirstScreenList(r7, r8, r9, r10, r11, r12)
            goto L_0x037c
        L_0x026b:
            boolean r2 = r14.isPageFromMerge(r0)
            if (r2 == 0) goto L_0x0379
            java.util.List r2 = r14.getDataSourceFromCollectionPoster()
            if (r2 == 0) goto L_0x0280
            int r3 = r2.size()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0281
        L_0x0280:
            r3 = r1
        L_0x0281:
            int r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r3)
            if (r3 <= 0) goto L_0x0375
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x02be
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r3.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0298
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0299
        L_0x0298:
            r5 = r1
        L_0x0299:
            if (r5 == 0) goto L_0x02a2
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState> r6 = com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x02a3
        L_0x02a2:
            r5 = r1
        L_0x02a3:
            com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState r5 = (com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState) r5
            if (r5 == 0) goto L_0x02be
            androidx.lifecycle.MutableLiveData r3 = r5.getCollectionModel()
            if (r3 == 0) goto L_0x02be
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r3 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel) r3
            if (r3 == 0) goto L_0x02be
            boolean r3 = r3.isCollectionRequest()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x02bf
        L_0x02be:
            r3 = r1
        L_0x02bf:
            boolean r4 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x02ea
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x02d6
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x02d7
        L_0x02d6:
            r6 = r1
        L_0x02d7:
            if (r6 == 0) goto L_0x02e0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState> r7 = com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x02e1
        L_0x02e0:
            r6 = r1
        L_0x02e1:
            com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState r6 = (com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState) r6
            if (r6 == 0) goto L_0x02ea
            java.lang.Boolean r3 = r6.getHasPrev()
            goto L_0x02eb
        L_0x02ea:
            r3 = r1
        L_0x02eb:
            boolean r6 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x0313
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r3.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x02ff
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0300
        L_0x02ff:
            r7 = r1
        L_0x0300:
            if (r7 == 0) goto L_0x0309
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState> r8 = com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x030a
        L_0x0309:
            r7 = r1
        L_0x030a:
            com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState r7 = (com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState) r7
            if (r7 == 0) goto L_0x0313
            java.lang.Boolean r3 = r7.getHasNext()
            goto L_0x0314
        L_0x0313:
            r3 = r1
        L_0x0314:
            boolean r7 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x034b
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r3.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x0328
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x0329
        L_0x0328:
            r8 = r1
        L_0x0329:
            if (r8 == 0) goto L_0x0332
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState> r9 = com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x0333
        L_0x0332:
            r8 = r1
        L_0x0333:
            com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState r8 = (com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState) r8
            if (r8 == 0) goto L_0x034b
            androidx.lifecycle.MutableLiveData r3 = r8.getCollectionModel()
            if (r3 == 0) goto L_0x034b
            java.lang.Object r3 = r3.getValue()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r3 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel) r3
            if (r3 == 0) goto L_0x034b
            com.baidu.searchbox.flowvideo.collection.repos.PlayLetInfoModel r3 = r3.getPlayLetInfo()
            r8 = r3
            goto L_0x034c
        L_0x034b:
            r8 = r1
        L_0x034c:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r3 = r14.store
            if (r3 == 0) goto L_0x036f
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r9 = r3.getState()
            boolean r10 = r9 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r10 == 0) goto L_0x035c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r9 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r9
            goto L_0x035d
        L_0x035c:
            r9 = r1
        L_0x035d:
            if (r9 == 0) goto L_0x0366
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState> r10 = com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState.class
            java.lang.Object r9 = r9.select(r10)
            goto L_0x0367
        L_0x0366:
            r9 = r1
        L_0x0367:
            com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState r9 = (com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListState) r9
            if (r9 == 0) goto L_0x036f
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel r1 = r9.getShortPlayIntroduceModel()
        L_0x036f:
            r9 = r1
            r3 = r14
            r5 = r2
            r3.updateFirstScreenList(r4, r5, r6, r7, r8, r9)
        L_0x0375:
            r14.initFirstDataForSupportPage()
            goto L_0x037c
        L_0x0379:
            r14.initFirstDataForSupportPage()
        L_0x037c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.initDataFromFlowIfNeed():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initFirstDataForSupportPage() {
        /*
            r10 = this;
            boolean r0 = r10.supportPages()
            if (r0 == 0) goto L_0x0158
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r0 = r10.store
            r1 = 0
            if (r0 == 0) goto L_0x002b
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0017
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x0018
        L_0x0017:
            r3 = r1
        L_0x0018:
            if (r3 == 0) goto L_0x0021
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r4 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0022
        L_0x0021:
            r3 = r1
        L_0x0022:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r3 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r3
            if (r3 == 0) goto L_0x002b
            java.util.List r0 = r3.getFirstScreenDataSource()
            goto L_0x002c
        L_0x002b:
            r0 = r1
        L_0x002c:
            if (r0 == 0) goto L_0x0037
            int r2 = r0.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0038
        L_0x0037:
            r2 = r1
        L_0x0038:
            int r2 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r2)
            if (r2 <= 0) goto L_0x0158
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r10.store
            if (r2 == 0) goto L_0x006a
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r2.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x004e
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x004f
        L_0x004e:
            r4 = r1
        L_0x004f:
            if (r4 == 0) goto L_0x0058
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r5 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x0059
        L_0x0058:
            r4 = r1
        L_0x0059:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r4 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r4
            if (r4 == 0) goto L_0x006a
            androidx.lifecycle.MutableLiveData r2 = r4.getCollectionShortPlayModel()
            if (r2 == 0) goto L_0x006a
            java.lang.Object r2 = r2.getValue()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r2 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel) r2
            goto L_0x006b
        L_0x006a:
            r2 = r1
        L_0x006b:
            if (r2 != 0) goto L_0x006e
            goto L_0x0072
        L_0x006e:
            r3 = 1
            r2.setRepeatSubscribe(r3)
        L_0x0072:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r10.store
            if (r2 == 0) goto L_0x00a9
            r3 = 0
            com.baidu.searchbox.feed.detail.frame.State r4 = r2.getState()
            boolean r5 = r4 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r5 == 0) goto L_0x0083
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r4 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r4
            goto L_0x0084
        L_0x0083:
            r4 = r1
        L_0x0084:
            if (r4 == 0) goto L_0x008d
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r5 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r4 = r4.select(r5)
            goto L_0x008e
        L_0x008d:
            r4 = r1
        L_0x008e:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r4 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r4
            if (r4 == 0) goto L_0x00a9
            androidx.lifecycle.MutableLiveData r2 = r4.getCollectionShortPlayModel()
            if (r2 == 0) goto L_0x00a9
            java.lang.Object r2 = r2.getValue()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r2 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel) r2
            if (r2 == 0) goto L_0x00a9
            boolean r2 = r2.isCollectionRequest()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x00aa
        L_0x00a9:
            r2 = r1
        L_0x00aa:
            boolean r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r10.store
            if (r2 == 0) goto L_0x00d5
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r2.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x00c1
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x00c2
        L_0x00c1:
            r5 = r1
        L_0x00c2:
            if (r5 == 0) goto L_0x00cb
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r6 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x00cc
        L_0x00cb:
            r5 = r1
        L_0x00cc:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r5
            if (r5 == 0) goto L_0x00d5
            java.lang.Boolean r2 = r5.getHasPrev()
            goto L_0x00d6
        L_0x00d5:
            r2 = r1
        L_0x00d6:
            boolean r5 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r2)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r10.store
            if (r2 == 0) goto L_0x00fe
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r2.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x00ea
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x00eb
        L_0x00ea:
            r6 = r1
        L_0x00eb:
            if (r6 == 0) goto L_0x00f4
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r7 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x00f5
        L_0x00f4:
            r6 = r1
        L_0x00f5:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r6 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r6
            if (r6 == 0) goto L_0x00fe
            java.lang.Boolean r2 = r6.getHasNext()
            goto L_0x00ff
        L_0x00fe:
            r2 = r1
        L_0x00ff:
            boolean r6 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r2)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r10.store
            if (r2 == 0) goto L_0x012e
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r2.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0113
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0114
        L_0x0113:
            r7 = r1
        L_0x0114:
            if (r7 == 0) goto L_0x011d
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x011e
        L_0x011d:
            r7 = r1
        L_0x011e:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r7
            if (r7 == 0) goto L_0x012e
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r2 = r7.getCurCollectionModel()
            if (r2 == 0) goto L_0x012e
            com.baidu.searchbox.flowvideo.collection.repos.PlayLetInfoModel r2 = r2.getPlayLetInfo()
            r7 = r2
            goto L_0x012f
        L_0x012e:
            r7 = r1
        L_0x012f:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r10.store
            if (r2 == 0) goto L_0x0152
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r8 = r2.getState()
            boolean r9 = r8 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r9 == 0) goto L_0x013f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r8 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r8
            goto L_0x0140
        L_0x013f:
            r8 = r1
        L_0x0140:
            if (r8 == 0) goto L_0x0149
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r9 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r8 = r8.select(r9)
            goto L_0x014a
        L_0x0149:
            r8 = r1
        L_0x014a:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r8 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r8
            if (r8 == 0) goto L_0x0152
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel r1 = r8.getShortPlayIntroduceModel()
        L_0x0152:
            r8 = r1
            r2 = r10
            r4 = r0
            r2.updateFirstScreenList(r3, r4, r5, r6, r7, r8)
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.initFirstDataForSupportPage():void");
    }

    private final List<ItemModel<?>> getDataSourceFromCollectionPoster() {
        Store $this$select$iv = this.store;
        if ($this$select$iv == null) {
            return null;
        }
        AbsState state = $this$select$iv.getState();
        CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
        CollectionPosterListState collectionPosterListState = (CollectionPosterListState) (commonState != null ? commonState.select(CollectionPosterListState.class) : null);
        if (collectionPosterListState != null) {
            return collectionPosterListState.getDataSource();
        }
        return null;
    }

    private final boolean isPageFromMerge(String page) {
        return VideoBizUtilsKt.isFromMerge(page) || VideoBizUtilsKt.isFromFeed(page) || VideoBizUtilsKt.isFromChannelFlow(page) || VideoBizUtilsKt.isFromUserHomePage(page) || VideoBizUtilsKt.isFromSearch(page);
    }

    private final void unSubscriberInternal() {
        ShortPlayPanelState $this$unSubscriberInternal_u24lambda_u2d9;
        if (this.isSubscribe && ($this$unSubscriberInternal_u24lambda_u2d9 = selectPanelState()) != null) {
            $this$unSubscriberInternal_u24lambda_u2d9.getCollectionShortPlayModel().removeObserver(this.modelChangeObserver);
            $this$unSubscriberInternal_u24lambda_u2d9.getSyncDataSource().removeObserver(this.syncObserver);
            this.isSubscribe = false;
        }
    }

    static /* synthetic */ void scrollToPositionAndHighlight$default(ShortPlayCommonListView shortPlayCommonListView, ItemModel itemModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            itemModel = null;
        }
        shortPlayCommonListView.scrollToPositionAndHighlight(itemModel);
    }

    private final void scrollToPositionAndHighlight(ItemModel<?> itemModel) {
        Store $this$select$iv = this.store;
        boolean z = false;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            String str = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            ShortPlayPanelState shortPlayPanelState = (ShortPlayPanelState) (commonState != null ? commonState.select(ShortPlayPanelState.class) : null);
            if (shortPlayPanelState != null) {
                ShortPlayPanelState $this$scrollToPositionAndHighlight_u24lambda_u2d10 = shortPlayPanelState;
                if ($this$scrollToPositionAndHighlight_u24lambda_u2d10.getShouldNotAnchor()) {
                    ItemModel itemModel2 = (ItemModel) CollectionsKt.getOrNull($this$scrollToPositionAndHighlight_u24lambda_u2d10.getDataShortPlaySource(), 0);
                    if (itemModel2 != null) {
                        str = itemModel2.getId();
                    }
                    String firstId = str;
                    if (firstId != null && (!StringsKt.isBlank(firstId))) {
                        z = true;
                    }
                    if (z) {
                        setExpandStatus(true);
                        scrollToPositionById(firstId, true);
                        return;
                    }
                    return;
                }
            }
        }
        ItemModel changeModel = itemModel == null ? getSelectedModel() : itemModel;
        if (changeModel != null) {
            ItemModel model = changeModel;
            updateSelect(model.getId());
            setExpandStatus(false);
            scrollToPositionById(model.getId(), true);
        }
    }

    private final void initListener() {
        setOnItemsShowingListener(new ShortPlayCommonListView$initListener$1(this));
        setOnBoundaryItemShowListener(new ShortPlayCommonListView$initListener$2(this));
        setItemClickListener(new ShortPlayCommonListView$initListener$3(this));
        setOnRecyclerScrollListener(new ShortPlayCommonListView$initListener$4(this));
        setRetryClickListener(new ShortPlayCommonListView$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r7.getHasClickPageTab() == true) goto L_0x0030;
     */
    /* renamed from: initListener$lambda-12  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m6631initListener$lambda12(com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView r17) {
        /*
            r0 = r17
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r1 = r0.store
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x002f
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r1.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            r7 = 0
            if (r6 == 0) goto L_0x001b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x001c
        L_0x001b:
            r5 = r7
        L_0x001c:
            if (r5 == 0) goto L_0x0024
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r6 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r7 = r5.select(r6)
        L_0x0024:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r7
            if (r7 == 0) goto L_0x002f
            boolean r1 = r7.getHasClickPageTab()
            if (r1 != r2) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r2 = r3
        L_0x0030:
            if (r2 == 0) goto L_0x0078
            com.baidu.searchbox.video.detail.export.IVideoNetWorkUtils r1 = com.baidu.searchbox.video.detail.export.IVideoNetWorkUtils.Impl.get()
            android.content.Context r2 = r17.getContext()
            boolean r1 = r1.isConnected(r2)
            if (r1 != 0) goto L_0x0066
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r1 = r0.store
            if (r1 == 0) goto L_0x0078
            com.baidu.searchbox.video.component.toast.ToastAction$SolidShow r16 = new com.baidu.searchbox.video.component.toast.ToastAction$SolidShow
            int r3 = com.baidu.searchbox.component.R.string.video_component_network_error
            r4 = 0
            r5 = 0
            com.baidu.searchbox.video.component.toast.ToastAction$App r2 = com.baidu.searchbox.video.component.toast.ToastAction.App.INSTANCE
            r6 = r2
            com.baidu.searchbox.video.component.toast.ToastAction r6 = (com.baidu.searchbox.video.component.toast.ToastAction) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 2038(0x7f6, float:2.856E-42)
            r15 = 0
            r2 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r2 = r16
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
            goto L_0x0078
        L_0x0066:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState$Loading r1 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState.Loading.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState r1 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState) r1
            r0.changeContent(r1)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r1 = r0.store
            if (r1 == 0) goto L_0x0078
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$OnBelowPagesRetryClickAction r2 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.OnBelowPagesRetryClickAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.m6631initListener$lambda12(com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView):void");
    }

    static /* synthetic */ void onItemClick$default(ShortPlayCommonListView shortPlayCommonListView, ItemModel itemModel, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        shortPlayCommonListView.onItemClick(itemModel, z);
    }

    private final void onItemClick(ItemModel<?> itemModel, boolean isAutoPlay) {
        if ((itemModel != null ? itemModel.getData() : null) instanceof VideoItemModel) {
            dealVideoItemClick(itemModel, isAutoPlay);
            return;
        }
        ShortMoreItemModel $this$onItemClick_u24lambda_u2d13 = FlowModelUtilsKt.transformShortMoreItemModel(itemModel);
        if ($this$onItemClick_u24lambda_u2d13 == null) {
            return;
        }
        if (!StringsKt.isBlank($this$onItemClick_u24lambda_u2d13.getMoreCmd())) {
            CommonListViewListener commonListViewListener2 = this.commonListViewListener;
            if (commonListViewListener2 != null) {
                commonListViewListener2.moreShortPlayClick();
            }
            Store<AbsState> store2 = this.store;
            if (store2 != null) {
                StoreExtKt.post(store2, new ShortPlayPanelAction.ClickShortPlayMoreViewAction($this$onItemClick_u24lambda_u2d13.getMoreCmd()));
            }
        } else if (!StringsKt.isBlank($this$onItemClick_u24lambda_u2d13.getCmd())) {
            CommonListViewListener commonListViewListener3 = this.commonListViewListener;
            if (commonListViewListener3 != null) {
                commonListViewListener3.moreShortPlayClick();
            }
            Store<AbsState> store3 = this.store;
            if (store3 != null) {
                StoreExtKt.post(store3, new ShortPlayPanelAction.ClickShortPlayViewAction($this$onItemClick_u24lambda_u2d13.getTitle()));
            }
            Store<AbsState> store4 = this.store;
            if (store4 != null) {
                StoreExtKt.post(store4, new RouterAction($this$onItemClick_u24lambda_u2d13.getCmd()));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dealVideoItemClick(com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r82, boolean r83) {
        /*
            r81 = this;
            r0 = r81
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r1 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r82)
            if (r1 == 0) goto L_0x01d9
            r76 = 0
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r77 = new com.baidu.searchbox.video.feedflow.flow.list.ItemModel
            java.lang.String r78 = r82.getId()
            java.lang.String r79 = r82.getNid()
            java.lang.String r80 = r82.getLayout()
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = 0
            r50 = 0
            r51 = 0
            r52 = 0
            r53 = 0
            r54 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r59 = 0
            r60 = 0
            r61 = 0
            r62 = 0
            r63 = 0
            r64 = 0
            r65 = 0
            r66 = 0
            r67 = 0
            r68 = 0
            r69 = 0
            r70 = 0
            r71 = 0
            r72 = -1
            r73 = -1
            r74 = 63
            r75 = 0
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r6 = com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel.copy$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66, r67, r68, r69, r70, r71, r72, r73, r74, r75)
            com.baidu.searchbox.video.feedflow.flow.list.StrategyVideoModel r7 = r82.getStrategyModel()
            if (r7 == 0) goto L_0x00b3
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 7
            r12 = 0
            com.baidu.searchbox.video.feedflow.flow.list.StrategyVideoModel r2 = com.baidu.searchbox.video.feedflow.flow.list.StrategyVideoModel.copy$default(r7, r8, r9, r10, r11, r12)
            r7 = r2
            goto L_0x00b4
        L_0x00b3:
            r7 = r13
        L_0x00b4:
            com.baidu.searchbox.video.feedflow.flow.list.CommonItemData r14 = r82.getCommonItemData()
            if (r14 == 0) goto L_0x00d7
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 1023(0x3ff, float:1.434E-42)
            r26 = 0
            com.baidu.searchbox.video.feedflow.flow.list.CommonItemData r2 = com.baidu.searchbox.video.feedflow.flow.list.CommonItemData.copy$default(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r8 = r2
            goto L_0x00d8
        L_0x00d7:
            r8 = r13
        L_0x00d8:
            r2 = r77
            r3 = r78
            r4 = r79
            r5 = r80
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r3 = r77
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r2 = r3.getRunTimeStatus()
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r4 = r82.getRunTimeStatus()
            int r4 = r4.getPosition()
            r2.setPosition(r4)
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r2 = r3.getRunTimeStatus()
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r4 = r82.getRunTimeStatus()
            boolean r4 = r4.isReportShow()
            r2.setReportShow(r4)
            r2 = 1
            if (r83 == 0) goto L_0x010d
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r4 = r3.getRunTimeStatus()
            r4.setAutoPlayState(r2)
        L_0x010d:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r4 = r0.store
            if (r4 == 0) goto L_0x012b
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x011d
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x011e
        L_0x011d:
            r6 = r13
        L_0x011e:
            if (r6 == 0) goto L_0x0127
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r7 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x0128
        L_0x0127:
            r6 = r13
        L_0x0128:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r6 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r6
            goto L_0x012c
        L_0x012b:
            r6 = r13
        L_0x012c:
            r16 = r6
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r15 = r0.store
            if (r15 == 0) goto L_0x01d7
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction$ItemClickAction r17 = new com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction$ItemClickAction
            if (r16 == 0) goto L_0x013c
            java.util.List r4 = r16.getDataShortPlaySource()
            goto L_0x013d
        L_0x013c:
            r4 = r13
        L_0x013d:
            r5 = 0
            if (r16 == 0) goto L_0x0148
            boolean r6 = r16.getHasClickPageTab()
            if (r6 != r2) goto L_0x0148
            r6 = r2
            goto L_0x0149
        L_0x0148:
            r6 = r5
        L_0x0149:
            if (r6 == 0) goto L_0x0150
            java.lang.Boolean r6 = r16.getClickPagePrev()
            goto L_0x0158
        L_0x0150:
            if (r16 == 0) goto L_0x0157
            java.lang.Boolean r6 = r16.getHasPrev()
            goto L_0x0158
        L_0x0157:
            r6 = r13
        L_0x0158:
            if (r16 == 0) goto L_0x0161
            boolean r7 = r16.getHasClickPageTab()
            if (r7 != r2) goto L_0x0161
            goto L_0x0162
        L_0x0161:
            r2 = r5
        L_0x0162:
            if (r2 == 0) goto L_0x016a
            java.lang.Boolean r2 = r16.getClickPageNext()
            r7 = r2
            goto L_0x0173
        L_0x016a:
            if (r16 == 0) goto L_0x0172
            java.lang.Boolean r2 = r16.getHasNext()
            r7 = r2
            goto L_0x0173
        L_0x0172:
            r7 = r13
        L_0x0173:
            r8 = 0
            java.lang.String r9 = r1.getCmdStr()
            java.lang.String r10 = r1.getCollCmdStr()
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r0.store
            if (r2 == 0) goto L_0x01a0
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r11 = r2.getState()
            boolean r12 = r11 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r12 == 0) goto L_0x018c
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r11 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r11
            goto L_0x018d
        L_0x018c:
            r11 = r13
        L_0x018d:
            if (r11 == 0) goto L_0x0196
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState> r12 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState.class
            java.lang.Object r11 = r11.select(r12)
            goto L_0x0197
        L_0x0196:
            r11 = r13
        L_0x0197:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState r11 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelState) r11
            if (r11 == 0) goto L_0x01a0
            java.lang.String r2 = r11.getCollId()
            goto L_0x01a1
        L_0x01a0:
            r2 = r13
        L_0x01a1:
            java.lang.String r5 = ""
            if (r2 != 0) goto L_0x01a7
            r11 = r5
            goto L_0x01a8
        L_0x01a7:
            r11 = r2
        L_0x01a8:
            if (r16 == 0) goto L_0x01b4
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r2 = r16.getCurCollectionModel()
            if (r2 == 0) goto L_0x01b4
            java.lang.String r13 = r2.getCollTitle()
        L_0x01b4:
            if (r13 != 0) goto L_0x01b7
            r13 = r5
        L_0x01b7:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionItemClickActionType r12 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionItemClickActionType.SHORT_MORE_TYPE
            r14 = 0
            r18 = 1040(0x410, float:1.457E-42)
            r19 = 0
            r2 = r17
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r13
            r13 = r14
            r14 = r18
            r0 = r15
            r15 = r19
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r2 = r17
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r0, r2)
        L_0x01d7:
        L_0x01d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.dealVideoItemClick(com.baidu.searchbox.video.feedflow.flow.list.ItemModel, boolean):void");
    }

    /* access modifiers changed from: private */
    public final void tryDispatchFirstScreenShow(int itemCount) {
        if (!this.isFirstScreenShow && itemCount > 0) {
            this.isFirstScreenShow = true;
            Store<AbsState> store2 = this.store;
            if (store2 != null) {
                StoreExtKt.post(store2, ShortPlayPanelAction.OnFirstScreenShowAction.INSTANCE);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void markNeedReportShow(int fPosition, int lPosition) {
        List dataList = getSource();
        if (dataList != null) {
            int size = dataList.size();
            for (int position = 0; position < size; position++) {
                boolean z = false;
                if (fPosition <= position && position <= lPosition) {
                    z = true;
                }
                if (z) {
                    ItemModel item = dataList.get(position);
                    if (!item.getRunTimeStatus().isReportShow() && !item.getRunTimeStatus().getNeedReportShow()) {
                        item.getRunTimeStatus().setNeedReportShow(true);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void tryLoadPrePage() {
        List dataSource;
        ShortPlayPanelState $this$tryLoadPrePage_u24lambda_u2d16 = selectPanelState();
        if ($this$tryLoadPrePage_u24lambda_u2d16 != null) {
            if (Intrinsics.areEqual((Object) $this$tryLoadPrePage_u24lambda_u2d16.getHasClickPageTab() ? $this$tryLoadPrePage_u24lambda_u2d16.getClickPagePrev() : $this$tryLoadPrePage_u24lambda_u2d16.getHasPrev(), (Object) true) && (dataSource = getSource()) != null) {
                Store<AbsState> store2 = this.store;
                if (store2 != null) {
                    StoreExtKt.post(store2, new ShortPlayPanelAction.TryLoadPageAction(-1, TypeIntrinsics.asMutableList(dataSource), false, $this$tryLoadPrePage_u24lambda_u2d16.getClickPagesContentType(), false, 20, (DefaultConstructorMarker) null));
                }
                $this$tryLoadPrePage_u24lambda_u2d16.setClickPagesContentType(PagesContentClickType.NONE_TYPE);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void tryLoadNextPage() {
        ShortPlayPanelState $this$tryLoadNextPage_u24lambda_u2d18 = selectPanelState();
        if ($this$tryLoadNextPage_u24lambda_u2d18 != null) {
            if (Intrinsics.areEqual((Object) $this$tryLoadNextPage_u24lambda_u2d18.getHasClickPageTab() ? $this$tryLoadNextPage_u24lambda_u2d18.getClickPageNext() : $this$tryLoadNextPage_u24lambda_u2d18.getHasNext(), (Object) true) || $this$tryLoadNextPage_u24lambda_u2d18.isLastPageOfCollection()) {
                List dataSource = getSource();
                if (dataSource != null) {
                    if (!$this$tryLoadNextPage_u24lambda_u2d18.isLastPageOfCollection() || !$this$tryLoadNextPage_u24lambda_u2d18.getHasSimilar()) {
                        Store<AbsState> store2 = this.store;
                        if (store2 != null) {
                            StoreExtKt.post(store2, new ShortPlayPanelAction.TryLoadPageAction(1, TypeIntrinsics.asMutableList(dataSource), false, (PagesContentClickType) null, false, 28, (DefaultConstructorMarker) null));
                        }
                    } else {
                        Store<AbsState> store3 = this.store;
                        if (store3 != null) {
                            StoreExtKt.post(store3, ShortPlayPanelAction.RequestShortPlayDataAction.INSTANCE);
                        }
                    }
                    $this$tryLoadNextPage_u24lambda_u2d18.setClickPagesContentType(PagesContentClickType.NONE_TYPE);
                    return;
                }
                return;
            }
            showBottom();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v34, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01fd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x012e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void handleReceiveData(com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r12, com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r13) {
        /*
            r11 = this;
            java.util.List r0 = r13.getItems()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0017
            boolean r0 = r13.getHasMore()
            if (r0 != 0) goto L_0x0017
            r11.showBottom()
        L_0x0017:
            int r0 = r13.getFromDirection()
            r2 = 0
            r3 = 0
            switch(r0) {
                case -1: goto L_0x0187;
                case 0: goto L_0x00db;
                case 1: goto L_0x0022;
                default: goto L_0x0020;
            }
        L_0x0020:
            goto L_0x025c
        L_0x0022:
            java.util.List r0 = r12.getDataShortPlaySource()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x003c
            java.util.List r0 = r12.getDataShortPlaySource()
            java.util.List r4 = r13.getItems()
            java.util.List r0 = r11.removeDuplicateOrAd(r0, r4)
            goto L_0x0040
        L_0x003c:
            java.util.List r0 = r13.getItems()
        L_0x0040:
            java.util.List r4 = r12.getDataShortPlaySource()
            java.util.List r5 = r12.getDataShortPlaySource()
            int r5 = r5.size()
            int r5 = r5 - r1
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r5)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r4
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r0, r2)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r4 == 0) goto L_0x0061
            java.lang.Object r6 = r4.getData()
            goto L_0x0062
        L_0x0061:
            r6 = r3
        L_0x0062:
            boolean r6 = r6 instanceof com.baidu.searchbox.video.feedflow.flow.list.ShortMoreItemModel
            if (r6 == 0) goto L_0x0073
            if (r5 == 0) goto L_0x006d
            java.lang.Object r6 = r5.getData()
            goto L_0x006e
        L_0x006d:
            r6 = r3
        L_0x006e:
            boolean r6 = r6 instanceof com.baidu.searchbox.video.feedflow.flow.list.ShortMoreItemModel
            if (r6 != 0) goto L_0x0073
            return
        L_0x0073:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r6 = r11.selectPanelState()
            if (r6 == 0) goto L_0x0085
            java.util.List r6 = r6.getDataShortPlaySource()
            if (r6 == 0) goto L_0x0085
            r7 = r0
            java.util.Collection r7 = (java.util.Collection) r7
            r6.addAll(r7)
        L_0x0085:
            boolean r6 = r11.supportPages()
            if (r6 == 0) goto L_0x00c0
            r6 = r0
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x00c0
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r6 = r11.selectPanelState()
            if (r6 == 0) goto L_0x00a2
            boolean r6 = r6.getHasClickPageTab()
            if (r6 != 0) goto L_0x00a2
            r2 = r1
        L_0x00a2:
            if (r2 == 0) goto L_0x00c0
            if (r5 == 0) goto L_0x00aa
            java.lang.Object r3 = r5.getData()
        L_0x00aa:
            boolean r2 = r3 instanceof com.baidu.searchbox.video.feedflow.flow.list.ShortMoreItemModel
            if (r2 != 0) goto L_0x00c0
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r2 = r11.selectPanelState()
            if (r2 == 0) goto L_0x00c0
            java.util.List r2 = r2.getFirstScreenDataSource()
            if (r2 == 0) goto L_0x00c0
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            r2.addAll(r3)
        L_0x00c0:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x025c
            int r1 = r13.getFromDirection()
            boolean r2 = r13.getHasPrev()
            boolean r3 = r13.getHasMore()
            r11.insertData(r1, r0, r2, r3)
            goto L_0x025c
        L_0x00db:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r0 = r11.store
            if (r0 == 0) goto L_0x00fd
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.State r2 = r0.getState()
            boolean r4 = r2 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x00eb
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r2 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r2
            goto L_0x00ec
        L_0x00eb:
            r2 = r3
        L_0x00ec:
            if (r2 == 0) goto L_0x00f5
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r4 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r2 = r2.select(r4)
            goto L_0x00f6
        L_0x00f5:
            r2 = r3
        L_0x00f6:
            com.baidu.searchbox.video.detail.core.model.IntentData r2 = (com.baidu.searchbox.video.detail.core.model.IntentData) r2
            if (r2 == 0) goto L_0x00fd
            java.lang.String r0 = r2.page
            goto L_0x00fe
        L_0x00fd:
            r0 = r3
        L_0x00fe:
            boolean r1 = r11.isPageFromMerge(r0)
            if (r1 == 0) goto L_0x011a
            java.util.List r1 = r11.getDataSourceFromCollectionPoster()
            if (r1 == 0) goto L_0x0113
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0114
        L_0x0113:
            r1 = r3
        L_0x0114:
            int r1 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r1)
            if (r1 > 0) goto L_0x025c
        L_0x011a:
            java.util.List r1 = r13.getItems()
            boolean r2 = kotlin.jvm.internal.TypeIntrinsics.isMutableList(r1)
            if (r2 == 0) goto L_0x0126
            r6 = r1
            goto L_0x0127
        L_0x0126:
            r6 = r3
        L_0x0127:
            if (r6 == 0) goto L_0x0185
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r2 = r11.store
            if (r2 == 0) goto L_0x0182
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r2.getState()
            boolean r7 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x013a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x013b
        L_0x013a:
            r5 = r3
        L_0x013b:
            if (r5 == 0) goto L_0x0143
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r3 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r3 = r5.select(r3)
        L_0x0143:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r3 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r3
            if (r3 == 0) goto L_0x0182
            r2 = r3
            r3 = 0
            boolean r5 = r13.isCollectionRequest()
            boolean r7 = r13.getHasPrev()
            boolean r8 = r13.getHasMore()
            com.baidu.searchbox.flowvideo.collection.repos.PlayLetInfoModel r9 = r13.getPlayLetInfo()
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel r10 = r2.getShortPlayIntroduceModel()
            r4 = r11
            r4.updateFirstScreenList(r5, r6, r7, r8, r9, r10)
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.PagesContentClickType r4 = r2.getClickPagesContentType()
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.PagesContentClickType r5 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.PagesContentClickType.CLICK_LAST_PAGES_TYPE
            if (r4 == r5) goto L_0x0170
            boolean r4 = r2.isLastPageOfCollection()
            if (r4 == 0) goto L_0x0181
        L_0x0170:
            boolean r4 = r2.getHasSimilar()
            if (r4 == 0) goto L_0x0181
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r4 = r11.store
            if (r4 == 0) goto L_0x0181
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$RequestShortPlayDataAction r5 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction.RequestShortPlayDataAction.INSTANCE
            com.baidu.searchbox.feed.detail.frame.Action r5 = (com.baidu.searchbox.feed.detail.frame.Action) r5
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r4, r5)
        L_0x0181:
        L_0x0182:
            goto L_0x025c
        L_0x0185:
            goto L_0x025c
        L_0x0187:
            java.util.List r0 = r12.getDataShortPlaySource()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x01a1
            java.util.List r0 = r12.getDataShortPlaySource()
            java.util.List r4 = r13.getItems()
            java.util.List r0 = r11.removeDuplicateOrAd(r0, r4)
            goto L_0x01a5
        L_0x01a1:
            java.util.List r0 = r13.getItems()
        L_0x01a5:
            java.util.List r4 = r12.getDataShortPlaySource()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.getOrNull(r4, r2)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r4
            int r5 = r0.size()
            int r5 = r5 - r1
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r0, r5)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            java.util.List r6 = r12.getDataShortPlaySource()
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x01fe
            if (r4 == 0) goto L_0x01cf
            java.lang.Object r6 = r4.getData()
            goto L_0x01d0
        L_0x01cf:
            r6 = r3
        L_0x01d0:
            boolean r6 = r6 instanceof com.baidu.searchbox.video.feedflow.flow.list.ShortMoreItemModel
            if (r6 != 0) goto L_0x01fe
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r6 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r5)
            if (r6 == 0) goto L_0x01fa
            if (r4 == 0) goto L_0x01e6
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r7 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r4)
            if (r7 == 0) goto L_0x01e6
            java.lang.Integer r3 = r7.getPosition()
        L_0x01e6:
            int r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r3)
            int r3 = r3 - r1
            java.lang.Integer r6 = r6.getPosition()
            if (r6 != 0) goto L_0x01f2
            goto L_0x01fa
        L_0x01f2:
            int r6 = r6.intValue()
            if (r3 != r6) goto L_0x01fa
            r3 = r1
            goto L_0x01fb
        L_0x01fa:
            r3 = r2
        L_0x01fb:
            if (r3 != 0) goto L_0x01fe
            return
        L_0x01fe:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r3 = r11.selectPanelState()
            if (r3 == 0) goto L_0x0210
            java.util.List r3 = r3.getDataShortPlaySource()
            if (r3 == 0) goto L_0x0210
            r6 = r0
            java.util.Collection r6 = (java.util.Collection) r6
            r3.addAll(r2, r6)
        L_0x0210:
            boolean r3 = r11.supportPages()
            if (r3 == 0) goto L_0x0243
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x0243
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r3 = r11.selectPanelState()
            if (r3 == 0) goto L_0x022e
            boolean r3 = r3.getHasClickPageTab()
            if (r3 != 0) goto L_0x022e
            r3 = r1
            goto L_0x022f
        L_0x022e:
            r3 = r2
        L_0x022f:
            if (r3 == 0) goto L_0x0243
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r3 = r11.selectPanelState()
            if (r3 == 0) goto L_0x0243
            java.util.List r3 = r3.getFirstScreenDataSource()
            if (r3 == 0) goto L_0x0243
            r6 = r0
            java.util.Collection r6 = (java.util.Collection) r6
            r3.addAll(r2, r6)
        L_0x0243:
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x025c
            int r1 = r13.getFromDirection()
            boolean r2 = r13.getHasPrev()
            boolean r3 = r13.getHasMore()
            r11.insertData(r1, r0, r2, r3)
        L_0x025c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.handleReceiveData(com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState, com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel):void");
    }

    private final void syncDataSource() {
        Store $this$select$iv = this.store;
        if ($this$select$iv != null) {
            AbsState state = $this$select$iv.getState();
            PlayLetInfoModel playLetInfoModel = null;
            CommonState commonState = state instanceof CommonState ? (CommonState) state : null;
            ShortPlayPanelState shortPlayPanelState = (ShortPlayPanelState) (commonState != null ? commonState.select(ShortPlayPanelState.class) : null);
            if (shortPlayPanelState != null) {
                ShortPlayPanelState $this$syncDataSource_u24lambda_u2d21 = shortPlayPanelState;
                List items = new ArrayList();
                items.addAll($this$syncDataSource_u24lambda_u2d21.getDataShortPlaySource());
                CollectionFlowModel value = $this$syncDataSource_u24lambda_u2d21.getCollectionModel().getValue();
                boolean orFalse = BdPlayerUtils.orFalse(value != null ? Boolean.valueOf(value.isCollectionRequest()) : null);
                boolean orFalse2 = BdPlayerUtils.orFalse($this$syncDataSource_u24lambda_u2d21.getHasPrev());
                boolean orFalse3 = BdPlayerUtils.orFalse($this$syncDataSource_u24lambda_u2d21.getHasNext());
                CollectionFlowModel value2 = $this$syncDataSource_u24lambda_u2d21.getCollectionModel().getValue();
                if (value2 != null) {
                    playLetInfoModel = value2.getPlayLetInfo();
                }
                updateFirstScreenList(orFalse, items, orFalse2, orFalse3, playLetInfoModel, $this$syncDataSource_u24lambda_u2d21.getShortPlayIntroduceModel());
            }
        }
    }

    static /* synthetic */ void updateFirstScreenList$default(ShortPlayCommonListView shortPlayCommonListView, boolean z, List list, boolean z2, boolean z3, PlayLetInfoModel playLetInfoModel, ShortPlayIntroduceModel shortPlayIntroduceModel, int i2, Object obj) {
        shortPlayCommonListView.updateFirstScreenList(z, list, z2, z3, playLetInfoModel, (i2 & 32) != 0 ? null : shortPlayIntroduceModel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateFirstScreenList(boolean r20, java.util.List<com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?>> r21, boolean r22, boolean r23, com.baidu.searchbox.flowvideo.collection.repos.PlayLetInfoModel r24, com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel r25) {
        /*
            r19 = this;
            r0 = r19
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r1 = r19.selectPanelState()
            if (r1 == 0) goto L_0x01c6
            r2 = 0
            java.util.List r3 = r1.getDataShortPlaySource()
            r3.clear()
            java.util.List r3 = r1.getDataShortPlaySource()
            r4 = r21
            java.util.List r3 = r0.removeDuplicateOrAd(r3, r4)
            java.util.List r5 = r1.getDataShortPlaySource()
            r6 = r3
            java.util.Collection r6 = (java.util.Collection) r6
            r5.addAll(r6)
            int r5 = r3.size()
            r14 = 0
            r13 = 1
            if (r5 < r13) goto L_0x0068
            int r5 = r3.size()
            int r5 = r5 - r13
            java.lang.Object r5 = r3.get(r5)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r5 = com.baidu.searchbox.video.feedflow.flow.list.FlowModelUtilsKt.transformVideoItemModel(r5)
            if (r5 == 0) goto L_0x0062
            java.lang.Integer r5 = r5.getPosition()
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r6 = r1.getCurCollectionModel()
            if (r6 == 0) goto L_0x0050
            int r6 = r6.getCollNum()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x0051
        L_0x0050:
            r6 = 0
        L_0x0051:
            int r6 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r6)
            if (r5 != 0) goto L_0x0058
            goto L_0x0060
        L_0x0058:
            int r5 = r5.intValue()
            if (r5 != r6) goto L_0x0060
            r5 = r13
            goto L_0x0063
        L_0x0060:
            r5 = r14
            goto L_0x0063
        L_0x0062:
            r5 = r14
        L_0x0063:
            if (r5 != 0) goto L_0x0068
            r1.setLastPageOfCollection(r14)
        L_0x0068:
            boolean r5 = r0.isLoadFirstScreen
            if (r5 != 0) goto L_0x00b9
            boolean r5 = r19.supportPages()
            if (r5 == 0) goto L_0x00b9
            java.util.List r5 = r1.getDataShortPlaySource()
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r13
            if (r5 == 0) goto L_0x00b9
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r5 = r0.store
            if (r5 == 0) goto L_0x00a1
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r5.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x008f
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0090
        L_0x008f:
            r7 = 0
        L_0x0090:
            if (r7 == 0) goto L_0x0099
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r8 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x009a
        L_0x0099:
            r7 = 0
        L_0x009a:
            com.baidu.searchbox.video.detail.core.model.IntentData r7 = (com.baidu.searchbox.video.detail.core.model.IntentData) r7
            if (r7 == 0) goto L_0x00a1
            java.lang.String r5 = r7.page
            goto L_0x00a2
        L_0x00a1:
            r5 = 0
        L_0x00a2:
            boolean r5 = r0.isPageFromMerge(r5)
            if (r5 == 0) goto L_0x00b9
            if (r20 == 0) goto L_0x00b9
            java.util.List r5 = r1.getFirstScreenDataSource()
            java.util.List r6 = r1.getDataShortPlaySource()
            java.util.Collection r6 = (java.util.Collection) r6
            r5.addAll(r6)
            r0.isLoadFirstScreen = r13
        L_0x00b9:
            java.util.Set r12 = r1.getGrayList()
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r5 = r0.store
            if (r5 == 0) goto L_0x00cb
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$UpdatePanelListGray r6 = new com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction$UpdatePanelListGray
            r6.<init>(r12)
            com.baidu.searchbox.feed.detail.frame.Action r6 = (com.baidu.searchbox.feed.detail.frame.Action) r6
            r5.dispatch(r6)
        L_0x00cb:
            boolean r5 = r19.getHasPageTab()
            if (r5 == 0) goto L_0x00ed
            java.util.List r5 = r1.getDataShortPlaySource()
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r13
            if (r5 == 0) goto L_0x00e6
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState$Success r5 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState.Success.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState r5 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState) r5
            r0.changeContent(r5)
            goto L_0x00ed
        L_0x00e6:
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState$Empty r5 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState.Empty.INSTANCE
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState r5 = (com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelContentState) r5
            r0.changeContent(r5)
        L_0x00ed:
            r19.setPageItemCanResponseClick()
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayListModel r16 = new com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayListModel
            boolean r9 = r19.supportPages()
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r5 = r0.store
            if (r5 == 0) goto L_0x0128
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r5.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x010a
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x010b
        L_0x010a:
            r7 = 0
        L_0x010b:
            if (r7 == 0) goto L_0x0114
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0115
        L_0x0114:
            r7 = 0
        L_0x0115:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r7
            if (r7 == 0) goto L_0x0128
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r5 = r7.getCurCollectionModel()
            if (r5 == 0) goto L_0x0128
            int r5 = r5.getCollNum()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x0129
        L_0x0128:
            r5 = 0
        L_0x0129:
            int r10 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r5)
            r5 = r16
            r6 = r3
            r7 = r22
            r8 = r23
            r11 = r25
            r17 = r12
            r12 = r24
            r15 = r13
            r13 = r20
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            com.baidu.searchbox.video.feedflow.flow.collection.view.common.CollectionCommonModel r5 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayListViewKt.createShortPlayListModel(r16)
            r0.bindData(r5)
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView$updateFirstScreenList$1$1 r5 = new com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView$updateFirstScreenList$1$1
            r5.<init>(r0)
            com.baidu.searchbox.video.feedflow.flow.collection.view.collectionpages.CollectionPagesAdapter$PageItemClickListener r5 = (com.baidu.searchbox.video.feedflow.flow.collection.view.collectionpages.CollectionPagesAdapter.PageItemClickListener) r5
            r0.setOnPageItemClickListener(r5)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = r19.getSelectedModel()
            r0.syncRecordCollection(r5)
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r5 = r0.store
            if (r5 == 0) goto L_0x0182
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r5.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x016b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x016c
        L_0x016b:
            r7 = 0
        L_0x016c:
            if (r7 == 0) goto L_0x0175
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r8 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r7 = r7.select(r8)
            goto L_0x0176
        L_0x0175:
            r7 = 0
        L_0x0176:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r7 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r7
            if (r7 == 0) goto L_0x0182
            boolean r5 = r7.getHasClickPageTab()
            if (r5 != r15) goto L_0x0182
            r13 = r15
            goto L_0x0183
        L_0x0182:
            r13 = r14
        L_0x0183:
            if (r13 == 0) goto L_0x01b4
            java.util.List r5 = r1.getDataShortPlaySource()
            java.lang.Object r5 = kotlin.collections.CollectionsKt.getOrNull(r5, r14)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x0198
            java.lang.String r5 = r5.getId()
            r18 = r5
            goto L_0x019a
        L_0x0198:
            r18 = 0
        L_0x019a:
            r5 = r18
            if (r5 == 0) goto L_0x01aa
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            r6 = r6 ^ r15
            if (r6 != r15) goto L_0x01aa
            r13 = r15
            goto L_0x01ab
        L_0x01aa:
            r13 = r14
        L_0x01ab:
            if (r13 == 0) goto L_0x01c1
            r0.setExpandStatus(r14)
            r0.scrollToPositionById(r5, r14)
            goto L_0x01c1
        L_0x01b4:
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r5 = r0.store
            int r5 = com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelPluginKt.getItemStyle(r5)
            r0.changeStyle(r5)
            r5 = 0
            scrollToPositionAndHighlight$default(r0, r5, r15, r5)
        L_0x01c1:
            r0.setHasReportedIntroduceShow(r14)
            goto L_0x01c8
        L_0x01c6:
            r4 = r21
        L_0x01c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.updateFirstScreenList(boolean, java.util.List, boolean, boolean, com.baidu.searchbox.flowvideo.collection.repos.PlayLetInfoModel, com.baidu.searchbox.video.feedflow.flow.shortplaypanel.model.ShortPlayIntroduceModel):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean supportPages() {
        /*
            r7 = this;
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r0 = r7.store
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x0030
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0013
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0014
        L_0x0013:
            r5 = r3
        L_0x0014:
            if (r5 == 0) goto L_0x001d
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r6 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x001e
        L_0x001d:
            r5 = r3
        L_0x001e:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r5
            if (r5 == 0) goto L_0x0030
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r0 = r5.getCurCollectionModel()
            if (r0 == 0) goto L_0x0030
            boolean r0 = r0.getWithTabFilter()
            if (r0 != r1) goto L_0x0030
            r0 = r1
            goto L_0x0031
        L_0x0030:
            r0 = r2
        L_0x0031:
            if (r0 == 0) goto L_0x0069
            com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r0 = r7.store
            if (r0 == 0) goto L_0x0060
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0043
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0044
        L_0x0043:
            r5 = r3
        L_0x0044:
            if (r5 == 0) goto L_0x004d
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState> r6 = com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x004e
        L_0x004d:
            r5 = r3
        L_0x004e:
            com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState r5 = (com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelState) r5
            if (r5 == 0) goto L_0x0060
            com.baidu.searchbox.video.feedflow.flow.collection.CollectionFlowModel r0 = r5.getCurCollectionModel()
            if (r0 == 0) goto L_0x0060
            int r0 = r0.getCollNum()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
        L_0x0060:
            int r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r3)
            r3 = 20
            if (r0 < r3) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r1 = r2
        L_0x006a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view.ShortPlayCommonListView.supportPages():boolean");
    }

    private final List<ItemModel<?>> removeDuplicateOrAd(List<ItemModel<?>> oldList, List<? extends ItemModel<?>> newList) {
        if (newList.isEmpty()) {
            return new ArrayList<>();
        }
        HashSet set = new HashSet();
        int size = oldList.size();
        for (int i2 = 0; i2 < size; i2++) {
            set.add(oldList.get(i2).getId());
        }
        List tmp = new ArrayList();
        int size2 = newList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            if (!ItemTypeManifestKt.isAdsItem((ItemModel<?>) (ItemModel) newList.get(i3)) && set.add(((ItemModel) newList.get(i3)).getId())) {
                tmp.add(newList.get(i3));
            }
        }
        return tmp;
    }

    private final void syncRecordCollection(ItemModel<?> itemModel) {
        Store<AbsState> store2;
        Integer position;
        VideoItemModel videoItemModel = null;
        if (((itemModel != null ? itemModel.getData() : null) instanceof VideoItemModel) && (store2 = this.store) != null) {
            String id = itemModel.getId();
            Object data = itemModel.getData();
            if (data instanceof VideoItemModel) {
                videoItemModel = (VideoItemModel) data;
            }
            StoreExtKt.post(store2, new RecordCollectionAction(id, (videoItemModel == null || (position = videoItemModel.getPosition()) == null) ? -1 : position.intValue()));
        }
    }

    private final ItemModel<?> getSelectedModel() {
        IFlowComponentService flowComponentService;
        ComponentArchManager $this$getService$iv = this.manager;
        if ($this$getService$iv != null) {
            flowComponentService = (IFlowComponentService) $this$getService$iv.getService(IFlowComponentService.class);
        } else {
            flowComponentService = null;
        }
        List dataSource = flowComponentService != null ? flowComponentService.getDataSource() : null;
        int currPosition = flowComponentService != null ? flowComponentService.getCurItemPosition() : -1;
        boolean z = false;
        if (dataSource != null && (!dataSource.isEmpty())) {
            z = true;
        }
        if (!z || currPosition < 0) {
            return null;
        }
        return (ItemModel) CollectionsKt.getOrNull(dataSource, currPosition);
    }

    private final void scrollToPositionById(String id, boolean isFromFirstShow) {
        int selectPosition = -1;
        List<ItemModel<?>> $this$forEachIndexed$iv = getSource();
        if ($this$forEachIndexed$iv != null) {
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual((Object) ((ItemModel) item$iv).getId(), (Object) id)) {
                    selectPosition = index;
                }
                index = index$iv;
            }
        }
        if (selectPosition == 0) {
            scrollTo(selectPosition, isFromFirstShow);
        } else if (selectPosition > 0) {
            scrollTo(selectPosition - 1, isFromFirstShow);
        }
    }

    public final void autoShowPanel(boolean isShow) {
        if (isShow) {
            changeStyle(CollectionPanelPluginKt.getItemStyle(this.store));
            scrollToPositionAndHighlight$default(this, (ItemModel) null, 1, (Object) null);
            showOrHidePagesView(true);
        }
    }

    public final void showPanel() {
        changeStyle(CollectionPanelPluginKt.getItemStyle(this.store));
        scrollToPositionAndHighlight$default(this, (ItemModel) null, 1, (Object) null);
        showOrHidePagesView(true);
    }

    /* access modifiers changed from: protected */
    public void uploadShortMoreViewShow() {
        Store<AbsState> store2 = this.store;
        if (store2 != null) {
            StoreExtKt.post(store2, ShortPlayPanelAction.ShowShortPlayMoreViewAction.INSTANCE);
        }
    }
}
