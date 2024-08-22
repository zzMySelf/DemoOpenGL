package com.baidu.searchbox.feed.ad.tail;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.feed.model.AdTailFrameData;
import com.baidu.searchbox.feed.styles.R;

public class AdEmbeddedTailFrameView extends AdBaseTailFrameView {
    public AdEmbeddedTailFrameView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AdEmbeddedTailFrameView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AdEmbeddedTailFrameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onNightModeChanged() {
        super.onNightModeChanged();
        this.mNameView.setTextColor(getResources().getColor(R.color.FC6));
        this.mCheckBtn.setTextColor(getResources().getColor(R.color.FC38));
        this.mDownloadBtn.setTextColor(getResources().getColor(R.color.FC38));
        this.mCheckBtn.setBackgroundDrawable(getResources().getDrawable(com.baidu.searchbox.feed.core.R.drawable.video_ad_tail_btn_selector));
        this.mDownloadBtn.setBackgroundDrawable(getResources().getDrawable(com.baidu.searchbox.feed.core.R.drawable.video_ad_tail_btn_selector));
        setBtnRadius(this.mOperateRootView, getResources().getDimension(R.dimen.F_J_X06));
        this.mTimerCloseTxt.setTextColor(getResources().getColor(com.baidu.searchbox.feed.core.R.color.feed_ad_suffix_time_close));
    }

    public boolean showTailFrame(AdTailFrameData data) {
        applyFontSize();
        return super.showTailFrame(data);
    }

    public void applyFontSize() {
        if (this.mAvatarView != null) {
            FontSizeViewExtKt.setScaledSizeRes(this.mAvatarView, 0, com.baidu.searchbox.feed.core.R.dimen.dimens_42dp, com.baidu.searchbox.feed.core.R.dimen.dimens_42dp);
        }
        if (this.mOperateRootView != null) {
            FontSizeViewExtKt.setScaledSizeRes(this.mOperateRootView, 0, com.baidu.searchbox.feed.core.R.dimen.dimens_66dp, R.dimen.F_H_X07);
        }
        if (this.mNameView != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(this.mNameView, 0, R.dimen.F_T_X054);
        }
        if (this.mCheckBtn != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(this.mCheckBtn, 0, R.dimen.F_T_X041);
        }
        if (this.mDownloadBtn != null) {
            FontSizeTextViewExtKt.setScaledSizeRes(this.mDownloadBtn, 0, R.dimen.F_T_X041);
        }
        setBtnRadius(this.mOperateRootView, FontSizeHelper.getScaledSizeRes(0, R.dimen.F_J_X06));
    }

    public int layoutId() {
        return com.baidu.searchbox.feed.template.R.layout.video_ad_tail_frame;
    }
}
