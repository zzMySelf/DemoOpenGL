package com.baidu.searchbox.ui.bubble;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.webkit.URLUtil;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.menu.BdMenu;
import com.baidu.android.ext.widget.menu.BdMenuItem;
import com.baidu.searchbox.common.res.R;
import com.facebook.drawee.view.SimpleDraweeView;

public class BaseBubbleView extends LinearLayout implements BdMenu.OnMenuSetChangedListener {
    public static final boolean DEBUG = false;
    private static final int DEFAULT_TEXT_COLOR = -16777216;
    private static final int DEFAULT_TEXT_SIZE = 11;
    public static final String TAG = "BaseBubbleView";
    private BubbleFrameLayout mBubbleLayout;
    private TextView mContentView;
    private SimpleDraweeView mImageView;
    private int mTextColor;
    private int mTextSize;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseBubbleView(Context context) {
        this(context, (AttributeSet) null);
        AttributeSet attributeSet = null;
    }

    public BaseBubbleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseBubbleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mTextColor = -16777216;
        this.mTextSize = 11;
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.base_buddle_view, this, true);
        this.mBubbleLayout = (BubbleFrameLayout) findViewById(R.id.share_buddle_layout);
        this.mContentView = (TextView) findViewById(com.baidu.android.common.ui.style.R.id.share_buddle_content);
        this.mImageView = (SimpleDraweeView) findViewById(com.baidu.android.common.ui.style.R.id.share_buddle_bg);
    }

    public void setContent(String content) {
        if (this.mContentView != null && !TextUtils.isEmpty(content)) {
            this.mContentView.setText(content);
        }
    }

    public void setImageView(String url) {
        if (this.mImageView != null && URLUtil.isValidUrl(url)) {
            this.mImageView.setImageURI(Uri.parse(url));
        }
    }

    public void setTextSize(int dpValue) {
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setTextSize((float) dpValue);
        }
    }

    public void setTextColor(int color) {
        TextView textView = this.mContentView;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setBubbleArrowPosition(float positionDp) {
        BubbleFrameLayout bubbleFrameLayout = this.mBubbleLayout;
        if (bubbleFrameLayout != null) {
            bubbleFrameLayout.setArrowPosition(positionDp);
            this.mBubbleLayout.requestLayout();
        }
    }

    public void onMenuSetChanged() {
    }

    public void onMenuItemUpdated(BdMenuItem item) {
    }
}
