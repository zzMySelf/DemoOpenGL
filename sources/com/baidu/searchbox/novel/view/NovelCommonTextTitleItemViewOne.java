package com.baidu.searchbox.novel.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.utils.NovelUIUtil;
import com.baidu.searchbox.noveladapter.fresco.INovelImageLoadListener;
import com.baidu.searchbox.noveladapter.fresco.NovelContainerImageView;
import com.baidu.searchbox.noveladapter.fresco.NovelFrescoImageUtil;
import com.baidu.searchbox.noveladapter.settingcore.NovelFontSizeSettingsWrapper;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;

public class NovelCommonTextTitleItemViewOne extends RelativeLayout implements View.OnClickListener {
    public static final int CLICK_TYPE_MORE_ICON = 2;
    public static final int CLICK_TYPE_MORE_TEXT = 1;
    private static final float MORE_TEXT_SIZE = 12.0f;
    private static final float TITLE_SIZE = 17.0f;
    private OnTitleItemClickListener mClickListener;
    private ImageView mMoreImageView;
    private TextView mMoreTextView;
    /* access modifiers changed from: private */
    public NovelContainerImageView mTitleImageView;
    /* access modifiers changed from: private */
    public TextView mTitleView;
    private boolean useCustomMoreImage = false;

    public NovelCommonTextTitleItemViewOne(Context context) {
        super(context);
        initView(context);
    }

