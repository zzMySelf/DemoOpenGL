package com.baidu.searchbox.video.detail.business;

import com.baidu.searchbox.video.detail.business.VideoBusiness;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/video/detail/business/VideoBusinessCanDebug;", "Lcom/baidu/searchbox/video/detail/business/VideoBusiness;", "debugName", "", "lib-support_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoBusiness.kt */
public interface VideoBusinessCanDebug extends VideoBusiness {
    String debugName();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoBusiness.kt */
    public static final class DefaultImpls {
        public static String scene(VideoBusinessCanDebug videoBusinessCanDebug) {
            return VideoBusiness.DefaultImpls.scene(videoBusinessCanDebug);
        }

        public static String secondJumpSource(VideoBusinessCanDebug videoBusinessCanDebug) {
            return VideoBusiness.DefaultImpls.secondJumpSource(videoBusinessCanDebug);
        }

        public static void setScene(VideoBusinessCanDebug videoBusinessCanDebug, String scene) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            VideoBusiness.DefaultImpls.setScene(videoBusinessCanDebug, scene);
        }

        public static void setSecondJumpSource(VideoBusinessCanDebug videoBusinessCanDebug, String secondJumpSource) {
            Intrinsics.checkNotNullParameter(secondJumpSource, "secondJumpSource");
            VideoBusiness.DefaultImpls.setSecondJumpSource(videoBusinessCanDebug, secondJumpSource);
        }

        public static String debugName(VideoBusinessCanDebug videoBusinessCanDebug) {
            return "";
        }
    }
}
