package com.baidu.searchbox.ad.motion;

interface IMotionDetector {
    public static final String TAG = "MotionDetector";

    void onScrolled(int[] iArr, long j2, long j3, int i2, int i3);

    void onTouchMove(long j2, int i2);

    void onTouchSequence(long j2, long j3, int i2, int[] iArr, int[] iArr2);
}
