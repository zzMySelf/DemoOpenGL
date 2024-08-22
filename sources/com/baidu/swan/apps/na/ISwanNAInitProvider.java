package com.baidu.swan.apps.na;

import android.app.Application;

public interface ISwanNAInitProvider {
    public static final ISwanNAInitProvider DEFAULT = new ISwanNAInitProvider() {
        public void onAttachApplication(Application application) {
        }
    };

    void onAttachApplication(Application application);
}
