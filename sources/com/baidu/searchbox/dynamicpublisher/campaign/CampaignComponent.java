package com.baidu.searchbox.dynamicpublisher.campaign;

import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.creative.interfaces.HostPluginAppRuntime;
import com.baidu.searchbox.dynamicpublisher.campaign.CampaignAction;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.ugc.campaign.CampaignView;
import com.baidu.searchbox.ugc.model.CampaignConfigModel;
import com.baidu.searchbox.ugc.model.CampaignModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\f\u0010 \u001a\u00020\u0017*\u00020!H\u0002J\u0014\u0010\"\u001a\u00020\u0017*\u00020!2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0013j\b\u0012\u0004\u0012\u00020\u0004`\u0014X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006#"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/campaign/CampaignComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "campaignModel", "Lcom/baidu/searchbox/ugc/model/CampaignModel;", "campaignView", "Lcom/baidu/searchbox/ugc/campaign/CampaignView;", "getCampaignView", "()Lcom/baidu/searchbox/ugc/campaign/CampaignView;", "campaignView$delegate", "Lkotlin/Lazy;", "guideMsg", "", "hideCampaignView", "", "isMiniVideo", "Ljava/lang/Boolean;", "isShownPlace", "recommendCampaignList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "switch", "checkVideoTypeSupport", "", "type", "", "createView", "onAttachToManager", "refreshCampaign", "selectedCampaign", "showCampaignGuideIfNeed", "showRecommendCampaign", "checkAndLoadCampaign", "Lcom/baidu/searchbox/dynamicpublisher/campaign/CampaignState;", "loadCampaign", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CampaignComponent.kt */
public final class CampaignComponent extends LiveDataComponent {
    /* access modifiers changed from: private */
    public CampaignModel campaignModel;
    private final Lazy campaignView$delegate = LazyKt.lazy(new CampaignComponent$campaignView$2(this));
    private String guideMsg;
    private boolean hideCampaignView;
    /* access modifiers changed from: private */
    public Boolean isMiniVideo;
    /* access modifiers changed from: private */
    public boolean isShownPlace;
    /* access modifiers changed from: private */
    public final ArrayList<CampaignModel> recommendCampaignList = new ArrayList<>();

    /* renamed from: switch  reason: not valid java name */
    private Boolean f1153switch;

    private final CampaignView getCampaignView() {
        return (CampaignView) this.campaignView$delegate.getValue();
    }

    public CampaignView createView() {
        return getCampaignView();
    }

