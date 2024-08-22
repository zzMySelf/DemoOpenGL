package com.baidu.searchbox.ai.model;

import android.util.Log;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ai.inference.impl.AIModelInstallManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.plugins.annotation.PluginAccessable;
import java.io.File;

public class MMLLibraryPluginManager implements NoProGuard {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String MMLNATIVE_SO_ID = "box.ai.library.mmlnative";
    private static final String MML_SO_ID = "box.ai.library.mml";
    private static final String PADDLE_LITE_CPU_GPU_SO_ID = "box.ai.library.paddle_lite_cpu_gpu";
    private static final String PADDLE_LITE_CPU_ONLY_SO_ID = "box.ai.library.paddle_lite_cpu_only";
    private static final String TAG = "MMLLibraryPluginManager";
    private static volatile MMLLibraryPluginManager sInstance;
    private boolean supportOpenCL;

    public static MMLLibraryPluginManager getInstance() {
        if (sInstance == null) {
            synchronized (MMLLibraryPluginManager.class) {
                if (sInstance == null) {
                    sInstance = new MMLLibraryPluginManager();
                }
            }
        }
        return sInstance;
    }

    MMLLibraryPluginManager() {
        try {
            System.loadLibrary("OpenCL");
            this.supportOpenCL = true;
        } catch (Throwable e2) {
            e2.printStackTrace();
            this.supportOpenCL = false;
        }
    }

    @PluginAccessable(methodName = "getPaddleLitePath", paramClasses = {})
    public String getPaddleLitePath() {
        if (DEBUG) {
            Log.d(TAG, "getPaddleLitePath");
        }
        Model libraryModel = getPaddleLiteModel();
        if (libraryModel == null) {
            return "";
        }
        return libraryModel.getModelAbsolutePath();
    }

    @PluginAccessable(methodName = "getMMLPath", paramClasses = {})
    public String getMMLPath() {
        if (DEBUG) {
            Log.d(TAG, "getMMLPath");
        }
        Model libraryModel = getMMLModel();
        if (libraryModel == null) {
            return "";
        }
        return libraryModel.getModelAbsolutePath();
    }

    @PluginAccessable(methodName = "getPaddleLiteVersion", paramClasses = {})
    public String getPaddleLiteVersion() {
        if (DEBUG) {
            Log.d(TAG, "getPaddleLiteVersion");
        }
        Model libraryModel = getPaddleLiteModel();
        if (libraryModel == null) {
            return "";
        }
        return libraryModel.getVersionCode();
    }

    @PluginAccessable(methodName = "getMMLVersion", paramClasses = {})
    public String getMMLVersion() {
        if (DEBUG) {
            Log.d(TAG, "getMMLVersion");
        }
        Model libraryModel = getMMLModel();
        if (libraryModel == null) {
            return "";
        }
        return libraryModel.getVersionCode();
    }

    @PluginAccessable(methodName = "isMMLPaddleLiteReady", paramClasses = {})
    public Boolean isMMLPaddleLiteReady() {
        if (DEBUG) {
            Log.d(TAG, "isMMLPaddleLiteReady");
        }
        Model mmlModel = getMMLModel();
        Model paddleLiteModel = getPaddleLiteModel();
        if (mmlModel == null || paddleLiteModel == null) {
            return false;
        }
        File mmlSoFile = new File(mmlModel.getModelAbsolutePath());
        File paddleLiteFile = new File(paddleLiteModel.getModelAbsolutePath());
        if (!mmlSoFile.exists() || !paddleLiteFile.exists()) {
            return false;
        }
        return true;
    }

    @PluginAccessable(methodName = "supportOpenCL", paramClasses = {})
    public boolean supportOpenCL() {
        if (DEBUG) {
            Log.d(TAG, "supportOpenCL");
        }
        return this.supportOpenCL;
    }

    public String getMMLNativePath() {
        if (DEBUG) {
            Log.d(TAG, "getMMLNativePath");
        }
        Model libraryModel = getMMLNativeModel();
        if (libraryModel == null) {
            return "";
        }
        return libraryModel.getModelAbsolutePath();
    }

    public String getMMLNativeVersion() {
        if (DEBUG) {
            Log.d(TAG, "getMMLVersion");
        }
        Model libraryModel = getMMLNativeModel();
        if (libraryModel == null) {
            return "";
        }
        return libraryModel.getVersionCode();
    }

    private Model getPaddleLiteModel() {
        if (this.supportOpenCL) {
            return AIModelInstallManager.get().getModel(PADDLE_LITE_CPU_GPU_SO_ID);
        }
        return AIModelInstallManager.get().getModel(PADDLE_LITE_CPU_ONLY_SO_ID);
    }

    private Model getMMLModel() {
        return AIModelInstallManager.get().getModel(MML_SO_ID);
    }

    private Model getMMLNativeModel() {
        return AIModelInstallManager.get().getModel("box.ai.library.mmlnative");
    }
}
