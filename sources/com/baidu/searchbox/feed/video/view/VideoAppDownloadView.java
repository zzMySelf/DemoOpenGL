package com.baidu.searchbox.feed.video.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.feed.template.FeedAdProgressButton;
import com.baidu.searchbox.feed.video.IVideoAppDownloadView;

public class VideoAppDownloadView extends FeedAdProgressButton implements IVideoAppDownloadView {
    public static final int DOWNLOAD_DEFAULT_SUCCESS_STATUS = 0;
    public static final int DOWNLOAD_DOWNLOAD_STATUS = 3;
    public static final int DOWNLOAD_DOWNLOAD_SUCCESS_STATUS = 2;
    public static final int DOWNLOAD_INSTALL_SUCCESS_STATUS = 1;
    public int mDownloadStatus = 3;
    private Region mProgressRectCornerRegion;
    private Region mProgressRoundCornerRegion;
    private Path mRoundCornerPath;
    private Rect mTempRectF;

    public VideoAppDownloadView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public VideoAppDownloadView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void updateText(String text) {
        if (!TextUtils.equals(getResources().getString(R.string.feed_ad_button_continue), text)) {
            setProgress(0);
        }
        super.setText(text);
        this.mDownloadStatus = 0;
        if (TextUtils.equals(getResources().getString(R.string.feed_ad_button_open), text)) {
            this.mDownloadStatus = 1;
        } else if (TextUtils.equals(getResources().getString(R.string.feed_ad_button_install), text)) {
            this.mDownloadStatus = 2;
        } else if (TextUtils.equals(getResources().getString(R.string.video_detail_download_banner_btn), text)) {
            this.mDownloadStatus = 3;
        } else if (TextUtils.equals(getResources().getString(R.string.video_detail_download_exact_banner_btn), text)) {
            this.mDownloadStatus = 3;
        }
    }

    /* access modifiers changed from: protected */
    public void drawProgressView(Canvas canvas) {
        if (this.mProgress > 0) {
            if (this.mRoundCornerPath == null) {
                Path path = new Path();
                this.mRoundCornerPath = path;
                path.addRoundRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), (float) this.mRadius, (float) this.mRadius, Path.Direction.CW);
            }
            if (this.mProgressRectCornerRegion == null) {
                this.mProgressRectCornerRegion = new Region();
            }
            this.mProgressRectCornerRegion.set(0, 0, (getWidth() * this.mProgress) / this.mMax, getHeight());
            if (this.mProgressRoundCornerRegion == null) {
                this.mProgressRoundCornerRegion = new Region();
            }
            this.mProgressRoundCornerRegion.setPath(this.mRoundCornerPath, this.mProgressRectCornerRegion);
            if (this.mTempRectF == null) {
                this.mTempRectF = new Rect();
            }
            RegionIterator iterator = new RegionIterator(this.mProgressRoundCornerRegion);
            while (iterator.next(this.mTempRectF)) {
                canvas.drawRect(this.mTempRectF, this.mForegroundPaint);
            }
        }
    }

    public int getDownloadStatus() {
        return this.mDownloadStatus;
    }

    /* access modifiers changed from: protected */
    public void initPaint() {
        super.initPaint();
        this.mForegroundPaint.setColor(this.mForegroundColor);
    }
}
