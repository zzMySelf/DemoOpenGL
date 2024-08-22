package com.facebook.animated.giflite.draw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import javax.annotation.Nullable;

public class MovieDrawer {
    private final Canvas mCanvas = new Canvas();
    private final Movie mMovie;
    @Nullable
    private Bitmap mPreviousBitmap;
    private final MovieScaleHolder mScaleHolder;

    public MovieDrawer(Movie movie) {
        this.mMovie = movie;
        this.mScaleHolder = new MovieScaleHolder(movie.width(), movie.height());
    }

    public synchronized void drawFrame(int movieTime, int w, int h2, Bitmap bitmap) {
        this.mMovie.setTime(movieTime);
        Bitmap bitmap2 = this.mPreviousBitmap;
        if (bitmap2 != null && bitmap2.isRecycled()) {
            this.mPreviousBitmap = null;
        }
        if (this.mPreviousBitmap != bitmap) {
            this.mPreviousBitmap = bitmap;
            this.mCanvas.setBitmap(bitmap);
        }
        this.mScaleHolder.updateViewPort(w, h2);
        this.mCanvas.save();
        this.mCanvas.scale(this.mScaleHolder.getScale(), this.mScaleHolder.getScale());
        this.mMovie.draw(this.mCanvas, this.mScaleHolder.getLeft(), this.mScaleHolder.getTop());
        this.mCanvas.restore();
    }
}
