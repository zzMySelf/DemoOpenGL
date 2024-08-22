package com.baidu.searchbox.feed.template.component;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.widget.TextView;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0014J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"com/baidu/searchbox/feed/template/component/FeedTopImagePrefixSpan$requestPrefixImageIfNeed$1", "Lcom/facebook/imagepipeline/datasource/BaseBitmapDataSubscriber;", "onFailureImpl", "", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "onNewResultImpl", "bitmap", "Landroid/graphics/Bitmap;", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedTopImagePrefixSpan.kt */
public final class FeedTopImagePrefixSpan$requestPrefixImageIfNeed$1 extends BaseBitmapDataSubscriber {
    final /* synthetic */ FeedTopImagePrefixSpan this$0;

    FeedTopImagePrefixSpan$requestPrefixImageIfNeed$1(FeedTopImagePrefixSpan $receiver) {
        this.this$0 = $receiver;
    }

    /* access modifiers changed from: protected */
    public void onNewResultImpl(Bitmap bitmap) {
        Bitmap bitmapCopy;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (bitmap.getConfig() == null) {
                bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                Intrinsics.checkNotNullExpressionValue(bitmapCopy, "{\n                      …ue)\n                    }");
            } else {
                bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
                Intrinsics.checkNotNullExpressionValue(bitmapCopy, "{\n                      …ue)\n                    }");
            }
            this.this$0.prefixDrawable = new BitmapDrawable(this.this$0.context.getResources(), bitmapCopy);
            TextView access$getTextView$p = this.this$0.textView;
            if (access$getTextView$p != null) {
                access$getTextView$p.post(new FeedTopImagePrefixSpan$requestPrefixImageIfNeed$1$$ExternalSyntheticLambda0(this.this$0));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onNewResultImpl$lambda-0  reason: not valid java name */
    public static final void m19567onNewResultImpl$lambda0(FeedTopImagePrefixSpan this$02) {
        Intrinsics.checkNotNullParameter(this$02, "this$0");
        SpannableString spanText = new SpannableString(this$02.textView.getText());
        spanText.setSpan(this$02, 0, 6, 17);
        this$02.textView.setText(spanText, TextView.BufferType.NORMAL);
    }

    /* access modifiers changed from: protected */
    public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.this$0.prefixDrawable = null;
    }
}
