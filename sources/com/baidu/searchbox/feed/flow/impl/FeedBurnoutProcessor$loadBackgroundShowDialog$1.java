package com.baidu.searchbox.feed.flow.impl;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0014J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/feed/flow/impl/FeedBurnoutProcessor$loadBackgroundShowDialog$1", "Lcom/facebook/imagepipeline/datasource/BaseBitmapDataSubscriber;", "onFailureImpl", "", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "onNewResultImpl", "bitmap", "Landroid/graphics/Bitmap;", "lib-feed-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedBurnoutProcessor.kt */
public final class FeedBurnoutProcessor$loadBackgroundShowDialog$1 extends BaseBitmapDataSubscriber {
    final /* synthetic */ FeedBurnoutProcessor this$0;

    FeedBurnoutProcessor$loadBackgroundShowDialog$1(FeedBurnoutProcessor $receiver) {
        this.this$0 = $receiver;
    }

    /* access modifiers changed from: protected */
    public void onNewResultImpl(Bitmap bitmap) {
        this.this$0.showDialog(bitmap);
    }

    /* access modifiers changed from: protected */
    public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
    }
}
