package com.baidu.searchbox.kankan.detail.view.video;

import android.graphics.PointF;

public class PosIndicator {
    private static int SCROLL_ORIENTATION_HORIZONTAL = 1;
    private static int SCROLL_ORIENTATION_NONE = -1;
    private static int SCROLL_ORIENTATION_VERTICAL = 0;
    public static final String TAG = "PosIndicator";
    private int mCurrentPos;
    private float mDistanceToDownX;
    private float mDistanceToDownY;
    private PointF mDownPoint = new PointF();
    public int mEndPos = 0;
    private boolean mIsDragging;
    private boolean mIsInitialized = false;
    private boolean mIsUnderTouch;
    private PointF mLastMovePoint = new PointF();
    private int mLastPos;
    private float mOffsetX;
    private float mOffsetY;
    private int mPressedPos;
    private PointF mReleasePoint = new PointF();
    private int mScrollOrientation = SCROLL_ORIENTATION_NONE;
    private int mStartPos = 0;
    private int mTouchAction = -1;
    private int mTouchSlop;

    public void initStartAndEndPos(int startPos, int endPos) {
        this.mStartPos = startPos;
        this.mEndPos = endPos;
        this.mIsInitialized = true;
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public void onDown(float x, float y) {
        this.mIsUnderTouch = true;
        this.mPressedPos = this.mCurrentPos;
        this.mLastMovePoint.set(x, y);
        this.mDownPoint.set(x, y);
        this.mTouchAction = 0;
        this.mScrollOrientation = SCROLL_ORIENTATION_NONE;
    }

    public boolean isScrollVertical() {
        return this.mScrollOrientation == SCROLL_ORIENTATION_VERTICAL;
    }

    public boolean isScrollHorizontal() {
        return this.mScrollOrientation == SCROLL_ORIENTATION_HORIZONTAL;
    }

    public void onMove(float x, float y) {
        float offsetX = x - this.mLastMovePoint.x;
        float offsetY = y - this.mLastMovePoint.y;
        if ((!this.mIsDragging && Math.abs(offsetY) > ((float) this.mTouchSlop)) || (!this.mIsDragging && Math.abs(offsetX) > ((float) this.mTouchSlop))) {
            this.mIsDragging = true;
            float abs = Math.abs(offsetY);
            int i2 = this.mTouchSlop;
            if (abs > ((float) i2)) {
                if (offsetY < 0.0f) {
                    offsetY += (float) i2;
                } else {
                    offsetY -= (float) i2;
                }
                this.mScrollOrientation = SCROLL_ORIENTATION_VERTICAL;
            }
            if (Math.abs(offsetX) > ((float) this.mTouchSlop)) {
                this.mScrollOrientation = SCROLL_ORIENTATION_HORIZONTAL;
            }
        }
        if (this.mIsDragging) {
            this.mTouchAction = 2;
            setOffset(offsetX, offsetY);
            this.mLastMovePoint.set(x, y);
            setDistanceToDown(x, y);
        }
    }

    public boolean isMoveUp() {
        return getOffsetY() < 0.0f;
    }

    public boolean isMoveDown() {
        return getOffsetY() > 0.0f;
    }

    public boolean isDragging() {
        return this.mIsDragging;
    }

    public void onRelease(float x, float y) {
        this.mIsUnderTouch = false;
        this.mIsDragging = false;
        this.mReleasePoint.set(x, y);
        this.mTouchAction = 1;
        this.mScrollOrientation = SCROLL_ORIENTATION_NONE;
    }

    public void onPointerDown(float x, float y) {
        this.mLastMovePoint.set(x, y);
    }

    public void onPointerUp(float x, float y) {
        this.mLastMovePoint.set(x, y);
    }

    public PointF getFingerDownPoint() {
        return this.mDownPoint;
    }

    public PointF getFingerMovePoint() {
        return this.mLastMovePoint;
    }

    public PointF getFingerReleasePoint() {
        return this.mReleasePoint;
    }

    public int getTouchAction() {
        return this.mTouchAction;
    }

    public void setTouchSlop(int touchSlop) {
        this.mTouchSlop = touchSlop;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    private void setDistanceToDown(float x, float y) {
        this.mDistanceToDownX = x - this.mDownPoint.x;
        this.mDistanceToDownY = y - this.mDownPoint.y;
    }

    public boolean isUnderTouch() {
        return this.mIsUnderTouch;
    }

    public boolean hasMovedAfterPressedDown() {
        return this.mCurrentPos != this.mPressedPos;
    }

    private void setOffset(float x, float y) {
        this.mOffsetX = x;
        this.mOffsetY = y;
    }

    public float getOffsetX() {
        return this.mOffsetX;
    }

    public float getOffsetY() {
        return this.mOffsetY;
    }

    public float getDistanceToDownX() {
        return this.mDistanceToDownX;
    }

    public float getDistanceToDownY() {
        return this.mDistanceToDownY;
    }

    public boolean isInStartPos() {
        return this.mCurrentPos == this.mStartPos;
    }

    public boolean isInEndPos() {
        return this.mCurrentPos == this.mEndPos;
    }

    public boolean hasLeftStartPos() {
        return this.mCurrentPos > this.mStartPos;
    }

    public boolean hasJustLeftStartPos() {
        return this.mLastPos == this.mStartPos && hasLeftStartPos();
    }

    public boolean hasJustBackStartPos() {
        return this.mLastPos != this.mStartPos && isInStartPos();
    }

    public boolean hasLeftEndPos() {
        return this.mCurrentPos < this.mEndPos;
    }

    public boolean hasJustLeftEndPos() {
        return this.mLastPos == this.mEndPos && hasLeftEndPos();
    }

    public boolean hasJustBackEndPos() {
        return this.mLastPos != this.mEndPos && isInEndPos();
    }

    public int checkPosBoundary(int to) {
        return Math.min(Math.max(to, this.mStartPos), this.mEndPos);
    }

    public void setCurrentPos(int currentPos) {
        this.mLastPos = this.mCurrentPos;
        this.mCurrentPos = currentPos;
    }

    public int getCurrentPos() {
        return this.mCurrentPos;
    }

    public int getLastPos() {
        return this.mLastPos;
    }

    public boolean willOverStartPos() {
        return ((int) (((float) this.mCurrentPos) - this.mOffsetY)) < this.mStartPos;
    }

    public boolean willOverEndPos() {
        return ((int) (((float) this.mCurrentPos) - this.mOffsetY)) > this.mEndPos;
    }

    public int getStartPos() {
        return this.mStartPos;
    }

    public int getEndPos() {
        return this.mEndPos;
    }

    public int getPosDistanceFromStart() {
        return this.mCurrentPos - this.mStartPos;
    }

    public int getPosOffset() {
        return this.mCurrentPos - this.mLastPos;
    }

    public String toString() {
        return "mCurrentPos: " + this.mCurrentPos + ", mLastPos: " + this.mLastPos + ", mPressedPos: " + this.mPressedPos + ", isInStartPos: " + isInStartPos() + ", isInEndPos: " + isInEndPos();
    }
}
