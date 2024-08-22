package com.pichillilorenzo.flutter_inappwebview.in_app_browser;

import android.app.Activity;
import java.util.List;

public interface InAppBrowserDelegate {
    void didChangeProgress(int i2);

    void didChangeTitle(String str);

    void didFailNavigation(String str, int i2, String str2);

    void didFinishNavigation(String str);

    void didStartNavigation(String str);

    void didUpdateVisitedHistory(String str);

    Activity getActivity();

    List<ActivityResultListener> getActivityResultListeners();
}
