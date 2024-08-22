package com.yy.transvod.player.common;

public class VideoExtraInfo {
    public static int SEI_APP_DATA = 2;
    public static int SEI_APP_SDK_DATA = 7;
    public static int SEI_BAIDU_SEI_DATA = 8;
    public static int SEI_ENCODE_DATA = 5;
    public static int SEI_PARAM_DATA_PAYLOAD = 6;
    public static int SEI_YY_APP_DATA = 1;
    public int mPayload = 0;
    public byte[] mStrExtraInfo = null;
    public String mUid = "";

    public static native void nativeClassInit();

    public String toString() {
        StringBuilder sb = new StringBuilder("VideoExtraInfo: ");
        sb.append(" mPayload=").append(this.mPayload);
        sb.append(" uid=").append(this.mUid);
        if (this.mStrExtraInfo != null) {
            sb.append(" mStrExtraInfo.size=").append(this.mStrExtraInfo.length);
        }
        return sb.toString();
    }
}
