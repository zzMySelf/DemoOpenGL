package com.baidu.searchbox.video.feedflow.flow.durationpad;

import android.content.res.Configuration;
import com.baidu.searchbox.account.im.GroupMemberAdapter;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataPlugin;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.service.IFlowComponentService;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBCManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\b\u0010&\u001a\u00020\u0017H\u0016J\b\u0010'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006,"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/durationpad/DurationPadPlugin;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataPlugin;", "()V", "PAD_TAG", "", "currentVideoVisible", "", "durationFlow", "Lcom/baidu/ubc/Flow;", "idSuffix", "", "partNidAtStartDuration", "partOrientation", "Lkotlin/Pair;", "partVideoOrientation", "step", "ubcService", "Lcom/baidu/ubc/UBCManager;", "getUbcService", "()Lcom/baidu/ubc/UBCManager;", "ubcService$delegate", "Lkotlin/Lazy;", "endDurationStatistic", "", "endSlot", "generatePartInfo", "Lorg/json/JSONObject;", "curItemModel", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "getCustomExt", "getExtLog", "store", "Lcom/baidu/searchbox/feed/detail/frame/Store;", "Lcom/baidu/searchbox/feed/detail/frame/AbsState;", "getPartIdPrefix", "getSource", "onAttachToManager", "onPause", "onResume", "recordNextSlot", "startDurationStatistic", "startSlot", "updateStep", "updateStepRecordNextSlot", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DurationPadPlugin.kt */
public final class DurationPadPlugin extends LiveDataPlugin {
    private final String PAD_TAG = "DurationPadPlugin";
    private boolean currentVideoVisible = true;
    private Flow durationFlow;
    private int idSuffix = -1;
    private String partNidAtStartDuration = "";
    private Pair<String, String> partOrientation = new Pair<>(this.partNidAtStartDuration, this.partVideoOrientation);
    private String partVideoOrientation = "";
    private int step;
    private final Lazy ubcService$delegate = LazyKt.lazy(DurationPadPlugin$ubcService$2.INSTANCE);

    private final UBCManager getUbcService() {
        Object value = this.ubcService$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-ubcService>(...)");
        return (UBCManager) value;
    }

