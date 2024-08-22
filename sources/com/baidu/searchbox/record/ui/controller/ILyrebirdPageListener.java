package com.baidu.searchbox.record.ui.controller;

import android.os.Bundle;
import com.baidu.searchbox.record.api.ILyrebirdImageCallback;

public interface ILyrebirdPageListener {
    void finish(Bundle bundle);

    void jumpPage(String str, Bundle bundle);

    void jumpToH5(String str);

    void loadImage(String str, ILyrebirdImageCallback.OnResultListener onResultListener);

    void onUserAction(String str, int i2);
}
