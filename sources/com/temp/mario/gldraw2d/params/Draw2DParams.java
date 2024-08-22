package com.temp.mario.gldraw2d.params;

public class Draw2DParams implements Cloneable {
    private int mDrawDegree = 0;
    private float mEqualScale = 1.0f;
    private MirrorType mMirrorType = MirrorType.NO_MIRROR;
    private ScaleType mScaleType = ScaleType.FIT_XY;
    private int mShowDegree = -90;
    private float mTranslateX = 0.0f;
    private float mTranslateY = 0.0f;

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public void setTranslateX(float translateX) {
        this.mTranslateX = translateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public void setTranslateY(float translateY) {
        this.mTranslateY = translateY;
    }

    public MirrorType getMirrorType() {
        return this.mMirrorType;
    }

    public void setMirrorType(MirrorType mirrorType) {
        this.mMirrorType = mirrorType;
    }

    public ScaleType getScaleType() {
        return this.mScaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        this.mScaleType = scaleType;
    }

    public float getEqualScale() {
        return this.mEqualScale;
    }

    public void setEqualScale(float equalScale) {
        this.mEqualScale = equalScale;
    }

    public int getDrawDegree() {
        return this.mDrawDegree;
    }

    public void setDrawDegree(int drawDegree) {
        this.mDrawDegree = drawDegree;
    }

    public int getShowDegree() {
        return this.mShowDegree;
    }

    public void setShowDegree(int showDegree) {
        this.mShowDegree = showDegree;
    }

    public Draw2DParams clone() {
        try {
            return (Draw2DParams) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
