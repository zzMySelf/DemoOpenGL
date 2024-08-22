package com.baidu.searchbox.video.videoplayer.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.video.videoplayer.invoker.InvokerUtils;

public class ImageTextView extends LinearLayout {
    private static final int TITLE_TOP_MARGIN = InvokerUtils.di2pi(4.0f);
    private int mDrawableId;
    private ImageView mIcon;
    private TextView mTitle;

    public ImageTextView(Context context) {
        super(context);
        init();
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ImageTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setOrientation(1);
        setGravity(17);
        ImageView imageView = new ImageView(getContext());
        this.mIcon = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.mIcon, new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(getContext());
        this.mTitle = textView;
        textView.setTextColor(-1);
        this.mTitle.setTextSize(12.0f);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(-2, -2);
        titleParams.setMargins(0, TITLE_TOP_MARGIN, 0, 0);
        addView(this.mTitle, titleParams);
    }

    public void setIconAndTitle(int drawableId, int titleId) {
        if (drawableId == 0) {
            this.mIcon.setImageDrawable((Drawable) null);
            this.mIcon.setVisibility(8);
        } else if (this.mDrawableId != drawableId) {
            this.mIcon.setImageResource(drawableId);
            this.mIcon.setVisibility(0);
            this.mDrawableId = drawableId;
        }
        if (titleId != 0) {
            this.mTitle.setText(titleId);
            this.mTitle.setVisibility(0);
            return;
        }
        this.mTitle.setText((CharSequence) null);
        this.mTitle.setVisibility(8);
    }

    public ImageTextView setIcon(Drawable drawable) {
        this.mIcon.setImageDrawable(drawable);
        this.mIcon.setVisibility(0);
        return this;
    }

    public ImageTextView setIcon(int res) {
        this.mIcon.setImageResource(res);
        this.mIcon.setVisibility(0);
        return this;
    }

    public ImageTextView setIconBackground(int res) {
        this.mIcon.setBackgroundResource(res);
        this.mIcon.setVisibility(0);
        return this;
    }

    public ImageTextView setTitle(int titleId) {
        return setTitle(getContext().getString(titleId));
    }

    public ImageTextView setTitle(String title) {
        if (title != null) {
            this.mTitle.setText(title);
            this.mTitle.setVisibility(0);
        } else {
            this.mTitle.setText((CharSequence) null);
            this.mTitle.setVisibility(8);
        }
        return this;
    }

    public void clearTitle() {
        this.mTitle.setText((CharSequence) null);
    }

    public ImageTextView setTextColor(int textColor) {
        this.mTitle.setTextColor(ResourcesCompat.getColorStateList(getResources(), textColor, (Resources.Theme) null));
        return this;
    }

    public ImageTextView setIconSize(int width, int height) {
        this.mIcon.setLayoutParams(new LinearLayout.LayoutParams(width, height));
        return this;
    }
}
