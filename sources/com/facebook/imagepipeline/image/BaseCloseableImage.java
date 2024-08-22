package com.facebook.imagepipeline.image;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class BaseCloseableImage implements CloseableImage {
    private static final Set<String> mImageExtrasList = new HashSet(Arrays.asList(new String[]{"encoded_size", "encoded_width", "encoded_height", "uri_source", "image_format", "bitmap_config", "is_rounded", "non_fatal_decode_error", "modified_url", "image_color_space"}));
    @Nullable
    private ImageInfo mCacheImageInfo;
    private Map<String, Object> mExtras = new HashMap();

    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    public boolean isStateful() {
        return false;
    }

    public Map<String, Object> getExtras() {
        return this.mExtras;
    }

    public void putExtras(@Nullable Map<String, ?> extras) {
        if (extras != null) {
            for (String extra : mImageExtrasList) {
                Object val = extras.get(extra);
                if (val != null) {
                    this.mExtras.put(extra, val);
                }
            }
        }
    }

    public <E> void putExtra(String extra, @Nullable E value) {
        if (mImageExtrasList.contains(extra)) {
            this.mExtras.put(extra, value);
        }
    }

    public <T> T getExtra(String key) {
        return getExtra(key, (Object) null);
    }

    public <T> T getExtra(String key, @Nullable T valueIfNotFound) {
        Object value = this.mExtras.get(key);
        if (value == null) {
            return valueIfNotFound;
        }
        return value;
    }

    public ImageInfo getImageInfo() {
        if (this.mCacheImageInfo == null) {
            this.mCacheImageInfo = new ImageInfoImpl(getWidth(), getHeight(), getSizeInBytes(), getQualityInfo(), getExtras());
        }
        return this.mCacheImageInfo;
    }
}
