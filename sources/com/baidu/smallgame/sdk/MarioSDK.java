package com.baidu.smallgame.sdk;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.smallgame.sdk.ArBridge;
import com.baidu.smallgame.sdk.delegate.AREngineDelegate;
import java.util.ArrayList;
import java.util.List;

public class MarioSDK {
    private static final String TAG = "MarioSDK";
    private AREngineDelegate mAREngineDelegate;
    private MarioInitListener mMarioInitListener;
    private V8Engine mV8Engine;

    public static class AREngineConfiguration {
        /* access modifiers changed from: private */
        public Context mContext;
        private List<DebugConsole> mDebugConsoles = new ArrayList();
        /* access modifiers changed from: private */
        public ArBridge.FirstFrameListener mFirstFrameListener;
        /* access modifiers changed from: private */
        public int mRenderMode;
        /* access modifiers changed from: private */
        public GLSurfaceView.Renderer mRenderer;
        /* access modifiers changed from: private */
        public SurfaceHolder mSurfaceHolder;

        public void addDebugConsole(DebugConsole debugConsole) {
            if (debugConsole != null) {
                this.mDebugConsoles.add(debugConsole);
            }
        }

        public Context getContext() {
            return this.mContext;
        }

        public List<DebugConsole> getDebugConsoles() {
            return this.mDebugConsoles;
        }

        public ArBridge.FirstFrameListener getFirstFrameListener() {
            return this.mFirstFrameListener;
        }

        public int getRenderMode() {
            return this.mRenderMode;
        }

        public GLSurfaceView.Renderer getRenderer() {
            return this.mRenderer;
        }

        public SurfaceHolder getSurfaceHolder() {
            return this.mSurfaceHolder;
        }

        public void setContext(Context context) {
            this.mContext = context;
        }

        public void setFirstFrameListener(ArBridge.FirstFrameListener firstFrameListener) {
            this.mFirstFrameListener = firstFrameListener;
        }

        public void setRenderMode(int i2) {
            this.mRenderMode = i2;
        }

        public void setRenderer(GLSurfaceView.Renderer renderer) {
            this.mRenderer = renderer;
        }

        public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
            this.mSurfaceHolder = surfaceHolder;
        }
    }

    public interface MarioInitListener {
        void onMarioInitDone();
    }

    private MarioSDK(V8Engine v8Engine, AREngineDelegate aREngineDelegate) {
        this.mV8Engine = v8Engine;
        this.mAREngineDelegate = aREngineDelegate;
    }

    public static AREngineDelegate createAREngine(AREngineConfiguration aREngineConfiguration) {
        if (aREngineConfiguration == null) {
            return null;
        }
        AREngine aREngine = new AREngine();
        if (aREngineConfiguration.mSurfaceHolder != null) {
            aREngine.setSurfaceHolder(aREngineConfiguration.mSurfaceHolder);
        }
        if (aREngineConfiguration.mFirstFrameListener != null) {
            aREngine.setFirstFrameListener(aREngineConfiguration.mFirstFrameListener);
        }
        aREngine.setRenderMode(aREngineConfiguration.mRenderMode);
        if (aREngineConfiguration.mContext != null) {
            aREngine.setContext(aREngineConfiguration.mContext);
        }
        if (aREngineConfiguration.mRenderer != null) {
            aREngine.setRenderer(aREngineConfiguration.mRenderer);
        }
        if (aREngineConfiguration.getDebugConsoles() != null) {
            for (DebugConsole addDebugConsole : aREngineConfiguration.getDebugConsoles()) {
                aREngine.addDebugConsole(addDebugConsole);
            }
        }
        return aREngine;
    }

    public static V8Engine createV8Engine(Context context, V8EngineConfiguration v8EngineConfiguration) {
        if (v8EngineConfiguration == null) {
            return null;
        }
        V8Engine v8Engine = new V8Engine(context, v8EngineConfiguration.getBasePath(), v8EngineConfiguration.getJsPath(), v8EngineConfiguration.getV8ThreadDelegatePolicy(), v8EngineConfiguration.getMainGlobalObject(), v8EngineConfiguration.getOpenGlobalObject(), v8EngineConfiguration.getAbTestInterface());
        if (v8EngineConfiguration.getUserAgent() != null) {
            v8Engine.setUserAgent(v8EngineConfiguration.getUserAgent());
        }
        if (v8EngineConfiguration.getDecodeBdFile() != null) {
            v8Engine.setBdFileRealPath(v8EngineConfiguration.getDecodeBdFile());
        }
        if (v8EngineConfiguration.getJavaScriptExceptionDelegate() != null) {
            v8Engine.setJavaScriptExceptionDelegate(v8EngineConfiguration.getJavaScriptExceptionDelegate());
        }
        if (v8EngineConfiguration.getFileSystemDelegatePolicy() != null) {
            v8Engine.setFileSystemDelegatePolicy(v8EngineConfiguration.getFileSystemDelegatePolicy());
        }
        if (v8EngineConfiguration.getV8EngineConsoles() != null) {
            for (V8Engine.V8EngineConsole addV8EngineConsole : v8EngineConfiguration.getV8EngineConsoles()) {
                v8Engine.addV8EngineConsole(addV8EngineConsole);
            }
        }
        if (v8EngineConfiguration.getV8StatusListeners() != null) {
            for (V8Engine.V8StatusListener addStatusHandler : v8EngineConfiguration.getV8StatusListeners()) {
                v8Engine.addStatusHandler(addStatusHandler);
            }
        }
        return v8Engine;
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, AREngineConfiguration aREngineConfiguration) {
        return initialize(context, v8EngineConfiguration, aREngineConfiguration, (MarioInitListener) null);
    }

    public AREngineDelegate getAREngineDelegate() {
        return this.mAREngineDelegate;
    }

    public V8Engine getV8Engine() {
        return this.mV8Engine;
    }

    public void reset() {
        resetAREngine();
        resetV8Engine();
    }

    public void resetAREngine() {
        this.mAREngineDelegate = null;
    }

    public void resetV8Engine() {
        this.mV8Engine = null;
    }

    public void setMarioInitListener(MarioInitListener marioInitListener) {
        this.mMarioInitListener = marioInitListener;
    }

    public static MarioSDK initialize(Context context, V8EngineConfiguration v8EngineConfiguration, AREngineConfiguration aREngineConfiguration, MarioInitListener marioInitListener) {
        V8Engine v8Engine;
        AREngineDelegate aREngineDelegate = null;
        try {
            v8Engine = createV8Engine(context, v8EngineConfiguration);
        } catch (Exception e2) {
            Log.e(TAG, "v8Engine init error", (Throwable) e2);
            v8Engine = null;
        }
        try {
            aREngineDelegate = createAREngine(aREngineConfiguration);
        } catch (Exception e3) {
            Log.e(TAG, "AREngine init error", (Throwable) e3);
        }
        MarioSDK marioSDK = new MarioSDK(v8Engine, aREngineDelegate);
        if (marioInitListener != null) {
            marioInitListener.onMarioInitDone();
        }
        return marioSDK;
    }
}
