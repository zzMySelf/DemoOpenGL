package com.baidu.searchbox.aisearch.camera.uitls;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.util.io.Closeables;
import com.facebook.common.util.UriUtil;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J&\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0007J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0007J\"\u0010\u001d\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/uitls/ImageUtils;", "", "()V", "ROTATE0", "", "ROTATE180", "ROTATE270", "ROTATE90", "computeInSampleSize", "width", "height", "maxSideLength", "decodeBitmapFromImage", "Landroid/graphics/Bitmap;", "image", "Landroid/media/Image;", "decodeBitmapFromUri", "context", "Landroid/content/Context;", "uri", "", "decodeImageDegree", "path", "flipBitmap", "bitmap", "resizeBitmap", "rotateBitmap", "orientation", "", "tryDecodeBitmapFromUriByPath", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageUtils.kt */
public final class ImageUtils {
    public static final ImageUtils INSTANCE = new ImageUtils();
    private static final int ROTATE0 = 0;
    private static final int ROTATE180 = 180;
    private static final int ROTATE270 = 270;
    private static final int ROTATE90 = 90;

    private ImageUtils() {
    }

    public final Bitmap decodeBitmapFromUri(Context context, String uri, int maxSideLength) {
        if (context == null || uri == null) {
            return null;
        }
        Bitmap $this$decodeBitmapFromUri_u24lambda_u2d0 = tryDecodeBitmapFromUriByPath(context, uri, maxSideLength);
        if ($this$decodeBitmapFromUri_u24lambda_u2d0 != null) {
            return $this$decodeBitmapFromUri_u24lambda_u2d0;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = null;
        InputStream input = null;
        try {
            input = context.getContentResolver().openInputStream(Uri.parse(uri));
            BitmapFactory.decodeStream(input, (Rect) null, options);
            Closeables.closeSafely((Closeable) input);
            int inSampleSize = computeInSampleSize(options.outWidth, options.outHeight, maxSideLength);
            if (inSampleSize <= 0) {
                Closeables.closeSafely((Closeable) input);
                return null;
            }
            input = context.getContentResolver().openInputStream(Uri.parse(uri));
            if (input != null) {
                options.inJustDecodeBounds = false;
                options.inSampleSize = inSampleSize;
                Bitmap sampledBitmap = BitmapFactory.decodeStream(input, (Rect) null, options);
                if (sampledBitmap == null) {
                    Closeables.closeSafely((Closeable) input);
                    return null;
                }
                bitmap = resizeBitmap(sampledBitmap, maxSideLength);
                String realPath = UriUtil.getRealPathFromUri(context.getContentResolver(), Uri.parse(uri));
                if (!(realPath == null || decodeImageDegree(realPath) == 0)) {
                    bitmap = rotateBitmap((float) decodeImageDegree(realPath), bitmap);
                }
            }
            Closeables.closeSafely((Closeable) input);
            int i2 = inSampleSize;
            return bitmap;
        } catch (Throwable th2) {
            Closeables.closeSafely((Closeable) input);
            return null;
        }
    }

    public final Bitmap resizeBitmap(Bitmap bitmap, int maxSideLength) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int originalWidth = bitmap.getWidth();
        int originalHeight = bitmap.getHeight();
        if (originalHeight <= 0 || originalHeight <= 0) {
            return bitmap;
        }
        if (originalWidth < maxSideLength && originalHeight < maxSideLength) {
            return bitmap;
        }
        boolean widthIsLarger = originalWidth > originalHeight;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, widthIsLarger ? maxSideLength : (int) ((((float) maxSideLength) / ((float) originalHeight)) * ((float) originalWidth)), !widthIsLarger ? maxSideLength : (int) ((((float) maxSideLength) / ((float) originalWidth)) * ((float) originalHeight)), true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
        return createScaledBitmap;
    }

    private final int decodeImageDegree(String path) {
        CharSequence charSequence = path;
        int degree = 0;
        if (charSequence == null || charSequence.length() == 0) {
            return 0;
        }
        try {
            switch (new ExifInterface(path).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) {
                case 3:
                    degree = 180;
                    break;
                case 6:
                    degree = 90;
                    break;
                case 8:
                    degree = 270;
                    break;
            }
        } catch (Exception e2) {
        }
        return degree;
    }

    public final Bitmap decodeBitmapFromImage(Image image) {
        Bitmap bitmap;
        InputStream inputStream;
        Intrinsics.checkNotNullParameter(image, "image");
        try {
            Image.Plane[] planes = image.getPlanes();
            Intrinsics.checkNotNullExpressionValue(planes, "image.planes");
            int i2 = 0;
            if (!(((Object[]) planes).length == 0)) {
                if (image.getPlanes()[0].getBuffer().hasRemaining()) {
                    byte[] byteArray = new byte[image.getPlanes()[0].getBuffer().remaining()];
                    image.getPlanes()[0].getBuffer().get(byteArray);
                    bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                    inputStream = null;
                    inputStream = new ByteArrayInputStream(byteArray);
                    try {
                        switch (new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)) {
                            case 3:
                                i2 = 180;
                                break;
                            case 6:
                                i2 = 90;
                                break;
                            case 8:
                                i2 = 270;
                                break;
                        }
                    } catch (Exception e2) {
                    }
                    int degree = i2;
                    if (degree != 0) {
                        bitmap = rotateBitmap((float) degree, bitmap);
                    }
                    Closeables.closeSafely((Closeable) inputStream);
                    return bitmap;
                }
            }
            return null;
        } catch (Throwable th2) {
            return null;
        }
    }

    public final Bitmap rotateBitmap(float orientation, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Matrix m = new Matrix();
        if (orientation == 0.0f) {
            return bitmap;
        }
        m.setRotate(orientation);
        try {
            Bitmap transformed = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
            Intrinsics.checkNotNullExpressionValue(transformed, "{\n            m.setRotat…l\n            }\n        }");
            return transformed;
        } catch (OutOfMemoryError e2) {
            return null;
        } catch (Exception e3) {
            return null;
        }
    }

    public final Bitmap flipBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
        try {
            Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Intrinsics.checkNotNullExpressionValue(result, "try {\n            Bitmap…    return null\n        }");
            return result;
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    private final Bitmap tryDecodeBitmapFromUriByPath(Context context, String uri, int maxSideLength) {
        try {
            String realPath = UriUtil.getRealPathFromUri(context.getContentResolver(), Uri.parse(uri));
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (realPath == null) {
                return null;
            }
            try {
                BitmapFactory.decodeFile(realPath, options);
                int inSampleSize = computeInSampleSize(options.outWidth, options.outHeight, maxSideLength);
                if (inSampleSize <= 0) {
                    return null;
                }
                options.inSampleSize = inSampleSize;
                options.inJustDecodeBounds = false;
                Bitmap sampledBitmap = BitmapFactory.decodeFile(realPath, options);
                Intrinsics.checkNotNullExpressionValue(sampledBitmap, "sampledBitmap");
                Bitmap bitmap = resizeBitmap(sampledBitmap, maxSideLength);
                if (decodeImageDegree(realPath) != 0) {
                    return rotateBitmap((float) decodeImageDegree(realPath), bitmap);
                }
                return bitmap;
            } catch (Throwable th2) {
                return null;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    private final int computeInSampleSize(int width, int height, int maxSideLength) {
        if (width <= 0 || height <= 0) {
            return -1;
        }
        int inSampleSize = 1;
        while (RangesKt.coerceAtLeast(width, height) / inSampleSize > maxSideLength) {
            inSampleSize *= 2;
        }
        return RangesKt.coerceAtLeast(inSampleSize / 2, 1);
    }
}
