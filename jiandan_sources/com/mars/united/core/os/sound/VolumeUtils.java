package com.mars.united.core.os.sound;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import fe.ggg.ad.qw.ad.qw;

public class VolumeUtils {
    public static final String qw = "VolumeUtils";

    public interface VolumeCallback {
        void qw();
    }

    public static class VolumeReceiver extends BroadcastReceiver {
        public VolumeCallback qw;

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.media.VOLUME_CHANGED_ACTION") && this.qw != null) {
                qw.qw.qw(VolumeUtils.qw, "android.media.VOLUME_CHANGED_ACTION");
                this.qw.qw();
            }
        }
    }
}
