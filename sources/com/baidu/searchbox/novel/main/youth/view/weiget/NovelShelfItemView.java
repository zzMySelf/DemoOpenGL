package com.baidu.searchbox.novel.main.youth.view.weiget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.utils.NovelCommonBitmapUtils;
import com.baidu.searchbox.novel.main.youth.bean.NovelYouthTopPageData;
import com.baidu.searchbox.novel.view.BaseNovelCustomViewNoNight;
import com.baidu.searchbox.novel.view.cardview.RelativeCardView;
import com.baidu.searchbox.noveladapter.fresco.NovelBaseControllerListener;
import com.baidu.searchbox.noveladapter.fresco.NovelBitmapTransBaseControllerListener;
import com.baidu.searchbox.noveladapter.fresco.NovelContainerImageView;
import com.baidu.searchbox.noveladapter.fresco.NovelFrescoImageUtil;
import com.baidu.searchbox.noveladapter.settingcore.NovelFontSizeSettingsWrapper;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;
import com.baidu.searchbox.story.NovelUtility;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.spswitch.utils.UIUtils;

public class NovelShelfItemView extends BaseNovelCustomViewNoNight {
    private NovelContainerImageView mImageView;
    private RelativeCardView mImageViewLayout;
    private NovelContainerImageView mReadProgressBg;
    private RelativeLayout mReadProgressLayout;
    private TextView mReadProgressText;
    private RelativeLayout mRootLayout;
    private ImageView mTag;
    private TextView mTitleView;
    private NovelContainerImageView mTtsIconIv;
    private RelativeLayout mTtsIconLayout;

    public NovelShelfItemView(Context context) {
        super(context);
    }

    public NovelShelfItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NovelShelfItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /* access modifiers changed from: protected */
    public void initAttrs(AttributeSet attrs) {
    }

    /* access modifiers changed from: protected */
    public int loadViewLayout() {
        return R.layout.novel_home_youth_shelf_item_view;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.mRootLayout = (RelativeLayout) findViewById(R.id.root_layout);
        this.mImageViewLayout = (RelativeCardView) findViewById(R.id.novel_youth_shelf_item_img_layout);
        this.mImageView = (NovelContainerImageView) findViewById(R.id.novel_youth_shelf_item_img);
        this.mTag = (ImageView) findViewById(R.id.novel_youth_shelf_item_tag);
        this.mTitleView = (TextView) findViewById(R.id.novel_youth_shelf_item_title);
        this.mReadProgressLayout = (RelativeLayout) findViewById(R.id.novel_youth_shelf_item_read_progress_layout);
        this.mReadProgressBg = (NovelContainerImageView) findViewById(R.id.novel_youth_shelf_item_read_progress);
        this.mReadProgressText = (TextView) findViewById(R.id.novel_youth_shelf_item_read_progress_text);
        this.mTtsIconLayout = (RelativeLayout) findViewById(R.id.novel_youth_shelf_item_tts_icon_layout);
        this.mTtsIconIv = (NovelContainerImageView) findViewById(R.id.novel_youth_shelf_item_tts_icon_iv);
    }