    public void onAttachToManager() {
        CampaignState $this$onAttachToManager_u24lambda_u2d11;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d11 = (CampaignState) store.subscribe((Class<T>) CampaignState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d11.getHideCampaignView().observe(this, new CampaignComponent$$ExternalSyntheticLambda6(this));
            $this$onAttachToManager_u24lambda_u2d11.getSelectedCampaignModel().observe(this, new CampaignComponent$$ExternalSyntheticLambda7(this));
            $this$onAttachToManager_u24lambda_u2d11.getRecommendCampaignList().observe(this, new CampaignComponent$$ExternalSyntheticLambda8(this));
            $this$onAttachToManager_u24lambda_u2d11.getPlaceCampaignModel().observe(this, new CampaignComponent$$ExternalSyntheticLambda9(this));
            $this$onAttachToManager_u24lambda_u2d11.getConfiguration().observe(this, new CampaignComponent$$ExternalSyntheticLambda10(this, $this$onAttachToManager_u24lambda_u2d11));
            $this$onAttachToManager_u24lambda_u2d11.getCollection().observe(this, new CampaignComponent$$ExternalSyntheticLambda11(this));
            $this$onAttachToManager_u24lambda_u2d11.getCollectionDraft().observe(this, new CampaignComponent$$ExternalSyntheticLambda12(this));
            $this$onAttachToManager_u24lambda_u2d11.getRestoration().observe(this, new CampaignComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d11.getVideoPair().observe(this, new CampaignComponent$$ExternalSyntheticLambda2(this, $this$onAttachToManager_u24lambda_u2d11));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-0  reason: not valid java name */
    public static final void m17956onAttachToManager$lambda11$lambda0(CampaignComponent this$0, Boolean isHideCampaignView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isHideCampaignView, "isHideCampaignView");
        this$0.hideCampaignView = isHideCampaignView.booleanValue();
        this$0.getCampaignView().setVisibility(isHideCampaignView.booleanValue() ? 8 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-1  reason: not valid java name */
    public static final void m17957onAttachToManager$lambda11$lambda1(CampaignComponent this$0, CampaignModel selected) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isShownPlace = false;
        this$0.refreshCampaign(selected);
        this$0.getCampaignView().hideRecommendCampaign();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-3  reason: not valid java name */
    public static final void m17959onAttachToManager$lambda11$lambda3(CampaignComponent this$0, ArrayList campaignList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recommendCampaignList.clear();
        Collection collection = campaignList;
        if (collection == null || collection.isEmpty()) {
            this$0.getCampaignView().hideRecommendCampaign();
            this$0.showCampaignGuideIfNeed();
            return;
        }
        Iterator it = campaignList.iterator();
        while (it.hasNext()) {
            this$0.recommendCampaignList.add((CampaignModel) it.next());
        }
        this$0.showRecommendCampaign();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-4  reason: not valid java name */
    public static final void m17960onAttachToManager$lambda11$lambda4(CampaignComponent this$0, CampaignModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (model != null) {
            this$0.isShownPlace = true;
            this$0.campaignModel = model;
            this$0.getCampaignView().showDefaultCampaign(this$0.campaignModel);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-5  reason: not valid java name */
    public static final void m17961onAttachToManager$lambda11$lambda5(CampaignComponent this$0, CampaignState $this_run, CampaignConfigModel config) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        String str = null;
        Boolean valueOf = config != null ? Boolean.valueOf(config.getSwitch()) : null;
        this$0.f1153switch = valueOf;
        if (Intrinsics.areEqual((Object) valueOf, (Object) true)) {
            this$0.guideMsg = config != null ? config.getGuideMsg() : null;
            if (this$0.campaignModel == null) {
                this$0.showCampaignGuideIfNeed();
            } else {
                this$0.getCampaignView().setVisibility(this$0.hideCampaignView ? 8 : 0);
            }
            Store<AbsState> store = this$0.getStore();
            if (store != null) {
                CampaignModel campaignModel2 = this$0.campaignModel;
                if (campaignModel2 != null) {
                    str = campaignModel2.id;
                }
                store.dispatch(new CampaignAction.ShowCampaign(str));
            }
            if (Intrinsics.areEqual((Object) $this_run.getPublishType().getValue(), (Object) "0") || Intrinsics.areEqual((Object) $this_run.getPublishType().getValue(), (Object) "18")) {
                this$0.loadCampaign($this_run, 3);
            } else {
                this$0.checkAndLoadCampaign($this_run);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-6  reason: not valid java name */
    public static final void m17962onAttachToManager$lambda11$lambda6(CampaignComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store<AbsState> store = this$0.getStore();
        if (store != null) {
            store.dispatch(new CampaignAction.SendData(this$0.campaignModel));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-7  reason: not valid java name */
    public static final void m17963onAttachToManager$lambda11$lambda7(CampaignComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store<AbsState> store = this$0.getStore();
        if (store != null) {
            store.dispatch(new CampaignAction.SendDraft(this$0.campaignModel));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-9  reason: not valid java name */
    public static final void m17964onAttachToManager$lambda11$lambda9(CampaignComponent this$0, CampaignModel selectedCampaign) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (selectedCampaign != null) {
            CampaignModel campaignModel2 = selectedCampaign;
            this$0.isShownPlace = true;
            this$0.refreshCampaign(selectedCampaign);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-11$lambda-10  reason: not valid java name */
    public static final void m17958onAttachToManager$lambda11$lambda10(CampaignComponent this$0, CampaignState $this_run, Pair it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        if (Intrinsics.areEqual((Object) this$0.f1153switch, (Object) true)) {
            CampaignModel campaignModel2 = this$0.campaignModel;
            if (!Intrinsics.areEqual((Object) campaignModel2 != null ? campaignModel2.taskOrigin : null, (Object) "duxingxuan")) {
                this$0.campaignModel = null;
                this$0.showCampaignGuideIfNeed();
                this$0.checkAndLoadCampaign($this_run);
            }
        }
    }

    private final void checkAndLoadCampaign(CampaignState $this$checkAndLoadCampaign) {
        ExecutorUtilsExt.postOnElastic(new CampaignComponent$$ExternalSyntheticLambda5($this$checkAndLoadCampaign, this), CampaignComponentKt.LOAD_FILE_TASK_NAME, 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: checkAndLoadCampaign$lambda-16  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m17952checkAndLoadCampaign$lambda16(com.baidu.searchbox.dynamicpublisher.campaign.CampaignState r18, com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent r19) {
        /*
            r1 = r18
            r2 = r19
            java.lang.String r0 = "$this_checkAndLoadCampaign"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            androidx.lifecycle.MutableLiveData r0 = r18.getVideoPair()
            java.lang.Object r0 = r0.getValue()
            kotlin.Pair r0 = (kotlin.Pair) r0
            r3 = 0
            if (r0 == 0) goto L_0x0023
            java.lang.Object r0 = r0.getFirst()
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            r4 = r0
            androidx.lifecycle.MutableLiveData r0 = r18.getVideoPair()
            java.lang.Object r0 = r0.getValue()
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 == 0) goto L_0x0038
            java.lang.Object r0 = r0.getSecond()
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
        L_0x0038:
            r0 = r3
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r6 = 1
            if (r0 == 0) goto L_0x0047
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r0 = 0
            goto L_0x0048
        L_0x0047:
            r0 = r6
        L_0x0048:
            if (r0 != 0) goto L_0x0050
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r6)
            r2.isMiniVideo = r0
        L_0x0050:
            if (r4 == 0) goto L_0x00b8
            r7 = r4
            r8 = 0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00ac }
            r0 = r7
            r9 = 0
            android.media.MediaMetadataRetriever r10 = com.baidu.searchbox.ugc.utils.FileUtils.getMediaMetadataRetriever(r0)     // Catch:{ all -> 0x00ac }
            r11 = r10
            r12 = 0
            r13 = 0
            r14 = 19
            java.lang.String r14 = r11.extractMetadata(r14)     // Catch:{ all -> 0x00ac }
            r15 = -1
            int r14 = com.baidu.searchbox.ugc.utils.UgcNumericConversionKt.toIntSafely(r14, r15)     // Catch:{ all -> 0x00ac }
            r13 = r14
            kotlin.jvm.internal.Ref$IntRef r14 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x00ac }
            r14.<init>()     // Catch:{ all -> 0x00ac }
            r5 = 18
            java.lang.String r5 = r11.extractMetadata(r5)     // Catch:{ all -> 0x00ac }
            int r5 = com.baidu.searchbox.ugc.utils.UgcNumericConversionKt.toIntSafely(r5, r15)     // Catch:{ all -> 0x00ac }
            r14.element = r5     // Catch:{ all -> 0x00ac }
            r5 = 24
            java.lang.String r5 = r11.extractMetadata(r5)     // Catch:{ all -> 0x00ac }
            int r5 = com.baidu.searchbox.ugc.utils.UgcNumericConversionKt.toIntSafely(r5, r15)     // Catch:{ all -> 0x00ac }
            switch(r5) {
                case 90: goto L_0x008b;
                case 270: goto L_0x008b;
                default: goto L_0x008a;
            }     // Catch:{ all -> 0x00ac }
        L_0x008a:
            goto L_0x0094
        L_0x008b:
            r15 = r13
            r17 = 0
            int r6 = r14.element     // Catch:{ all -> 0x00ac }
            r14.element = r13     // Catch:{ all -> 0x00ac }
            r13 = r6
        L_0x0094:
            int r6 = r14.element     // Catch:{ all -> 0x00ac }
            if (r13 <= r6) goto L_0x009b
            r16 = 1
            goto L_0x009d
        L_0x009b:
            r16 = 0
        L_0x009d:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r16)     // Catch:{ all -> 0x00ac }
            r2.isMiniVideo = r6     // Catch:{ all -> 0x00ac }
            r11.release()     // Catch:{ all -> 0x00ac }
            kotlin.Result.m8971constructorimpl(r10)     // Catch:{ all -> 0x00ac }
            goto L_0x00b6
        L_0x00ac:
            r0 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x00b6:
        L_0x00b8:
            androidx.lifecycle.MutableLiveData r0 = r18.getPublishType()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r5 = "0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            r5 = 3
            if (r0 == 0) goto L_0x00cb
            goto L_0x00ec
        L_0x00cb:
            androidx.lifecycle.MutableLiveData r0 = r18.getPublishType()
            java.lang.Object r0 = r0.getValue()
            java.lang.String r6 = "18"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r6)
            if (r0 == 0) goto L_0x00dc
            goto L_0x00ec
        L_0x00dc:
            java.lang.Boolean r0 = r2.isMiniVideo
            r5 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 == 0) goto L_0x00eb
            r5 = 4
            goto L_0x00ec
        L_0x00eb:
            r5 = 2
        L_0x00ec:
            r0 = r5
            r2.checkVideoTypeSupport(r0)
            r2.loadCampaign(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent.m17952checkAndLoadCampaign$lambda16(com.baidu.searchbox.dynamicpublisher.campaign.CampaignState, com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent):void");
    }

    private final void loadCampaign(CampaignState $this$loadCampaign, int type) {
        UiThreadUtils.runOnUiThread(new CampaignComponent$$ExternalSyntheticLambda4(this, type, $this$loadCampaign));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadCampaign$lambda-25  reason: not valid java name */
    public static final void m17954loadCampaign$lambda25(CampaignComponent this$0, int $type, CampaignState $this_loadCampaign) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($this_loadCampaign, "$this_loadCampaign");
        HostPluginAppRuntime.getWebPageEntry().fetchActivityTaskJson(this$0.getContext(), $type, new CampaignComponent$$ExternalSyntheticLambda3(this$0, $this_loadCampaign));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* renamed from: loadCampaign$lambda-25$lambda-24  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m17955loadCampaign$lambda25$lambda24(com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent r27, com.baidu.searchbox.dynamicpublisher.campaign.CampaignState r28, java.lang.String r29) {
        /*
            r1 = r27
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "$this_loadCampaign"
            r2 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            com.baidu.searchbox.ugc.model.CampaignModel r0 = r1.campaignModel
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.taskOrigin
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            java.lang.String r4 = "duxingxuan"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x0020
            return
        L_0x0020:
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0033 }
            r0 = r28
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x0033 }
            r6 = r29
            r5.<init>(r6)     // Catch:{ all -> 0x0031 }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r5)     // Catch:{ all -> 0x0031 }
            goto L_0x0040
        L_0x0031:
            r0 = move-exception
            goto L_0x0036
        L_0x0033:
            r0 = move-exception
            r6 = r29
        L_0x0036:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x0040:
            boolean r4 = kotlin.Result.m8978isSuccessimpl(r0)
            if (r4 == 0) goto L_0x01c3
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            r4 = 0
            java.util.ArrayList<com.baidu.searchbox.ugc.model.CampaignModel> r5 = r1.recommendCampaignList
            r5.clear()
            java.lang.String r5 = "list"
            org.json.JSONArray r5 = r0.optJSONArray(r5)
            if (r5 == 0) goto L_0x01b0
            java.lang.String r7 = "optJSONArray(\"list\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            r7 = 0
            r8 = 0
            int r9 = r5.length()
        L_0x0063:
            if (r8 >= r9) goto L_0x01a6
            java.util.ArrayList<com.baidu.searchbox.ugc.model.CampaignModel> r10 = r1.recommendCampaignList
            com.baidu.searchbox.ugc.model.CampaignModel r11 = new com.baidu.searchbox.ugc.model.CampaignModel
            r11.<init>()
            r12 = r11
            r13 = 0
            org.json.JSONObject r14 = r5.optJSONObject(r8)
            if (r14 == 0) goto L_0x007c
            java.lang.String r15 = "task_name"
            java.lang.String r15 = r14.optString(r15)
            goto L_0x007d
        L_0x007c:
            r15 = 0
        L_0x007d:
            r12.name = r15
            java.lang.String r15 = "id"
            if (r14 == 0) goto L_0x008a
            java.lang.String r16 = r14.optString(r15)
            r3 = r16
            goto L_0x008b
        L_0x008a:
            r3 = 0
        L_0x008b:
            r12.id = r3
            r3 = 0
            if (r14 == 0) goto L_0x009a
            r17 = r0
            java.lang.String r0 = "is_need"
            int r3 = r14.optInt(r0, r3)
            goto L_0x009c
        L_0x009a:
            r17 = r0
        L_0x009c:
            r12.isNeed = r3
            if (r14 == 0) goto L_0x00a8
            java.lang.String r0 = "task_origin"
            java.lang.String r0 = r14.optString(r0)
            goto L_0x00a9
        L_0x00a8:
            r0 = 0
        L_0x00a9:
            r12.taskOrigin = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            r12.topicList = r0
            if (r14 == 0) goto L_0x0170
            java.lang.String r0 = "topic_list"
            org.json.JSONArray r0 = r14.optJSONArray(r0)
            if (r0 == 0) goto L_0x0170
            java.lang.String r3 = "optJSONArray(\"topic_list\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            r3 = 0
            r18 = 0
            int r2 = r0.length()
            r19 = r3
            r3 = r18
        L_0x00d0:
            if (r3 >= r2) goto L_0x0166
            r18 = r2
            org.json.JSONObject r2 = r0.optJSONObject(r3)
            if (r2 == 0) goto L_0x00df
            java.lang.String r20 = r2.optString(r15)
            goto L_0x00e1
        L_0x00df:
            r20 = 0
        L_0x00e1:
            r21 = r20
            if (r2 == 0) goto L_0x00ef
            r20 = r0
            java.lang.String r0 = "title"
            java.lang.String r0 = r2.optString(r0)
            goto L_0x00f2
        L_0x00ef:
            r20 = r0
            r0 = 0
        L_0x00f2:
            r22 = r2
            r2 = r21
            r21 = r2
            java.lang.CharSequence r21 = (java.lang.CharSequence) r21
            boolean r21 = android.text.TextUtils.isEmpty(r21)
            if (r21 != 0) goto L_0x014e
            r21 = r0
            java.lang.CharSequence r21 = (java.lang.CharSequence) r21
            boolean r21 = android.text.TextUtils.isEmpty(r21)
            if (r21 != 0) goto L_0x014e
            r21 = r4
            java.util.List<com.baidu.searchbox.ugc.model.TopicItem> r4 = r12.topicList
            r23 = r5
            com.baidu.searchbox.ugc.model.TopicItem r5 = new com.baidu.searchbox.ugc.model.TopicItem
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r24 = r7
            r7 = 35
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6, r2)
            r6 = r5
            r25 = 0
            r26 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r2 = r2.toString()
            r6.title = r2
            r4.add(r5)
            goto L_0x0156
        L_0x014e:
            r26 = r2
            r21 = r4
            r23 = r5
            r24 = r7
        L_0x0156:
            int r3 = r3 + 1
            r6 = r29
            r2 = r18
            r0 = r20
            r4 = r21
            r5 = r23
            r7 = r24
            goto L_0x00d0
        L_0x0166:
            r20 = r0
            r21 = r4
            r23 = r5
            r24 = r7
            goto L_0x0176
        L_0x0170:
            r21 = r4
            r23 = r5
            r24 = r7
        L_0x0176:
            if (r14 == 0) goto L_0x0181
            java.lang.String r0 = "tiaozhanInfo"
            org.json.JSONObject r0 = r14.optJSONObject(r0)
            goto L_0x0182
        L_0x0181:
            r0 = 0
        L_0x0182:
            if (r0 == 0) goto L_0x0192
            com.baidu.searchbox.ugc.model.TiaoZhanInfo r2 = new com.baidu.searchbox.ugc.model.TiaoZhanInfo
            r2.<init>()
            r3 = r2
            r4 = 0
            r3.parseTiaozhanInfo(r0)
            r12.tiaoZhanInfo = r2
        L_0x0192:
            r10.add(r11)
            int r8 = r8 + 1
            r2 = r28
            r6 = r29
            r0 = r17
            r4 = r21
            r5 = r23
            r7 = r24
            goto L_0x0063
        L_0x01a6:
            r17 = r0
            r21 = r4
            r23 = r5
            r24 = r7
            goto L_0x01b4
        L_0x01b0:
            r17 = r0
            r21 = r4
        L_0x01b4:
            boolean r0 = r1.isShownPlace
            if (r0 != 0) goto L_0x01bc
            r27.showRecommendCampaign()
        L_0x01bc:
            com.baidu.searchbox.ugc.model.CampaignModel r0 = r1.campaignModel
            r1.refreshCampaign(r0)
        L_0x01c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent.m17955loadCampaign$lambda25$lambda24(com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent, com.baidu.searchbox.dynamicpublisher.campaign.CampaignState, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkVideoTypeSupport(int r5) {
        /*
            r4 = this;
            boolean r0 = r4.isShownPlace
            r1 = 0
            if (r0 != 0) goto L_0x0008
            r4.campaignModel = r1
            return
        L_0x0008:
            r0 = 4
            if (r5 != r0) goto L_0x002a
            com.baidu.searchbox.ugc.model.CampaignModel r0 = r4.campaignModel
            if (r0 == 0) goto L_0x0012
            java.lang.String r0 = r0.videoType
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            java.lang.String r2 = "1"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x002a
            android.content.Context r0 = r4.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r2 = com.baidu.searchbox.publishercomponent.R.string.dynamic_publisher_campaign_video
            java.lang.String r0 = r0.getString(r2)
            goto L_0x004d
        L_0x002a:
            r0 = 2
            if (r5 != r0) goto L_0x004c
            com.baidu.searchbox.ugc.model.CampaignModel r0 = r4.campaignModel
            if (r0 == 0) goto L_0x0034
            java.lang.String r0 = r0.videoType
            goto L_0x0035
        L_0x0034:
            r0 = r1
        L_0x0035:
            java.lang.String r2 = "2"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x004c
            android.content.Context r0 = r4.getContext()
            android.content.res.Resources r0 = r0.getResources()
            int r2 = com.baidu.searchbox.publishercomponent.R.string.dynamic_publisher_campaign_mini
            java.lang.String r0 = r0.getString(r2)
            goto L_0x004d
        L_0x004c:
            r0 = r1
        L_0x004d:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            if (r2 == 0) goto L_0x005d
            int r2 = r2.length()
            if (r2 != 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            r2 = r3
            goto L_0x005e
        L_0x005d:
            r2 = 1
        L_0x005e:
            if (r2 != 0) goto L_0x006c
            r4.isShownPlace = r3
            r4.campaignModel = r1
            com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent$$ExternalSyntheticLambda0 r1 = new com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent$$ExternalSyntheticLambda0
            r1.<init>(r4, r0)
            com.baidu.android.util.concurrent.UiThreadUtils.runOnUiThread(r1)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.campaign.CampaignComponent.checkVideoTypeSupport(int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: checkVideoTypeSupport$lambda-26  reason: not valid java name */
    public static final void m17953checkVideoTypeSupport$lambda26(CampaignComponent this$0, String $guideString) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showCampaignGuideIfNeed();
        UniversalToast.makeText(AppRuntime.getAppContext(), (CharSequence) $guideString).show();
    }

    /* access modifiers changed from: private */
    public final void refreshCampaign(CampaignModel selectedCampaign) {
        if (selectedCampaign != null) {
            this.campaignModel = selectedCampaign;
            getCampaignView().showCampaignDetail(this.campaignModel);
        }
    }

    /* access modifiers changed from: private */
    public final void showRecommendCampaign() {
        Collection collection = this.recommendCampaignList;
        if (!(collection == null || collection.isEmpty())) {
            CampaignModel campaignModel2 = this.campaignModel;
            if (!Intrinsics.areEqual((Object) campaignModel2 != null ? campaignModel2.taskOrigin : null, (Object) "duxingxuan")) {
                getCampaignView().showRecommendCampaign(this.recommendCampaignList);
                Store<AbsState> store = getStore();
                if (store != null) {
                    store.dispatch(CampaignAction.RecommendCampaignShown.INSTANCE);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void showCampaignGuideIfNeed() {
        this.campaignModel = null;
        getCampaignView().hideCampaignDetail();
        CharSequence charSequence = this.guideMsg;
        int i2 = 0;
        if (!(charSequence == null || charSequence.length() == 0)) {
            getCampaignView().showCurrentGuide(this.guideMsg);
        }
        CampaignView campaignView = getCampaignView();
        if (this.hideCampaignView) {
            i2 = 8;
        }
        campaignView.setVisibility(i2);
    }
}
