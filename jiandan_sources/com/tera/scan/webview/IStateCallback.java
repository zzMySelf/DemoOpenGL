package com.tera.scan.webview;

import android.app.Activity;

public interface IStateCallback {
    void ad(BaseWebViewFragment baseWebViewFragment, boolean z);

    void onDestroyView();

    void onPause();

    void onResume();

    void qw(Activity activity);
}
