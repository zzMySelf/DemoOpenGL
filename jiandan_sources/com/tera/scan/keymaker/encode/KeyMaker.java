package com.tera.scan.keymaker.encode;

import com.getkeepsafe.relinker.ReLinker;
import fe.mmm.qw.ppp.qw;

public class KeyMaker {
    static {
        try {
            ReLinker.qw(qw.qw.qw(), "BDPrecreate_V1_1");
        } catch (Throwable th2) {
            fe.mmm.qw.i.qw.rg("KeyMaker", "ReLinker throw " + th2.getMessage());
        }
    }

    public static native String converToSha1Key(long j, int i2, String str, String str2);

    public static native String convertToBTKey(long j, int i2, String str, String str2);

    public static native String convertToRC4Key(long j, int i2, String str, String str2);
}
