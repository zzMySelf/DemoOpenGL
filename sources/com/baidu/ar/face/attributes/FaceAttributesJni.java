package com.baidu.ar.face.attributes;

import android.content.res.AssetManager;
import com.baidu.ar.libloader.a;
import java.nio.ByteBuffer;

public class FaceAttributesJni {

    /* renamed from: a  reason: collision with root package name */
    protected static boolean f9399a = false;

    static {
        try {
            a.a("FaceAttributes");
            f9399a = true;
        } catch (Throwable th2) {
            f9399a = false;
            th2.printStackTrace();
        }
    }

    public static native int getVersion();

    public static native synchronized int initGenderDetect(String str);

    public static native synchronized int initGenderDetectFromAssets(String str);

    public static native synchronized int predictGenderDetect(ByteBuffer byteBuffer, int i2, int i3, float[] fArr, float[] fArr2);

    public static native synchronized int releaseGenderDetect();

    public static native int setAssetManager(AssetManager assetManager);
}
