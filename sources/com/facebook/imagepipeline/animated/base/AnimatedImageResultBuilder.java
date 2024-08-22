package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.transformation.BitmapTransformation;
import java.util.List;
import javax.annotation.Nullable;

public class AnimatedImageResultBuilder {
    @Nullable
    private BitmapTransformation mBitmapTransformation;
    @Nullable
    private List<CloseableReference<Bitmap>> mDecodedFrames;
    private int mFrameForPreview;
    private final AnimatedImage mImage;
    @Nullable
    private CloseableReference<Bitmap> mPreviewBitmap;
    @Nullable
    private String mSource;

    AnimatedImageResultBuilder(AnimatedImage image) {
        this.mImage = image;
    }

    public AnimatedImage getImage() {
        return this.mImage;
    }

    @Nullable
    public CloseableReference<Bitmap> getPreviewBitmap() {
        return CloseableReference.cloneOrNull(this.mPreviewBitmap);
    }

    public AnimatedImageResultBuilder setPreviewBitmap(@Nullable CloseableReference<Bitmap> previewBitmap) {
        this.mPreviewBitmap = CloseableReference.cloneOrNull(previewBitmap);
        return this;
    }

    public int getFrameForPreview() {
        return this.mFrameForPreview;
    }

    public AnimatedImageResultBuilder setFrameForPreview(int frameForPreview) {
        this.mFrameForPreview = frameForPreview;
        return this;
    }

    @Nullable
    public List<CloseableReference<Bitmap>> getDecodedFrames() {
        return CloseableReference.cloneOrNull(this.mDecodedFrames);
    }

    @Nullable
    public String getSource() {
        return this.mSource;
    }

    public AnimatedImageResultBuilder setDecodedFrames(@Nullable List<CloseableReference<Bitmap>> decodedFrames) {
        this.mDecodedFrames = CloseableReference.cloneOrNull(decodedFrames);
        return this;
    }

    @Nullable
    public BitmapTransformation getBitmapTransformation() {
        return this.mBitmapTransformation;
    }

    public AnimatedImageResultBuilder setBitmapTransformation(@Nullable BitmapTransformation bitmapTransformation) {
        this.mBitmapTransformation = bitmapTransformation;
        return this;
    }

    public AnimatedImageResultBuilder setSource(@Nullable String source) {
        this.mSource = source;
        return this;
    }

    public AnimatedImageResult build() {
        try {
            return new AnimatedImageResult(this);
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) this.mPreviewBitmap);
            this.mPreviewBitmap = null;
            CloseableReference.closeSafely((Iterable<? extends CloseableReference<?>>) this.mDecodedFrames);
            this.mDecodedFrames = null;
        }
    }
}
