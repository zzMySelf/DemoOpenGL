package com.baidu.searchbox.aideviceperformance.inference;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.ai.AlgorithmType;
import com.baidu.searchbox.ai.Common;
import com.baidu.searchbox.ai.DataType;
import com.baidu.searchbox.ai.Inference;
import com.baidu.searchbox.ai.InferenceException;
import com.baidu.searchbox.ai.Tensor;
import java.io.File;

public class InferenceWrapper implements AutoCloseable {
    private static final String TAG = "InferenceWrapper";
    private Inference mInference;
    private DevicePerformanceModelInfo mModel;

    public interface InitCallback {
        void onInitResult(boolean z, String str);
    }

    public void init(AlgorithmType algorithm, DevicePerformanceModelInfo devicePerformanceModelInfo) throws ModelLoadException {
        if (innerCheck(algorithm, devicePerformanceModelInfo)) {
            this.mInference = Inference.getInstance(algorithm.value(), devicePerformanceModelInfo.modelPath);
            this.mModel = devicePerformanceModelInfo;
            InferenceRecorder.getInstance().inferenceStart(devicePerformanceModelInfo.modelPath);
        }
    }

    public void initAndPreload(AlgorithmType algorithm, DevicePerformanceModelInfo devicePerformanceModelInfo, DataType dataType) throws ModelLoadException {
        if (innerCheck(algorithm, devicePerformanceModelInfo)) {
            Inference instance = Inference.getInstance(algorithm.value(), devicePerformanceModelInfo.modelPath);
            this.mInference = instance;
            instance.preloadModel(dataType);
            this.mModel = devicePerformanceModelInfo;
            InferenceRecorder.getInstance().inferenceStart(devicePerformanceModelInfo.modelPath);
        }
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

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r4.mModel == null) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r4.mModel != null) goto L_0x000e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        com.baidu.searchbox.aideviceperformance.inference.InferenceRecorder.getInstance().inferenceStop(r4.mModel.getModelPath());
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
            com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo r1 = r4.mModel
            if (r1 == 0) goto L_0x001b
        L_0x000e:
            com.baidu.searchbox.aideviceperformance.inference.InferenceRecorder r1 = com.baidu.searchbox.aideviceperformance.inference.InferenceRecorder.getInstance()
            com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo r2 = r4.mModel
            java.lang.String r2 = r2.getModelPath()
            r1.inferenceStop(r2)
        L_0x001b:
            r4.mInference = r0
            r4.mModel = r0
            goto L_0x002f
        L_0x0020:
            r1 = move-exception
            goto L_0x0030
        L_0x0022:
            r1 = move-exception
            boolean r2 = com.baidu.searchbox.aideviceperformance.inference.InferenceConfig.DEBUG     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x002a
            r1.printStackTrace()     // Catch:{ all -> 0x0020 }
        L_0x002a:
            com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo r1 = r4.mModel
            if (r1 == 0) goto L_0x001b
            goto L_0x000e
        L_0x002f:
            return
        L_0x0030:
            com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo r2 = r4.mModel
            if (r2 == 0) goto L_0x0041
            com.baidu.searchbox.aideviceperformance.inference.InferenceRecorder r2 = com.baidu.searchbox.aideviceperformance.inference.InferenceRecorder.getInstance()
            com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo r3 = r4.mModel
            java.lang.String r3 = r3.getModelPath()
            r2.inferenceStop(r3)
        L_0x0041:
            r4.mInference = r0
            r4.mModel = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aideviceperformance.inference.InferenceWrapper.close():void");
    }

    public boolean innerCheck(AlgorithmType algorithm, DevicePerformanceModelInfo devicePerformanceModelInfo) throws ModelLoadException {
        if (devicePerformanceModelInfo == null || algorithm == null) {
            throw new ModelLoadException();
        } else if (Common.getSDKVersion() == null) {
            throw new ModelLoadException();
        } else if (TextUtils.isEmpty(devicePerformanceModelInfo.modelPath)) {
            if (InferenceConfig.DEBUG) {
                Log.d(TAG, "has no model for id: " + devicePerformanceModelInfo.modelPath);
            }
            throw new ModelLoadException(-1, "has no model");
        } else if (new File(devicePerformanceModelInfo.modelPath).exists()) {
            return true;
        } else {
            if (InferenceConfig.DEBUG) {
                Log.d(TAG, "has no model for id: " + devicePerformanceModelInfo.modelPath);
            }
            throw new ModelLoadException(-1, "has no model");
        }
    }
}
