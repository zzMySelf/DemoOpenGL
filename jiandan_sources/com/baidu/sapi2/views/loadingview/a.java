package com.baidu.sapi2.views.loadingview;

import android.view.View;

public interface a<T extends View> {
    void a();

    void dismiss();

    T getLoadingView();
}
