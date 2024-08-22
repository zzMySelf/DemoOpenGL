package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public class ImageRequestBuilder {
    private static final Set<String> CUSTOM_NETWORK_SCHEMES = new HashSet();
    @Nullable
    private BytesRange mBytesRange = null;
    private ImageRequest.CacheChoice mCacheChoice = ImageRequest.CacheChoice.DEFAULT;
    private int mCachesDisabled = 0;
    @Nullable
    private Boolean mDecodePrefetches = null;
    private int mDelayMs;
    private ImageDecodeOptions mImageDecodeOptions = ImageDecodeOptions.defaults();
    private boolean mLoadThumbnailOnly = false;
    private boolean mLocalThumbnailPreviewsEnabled = false;
    private String mLogTag = null;
    private ImageRequest.RequestLevel mLowestPermittedRequestLevel = ImageRequest.RequestLevel.FULL_FETCH;
    private Map<String, String> mNetRequestHeader = null;
    @Nullable
    private Postprocessor mPostprocessor = null;
    private boolean mProgressiveRenderingEnabled = ImagePipelineConfig.getDefaultImageRequestConfig().isProgressiveRenderingEnabled();
    @Nullable
    private RequestListener mRequestListener;
    private Priority mRequestPriority = Priority.HIGH;
    @Nullable
    private ResizeOptions mResizeOptions = null;
    @Nullable
    private Boolean mResizingAllowedOverride = null;
    @Nullable
    private RotationOptions mRotationOptions = null;
    private Uri mSourceUri = null;
    private String mTag = null;

    public static ImageRequestBuilder newBuilderWithSource(Uri uri) {
        return new ImageRequestBuilder().setSource(uri);
    }

    public static ImageRequestBuilder newBuilderWithResourceId(int resId) {
        return newBuilderWithSource(UriUtil.getUriForResourceId(resId));
    }

    public static ImageRequestBuilder fromRequest(ImageRequest imageRequest) {
        return newBuilderWithSource(imageRequest.getSourceUri()).setImageDecodeOptions(imageRequest.getImageDecodeOptions()).setBytesRange(imageRequest.getBytesRange()).setCacheChoice(imageRequest.getCacheChoice()).setLocalThumbnailPreviewsEnabled(imageRequest.getLocalThumbnailPreviewsEnabled()).setLoadThumbnailOnly(imageRequest.getLoadThumbnailOnlyForAndroidSdkAboveQ()).setLowestPermittedRequestLevel(imageRequest.getLowestPermittedRequestLevel()).setCachesDisabled(imageRequest.getCachesDisabled()).setPostprocessor(imageRequest.getPostprocessor()).setProgressiveRenderingEnabled(imageRequest.getProgressiveRenderingEnabled()).setRequestPriority(imageRequest.getPriority()).setResizeOptions(imageRequest.getResizeOptions()).setRequestListener(imageRequest.getRequestListener()).setRotationOptions(imageRequest.getRotationOptions()).setShouldDecodePrefetches(imageRequest.shouldDecodePrefetches()).setDelayMs(imageRequest.getDelayMs()).setNetRequestHeader(imageRequest.getNetRequestHeader()).setTag(imageRequest.mTag).setLogTag(imageRequest.mLogTag);
    }

    public Map<String, String> getNetRequestHeader() {
        return this.mNetRequestHeader;
    }

    public ImageRequestBuilder setNetRequestHeader(Map<String, String> header) {
        this.mNetRequestHeader = header;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder setTag(String tag) {
        this.mTag = tag;
        return this;
    }

    public String getLogTag() {
        return this.mLogTag;
    }

    public ImageRequestBuilder setLogTag(String logTag) {
        this.mLogTag = logTag;
        return this;
    }

    public static void addCustomUriNetworkScheme(String scheme) {
        CUSTOM_NETWORK_SCHEMES.add(scheme);
    }

    private ImageRequestBuilder() {
    }

    public ImageRequestBuilder setSource(Uri uri) {
        Preconditions.checkNotNull(uri);
        this.mSourceUri = uri;
        return this;
    }

    public Uri getSourceUri() {
        return this.mSourceUri;
    }

    public ImageRequestBuilder setLowestPermittedRequestLevel(ImageRequest.RequestLevel requestLevel) {
        this.mLowestPermittedRequestLevel = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel getLowestPermittedRequestLevel() {
        return this.mLowestPermittedRequestLevel;
    }

    private ImageRequestBuilder setCachesDisabled(int cachesDisabled) {
        this.mCachesDisabled = cachesDisabled;
        return this;
    }

    public int getCachesDisabled() {
        return this.mCachesDisabled;
    }

    @Deprecated
    public ImageRequestBuilder setAutoRotateEnabled(boolean enabled) {
        if (enabled) {
            return setRotationOptions(RotationOptions.autoRotate());
        }
        return setRotationOptions(RotationOptions.disableRotation());
    }

    public ImageRequestBuilder setResizeOptions(@Nullable ResizeOptions resizeOptions) {
        this.mResizeOptions = resizeOptions;
        return this;
    }

    @Nullable
    public ResizeOptions getResizeOptions() {
        return this.mResizeOptions;
    }

    public ImageRequestBuilder setRotationOptions(@Nullable RotationOptions rotationOptions) {
        this.mRotationOptions = rotationOptions;
        return this;
    }

    @Nullable
    public RotationOptions getRotationOptions() {
        return this.mRotationOptions;
    }

    public ImageRequestBuilder setBytesRange(@Nullable BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
        return this;
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public ImageRequestBuilder setImageDecodeOptions(ImageDecodeOptions imageDecodeOptions) {
        this.mImageDecodeOptions = imageDecodeOptions;
        return this;
    }

    public ImageDecodeOptions getImageDecodeOptions() {
        return this.mImageDecodeOptions;
    }

    public ImageRequestBuilder setCacheChoice(ImageRequest.CacheChoice cacheChoice) {
        this.mCacheChoice = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice getCacheChoice() {
        return this.mCacheChoice;
    }

    public ImageRequestBuilder setProgressiveRenderingEnabled(boolean enabled) {
        this.mProgressiveRenderingEnabled = enabled;
        return this;
    }

    public boolean isProgressiveRenderingEnabled() {
        return this.mProgressiveRenderingEnabled;
    }

    public ImageRequestBuilder setLocalThumbnailPreviewsEnabled(boolean enabled) {
        this.mLocalThumbnailPreviewsEnabled = enabled;
        return this;
    }

    public boolean isLocalThumbnailPreviewsEnabled() {
        return this.mLocalThumbnailPreviewsEnabled;
    }

    public ImageRequestBuilder setLoadThumbnailOnly(boolean loadThumbnailOnly) {
        this.mLoadThumbnailOnly = loadThumbnailOnly;
        return this;
    }

    public boolean getLoadThumbnailOnly() {
        return this.mLoadThumbnailOnly;
    }

    public ImageRequestBuilder disableDiskCache() {
        this.mCachesDisabled |= 48;
        return this;
    }

    private boolean isCustomNetworkUri(@Nullable Uri uri) {
        Set<String> set = CUSTOM_NETWORK_SCHEMES;
        if (set == null || uri == null) {
            return false;
        }
        for (String scheme : set) {
            if (scheme.equals(uri.getScheme())) {
                return true;
            }
        }
        return false;
    }

    public boolean isDiskCacheEnabled() {
        return (this.mCachesDisabled & 48) == 0 && (UriUtil.isNetworkUri(this.mSourceUri) || isCustomNetworkUri(this.mSourceUri));
    }

    public ImageRequestBuilder disableMemoryCache() {
        this.mCachesDisabled |= 15;
        return this;
    }

    public boolean isMemoryCacheEnabled() {
        return (this.mCachesDisabled & 15) == 0;
    }

    public ImageRequestBuilder setRequestPriority(Priority requestPriority) {
        this.mRequestPriority = requestPriority;
        return this;
    }

    public Priority getRequestPriority() {
        return this.mRequestPriority;
    }

    public ImageRequestBuilder setPostprocessor(@Nullable Postprocessor postprocessor) {
        this.mPostprocessor = postprocessor;
        return this;
    }

    @Nullable
    public Postprocessor getPostprocessor() {
        return this.mPostprocessor;
    }

    public ImageRequestBuilder setRequestListener(@Nullable RequestListener requestListener) {
        this.mRequestListener = requestListener;
        return this;
    }

    @Nullable
    public RequestListener getRequestListener() {
        return this.mRequestListener;
    }

    public ImageRequest build() {
        validate();
        return new ImageRequest(this);
    }

    @Nullable
    public Boolean shouldDecodePrefetches() {
        return this.mDecodePrefetches;
    }

    public ImageRequestBuilder setShouldDecodePrefetches(@Nullable Boolean shouldDecodePrefetches) {
        this.mDecodePrefetches = shouldDecodePrefetches;
        return this;
    }

    public ImageRequestBuilder setResizingAllowedOverride(@Nullable Boolean resizingAllowedOverride) {
        this.mResizingAllowedOverride = resizingAllowedOverride;
        return this;
    }

    @Nullable
    public Boolean getResizingAllowedOverride() {
        return this.mResizingAllowedOverride;
    }

    public int getDelayMs() {
        return this.mDelayMs;
    }

    public ImageRequestBuilder setDelayMs(int delayMs) {
        this.mDelayMs = delayMs;
        return this;
    }

    public static class BuilderException extends RuntimeException {
        public BuilderException(String message) {
            super("Invalid request builder: " + message);
        }
    }

    /* access modifiers changed from: protected */
    public void validate() {
        Uri uri = this.mSourceUri;
        if (uri != null) {
            if (UriUtil.isLocalResourceUri(uri)) {
                if (!this.mSourceUri.isAbsolute()) {
                    throw new BuilderException("Resource URI path must be absolute.");
                } else if (!this.mSourceUri.getPath().isEmpty()) {
                    try {
                        Integer.parseInt(this.mSourceUri.getPath().substring(1));
                    } catch (NumberFormatException e2) {
                        throw new BuilderException("Resource URI path must be a resource id.");
                    }
                } else {
                    throw new BuilderException("Resource URI must not be empty");
                }
            }
            if (UriUtil.isLocalAssetUri(this.mSourceUri) && !this.mSourceUri.isAbsolute()) {
                throw new BuilderException("Asset URI path must be absolute.");
            }
            return;
        }
        throw new BuilderException("Source must be set!");
    }
}
