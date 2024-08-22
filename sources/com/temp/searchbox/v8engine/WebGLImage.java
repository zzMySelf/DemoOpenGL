package com.temp.searchbox.v8engine;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.rtc.nps.plugin.data.RtcParameterSettings;
import com.baidu.searchbox.ugc.media.MimeType;
import com.baidu.swan.apps.canvas.model.CanvasToTempFileModel;
import com.temp.searchbox.v8engine.event.JSEvent;
import com.temp.searchbox.v8engine.util.MarioDebug;
import com.temp.smallgame.sdk.MarioLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class WebGLImage {
    private static final boolean DEBUG = MarioDebug.DEBUG_RENDER;
    private static final String TAG = "TLS_WebGLImage";
    private static HandlerThread sBackgroundThread = null;
    private static Handler sHandler = null;
    private String mBasePath = "";
    private String mBeforeSrc;
    private long mEnginePtr = 0;
    private String mErrorMsg;
    private int mHeight = 0;
    private int mImageId;
    private long mNativePtr = 0;
    private String mSrc = "";
    private int mWidth = 0;

    private native void nativeOnLoadFailed(long j2, String str, int i2);

    private native void nativeOnLoadSuccess(long j2, int i2);

    private static native boolean nativeReadPixels(long j2, Bitmap bitmap, int i2, int i3, int i4, int i5);

    public native boolean nativeLoadAsset(long j2, Bitmap bitmap);

    public long getEnginePtr() {
        return this.mEnginePtr;
    }

    private WebGLImage(long nativePtr, long enginePtr, String basePath) {
        this.mNativePtr = nativePtr;
        this.mEnginePtr = enginePtr;
        this.mBasePath = basePath;
    }

    public static WebGLImage create(long nativePtr, long enginePtr, String basePath) {
        return new WebGLImage(nativePtr, enginePtr, basePath);
    }

    public void detach() {
        if (DEBUG) {
            MarioLog.d(TAG, "detach. src = " + this.mSrc);
        }
        this.mNativePtr = 0;
    }

    private static void recycleBitmap(String src) {
        WebGLImageLoader.recycleBitmap(src);
    }

    /* access modifiers changed from: package-private */
    public String oldSrc() {
        return this.mBeforeSrc;
    }

    public void setSrc(String src) {
        if (src != null) {
            this.mBeforeSrc = this.mSrc;
            this.mSrc = src.trim();
            WebGLImageLoader.loadImage(this);
        }
    }

    public void setImageId(int imageId) {
        this.mImageId = imageId;
    }

    public int getImageId() {
        return this.mImageId;
    }

    public int width() {
        return this.mWidth;
    }

    public int height() {
        return this.mHeight;
    }

    public String src() {
        if (!TextUtils.isEmpty(this.mSrc) && this.mSrc.startsWith("file")) {
            this.mSrc = Uri.parse(this.mSrc).getPath();
        }
        return this.mSrc;
    }

    public long nativePtr() {
        return this.mNativePtr;
    }

    public String basePath() {
        return this.mBasePath;
    }

    public boolean setBitmapData(Bitmap bitmap) {
        long j2 = this.mNativePtr;
        return j2 != 0 && nativeLoadAsset(j2, bitmap);
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public void onLoadSuccess(int imageId) {
        JSEvent event = new JSEvent("load", this, (Object) null);
        try {
            V8Engine engine = V8Engine.getInstance(this.mEnginePtr);
            if (engine != null) {
                postImageJSCallback(engine, event, imageId);
                if (DEBUG) {
                    MarioLog.d(TAG, "onLoadSuccess: " + this.mSrc);
                    return;
                }
                return;
            }
            throw new Exception("can't get the v8engine instance.");
        } catch (Exception e2) {
            MarioLog.e("V8", e2.getMessage(), (Throwable) e2);
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 4 */
    public void onLoadFailed(int src, String error) {
        this.mErrorMsg = error;
        JSEvent event = new JSEvent("error", this, (Object) null);
        try {
            V8Engine engine = V8Engine.getInstance(this.mEnginePtr);
            if (engine != null) {
                postImageJSCallback(engine, event, src);
                if (DEBUG) {
                    MarioLog.d(TAG, "onLoadFailed: " + error);
                    return;
                }
                return;
            }
            throw new Exception("can't get the v8engine instance.");
        } catch (Exception e2) {
            MarioLog.e("V8", e2.getMessage(), (Throwable) e2);
        }
    }

    private void postImageJSCallback(V8Engine engine, final JSEvent event, final int imageId) {
        engine.postSuspendableTaskOnJSThread(new Runnable() {
            public void run() {
                WebGLImage.this.invokeCallback(event, imageId);
            }
        });
    }

    public void invokeCallback(JSEvent event, int imageId) {
        if (event != null && event.type != null) {
            V8Engine engine = V8Engine.getInstance(this.mEnginePtr);
            if (engine != null && engine.isPaused()) {
                postImageJSCallback(engine, event, imageId);
            } else if (this.mNativePtr != 0) {
                if (DEBUG) {
                    MarioLog.d(TAG, "invokeCallback. type = " + event.type + ", src = " + src());
                }
                if (event.type.equals("load")) {
                    nativeOnLoadSuccess(this.mNativePtr, imageId);
                } else {
                    nativeOnLoadFailed(this.mNativePtr, this.mErrorMsg, imageId);
                }
            }
        }
    }

    public static Bitmap readCanvas(long nativeCanvasPtr, int x, int y, int width, int height) {
        Bitmap bitmap = null;
        if (x == -1 || y == -1) {
            return null;
        }
        try {
            Bitmap bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            if (nativeReadPixels(nativeCanvasPtr, bitmap2, x, y, width, height)) {
                return bitmap2;
            }
            throw new RuntimeException("Failed to read pixels from native canvas");
        } catch (Throwable e2) {
            MarioLog.e("V8", e2.getMessage(), e2);
            if (bitmap != null) {
                bitmap.recycle();
            }
            return null;
        }
    }

    public static byte[] compressCanvas(Bitmap bitmap, int destWidth, int destHeight, String fileType, float quality) throws Throwable {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Bitmap.CompressFormat type = toCompressFormat(fileType);
        if (!(destWidth == bitmap.getWidth() && destHeight == bitmap.getHeight())) {
            Bitmap tmp = Bitmap.createScaledBitmap(bitmap, destWidth, destHeight, false);
            bitmap.recycle();
            bitmap = tmp;
        }
        bitmap.compress(type, (int) (100.0f * quality), out);
        return out.toByteArray();
    }

    public static String saveTempFilePath(long nativeEnginePtr, byte[] data, String fileType) throws Throwable {
        FileOutputStream fileStream = null;
        try {
            File dir = new File(V8Engine.getInstance(nativeEnginePtr).getBdFileRealPath(), "tmp");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = File.createTempFile("tmp_", "." + fileType, dir);
            MarioLog.e("V8", "saveTempFilePath--file : " + file);
            FileOutputStream fileStream2 = new FileOutputStream(file);
            fileStream2.write(data);
            String str = "bdfile://tmp/" + file.getName();
            fileStream2.close();
            return str;
        } catch (Throwable th2) {
            if (fileStream != null) {
                fileStream.close();
            }
            throw th2;
        }
    }

    private static void saveBitmapData(byte[] data, String type) {
        FileOutputStream fileStream = null;
        try {
            File file = File.createTempFile("tmp_", "." + type, new File("/sdcard"));
            MarioLog.e("V8", "saveBitmapData--file : " + file);
            fileStream = new FileOutputStream(file);
            fileStream.write(data);
            fileStream.flush();
            fileStream.close();
        } catch (Throwable t) {
            MarioLog.d("V8", t.getMessage(), t);
        }
    }

    public static String toDataURL(long nativeCanvasPtr, int width, int height, String type, float quality) {
        try {
            Bitmap bitmap = readCanvas(nativeCanvasPtr, 0, 0, width, height);
            float quality2 = (quality <= 0.0f || quality > 1.0f) ? 0.92f : quality;
            String imageType = getValidFileType(type);
            return "data:" + ("image/" + imageType) + ";base64," + Base64.encodeToString(compressCanvas(bitmap, width, height, imageType, quality2), 2);
        } catch (Throwable e2) {
            MarioLog.e("V8", e2.getMessage(), e2);
            return null;
        }
    }

    private static class CanvasResult {
        @V8JavascriptField
        public String errMsg = null;
        @V8JavascriptField
        public String tempFilePath = null;

        CanvasResult(String path, String msg) {
            this.tempFilePath = path;
            this.errMsg = msg;
        }

        CanvasResult() {
        }
    }

    public static String toTempFilePathInternal(long nativeCanvasPtr, long nativeEnginePtr, int x, int y, int width, int height, int destWidth, int destHeight, String fileType, float quality, JsFunction success, JsFunction fail, JsFunction complete, boolean sync) {
        String fileType2 = getValidFileType(fileType);
        float quality2 = (quality <= 0.0f || quality > 1.0f) ? 0.92f : quality;
        if (sync) {
            return toTempFilePathSync(nativeCanvasPtr, nativeEnginePtr, x, y, width, height, destWidth, destHeight, fileType2, quality2);
        }
        return toTempFilePathAsync(nativeCanvasPtr, nativeEnginePtr, x, y, width, height, destWidth, destHeight, fileType2, quality2, success, fail, complete);
    }

    public static String toTempFilePathAsync(long nativeCanvasPtr, long nativeEnginePtr, int x, int y, int width, int height, int destWidth, int destHeight, String fileType, float quality, JsFunction success, JsFunction fail, JsFunction complete) {
        int i2 = x;
        int i3 = y;
        int i4 = width;
        int i5 = height;
        int i6 = destWidth;
        int i7 = destHeight;
        MarioLog.e("V8", "toTempFilePathAsync-- " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + i6 + ", " + i7 + ", " + fileType + ", " + quality + ", " + success + ", " + fail + ", " + complete);
        if (sBackgroundThread == null) {
            HandlerThread handlerThread = new HandlerThread("background");
            sBackgroundThread = handlerThread;
            handlerThread.start();
            sHandler = new Handler(sBackgroundThread.getLooper());
        }
        final Bitmap bitmap = (i2 < 0 || i3 < 0 || i4 <= 0 || i5 <= 0 || i6 <= 0 || i7 <= 0) ? null : readCanvas(nativeCanvasPtr, x, y, width, height);
        final int i8 = destWidth;
        final int i9 = destHeight;
        final String str = fileType;
        final float f2 = quality;
        final long j2 = nativeEnginePtr;
        final JsFunction jsFunction = success;
        final JsFunction jsFunction2 = fail;
        final JsFunction jsFunction3 = complete;
        sHandler.post(new Runnable() {
            /* Debug info: failed to restart local var, previous not found, register: 8 */
            public void run() {
                JsFunction jsFunction;
                CanvasResult result = new CanvasResult();
                try {
                    Bitmap bitmap = bitmap;
                    if (bitmap != null) {
                        String tmpFile = WebGLImage.saveTempFilePath(j2, WebGLImage.compressCanvas(bitmap, i8, i9, str, f2), str);
                        MarioLog.e("V8", "toTempFilePathAsync--Success: " + tmpFile);
                        if (jsFunction != null) {
                            result.tempFilePath = tmpFile;
                            result.errMsg = "CanvastoTempFilePath: success";
                            jsFunction.call((Object) result);
                        }
                        MarioLog.e("V8", "toTempFilePathAsync--Complete: ");
                        jsFunction = jsFunction3;
                        if (jsFunction == null) {
                            return;
                        }
                        jsFunction.call((Object) result);
                        return;
                    }
                    throw new Exception();
                } catch (Throwable th2) {
                    MarioLog.e("V8", "toTempFilePathAsync--Complete: ");
                    JsFunction jsFunction2 = jsFunction3;
                    if (jsFunction2 != null) {
                        jsFunction2.call((Object) result);
                    }
                    throw th2;
                }
            }
        });
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String toTempFilePathSync(long r16, long r18, int r20, int r21, int r22, int r23, int r24, int r25, java.lang.String r26, float r27) {
        /*
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "toTempFilePathSync-- "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r7)
            java.lang.String r1 = ", "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r8)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r11)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r12)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r14)
            java.lang.String r0 = r0.toString()
            java.lang.String r15 = "V8"
            com.temp.smallgame.sdk.MarioLog.e(r15, r0)
            r0 = -1
            if (r7 == r0) goto L_0x0097
            if (r8 == r0) goto L_0x0097
            if (r9 == r0) goto L_0x008d
            if (r10 == r0) goto L_0x008d
            if (r11 == r0) goto L_0x008d
            if (r12 == r0) goto L_0x008d
            r1 = r16
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            android.graphics.Bitmap r0 = readCanvas(r1, r3, r4, r5, r6)     // Catch:{ all -> 0x0089 }
            byte[] r1 = compressCanvas(r0, r11, r12, r13, r14)     // Catch:{ all -> 0x0089 }
            r2 = r18
            java.lang.String r4 = saveTempFilePath(r2, r1, r13)     // Catch:{ all -> 0x00a1 }
            return r4
        L_0x0089:
            r0 = move-exception
            r2 = r18
            goto L_0x00a2
        L_0x008d:
            r2 = r18
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = "The width or height must be legal"
            r0.<init>(r1)     // Catch:{ all -> 0x00a1 }
            throw r0     // Catch:{ all -> 0x00a1 }
        L_0x0097:
            r2 = r18
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = "The x or y must be legal"
            r0.<init>(r1)     // Catch:{ all -> 0x00a1 }
            throw r0     // Catch:{ all -> 0x00a1 }
        L_0x00a1:
            r0 = move-exception
        L_0x00a2:
            java.lang.String r1 = r0.getMessage()
            com.temp.smallgame.sdk.MarioLog.e((java.lang.String) r15, (java.lang.String) r1, (java.lang.Throwable) r0)
            com.temp.searchbox.v8engine.V8Engine r1 = com.temp.searchbox.v8engine.V8Engine.getInstance(r18)
            if (r1 == 0) goto L_0x00b8
            com.temp.searchbox.v8engine.JSExceptionType r4 = com.temp.searchbox.v8engine.JSExceptionType.Error
            java.lang.String r5 = r0.getMessage()
            r1.throwJSException(r4, r5)
        L_0x00b8:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.temp.searchbox.v8engine.WebGLImage.toTempFilePathSync(long, long, int, int, int, int, int, int, java.lang.String, float):java.lang.String");
    }

    private static Bitmap.CompressFormat toCompressFormat(String type) {
        if ("jpg".equalsIgnoreCase(type) || RtcParameterSettings.VideoCodecId.JPEG.equalsIgnoreCase(type)) {
            return Bitmap.CompressFormat.JPEG;
        }
        return Bitmap.CompressFormat.PNG;
    }

    private static String getValidFileType(String type) {
        if ("jpg".equalsIgnoreCase(type) || MimeType.Image.JPG.equalsIgnoreCase(type)) {
            return "jpg";
        }
        if (RtcParameterSettings.VideoCodecId.JPEG.equalsIgnoreCase(type) || "image/jpeg".equalsIgnoreCase(type)) {
            return RtcParameterSettings.VideoCodecId.JPEG;
        }
        return CanvasToTempFileModel.IMAGE_EXT_PNG;
    }
}
