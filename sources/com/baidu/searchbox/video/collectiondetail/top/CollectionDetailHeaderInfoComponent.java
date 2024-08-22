package com.baidu.searchbox.video.collectiondetail.top;

import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState;
import com.baidu.searchbox.video.collectiondetail.list.CollectionDetailAction;
import com.baidu.searchbox.video.collectiondetail.service.ICollectionDetailLayoutService;
import com.baidu.searchbox.video.component.ext.StoreExtKt;
import com.baidu.searchbox.video.feedflow.detail.night.NightModeState;
import com.baidu.searchbox.video.feedflow.detail.subscribe.SubscribeModel;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\bH\u0002J\u0012\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/collectiondetail/top/CollectionDetailHeaderInfoComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "rootView", "Lcom/baidu/searchbox/video/collectiondetail/top/CollectionDetailHeaderInfoView;", "createView", "Landroid/view/View;", "onAttachToManager", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "onResume", "setHeaderInfoData", "headerData", "Lcom/baidu/searchbox/video/collectiondetail/top/CollectionDetailHeaderInfoModel;", "updateFavorUI", "favorModel", "Lcom/baidu/searchbox/video/collectiondetail/top/CollectionDetailHeaderInfoFavorModel;", "updateNightMode", "updateSubscribeUI", "subscribeModel", "Lcom/baidu/searchbox/video/feedflow/detail/subscribe/SubscribeModel;", "collection-flow_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionDetailHeaderInfoComponent.kt */
public final class CollectionDetailHeaderInfoComponent extends LiveDataComponent {
    private CollectionDetailHeaderInfoView rootView;

