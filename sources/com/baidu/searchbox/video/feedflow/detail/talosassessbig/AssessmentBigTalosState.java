package com.baidu.searchbox.video.feedflow.detail.talosassessbig;

import androidx.lifecycle.MutableLiveData;
import com.alipay.sdk.m.l.c;
import com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim.BgmInfo;
import com.baidu.searchbox.video.feedflow.detail.panelBgmAndAnim.CardPanelBgmStatus;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.BgmAndAnimState;
import com.baidu.searchbox.video.feedflow.flow.list.TalosAssessmentBigModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003¢\u0006\u0002\u0010\u0015J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003J\u000f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\u000f\u00104\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003HÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\t\u00107\u001a\u00020\u000fHÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003HÆ\u0003J§\u0001\u0010:\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u000fHÖ\u0001R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0017\"\u0004\b$\u0010\u0019R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010%\"\u0004\b&\u0010'R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0017R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0017\"\u0004\b-\u0010\u0019R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0017¨\u0006@"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/talosassessbig/AssessmentBigTalosState;", "", "bindData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/video/feedflow/flow/list/TalosAssessmentBigModel;", "setBottomGuideVisible", "", "isOperated", "videoStatus", "Lcom/baidu/searchbox/video/feedflow/detail/panelBgmAndAnim/CardPanelBgmStatus;", "ubcBgmInfo", "Lcom/baidu/searchbox/video/feedflow/detail/panelBgmAndAnim/BgmInfo;", "bgmPlayState", "Lcom/baidu/searchbox/video/feedflow/detail/talosassessbig/common/BgmAndAnimState;", "bgmUrl", "", "activityFinish", "formSubmit", "jsLoadSuccess", "updateFontSize", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZLandroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Lcom/baidu/searchbox/video/feedflow/detail/talosassessbig/common/BgmAndAnimState;Ljava/lang/String;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getActivityFinish", "()Landroidx/lifecycle/MutableLiveData;", "setActivityFinish", "(Landroidx/lifecycle/MutableLiveData;)V", "getBgmPlayState", "()Lcom/baidu/searchbox/video/feedflow/detail/talosassessbig/common/BgmAndAnimState;", "setBgmPlayState", "(Lcom/baidu/searchbox/video/feedflow/detail/talosassessbig/common/BgmAndAnimState;)V", "getBgmUrl", "()Ljava/lang/String;", "setBgmUrl", "(Ljava/lang/String;)V", "getBindData", "getFormSubmit", "setFormSubmit", "()Z", "setOperated", "(Z)V", "getJsLoadSuccess", "setJsLoadSuccess", "getSetBottomGuideVisible", "getUbcBgmInfo", "getUpdateFontSize", "setUpdateFontSize", "getVideoStatus", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AssessmentBigTalosState.kt */
public final class AssessmentBigTalosState {
    private MutableLiveData<String> activityFinish;
    private BgmAndAnimState bgmPlayState;
    private String bgmUrl;
    private final MutableLiveData<TalosAssessmentBigModel> bindData;
    private MutableLiveData<String> formSubmit;
    private boolean isOperated;
    private MutableLiveData<String> jsLoadSuccess;
    private final MutableLiveData<Boolean> setBottomGuideVisible;
    private final MutableLiveData<BgmInfo> ubcBgmInfo;
    private MutableLiveData<Unit> updateFontSize;
    private final MutableLiveData<CardPanelBgmStatus> videoStatus;

