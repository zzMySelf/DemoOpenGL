package com.baidu.searchbox.feed.tts.utils;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class TTSFrescoUtils {
    public static void setImageUrl(final ImageView imageView, String imageUrl, final int errorImageRes) {
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageUrl)).build(), AppRuntime.getAppContext()).subscribe(new BaseBitmapDataSubscriber() {
            /* access modifiers changed from: protected */
            public void onNewResultImpl(Bitmap bitmap) {
                Bitmap b2;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        if (bitmap.getConfig() == null) {
                            b2 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                        } else {
                            b2 = bitmap.copy(bitmap.getConfig(), true);
                        }
                        imageView.setImageBitmap(b2);
                    } catch (OutOfMemoryError outOfMemoryError) {
                        if (TTSRuntime.DEBUG) {
                            outOfMemoryError.printStackTrace();
                        }
                        System.gc();
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                imageView.setImageResource(errorImageRes);
            }
        }, UiThreadImmediateExecutorService.getInstance());
    }
}
