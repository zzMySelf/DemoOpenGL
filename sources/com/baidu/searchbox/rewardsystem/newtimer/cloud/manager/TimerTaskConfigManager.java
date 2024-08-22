package com.baidu.searchbox.rewardsystem.newtimer.cloud.manager;

import com.baidu.searchbox.rewardsystem.newtimer.cloud.configctrl.MissionTimerTaskConfig;

public class TimerTaskConfigManager {
    private final MissionTimerTaskConfig mMissionTimerTaskConfig;

    private TimerTaskConfigManager() {
        this.mMissionTimerTaskConfig = new MissionTimerTaskConfig();
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static TimerTaskConfigManager sIns = new TimerTaskConfigManager();

        private Holder() {
        }
    }

    public static TimerTaskConfigManager getInstance() {
        return Holder.sIns;
    }

    public MissionTimerTaskConfig getMissionTimerTaskConfig() {
        return this.mMissionTimerTaskConfig;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean commandUpdate(android.content.Context r3, java.lang.String r4, java.lang.String r5, com.baidu.searchbox.net.update.v2.ActionData<org.json.JSONObject> r6) {
        /*
            r2 = this;
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case 1100540169: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0014
        L_0x0009:
            java.lang.String r0 = "mission_task_config"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0015
        L_0x0014:
            r0 = -1
        L_0x0015:
            switch(r0) {
                case 0: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r1
        L_0x0019:
            com.baidu.searchbox.rewardsystem.newtimer.cloud.configctrl.MissionTimerTaskConfig r0 = r2.mMissionTimerTaskConfig
            boolean r0 = r0.commandUpdate(r3, r4, r5, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.rewardsystem.newtimer.cloud.manager.TimerTaskConfigManager.commandUpdate(android.content.Context, java.lang.String, java.lang.String, com.baidu.searchbox.net.update.v2.ActionData):boolean");
    }
}
