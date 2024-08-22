package com.baidu.mario.audio;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Build;
import android.util.Log;
import kotlin.UByte;

class AudioHelper {
    public static final int CHECK_VOLUME_FRAME_NUMBER_MAX = 20;
    private static final String TAG = "AudioHelper";

    AudioHelper() {
    }

    public static double calculateVolume(byte[] bArr) {
        double d2 = 0.0d;
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            int i3 = (bArr[i2] & UByte.MAX_VALUE) + ((bArr[i2 + 1] & UByte.MAX_VALUE) << 8);
            if (i3 >= 32768) {
                i3 = 65535 - i3;
            }
            d2 += (double) Math.abs(i3);
        }
        return Math.log10(((d2 / ((double) bArr.length)) / 2.0d) + 1.0d) * 10.0d;
    }

    public static double calculateVolumePercent(byte[] bArr) {
        double d2 = 0.0d;
        for (int i2 = 0; i2 < bArr.length; i2 += 2) {
            int i3 = (bArr[i2] & UByte.MAX_VALUE) + ((bArr[i2 + 1] & UByte.MAX_VALUE) << 8);
            if (i3 >= 32768) {
                i3 = 65535 - i3;
            }
            d2 += (double) (i3 * i3);
        }
        return Math.min(5000.0d, Math.sqrt((d2 / ((double) bArr.length)) / 2.0d)) / 50.0d;
    }

    public static boolean checkAudioRecordPermission(Context context) {
        String packageName = context.getApplicationContext().getPackageName();
        if (Build.VERSION.SDK_INT >= 23) {
            return checkPermissionOverVersionM(context, packageName);
        }
        return checkPermissionUnderVersionM();
    }

    private static boolean checkPermissionOverVersionM(Context context, String str) {
        return context.getPackageManager().checkPermission("android.permission.RECORD_AUDIO", str) == 0;
    }

    private static boolean checkPermissionUnderVersionM() {
        AudioRecord audioRecord = new AudioRecord(1, 16000, 16, 2, 1024);
        try {
            audioRecord.startRecording();
            boolean z = audioRecord.getRecordingState() == 3;
            byte[] bArr = new byte[32768];
            int i2 = 0;
            while (true) {
                if (i2 >= 20) {
                    break;
                }
                audioRecord.read(bArr, 0, 32768);
                double calculateVolume = calculateVolume(bArr);
                Log.i(TAG, "checkPermissionUnderVersionM volume = " + calculateVolume);
                z = calculateVolume != 0.0d;
                if (z) {
                    break;
                }
                i2++;
            }
            audioRecord.stop();
            audioRecord.release();
            return z;
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
