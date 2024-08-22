package com.yy.videoplayer.decoder.glesunder43;

import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import java.nio.FloatBuffer;

public class Drawable2d {
    private static final FloatBuffer FULL_RECTANGLE_BUF;
    private static final float[] FULL_RECTANGLE_COORDS;
    private static final FloatBuffer FULL_RECTANGLE_TEX_BUF;
    private static final float[] FULL_RECTANGLE_TEX_COORDS;
    private static final FloatBuffer RECTANGLE_BUF;
    private static final float[] RECTANGLE_COORDS;
    private static final FloatBuffer RECTANGLE_TEX_BUF;
    private static final float[] RECTANGLE_TEX_COORDS;
    private static final int SIZEOF_FLOAT = 4;
    private static final FloatBuffer TRIANGLE_BUF;
    private static final float[] TRIANGLE_COORDS;
    private static final FloatBuffer TRIANGLE_TEX_BUF;
    private static final float[] TRIANGLE_TEX_COORDS;
    private int mCoordsPerVertex;
    private Prefab mPrefab;
    private FloatBuffer mTexCoordArray;
    private int mTexCoordStride;
    private FloatBuffer mVertexArray;
    private int mVertexCount;
    private int mVertexStride;

    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        TRIANGLE_COORDS = fArr;
        float[] fArr2 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TRIANGLE_TEX_COORDS = fArr2;
        TRIANGLE_BUF = GlUtil.createFloatBuffer(fArr);
        TRIANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr2);
        float[] fArr3 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        RECTANGLE_COORDS = fArr3;
        float[] fArr4 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        RECTANGLE_TEX_COORDS = fArr4;
        RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr3);
        RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr4);
        float[] fArr5 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_COORDS = fArr5;
        float[] fArr6 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        FULL_RECTANGLE_TEX_COORDS = fArr6;
        FULL_RECTANGLE_BUF = GlUtil.createFloatBuffer(fArr5);
        FULL_RECTANGLE_TEX_BUF = GlUtil.createFloatBuffer(fArr6);
    }

    /* renamed from: com.yy.videoplayer.decoder.glesunder43.Drawable2d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$yy$videoplayer$decoder$glesunder43$Drawable2d$Prefab;

        static {
            int[] iArr = new int[Prefab.values().length];
            $SwitchMap$com$yy$videoplayer$decoder$glesunder43$Drawable2d$Prefab = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$yy$videoplayer$decoder$glesunder43$Drawable2d$Prefab[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$yy$videoplayer$decoder$glesunder43$Drawable2d$Prefab[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public Drawable2d(Prefab shape) {
        switch (AnonymousClass1.$SwitchMap$com$yy$videoplayer$decoder$glesunder43$Drawable2d$Prefab[shape.ordinal()]) {
            case 1:
                this.mVertexArray = TRIANGLE_BUF;
                this.mTexCoordArray = TRIANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = 2 * 4;
                this.mVertexCount = TRIANGLE_COORDS.length / 2;
                break;
            case 2:
                this.mVertexArray = RECTANGLE_BUF;
                this.mTexCoordArray = RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = 2 * 4;
                this.mVertexCount = RECTANGLE_COORDS.length / 2;
                break;
            case 3:
                this.mVertexArray = FULL_RECTANGLE_BUF;
                this.mTexCoordArray = FULL_RECTANGLE_TEX_BUF;
                this.mCoordsPerVertex = 2;
                this.mVertexStride = 2 * 4;
                this.mVertexCount = FULL_RECTANGLE_COORDS.length / 2;
                break;
            default:
                throw new RuntimeException("Unknown shape " + shape);
        }
        this.mTexCoordStride = 8;
        this.mPrefab = shape;
    }

    public FloatBuffer getVertexArray() {
        return this.mVertexArray;
    }

    public FloatBuffer getTexCoordArray() {
        return this.mTexCoordArray;
    }

    public int getVertexCount() {
        return this.mVertexCount;
    }

    public int getVertexStride() {
        return this.mVertexStride;
    }

    public int getTexCoordStride() {
        return this.mTexCoordStride;
    }

    public int getCoordsPerVertex() {
        return this.mCoordsPerVertex;
    }

    public String toString() {
        if (this.mPrefab != null) {
            return "[Drawable2d: " + this.mPrefab + RhetoricalTagUtilKt.TAG_END_SYMBOL;
        }
        return "[Drawable2d: ...]";
    }
}