    public NovelCommonTextTitleItemViewOne(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public NovelCommonTextTitleItemViewOne(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public NovelCommonTextTitleItemViewOne(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        TextView textView = new TextView(context);
        this.mTitleView = textView;
        textView.setTextColor(NovelNightModeUtils.getColor(R.color.NC502));
        this.mTitleView.setTextSize(1, 17.0f);
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(-2, -2);
        titleParams.leftMargin = getDimension(R.dimen.novel_dimens_11dp, 33);
        titleParams.topMargin = getDimension(R.dimen.novel_dimens_19dp, 54);
        titleParams.bottomMargin = getDimension(R.dimen.novel_dimens_16dp, 54);
        this.mTitleView.setLayoutParams(titleParams);
        this.mTitleView.setOnClickListener(this);
        this.mTitleView.setIncludeFontPadding(false);
        TextPaint titleViewPaint = this.mTitleView.getPaint();
        if (titleViewPaint != null) {
            titleViewPaint.setFakeBoldText(true);
        }
        addView(this.mTitleView);
        this.mTitleImageView = new NovelContainerImageView(context);
        RelativeLayout.LayoutParams titleImageParams = new RelativeLayout.LayoutParams(NovelUIUtil.getDimension(getContext(), R.dimen.novel_dimens_72dp, 216), NovelUIUtil.getDimension(getContext(), R.dimen.novel_dimens_18dp, 54));
        titleImageParams.leftMargin = getDimension(R.dimen.novel_dimens_11dp, 33);
        titleImageParams.topMargin = getDimension(R.dimen.novel_dimens_18dp, 54);
        titleImageParams.bottomMargin = getDimension(R.dimen.novel_dimens_18dp, 54);
        this.mTitleImageView.setLayoutParams(titleImageParams);
        this.mTitleImageView.setOnClickListener(this);
        addView(this.mTitleImageView);
        this.mTitleImageView.setVisibility(8);
        this.mMoreImageView = new ImageView(context);
        RelativeLayout.LayoutParams moreImageParams = new RelativeLayout.LayoutParams(-2, -2);
        moreImageParams.rightMargin = getDimension(R.dimen.novel_dimens_11dp, 33);
        moreImageParams.addRule(11);
        moreImageParams.addRule(15);
        this.mMoreImageView.setImageDrawable(NovelNightModeUtils.getDrawable(R.drawable.novel_home_page_recommend_item_more_icon));
        this.mMoreImageView.setLayoutParams(moreImageParams);
        this.mMoreImageView.setId(R.id.novel_common_title_item_more_image_view);
        this.mMoreImageView.setOnClickListener(this);
        addView(this.mMoreImageView);
        TextView textView2 = new TextView(context);
        this.mMoreTextView = textView2;
        textView2.setTextColor(NovelNightModeUtils.getColor(R.color.NC504));
        this.mMoreTextView.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams moreTextParams = new RelativeLayout.LayoutParams(-2, -2);
        moreTextParams.rightMargin = getDimension(R.dimen.novel_dimens_3dp, 9);
        moreTextParams.addRule(16, this.mMoreImageView.getId());
        moreTextParams.addRule(15);
        this.mMoreTextView.setLayoutParams(moreTextParams);
        this.mMoreTextView.setOnClickListener(this);
        this.mMoreTextView.setIncludeFontPadding(false);
        fontSizeChanged();
        addView(this.mMoreTextView);
    }

    public void setTitleImageUrl(String urlDay, String urlNight) {
        if (TextUtils.isEmpty(urlDay) || TextUtils.isEmpty(urlNight)) {
            NovelContainerImageView novelContainerImageView = this.mTitleImageView;
            if (novelContainerImageView != null) {
                novelContainerImageView.setVisibility(8);
            }
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setVisibility(0);
                return;
            }
            return;
        }
        NovelFrescoImageUtil.getInstance().loadBitmap(getContext(), NovelNightModeUtils.isNightMode() ? urlNight : urlDay, new INovelImageLoadListener() {
            public void onNewResultImpl(Bitmap bitmap) {
                if (bitmap != null) {
                    BitmapDrawable drawable = new BitmapDrawable(NovelCommonTextTitleItemViewOne.this.getResources(), bitmap);
                    if (NovelCommonTextTitleItemViewOne.this.mTitleImageView != null) {
                        NovelCommonTextTitleItemViewOne.this.mTitleImageView.setVisibility(0);
                        NovelCommonTextTitleItemViewOne.this.mTitleImageView.setImageDrawable(drawable);
                    }
                    if (NovelCommonTextTitleItemViewOne.this.mTitleView != null) {
                        NovelCommonTextTitleItemViewOne.this.mTitleView.setVisibility(8);
                        return;
                    }
                    return;
                }
                if (NovelCommonTextTitleItemViewOne.this.mTitleImageView != null) {
                    NovelCommonTextTitleItemViewOne.this.mTitleImageView.setVisibility(8);
                }
                if (NovelCommonTextTitleItemViewOne.this.mTitleView != null) {
                    NovelCommonTextTitleItemViewOne.this.mTitleView.setVisibility(0);
                }
            }

            public void onFailureImpl() {
                if (NovelCommonTextTitleItemViewOne.this.mTitleImageView != null) {
                    NovelCommonTextTitleItemViewOne.this.mTitleImageView.setVisibility(8);
                }
                if (NovelCommonTextTitleItemViewOne.this.mTitleView != null) {
                    NovelCommonTextTitleItemViewOne.this.mTitleView.setVisibility(0);
                }
            }

            public void onCancellation() {
            }
        });
    }

    public void setTitle(String title) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(title);
        }
    }

    public void setTitleTextColor(int color) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setTitleTextSize(int size) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextSize((float) size);
        }
    }

    public void setTitleTextSize(int unit, int size) {
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextSize(unit, (float) size);
        }
    }

    public void setMoreText(String text) {
        TextView textView = this.mMoreTextView;
        if (textView != null) {
            textView.setText(text);
        }
    }

    public void setMoreTextColor(int color) {
        TextView textView = this.mMoreTextView;
        if (textView != null) {
            textView.setTextColor(color);
        }
    }

    public void setMoreTextSize(int size) {
        TextView textView = this.mMoreTextView;
        if (textView != null) {
            textView.setTextSize((float) size);
        }
    }

    public void setMoreTextSize(int unit, int size) {
        TextView textView = this.mMoreTextView;
        if (textView != null) {
            textView.setTextSize(unit, (float) size);
        }
    }

    public void setMoreImage(int resource) {
        ImageView imageView = this.mMoreImageView;
        if (imageView != null) {
            this.useCustomMoreImage = true;
            imageView.setImageDrawable(NovelNightModeUtils.getDrawable(resource));
        }
    }

    public void setMoreImage(Drawable resource) {
        ImageView imageView = this.mMoreImageView;
        if (imageView != null) {
            this.useCustomMoreImage = true;
            imageView.setImageDrawable(resource);
        }
    }

    public void hideMoreIcon() {
        ImageView imageView = this.mMoreImageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.mMoreTextView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void setOnClickListener(OnTitleItemClickListener listener) {
        this.mClickListener = listener;
    }

    public void onClick(View v) {
        OnTitleItemClickListener onTitleItemClickListener = this.mClickListener;
        if (onTitleItemClickListener == null) {
            return;
        }
        if (v == this.mTitleView) {
            onTitleItemClickListener.onTitleClick();
        } else if (v == this.mMoreTextView) {
            onTitleItemClickListener.onMoreClick(1);
        } else if (v == this.mMoreImageView) {
            onTitleItemClickListener.onMoreClick(2);
        }
    }

    public void onNightModeChanged() {
        ImageView imageView;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(NovelNightModeUtils.getColor(R.color.NC502));
        }
        TextView textView2 = this.mMoreTextView;
        if (textView2 != null && textView2.getVisibility() == 0) {
            this.mMoreTextView.setTextColor(NovelNightModeUtils.getColor(R.color.NC504));
        }
        if (!this.useCustomMoreImage && (imageView = this.mMoreImageView) != null) {
            imageView.setImageDrawable(NovelNightModeUtils.getDrawable(R.drawable.novel_home_page_recommend_item_more_icon));
        }
    }

    public void fontSizeChanged() {
        TextView textView = this.mTitleView;
        if (textView != null) {
            NovelFontSizeSettingsWrapper.setTextViewScaledSize(textView, 17.0f);
        }
        NovelContainerImageView novelContainerImageView = this.mTitleImageView;
        if (novelContainerImageView != null) {
            NovelFontSizeSettingsWrapper.setScaledViewSizeRes(novelContainerImageView, R.dimen.novel_dimens_72dp, R.dimen.novel_dimens_18dp);
        }
        TextView textView2 = this.mMoreTextView;
        if (textView2 != null) {
            NovelFontSizeSettingsWrapper.setTextViewScaledSize(textView2, 12.0f);
        }
        ImageView imageView = this.mMoreImageView;
        if (imageView != null) {
            NovelFontSizeSettingsWrapper.setScaledViewSizeRes(imageView, R.dimen.novel_dimens_10dp, R.dimen.novel_dimens_10dp);
        }
    }

    private int getDimension(int res, int defaultValue) {
        try {
            return (int) getResources().getDimension(res);
        } catch (Exception e2) {
            e2.printStackTrace();
            return defaultValue;
        }
    }

    public static class OnTitleItemClickListener {
        public void onTitleClick() {
        }

        public void onMoreClick(int type) {
        }
    }
}
