package com.baidu.talos.core.render.viewshot;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.callback.Promise;
import com.baidu.talos.core.common.RNAppProcessManager;
import com.baidu.talos.core.data.Arguments;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.render.PixelUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ViewShot implements Runnable {
    public static final String DIRECTORY_NAME = "talos-view-snapshot";
    public static final String ERROR_PARAMS_ILLEGAL_CODE = "E_PARAMS_ILLEGAL";
    public static final String ERROR_UNABLE_TO_SNAPSHOT = "E_UNABLE_TO_SNAPSHOT";
    private static final String TAG = ViewShot.class.getSimpleName();
    public static final String TAG_WINDOW = "window";
    public static final String TEMP_FILE_PREFIX = "talos-snapshot-image";
    private final int format;
    private final int height;
    private final int offsetX;
    private final int offsetY;
    private final File output;
    private final Promise promise;
    private final double quality;

    /* renamed from: view  reason: collision with root package name */
    private final View f3735view;
    private final int width;

    public @interface Formats {
        public static final int JPEG = 0;
        public static final int PNG = 1;
        public static final int RAW = -1;
        public static final int WEBP = 2;
        public static final Bitmap.CompressFormat[] mapping = {Bitmap.CompressFormat.JPEG, Bitmap.CompressFormat.PNG, Bitmap.CompressFormat.WEBP};
    }

    public ViewShot(View view2, int format2, double quality2, int width2, int height2, File output2, int offsetX2, int offsetY2, Promise promise2) {
        this.f3735view = view2;
        this.format = format2;
        this.quality = quality2;
        this.width = width2;
        this.height = height2;
        this.output = output2;
        this.offsetX = offsetX2;
        this.offsetY = offsetY2;
        this.promise = promise2;
    }

    public static File getViewShotPathForProcess(File basePath) {
        return new File(new File(basePath, DIRECTORY_NAME), RNAppProcessManager.getProcessName());
    }

    public void run() {
        try {
            long start = System.currentTimeMillis();
            saveToTempFileOnDevice();
            if (Debug.isDebug()) {
                Log.d(TAG, "captureView cost time:" + (System.currentTimeMillis() - start));
            }
        } catch (Throwable ex) {
            Log.e(TAG, "Failed to capture view snapshot", ex);
            this.promise.reject(ERROR_UNABLE_TO_SNAPSHOT, "Failed to capture view snapshot, ex:" + Log.getStackTraceString(ex));
        }
    }

    private void saveToTempFileOnDevice() throws IOException {
        Size size = captureView(new FileOutputStream(this.output));
        ParamMap result = Arguments.createMap();
        String url = Uri.fromFile(this.output).toString();
        result.putString("url", url);
        result.putDouble("width", Double.valueOf((double) PixelUtil.toDIPFromPixel((float) size.getWidth())));
        result.putDouble("height", Double.valueOf((double) PixelUtil.toDIPFromPixel((float) size.getHeight())));
        this.promise.resolve(result);
        if (Debug.isDebug()) {
            Log.d(TAG, "saveToTempFileOnDevice success:" + url);
        }
    }

    private Size captureView(OutputStream os) throws IOException {
        try {
            return captureViewImpl(os);
        } finally {
            os.close();
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 11 */
    private Size captureViewImpl(OutputStream os) {
        int w = this.f3735view.getWidth();
        int h2 = this.f3735view.getHeight();
        if (w > 0 && h2 > 0) {
            int w2 = Math.min(this.width, w - this.offsetX);
            int h3 = Math.min(this.height, h2 - this.offsetY);
            boolean needDisableDrawingCache = false;
            if (!this.f3735view.isDrawingCacheEnabled()) {
                this.f3735view.setDrawingCacheEnabled(true);
                needDisableDrawingCache = true;
            }
            Integer color = null;
            if (this.format == 0) {
                color = Integer.valueOf(this.f3735view.getDrawingCacheBackgroundColor());
                this.f3735view.setDrawingCacheBackgroundColor(-1);
            }
            try {
                this.f3735view.destroyDrawingCache();
                Bitmap bitmap = Bitmap.createBitmap(this.f3735view.getDrawingCache(), this.offsetX, this.offsetY, w2, h3);
                bitmap.compress(Formats.mapping[this.format], (int) (this.quality * 100.0d), os);
                Size size = new Size(bitmap.getWidth(), bitmap.getHeight());
                if (color != null) {
                    this.f3735view.setDrawingCacheBackgroundColor(color.intValue());
                }
                if (needDisableDrawingCache) {
                    this.f3735view.setDrawingCacheEnabled(false);
                }
                return size;
            } catch (Throwable th2) {
                if (color != null) {
                    this.f3735view.setDrawingCacheBackgroundColor(color.intValue());
                }
                if (needDisableDrawingCache) {
                    this.f3735view.setDrawingCacheEnabled(false);
                }
                throw th2;
            }
        } else if (!Debug.isDebug()) {
            return new Size(w, h2);
        } else {
            throw new RuntimeException("Impossible to snapshot the view: view is invalid");
        }
    }

    private static final class Size {
        private final int mHeight;
        private final int mWidth;

        public Size(int width, int height) {
            this.mWidth = width;
            this.mHeight = height;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }
    }
}
