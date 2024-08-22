package com.baidu.searchbox.video.feedflow.detail.protocol;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.searchflow.detail.api.ProtocolModel;
import com.baidu.searchbox.video.detail.message.MessageManifest;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u001a\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/protocol/FlowProtocolState;", "", "data", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/searchflow/detail/api/ProtocolModel;", "isVisible", "", "alphaAndHeightAnim", "isShowOrHideAnim", "time", "", "area", "isLeftAreaShow", "setInitStyle", "", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;ZLandroidx/lifecycle/MutableLiveData;)V", "getAlphaAndHeightAnim", "()Landroidx/lifecycle/MutableLiveData;", "getArea", "getData", "()Z", "setLeftAreaShow", "(Z)V", "isLongPressing", "getSetInitStyle", "setSetInitStyle", "(Landroidx/lifecycle/MutableLiveData;)V", "getTime", "handleLongPressing", "", "isLongPress", "reset", "state", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NestedAction$OnBindData;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowProtocolState.kt */
public final class FlowProtocolState {
    private final MutableLiveData<Boolean> alphaAndHeightAnim;
    private final MutableLiveData<String> area;
    private final MutableLiveData<ProtocolModel> data;
    private boolean isLeftAreaShow;
    private boolean isLongPressing;
    private final MutableLiveData<Boolean> isShowOrHideAnim;
    private final MutableLiveData<Boolean> isVisible;
    private MutableLiveData<Integer> setInitStyle;
    private final MutableLiveData<String> time;

    public FlowProtocolState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, false, (MutableLiveData) null, 255, (DefaultConstructorMarker) null);
    }

    public FlowProtocolState(MutableLiveData<ProtocolModel> data2, MutableLiveData<Boolean> isVisible2, MutableLiveData<Boolean> alphaAndHeightAnim2, MutableLiveData<Boolean> isShowOrHideAnim2, MutableLiveData<String> time2, MutableLiveData<String> area2, boolean isLeftAreaShow2, MutableLiveData<Integer> setInitStyle2) {
        Intrinsics.checkNotNullParameter(data2, "data");
        Intrinsics.checkNotNullParameter(isVisible2, "isVisible");
        Intrinsics.checkNotNullParameter(alphaAndHeightAnim2, "alphaAndHeightAnim");
        Intrinsics.checkNotNullParameter(isShowOrHideAnim2, "isShowOrHideAnim");
        Intrinsics.checkNotNullParameter(time2, "time");
        Intrinsics.checkNotNullParameter(area2, MessageManifest.Advert.Key.AREA);
        Intrinsics.checkNotNullParameter(setInitStyle2, "setInitStyle");
        this.data = data2;
        this.isVisible = isVisible2;
        this.alphaAndHeightAnim = alphaAndHeightAnim2;
        this.isShowOrHideAnim = isShowOrHideAnim2;
        this.time = time2;
        this.area = area2;
        this.isLeftAreaShow = isLeftAreaShow2;
        this.setInitStyle = setInitStyle2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlowProtocolState(androidx.lifecycle.MutableLiveData r9, androidx.lifecycle.MutableLiveData r10, androidx.lifecycle.MutableLiveData r11, androidx.lifecycle.MutableLiveData r12, androidx.lifecycle.MutableLiveData r13, androidx.lifecycle.MutableLiveData r14, boolean r15, androidx.lifecycle.MutableLiveData r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r8 = this;
            r0 = r17
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r9
        L_0x000d:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x0017
            androidx.lifecycle.MutableLiveData r2 = new androidx.lifecycle.MutableLiveData
            r2.<init>()
            goto L_0x0018
        L_0x0017:
            r2 = r10
        L_0x0018:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0022
            androidx.lifecycle.MutableLiveData r3 = new androidx.lifecycle.MutableLiveData
            r3.<init>()
            goto L_0x0023
        L_0x0022:
            r3 = r11
        L_0x0023:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x002d
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
            goto L_0x002e
        L_0x002d:
            r4 = r12
        L_0x002e:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0038
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            goto L_0x0039
        L_0x0038:
            r5 = r13
        L_0x0039:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x0043
            androidx.lifecycle.MutableLiveData r6 = new androidx.lifecycle.MutableLiveData
            r6.<init>()
            goto L_0x0044
        L_0x0043:
            r6 = r14
        L_0x0044:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x004a
            r7 = 1
            goto L_0x004b
        L_0x004a:
            r7 = r15
        L_0x004b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0055
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x0057
        L_0x0055:
            r0 = r16
        L_0x0057:
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r14 = r6
            r15 = r7
            r16 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.protocol.FlowProtocolState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, boolean, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<ProtocolModel> getData() {
        return this.data;
    }

    public final MutableLiveData<Boolean> isVisible() {
        return this.isVisible;
    }

    public final MutableLiveData<Boolean> getAlphaAndHeightAnim() {
        return this.alphaAndHeightAnim;
    }

    public final MutableLiveData<Boolean> isShowOrHideAnim() {
        return this.isShowOrHideAnim;
    }

    public final MutableLiveData<String> getTime() {
        return this.time;
    }

    public final MutableLiveData<String> getArea() {
        return this.area;
    }

    public final boolean isLeftAreaShow() {
        return this.isLeftAreaShow;
    }

    public final void setLeftAreaShow(boolean z) {
        this.isLeftAreaShow = z;
    }

    public final MutableLiveData<Integer> getSetInitStyle() {
        return this.setInitStyle;
    }

    public final void setSetInitStyle(MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.setInitStyle = mutableLiveData;
    }

    public final boolean isLongPressing() {
        return this.isLongPressing;
    }

    public final void handleLongPressing(boolean isLongPress) {
        this.isLongPressing = isLongPress;
        if (Intrinsics.areEqual((Object) this.isVisible.getValue(), (Object) true)) {
            this.isShowOrHideAnim.setValue(Boolean.valueOf(!isLongPress));
        }
    }

    public final void reset(CommonState state, NestedAction.OnBindData<?> action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        Object data2 = action.getData();
        if (VideoFlowUtilsKt.getComponentInitStyleByFirstJump(state, (ItemModel<?>) data2 instanceof ItemModel ? (ItemModel) data2 : null) != null) {
            this.setInitStyle.setValue(1);
        } else {
            this.setInitStyle.setValue(0);
        }
    }
}
