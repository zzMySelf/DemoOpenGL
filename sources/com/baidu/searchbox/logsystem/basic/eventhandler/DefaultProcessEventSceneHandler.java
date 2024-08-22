package com.baidu.searchbox.logsystem.basic.eventhandler;

import android.content.Context;
import com.baidu.searchbox.logsystem.logsys.eventscene.EventObject;
import com.baidu.searchbox.logsystem.logsys.eventscene.handler.ProcessEventSceneHandler;
import com.baidu.searchbox.logsystem.logsys.eventscene.snapshot.ProcessSnapshotType;
import java.util.HashSet;
import java.util.Set;

public class DefaultProcessEventSceneHandler extends ProcessEventSceneHandler {
    public static void init() {
    }

    public Set<ProcessSnapshotType> requireGeneralSnapshots(Context context, EventObject eventObject) {
        Set<ProcessSnapshotType> snapshotGeneralTypes = new HashSet<>(3);
        snapshotGeneralTypes.add(ProcessSnapshotType.PROCESS_UI_TRACE);
        snapshotGeneralTypes.add(ProcessSnapshotType.PROCESS_RUNNING_STATUS);
        snapshotGeneralTypes.add(ProcessSnapshotType.PROCESS_STATUS);
        return snapshotGeneralTypes;
    }
}
