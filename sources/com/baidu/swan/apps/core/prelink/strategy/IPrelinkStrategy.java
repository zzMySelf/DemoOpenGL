package com.baidu.swan.apps.core.prelink.strategy;

import com.baidu.swan.apps.core.prelink.recorder.IRecorder;

public interface IPrelinkStrategy {
    IRecorder getRecorder(String str);

    boolean needPreLink(String str, String str2, String str3);

    boolean prelinkByPreloadOn(String str);
}
