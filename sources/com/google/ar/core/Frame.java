package com.google.ar.core;

import android.media.Image;
import android.view.MotionEvent;
import com.google.ar.core.Session;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Frame {
    static final ArrayList<Anchor> ANCHORS_EMPTY_LIST = new ArrayList<>();
    static final ArrayList<Plane> PLANES_EMPTY_LIST = new ArrayList<>();
    private static final String TAG = "ARCore-Frame";
    private final LightEstimate lightEstimate;
    long nativeHandle;
    final Session session;

    Frame(Session session2) {
        this.nativeHandle = 0;
        this.session = session2;
        this.nativeHandle = nativeCreateFrame(session2.nativeHandle);
        this.lightEstimate = new LightEstimate(session2);
    }

    private List<HitResult> convertNativeHitResultsToList(long[] jArr) {
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long hitResult : jArr) {
            HitResult hitResult2 = new HitResult(hitResult, this.session);
            if (hitResult2.getTrackable() != null) {
                arrayList.add(hitResult2);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private boolean isSharedCameraUsed() {
        return this.session.isSharedCameraUsed();
    }

    private native long nativeAcquireCameraImage(long j2, long j3);

    private native long nativeAcquireImageMetadata(long j2, long j3);

    private native long[] nativeAcquireUpdatedAnchors(long j2, long j3);

    private static native long nativeCreateFrame(long j2);

    private static native void nativeDestroyFrame(long j2);

    private native long nativeGetAndroidCameraTimestamp(long j2, long j3);

    private native Pose nativeGetAndroidSensorPose(long j2, long j3);

    private native void nativeGetLightEstimate(long j2, long j3, long j4);

    private native long nativeGetTimestamp(long j2, long j3);

    private native boolean nativeHasDisplayGeometryChanged(long j2, long j3);

    private native void nativeTransformCoordinates2dFloatArrayOrBuffer(long j2, long j3, int i2, Object obj, int i3, Object obj2);

    private native void nativeTransformDisplayUvCoords(long j2, long j3, FloatBuffer floatBuffer, FloatBuffer floatBuffer2);

    public Image acquireCameraImage() {
        return new ArImage(this.session, nativeAcquireCameraImage(this.session.nativeHandle, this.nativeHandle));
    }

    public PointCloud acquirePointCloud() {
        return new PointCloud(this.session, nativeAcquirePointCloud(this.session.nativeHandle, this.nativeHandle));
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        long j2 = this.nativeHandle;
        if (j2 != 0) {
            nativeDestroyFrame(j2);
        }
        super.finalize();
    }

    public long getAndroidCameraTimestamp() {
        return nativeGetAndroidCameraTimestamp(this.session.nativeHandle, this.nativeHandle);
    }

    public Pose getAndroidSensorPose() {
        return nativeGetAndroidSensorPose(this.session.nativeHandle, this.nativeHandle);
    }

    public Camera getCamera() {
        return new Camera(this.session, this);
    }

    public ImageMetadata getImageMetadata() {
        if (!isSharedCameraUsed()) {
            return new ImageMetadata(nativeAcquireImageMetadata(this.session.nativeHandle, this.nativeHandle), this.session);
        }
        throw new IllegalStateException("Metadata access is not available from Frame when shared camera is in use.");
    }

    public LightEstimate getLightEstimate() {
        nativeGetLightEstimate(this.session.nativeHandle, this.nativeHandle, this.lightEstimate.nativeHandle);
        return this.lightEstimate;
    }

    public long getTimestamp() {
        return nativeGetTimestamp(this.session.nativeHandle, this.nativeHandle);
    }

    public Collection<Anchor> getUpdatedAnchors() {
        Session session2 = this.session;
        return session2.convertNativeAnchorsToCollection(nativeAcquireUpdatedAnchors(session2.nativeHandle, this.nativeHandle));
    }

    public <T extends Trackable> Collection<T> getUpdatedTrackables(Class<T> cls) {
        Session.c a2 = Session.c.a(cls);
        if (a2 == Session.c.UNKNOWN_TO_JAVA) {
            return Collections.emptyList();
        }
        return this.session.convertNativeTrackablesToCollection(cls, nativeAcquireUpdatedTrackables(this.session.nativeHandle, this.nativeHandle, a2.f4561b));
    }

    public boolean hasDisplayGeometryChanged() {
        return nativeHasDisplayGeometryChanged(this.session.nativeHandle, this.nativeHandle);
    }

    public List<HitResult> hitTest(float f2, float f3) {
        return convertNativeHitResultsToList(nativeHitTest(this.session.nativeHandle, this.nativeHandle, f2, f3));
    }

    /* access modifiers changed from: package-private */
    public native long nativeAcquirePointCloud(long j2, long j3);

    /* access modifiers changed from: package-private */
    public native long[] nativeAcquireUpdatedTrackables(long j2, long j3, int i2);

    /* access modifiers changed from: package-private */
    public native long[] nativeHitTest(long j2, long j3, float f2, float f3);

    /* access modifiers changed from: package-private */
    public native long[] nativeHitTestRay(long j2, long j3, float[] fArr, int i2, float[] fArr2, int i3);

    public void transformCoordinates2d(Coordinates2d coordinates2d, FloatBuffer floatBuffer, Coordinates2d coordinates2d2, FloatBuffer floatBuffer2) {
        nativeTransformCoordinates2dFloatArrayOrBuffer(this.session.nativeHandle, this.nativeHandle, coordinates2d.nativeCode, floatBuffer, coordinates2d2.nativeCode, floatBuffer2);
    }

    @Deprecated
    public void transformDisplayUvCoords(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!floatBuffer.isDirect() || !floatBuffer2.isDirect()) {
            throw new IllegalArgumentException("transformDisplayUvCoords currently requires direct buffers.");
        }
        nativeTransformDisplayUvCoords(this.session.nativeHandle, this.nativeHandle, floatBuffer, floatBuffer2);
    }

    public void transformCoordinates2d(Coordinates2d coordinates2d, float[] fArr, Coordinates2d coordinates2d2, float[] fArr2) {
        nativeTransformCoordinates2dFloatArrayOrBuffer(this.session.nativeHandle, this.nativeHandle, coordinates2d.nativeCode, fArr, coordinates2d2.nativeCode, fArr2);
    }

    public List<HitResult> hitTest(MotionEvent motionEvent) {
        return hitTest(motionEvent.getX(), motionEvent.getY());
    }

    public List<HitResult> hitTest(float[] fArr, int i2, float[] fArr2, int i3) {
        return convertNativeHitResultsToList(nativeHitTestRay(this.session.nativeHandle, this.nativeHandle, fArr, i2, fArr2, i3));
    }

    protected Frame() {
        this.session = null;
        this.nativeHandle = 0;
        this.lightEstimate = null;
    }
}
