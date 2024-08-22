package com.baidu.searchbox.http.silence;

import java.util.List;

public interface SilenceProbeResultCallback {
    void onResult(List<SilenceProbeResult> list, boolean z);
}