    public void setData(NovelYouthTopPageData.ShelfShowData data) {
        if (data != null) {
            if (this.mImageView != null && !TextUtils.isEmpty(data.getImgUrl())) {
                this.mImageView.setImageURI(data.getImgUrl());
            }
            if (this.mTitleView != null && !TextUtils.isEmpty(data.getTitle())) {
                this.mTitleView.setText(data.getTitle());
            }
            if (this.mTag != null) {
                String tagType = data.getTagType();
                if (TextUtils.isEmpty(tagType)) {
                    this.mTag.setVisibility(8);
                } else if ("1".equals(tagType)) {
                    this.mTag.setVisibility(0);
                    this.mTag.setImageDrawable(NovelNightModeUtils.fitToNightMode(R.drawable.novel_icon_shelf_update_new_youth));
                } else if ("2".equals(tagType)) {
                    this.mTag.setVisibility(0);
                    this.mTag.setImageDrawable(NovelNightModeUtils.fitToNightMode(R.drawable.novel_icon_shelf_web_source_new_youth));
                } else if (UgcConstant.ERROR_CODE_BY_CANCEL.equals(tagType)) {
                    this.mTag.setVisibility(0);
                    this.mTag.setImageDrawable(NovelNightModeUtils.fitToNightMode(R.drawable.novel_icon_shelf_recommend_source_new_youth));
                }
            }
            RelativeLayout relativeLayout = this.mReadProgressLayout;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
                String bookProgress = data.getBookProgress();
                if (!TextUtils.isEmpty(bookProgress)) {
                    float progressFloat = ((float) ((int) (NovelUtility.safeToFloat(bookProgress) * 10000.0f))) / 100.0f;
                    if (progressFloat > 0.0f && progressFloat <= 100.0f) {
                        this.mReadProgressLayout.setVisibility(0);
                        this.mReadProgressText.setText(String.format((data.isListen() ? "已听" : "已读") + " %.2f%%", new Object[]{Float.valueOf(progressFloat)}));
                    }
                }
            }
            RelativeLayout relativeLayout2 = this.mTtsIconLayout;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
                if (data.isListen() && !TextUtils.isEmpty(data.getImgUrl())) {
                    this.mTtsIconLayout.setVisibility(0);
                    if (this.mTtsIconIv != null) {
                        NovelFrescoImageUtil.getInstance().setTTSAndSoundIconControler(this.mTtsIconIv, (NovelBaseControllerListener) null, new NovelBitmapTransBaseControllerListener() {
                            public void onBitmapSetTrans(Bitmap sourceBitmap, Bitmap destBitmap) {
                                NovelCommonBitmapUtils.getCombinBitmap(sourceBitmap, destBitmap);
                            }

                            public int getBlurCircleBitmapSize(Bitmap sourceBitmap) {
                                return UIUtils.dip2px(NovelShelfItemView.this.getContext(), 21.0f);
                            }

                            public void onBlurCircleBitmapTrans(Bitmap sourceBitmap, Bitmap destBitmap) {
                                NovelCommonBitmapUtils.getBlurTTSAndSoundIcon(sourceBitmap, destBitmap);
                            }
                        }, data.getImgUrl());
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
    }

    /* access modifiers changed from: protected */
    public void initListener() {
    }

    public void updateUi() {
        RelativeLayout relativeLayout = this.mRootLayout;
        if (relativeLayout != null) {
            NovelFontSizeSettingsWrapper.setScaledViewWidthRes(relativeLayout, R.dimen.novel_dimens_62dp);
        }
        RelativeCardView relativeCardView = this.mImageViewLayout;
        if (relativeCardView != null) {
            NovelFontSizeSettingsWrapper.setScaledViewSizeRes(relativeCardView, R.dimen.novel_dimens_62dp, R.dimen.novel_dimens_82dp);
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            NovelFontSizeSettingsWrapper.setTextViewScaledSize(textView, 12.0f);
            this.mTitleView.setTextColor(NovelNightModeUtils.getColor(R.color.NC502));
        }
        RelativeLayout relativeLayout2 = this.mReadProgressLayout;
        if (relativeLayout2 != null) {
            NovelFontSizeSettingsWrapper.setScaledViewHeightRes(relativeLayout2, R.dimen.novel_dimens_16dp);
        }
        TextView textView2 = this.mReadProgressText;
        if (textView2 != null) {
            NovelFontSizeSettingsWrapper.setTextViewScaledSize(textView2, 10.0f);
        }
        ImageView imageView = this.mTag;
        if (imageView != null) {
            NovelFontSizeSettingsWrapper.setScaledViewSizeRes(imageView, R.dimen.novel_dimens_30dp, R.dimen.novel_dimens_16dp);
        }
    }
}
