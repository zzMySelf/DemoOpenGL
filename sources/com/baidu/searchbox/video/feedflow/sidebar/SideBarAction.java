package com.baidu.searchbox.video.feedflow.sidebar;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "OnDrawerClose", "OnDrawerOpen", "OnDrawerSlideBegin", "OnLeftDrawerOpen", "OnOuterRedDotNotifyAction", "OnSideBarEnterClickAction", "OnViewCoveredState", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnDrawerSlideBegin;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnDrawerOpen;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnLeftDrawerOpen;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnDrawerClose;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnSideBarEnterClickAction;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnOuterRedDotNotifyAction;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnViewCoveredState;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SideBarActionManifest.kt */
public abstract class SideBarAction implements Action {
    public /* synthetic */ SideBarAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SideBarAction() {
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnDrawerSlideBegin;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "isInOpenState", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SideBarActionManifest.kt */
    public static final class OnDrawerSlideBegin extends SideBarAction {
        private final boolean isInOpenState;

        public static /* synthetic */ OnDrawerSlideBegin copy$default(OnDrawerSlideBegin onDrawerSlideBegin, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = onDrawerSlideBegin.isInOpenState;
            }
            return onDrawerSlideBegin.copy(z);
        }

        public final boolean component1() {
            return this.isInOpenState;
        }

        public final OnDrawerSlideBegin copy(boolean z) {
            return new OnDrawerSlideBegin(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnDrawerSlideBegin) && this.isInOpenState == ((OnDrawerSlideBegin) obj).isInOpenState;
        }

        public int hashCode() {
            boolean z = this.isInOpenState;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "OnDrawerSlideBegin(isInOpenState=" + this.isInOpenState + ')';
        }

        public OnDrawerSlideBegin(boolean isInOpenState2) {
            super((DefaultConstructorMarker) null);
            this.isInOpenState = isInOpenState2;
        }

        public final boolean isInOpenState() {
            return this.isInOpenState;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnDrawerOpen;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "isAuto", "", "oldStatus", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarDrawerStatus;", "(ZLcom/baidu/searchbox/video/feedflow/sidebar/SideBarDrawerStatus;)V", "()Z", "getOldStatus", "()Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarDrawerStatus;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SideBarActionManifest.kt */
    public static final class OnDrawerOpen extends SideBarAction {
        private final boolean isAuto;
        private final SideBarDrawerStatus oldStatus;

        public static /* synthetic */ OnDrawerOpen copy$default(OnDrawerOpen onDrawerOpen, boolean z, SideBarDrawerStatus sideBarDrawerStatus, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = onDrawerOpen.isAuto;
            }
            if ((i2 & 2) != 0) {
                sideBarDrawerStatus = onDrawerOpen.oldStatus;
            }
            return onDrawerOpen.copy(z, sideBarDrawerStatus);
        }

        public final boolean component1() {
            return this.isAuto;
        }

        public final SideBarDrawerStatus component2() {
            return this.oldStatus;
        }

        public final OnDrawerOpen copy(boolean z, SideBarDrawerStatus sideBarDrawerStatus) {
            Intrinsics.checkNotNullParameter(sideBarDrawerStatus, "oldStatus");
            return new OnDrawerOpen(z, sideBarDrawerStatus);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnDrawerOpen)) {
                return false;
            }
            OnDrawerOpen onDrawerOpen = (OnDrawerOpen) obj;
            return this.isAuto == onDrawerOpen.isAuto && Intrinsics.areEqual((Object) this.oldStatus, (Object) onDrawerOpen.oldStatus);
        }

        public int hashCode() {
            boolean z = this.isAuto;
            if (z) {
                z = true;
            }
            return ((z ? 1 : 0) * true) + this.oldStatus.hashCode();
        }

