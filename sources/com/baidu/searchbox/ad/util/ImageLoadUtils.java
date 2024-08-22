package com.baidu.searchbox.ad.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Arrays;

public class ImageLoadUtils {
    private static final int CORNERS = 4;

    public interface OnImageLoadListener {
        void onImageLoad(Drawable drawable);
    }

    public static void loadImage(String imageUrl, OnImageLoadListener listener) {
        loadImageWithCorner(imageUrl, listener, 0.0f);
    }

    public static void loadImageWithCorner(String imageUrl, OnImageLoadListener listener, float dp) {
        if (Float.compare(dp, 0.0f) < 0) {
            dp = 0.0f;
        }
        float[] arrays = new float[4];
        Arrays.fill(arrays, DeviceUtil.ScreenInfo.dp2pxf(AppRuntime.getAppContext(), dp));
        loadImageInner(imageUrl, listener, arrays);
    }

    public static void loadImageWithCorner(String imageUrl, OnImageLoadListener listener, float[] dps) {
        validCorners(dps);
        loadImageInner(imageUrl, listener, dps);
    }

    public static Bitmap parseDrawableToBitmap(Drawable drawable) {
        return ((BitmapDrawable) drawable).getBitmap();
    }

    public static Drawable parseBitmapToDrawable(Context context, Bitmap bitmap) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, float roundedCornerPx, boolean[] roundedCornerPosArray) {
        if (roundedCornerPosArray == null || roundedCornerPosArray.length != 4) {
            roundedCornerPosArray = new boolean[4];
            Arrays.fill(roundedCornerPosArray, false);
        }
        try {
            Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(output);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            canvas.drawARGB(0, 0, 0, 0);
            canvas.drawRoundRect(new RectF(rect), roundedCornerPx, roundedCornerPx, paint);
            if (!roundedCornerPosArray[0]) {
                canvas.drawRect(new Rect(0, 0, bitmap.getWidth() / 2, bitmap.getHeight() / 2), paint);
            }
            if (!roundedCornerPosArray[1]) {
                canvas.drawRect(new Rect(bitmap.getWidth() / 2, 0, bitmap.getWidth(), bitmap.getHeight() / 2), paint);
            }
            if (!roundedCornerPosArray[2]) {
                canvas.drawRect(new Rect(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getWidth(), bitmap.getHeight()), paint);
            }
            if (!roundedCornerPosArray[3]) {
                canvas.drawRect(new Rect(0, bitmap.getHeight() / 2, bitmap.getWidth() / 2, bitmap.getHeight()), paint);
            }
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect, paint);
            return output;
        } catch (Exception e2) {
            return bitmap;
        }
    }

    private static void validCorners(float[] dps) {
        if (dps == null || dps.length != 4) {
            Arrays.fill(new float[4], 0.0f);
            return;
        }
        for (int i2 = 0; i2 < 4; i2++) {
            if (Float.compare(dps[i2], 0.0f) < 0) {
                dps[i2] = 0.0f;
            }
            dps[i2] = DeviceUtil.ScreenInfo.dp2pxf(AppRuntime.getAppContext(), dps[i2]);
        }
    }

    /* access modifiers changed from: private */
    public static Drawable getDrawable(InputStream is, float[] corners) {
        Drawable drawable = Drawable.createFromStream(is, "");
        if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setShape(0);
            ((GradientDrawable) drawable).setCornerRadii(corners);
        }
        return drawable;
    }

    private static void loadImageInner(String imageUrl, OnImageLoadListener listener, float[] corners) {
        if (!TextUtils.isEmpty(imageUrl)) {
            ImagePipeline pipeline = Fresco.getImagePipeline();
            ImagePipelineFactory factory = Fresco.getImagePipelineFactory();
            if (pipeline != null && factory != null) {
                try {
                    DataSource<Boolean> cacheDataSource = pipeline.isInDiskCache(Uri.parse(imageUrl));
                    final ImagePipelineFactory imagePipelineFactory = factory;
                    final String str = imageUrl;
                    final OnImageLoadListener onImageLoadListener = listener;
                    final float[] fArr = corners;
                    final DataSource<Boolean> dataSource = cacheDataSource;
                    final ImagePipeline imagePipeline = pipeline;
                    cacheDataSource.subscribe(new BaseDataSubscriber<Boolean>() {
                        /* access modifiers changed from: protected */
                        public void onNewResultImpl(DataSource<Boolean> dataSource) {
                            if (dataSource != null && dataSource.isFinished()) {
                                Boolean result = dataSource.getResult();
                                if (result == null || !result.booleanValue()) {
                                    imagePipeline.fetchDecodedImage(ImageRequest.fromUri(str), AppRuntime.getAppContext()).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() {
                                        /* Debug info: failed to restart local var, previous not found, register: 5 */
                                        /* access modifiers changed from: protected */
                                        public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                                            CloseableReference<CloseableImage> ref;
                                            if (dataSource == null || dataSource.isFinished()) {
                                                try {
                                                    ref = dataSource.getResult();
                                                    if (ref == null) {
                                                        dataSource.close();
                                                        return;
                                                    }
                                                    BinaryResource resource = ImagePipelineFactory.this.getMainFileCache().getResource(new SimpleCacheKey(str));
                                                    if (resource instanceof FileBinaryResource) {
                                                        InputStream iis = resource.openStream();
                                                        if (onImageLoadListener != null) {
                                                            onImageLoadListener.onImageLoad(ImageLoadUtils.getDrawable(iis, fArr));
                                                        }
                                                        Closeables.closeSafely((Closeable) iis);
                                                        CloseableReference.closeSafely((CloseableReference<?>) ref);
                                                    }
                                                    dataSource.close();
                                                } catch (Exception e2) {
                                                    Closeables.closeSafely((Closeable) null);
                                                } catch (Throwable th2) {
                                                    dataSource.close();
                                                    throw th2;
                                                }
                                            }
                                        }

                                        /* access modifiers changed from: protected */
                                        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                                            if (dataSource != null) {
                                                dataSource.close();
                                            }
                                        }
                                    }, UiThreadImmediateExecutorService.getInstance());
                                    return;
                                }
                                BinaryResource resource = ImagePipelineFactory.this.getMainFileCache().getResource(new SimpleCacheKey(str));
                                if (resource instanceof FileBinaryResource) {
                                    InputStream is = null;
                                    try {
                                        InputStream is2 = resource.openStream();
                                        OnImageLoadListener onImageLoadListener = onImageLoadListener;
                                        if (onImageLoadListener != null) {
                                            onImageLoadListener.onImageLoad(ImageLoadUtils.getDrawable(is2, fArr));
                                        }
                                        if (!dataSource.isClosed()) {
                                            dataSource.close();
                                        }
                                        if (!dataSource.isClosed()) {
                                            dataSource.close();
                                        }
                                        if (is2 != null) {
                                            try {
                                                is2.close();
                                            } catch (Exception e2) {
                                            }
                                        }
                                    } catch (Exception e3) {
                                        if (!dataSource.isClosed()) {
                                            dataSource.close();
                                        }
                                        if (!dataSource.isClosed()) {
                                            dataSource.close();
                                        }
                                        if (is != null) {
                                            is.close();
                                        }
                                    } catch (Throwable th2) {
                                        if (!dataSource.isClosed()) {
                                            dataSource.close();
                                        }
                                        if (!dataSource.isClosed()) {
                                            dataSource.close();
                                        }
                                        if (is != null) {
                                            try {
                                                is.close();
                                            } catch (Exception e4) {
                                            }
                                        }
                                        throw th2;
                                    }
                                }
                            }
                        }

                        /* access modifiers changed from: protected */
                        public void onFailureImpl(DataSource<Boolean> dataSource) {
                            if (dataSource != null) {
                                dataSource.close();
                            }
                        }
                    }, UiThreadImmediateExecutorService.getInstance());
                } catch (Exception e2) {
                }
            }
        }
    }
}
