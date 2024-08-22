package com.baidu.searchbox.video.feedflow.ad.author;

import com.baidu.searchbox.feed.detail.frame.Action;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "AvatarBtnAbsorbColor", "LandscapeTopAuthorClickAction", "ResetAvatarBtnColor", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadTopAuthorActionManifest.kt */
public class NadTopAuthorAction implements Action {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorAction$LandscapeTopAuthorClickAction;", "Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorAction;", "()V", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadTopAuthorActionManifest.kt */
    public static final class LandscapeTopAuthorClickAction extends NadTopAuthorAction {
        public static final LandscapeTopAuthorClickAction INSTANCE = new LandscapeTopAuthorClickAction();

        private LandscapeTopAuthorClickAction() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorAction$AvatarBtnAbsorbColor;", "Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorAction;", "duration", "", "(Ljava/lang/Long;)V", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadTopAuthorActionManifest.kt */
    public static final class AvatarBtnAbsorbColor extends NadTopAuthorAction {
        private final Long duration;

        public AvatarBtnAbsorbColor(Long duration2) {
            this.duration = duration2;
        }

        public final Long getDuration() {
            return this.duration;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorAction$ResetAvatarBtnColor;", "Lcom/baidu/searchbox/video/feedflow/ad/author/NadTopAuthorAction;", "()V", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadTopAuthorActionManifest.kt */
    public static final class ResetAvatarBtnColor extends NadTopAuthorAction {
        public static final ResetAvatarBtnColor INSTANCE = new ResetAvatarBtnColor();

        private ResetAvatarBtnColor() {
        }
    }
}
