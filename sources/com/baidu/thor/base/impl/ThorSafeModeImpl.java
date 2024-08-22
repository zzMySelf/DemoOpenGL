package com.baidu.thor.base.impl;

import com.baidu.perf.safemode.SafeMode;
import com.baidu.thor.base.IThorSafeMode;

public class ThorSafeModeImpl implements IThorSafeMode {
    public int getCrashCount() {
        return SafeMode.getCrashCount();
    }
}
