package com.yy.transvod.player;

public interface OnPlayerQualityMonitorListener {
    public static final int DECODE_TYPE_AVC_HW = 1;
    public static final int DECODE_TYPE_AVC_SW = 2;
    public static final int DECODE_TYPE_HEVC_HW = 3;
    public static final int DECODE_TYPE_HEVC_SW = 4;
    public static final int STALLS_TYPE_BOTH_UP_DOWNSTREAM = 1;
    public static final int STALLS_TYPE_DOWNSTREAM = 3;
    public static final int STALLS_TYPE_UNKNOW = 0;
    public static final int STALLS_TYPE_UPSTREAM = 2;

    void onPlayerAudioStalls(VodPlayer vodPlayer, boolean z, int i2);

    void onPlayerDecodeBitrate(VodPlayer vodPlayer, int i2, int i3);

    void onPlayerDecodeOuputSize(VodPlayer vodPlayer, int i2, int i3);

    void onPlayerDecodeType(VodPlayer vodPlayer, int i2);

    void onPlayerReceiveToRenderDelay(VodPlayer vodPlayer, int i2);

    void onPlayerRenderFramerate(VodPlayer vodPlayer, int i2);

    void onPlayerVideoStalls(VodPlayer vodPlayer, boolean z, int i2);
}
