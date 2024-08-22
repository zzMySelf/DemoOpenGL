package com.baidu.searchbox.concurrent;

import com.baidu.android.util.concurrent.UiThreadUtil;
import com.baidu.searchbox.export.IPlayerUiThreadUtils;

public class PlayerUiThreadUtilsImpl implements IPlayerUiThreadUtils {
    public void runOnUiThread(Runnable action) {
        UiThreadUtil.runOnUiThread(action);
    }
}
