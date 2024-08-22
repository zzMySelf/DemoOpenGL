package com.yy.videoplayer.view;

import com.baidu.searchbox.fileviewer.activity.FileViewerActivity;

public class YMFVideoPosition {
    public int mHeight = 0;
    public int mIndex = 0;
    public int mWidth = 0;
    public int mX = 0;
    public int mY = 0;

    public String toString() {
        return "" + FileViewerActivity.LEFT_BRACKET + this.mIndex + "," + this.mX + "," + this.mY + "," + this.mWidth + "," + this.mHeight + ")";
    }
}
