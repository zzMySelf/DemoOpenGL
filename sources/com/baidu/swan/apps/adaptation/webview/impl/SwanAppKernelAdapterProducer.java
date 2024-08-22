package com.baidu.swan.apps.adaptation.webview.impl;

import com.baidu.swan.apps.adaptation.webview.IWebViewKernelAdapter;

public final class SwanAppKernelAdapterProducer {
    private SwanAppKernelAdapterProducer() {
    }

    public static SwanAppKernelAdapterProducer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public IWebViewKernelAdapter getKernelAdapter() {
        return new SailorKernelAdapter();
    }

    private static class SingletonHolder {
        public static final SwanAppKernelAdapterProducer INSTANCE = new SwanAppKernelAdapterProducer();

        private SingletonHolder() {
        }
    }
}
