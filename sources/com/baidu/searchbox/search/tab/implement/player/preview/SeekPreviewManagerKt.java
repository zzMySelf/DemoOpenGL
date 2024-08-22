package com.baidu.searchbox.search.tab.implement.player.preview;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.search.tab.implement.tplmodel.VideoCommonBigImageModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0006H\u0002\u001a\u0014\u0010\t\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"DEBUG", "", "TAG", "", "getImageIndex", "Lkotlin/Pair;", "", "Lcom/baidu/searchbox/search/tab/implement/tplmodel/VideoCommonBigImageModel$FrameSprites;", "index", "getThumbIndex", "pos", "getThumbInfo", "Lcom/baidu/searchbox/search/tab/implement/player/preview/ThumbInfo;", "frameIndex", "search_video_business_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SeekPreviewManager.kt */
public final class SeekPreviewManagerKt {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "PlayerSeekPreviewLayer";

    /* access modifiers changed from: private */
    public static final ThumbInfo getThumbInfo(VideoCommonBigImageModel.FrameSprites $this$getThumbInfo, int frameIndex) {
        Pair<Integer, Integer> imageIndex;
        VideoCommonBigImageModel.FrameSprites frameSprites = $this$getThumbInfo;
        if (!$this$getThumbInfo.isValid() || (imageIndex = getImageIndex($this$getThumbInfo, frameIndex)) == null) {
            return null;
        }
        int imageIndex2 = imageIndex.component1().intValue();
        int thumbOfImage = imageIndex.component2().intValue();
        if (imageIndex2 >= frameSprites.imgUrls.size()) {
            return null;
        }
        int left = frameSprites.thumbWidth * (thumbOfImage % frameSprites.columnSize);
        int top = (thumbOfImage / frameSprites.columnSize) * frameSprites.thumbHeight;
        int right = left + frameSprites.thumbWidth;
        int bottom = top + frameSprites.thumbHeight;
        if (right <= 0 || bottom <= 0) {
            return null;
        }
        String str = frameSprites.imgUrls.get(imageIndex2);
        Intrinsics.checkNotNullExpressionValue(str, "imgUrls[imageIndex]");
        return new ThumbInfo(str, left, top, right, bottom);
    }

    /* access modifiers changed from: private */
    public static final int getThumbIndex(VideoCommonBigImageModel.FrameSprites $this$getThumbIndex, int pos) {
        if ($this$getThumbIndex.interval > 0) {
            return pos / $this$getThumbIndex.interval;
        }
        return -1;
    }

    private static final Pair<Integer, Integer> getImageIndex(VideoCommonBigImageModel.FrameSprites $this$getImageIndex, int index) {
        int size = $this$getImageIndex.rowSize * $this$getImageIndex.columnSize;
        if (size <= 0) {
            return null;
        }
        return new Pair<>(Integer.valueOf(index / size), Integer.valueOf(index % size));
    }
}
