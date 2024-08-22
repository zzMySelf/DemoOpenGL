package com.baidu.wallet.utils.compress;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class c {
    public static final int a = 4;
    public static final int b = 20;
    public static final int c = 0;
    public static final int d = 3;
    public static final float[] e = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final String g = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    public static final String h = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    public FloatBuffer f;

    /* renamed from: i  reason: collision with root package name */
    public float[] f3653i = new float[16];
    public float[] j = new float[16];
    public int k;
    public int l = -1234567;
    public int m;
    public int n;

    /* renamed from: o  reason: collision with root package name */
    public int f3654o;
    public int p;
    public int q = 0;

    public c() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f = asFloatBuffer;
        asFloatBuffer.put(e).position(0);
        Matrix.setIdentityM(this.j, 0);
    }

    public int a() {
        return this.l;
    }

    public void b() {
        int a2 = a(g, h);
        this.k = a2;
        if (a2 != 0) {
            this.f3654o = GLES20.glGetAttribLocation(a2, "aPosition");
            b("glGetAttribLocation aPosition");
            if (this.f3654o != -1) {
                this.p = GLES20.glGetAttribLocation(this.k, "aTextureCoord");
                b("glGetAttribLocation aTextureCoord");
                if (this.p != -1) {
                    this.m = GLES20.glGetUniformLocation(this.k, "uMVPMatrix");
                    b("glGetUniformLocation uMVPMatrix");
                    if (this.m != -1) {
                        this.n = GLES20.glGetUniformLocation(this.k, "uSTMatrix");
                        b("glGetUniformLocation uSTMatrix");
                        if (this.n != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i2 = iArr[0];
                            this.l = i2;
                            GLES20.glBindTexture(36197, i2);
                            b("glBindTexture mTextureID");
                            GLES20.glTexParameterf(36197, 10241, 9728.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            b("glTexParameter");
                            Matrix.setIdentityM(this.f3653i, 0);
                            int i3 = this.q;
                            if (i3 != 0) {
                                Matrix.rotateM(this.f3653i, 0, (float) i3, 0.0f, 0.0f, 1.0f);
                                return;
                            }
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        throw new RuntimeException("failed creating program");
    }

    public void a(SurfaceTexture surfaceTexture) {
        b("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.j);
        GLES20.glUseProgram(this.k);
        b("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.l);
        this.f.position(0);
        GLES20.glVertexAttribPointer(this.f3654o, 3, 5126, false, 20, this.f);
        b("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f3654o);
        b("glEnableVertexAttribArray maPositionHandle");
        this.f.position(3);
        GLES20.glVertexAttribPointer(this.p, 2, 5126, false, 20, this.f);
        b("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.p);
        b("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.n, 1, false, this.j, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.f3653i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        b("glDrawArrays");
        GLES20.glFinish();
    }

    public void a(String str) {
        GLES20.glDeleteProgram(this.k);
        int a2 = a(g, str);
        this.k = a2;
        if (a2 == 0) {
            throw new RuntimeException("failed creating program");
        }
    }

    private int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        b("glCreateShader type=" + i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public void b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    private int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        b("glCreateProgram");
        if (glCreateProgram == 0) {
            return 0;
        }
        GLES20.glAttachShader(glCreateProgram, a3);
        b("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a2);
        b("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }
}
