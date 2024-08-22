package com.baidu.searchbox.video.feedflow.flow.requestperformance;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.common.RequestRecordStat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001BE\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/requestperformance/FlowRequestPerformanceState;", "", "startStat", "Landroidx/lifecycle/MutableLiveData;", "", "endStat", "refreshState", "", "serverCostPass", "record", "Lcom/baidu/searchbox/common/RequestRecordStat;", "(Landroidx/lifecycle/MutableLiveData;Landroidx/lifecycle/MutableLiveData;Ljava/lang/String;Ljava/lang/String;Lcom/baidu/searchbox/common/RequestRecordStat;)V", "getEndStat", "()Landroidx/lifecycle/MutableLiveData;", "getRecord", "()Lcom/baidu/searchbox/common/RequestRecordStat;", "setRecord", "(Lcom/baidu/searchbox/common/RequestRecordStat;)V", "getRefreshState", "()Ljava/lang/String;", "setRefreshState", "(Ljava/lang/String;)V", "getServerCostPass", "setServerCostPass", "getStartStat", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowRequestPerformanceState.kt */
public final class FlowRequestPerformanceState {
    private final MutableLiveData<Unit> endStat;
    private RequestRecordStat record;
    private String refreshState;
    private String serverCostPass;
    private final MutableLiveData<Unit> startStat;

    public FlowRequestPerformanceState() {
        this((MutableLiveData) null, (MutableLiveData) null, (String) null, (String) null, (RequestRecordStat) null, 31, (DefaultConstructorMarker) null);
    }

    public FlowRequestPerformanceState(MutableLiveData<Unit> startStat2, MutableLiveData<Unit> endStat2, String refreshState2, String serverCostPass2, RequestRecordStat record2) {
        Intrinsics.checkNotNullParameter(startStat2, "startStat");
        Intrinsics.checkNotNullParameter(endStat2, "endStat");
        Intrinsics.checkNotNullParameter(refreshState2, "refreshState");
        Intrinsics.checkNotNullParameter(serverCostPass2, "serverCostPass");
        this.startStat = startStat2;
        this.endStat = endStat2;
        this.refreshState = refreshState2;
        this.serverCostPass = serverCostPass2;
        this.record = record2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ FlowRequestPerformanceState(androidx.lifecycle.MutableLiveData r4, androidx.lifecycle.MutableLiveData r5, java.lang.String r6, java.lang.String r7, com.baidu.searchbox.common.RequestRecordStat r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0009
            androidx.lifecycle.MutableLiveData r4 = new androidx.lifecycle.MutableLiveData
            r4.<init>()
        L_0x0009:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0014
            androidx.lifecycle.MutableLiveData r5 = new androidx.lifecycle.MutableLiveData
            r5.<init>()
            r10 = r5
            goto L_0x0015
        L_0x0014:
            r10 = r5
        L_0x0015:
            r5 = r9 & 4
            java.lang.String r0 = ""
            if (r5 == 0) goto L_0x001d
            r1 = r0
            goto L_0x001e
        L_0x001d:
            r1 = r6
        L_0x001e:
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r0 = r7
        L_0x0024:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x002b
            r8 = 0
            r2 = r8
            goto L_0x002c
        L_0x002b:
            r2 = r8
        L_0x002c:
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r1
            r9 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.flow.requestperformance.FlowRequestPerformanceState.<init>(androidx.lifecycle.MutableLiveData, androidx.lifecycle.MutableLiveData, java.lang.String, java.lang.String, com.baidu.searchbox.common.RequestRecordStat, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MutableLiveData<Unit> getStartStat() {
        return this.startStat;
    }

    public final MutableLiveData<Unit> getEndStat() {
        return this.endStat;
    }

    public final String getRefreshState() {
        return this.refreshState;
    }

    public final void setRefreshState(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.refreshState = str;
    }

    public final String getServerCostPass() {
        return this.serverCostPass;
    }

    public final void setServerCostPass(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serverCostPass = str;
    }

    public final RequestRecordStat getRecord() {
        return this.record;
    }

    public final void setRecord(RequestRecordStat requestRecordStat) {
        this.record = requestRecordStat;
    }
}
