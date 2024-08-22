package com.baidu.searchbox.video.feedflow.detail.livereal;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.live.host2live.video.LiveType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001Ba\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\u0002\u0010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u001a\u0010\f\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/livereal/LiveRealContainerState;", "", "checkPluginAndGetAct", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/live/host2live/video/LiveType;", "nid", "", "scheme", "dataSuccess", "", "liveType", "pageSelectedNid", "isCancelLiveAutoPlay", "destroyLivePreload", "", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/String;Ljava/lang/String;ZLcom/baidu/searchbox/live/host2live/video/LiveType;Ljava/lang/String;ZLandroidx/lifecycle/MutableLiveData;)V", "getCheckPluginAndGetAct", "()Landroidx/lifecycle/MutableLiveData;", "getDataSuccess", "()Z", "setDataSuccess", "(Z)V", "getDestroyLivePreload", "setCancelLiveAutoPlay", "getLiveType", "()Lcom/baidu/searchbox/live/host2live/video/LiveType;", "setLiveType", "(Lcom/baidu/searchbox/live/host2live/video/LiveType;)V", "getNid", "()Ljava/lang/String;", "setNid", "(Ljava/lang/String;)V", "getPageSelectedNid", "setPageSelectedNid", "getScheme", "setScheme", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LiveRealContainerState.kt */
public final class LiveRealContainerState {
    private final MutableLiveData<LiveType> checkPluginAndGetAct;
    private boolean dataSuccess;
    private final MutableLiveData<Unit> destroyLivePreload;
    private boolean isCancelLiveAutoPlay;
    private LiveType liveType;
    private String nid;
    private String pageSelectedNid;
    private String scheme;

    public LiveRealContainerState() {
        this((MutableLiveData) null, (String) null, (String) null, false, (LiveType) null, (String) null, false, (MutableLiveData) null, 255, (DefaultConstructorMarker) null);
    }

    public LiveRealContainerState(MutableLiveData<LiveType> checkPluginAndGetAct2, String nid2, String scheme2, boolean dataSuccess2, LiveType liveType2, String pageSelectedNid2, boolean isCancelLiveAutoPlay2, MutableLiveData<Unit> destroyLivePreload2) {
        Intrinsics.checkNotNullParameter(checkPluginAndGetAct2, "checkPluginAndGetAct");
        Intrinsics.checkNotNullParameter(nid2, "nid");
        Intrinsics.checkNotNullParameter(scheme2, "scheme");
        Intrinsics.checkNotNullParameter(liveType2, "liveType");
        Intrinsics.checkNotNullParameter(pageSelectedNid2, "pageSelectedNid");
        Intrinsics.checkNotNullParameter(destroyLivePreload2, "destroyLivePreload");
        this.checkPluginAndGetAct = checkPluginAndGetAct2;
        this.nid = nid2;
        this.scheme = scheme2;
        this.dataSuccess = dataSuccess2;
        this.liveType = liveType2;
        this.pageSelectedNid = pageSelectedNid2;
        this.isCancelLiveAutoPlay = isCancelLiveAutoPlay2;
        this.destroyLivePreload = destroyLivePreload2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LiveRealContainerState(androidx.lifecycle.MutableLiveData r10, java.lang.String r11, java.lang.String r12, boolean r13, com.baidu.searchbox.live.host2live.video.LiveType r14, java.lang.String r15, boolean r16, androidx.lifecycle.MutableLiveData r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            androidx.lifecycle.MutableLiveData r1 = new androidx.lifecycle.MutableLiveData
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r10
        L_0x000d:
            r2 = r0 & 2
            java.lang.String r3 = ""
            if (r2 == 0) goto L_0x0015
            r2 = r3
            goto L_0x0016
        L_0x0015:
            r2 = r11
        L_0x0016:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001c
            r4 = r3
            goto L_0x001d
        L_0x001c:
            r4 = r12
        L_0x001d:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0024
            r5 = r6
            goto L_0x0025
        L_0x0024:
            r5 = r13
        L_0x0025:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002c
            com.baidu.searchbox.live.host2live.video.LiveType r7 = com.baidu.searchbox.live.host2live.video.LiveType.MEDIA
            goto L_0x002d
        L_0x002c:
            r7 = r14
        L_0x002d:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            goto L_0x0033
        L_0x0032:
            r3 = r15
        L_0x0033:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r6 = r16
        L_0x003a:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0044
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            goto L_0x0046
        L_0x0044:
            r0 = r17
        L_0x0046:
            r10 = r1
            r11 = r2
            r12 = r4
            r13 = r5
            r14 = r7
            r15 = r3
            r16 = r6
            r17 = r0
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerState.<init>(androidx.lifecycle.MutableLiveData, java.lang.String, java.lang.String, boolean, com.baidu.searchbox.live.host2live.video.LiveType, java.lang.String, boolean, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<LiveType> getCheckPluginAndGetAct() {
        return this.checkPluginAndGetAct;
    }

    public final String getNid() {
        return this.nid;
    }

    public final void setNid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nid = str;
    }

    public final String getScheme() {
        return this.scheme;
    }

    public final void setScheme(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.scheme = str;
    }

    public final boolean getDataSuccess() {
        return this.dataSuccess;
    }

    public final void setDataSuccess(boolean z) {
        this.dataSuccess = z;
    }

    public final LiveType getLiveType() {
        return this.liveType;
    }

    public final void setLiveType(LiveType liveType2) {
        Intrinsics.checkNotNullParameter(liveType2, "<set-?>");
        this.liveType = liveType2;
    }

    public final String getPageSelectedNid() {
        return this.pageSelectedNid;
    }

    public final void setPageSelectedNid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pageSelectedNid = str;
    }

    public final boolean isCancelLiveAutoPlay() {
        return this.isCancelLiveAutoPlay;
    }

    public final void setCancelLiveAutoPlay(boolean z) {
        this.isCancelLiveAutoPlay = z;
    }

    public final MutableLiveData<Unit> getDestroyLivePreload() {
        return this.destroyLivePreload;
    }
}
