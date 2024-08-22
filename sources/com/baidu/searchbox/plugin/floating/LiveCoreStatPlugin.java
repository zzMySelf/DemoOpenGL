package com.baidu.searchbox.plugin.floating;

import com.baidu.searchbox.player.ubc.CoreStatPlugin;

public class LiveCoreStatPlugin extends CoreStatPlugin {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onVideoEventNotify(com.baidu.searchbox.player.event.VideoEvent r3) {
        /*
            r2 = this;
            super.onVideoEventNotify(r3)
            java.lang.String r0 = r3.getAction()
            int r1 = r0.hashCode()
            switch(r1) {
                case -2127352417: goto L_0x000f;
                default: goto L_0x000e;
            }
        L_0x000e:
            goto L_0x001a
        L_0x000f:
            java.lang.String r1 = "statistics_update_content"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000e
            r0 = 0
            goto L_0x001b
        L_0x001a:
            r0 = -1
        L_0x001b:
            switch(r0) {
                case 0: goto L_0x001f;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x002a
        L_0x001f:
            r0 = 13
            java.lang.Object r0 = r3.getExtra(r0)
            com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent r0 = (com.baidu.searchbox.player.ubc.BDVideoPlayerUbcContent) r0
            r2.mUBCContent = r0
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.plugin.floating.LiveCoreStatPlugin.onVideoEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }
}