    public View createView() {
        CollectionDetailHeaderInfoView $this$createView_u24lambda_u2d0 = new CollectionDetailHeaderInfoView(getContext(), (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$createView_u24lambda_u2d0.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        $this$createView_u24lambda_u2d0.setClickCallback(new CollectionDetailHeaderInfoComponent$createView$1$1(this));
        this.rootView = $this$createView_u24lambda_u2d0;
        return $this$createView_u24lambda_u2d0;
    }

    public void onAttachToManager() {
        FontSizeState fontSizeState;
        MutableLiveData<Unit> action;
        CollectionDetailFavorState $this$onAttachToManager_u24lambda_u2d10;
        NightModeState $this$onAttachToManager_u24lambda_u2d6;
        CollectionDetailHeaderInfoState $this$onAttachToManager_u24lambda_u2d4;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if (!($this$subscribe$iv == null || ($this$onAttachToManager_u24lambda_u2d4 = (CollectionDetailHeaderInfoState) $this$subscribe$iv.subscribe(CollectionDetailHeaderInfoState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d4.getHeaderModel().observe(this, new CollectionDetailHeaderInfoComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d4.getSubscribeShow().observe(this, new CollectionDetailHeaderInfoComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d4.getSubscribeBackModel().observe(this, new CollectionDetailHeaderInfoComponent$$ExternalSyntheticLambda2(this));
        }
        Store $this$subscribe$iv2 = getStore();
        if (!($this$subscribe$iv2 == null || ($this$onAttachToManager_u24lambda_u2d6 = (NightModeState) $this$subscribe$iv2.subscribe(NightModeState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d6.getData().observe(this, new CollectionDetailHeaderInfoComponent$$ExternalSyntheticLambda3(this));
        }
        Store $this$subscribe$iv3 = getStore();
        if (!($this$subscribe$iv3 == null || ($this$onAttachToManager_u24lambda_u2d10 = (CollectionDetailFavorState) $this$subscribe$iv3.subscribe(CollectionDetailFavorState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d10.getFavorModel().observe(this, new CollectionDetailHeaderInfoComponent$$ExternalSyntheticLambda4(this));
            $this$onAttachToManager_u24lambda_u2d10.getFavorBackModel().observe(this, new CollectionDetailHeaderInfoComponent$$ExternalSyntheticLambda5(this, $this$onAttachToManager_u24lambda_u2d10));
        }
        Store $this$subscribe$iv4 = getStore();
        if ($this$subscribe$iv4 != null && (fontSizeState = (FontSizeState) $this$subscribe$iv4.subscribe(FontSizeState.class)) != null && (action = fontSizeState.getAction()) != null) {
            action.observe(this, new CollectionDetailHeaderInfoComponent$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-4$lambda-1  reason: not valid java name */
    public static final void m5054onAttachToManager$lambda4$lambda1(CollectionDetailHeaderInfoComponent this$0, CollectionDetailHeaderInfoModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(model, "model");
        this$0.setHeaderInfoData(model);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-4$lambda-2  reason: not valid java name */
    public static final void m5055onAttachToManager$lambda4$lambda2(CollectionDetailHeaderInfoComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateSubscribeUI((SubscribeModel) null);
        Store<AbsState> store = this$0.getStore();
        if (store != null) {
            StoreExtKt.post(store, CollectionDetailAction.CollectionSubscribeShowAction.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-4$lambda-3  reason: not valid java name */
    public static final void m5056onAttachToManager$lambda4$lambda3(CollectionDetailHeaderInfoComponent this$0, SubscribeModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateSubscribeUI(model);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-6$lambda-5  reason: not valid java name */
    public static final void m5057onAttachToManager$lambda6$lambda5(CollectionDetailHeaderInfoComponent this$0, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateNightMode();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        if (r4 != null) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* renamed from: onAttachToManager$lambda-10$lambda-7  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5051onAttachToManager$lambda10$lambda7(com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoComponent r8, com.baidu.searchbox.flowvideo.detail.repos.FavorModel r9) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            r1 = 0
            if (r0 == 0) goto L_0x0037
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.State r3 = r0.getState()
            boolean r4 = r3 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r4 == 0) goto L_0x0019
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r3 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r3
            goto L_0x001a
        L_0x0019:
            r3 = r1
        L_0x001a:
            if (r3 == 0) goto L_0x0023
            java.lang.Class<com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig> r4 = com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig.class
            java.lang.Object r3 = r3.select(r4)
            goto L_0x0024
        L_0x0023:
            r3 = r1
        L_0x0024:
            com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig r3 = (com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig) r3
            if (r3 == 0) goto L_0x0037
            com.baidu.searchbox.video.feedflow.common.config.ShortPlayFavorConfig r0 = r3.getShortFavorSwitchConfig()
            if (r0 == 0) goto L_0x0037
            boolean r0 = r0.getSwitch()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0038
        L_0x0037:
            r0 = r1
        L_0x0038:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)
            com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoFavorModel r2 = new com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoFavorModel
            r3 = 1
            com.baidu.searchbox.feed.detail.frame.Store r4 = r8.getStore()
            if (r4 == 0) goto L_0x0067
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0052
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0053
        L_0x0052:
            r6 = r1
        L_0x0053:
            if (r6 == 0) goto L_0x005c
            java.lang.Class<com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState> r7 = com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x005d
        L_0x005c:
            r6 = r1
        L_0x005d:
            com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState r6 = (com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState) r6
            if (r6 == 0) goto L_0x0067
            java.lang.String r4 = r6.getCollType()
            if (r4 != 0) goto L_0x0069
        L_0x0067:
            java.lang.String r4 = "collection_type_normal"
        L_0x0069:
            r2.<init>(r1, r3, r0, r4)
            r8.updateFavorUI(r2)
            com.baidu.searchbox.feed.detail.frame.Store r1 = r8.getStore()
            if (r1 == 0) goto L_0x007f
            com.baidu.searchbox.video.feedflow.detail.favor.QueryFavorAction r2 = new com.baidu.searchbox.video.feedflow.detail.favor.QueryFavorAction
            r2.<init>(r9)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x007f:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r8.getStore()
            if (r1 == 0) goto L_0x008f
            com.baidu.searchbox.video.collectiondetail.list.CollectionDetailAction$CollectionFavorShowAction r2 = new com.baidu.searchbox.video.collectiondetail.list.CollectionDetailAction$CollectionFavorShowAction
            r2.<init>(r0)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoComponent.m5051onAttachToManager$lambda10$lambda7(com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoComponent, com.baidu.searchbox.flowvideo.detail.repos.FavorModel):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
        if (r4 != null) goto L_0x007d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* renamed from: onAttachToManager$lambda-10$lambda-9  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m5052onAttachToManager$lambda10$lambda9(com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoComponent r9, com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState r10, com.baidu.searchbox.video.feedflow.detail.favor.FavorBackModel r11) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "$this_apply"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            if (r11 == 0) goto L_0x0015
            r0 = r11
            r1 = 0
            r2 = 1
            r10.setCollFavorBack(r2)
        L_0x0015:
            com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoFavorModel r0 = new com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoFavorModel
            boolean r1 = r11.isFavor()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2 = 0
            com.baidu.searchbox.feed.detail.frame.Store r3 = r9.getStore()
            r4 = 0
            if (r3 == 0) goto L_0x0051
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r3.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0033
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0034
        L_0x0033:
            r6 = r4
        L_0x0034:
            if (r6 == 0) goto L_0x003d
            java.lang.Class<com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig> r7 = com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x003e
        L_0x003d:
            r6 = r4
        L_0x003e:
            com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig r6 = (com.baidu.searchbox.video.assemble.config.FeedCollectionGcpConfig) r6
            if (r6 == 0) goto L_0x0051
            com.baidu.searchbox.video.feedflow.common.config.ShortPlayFavorConfig r3 = r6.getShortFavorSwitchConfig()
            if (r3 == 0) goto L_0x0051
            boolean r3 = r3.getSwitch()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0052
        L_0x0051:
            r3 = r4
        L_0x0052:
            boolean r3 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r3)
            com.baidu.searchbox.feed.detail.frame.Store r5 = r9.getStore()
            if (r5 == 0) goto L_0x007b
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r5.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0068
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0069
        L_0x0068:
            r7 = r4
        L_0x0069:
            if (r7 == 0) goto L_0x0071
            java.lang.Class<com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState> r4 = com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState.class
            java.lang.Object r4 = r7.select(r4)
        L_0x0071:
            com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState r4 = (com.baidu.searchbox.video.collectiondetail.list.CollectionDetailState) r4
            if (r4 == 0) goto L_0x007b
            java.lang.String r4 = r4.getCollType()
            if (r4 != 0) goto L_0x007d
        L_0x007b:
            java.lang.String r4 = "collection_type_normal"
        L_0x007d:
            r0.<init>(r1, r2, r3, r4)
            r9.updateFavorUI(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoComponent.m5052onAttachToManager$lambda10$lambda9(com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoComponent, com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState, com.baidu.searchbox.video.feedflow.detail.favor.FavorBackModel):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11  reason: not valid java name */
    public static final void m5053onAttachToManager$lambda11(CollectionDetailHeaderInfoComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CollectionDetailHeaderInfoView collectionDetailHeaderInfoView = this$0.rootView;
        if (collectionDetailHeaderInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            collectionDetailHeaderInfoView = null;
        }
        collectionDetailHeaderInfoView.updateViewFont();
        ICollectionDetailLayoutService iCollectionDetailLayoutService = (ICollectionDetailLayoutService) this$0.getManager().getService(ICollectionDetailLayoutService.class);
        if (iCollectionDetailLayoutService != null) {
            iCollectionDetailLayoutService.requestLayoutListView();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0097, code lost:
        if ((r3.length() == 0) == true) goto L_0x009b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x009d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r9 = this;
            super.onResume()
            com.baidu.searchbox.feed.detail.frame.Store r0 = r9.getStore()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x002f
            r4 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r0.getState()
            boolean r6 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r6 == 0) goto L_0x0018
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5
            goto L_0x0019
        L_0x0018:
            r5 = r3
        L_0x0019:
            if (r5 == 0) goto L_0x0022
            java.lang.Class<com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState> r6 = com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState.class
            java.lang.Object r5 = r5.select(r6)
            goto L_0x0023
        L_0x0022:
            r5 = r3
        L_0x0023:
            com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState r5 = (com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState) r5
            if (r5 == 0) goto L_0x002f
            boolean r0 = r5.isCollFavorBack()
            if (r0 != r1) goto L_0x002f
            r0 = r1
            goto L_0x0030
        L_0x002f:
            r0 = r2
        L_0x0030:
            com.baidu.searchbox.feed.detail.frame.Store r4 = r9.getStore()
            if (r4 == 0) goto L_0x005e
            r5 = 0
            com.baidu.searchbox.feed.detail.frame.State r6 = r4.getState()
            boolean r7 = r6 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r7 == 0) goto L_0x0042
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r6 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r6
            goto L_0x0043
        L_0x0042:
            r6 = r3
        L_0x0043:
            if (r6 == 0) goto L_0x004c
            java.lang.Class<com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState> r7 = com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState.class
            java.lang.Object r6 = r6.select(r7)
            goto L_0x004d
        L_0x004c:
            r6 = r3
        L_0x004d:
            com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState r6 = (com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState) r6
            if (r6 == 0) goto L_0x005e
            androidx.lifecycle.MutableLiveData r4 = r6.getFavorModel()
            if (r4 == 0) goto L_0x005e
            java.lang.Object r4 = r4.getValue()
            com.baidu.searchbox.flowvideo.detail.repos.FavorModel r4 = (com.baidu.searchbox.flowvideo.detail.repos.FavorModel) r4
            goto L_0x005f
        L_0x005e:
            r4 = r3
        L_0x005f:
            com.baidu.searchbox.feed.detail.frame.Store r5 = r9.getStore()
            if (r5 == 0) goto L_0x009a
            r6 = 0
            com.baidu.searchbox.feed.detail.frame.State r7 = r5.getState()
            boolean r8 = r7 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState
            if (r8 == 0) goto L_0x0071
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r7 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r7
            goto L_0x0072
        L_0x0071:
            r7 = r3
        L_0x0072:
            if (r7 == 0) goto L_0x007a
            java.lang.Class<com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState> r3 = com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState.class
            java.lang.Object r3 = r7.select(r3)
        L_0x007a:
            com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState r3 = (com.baidu.searchbox.video.collectiondetail.favor.CollectionDetailFavorState) r3
            if (r3 == 0) goto L_0x009a
            androidx.lifecycle.MutableLiveData r3 = r3.getUkey()
            if (r3 == 0) goto L_0x009a
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x009a
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0096
            r3 = r1
            goto L_0x0097
        L_0x0096:
            r3 = r2
        L_0x0097:
            if (r3 != r1) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r1 = r2
        L_0x009b:
            if (r1 != 0) goto L_0x00af
            if (r0 == 0) goto L_0x00af
            com.baidu.searchbox.feed.detail.frame.Store r1 = r9.getStore()
            if (r1 == 0) goto L_0x00af
            com.baidu.searchbox.video.feedflow.detail.favor.QueryFavorAction r2 = new com.baidu.searchbox.video.feedflow.detail.favor.QueryFavorAction
            r2.<init>(r4)
            com.baidu.searchbox.feed.detail.frame.Action r2 = (com.baidu.searchbox.feed.detail.frame.Action) r2
            com.baidu.searchbox.video.component.ext.StoreExtKt.post(r1, r2)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.collectiondetail.top.CollectionDetailHeaderInfoComponent.onResume():void");
    }

    private final void updateNightMode() {
        CollectionDetailHeaderInfoView collectionDetailHeaderInfoView = this.rootView;
        if (collectionDetailHeaderInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            collectionDetailHeaderInfoView = null;
        }
        collectionDetailHeaderInfoView.updateUI();
    }

    private final void setHeaderInfoData(CollectionDetailHeaderInfoModel headerData) {
        CollectionDetailHeaderInfoView collectionDetailHeaderInfoView = this.rootView;
        if (collectionDetailHeaderInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            collectionDetailHeaderInfoView = null;
        }
        collectionDetailHeaderInfoView.setHeaderInfoData(headerData);
    }

    private final void updateFavorUI(CollectionDetailHeaderInfoFavorModel favorModel) {
        CollectionDetailHeaderInfoView collectionDetailHeaderInfoView = this.rootView;
        if (collectionDetailHeaderInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            collectionDetailHeaderInfoView = null;
        }
        collectionDetailHeaderInfoView.updateFavorUI(favorModel);
    }

    private final void updateSubscribeUI(SubscribeModel subscribeModel) {
        CollectionDetailHeaderInfoView collectionDetailHeaderInfoView = this.rootView;
        if (collectionDetailHeaderInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            collectionDetailHeaderInfoView = null;
        }
        collectionDetailHeaderInfoView.updateSubscribeUI(subscribeModel);
    }

    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        CollectionDetailHeaderInfoView collectionDetailHeaderInfoView = this.rootView;
        if (collectionDetailHeaderInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            collectionDetailHeaderInfoView = null;
        }
        collectionDetailHeaderInfoView.tryRefresh();
    }

    public void onDestroy() {
        super.onDestroy();
        CollectionDetailHeaderInfoView collectionDetailHeaderInfoView = this.rootView;
        if (collectionDetailHeaderInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            collectionDetailHeaderInfoView = null;
        }
        collectionDetailHeaderInfoView.release();
    }
}
