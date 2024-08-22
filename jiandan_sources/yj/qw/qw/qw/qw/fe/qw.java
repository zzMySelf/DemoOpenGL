package yj.qw.qw.qw.qw.fe;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.IntBuffer;

public class qw {
    public static int ad(String str, int i2) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader);
        return 0;
    }

    public static int de(Bitmap bitmap, int i2, boolean z) {
        int[] iArr = new int[1];
        if (i2 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i2;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static int fe(IntBuffer intBuffer, int i2, int i3, int i4) {
        int i5 = i4;
        int[] iArr = new int[1];
        if (i5 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, intBuffer);
        } else {
            GLES20.glBindTexture(3553, i5);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, 6408, 5121, intBuffer);
            iArr[0] = i5;
        }
        return iArr[0];
    }

    public static int qw(String str, String str2) {
        int ad2;
        int[] iArr = new int[1];
        int ad3 = ad(str, 35633);
        if (ad3 == 0 || (ad2 = ad(str2, 35632)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, ad3);
        GLES20.glAttachShader(glCreateProgram, ad2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            return 0;
        }
        GLES20.glDeleteShader(ad3);
        GLES20.glDeleteShader(ad2);
        return glCreateProgram;
    }
}
