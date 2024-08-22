package com.baidu.talos.core.deploy.inter;

import java.util.Map;

public interface IBundleDeployTask {

    public interface BundleDeployTaskCallback {
        void onFail(String str, String str2, int i2, String str3, Map<String, String> map);

        void onSuccess(String str, String str2, Map<String, String> map);
    }

    String getName();

    void run();
}
