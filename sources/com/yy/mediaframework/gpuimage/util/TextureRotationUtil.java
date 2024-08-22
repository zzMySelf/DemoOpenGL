package com.yy.mediaframework.gpuimage.util;

public class TextureRotationUtil {
    public static final float[] CUBE = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] FULL_RECTANGLE_TEX_COORDS = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final float[] RECTANGLE_TEX_COORDS = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] TEXTURE_NO_ROTATION = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public static final float[] TEXTURE_ROTATED_180 = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    public static final float[] TEXTURE_ROTATED_270 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static final float[] TEXTURE_ROTATED_90 = {1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    private TextureRotationUtil() {
    }

    /* renamed from: com.yy.mediaframework.gpuimage.util.TextureRotationUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yy$mediaframework$gpuimage$util$Rotation;

        static {
            int[] iArr = new int[Rotation.values().length];
            $SwitchMap$com$yy$mediaframework$gpuimage$util$Rotation = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$yy$mediaframework$gpuimage$util$Rotation[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$yy$mediaframework$gpuimage$util$Rotation[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$yy$mediaframework$gpuimage$util$Rotation[Rotation.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static float[] getRotation(Rotation rotation, boolean flipHorizontal, boolean flipVertical) {
        float[] rotatedTex;
        switch (AnonymousClass1.$SwitchMap$com$yy$mediaframework$gpuimage$util$Rotation[rotation.ordinal()]) {
            case 1:
                rotatedTex = TEXTURE_ROTATED_90;
                break;
            case 2:
                rotatedTex = TEXTURE_ROTATED_180;
                break;
            case 3:
                rotatedTex = TEXTURE_ROTATED_270;
                break;
            default:
                rotatedTex = TEXTURE_NO_ROTATION;
                break;
        }
        if (flipHorizontal) {
            rotatedTex = new float[]{flip(rotatedTex[0]), rotatedTex[1], flip(rotatedTex[2]), rotatedTex[3], flip(rotatedTex[4]), rotatedTex[5], flip(rotatedTex[6]), rotatedTex[7]};
        }
        if (!flipVertical) {
            return rotatedTex;
        }
        return new float[]{rotatedTex[0], flip(rotatedTex[1]), rotatedTex[2], flip(rotatedTex[3]), rotatedTex[4], flip(rotatedTex[5]), rotatedTex[6], flip(rotatedTex[7])};
    }

    private static float flip(float i2) {
        if (i2 == 0.0f) {
            return 1.0f;
        }
        return 0.0f;
    }
}
