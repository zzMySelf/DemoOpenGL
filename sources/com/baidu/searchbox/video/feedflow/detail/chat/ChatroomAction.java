package com.baidu.searchbox.video.feedflow.detail.chat;

import com.baidu.searchbox.feed.detail.arch.anno.UnicastAction;
import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "CloseChatroom", "Expired", "HidePanel", "ShowPanel", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$Expired;", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$ShowPanel;", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$HidePanel;", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$CloseChatroom;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatroomEntranceActionManifest.kt */
public abstract class ChatroomAction implements Action {
    public /* synthetic */ ChatroomAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ChatroomAction() {
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$Expired;", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChatroomEntranceActionManifest.kt */
    public static final class Expired extends ChatroomAction {
        public static final Expired INSTANCE = new Expired();

        private Expired() {
            super((DefaultConstructorMarker) null);
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$ShowPanel;", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction;", "isFullScreen", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChatroomEntranceActionManifest.kt */
    public static final class ShowPanel extends ChatroomAction {
        private final boolean isFullScreen;

        public static /* synthetic */ ShowPanel copy$default(ShowPanel showPanel, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = showPanel.isFullScreen;
            }
            return showPanel.copy(z);
        }

        public final boolean component1() {
            return this.isFullScreen;
        }

        public final ShowPanel copy(boolean z) {
            return new ShowPanel(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ShowPanel) && this.isFullScreen == ((ShowPanel) obj).isFullScreen;
        }

        public int hashCode() {
            boolean z = this.isFullScreen;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "ShowPanel(isFullScreen=" + this.isFullScreen + ')';
        }

        public ShowPanel(boolean isFullScreen2) {
            super((DefaultConstructorMarker) null);
            this.isFullScreen = isFullScreen2;
        }

        public final boolean isFullScreen() {
            return this.isFullScreen;
        }
    }

    @UnicastAction
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$HidePanel;", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChatroomEntranceActionManifest.kt */
    public static final class HidePanel extends ChatroomAction {
        public static final HidePanel INSTANCE = new HidePanel();

        private HidePanel() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction$CloseChatroom;", "Lcom/baidu/searchbox/video/feedflow/detail/chat/ChatroomAction;", "()V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChatroomEntranceActionManifest.kt */
    public static final class CloseChatroom extends ChatroomAction {
        public static final CloseChatroom INSTANCE = new CloseChatroom();

        private CloseChatroom() {
            super((DefaultConstructorMarker) null);
        }
    }
}
