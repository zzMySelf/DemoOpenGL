package com.baidu.wallet.base.camera.internal;

import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.view.SurfaceHolder;
import com.baidu.wallet.base.statistics.DXMSdkSAUtils;
import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class CameraCtrl implements Camera.ErrorCallback, NoProguard {
    public static final int STATE_RAW = 0;
    public static final int TO_STATE_DESTROIED = 8;
    public static final int TO_STATE_INIT = 1;
    public static final int TO_STATE_PAUSED = 4;
    public static final int TO_STATE_STARTED = 2;
    public static final String Tag = CameraCtrl.class.getSimpleName();
    public int _cameraCnt;
    public int _cameraId;
    public b _cameraProxy;
    public int _height;
    public final Method[] _newVersionMethods;
    public Camera.PreviewCallback _previewCb;
    public SurfaceHolder _previewView;
    public int _rotation;
    public int _state;
    public boolean _supportAutoFocus;
    public int _width;

    public enum MethodIndex {
        open,
        getNumberOfCameras,
        setDisplayOrientation
    }

    public static class a {
        public static CameraCtrl a = new CameraCtrl();
    }

    private void doDestroy() {
        if (this._cameraProxy != null) {
            LogUtil.i(Tag, "doDestroy");
            this._cameraProxy.a((Camera.PreviewCallback) null);
            this._cameraProxy.c();
            this._cameraProxy.f();
            reset();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4 = java.lang.Runtime.getRuntime().freeMemory();
        com.baidu.wallet.core.utils.LogUtil.d("freeMemory", r4 + "");
        r5 = (int) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0059, code lost:
        if (r5 <= r0) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005b, code lost:
        r2[r3] = new byte[r5];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
        r2[r3] = new byte[r0];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
        r9._cameraProxy.a(r2[r3]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0075, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void doStart(android.hardware.Camera.PreviewCallback r10) {
        /*
            r9 = this;
            java.lang.String r0 = Tag
            java.lang.String r1 = "doStart"
            com.baidu.wallet.core.utils.LogUtil.i(r0, r1)
            android.hardware.Camera$PreviewCallback r0 = r9._previewCb
            if (r0 != 0) goto L_0x0076
            int r0 = r9._width
            int r1 = r9._height
            int r0 = r0 * r1
            com.baidu.wallet.base.camera.internal.b r1 = r9._cameraProxy
            android.hardware.Camera$Parameters r1 = r1.d()
            int r1 = r1.getPreviewFormat()
            int r1 = android.graphics.ImageFormat.getBitsPerPixel(r1)
            int r0 = r0 * r1
            int r0 = r0 / 8
            r1 = 4
            byte[][] r2 = new byte[r1][]
            r3 = 0
        L_0x0027:
            if (r3 >= r1) goto L_0x0076
            r4 = 0
            r2[r3] = r4
            byte[] r4 = new byte[r0]     // Catch:{ OutOfMemoryError -> 0x003a }
            r2[r3] = r4     // Catch:{ OutOfMemoryError -> 0x003a }
            com.baidu.wallet.base.camera.internal.b r4 = r9._cameraProxy
            r5 = r2[r3]
            r4.a((byte[]) r5)
            goto L_0x006b
        L_0x0038:
            r10 = move-exception
            goto L_0x006e
        L_0x003a:
            java.lang.Runtime r4 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0038 }
            long r4 = r4.freeMemory()     // Catch:{ all -> 0x0038 }
            java.lang.String r6 = "freeMemory"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0038 }
            r7.<init>()     // Catch:{ all -> 0x0038 }
            r7.append(r4)     // Catch:{ all -> 0x0038 }
            java.lang.String r8 = ""
            r7.append(r8)     // Catch:{ all -> 0x0038 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0038 }
            com.baidu.wallet.core.utils.LogUtil.d(r6, r7)     // Catch:{ all -> 0x0038 }
            int r5 = (int) r4     // Catch:{ all -> 0x0038 }
            if (r5 > r0) goto L_0x0060
            byte[] r4 = new byte[r5]     // Catch:{ all -> 0x0038 }
            r2[r3] = r4     // Catch:{ all -> 0x0038 }
            goto L_0x0064
        L_0x0060:
            byte[] r4 = new byte[r0]     // Catch:{ all -> 0x0038 }
            r2[r3] = r4     // Catch:{ all -> 0x0038 }
        L_0x0064:
            com.baidu.wallet.base.camera.internal.b r4 = r9._cameraProxy
            r5 = r2[r3]
            r4.a((byte[]) r5)
        L_0x006b:
            int r3 = r3 + 1
            goto L_0x0027
        L_0x006e:
            com.baidu.wallet.base.camera.internal.b r0 = r9._cameraProxy
            r1 = r2[r3]
            r0.a((byte[]) r1)
            throw r10
        L_0x0076:
            r9._previewCb = r10
            com.baidu.wallet.base.camera.internal.b r0 = r9._cameraProxy
            r0.a((android.hardware.Camera.PreviewCallback) r10)
            android.view.SurfaceHolder r10 = r9._previewView     // Catch:{ IOException -> 0x008a }
            if (r10 != 0) goto L_0x0082
            goto L_0x008e
        L_0x0082:
            com.baidu.wallet.base.camera.internal.b r10 = r9._cameraProxy     // Catch:{ IOException -> 0x008a }
            android.view.SurfaceHolder r0 = r9._previewView     // Catch:{ IOException -> 0x008a }
            r10.a((android.view.SurfaceHolder) r0)     // Catch:{ IOException -> 0x008a }
            goto L_0x008e
        L_0x008a:
            r10 = move-exception
            r10.printStackTrace()
        L_0x008e:
            com.baidu.wallet.base.camera.internal.b r10 = r9._cameraProxy     // Catch:{ Exception -> 0x0094 }
            r10.e()     // Catch:{ Exception -> 0x0094 }
            goto L_0x0098
        L_0x0094:
            r10 = move-exception
            r10.printStackTrace()
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.camera.internal.CameraCtrl.doStart(android.hardware.Camera$PreviewCallback):void");
    }

    public static CameraCtrl getInstance() {
        return a.a;
    }

    private Camera.Size getSimilarRatioSize(int i2, int i3, List<Camera.Size> list, int i4) {
        List<Camera.Size> list2 = list;
        int i5 = i2;
        int i6 = i3;
        if (i5 >= i6) {
            int i7 = i6;
            i6 = i5;
            i5 = i7;
        }
        float f = ((float) i5) / ((float) i6);
        double d = Double.MAX_VALUE;
        Camera.Size size = null;
        sortSize(list2);
        ListIterator<Camera.Size> listIterator = list.listIterator();
        String str = Tag;
        LogUtil.i(str, "sorted getSimilarRatioSize(" + i6 + i5 + ") ; expectRatio = " + f);
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            Camera.Size next = listIterator.next();
            LogUtil.i(Tag, String.format("supported picture size:(%d,%d)", new Object[]{Integer.valueOf(next.width), Integer.valueOf(next.height)}));
            if (next.width == i6 && next.height == i5) {
                size = next;
                break;
            }
            int i8 = next.width;
            double d2 = ((double) next.height) / ((double) i8);
            LogUtil.i(Tag, String.format("supported picture size:(%d,%d);ratio:%f", new Object[]{Integer.valueOf(i8), Integer.valueOf(next.height), Double.valueOf(d2)}));
            double abs = Math.abs(((double) f) - d2);
            if (d > abs && 400 < next.height) {
                size = next;
                d = abs;
            }
        }
        if (size != null) {
            return size;
        }
        Camera.Size size2 = list2.get(list.size() - 1);
        StringBuilder sb = new StringBuilder(size2.width);
        sb.append(",");
        sb.append(size2.height);
        DXMSdkSAUtils.onEventWithValues("sdk_self_define_camera_get_size", Arrays.asList(new String[]{String.valueOf(i4), sb.toString()}));
        return size2;
    }

    public static boolean isSupprtFlashLight(PackageManager packageManager) {
        FeatureInfo[] systemAvailableFeatures = packageManager.getSystemAvailableFeatures();
        if (systemAvailableFeatures == null) {
            return false;
        }
        for (FeatureInfo featureInfo : systemAvailableFeatures) {
            if ("android.hardware.camera.flash".equals(featureInfo.name)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0160, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004d A[Catch:{ Exception -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065 A[Catch:{ Exception -> 0x0121 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092 A[SYNTHETIC, Splitter:B:26:0x0092] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean openCamera(int r8, int r9, int r10, int r11, int r12, int r13) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.baidu.wallet.base.camera.internal.b r0 = r7._cameraProxy     // Catch:{ all -> 0x0161 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x014d
            com.baidu.wallet.base.camera.internal.b r0 = com.baidu.wallet.base.camera.internal.b.a()     // Catch:{ Exception -> 0x0143 }
            r7._cameraProxy = r0     // Catch:{ Exception -> 0x0143 }
            r0 = -1
            if (r0 == r8) goto L_0x0036
            boolean r0 = r7.isSupportMultiCamera()     // Catch:{ Exception -> 0x0143 }
            if (r0 != 0) goto L_0x0017
            goto L_0x0036
        L_0x0017:
            com.baidu.wallet.base.camera.internal.b r0 = r7._cameraProxy     // Catch:{ Exception -> 0x0143 }
            java.lang.reflect.Method[] r3 = r7._newVersionMethods     // Catch:{ Exception -> 0x0143 }
            com.baidu.wallet.base.camera.internal.CameraCtrl$MethodIndex r4 = com.baidu.wallet.base.camera.internal.CameraCtrl.MethodIndex.open     // Catch:{ Exception -> 0x0143 }
            int r4 = r4.ordinal()     // Catch:{ Exception -> 0x0143 }
            r3 = r3[r4]     // Catch:{ Exception -> 0x0143 }
            java.lang.Class<android.hardware.Camera> r4 = android.hardware.Camera.class
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0143 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0143 }
            r5[r2] = r6     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r3 = r3.invoke(r4, r5)     // Catch:{ Exception -> 0x0143 }
            android.hardware.Camera r3 = (android.hardware.Camera) r3     // Catch:{ Exception -> 0x0143 }
            r0.a = r3     // Catch:{ Exception -> 0x0143 }
            goto L_0x003b
        L_0x0036:
            com.baidu.wallet.base.camera.internal.b r0 = r7._cameraProxy     // Catch:{ Exception -> 0x0143 }
            r0.b()     // Catch:{ Exception -> 0x0143 }
        L_0x003b:
            com.baidu.wallet.base.camera.internal.b r0 = r7._cameraProxy     // Catch:{ all -> 0x0161 }
            android.hardware.Camera$Parameters r0 = r0.d()     // Catch:{ all -> 0x0161 }
            java.lang.String r3 = r0.getFocusMode()     // Catch:{ all -> 0x0161 }
            java.lang.String r4 = "auto"
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0161 }
            if (r4 != 0) goto L_0x0058
            java.lang.String r4 = "macro"
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0161 }
            if (r3 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0056:
            r3 = 0
            goto L_0x0059
        L_0x0058:
            r3 = 1
        L_0x0059:
            r7._supportAutoFocus = r3     // Catch:{ all -> 0x0161 }
            java.util.List r3 = r0.getSupportedPreviewSizes()     // Catch:{ all -> 0x0161 }
            android.hardware.Camera$Size r3 = r7.getSimilarRatioSize(r9, r10, r3, r2)     // Catch:{ all -> 0x0161 }
            if (r3 != 0) goto L_0x0092
            com.baidu.wallet.base.camera.internal.b r8 = r7._cameraProxy     // Catch:{ all -> 0x0161 }
            r8.f()     // Catch:{ all -> 0x0161 }
            r8 = 0
            r7._cameraProxy = r8     // Catch:{ all -> 0x0161 }
            java.lang.String r11 = Tag     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            r12.<init>()     // Catch:{ all -> 0x0161 }
            java.lang.String r13 = "fail to get a proximate preivew size("
            r12.append(r13)     // Catch:{ all -> 0x0161 }
            r12.append(r9)     // Catch:{ all -> 0x0161 }
            java.lang.String r9 = ","
            r12.append(r9)     // Catch:{ all -> 0x0161 }
            r12.append(r10)     // Catch:{ all -> 0x0161 }
            java.lang.String r9 = ")."
            r12.append(r9)     // Catch:{ all -> 0x0161 }
            java.lang.String r9 = r12.toString()     // Catch:{ all -> 0x0161 }
            com.baidu.wallet.core.utils.LogUtil.e(r11, r9, r8)     // Catch:{ all -> 0x0161 }
            monitor-exit(r7)
            return r2
        L_0x0092:
            java.lang.String r4 = Tag     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            r5.<init>()     // Catch:{ all -> 0x0161 }
            java.lang.String r6 = "set preview size to widht = "
            r5.append(r6)     // Catch:{ all -> 0x0161 }
            int r6 = r3.width     // Catch:{ all -> 0x0161 }
            r5.append(r6)     // Catch:{ all -> 0x0161 }
            java.lang.String r6 = " , height = "
            r5.append(r6)     // Catch:{ all -> 0x0161 }
            int r6 = r3.height     // Catch:{ all -> 0x0161 }
            r5.append(r6)     // Catch:{ all -> 0x0161 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0161 }
            com.baidu.wallet.core.utils.LogUtil.i(r4, r5)     // Catch:{ all -> 0x0161 }
            int r4 = r3.width     // Catch:{ all -> 0x0161 }
            r7._width = r4     // Catch:{ all -> 0x0161 }
            int r3 = r3.height     // Catch:{ all -> 0x0161 }
            r7._height = r3     // Catch:{ all -> 0x0161 }
            r0.setPreviewSize(r4, r3)     // Catch:{ all -> 0x0161 }
            java.util.List r3 = r0.getSupportedPictureSizes()     // Catch:{ all -> 0x0161 }
            android.hardware.Camera$Size r9 = r7.getSimilarRatioSize(r9, r10, r3, r1)     // Catch:{ all -> 0x0161 }
            if (r9 == 0) goto L_0x00f2
            int r10 = r9.width     // Catch:{ all -> 0x0161 }
            int r3 = r9.height     // Catch:{ all -> 0x0161 }
            r0.setPictureSize(r10, r3)     // Catch:{ all -> 0x0161 }
            java.lang.String r10 = Tag     // Catch:{ all -> 0x0161 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0161 }
            r3.<init>()     // Catch:{ all -> 0x0161 }
            java.lang.String r4 = "set picture size to width = "
            r3.append(r4)     // Catch:{ all -> 0x0161 }
            int r4 = r9.width     // Catch:{ all -> 0x0161 }
            r3.append(r4)     // Catch:{ all -> 0x0161 }
            java.lang.String r4 = " , height = "
            r3.append(r4)     // Catch:{ all -> 0x0161 }
            int r9 = r9.height     // Catch:{ all -> 0x0161 }
            r3.append(r9)     // Catch:{ all -> 0x0161 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x0161 }
            com.baidu.wallet.core.utils.LogUtil.i(r10, r9)     // Catch:{ all -> 0x0161 }
        L_0x00f2:
            r0.setPreviewFormat(r12)     // Catch:{ IllegalArgumentException -> 0x0139 }
            r9 = 9
            int r10 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0161 }
            if (r9 <= r10) goto L_0x00fe
            r0.setPreviewFrameRate(r13)     // Catch:{ all -> 0x0161 }
        L_0x00fe:
            com.baidu.wallet.base.camera.internal.b r9 = r7._cameraProxy     // Catch:{ Exception -> 0x012d }
            r9.a((android.hardware.Camera.Parameters) r0)     // Catch:{ Exception -> 0x012d }
            java.lang.reflect.Method[] r9 = r7._newVersionMethods     // Catch:{ all -> 0x0161 }
            com.baidu.wallet.base.camera.internal.CameraCtrl$MethodIndex r10 = com.baidu.wallet.base.camera.internal.CameraCtrl.MethodIndex.setDisplayOrientation     // Catch:{ all -> 0x0161 }
            int r10 = r10.ordinal()     // Catch:{ all -> 0x0161 }
            r9 = r9[r10]     // Catch:{ all -> 0x0161 }
            if (r9 == 0) goto L_0x0129
            com.baidu.wallet.base.camera.internal.b r10 = r7._cameraProxy     // Catch:{ Exception -> 0x0121 }
            android.hardware.Camera r10 = r10.a     // Catch:{ Exception -> 0x0121 }
            java.lang.Object[] r12 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0121 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x0121 }
            r12[r2] = r13     // Catch:{ Exception -> 0x0121 }
            r9.invoke(r10, r12)     // Catch:{ Exception -> 0x0121 }
            r7._rotation = r11     // Catch:{ Exception -> 0x0121 }
            goto L_0x0129
        L_0x0121:
            r9 = move-exception
            java.lang.String r10 = Tag     // Catch:{ all -> 0x0161 }
            java.lang.String r11 = ""
            com.baidu.wallet.core.utils.LogUtil.e(r10, r11, r9)     // Catch:{ all -> 0x0161 }
        L_0x0129:
            r7._cameraId = r8     // Catch:{ all -> 0x0161 }
            monitor-exit(r7)
            return r1
        L_0x012d:
            r8 = move-exception
            java.lang.String r9 = Tag     // Catch:{ all -> 0x0161 }
            java.lang.String r10 = r0.toString()     // Catch:{ all -> 0x0161 }
            com.baidu.wallet.core.utils.LogUtil.e(r9, r10, r8)     // Catch:{ all -> 0x0161 }
            monitor-exit(r7)
            return r2
        L_0x0139:
            r8 = move-exception
            java.lang.String r9 = Tag     // Catch:{ all -> 0x0161 }
            java.lang.String r10 = "failed to openCamera:"
            com.baidu.wallet.core.utils.LogUtil.e(r9, r10, r8)     // Catch:{ all -> 0x0161 }
            monitor-exit(r7)
            return r2
        L_0x0143:
            r8 = move-exception
            java.lang.String r9 = Tag     // Catch:{ all -> 0x0161 }
            java.lang.String r10 = "The camera is in use"
            com.baidu.wallet.core.utils.LogUtil.e(r9, r10, r8)     // Catch:{ all -> 0x0161 }
            monitor-exit(r7)
            return r2
        L_0x014d:
            int r12 = r7._cameraId     // Catch:{ all -> 0x0161 }
            if (r8 != r12) goto L_0x015e
            int r8 = r7._width     // Catch:{ all -> 0x0161 }
            if (r9 != r8) goto L_0x015e
            int r8 = r7._rotation     // Catch:{ all -> 0x0161 }
            if (r11 != r8) goto L_0x015e
            int r8 = r7._height     // Catch:{ all -> 0x0161 }
            if (r10 != r8) goto L_0x015e
            goto L_0x015f
        L_0x015e:
            r1 = 0
        L_0x015f:
            monitor-exit(r7)
            return r1
        L_0x0161:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.wallet.base.camera.internal.CameraCtrl.openCamera(int, int, int, int, int, int):boolean");
    }

    private boolean setState(int i2) {
        if (2 == i2) {
            if ((this._state & 7) == 0) {
                return false;
            }
        } else if (4 == i2) {
            if ((this._state & 6) == 0) {
                return false;
            }
        } else if (1 == i2) {
            int i3 = this._state;
            if (!(i3 == 0 || 8 == i3)) {
                return false;
            }
        } else if (8 != i2) {
            return false;
        }
        this._state = i2;
        String str = Tag;
        LogUtil.i(str, "setState(" + this._state + ") succeed.");
        return true;
    }

    private void sortSize(List<Camera.Size> list) {
        Collections.sort(list, new Comparator<Camera.Size>() {
            /* renamed from: a */
            public int compare(Camera.Size size, Camera.Size size2) {
                int i2 = size.width;
                int i3 = size2.width;
                if (i2 > i3) {
                    return 1;
                }
                if (i2 < i3) {
                    return -1;
                }
                if (i2 != i3) {
                    return 0;
                }
                int i4 = size.height;
                int i5 = size2.height;
                if (i4 > i5) {
                    return 1;
                }
                if (i4 < i5) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public b camera() {
        return this._cameraProxy;
    }

    public synchronized void destroy() {
        String str = Tag;
        LogUtil.i(str, "destroy:stat=" + this._state);
        if (setState(8)) {
            doDestroy();
        }
    }

    public int getCameraCount() {
        int i2 = this._cameraCnt;
        if (-1 != i2) {
            return i2;
        }
        if (this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] == null) {
            return 1;
        }
        try {
            int intValue = ((Integer) this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()].invoke(Camera.class, new Object[0])).intValue();
            this._cameraCnt = intValue;
            i2 = intValue;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        if (-1 == i2) {
            return 0;
        }
        return i2;
    }

    public int getCurrentZoom() {
        b bVar;
        if (!isSupportZoom() || (bVar = this._cameraProxy) == null) {
            return 0;
        }
        return bVar.d().getZoom();
    }

    public int getMaxZoom() {
        b bVar;
        if (!isSupportZoom() || (bVar = this._cameraProxy) == null) {
            return 0;
        }
        return bVar.d().getMaxZoom();
    }

    public synchronized int getPreviewHeight() {
        return this._height;
    }

    public synchronized int getPreviewWidht() {
        return this._width;
    }

    public synchronized boolean init(int i2, int i3, int i4, int i5, int i6, int i7) {
        String str = Tag;
        LogUtil.i(str, "init:state=" + this._state);
        if (!setState(1)) {
            return false;
        }
        this._previewCb = null;
        return openCamera(i2, i3, i4, i5, i6, i7);
    }

    public boolean isFlashOn() {
        if ((this._state & 6) == 0) {
            return false;
        }
        return "torch".equals(this._cameraProxy.d().getFlashMode());
    }

    public boolean isSupportAutoFocus() {
        return this._supportAutoFocus;
    }

    public boolean isSupportMultiCamera() {
        if (9 <= Build.VERSION.SDK_INT && this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] != null && getCameraCount() > 1) {
            return true;
        }
        return false;
    }

    public boolean isSupportZoom() {
        b bVar = this._cameraProxy;
        if (bVar != null) {
            return bVar.d().isZoomSupported();
        }
        return false;
    }

    public void onError(int i2, Camera camera) {
        String str = Tag;
        LogUtil.e(str, "camera error: " + i2, (Throwable) null);
    }

    public synchronized void pause() {
        if (setState(4)) {
            this._cameraProxy.c();
        }
    }

    public void reset() {
        this._cameraProxy = null;
        this._previewCb = null;
        this._previewView = null;
        this._rotation = -1;
        this._height = -1;
        this._width = -1;
        this._cameraId = -1;
        this._state = 0;
    }

    public boolean setFlashOn(boolean z) {
        Camera.Parameters d;
        String flashMode;
        if ((this._state & 6) == 0 || (flashMode = d.getFlashMode()) == null) {
            return false;
        }
        String str = z ? "torch" : "off";
        if (str.equals(flashMode)) {
            return true;
        }
        (d = this._cameraProxy.d()).setFlashMode(str);
        try {
            this._cameraProxy.a(d);
            return true;
        } catch (Exception e) {
            LogUtil.e(Tag, "setFlashOn()", e);
            return false;
        }
    }

    public void setPreviewDisplay(SurfaceHolder surfaceHolder) {
        if (this._previewView == null && surfaceHolder != null) {
            try {
                this._cameraProxy.a(surfaceHolder);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setZoom(int i2) {
        b bVar = this._cameraProxy;
        if (bVar != null) {
            Camera.Parameters d = bVar.d();
            if (isSupportZoom() && d.getZoom() != i2) {
                d.setZoom(i2);
                this._cameraProxy.a(d);
            }
        }
    }

    public synchronized void start(Camera.PreviewCallback previewCallback, SurfaceHolder surfaceHolder) {
        String str = Tag;
        LogUtil.i(str, "start:stat=" + this._state);
        if (previewCallback == null) {
            LogUtil.w(Tag, "Can not start a camera with a null preview-callback");
        } else if (previewCallback == this._previewCb && surfaceHolder == this._previewView && 2 == this._state) {
            LogUtil.w(Tag, "The camera already started.");
        } else if (setState(2)) {
            this._previewView = surfaceHolder;
            doStart(previewCallback);
        }
    }

    public boolean trigerFlash() {
        if ((this._state & 6) == 0) {
            return false;
        }
        this._cameraProxy.c();
        Camera.Parameters d = this._cameraProxy.d();
        if ("torch".equals(d.getFlashMode())) {
            d.setFlashMode("off");
        } else {
            d.setFlashMode("torch");
        }
        try {
            this._cameraProxy.a(d);
            this._cameraProxy.e();
            return true;
        } catch (Exception unused) {
            this._cameraProxy.e();
            return false;
        }
    }

    public CameraCtrl() {
        this._cameraProxy = null;
        this._cameraCnt = -1;
        this._supportAutoFocus = false;
        this._previewView = null;
        this._state = 0;
        reset();
        this._newVersionMethods = new Method[MethodIndex.values().length];
        int i2 = 0;
        while (true) {
            Method[] methodArr = this._newVersionMethods;
            if (i2 < methodArr.length) {
                methodArr[i2] = null;
                i2++;
            } else {
                try {
                    Class[] clsArr = {Integer.TYPE};
                    methodArr[MethodIndex.open.ordinal()] = Camera.class.getMethod("open", clsArr);
                    this._newVersionMethods[MethodIndex.setDisplayOrientation.ordinal()] = Camera.class.getMethod("setDisplayOrientation", clsArr);
                    this._newVersionMethods[MethodIndex.getNumberOfCameras.ordinal()] = Camera.class.getMethod("getNumberOfCameras", (Class[]) null);
                    return;
                } catch (NoSuchMethodException e) {
                    LogUtil.e(Tag, "determine method: ", e);
                    return;
                }
            }
        }
    }
}
