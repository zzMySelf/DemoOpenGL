package com.baidu.searchbox.video.feedflow.flow.offlinecache;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.video.feedflow.cache.model.InsertOfflineCacheFailType;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "BufferBlockAction", "InsertCacheDataAction", "InsertCacheFailAction", "NetReductionAction", "OfflineCacheDownloadStart", "OfflineCacheDownloadSuccess", "StartCacheAction", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$BufferBlockAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$InsertCacheDataAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$StartCacheAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$InsertCacheFailAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$NetReductionAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$OfflineCacheDownloadStart;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$OfflineCacheDownloadSuccess;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowOfflineCacheManifest.kt */
public abstract class FlowOfflineCacheAction implements Action {
    public /* synthetic */ FlowOfflineCacheAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FlowOfflineCacheAction() {
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$BufferBlockAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowOfflineCacheManifest.kt */
    public static final class BufferBlockAction extends FlowOfflineCacheAction {
        public static final BufferBlockAction INSTANCE = new BufferBlockAction();

        private BufferBlockAction() {
            super((DefaultConstructorMarker) null);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B'\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0013\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$InsertCacheDataAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "modelList", "", "Lcom/baidu/searchbox/video/feedflow/flow/list/ItemModel;", "insertType", "", "count", "", "(Ljava/util/List;Ljava/lang/String;I)V", "getCount", "()I", "getInsertType", "()Ljava/lang/String;", "getModelList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowOfflineCacheManifest.kt */
    public static final class InsertCacheDataAction extends FlowOfflineCacheAction {
        private final int count;
        private final String insertType;
        private final List<ItemModel<?>> modelList;

        public static /* synthetic */ InsertCacheDataAction copy$default(InsertCacheDataAction insertCacheDataAction, List<ItemModel<?>> list, String str, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = insertCacheDataAction.modelList;
            }
            if ((i3 & 2) != 0) {
                str = insertCacheDataAction.insertType;
            }
            if ((i3 & 4) != 0) {
                i2 = insertCacheDataAction.count;
            }
            return insertCacheDataAction.copy(list, str, i2);
        }

        public final List<ItemModel<?>> component1() {
            return this.modelList;
        }

        public final String component2() {
            return this.insertType;
        }

        public final int component3() {
            return this.count;
        }

        public final InsertCacheDataAction copy(List<? extends ItemModel<?>> list, String str, int i2) {
            Intrinsics.checkNotNullParameter(list, "modelList");
            Intrinsics.checkNotNullParameter(str, "insertType");
            return new InsertCacheDataAction(list, str, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InsertCacheDataAction)) {
                return false;
            }
            InsertCacheDataAction insertCacheDataAction = (InsertCacheDataAction) obj;
            return Intrinsics.areEqual((Object) this.modelList, (Object) insertCacheDataAction.modelList) && Intrinsics.areEqual((Object) this.insertType, (Object) insertCacheDataAction.insertType) && this.count == insertCacheDataAction.count;
        }

        public int hashCode() {
            return (((this.modelList.hashCode() * 31) + this.insertType.hashCode()) * 31) + Integer.hashCode(this.count);
        }

        public String toString() {
            return "InsertCacheDataAction(modelList=" + this.modelList + ", insertType=" + this.insertType + ", count=" + this.count + ')';
        }

        public final int getCount() {
            return this.count;
        }

        public final String getInsertType() {
            return this.insertType;
        }

        public final List<ItemModel<?>> getModelList() {
            return this.modelList;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InsertCacheDataAction(List<? extends ItemModel<?>> modelList2, String insertType2, int count2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(modelList2, "modelList");
            Intrinsics.checkNotNullParameter(insertType2, "insertType");
            this.modelList = modelList2;
            this.insertType = insertType2;
            this.count = count2;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$StartCacheAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowOfflineCacheManifest.kt */
    public static final class StartCacheAction extends FlowOfflineCacheAction {
        public static final StartCacheAction INSTANCE = new StartCacheAction();

        private StartCacheAction() {
            super((DefaultConstructorMarker) null);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$InsertCacheFailAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "failReason", "Lcom/baidu/searchbox/video/feedflow/cache/model/InsertOfflineCacheFailType;", "insertType", "", "cacheStatus", "(Lcom/baidu/searchbox/video/feedflow/cache/model/InsertOfflineCacheFailType;Ljava/lang/String;Ljava/lang/String;)V", "getCacheStatus", "()Ljava/lang/String;", "getFailReason", "()Lcom/baidu/searchbox/video/feedflow/cache/model/InsertOfflineCacheFailType;", "getInsertType", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowOfflineCacheManifest.kt */
    public static final class InsertCacheFailAction extends FlowOfflineCacheAction {
        private final String cacheStatus;
        private final InsertOfflineCacheFailType failReason;
        private final String insertType;

        public static /* synthetic */ InsertCacheFailAction copy$default(InsertCacheFailAction insertCacheFailAction, InsertOfflineCacheFailType insertOfflineCacheFailType, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                insertOfflineCacheFailType = insertCacheFailAction.failReason;
            }
            if ((i2 & 2) != 0) {
                str = insertCacheFailAction.insertType;
            }
            if ((i2 & 4) != 0) {
                str2 = insertCacheFailAction.cacheStatus;
            }
            return insertCacheFailAction.copy(insertOfflineCacheFailType, str, str2);
        }

        public final InsertOfflineCacheFailType component1() {
            return this.failReason;
        }

        public final String component2() {
            return this.insertType;
        }

        public final String component3() {
            return this.cacheStatus;
        }

        public final InsertCacheFailAction copy(InsertOfflineCacheFailType insertOfflineCacheFailType, String str, String str2) {
            Intrinsics.checkNotNullParameter(insertOfflineCacheFailType, "failReason");
            Intrinsics.checkNotNullParameter(str, "insertType");
            Intrinsics.checkNotNullParameter(str2, "cacheStatus");
            return new InsertCacheFailAction(insertOfflineCacheFailType, str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof InsertCacheFailAction)) {
                return false;
            }
            InsertCacheFailAction insertCacheFailAction = (InsertCacheFailAction) obj;
            return this.failReason == insertCacheFailAction.failReason && Intrinsics.areEqual((Object) this.insertType, (Object) insertCacheFailAction.insertType) && Intrinsics.areEqual((Object) this.cacheStatus, (Object) insertCacheFailAction.cacheStatus);
        }

        public int hashCode() {
            return (((this.failReason.hashCode() * 31) + this.insertType.hashCode()) * 31) + this.cacheStatus.hashCode();
        }

        public String toString() {
            return "InsertCacheFailAction(failReason=" + this.failReason + ", insertType=" + this.insertType + ", cacheStatus=" + this.cacheStatus + ')';
        }

        public final InsertOfflineCacheFailType getFailReason() {
            return this.failReason;
        }

        public final String getInsertType() {
            return this.insertType;
        }

        public final String getCacheStatus() {
            return this.cacheStatus;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InsertCacheFailAction(InsertOfflineCacheFailType failReason2, String insertType2, String cacheStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(failReason2, "failReason");
            Intrinsics.checkNotNullParameter(insertType2, "insertType");
            Intrinsics.checkNotNullParameter(cacheStatus2, "cacheStatus");
            this.failReason = failReason2;
            this.insertType = insertType2;
            this.cacheStatus = cacheStatus2;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$NetReductionAction;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowOfflineCacheManifest.kt */
    public static final class NetReductionAction extends FlowOfflineCacheAction {
        public static final NetReductionAction INSTANCE = new NetReductionAction();

        private NetReductionAction() {
            super((DefaultConstructorMarker) null);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$OfflineCacheDownloadStart;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "nid", "", "(Ljava/lang/String;)V", "getNid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowOfflineCacheManifest.kt */
    public static final class OfflineCacheDownloadStart extends FlowOfflineCacheAction {
        private final String nid;

        public static /* synthetic */ OfflineCacheDownloadStart copy$default(OfflineCacheDownloadStart offlineCacheDownloadStart, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = offlineCacheDownloadStart.nid;
            }
            return offlineCacheDownloadStart.copy(str);
        }

        public final String component1() {
            return this.nid;
        }

        public final OfflineCacheDownloadStart copy(String str) {
            return new OfflineCacheDownloadStart(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OfflineCacheDownloadStart) && Intrinsics.areEqual((Object) this.nid, (Object) ((OfflineCacheDownloadStart) obj).nid);
        }

        public int hashCode() {
            String str = this.nid;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "OfflineCacheDownloadStart(nid=" + this.nid + ')';
        }

        public OfflineCacheDownloadStart(String nid2) {
            super((DefaultConstructorMarker) null);
            this.nid = nid2;
        }

        public final String getNid() {
            return this.nid;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction$OfflineCacheDownloadSuccess;", "Lcom/baidu/searchbox/video/feedflow/flow/offlinecache/FlowOfflineCacheAction;", "nid", "", "(Ljava/lang/String;)V", "getNid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowOfflineCacheManifest.kt */
    public static final class OfflineCacheDownloadSuccess extends FlowOfflineCacheAction {
        private final String nid;

        public static /* synthetic */ OfflineCacheDownloadSuccess copy$default(OfflineCacheDownloadSuccess offlineCacheDownloadSuccess, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = offlineCacheDownloadSuccess.nid;
            }
            return offlineCacheDownloadSuccess.copy(str);
        }

        public final String component1() {
            return this.nid;
        }

        public final OfflineCacheDownloadSuccess copy(String str) {
            return new OfflineCacheDownloadSuccess(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OfflineCacheDownloadSuccess) && Intrinsics.areEqual((Object) this.nid, (Object) ((OfflineCacheDownloadSuccess) obj).nid);
        }

        public int hashCode() {
            String str = this.nid;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "OfflineCacheDownloadSuccess(nid=" + this.nid + ')';
        }

        public OfflineCacheDownloadSuccess(String nid2) {
            super((DefaultConstructorMarker) null);
            this.nid = nid2;
        }

        public final String getNid() {
            return this.nid;
        }
    }
}
