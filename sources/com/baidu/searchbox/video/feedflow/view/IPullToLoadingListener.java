package com.baidu.searchbox.video.feedflow.view;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/view/IPullToLoadingListener;", "", "getSimilarCollectionSwitch", "", "hasMore", "hasPrev", "insertSimilarCollectionData", "", "isLoadingOrNetError", "isNeedLimitTip", "isNeedLoadPrev", "isShortPlay", "isSupportSimilarCollection", "onDragRelease", "onLoadingStarted", "up", "onNextSimilarCollectionGuideShow", "onTargetViewTranslationYUpdate", "translationY", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowGestureContainer.kt */
public interface IPullToLoadingListener {
    boolean getSimilarCollectionSwitch();

    boolean hasMore();

    boolean hasPrev();

    void insertSimilarCollectionData();

    boolean isLoadingOrNetError();

    boolean isNeedLimitTip();

    boolean isNeedLoadPrev();

    boolean isShortPlay();

    boolean isSupportSimilarCollection();

    void onDragRelease();

    void onLoadingStarted(boolean z);

    void onNextSimilarCollectionGuideShow();

    void onTargetViewTranslationYUpdate(float f2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoFlowGestureContainer.kt */
    public static final class DefaultImpls {
        public static void onLoadingStarted(IPullToLoadingListener iPullToLoadingListener, boolean up) {
        }

        public static void onTargetViewTranslationYUpdate(IPullToLoadingListener iPullToLoadingListener, float translationY) {
        }

        public static void onDragRelease(IPullToLoadingListener iPullToLoadingListener) {
        }

        public static void onNextSimilarCollectionGuideShow(IPullToLoadingListener iPullToLoadingListener) {
        }

        public static void insertSimilarCollectionData(IPullToLoadingListener iPullToLoadingListener) {
        }
    }
}
