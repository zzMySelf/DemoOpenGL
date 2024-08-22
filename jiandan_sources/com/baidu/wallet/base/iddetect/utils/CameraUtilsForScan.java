package com.baidu.wallet.base.iddetect.utils;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.baidu.wallet.base.iddetect.CameraSizeInfo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CameraUtilsForScan {
    public static final float BANK_HEIGHT_WIDTH_RADIO = 0.6306f;
    public static final int BIG_MAX_SIZE_HEIGHT = 1080;
    public static final int BIG_MAX_SIZE_WIDTH = 1920;
    public static final int CAMERA_POS_BACK = 1;
    public static final int CAMERA_POS_FRONT = 0;
    public static final int DEFAULT_SIZE_HEIGHT = 480;
    public static final int DEFAULT_SIZE_WIDTH = 640;
    public static final float MAX_RATIO_DVALUE = 0.1f;
    public static final int MAX_SIZE_HEIGHT = 720;
    public static final int MIN_SIZE_HEIGHT = 480;
    public static CameraSizeInfo mSmallSortSize;

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.baidu.wallet.base.iddetect.CameraSizeInfo getBestSurfaceSize(int r4, android.content.Context r5) {
        /*
            android.hardware.Camera r4 = getCameraDevice(r4)
            if (r4 == 0) goto L_0x004d
            android.hardware.Camera$Parameters r0 = r4.getParameters()     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x004d
            android.hardware.Camera$Parameters r0 = r4.getParameters()     // Catch:{ Exception -> 0x002d }
            java.util.List r0 = r0.getSupportedPreviewSizes()     // Catch:{ Exception -> 0x002d }
            java.util.List r0 = sortOut(r0)     // Catch:{ Exception -> 0x002d }
            android.graphics.Rect r1 = getScreenInfo(r5)     // Catch:{ Exception -> 0x002d }
            int r2 = r1.width()     // Catch:{ Exception -> 0x002d }
            int r3 = r1.height()     // Catch:{ Exception -> 0x002d }
            float r2 = getWdivideHRatio(r2, r3)     // Catch:{ Exception -> 0x002d }
            com.baidu.wallet.base.iddetect.CameraSizeInfo r5 = getMostSimilarSize(r5, r1, r2, r0)     // Catch:{ Exception -> 0x002d }
            goto L_0x004e
        L_0x002d:
            r4 = move-exception
            java.lang.Class<com.baidu.wallet.base.iddetect.CameraSizeInfo> r5 = com.baidu.wallet.base.iddetect.CameraSizeInfo.class
            java.lang.String r5 = r5.getSimpleName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "exception = "
            r0.append(r1)
            java.lang.String r1 = r4.getMessage()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.baidu.wallet.core.utils.LogUtil.errord(r5, r0)
            throw r4
        L_0x004d:
            r5 = 0
        L_0x004e:
            if (r4 == 0) goto L_0x005e
            java.lang.Class<com.baidu.wallet.base.iddetect.CameraSizeInfo> r0 = com.baidu.wallet.base.iddetect.CameraSizeInfo.class
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r1 = "release camera"
            com.baidu.wallet.core.utils.LogUtil.errord(r0, r1)
            r4.release()
        L_0x005e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan.getBestSurfaceSize(int, android.content.Context):com.baidu.wallet.base.iddetect.CameraSizeInfo");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r3 = android.hardware.Camera.open();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.hardware.Camera getCameraDevice(int r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 9
            if (r0 < r2) goto L_0x001b
            r0 = 1
            if (r3 != r0) goto L_0x0010
            r3 = 0
            android.hardware.Camera r3 = android.hardware.Camera.open(r3)     // Catch:{ Exception -> 0x0016 }
            goto L_0x0014
        L_0x0010:
            android.hardware.Camera r3 = android.hardware.Camera.open(r0)     // Catch:{ Exception -> 0x0016 }
        L_0x0014:
            r1 = r3
            goto L_0x001f
        L_0x0016:
            android.hardware.Camera r3 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x001f }
            goto L_0x0014
        L_0x001b:
            android.hardware.Camera r1 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x001f }
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.iddetect.utils.CameraUtilsForScan.getCameraDevice(int):android.hardware.Camera");
    }

    public static float getFormatFloat(float f) {
        return Float.parseFloat(new DecimalFormat("##0.00").format((double) f));
    }

    public static float getFrameHeightRatio(Context context, Rect rect, CameraSizeInfo cameraSizeInfo) {
        float width = (((float) rect.width()) * 1.0f) / ((float) cameraSizeInfo.mHeight);
        float height = (((float) rect.height()) * 1.0f) / ((float) cameraSizeInfo.mWidth);
        return width > height ? (width * 0.6306f) / height : (height * 0.6306f) / width;
    }

    public static CameraSizeInfo getMostSimilarSize(Context context, Rect rect, float f, List<CameraSizeInfo> list) {
        boolean z;
        int i2;
        boolean z2 = false;
        CameraSizeInfo cameraSizeInfo = null;
        int i3 = 0;
        while (true) {
            if (i3 >= list.size()) {
                z = false;
                break;
            }
            cameraSizeInfo = list.get(i3);
            float wdivideHRatio = getWdivideHRatio(cameraSizeInfo.mHeight, cameraSizeInfo.mWidth);
            list.get(i3).mRatioDeta = Math.abs(wdivideHRatio - f);
            list.get(i3).mIsCompareRatio = true;
            if (wdivideHRatio == f && (i2 = cameraSizeInfo.mHeight) >= 480 && i2 <= 720) {
                cameraSizeInfo.mHeightRatio = 0.6306f;
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            Collections.sort(list);
            int i4 = 0;
            while (true) {
                if (i4 < list.size()) {
                    if (list.get(i4).mHeight >= 480 && list.get(i4).mHeight <= 720 && list.get(i4).mRatioDeta <= 0.1f) {
                        cameraSizeInfo = list.get(i4);
                        cameraSizeInfo.mHeightRatio = getFrameHeightRatio(context, rect, cameraSizeInfo);
                        z2 = true;
                        break;
                    }
                    i4++;
                } else {
                    break;
                }
            }
        }
        if (!z && !z2) {
            if (cameraSizeInfo == null) {
                cameraSizeInfo = new CameraSizeInfo(640, 480);
            } else {
                cameraSizeInfo.mHeight = 480;
                cameraSizeInfo.mWidth = 640;
            }
            cameraSizeInfo.mHeightRatio = getFrameHeightRatio(context, rect, cameraSizeInfo);
        }
        return cameraSizeInfo;
    }

    public static Rect getScreenInfo(Context context) {
        if (Build.VERSION.SDK_INT < 14) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        Rect rect = new Rect();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRectSize(rect);
        return rect;
    }

    public static CameraSizeInfo getSortSizeInstance(Context context, int i2, boolean z) {
        if (mSmallSortSize == null || z) {
            mSmallSortSize = getBestSurfaceSize(i2, context);
        }
        return mSmallSortSize;
    }

    public static float getWdivideHRatio(int i2, int i3) {
        return getFormatFloat((((float) i2) * 1.0f) / ((float) i3));
    }

    public static List<CameraSizeInfo> sortOut(List<Camera.Size> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Camera.Size size = list.get(i2);
            arrayList.add(new CameraSizeInfo(size.width, size.height));
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
