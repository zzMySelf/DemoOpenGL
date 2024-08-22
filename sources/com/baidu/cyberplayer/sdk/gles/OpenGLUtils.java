package com.baidu.cyberplayer.sdk.gles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.CyberLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class OpenGLUtils {
    public static final int NOT_INIT = -1;
    public static final int NO_TEXTURE = -1;
    public static final int ON_DRAWN = 1;
    private static final String TAG = "OpenGLUtils";

    public static int loadTexture(Bitmap img, int usedTexId) {
        return loadTexture(img, usedTexId, true);
    }

    public static int loadTexture(Bitmap img, int usedTexId, boolean recycle) {
        int[] textures = new int[1];
        if (usedTexId == -1) {
            GLES20.glGenTextures(1, textures, 0);
            GLES20.glBindTexture(3553, textures[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, img, 0);
        } else {
            GLES20.glBindTexture(3553, usedTexId);
            GLUtils.texSubImage2D(3553, 0, 0, 0, img);
            textures[0] = usedTexId;
        }
        if (recycle) {
            img.recycle();
        }
        return textures[0];
    }

    public static int loadTexture(IntBuffer data, int width, int height, int usedTexId) {
        int i2 = usedTexId;
        int[] textures = new int[1];
        if (i2 == -1) {
            GLES20.glGenTextures(1, textures, 0);
            GLES20.glBindTexture(3553, textures[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, width, height, 0, 6408, 5121, data);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, width, height, 6408, 5121, data);
            textures[0] = i2;
        }
        return textures[0];
    }

    public static int loadTexture(ByteBuffer data, int width, int height, int usedTexId, int type) {
        int i2 = usedTexId;
        int[] textures = new int[1];
        if (i2 == -1) {
            GLES20.glGenTextures(1, textures, 0);
            GLES20.glBindTexture(3553, textures[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, type, width, height, 0, type, 5121, data);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, width, height, type, 5121, data);
            textures[0] = i2;
        }
        return textures[0];
    }

    public static int loadTextureAsBitmap(IntBuffer data, Camera.Size size, int usedTexId) {
        return loadTexture(Bitmap.createBitmap(data.array(), size.width, size.height, Bitmap.Config.ARGB_8888), usedTexId);
    }

    public static int loadShader(String strSource, int iType) {
        int[] compiled = new int[1];
        int iShader = GLES20.glCreateShader(iType);
        GLES20.glShaderSource(iShader, strSource);
        GLES20.glCompileShader(iShader);
        GLES20.glGetShaderiv(iShader, 35713, compiled, 0);
        if (compiled[0] != 0) {
            return iShader;
        }
        Log.d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(iShader));
        return 0;
    }

    public static int loadProgram(String strVSource, String strFSource) {
        int[] link = new int[1];
        int iVShader = loadShader(strVSource, 35633);
        if (iVShader == 0) {
            Log.d("Load Program", "Vertex Shader Failed");
            return 0;
        }
        int iFShader = loadShader(strFSource, 35632);
        if (iFShader == 0) {
            Log.d("Load Program", "Fragment Shader Failed");
            return 0;
        }
        int iProgId = GLES20.glCreateProgram();
        GLES20.glAttachShader(iProgId, iVShader);
        GLES20.glAttachShader(iProgId, iFShader);
        GLES20.glLinkProgram(iProgId);
        GLES20.glGetProgramiv(iProgId, 35714, link, 0);
        if (link[0] <= 0) {
            Log.d("Load Program", "Linking Failed");
            return 0;
        }
        GLES20.glDeleteShader(iVShader);
        GLES20.glDeleteShader(iFShader);
        return iProgId;
    }

    public static float rnd(float min, float max) {
        return ((max - min) * ((float) Math.random())) + min;
    }

    public static void createFrameBuffer(int[] frameBuffer, int[] frameBufferTexture, int width, int height) {
        int[] iArr = frameBuffer;
        int[] iArr2 = frameBufferTexture;
        GLES20.glGenFramebuffers(iArr.length, frameBuffer, 0);
        GLES20.glGenTextures(iArr2.length, iArr2, 0);
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            GLES20.glBindTexture(3553, iArr2[i2]);
            GLES20.glTexImage2D(3553, 0, 6408, width, height, 0, 6408, 5121, (Buffer) null);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, iArr[i2]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[i2], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public static void createFrameBuffer(int[] frameBuffer) {
        GLES20.glGenFramebuffers(frameBuffer.length, frameBuffer, 0);
    }

    public static void bindTextureToFBO(int[] frameBuffer, int[] frameBufferTexture, int width, int height) {
        for (int i2 = 0; i2 < frameBufferTexture.length; i2++) {
            GLES20.glBindTexture(3553, frameBufferTexture[i2]);
            GLES20.glBindFramebuffer(36160, frameBuffer[i2]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, frameBufferTexture[i2], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    public static void createEmptyTexture(int[] textures, int width, int height) {
        GLES20.glGenTextures(textures.length, textures, 0);
        for (int glBindTexture : textures) {
            GLES20.glBindTexture(3553, glBindTexture);
            GLES20.glTexImage2D(3553, 0, 6408, width, height, 0, 6408, 5121, (Buffer) null);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindTexture(3553, 0);
        }
    }

    public static String readShaderFromRawResource(Context context, int resourceId) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(resourceId)));
        StringBuilder body = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                String nextLine = readLine;
                if (readLine == null) {
                    return body.toString();
                }
                body.append(nextLine);
                body.append(10);
            } catch (IOException e2) {
                return null;
            }
        }
    }

    public static void deleteTexture(int texture) {
        GLES30.glDeleteTextures(1, new int[]{texture}, 0);
    }

    public static Bitmap createTextBitmap(String text, int width, int height, String color) {
        String str = text;
        int w = width * 2;
        int h2 = height * 2;
        Bitmap bitmap = Bitmap.createBitmap(w, h2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Rect rect = new Rect(0, 0, w, h2);
        Rect bounds = new Rect();
        float sizeR = 0.9f;
        Paint paint = new Paint(1);
        paint.setTextSize(((float) h2) * 0.9f);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        if (!TextUtils.isEmpty(color)) {
            paint.setColor(Color.parseColor("#" + color));
        } else {
            String str2 = color;
        }
        while (sizeR > 0.1f) {
            paint.getTextBounds(str, 0, text.length(), bounds);
            if (bounds.width() <= rect.width()) {
                break;
            }
            sizeR -= 0.1f;
            paint.setTextSize(((float) h2) * sizeR);
        }
        Paint.FontMetricsInt fontMetrics = paint.getFontMetricsInt();
        canvas.drawText(str, (float) rect.centerX(), (float) ((rect.centerY() - (fontMetrics.top / 2)) - (fontMetrics.bottom / 2)), paint);
        bitmap.setHasAlpha(true);
        return bitmap;
    }

    public static Bitmap createCircleBitmap(Bitmap source) {
        Bitmap output = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle((float) (source.getWidth() / 2), (float) (source.getWidth() / 2), (float) (source.getWidth() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0.0f, 0.0f, paint);
        return output;
    }

    public static int createSurfaceTextureId() {
        int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);
        checkGlError("glGenTextures");
        int texId = textures[0];
        GLES20.glBindTexture(36197, texId);
        checkGlError("glBindTexture " + texId);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlError("glTexParameter");
        return texId;
    }

    public static boolean checkGlError(String op) {
        int glGetError = GLES20.glGetError();
        int error = glGetError;
        if (glGetError == 0) {
            return false;
        }
        CyberLog.e(TAG, op + ": glError " + error);
        return true;
    }

    public static boolean checkGlError(String TAG2, String op) {
        int glGetError = GLES20.glGetError();
        int error = glGetError;
        if (glGetError == 0) {
            return false;
        }
        CyberLog.e(TAG2, op + ": glError " + error);
        return true;
    }
}
