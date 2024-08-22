package com.baidu.mario.gldraw2d.models;

public class Texture implements Cloneable {
    private boolean mCameraFrame = false;
    private boolean mFrontCamera = false;
    private int mHeight;
    private int mId = -1;
    private long mTimestamp = 0;
    private int mType = 3553;
    private int mWidth;

    public int getHeight() {
        return this.mHeight;
    }

    public int getId() {
        return this.mId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getType() {
        return this.mType;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isCameraFrame() {
        return this.mCameraFrame;
    }

    public boolean isEffective() {
        return this.mId != -1;
    }

    public boolean isFrontCamera() {
        return this.mFrontCamera;
    }

    public void setCameraFrame(boolean z) {
        this.mCameraFrame = z;
    }

    public void setFrontCamera(boolean z) {
        this.mFrontCamera = z;
    }

    public void setHeight(int i2) {
        this.mHeight = i2;
    }

    public void setId(int i2) {
        this.mId = i2;
    }

    public void setTimestamp(long j2) {
        this.mTimestamp = j2;
    }

    public void setType(int i2) {
        this.mType = i2;
    }

    public void setWidth(int i2) {
        this.mWidth = i2;
    }

    public String toString() {
        return "type = " + this.mType + " && id = " + this.mId + " && cameraFrame" + this.mCameraFrame + " && frontCamera = " + this.mFrontCamera + " && width * height = " + this.mWidth + " * " + this.mHeight + " && timestamp = " + this.mTimestamp;
    }

    public Texture clone() {
        try {
            return (Texture) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
