package com.baidu.searchbox.feed.news.diverse.guide;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.news.R;
import org.libpag.PAGView;

public class NewsGuideView extends LinearLayout {
    protected static final int INSET_SHADOW_SIZE = 20;
    private static final String LOTTLE_NEWS_TIPS = "assets://feed_push_float_news_guide_view.pag";
    private static final String TAG = "NewsGuideView";
    protected ObjectAnimator mShowAnim;
    private TextView mTextView;
    protected PAGView mTipsLottie;

    public NewsGuideView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NewsGuideView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NewsGuideView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(0);
        initView();
        setViewPadding();
    }

    /* access modifiers changed from: protected */
    public void initView() {
        LayoutInflater.from(getContext()).inflate(getInflateLayout(), this, true);
        setGravity(17);
        this.mTextView = (TextView) findViewById(R.id.feed_push_tips_tv);
        this.mTipsLottie = (PAGView) findViewById(R.id.feed_push_tips_lv);
        this.mTextView.setTextSize(0, FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_T_X042)));
        this.mTextView.getPaint().setStrokeWidth(0.3f);
        ViewGroup.LayoutParams layoutParams = this.mTipsLottie.getLayoutParams();
        layoutParams.width = (int) FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_18dp));
        layoutParams.height = (int) FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_18dp));
        this.mTipsLottie.setLayoutParams(layoutParams);
        this.mTipsLottie.setPath(LOTTLE_NEWS_TIPS);
        this.mTipsLottie.setRepeatCount(-1);
    }

    /* access modifiers changed from: protected */
    public int getInflateLayout() {
        return R.layout.feed_push_news_guide_view;
    }

    /* access modifiers changed from: protected */
    public void setViewPadding() {
        setPadding(getContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X058), getContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_7dp), getContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_12dp), getContext().getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_7dp) + 20);
    }

    public ObjectAnimator getShowAnimator() {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (this.mShowAnim == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
            this.mShowAnim = ofFloat;
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    if (NewsGuideView.this.mTipsLottie != null && NewsGuideView.this.mTipsLottie.getVisibility() == 0) {
                        NewsGuideView.this.mTipsLottie.play();
                    }
                }
            });
        }
        return this.mShowAnim;
    }

    public void updateText(String string) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void isNeedShowLeftIcon(boolean isNeed) {
        this.mTipsLottie.setVisibility(isNeed ? 0 : 8);
    }

    public void fontSizeChanged() {
        this.mTextView.setTextSize(0, FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.styles.R.dimen.F_T_X042)));
        ViewGroup.LayoutParams layoutParams = this.mTipsLottie.getLayoutParams();
        layoutParams.width = (int) FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_18dp));
        layoutParams.height = (int) FontSizeHelper.getScaledSize(0, (float) getResources().getDimensionPixelSize(com.baidu.searchbox.feed.core.R.dimen.dimens_18dp));
        this.mTipsLottie.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.mShowAnim;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        PAGView pAGView = this.mTipsLottie;
        if (pAGView != null) {
            pAGView.stop();
        }
    }
}
