package com.duxiaoman.imageloader.listener;

import android.graphics.Bitmap;

public interface IImageLoaderListener {
    void onCompleted(Bitmap bitmap);

    void onFailure(Exception exc);
}