    public AssessmentBigTalosState() {
        this((MutableLiveData) null, (MutableLiveData) null, false, (MutableLiveData) null, (MutableLiveData) null, (BgmAndAnimState) null, (String) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AssessmentBigTalosState copy$default(AssessmentBigTalosState assessmentBigTalosState, MutableLiveData mutableLiveData, MutableLiveData mutableLiveData2, boolean z, MutableLiveData mutableLiveData3, MutableLiveData mutableLiveData4, BgmAndAnimState bgmAndAnimState, String str, MutableLiveData mutableLiveData5, MutableLiveData mutableLiveData6, MutableLiveData mutableLiveData7, MutableLiveData mutableLiveData8, int i2, Object obj) {
        AssessmentBigTalosState assessmentBigTalosState2 = assessmentBigTalosState;
        int i3 = i2;
        return assessmentBigTalosState.copy((i3 & 1) != 0 ? assessmentBigTalosState2.bindData : mutableLiveData, (i3 & 2) != 0 ? assessmentBigTalosState2.setBottomGuideVisible : mutableLiveData2, (i3 & 4) != 0 ? assessmentBigTalosState2.isOperated : z, (i3 & 8) != 0 ? assessmentBigTalosState2.videoStatus : mutableLiveData3, (i3 & 16) != 0 ? assessmentBigTalosState2.ubcBgmInfo : mutableLiveData4, (i3 & 32) != 0 ? assessmentBigTalosState2.bgmPlayState : bgmAndAnimState, (i3 & 64) != 0 ? assessmentBigTalosState2.bgmUrl : str, (i3 & 128) != 0 ? assessmentBigTalosState2.activityFinish : mutableLiveData5, (i3 & 256) != 0 ? assessmentBigTalosState2.formSubmit : mutableLiveData6, (i3 & 512) != 0 ? assessmentBigTalosState2.jsLoadSuccess : mutableLiveData7, (i3 & 1024) != 0 ? assessmentBigTalosState2.updateFontSize : mutableLiveData8);
    }

    public final MutableLiveData<TalosAssessmentBigModel> component1() {
        return this.bindData;
    }

    public final MutableLiveData<String> component10() {
        return this.jsLoadSuccess;
    }

    public final MutableLiveData<Unit> component11() {
        return this.updateFontSize;
    }

    public final MutableLiveData<Boolean> component2() {
        return this.setBottomGuideVisible;
    }

    public final boolean component3() {
        return this.isOperated;
    }

    public final MutableLiveData<CardPanelBgmStatus> component4() {
        return this.videoStatus;
    }

    public final MutableLiveData<BgmInfo> component5() {
        return this.ubcBgmInfo;
    }

    public final BgmAndAnimState component6() {
        return this.bgmPlayState;
    }

    public final String component7() {
        return this.bgmUrl;
    }

    public final MutableLiveData<String> component8() {
        return this.activityFinish;
    }

    public final MutableLiveData<String> component9() {
        return this.formSubmit;
    }

    public final AssessmentBigTalosState copy(MutableLiveData<TalosAssessmentBigModel> mutableLiveData, MutableLiveData<Boolean> mutableLiveData2, boolean z, MutableLiveData<CardPanelBgmStatus> mutableLiveData3, MutableLiveData<BgmInfo> mutableLiveData4, BgmAndAnimState bgmAndAnimState, String str, MutableLiveData<String> mutableLiveData5, MutableLiveData<String> mutableLiveData6, MutableLiveData<String> mutableLiveData7, MutableLiveData<Unit> mutableLiveData8) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "bindData");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "setBottomGuideVisible");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "videoStatus");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "ubcBgmInfo");
        Intrinsics.checkNotNullParameter(bgmAndAnimState, "bgmPlayState");
        Intrinsics.checkNotNullParameter(str, "bgmUrl");
        MutableLiveData<String> mutableLiveData9 = mutableLiveData5;
        Intrinsics.checkNotNullParameter(mutableLiveData9, "activityFinish");
        Intrinsics.checkNotNullParameter(mutableLiveData6, c.k);
        Intrinsics.checkNotNullParameter(mutableLiveData7, "jsLoadSuccess");
        Intrinsics.checkNotNullParameter(mutableLiveData8, "updateFontSize");
        return new AssessmentBigTalosState(mutableLiveData, mutableLiveData2, z, mutableLiveData3, mutableLiveData4, bgmAndAnimState, str, mutableLiveData9, mutableLiveData6, mutableLiveData7, mutableLiveData8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssessmentBigTalosState)) {
            return false;
        }
        AssessmentBigTalosState assessmentBigTalosState = (AssessmentBigTalosState) obj;
        return Intrinsics.areEqual((Object) this.bindData, (Object) assessmentBigTalosState.bindData) && Intrinsics.areEqual((Object) this.setBottomGuideVisible, (Object) assessmentBigTalosState.setBottomGuideVisible) && this.isOperated == assessmentBigTalosState.isOperated && Intrinsics.areEqual((Object) this.videoStatus, (Object) assessmentBigTalosState.videoStatus) && Intrinsics.areEqual((Object) this.ubcBgmInfo, (Object) assessmentBigTalosState.ubcBgmInfo) && this.bgmPlayState == assessmentBigTalosState.bgmPlayState && Intrinsics.areEqual((Object) this.bgmUrl, (Object) assessmentBigTalosState.bgmUrl) && Intrinsics.areEqual((Object) this.activityFinish, (Object) assessmentBigTalosState.activityFinish) && Intrinsics.areEqual((Object) this.formSubmit, (Object) assessmentBigTalosState.formSubmit) && Intrinsics.areEqual((Object) this.jsLoadSuccess, (Object) assessmentBigTalosState.jsLoadSuccess) && Intrinsics.areEqual((Object) this.updateFontSize, (Object) assessmentBigTalosState.updateFontSize);
    }

    public int hashCode() {
        int hashCode = ((this.bindData.hashCode() * 31) + this.setBottomGuideVisible.hashCode()) * 31;
        boolean z = this.isOperated;
        if (z) {
            z = true;
        }
        return ((((((((((((((((hashCode + (z ? 1 : 0)) * 31) + this.videoStatus.hashCode()) * 31) + this.ubcBgmInfo.hashCode()) * 31) + this.bgmPlayState.hashCode()) * 31) + this.bgmUrl.hashCode()) * 31) + this.activityFinish.hashCode()) * 31) + this.formSubmit.hashCode()) * 31) + this.jsLoadSuccess.hashCode()) * 31) + this.updateFontSize.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssessmentBigTalosState(bindData=").append(this.bindData).append(", setBottomGuideVisible=").append(this.setBottomGuideVisible).append(", isOperated=").append(this.isOperated).append(", videoStatus=").append(this.videoStatus).append(", ubcBgmInfo=").append(this.ubcBgmInfo).append(", bgmPlayState=").append(this.bgmPlayState).append(", bgmUrl=").append(this.bgmUrl).append(", activityFinish=").append(this.activityFinish).append(", formSubmit=").append(this.formSubmit).append(", jsLoadSuccess=").append(this.jsLoadSuccess).append(", updateFontSize=").append(this.updateFontSize).append(')');
        return sb.toString();
    }

    public AssessmentBigTalosState(MutableLiveData<TalosAssessmentBigModel> bindData2, MutableLiveData<Boolean> setBottomGuideVisible2, boolean isOperated2, MutableLiveData<CardPanelBgmStatus> videoStatus2, MutableLiveData<BgmInfo> ubcBgmInfo2, BgmAndAnimState bgmPlayState2, String bgmUrl2, MutableLiveData<String> activityFinish2, MutableLiveData<String> formSubmit2, MutableLiveData<String> jsLoadSuccess2, MutableLiveData<Unit> updateFontSize2) {
        Intrinsics.checkNotNullParameter(bindData2, "bindData");
        Intrinsics.checkNotNullParameter(setBottomGuideVisible2, "setBottomGuideVisible");
        Intrinsics.checkNotNullParameter(videoStatus2, "videoStatus");
        Intrinsics.checkNotNullParameter(ubcBgmInfo2, "ubcBgmInfo");
        Intrinsics.checkNotNullParameter(bgmPlayState2, "bgmPlayState");
        Intrinsics.checkNotNullParameter(bgmUrl2, "bgmUrl");
        Intrinsics.checkNotNullParameter(activityFinish2, "activityFinish");
        Intrinsics.checkNotNullParameter(formSubmit2, c.k);
        Intrinsics.checkNotNullParameter(jsLoadSuccess2, "jsLoadSuccess");
        Intrinsics.checkNotNullParameter(updateFontSize2, "updateFontSize");
        this.bindData = bindData2;
        this.setBottomGuideVisible = setBottomGuideVisible2;
        this.isOperated = isOperated2;
        this.videoStatus = videoStatus2;
        this.ubcBgmInfo = ubcBgmInfo2;
        this.bgmPlayState = bgmPlayState2;
        this.bgmUrl = bgmUrl2;
        this.activityFinish = activityFinish2;
        this.formSubmit = formSubmit2;
        this.jsLoadSuccess = jsLoadSuccess2;
        this.updateFontSize = updateFontSize2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AssessmentBigTalosState(androidx.lifecycle.MutableLiveData r12, androidx.lifecycle.MutableLiveData r13, boolean r14, androidx.lifecycle.MutableLiveData r15, androidx.lifecycle.MutableLiveData r16, com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.BgmAndAnimState r17, java.lang.String r18, androidx.lifecycle.MutableLiveData r19, androidx.lifecycle.MutableLiveData r20, androidx.lifecycle.MutableLiveData r21, androidx.lifecycle.MutableLiveData r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r12
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0017
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x0018
        L_0x0017:
            r2 = r13
        L_0x0018:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x001e
            r3 = 0
            goto L_0x001f
        L_0x001e:
            r3 = r14
        L_0x001f:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x0029
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
            goto L_0x002a
        L_0x0029:
            r4 = r15
        L_0x002a:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0034
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            goto L_0x0036
        L_0x0034:
            r5 = r16
        L_0x0036:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x003d
            com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.BgmAndAnimState r6 = com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.BgmAndAnimState.PLAY_UNUSUAL
            goto L_0x003f
        L_0x003d:
            r6 = r17
        L_0x003f:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0046
            java.lang.String r7 = ""
            goto L_0x0048
        L_0x0046:
            r7 = r18
        L_0x0048:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x0052
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            goto L_0x0054
        L_0x0052:
            r8 = r19
        L_0x0054:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x005e
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            goto L_0x0060
        L_0x005e:
            r9 = r20
        L_0x0060:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x006a
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            goto L_0x006c
        L_0x006a:
            r10 = r21
        L_0x006c:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0076
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x0078
        L_0x0076:
            r0 = r22
        L_0x0078:
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.talosassessbig.AssessmentBigTalosState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.BgmAndAnimState, java.lang.String, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<TalosAssessmentBigModel> getBindData() {
        return this.bindData;
    }

    public final MutableLiveData<Boolean> getSetBottomGuideVisible() {
        return this.setBottomGuideVisible;
    }

    public final boolean isOperated() {
        return this.isOperated;
    }

    public final void setOperated(boolean z) {
        this.isOperated = z;
    }

    public final MutableLiveData<CardPanelBgmStatus> getVideoStatus() {
        return this.videoStatus;
    }

    public final MutableLiveData<BgmInfo> getUbcBgmInfo() {
        return this.ubcBgmInfo;
    }

    public final BgmAndAnimState getBgmPlayState() {
        return this.bgmPlayState;
    }

    public final void setBgmPlayState(BgmAndAnimState bgmAndAnimState) {
        Intrinsics.checkNotNullParameter(bgmAndAnimState, "<set-?>");
        this.bgmPlayState = bgmAndAnimState;
    }

    public final String getBgmUrl() {
        return this.bgmUrl;
    }

    public final void setBgmUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bgmUrl = str;
    }

    public final MutableLiveData<String> getActivityFinish() {
        return this.activityFinish;
    }

    public final void setActivityFinish(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.activityFinish = mutableLiveData;
    }

    public final MutableLiveData<String> getFormSubmit() {
        return this.formSubmit;
    }

    public final void setFormSubmit(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.formSubmit = mutableLiveData;
    }

    public final MutableLiveData<String> getJsLoadSuccess() {
        return this.jsLoadSuccess;
    }

    public final void setJsLoadSuccess(MutableLiveData<String> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.jsLoadSuccess = mutableLiveData;
    }

    public final MutableLiveData<Unit> getUpdateFontSize() {
        return this.updateFontSize;
    }

    public final void setUpdateFontSize(MutableLiveData<Unit> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.updateFontSize = mutableLiveData;
    }
}