        public String toString() {
            return "OnDrawerOpen(isAuto=" + this.isAuto + ", oldStatus=" + this.oldStatus + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnDrawerOpen(boolean isAuto2, SideBarDrawerStatus oldStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(oldStatus2, "oldStatus");
            this.isAuto = isAuto2;
            this.oldStatus = oldStatus2;
        }

        public final SideBarDrawerStatus getOldStatus() {
            return this.oldStatus;
        }

        public final boolean isAuto() {
            return this.isAuto;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnLeftDrawerOpen;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "redDotShowing", "", "(Z)V", "getRedDotShowing", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SideBarActionManifest.kt */
    public static final class OnLeftDrawerOpen extends SideBarAction {
        private final boolean redDotShowing;

        public static /* synthetic */ OnLeftDrawerOpen copy$default(OnLeftDrawerOpen onLeftDrawerOpen, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = onLeftDrawerOpen.redDotShowing;
            }
            return onLeftDrawerOpen.copy(z);
        }

        public final boolean component1() {
            return this.redDotShowing;
        }

        public final OnLeftDrawerOpen copy(boolean z) {
            return new OnLeftDrawerOpen(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnLeftDrawerOpen) && this.redDotShowing == ((OnLeftDrawerOpen) obj).redDotShowing;
        }

        public int hashCode() {
            boolean z = this.redDotShowing;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "OnLeftDrawerOpen(redDotShowing=" + this.redDotShowing + ')';
        }

        public OnLeftDrawerOpen(boolean redDotShowing2) {
            super((DefaultConstructorMarker) null);
            this.redDotShowing = redDotShowing2;
        }

        public final boolean getRedDotShowing() {
            return this.redDotShowing;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnDrawerClose;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "isAuto", "", "oldStatus", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarDrawerStatus;", "(ZLcom/baidu/searchbox/video/feedflow/sidebar/SideBarDrawerStatus;)V", "()Z", "getOldStatus", "()Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarDrawerStatus;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SideBarActionManifest.kt */
    public static final class OnDrawerClose extends SideBarAction {
        private final boolean isAuto;
        private final SideBarDrawerStatus oldStatus;

        public static /* synthetic */ OnDrawerClose copy$default(OnDrawerClose onDrawerClose, boolean z, SideBarDrawerStatus sideBarDrawerStatus, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = onDrawerClose.isAuto;
            }
            if ((i2 & 2) != 0) {
                sideBarDrawerStatus = onDrawerClose.oldStatus;
            }
            return onDrawerClose.copy(z, sideBarDrawerStatus);
        }

        public final boolean component1() {
            return this.isAuto;
        }

        public final SideBarDrawerStatus component2() {
            return this.oldStatus;
        }

        public final OnDrawerClose copy(boolean z, SideBarDrawerStatus sideBarDrawerStatus) {
            Intrinsics.checkNotNullParameter(sideBarDrawerStatus, "oldStatus");
            return new OnDrawerClose(z, sideBarDrawerStatus);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnDrawerClose)) {
                return false;
            }
            OnDrawerClose onDrawerClose = (OnDrawerClose) obj;
            return this.isAuto == onDrawerClose.isAuto && Intrinsics.areEqual((Object) this.oldStatus, (Object) onDrawerClose.oldStatus);
        }

        public int hashCode() {
            boolean z = this.isAuto;
            if (z) {
                z = true;
            }
            return ((z ? 1 : 0) * true) + this.oldStatus.hashCode();
        }

        public String toString() {
            return "OnDrawerClose(isAuto=" + this.isAuto + ", oldStatus=" + this.oldStatus + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnDrawerClose(boolean isAuto2, SideBarDrawerStatus oldStatus2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(oldStatus2, "oldStatus");
            this.isAuto = isAuto2;
            this.oldStatus = oldStatus2;
        }

        public final SideBarDrawerStatus getOldStatus() {
            return this.oldStatus;
        }

        public final boolean isAuto() {
            return this.isAuto;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnSideBarEnterClickAction;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SideBarActionManifest.kt */
    public static final class OnSideBarEnterClickAction extends SideBarAction {
        public static final OnSideBarEnterClickAction INSTANCE = new OnSideBarEnterClickAction();

        private OnSideBarEnterClickAction() {
            super((DefaultConstructorMarker) null);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnOuterRedDotNotifyAction;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "id", "", "isShow", "", "value", "(Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()Ljava/lang/String;", "()Z", "getValue", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SideBarActionManifest.kt */
    public static final class OnOuterRedDotNotifyAction extends SideBarAction {
        private final String id;
        private final boolean isShow;
        private final String value;

        public static /* synthetic */ OnOuterRedDotNotifyAction copy$default(OnOuterRedDotNotifyAction onOuterRedDotNotifyAction, String str, boolean z, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = onOuterRedDotNotifyAction.id;
            }
            if ((i2 & 2) != 0) {
                z = onOuterRedDotNotifyAction.isShow;
            }
            if ((i2 & 4) != 0) {
                str2 = onOuterRedDotNotifyAction.value;
            }
            return onOuterRedDotNotifyAction.copy(str, z, str2);
        }

        public final String component1() {
            return this.id;
        }

        public final boolean component2() {
            return this.isShow;
        }

        public final String component3() {
            return this.value;
        }

        public final OnOuterRedDotNotifyAction copy(String str, boolean z, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "value");
            return new OnOuterRedDotNotifyAction(str, z, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof OnOuterRedDotNotifyAction)) {
                return false;
            }
            OnOuterRedDotNotifyAction onOuterRedDotNotifyAction = (OnOuterRedDotNotifyAction) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) onOuterRedDotNotifyAction.id) && this.isShow == onOuterRedDotNotifyAction.isShow && Intrinsics.areEqual((Object) this.value, (Object) onOuterRedDotNotifyAction.value);
        }

        public int hashCode() {
            int hashCode = this.id.hashCode() * 31;
            boolean z = this.isShow;
            if (z) {
                z = true;
            }
            return ((hashCode + (z ? 1 : 0)) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "OnOuterRedDotNotifyAction(id=" + this.id + ", isShow=" + this.isShow + ", value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OnOuterRedDotNotifyAction(String id2, boolean isShow2, String value2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(id2, "id");
            Intrinsics.checkNotNullParameter(value2, "value");
            this.id = id2;
            this.isShow = isShow2;
            this.value = value2;
        }

        public final String getId() {
            return this.id;
        }

        public final String getValue() {
            return this.value;
        }

        public final boolean isShow() {
            return this.isShow;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction$OnViewCoveredState;", "Lcom/baidu/searchbox/video/feedflow/sidebar/SideBarAction;", "status", "", "(I)V", "getStatus", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SideBarActionManifest.kt */
    public static final class OnViewCoveredState extends SideBarAction {
        private final int status;

        public OnViewCoveredState() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ OnViewCoveredState copy$default(OnViewCoveredState onViewCoveredState, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = onViewCoveredState.status;
            }
            return onViewCoveredState.copy(i2);
        }

        public final int component1() {
            return this.status;
        }

        public final OnViewCoveredState copy(int i2) {
            return new OnViewCoveredState(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OnViewCoveredState) && this.status == ((OnViewCoveredState) obj).status;
        }

        public int hashCode() {
            return Integer.hashCode(this.status);
        }

        public String toString() {
            return "OnViewCoveredState(status=" + this.status + ')';
        }

        public OnViewCoveredState(int status2) {
            super((DefaultConstructorMarker) null);
            this.status = status2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ OnViewCoveredState(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i2);
        }

        public final int getStatus() {
            return this.status;
        }
    }
}
