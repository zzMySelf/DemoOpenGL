package com.tera.scan.doc.preview.document.ui.view;

import androidx.annotation.StringRes;

public interface ILoadCallback {
    void onLoadFailed(@StringRes int i2, long j);

    void onLoadSucceed();
}
