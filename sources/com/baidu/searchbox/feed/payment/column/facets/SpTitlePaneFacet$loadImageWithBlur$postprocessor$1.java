package com.baidu.searchbox.feed.payment.column.facets;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.searchbox.bdmediacore.utils.FastBlur;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.BasePostprocessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/baidu/searchbox/feed/payment/column/facets/SpTitlePaneFacet$loadImageWithBlur$postprocessor$1", "Lcom/facebook/imagepipeline/request/BasePostprocessor;", "getName", "", "getPostprocessorCacheKey", "Lcom/facebook/cache/common/CacheKey;", "process", "", "bitmap", "Landroid/graphics/Bitmap;", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpTitlePaneFacet.kt */
public final class SpTitlePaneFacet$loadImageWithBlur$postprocessor$1 extends BasePostprocessor {
    final /* synthetic */ Uri $uri;

    SpTitlePaneFacet$loadImageWithBlur$postprocessor$1(Uri $uri2) {
        this.$uri = $uri2;
    }

    public String getName() {
        return "BlurPostProcessor";
    }

    public void process(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        FastBlur.doBlur(bitmap, 100, true);
    }

    public CacheKey getPostprocessorCacheKey() {
        return new SimpleCacheKey(this.$uri.toString());
    }
}
