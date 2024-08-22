package com.baidu.searchbox.video.feedflow.detail.pagesharing;

import android.graphics.Rect;
import com.baidu.searchbox.player.BaseVideoPlayer;
import com.baidu.searchbox.video.feedflow.detail.player.player.VideoFlowPlayer;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\b\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u001a9\u0010\u000b\u001a\u00020\u0007*\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000fH\u0002\u001a\f\u0010\u0014\u001a\u00020\u0010*\u00020\nH\u0002\u001a\f\u0010\u0015\u001a\u00020\u0010*\u00020\nH\u0002\u001a\f\u0010\u0016\u001a\u00020\u0010*\u00020\nH\u0002\u001a\f\u0010\u0017\u001a\u00020\u0003*\u00020\nH\u0002\u001a\"\u0010\u0018\u001a\u00020\u0007*\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002\u001a\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d*\u0004\u0018\u00010\nH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"HANDLE_MSG_WHAT_COUNT_DOWN", "", "TAG", "", "getAnimStyleByDiscover", "getAnimStyleByFeed", "bindData", "", "Lcom/baidu/searchbox/video/feedflow/detail/pagesharing/CrossPageTransitionCoverView;", "model", "Lcom/baidu/searchbox/video/feedflow/detail/pagesharing/FeedItemClickModel;", "bindListener", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/VideoFlowPlayer;", "itemModel", "firstFrame", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "canNotUseAnim", "canUseSlideAnim", "canUseZoomAnim", "getAnimStyle", "setData", "Lcom/baidu/searchbox/player/BaseVideoPlayer;", "posterLocation", "Landroid/graphics/Rect;", "toTransModel", "Lcom/baidu/searchbox/video/feedflow/detail/pagesharing/CrossPageTransitionModel;", "lib-flow-component_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoPreViewContainer.kt */
public final class VideoPreViewContainerKt {
    private static final int HANDLE_MSG_WHAT_COUNT_DOWN = 1000;
    private static final String TAG = "VideoPreViewContainer";

    /* access modifiers changed from: private */
    public static final void bindListener(VideoFlowPlayer $this$bindListener, FeedItemClickModel itemModel, Function1<? super Boolean, Unit> firstFrame) {
        if ($this$bindListener != null) {
            if (!DIFactory.INSTANCE.getConfig().getPreViewSwitchConfig(VideoPreViewDataManagerKt.getSwitchScene(itemModel)).isAvoidFirstFrame()) {
                firstFrame.invoke(false);
            } else {
                $this$bindListener.setPlayerListener(new VideoPreViewContainerKt$bindListener$1(firstFrame));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final boolean canUseSlideAnim(FeedItemClickModel $this$canUseSlideAnim) {
        return Intrinsics.areEqual((Object) getAnimStyle($this$canUseSlideAnim), (Object) "2");
    }

    /* access modifiers changed from: private */
    public static final boolean canNotUseAnim(FeedItemClickModel $this$canNotUseAnim) {
        return Intrinsics.areEqual((Object) getAnimStyle($this$canNotUseAnim), (Object) "3");
    }

    /* access modifiers changed from: private */
    public static final boolean canUseZoomAnim(FeedItemClickModel $this$canUseZoomAnim) {
        return Intrinsics.areEqual((Object) getAnimStyle($this$canUseZoomAnim), (Object) "1");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.lang.String getAnimStyle(com.baidu.searchbox.video.feedflow.detail.pagesharing.FeedItemClickModel r3) {
        /*
            boolean r0 = r3.isFromDiscover()
            java.lang.String r1 = "1"
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = getAnimStyleByDiscover()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r2 = kotlin.text.StringsKt.isBlank(r0)
            if (r2 == 0) goto L_0x0017
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r1 = r0
        L_0x0018:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        L_0x001b:
            boolean r0 = r3.isFromFeed()
            java.lang.String r2 = "2"
            if (r0 == 0) goto L_0x004f
            boolean r0 = r3.isMiniVideo()
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = getAnimStyleByDiscover()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r2 = kotlin.text.StringsKt.isBlank(r0)
            if (r2 == 0) goto L_0x0038
            r0 = 0
            goto L_0x0039
        L_0x0038:
            r1 = r0
        L_0x0039:
            java.lang.String r1 = (java.lang.String) r1
            return r1
        L_0x003c:
            java.lang.String r0 = getAnimStyleByFeed()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r1 = kotlin.text.StringsKt.isBlank(r0)
            if (r1 == 0) goto L_0x004b
            r0 = 0
            goto L_0x004c
        L_0x004b:
            r2 = r0
        L_0x004c:
            java.lang.String r2 = (java.lang.String) r2
            return r2
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.pagesharing.VideoPreViewContainerKt.getAnimStyle(com.baidu.searchbox.video.feedflow.detail.pagesharing.FeedItemClickModel):java.lang.String");
    }

    private static final String getAnimStyleByFeed() {
        return DIFactory.INSTANCE.getConfig().getPreViewSwitchConfig("feed").getAnimStyleByFeed();
    }

    private static final String getAnimStyleByDiscover() {
        return DIFactory.INSTANCE.getConfig().getPreViewSwitchConfig("discover").getAnimStyleByDiscover();
    }

    /* access modifiers changed from: private */
    public static final void setData(BaseVideoPlayer $this$setData, Rect posterLocation, FeedItemClickModel model) {
        if ($this$setData != null && model != null && model.getVideoSeries() != null && posterLocation != null) {
            $this$setData.setVideoSeries(model.getVideoSeries());
        }
    }

    private static final CrossPageTransitionModel toTransModel(FeedItemClickModel $this$toTransModel) {
        if ($this$toTransModel == null) {
            return null;
        }
        if ((!StringsKt.isBlank($this$toTransModel.getAuthorImage())) || (!StringsKt.isBlank($this$toTransModel.getAuthorName()))) {
            return new CrossPageTransitionModel($this$toTransModel.getAuthorImage(), $this$toTransModel.getAuthorName(), $this$toTransModel.getVideoTitle(), $this$toTransModel.getFrom(), $this$toTransModel.getPage(), $this$toTransModel.getPd(), VideoPreViewDataManagerKt.getSwitchScene($this$toTransModel));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void bindData(CrossPageTransitionCoverView $this$bindData, FeedItemClickModel model) {
        if ($this$bindData != null) {
            $this$bindData.bindData(toTransModel(model));
        }
    }
}
