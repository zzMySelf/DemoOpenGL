package com.baidu.searchbox.dynamicpublisher.publish;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.ugc.model.PublishModels;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0013\b\u0002\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u0003\u0012\"\b\u0002\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r0\u0003\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0003\u0012\u001e\b\u0002\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t0\u0003¢\u0006\u0002\u0010\u0011J\u0014\u0010\u0019\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J\u001b\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u0003HÆ\u0003J#\u0010\u001c\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r0\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0003HÆ\u0003J\u001f\u0010\u001e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t0\u0003HÆ\u0003J \u0001\u0010\u001f\u001a\u00020\u00002\u0013\b\u0002\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u00032\"\b\u0002\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r0\u00032\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00032\u001e\b\u0002\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t0\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\t\u0010$\u001a\u00020\u000fHÖ\u0001R#\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\u0002\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R'\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R+\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/publish/PublishState;", "", "publishStatus", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/baidu/searchbox/dynamicpublisher/publish/PublishStatus;", "publishModel", "Lcom/baidu/searchbox/dynamicpublisher/publish/PublishModel;", "progress", "Lkotlin/Pair;", "uploadImageResult", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/PublishModels$ImageData;", "Lkotlin/collections/ArrayList;", "uploadVideoResult", "", "uploadCoverResult", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;)V", "getProgress", "()Landroidx/lifecycle/MutableLiveData;", "getPublishModel", "getPublishStatus", "getUploadCoverResult", "getUploadImageResult", "getUploadVideoResult", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishState.kt */
public final class PublishState {
    private final MutableLiveData<Pair<Integer, Integer>> progress;
    private final MutableLiveData<PublishModel> publishModel;
    private final MutableLiveData<Integer> publishStatus;
    private final MutableLiveData<Pair<String, String>> uploadCoverResult;
    private final MutableLiveData<ArrayList<PublishModels.ImageData>> uploadImageResult;
    private final MutableLiveData<String> uploadVideoResult;

