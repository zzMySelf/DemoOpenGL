package com.baidu.searchbox.ai.infer;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ai.AlgorithmType;
import com.baidu.searchbox.ai.Common;
import com.baidu.searchbox.ai.DataType;
import com.baidu.searchbox.ai.Inference;
import com.baidu.searchbox.ai.InferenceException;
import com.baidu.searchbox.ai.Tensor;
import com.baidu.searchbox.ai.model.MMLModel;
import com.baidu.searchbox.ai.model.MMLModelInstallManager;
import com.baidu.searchbox.ai.model.ModelDataManager;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;

public class InferenceWrapper implements AutoCloseable {
    private static final String TAG = "InferenceWrapper";
    private Inference mInference;
    private MMLModel mModel;

    public interface InitCallback {
        void onInitResult(boolean z, String str);
    }

    public void init(AlgorithmType algorithm, String modelId) throws ModelLoadException {
        MMLModel mmlModel = innerCheck(algorithm, modelId);
        this.mInference = Inference.getInstance(algorithm.value(), mmlModel.modelPath);
        this.mModel = mmlModel;
        InferenceRecorder.getInstance().inferenceStart(modelId);
    }

    public void initAndPreload(AlgorithmType algorithm, String modelId, DataType dataType) throws ModelLoadException {
        MMLModel mmlModel = innerCheck(algorithm, modelId);
        Inference instance = Inference.getInstance(algorithm.value(), mmlModel.modelPath);
        this.mInference = instance;
        instance.preloadModel(dataType);
        this.mModel = mmlModel;
        InferenceRecorder.getInstance().inferenceStart(modelId);
    }

    public int predictForClassId(Tensor input, float threshold) {
        Inference inference = this.mInference;
        if (inference != null) {
            return inference.predictForClassId(input, threshold);
        }
        throw new IllegalStateException("not init!!!");
    }

    public String predictForClassName(Tensor input, float threshold) {
        Inference inference = this.mInference;
        if (inference != null) {
            return inference.predictForClassName(input, threshold);
        }
        throw new IllegalStateException("not init!!!");
    }

    public <T> T[] predictForClassArray(Tensor input, float threshold, Class<T> type) throws InferenceException {
        Inference inference = this.mInference;
        if (inference != null) {
            return inference.predictForClassArray(input, threshold, type);
        }
        throw new IllegalStateException("not init!!!");
    }

    public <T> T predictForRegressorTarget(Tensor input, float threshold, Class<T> type) throws InferenceException {
        Inference inference = this.mInference;
        if (inference != null) {
            return inference.predictForRegressorTarget(input, threshold, type);
        }
        throw new IllegalStateException("not init!!!");
    }

    public <T> T[] predictForRegressorTargetArray(Tensor input, float threshold) {
        Inference inference = this.mInference;
        if (inference != null) {
            return inference.predictForRegressorTargetArray(input, threshold);
        }
        throw new IllegalStateException("not init!!!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        if (r4.mModel == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r4.mModel != null) goto L_0x000e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        com.baidu.searchbox.ai.infer.InferenceRecorder.getInstance().inferenceStop(r4.mModel.getModelId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r4.mInference = null;
        r4.mModel = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r4 = this;
            r0 = 0
            com.baidu.searchbox.ai.Inference r1 = r4.mInference     // Catch:{ Exception -> 0x0022 }
            if (r1 == 0) goto L_0x000a
            r1.close()     // Catch:{ Exception -> 0x0022 }
            r4.mInference = r0     // Catch:{ Exception -> 0x0022 }
        L_0x000a:
            com.baidu.searchbox.ai.model.MMLModel r1 = r4.mModel
            if (r1 == 0) goto L_0x001b
        L_0x000e:
            com.baidu.searchbox.ai.infer.InferenceRecorder r1 = com.baidu.searchbox.ai.infer.InferenceRecorder.getInstance()
            com.baidu.searchbox.ai.model.MMLModel r2 = r4.mModel
            java.lang.String r2 = r2.getModelId()
            r1.inferenceStop(r2)
        L_0x001b:
            r4.mInference = r0
            r4.mModel = r0
            goto L_0x0031
        L_0x0020:
            r1 = move-exception
            goto L_0x0032
        L_0x0022:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x002c
            r1.printStackTrace()     // Catch:{ all -> 0x0020 }
        L_0x002c:
            com.baidu.searchbox.ai.model.MMLModel r1 = r4.mModel
            if (r1 == 0) goto L_0x001b
            goto L_0x000e
        L_0x0031:
            return
        L_0x0032:
            com.baidu.searchbox.ai.model.MMLModel r2 = r4.mModel
            if (r2 == 0) goto L_0x0043
            com.baidu.searchbox.ai.infer.InferenceRecorder r2 = com.baidu.searchbox.ai.infer.InferenceRecorder.getInstance()
            com.baidu.searchbox.ai.model.MMLModel r3 = r4.mModel
            java.lang.String r3 = r3.getModelId()
            r2.inferenceStop(r3)
        L_0x0043:
            r4.mInference = r0
            r4.mModel = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.ai.infer.InferenceWrapper.close():void");
    }

    private boolean checkModelLoadable(String modelId) {
        return !MMLModelInstallManager.getInstance().isInstalling();
    }

    public MMLModel innerCheck(AlgorithmType algorithm, String modelId) throws ModelLoadException {
        if (TextUtils.isEmpty(modelId) || algorithm == null) {
            throw new ModelLoadException();
        } else if (Common.getSDKVersion() != null) {
            MMLModel mmlModel = ModelDataManager.getInstance().queryModelById(modelId);
            if (mmlModel == null || TextUtils.isEmpty(mmlModel.modelPath)) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "has no model for id: " + modelId);
                }
                throw new ModelLoadException(-1, "has no model");
            } else if (!new File(mmlModel.modelPath).exists()) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "has no model for id: " + modelId);
                }
                throw new ModelLoadException(-1, "has no model");
            } else if (!MMLModelInstallManager.getInstance().handleModelCompatibleIfNeed(mmlModel)) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "model not compatible: " + modelId);
                }
                throw new ModelLoadException(-1, "model not compatible");
            } else if (checkModelLoadable(modelId)) {
                return mmlModel;
            } else {
                throw new ModelLoadException(-2, "model is installing");
            }
        } else {
            throw new ModelLoadException();
        }
    }
}
