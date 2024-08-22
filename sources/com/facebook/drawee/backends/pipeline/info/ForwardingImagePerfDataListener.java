package com.facebook.drawee.backends.pipeline.info;

import com.facebook.fresco.ui.common.ImageLoadStatus;
import com.facebook.fresco.ui.common.ImagePerfData;
import com.facebook.fresco.ui.common.ImagePerfDataListener;
import com.facebook.fresco.ui.common.VisibilityState;
import java.util.Collection;

public class ForwardingImagePerfDataListener implements ImagePerfDataListener {
    private final Collection<ImagePerfDataListener> mListeners;

    public ForwardingImagePerfDataListener(Collection<ImagePerfDataListener> listeners) {
        this.mListeners = listeners;
    }

    public void onImageLoadStatusUpdated(ImagePerfData imagePerfData, ImageLoadStatus imageLoadStatus) {
        for (ImagePerfDataListener listener : this.mListeners) {
            listener.onImageLoadStatusUpdated(imagePerfData, imageLoadStatus);
        }
    }

    public void onImageVisibilityUpdated(ImagePerfData imagePerfData, VisibilityState visibilityState) {
        for (ImagePerfDataListener listener : this.mListeners) {
            listener.onImageVisibilityUpdated(imagePerfData, visibilityState);
        }
    }
}
