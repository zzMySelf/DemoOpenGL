package com.baidu.wallet.base.iddetect;

public class CameraSizeInfo implements Comparable<CameraSizeInfo> {
    public int mHeight;
    public float mHeightRatio;
    public boolean mIsCompareRatio = false;
    public float mRatioDeta;
    public int mWidth;

    public CameraSizeInfo(int i2, int i3) {
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public int compareTo(CameraSizeInfo cameraSizeInfo) {
        if (this.mIsCompareRatio) {
            return this.mRatioDeta < cameraSizeInfo.mRatioDeta ? -1 : 1;
        }
        int i2 = this.mHeight;
        int i3 = cameraSizeInfo.mHeight;
        if (i2 < i3) {
            return -1;
        }
        return (i2 <= i3 && this.mWidth < cameraSizeInfo.mWidth) ? -1 : 1;
    }
}
