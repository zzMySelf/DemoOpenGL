package com.baidu.searchbox.video.feedflow.flow.more;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.NoPostAction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "HideAirPlay", "HideCopyLink", "HideDownload", "HideFavor", "HideFloating", "HideShare", "SwitchClickable", "SwitchEnable", "SwitchEnableNoPost", "UpdateClearScreenData", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$SwitchEnable;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$SwitchClickable;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideShare;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideDownload;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideFavor;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideCopyLink;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$UpdateClearScreenData;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideAirPlay;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideFloating;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MoreFlowActionManifest.kt */
public abstract class MoreFlowAction implements Action {
    public /* synthetic */ MoreFlowAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MoreFlowAction() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$SwitchEnable;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "enable", "", "(Z)V", "getEnable", "()Z", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static class SwitchEnable extends MoreFlowAction {
        private final boolean enable;

        public SwitchEnable(boolean enable2) {
            super((DefaultConstructorMarker) null);
            this.enable = enable2;
        }

        public final boolean getEnable() {
            return this.enable;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$SwitchEnableNoPost;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$SwitchEnable;", "Lcom/baidu/searchbox/feed/detail/frame/NoPostAction;", "enable", "", "(Z)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class SwitchEnableNoPost extends SwitchEnable implements NoPostAction {
        public SwitchEnableNoPost(boolean enable) {
            super(enable);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$SwitchClickable;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "clickable", "", "(Z)V", "getClickable", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class SwitchClickable extends MoreFlowAction {
        private final boolean clickable;

        public static /* synthetic */ SwitchClickable copy$default(SwitchClickable switchClickable, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = switchClickable.clickable;
            }
            return switchClickable.copy(z);
        }

        public final boolean component1() {
            return this.clickable;
        }

        public final SwitchClickable copy(boolean z) {
            return new SwitchClickable(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SwitchClickable) && this.clickable == ((SwitchClickable) obj).clickable;
        }

        public int hashCode() {
            boolean z = this.clickable;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "SwitchClickable(clickable=" + this.clickable + ')';
        }

        public SwitchClickable(boolean clickable2) {
            super((DefaultConstructorMarker) null);
            this.clickable = clickable2;
        }

        public final boolean getClickable() {
            return this.clickable;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideShare;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "hide", "", "(Z)V", "getHide", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class HideShare extends MoreFlowAction {
        private final boolean hide;

        public static /* synthetic */ HideShare copy$default(HideShare hideShare, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = hideShare.hide;
            }
            return hideShare.copy(z);
        }

        public final boolean component1() {
            return this.hide;
        }

        public final HideShare copy(boolean z) {
            return new HideShare(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HideShare) && this.hide == ((HideShare) obj).hide;
        }

        public int hashCode() {
            boolean z = this.hide;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "HideShare(hide=" + this.hide + ')';
        }

        public HideShare(boolean hide2) {
            super((DefaultConstructorMarker) null);
            this.hide = hide2;
        }

        public final boolean getHide() {
            return this.hide;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideDownload;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "hide", "", "(Z)V", "getHide", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class HideDownload extends MoreFlowAction {
        private final boolean hide;

        public static /* synthetic */ HideDownload copy$default(HideDownload hideDownload, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = hideDownload.hide;
            }
            return hideDownload.copy(z);
        }

        public final boolean component1() {
            return this.hide;
        }

        public final HideDownload copy(boolean z) {
            return new HideDownload(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HideDownload) && this.hide == ((HideDownload) obj).hide;
        }

        public int hashCode() {
            boolean z = this.hide;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "HideDownload(hide=" + this.hide + ')';
        }

        public HideDownload(boolean hide2) {
            super((DefaultConstructorMarker) null);
            this.hide = hide2;
        }

        public final boolean getHide() {
            return this.hide;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideFavor;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "hide", "", "(Z)V", "getHide", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class HideFavor extends MoreFlowAction {
        private final boolean hide;

        public static /* synthetic */ HideFavor copy$default(HideFavor hideFavor, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = hideFavor.hide;
            }
            return hideFavor.copy(z);
        }

        public final boolean component1() {
            return this.hide;
        }

        public final HideFavor copy(boolean z) {
            return new HideFavor(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HideFavor) && this.hide == ((HideFavor) obj).hide;
        }

        public int hashCode() {
            boolean z = this.hide;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "HideFavor(hide=" + this.hide + ')';
        }

        public HideFavor(boolean hide2) {
            super((DefaultConstructorMarker) null);
            this.hide = hide2;
        }

        public final boolean getHide() {
            return this.hide;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideCopyLink;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "hide", "", "(Z)V", "getHide", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class HideCopyLink extends MoreFlowAction {
        private final boolean hide;

        public static /* synthetic */ HideCopyLink copy$default(HideCopyLink hideCopyLink, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = hideCopyLink.hide;
            }
            return hideCopyLink.copy(z);
        }

        public final boolean component1() {
            return this.hide;
        }

        public final HideCopyLink copy(boolean z) {
            return new HideCopyLink(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HideCopyLink) && this.hide == ((HideCopyLink) obj).hide;
        }

        public int hashCode() {
            boolean z = this.hide;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "HideCopyLink(hide=" + this.hide + ')';
        }

        public HideCopyLink(boolean hide2) {
            super((DefaultConstructorMarker) null);
            this.hide = hide2;
        }

        public final boolean getHide() {
            return this.hide;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$UpdateClearScreenData;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "isInClearScreen", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class UpdateClearScreenData extends MoreFlowAction {
        private final boolean isInClearScreen;

        public static /* synthetic */ UpdateClearScreenData copy$default(UpdateClearScreenData updateClearScreenData, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = updateClearScreenData.isInClearScreen;
            }
            return updateClearScreenData.copy(z);
        }

        public final boolean component1() {
            return this.isInClearScreen;
        }

        public final UpdateClearScreenData copy(boolean z) {
            return new UpdateClearScreenData(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateClearScreenData) && this.isInClearScreen == ((UpdateClearScreenData) obj).isInClearScreen;
        }

        public int hashCode() {
            boolean z = this.isInClearScreen;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "UpdateClearScreenData(isInClearScreen=" + this.isInClearScreen + ')';
        }

        public UpdateClearScreenData(boolean isInClearScreen2) {
            super((DefaultConstructorMarker) null);
            this.isInClearScreen = isInClearScreen2;
        }

        public final boolean isInClearScreen() {
            return this.isInClearScreen;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideAirPlay;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "hide", "", "(Z)V", "getHide", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class HideAirPlay extends MoreFlowAction {
        private final boolean hide;

        public static /* synthetic */ HideAirPlay copy$default(HideAirPlay hideAirPlay, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = hideAirPlay.hide;
            }
            return hideAirPlay.copy(z);
        }

        public final boolean component1() {
            return this.hide;
        }

        public final HideAirPlay copy(boolean z) {
            return new HideAirPlay(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HideAirPlay) && this.hide == ((HideAirPlay) obj).hide;
        }

        public int hashCode() {
            boolean z = this.hide;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "HideAirPlay(hide=" + this.hide + ')';
        }

        public HideAirPlay(boolean hide2) {
            super((DefaultConstructorMarker) null);
            this.hide = hide2;
        }

        public final boolean getHide() {
            return this.hide;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction$HideFloating;", "Lcom/baidu/searchbox/video/feedflow/flow/more/MoreFlowAction;", "hide", "", "(Z)V", "getHide", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MoreFlowActionManifest.kt */
    public static final class HideFloating extends MoreFlowAction {
        private final boolean hide;

        public static /* synthetic */ HideFloating copy$default(HideFloating hideFloating, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = hideFloating.hide;
            }
            return hideFloating.copy(z);
        }

        public final boolean component1() {
            return this.hide;
        }

        public final HideFloating copy(boolean z) {
            return new HideFloating(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HideFloating) && this.hide == ((HideFloating) obj).hide;
        }

        public int hashCode() {
            boolean z = this.hide;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "HideFloating(hide=" + this.hide + ')';
        }

        public HideFloating(boolean hide2) {
            super((DefaultConstructorMarker) null);
            this.hide = hide2;
        }

        public final boolean getHide() {
            return this.hide;
        }
    }
}
