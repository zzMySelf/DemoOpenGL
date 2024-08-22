package com.baidu.talos.core.render.views.bgimg;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.core.Debug;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.core.render.PixelUtil;
import com.baidu.talos.core.render.ViewProps;
import com.baidu.talos.core.render.theme.TalosThemeManager;
import com.baidu.talos.util.DeviceUtils;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BackgroundDrawer {
    public static final String SIZE_UNIT_AUTO = "auto";
    public static final String SIZE_UNIT_CENTER = "center";
    public static final String SIZE_UNIT_PER = "%";
    public static final String SIZE_UNIT_PX = "px";
    public static final String SIZE_UNIT_VH = "vh";
    public static final String SIZE_UNIT_VW = "vw";
    public static final String TAG = "BackgroundDrawer";

    public static final class Rects {
        public Rect source;
        public Rect target;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void drawBackground(android.view.View r17, android.graphics.Canvas r18, android.graphics.Paint r19, com.baidu.talos.core.render.views.bgimg.BackgroundDrawer.Options r20) {
        /*
            r1 = r17
            r8 = r20
            java.lang.String r9 = "BackgroundDrawer"
            if (r1 == 0) goto L_0x00cc
            if (r8 == 0) goto L_0x00cc
            java.lang.String r0 = r20.imageUri
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0018
            r6 = r18
            goto L_0x00ce
        L_0x0018:
            android.graphics.Bitmap r0 = r8.backgroundBitmap     // Catch:{ Exception -> 0x00bb }
            if (r0 == 0) goto L_0x00a7
            boolean r2 = r0.isRecycled()     // Catch:{ Exception -> 0x00bb }
            if (r2 == 0) goto L_0x0026
            r6 = r18
            goto L_0x00a9
        L_0x0026:
            int r2 = r17.getRight()     // Catch:{ Exception -> 0x00bb }
            int r3 = r17.getLeft()     // Catch:{ Exception -> 0x00bb }
            int r10 = r2 - r3
            int r2 = r17.getBottom()     // Catch:{ Exception -> 0x00bb }
            int r3 = r17.getTop()     // Catch:{ Exception -> 0x00bb }
            int r11 = r2 - r3
            r2 = 0
            r3 = 0
            com.baidu.talos.view.RootView r4 = com.baidu.talos.core.render.util.RootViewUtil.getRootView(r17)     // Catch:{ Exception -> 0x00bb }
            android.view.View r4 = (android.view.View) r4     // Catch:{ Exception -> 0x00bb }
            r12 = r4
            if (r12 == 0) goto L_0x0052
            int r4 = r12.getWidth()     // Catch:{ Exception -> 0x00bb }
            r2 = r4
            int r4 = r12.getHeight()     // Catch:{ Exception -> 0x00bb }
            r3 = r4
            r13 = r2
            r14 = r3
            goto L_0x0054
        L_0x0052:
            r13 = r2
            r14 = r3
        L_0x0054:
            r2 = r10
            r3 = r11
            r4 = r13
            r5 = r14
            r6 = r0
            r7 = r20
            java.util.List r2 = calculateRects(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00bb }
            if (r2 == 0) goto L_0x00a2
            int r3 = r2.size()     // Catch:{ Exception -> 0x00bb }
            if (r3 <= 0) goto L_0x00a2
            if (r19 != 0) goto L_0x006f
            android.graphics.Paint r3 = new android.graphics.Paint     // Catch:{ Exception -> 0x00bb }
            r3.<init>()     // Catch:{ Exception -> 0x00bb }
            goto L_0x0071
        L_0x006f:
            r3 = r19
        L_0x0071:
            java.util.Iterator r4 = r2.iterator()     // Catch:{ Exception -> 0x00bb }
        L_0x0075:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x00bb }
            if (r5 == 0) goto L_0x009d
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x00bb }
            android.graphics.Rect r5 = (android.graphics.Rect) r5     // Catch:{ Exception -> 0x00bb }
            android.graphics.Rect r6 = new android.graphics.Rect     // Catch:{ Exception -> 0x00bb }
            int r7 = r0.getWidth()     // Catch:{ Exception -> 0x00bb }
            int r15 = r0.getHeight()     // Catch:{ Exception -> 0x00bb }
            r16 = r2
            r2 = 0
            r6.<init>(r2, r2, r7, r15)     // Catch:{ Exception -> 0x00bb }
            r2 = r6
            alignRects(r2, r5, r10, r11)     // Catch:{ Exception -> 0x00bb }
            r6 = r18
            r6.drawBitmap(r0, r2, r5, r3)     // Catch:{ Exception -> 0x00b9 }
            r2 = r16
            goto L_0x0075
        L_0x009d:
            r6 = r18
            r16 = r2
            goto L_0x00a6
        L_0x00a2:
            r6 = r18
            r16 = r2
        L_0x00a6:
            goto L_0x00cb
        L_0x00a7:
            r6 = r18
        L_0x00a9:
            boolean r2 = com.baidu.talos.core.Debug.isDebug()     // Catch:{ Exception -> 0x00b9 }
            if (r2 == 0) goto L_0x00b5
            java.lang.String r2 = "no cache when draw"
            android.util.Log.d(r9, r2)     // Catch:{ Exception -> 0x00b9 }
        L_0x00b5:
            r8.loadImg(r1)     // Catch:{ Exception -> 0x00b9 }
            return
        L_0x00b9:
            r0 = move-exception
            goto L_0x00be
        L_0x00bb:
            r0 = move-exception
            r6 = r18
        L_0x00be:
            boolean r2 = com.baidu.talos.core.Debug.isDebug()
            if (r2 == 0) goto L_0x00cb
            java.lang.String r2 = android.util.Log.getStackTraceString(r0)
            android.util.Log.e(r9, r2)
        L_0x00cb:
            return
        L_0x00cc:
            r6 = r18
        L_0x00ce:
            boolean r0 = com.baidu.talos.core.Debug.isDebug()
            if (r0 == 0) goto L_0x00d9
            java.lang.String r0 = "data is null"
            android.util.Log.e(r9, r0)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.talos.core.render.views.bgimg.BackgroundDrawer.drawBackground(android.view.View, android.graphics.Canvas, android.graphics.Paint, com.baidu.talos.core.render.views.bgimg.BackgroundDrawer$Options):void");
    }

    private static void alignRects(Rect source, Rect target, int rightBound, int bottomBound) {
        double rationX = (((double) (source.right - source.left)) * 1.0d) / ((double) (target.right - target.left));
        double rationY = (((double) (source.bottom - source.top)) * 1.0d) / ((double) (target.bottom - target.top));
        if (target.top < 0) {
            source.top = (int) (((double) source.top) + (((double) (-target.top)) * rationY));
            target.top = 0;
        }
        if (target.bottom > bottomBound) {
            source.bottom = (int) (((double) source.bottom) - (((double) (target.bottom - bottomBound)) * rationY));
            target.bottom = bottomBound;
        }
        if (target.left < 0) {
            source.left = (int) (((double) source.left) + (((double) (-target.left)) * rationX));
            target.left = 0;
        }
        if (target.right > rightBound) {
            source.right = (int) (((double) source.right) - (((double) (target.right - rightBound)) * rationX));
            target.right = rightBound;
        }
    }

    private static List<Rect> calculateRects(int parentWidth, int parentHeight, int rootWidth, int rootHeight, Bitmap bitmap, Options options) {
        Rect pivot = calculatePivot(parentWidth, parentHeight, rootWidth, rootHeight, calculateSize(parentWidth, parentHeight, rootWidth, rootHeight, bitmap, options), options);
        switch (options.repeatType) {
            case 1:
                return calculateRepeatXY(parentWidth, parentHeight, pivot);
            case 2:
                return calculateRepeatX(parentWidth, parentHeight, pivot);
            case 3:
                return calculateRepeatY(parentWidth, parentHeight, pivot);
            case 4:
                List<Rect> rects = new ArrayList<>();
                rects.add(pivot);
                return rects;
            default:
                return null;
        }
    }

    private static List<Rect> calculateRepeatX(int parentWidth, int parentHeight, Rect pivot) {
        List<Rect> rectList = new ArrayList<>();
        rectList.add(pivot);
        int backgroundWidth = pivot.right - pivot.left;
        for (int rightBound = pivot.left; rightBound > 0; rightBound -= backgroundWidth) {
            rectList.add(new Rect(rightBound - backgroundWidth, pivot.top, rightBound, pivot.bottom));
        }
        for (int leftBound = pivot.right; leftBound < parentWidth; leftBound += backgroundWidth) {
            rectList.add(new Rect(leftBound, pivot.top, leftBound + backgroundWidth, pivot.bottom));
        }
        return rectList;
    }

    private static List<Rect> calculateRepeatY(int parentWidth, int parentHeight, Rect pivot) {
        List<Rect> rectList = new ArrayList<>();
        rectList.add(pivot);
        int backgroundHeight = pivot.bottom - pivot.top;
        for (int bottomBound = pivot.top; bottomBound > 0; bottomBound -= backgroundHeight) {
            rectList.add(new Rect(pivot.left, bottomBound - backgroundHeight, pivot.right, bottomBound));
        }
        for (int topBound = pivot.bottom; topBound < parentHeight; topBound += backgroundHeight) {
            rectList.add(new Rect(pivot.left, topBound, pivot.right, topBound + backgroundHeight));
        }
        return rectList;
    }

    private static List<Rect> calculateRepeatXY(int parentWidth, int parentHeight, Rect pivot) {
        List<Rect> rectList = new ArrayList<>();
        int backgroundHeight = pivot.bottom - pivot.top;
        rectList.addAll(calculateRepeatX(parentWidth, parentHeight, pivot));
        for (int bottomBound = pivot.top; bottomBound > 0; bottomBound -= backgroundHeight) {
            rectList.addAll(calculateRepeatX(parentWidth, parentHeight, new Rect(pivot.left, bottomBound - backgroundHeight, pivot.right, bottomBound)));
        }
        for (int topBound = pivot.bottom; topBound < parentHeight; topBound += backgroundHeight) {
            rectList.addAll(calculateRepeatX(parentWidth, parentHeight, new Rect(pivot.left, topBound, pivot.right, topBound + backgroundHeight)));
        }
        return rectList;
    }

    private static Rect calculatePivot(int parentWidth, int parentHeight, int rootWidth, int rootHeight, Size size, Options options) {
        Rect pivot = new Rect(0, 0, size.width, size.height);
        if (!TextUtils.isEmpty(options.left)) {
            pivot.left = getRealVal(options.left, size.width, parentWidth, rootWidth, rootHeight);
            pivot.right = pivot.left + size.width;
        } else if (!TextUtils.isEmpty(options.right)) {
            pivot.right = parentWidth - getRealVal(options.right, size.width, parentWidth, rootWidth, rootHeight);
            pivot.left = pivot.right - size.width;
        }
        if (!TextUtils.isEmpty(options.top)) {
            pivot.top = getRealVal(options.top, size.height, parentHeight, rootWidth, rootHeight);
            pivot.bottom = pivot.top + size.height;
        } else if (!TextUtils.isEmpty(options.bottom)) {
            pivot.bottom = parentHeight - getRealVal(options.bottom, size.height, parentHeight, rootWidth, rootHeight);
            pivot.top = pivot.bottom - size.height;
        }
        return pivot;
    }

    private static Size calculateSize(int parentWidth, int parentHeight, int rootWidth, int rootHeight, Bitmap bitmap, Options options) {
        int i2 = parentWidth;
        int i3 = parentHeight;
        Size size = new Size(bitmap.getWidth(), bitmap.getHeight());
        if (i3 == 0) {
            Options options2 = options;
        } else if (i2 == 0) {
            Options options3 = options;
        } else {
            double ratioBitmap = ((double) bitmap.getWidth()) / ((double) bitmap.getHeight());
            double ratioParent = ((double) i2) / ((double) i3);
            switch (options.sizeType) {
                case 11:
                    size.width = bitmap.getWidth();
                    size.height = bitmap.getHeight();
                    return size;
                case 12:
                    if (ratioBitmap > ratioParent) {
                        size.height = i3;
                        size.width = (int) (((double) size.height) * ratioBitmap);
                        return size;
                    }
                    size.width = i2;
                    size.height = (int) (((double) size.width) / ratioBitmap);
                    return size;
                case 13:
                    if (ratioBitmap > ratioParent) {
                        size.width = i2;
                        size.height = (int) (((double) size.width) / ratioBitmap);
                        return size;
                    }
                    size.height = i3;
                    size.width = (int) (((double) size.height) * ratioBitmap);
                    return size;
                case 14:
                    return getSizeRealVal(options, parentWidth, parentHeight, rootWidth, rootHeight, bitmap);
                default:
                    return size;
            }
        }
        return size;
    }

    private static Size getSizeRealVal(Options options, int parentWidth, int parentHeight, int rootWidth, int rootHeight, Bitmap bitmap) {
        String valWidth = options.width;
        String valHeight = options.height;
        int imageWidth = bitmap.getWidth();
        int imageHeight = bitmap.getHeight();
        Size size = new Size(imageWidth, imageHeight);
        if (TextUtils.isEmpty(valWidth)) {
            size.width = 0;
            return size;
        } else if (TextUtils.isEmpty(valHeight)) {
            size.height = 0;
            return size;
        } else if (valWidth.endsWith("auto") && valHeight.endsWith("auto")) {
            size.width = imageWidth;
            size.height = imageHeight;
            return size;
        } else if (valWidth.endsWith("auto")) {
            size.height = getRealVal(valHeight, parentHeight, rootWidth, rootHeight);
            size.width = (size.height * imageWidth) / imageHeight;
            return size;
        } else if (valHeight.endsWith("auto")) {
            size.width = getRealVal(valWidth, parentWidth, rootWidth, rootHeight);
            size.height = (size.width * imageHeight) / imageWidth;
            return size;
        } else {
            size.height = getRealVal(valHeight, parentHeight, rootWidth, rootHeight);
            size.width = getRealVal(valWidth, parentWidth, rootWidth, rootHeight);
            return size;
        }
    }

    private static int getRealVal(String val, int scale, int rootWidth, int rootHeight) {
        if (TextUtils.isEmpty(val)) {
            return 0;
        }
        if (val.endsWith("%")) {
            return (int) ((((float) scale) * Float.parseFloat(val.substring(0, val.length() - 1))) / 100.0f);
        } else if (val.endsWith("vh")) {
            return getViewportHeight(rootHeight, Float.parseFloat(val.substring(0, val.length() - 2)));
        } else {
            if (val.endsWith("vw")) {
                return getViewportWidth(rootWidth, Float.parseFloat(val.substring(0, val.length() - 2)));
            }
            try {
                return (int) PixelUtil.toPixelFromDIP(Float.parseFloat(val));
            } catch (Exception e2) {
                return 0;
            }
        }
    }

    private static int getRealVal(String val, int childScale, int parentScale, int rootWidth, int rootHeight) {
        if (TextUtils.isEmpty(val)) {
            return 0;
        }
        if (val.endsWith("center")) {
            return (parentScale - childScale) / 2;
        }
        return getRealVal(val, parentScale, rootWidth, rootHeight);
    }

    public static int getViewportWidth(int width, float vw) {
        if (width <= 0) {
            width = DeviceUtils.ScreenInfo.getDisplayWidth(TalosAppRuntimeInit.getAppContext());
        }
        return (int) ((((float) width) * vw) / 100.0f);
    }

    public static int getViewportHeight(int height, float vh) {
        if (height <= 0) {
            height = DeviceUtils.ScreenInfo.getDisplayHeight(TalosAppRuntimeInit.getAppContext());
        }
        return (int) ((((float) height) * vh) / 100.0f);
    }

    public static final class Size {
        public int height;
        public int width;

        public Size(int width2, int height2) {
            this.width = width2;
            this.height = height2;
        }
    }

    public static final class Options {
        public static final String REPEAT_ALL_KEY = "repeat";
        public static final int REPEAT_ALL_VAL = 1;
        public static final String REPEAT_NO_KEY = "noRepeat";
        public static final int REPEAT_NO_VAL = 4;
        public static final String REPEAT_X_KEY = "repeatX";
        public static final int REPEAT_X_VAL = 2;
        public static final String REPEAT_Y_KEY = "repeatY";
        public static final int REPEAT_Y_VAL = 3;
        public static final String SIZE_AUTO_KEY = "auto";
        public static final int SIZE_AUTO_VAL = 11;
        public static final String SIZE_CONTAIN_KEY = "contain";
        public static final int SIZE_CONTAIN_VAL = 13;
        public static final String SIZE_COVER_KEY = "cover";
        public static final int SIZE_COVER_VAL = 12;
        public static final String SIZE_FIXED_KEY = "fixed";
        public static final int SIZE_FIXED_VAL = 14;
        public Bitmap backgroundBitmap;
        public String bottom;
        public String height;
        /* access modifiers changed from: private */
        public String imageUri = "";
        public String left;
        private String mRuntimeKey;
        public int repeatType = 4;
        public String right;
        public int sizeType = 11;
        public String top;
        public String width;

        public Options(String runtimeKey) {
            this.mRuntimeKey = runtimeKey;
        }

        public void setBackgroundImg(ParamMap source, View target) {
            String uriValue;
            if (source != null) {
                if (source.hasKey("uri")) {
                    if (!TextUtils.isEmpty(this.mRuntimeKey)) {
                        String uriPrefix = "";
                        if (source.hasKey("prefix")) {
                            uriPrefix = source.getString("prefix");
                        }
                        String uriValue2 = source.getString("uri");
                        String uriSuffix = "";
                        if (source.hasKey("suffix")) {
                            uriSuffix = source.getString("suffix");
                        }
                        uriValue = TalosThemeManager.getInstance().getTheme(this.mRuntimeKey).mergeImageUri(uriValue2, uriPrefix, uriSuffix);
                    } else {
                        uriValue = source.getString("uri");
                    }
                    if (TextUtils.isEmpty(uriValue)) {
                        clearBackgroundImg(target);
                        return;
                    }
                    Uri targetUri = computeUri(uriValue);
                    if (targetUri == null) {
                        clearBackgroundImg(target);
                        return;
                    }
                    this.imageUri = uriValue;
                    ImageRequest request = ImageRequestBuilder.newBuilderWithSource(targetUri).setProgressiveRenderingEnabled(true).build();
                    Bitmap copy = null;
                    if (Fresco.getImagePipeline().isInBitmapMemoryCache(request)) {
                        try {
                            CloseableImage closeableImage = Fresco.getImagePipeline().getCachedImage(Fresco.getImagePipeline().getCacheKey(request, (Object) null)).get();
                            if (closeableImage instanceof CloseableBitmap) {
                                copy = Bitmap.createBitmap(((CloseableBitmap) closeableImage).getUnderlyingBitmap());
                            }
                        } catch (Throwable th2) {
                            copy = null;
                        }
                    }
                    if (copy == null || copy.isRecycled()) {
                        loadImg(target);
                        return;
                    }
                    updateBackgroundImg(target, copy);
                    if (Debug.isDebug()) {
                        Log.d(BackgroundDrawer.TAG, "bitmap is in cache");
                        return;
                    }
                    return;
                }
                if (Debug.isDebug()) {
                    Log.d(BackgroundDrawer.TAG, "image uri is null");
                }
                clearBackgroundImg(target);
            }
        }

        public void setSize(ParamMap size) {
            if (size != null) {
                String sizeType2 = null;
                String width2 = null;
                String height2 = null;
                if (size.hasKey(ViewProps.BACKGROUND_SIZE_TYPE)) {
                    sizeType2 = size.getString(ViewProps.BACKGROUND_SIZE_TYPE);
                }
                if (size.hasKey("width")) {
                    width2 = size.getString("width");
                }
                if (size.hasKey("height")) {
                    height2 = size.getString("height");
                }
                if (!TextUtils.isEmpty(sizeType2)) {
                    char c2 = 65535;
                    switch (sizeType2.hashCode()) {
                        case 3005871:
                            if (sizeType2.equals("auto")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 94852023:
                            if (sizeType2.equals("cover")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 97445748:
                            if (sizeType2.equals("fixed")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 951526612:
                            if (sizeType2.equals("contain")) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            this.sizeType = 12;
                            return;
                        case 1:
                            this.sizeType = 14;
                            this.width = width2;
                            this.height = height2;
                            return;
                        case 2:
                            this.sizeType = 13;
                            return;
                        default:
                            this.sizeType = 11;
                            return;
                    }
                }
            }
        }

        public void setRepeat(ParamMap repeat) {
            if (repeat != null) {
                String repeatType2 = null;
                if (repeat.hasKey(ViewProps.BACKGROUND_REPEAT_TYPE)) {
                    repeatType2 = repeat.getString(ViewProps.BACKGROUND_REPEAT_TYPE);
                }
                if (!TextUtils.isEmpty(repeatType2)) {
                    char c2 = 65535;
                    switch (repeatType2.hashCode()) {
                        case -934531685:
                            if (repeatType2.equals("repeat")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 608572092:
                            if (repeatType2.equals(REPEAT_NO_KEY)) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 1094288925:
                            if (repeatType2.equals(REPEAT_X_KEY)) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1094288926:
                            if (repeatType2.equals(REPEAT_Y_KEY)) {
                                c2 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            this.repeatType = 1;
                            return;
                        case 1:
                            this.repeatType = 2;
                            return;
                        case 2:
                            this.repeatType = 3;
                            return;
                        default:
                            this.repeatType = 4;
                            return;
                    }
                }
            }
        }

        public void setPosition(ParamMap position) {
            if (position != null) {
                String left2 = null;
                String top2 = null;
                String right2 = null;
                String bottom2 = null;
                if (position.hasKey("left")) {
                    left2 = position.getString("left");
                }
                if (position.hasKey("top")) {
                    top2 = position.getString("top");
                }
                if (position.hasKey("right")) {
                    right2 = position.getString("right");
                }
                if (position.hasKey("bottom")) {
                    bottom2 = position.getString("bottom");
                }
                this.left = left2;
                this.top = top2;
                this.right = right2;
                this.bottom = bottom2;
            }
        }

        public void setReadyImage(String uri, View target) {
            String str = this.imageUri;
            if (str != null && str.equals(uri) && target != null) {
                target.postInvalidate();
            }
        }

        public void setReadyImage(View target) {
            if (target != null) {
                target.postInvalidate();
            }
        }

        private Uri computeUri(String source) {
            try {
                Uri uri = Uri.parse(source);
                return uri.getScheme() == null ? computeLocalUri(source) : uri;
            } catch (Exception e2) {
                return computeLocalUri(source);
            }
        }

        private Uri computeLocalUri(String source) {
            if (source == null || !source.startsWith("/")) {
                return null;
            }
            File file = new File(source);
            if (file.exists()) {
                return Uri.fromFile(file);
            }
            return null;
        }

        private Uri parseUri(String uriStr) {
            try {
                return Uri.parse(uriStr);
            } catch (Exception e2) {
                return null;
            }
        }

        /* access modifiers changed from: private */
        public void updateBackgroundImg(View target, Bitmap newBitmap) {
            this.backgroundBitmap = newBitmap;
            if (target instanceof BackgroundHolder) {
                ((BackgroundHolder) target).setReadyImage(this.imageUri);
            }
        }

        private void clearBackgroundImg(View target) {
            this.backgroundBitmap = null;
            if (!TextUtils.isEmpty(this.imageUri)) {
                this.imageUri = "";
                if (target instanceof BackgroundHolder) {
                    ((BackgroundHolder) target).setReadyImage("");
                }
            }
        }

        /* access modifiers changed from: private */
        public void loadImg(final View target) {
            if (!TextUtils.isEmpty(this.imageUri)) {
                Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(computeUri(this.imageUri)).setProgressiveRenderingEnabled(true).build(), target.getContext()).subscribe(new BaseBitmapDataSubscriber() {
                    /* access modifiers changed from: protected */
                    public void onNewResultImpl(@Nullable Bitmap bitmap) {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            if (Debug.isDebug()) {
                                Log.d(BackgroundDrawer.TAG, "bitmap load success");
                            }
                            try {
                                Options.this.updateBackgroundImg(target, Bitmap.createBitmap(bitmap));
                            } catch (Throwable e2) {
                                if (Debug.isDebug()) {
                                    Log.e(BackgroundDrawer.TAG, "background loadImg " + Options.this.imageUri, e2);
                                }
                            }
                        }
                    }

                    /* access modifiers changed from: protected */
                    public void onFailureImpl(@Nonnull DataSource<CloseableReference<CloseableImage>> dataSource) {
                        if (Debug.isDebug()) {
                            Log.d(BackgroundDrawer.TAG, "bitmap load fail");
                        }
                    }
                }, UiThreadImmediateExecutorService.getInstance());
            }
        }
    }
}
