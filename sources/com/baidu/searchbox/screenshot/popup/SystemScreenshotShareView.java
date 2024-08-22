package com.baidu.searchbox.screenshot.popup;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.searchbox.screenshot.R;
import com.baidu.searchbox.socialshare.update.ShareOperationPreferenceUtils;
import com.baidu.searchbox.ui.view.BadgeView;

public class SystemScreenshotShareView extends RelativeLayout implements View.OnClickListener {
    public static final String COVER_FEEDBACK_TAG = "COVER_FEEDBACK_TAG";
    public static final String COVER_SHARE_TAG = "COVER_SHARE_TAG";
    public static final String ROOT_VIEW_TAG = "ROOT_VIEW_TAG";
    public static final int TEXT_EXTRACTION_BADGE_MAX_TIME = 3;
    private static final int TEXT_EXTRACTION_BADGE_SIZE_DP = 8;
    public static final String TEXT_EXTRACTION_TAG = "TEXT_EXTRACTION_TAG";
    private ImageView mBgImageView;
    private LinearLayout mCoverShare;
    /* access modifiers changed from: private */
    public OnShareClickListener mListener;
    private String mPage;
    private RelativeLayout mRoot;
    private BadgeView mTextExtractionBadge;
    private RelativeLayout mTextExtractionLayout;

    public interface OnShareClickListener {
        void onShareClick(View view2);
    }

    public SystemScreenshotShareView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SystemScreenshotShareView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SystemScreenshotShareView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPage = "other";
        init(context);
    }

    private void init(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.screenshot_layer_layout, this, false);
        this.mRoot = relativeLayout;
        this.mBgImageView = (ImageView) relativeLayout.findViewById(R.id.image_screenshot);
        this.mCoverShare = (LinearLayout) this.mRoot.findViewById(R.id.cover_share);
        initTextExtractionView();
        LinearLayout linearLayout = this.mCoverShare;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        RelativeLayout relativeLayout2 = this.mRoot;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    if (SystemScreenshotShareView.this.mListener != null) {
                        view2.setTag(SystemScreenshotShareView.ROOT_VIEW_TAG);
                        SystemScreenshotShareView.this.mListener.onShareClick(view2);
                    }
                }
            });
        }
        addView(this.mRoot);
    }

    public void setOnShareClickListener(OnShareClickListener listener) {
        this.mListener = listener;
    }

    public void setImageView(Bitmap bitmap) {
        this.mBgImageView.setImageBitmap(bitmap);
    }

    public void onClick(View view2) {
        if (view2.getId() == R.id.cover_share) {
            if (this.mListener != null) {
                view2.setTag(COVER_SHARE_TAG);
                this.mListener.onShareClick(view2);
            }
        } else if (view2.getId() == R.id.text_extraction_layout && this.mListener != null) {
            if (this.mTextExtractionBadge.getVisibility() == 0) {
                ShareOperationPreferenceUtils.setTextExtractionBadgeTimes(4);
                this.mTextExtractionBadge.setVisibility(8);
            }
            view2.setTag(TEXT_EXTRACTION_TAG);
            this.mListener.onShareClick(view2);
        }
    }

    private void initTextExtractionView() {
        RelativeLayout relativeLayout = (RelativeLayout) this.mRoot.findViewById(R.id.text_extraction_layout);
        this.mTextExtractionLayout = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    private void initTextExtractionBadge() {
        BadgeView badgeView = (BadgeView) this.mRoot.findViewById(R.id.text_extraction_badge);
        this.mTextExtractionBadge = badgeView;
        badgeView.setType(BadgeView.Type.SMALL_TEXT);
        this.mTextExtractionBadge.setTextSize(1, 8.0f);
        this.mTextExtractionBadge.setBadgeText(getResources().getString(R.string.socialshare_screenshot_text_extraction_badge));
        if (this.mTextExtractionLayout.getVisibility() != 0 || ShareOperationPreferenceUtils.getTextExtractionBadgeTimes() >= 3) {
            this.mTextExtractionBadge.setVisibility(8);
            return;
        }
        this.mTextExtractionBadge.setVisibility(0);
        ShareOperationPreferenceUtils.setTextExtractionBadgeTimes(ShareOperationPreferenceUtils.getTextExtractionBadgeTimes() + 1);
    }

    public void setPage(String page) {
        this.mPage = page;
    }
}
