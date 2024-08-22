package com.baidu.disasterrecovery.jnicrash;

import com.baidu.crashpad.ZwCrashpad;

public class NativeCrashTest {
    public static void makeCrash() {
        NativeCrashCapture.makeCrash();
    }

    public static void makeCrashCrashpad() {
        ZwCrashpad.crashIntentionally(1);
    }
}
