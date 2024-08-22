package com.baidu.searchbox.record.ui.controller;

import android.os.Bundle;
import com.baidu.searchbox.record.api.LyrebirdConfig;

public interface IPageController {
    void gotoPage(Class<?> cls, Bundle bundle);

    void gotoPage(String str, Bundle bundle);

    void init(Object obj, int i2, LyrebirdConfig lyrebirdConfig);

    boolean interceptBackPressed();

    boolean isEmptyBackStack();

    void onDestory();

    void onPause();

    void onResume();
}
