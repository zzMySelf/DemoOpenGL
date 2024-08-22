package com.baidu.searchbox.comment.view.commentshare;

import android.graphics.Bitmap;
import com.baidu.searchbox.comment.view.commentshare.CommentSharePosterView;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005H\u0016J\u001e\u0010\b\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, d2 = {"com/baidu/searchbox/comment/view/commentshare/CommentSharePosterView$downloadBitmap$1", "Lcom/facebook/imagepipeline/datasource/BaseBitmapDataSubscriber;", "onCancellation", "", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "onFailureImpl", "onNewResultImpl", "bitmap", "Landroid/graphics/Bitmap;", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentSharePosterView.kt */
public final class CommentSharePosterView$downloadBitmap$1 extends BaseBitmapDataSubscriber {
    final /* synthetic */ CommentSharePosterView.DownloadCallback $callback;

    CommentSharePosterView$downloadBitmap$1(CommentSharePosterView.DownloadCallback $callback2) {
        this.$callback = $callback2;
    }

    /* access modifiers changed from: protected */
    public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        CommentSharePosterView.DownloadCallback downloadCallback = this.$callback;
        if (downloadCallback != null) {
            downloadCallback.onCallback((Bitmap) null);
        }
    }

    public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        CommentSharePosterView.DownloadCallback downloadCallback = this.$callback;
        if (downloadCallback != null) {
            downloadCallback.onCallback((Bitmap) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewResultImpl(Bitmap bitmap) {
        Bitmap bmp;
        if (bitmap == null || bitmap.isRecycled()) {
            CommentSharePosterView.DownloadCallback downloadCallback = this.$callback;
            if (downloadCallback != null) {
                downloadCallback.onCallback((Bitmap) null);
                return;
            }
            return;
        }
        if (bitmap.getConfig() == null) {
            bmp = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        } else {
            bmp = bitmap.copy(bitmap.getConfig(), true);
        }
        CommentSharePosterView.DownloadCallback downloadCallback2 = this.$callback;
        if (downloadCallback2 != null) {
            downloadCallback2.onCallback(bmp);
        }
    }
}
