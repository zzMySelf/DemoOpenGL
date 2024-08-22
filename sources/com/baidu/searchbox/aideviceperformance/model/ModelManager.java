package com.baidu.searchbox.aideviceperformance.model;

import com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo;
import com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider;
import com.baidu.searchbox.aideviceperformance.utils.Config;
import com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper;
import com.baidu.searchbox.aideviceperformance.utils.FileUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.File;
import java.util.HashMap;

public class ModelManager {
    private static long defaultModelsVersion = 1;
    private static HashMap<ModelInfoDataProvider.DevicePerformanceModelInfoType, IDevicePerformanceModelInfoProvider> mModelInfoProviderHashMap = new HashMap<>();

    public void setModelInfoProvider(IDevicePerformanceModelInfoProvider modelInfoProvider, ModelInfoDataProvider.DevicePerformanceModelInfoType modelInfoType) {
        if (modelInfoProvider != null && modelInfoType != null) {
            mModelInfoProviderHashMap.put(modelInfoType, modelInfoProvider);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean needUpdateDefaultModel() {
        /*
            com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper r0 = com.baidu.searchbox.aideviceperformance.utils.DeviceInfoSharedPreferenceWrapper.getInstance()
            java.lang.String r1 = com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider.defaultModelAssertDir
            r2 = -1
            long r0 = r0.getLong(r1, r2)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            long r1 = r0.longValue()
            long r3 = defaultModelsVersion
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            if (r1 >= 0) goto L_0x001c
            return r2
        L_0x001c:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider.defaultModelFilePath
            r1.<init>(r3)
            boolean r3 = r1.exists()
            if (r3 != 0) goto L_0x002a
            return r2
        L_0x002a:
            com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider r3 = new com.baidu.searchbox.aideviceperformance.model.ModelInfoDataProvider
            r3.<init>()
            java.util.HashMap r3 = r3.getDefaultModelInfoMap()
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x003b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0060
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo r5 = (com.baidu.searchbox.aideviceperformance.inference.DevicePerformanceModelInfo) r5
            if (r5 != 0) goto L_0x0051
            return r2
        L_0x0051:
            java.io.File r6 = new java.io.File
            java.lang.String r7 = r5.modelPath
            r6.<init>(r7)
            boolean r7 = r6.exists()
            if (r7 != 0) goto L_0x005f
            return r2
        L_0x005f:
            goto L_0x003b
        L_0x0060:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aideviceperformance.model.ModelManager.needUpdateDefaultModel():boolean");
    }

    public boolean checkAndUpdatePresetModel() {
        boolean isNeedUpdate;
        boolean isNeedUpdate2 = needUpdateDefaultModel();
        if (!isNeedUpdate2) {
            return isNeedUpdate2;
        }
        synchronized (ModelManager.class) {
            isNeedUpdate = needUpdateDefaultModel();
            if (isNeedUpdate) {
                try {
                    FileUtil fileUtil = new FileUtil();
                    fileUtil.deleteFile(new File(ModelInfoDataProvider.defaultModelFilePath));
                    fileUtil.copyDirFromAssets(AppRuntime.getAppContext(), ModelInfoDataProvider.defaultModelAssertDir, ModelInfoDataProvider.defaultModelFilePath);
                    DeviceInfoSharedPreferenceWrapper.getInstance().putLong(ModelInfoDataProvider.defaultModelAssertDir, defaultModelsVersion);
                } catch (Exception e2) {
                    if (Config.isDebug()) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        return isNeedUpdate;
    }

    private static DevicePerformanceModelInfo defaultModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType modelInfoType) {
        DevicePerformanceModelInfo modelInfo;
        if (modelInfoType == null || (modelInfo = new ModelInfoDataProvider().getDefaultModelInfoMap().get(modelInfoType)) == null) {
            return null;
        }
        return modelInfo;
    }

    public static DevicePerformanceModelInfo getDevicePerformanceModelInfo(ModelInfoDataProvider.DevicePerformanceModelInfoType modelInfoType) {
        DevicePerformanceModelInfo defaultModel = defaultModelInfo(modelInfoType);
        IDevicePerformanceModelInfoProvider provider = mModelInfoProviderHashMap.get(modelInfoType);
        if (provider != null) {
            return provider.getDevicePerformanceModelInfo(modelInfoType, defaultModel);
        }
        return defaultModel;
    }
}