    public void onAttachToManager() {
        DurationPadState $this$onAttachToManager_u24lambda_u2d3;
        super.onAttachToManager();
        Store $this$subscribe$iv = getStore();
        if ($this$subscribe$iv != null && ($this$onAttachToManager_u24lambda_u2d3 = (DurationPadState) $this$subscribe$iv.subscribe(DurationPadState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d3.isCovered().observe(this, new DurationPadPlugin$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d3.getPageChangeRecordPart().observe(this, new DurationPadPlugin$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d3.getChangeConfiguration().observe(this, new DurationPadPlugin$$ExternalSyntheticLambda2(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-0  reason: not valid java name */
    public static final void m6326onAttachToManager$lambda3$lambda0(DurationPadPlugin this$0, Boolean isCovered) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(isCovered, "isCovered");
        if (isCovered.booleanValue()) {
            this$0.currentVideoVisible = false;
            this$0.endDurationStatistic();
            return;
        }
        this$0.currentVideoVisible = true;
        this$0.startDurationStatistic();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-1  reason: not valid java name */
    public static final void m6327onAttachToManager$lambda3$lambda1(DurationPadPlugin this$0, Unit pageChangeRecordPart) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.updateStepRecordNextSlot();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-3$lambda-2  reason: not valid java name */
    public static final void m6328onAttachToManager$lambda3$lambda2(DurationPadPlugin this$0, Configuration changeConfiguration) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.partNidAtStartDuration = "";
        if (changeConfiguration.orientation == 2) {
            str = "1";
        } else {
            str = "2";
        }
        this$0.partVideoOrientation = str;
        this$0.updateStepRecordNextSlot();
    }

    private final void updateStepRecordNextSlot() {
        if (DIFactory.INSTANCE.isPadStyle()) {
            IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
            String str = null;
            ItemModel curItemModel = iFlowComponentService != null ? iFlowComponentService.getCurItemModel() : null;
            boolean isSkip = true;
            if (!StringsKt.isBlank(this.partNidAtStartDuration)) {
                boolean isSkip2 = Intrinsics.areEqual((Object) curItemModel != null ? curItemModel.getNid() : null, (Object) this.partNidAtStartDuration);
                this.partNidAtStartDuration = "";
                if (isSkip2) {
                    return;
                }
            }
            if ((!StringsKt.isBlank(this.partOrientation.getFirst())) && (!StringsKt.isBlank(this.partOrientation.getSecond()))) {
                if (curItemModel != null) {
                    str = curItemModel.getNid();
                }
                if (!Intrinsics.areEqual((Object) str, (Object) this.partOrientation.getFirst()) || !Intrinsics.areEqual((Object) this.partOrientation.getSecond(), (Object) this.partVideoOrientation)) {
                    isSkip = false;
                }
                if (isSkip) {
                    return;
                }
            }
            updateStep();
            recordNextSlot();
        }
    }

    private final void startDurationStatistic() {
        ItemModel curItemModel;
        if (DIFactory.INSTANCE.isPadStyle()) {
            this.durationFlow = getUbcService().beginFlow(UBCManifestKt.UBC_ID_7509);
            IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
            if (!(iFlowComponentService == null || (curItemModel = iFlowComponentService.getCurItemModel()) == null)) {
                int i2 = this.idSuffix;
                if (i2 < 0) {
                    this.idSuffix = i2 + 1;
                }
                this.partNidAtStartDuration = curItemModel.getNid();
            }
            startSlot(this.idSuffix);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        r1 = r1.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void endDurationStatistic() {
        /*
            r18 = this;
            r0 = r18
            com.baidu.searchbox.video.feedflow.di.DIFactory r1 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE
            boolean r1 = r1.isPadStyle()
            if (r1 != 0) goto L_0x000b
            return
        L_0x000b:
            com.baidu.searchbox.feed.detail.frame.Store r1 = r18.getStore()
            if (r1 == 0) goto L_0x0022
            com.baidu.searchbox.feed.detail.frame.State r1 = r1.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r1 = (com.baidu.searchbox.feed.detail.frame.AbsState) r1
            if (r1 == 0) goto L_0x0022
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r3 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r1 = r1.select(r3)
            com.baidu.searchbox.video.detail.core.model.IntentData r1 = (com.baidu.searchbox.video.detail.core.model.IntentData) r1
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            com.baidu.searchbox.feed.detail.frame.Store r3 = r18.getStore()
            if (r3 == 0) goto L_0x003a
            com.baidu.searchbox.feed.detail.frame.State r3 = r3.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r3 = (com.baidu.searchbox.feed.detail.frame.AbsState) r3
            if (r3 == 0) goto L_0x003a
            java.lang.Class<com.baidu.searchbox.feed.detail.ext.common.UbcBean> r4 = com.baidu.searchbox.feed.detail.ext.common.UbcBean.class
            java.lang.Object r3 = r3.select(r4)
            com.baidu.searchbox.feed.detail.ext.common.UbcBean r3 = (com.baidu.searchbox.feed.detail.ext.common.UbcBean) r3
            goto L_0x003b
        L_0x003a:
            r3 = 0
        L_0x003b:
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            r12 = r4
            if (r1 == 0) goto L_0x0118
            if (r3 == 0) goto L_0x0118
            com.baidu.searchbox.feed.detail.frame.Store r4 = r18.getStore()
            java.lang.String r13 = r0.getExtLog(r4)
            org.json.JSONObject r4 = r18.getCustomExt()
            r5 = r4
            r6 = 0
            java.lang.Boolean r7 = r1.isColdLaunchRestore
            java.lang.String r8 = "intentData.isColdLaunchRestore"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x0067
            java.lang.String r7 = "coldstart"
            java.lang.String r8 = "1"
            r5.putOpt(r7, r8)
        L_0x0067:
            r14 = r4
            java.lang.String r4 = r14.toString()
            java.lang.String r5 = "customExt.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r15 = r4
            com.baidu.searchbox.feed.detail.ext.common.UbcExtBean r11 = new com.baidu.searchbox.feed.detail.ext.common.UbcExtBean
            r5 = 0
            r6 = 0
            java.lang.String r7 = r18.getSource()
            r9 = 0
            r10 = 19
            r16 = 0
            java.lang.String r8 = "na"
            r4 = r3
            r2 = r11
            r11 = r16
            com.baidu.searchbox.feed.detail.ext.common.UbcBean r4 = com.baidu.searchbox.feed.detail.ext.common.UbcBean.copy$default(r4, r5, r6, r7, r8, r9, r10, r11)
            java.lang.String r5 = "7509"
            r2.<init>(r5, r4, r13, r15)
            org.json.JSONObject r4 = r2.toJson()
            int r5 = r0.step
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = "step"
            r4.putOpt(r6, r5)
            java.lang.String r5 = "ext"
            org.json.JSONObject r6 = r4.optJSONObject(r5)
            if (r6 != 0) goto L_0x00ae
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
        L_0x00ae:
            java.lang.String r7 = r1.pd
            java.lang.String r8 = "pd"
            r6.putOpt(r8, r7)
            java.lang.String r7 = r1.page
            boolean r7 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromUserHomePage(r7)
            if (r7 == 0) goto L_0x00c6
            java.lang.String r7 = com.baidu.ubc.bussiness.UBCDurationSearchSession.getSSession()
            java.lang.String r8 = "s_session"
            r6.putOpt(r8, r7)
        L_0x00c6:
            com.baidu.searchbox.feed.detail.frame.Store r7 = r18.getStore()
            if (r7 == 0) goto L_0x00d5
            com.baidu.searchbox.feed.detail.frame.State r7 = r7.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r7 = (com.baidu.searchbox.feed.detail.frame.AbsState) r7
            r17 = r7
            goto L_0x00d7
        L_0x00d5:
            r17 = 0
        L_0x00d7:
            java.lang.String r7 = com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt.getPage(r17)
            boolean r7 = com.baidu.searchbox.video.detail.business.VideoBizUtilsKt.isFromChannelFlow(r7)
            if (r7 == 0) goto L_0x00fd
            java.lang.String r7 = "sub_pd"
            java.lang.String r8 = r6.optString(r7)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x00f5
            boolean r8 = kotlin.text.StringsKt.isBlank(r8)
            if (r8 == 0) goto L_0x00f3
            goto L_0x00f5
        L_0x00f3:
            r8 = 0
            goto L_0x00f6
        L_0x00f5:
            r8 = 1
        L_0x00f6:
            if (r8 == 0) goto L_0x00fd
            java.lang.String r8 = "channel_video_landing"
            r6.putOpt(r7, r8)
        L_0x00fd:
            r4.putOpt(r5, r6)
            com.baidu.searchbox.video.feedflow.common.DeviceInfo r5 = com.baidu.searchbox.video.feedflow.common.DeviceInfo.INSTANCE
            r5.into(r6)
            java.lang.String r5 = "slog"
            r12.putOpt(r5, r4)
            com.baidu.ubc.UBCManager r5 = r18.getUbcService()
            com.baidu.ubc.Flow r7 = r0.durationFlow
            java.lang.String r8 = r12.toString()
            r5.flowSetValueWithDuration(r7, r8)
        L_0x0118:
            int r2 = r0.idSuffix
            r0.endSlot(r2)
            com.baidu.ubc.UBCManager r2 = r18.getUbcService()
            com.baidu.ubc.Flow r4 = r0.durationFlow
            r2.flowEnd(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.durationpad.DurationPadPlugin.endDurationStatistic():void");
    }

    private final void recordNextSlot() {
        int i2 = this.idSuffix;
        if (i2 > -1) {
            endSlot(i2);
        }
        int i3 = this.idSuffix + 1;
        this.idSuffix = i3;
        startSlot(i3);
    }

    private final void updateStep() {
        ItemModel<?> curItemModel;
        RunTimeStatus runTimeStatus;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService != null && (curItemModel = iFlowComponentService.getCurItemModel()) != null && (runTimeStatus = curItemModel.getRunTimeStatus()) != null && !runTimeStatus.isRecordStep()) {
            runTimeStatus.setRecordStep(true);
            this.step++;
        }
    }

    private final void startSlot(int idSuffix2) {
        ItemModel curItemModel;
        IFlowComponentService iFlowComponentService = (IFlowComponentService) getManager().getService(IFlowComponentService.class);
        if (iFlowComponentService != null && (curItemModel = iFlowComponentService.getCurItemModel()) != null) {
            getUbcService().flowStartSlot(this.durationFlow, getPartIdPrefix() + GroupMemberAdapter.MANAGER_CHAR + idSuffix2, generatePartInfo(curItemModel));
        }
    }

    private final void endSlot(int idSuffix2) {
        getUbcService().flowEndSlot(this.durationFlow, getPartIdPrefix() + GroupMemberAdapter.MANAGER_CHAR + idSuffix2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012e A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0145 A[SYNTHETIC, Splitter:B:109:0x0145] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014e A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x017b A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01b0 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01b3 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01bc A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01be A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x01c1 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x01d6 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x01d8 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x01db A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x01ff A[SYNTHETIC, Splitter:B:169:0x01ff] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0204 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x020c A[SYNTHETIC, Splitter:B:175:0x020c] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0211 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x021b A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0255 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0273 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x027c A[SYNTHETIC, Splitter:B:205:0x027c] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0281 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0290 A[SYNTHETIC, Splitter:B:211:0x0290] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x02d4 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x02ea A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x02ed A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x02f0 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0317 A[SYNTHETIC, Splitter:B:232:0x0317] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x031c A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x032e A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x034f A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x035a A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0361 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0369 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0370 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0378 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x037f A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0385 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x038c A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x038f A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x039a A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x039d A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x03a0 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x03ab A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x03d1 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x03da A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x0400 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0407 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x040d A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x041a A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0421 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:302:0x0428 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x042e A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0065 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x043c A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009b A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009e A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a7 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b6 A[SYNTHETIC, Splitter:B:49:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bb A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c3 A[SYNTHETIC, Splitter:B:55:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00c8 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d0 A[SYNTHETIC, Splitter:B:61:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d5 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00de A[SYNTHETIC, Splitter:B:67:0x00de] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00e3 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00eb A[SYNTHETIC, Splitter:B:73:0x00eb] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00f0 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f8 A[SYNTHETIC, Splitter:B:79:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fd A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0105 A[SYNTHETIC, Splitter:B:85:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010a A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0112 A[SYNTHETIC, Splitter:B:91:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0117 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0123 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0126 A[Catch:{ JSONException -> 0x0444 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0129 A[Catch:{ JSONException -> 0x0444 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject generatePartInfo(com.baidu.searchbox.video.feedflow.flow.list.ItemModel<?> r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r0 = "2"
            java.lang.String r3 = "channel_id"
            java.lang.String r4 = "vid"
            com.baidu.searchbox.video.feedflow.flow.list.CommonItemData r6 = r20.getCommonItemData()     // Catch:{ JSONException -> 0x0444 }
            if (r6 == 0) goto L_0x0016
            org.json.JSONObject r6 = r6.getExtLogJo()     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0017
        L_0x0016:
            r6 = 0
        L_0x0017:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0444 }
            r7.<init>()     // Catch:{ JSONException -> 0x0444 }
            r8 = r7
            r9 = 0
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r10 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r10 = r10.getVideoVid(r2)     // Catch:{ JSONException -> 0x0444 }
            r8.putOpt(r4, r10)     // Catch:{ JSONException -> 0x0444 }
            r11 = r10
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ JSONException -> 0x0444 }
            r13 = 1
            if (r11 == 0) goto L_0x0036
            int r11 = r11.length()     // Catch:{ JSONException -> 0x0444 }
            if (r11 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r11 = 0
            goto L_0x0037
        L_0x0036:
            r11 = r13
        L_0x0037:
            if (r11 == 0) goto L_0x0070
            com.baidu.searchbox.feed.detail.frame.Store r11 = r19.getStore()     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x0062
            r14 = 0
            com.baidu.searchbox.feed.detail.frame.State r15 = r11.getState()     // Catch:{ JSONException -> 0x0444 }
            boolean r12 = r15 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x0444 }
            if (r12 == 0) goto L_0x004b
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r15 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r15     // Catch:{ JSONException -> 0x0444 }
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 == 0) goto L_0x0055
            java.lang.Class<com.baidu.searchbox.video.feedflow.config.AbConfig> r12 = com.baidu.searchbox.video.feedflow.config.AbConfig.class
            java.lang.Object r12 = r15.select(r12)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0056
        L_0x0055:
            r12 = 0
        L_0x0056:
            com.baidu.searchbox.video.feedflow.config.AbConfig r12 = (com.baidu.searchbox.video.feedflow.config.AbConfig) r12     // Catch:{ JSONException -> 0x0444 }
            if (r12 == 0) goto L_0x0062
            boolean r11 = r12.isDurationStatVidOptimizationEnable()     // Catch:{ JSONException -> 0x0444 }
            if (r11 != r13) goto L_0x0062
            r11 = r13
            goto L_0x0063
        L_0x0062:
            r11 = 0
        L_0x0063:
            if (r11 == 0) goto L_0x0070
            if (r6 == 0) goto L_0x006c
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x006d
        L_0x006c:
            r11 = 0
        L_0x006d:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
        L_0x0070:
            java.lang.String r4 = "nid"
            java.lang.String r11 = r20.getNid()     // Catch:{ JSONException -> 0x0444 }
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "netType"
            com.baidu.searchbox.video.feedflow.di.DIFactory r11 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = r11.getNetType()     // Catch:{ JSONException -> 0x0444 }
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "status"
            com.baidu.searchbox.feed.detail.frame.Store r11 = r19.getStore()     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x0094
            com.baidu.searchbox.feed.detail.frame.State r11 = r11.getState()     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.feed.detail.frame.AbsState r11 = (com.baidu.searchbox.feed.detail.frame.AbsState) r11     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0095
        L_0x0094:
            r11 = 0
        L_0x0095:
            boolean r11 = com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt.isLandscapeFlowMode((com.baidu.searchbox.feed.detail.frame.AbsState) r11)     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x009e
            java.lang.String r11 = "landscape"
            goto L_0x00a0
        L_0x009e:
            java.lang.String r11 = "portrait"
        L_0x00a0:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "refreshTimestampMs"
            if (r6 == 0) goto L_0x00ae
            java.lang.String r11 = "refresh_timestamp_ms"
            java.lang.Object r11 = r6.opt(r11)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x00af
        L_0x00ae:
            r11 = 0
        L_0x00af:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "resourceType"
            if (r6 == 0) goto L_0x00bb
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x00bc
        L_0x00bb:
            r11 = 0
        L_0x00bc:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "is_microvideo"
            if (r6 == 0) goto L_0x00c8
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x00c9
        L_0x00c8:
            r11 = 0
        L_0x00c9:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "collection_id"
            if (r6 == 0) goto L_0x00d5
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x00d6
        L_0x00d5:
            r11 = 0
        L_0x00d6:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "template_status"
            if (r6 == 0) goto L_0x00e3
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x00e4
        L_0x00e3:
            r11 = 0
        L_0x00e4:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "label"
            if (r6 == 0) goto L_0x00f0
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x00f1
        L_0x00f0:
            r11 = 0
        L_0x00f1:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "pay_column"
            if (r6 == 0) goto L_0x00fd
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x00fe
        L_0x00fd:
            r11 = 0
        L_0x00fe:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "recommend_src"
            if (r6 == 0) goto L_0x010a
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x010b
        L_0x010a:
            r11 = 0
        L_0x010b:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r4 = "is_recommend"
            if (r6 == 0) goto L_0x0117
            java.lang.Object r11 = r6.opt(r4)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0118
        L_0x0117:
            r11 = 0
        L_0x0118:
            r8.putOpt(r4, r11)     // Catch:{ JSONException -> 0x0444 }
            java.lang.Object r4 = r20.getData()     // Catch:{ JSONException -> 0x0444 }
            boolean r11 = r4 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x0126
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r4 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r4     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0127
        L_0x0126:
            r4 = 0
        L_0x0127:
            if (r4 == 0) goto L_0x012e
            java.lang.String r4 = r4.getLandscapeRelatedRecommendSuperId()     // Catch:{ JSONException -> 0x0444 }
            goto L_0x012f
        L_0x012e:
            r4 = 0
        L_0x012f:
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x013d
            int r11 = r11.length()     // Catch:{ JSONException -> 0x0444 }
            if (r11 != 0) goto L_0x013b
            goto L_0x013d
        L_0x013b:
            r11 = 0
            goto L_0x013e
        L_0x013d:
            r11 = r13
        L_0x013e:
            java.lang.String r12 = "template"
            java.lang.String r14 = "mounted_rid"
            if (r11 != 0) goto L_0x014e
            r8.putOpt(r14, r4)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "relate_recommend"
            r8.putOpt(r12, r11)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0164
        L_0x014e:
            if (r6 == 0) goto L_0x0155
            java.lang.Object r11 = r6.opt(r14)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0156
        L_0x0155:
            r11 = 0
        L_0x0156:
            r8.putOpt(r14, r11)     // Catch:{ JSONException -> 0x0444 }
            if (r6 == 0) goto L_0x0160
            java.lang.Object r11 = r6.opt(r12)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0161
        L_0x0160:
            r11 = 0
        L_0x0161:
            r8.putOpt(r12, r11)     // Catch:{ JSONException -> 0x0444 }
        L_0x0164:
            java.lang.String r11 = "autoPlay"
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r12 = r20.getRunTimeStatus()     // Catch:{ JSONException -> 0x0444 }
            int r12 = r12.getAutoPlayFlagState()     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ JSONException -> 0x0444 }
            r8.putOpt(r11, r12)     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.feed.detail.frame.Store r11 = r19.getStore()     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x019e
            r12 = 0
            com.baidu.searchbox.feed.detail.frame.State r14 = r11.getState()     // Catch:{ JSONException -> 0x0444 }
            boolean r15 = r14 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x0444 }
            if (r15 == 0) goto L_0x0187
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r14 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r14     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0188
        L_0x0187:
            r14 = 0
        L_0x0188:
            if (r14 == 0) goto L_0x0191
            java.lang.Class<com.baidu.searchbox.video.feedflow.tab.TabState> r15 = com.baidu.searchbox.video.feedflow.tab.TabState.class
            java.lang.Object r14 = r14.select(r15)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0192
        L_0x0191:
            r14 = 0
        L_0x0192:
            com.baidu.searchbox.video.feedflow.tab.TabState r14 = (com.baidu.searchbox.video.feedflow.tab.TabState) r14     // Catch:{ JSONException -> 0x0444 }
            if (r14 == 0) goto L_0x019e
            boolean r11 = r14.getTheaterTabDetainment()     // Catch:{ JSONException -> 0x0444 }
            if (r11 != r13) goto L_0x019e
            r11 = r13
            goto L_0x019f
        L_0x019e:
            r11 = 0
        L_0x019f:
            java.lang.String r12 = "1"
            if (r11 == 0) goto L_0x01a8
            java.lang.String r11 = "back_retain"
            r8.putOpt(r11, r12)     // Catch:{ JSONException -> 0x0444 }
        L_0x01a8:
            java.lang.Object r11 = r20.getData()     // Catch:{ JSONException -> 0x0444 }
            boolean r14 = r11 instanceof com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel     // Catch:{ JSONException -> 0x0444 }
            if (r14 == 0) goto L_0x01b3
            com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel r11 = (com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel) r11     // Catch:{ JSONException -> 0x0444 }
            goto L_0x01b4
        L_0x01b3:
            r11 = 0
        L_0x01b4:
            if (r11 == 0) goto L_0x01be
            int r11 = r11.getFlowVideoGrType()     // Catch:{ JSONException -> 0x0444 }
            if (r11 != r13) goto L_0x01be
            r11 = r13
            goto L_0x01bf
        L_0x01be:
            r11 = 0
        L_0x01bf:
            if (r11 == 0) goto L_0x01c6
            java.lang.String r11 = "followrid"
            r8.put(r11, r13)     // Catch:{ JSONException -> 0x0444 }
        L_0x01c6:
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r11 = r20.getRunTimeStatus()     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.video.feedflow.flow.list.RecommendShowModel r11 = r11.getRecommendNextContentFlagState()     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x01d8
            boolean r11 = r11.isClicked()     // Catch:{ JSONException -> 0x0444 }
            if (r11 != r13) goto L_0x01d8
            r11 = r13
            goto L_0x01d9
        L_0x01d8:
            r11 = 0
        L_0x01d9:
            if (r11 == 0) goto L_0x01fb
            java.lang.String r11 = "trailer_status"
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r14 = r20.getRunTimeStatus()     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.video.feedflow.flow.list.RecommendShowModel r14 = r14.getRecommendNextContentFlagState()     // Catch:{ JSONException -> 0x0444 }
            if (r14 == 0) goto L_0x01f1
            boolean r14 = r14.isDefaultText()     // Catch:{ JSONException -> 0x0444 }
            if (r14 != r13) goto L_0x01f1
            r14 = r13
            goto L_0x01f2
        L_0x01f1:
            r14 = 0
        L_0x01f2:
            if (r14 == 0) goto L_0x01f7
            java.lang.String r14 = "0"
            goto L_0x01f8
        L_0x01f7:
            r14 = r12
        L_0x01f8:
            r8.putOpt(r11, r14)     // Catch:{ JSONException -> 0x0444 }
        L_0x01fb:
            java.lang.String r11 = "resourceType_src"
            if (r6 == 0) goto L_0x0204
            java.lang.Object r14 = r6.opt(r11)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0205
        L_0x0204:
            r14 = 0
        L_0x0205:
            r8.putOpt(r11, r14)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "landing_channel_id"
            if (r6 == 0) goto L_0x0211
            java.lang.Object r14 = r6.opt(r11)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0212
        L_0x0211:
            r14 = 0
        L_0x0212:
            r8.putOpt(r11, r14)     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.feed.detail.frame.Store r14 = r19.getStore()     // Catch:{ JSONException -> 0x0444 }
            if (r14 == 0) goto L_0x0239
            r15 = 0
            com.baidu.searchbox.feed.detail.frame.State r5 = r14.getState()     // Catch:{ JSONException -> 0x0444 }
            boolean r13 = r5 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x0444 }
            if (r13 == 0) goto L_0x0227
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r5 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r5     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0228
        L_0x0227:
            r5 = 0
        L_0x0228:
            if (r5 == 0) goto L_0x0231
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r13 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r5 = r5.select(r13)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0232
        L_0x0231:
            r5 = 0
        L_0x0232:
            com.baidu.searchbox.video.detail.core.model.IntentData r5 = (com.baidu.searchbox.video.detail.core.model.IntentData) r5     // Catch:{ JSONException -> 0x0444 }
            if (r5 == 0) goto L_0x0239
            org.json.JSONObject r5 = r5.extObject     // Catch:{ JSONException -> 0x0444 }
            goto L_0x023a
        L_0x0239:
            r5 = 0
        L_0x023a:
            if (r5 == 0) goto L_0x0259
            java.lang.String r13 = r5.optString(r11)     // Catch:{ JSONException -> 0x0444 }
            if (r13 == 0) goto L_0x0259
            java.lang.String r14 = "optString(\"landing_channel_id\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ JSONException -> 0x0444 }
            r14 = 0
            r15 = r13
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15     // Catch:{ JSONException -> 0x0444 }
            boolean r15 = kotlin.text.StringsKt.isBlank(r15)     // Catch:{ JSONException -> 0x0444 }
            r17 = 1
            r15 = r15 ^ 1
            if (r15 == 0) goto L_0x0258
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
        L_0x0258:
        L_0x0259:
            if (r5 == 0) goto L_0x0277
            java.lang.String r11 = r5.optString(r3)     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x0277
            java.lang.String r13 = "optString(EXT_CHANNEL_ID)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)     // Catch:{ JSONException -> 0x0444 }
            r13 = 0
            r14 = r11
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ JSONException -> 0x0444 }
            boolean r14 = kotlin.text.StringsKt.isBlank(r14)     // Catch:{ JSONException -> 0x0444 }
            r15 = 1
            r14 = r14 ^ r15
            if (r14 == 0) goto L_0x0276
            r8.putOpt(r3, r11)     // Catch:{ JSONException -> 0x0444 }
        L_0x0276:
        L_0x0277:
            java.lang.String r3 = "from_wf"
            if (r6 == 0) goto L_0x0281
            java.lang.Object r11 = r6.opt(r3)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0282
        L_0x0281:
            r11 = 0
        L_0x0282:
            r8.putOpt(r3, r11)     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.video.feedflow.di.DIFactory r3 = com.baidu.searchbox.video.feedflow.di.DIFactory.INSTANCE     // Catch:{ JSONException -> 0x0444 }
            boolean r3 = r3.isPadStyle()     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "system_status"
            if (r3 == 0) goto L_0x02b1
            android.content.Context r3 = r19.getContext()     // Catch:{ JSONException -> 0x0444 }
            boolean r13 = r3 instanceof android.app.Activity     // Catch:{ JSONException -> 0x0444 }
            if (r13 == 0) goto L_0x029b
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ JSONException -> 0x0444 }
            goto L_0x029c
        L_0x029b:
            r3 = 0
        L_0x029c:
            boolean r3 = com.baidu.searchbox.appframework.pad.PadUtilsKt.isPadHorizontal(r3)     // Catch:{ JSONException -> 0x0444 }
            if (r3 == 0) goto L_0x02b1
            r8.putOpt(r11, r12)     // Catch:{ JSONException -> 0x0444 }
            kotlin.Pair r0 = new kotlin.Pair     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r3 = r20.getNid()     // Catch:{ JSONException -> 0x0444 }
            r0.<init>(r3, r12)     // Catch:{ JSONException -> 0x0444 }
            r1.partOrientation = r0     // Catch:{ JSONException -> 0x0444 }
            goto L_0x02bf
        L_0x02b1:
            r8.putOpt(r11, r0)     // Catch:{ JSONException -> 0x0444 }
            kotlin.Pair r3 = new kotlin.Pair     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = r20.getNid()     // Catch:{ JSONException -> 0x0444 }
            r3.<init>(r11, r0)     // Catch:{ JSONException -> 0x0444 }
            r1.partOrientation = r3     // Catch:{ JSONException -> 0x0444 }
        L_0x02bf:
            com.baidu.searchbox.feed.detail.frame.Store r0 = r19.getStore()     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r0 = com.baidu.searchbox.video.feedflow.flow.enterpathway.EnterPathWayStateKt.getEnterPathWay(r0)     // Catch:{ JSONException -> 0x0444 }
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ JSONException -> 0x0444 }
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)     // Catch:{ JSONException -> 0x0444 }
            r17 = 1
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x02d9
            java.lang.String r3 = "enterPathWay"
            r8.putOpt(r3, r0)     // Catch:{ JSONException -> 0x0444 }
        L_0x02d9:
            com.baidu.searchbox.feed.detail.frame.Store r3 = r19.getStore()     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r3 = com.baidu.searchbox.video.feedflow.flow.enterpathway.EnterPathWayStateKt.getRecommentInspireTime(r3)     // Catch:{ JSONException -> 0x0444 }
            r11 = r3
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ JSONException -> 0x0444 }
            int r11 = r11.length()     // Catch:{ JSONException -> 0x0444 }
            if (r11 <= 0) goto L_0x02ed
            r11 = r17
            goto L_0x02ee
        L_0x02ed:
            r11 = 0
        L_0x02ee:
            if (r11 == 0) goto L_0x02f5
            java.lang.String r11 = "recomment_inspire_time"
            r8.putOpt(r11, r3)     // Catch:{ JSONException -> 0x0444 }
        L_0x02f5:
            java.lang.String r11 = "page_id"
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r13 = r19.getManager()     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r13 = com.baidu.searchbox.video.feedflow.trace.PageIdManagerPluginKt.getPageId(r13)     // Catch:{ JSONException -> 0x0444 }
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "page_seq"
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r13 = r19.getManager()     // Catch:{ JSONException -> 0x0444 }
            int r13 = com.baidu.searchbox.video.feedflow.trace.PageIdManagerPluginKt.getPageSequence(r13)     // Catch:{ JSONException -> 0x0444 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)     // Catch:{ JSONException -> 0x0444 }
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "inner_click"
            if (r6 == 0) goto L_0x031c
            java.lang.Object r13 = r6.opt(r11)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x031d
        L_0x031c:
            r13 = 0
        L_0x031d:
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r11 = r20.getRunTimeStatus()     // Catch:{ JSONException -> 0x0444 }
            java.lang.Boolean r11 = r11.isOfflineCache()     // Catch:{ JSONException -> 0x0444 }
            boolean r11 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r11)     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x0344
            java.lang.String r11 = "isLocalCacheVideo"
            r8.putOpt(r11, r12)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "offlineCacheTag"
            com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfig r13 = com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfigKt.getFlowVideoCacheConfig()     // Catch:{ JSONException -> 0x0444 }
            int r13 = com.baidu.searchbox.video.feedflow.cache.FlowVideoCacheConfigKt.getCacheMaxSize(r13)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ JSONException -> 0x0444 }
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
        L_0x0344:
            com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper r11 = com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper.INSTANCE     // Catch:{ JSONException -> 0x0444 }
            r11.appendVideoShowTypeExt(r8, r2)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentGuideComponentKt.getCollectionPayType(r20)     // Catch:{ JSONException -> 0x0444 }
            if (r11 == 0) goto L_0x0356
            r13 = 0
            java.lang.String r14 = "collection_pay_type"
            r8.put(r14, r11)     // Catch:{ JSONException -> 0x0444 }
        L_0x0356:
            java.lang.String r11 = "identifyCharacter"
            if (r6 == 0) goto L_0x0361
            java.lang.String r13 = "identifyCharacter"
            java.lang.Object r13 = r6.opt(r13)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0362
        L_0x0361:
            r13 = 0
        L_0x0362:
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "comment_video_source"
            if (r6 == 0) goto L_0x0370
            java.lang.String r13 = "comment_video_source"
            java.lang.Object r13 = r6.opt(r13)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0371
        L_0x0370:
            r13 = 0
        L_0x0371:
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
            java.lang.String r11 = "collection_nid_src"
            if (r6 == 0) goto L_0x037f
            java.lang.String r13 = "collection_nid_src"
            java.lang.String r13 = r6.optString(r13)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0380
        L_0x037f:
            r13 = 0
        L_0x0380:
            r8.putOpt(r11, r13)     // Catch:{ JSONException -> 0x0444 }
            if (r6 == 0) goto L_0x038c
            java.lang.String r11 = "note_recommend"
            java.lang.String r11 = r6.optString(r11)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x038d
        L_0x038c:
            r11 = 0
        L_0x038d:
            if (r11 != 0) goto L_0x0391
            java.lang.String r11 = ""
        L_0x0391:
            r13 = r11
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ JSONException -> 0x0444 }
            int r13 = r13.length()     // Catch:{ JSONException -> 0x0444 }
            if (r13 <= 0) goto L_0x039d
            r13 = r17
            goto L_0x039e
        L_0x039d:
            r13 = 0
        L_0x039e:
            if (r13 == 0) goto L_0x03a5
            java.lang.String r13 = "note_recommend"
            r8.putOpt(r13, r11)     // Catch:{ JSONException -> 0x0444 }
        L_0x03a5:
            com.baidu.searchbox.feed.detail.frame.Store r13 = r19.getStore()     // Catch:{ JSONException -> 0x0444 }
            if (r13 == 0) goto L_0x03d1
            r14 = 0
            com.baidu.searchbox.feed.detail.frame.State r15 = r13.getState()     // Catch:{ JSONException -> 0x0444 }
            r18 = r0
            boolean r0 = r15 instanceof com.baidu.searchbox.feed.detail.arch.ext.CommonState     // Catch:{ JSONException -> 0x0444 }
            if (r0 == 0) goto L_0x03b9
            com.baidu.searchbox.feed.detail.arch.ext.CommonState r15 = (com.baidu.searchbox.feed.detail.arch.ext.CommonState) r15     // Catch:{ JSONException -> 0x0444 }
            goto L_0x03ba
        L_0x03b9:
            r15 = 0
        L_0x03ba:
            if (r15 == 0) goto L_0x03c3
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.FlowState> r0 = com.baidu.searchbox.video.feedflow.flow.list.FlowState.class
            java.lang.Object r0 = r15.select(r0)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x03c4
        L_0x03c3:
            r0 = 0
        L_0x03c4:
            com.baidu.searchbox.video.feedflow.flow.list.FlowState r0 = (com.baidu.searchbox.video.feedflow.flow.list.FlowState) r0     // Catch:{ JSONException -> 0x0444 }
            if (r0 == 0) goto L_0x03d3
            int r0 = r0.getCurItemPosition()     // Catch:{ JSONException -> 0x0444 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x03d4
        L_0x03d1:
            r18 = r0
        L_0x03d3:
            r0 = 0
        L_0x03d4:
            int r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orZero((java.lang.Integer) r0)     // Catch:{ JSONException -> 0x0444 }
            if (r0 != 0) goto L_0x03fe
            com.baidu.searchbox.feed.detail.arch.ComponentArchManager r0 = r19.getManager()     // Catch:{ JSONException -> 0x0444 }
            r13 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.ITopExpandableService> r14 = com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.ITopExpandableService.class
            com.baidu.searchbox.feed.detail.arch.api.IService r14 = r0.getService(r14)     // Catch:{ JSONException -> 0x0444 }
            com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.ITopExpandableService r14 = (com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.ITopExpandableService) r14     // Catch:{ JSONException -> 0x0444 }
            if (r14 == 0) goto L_0x03f2
            boolean r0 = r14.isExpandAutoPlayEnabled()     // Catch:{ JSONException -> 0x0444 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x03f3
        L_0x03f2:
            r0 = 0
        L_0x03f3:
            boolean r0 = com.baidu.searchbox.player.utils.BdPlayerUtils.orFalse(r0)     // Catch:{ JSONException -> 0x0444 }
            if (r0 == 0) goto L_0x03fe
            java.lang.String r0 = "crimp_type"
            r8.putOpt(r0, r12)     // Catch:{ JSONException -> 0x0444 }
        L_0x03fe:
            if (r6 == 0) goto L_0x0407
            java.lang.String r0 = "from_entry_style"
            java.lang.String r0 = r6.optString(r0)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0408
        L_0x0407:
            r0 = 0
        L_0x0408:
            r12 = r0
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ JSONException -> 0x0444 }
            if (r12 == 0) goto L_0x0416
            boolean r12 = kotlin.text.StringsKt.isBlank(r12)     // Catch:{ JSONException -> 0x0444 }
            if (r12 == 0) goto L_0x0414
            goto L_0x0416
        L_0x0414:
            r12 = 0
            goto L_0x0418
        L_0x0416:
            r12 = r17
        L_0x0418:
            if (r12 != 0) goto L_0x041f
            java.lang.String r12 = "from_entry_style"
            r8.putOpt(r12, r0)     // Catch:{ JSONException -> 0x0444 }
        L_0x041f:
            if (r6 == 0) goto L_0x0428
            java.lang.String r12 = "baiplus_order_id"
            java.lang.String r12 = r6.optString(r12)     // Catch:{ JSONException -> 0x0444 }
            goto L_0x0429
        L_0x0428:
            r12 = 0
        L_0x0429:
            r13 = r12
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ JSONException -> 0x0444 }
            if (r13 == 0) goto L_0x0438
            boolean r13 = kotlin.text.StringsKt.isBlank(r13)     // Catch:{ JSONException -> 0x0444 }
            if (r13 == 0) goto L_0x0435
            goto L_0x0438
        L_0x0435:
            r16 = 0
            goto L_0x043a
        L_0x0438:
            r16 = r17
        L_0x043a:
            if (r16 != 0) goto L_0x0441
            java.lang.String r13 = "baiplus_order_id"
            r8.putOpt(r13, r12)     // Catch:{ JSONException -> 0x0444 }
        L_0x0441:
            r5 = r7
            goto L_0x044a
        L_0x0444:
            r0 = move-exception
            r3 = 0
            r5 = r3
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            r5 = r3
        L_0x044a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.durationpad.DurationPadPlugin.generatePartInfo(com.baidu.searchbox.video.feedflow.flow.list.ItemModel):org.json.JSONObject");
    }

    private final String getPartIdPrefix() {
        Store<AbsState> store = getStore();
        AbsState absState = null;
        if (UBCManifestKt.isPageSourceFromFeed(store != null ? store.getState() : null)) {
            return "feed_video_landing";
        }
        Store<AbsState> store2 = getStore();
        if (UBCManifestKt.isPageSourceFromHot(store2 != null ? store2.getState() : null)) {
            return "flowhot_video_landing";
        }
        Store<AbsState> store3 = getStore();
        if (store3 != null) {
            absState = store3.getState();
        }
        if (VideoBizUtilsKt.isFromChannelFlow(UBCManifestKt.getPage(absState))) {
            return "channel_video_landing";
        }
        return "merge_video_landing";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r6.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getExtLog(com.baidu.searchbox.feed.detail.frame.Store<com.baidu.searchbox.feed.detail.frame.AbsState> r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0013
            com.baidu.searchbox.feed.detail.frame.State r0 = r6.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0013
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r1 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            if (r0 == 0) goto L_0x003e
            java.lang.String r1 = r0.videoInfoExtLog
            java.lang.String r2 = r0.extLog
            java.lang.String r3 = "ext_log"
            java.lang.String r2 = com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt.getValueFromJsonString(r2, r3)
            org.json.JSONObject r1 = com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt.mergeExt((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "mergeExt(intentData.vide…g, \"ext_log\")).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = r0.extLog
            org.json.JSONObject r3 = com.baidu.searchbox.feed.detail.ext.common.UbcExtBeanKt.mergeExt((java.lang.String) r1, (java.lang.String) r2)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "mergeExt(infoExtLog, intentExtLog).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            return r3
        L_0x003e:
            java.lang.String r1 = ""
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.durationpad.DurationPadPlugin.getExtLog(com.baidu.searchbox.feed.detail.frame.Store):java.lang.String");
    }

    private final JSONObject getCustomExt() {
        return DIFactory.INSTANCE.createCustomExt();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getState();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getSource() {
        /*
            r5 = this;
            com.baidu.searchbox.feed.detail.frame.Store r0 = r5.getStore()
            if (r0 == 0) goto L_0x0018
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x0018
            java.lang.Class<com.baidu.searchbox.video.detail.core.model.IntentData> r1 = com.baidu.searchbox.video.detail.core.model.IntentData.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.video.detail.core.model.IntentData r0 = (com.baidu.searchbox.video.detail.core.model.IntentData) r0
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            java.lang.String r1 = "unknown"
            if (r0 == 0) goto L_0x002c
            r2 = r0
            r3 = 0
            java.lang.String r4 = r2.pd
            if (r4 != 0) goto L_0x0025
            goto L_0x002b
        L_0x0025:
            java.lang.String r1 = "pd ?: \"unknown\""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            r1 = r4
        L_0x002b:
            return r1
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.durationpad.DurationPadPlugin.getSource():java.lang.String");
    }

    public void onResume() {
        super.onResume();
        if (this.currentVideoVisible) {
            startDurationStatistic();
        }
    }

    public void onPause() {
        super.onPause();
        if (this.currentVideoVisible) {
            endDurationStatistic();
        }
    }
}
