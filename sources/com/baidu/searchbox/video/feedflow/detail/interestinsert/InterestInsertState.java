package com.baidu.searchbox.video.feedflow.detail.interestinsert;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.video.feedflow.flow.list.InterestTagModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001BO\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0016\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/interestinsert/InterestInsertState;", "", "fastPageCount", "Landroidx/lifecycle/MutableLiveData;", "", "isCanInsert", "", "pagePosition", "isShowing", "isShown", "data", "Lcom/baidu/searchbox/video/feedflow/flow/list/InterestTagModel;", "(Landroidx/lifecycle/MutableLiveData;ZILandroidx/lifecycle/MutableLiveData;ZLcom/baidu/searchbox/video/feedflow/flow/list/InterestTagModel;)V", "getData", "()Lcom/baidu/searchbox/video/feedflow/flow/list/InterestTagModel;", "setData", "(Lcom/baidu/searchbox/video/feedflow/flow/list/InterestTagModel;)V", "getFastPageCount", "()Landroidx/lifecycle/MutableLiveData;", "()Z", "setCanInsert", "(Z)V", "setShown", "getPagePosition", "()I", "setPagePosition", "(I)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InterestInsertState.kt */
public final class InterestInsertState {
    private InterestTagModel data;
    private final MutableLiveData<Integer> fastPageCount;
    private boolean isCanInsert;
    private final MutableLiveData<Boolean> isShowing;
    private boolean isShown;
    private int pagePosition;

    public InterestInsertState() {
        this((MutableLiveData) null, false, 0, (MutableLiveData) null, false, (InterestTagModel) null, 63, (DefaultConstructorMarker) null);
    }

    public InterestInsertState(MutableLiveData<Integer> fastPageCount2, boolean isCanInsert2, int pagePosition2, MutableLiveData<Boolean> isShowing2, boolean isShown2, InterestTagModel data2) {
        Intrinsics.checkNotNullParameter(fastPageCount2, "fastPageCount");
        Intrinsics.checkNotNullParameter(isShowing2, "isShowing");
        this.fastPageCount = fastPageCount2;
        this.isCanInsert = isCanInsert2;
        this.pagePosition = pagePosition2;
        this.isShowing = isShowing2;
        this.isShown = isShown2;
        this.data = data2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InterestInsertState(androidx.lifecycle.MutableLiveData r5, boolean r6, int r7, androidx.lifecycle.MutableLiveData r8, boolean r9, com.baidu.searchbox.video.feedflow.flow.list.InterestTagModel r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
        L_0x0009:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0010
            r6 = 1
            r12 = r6
            goto L_0x0011
        L_0x0010:
            r12 = r6
        L_0x0011:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0018
            r7 = -1
            r0 = r7
            goto L_0x0019
        L_0x0018:
            r0 = r7
        L_0x0019:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x0024
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r1 = r8
            goto L_0x0025
        L_0x0024:
            r1 = r8
        L_0x0025:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x002c
            r9 = 0
            r2 = r9
            goto L_0x002d
        L_0x002c:
            r2 = r9
        L_0x002d:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0034
            r10 = 0
            r3 = r10
            goto L_0x0035
        L_0x0034:
            r3 = r10
        L_0x0035:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.interestinsert.InterestInsertState.<init>(androidx.lifecycle.MutableLiveData, boolean, int, androidx.lifecycle.MutableLiveData, boolean, com.baidu.searchbox.video.feedflow.flow.list.InterestTagModel, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Integer> getFastPageCount() {
        return this.fastPageCount;
    }

    public final boolean isCanInsert() {
        return this.isCanInsert;
    }

    public final void setCanInsert(boolean z) {
        this.isCanInsert = z;
    }

    public final int getPagePosition() {
        return this.pagePosition;
    }

    public final void setPagePosition(int i2) {
        this.pagePosition = i2;
    }

    public final MutableLiveData<Boolean> isShowing() {
        return this.isShowing;
    }

    public final boolean isShown() {
        return this.isShown;
    }

    public final void setShown(boolean z) {
        this.isShown = z;
    }

    public final InterestTagModel getData() {
        return this.data;
    }

    public final void setData(InterestTagModel interestTagModel) {
        this.data = interestTagModel;
    }
}
