package com.baidu.speech.easr;

public class VoicePreProcess {
    public static native synchronized int initJni(int i2, int i3, int i4, double d2, double d3);

    public static native synchronized int process(byte[] bArr, byte[] bArr2, short[] sArr);

    public static native synchronized int releaseJni(int i2);

    static {
        try {
            synchronized (VoicePreProcess.class) {
                System.loadLibrary("FPALG");
            }
        } catch (UnsatisfiedLinkError e2) {
        }
    }

    private VoicePreProcess() {
    }
}
