package com.baidu.searchbox.feed.biserialdetail.content.imgviewer;

import com.baidu.searchbox.feed.biserialdetail.content.DynamicLinkageContent;
import com.baidu.searchbox.feed.biserialdetail.content.banner.BannerPageAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/feed/biserialdetail/content/imgviewer/ImgViewer$updateFeedDataPrefetch$2", "Lcom/baidu/searchbox/feed/biserialdetail/content/banner/BannerPageAdapter$ImageLoadStateListener;", "onImageLoadState", "", "position", "", "isSuccess", "", "lib-feed-biserial-detail_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImgViewer.kt */
public final class ImgViewer$updateFeedDataPrefetch$2 implements BannerPageAdapter.ImageLoadStateListener {
    final /* synthetic */ int $currentIndex;
    final /* synthetic */ ImgViewer this$0;

    ImgViewer$updateFeedDataPrefetch$2(int $currentIndex2, ImgViewer $receiver) {
        this.$currentIndex = $currentIndex2;
        this.this$0 = $receiver;
    }

    public void onImageLoadState(int position, boolean isSuccess) {
        if (position == this.$currentIndex) {
            DynamicLinkageContent.IDynamicContentListener access$getDynamicContentListener$p = this.this$0.dynamicContentListener;
            if (access$getDynamicContentListener$p != null) {
                access$getDynamicContentListener$p.afterDrawPrefetchImage(isSuccess);
            }
            BannerPageAdapter access$getPagerAdapter$p = this.this$0.pagerAdapter;
            if (access$getPagerAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
                access$getPagerAdapter$p = null;
            }
            access$getPagerAdapter$p.imageLoadStateListener = null;
        }
    }
}