    public PublishState() {
        this((MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, (MutableLiveData) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PublishState copy$default(PublishState publishState, MutableLiveData<Integer> mutableLiveData, MutableLiveData<PublishModel> mutableLiveData2, MutableLiveData<Pair<Integer, Integer>> mutableLiveData3, MutableLiveData<ArrayList<PublishModels.ImageData>> mutableLiveData4, MutableLiveData<String> mutableLiveData5, MutableLiveData<Pair<String, String>> mutableLiveData6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mutableLiveData = publishState.publishStatus;
        }
        if ((i2 & 2) != 0) {
            mutableLiveData2 = publishState.publishModel;
        }
        MutableLiveData<PublishModel> mutableLiveData7 = mutableLiveData2;
        if ((i2 & 4) != 0) {
            mutableLiveData3 = publishState.progress;
        }
        MutableLiveData<Pair<Integer, Integer>> mutableLiveData8 = mutableLiveData3;
        if ((i2 & 8) != 0) {
            mutableLiveData4 = publishState.uploadImageResult;
        }
        MutableLiveData<ArrayList<PublishModels.ImageData>> mutableLiveData9 = mutableLiveData4;
        if ((i2 & 16) != 0) {
            mutableLiveData5 = publishState.uploadVideoResult;
        }
        MutableLiveData<String> mutableLiveData10 = mutableLiveData5;
        if ((i2 & 32) != 0) {
            mutableLiveData6 = publishState.uploadCoverResult;
        }
        return publishState.copy(mutableLiveData, mutableLiveData7, mutableLiveData8, mutableLiveData9, mutableLiveData10, mutableLiveData6);
    }

    public final MutableLiveData<Integer> component1() {
        return this.publishStatus;
    }

    public final MutableLiveData<PublishModel> component2() {
        return this.publishModel;
    }

    public final MutableLiveData<Pair<Integer, Integer>> component3() {
        return this.progress;
    }

    public final MutableLiveData<ArrayList<PublishModels.ImageData>> component4() {
        return this.uploadImageResult;
    }

    public final MutableLiveData<String> component5() {
        return this.uploadVideoResult;
    }

    public final MutableLiveData<Pair<String, String>> component6() {
        return this.uploadCoverResult;
    }

    public final PublishState copy(MutableLiveData<Integer> mutableLiveData, MutableLiveData<PublishModel> mutableLiveData2, MutableLiveData<Pair<Integer, Integer>> mutableLiveData3, MutableLiveData<ArrayList<PublishModels.ImageData>> mutableLiveData4, MutableLiveData<String> mutableLiveData5, MutableLiveData<Pair<String, String>> mutableLiveData6) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "publishStatus");
        Intrinsics.checkNotNullParameter(mutableLiveData2, "publishModel");
        Intrinsics.checkNotNullParameter(mutableLiveData3, "progress");
        Intrinsics.checkNotNullParameter(mutableLiveData4, "uploadImageResult");
        Intrinsics.checkNotNullParameter(mutableLiveData5, "uploadVideoResult");
        Intrinsics.checkNotNullParameter(mutableLiveData6, "uploadCoverResult");
        return new PublishState(mutableLiveData, mutableLiveData2, mutableLiveData3, mutableLiveData4, mutableLiveData5, mutableLiveData6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublishState)) {
            return false;
        }
        PublishState publishState = (PublishState) obj;
        return Intrinsics.areEqual((Object) this.publishStatus, (Object) publishState.publishStatus) && Intrinsics.areEqual((Object) this.publishModel, (Object) publishState.publishModel) && Intrinsics.areEqual((Object) this.progress, (Object) publishState.progress) && Intrinsics.areEqual((Object) this.uploadImageResult, (Object) publishState.uploadImageResult) && Intrinsics.areEqual((Object) this.uploadVideoResult, (Object) publishState.uploadVideoResult) && Intrinsics.areEqual((Object) this.uploadCoverResult, (Object) publishState.uploadCoverResult);
    }

    public int hashCode() {
        return (((((((((this.publishStatus.hashCode() * 31) + this.publishModel.hashCode()) * 31) + this.progress.hashCode()) * 31) + this.uploadImageResult.hashCode()) * 31) + this.uploadVideoResult.hashCode()) * 31) + this.uploadCoverResult.hashCode();
    }

    public String toString() {
        return "PublishState(publishStatus=" + this.publishStatus + ", publishModel=" + this.publishModel + ", progress=" + this.progress + ", uploadImageResult=" + this.uploadImageResult + ", uploadVideoResult=" + this.uploadVideoResult + ", uploadCoverResult=" + this.uploadCoverResult + ')';
    }

    public PublishState(MutableLiveData<Integer> publishStatus2, MutableLiveData<PublishModel> publishModel2, MutableLiveData<Pair<Integer, Integer>> progress2, MutableLiveData<ArrayList<PublishModels.ImageData>> uploadImageResult2, MutableLiveData<String> uploadVideoResult2, MutableLiveData<Pair<String, String>> uploadCoverResult2) {
        Intrinsics.checkNotNullParameter(publishStatus2, "publishStatus");
        Intrinsics.checkNotNullParameter(publishModel2, "publishModel");
        Intrinsics.checkNotNullParameter(progress2, "progress");
        Intrinsics.checkNotNullParameter(uploadImageResult2, "uploadImageResult");
        Intrinsics.checkNotNullParameter(uploadVideoResult2, "uploadVideoResult");
        Intrinsics.checkNotNullParameter(uploadCoverResult2, "uploadCoverResult");
        this.publishStatus = publishStatus2;
        this.publishModel = publishModel2;
        this.progress = progress2;
        this.uploadImageResult = uploadImageResult2;
        this.uploadVideoResult = uploadVideoResult2;
        this.uploadCoverResult = uploadCoverResult2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PublishState(androidx.lifecycle.MutableLiveData r8, androidx.lifecycle.MutableLiveData r9, androidx.lifecycle.MutableLiveData r10, androidx.lifecycle.MutableLiveData r11, androidx.lifecycle.MutableLiveData r12, androidx.lifecycle.MutableLiveData r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r15 = r14 & 1
            if (r15 == 0) goto L_0x0010
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r15 = 0
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r8.<init>(r15)
            r1 = r8
            goto L_0x0011
        L_0x0010:
            r1 = r8
        L_0x0011:
            r8 = r14 & 2
            if (r8 == 0) goto L_0x001c
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            r2 = r9
            goto L_0x001d
        L_0x001c:
            r2 = r9
        L_0x001d:
            r8 = r14 & 4
            if (r8 == 0) goto L_0x0028
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r3 = r10
            goto L_0x0029
        L_0x0028:
            r3 = r10
        L_0x0029:
            r8 = r14 & 8
            if (r8 == 0) goto L_0x0034
            androidx.lifecycle.MutableLiveData r11 = new androidx.lifecycle.MutableLiveData
            r11.<init>()
            r4 = r11
            goto L_0x0035
        L_0x0034:
            r4 = r11
        L_0x0035:
            r8 = r14 & 16
            if (r8 == 0) goto L_0x0040
            androidx.lifecycle.MutableLiveData r12 = new androidx.lifecycle.MutableLiveData
            r12.<init>()
            r5 = r12
            goto L_0x0041
        L_0x0040:
            r5 = r12
        L_0x0041:
            r8 = r14 & 32
            if (r8 == 0) goto L_0x004c
            androidx.lifecycle.MutableLiveData r13 = new androidx.lifecycle.MutableLiveData
            r13.<init>()
            r6 = r13
            goto L_0x004d
        L_0x004c:
            r6 = r13
        L_0x004d:
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.dynamicpublisher.publish.PublishState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Integer> getPublishStatus() {
        return this.publishStatus;
    }

    public final MutableLiveData<PublishModel> getPublishModel() {
        return this.publishModel;
    }

    public final MutableLiveData<Pair<Integer, Integer>> getProgress() {
        return this.progress;
    }

    public final MutableLiveData<ArrayList<PublishModels.ImageData>> getUploadImageResult() {
        return this.uploadImageResult;
    }

    public final MutableLiveData<String> getUploadVideoResult() {
        return this.uploadVideoResult;
    }

    public final MutableLiveData<Pair<String, String>> getUploadCoverResult() {
        return this.uploadCoverResult;
    }
}
