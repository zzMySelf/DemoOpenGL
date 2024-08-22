package com.baidu.searchbox.player.session;

import com.baidu.searchbox.player.BDPlayerConfig;
import com.baidu.searchbox.player.constants.PlayerStatus;
import com.baidu.searchbox.player.event.ControlEventTrigger;
import com.baidu.searchbox.player.event.StateEvent;
import com.baidu.searchbox.player.message.IMessenger;

public final class VideoSession {
    private ControlEventTrigger mControlEventTrigger = new ControlEventTrigger();
    private StringBuilder mDesc;
    private IMessenger mMessenger;
    private PlayerStatus mStatus = PlayerStatus.IDLE;

    VideoSession() {
        init();
    }

    private void init() {
    }

    public IMessenger getMessenger() {
        return this.mMessenger;
    }

    @Deprecated
    public ControlEventTrigger getControlEventTrigger() {
        return this.mControlEventTrigger;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        if (r0.equals("player_event_on_prepared") != false) goto L_0x0049;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void accessEventNotify(com.baidu.searchbox.player.event.VideoEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getType()
            r1 = 2
            r2 = 4
            if (r0 == r2) goto L_0x000f
            int r0 = r6.getType()
            if (r0 == r1) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r0 = r6.getAction()
            r2 = -1
            int r3 = r0.hashCode()
            r4 = 1
            switch(r3) {
                case -525235558: goto L_0x003e;
                case -461848373: goto L_0x0033;
                case 154871702: goto L_0x0028;
                case 1370689931: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0048
        L_0x001d:
            java.lang.String r1 = "player_event_on_info"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001c
            r1 = 0
            goto L_0x0049
        L_0x0028:
            java.lang.String r1 = "player_event_on_complete"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001c
            r1 = r4
            goto L_0x0049
        L_0x0033:
            java.lang.String r1 = "player_event_on_error"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x001c
            r1 = 3
            goto L_0x0049
        L_0x003e:
            java.lang.String r3 = "player_event_on_prepared"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x001c
            goto L_0x0049
        L_0x0048:
            r1 = r2
        L_0x0049:
            switch(r1) {
                case 0: goto L_0x005f;
                case 1: goto L_0x0059;
                case 2: goto L_0x0053;
                case 3: goto L_0x004d;
                default: goto L_0x004c;
            }
        L_0x004c:
            goto L_0x0070
        L_0x004d:
            com.baidu.searchbox.player.constants.PlayerStatus r0 = com.baidu.searchbox.player.constants.PlayerStatus.ERROR
            r5.statusChangeNotify(r0)
            goto L_0x0070
        L_0x0053:
            com.baidu.searchbox.player.constants.PlayerStatus r0 = com.baidu.searchbox.player.constants.PlayerStatus.PREPARED
            r5.statusChangeNotify(r0)
            goto L_0x0070
        L_0x0059:
            com.baidu.searchbox.player.constants.PlayerStatus r0 = com.baidu.searchbox.player.constants.PlayerStatus.COMPLETE
            r5.statusChangeNotify(r0)
            goto L_0x0070
        L_0x005f:
            int r0 = r6.getIntExtra(r4)
            r1 = 904(0x388, float:1.267E-42)
            if (r1 == r0) goto L_0x006b
            r1 = 956(0x3bc, float:1.34E-42)
            if (r1 != r0) goto L_0x0070
        L_0x006b:
            com.baidu.searchbox.player.constants.PlayerStatus r1 = com.baidu.searchbox.player.constants.PlayerStatus.PLAYING
            r5.statusChangeNotify(r1)
        L_0x0070:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.player.session.VideoSession.accessEventNotify(com.baidu.searchbox.player.event.VideoEvent):void");
    }

    public void statusChangeNotify(PlayerStatus status) {
        if (status != this.mStatus) {
            PlayerStatus old = this.mStatus;
            this.mStatus = status;
            IMessenger iMessenger = this.mMessenger;
            if (iMessenger != null) {
                iMessenger.notifyEvent(StateEvent.obtainEvent(old, status));
            }
        }
    }

    public PlayerStatus getStatus() {
        return this.mStatus;
    }

    public boolean isPause() {
        return this.mStatus == PlayerStatus.PAUSE;
    }

    public boolean isPlaying() {
        return this.mStatus == PlayerStatus.PLAYING;
    }

    public boolean isComplete() {
        return this.mStatus == PlayerStatus.COMPLETE;
    }

    public boolean isError() {
        return this.mStatus == PlayerStatus.ERROR;
    }

    public boolean isStop() {
        return this.mStatus == PlayerStatus.STOP;
    }

    public boolean isPrepared() {
        return this.mStatus == PlayerStatus.PREPARED;
    }

    public boolean isPreparing() {
        return this.mStatus == PlayerStatus.PREPARING;
    }

    public boolean isIdle() {
        return this.mStatus == PlayerStatus.IDLE;
    }

    public boolean matchStatus(PlayerStatus... statusArray) {
        for (PlayerStatus status : statusArray) {
            if (status == getStatus()) {
                return true;
            }
        }
        return false;
    }

    public void bindMessenger(IMessenger messenger) {
        this.mMessenger = messenger;
    }

    public void unbindMessenger() {
        this.mMessenger = null;
    }

    public void reset() {
        unbindMessenger();
        this.mStatus = PlayerStatus.IDLE;
    }

    public String toString() {
        if (!BDPlayerConfig.isDebug()) {
            return super.toString();
        }
        StringBuilder sb = this.mDesc;
        if (sb == null) {
            this.mDesc = new StringBuilder();
        } else if (sb.length() > 0) {
            StringBuilder sb2 = this.mDesc;
            sb2.delete(0, sb2.length());
        }
        this.mDesc.append("，Courier :").append(this.mMessenger).append("，status :").append(this.mStatus).append("，hash :").append(hashCode()).append("】");
        return this.mDesc.toString();
    }
}
