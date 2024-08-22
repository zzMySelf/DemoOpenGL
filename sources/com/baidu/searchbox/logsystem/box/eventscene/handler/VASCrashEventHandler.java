package com.baidu.searchbox.logsystem.box.eventscene.handler;

import android.content.Context;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.performance.memory.monitor.MemoryMonitor;
import com.baidu.searchbox.performance.memory.monitor.VASSingleton;
import java.io.File;
import java.util.HashSet;

public class VASCrashEventHandler extends ProcessEventSceneHandler {
    private static final String CWA = "android.database.CursorWindowAllocationException: Cursor window allocation";
    protected static final String OOM = "java.lang.OutOfMemoryError";
    private static final String PC = "pthread_create";

    public boolean saveFragmentSnapshot(Context context, EventObject eventObject, File sharedOutput) {
        boolean useMemorySnapshot = false;
        String eventLog = eventObject.mEventLog;
        if (eventLog.contains(OOM) && eventLog.contains(PC)) {
            useMemorySnapshot = true;
        }
        if (eventLog.contains(CWA)) {
            useMemorySnapshot = true;
        }
        HashSet<String> keys = new HashSet<>(1);
        keys.add("VmPeak");
        if (!useMemorySnapshot) {
            return false;
        }
        VASSingleton.getInstance().updateMinCrashVAS(MemoryMonitor.obtainMemorySnapshot(keys, "from crash").mVmPeak);
        return false;
    }
}
