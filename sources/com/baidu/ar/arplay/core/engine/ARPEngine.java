package com.baidu.ar.arplay.core.engine;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.baidu.ar.arplay.core.engine.ARPContent;
import com.baidu.ar.arplay.core.engine.ARPDataInteraction;
import com.baidu.ar.arplay.core.engine.engine3d.AbstractARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPEngine3D;
import com.baidu.ar.arplay.core.engine.engine3d.IARPScene;
import com.baidu.ar.arplay.core.renderer.ARPFilter;
import com.baidu.ar.arplay.core.renderer.ARPRenderer;
import com.baidu.ar.arplay.core.renderer.IARPRenderer;
import com.baidu.ar.arplay.util.LogUtil;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ARPEngine {
    private static final String ENGINE_3D_CLASS_NAME = "com.baidu.ar.arplay.core.engine3d.ARPEngine3D";
    private static final String LOWEST_VERSION_KEY = "compatible_version";
    private static final String TAG = "ARPEngine";
    private static ARPEngine self;
    private ARPContent mARPContent = new ARPContent();
    private ARPDataInteraction mARPDataInteraction;
    private AbstractARPEngine3D mARPEngine3D;
    private ARPEngineParams mARPEngineParams;
    private ARPFilter mARPFilter = new ARPFilter();
    private ARPRenderer mARPRenderer = new ARPRenderer();
    private volatile boolean mIsEngineCreated = false;
    private boolean mIsInitNative = false;
    private boolean mIsPaused = false;
    boolean mScenePausedByUser;

    private ARPEngine() {
        ARPDataInteraction aRPDataInteraction = new ARPDataInteraction();
        this.mARPDataInteraction = aRPDataInteraction;
        this.mARPContent.registerCaseLoadListener(aRPDataInteraction);
        initEngine3DInstance();
    }

    private boolean createApp(int i2, int i3, int i4, int i5, float f2, String str) {
        LogUtil.b(TAG, "createApp [width*height]: [" + i2 + "*" + i3 + RhetoricalTagUtilKt.TAG_END_SYMBOL);
        boolean nativeCreateApp = nativeCreateApp(i2, i3, i4, i5, f2, str);
        this.mIsEngineCreated = true;
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.setEngineCreated(this.mIsEngineCreated);
        }
        return nativeCreateApp;
    }

    public static synchronized ARPEngine getInstance() {
        ARPEngine aRPEngine;
        synchronized (ARPEngine.class) {
            if (self == null) {
                self = new ARPEngine();
            }
            aRPEngine = self;
        }
        return aRPEngine;
    }

    private void initEngine3DInstance() {
        try {
            Object newInstance = Class.forName(ENGINE_3D_CLASS_NAME).newInstance();
            if (newInstance instanceof IARPEngine3D) {
                this.mARPEngine3D = (AbstractARPEngine3D) newInstance;
            }
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (InstantiationException e4) {
            e4.printStackTrace();
        }
    }

    public static native boolean libraryHasLoaded();

    private native boolean nativeSetup(Object obj, String str);

    public static synchronized void releaseInstance() {
        synchronized (ARPEngine.class) {
            ARPEngine aRPEngine = self;
            if (aRPEngine != null) {
                aRPEngine.destroy();
            }
            self = null;
        }
    }

    public void addAlgoType(int[] iArr, int i2) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.addAlgoType(iArr, i2);
        }
    }

    public String adjustFilterWithCasePathParam(String str) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter == null) {
            return null;
        }
        aRPFilter.adjustFilterWithCasePathParam(str);
        return null;
    }

    public void adjustFilterWithFloatArrayParam(String str, String str2, float[] fArr, long j2) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithFloatArrayParam(str, str2, fArr, j2);
        }
    }

    public void adjustFilterWithFloatParam(String str, String str2, float f2, long j2) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithFloatParam(str, str2, f2, j2);
        }
    }

    public void adjustFilterWithIntParam(String str, String str2, int i2, long j2) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithIntParam(str, str2, i2, j2);
        }
    }

    public String adjustFilterWithJsonPathParam(String str) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            return aRPFilter.adjustFilterWithJsonPathParam(str);
        }
        return null;
    }

    public void adjustFilterWithStringParam(String str, String str2, String str3, long j2) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.adjustFilterWithStringParam(str, str2, str3, j2);
        }
    }

    public void clearARMemory() {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.clearARMemory();
        }
    }

    public void clearAlgoCache() {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.clearAlgoCache();
        }
    }

    public boolean createEngine(ARPEngineParams aRPEngineParams) {
        synchronized (this) {
            boolean z = false;
            if (aRPEngineParams == null) {
                return false;
            }
            this.mARPEngineParams = aRPEngineParams;
            if (!this.mIsInitNative) {
                z = nativeSetup(new WeakReference(this), "5.1.4");
                this.mIsInitNative = true;
            }
            if (!this.mIsEngineCreated) {
                z = createApp(this.mARPEngineParams.getInputWidth(), this.mARPEngineParams.getInputHeight(), this.mARPEngineParams.getOutputWidth(), this.mARPEngineParams.getOutputHeight(), this.mARPEngineParams.getDensity(), this.mARPEngineParams.getShaderDBPath());
                ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
                if (aRPDataInteraction != null) {
                    aRPDataInteraction.setup();
                }
            }
            AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
            if (abstractARPEngine3D != null) {
                abstractARPEngine3D.setIsActiveByARPlayVersionCase(isDriverdByARPVersion());
            }
            this.mARPContent.setIsFrontCamera(this.mARPEngineParams.isIsFrontCamera());
            return z;
        }
    }

    public synchronized void destroy() {
        LogUtil.b(TAG, "destroy");
        ARPRenderer aRPRenderer = this.mARPRenderer;
        if (aRPRenderer != null) {
            aRPRenderer.destroy();
        }
    }

    public synchronized void destroyEngine() {
        LogUtil.b(TAG, "destroyEngine");
        this.mIsEngineCreated = false;
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.destroy();
        }
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.setEngineCreated(this.mIsEngineCreated);
            this.mARPContent.destroy();
        }
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.destroy();
        }
        nativeSetEngineBlendState(0);
        nativeDestroyEngine();
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.destroy();
        }
    }

    public void destroyMockAlgoHandle(long j2) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.destroyMockAlgoHandle(j2);
        }
    }

    public void disableCaseLutTexture() {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.disableCaseLutTexture();
        }
    }

    public void disableFilterByAuthCode(int i2) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.disableFilterByAuthCode(i2);
        }
    }

    public IARPRenderer getARPRenderer() {
        return this.mARPRenderer;
    }

    public IARPScene getCurrentScene() {
        AbstractARPEngine3D abstractARPEngine3D;
        if (isEngineCanAccess() && (abstractARPEngine3D = this.mARPEngine3D) != null) {
            return abstractARPEngine3D.getCurrentScene();
        }
        return null;
    }

    public float[] getWindowSize() {
        ARPContent aRPContent = this.mARPContent;
        return aRPContent != null ? aRPContent.getWindowSize() : new float[0];
    }

    public void initDataStore(SharedPreferences sharedPreferences) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.initDataStore(sharedPreferences);
        }
    }

    public void initWorldAxis() {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.initWorldAxis();
        }
    }

    public boolean isAppControllerInterrupt() {
        return nativeIsAppControllerInterrupt();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        r0 = (java.lang.String) r0.get(LOWEST_VERSION_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isDriverdByARPVersion() {
        /*
            r4 = this;
            com.baidu.ar.arplay.core.engine.ARPScriptEnvironment r0 = com.baidu.ar.arplay.core.engine.ARPScriptEnvironment.getInstance()
            java.lang.String r1 = "caseinfo"
            java.lang.Object r0 = r0.getSharedEnvironmentValue(r1)
            r1 = 0
            if (r0 == 0) goto L_0x0033
            boolean r2 = r0 instanceof java.util.HashMap
            if (r2 == 0) goto L_0x0033
            java.util.HashMap r0 = (java.util.HashMap) r0
            java.lang.String r2 = "compatible_version"
            java.lang.Object r3 = r0.get(r2)
            boolean r3 = r3 instanceof java.lang.String
            if (r3 == 0) goto L_0x0033
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = ""
            if (r0 != r2) goto L_0x0028
            return r1
        L_0x0028:
            java.lang.String r2 = "2.0.0"
            int r0 = r0.compareTo(r2)
            if (r0 >= 0) goto L_0x0031
            return r1
        L_0x0031:
            r0 = 1
            return r0
        L_0x0033:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.arplay.core.engine.ARPEngine.isDriverdByARPVersion():boolean");
    }

    public boolean isEngineCanAccess() {
        return this.mIsEngineCreated && this.mARPContent.isCaseCreated();
    }

    public boolean isPaused() {
        return this.mIsPaused;
    }

    public synchronized int loadCaseWithResPath(String str) {
        ARPRenderer aRPRenderer;
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent == null || (aRPRenderer = this.mARPRenderer) == null) {
            return -1;
        }
        return aRPContent.loadCaseWithResPath(str, aRPRenderer.getCameraPreviewWidth(), this.mARPRenderer.getCameraPreviewHeight());
    }

    public synchronized void loadTempleteWithResPath(String str) {
        ARPRenderer aRPRenderer;
        ARPContent aRPContent = this.mARPContent;
        if (!(aRPContent == null || (aRPRenderer = this.mARPRenderer) == null)) {
            aRPContent.loadTempleteWithResPath(str, aRPRenderer.getCameraPreviewWidth(), this.mARPRenderer.getCameraPreviewHeight());
        }
    }

    public long mockFaceAlgoHandle(long j2, float[] fArr) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            return aRPDataInteraction.mockFaceAlgoHandle(j2, fArr);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public native boolean nativeCreateApp(int i2, int i3, int i4, int i5, float f2, String str);

    /* access modifiers changed from: package-private */
    public native void nativeDestroyEngine();

    /* access modifiers changed from: package-private */
    public native boolean nativeIsAppControllerInterrupt();

    /* access modifiers changed from: package-private */
    public native void nativeOnPause();

    /* access modifiers changed from: package-private */
    public native void nativeOnResume();

    /* access modifiers changed from: package-private */
    public native void nativeSetConfig(String str, String str2);

    /* access modifiers changed from: package-private */
    public native void nativeSetEngineBlendState(int i2);

    /* access modifiers changed from: package-private */
    public native void nativeSetLocalDeviceGrade(int i2);

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onCaseLoadCompleted(java.util.Map r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r3 != 0) goto L_0x0005
            monitor-exit(r2)
            return
        L_0x0005:
            com.baidu.ar.arplay.core.engine.engine3d.AbstractARPEngine3D r0 = r2.mARPEngine3D     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0010
            boolean r1 = r2.isDriverdByARPVersion()     // Catch:{ all -> 0x0031 }
            r0.setIsActiveByARPlayVersionCase(r1)     // Catch:{ all -> 0x0031 }
        L_0x0010:
            com.baidu.ar.arplay.core.engine.ARPContent r0 = r2.mARPContent     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0028
            com.baidu.ar.arplay.core.engine.ARPContent$c r1 = com.baidu.ar.arplay.core.engine.ARPContent.c.OnCaseLoaded     // Catch:{ all -> 0x0031 }
            boolean r0 = r0.checkValid(r1)     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0028
            com.baidu.ar.arplay.core.renderer.ARPRenderer r0 = r2.mARPRenderer     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0023
            r0.clearAllAsyncRenderTask()     // Catch:{ all -> 0x0031 }
        L_0x0023:
            com.baidu.ar.arplay.core.engine.ARPContent r0 = r2.mARPContent     // Catch:{ all -> 0x0031 }
            r0.onCaseLoadCompleted(r3)     // Catch:{ all -> 0x0031 }
        L_0x0028:
            boolean r3 = r2.mIsPaused     // Catch:{ all -> 0x0031 }
            if (r3 == 0) goto L_0x002f
            r2.nativeOnPause()     // Catch:{ all -> 0x0031 }
        L_0x002f:
            monitor-exit(r2)
            return
        L_0x0031:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.arplay.core.engine.ARPEngine.onCaseLoadCompleted(java.util.Map):void");
    }

    public void onCaseUnloadCompleted() {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.onCaseUnloadCompleted();
        }
    }

    public void onGestureUpdate(int i2, long j2, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, int i5, float f10) {
        ARPDataInteraction aRPDataInteraction;
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onGestureUpdate(i2, j2, i3, f2, f3, f4, f5, i4, f6, f7, f8, f9, i5, f10);
        }
    }

    public void onGestureUpdateWithScaleFinish(int i2, long j2, int i3, float f2, float f3, float f4, float f5, int i4, float f6, float f7, float f8, float f9, int i5, float f10, boolean z) {
        ARPDataInteraction aRPDataInteraction;
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onGestureUpdateWithScaleFinish(i2, j2, i3, f2, f3, f4, f5, i4, f6, f7, f8, f9, i5, f10, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onTempleLoadCompleted(java.util.Map r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 != 0) goto L_0x0005
            monitor-exit(r1)
            return
        L_0x0005:
            com.baidu.ar.arplay.core.engine.ARPContent r0 = r1.mARPContent     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            com.baidu.ar.arplay.core.renderer.ARPRenderer r0 = r1.mARPRenderer     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0010
            r0.clearAllAsyncRenderTask()     // Catch:{ all -> 0x0017 }
        L_0x0010:
            com.baidu.ar.arplay.core.engine.ARPContent r0 = r1.mARPContent     // Catch:{ all -> 0x0017 }
            r0.onTempleLoadCompleted(r2)     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r1)
            return
        L_0x0017:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.ar.arplay.core.engine.ARPEngine.onTempleLoadCompleted(java.util.Map):void");
    }

    public void onTouchUpdate(int i2, float f2, float f3, float f4, float f5, long j2, int i3, float f6) {
        ARPDataInteraction aRPDataInteraction;
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.onTouchUpdate(i2, f2, f3, f4, f5, j2, i3, f6);
        }
    }

    public synchronized void pause() {
        this.mIsPaused = true;
        if (isEngineCanAccess()) {
            nativeOnPause();
        }
        ARPRenderer aRPRenderer = this.mARPRenderer;
        if (aRPRenderer != null) {
            aRPRenderer.pause();
        }
    }

    public synchronized void pauseScene() {
        this.mIsPaused = true;
        if (isEngineCanAccess()) {
            nativeOnPause();
        }
        this.mScenePausedByUser = true;
    }

    public void removeAlgoType(int[] iArr) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.removeAlgoType(iArr);
        }
    }

    public synchronized void resume() {
        if (!this.mScenePausedByUser) {
            resumeScene();
        }
        ARPRenderer aRPRenderer = this.mARPRenderer;
        if (aRPRenderer != null) {
            aRPRenderer.resume();
        }
    }

    public synchronized void resumeScene() {
        this.mIsPaused = false;
        if (isEngineCanAccess()) {
            nativeOnResume();
        }
        this.mScenePausedByUser = false;
    }

    public void sceneRotateToCamera() {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.sceneRotateToCamera();
        }
    }

    public void sceneWorldPositionToOrigin() {
        AbstractARPEngine3D abstractARPEngine3D = this.mARPEngine3D;
        if (abstractARPEngine3D != null) {
            abstractARPEngine3D.sceneWorldPositionToOrigin();
        }
    }

    public synchronized void setAlgoDataHandle(long j2) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setAlgoDataHandle(j2);
        }
    }

    public void setAuthPic(Bitmap bitmap, float[] fArr) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.setAuthPic(bitmap, fArr);
        }
    }

    public void setConfig(String str, String str2) {
        LogUtil.b(TAG, "syncServerConfig :" + str2);
        nativeSetConfig(str, str2);
    }

    public void setContext(SoftReference<Context> softReference) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.setContext(softReference);
        }
    }

    public void setEngineBlendState(int i2) {
        nativeSetEngineBlendState(i2);
    }

    public void setFaceLandMarkFrameAcheMode(int i2) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setFaceLandMarkFrameAcheMode(i2);
        }
    }

    public synchronized void setHtmlUpdateCallback(ARPDataInteraction.a aVar) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setHtmlUpdateCallback(aVar);
        }
    }

    public void setInteraction(ARPDataInteraction.b bVar) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setInteraction(bVar);
        }
    }

    public void setIsFrontCamera(boolean z) {
        this.mARPContent.setIsFrontCamera(z);
    }

    public void setLocalDeviceGrade(int i2) {
        LogUtil.b(TAG, "setLocalDeviceGrade :" + i2);
        nativeSetLocalDeviceGrade(i2);
    }

    public void setPreviewSize(int i2, int i3) {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.setPreviewSize(i2, i3);
        }
    }

    public synchronized void setVideoUpdateCallback(ARPDataInteraction.c cVar) {
        ARPDataInteraction aRPDataInteraction = this.mARPDataInteraction;
        if (aRPDataInteraction != null) {
            aRPDataInteraction.setVideoUpdateCallback(cVar);
        }
    }

    public void setWatermark(String str, Bitmap bitmap, float[] fArr) {
        ARPFilter aRPFilter = this.mARPFilter;
        if (aRPFilter != null) {
            aRPFilter.setWatermark(str, bitmap, fArr);
        }
    }

    public void setWindowSize(int i2, int i3) {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null) {
            aRPContent.setWindowSize(i2, i3);
        }
    }

    public synchronized void unloadCase() {
        ARPContent aRPContent = this.mARPContent;
        if (aRPContent != null && aRPContent.checkValid(ARPContent.c.UnloadCase)) {
            ARPRenderer aRPRenderer = this.mARPRenderer;
            if (aRPRenderer != null) {
                aRPRenderer.clearAllAsyncRenderTask();
            }
            this.mARPContent.unloadCase();
        }
    }

    public synchronized void unloadTemplete() {
        LogUtil.b(TAG, "unloadTemplete");
        this.mARPContent.unloadTemplete();
    }

    public void updateAlgoDataToNode(int i2, int i3, byte[] bArr) {
        ARPDataInteraction aRPDataInteraction;
        LogUtil.a(TAG, "updateAlgoDataToNode");
        if (isEngineCanAccess() && (aRPDataInteraction = this.mARPDataInteraction) != null) {
            aRPDataInteraction.updateAlgoDataToNode(i2, i3, bArr);
        }
    }

    public void updateNodeUniform(String str, HashMap<String, Object> hashMap) {
        AbstractARPEngine3D abstractARPEngine3D;
        if (isEngineCanAccess() && !isAppControllerInterrupt() && (abstractARPEngine3D = this.mARPEngine3D) != null) {
            abstractARPEngine3D.updateNodeUniform(str, hashMap);
        }
    }
}
